package com.eve.examplemod.common.machine.multiblock.part;

import com.eve.examplemod.api.capability.IFuelCell;
import com.eve.examplemod.common.machine.logic.ActiveCoolerLogic;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.WorkableTieredMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ActiveCooler extends WorkableTieredMachine {
    public List<IFuelCell> fuelCellList;
    private TickableSubscription serverTickEvent;

    //TODO remove energy container bc its ugly

    //TODO make cooler check for fuel cells only on placement and when block is updated maybe

    public ActiveCooler(IMachineBlockEntity holder, int tier, Int2IntFunction tankScalingFunction, Object... args) {
        super(holder, tier, tankScalingFunction, args);
    }


    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            updateServerTickSubscription();
        }
    }

    private void updateServerTickSubscription() {
        serverTickEvent = this.subscribeServerTick(serverTickEvent, this::serverTickEvent);
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new ActiveCoolerLogic(this);
    }

    @NotNull
    @Override
    public ActiveCoolerLogic getRecipeLogic() {
        return (ActiveCoolerLogic) super.getRecipeLogic();
    }


    private void serverTickEvent() {

    }

    public boolean fuelCellsEmpty(){
        fuelCellList = new ArrayList<>();
        if (getLevel() != null) {
        for (var direction : Direction.values()) {
            if (MetaMachine.getMachine(getLevel(), getPos().relative(direction)) instanceof IFuelCell rizz) {
                fuelCellList.add(rizz);
            }
        }
        return fuelCellList.isEmpty();
        }
        return true;
    }

    public int cooling(){
        if (recipeLogic.getLastRecipe() != null){
            return recipeLogic.getLastRecipe().data.getInt("cooling");
        }
        return 0;
    }

    @Override
    public boolean onWorking() {
        fuelCellList = new ArrayList<>();
        if (getLevel() != null) {
            if (recipeLogic.getLastRecipe() != null) {
                int cooling = recipeLogic.getLastRecipe().data.getInt("cooling");

                for (var direction : Direction.values()) {
                    if (MetaMachine.getMachine(getLevel(), getPos().relative(direction)) instanceof IFuelCell rizz) {
                        fuelCellList.add(rizz);
                    }
                    if (!fuelCellList.isEmpty()) {
                        for (IFuelCell cell : fuelCellList) {
                            if (cell.getHeat() > cooling/fuelCellList.size()) {
                                // remove getoffsettimer if it doesnt work
                                if (getOffsetTimer() % 20 == 0) {
                                    cell.subtractHeat(cooling / fuelCellList.size());
                                }
                            }
                        }
                    }
                }
            }
        }
        return super.onWorking();
    }
}

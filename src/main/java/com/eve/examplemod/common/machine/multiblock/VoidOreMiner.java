package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.data.EVMaterials;
import com.eve.examplemod.common.machine.trait.VOMLogic;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@SuppressWarnings({"SpellCheckingInspection"})
public class VoidOreMiner extends WorkableElectricMultiblockMachine
        implements IFancyUIMachine, IDisplayUIMachine {



    private final int maxTemperature;
    public final int tier;
    private TickableSubscription serverTickEvent;
    public int temperature = 0;
    public boolean cryotheum = false;
    public boolean overheat = false;
    public FluidStack CRYOTHEUM_STACK = EVMaterials.Cryotheum.getFluid(1);
    public FluidStack PYROTHEUM_STACK = EVMaterials.Pyrotheum.getFluid(1);
    public FluidStack DRILLING_MUD_STACK = EVMaterials.DrillingMud.getFluid(1);
    public FluidStack USED_DRILLING_MUD_STACK = EVMaterials.UsedDrillingMud.getFluid(1);
    private static final int CONSUME_START = 100;
    private double currentDrillingFluid = CONSUME_START;


    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("working: " + onWorking()));
        textList.add(Component.translatable("Temperaure: " + temperature));
        textList.add(Component.translatable("cryotheum: " + cryotheum));
    }

    public VoidOreMiner(IMachineBlockEntity holder, int tier, int temp) {
        super(holder);
        this.tier=tier;
        this.maxTemperature=temp;
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new VOMLogic(this);
    }

    @NotNull
    @Override
    public VOMLogic getRecipeLogic() {
        return (VOMLogic) super.getRecipeLogic();
    }





    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        updateServerTickSubscription();
    }

    @Override
    public void onStructureInvalid() {
        this.unsubscribe(serverTickEvent);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if(!isRemote() && isFormed()) {
            updateServerTickSubscription();
        }
    }

    private void updateServerTickSubscription() {
        serverTickEvent = this.subscribeServerTick(serverTickEvent, this::serverTickEvent);
    }




    private void serverTickEvent() {
        if (temperature < 0){
            temperature = 0;
        }
        if (overheat) {
            if (temperature > 0) {
                temperature -= 10;
            }
            if (temperature == 0) {
                overheat = false;
            }
            if (currentDrillingFluid > CONSUME_START) {
                currentDrillingFluid--;
            }
            if (currentDrillingFluid < CONSUME_START) {
                currentDrillingFluid = CONSUME_START;
            }
        }
        if (getOffsetTimer() % 20 == 0) {
            PYROTHEUM_STACK = EVMaterials.Pyrotheum.getFluid((int) currentDrillingFluid);
            CRYOTHEUM_STACK = EVMaterials.Cryotheum.getFluid((int) currentDrillingFluid);
            DRILLING_MUD_STACK = EVMaterials.DrillingMud.getFluid((int) currentDrillingFluid);
            USED_DRILLING_MUD_STACK = EVMaterials.UsedDrillingMud.getFluid((int) currentDrillingFluid);

            if (getRecipeLogic().isWorking() && !overheat && !cryotheum) {
                temperature += (int)(currentDrillingFluid / 100.0);
                currentDrillingFluid = currentDrillingFluid * 1.02;
            }

            if (temperature > maxTemperature) {
                overheat = true;
                currentDrillingFluid = CONSUME_START;
            }
        }

    }

    }
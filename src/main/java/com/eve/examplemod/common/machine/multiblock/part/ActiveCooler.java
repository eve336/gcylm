package com.eve.examplemod.common.machine.multiblock.part;

import com.eve.examplemod.api.capability.IFuelCell;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.WorkableTieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import it.unimi.dsi.fastutil.ints.Int2LongFunction;
import net.minecraft.core.Direction;

public class ActiveCooler extends WorkableTieredMachine {
    private TickableSubscription serverTickEvent;

    public ActiveCooler(IMachineBlockEntity holder, int tier, Int2LongFunction tankScalingFunction, Object... args) {
        super(holder, tier, tankScalingFunction, args);
    }


    @Override
    public void onLoad(){
        super.onLoad();
        if(!isRemote()) {
            updateServerTickSubscription();
        }




    }

    private void updateServerTickSubscription() {
        serverTickEvent = this.subscribeServerTick(serverTickEvent, this::serverTickEvent);
    }
    private void serverTickEvent() {
        if(recipeLogic.isWorking()){
            if (getLevel().getBlockEntity(getPos().relative(Direction.DOWN, 1)) instanceof MetaMachineBlockEntity blockentity){
                if (blockentity.getMetaMachine() instanceof IFuelCell fuel){
                    fuel.subtractHeat(200);
                }
            }
            if (getLevel().getBlockEntity(getPos().relative(Direction.NORTH, 1)) instanceof MetaMachineBlockEntity blockentity){
                if (blockentity.getMetaMachine() instanceof IFuelCell fuel){
                    fuel.subtractHeat(200);
                }
            }
            if (getLevel().getBlockEntity(getPos().relative(Direction.SOUTH, 1)) instanceof MetaMachineBlockEntity blockentity){
                if (blockentity.getMetaMachine() instanceof IFuelCell fuel){
                    fuel.subtractHeat(200);
                }
            }
            if (getLevel().getBlockEntity(getPos().relative(Direction.EAST, 1)) instanceof MetaMachineBlockEntity blockentity){
                if (blockentity.getMetaMachine() instanceof IFuelCell fuel){
                    fuel.subtractHeat(200);
                }
            }
            if (getLevel().getBlockEntity(getPos().relative(Direction.WEST, 1)) instanceof MetaMachineBlockEntity blockentity){
                if (blockentity.getMetaMachine() instanceof IFuelCell fuel){
                    fuel.subtractHeat(200);
                }
            }
            if (getLevel().getBlockEntity(getPos().relative(Direction.UP, 1)) instanceof MetaMachineBlockEntity blockentity){
                if (blockentity.getMetaMachine() instanceof IFuelCell fuel){
                    fuel.subtractHeat(200);
                }
            }
        }
    }
}

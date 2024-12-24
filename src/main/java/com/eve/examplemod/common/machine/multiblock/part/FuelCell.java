package com.eve.examplemod.common.machine.multiblock.part;

import com.eve.examplemod.api.capability.IFuelCell;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import lombok.Getter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Interface;

public class FuelCell extends MultiblockPartMachine implements IFuelCell {


    // TODO add explosion

    //  (mnost playerrs just turn off explosions anyways)

    // TODO make it so it doesnt just change to the textures of the rhuhe j the uhhhh you know the nuclear reacotr overlay thing where it changes the hull mayybe yuse overlay texture but that might make it so the uh it has pixels on top so its actually slightly bigger than a full  cube so the edges are see through


    @Getter
    public int heat = 0;

    public FuelCell(IMachineBlockEntity holder){
        super(holder);
    }

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        return false;
    }

    public void changeHeat(int a){
        heat = heat + a;
    }
    public void subtractHeat(int b){
        heat = heat - b;
    }



}
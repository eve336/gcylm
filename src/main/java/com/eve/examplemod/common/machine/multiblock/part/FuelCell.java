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


    @Override
    public boolean replacePartModelWhenFormed() {
        return false;
    }
}
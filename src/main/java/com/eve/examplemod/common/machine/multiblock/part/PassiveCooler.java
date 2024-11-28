package com.eve.examplemod.common.machine.multiblock.part;

import com.eve.examplemod.api.capability.IFuelCell;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Objects;

public class PassiveCooler extends MultiblockPartMachine {
    private TickableSubscription serverTickEvent;
    private int cooling;

    public PassiveCooler(IMachineBlockEntity holder, int cooling) {
        super(holder);
        this.cooling = cooling;
    }


    private void updateServerTickSubscription() {
        serverTickEvent = this.subscribeServerTick(serverTickEvent, this::serverTickEvent);
    }

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        return false;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        if(!isRemote()) {
            updateServerTickSubscription();
        }

    }

    private void serverTickEvent() {
        for (var direction : Direction.values()) {
            if (MetaMachine.getMachine(getLevel(), getPos().relative(direction)) instanceof IFuelCell rizz) {
                rizz.subtractHeat(200);
            }
        }
    }


    @Override
    public void notifyBlockUpdate() {
        super.notifyBlockUpdate();
    }
}

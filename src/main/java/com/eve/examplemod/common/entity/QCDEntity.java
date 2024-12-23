package com.eve.examplemod.common.entity;

import com.eve.examplemod.common.data.EVBlocks;
import com.gregtechceu.gtceu.common.entity.IndustrialTNTEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class QCDEntity extends IndustrialTNTEntity {
    public QCDEntity(Level world, double x, double y, double z, @Nullable LivingEntity owner) {
        super(world, x, y, z, owner);
    }
    @SuppressWarnings("unused")
    public QCDEntity(EntityType<? extends QCDEntity> type, Level world) {
        super(type, world);
    }

    @Override
    protected float getStrength() {
        return 13.0F;
    }

    @Override
    public boolean dropsAllBlocks() {
        return true;
    }

    @Override
    protected int getRange() {
        return 9;
    }

    @Override
    public @NotNull BlockState getExplosiveState() {
        return EVBlocks.QCD_CHARGE.getDefaultState();
    }
}

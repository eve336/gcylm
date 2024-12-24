package com.eve.examplemod.common.entity;

import com.eve.examplemod.common.block.explosive.LeptonicBlock;
import com.eve.examplemod.common.data.EVBlocks;
import com.eve.examplemod.common.data.EVEntityTypes;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTEntityTypes;
import com.gregtechceu.gtceu.common.entity.GTExplosiveEntity;
import com.gregtechceu.gtceu.common.entity.IndustrialTNTEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LeptonicEntity extends GTExplosiveEntity {
    public LeptonicEntity(Level world, double x, double y, double z, @Nullable LivingEntity owner) {
        super(EVEntityTypes.LEPTONIC_CHARGE.get(), world, x, y, z, owner);
    }

    @SuppressWarnings("unused")
    public LeptonicEntity(EntityType<? extends LeptonicEntity> type, Level world) {
        super(type, world);
    }

    @Override
    protected float getStrength() {
        return 10.0F;
    }

    @Override
    public boolean dropsAllBlocks() {
        return true;
    }

    @Override
    protected int getRange() {
        return 7;
    }

    @Override
    public @NotNull BlockState getExplosiveState() {
        return EVBlocks.LEPTONIC_CHARGE.getDefaultState();
    }
}

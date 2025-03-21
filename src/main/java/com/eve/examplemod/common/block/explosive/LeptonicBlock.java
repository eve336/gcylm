package com.eve.examplemod.common.block.explosive;

import com.eve.examplemod.common.entity.LeptonicEntity;
import com.gregtechceu.gtceu.common.block.explosive.IndustrialTNTBlock;
import com.gregtechceu.gtceu.common.entity.GTExplosiveEntity;
import com.gregtechceu.gtceu.common.entity.IndustrialTNTEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class LeptonicBlock extends IndustrialTNTBlock {
    public LeptonicBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected GTExplosiveEntity createEntity(@NotNull Level world, @NotNull BlockPos pos,
                                             @NotNull LivingEntity exploder) {
        float x = pos.getX() + 0.5F, y = pos.getY(), z = pos.getZ() + 0.5F;
        return new LeptonicEntity(world, x, y, z, exploder);
    }
}

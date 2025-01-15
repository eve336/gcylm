package com.eve.examplemod.common.data;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.antlr.runtime.tree.Tree;

public class StraightRubberTreeGrower extends AbstractTreeGrower {
    public StraightRubberTreeGrower(){

    }

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
            return EVConfiguredFeatures.STRAIGHT_RUBBER;
    }
}

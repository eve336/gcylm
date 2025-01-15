package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class EVConfiguredFeatures {

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leavesBlock, int baseHeight, int heightRandA, int heightRandB, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock), new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB), BlockStateProvider.simple(leavesBlock), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightRubber() {
        return createStraightBlobTree(GTBlocks.RUBBER_LOG.get(), GTBlocks.RUBBER_LEAVES.get(), 5, 2, 0, 2).ignoreVines();
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAIGHT_RUBBER = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            EVMain.id("straight_rubber_tree"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, STRAIGHT_RUBBER, Feature.TREE, createStraightRubber().build());
    }
}

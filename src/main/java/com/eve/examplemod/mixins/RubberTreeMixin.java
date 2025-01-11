package com.eve.examplemod.mixins;

import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTConfiguredFeatures;
import com.gregtechceu.gtceu.common.data.GTFeatures;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.worldgen.feature.configurations.FluidSproutConfiguration;
import com.gregtechceu.gtceu.common.worldgen.feature.configurations.StoneBlobConfiguration;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static com.gregtechceu.gtceu.common.data.GTConfiguredFeatures.*;

// wrong mixin this is world gen?
@Mixin(GTConfiguredFeatures.class)
public class RubberTreeMixin {
    /**
     * @author eve336
     * @reason i wanted to
     */
    @Overwrite(remap = false)
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> ctx) {
        FeatureUtils.register(ctx, RUBBER, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider
                        .simple(GTBlocks.RUBBER_LOG.get().changeNatural(GTBlocks.RUBBER_LOG.getDefaultState(), true)),
                new StraightTrunkPlacer(100, 100, 10000),
                BlockStateProvider.simple(GTBlocks.RUBBER_LEAVES.get()),
                new MegaJungleFoliagePlacer(ConstantInt.of(1), UniformInt.of(0, 1), 1),
                new TwoLayersFeatureSize(122332, 132323, 10000)).ignoreVines().build());

        FeatureUtils.register(ctx, RED_GRANITE_BLOB, GTFeatures.STONE_BLOB.get(),
                new StoneBlobConfiguration(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                        GTBlocks.RED_GRANITE.getDefaultState()), UniformInt.of(20, 30)));
        FeatureUtils.register(ctx, MARBLE_BLOB, GTFeatures.STONE_BLOB.get(),
                new StoneBlobConfiguration(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                        GTBlocks.MARBLE.getDefaultState()), UniformInt.of(20, 30)));

        FeatureUtils.register(ctx, RAW_OIL_SPROUT, GTFeatures.FLUID_SPROUT.get(),
                new FluidSproutConfiguration(GTMaterials.RawOil.getFluid(), UniformInt.of(9, 13), UniformInt.of(6, 9),
                        0.4f));
    }
}

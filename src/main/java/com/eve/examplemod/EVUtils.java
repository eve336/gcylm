package com.eve.examplemod;

import com.gregtechceu.gtceu.GTCEu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

public class EVUtils {
    public static boolean canSeeSunClearly(Level world, BlockPos blockPos) {
        // little sneaky trick bc world.canSeeSky doesnt actually check if the blocks above are empty
        if (world.getBiome(blockPos.above()).is(BiomeTags.IS_NETHER) || world.getBiome(blockPos.above()).is(BiomeTags.IS_END)) {
            BlockPos blockPos1 = blockPos.above();
            for (int i = blockPos.above().getY(); i < world.getMaxBuildHeight(); i++) {
//                if (world.getBlockState(blockPos1).isSolidRender(world, blockPos1)) {
                if (!world.getBlockState(blockPos1).propagatesSkylightDown(world, blockPos1) && !world.getBlockState(blockPos1).isAir()) {
                    return false;
                }
                blockPos1 = blockPos1.offset(0, 1, 0);

            }
            return true;
        }


        if (!world.canSeeSky(blockPos.above())) {
            return false;
        }

        Biome biome = world.getBiome(blockPos.above()).value();
        if (world.isRaining()) {
            if (biome.warmEnoughToRain(blockPos.above()) || biome.coldEnoughToSnow(blockPos.above())) {
                return false;
            }
        }


        ResourceLocation javdVoidBiome = new ResourceLocation("javd", "void");
        if (GTCEu.Mods.isJAVDLoaded() &&
                world.registryAccess().registryOrThrow(Registries.BIOME).getKey(biome).equals(javdVoidBiome)) {
            return !world.isDay();
        } else return world.isDay();
    }
}

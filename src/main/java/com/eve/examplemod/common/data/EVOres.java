package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.data.worldgen.GTLayerPattern;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.WorldGenLayers;
import com.gregtechceu.gtceu.api.data.worldgen.generator.indicators.SurfaceIndicatorGenerator;
import com.gregtechceu.gtceu.common.data.GTOres;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.valueproviders.UniformInt;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Quartzite;


import com.gregtechceu.gtceu.api.data.worldgen.GTLayerPattern;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.generator.indicators.SurfaceIndicatorGenerator;
import com.gregtechceu.gtceu.api.data.worldgen.generator.veins.DikeVeinGenerator;
import com.gregtechceu.gtceu.api.data.worldgen.generator.veins.VeinedVeinGenerator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTOres.*;

public class EVOres {

    public static final GTOreDefinition NETHER_PRECIOUS_METAL = create(EVMain.id("nether_gold_vein"), vein -> vein
            .clusterSize(UniformInt.of(25, 29))
            .density(0.2F).weight(160)
            .layer(WorldGenLayers.NETHERRACK)
            .heightRangeUniform(10, 120)
            .biomes(BiomeTags.IS_NETHER)
            .layeredVeinGenerator(generator -> generator.withLayerPattern(() -> GTLayerPattern.builder(NETHER_RULES)
                    .layer(l -> l.weight(15).mat(PreciousMetal).size(1, 4))
                    .layer(l -> l.weight(15).mat(Iron).size(1, 4))
                    .layer(l -> l.weight(1).mat(Gold).size(1, 1))
                    .build()))
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(PreciousMetal)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)));

    public static final GTOreDefinition NETHER_SULFUR = create(EVMain.id("nether_sulfur"), vein -> vein
            .clusterSize(UniformInt.of(25, 35))
            .density(0.4F).weight(160)
            .layer(WorldGenLayers.NETHERRACK)
            .heightRangeUniform(40, 120)
            .biomes(BiomeTags.IS_NETHER)
            .layeredVeinGenerator(generator -> generator.withLayerPattern(() -> GTLayerPattern.builder(NETHER_RULES)
                    .layer(l -> l.weight(5).mat(Sulfur).size(1, 4))
                    .layer(l -> l.weight(3).mat(Iron).size(1, 4))
                    .build()))
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(PreciousMetal)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)));

    // find out a way to kill ore veins from gt...,,,, you should mixin and kill all of them hehehehehhehe
    // kubejs works fine but pack creators need to do that manually :sob:
    public static final GTOreDefinition TUNGSTATE_VEIN_MARS = create(EVMain.id("tungstate_vein_mars"), vein -> vein
            .clusterSize(UniformInt.of(30, 35)).density(0.4f).weight(200)
            .layer(WorldGenLayers.STONE)
            .heightRangeUniform(10, 80)
            .biomes(BiomeTags.IS_OVERWORLD)
            .layeredVeinGenerator(generator -> generator
                    .withLayerPattern(() -> GTLayerPattern.builder(OVERWORLD_RULES)
                            .layer(l -> l.weight(3).mat(PreciousMetal).size(1, 2))
                            .layer(l -> l.weight(6).mat(Magnetite).size(1, 1))
                            .layer(l -> l.weight(6).mat(Iron).size(1, 1))
                            .build())
            )
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(Tungstate)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)
            ));

    // the most used material in all of gt is just insanely hard to find??? buff copper vein
    public static final GTOreDefinition COPPER_VEIN = create(EVMain.id("copper_vein"), vein -> vein
            .clusterSize(UniformInt.of(30, 45)).density(0.5f).weight(140)
            .layer(WorldGenLayers.STONE)
            .heightRangeUniform(55, 75)
            .biomes(BiomeTags.IS_OVERWORLD)
            .layeredVeinGenerator(generator -> generator
                    .withLayerPattern(() -> GTLayerPattern.builder(OVERWORLD_RULES)
                            .layer(l -> l.weight(4).mat(Copper).size(1, 3))
                            .layer(l -> l.weight(4).mat(Tetrahedrite).size(1, 2))
                            .build())
            )
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(Copper)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)
            ));

    public static final GTOreDefinition CHALCOCITE_VEIN = create(EVMain.id("chalcocite_vein"), vein -> vein
            .clusterSize(UniformInt.of(32, 45)).density(0.53f).weight(120)
            .layer(WorldGenLayers.STONE)
            .heightRangeUniform(45, 80)
            .biomes(BiomeTags.IS_OVERWORLD)
            .layeredVeinGenerator(generator -> generator
                    .withLayerPattern(() -> GTLayerPattern.builder(OVERWORLD_RULES)
                            .layer(l -> l.weight(6).mat(Copper).size(1, 3))
                            .layer(l -> l.weight(6).mat(Chalcocite).size(1, 3))
                            .layer(l -> l.weight(4).mat(Iron).size(1, 3))
                            .build())
            )
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(Copper)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)
            ));

    public static final GTOreDefinition IRON_VEIN = create(EVMain.id("iron_vein"), vein -> vein
            .clusterSize(UniformInt.of(32, 47)).density(0.53f).weight(120)
            .layer(WorldGenLayers.STONE)
            .heightRangeUniform(60, 80)
            .biomes(BiomeTags.IS_OVERWORLD)
            .layeredVeinGenerator(generator -> generator
                    .withLayerPattern(() -> GTLayerPattern.builder(OVERWORLD_RULES)
                            .layer(l -> l.weight(6).mat(Iron).size(1, 3))
                            .layer(l -> l.weight(4).mat(Tin).size(1, 3))
                            .build())
            )
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(Copper)
                    .placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)
            ));

    public static void init(){

    }


}

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
            .clusterSize(UniformInt.of(32, 40))
            .density(0.2F).weight(80)
            .layer(WorldGenLayers.NETHERRACK)
            .heightRangeUniform(40, 80)
            .biomes(BiomeTags.IS_NETHER)
            .layeredVeinGenerator(generator -> generator.withLayerPattern(() -> GTLayerPattern.builder(NETHER_RULES)
                    .layer(l -> l.weight(15).mat(PreciousMetal).size(2, 4))
                    .layer(l -> l.weight(1).mat(Gold).size(1, 1))
                    .build()))
            .surfaceIndicatorGenerator(indicator -> indicator.surfaceRock(PreciousMetal).placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)));

    public static final GTOreDefinition PRECIOUS_METAL = create(EVMain.id("nether_gold_vein"), vein -> vein
            .clusterSize(UniformInt.of(32, 40))
            .density(0.2F).weight(80)
            .layer(WorldGenLayers.NETHERRACK)
            .heightRangeUniform(40, 80)
            .biomes(BiomeTags.IS_OVERWORLD)
            .layeredVeinGenerator(generator -> generator.withLayerPattern(() -> GTLayerPattern.builder(OVERWORLD_RULES)
                    .layer(l -> l.weight(10).mat(PreciousMetal).size(2, 4))
                    .build()))
            .surfaceIndicatorGenerator(indicator -> indicator.surfaceRock(PreciousMetal).placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE)));

    public static void init(){

    }


}

package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVBlocks.LEPTONIC_CHARGE;
import static com.eve.examplemod.common.data.EVBlocks.TARANIUM_CHARGE;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class WormholeGeneratorChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;
        PLASMA_CONDENSER_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(500).EUt(400000)
                .inputItems(NEUTRON_PLASMA_CONTAINMENT_CELL)
                .notConsumable(SPHERE_FIELD_SHAPE)
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,32000))
                .outputItems(NEUTRONIUM_SPHERE,4)
                .outputItems(PLASMA_CONTAINMENT_CELL)
                .outputFluids(Helium.getFluid(32000))
                .save(provider);

        POLARIZER_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(200).EUt(500000)
                .inputItems(NEUTRONIUM_SPHERE)
                .outputItems(TRIPLET_NEUTRONIUM_SPHERE)
                .save(provider);

        LARGE_CENTRIFUGE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(40).EUt(100000)
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .inputFluids(Helium.getFluid(FluidStorageKeys.PLASMA,1000))
                .outputFluids(FreeAlphaGas.getFluid(1000))
                .outputFluids(FreeElectronGas.getFluid(1000))
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(200).EUt(50000)
                .inputItems(TRIPLET_NEUTRONIUM_SPHERE)
                .inputFluids(FreeAlphaGas.getFluid(1000))
                .outputItems(CHARGED_TRIPLET_NEUTRONIUM_SPHERE)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(100).EUt(100000)
                .inputFluids(Tritanium.getFluid(144))
                .inputItems(rod, NaquadahAlloy, 4)
                .inputItems(wireGtSingle, UVSuperconductor, 2)
                .inputItems(DEGENERATE_RHENIUM_PLATE,4)
                .inputItems(EMITTER_UV,2)
                .outputItems(TIME_DILATION_CONTAINMENT_UNIT)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(100).EUt(800000)
                .inputFluids(Tritanium.getFluid(144))
                .inputItems(rod, NaquadahAlloy, 4)
                .inputItems(wireGtSingle, UHVSuperconductor, 2)
                .inputItems(DEGENERATE_RHENIUM_PLATE,4)
                .inputItems(EMITTER_UHV,2)
                .outputItems(TIME_DILATION_CONTAINMENT_UNIT,4)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(100).EUt(12800000)
                .inputFluids(Tritanium.getFluid(144))
                .inputItems(rod, NaquadahAlloy, 4)
                .inputItems(wireGtSingle, UEVSuperconductor, 2)
                .inputItems(QCD_PROTECTIVE_PLATING)
                .inputItems(FIELD_GENERATOR_UHV,2)
                .inputItems(CHARGED_LEPTON_TRAP_CRYSTAL,2)
                .outputItems(TIME_DILATION_CONTAINMENT_UNIT,16)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(200).EUt(288566)
                .inputItems(TARANIUM_CHARGE.asItem())
                .inputItems(TIME_DILATION_CONTAINMENT_UNIT,64)
                .inputItems(CHARGED_TRIPLET_NEUTRONIUM_SPHERE,64)
                .outputItems(CONTAINED_REISSNER_NORDSTROM_SINGULARITY,64)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(600).EUt(6000000)
                .inputItems(CONTAINED_REISSNER_NORDSTROM_SINGULARITY,64)
                .outputItems(CONTAINED_KERR_NEWMANN_SINGULARITY)
                .outputItems(TIME_DILATION_CONTAINMENT_UNIT,63)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(40).EUt(100000)
                .inputFluids(FreeElectronGas.getFluid(1000))
                .inputItems(CONTAINED_KERR_NEWMANN_SINGULARITY)
                .outputItems(CONTAINED_KERR_SINGULARITY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(200).EUt(100000)
                .inputFluids(FreeElectronGas.getFluid(1000))
                .inputItems(plate, MetastableOganesson, 1)
                .inputItems(plate, Vibranium, 1)
                .inputItems(plate, Trinium)
                .inputItems(dustSmall, Mendelevium, 1)
                .inputItems(TARANIUM_CHARGE.asItem())
                .outputItems(LEPTONIC_CHARGE.asItem())
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(100).EUt(100000)
                .inputFluids(Tritanium.getFluid(576))
                .inputItems(EMITTER_ZPM,2)
                .inputItems(FIELD_GENERATOR_ZPM)
                .inputItems(CONTAINED_KERR_SINGULARITY)
                .inputItems(wireGtSingle, UVSuperconductor, 2)
                .inputItems(plate, Neutronium, 2)
                .outputItems(MICROWORMHOLE_GENERATOR)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(400).EUt(1000000)
                .inputItems(NEUTRONIUM_SPHERE)
                .inputItems(TIME_DILATION_CONTAINMENT_UNIT)
                .outputItems(CONTAINED_HIGH_DENSITY_PROTONIC_MATTER)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(200).EUt(1000000)
                .inputFluids(NaquadahAlloy.getFluid(576))
                .inputItems(CONTAINED_HIGH_DENSITY_PROTONIC_MATTER)
                .inputItems(MICROWORMHOLE_GENERATOR)
                .inputItems(CONTAINED_KERR_SINGULARITY)
                .inputItems(EMITTER_UV,4)
                .inputItems(FIELD_GENERATOR_UV,2)
                .inputItems(SENSOR_UV,4)
                .inputItems(BATTERY_SMALL_LIS)
                .outputItems(MACROWORMHOLE_GENERATOR)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(600).EUt(5000000)
                .inputItems(DEGENERATE_RHENIUM_DUST)
                .inputItems(LEPTONIC_CHARGE.asItem())
                .inputItems(CONTAINED_HIGH_DENSITY_PROTONIC_MATTER)
                .outputItems(CONTAINED_EXOTIC_MATTER)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("wormhole_generator_chain_" + chainNumber++).duration(400).EUt(6000000)
                .inputFluids(Naquadria.getFluid(288))
                .inputFluids(EnrichedNaquadahAlloy.getFluid(144))
                .inputFluids(Neutronium.getFluid(144))
                .inputFluids(Taranium.getFluid(72))
                .inputItems(EMITTER_UHV,2)
                .inputItems(FIELD_GENERATOR_UHV,2)
                .inputItems(SENSOR_UHV,2)
                .inputItems(BATTERY_SMALL_FLUORIDE)
                .inputItems(CONTAINED_EXOTIC_MATTER)
                .inputItems(MACROWORMHOLE_GENERATOR)
                .outputItems(STABILIZED_WORMHOLE_GENERATOR)
                .save(provider);
    }

}

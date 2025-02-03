package com.eve.examplemod.data.recipe.chain;

import com.eve.examplemod.common.data.EVMaterials;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVBlocks.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.PLASMA_CONDENSER_RECIPES;
import static com.eve.examplemod.common.data.EVRecipeTypes.STELLAR_FORGE_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GCYMRecipeTypes.ALLOY_BLAST_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTItems.GELLED_TOLUENE;
import static com.gregtechceu.gtceu.common.data.GTItems.SHAPE_MOLD_BLOCK;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class UHVMaterials {
    static int chainNumber = 1;
    public static void init(Consumer<FinishedRecipe> provider) {
        ASSEMBLER_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(dust, Naquadria)
                .inputItems(GELLED_TOLUENE,2)
                .inputItems(plate, EVMaterials.Uranium238, 1)
                .inputItems(bolt, Osmium, 1)
                .inputItems(bolt, Titanium, 4)
                .inputItems(HexanitroHexaazaisowurtzitane)
                .inputFluids(GlycerylTrinitrate.getFluid(1000))
                .inputItems(NAQUADRIA_CHARGE.asItem())
                .EUt(1966080)
                .duration(100)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(ingot, Rhenium)
                .inputItems(NAQUADRIA_CHARGE.asItem())
                .outputFluids(ElectronDegenerateRheniumPlasma.getFluid(1000))
                .EUt(1966080)
                .duration(20)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(plateDense, Rhenium)
                .inputItems(NAQUADRIA_CHARGE.asItem())
                .outputFluids(ElectronDegenerateRheniumPlasma.getFluid(10000))
                .EUt(1966080 * 4)
                .duration(100)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(PLASMA_CONTAINMENT_CELL)
                .inputFluids(ElectronDegenerateRheniumPlasma.getFluid(1000))
                .outputItems(RHENIUM_PLASMA_CONTAINMENT_CELL)
                .EUt(30720)
                .duration(20)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(RHENIUM_PLASMA_CONTAINMENT_CELL)
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,16000))
                .outputFluids(Helium.getFluid(16000))
                .notConsumable(PLATE_FIELD_SHAPE)
                .outputItems(DEGENERATE_RHENIUM_PLATE)
                .outputItems(PLASMA_CONTAINMENT_CELL)
                .EUt(122880)
                .duration(250)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputFluids(Helium.getFluid(5000))
                .outputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,5000))
                .EUt(7680)
                .duration(20)
                .save(provider);


        ASSEMBLY_LINE_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(rodLong, NeodymiumMagnetic, 2)
                .inputItems(wireGtSingle, UVSuperconductor, 16)
                .inputItems(pipeLargeItem, Ultimet, 4)
                .inputItems(plate, NaquadahAlloy, 8)
                .inputFluids(Titanium.getFluid(2592))
                .inputFluids(NaquadahEnriched.getFluid(1584))
                .outputItems(PLASMA_CONTAINMENT_CELL)
                .EUt(983040)
                .duration(50)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(DEGENERATE_RHENIUM_PLATE)
                .outputItems(DEGENERATE_RHENIUM_DUST,4)
                .duration(100)
                .EUt(62_914_560)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(plate, Mendelevium)
                .inputItems(GELLED_TOLUENE,4)
                .inputItems(rodLong, NaquadriaticTaranium)
                .inputItems(dust, Taranium)
                .inputItems(plate, Tritanium)
                .inputItems(DEGENERATE_RHENIUM_DUST)
                .inputFluids(GlycerylTrinitrate.getFluid(2500))
                .outputItems(TARANIUM_CHARGE.asItem())
                .EUt(7_864_320)
                .duration(20)
                .save(provider);

        ALLOY_BLAST_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(dust, Seaborgium)
                .inputItems(dust, Bohrium)
                .inputItems(dust, Rutherfordium)
                .inputItems(dust, Dubnium)
                .circuitMeta(1)
                .outputFluids(SuperheavyMix.getFluid(4000))
                .EUt(25_000_000)
                .duration(40)
                .blastFurnaceTemp(11000)
                .save(provider);

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .notConsumable(SHAPE_MOLD_BLOCK)
                .inputFluids(SuperheavyMix.getFluid(1000))
                .outputItems(SUPERHEAVY_BLOCK.asItem())
                .EUt(100000000)
                .duration(40)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(SUPERHEAVY_BLOCK.asItem())
                .inputItems(TARANIUM_CHARGE.asItem())
                .outputFluids(NeutronPlasma.getFluid(1000))
                .EUt(100000000)
                .duration(10)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(PLASMA_CONTAINMENT_CELL)
                .inputFluids(NeutronPlasma.getFluid(1000))
                .outputItems(NEUTRON_PLASMA_CONTAINMENT_CELL)
                .EUt(25000000)
                .duration(80)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("uhv_materials_" + chainNumber++)
                .inputItems(NEUTRON_PLASMA_CONTAINMENT_CELL)
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,32000))
                .outputFluids(Helium.getFluid(32000))
                .notConsumable(INGOT_FIELD_SHAPE)
                .outputItems(ingot, Neutronium)
                .outputItems(PLASMA_CONTAINMENT_CELL)
                .EUt(10000000)
                .duration(500)
                .save(provider);

    }
}

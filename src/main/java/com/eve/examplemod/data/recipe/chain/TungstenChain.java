package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class TungstenChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        // scheelite_and_sodium_hydroxide_to_calcium_hydroxide_001
        MIXER_RECIPES.recipeBuilder("scheelite_and_sodium_hydroxide_to_calcium_hydroxide_001")
                .inputItems(dust, Scheelite, 7)
                .inputItems(dust, SodiumHydroxide, 6)
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputItems(dust, CalciumHydroxide, 10)
                .outputFluids(SodiumTungstate.getFluid(1000))
                .EUt(480)
                .duration(110)
                .save(provider);

// tungstate_and_sodium_hydroxide_to_lithium_hydroxide_002
        MIXER_RECIPES.recipeBuilder("tungstate_and_sodium_hydroxide_to_lithium_hydroxide_002")
                .inputItems(dust, Tungstate, 7)
                .inputItems(dust, SodiumHydroxide, 6)
                .outputItems(dust, LithiumHydroxide, 6)
                .outputFluids(SodiumTungstate.getFluid(1000))
                .EUt(480)
                .duration(160)
                .save(provider);

// lithium_hydroxide_and_water_to_lithium_hydroxide_solution_003
        MIXER_RECIPES.recipeBuilder("lithium_hydroxide_and_water_to_lithium_hydroxide_solution_003")
                .inputFluids(Water.getFluid(1000))
                .inputItems(dust, LithiumHydroxide, 3)
                .outputFluids(LithiumHydroxideSolution.getFluid(1000))
                .EUt(30)
                .duration(60)
                .save(provider);

// calcium_chloride_and_sodium_tungstate_to_calcium_tungstate_004
        CHEMICAL_RECIPES.recipeBuilder("calcium_chloride_and_sodium_tungstate_to_calcium_tungstate_004")
                .inputItems(dust, CalciumChloride, 3)
                .inputFluids(SodiumTungstate.getFluid(1000))
                .inputFluids(Water.getFluid(2000))
                .outputItems(dust, CalciumTungstate, 6)
                .outputFluids(SaltWater.getFluid(2000))
                .EUt(480)
                .duration(60)
                .save(provider);


// calcium_tungstate_and_water_to_tungstic_acid_006
        LARGE_CHEMICAL_RECIPES.recipeBuilder("calcium_tungstate_and_water_to_tungstic_acid_006")
                .inputItems(dust, CalciumTungstate, 6)
                .inputFluids(Water.getFluid(2000))
                .outputItems(dust, TungsticAcid, 7)
                .outputItems(dust, CalciumHydroxide, 5)
                .EUt(480)
                .duration(150)
                .save(provider);

// tungstic_acid_to_tungsten_trioxide_007
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("tungstic_acid_to_tungsten_trioxide_007")
                .inputItems(dust, TungsticAcid, 7)
                .outputItems(dust, TungstenTrioxide, 4)
                .EUt(120)
                .duration(150)
                .save(provider);

// tungsten_trioxide_and_hydrogen_to_tungsten_008
        CHEMICAL_RECIPES.recipeBuilder("tungsten_trioxide_and_hydrogen_to_tungsten_008")
                .inputItems(dust, TungstenTrioxide, 4)
                .inputFluids(Hydrogen.getFluid(6000))
                .outputItems(dust, Tungsten)
                .outputFluids(Water.getFluid(3000))
                .EUt(1920)
                .duration(65)
                .save(provider);

// tungsten_and_chlorine_to_tungsten_hexachloride_009
        CHEMICAL_RECIPES.recipeBuilder("tungsten_and_chlorine_to_tungsten_hexachloride_009")
                .inputItems(dust, Tungsten)
                .inputFluids(Chlorine.getFluid(6000))
                .outputItems(dust, TungstenHexachloride, 7)
                .duration(120)
                .EUt(120)
                .save(provider);

// tungsten_hexachloride_and_methane_and_hydrogen_to_tungsten_carbide_010
        CHEMICAL_RECIPES.recipeBuilder("tungsten_hexachloride_and_methane_and_hydrogen_to_tungsten_carbide_010")
                .inputItems(dust, TungstenHexachloride, 7)
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputItems(dust, TungstenCarbide, 2)
                .outputFluids(HydrochloricAcid.getFluid(6000))
                .EUt(480)
                .duration(100)
                .save(provider);
    }
}

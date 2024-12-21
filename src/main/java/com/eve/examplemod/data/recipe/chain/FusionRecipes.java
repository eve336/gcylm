package com.eve.examplemod.data.recipe.chain;

import static com.eve.examplemod.common.data.EVMaterials.Plutonium239;
import static com.eve.examplemod.common.data.EVMaterials.Uranium238;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.FUSION_RECIPES;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKey;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class FusionRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        int chainNumber = 1; // Start at 2 and increment

        // Fusion Recipes
        FUSION_RECIPES.recipeBuilder("helium_plasma_recipe_" + chainNumber++)
                .duration(16).EUt(4096).fusionStartEU(40000000)
                .inputFluids(Deuterium.getFluid(125))
                .inputFluids(Tritium.getFluid(125))
                .outputFluids(Helium.getFluid(FluidStorageKeys.PLASMA, 125))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("helium_plasma_recipe_" + chainNumber++)
                .duration(16).EUt(2048).fusionStartEU(60000000)
                .inputFluids(Deuterium.getFluid(125))
                .inputFluids(Helium3.getFluid(125))
                .outputFluids(Helium.getFluid(FluidStorageKeys.PLASMA, 125))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("potassium_plasma_recipe_" + chainNumber++)
                .duration(16).EUt(2048).fusionStartEU(60000000)
                .inputFluids(Fluorine.getFluid(125))
                .inputFluids(Helium3.getFluid(125))
                .outputFluids(Potassium.getFluid(FluidStorageKeys.PLASMA, 125))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("oxygen_plasma_recipe_" + chainNumber++)
                .duration(32).EUt(4096).fusionStartEU(80000000)
                .inputFluids(Carbon.getFluid(125))
                .inputFluids(Helium3.getFluid(125))
                .outputFluids(Oxygen.getFluid(FluidStorageKeys.PLASMA, 125))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("nitrogen_plasma_recipe_" + chainNumber++)
                .duration(16).EUt(16384).fusionStartEU(180000000)
                .inputFluids(Beryllium.getFluid(16))
                .inputFluids(Deuterium.getFluid(375))
                .outputFluids(Nitrogen.getFluid(FluidStorageKeys.PLASMA, 175))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("iron_plasma_recipe_" + chainNumber++)
                .duration(32).EUt(8192).fusionStartEU(360000000)
                .inputFluids(Silicon.getFluid(16))
                .inputFluids(Magnesium.getFluid(16))
                .outputFluids(Iron.getFluid(FluidStorageKeys.PLASMA, 125))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("nickel_plasma_recipe_" + chainNumber++)
                .duration(16).EUt(32768).fusionStartEU(480000000)
                .inputFluids(Potassium.getFluid(16))
                .inputFluids(Fluorine.getFluid(125))
                .outputFluids(Nickel.getFluid(FluidStorageKeys.PLASMA, 125))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("platinum_plasma_recipe_" + chainNumber++)
                .duration(32).EUt(32768).fusionStartEU(150000000)
                .inputFluids(Beryllium.getFluid(16))
                .inputFluids(Tungsten.getFluid(16))
                .outputFluids(Platinum.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("europium_fluid_recipe_" + chainNumber++)
                .duration(64).EUt(24576).fusionStartEU(150000000)
                .inputFluids(Neodymium.getFluid(16))
                .inputFluids(Hydrogen.getFluid(48))
                .outputFluids(Europium.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("americium_fluid_recipe_" + chainNumber++)
                .duration(96).EUt(49152).fusionStartEU(200000000)
                .inputFluids(Lutetium.getFluid(16))
                .inputFluids(Chromium.getFluid(16))
                .outputFluids(Americium.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("naquadah_fluid_recipe_" + chainNumber++)
                .duration(64).EUt(32768).fusionStartEU(300000000)
                .inputFluids(Plutonium239.getFluid(16))
                .inputFluids(Thorium.getFluid(16))
                .outputFluids(Naquadah.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("osmium_fluid_recipe_" + chainNumber++)
                .duration(64).EUt(24578).fusionStartEU(150000000)
                .inputFluids(Tungsten.getFluid(16))
                .inputFluids(Helium.getFluid(16))
                .outputFluids(Osmium.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("iron_fluid_recipe_" + chainNumber++)
                .duration(64).EUt(8192).fusionStartEU(120000000)
                .inputFluids(Manganese.getFluid(16))
                .inputFluids(Hydrogen.getFluid(16))
                .outputFluids(Iron.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("uranium_fluid_recipe_" + chainNumber++)
                .duration(64).EUt(49152).fusionStartEU(240000000)
                .inputFluids(Mercury.getFluid(16))
                .inputFluids(Magnesium.getFluid(16))
                .outputFluids(Uranium238.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("uranium_fluid_recipe_2_" + chainNumber++)
                .duration(64).EUt(49152).fusionStartEU(240000000)
                .inputFluids(Gold.getFluid(16))
                .inputFluids(Aluminium.getFluid(16))
                .outputFluids(Uranium238.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("plutonium_fluid_recipe_" + chainNumber++)
                .duration(128).EUt(8192).fusionStartEU(120000000)
                .inputFluids(Uranium238.getFluid(16))
                .inputFluids(Helium.getFluid(16))
                .outputFluids(Plutonium241.getFluid(16))
                .save(provider);

        FUSION_RECIPES.recipeBuilder("copernicium_fluid_recipe_" + chainNumber++)
                .duration(128).EUt(49152).fusionStartEU(480000000)
                .inputFluids(Nickel.getFluid(16))
                .inputFluids(Polonium.getFluid(16))
                .outputFluids(Copernicium.getFluid(16))
                .save(provider);
        // ... Continue for all other recipes ...

        // You can continue updating each recipe similarly, incrementing `aluminiumChainNumber` and adjusting the output format
    }
}

package com.eve.examplemod.data.recipe.generated;

import com.eve.examplemod.api.data.material.properties.EVNuclearProperty;
import com.eve.examplemod.api.data.material.properties.EVPropertyKey;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.Map;
import java.util.function.Consumer;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.api.data.tag.EVTagPrefix.*;
import static com.eve.examplemod.common.data.EVMaterials.Plutonium244;
import static com.eve.examplemod.common.data.EVRecipeTypes.NUCLEAR_REACTOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.ingot;
import static com.gregtechceu.gtceu.common.data.GTItems.SHAPE_MOLD_BALL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class Nuclear {
    public static void init(Consumer<FinishedRecipe> provider) {
        nuclearReactorRecipes(provider);
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlag(GENERATE_NUCLEAR)) {
                    if (material.hasProperty(PropertyKey.INGOT)) {
                        CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_oxide")
                                .inputItems(ingot, material)
                                .inputFluids(Oxygen.getFluid(1000))
                                .outputItems(oxide, material)
                                .duration(300).EUt(30)
                                .save(provider);

                        ALLOY_SMELTER_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_fuel_pure")
                                .inputItems(ingot, material)
                                .notConsumable(SHAPE_MOLD_BALL)
                                .outputItems(fuel_pure, material)
                                .duration(200).EUt(30)
                                .save(provider);
                    }
                    ALLOY_SMELTER_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_fuel_oxide")
                            .inputItems(oxide, material)
                            .notConsumable(SHAPE_MOLD_BALL)
                            .outputItems(fuel_oxide, material)
                            .duration(200).EUt(30)
                            .save(provider);

                }
            }
        }
    }
    static void nuclearReactorRecipes(Consumer<FinishedRecipe> provider) {
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlags(GENERATE_NUCLEAR, FISSILE_OXIDE)) {

                        for (MaterialRegistry registry2 : GTCEuAPI.materialManager.getRegistries()) {
                            for (Material material2 : registry2.getAllMaterials()) {
                                if (material2.hasFlags(GENERATE_NUCLEAR, FISSILE)) {
                                    Plutonium244.getProperty(EVPropertyKey.NUCLEAR);
                                    EVNuclearProperty property = new EVNuclearProperty(0, Map.of());
                                    if (material2.getProperty(EVPropertyKey.NUCLEAR) != null){
                                        property = material2.getProperty(EVPropertyKey.NUCLEAR);
                                    }
                                    for (int i = 2; i < 7; i++) {
                                    GTRecipeBuilder NuclearReactorRecipe = NUCLEAR_REACTOR_RECIPES.recipeBuilder("circuit_" + i +"_" + material.getName().toLowerCase() + "_and_" + material2.getName().toLowerCase());
                                    NuclearReactorRecipe.inputItems(fuel_pure, material2, 9);
                                    NuclearReactorRecipe.inputItems(fuel_oxide, material, i);
                                    NuclearReactorRecipe.circuitMeta(i);
                                    NuclearReactorRecipe.outputItems(depleted_fuel_oxide, material, i);
                                    property.getDecay().forEach((key, value) ->
                                            NuclearReactorRecipe.chancedOutput(depleted_fuel, key,9, value, 100)
                                            );
                                    NuclearReactorRecipe.addData("temp", property.getHeat());
                                    NuclearReactorRecipe.save(provider);
                            }
                        }
                    }
                    }
                }
            }
        }
    }
}
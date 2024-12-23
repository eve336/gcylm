package com.eve.examplemod.data.recipe.generated;

import com.eve.examplemod.api.data.material.properties.EVComponentProperty;
import com.eve.examplemod.api.data.material.properties.EVNuclearProperty;
import com.eve.examplemod.api.data.material.properties.EVPropertyKey;
import com.eve.examplemod.api.data.material.properties.EVWasteProperty;
import com.eve.examplemod.api.fluids.store.EVFluidStorageKeys;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.*;
import java.util.function.Consumer;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.api.data.tag.EVTagPrefix.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.NUCLEAR_REACTOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.SHAPE_MOLD_BALL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class Nuclear {




    public static void init(Consumer<FinishedRecipe> provider) {

        nuclearReactorRecipes(provider);
        fuelReprocessing(provider);
        isotopeSeparation(provider);

        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlag(GENERATE_NUCLEAR)) {
                    if (material.hasProperty(PropertyKey.INGOT)) {
                        if (material.hasFlag(FISSILE_OXIDE)) {
                            CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_oxide")
                                    .inputItems(ingot, material)
                                    .inputFluids(Oxygen.getFluid(1000))
                                    .outputItems(oxide, material)
                                    .duration(300).EUt(30)
                                    .save(provider);

                            ALLOY_SMELTER_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_fuel_oxide")
                                    .inputItems(oxide, material)
                                    .notConsumable(SHAPE_MOLD_BALL)
                                    .outputItems(fuel_oxide, material)
                                    .duration(200).EUt(30)
                                    .save(provider);
                        }
                        if (material.hasFlag(FISSILE)) {
                            ALLOY_SMELTER_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_fuel_pure")
                                    .inputItems(ingot, material)
                                    .notConsumable(SHAPE_MOLD_BALL)
                                    .outputItems(fuel_pure, material)
                                    .duration(200).EUt(30)
                                    .save(provider);
                        }
                    }
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
                                    property.getDecayProducts().forEach((key, value) ->
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
    static void fuelReprocessing(Consumer<FinishedRecipe> provider) {
        var stringToElement = new HashMap<String, Material>();
        Set<Material> decayset = new HashSet<>();
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlag(GENERATE_NUCLEAR)) {
                    if (material.getElement() != null && !material.getElement().isIsotope()){
                        String symbol;
                        String[] symbolArray = material.getElement().symbol().split("-");
                        symbol = symbolArray[0];
                        stringToElement.put(symbol, material);
                    }
                    if (material.getProperty(EVPropertyKey.NUCLEAR) != null){
                        EVNuclearProperty nuclearProperty = material.getProperty(EVPropertyKey.NUCLEAR);
                        nuclearProperty.decayProducts.forEach((key, value) -> decayset.add(key));
                    }
                }
            }
        }

        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlag(GENERATE_NUCLEAR)) {

                    if (decayset.contains(material)){
                        // Fuel + O = [Fuel + O]
                        CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_depleted_to_oxide")
                                .inputItems(depleted_fuel, material)
                                .inputFluids(Oxygen.getFluid(1000))
                                .outputItems(depleted_fuel_oxide, material)
                                .save(provider);
                    }

                    if (material.hasFlag(FISSILE_OXIDE) || decayset.contains(material)) {

                        // HNO3 + [Fuel + O] = [Fuel + NO3 + H2O]   i dont think this one makes sense TODO fix this stoich
                        LARGE_CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_nitrate_solution").EUt(30).duration(50 * 20)
                                .notConsumable(dust, Boron)
                                .inputItems(depleted_fuel_oxide, material)
                                .inputFluids(NitricAcid.getFluid(1000))
                                .outputFluids(material.getFluid(EVFluidStorageKeys.depleted_nitrate, 1000))
                                .save(provider);

                        // Fuel2N3 ???
                        LARGE_CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_depleted_fuel_nitride")
                                .notConsumableFluid(TributylPhosphate.getFluid(1))
                                .notConsumableFluid(Hydrazine.getFluid(1))
                                .notConsumableFluid(RP1.getFluid(1))
                                .inputFluids(material.getFluid(EVFluidStorageKeys.depleted_nitrate, 1000))
                                .notConsumable(dust, FerriteMixture)
                                .outputItems(depleted_fuel_nitride, material)
                                .outputFluids(Oxygen.getFluid(4000))
                                .outputFluids(Hydrogen.getFluid(1000))
                                .save(provider);

                        String symbol = null;
                        if (material.getElement() != null) {
                            String[] symbolArray = material.getElement().symbol().split("-");
                            symbol = symbolArray[0];
                        }
                        if (symbol != null) {
                            Material material1 = stringToElement.get(symbol);
                            ELECTROLYZER_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_depleted_fuel_electrolysing")
                                    .inputItems(depleted_fuel_nitride, material)
                                    .outputItems(nuclear_waste, material1)
                                    .outputFluids(Nitrogen.getFluid(1000))
                                    .save(provider);
                        }
                    }
                        if (material.getProperty(EVPropertyKey.WASTE) != null) {
                            EVWasteProperty property = material.getProperty(EVPropertyKey.WASTE);
                            GTRecipeBuilder recipeBuilder = THERMAL_CENTRIFUGE_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_waste_centrifuging");
                            recipeBuilder.inputItems(nuclear_waste, material);
                            property.getRealMaterials().forEach(material1 ->
                                    recipeBuilder.outputItems(dust, material1)
                            );
                            property.getWasteProducts().forEach((key, value) -> recipeBuilder.chancedOutput(dust, key, value, 0));
                            recipeBuilder.save(provider);
                        }

                }
            }
        }
    }

    static void isotopeSeparation(Consumer<FinishedRecipe> provider) {


        Set<Material> set = new HashSet<>();

        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlag(GENERATE_NUCLEAR)) {
                    if (material.getProperty(EVPropertyKey.COMPONENT) != null){
                        EVComponentProperty prop = material.getProperty(EVPropertyKey.COMPONENT);
                        prop.components.forEach((ohio, rizz) -> set.add(ohio));
                    }
                }
            }
        }


        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
        for (Material material : registry.getAllMaterials()) {
            if (material.hasFlag(GENERATE_NUCLEAR)) {
                if (material.getElement() != null && !material.getElement().isIsotope()){

                    // Mat + 2HNO3 = [Mat + 2NO3] + 2H
                    CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_dust_to_nitrite")
                            .inputItems(dust, material)
                            .inputFluids(NitricAcid.getFluid(2000))
                            .outputItems(nitrite, material, 1)
                            .outputFluids(Hydrogen.getFluid(2000))
                            .save(provider);

                    // [Mat + 2NO3] = [Mat + 2O] + 2NO2
                    BLAST_RECIPES.recipeBuilder(material.getName().toLowerCase() + "nitrite_to_dioxide").EUt(120).duration(5*20)
                            .inputItems(nitrite, material, 1)
                            .outputItems(dioxide, material)
                            .outputFluids(NitrogenDioxide.getFluid(2000))
                            .blastFurnaceTemp(600)
                            .save(provider);

                    // [Mat + 2O] + 6Cl = [Mat + 6Cl] + 2O
                    CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "dioxide_to_hexachloride")
                            .inputItems(dioxide, material)
                            .inputFluids(Chlorine.getFluid(6000))
                            .outputFluids(material.getFluid(EVFluidStorageKeys.hexachloride, 1000))
                            .outputFluids(Oxygen.getFluid(2000))
                            .save(provider);

                    // [Mat + 6Cl] + 6HF = 6HCl + [Mat + 6F]
                    CHEMICAL_RECIPES.recipeBuilder(material.getName().toLowerCase() + "hexachloride_to_hexafluoride")
                            .inputFluids(HydrofluoricAcid.getFluid(6000))
                            .inputFluids(material.getFluid(EVFluidStorageKeys.hexachloride, 1000))
                            .outputFluids(HydrochloricAcid.getFluid(6000))
                            .outputFluids(material.getFluid(EVFluidStorageKeys.hexafluoride, 1000))
                            .save(provider);

                    if (material.hasProperty(EVPropertyKey.COMPONENT)){
                        EVComponentProperty prop = material.getProperty(EVPropertyKey.COMPONENT);
                        GTRecipeBuilder recipeBuilder = GAS_CENTRIFUGE_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_gas_centrifuge");
                        recipeBuilder.inputFluids(material.getFluid(EVFluidStorageKeys.hexafluoride, 20000));
                        prop.components.forEach((key, value) ->
                                recipeBuilder.outputFluids(key.getFluid(EVFluidStorageKeys.hexafluoride, value))
                                );
                        recipeBuilder.save(provider);

                        // do the ratios for this lmaoooo, think of some good solution for (chemplant) skip
                        GTRecipeBuilder recipeBuilder2 = CHEMICAL_PLANT_RECIPES.recipeBuilder(material.getName().toLowerCase() + "isotope_separation");
                                recipeBuilder2.inputItems(dust, material, 100);
                                prop.components.forEach((key, value) ->
                                        recipeBuilder2.outputItems(dust, key, value / 10)
                                        );
                                recipeBuilder2.save(provider);
                    }


                }
                if ((material.getElement() != null && material.getElement().isIsotope())){

                    if (set.contains(material)) {

                        // [Mat + F6] + 3H2O -> [Mat + F6 + 3H2O]
                        CRACKING_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_hexafluoride_steam_cracking")
                                .inputFluids(material.getFluid(EVFluidStorageKeys.hexafluoride, 1000))
                                .inputFluids(Steam.getFluid(3000))
                                .outputFluids(material.getFluid(EVFluidStorageKeys.steam_cracked_hexafluoride, 1000))
                                .save(provider);


                        // [Mat + F6 + 3H2O] -> [Mat + 2O] + 6HF + O (O lost)
                        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_steam_cracked_to_dioxide")
                                .inputFluids(material.getFluid(EVFluidStorageKeys.steam_cracked_hexafluoride, 1000))
                                .outputItems(dioxide, material, 1)
                                .outputFluids(HydrofluoricAcid.getFluid(6000))
                                .outputFluids(Oxygen.getFluid(1000))
                                .blastFurnaceTemp(600)
                                .save(provider);

                    }

                    // [Mat + 2O] -> Mat + 2O
                    BLAST_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_dioxide_to_ingot")
                            .inputItems(dioxide, material, 1)
                            .outputItems(ingot, material)
                            .outputFluids(Oxygen.getFluid(2000))
                            .blastFurnaceTemp(600)
                            .save(provider);
                }
            }
            }
        }
    }


}
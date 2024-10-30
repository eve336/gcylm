package com.eve.examplemod.data.recipe.generated;

import java.util.function.Consumer;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import net.minecraft.data.recipes.FinishedRecipe;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.AUTOCLAVE_RECIPES;

public class Replication {

    public static void init(Consumer<FinishedRecipe> provider) {
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.isElement() && material.hasFluid()) {
                    AUTOCLAVE_RECIPES.recipeBuilder("autoclave_")
                            .outputFluids(material.getFluid(1))
                            .duration(1200).EUt(24)
                            .save(provider);
                }
            }
        }
    }
}
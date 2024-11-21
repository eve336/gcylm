package com.eve.examplemod.data.recipe.generated;

import java.util.function.Consumer;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import net.minecraft.data.recipes.FinishedRecipe;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.DISABLE_REPLICATION;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.AUTOCLAVE_RECIPES;

public class Replication {

    public static void init(Consumer<FinishedRecipe> provider) {
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.isElement() && material.hasFluid() && !material.hasFlag(DISABLE_REPLICATION)) {
                    AUTOCLAVE_RECIPES.recipeBuilder("autoclave_")
                            .notConsumableFluid(material.getFluid(1))
                            .outputFluids(material.getFluid(100))
                            .duration(1200).EUt(9000000)
                            .save(provider);
                }
            }
        }
    }
}
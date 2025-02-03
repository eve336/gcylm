package com.eve.examplemod.data.recipe.generated;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.DISABLE_REPLICATION;
import static com.eve.examplemod.common.data.EVRecipeTypes.RECPLICATION_RECIPES;

public class Replication {

    // TODO bosonic + fermionic matter
    // TODO config option
    // TODO remove a LOT of materials from replication

    public static void init(Consumer<FinishedRecipe> provider) {
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.isElement() && material.hasFluid() && !material.hasFlag(DISABLE_REPLICATION) && material.getElement() != null && !material.getElement().isIsotope()) {
                    if (material.getProperty(PropertyKey.FLUID) != null) {
                        if (material.getProperty(PropertyKey.FLUID).getPrimaryKey().equals(FluidStorageKeys.LIQUID)) {
                            RECPLICATION_RECIPES.recipeBuilder(material.getName().toLowerCase() + "_replication")
                                    .notConsumableFluid(material.getFluid(1))
                                    .outputFluids(material.getFluid(100))
                                    .duration(1200).EUt(9000000)
                                    .save(provider);
                        }
                    }
                }
            }
        }
    }
}
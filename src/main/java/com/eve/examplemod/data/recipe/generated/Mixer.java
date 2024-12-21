package com.eve.examplemod.data.recipe.generated;

import com.eve.examplemod.api.data.material.info.EVMaterialFlags;
import com.eve.examplemod.api.data.material.properties.EVMixerProperty;
import com.eve.examplemod.api.data.material.properties.EVPropertyKey;
import com.eve.examplemod.common.data.EVMaterials;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.LARGE_MIXER_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MIXER_RECIPES;

public class Mixer {
    public static void init(Consumer<FinishedRecipe> provider) {
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material input : registry.getAllMaterials()) {
                if (input.hasFlag(EVMaterialFlags.AUTOGEN_MIXER_RECIPE) && !input.hasFlag(DISABLE_AUTOGEN_MIXER) && !input.isElement() && input.getMaterialComponents().size() > 1) {
                    int fluidInputs = 0;
                    int itemInputs = 0;
                    for (int i = 0; i < input.getMaterialComponents().size(); i++) {
                        Material material = input.getMaterialComponents().get(i).material();
                        if (material.hasFluid() && !material.hasProperty(PropertyKey.INGOT) && !material.hasProperty(PropertyKey.DUST)) {
                            fluidInputs = fluidInputs + 1;
                        } else itemInputs = itemInputs + 1;
                    }
                    GTRecipeBuilder mixerRecipe;
                    if (fluidInputs > 2 || itemInputs > 5) {
                        mixerRecipe = LARGE_MIXER_RECIPES.recipeBuilder(input.getName().toLowerCase() + "_mixer_recipe_autogenned");
                    }
                    else mixerRecipe = MIXER_RECIPES.recipeBuilder(input.getName().toLowerCase() + "_mixer_recipe_autogenned");


                    EVMixerProperty property = EVMaterials.HastelloyX78.getProperty(EVPropertyKey.MIXER);
                    BlastProperty blastProperty = GTMaterials.Aluminium.getProperty(PropertyKey.BLAST);
                    int totalamount = 0;
                    if (input.getProperty(EVPropertyKey.MIXER) != null) {
                        property = input.getProperty(EVPropertyKey.MIXER);
                    }
                    if (input.getProperty(PropertyKey.BLAST) != null) {
                        blastProperty = input.getProperty(PropertyKey.BLAST);
                    }
                    for (int i = 0; i < input.getMaterialComponents().size(); i++) {
                        Material material = input.getMaterialComponents().get(i).material();
                        long amount = input.getMaterialComponents().get(i).amount();
                        totalamount = totalamount + (int) amount;
                        if (material.hasFluid() && !material.hasProperty(PropertyKey.INGOT) && !material.hasProperty(PropertyKey.DUST)) {
                            mixerRecipe.inputFluids(material.getFluid(((int) amount * 1000)));
                        } else {
                            mixerRecipe.inputItems(dust, material, (int) amount);
                        }
                    }
                    int duration = property.getDurationOverride();
                    if (duration < 0) {
                        duration = blastProperty.getDurationOverride();
                    }
                    if (duration < 0) {
                        duration = (Math.max(1, (int) (input.getMass() * blastProperty.getBlastTemperature() / 100L)) / 5);
                    }

                    int EUt = property.getEUtOverride();
                    if (EUt < 0) {
                        EUt = blastProperty.getEUtOverride();
                    }
                    if (EUt < 0) {
                        EUt = GTValues.VA[GTValues.MV];
                    }
                    mixerRecipe.circuitMeta(input.getMaterialComponents().size());
                    mixerRecipe.outputItems(dust, input, totalamount)
                            .EUt(EUt)
                            .duration(duration)
                            .save(provider);
                }
            }
        }
    }
}

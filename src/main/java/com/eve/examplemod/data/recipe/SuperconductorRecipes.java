package com.eve.examplemod.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import dev.architectury.utils.Amount;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class SuperconductorRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        MIXER_RECIPES.recipeBuilder("lv_supercon")
                .inputItems(dust, SolderingAlloy, 10)
                .inputItems(dust, Gallium, 2)
                .outputItems(dust, LVSuperconductorBase)
                .duration(12*20)
                .EUt(30)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("mv_supercon")
                .inputItems(dust, Cadmium, 5)
                .inputItems(dust, Magnesium)
                .inputFluids(Oxygen.getFluid(6000))
                .outputItems(dust, MVSuperconductorBase, 12)
                .EUt(30)
                .duration(20*12)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("hv_supercon")
                .inputItems(dust, Copper, 10)
                .inputItems(dust, Titanium)
                .inputItems(dust, Barium, 9)
                .inputFluids(Oxygen.getFluid(20000))
                .outputItems(dust, HVSuperconductorBase, 40)
                .EUt(30)
                .duration(20*40)
                .save(provider);


        MIXER_RECIPES.recipeBuilder("iv_supercon")
                .inputItems(dust, Indium, 3)
                .inputItems(dust, Vanadium)
                .outputItems(dust, IVSuperconductorBase, 4)
                .EUt(30)
                .duration(20*20)
                .save(provider);


        GTRecipeBuilder zpmSupercon = MIXER_RECIPES.recipeBuilder("zpm_supercon");

        Material input = ZPMSuperconductorBase;
        for (int i = 0; i < input.getMaterialComponents().size(); i++) {
            Material material = input.getMaterialComponents().get(i).material();
            long amount = input.getMaterialComponents().get(i).amount();
            if (material.hasFluid() && !material.hasProperty(PropertyKey.INGOT)){
                zpmSupercon.inputFluids(material.getFluid(amount*1000));
            }
            else zpmSupercon.inputItems(dust, material, (int) amount);
        }
                zpmSupercon.outputItems(dust, ZPMSuperconductorBase, 13)
                .EUt(30)
                .duration(20*50)
                .save(provider);



        MIXER_RECIPES.recipeBuilder("uv_supercon")
                .inputItems(dust, Naquadria, 4)
                .inputItems(dust, Osmiridium)
                .inputItems(dust, Rutherfordium)
                .inputItems(dust, Samarium)
                .outputItems(dust, MVSuperconductorBase, 9)
                .EUt(30)
                .duration(20*12)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("uhv_supercon")
                .inputItems(dust, TBCCODust)
                .inputItems(dust, StrontiumSuperconductorDust)
                .inputItems(dust, Amethyst)
                .outputItems(dust, MVSuperconductorBase, 9)
                .EUt(30)
                .duration(20*12)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("uev_supercon")
                .inputItems(dust, Cadmium, 5)
                .inputItems(dust, Magnesium)
                .inputFluids(Oxygen.getFluid(6000))
                .outputItems(dust, MVSuperconductorBase, 12)
                .EUt(30)
                .duration(20*12)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("uiv_supercon")
                .inputItems(dust, Cadmium, 5)
                .inputItems(dust, Magnesium)
                .inputFluids(Oxygen.getFluid(6000))
                .outputItems(dust, MVSuperconductorBase, 12)
                .EUt(30)
                .duration(20*12)
                .save(provider);
    }
}

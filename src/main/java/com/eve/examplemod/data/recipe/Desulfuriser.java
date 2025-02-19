package com.eve.examplemod.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVRecipeTypes.DESULFURISER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class Desulfuriser {
    public static void init(Consumer<FinishedRecipe> provider) {
        DESULFURISER_RECIPES.recipeBuilder("desulfurise_refinery_gas").EUt(30).duration(8*20)
                .inputFluids(SulfuricGas.getFluid(16000))
                .outputFluids(RefineryGas.getFluid(16000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .save(provider);

        DESULFURISER_RECIPES.recipeBuilder("desulfurise_heavy_fuel").EUt(30).duration(8*20)
                .inputFluids(SulfuricHeavyFuel.getFluid(8000))
                .outputFluids(HeavyFuel.getFluid(8000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .save(provider);

        DESULFURISER_RECIPES.recipeBuilder("desulfurise_light_fuel").EUt(30).duration(8*20)
                .inputFluids(SulfuricLightFuel.getFluid(12000))
                .outputFluids(LightFuel.getFluid(12000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .save(provider);

        DESULFURISER_RECIPES.recipeBuilder("desulfurise_naphtha").EUt(30).duration(8*20)
                .inputFluids(SulfuricNaphtha.getFluid(12000))
                .outputFluids(Naphtha.getFluid(12000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .save(provider);
    }
}

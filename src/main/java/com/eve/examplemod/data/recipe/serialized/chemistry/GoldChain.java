package com.eve.examplemod.data.recipe.serialized.chemistry;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class GoldChain {

    public static void init(Consumer<FinishedRecipe> provider) {

        CENTRIFUGE_RECIPES.recipeBuilder("ohio")
                .inputItems(dust, GoldAlloy, 4)
                .outputItems(ChemicalHelper.get(dust, Copper))
                .outputItems(dustTiny, Gold, 4)
                .duration(500)
                .EUt(30)
                .save(provider);

        ELECTROLYZER_RECIPES.recipeBuilder("ohio")
                .inputItems(dust, GoldLeach, 4)
                .inputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(dust, Copper, 3)
                .outputItems(dustTiny, Gold, 8)
                .duration(300)
                .EUt(30)
                .save(provider);


        
        ALLOY_SMELTER_RECIPES.recipeBuilder("goldline").EUt(30).duration(100)
                .inputItems(dust, PreciousMetal)
                .inputItems(dust, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("goldline").EUt(30).duration(100)
                .inputItems(ingot, PreciousMetal)
                .inputItems(dust, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("goldline").EUt(30).duration(100)
                .inputItems(dust, PreciousMetal)
                .inputItems(ingot, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("goldline").EUt(30).duration(100)
                .inputItems(ingot, PreciousMetal)
                .inputItems(ingot, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        // STEP 2
        // Cu3Au? + HNO3 -> Cu3Au?(OH) + NO2
    }
}

package com.eve.examplemod.data.recipe.chain;


import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTItems.STICKY_RESIN;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class InsulatorChain {


    public static void init(Consumer<FinishedRecipe> provider) {
        MIXER_RECIPES.recipeBuilder("aluminium_chain_2").duration(400).EUt(8)
                .inputItems(dust, Mica, 3)
                .inputItems(dust, RawRubber, 2)
                .outputItems(dust, MicaPulp, 5)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("aluminium_chain_3").duration(400).EUt(8)
                .inputItems(dust, Mica, 3)
                .inputItems(STICKY_RESIN)
                .outputItems(dust, MicaPulp, 4)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("aluminium_chain_4").duration(1200).EUt(30)
                .inputItems(dust, Sapphire, 1)
                .inputItems(dust, SiliconDioxide, 3)
                .outputItems(dust, AluminoSilicateWool, 2)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("aluminium_chain_5").duration(1200).EUt(30)
                .inputItems(dust, GreenSapphire, 1)
                .inputItems(dust, SiliconDioxide, 3)
                .outputItems(dust, AluminoSilicateWool, 2)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("aluminium_chain_6").duration(1200).EUt(30)
                .inputItems(dust, Ruby, 1)
                .inputItems(dust, SiliconDioxide, 3)
                .outputItems(dust, AluminoSilicateWool, 2)
                .save(provider);

        FORMING_PRESS_RECIPES.recipeBuilder("aluminium_chain_7").duration(400).EUt(28)
                .inputItems(dust, MicaPulp, 4)
                .inputItems(dust, Asbestos, 1)
                .outputItems(mica_sheet, 5)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("aluminium_chain_8").duration(400).EUt(30)
                .inputItems(mica_sheet, 5)
                .inputItems(dust, SiliconDioxide, 3)
                .outputItems(mica_insulator_sheet, 8)
                .save(provider);

        BENDER_RECIPES.recipeBuilder("aluminium_chain_9").duration(100).EUt(30)
                .circuitMeta(1)
                .inputItems(mica_insulator_sheet, 1)
                .outputItems(mica_insulator_foil, 4)
                .save(provider);
    }
}

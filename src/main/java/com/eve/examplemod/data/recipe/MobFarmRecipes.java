package com.eve.examplemod.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.BottleItem;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.BLAZE_BOTTLE;
import static com.eve.examplemod.common.data.EVRecipeTypes.HARVESTER_RECIPES;
import static com.eve.examplemod.common.data.EVRecipeTypes.SPAWNER_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Coal;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Sulfur;
import static net.minecraft.world.item.Items.*;

public class MobFarmRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        SPAWNER_RECIPES.recipeBuilder("blaze_spawning").EUt(25).duration(200)
                .inputItems(GLASS_BOTTLE)
                .inputItems(BLAZE_POWDER, 2)
                .inputItems(dust, Sulfur)
                .inputFluids(GTMaterials.Lava.getFluid(500))
                .outputItems(BLAZE_BOTTLE)
                .save(provider);

        HARVESTER_RECIPES.recipeBuilder("blaze_harvesting").EUt(30).duration(200)
                .inputItems(BLAZE_BOTTLE)
                .outputItems(BLAZE_ROD, 7)
                .outputItems(dust, Coal)
                .outputItems(GLASS_BOTTLE)
                .save(provider);
    }
}

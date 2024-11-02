package com.eve.examplemod.common.data;

import com.eve.examplemod.data.recipe.generated.Replication;
import com.eve.examplemod.data.recipe.serialized.chemistry.AluminiumChain;
import com.eve.examplemod.data.recipe.serialized.chemistry.GoldChain;
import net.minecraft.data.recipes.FinishedRecipe;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTRecipes.RECIPE_FILTERS;


public class EVRecipes {
    public static void init(Consumer<FinishedRecipe> originalConsumer) {
        Consumer<FinishedRecipe> consumer = recipe -> {
            if (!RECIPE_FILTERS.contains(recipe.getId())) {
                originalConsumer.accept(recipe);
            }
        };
        Replication.init(consumer);
        GoldChain.init(consumer);
        AluminiumChain.init(consumer);
    }
}

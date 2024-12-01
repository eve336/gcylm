package com.eve.examplemod.common.data;

import com.eve.examplemod.data.recipe.MiscRecipes;
import com.eve.examplemod.data.recipe.SuperconductorRecipes;
import com.eve.examplemod.data.recipe.chain.*;
import com.eve.examplemod.data.recipe.circuit.CircuitRecipes;
import com.eve.examplemod.data.recipe.generated.Machines;
import com.eve.examplemod.data.recipe.generated.Mixer;
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
        MiscRecipes.init(consumer);
        Machines.init(consumer);
        InsulatorChain.init(consumer);
        AmmoniaChain.init(consumer);
        ArcFurnaceOxidation.init(consumer);
        Batteries.init(consumer);
        BrineChain.init(consumer);
        BariumChain.init(consumer);
        CircuitRecipes.init(consumer);
        SuperconductorRecipes.init(consumer);
        Mixer.init(consumer);
    }
}

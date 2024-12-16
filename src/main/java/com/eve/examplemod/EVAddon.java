package com.eve.examplemod;

import com.eve.examplemod.api.data.tag.EVTagPrefix;
import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.data.*;
import com.eve.examplemod.data.recipe.Removal;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class EVAddon implements IGTAddon {



    @Override
    public GTRegistrate getRegistrate() {
        return EVRegistries.REGISTRATE;
    }



    @Override
    public void registerCovers() {
        EVCovers.init();
    }
    @Override
    public void initializeAddon() {
        EVItems.init();
    }


    @Override
    public String addonModId() {
        return EVMain.MOD_ID;
    }




    @Override
    public void registerTagPrefixes() {
        //CustomTagPrefixes.init();
        EVTagPrefix.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        //CustomRecipes.init(provider);
        EVRecipes.init(provider);
    }

    public void removeRecipes(Consumer<ResourceLocation> registry) {
        Removal.init(registry);
    }

    @Override
    public void registerElements() {
        EVElements.init();
    }

    @Override
    public void registerOreVeins() {
        EVOres.init();
    }



    
    // If you have custom ingredient types, uncomment this & change to match your capability.
    // KubeJS WILL REMOVE YOUR RECIPES IF THESE ARE NOT REGISTERED.
    /*
    public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, false);
    public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, true);

    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {
        event.registerKey(CustomRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
    }
    */
}

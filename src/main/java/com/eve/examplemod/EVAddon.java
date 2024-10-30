package com.eve.examplemod;

import com.eve.examplemod.common.data.EVCovers;
import com.eve.examplemod.common.data.EVElements;
import com.eve.examplemod.common.data.EVRecipes;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class EVAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return EVMain.EV_REGISTRATE;
    }

    @Override
    public void initializeAddon() {

    }

    @Override
    public String addonModId() {
        return EVMain.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        //CustomTagPrefixes.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        //CustomRecipes.init(provider);
        EVRecipes.init(provider);
    }

    @Override
    public void registerElements() {
        EVElements.init();
    }



    @Override
    public void registerCovers() {

        GTRegistries.COVERS.register(EVCovers.ROBOT_ARM.id, EVCovers.ROBOT_ARM.definition);
        GTRegistries.COVERS.register(EVCovers.CONVEYOR.id, EVCovers.CONVEYOR.definition);
        GTRegistries.COVERS.register(EVCovers.PUMP.id, EVCovers.PUMP.definition);
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

package com.eve.examplemod.common.data;

import com.eve.examplemod.config.EVConfig;
import com.eve.examplemod.data.recipe.*;
import com.eve.examplemod.data.recipe.chain.*;
import com.eve.examplemod.data.recipe.circuit.CircuitComponentRecipes;
import com.eve.examplemod.data.recipe.circuit.CircuitRecipes;
import com.eve.examplemod.data.recipe.generated.*;
import com.eve.examplemod.data.recipe.chain.AluminiumChain;
import com.eve.examplemod.data.recipe.chain.GoldChain;
import com.eve.examplemod.data.recipe.generated.GeneratedMachineRecipes;
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
        if (EVConfig.INSTANCE.harderGold) GoldChain.init(consumer);
        AluminiumChain.init(consumer);
        MiscRecipes.init(consumer);
        GeneratedMachineRecipes.init(consumer);
        InsulatorChain.init(consumer);
        AmmoniaChain.init(consumer);
        ArcFurnaceOxidation.init(consumer);
        Batteries.init(consumer);
        BrineChain.init(consumer);
        BariumChain.init(consumer);
        CircuitRecipes.init(consumer);
        SuperconductorRecipes.init(consumer);
        Mixer.init(consumer);
        FusionRecipes.init(consumer);
        FullereneChain.init(consumer);
        if (EVConfig.INSTANCE.harderPlatline) Platline.init(consumer);
        if (EVConfig.INSTANCE.harderTungsten) TungstenChain.init(consumer);
        HydrogenPeroxide.init(consumer);
        Nuclear.init(consumer);
        CircuitComponentRecipes.init(consumer);
        UltimateMaterials.init(consumer);
        UHVMaterials.init(consumer);
        TriniumChain.init(consumer);
        TaraniumChain.init(consumer);
        SensorEmitter.init(consumer);
        SeleniumChain.init(consumer);
        SuperconductorsSMDChain.init(consumer);
        RheniumChain.init(consumer);
        REEChain.init(consumer);
        PEEKChain.init(consumer);
        OrganometallicChains.init(consumer);
        OpticalChain.init(consumer);
        NaquadahChain.init(consumer);
        LithiumChain.init(consumer);
        IodineChain.init(consumer);
        InsulationWireAssemblyChain.init(consumer);
        HNIWChain.init(consumer);
        CosmicChain.init(consumer);
        CombinedChains.init(consumer);
        ChromiumChain.init(consumer);
        VariousChains.init(consumer);
        VanadiumChain.init(consumer);
        WetwareChain.init(consumer);
        ZincChain.init(consumer);
        ZirconChain.init(consumer);
        WormholeGeneratorChain.init(consumer);
        CoolerRecipes.init(consumer);
        SolarPanelRecipes.init(consumer);
        MachineRecipes.init(consumer);
        Cables.init(consumer);
        MobFarmRecipes.init(consumer);
        Desulfuriser.init(consumer);
    }
}

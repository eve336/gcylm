package com.eve.examplemod.common.data;

import com.eve.examplemod.common.data.machines.EVMultiMachines;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GCYMMachines;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.machines.GCYMMachines.LARGE_MIXER;


public class EVRecipeTypes {

    // why do i have a separate large centrifuge recipe map again? theyre the same size??
    // the large mixer makes sense bc it can handle more inputs but the large centri has the same amoutn


    public static final GTRecipeType CHEMICAL_DEHYDRATOR_RECIPES = GTRecipeTypes.register("chemical_dehydrator", MULTIBLOCK).setMaxIOSize(2, 9, 2, 2);
    public static final GTRecipeType STELLAR_FORGE_RECIPES = GTRecipeTypes.register("stellar_forge", MULTIBLOCK).setMaxIOSize(3,2,3,2);
    public static final GTRecipeType CHEMICAL_PLANT_RECIPES = GTRecipeTypes.register("chemplant", MULTIBLOCK).setMaxIOSize(6,4,5,4);
    public static final GTRecipeType BIO_REACTOR_RECIPES = GTRecipeTypes.register("bio_reactor", MULTIBLOCK).setMaxIOSize(3,3,5,2);

    public static final GTRecipeType ACTIVE_COOLER_RECIPES = GTRecipeTypes.register("active_cooler", ELECTRIC)
            .setMaxIOSize(0,0,1,0)
            .addDataInfo(data ->{
                int cooling = data.getInt("cooling");
                return LocalizationUtils.format("examplemod.recipe.cooling", cooling);
                    }
            );


    public static final GTRecipeType NUCLEAR_REACTOR_RECIPES = GTRecipeTypes.register("nuclear_reactor", MULTIBLOCK)
            .setMaxIOSize(4,4,0,0)
            .addDataInfo(data ->{
                        int temperature = data.getInt("temperature");
                        return LocalizationUtils.format("examplemod.recipe.temperature", temperature);
                    }
            );

    public static final GTRecipeType LARGE_MIXER_RECIPES = GTRecipeTypes.register("large_mixer", MULTIBLOCK)
            .setMaxIOSize(9,1,6,1).setEUIO(IO.IN)
            // dont believe intellij
            .setIconSupplier(() -> LARGE_MIXER.asStack());

    public static final GTRecipeType GAS_CENTRIFUGE_RECIPES = GTRecipeTypes.register("gas_centrifuge", MULTIBLOCK)
            .setMaxIOSize(0,0,1,3).setEUIO(IO.IN);

    public static final GTRecipeType PLASMA_CONDENSER_RECIPES = GTRecipeTypes.register("plasma_condenser", MULTIBLOCK)
            .setMaxIOSize(5,5,5,5).setEUIO(IO.IN);

    public static final GTRecipeType RECPLICATION_RECIPES = GTRecipeTypes.register("replication", MULTIBLOCK)
            .setMaxIOSize(0,0,3,1);

    public static final GTRecipeType LARGE_CENTRIFUGE_RECIPES = GTRecipeTypes.register("large_centrifuge", MULTIBLOCK)
            .setMaxIOSize(2,6,2,6).setEUIO(IO.IN)
            .setIconSupplier(() -> GCYMMachines.LARGE_CENTRIFUGE.asStack());

    public static final GTRecipeType LARGE_ENGRAVER_RECIPES = GTRecipeTypes.register("large_engraver", MULTIBLOCK)
            .setMaxIOSize(5,5,3,1).setEUIO(IO.IN);

    public static final GTRecipeType ADV_FUSION_RECIPES = GTRecipeTypes.register("adv_fusion", MULTIBLOCK)
            .setMaxIOSize(0,0,3,1).setEUIO(IO.IN);

    public static final GTRecipeType SPAWNER_RECIPES = GTRecipeTypes.register("spawner", ELECTRIC)
            .setMaxIOSize(4,1, 2,0).setEUIO(IO.IN);

    public static final GTRecipeType HARVESTER_RECIPES = GTRecipeTypes.register("harvester", ELECTRIC)
            .setMaxIOSize(1,4,0,0).setEUIO(IO.IN);

    public static final GTRecipeType DESULFURISER_RECIPES = GTRecipeTypes.register("desulfuriser", MULTIBLOCK)
            .setMaxIOSize(0,0,2,2).setEUIO(IO.IN);

//    public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
//        var recipeType = new GTRecipeType(GTCEu.id(name), group, proxyRecipes);
//        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
//        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
//        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
//        return recipeType;
//    }


    public static void init(){
        MIXER_RECIPES.onRecipeBuild((builder, provider) -> {
            LARGE_MIXER_RECIPES.copyFrom(builder)
                    .save(provider);
        });

//        CENTRIFUGE_RECIPES.onRecipeBuild((builder, provider) -> {
//            LARGE_CENTRIFUGE_RECIPES.copyFrom(builder)
//                    .save(provider);
//        });

    }
}



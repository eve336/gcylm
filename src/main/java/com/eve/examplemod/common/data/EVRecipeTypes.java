package com.eve.examplemod.common.data;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MULTIBLOCK;

public class EVRecipeTypes {


    public static final GTRecipeType CHEMICAL_DEHYDRATOR_RECIPES = GTRecipeTypes.register("chemical_dehydrator", MULTIBLOCK).setMaxIOSize(2, 9, 2, 2);
    public static final GTRecipeType STELLAR_FORGE_RECIPES = GTRecipeTypes.register("stellar_forge", MULTIBLOCK).setMaxIOSize(3,2,3,2);
    public static final GTRecipeType CHEMICAL_PLANT_RECIPES = GTRecipeTypes.register("chemplant", MULTIBLOCK).setMaxIOSize(6,4,5,4);
    public static final GTRecipeType BIO_REACTOR_RECIPES = GTRecipeTypes.register("bio_reactor", MULTIBLOCK).setMaxIOSize(3,3,5,2);

    public static void init(){

    }
}



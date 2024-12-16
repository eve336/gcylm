package com.eve.examplemod.api.data.material.info;


import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;

public class EVMaterialFlags extends MaterialFlags {
    public static final MaterialFlag DISABLE_REPLICATION = new MaterialFlag.Builder("disable_replication").build();
    public static final MaterialFlag AUTOGEN_MIXER_RECIPE = new MaterialFlag.Builder("autogen_mixer_recipe").build();
    public static final MaterialFlag DISABLE_AUTOGEN_MIXER = new MaterialFlag.Builder("disable_autogen_mixer").build();
    public static final MaterialFlag GENERATE_NUCLEAR = new MaterialFlag.Builder("generate_nuclear").build();
    public static final MaterialFlag FISSILE = new MaterialFlag.Builder("fissile").build();
    public static final MaterialFlag FISSILE_OXIDE = new MaterialFlag.Builder("fissile_oxide").build();
    public static final MaterialFlag DEPLETED = new MaterialFlag.Builder("depleted").build();
    public static final MaterialFlag DEPLETED_OXIDE = new MaterialFlag.Builder("depleted_oxide").build();






}

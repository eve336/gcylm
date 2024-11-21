package com.eve.examplemod.api.data.material.info;


import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;

public class EVMaterialFlags extends MaterialFlags {
    public static final MaterialFlag DISABLE_REPLICATION = new MaterialFlag.Builder("disable_replication").build();
}

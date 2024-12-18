package com.eve.examplemod.api.data.material.info;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;

import java.util.HashMap;
import java.util.Map;

public class EVMaterialIconType {
    public static final Map<String, MaterialIconType> ICON_TYPES = new HashMap<>();

    public static final MaterialIconType fuel = new MaterialIconType("fuel");
    public static final MaterialIconType depletedFuel = new MaterialIconType("depleted_fuel");
    public static final MaterialIconType waste = new MaterialIconType("waste");


    public static void init(){

    }
}

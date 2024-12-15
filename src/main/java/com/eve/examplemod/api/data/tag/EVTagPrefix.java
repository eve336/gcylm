package com.eve.examplemod.api.data.tag;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.function.Predicate;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.api.data.material.info.EVMaterialIconType.*;
import static com.eve.examplemod.api.data.tag.EVTagPrefix.Conditions.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType.*;

public class EVTagPrefix{

    public static final TagPrefix oxide = new TagPrefix("oxide").generateItem(true).idPattern("%s_oxide").generationCondition((material -> material.hasFlags(GENERATE_NUCLEAR, FISSILE_OXIDE))).langValue("%s Oxide").materialIconType(dust);
    public static final TagPrefix fuel_oxide = new TagPrefix("fuelOxide").generateItem(true).idPattern("%s_fuel_oxide").generationCondition((material -> material.hasFlags(GENERATE_NUCLEAR, FISSILE_OXIDE))).langValue("%s Fuel Oxide").materialIconType(fuel);
    public static final TagPrefix fuel_pure = new TagPrefix("fuelPure").generateItem(true).idPattern("%s_fuel_pure").generationCondition((material -> material.hasFlags(GENERATE_NUCLEAR, FISSILE))).langValue("Pure %s Fuel").materialIconType(fuel);
    public static final TagPrefix depleted_fuel = new TagPrefix("depletedFuel").generateItem(true).idPattern("depleted_%s_fuel").generationCondition((material -> material.hasFlag(GENERATE_NUCLEAR))).langValue("Depleted %s Fuel").materialIconType(depletedFuel);
    public static final TagPrefix depleted_fuel_oxide = new TagPrefix("depletedFuelOxide").generateItem(true).idPattern("depleted_%s_fuel_oxide").generationCondition((material -> material.hasFlag(GENERATE_NUCLEAR))).langValue("Depleted %s Fuel Oxide").materialIconType(depletedFuel);


    public static class Conditions {
        public static final Predicate<Material> hasIngotProperty = mat -> mat.hasProperty(PropertyKey.INGOT);
        public static final Predicate<Material> isIsotope = mat -> {
            if (mat == GTMaterials.Naquadah || mat == GTMaterials.NaquadahEnriched || mat == GTMaterials.Naquadria){
                return false;
            }
            if (mat.getElement() != null) {
                return mat.getElement().isIsotope();
            }
            return false;
        };

    }
    public static void init() {
    }

}

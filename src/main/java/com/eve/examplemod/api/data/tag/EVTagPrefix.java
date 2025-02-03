package com.eve.examplemod.api.data.tag;

import com.eve.examplemod.api.data.material.properties.EVNuclearProperty;
import com.eve.examplemod.api.data.material.properties.EVPropertyKey;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.network.chat.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.api.data.material.info.EVMaterialIconType.*;
import static com.eve.examplemod.api.data.tag.EVTagPrefix.Conditions.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.PREFIXES;

public class EVTagPrefix{


    public static TagPrefix get(String name) {
        return PREFIXES.get(name);
    }

    public static final TagPrefix oxide = new TagPrefix("oxide").generateItem(true).idPattern("%s_oxide").generationCondition((material -> material.hasFlags(GENERATE_NUCLEAR, FISSILE_OXIDE))).langValue("%s Oxide").materialIconType(dust);
    public static final TagPrefix fuel_oxide = new TagPrefix("fuelOxide").generateItem(true).idPattern("%s_fuel_oxide").generationCondition((material -> material.hasFlags(GENERATE_NUCLEAR, FISSILE_OXIDE))).langValue("%s Fuel Oxide").materialIconType(fuel).tooltip((material, components) -> {
        if (material.hasProperty(EVPropertyKey.NUCLEAR)){
            int heat = material.getProperty(EVPropertyKey.NUCLEAR).getHeat();
            components.add(Component.literal("Heat: " + heat));
        }
    });
    public static final TagPrefix fuel_pure = new TagPrefix("fuelPure").generateItem(true).idPattern("%s_fuel_pure").generationCondition((material -> material.hasFlags(GENERATE_NUCLEAR, FISSILE))).langValue("Pure %s Fuel").materialIconType(fuel).tooltip((material, components) -> {
        if (material.hasProperty(EVPropertyKey.NUCLEAR)){
            int heat = material.getProperty(EVPropertyKey.NUCLEAR).getHeat();
            components.add(Component.literal("Heat: " + heat));
        }
    });
    public static final TagPrefix depleted_fuel = new TagPrefix("depletedFuel").generateItem(true).idPattern("depleted_%s_fuel").generationCondition(onDecaySet).langValue("Depleted %s Fuel").materialIconType(depletedFuel);
    public static final TagPrefix depleted_fuel_oxide = new TagPrefix("depletedFuelOxide").generateItem(true).idPattern("depleted_%s_fuel_oxide").generationCondition(onDecaySet.or(material -> material.hasFlag(FISSILE_OXIDE))).langValue("Depleted %s Fuel Oxide").materialIconType(depletedFuel);
    public static final TagPrefix depleted_fuel_nitride = new TagPrefix("depletedFuelNitride").generateItem(true).idPattern("depleted_%s_fuel_nitride").generationCondition(onDecaySet.or(material -> material.hasFlag(FISSILE_OXIDE))).langValue("Depleted %s Fuel Nitride").materialIconType(depletedFuel);
    public static final TagPrefix nuclear_waste = new TagPrefix("nuclear_waste").generateItem(true).idPattern("%s_waste").generationCondition(isNotIsotope.and(material -> material.hasFlag(GENERATE_NUCLEAR))).langValue("%s Waste").materialIconType(waste);
    public static final TagPrefix nitrite = new TagPrefix("nitrite").generateItem(true).idPattern("%s_nitrite").generationCondition(isElement.and(isNotIsotope).and(material -> material.hasFlag(GENERATE_NUCLEAR))).langValue("%s Nitrite").materialIconType(dust);
    public static final TagPrefix dioxide = new TagPrefix("dioxide").generateItem(true).idPattern("%s_dioxide").generationCondition(isElement.and(material -> material.hasFlag(GENERATE_NUCLEAR))).langValue("%s Dioxide").materialIconType(dust);


    public static class Conditions {

        public static final Predicate<Material> hasIngotProperty = mat -> mat.hasProperty(PropertyKey.INGOT);
        public static final Predicate<Material> isElement = Material::isElement;
        public static final Predicate<Material> generateNuclear = material -> material.hasFlag(GENERATE_NUCLEAR);
        public static final Predicate<Material> onDecaySet = material -> {
            Set<Material> decayset = new HashSet<>();
            for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
                for (Material material1 : registry.getAllMaterials()) {
                    if (material1.hasFlag(GENERATE_NUCLEAR)) {
                        if (material1.getProperty(EVPropertyKey.NUCLEAR) != null){
                            EVNuclearProperty nuclearProperty = material1.getProperty(EVPropertyKey.NUCLEAR);
                            nuclearProperty.decayProducts.forEach((key, value) -> decayset.add(key));
                        }
                    }
                }
            }
            return decayset.contains(material);
        };
        public static final Predicate<Material> isNotIsotope = mat -> {
            if (mat.getElement() != null && !mat.getElement().isIsotope()){
                return true;
            }
            if (mat.getElement() != null && mat.getElement().isIsotope()){
                return false;
            }
            return false;
        };
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

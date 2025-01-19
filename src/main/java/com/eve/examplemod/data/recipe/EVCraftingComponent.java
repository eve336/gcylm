package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVItems;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.CustomTags;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.gregtechceu.gtceu.api.GTValues.*;



public class EVCraftingComponent extends CraftingComponent {

    public static Component BATTERY;
    public static Component GEAR;

    public static void initialiseComponents() {


        BATTERY = new Component(Stream.of(new Object[][] {

                { 0, CustomTags.ULV_BATTERIES },
                { 1, CustomTags.LV_BATTERIES },
                { 2, CustomTags.MV_BATTERIES },
                { 3, CustomTags.HV_BATTERIES },
                { 4, CustomTags.EV_BATTERIES },
                { 5, CustomTags.IV_BATTERIES },
                { 6, CustomTags.LuV_BATTERIES },
                { 7, CustomTags.ZPM_BATTERIES },
                { 8, CustomTags.UV_BATTERIES },
                { 9, CustomTags.UHV_BATTERIES },
//                { 10, CustomTags.UEV_BATT },
//                { 11, CustomTags.UIV_CIRCUITS },
//                { 12, CustomTags.UXV_CIRCUITS },
//                { 13, CustomTags.OpV_CIRCUITS },
//                { 14, CustomTags.MAX_BATTERIES },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        GEAR = new Component(Stream.of(new Object[][] {

                { 0, new UnificationEntry(TagPrefix.gear, GTMaterials.WroughtIron) },
                { 1, new UnificationEntry(TagPrefix.gear, GTMaterials.Steel) },
                { 2, new UnificationEntry(TagPrefix.gear, GTMaterials.Aluminium) },
                { 3, new UnificationEntry(TagPrefix.gear, GTMaterials.StainlessSteel) },
                { 4, new UnificationEntry(TagPrefix.gear, GTMaterials.Titanium) },
                { 5, new UnificationEntry(TagPrefix.gear, GTMaterials.TungstenSteel) },
                { 6, new UnificationEntry(TagPrefix.gear, GTMaterials.RhodiumPlatedPalladium) },
                { 7, new UnificationEntry(TagPrefix.gear, GTMaterials.NaquadahAlloy) },
                { 8, new UnificationEntry(TagPrefix.gear, GTMaterials.Darmstadtium) },
                { 9, new UnificationEntry(TagPrefix.gear, GTMaterials.Neutronium) },
                { FALLBACK, new UnificationEntry(TagPrefix.gear, GTMaterials.Neutronium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PUMP = new Component(Stream.of(new Object[][]{

                {1, GTItems.ELECTRIC_PUMP_LV.asStack()},
                {2, GTItems.ELECTRIC_PUMP_MV.asStack()},
                {3, GTItems.ELECTRIC_PUMP_HV.asStack()},
                {4, GTItems.ELECTRIC_PUMP_EV.asStack()},
                {5, GTItems.ELECTRIC_PUMP_IV.asStack()},
                {6, GTItems.ELECTRIC_PUMP_LuV.asStack()},
                {7, GTItems.ELECTRIC_PUMP_ZPM.asStack()},
                {8, GTItems.ELECTRIC_PUMP_UV.asStack()},
                {9, GTItems.ELECTRIC_PUMP_UHV.asStack()},
                {10, GTItems.ELECTRIC_PUMP_UEV.asStack()},
                {11, GTItems.ELECTRIC_PUMP_UIV.asStack()},
                {12, GTItems.ELECTRIC_PUMP_UXV.asStack()},
                {13, GTItems.ELECTRIC_PUMP_OpV.asStack()},
                {14, EVItems.electric_pump_max.asStack()},
                {FALLBACK, GTItems.ELECTRIC_PUMP_UV.asStack()},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));


        CONVEYOR = new Component(Stream.of(new Object[][] {

                { 1, GTItems.CONVEYOR_MODULE_LV.asStack() },
                { 2, GTItems.CONVEYOR_MODULE_MV.asStack() },
                { 3, GTItems.CONVEYOR_MODULE_HV.asStack() },
                { 4, GTItems.CONVEYOR_MODULE_EV.asStack() },
                { 5, GTItems.CONVEYOR_MODULE_IV.asStack() },
                { 6, GTItems.CONVEYOR_MODULE_LuV.asStack() },
                { 7, GTItems.CONVEYOR_MODULE_ZPM.asStack() },
                { 8, GTItems.CONVEYOR_MODULE_UV.asStack() },
                { 9, GTItems.CONVEYOR_MODULE_UHV.asStack() },
                { 10, GTItems.CONVEYOR_MODULE_UEV.asStack() },
                { 11, GTItems.CONVEYOR_MODULE_UIV.asStack() },
                { 12, GTItems.CONVEYOR_MODULE_UXV.asStack() },
                { 13, GTItems.CONVEYOR_MODULE_OpV.asStack() },
                { 14, EVItems.conveyor_module_max.asStack() },
                {FALLBACK, GTItems.CONVEYOR_MODULE_UV.asStack()},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));


        ROBOT_ARM = new Component(Stream.of(new Object[][] {

                { 1, GTItems.ROBOT_ARM_LV.asStack() },
                { 2, GTItems.ROBOT_ARM_MV.asStack() },
                { 3, GTItems.ROBOT_ARM_HV.asStack() },
                { 4, GTItems.ROBOT_ARM_EV.asStack() },
                { 5, GTItems.ROBOT_ARM_IV.asStack() },
                { 6, GTItems.ROBOT_ARM_LuV.asStack() },
                { 7, GTItems.ROBOT_ARM_ZPM.asStack() },
                { 8, GTItems.ROBOT_ARM_UV.asStack() },
                { 9, GTItems.ROBOT_ARM_UHV.asStack() },
                { 10, GTItems.ROBOT_ARM_UEV.asStack() },
                { 11, GTItems.ROBOT_ARM_UIV.asStack() },
                { 12, GTItems.ROBOT_ARM_UXV.asStack() },
                { 13, GTItems.ROBOT_ARM_OpV.asStack() },
                { 14, EVItems.ROBOT_ARM_MAX.asStack() },
                { FALLBACK, GTItems.ROBOT_ARM_UV.asStack() },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));


    }
    }


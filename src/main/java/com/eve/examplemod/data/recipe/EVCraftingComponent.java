package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVItems;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.gregtechceu.gtceu.api.GTValues.*;



public class EVCraftingComponent extends CraftingComponent {


    public static void initialiseComponents() {

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
                { 14, EVItems.robot_arm_max.asStack() },
                { FALLBACK, GTItems.ROBOT_ARM_UV.asStack() },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));


    }
    }


package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVItems;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.FALLBACK;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;


public class EVCraftingComponent extends CraftingComponent {

    public static Component BATTERY;
    public static Component GEAR;
    public static Component SECONDARY_CABLE;
    public static Component SECONDARY_CABLE_2x;
    public static Component SECONDARY_CABLE_4x;
    public static Component SECONDARY_CABLE_8x;
    public static Component CABLE;
    public static Component CABLE_8x;
    public static Component CABLE_16x;


    public static void initialiseComponents() {


        BATTERY = new Component(Stream.of(new Object[][]{

                {0, CustomTags.ULV_BATTERIES},
                {1, CustomTags.LV_BATTERIES},
                {2, CustomTags.MV_BATTERIES},
                {3, CustomTags.HV_BATTERIES},
                {4, CustomTags.EV_BATTERIES},
                {5, CustomTags.IV_BATTERIES},
                {6, CustomTags.LuV_BATTERIES},
                {7, CustomTags.ZPM_BATTERIES},
                {8, CustomTags.UV_BATTERIES},
                {9, CustomTags.UHV_BATTERIES},
//                { 10, CustomTags.UEV_BATT },
//                { 11, CustomTags.UIV_CIRCUITS },
//                { 12, CustomTags.UXV_CIRCUITS },
//                { 13, CustomTags.OpV_CIRCUITS },
//                { 14, CustomTags.MAX_BATTERIES },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        GEAR = new Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(TagPrefix.gear, GTMaterials.WroughtIron)},
                {1, new UnificationEntry(TagPrefix.gear, GTMaterials.Steel)},
                {2, new UnificationEntry(TagPrefix.gear, GTMaterials.Aluminium)},
                {3, new UnificationEntry(TagPrefix.gear, GTMaterials.StainlessSteel)},
                {4, new UnificationEntry(TagPrefix.gear, GTMaterials.Titanium)},
                {5, new UnificationEntry(TagPrefix.gear, GTMaterials.TungstenSteel)},
                {6, new UnificationEntry(TagPrefix.gear, GTMaterials.RhodiumPlatedPalladium)},
                {7, new UnificationEntry(TagPrefix.gear, GTMaterials.NaquadahAlloy)},
                {8, new UnificationEntry(TagPrefix.gear, GTMaterials.Darmstadtium)},
                {9, new UnificationEntry(TagPrefix.gear, GTMaterials.Neutronium)},
                {FALLBACK, new UnificationEntry(TagPrefix.gear, GTMaterials.Neutronium)},

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PUMP = new Component(Stream.of(new Object[][]{
                {1, EVItems.ELECTRIC_PUMP_ULV.asStack()},
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
                {14, EVItems.ELECTRIC_PUMP_MAX.asStack()},
                {FALLBACK, GTItems.ELECTRIC_PUMP_UV.asStack()},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));


        CONVEYOR = new Component(Stream.of(new Object[][]{
                {0, EVItems.CONVEYOR_MODULE_ULV.asStack()},
                {1, GTItems.CONVEYOR_MODULE_LV.asStack()},
                {2, GTItems.CONVEYOR_MODULE_MV.asStack()},
                {3, GTItems.CONVEYOR_MODULE_HV.asStack()},
                {4, GTItems.CONVEYOR_MODULE_EV.asStack()},
                {5, GTItems.CONVEYOR_MODULE_IV.asStack()},
                {6, GTItems.CONVEYOR_MODULE_LuV.asStack()},
                {7, GTItems.CONVEYOR_MODULE_ZPM.asStack()},
                {8, GTItems.CONVEYOR_MODULE_UV.asStack()},
                {9, GTItems.CONVEYOR_MODULE_UHV.asStack()},
                {10, GTItems.CONVEYOR_MODULE_UEV.asStack()},
                {11, GTItems.CONVEYOR_MODULE_UIV.asStack()},
                {12, GTItems.CONVEYOR_MODULE_UXV.asStack()},
                {13, GTItems.CONVEYOR_MODULE_OpV.asStack()},
                {14, EVItems.CONVEYOR_MODULE_MAX.asStack()},
                {FALLBACK, GTItems.CONVEYOR_MODULE_UV.asStack()},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));


//        ROBOT_ARM = new Component(Stream.of(new Object[][] {
//
//                { 1, GTItems.ROBOT_ARM_LV.asStack() },
//                { 2, GTItems.ROBOT_ARM_MV.asStack() },
//                { 3, GTItems.ROBOT_ARM_HV.asStack() },
//                { 4, GTItems.ROBOT_ARM_EV.asStack() },
//                { 5, GTItems.ROBOT_ARM_IV.asStack() },
//                { 6, GTItems.ROBOT_ARM_LuV.asStack() },
//                { 7, GTItems.ROBOT_ARM_ZPM.asStack() },
//                { 8, GTItems.ROBOT_ARM_UV.asStack() },
//                { 9, GTItems.ROBOT_ARM_UHV.asStack() },
//                { 10, GTItems.ROBOT_ARM_UEV.asStack() },
//                { 11, GTItems.ROBOT_ARM_UIV.asStack() },
//                { 12, GTItems.ROBOT_ARM_UXV.asStack() },
//                { 13, GTItems.ROBOT_ARM_OpV.asStack() },
//                { 14, EVItems.ROBOT_ARM_MAX.asStack() },
//                { FALLBACK, GTItems.ROBOT_ARM_UV.asStack() },
//        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        SECONDARY_CABLE = new Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(TagPrefix.cableGtSingle, Lead)},
                {1, new UnificationEntry(TagPrefix.cableGtSingle, Nickel)},
                {2, new UnificationEntry(TagPrefix.cableGtSingle, Iron)},
                {3, new UnificationEntry(TagPrefix.cableGtSingle, Silver)},
                {4, new UnificationEntry(TagPrefix.cableGtSingle, Steel)},
                {5, new UnificationEntry(TagPrefix.cableGtSingle, Tungsten)},
                {6, new UnificationEntry(TagPrefix.cableGtSingle, Osmium)},
                {7, new UnificationEntry(TagPrefix.cableGtSingle, Naquadah)},
                {8, new UnificationEntry(TagPrefix.cableGtSingle, Duranium)},
                {9, new UnificationEntry(TagPrefix.cableGtSingle, AbyssalAlloy)},
                {10, new UnificationEntry(TagPrefix.cableGtSingle, TitanSteel)},
                {11, new UnificationEntry(TagPrefix.cableGtSingle, BlackTitanium)},
                {12, new UnificationEntry(TagPrefix.cableGtSingle, Vibranium)},
                {13, new UnificationEntry(TagPrefix.cableGtSingle, Lead)},
                {FALLBACK, new UnificationEntry(TagPrefix.cableGtSingle, BlackTitanium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        SECONDARY_CABLE_2x = new Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(TagPrefix.cableGtDouble, Lead)},
                {1, new UnificationEntry(TagPrefix.cableGtDouble, Nickel)},
                {2, new UnificationEntry(TagPrefix.cableGtDouble, Iron)},
                {3, new UnificationEntry(TagPrefix.cableGtDouble, Silver)},
                {4, new UnificationEntry(TagPrefix.cableGtDouble, Steel)},
                {5, new UnificationEntry(TagPrefix.cableGtDouble, Tungsten)},
                {6, new UnificationEntry(TagPrefix.cableGtDouble, Osmium)},
                {7, new UnificationEntry(TagPrefix.cableGtDouble, Naquadah)},
                {8, new UnificationEntry(TagPrefix.cableGtDouble, Duranium)},
                {9, new UnificationEntry(TagPrefix.cableGtDouble, AbyssalAlloy)},
                {10, new UnificationEntry(TagPrefix.cableGtDouble, TitanSteel)},
                {11, new UnificationEntry(TagPrefix.cableGtDouble, BlackTitanium)},
                {12, new UnificationEntry(TagPrefix.cableGtDouble, Vibranium)},
                {13, new UnificationEntry(TagPrefix.cableGtDouble, Lead)},
                {FALLBACK, new UnificationEntry(TagPrefix.cableGtDouble, BlackTitanium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        SECONDARY_CABLE_4x = new Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(TagPrefix.cableGtQuadruple, Lead)},
                {1, new UnificationEntry(TagPrefix.cableGtQuadruple, Nickel)},
                {2, new UnificationEntry(TagPrefix.cableGtQuadruple, Iron)},
                {3, new UnificationEntry(TagPrefix.cableGtQuadruple, Silver)},
                {4, new UnificationEntry(TagPrefix.cableGtQuadruple, Steel)},
                {5, new UnificationEntry(TagPrefix.cableGtQuadruple, Tungsten)},
                {6, new UnificationEntry(TagPrefix.cableGtQuadruple, Osmium)},
                {7, new UnificationEntry(TagPrefix.cableGtQuadruple, Naquadah)},
                {8, new UnificationEntry(TagPrefix.cableGtQuadruple, Duranium)},
                {9, new UnificationEntry(TagPrefix.cableGtQuadruple, AbyssalAlloy)},
                {10, new UnificationEntry(TagPrefix.cableGtQuadruple, TitanSteel)},
                {11, new UnificationEntry(TagPrefix.cableGtQuadruple, BlackTitanium)},
                {12, new UnificationEntry(TagPrefix.cableGtQuadruple, Vibranium)},
                {13, new UnificationEntry(TagPrefix.cableGtQuadruple, Lead)},
                {FALLBACK, new UnificationEntry(TagPrefix.cableGtQuadruple, BlackTitanium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        SECONDARY_CABLE_8x = new Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(TagPrefix.cableGtOctal, Lead)},
                {1, new UnificationEntry(TagPrefix.cableGtOctal, Nickel)},
                {2, new UnificationEntry(TagPrefix.cableGtOctal, Iron)},
                {3, new UnificationEntry(TagPrefix.cableGtOctal, Silver)},
                {4, new UnificationEntry(TagPrefix.cableGtOctal, Steel)},
                {5, new UnificationEntry(TagPrefix.cableGtOctal, Tungsten)},
                {6, new UnificationEntry(TagPrefix.cableGtOctal, Osmium)},
                {7, new UnificationEntry(TagPrefix.cableGtOctal, Naquadah)},
                {8, new UnificationEntry(TagPrefix.cableGtOctal, Duranium)},
                {9, new UnificationEntry(TagPrefix.cableGtOctal, AbyssalAlloy)},
                {10, new UnificationEntry(TagPrefix.cableGtOctal, TitanSteel)},
                {11, new UnificationEntry(TagPrefix.cableGtOctal, BlackTitanium)},
                {12, new UnificationEntry(TagPrefix.cableGtOctal, Vibranium)},
                {13, new UnificationEntry(TagPrefix.cableGtOctal, Lead)},
                {FALLBACK, new UnificationEntry(TagPrefix.cableGtOctal, BlackTitanium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE = new Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(TagPrefix.cableGtSingle, RedAlloy)},
                {1, new UnificationEntry(TagPrefix.cableGtSingle, Tin)},
                {2, new UnificationEntry(TagPrefix.cableGtSingle, Copper)},
                {3, new UnificationEntry(TagPrefix.cableGtSingle, Gold)},
                {4, new UnificationEntry(TagPrefix.cableGtSingle, Aluminium)},
                {5, new UnificationEntry(TagPrefix.cableGtSingle, Platinum)},
                {6, new UnificationEntry(TagPrefix.cableGtSingle, NiobiumTitanium)},
                {7, new UnificationEntry(TagPrefix.cableGtSingle, VanadiumGallium)},
                {8, new UnificationEntry(TagPrefix.cableGtSingle, YttriumBariumCuprate)},
                {9, new UnificationEntry(TagPrefix.cableGtSingle, TitaniumTungstenCarbide)},
                {10, new UnificationEntry(TagPrefix.cableGtSingle, Pikyonium)},
                {11, new UnificationEntry(TagPrefix.cableGtSingle, Cinobite)},
                {12, new UnificationEntry(TagPrefix.cableGtSingle, NaquadriaticTaranium)},
                {13, new UnificationEntry(TagPrefix.cableGtSingle, Neutronium)},
                {FALLBACK, new UnificationEntry(TagPrefix.cableGtSingle, Neutronium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_16x = new Component(Stream.of(new Object[][]{
                {0, new UnificationEntry(TagPrefix.cableGtHex, RedAlloy)},
                {1, new UnificationEntry(TagPrefix.cableGtHex, Tin)},
                {2, new UnificationEntry(TagPrefix.cableGtHex, Copper)},
                {3, new UnificationEntry(TagPrefix.cableGtHex, Gold)},
                {4, new UnificationEntry(TagPrefix.cableGtHex, Aluminium)},
                {5, new UnificationEntry(TagPrefix.cableGtHex, Platinum)},
                {6, new UnificationEntry(TagPrefix.cableGtHex, NiobiumTitanium)},
                {7, new UnificationEntry(TagPrefix.cableGtHex, VanadiumGallium)},
                {8, new UnificationEntry(TagPrefix.cableGtHex, YttriumBariumCuprate)},
                {9, new UnificationEntry(TagPrefix.cableGtHex, TitaniumTungstenCarbide)},
                {10, new UnificationEntry(TagPrefix.cableGtHex, Pikyonium)},
                {11, new UnificationEntry(TagPrefix.cableGtHex, Cinobite)},
                {12, new UnificationEntry(TagPrefix.cableGtHex, NaquadriaticTaranium)},
                {13, new UnificationEntry(TagPrefix.cableGtHex, Neutronium)},
                {FALLBACK, new UnificationEntry(TagPrefix.cableGtHex, Neutronium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_8x = new Component(Stream.of(new Object[][]{
                {0, new UnificationEntry(TagPrefix.cableGtOctal, RedAlloy)},
                {1, new UnificationEntry(TagPrefix.cableGtOctal, Tin)},
                {2, new UnificationEntry(TagPrefix.cableGtOctal, Copper)},
                {3, new UnificationEntry(TagPrefix.cableGtOctal, Gold)},
                {4, new UnificationEntry(TagPrefix.cableGtOctal, Aluminium)},
                {5, new UnificationEntry(TagPrefix.cableGtOctal, Platinum)},
                {6, new UnificationEntry(TagPrefix.cableGtOctal, NiobiumTitanium)},
                {7, new UnificationEntry(TagPrefix.cableGtOctal, VanadiumGallium)},
                {8, new UnificationEntry(TagPrefix.cableGtOctal, YttriumBariumCuprate)},
                {9, new UnificationEntry(TagPrefix.cableGtOctal, TitaniumTungstenCarbide)},
                {10, new UnificationEntry(TagPrefix.cableGtOctal, Pikyonium)},
                {11, new UnificationEntry(TagPrefix.cableGtOctal, Cinobite)},
                {12, new UnificationEntry(TagPrefix.cableGtOctal, NaquadriaticTaranium)},
                {13, new UnificationEntry(TagPrefix.cableGtOctal, Neutronium)},
                {FALLBACK, new UnificationEntry(TagPrefix.cableGtOctal, Neutronium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        ROBOT_ARM = new Component(Stream.of(new Object[][]{
                {0, EVItems.ROBOT_ARM_ULV.asStack()},
                {1, GTItems.ROBOT_ARM_LV.asStack()},
                {2, GTItems.ROBOT_ARM_MV.asStack()},
                {3, GTItems.ROBOT_ARM_HV.asStack()},
                {4, GTItems.ROBOT_ARM_EV.asStack()},
                {5, GTItems.ROBOT_ARM_IV.asStack()},
                {6, GTItems.ROBOT_ARM_LuV.asStack()},
                {7, GTItems.ROBOT_ARM_ZPM.asStack()},
                {8, GTItems.ROBOT_ARM_UV.asStack()},
                {9, GTItems.ROBOT_ARM_UHV.asStack()},
                {10, GTItems.ROBOT_ARM_UEV.asStack()},
                {11, GTItems.ROBOT_ARM_UIV.asStack()},
                {12, GTItems.ROBOT_ARM_UXV.asStack()},
                {13, GTItems.ROBOT_ARM_OpV.asStack()},
                {14, EVItems.ROBOT_ARM_MAX.asStack()},
                {FALLBACK, GTItems.ROBOT_ARM_UV.asStack()},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }


}



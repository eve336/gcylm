package com.eve.examplemod.common.data;

import com.eve.examplemod.api.registries.EVRegistries;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import static com.gregtechceu.gtceu.common.data.GTModels.overrideModel;


@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class EVItems {

    public static ItemEntry<Item> SMD_CAPACITOR_REFINED = EVRegistries.REGISTRATE.item("smd_capacitor_refined", Item::new)
            .register();


    public static ItemEntry<Item> MICA_SHEET = EVRegistries.REGISTRATE.item("mica_sheet", Item::new)
            .register();

    public static ItemEntry<Item> MICA_INSULATOR_SHEET = EVRegistries.REGISTRATE.item("mica_insulator_sheet", Item::new)
            .register();

    public static ItemEntry<Item> MICA_INSULATOR_FOIL = EVRegistries.REGISTRATE.item("mica_insulator_foil", Item::new)
            .register();

    public static ItemEntry<Item> REFINED_PROCESSOR = EVRegistries.REGISTRATE.item("refined_processor", Item::new)
            .tag(CustomTags.LV_CIRCUITS)
            .register();

    public static ItemEntry<Item> REFINED_ASSEMBLY = EVRegistries.REGISTRATE.item("refined_assembly", Item::new)
            .tag(CustomTags.MV_CIRCUITS)
            .register();

    public static ItemEntry<Item> REFINED_COMPUTER = EVRegistries.REGISTRATE.item("refined_computer", Item::new)
            .tag(CustomTags.HV_CIRCUITS)
            .register();

    public static ItemEntry<Item> REFINED_MAINFRAME = EVRegistries.REGISTRATE.item("refined_mainframe", Item::new)
            .tag(CustomTags.EV_CIRCUITS)
            .register();


    public static ItemEntry<Item> NANOSILICON_CATHODE = EVRegistries.REGISTRATE.item("NANOSILICON_CATHODE".toLowerCase(), Item::new).register();


    public static ItemEntry<Item> ARAM = EVRegistries.REGISTRATE.item("aram", Item::new).register();
    public static ItemEntry<Item> ARAM_WAFER = EVRegistries.REGISTRATE.item("aram_wafer", Item::new).register();

    public static ItemEntry<Item> KAPTON_BOARD = EVRegistries.REGISTRATE.item("kapton_board", Item::new).register();
    public static ItemEntry<Item> KAPTON_CIRCUIT_BOARD = EVRegistries.REGISTRATE.item("kapton_circuit_board", Item::new).register();

    public static ItemEntry<Item> COSMIC_MESH = EVRegistries.REGISTRATE.item("cosmic_mesh", Item::new).register();
    public static ItemEntry<Item> COSMIC_FABRIC = EVRegistries.REGISTRATE.item("cosmic_fabric", Item::new).register();

    // Already exist in Gt
    // public static ItemEntry<Item> UHPIC = EVRegistries.REGISTRATE.item("uhpic", Item::new).register();
    // public static ItemEntry<Item> UHPIC_WAFER = EVRegistries.REGISTRATE.item("uhpic_wafer", Item::new).register();


    // public static ItemEntry<Item> HASOC = EVRegistries.REGISTRATE.item("hasoc", Item::new).register();
    // public static ItemEntry<Item> HASOC_WAFER = EVRegistries.REGISTRATE.item("hasoc_wafer", Item::new).register();

    public static ItemEntry<Item> UHASOC = EVRegistries.REGISTRATE.item("uhasoc", Item::new).register();
    public static ItemEntry<Item> UHASOC_WAFER = EVRegistries.REGISTRATE.item("uhasoc_wafer".toLowerCase(), Item::new).register();

    public static ItemEntry<Item> WAFER_RUTHERFORDIUM = EVRegistries.REGISTRATE.item("rutherfordium_wafer", Item::new).register();
    public static ItemEntry<Item> WAFER_DUBNIUM = EVRegistries.REGISTRATE.item("dubnium_wafer", Item::new).register();

    public static ItemEntry<Item> BOULE_RUTHERFORDIUM = EVRegistries.REGISTRATE.item("rutherfordium_boule", Item::new).register();
    public static ItemEntry<Item> BOULE_DUBNIUM = EVRegistries.REGISTRATE.item("dubnium_boule", Item::new).register();


    public static ItemEntry<Item> BATTERY_NIMH_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_NIMH_EMPTY".toLowerCase(), Item::new).register();


    public static ItemEntry<ComponentItem> BATTERY_NIMH = EVRegistries.REGISTRATE
            .item("BATTERY_NIMH".toLowerCase(), ComponentItem::create)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();

    public static ItemEntry<Item> BATTERY_SMALL_LITHIUM_ION_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_SMALL_LITHIUM_ION_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_SMALL_LITHIUM_ION = EVRegistries.REGISTRATE.item("BATTERY_SMALL_LITHIUM_ION".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_MEDIUM_LITHIUM_ION_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_MEDIUM_LITHIUM_ION_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_MEDIUM_LITHIUM_ION = EVRegistries.REGISTRATE.item("BATTERY_MEDIUM_LITHIUM_ION".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_LARGE_LITHIUM_ION_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_LARGE_LITHIUM_ION_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_LARGE_LITHIUM_ION = EVRegistries.REGISTRATE.item("BATTERY_LARGE_LITHIUM_ION".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_SMALL_LIS_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_SMALL_LIS_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_SMALL_LIS = EVRegistries.REGISTRATE.item("BATTERY_SMALL_LIS".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_MEDIUM_LIS_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_MEDIUM_LIS_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_MEDIUM_LIS = EVRegistries.REGISTRATE.item("BATTERY_MEDIUM_LIS".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_LARGE_LIS_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_LARGE_LIS_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_LARGE_LIS = EVRegistries.REGISTRATE.item("BATTERY_LARGE_LIS".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_SMALL_FLUORIDE_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_SMALL_FLUORIDE_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_SMALL_FLUORIDE = EVRegistries.REGISTRATE.item("BATTERY_SMALL_FLUORIDE".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_MEDIUM_FLUORIDE_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_MEDIUM_FLUORIDE_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_MEDIUM_FLUORIDE = EVRegistries.REGISTRATE.item("BATTERY_MEDIUM_FLUORIDE".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();
    public static ItemEntry<Item> BATTERY_LARGE_FLUORIDE_EMPTY = EVRegistries.REGISTRATE.item("BATTERY_LARGE_FLUORIDE_EMPTY".toLowerCase(), Item::new).register();
    public static ItemEntry<Item> BATTERY_LARGE_FLUORIDE = EVRegistries.REGISTRATE.item("BATTERY_LARGE_FLUORIDE".toLowerCase(), Item::new)
            .model(overrideModel(GTCEu.id("battery"), 8))
            .register();


    public static ItemEntry<Item> FULLERENE_POLYMER_MATRIX_SOFT_TUBING = EVRegistries.REGISTRATE.item("fullerene_polymer_matrix_soft_tubing", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> FULLERENE_POLYMER_MATRIX_FINE_TUBING = EVRegistries.REGISTRATE.item("fullerene_polymer_matrix_fine_tubing", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> X_RAY_WAVEGUIDE = EVRegistries.REGISTRATE.item("x_ray_waveguide", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MICROFOCUS_X_RAY_TUBE = EVRegistries.REGISTRATE.item("microfocus_x_ray_tube", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> X_RAY_MIRROR_PLATE = EVRegistries.REGISTRATE.item("x_ray_mirror_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> UNTREATED_EXOTIC_WAFER = EVRegistries.REGISTRATE.item("untreated_exotic_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> EXOTIC_WAFER = EVRegistries.REGISTRATE.item("exotic_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> EXOTIC_CHIP = EVRegistries.REGISTRATE.item("exotic_chip", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> EXCITATION_MAINTAINER = EVRegistries.REGISTRATE.item("excitation_maintainer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CRYOGENIC_INTERFACE = EVRegistries.REGISTRATE.item("cryogenic_interface", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> RYDBERG_SPINORIAL_ASSEMBLY = EVRegistries.REGISTRATE.item("rydberg_spinorial_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> X_RAY_LASER = EVRegistries.REGISTRATE.item("x_ray_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> EXOTIC_PROCESSING_CORE = EVRegistries.REGISTRATE.item("exotic_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PROTONATED_FULLERENE_SIEVING_MATRIX = EVRegistries.REGISTRATE.item("protonated_fullerene_sieving_matrix", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SATURATED_FULLERENE_SIEVING_MATRIX = EVRegistries.REGISTRATE.item("saturated_fullerene_sieving_matrix", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static ItemEntry<Item> SMD_CAPACITOR_MICRO = EVRegistries.REGISTRATE.item("smd_capacitor_micro", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_MICRO = EVRegistries.REGISTRATE.item("smd_resistor_micro", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_MICRO = EVRegistries.REGISTRATE.item("smd_diode_micro", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_MICRO = EVRegistries.REGISTRATE.item("smd_transistor_micro", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_NANO = EVRegistries.REGISTRATE.item("smd_capacitor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_QUANTUM = EVRegistries.REGISTRATE.item("smd_capacitor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_CRYSTAL = EVRegistries.REGISTRATE.item("smd_capacitor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_WETWARE = EVRegistries.REGISTRATE.item("smd_capacitor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_BIOWARE = EVRegistries.REGISTRATE.item("smd_capacitor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_OPTICAL = EVRegistries.REGISTRATE.item("smd_capacitor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_EXOTIC = EVRegistries.REGISTRATE.item("smd_capacitor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_COSMIC = EVRegistries.REGISTRATE.item("smd_capacitor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_CAPACITOR_SUPRACAUSAL = EVRegistries.REGISTRATE.item("smd_capacitor_supracasual", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_REFINED = EVRegistries.REGISTRATE.item("smd_resistor_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_NANO = EVRegistries.REGISTRATE.item("smd_resistor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_QUANTUM = EVRegistries.REGISTRATE.item("smd_resistor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_CRYSTAL = EVRegistries.REGISTRATE.item("smd_resistor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_WETWARE = EVRegistries.REGISTRATE.item("smd_resistor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_BIOWARE = EVRegistries.REGISTRATE.item("smd_resistor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_OPTICAL = EVRegistries.REGISTRATE.item("smd_resistor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_EXOTIC = EVRegistries.REGISTRATE.item("smd_resistor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_COSMIC = EVRegistries.REGISTRATE.item("smd_resistor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_RESISTOR_SUPRACAUSAL = EVRegistries.REGISTRATE.item("smd_resistor_supracasual", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_REFINED = EVRegistries.REGISTRATE.item("smd_diode_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_NANO = EVRegistries.REGISTRATE.item("smd_diode_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_QUANTUM = EVRegistries.REGISTRATE.item("smd_diode_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_CRYSTAL = EVRegistries.REGISTRATE.item("smd_diode_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_WETWARE = EVRegistries.REGISTRATE.item("smd_diode_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_BIOWARE = EVRegistries.REGISTRATE.item("smd_diode_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_OPTICAL = EVRegistries.REGISTRATE.item("smd_diode_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_EXOTIC = EVRegistries.REGISTRATE.item("smd_diode_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_COSMIC = EVRegistries.REGISTRATE.item("smd_diode_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_DIODE_SUPRACAUSAL = EVRegistries.REGISTRATE.item("smd_diode_supracasual", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_REFINED = EVRegistries.REGISTRATE.item("smd_transistor_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_NANO = EVRegistries.REGISTRATE.item("smd_transistor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_QUANTUM = EVRegistries.REGISTRATE.item("smd_transistor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_CRYSTAL = EVRegistries.REGISTRATE.item("smd_transistor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_WETWARE = EVRegistries.REGISTRATE.item("smd_transistor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_BIOWARE = EVRegistries.REGISTRATE.item("smd_transistor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_OPTICAL = EVRegistries.REGISTRATE.item("smd_transistor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_EXOTIC = EVRegistries.REGISTRATE.item("smd_transistor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_COSMIC = EVRegistries.REGISTRATE.item("smd_transistor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SMD_TRANSISTOR_SUPRACAUSAL = EVRegistries.REGISTRATE.item("smd_transistor_supracasual", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();


    public static ItemEntry<Item> BIOWARE_PROCESSOR = EVRegistries.REGISTRATE.item("bioware_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.ZPM_CIRCUITS)
            .register();
    public static ItemEntry<Item> BIOWARE_ASSEMBLY = EVRegistries.REGISTRATE.item("bioware_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UV_CIRCUITS)
            .register();
    public static ItemEntry<Item> BIOWARE_COMPUTER = EVRegistries.REGISTRATE.item("bioware_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static ItemEntry<Item> BIOWARE_MAINFRAME = EVRegistries.REGISTRATE.item("bioware_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UEV_CIRCUITS)
            .register();

    public static ItemEntry<Item> OPTICAL_PROCESSOR = EVRegistries.REGISTRATE.item("optical_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UV_CIRCUITS)
            .register();
    public static ItemEntry<Item> OPTICAL_ASSEMBLY = EVRegistries.REGISTRATE.item("optical_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static ItemEntry<Item> OPTICAL_COMPUTER = EVRegistries.REGISTRATE.item("optical_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static ItemEntry<Item> OPTICAL_MAINFRAME = EVRegistries.REGISTRATE.item("optical_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UIV_CIRCUITS)
            .register();

    public static ItemEntry<Item> EXOTIC_PROCESSOR = EVRegistries.REGISTRATE.item("exotic_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UHV_CIRCUITS)
            .register();
    public static ItemEntry<Item> EXOTIC_ASSEMBLY = EVRegistries.REGISTRATE.item("exotic_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static ItemEntry<Item> EXOTIC_COMPUTER = EVRegistries.REGISTRATE.item("exotic_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static ItemEntry<Item> EXOTIC_MAINFRAME = EVRegistries.REGISTRATE.item("exotic_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UXV_CIRCUITS)
            .register();

    public static ItemEntry<Item> COSMIC_PROCESSOR = EVRegistries.REGISTRATE.item("cosmic_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UEV_CIRCUITS)
            .register();
    public static ItemEntry<Item> COSMIC_ASSEMBLY = EVRegistries.REGISTRATE.item("cosmic_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static ItemEntry<Item> COSMIC_COMPUTER = EVRegistries.REGISTRATE.item("cosmic_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static ItemEntry<Item> COSMIC_MAINFRAME = EVRegistries.REGISTRATE.item("cosmic_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.OpV_CIRCUITS)
            .register();

    public static ItemEntry<Item> SUPRACAUSAL_PROCESSOR = EVRegistries.REGISTRATE.item("supracasual_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UIV_CIRCUITS)
            .register();
    public static ItemEntry<Item> SUPRACAUSAL_ASSEMBLY = EVRegistries.REGISTRATE.item("supracasual_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.UXV_CIRCUITS)
            .register();
    public static ItemEntry<Item> SUPRACAUSAL_COMPUTER = EVRegistries.REGISTRATE.item("supracasual_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.OpV_CIRCUITS)
            .register();
    public static ItemEntry<Item> SUPRACAUSAL_MAINFRAME = EVRegistries.REGISTRATE.item("supracasual_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey())
            .tag(CustomTags.MAX_CIRCUITS)
            .register();

    public static ItemEntry<Item> UNSTABLE_STAR = EVRegistries.REGISTRATE.item("unstable_star", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static ItemEntry<Item> ELECTRIC_PISTON_MAX = EVRegistries.REGISTRATE.item("electric_piston_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> EMITTER_MAX = EVRegistries.REGISTRATE.item("emitter_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> FIELD_GENERATOR_MAX = EVRegistries.REGISTRATE.item("field_generator_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MAX_ELECTRIC_MOTOR = EVRegistries.REGISTRATE.item("max_electric_motor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();


    public static ItemEntry<Item> ELECTRIC_PISTON_ULV = EVRegistries.REGISTRATE.item("ulv_electric_piston", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ELECTRIC_MOTOR_ULV = EVRegistries.REGISTRATE.item("ulv_electric_motor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static ItemEntry<ComponentItem> conveyor_module_max = EVRegistries.REGISTRATE.item("conveyor_module_max", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.CONVEYOR[GTValues.MAX])))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .lang("Max Conveyor Module")
            .register();

    public static ItemEntry<ComponentItem> ROBOT_ARM_MAX = EVRegistries.REGISTRATE.item("robot_arm_max", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.ROBOT_ARM[GTValues.MAX])))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .lang("Max Robot Arm")
            .register();


    public static ItemEntry<ComponentItem> electric_pump_max = EVRegistries.REGISTRATE.item("electric_pump_max", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.PUMP[GTValues.MAX])))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate",
                        1280 * 64 * 64 * 4 / 20));
            })))
            .lang("Max Electric Pump")
            .register();

    public static ItemEntry<ComponentItem> CONVEYOR_MODULE_ULV = EVRegistries.REGISTRATE.item("ulv_conveyor_module", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.CONVEYOR[0])))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate", 8));
            })))
            .lang("ULV Conveyor Module")
            .register();

    public static ItemEntry<ComponentItem> ROBOT_ARM_ULV = EVRegistries.REGISTRATE.item("ulv_robot_arm", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.ROBOT_ARM[0])))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate", 8));
            })))
            .lang("ULV Robot Arm")
            .register();


    public static ItemEntry<ComponentItem> ELECTRIC_PUMP_ULV = EVRegistries.REGISTRATE.item("ulv_electric_pump", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.PUMP[1])))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate",
                        64));
            })))
            .lang("ULV Electric Pump")
            .register();


    public static ItemEntry<ComponentItem> ULV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("ulv_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[0])))
            .register();

    public static ItemEntry<ComponentItem> LV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("lv_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[1])))
            .register();

    public static ItemEntry<ComponentItem> MV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("mv_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[2])))
            .register();

    public static ItemEntry<ComponentItem> HV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("hv_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[3])))
            .register();

    public static ItemEntry<ComponentItem> EV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("ev_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[4])))
            .register();

    public static ItemEntry<ComponentItem> IV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("iv_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[5])))
            .register();

    public static ItemEntry<ComponentItem> LuV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("luv_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[6])))
            .register();

    public static ItemEntry<ComponentItem> ZPM_SOLAR_PANEL = EVRegistries.REGISTRATE.item("zpm_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[7])))
            .register();

    public static ItemEntry<ComponentItem> UV_SOLAR_PANEL = EVRegistries.REGISTRATE.item("uv_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[8])))
            .register();

    public static ItemEntry<ComponentItem> MAX_SOLAR_PANEL = EVRegistries.REGISTRATE.item("max_solar_panel", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.EVSOLAR[GTValues.MAX])))
            .register();

    public static ItemEntry<Item> SENSOR_MAX = EVRegistries.REGISTRATE.item("sensor_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ULTRASONIC_HOMOGENIZER = EVRegistries.REGISTRATE.item("ultrasonic_homogenizer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> STERILIZED_PETRI_DISH = EVRegistries.REGISTRATE.item("sterilized_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CONTAMINATED_PETRI_DISH = EVRegistries.REGISTRATE.item("contaminated_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ELECTRICALLY_WIRED_PETRI_DISH = EVRegistries.REGISTRATE.item("electrically_wired_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CLEAN_CULTURE = EVRegistries.REGISTRATE.item("clean_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PIEZOELECTRIC_CRYSTAL = EVRegistries.REGISTRATE.item("piezoelectric_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NEURO_SUPPORT_UNIT = EVRegistries.REGISTRATE.item("neuro_support_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CYBER_PROCESSING_UNIT = EVRegistries.REGISTRATE.item("cyber_processing_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SHEWANELLA_CULTURE = EVRegistries.REGISTRATE.item("shewanella_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> STREPTOCOCCUS_CULTURE = EVRegistries.REGISTRATE.item("streptococcus_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ESCHERICHIA_CULTURE = EVRegistries.REGISTRATE.item("escherichia_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BIFIDOBACTERIUM_CULTURE = EVRegistries.REGISTRATE.item("bifidobacterium_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BREVIBACTERIUM_CULTURE = EVRegistries.REGISTRATE.item("brevibacterium_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CUPRIVADUS_CULTURE = EVRegistries.REGISTRATE.item("cuprivadus_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PLATE_FIELD_SHAPE = EVRegistries.REGISTRATE.item("plate_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> INGOT_FIELD_SHAPE = EVRegistries.REGISTRATE.item("ingot_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> WIRE_FIELD_SHAPE = EVRegistries.REGISTRATE.item("wire_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ROD_FIELD_SHAPE = EVRegistries.REGISTRATE.item("rod_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PLASMA_CONTAINMENT_CELL = EVRegistries.REGISTRATE.item("plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> RHENIUM_PLASMA_CONTAINMENT_CELL = EVRegistries.REGISTRATE.item("rhenium_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NEUTRON_PLASMA_CONTAINMENT_CELL = EVRegistries.REGISTRATE.item("neutron_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> DEGENERATE_RHENIUM_PLATE = EVRegistries.REGISTRATE.item("degenerate_rhenium_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> DEGENERATE_RHENIUM_DUST = EVRegistries.REGISTRATE.item("degenerate_rhenium_dust", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ZBLAN = EVRegistries.REGISTRATE.item("zblan", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ZBLAN_INGOT = EVRegistries.REGISTRATE.item("zblan_ingot", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> HOT_ANNEALED_ZBLAN_INGOT = EVRegistries.REGISTRATE.item("hot_annealed_zblan_ingot", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ZBLAN_FIBER = EVRegistries.REGISTRATE.item("zblan_fiber", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ERBIUM_DOPED_ZBLAN = EVRegistries.REGISTRATE.item("erbium_doped_zblan", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CLADDED_OPTICAL_FIBER_CORE = EVRegistries.REGISTRATE.item("cladded_optical_fiber_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ACRYLIC_YARN = EVRegistries.REGISTRATE.item("acrylic_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> RAPIDLY_ROTATING_CRUCIBLE = EVRegistries.REGISTRATE.item("rapidly_rotating_crucible", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> HEAVY_METAL_ABSORBING_YARN = EVRegistries.REGISTRATE.item("heavy_metal_absorbing_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> URANIUM_SATURATED_YARN = EVRegistries.REGISTRATE.item("uranium_saturated_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BORON_RETAINING_YARN = EVRegistries.REGISTRATE.item("boron_retaining_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BORON_SATURATED_YARN = EVRegistries.REGISTRATE.item("boron_saturated_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LITHIUM_SIEVE = EVRegistries.REGISTRATE.item("lithium_sieve", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LITHIUM_SATURATED_LITHIUM_SIEVE = EVRegistries.REGISTRATE.item("lithium_saturated_lithium_sieve", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NANOTOME = EVRegistries.REGISTRATE.item("nanotome", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MEMORY_FOAM_BLOCK = EVRegistries.REGISTRATE.item("memory_foam_block", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LASER_DIODE = EVRegistries.REGISTRATE.item("laser_diode", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LASER_COOLING_UNIT = EVRegistries.REGISTRATE.item("laser_cooling_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MAGNETIC_TRAP = EVRegistries.REGISTRATE.item("magnetic_trap", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> EMPTY_LASER_COOLING_CONTAINER = EVRegistries.REGISTRATE.item("empty_laser_cooling_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BOSE_EINSTEIN_COOLING_CONTAINER = EVRegistries.REGISTRATE.item("bose_einstein_cooling_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ALUMINO_SILICATE_GLASS_TUBE = EVRegistries.REGISTRATE.item("alumino_silicate_glass_tube", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BALLAST = EVRegistries.REGISTRATE.item("ballast", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> UVA_LAMP_CORE = EVRegistries.REGISTRATE.item("uva_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BLUE_LAMP_CORE = EVRegistries.REGISTRATE.item("blue_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> GREEN_LAMP_CORE = EVRegistries.REGISTRATE.item("green_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> RED_LAMP_CORE = EVRegistries.REGISTRATE.item("red_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> WHITE_LAMP_CORE = EVRegistries.REGISTRATE.item("white_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> UVA_HALIDE_LAMP = EVRegistries.REGISTRATE.item("uva_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> BLUE_HALIDE_LAMP = EVRegistries.REGISTRATE.item("blue_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> GREEN_HALIDE_LAMP = EVRegistries.REGISTRATE.item("green_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> RED_HALIDE_LAMP = EVRegistries.REGISTRATE.item("red_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> WHITE_HALIDE_LAMP = EVRegistries.REGISTRATE.item("white_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ACTINIUM_PLASMA_CONTAINMENT_CELL = EVRegistries.REGISTRATE.item("actinium_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NDYAG_BOULE = EVRegistries.REGISTRATE.item("ndyag_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PRHOYLF_BOULE = EVRegistries.REGISTRATE.item("prhoylf_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LUTMYVO_BOULE = EVRegistries.REGISTRATE.item("lutmyvo_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NDYAG_ROD = EVRegistries.REGISTRATE.item("ndyag_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PRHOYLF_ROD = EVRegistries.REGISTRATE.item("prhoylf_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LUTMYVO_ROD = EVRegistries.REGISTRATE.item("lutmyvo_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LOW_FREQUENCY_LASER = EVRegistries.REGISTRATE.item("low_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MEDIUM_FREQUENCY_LASER = EVRegistries.REGISTRATE.item("medium_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> HIGH_FREQUENCY_LASER = EVRegistries.REGISTRATE.item("high_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE = EVRegistries.REGISTRATE.item("periodically_poled_lithium_niobate_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NON_LINEAR_OPTICAL_LENS = EVRegistries.REGISTRATE.item("non_linear_optical_lens", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> HIGHLY_REFLECTIVE_MIRROR = EVRegistries.REGISTRATE.item("highly_reflective_mirror", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ROTATING_TRANSPARENT_SURFACE = EVRegistries.REGISTRATE.item("rotating_transparent_surface", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ELECTRON_SOURCE = EVRegistries.REGISTRATE.item("electron_source", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> OPTICAL_SOC = EVRegistries.REGISTRATE.item("optical_soc", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> OPTICAL_SOC_WAFER = EVRegistries.REGISTRATE.item("optical_soc_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> OPTICAL_PROCESSING_CORE = EVRegistries.REGISTRATE.item("optical_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PEEK_POLYAMIDE_FOIL = EVRegistries.REGISTRATE.item("peek_polyamide_foil", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> INSULATION_WIRE_ASSEMBLY = EVRegistries.REGISTRATE.item("insulation_wire_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NEUTRONIUM_SPHERE = EVRegistries.REGISTRATE.item("neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> TRIPLET_NEUTRONIUM_SPHERE = EVRegistries.REGISTRATE.item("triplet_neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CHARGED_TRIPLET_NEUTRONIUM_SPHERE = EVRegistries.REGISTRATE.item("charged_triplet_neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CONTAINED_REISSNER_NORDSTROM_SINGULARITY = EVRegistries.REGISTRATE.item("contained_reissner_nordstrom_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CONTAINED_KERR_NEWMANN_SINGULARITY = EVRegistries.REGISTRATE.item("contained_kerr_newmann_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CONTAINED_KERR_SINGULARITY = EVRegistries.REGISTRATE.item("contained_kerr_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CONTAINED_HIGH_DENSITY_PROTONIC_MATTER = EVRegistries.REGISTRATE.item("contained_high_density_protonic_matter", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> TIME_DILATION_CONTAINMENT_UNIT = EVRegistries.REGISTRATE.item("time_dilation_containment_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MICROWORMHOLE_GENERATOR = EVRegistries.REGISTRATE.item("microwormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MACROWORMHOLE_GENERATOR = EVRegistries.REGISTRATE.item("macrowormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> STABILIZED_WORMHOLE_GENERATOR = EVRegistries.REGISTRATE.item("stabilized_wormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CONTAINED_EXOTIC_MATTER = EVRegistries.REGISTRATE.item("contained_exotic_matter", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SEPARATION_ELECTROMAGNET = EVRegistries.REGISTRATE.item("separation_electromagnet", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SPHERE_FIELD_SHAPE = EVRegistries.REGISTRATE.item("sphere_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> AEROGRAPHENE = EVRegistries.REGISTRATE.item("aerographene", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SCINTILLATOR_CRYSTAL = EVRegistries.REGISTRATE.item("scintillator_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SCINTILLATOR = EVRegistries.REGISTRATE.item("scintillator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> LEPTON_TRAP_CRYSTAL = EVRegistries.REGISTRATE.item("lepton_trap_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> HASSIUM_SEED_CRYSTAL = EVRegistries.REGISTRATE.item("hassium_seed_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> HASSIUM_BOULE = EVRegistries.REGISTRATE.item("hassium_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> HASSIUM_WAFER = EVRegistries.REGISTRATE.item("hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> COATED_HASSIUM_WAFER = EVRegistries.REGISTRATE.item("coated_hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PHOTOCOATED_HASSIUM_WAFER = EVRegistries.REGISTRATE.item("photocoated_hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> GRATING_LITHOGRAPHY_MASK = EVRegistries.REGISTRATE.item("grating_lithography_mask", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> DIFFRACTOR_GRATING_MIRROR = EVRegistries.REGISTRATE.item("diffractor_grating_mirror", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ULTRASHORT_PULSE_LASER = EVRegistries.REGISTRATE.item("ultrashort_pulse_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> COSMIC_PROCESSING_UNIT_CORE = EVRegistries.REGISTRATE.item("cosmic_processing_unit_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> COSMIC_PROCESSING_CORE = EVRegistries.REGISTRATE.item("cosmic_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> GRAPHENE_IRON_PLATE = EVRegistries.REGISTRATE.item("graphene_iron_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> TOPOLOGICAL_MANIPULATOR_UNIT = EVRegistries.REGISTRATE.item("topological_manipulator_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM = EVRegistries.REGISTRATE.item("relativistic_spinorial_memory_system", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> GRAVITON_TRANSDUCER = EVRegistries.REGISTRATE.item("graviton_transducer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> NUCLEAR_CLOCK = EVRegistries.REGISTRATE.item("nuclear_clock", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SUPRACAUSAL_PROCESSING_CORE = EVRegistries.REGISTRATE.item("supracasual_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> MANIFOLD_OSCILLATORY_POWER_CELL = EVRegistries.REGISTRATE.item("manifold_oscillatory_power_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> QCD_PROTECTIVE_PLATING = EVRegistries.REGISTRATE.item("qcd_protective_plating", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CTC_GUIDANCE_UNIT = EVRegistries.REGISTRATE.item("ctc_guidance_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CTC_COMPUTATIONAL_UNIT_CONTAINER = EVRegistries.REGISTRATE.item("ctc_computational_unit_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> EIGENFOLDED_KERR_MANIFOLD = EVRegistries.REGISTRATE.item("eigenfolded_kerr_manifold", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> CTC_COMPUTATIONAL_UNIT = EVRegistries.REGISTRATE.item("ctc_computational_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> RECURSIVELY_FOLDED_NEGATIVE_SPACE = EVRegistries.REGISTRATE.item("recursively_folded_negative_space", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static ItemEntry<Item> COSMIC_MESH_CONTAINMENT_UNIT = EVRegistries.REGISTRATE.item("cosmic_mesh_containment_unit", Item::new).register();
    public static ItemEntry<Item> HIGHLY_DENSE_POLYMER_PLATE = EVRegistries.REGISTRATE.item("highly_dense_polymer_plate", Item::new).register();
    public static ItemEntry<Item> EXTREMELY_DURABLE_PLASMA_CELL = EVRegistries.REGISTRATE.item("extremely_durable_plasma_cell", Item::new).register();
    public static ItemEntry<Item> COSMIC_NEUTRON_PLASMA_CELL = EVRegistries.REGISTRATE.item("cosmic_neutron_plasma_cell", Item::new).register();
    public static ItemEntry<Item> DENSE_NEUTRON_PLASMA_CELL = EVRegistries.REGISTRATE.item("dense_neutron_plasma_cell", Item::new).register();

    public static ItemEntry<Item> CHARGED_LEPTON_TRAP_CRYSTAL = EVRegistries.REGISTRATE.item("charged_lepton_trap_crystal", Item::new).register();

    public static ItemEntry<Item> HIGHLY_INSULATING_FOIL = EVRegistries.REGISTRATE.item("highly_insulating_foil", Item::new).register();


    public static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent components) {
        return item -> item.attachComponents(components);
    }

    public static void init() {

    }
}

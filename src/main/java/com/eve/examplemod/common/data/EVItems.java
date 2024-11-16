package com.eve.examplemod.common.data;
import com.eve.examplemod.EVMain;
import com.eve.examplemod.api.registries.EVRegistries;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.tterrag.registrate.util.nullness.NonNullConsumer;



@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class EVItems {


    // TODO Hot wrought iron ingot that hurts you

    public static ItemEntry<Item> smd_capacitor_refined = EVMain.EV_REGISTRATE.item("smd_capacitor_refined", Item::new)
            .register();


    public static ItemEntry<Item> mica_sheet = EVRegistries.REGISTRATE.item("mica_sheet", Item::new)
            .register();

    public static ItemEntry<Item> mica_insulator_sheet = EVRegistries.REGISTRATE.item("mica_insulator_sheet", Item::new)
            .register();

    public static ItemEntry<Item> mica_insulator_foil = EVRegistries.REGISTRATE.item("mica_insulator_foil", Item::new)
            .register();

    public static ItemEntry<Item> fullerene_polymer_matrix_soft_tubing = EVMain.EV_REGISTRATE.item("fullerene_polymer_matrix_soft_tubing", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> fullerene_polymer_matrix_fine_tubing = EVMain.EV_REGISTRATE.item("fullerene_polymer_matrix_fine_tubing", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> x_ray_waveguide = EVMain.EV_REGISTRATE.item("x_ray_waveguide", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> microfocus_x_ray_tube = EVMain.EV_REGISTRATE.item("microfocus_x_ray_tube", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> x_ray_mirror_plate = EVMain.EV_REGISTRATE.item("x_ray_mirror_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> untreated_exotic_wafer = EVMain.EV_REGISTRATE.item("untreated_exotic_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_wafer = EVMain.EV_REGISTRATE.item("exotic_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_chip = EVMain.EV_REGISTRATE.item("exotic_chip", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> excitation_maintainer = EVMain.EV_REGISTRATE.item("excitation_maintainer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cryogenic_interface = EVMain.EV_REGISTRATE.item("cryogenic_interface", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rydberg_spinorial_assembly = EVMain.EV_REGISTRATE.item("rydberg_spinorial_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> x_ray_laser = EVMain.EV_REGISTRATE.item("x_ray_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_processing_core = EVMain.EV_REGISTRATE.item("exotic_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> protonated_fullerene_sieving_matrix = EVMain.EV_REGISTRATE.item("protonated_fullerene_sieving_matrix", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> saturated_fullerene_sieving_matrix = EVMain.EV_REGISTRATE.item("saturated_fullerene_sieving_matrix", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> petri_dish = EVMain.EV_REGISTRATE.item("petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_nano = EVMain.EV_REGISTRATE.item("smd_capacitor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_quantum = EVMain.EV_REGISTRATE.item("smd_capacitor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_crystal = EVMain.EV_REGISTRATE.item("smd_capacitor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_wetware = EVMain.EV_REGISTRATE.item("smd_capacitor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_bioware = EVMain.EV_REGISTRATE.item("smd_capacitor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_optical = EVMain.EV_REGISTRATE.item("smd_capacitor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_exotic = EVMain.EV_REGISTRATE.item("smd_capacitor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_cosmic = EVMain.EV_REGISTRATE.item("smd_capacitor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_supracausal = EVMain.EV_REGISTRATE.item("smd_capacitor_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_refined = EVMain.EV_REGISTRATE.item("smd_resistor_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_nano = EVMain.EV_REGISTRATE.item("smd_resistor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_quantum = EVMain.EV_REGISTRATE.item("smd_resistor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_crystal = EVMain.EV_REGISTRATE.item("smd_resistor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_wetware = EVMain.EV_REGISTRATE.item("smd_resistor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_bioware = EVMain.EV_REGISTRATE.item("smd_resistor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_optical = EVMain.EV_REGISTRATE.item("smd_resistor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_exotic = EVMain.EV_REGISTRATE.item("smd_resistor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_cosmic = EVMain.EV_REGISTRATE.item("smd_resistor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_supracausal = EVMain.EV_REGISTRATE.item("smd_resistor_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_refined = EVMain.EV_REGISTRATE.item("smd_diode_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_nano = EVMain.EV_REGISTRATE.item("smd_diode_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_quantum = EVMain.EV_REGISTRATE.item("smd_diode_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_crystal = EVMain.EV_REGISTRATE.item("smd_diode_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_wetware = EVMain.EV_REGISTRATE.item("smd_diode_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_bioware = EVMain.EV_REGISTRATE.item("smd_diode_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_optical = EVMain.EV_REGISTRATE.item("smd_diode_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_exotic = EVMain.EV_REGISTRATE.item("smd_diode_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_cosmic = EVMain.EV_REGISTRATE.item("smd_diode_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_supracausal = EVMain.EV_REGISTRATE.item("smd_diode_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_refined = EVMain.EV_REGISTRATE.item("smd_transistor_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_nano = EVMain.EV_REGISTRATE.item("smd_transistor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_quantum = EVMain.EV_REGISTRATE.item("smd_transistor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_crystal = EVMain.EV_REGISTRATE.item("smd_transistor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_wetware = EVMain.EV_REGISTRATE.item("smd_transistor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_bioware = EVMain.EV_REGISTRATE.item("smd_transistor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_optical = EVMain.EV_REGISTRATE.item("smd_transistor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_exotic = EVMain.EV_REGISTRATE.item("smd_transistor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_cosmic = EVMain.EV_REGISTRATE.item("smd_transistor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_supracausal = EVMain.EV_REGISTRATE.item("smd_transistor_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_processor = EVMain.EV_REGISTRATE.item("cosmic_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_assembly = EVMain.EV_REGISTRATE.item("cosmic_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_computer = EVMain.EV_REGISTRATE.item("cosmic_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_mainframe = EVMain.EV_REGISTRATE.item("cosmic_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_processor = EVMain.EV_REGISTRATE.item("bioware_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_assembly = EVMain.EV_REGISTRATE.item("bioware_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_computer = EVMain.EV_REGISTRATE.item("bioware_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_mainframe = EVMain.EV_REGISTRATE.item("bioware_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_processor = EVMain.EV_REGISTRATE.item("optical_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_assembly = EVMain.EV_REGISTRATE.item("optical_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_computer = EVMain.EV_REGISTRATE.item("optical_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_mainframe = EVMain.EV_REGISTRATE.item("optical_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_processor = EVMain.EV_REGISTRATE.item("exotic_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_assembly = EVMain.EV_REGISTRATE.item("exotic_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_computer = EVMain.EV_REGISTRATE.item("exotic_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_mainframe = EVMain.EV_REGISTRATE.item("exotic_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_processor = EVMain.EV_REGISTRATE.item("supracausal_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_assembly = EVMain.EV_REGISTRATE.item("supracausal_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_computer = EVMain.EV_REGISTRATE.item("supracausal_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_mainframe = EVMain.EV_REGISTRATE.item("supracausal_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> unstable_star = EVMain.EV_REGISTRATE.item("unstable_star", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static ItemEntry<Item> electric_piston_max = EVMain.EV_REGISTRATE.item("electric_piston_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> emitter_max = EVMain.EV_REGISTRATE.item("emitter_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> field_generator_max = EVMain.EV_REGISTRATE.item("field_generator_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();



    public static ItemEntry<ComponentItem> conveyor_module_max = EVRegistries.REGISTRATE.item("conveyor_module_max", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.CONVEYOR.definition)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .lang("Max Conveyor Module")
            .register();

    public static ItemEntry<ComponentItem> robot_arm_max = EVRegistries.REGISTRATE.item("robot_arm_max", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.ROBOT_ARM.definition)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", 16));
            })))
            .lang("Max Robot Arm")
            .register();


    public static ItemEntry<ComponentItem> electric_pump_max = EVRegistries.REGISTRATE.item("electric_pump_max", ComponentItem::create)
            .onRegister(attach(new CoverPlaceBehavior(EVCovers.PUMP.definition)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate",
                        1280 * 64 * 64 * 4 / 20));
            })))
            .lang("Max Electric Pump")
            .register();







    public static ItemEntry<Item> sensor_max = EVMain.EV_REGISTRATE.item("sensor_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ultrasonic_homogenizer = EVMain.EV_REGISTRATE.item("ultrasonic_homogenizer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> sterilized_petri_dish = EVMain.EV_REGISTRATE.item("sterilized_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contaminated_petri_dish = EVMain.EV_REGISTRATE.item("contaminated_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> electrically_wired_petri_dish = EVMain.EV_REGISTRATE.item("electrically_wired_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> clean_culture = EVMain.EV_REGISTRATE.item("clean_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> piezoelectric_crystal = EVMain.EV_REGISTRATE.item("piezoelectric_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> neuro_support_unit = EVMain.EV_REGISTRATE.item("neuro_support_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cyber_processing_unit = EVMain.EV_REGISTRATE.item("cyber_processing_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> shewanella_culture = EVMain.EV_REGISTRATE.item("shewanella_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> streptococcus_culture = EVMain.EV_REGISTRATE.item("streptococcus_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> escherichia_culture = EVMain.EV_REGISTRATE.item("escherichia_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bifidobacterium_culture = EVMain.EV_REGISTRATE.item("bifidobacterium_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> brevibacterium_culture = EVMain.EV_REGISTRATE.item("brevibacterium_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cuprivadus_culture = EVMain.EV_REGISTRATE.item("cuprivadus_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> plate_field_shape = EVMain.EV_REGISTRATE.item("plate_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ingot_field_shape = EVMain.EV_REGISTRATE.item("ingot_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> plasma_containment_cell = EVMain.EV_REGISTRATE.item("plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rhenium_plasma_containment_cell = EVMain.EV_REGISTRATE.item("rhenium_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> neutron_plasma_containment_cell = EVMain.EV_REGISTRATE.item("neutron_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> degenerate_rhenium_plate = EVMain.EV_REGISTRATE.item("degenerate_rhenium_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> degenerate_rhenium_dust = EVMain.EV_REGISTRATE.item("degenerate_rhenium_dust", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> zblan = EVMain.EV_REGISTRATE.item("zblan", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> zblan_ingot = EVMain.EV_REGISTRATE.item("zblan_ingot", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hot_annealed_zblan_ingot = EVMain.EV_REGISTRATE.item("hot_annealed_zblan_ingot", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> zblan_fiber = EVMain.EV_REGISTRATE.item("zblan_fiber", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> erbium_doped_zblan = EVMain.EV_REGISTRATE.item("erbium_doped_zblan", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cladded_optical_fiber_core = EVMain.EV_REGISTRATE.item("cladded_optical_fiber_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> acrylic_yarn = EVMain.EV_REGISTRATE.item("acrylic_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rapidly_rotating_crucible = EVMain.EV_REGISTRATE.item("rapidly_rotating_crucible", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> heavy_metal_absorbing_yarn = EVMain.EV_REGISTRATE.item("heavy_metal_absorbing_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> uranium_saturated_yarn = EVMain.EV_REGISTRATE.item("uranium_saturated_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> boron_retaining_yarn = EVMain.EV_REGISTRATE.item("boron_retaining_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> boron_saturated_yarn = EVMain.EV_REGISTRATE.item("boron_saturated_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lithium_sieve = EVMain.EV_REGISTRATE.item("lithium_sieve", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lithium_saturated_lithium_sieve = EVMain.EV_REGISTRATE.item("lithium_saturated_lithium_sieve", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> nanotome = EVMain.EV_REGISTRATE.item("nanotome", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> memory_foam_block = EVMain.EV_REGISTRATE.item("memory_foam_block", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> laser_diode = EVMain.EV_REGISTRATE.item("laser_diode", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> laser_cooling_unit = EVMain.EV_REGISTRATE.item("laser_cooling_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> magnetic_trap = EVMain.EV_REGISTRATE.item("magnetic_trap", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> empty_laser_cooling_container = EVMain.EV_REGISTRATE.item("empty_laser_cooling_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bose_einstein_cooling_container = EVMain.EV_REGISTRATE.item("bose_einstein_cooling_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> alumino_silicate_glass_tube = EVMain.EV_REGISTRATE.item("alumino_silicate_glass_tube", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ballast = EVMain.EV_REGISTRATE.item("ballast", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> uva_lamp_core = EVMain.EV_REGISTRATE.item("uva_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> blue_lamp_core = EVMain.EV_REGISTRATE.item("blue_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> green_lamp_core = EVMain.EV_REGISTRATE.item("green_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> red_lamp_core = EVMain.EV_REGISTRATE.item("red_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> white_lamp_core = EVMain.EV_REGISTRATE.item("white_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> uva_halide_lamp = EVMain.EV_REGISTRATE.item("uva_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> blue_halide_lamp = EVMain.EV_REGISTRATE.item("blue_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> green_halide_lamp = EVMain.EV_REGISTRATE.item("green_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> red_halide_lamp = EVMain.EV_REGISTRATE.item("red_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> white_halide_lamp = EVMain.EV_REGISTRATE.item("white_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> actinium_plasma_containment_cell = EVMain.EV_REGISTRATE.item("actinium_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ndyag_boule = EVMain.EV_REGISTRATE.item("ndyag_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> prhoylf_boule = EVMain.EV_REGISTRATE.item("prhoylf_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lutmyvo_boule = EVMain.EV_REGISTRATE.item("lutmyvo_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ndyag_rod = EVMain.EV_REGISTRATE.item("ndyag_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> prhoylf_rod = EVMain.EV_REGISTRATE.item("prhoylf_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lutmyvo_rod = EVMain.EV_REGISTRATE.item("lutmyvo_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> low_frequency_laser = EVMain.EV_REGISTRATE.item("low_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> medium_frequency_laser = EVMain.EV_REGISTRATE.item("medium_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> high_frequency_laser = EVMain.EV_REGISTRATE.item("high_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> periodically_poled_lithium_niobate_boule = EVMain.EV_REGISTRATE.item("periodically_poled_lithium_niobate_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> non_linear_optical_lens = EVMain.EV_REGISTRATE.item("non_linear_optical_lens", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> highly_reflective_mirror = EVMain.EV_REGISTRATE.item("highly_reflective_mirror", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rotating_transparent_surface = EVMain.EV_REGISTRATE.item("rotating_transparent_surface", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> electron_source = EVMain.EV_REGISTRATE.item("electron_source", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_soc = EVMain.EV_REGISTRATE.item("optical_soc", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_soc_wafer = EVMain.EV_REGISTRATE.item("optical_soc_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_processing_core = EVMain.EV_REGISTRATE.item("optical_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> peek_polyamide_foil = EVMain.EV_REGISTRATE.item("peek_polyamide_foil", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> insulation_wire_assembly = EVMain.EV_REGISTRATE.item("insulation_wire_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> neutronium_sphere = EVMain.EV_REGISTRATE.item("neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> triplet_neutronium_sphere = EVMain.EV_REGISTRATE.item("triplet_neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> charged_triplet_neutronium_sphere = EVMain.EV_REGISTRATE.item("charged_triplet_neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_reissner_nordstrom_singularity = EVMain.EV_REGISTRATE.item("contained_reissner_nordstrom_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_kerr_newmann_singularity = EVMain.EV_REGISTRATE.item("contained_kerr_newmann_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_kerr_singularity = EVMain.EV_REGISTRATE.item("contained_kerr_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_high_density_protonic_matter = EVMain.EV_REGISTRATE.item("contained_high_density_protonic_matter", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> time_dilation_containment_unit = EVMain.EV_REGISTRATE.item("time_dilation_containment_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> microwormhole_generator = EVMain.EV_REGISTRATE.item("microwormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> macrowormhole_generator = EVMain.EV_REGISTRATE.item("macrowormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> stabilized_wormhole_generator = EVMain.EV_REGISTRATE.item("stabilized_wormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_exotic_matter = EVMain.EV_REGISTRATE.item("contained_exotic_matter", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> separation_electromagnet = EVMain.EV_REGISTRATE.item("separation_electromagnet", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> sphere_field_shape = EVMain.EV_REGISTRATE.item("sphere_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> aerographene = EVMain.EV_REGISTRATE.item("aerographene", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> scintillator_crystal = EVMain.EV_REGISTRATE.item("scintillator_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> scintillator = EVMain.EV_REGISTRATE.item("scintillator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lepton_trap_crystal = EVMain.EV_REGISTRATE.item("lepton_trap_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hassium_seed_crystal = EVMain.EV_REGISTRATE.item("hassium_seed_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hassium_boule = EVMain.EV_REGISTRATE.item("hassium_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hassium_wafer = EVMain.EV_REGISTRATE.item("hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> coated_hassium_wafer = EVMain.EV_REGISTRATE.item("coated_hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> photocoated_hassium_wafer = EVMain.EV_REGISTRATE.item("photocoated_hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> grating_lithography_mask = EVMain.EV_REGISTRATE.item("grating_lithography_mask", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> diffractor_grating_mirror = EVMain.EV_REGISTRATE.item("diffractor_grating_mirror", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ultrashort_pulse_laser = EVMain.EV_REGISTRATE.item("ultrashort_pulse_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_processing_unit_core = EVMain.EV_REGISTRATE.item("cosmic_processing_unit_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_processing_core = EVMain.EV_REGISTRATE.item("cosmic_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> graphene_iron_plate = EVMain.EV_REGISTRATE.item("graphene_iron_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> topological_manipulator_unit = EVMain.EV_REGISTRATE.item("topological_manipulator_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> relativistic_spinorial_memory_system = EVMain.EV_REGISTRATE.item("relativistic_spinorial_memory_system", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> graviton_transducer = EVMain.EV_REGISTRATE.item("graviton_transducer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> nuclear_clock = EVMain.EV_REGISTRATE.item("nuclear_clock", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_processing_core = EVMain.EV_REGISTRATE.item("supracausal_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> manifold_oscillatory_power_cell = EVMain.EV_REGISTRATE.item("manifold_oscillatory_power_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> qcd_protective_plating = EVMain.EV_REGISTRATE.item("qcd_protective_plating", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ctc_guidance_unit = EVMain.EV_REGISTRATE.item("ctc_guidance_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ctc_computational_unit_container = EVMain.EV_REGISTRATE.item("ctc_computational_unit_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> eigenfolded_kerr_manifold = EVMain.EV_REGISTRATE.item("eigenfolded_kerr_manifold", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ctc_computational_unit = EVMain.EV_REGISTRATE.item("ctc_computational_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> recursively_folded_negative_space = EVMain.EV_REGISTRATE.item("recursively_folded_negative_space", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent components) {
        return item -> item.attachComponents(components);
    }

    public static void init() {

    }
}

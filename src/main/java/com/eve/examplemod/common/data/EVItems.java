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

    public static ItemEntry<Item> smd_capacitor_refined = EVRegistries.REGISTRATE.item("smd_capacitor_refined", Item::new)
            .register();


    public static ItemEntry<Item> mica_sheet = EVRegistries.REGISTRATE.item("mica_sheet", Item::new)
            .register();

    public static ItemEntry<Item> mica_insulator_sheet = EVRegistries.REGISTRATE.item("mica_insulator_sheet", Item::new)
            .register();

    public static ItemEntry<Item> mica_insulator_foil = EVRegistries.REGISTRATE.item("mica_insulator_foil", Item::new)
            .register();

    public static ItemEntry<Item> fullerene_polymer_matrix_soft_tubing = EVRegistries.REGISTRATE.item("fullerene_polymer_matrix_soft_tubing", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> fullerene_polymer_matrix_fine_tubing = EVRegistries.REGISTRATE.item("fullerene_polymer_matrix_fine_tubing", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> x_ray_waveguide = EVRegistries.REGISTRATE.item("x_ray_waveguide", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> microfocus_x_ray_tube = EVRegistries.REGISTRATE.item("microfocus_x_ray_tube", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> x_ray_mirror_plate = EVRegistries.REGISTRATE.item("x_ray_mirror_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> untreated_exotic_wafer = EVRegistries.REGISTRATE.item("untreated_exotic_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_wafer = EVRegistries.REGISTRATE.item("exotic_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_chip = EVRegistries.REGISTRATE.item("exotic_chip", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> excitation_maintainer = EVRegistries.REGISTRATE.item("excitation_maintainer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cryogenic_interface = EVRegistries.REGISTRATE.item("cryogenic_interface", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rydberg_spinorial_assembly = EVRegistries.REGISTRATE.item("rydberg_spinorial_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> x_ray_laser = EVRegistries.REGISTRATE.item("x_ray_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_processing_core = EVRegistries.REGISTRATE.item("exotic_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> protonated_fullerene_sieving_matrix = EVRegistries.REGISTRATE.item("protonated_fullerene_sieving_matrix", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> saturated_fullerene_sieving_matrix = EVRegistries.REGISTRATE.item("saturated_fullerene_sieving_matrix", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> petri_dish = EVRegistries.REGISTRATE.item("petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_nano = EVRegistries.REGISTRATE.item("smd_capacitor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_quantum = EVRegistries.REGISTRATE.item("smd_capacitor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_crystal = EVRegistries.REGISTRATE.item("smd_capacitor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_wetware = EVRegistries.REGISTRATE.item("smd_capacitor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_bioware = EVRegistries.REGISTRATE.item("smd_capacitor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_optical = EVRegistries.REGISTRATE.item("smd_capacitor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_exotic = EVRegistries.REGISTRATE.item("smd_capacitor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_cosmic = EVRegistries.REGISTRATE.item("smd_capacitor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_capacitor_supracausal = EVRegistries.REGISTRATE.item("smd_capacitor_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_refined = EVRegistries.REGISTRATE.item("smd_resistor_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_nano = EVRegistries.REGISTRATE.item("smd_resistor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_quantum = EVRegistries.REGISTRATE.item("smd_resistor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_crystal = EVRegistries.REGISTRATE.item("smd_resistor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_wetware = EVRegistries.REGISTRATE.item("smd_resistor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_bioware = EVRegistries.REGISTRATE.item("smd_resistor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_optical = EVRegistries.REGISTRATE.item("smd_resistor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_exotic = EVRegistries.REGISTRATE.item("smd_resistor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_cosmic = EVRegistries.REGISTRATE.item("smd_resistor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_resistor_supracausal = EVRegistries.REGISTRATE.item("smd_resistor_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_refined = EVRegistries.REGISTRATE.item("smd_diode_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_nano = EVRegistries.REGISTRATE.item("smd_diode_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_quantum = EVRegistries.REGISTRATE.item("smd_diode_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_crystal = EVRegistries.REGISTRATE.item("smd_diode_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_wetware = EVRegistries.REGISTRATE.item("smd_diode_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_bioware = EVRegistries.REGISTRATE.item("smd_diode_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_optical = EVRegistries.REGISTRATE.item("smd_diode_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_exotic = EVRegistries.REGISTRATE.item("smd_diode_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_cosmic = EVRegistries.REGISTRATE.item("smd_diode_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_diode_supracausal = EVRegistries.REGISTRATE.item("smd_diode_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_refined = EVRegistries.REGISTRATE.item("smd_transistor_refined", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_nano = EVRegistries.REGISTRATE.item("smd_transistor_nano", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_quantum = EVRegistries.REGISTRATE.item("smd_transistor_quantum", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_crystal = EVRegistries.REGISTRATE.item("smd_transistor_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_wetware = EVRegistries.REGISTRATE.item("smd_transistor_wetware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_bioware = EVRegistries.REGISTRATE.item("smd_transistor_bioware", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_optical = EVRegistries.REGISTRATE.item("smd_transistor_optical", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_exotic = EVRegistries.REGISTRATE.item("smd_transistor_exotic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_cosmic = EVRegistries.REGISTRATE.item("smd_transistor_cosmic", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> smd_transistor_supracausal = EVRegistries.REGISTRATE.item("smd_transistor_supracausal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_processor = EVRegistries.REGISTRATE.item("cosmic_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_assembly = EVRegistries.REGISTRATE.item("cosmic_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_computer = EVRegistries.REGISTRATE.item("cosmic_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_mainframe = EVRegistries.REGISTRATE.item("cosmic_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_processor = EVRegistries.REGISTRATE.item("bioware_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_assembly = EVRegistries.REGISTRATE.item("bioware_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_computer = EVRegistries.REGISTRATE.item("bioware_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bioware_mainframe = EVRegistries.REGISTRATE.item("bioware_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_processor = EVRegistries.REGISTRATE.item("optical_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_assembly = EVRegistries.REGISTRATE.item("optical_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_computer = EVRegistries.REGISTRATE.item("optical_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_mainframe = EVRegistries.REGISTRATE.item("optical_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_processor = EVRegistries.REGISTRATE.item("exotic_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_assembly = EVRegistries.REGISTRATE.item("exotic_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_computer = EVRegistries.REGISTRATE.item("exotic_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> exotic_mainframe = EVRegistries.REGISTRATE.item("exotic_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_processor = EVRegistries.REGISTRATE.item("supracausal_processor", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_assembly = EVRegistries.REGISTRATE.item("supracausal_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_computer = EVRegistries.REGISTRATE.item("supracausal_computer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_mainframe = EVRegistries.REGISTRATE.item("supracausal_mainframe", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> unstable_star = EVRegistries.REGISTRATE.item("unstable_star", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static ItemEntry<Item> electric_piston_max = EVRegistries.REGISTRATE.item("electric_piston_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> emitter_max = EVRegistries.REGISTRATE.item("emitter_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> field_generator_max = EVRegistries.REGISTRATE.item("field_generator_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();



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







    public static ItemEntry<Item> sensor_max = EVRegistries.REGISTRATE.item("sensor_max", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ultrasonic_homogenizer = EVRegistries.REGISTRATE.item("ultrasonic_homogenizer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> sterilized_petri_dish = EVRegistries.REGISTRATE.item("sterilized_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contaminated_petri_dish = EVRegistries.REGISTRATE.item("contaminated_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> electrically_wired_petri_dish = EVRegistries.REGISTRATE.item("electrically_wired_petri_dish", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> clean_culture = EVRegistries.REGISTRATE.item("clean_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> piezoelectric_crystal = EVRegistries.REGISTRATE.item("piezoelectric_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> neuro_support_unit = EVRegistries.REGISTRATE.item("neuro_support_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cyber_processing_unit = EVRegistries.REGISTRATE.item("cyber_processing_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> shewanella_culture = EVRegistries.REGISTRATE.item("shewanella_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> streptococcus_culture = EVRegistries.REGISTRATE.item("streptococcus_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> escherichia_culture = EVRegistries.REGISTRATE.item("escherichia_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bifidobacterium_culture = EVRegistries.REGISTRATE.item("bifidobacterium_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> brevibacterium_culture = EVRegistries.REGISTRATE.item("brevibacterium_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cuprivadus_culture = EVRegistries.REGISTRATE.item("cuprivadus_culture", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> plate_field_shape = EVRegistries.REGISTRATE.item("plate_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ingot_field_shape = EVRegistries.REGISTRATE.item("ingot_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> plasma_containment_cell = EVRegistries.REGISTRATE.item("plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rhenium_plasma_containment_cell = EVRegistries.REGISTRATE.item("rhenium_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> neutron_plasma_containment_cell = EVRegistries.REGISTRATE.item("neutron_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> degenerate_rhenium_plate = EVRegistries.REGISTRATE.item("degenerate_rhenium_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> degenerate_rhenium_dust = EVRegistries.REGISTRATE.item("degenerate_rhenium_dust", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> zblan = EVRegistries.REGISTRATE.item("zblan", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> zblan_ingot = EVRegistries.REGISTRATE.item("zblan_ingot", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hot_annealed_zblan_ingot = EVRegistries.REGISTRATE.item("hot_annealed_zblan_ingot", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> zblan_fiber = EVRegistries.REGISTRATE.item("zblan_fiber", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> erbium_doped_zblan = EVRegistries.REGISTRATE.item("erbium_doped_zblan", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cladded_optical_fiber_core = EVRegistries.REGISTRATE.item("cladded_optical_fiber_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> acrylic_yarn = EVRegistries.REGISTRATE.item("acrylic_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rapidly_rotating_crucible = EVRegistries.REGISTRATE.item("rapidly_rotating_crucible", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> heavy_metal_absorbing_yarn = EVRegistries.REGISTRATE.item("heavy_metal_absorbing_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> uranium_saturated_yarn = EVRegistries.REGISTRATE.item("uranium_saturated_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> boron_retaining_yarn = EVRegistries.REGISTRATE.item("boron_retaining_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> boron_saturated_yarn = EVRegistries.REGISTRATE.item("boron_saturated_yarn", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lithium_sieve = EVRegistries.REGISTRATE.item("lithium_sieve", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lithium_saturated_lithium_sieve = EVRegistries.REGISTRATE.item("lithium_saturated_lithium_sieve", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> nanotome = EVRegistries.REGISTRATE.item("nanotome", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> memory_foam_block = EVRegistries.REGISTRATE.item("memory_foam_block", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> laser_diode = EVRegistries.REGISTRATE.item("laser_diode", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> laser_cooling_unit = EVRegistries.REGISTRATE.item("laser_cooling_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> magnetic_trap = EVRegistries.REGISTRATE.item("magnetic_trap", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> empty_laser_cooling_container = EVRegistries.REGISTRATE.item("empty_laser_cooling_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> bose_einstein_cooling_container = EVRegistries.REGISTRATE.item("bose_einstein_cooling_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> alumino_silicate_glass_tube = EVRegistries.REGISTRATE.item("alumino_silicate_glass_tube", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ballast = EVRegistries.REGISTRATE.item("ballast", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> uva_lamp_core = EVRegistries.REGISTRATE.item("uva_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> blue_lamp_core = EVRegistries.REGISTRATE.item("blue_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> green_lamp_core = EVRegistries.REGISTRATE.item("green_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> red_lamp_core = EVRegistries.REGISTRATE.item("red_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> white_lamp_core = EVRegistries.REGISTRATE.item("white_lamp_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> uva_halide_lamp = EVRegistries.REGISTRATE.item("uva_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> blue_halide_lamp = EVRegistries.REGISTRATE.item("blue_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> green_halide_lamp = EVRegistries.REGISTRATE.item("green_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> red_halide_lamp = EVRegistries.REGISTRATE.item("red_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> white_halide_lamp = EVRegistries.REGISTRATE.item("white_halide_lamp", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> actinium_plasma_containment_cell = EVRegistries.REGISTRATE.item("actinium_plasma_containment_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ndyag_boule = EVRegistries.REGISTRATE.item("ndyag_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> prhoylf_boule = EVRegistries.REGISTRATE.item("prhoylf_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lutmyvo_boule = EVRegistries.REGISTRATE.item("lutmyvo_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ndyag_rod = EVRegistries.REGISTRATE.item("ndyag_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> prhoylf_rod = EVRegistries.REGISTRATE.item("prhoylf_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lutmyvo_rod = EVRegistries.REGISTRATE.item("lutmyvo_rod", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> low_frequency_laser = EVRegistries.REGISTRATE.item("low_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> medium_frequency_laser = EVRegistries.REGISTRATE.item("medium_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> high_frequency_laser = EVRegistries.REGISTRATE.item("high_frequency_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> periodically_poled_lithium_niobate_boule = EVRegistries.REGISTRATE.item("periodically_poled_lithium_niobate_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> non_linear_optical_lens = EVRegistries.REGISTRATE.item("non_linear_optical_lens", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> highly_reflective_mirror = EVRegistries.REGISTRATE.item("highly_reflective_mirror", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> rotating_transparent_surface = EVRegistries.REGISTRATE.item("rotating_transparent_surface", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> electron_source = EVRegistries.REGISTRATE.item("electron_source", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_soc = EVRegistries.REGISTRATE.item("optical_soc", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_soc_wafer = EVRegistries.REGISTRATE.item("optical_soc_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> optical_processing_core = EVRegistries.REGISTRATE.item("optical_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> peek_polyamide_foil = EVRegistries.REGISTRATE.item("peek_polyamide_foil", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> insulation_wire_assembly = EVRegistries.REGISTRATE.item("insulation_wire_assembly", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> neutronium_sphere = EVRegistries.REGISTRATE.item("neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> triplet_neutronium_sphere = EVRegistries.REGISTRATE.item("triplet_neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> charged_triplet_neutronium_sphere = EVRegistries.REGISTRATE.item("charged_triplet_neutronium_sphere", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_reissner_nordstrom_singularity = EVRegistries.REGISTRATE.item("contained_reissner_nordstrom_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_kerr_newmann_singularity = EVRegistries.REGISTRATE.item("contained_kerr_newmann_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_kerr_singularity = EVRegistries.REGISTRATE.item("contained_kerr_singularity", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_high_density_protonic_matter = EVRegistries.REGISTRATE.item("contained_high_density_protonic_matter", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> time_dilation_containment_unit = EVRegistries.REGISTRATE.item("time_dilation_containment_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> microwormhole_generator = EVRegistries.REGISTRATE.item("microwormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> macrowormhole_generator = EVRegistries.REGISTRATE.item("macrowormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> stabilized_wormhole_generator = EVRegistries.REGISTRATE.item("stabilized_wormhole_generator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> contained_exotic_matter = EVRegistries.REGISTRATE.item("contained_exotic_matter", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> separation_electromagnet = EVRegistries.REGISTRATE.item("separation_electromagnet", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> sphere_field_shape = EVRegistries.REGISTRATE.item("sphere_field_shape", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> aerographene = EVRegistries.REGISTRATE.item("aerographene", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> scintillator_crystal = EVRegistries.REGISTRATE.item("scintillator_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> scintillator = EVRegistries.REGISTRATE.item("scintillator", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> lepton_trap_crystal = EVRegistries.REGISTRATE.item("lepton_trap_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hassium_seed_crystal = EVRegistries.REGISTRATE.item("hassium_seed_crystal", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hassium_boule = EVRegistries.REGISTRATE.item("hassium_boule", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> hassium_wafer = EVRegistries.REGISTRATE.item("hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> coated_hassium_wafer = EVRegistries.REGISTRATE.item("coated_hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> photocoated_hassium_wafer = EVRegistries.REGISTRATE.item("photocoated_hassium_wafer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> grating_lithography_mask = EVRegistries.REGISTRATE.item("grating_lithography_mask", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> diffractor_grating_mirror = EVRegistries.REGISTRATE.item("diffractor_grating_mirror", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ultrashort_pulse_laser = EVRegistries.REGISTRATE.item("ultrashort_pulse_laser", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_processing_unit_core = EVRegistries.REGISTRATE.item("cosmic_processing_unit_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> cosmic_processing_core = EVRegistries.REGISTRATE.item("cosmic_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> graphene_iron_plate = EVRegistries.REGISTRATE.item("graphene_iron_plate", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> topological_manipulator_unit = EVRegistries.REGISTRATE.item("topological_manipulator_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> relativistic_spinorial_memory_system = EVRegistries.REGISTRATE.item("relativistic_spinorial_memory_system", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> graviton_transducer = EVRegistries.REGISTRATE.item("graviton_transducer", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> nuclear_clock = EVRegistries.REGISTRATE.item("nuclear_clock", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> supracausal_processing_core = EVRegistries.REGISTRATE.item("supracausal_processing_core", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> manifold_oscillatory_power_cell = EVRegistries.REGISTRATE.item("manifold_oscillatory_power_cell", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> qcd_protective_plating = EVRegistries.REGISTRATE.item("qcd_protective_plating", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ctc_guidance_unit = EVRegistries.REGISTRATE.item("ctc_guidance_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ctc_computational_unit_container = EVRegistries.REGISTRATE.item("ctc_computational_unit_container", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> eigenfolded_kerr_manifold = EVRegistries.REGISTRATE.item("eigenfolded_kerr_manifold", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ctc_computational_unit = EVRegistries.REGISTRATE.item("ctc_computational_unit", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();
    public static ItemEntry<Item> recursively_folded_negative_space = EVRegistries.REGISTRATE.item("recursively_folded_negative_space", Item::new).tab(EVTabs.EV_MATERIALS.getKey()).register();

    public static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent components) {
        return item -> item.attachComponents(components);
    }

    public static void init() {

    }
}

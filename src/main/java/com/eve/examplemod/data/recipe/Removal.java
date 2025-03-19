package com.eve.examplemod.data.recipe;

import com.eve.examplemod.EVMain;
import com.eve.examplemod.api.data.material.info.EVMaterialFlags;
import com.eve.examplemod.config.EVConfig;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.VN;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public class Removal {
    public static void init(Consumer<ResourceLocation> registry) {
        if (EVConfig.INSTANCE.harderPlatline) platline(registry);
        if (EVConfig.INSTANCE.harderTungsten) tungsten(registry);
        if (EVConfig.INSTANCE.harderGold) gold(registry);
        if (EVConfig.INSTANCE.harderIndium) indium(registry);
        if (EVConfig.INSTANCE.harderNaquadah) naquadah(registry);
        if (EVConfig.INSTANCE.harderYCBO) YCBO(registry);
        if (EVConfig.INSTANCE.removeCircuitAssemblerRecipes) CircuitAssemblers(registry);
        if (EVConfig.INSTANCE.removeLargeCircuitAssembler) LargeCircuitAssembler(registry);
        Hatches(registry);
        if (EVConfig.INSTANCE.evEndAccess) end(registry);
        cables(registry);

        for (Material material : GTCEuAPI.materialManager.getRegisteredMaterials()) {
            if (material.hasFlag(EVMaterialFlags.DISABLE_ELECTRIC_BLAST)){
                registry.accept(new ResourceLocation("gtceu:electric_blast_furnace/blast_" + material.getName()));
                registry.accept(new ResourceLocation("gtceu:electric_blast_furnace/blast_" + material.getName() + "_gas"));
                registry.accept(new ResourceLocation("gtceu:vacuum_freezer/cool_hot_" + material.getName() + "_ingot"));
            }
        }

        // soldering alloy loop
        for (int i = 0; i < 2; i = i + 1) {
            String solderingAlloy = "";
            if (i == 1) {
                solderingAlloy = "_soldering_alloy";
            }
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/processor_mv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/processor_mv_soc" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/processor_assembly_hv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/workstation_ev" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/mainframe_iv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/mainframe_iv_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_processor_hv_soc" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_processor_hv_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_processor_hv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_processor_assembly_ev_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_processor_assembly_ev" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_computer_iv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_computer_iv_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_mainframe_luv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/nano_mainframe_luv_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_processor_ev" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_processor_ev" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_processor_ev_soc" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_processor_ev_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_assembly_iv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_assembly_iv_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_computer_luv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_computer_luv_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_mainframe_zpm" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/quantum_mainframe_zpm_asmd" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/crystal_processor_iv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/crystal_processor_iv_soc" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/crystal_assembly_luv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/crystal_computer_zpm" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/wetware_processor_luv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/wetware_processor_luv_soc" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/wetware_processor_assembly_zpm" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/wetware_processor_assembly" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/microprocessor_lv" + solderingAlloy));
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/microprocessor_lv_soc" + solderingAlloy));


        }
        registry.accept(new ResourceLocation("gtceu:assembly_line/crystal_mainframe_uv"));
        registry.accept(new ResourceLocation("gtceu:assembly_line/wetware_super_computer_uv"));
        registry.accept(new ResourceLocation("gtceu:assembly_line/wetware_mainframe_uhv"));

        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/qubit_cpu_wafer_radon"));
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/qubit_cpu_wafer_radon"));

        registry.accept(new ResourceLocation("gtceu:circuit_assembler/neuro_processor"));
        registry.accept(new ResourceLocation("gtceu:laser_engraver/engrave_hasoc_neutronium"));



        //misc
        registry.accept(new ResourceLocation("gtceu:vacuum_freezer/cool_hot_silicon_ingot"));
        registry.accept(new ResourceLocation("gtceu:electric_blast_furnace/blast_silicon"));
        registry.accept(new ResourceLocation("gtceu:electric_blast_furnace/blast_silicon_dioxide"));
        // [sic]
        registry.accept(new ResourceLocation("gtceu:chemical_bath/silion_cool_down"));
        registry.accept(new ResourceLocation("gtceu:chemical_bath/silicon_cool_down_distilled_water"));
        registry.accept(new ResourceLocation("gtceu:circuit_assembler/wetware_board"));
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/wetware_circuit_board_iron3"));
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/wetware_circuit_board_persulfate"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/wetware_circuit_board_iron3"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/wetware_circuit_board_persulfate"));
        registry.accept(new ResourceLocation("gtceu:assembler/mds_coil_block"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_cupronickel"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_kanthal"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_nichrome"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_rtm_alloy"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_hssg"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_naquadah"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_trinium"));
        registry.accept(new ResourceLocation("gtceu:assembler/coil_tritanium"));
        registry.accept(new ResourceLocation("gtceu:assembler/inductor"));
        registry.accept(new ResourceLocation("gtceu:assembler/inductor_annealed"));
        registry.accept(new ResourceLocation("gtceu:assembler/inductor_nzf"));
        registry.accept(new ResourceLocation("gtceu:assembler/inductor_nzf_annealed"));

        registry.accept(new ResourceLocation("gtceu:electrolyzer/decomposition_electrolyzing_barium_sulfide"));
        registry.accept(new ResourceLocation("gtceu:electrolyzer/decomposition_electrolyzing_barite"));
        registry.accept(new ResourceLocation("gtceu:shaped/emitter_ev"));
        registry.accept(new ResourceLocation("gtceu:assembly_line/robot_arm_luv"));


        // raw carbon fibers
        registry.accept(new ResourceLocation("gtceu:autoclave/carbon_fibers_ptfe"));
        registry.accept(new ResourceLocation("gtceu:autoclave/carbon_fibers_polyethylene"));
        registry.accept(new ResourceLocation("gtceu:autoclave/carbon_fibers_epoxy"));
        registry.accept(new ResourceLocation("gtceu:autoclave/carbon_fibers_pbi"));


        registry.accept(new ResourceLocation("gtceu:assembler/electric_motor_iv"));
        registry.accept(new ResourceLocation("gtceu:shaped/electric_motor_iv"));

        List<String> removal = List.of("gtceu:autoclave/raw_crystal_chip_from_part_bacterial_sludge", "gtceu:autoclave/raw_crystal_chip_from_part_europium",
                "gtceu:autoclave/raw_crystal_chip_olivine", "gtceu:autoclave/raw_crystal_chip_from_part_mutagen", "gtceu:autoclave/raw_crystal_chip_emerald",
                "gtceu:electric_blast_furnace/engraved_crystal_chip_from_olivine", "gtceu:electric_blast_furnace/engraved_crystal_chip_from_emerald",
                "gtceu:assembler/superconducting_coil_luv", "gtceu:assembler/superconducting_coil_zpm", "gtceu:assembler/superconducting_coil_uv", "gtceu:mixer/naquadah_alloy",
                "gtceu:mixer/graphene", "gtceu:shaped/super_tank_lv", "gtceu:shaped/super_tank_mv", "gtceu:shaped/super_tank_hv", "gtceu:shaped/super_tank_ev",
                "gtceu:coke_oven/log_to_charcoal", "gtceu:shaped/large_chemical_reactor", "gtceu:mixer/hsss",
        // wetware
                "gtceu:fluid_heater/sterile_growth_medium", "gtceu:mixer/raw_growth_medium", "gtceu:autoclave/agar", "gtceu:distillery/mutagen",
                "gtceu:brewery/enriched_bacterial_sludge_from_u235", "gtceu:brewery/enriched_bacterial_sludge_from_u238", "gtceu:brewery/enriched_bacterial_sludge_from_naquadria",
                "gtceu:chemical_reactor/stem_cells", "gtceu:large_chemical_reactor/stem_cells",

                "gtceu:cutter/cut_nano_cpu", "gtceu:cutter/cut_nano_cpu_distilled_water", "gtceu:cutter/cut_nano_cpu_water", "gtceu:gas_turbine/nitrobenzene",
                "gtceu:shaped/large_centrifuge", "gtceu:shaped/casing_assembly_control", "gtceu:mixer/niobium_titanium", "gtceu:mixer/osmiridium",

                // gcym casings
                "gtceu:assembler/casing_laser_safe_engraving", "gtceu:assembler/casing_large_scale_assembling", "gtceu:assembler/casing_reaction_safe_mixing",
                "gtceu:assembler/casing_high_temperature_smelting", "gtceu:assembler/casing_tungstensteel_robust", "gtceu:assembler/casing_hsla_nonconducting",
                "gtceu:assembler/casing_incoloy_vibration_safe", "gtceu:assembler/casing_secure_maceration", "gtceu:assembler/casing_shock_proof", "gtceu:assembler/casing_corrosion_proof",
                "gtceu:assembler/casing_stress_proof",

                // gcym machines
                "gtceu:shaped/large_packer", "gtceu:shaped/large_sifter", "gtceu:shaped/large_wiremill", "gtceu:shaped/large_mixer", "gtceu:shaped/large_autoclave"
                );
        removal.forEach(c -> registry.accept(new ResourceLocation(c)));
    }
    public static void platline(Consumer<ResourceLocation> registry) {

        registry.accept(new ResourceLocation("gtceu:centrifuge/pgs_separation"));
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/rarest_metal_mixture_separation"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/rarest_metal_mixture_separation"));


        // why do each of these have like 2 steps in base gt lmao???

        // platinum
        registry.accept(new ResourceLocation("gtceu:electrolyzer/raw_platinum_separation"));
        registry.accept(new ResourceLocation("gtceu:centrifuge/endstone_separation"));

        // palladium
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/raw_palladium_separation"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/raw_palladium_separation"));


        // osmium
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/osmium_tetroxide_separation"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/osmium_tetroxide_separation"));
        registry.accept(new ResourceLocation("gtceu:distillery/acidic_osmium_solution_separation_to_water"));
        registry.accept(new ResourceLocation("gtceu:distillery/acidic_osmium_solution_separation_to_hydrochloric_acid"));
        registry.accept(new ResourceLocation("gtceu:distillation_tower/acidic_osmium_solution_separation"));

        // iridium
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/iridium_chloride_separation"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/iridium_chloride_separation"));
        registry.accept(new ResourceLocation("gtceu:centrifuge/iridium_metal_residue_separation"));

        // ruthenium
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/ruthenium_tetroxide_separation"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/ruthenium_tetroxide_separation"));
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/inert_metal_mixture_separation"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/inert_metal_mixture_separation"));

        // rhodium
        registry.accept(new ResourceLocation("gtceu:electrolyzer/rhodium_sulfate_separation"));

        // pgs
        List<String> list = List.of("pentlandite", "bornite", "cooperite", "chalcocite", "chalcopyrite", "tetrahedrite");
        list.forEach(c -> {
            registry.accept(new ResourceLocation("gtceu:chemical_reactor/pgs_from" + c));
            registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/pgs_from" + c));
        }

);
    }
    public static void indium(Consumer<ResourceLocation> registry) {
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/indium_concentrate_separation"));
        registry.accept(new ResourceLocation("gtceu:chemical_reactor/indium_concentrate_separation_4x"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/indium_concentrate_separation"));
        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/indium_concentrate_separation_4x"));
        registry.accept(new ResourceLocation("gtceu:mixer/indium_concentrate"));
        registry.accept(new ResourceLocation("gtceu:large_mixer/indium_concentrate"));
    }

    public static void naquadah(Consumer<ResourceLocation> registry) {
        List<String> removalList = List.of("gtceu:centrifuge/impure_enriched_naquadah_solution_separation", "gtceu:electric_blast_furnace/trinium_sulfide_separation",
                "gtceu:distillation_tower/enriched_naquadah_waste_separation", "gtceu:distillery/enriched_naquadah_waste_separation_to_sulfuric_acid", "gtceu:distillery/enriched_naquadah_waste_separation_to_naquadria_solution",
                "gtceu:distillery/enriched_naquadah_waste_separation_to_enriched_naquadah_solution", "gtceu:mixer/naquadria_solution_separation", "gtceu:centrifuge/impure_naquadria_solution_separation", "gtceu:distillery/naquadria_waste_separation_to_naquadria_solution",
                "gtceu:distillery/enriched_naquadah_waste_separation_to_naquadria_solution", "gtceu:distillation_tower/naquadria_waste_separation", "gtceu:distillation_tower/enriched_naquadah_waste_separation");
        removalList.forEach(c -> registry.accept(new ResourceLocation(c)));

        registry.accept(new ResourceLocation("gtceu:large_chemical_reactor/naquadah_separation"));
        registry.accept(new ResourceLocation("gtceu:electric_blast_furnace/titanium_trifluoride_separation"));

        // enriched naquadah
        registry.accept(new ResourceLocation("gtceu:mixer/enriched_naquadah_solution_separation"));
        registry.accept(new ResourceLocation("gtceu:centrifuge/acidic_enriched_naquadah_separation"));
//
    }

    public static void tungsten(Consumer<ResourceLocation> registry) {
        registry.accept(new ResourceLocation("gtceu:chemical_bath/tungstic_acid_from_scheelite"));
        registry.accept(new ResourceLocation("gtceu:chemical_bath/tungstic_acid_from_tungstate"));
        registry.accept(new ResourceLocation("gtceu:electrolyzer/tungstic_acid_electrolysis"));
//        registry.accept(new ResourceLocation("gtceu:mixer/tungstencarbide"));
    }
    public static void gold(Consumer<ResourceLocation> registry) {
        registry.accept(new ResourceLocation("gtceu:centrifuge/glowstone_separation"));
    }
    public static void YCBO(Consumer<ResourceLocation> registry) {
        List<String> removalList = List.of("gtceu:alloy_blast_smelter/yttrium_barium_cuprate_gas", "gtceu:alloy_blast_smelter/yttrium_barium_cuprate", "gtceu:vacuum_freezer/yttrium_barium_cuprate",
                "gtceu:mixer/yttrium_barium_cuprate"
                , "gtceu:centrifuge/rare_earth_separation", "gtceu:large_centrifuge/rare_earth_separation"
        );
        removalList.forEach(c -> registry.accept(new ResourceLocation(c)));

    }

    public static void CircuitAssemblers(Consumer<ResourceLocation> registry){
        for (int i = 5; i < 13; i++) {
            registry.accept(new ResourceLocation( "gtceu:shaped/" + GTValues.VN[i].toLowerCase() + "_circuit_assembler"));
        }
    }
    public static void LargeCircuitAssembler(Consumer<ResourceLocation> registry) {
        registry.accept(new ResourceLocation("gtceu:shaped/large_circuit_assembler"));
    }
    public static void Hatches(Consumer<ResourceLocation> registry){
        List<String> list = List.of("polytetrafluoroethylene", "polyethylene", "glue", "polybenzimidazole");
        for (var machine : GTMachines.FLUID_IMPORT_HATCH) {
            if (machine == null) continue;
            int tier = machine.getTier();
            for (String s : list) {
                registry.accept(new ResourceLocation("gtceu:assembler/fluid_hatch_" + VN[tier].toLowerCase() + "_" + s));
            }
        }
        for (var machine : GTMachines.FLUID_EXPORT_HATCH) {
            if (machine == null) continue;
            int tier = machine.getTier();
            for (String s : list) {
                registry.accept(new ResourceLocation("gtceu:assembler/fluid_export_hatch_" + VN[tier].toLowerCase() + "_" + s));
            }
        }
        for (var machine : GTMachines.ITEM_IMPORT_BUS) {
            if (machine == null) continue;
            int tier = machine.getTier();
            for (String s : list) {
                registry.accept(new ResourceLocation("gtceu:assembler/item_import_bus_" + VN[tier].toLowerCase() + "_" + s));
            }
        }
        for (var machine : GTMachines.ITEM_EXPORT_BUS) {
            if (machine == null) continue;
            int tier = machine.getTier();
            for (String s : list) {
                registry.accept(new ResourceLocation("gtceu:assembler/item_export_bus_" + VN[tier].toLowerCase() + "_" + s));
            }
        }
    }

    public static void end(Consumer<ResourceLocation> registry){
        registry.accept(new ResourceLocation("minecraft:ender_eye"));
        registry.accept(new ResourceLocation("gtceu:chemical_bath/eye_of_ender"));
        registry.accept(new ResourceLocation("gtceu:shaped/emitter_hv"));
        registry.accept(new ResourceLocation("gtceu:assembler/emitter_hv"));
    }

    public static void cables(Consumer<ResourceLocation> registry){
//        for (MaterialRegistry registry2 : GTCEuAPI.materialManager.getRegistries()) {
//            for (Material material : registry2.getAllMaterials()) {
//                if (material.hasProperty(PropertyKey.WIRE)){
//                    var property = material.getProperty(PropertyKey.WIRE);
//                    if (property.isSuperconductor()) return;
//                    var tier = GTUtil.getTierByVoltage(property.getVoltage());
//                    //if (tier > GTValues.LuV){
//                        List<TagPrefix> wirePrefix = List.of(wireGtSingle, wireGtDouble, wireGtQuadruple, wireGtOctal, wireGtHex);
//                        Map<TagPrefix, String> map = Map.of(wireGtSingle, "_wire_gt_single", wireGtDouble, "_wire_gt_double", wireGtQuadruple, "_wire_gt_quadruple", wireGtOctal, "_wire_gt_octal", wireGtHex, "_wire_gt_hex");
//                        wirePrefix.forEach(p -> {
//                            // todo fix this
//                            registry.accept(new ResourceLocation("gtceu:assembler/cover_" + material.getName() + map.get(p) + "_styrene_butadiene"));
//                            registry.accept(new ResourceLocation("gtceu:assembler/cover_" + material.getName() + map.get(p) + "_silicone"));
//                            if(Objects.equals(material.getModid(), EVMain.MOD_ID)) {
//                                String name = material.getName();
//                                System.out.println(name);
//                            }
//                            // registry.accept(new ResourceLocation("gtceu:assembler/cover_" + material.getName() + map.get(p) + "_rubber"));
//
////                            System.out.println("gtceu:assembler/cover_" + material.getName() + "_" + p.name.toLowerCase() + "_silicone");
//                        });
//                    //}
//                }
//            }
//        }

    }



}

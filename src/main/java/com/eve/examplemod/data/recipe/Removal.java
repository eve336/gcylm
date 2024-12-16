package com.eve.examplemod.data.recipe;

import com.eve.examplemod.config.EVConfig;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class Removal {
    public static void init(Consumer<ResourceLocation> registry) {
        if (EVConfig.INSTANCE.harderPlatline) platline(registry);
        if (EVConfig.INSTANCE.harderTungsten) tungsten(registry);
        if (EVConfig.INSTANCE.harderGold) gold(registry);

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
            registry.accept(new ResourceLocation("gtceu:circuit_assembler/wetware_processor_assembly" + solderingAlloy));
        }
        registry.accept(new ResourceLocation("gtceu:assembly_line/crystal_mainframe_uv"));
        registry.accept(new ResourceLocation("gtceu:assembly_line/wetware_super_computer_uv"));
        registry.accept(new ResourceLocation("gtceu:assembly_line/wetware_mainframe_uhv"));


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

    }
    public static void platline(Consumer<ResourceLocation> registry) {
        registry.accept(new ResourceLocation("gtceu:electrolyzer/raw_platinum_separation"));
    }
    public static void tungsten(Consumer<ResourceLocation> registry) {
        registry.accept(new ResourceLocation("gtceu:chemical_bath/tungstic_acid_from_scheelite"));
        registry.accept(new ResourceLocation("gtceu:chemical_bath/tungstic_acid_from_tungstate"));
        registry.accept(new ResourceLocation("gtceu:electrolyzer/tungstic_acid_electrolysis"));
        registry.accept(new ResourceLocation("gtceu:mixer/tungstencarbide"));
    }
    public static void gold(Consumer<ResourceLocation> registry) {

    }

}

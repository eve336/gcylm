package com.eve.examplemod.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class Removal {
    public static void init(Consumer<ResourceLocation> registry) {


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
    }
}

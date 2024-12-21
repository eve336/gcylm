package com.eve.examplemod.data.recipe.circuit;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.L;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class CircuitRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        refined(provider);
        micro(provider);
        nano(provider);
        quantum(provider);
        crystal(provider);
        wetware(provider);
        bioware(provider);
        optical(provider);
        exotic(provider);
        cosmic(provider);
        supracasual(provider);
    }
    public static void refined(Consumer<FinishedRecipe> provider) {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_processor").duration(200).EUt(60)
                .inputItems(RESISTOR, 8)
                .inputItems(TRANSISTOR, 8)
                .inputItems(CAPACITOR, 8)
                .inputItems(PLASTIC_CIRCUIT_BOARD, 1)
                .inputItems(CENTRAL_PROCESSING_UNIT, 1)
                .inputItems(wireFine, TinAlloy, 2)
                .outputItems(refined_processor, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_processor_smd").duration(200).EUt(60)
                .inputItems(SMD_RESISTOR_REFINED, 4)
                .inputItems(SMD_TRANSISTOR_REFINED, 4)
                .inputItems(SMD_CAPACITOR_REFINED, 4)
                .inputItems(PLASTIC_CIRCUIT_BOARD, 1)
                .inputItems(CENTRAL_PROCESSING_UNIT, 1)
                .inputItems(wireFine, TinAlloy, 2)
                .outputItems(refined_processor, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_processor_soc").duration(50).EUt(600)
                .inputItems(PLASTIC_CIRCUIT_BOARD, 1)
                .inputItems(SYSTEM_ON_CHIP, 1)
                .inputItems(wireFine, TinAlloy, 8)
                .outputItems(refined_processor, 4)
                .save(provider);

// Refined Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_assembly").duration(100).EUt(60)
                .inputItems(refined_processor, 3)
                .inputItems(RESISTOR, 8)
                .inputItems(TRANSISTOR, 8)
                .inputItems(CAPACITOR, 8)
                .inputItems(PLASTIC_CIRCUIT_BOARD, 1)
                .outputItems(refined_assembly, 1)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_assembly_smd").duration(100).EUt(60)
                .inputItems(refined_processor, 3)
                .inputItems(SMD_RESISTOR_REFINED, 2)
                .inputItems(SMD_TRANSISTOR_REFINED, 2)
                .inputItems(SMD_CAPACITOR_REFINED, 2)
                .inputItems(PLASTIC_CIRCUIT_BOARD, 1)
                .outputItems(refined_assembly, 1)
                .save(provider);

// Refined Computer
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_computer").duration(200).EUt(90)
                .inputItems(refined_assembly, 4)
                .inputItems(RESISTOR, 8)
                .inputItems(TRANSISTOR, 8)
                .inputItems(RANDOM_ACCESS_MEMORY, 2)
                .inputItems(PLASTIC_CIRCUIT_BOARD, 1)
                .outputItems(refined_computer, 1)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_computer_smd").duration(200).EUt(90)
                .inputItems(refined_assembly, 4)
                .inputItems(SMD_RESISTOR_REFINED, 2)
                .inputItems(SMD_TRANSISTOR_REFINED, 2)
                .inputItems(RANDOM_ACCESS_MEMORY, 2)
                .inputItems(PLASTIC_CIRCUIT_BOARD, 1)
                .outputItems(refined_computer, 1)
                .save(provider);

// Refined Mainframe
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_mainframe").duration(500).EUt(110)
                .inputItems(refined_computer, 2)
                .inputItems(RESISTOR, 32)
                .inputItems(TRANSISTOR, 16)
                .inputItems(DIODE, 8)
                .inputItems(RANDOM_ACCESS_MEMORY, 4)
                .inputItems(frameGt, StainlessSteel, 4)
                .outputItems(refined_mainframe, 1)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("refined_mainframe_smd").duration(500).EUt(110)
                .inputItems(refined_computer, 2)
                .inputItems(SMD_RESISTOR_REFINED, 16)
                .inputItems(SMD_TRANSISTOR_REFINED, 8)
                .inputItems(SMD_DIODE_REFINED, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 4)
                .inputItems(frameGt, StainlessSteel, 4)
                .outputItems(refined_mainframe, 1)
                .save(provider);
    }

    public static void micro(Consumer<FinishedRecipe> provider) {

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("micro_processor_standard").duration(100).EUt(400)
                .inputItems(SMD_RESISTOR_MICRO, 4)
                .inputItems(SMD_TRANSISTOR_MICRO, 4)
                .inputItems(SMD_CAPACITOR_MICRO, 4)
                .inputItems(ADVANCED_CIRCUIT_BOARD, 1)
                .inputItems(CENTRAL_PROCESSING_UNIT, 2)
                .inputItems(wireFine, RedAlloy, 2)
                .outputItems(PROCESSOR_MV, 4)
                .save(provider);

// SoC Recipe
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("micro_processor_soc").duration(50).EUt(2400)
                .inputItems(ADVANCED_CIRCUIT_BOARD, 1)
                .inputItems(SYSTEM_ON_CHIP, 1)
                .inputItems(wireFine, RedAlloy, 8)
                .outputItems(PROCESSOR_MV, 4)
                .save(provider);

// Micro Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("processor_assembly_hv_standard").duration(100).EUt(350)
                .inputItems(PROCESSOR_MV, 3)
                .inputItems(SMD_CAPACITOR_MICRO, 2)
                .inputItems(SMD_RESISTOR_MICRO, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 2)
                .inputItems(ADVANCED_CIRCUIT_BOARD, 1)
                .inputItems(plate, Titanium, 1)
                .outputItems(PROCESSOR_ASSEMBLY_HV, 1)
                .save(provider);


        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("micro_computer_standard").duration(200).EUt(425)
                .inputItems(PROCESSOR_ASSEMBLY_HV, 4)
                .inputItems(SMD_RESISTOR_MICRO, 4)
                .inputItems(SMD_TRANSISTOR_MICRO, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 8)
                .inputItems(ADVANCED_CIRCUIT_BOARD, 1)
                .inputItems(wireGtSingle, HVSuperconductor, 1)
                .outputItems(WORKSTATION_EV, 1)
                .save(provider);

// Micro Mainframe


        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("micro_mainframe_standard").duration(500).EUt(500)
                .inputItems(WORKSTATION_EV, 2)
                .inputItems(SMD_RESISTOR_MICRO, 20)
                .inputItems(SMD_TRANSISTOR_MICRO, 10)
                .inputItems(SMD_DIODE_MICRO, 5)
                .inputItems(RANDOM_ACCESS_MEMORY, 8)
                .inputItems(frameGt, Titanium, 4)
                .outputItems(MAINFRAME_IV, 1)
                .save(provider);
    }
    public static void nano(Consumer<FinishedRecipe> provider) {



        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evnano_processor_hv_variant").duration(100).EUt(2000)
                .outputItems(NANO_PROCESSOR_HV, 4)
                .inputItems(SMD_RESISTOR_NANO, 4)
                .inputItems(SMD_TRANSISTOR_NANO, 4)
                .inputItems(SMD_CAPACITOR_NANO, 4)
                .inputItems(MULTILAYER_FIBER_BOARD, 1)
                .inputItems(NANO_CENTRAL_PROCESSING_UNIT, 12)
                .inputItems(wireFine, Aluminium, 2)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evnano_processor_hv_soc_stuff").duration(50).EUt(9600)
                .inputItems(MULTILAYER_FIBER_BOARD, 1)
                .inputItems(SYSTEM_ON_CHIP, 1)
                .inputItems(wireFine, Aluminium, 8)
                .outputItems(NANO_PROCESSOR_HV, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evnano_processor_assembly_ev_variant").duration(100).EUt(2000)
                .inputItems(NANO_PROCESSOR_HV, 3)
                .inputItems(SMD_CAPACITOR_NANO, 4)
                .inputItems(SMD_RESISTOR_NANO, 4)
                .inputItems(NANO_CENTRAL_PROCESSING_UNIT, 2)
                .inputItems(MULTILAYER_FIBER_BOARD, 1)
                .inputItems(plate, TungstenSteel, 1)
                .outputItems(NANO_PROCESSOR_ASSEMBLY_EV, 1)
                .save(provider);



        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evnano_computer_variant").duration(200).EUt(2000)
                .outputItems(NANO_COMPUTER_IV, 1)
                .inputItems(NANO_PROCESSOR_ASSEMBLY_EV, 4)
                .inputItems(SMD_RESISTOR_NANO, 4)
                .inputItems(SMD_TRANSISTOR_NANO, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 8)
                .inputItems(MULTILAYER_FIBER_BOARD, 1)
                .inputItems(wireGtSingle, EVSuperconductor, 1)
                .save(provider);


        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evnano_mainframe_variant").duration(500).EUt(2000)
                .inputItems(NANO_COMPUTER_IV, 2)
                .inputItems(SMD_RESISTOR_NANO, 24)
                .inputItems(SMD_TRANSISTOR_NANO, 12)
                .inputItems(SMD_DIODE_NANO, 6)
                .inputItems(RANDOM_ACCESS_MEMORY, 12)
                .inputItems(frameGt, TungstenSteel, 4)
                .outputItems(NANO_MAINFRAME_LuV, 1)
                .save(provider);
    }
    public static void quantum(Consumer<FinishedRecipe> provider) {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evquantum_processor_ev").duration(100).EUt(3000)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT)
                .inputItems(SMD_TRANSISTOR_QUANTUM, 4)
                .inputItems(SMD_CAPACITOR_QUANTUM, 4)
                .inputItems(MULTILAYER_FIBER_BOARD)
                .inputItems(NANO_CENTRAL_PROCESSING_UNIT)
                .inputItems(wireFine, Platinum, 2)
                .outputItems(QUANTUM_PROCESSOR_EV, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evquantum_processor_ev_variant").duration(50).EUt(36000)
                .inputItems(MULTILAYER_FIBER_BOARD)
                .inputItems(ADVANCED_SYSTEM_ON_CHIP)
                .inputItems(wireFine, Platinum, 8)
                .outputItems(QUANTUM_PROCESSOR_EV, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evquantum_assembly").duration(100).EUt(4000)
                .inputItems(QUANTUM_PROCESSOR_EV, 3)
                .inputItems(SMD_CAPACITOR_QUANTUM, 4)
                .inputItems(SMD_RESISTOR_QUANTUM, 4)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 2)
                .inputItems(MULTILAYER_FIBER_BOARD)
                .inputItems(plate, Osmium)
                .outputItems(QUANTUM_ASSEMBLY_IV, 1)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evquantum_computer").duration(200).EUt(6000)
                .inputItems(QUANTUM_ASSEMBLY_IV, 4)
                .inputItems(SMD_DIODE_QUANTUM, 8)
                .inputItems(QUANTUM_EYE)
                .inputItems(POWER_INTEGRATED_CIRCUIT, 4)
                .inputItems(MULTILAYER_FIBER_BOARD)
                .inputItems(wireGtSingle, IVSuperconductor, 2)
                .outputItems(QUANTUM_COMPUTER_LuV, 1)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("evquantum_mainframe").duration(500).EUt(8000)
                .inputItems(QUANTUM_COMPUTER_LuV, 2)
                .inputItems(SMD_RESISTOR_QUANTUM, 32)
                .inputItems(SMD_TRANSISTOR_QUANTUM, 28)
                .inputItems(SMD_CAPACITOR_QUANTUM, 28)
                .inputItems(SMD_DIODE_QUANTUM, 16)
                .inputItems(POWER_INTEGRATED_CIRCUIT, 8)
                .inputItems(QUANTUM_STAR)
                .inputItems(frameGt, TungstenSteel, 4)
                .inputItems(wireGtSingle, IVSuperconductor, 16)
                .outputItems(QUANTUM_MAINFRAME_ZPM, 1)
                .save(provider);
    }
    public static void crystal(Consumer<FinishedRecipe> provider) {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evcrystal_processor").duration(100).EUt(10000)
                .inputItems(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .inputItems(SMD_TRANSISTOR_CRYSTAL, 8)
                .inputItems(SMD_CAPACITOR_CRYSTAL, 4)
                .inputItems(KAPTON_CIRCUIT_BOARD)
                .inputItems(NANO_CENTRAL_PROCESSING_UNIT)
                .inputItems(wireFine, NiobiumTitanium, 2)
                .outputItems(CRYSTAL_PROCESSOR_IV, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evcrystal_processor_variant").duration(50).EUt(86000)
                .inputItems(KAPTON_CIRCUIT_BOARD)
                .inputItems(CRYSTAL_SYSTEM_ON_CHIP)
                .inputItems(wireFine, NiobiumTitanium, 8)
                .outputItems(CRYSTAL_PROCESSOR_IV, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evenergy_flow_circuit_luv").duration(100).EUt(20000)
                .inputItems(CRYSTAL_PROCESSOR_IV, 3)
                .inputItems(CENTRAL_PROCESSING_UNIT, 64)
                .inputItems(SMD_RESISTOR_CRYSTAL, 4)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT)
                .inputItems(KAPTON_CIRCUIT_BOARD)
                .inputItems(wireGtSingle, IndiumTinBariumTitaniumCuprate, 4)
                .outputItems(CRYSTAL_ASSEMBLY_LuV, 1)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("evcrystal_computer").duration(300).EUt(30000)
                .inputItems(CRYSTAL_ASSEMBLY_LuV, 4)
                .inputItems(SMD_DIODE_CRYSTAL, 8)
                .inputItems(SMD_RESISTOR_CRYSTAL, 8)
                .inputItems(QUANTUM_EYE)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT)
                .inputItems(KAPTON_CIRCUIT_BOARD)
                .inputItems(plate, RhodiumPlatedPalladium, 2)
                .inputItems(wireGtSingle, IndiumTinBariumTitaniumCuprate, 16)
                .outputItems(CRYSTAL_COMPUTER_ZPM, 1)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("evcrystal_mainframe").duration(500).EUt(30000)
                .inputItems(CRYSTAL_COMPUTER_ZPM, 2)
                .inputItems(SMD_RESISTOR_CRYSTAL, 48)
                .inputItems(SMD_TRANSISTOR_CRYSTAL, 36)
                .inputItems(SMD_CAPACITOR_CRYSTAL, 32)
                .inputItems(SMD_DIODE_CRYSTAL, 24)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .inputItems(QUANTUM_STAR, 4)
                .inputItems(frameGt, HSSE, 4)
                .inputItems(wireGtSingle, IndiumTinBariumTitaniumCuprate, 32)
                .outputItems(CRYSTAL_MAINFRAME_UV, 1)
                .save(provider);
    }
    public static void wetware(Consumer<FinishedRecipe> provider) {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evwetware_processor_luv").duration(200).EUt(56000)
                .inputItems(CRYSTAL_SYSTEM_ON_CHIP)
                .inputItems(SMD_TRANSISTOR_WETWARE, 8)
                .inputItems(SMD_CAPACITOR_WETWARE, 4)
                .inputItems(CYBER_PROCESSING_UNIT)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT)
                .inputItems(wireFine, YttriumBariumCuprate, 2)
                .outputItems(WETWARE_PROCESSOR_LuV, 4)
                .save(provider);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("evwetware_processor_luv_variant").duration(200).EUt(480000)
                .inputItems(CYBER_PROCESSING_UNIT)
                .inputItems(ADVANCED_SYSTEM_ON_CHIP, 4)
                .inputItems(wireFine, NaquadahAlloy, 8)
                .outputItems(WETWARE_PROCESSOR_LuV, 4)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("evwetware_processor_assembly_zpm").duration(400).EUt(120000)
                .inputItems(WETWARE_PROCESSOR_LuV, 3)
                .inputItems(SMD_RESISTOR_WETWARE, 16)
                .inputItems(SMD_TRANSISTOR_WETWARE, 16)
                .inputItems(SMD_CAPACITOR_WETWARE, 16)
                .inputItems(SMD_DIODE_WETWARE, 16)
                .inputItems(ARAM, 4)
                .inputItems(QUANTUM_EYE, 4)
                .inputItems(wireGtSingle, ZPMSuperconductor, 4)
                .inputItems(foil, SiliconeRubber, 16)
                .inputFluids(SterileGrowthMedium.getFluid(2000))
                .outputItems(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 1)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("ev_wetware_super_computer_uv").duration(600).EUt(122880)
                .inputItems(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 4)
                .inputItems(SMD_RESISTOR_WETWARE, 32)
                .inputItems(SMD_TRANSISTOR_WETWARE, 32)
                .inputItems(SMD_CAPACITOR_WETWARE, 32)
                .inputItems(SMD_DIODE_WETWARE, 32)
                .inputItems(QUANTUM_STAR, 4)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .inputItems(plate, Rutherfordium, 2)
                .inputItems(wireGtSingle, ZPMSuperconductor, 16)
                .inputItems(foil, SiliconeRubber, 32)
                .inputFluids(SterileGrowthMedium.getFluid(2000))
                .outputItems(WETWARE_SUPER_COMPUTER_UV, 1)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("wetware_mainframe_max").duration(2000).EUt(300000)
                .inputItems(WETWARE_SUPER_COMPUTER_UV, 2)
                .inputItems(SMD_RESISTOR_WETWARE, 64)
                .inputItems(SMD_TRANSISTOR_WETWARE, 64)
                .inputItems(SMD_CAPACITOR_WETWARE, 64)
                .inputItems(SMD_DIODE_WETWARE, 64)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .inputItems(GRAVI_STAR, 4)
                .inputItems(frameGt, Tritanium, 4)
                .inputItems(plate, Duranium, 32)
                .inputItems(wireGtSingle, UVSuperconductor, 64)
                .inputItems(foil, Polytetrafluoroethylene, 64)
                .inputFluids(SterileGrowthMedium.getFluid(2000))
                .inputFluids(UUMatter.getFluid(100))
                .outputItems(WETWARE_MAINFRAME_UHV, 1)
                .save(provider);
    }
    public static void bioware(Consumer<FinishedRecipe> provider) {
// Bioware Processor Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("bioware_processor").duration(200).EUt(240000)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 4)
                .inputItems(SMD_TRANSISTOR_BIOWARE, 8)
                .inputItems(SMD_CAPACITOR_BIOWARE, 4)
                .inputItems(NEURO_PROCESSOR)
                .inputItems(HASOC)
                .inputItems(wireFine, NaquadahAlloy, 4)
                .outputItems(BIOWARE_PROCESSOR, 4)
                .solderMultiplier(4)
                .save(provider);

// Bioware Assembly
        ASSEMBLY_LINE_RECIPES.recipeBuilder("bioware_assembly").duration(400).EUt(480000)
                .inputItems(BIOWARE_PROCESSOR, 3)
                .inputItems(SMD_CAPACITOR_BIOWARE, 16)
                .inputItems(SMD_TRANSISTOR_BIOWARE, 16)
                .inputItems(SMD_DIODE_BIOWARE, 16)
                .inputItems(SMD_RESISTOR_BIOWARE, 16)
                .inputItems(wireGtSingle, UVSuperconductor, 4)
                .inputItems(ARAM, 32)
                .inputItems(plate, Duranium, 2)
                .inputItems(foil, Polybenzimidazole, 16)
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .inputFluids(Titanium.getFluid(L * 9))
                .inputFluids(Polyethylene.getFluid(144 * 18))
                .inputFluids(NaquadahEnriched.getFluid(L * 9))
                .outputItems(BIOWARE_ASSEMBLY)
                .save(provider);

// Bioware Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder("bioware_computer").duration(600).EUt(480000)
                .inputItems(BIOWARE_ASSEMBLY, 4)
                .inputItems(SMD_CAPACITOR_BIOWARE, 32)
                .inputItems(SMD_TRANSISTOR_BIOWARE, 32)
                .inputItems(SMD_DIODE_BIOWARE, 32)
                .inputItems(SMD_RESISTOR_BIOWARE, 32)
                .inputItems(wireGtSingle, UVSuperconductor, 2)
                .inputItems(UHPIC, 16)
                .inputItems(ARAM, 64)
                .inputItems(plate, Seaborgium, 2)
                .inputItems(foil, Polybenzimidazole, 16)
                .inputItems(GRAVI_STAR, 2)
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .inputFluids(Tritanium.getFluid(L * 2))
                .inputFluids(Polybenzimidazole.getFluid(L * 9))
                .inputFluids(NaquadahEnriched.getFluid(L * 9))
                .outputItems(BIOWARE_COMPUTER)
                .save(provider);

// Bioware Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder("bioware_mainframe").duration(800).EUt(1920000)
                .inputItems(BIOWARE_COMPUTER, 2)
                .inputItems(SMD_CAPACITOR_BIOWARE, 64)
                .inputItems(SMD_TRANSISTOR_BIOWARE, 64)
                .inputItems(SMD_DIODE_BIOWARE, 64)
                .inputItems(SMD_RESISTOR_BIOWARE, 64)
                .inputItems(wireGtSingle, UVSuperconductor, 6)
                .inputItems(UHPIC, 32)
                .inputItems(plate, Adamantium, 2)
                .inputItems(frameGt, Adamantium)
                .inputItems(plate, Naquadria, 8)
                .inputItems(foil, Polybenzimidazole, 64)
                .inputItems(UNSTABLE_STAR)
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .inputFluids(Tritanium.getFluid(L * 9))
                .inputFluids(Polybenzimidazole.getFluid(L * 18))
                .inputFluids(Naquadria.getFluid(L * 9))
                .outputItems(BIOWARE_MAINFRAME)
                .save(provider);
    }
    public static void optical(Consumer<FinishedRecipe> provider) {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("optical_processor").duration(200).EUt(960000)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 4)
                .inputItems(SMD_TRANSISTOR_OPTICAL, 8)
                .inputItems(SMD_CAPACITOR_OPTICAL, 4)
                .inputItems(OPTICAL_PROCESSING_CORE)
                .inputItems(HASOC)
                .inputItems(wireFine, Pikyonium, 4)
                .outputItems(OPTICAL_PROCESSOR, 4)
                .solderMultiplier(4)
                .save(provider);

// Optical Assembly
        ASSEMBLY_LINE_RECIPES.recipeBuilder("optical_assembly").duration(400).EUt(960000)
                .inputItems(OPTICAL_PROCESSOR, 3)
                .inputItems(SMD_CAPACITOR_OPTICAL, 64)
                .inputItems(SMD_TRANSISTOR_OPTICAL, 64)
                .inputItems(SMD_DIODE_OPTICAL, 64)
                .inputItems(SMD_RESISTOR_OPTICAL, 64)
                .inputItems(wireGtSingle, UHVSuperconductor, 4)
                .inputItems(ARAM, 32)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .inputItems(plate, HDCS, 2)
                .inputItems(foil, Polyetheretherketone, 16)
                .inputFluids(Duranium.getFluid(L))
                .inputFluids(Polytetrafluoroethylene.getFluid(L * 2))
                .inputFluids(NaquadahEnriched.getFluid(L))
                .outputItems(OPTICAL_ASSEMBLY)
                .save(provider);

// Optical Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder("optical_computer").duration(600).EUt(1920000)
                .inputItems(OPTICAL_ASSEMBLY, 4)
                .inputItems(SMD_CAPACITOR_OPTICAL, 32)
                .inputItems(SMD_TRANSISTOR_OPTICAL, 32)
                .inputItems(SMD_DIODE_OPTICAL, 32)
                .inputItems(SMD_RESISTOR_OPTICAL, 32)
                .inputItems(OPTICAL_SOC)
                .inputItems(wireGtSingle, UHVSuperconductor, 2)
                .inputItems(CLADDED_OPTICAL_FIBER_CORE, 16)
                .inputItems(UHPIC, 32)
                .inputItems(ARAM, 64)
                .inputItems(ARAM, 64)
                .inputItems(plate, Quantum, 2)
                .inputItems(foil, Polybenzimidazole, 16)
                .inputItems(GRAVI_STAR, 4)
                .inputFluids(Tritanium.getFluid(L))
                .inputFluids(Polyetheretherketone.getFluid(L))
                .inputFluids(Adamantium.getFluid(L))
                .outputItems(OPTICAL_COMPUTER)
                .save(provider);

// Optical Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder("optical_mainframe").duration(800).EUt(6000000)
                .inputItems(OPTICAL_COMPUTER, 2)
                .inputItems(SMD_CAPACITOR_OPTICAL, 64)
                .inputItems(SMD_TRANSISTOR_OPTICAL, 64)
                .inputItems(SMD_DIODE_OPTICAL, 64)
                .inputItems(SMD_RESISTOR_OPTICAL, 64)
                .inputItems(wireGtSingle, UVSuperconductor, 6)
                .inputItems(UHPIC, 64)
                .inputItems(UHASOC, 64)
                .inputItems(plate, EnrichedNaquadahAlloy, 4)
                .inputItems(frameGt, Bohrium)
                .inputItems(foil, Polyetheretherketone, 64)
                .inputItems(UNSTABLE_STAR, 8)
                .inputItems(CLADDED_OPTICAL_FIBER_CORE, 48)
                .inputFluids(Cinobite.getFluid(L))
                .inputFluids(Adamantium.getFluid(L))
                .inputFluids(Polyetheretherketone.getFluid(L * 2))
                .inputFluids(Naquadria.getFluid(L))
                .outputItems(OPTICAL_MAINFRAME)
                .save(provider);
    }
    public static void exotic(Consumer<FinishedRecipe> provider) {
// Exotic Processor Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("exotic_processor").duration(100).EUt((int) 4E+6)
                .inputItems(SMD_CAPACITOR_EXOTIC, 8)
                .inputItems(SMD_TRANSISTOR_EXOTIC, 8)
                .inputItems(EXOTIC_PROCESSING_CORE)
                .inputItems(wireFine, Cinobite, 4)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 4)
                .inputItems(HASOC)
                .solderMultiplier(4)
                .outputItems(EXOTIC_PROCESSOR, 4)
                .save(provider);

// Exotic Assembly
        ASSEMBLY_LINE_RECIPES.recipeBuilder("exotic_assembly").duration(200).EUt((int) 4E+6)
                .inputItems(SMD_RESISTOR_EXOTIC, 16)
                .inputItems(SMD_DIODE_EXOTIC, 16)
                .inputItems(SMD_TRANSISTOR_EXOTIC, 16)
                .inputItems(SMD_CAPACITOR_EXOTIC, 16)
                .inputItems(EXOTIC_PROCESSOR, 3)
                .inputItems(wireFine, Cinobite, 4)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 4)
                .inputItems(plate, EnrichedNaquadahAlloy, 2)
                .inputItems(ARAM, 2)
                .inputItems(wireGtSingle, UHVSuperconductor, 2)
                .inputFluids(EnrichedNaquadahAlloy.getFluid(L))
                .inputFluids(TriniumTitanium.getFluid(L))
                .inputFluids(Quantum.getFluid(L))
                .inputFluids(QuantumDots.getFluid(10))
                .outputItems(EXOTIC_ASSEMBLY)
                .save(provider);

// Exotic Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder("exotic_computer").duration(300).EUt((int) 4E+6)
                .inputItems(SMD_DIODE_EXOTIC, 32)
                .inputItems(SMD_RESISTOR_EXOTIC, 32)
                .inputItems(SMD_TRANSISTOR_EXOTIC, 32)
                .inputItems(SMD_CAPACITOR_EXOTIC, 32)
                .inputItems(EXOTIC_ASSEMBLY, 4)
                .inputItems(wireFine, Quantum, 4)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 4)
                .inputItems(UHPIC, 4)
                .inputItems(ARAM, 8)
                .inputItems(wireGtSingle, UEVSuperconductor, 4)
                .inputFluids(Polyetheretherketone.getFluid(L))
                .inputFluids(Vibranium.getFluid(L))
                .inputFluids(EnrichedNaquadahAlloy.getFluid(L))
                .inputFluids(TriniumTitanium.getFluid(L))
                .outputItems(EXOTIC_COMPUTER)
                .save(provider);

// Exotic Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder("exotic_mainframe").duration(400).EUt((int) 1E+7)
                .inputItems(SMD_RESISTOR_EXOTIC, 64)
                .inputItems(SMD_DIODE_EXOTIC, 64)
                .inputItems(SMD_TRANSISTOR_EXOTIC, 64)
                .inputItems(SMD_CAPACITOR_EXOTIC, 64)
                .inputItems(EXOTIC_COMPUTER, 2)
                .inputItems(wireFine, Vibranium, 4)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 4)
                .inputItems(UHASOC, 4)
                .inputItems(frameGt, TriniumTitanium)
                .inputItems(UHPIC, 2)
                .inputItems(ARAM, 16)
                .inputItems(wireGtSingle, UEVSuperconductor, 8)
                .inputFluids(LiquidEnrichedHelium.getFluid(100))
                .inputFluids(FullerenePolymerMatrix.getFluid(L))
                .inputFluids(Quantum.getFluid(144))
                .inputFluids(Naquadria.getFluid(144))
                .outputItems(EXOTIC_MAINFRAME)
                .save(provider);
    }
    public static void cosmic(Consumer<FinishedRecipe> provider) {
// Cosmic Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("cosmic_processor").duration(50).EUt(30_720_000)
                .inputItems(QUBIT_CENTRAL_PROCESSING_UNIT, 4)
                .inputItems(SMD_TRANSISTOR_COSMIC, 32)
                .inputItems(SMD_CAPACITOR_COSMIC, 16)
                .inputItems(COSMIC_PROCESSING_CORE)
                .inputItems(UHASOC)
                .inputItems(wireFine, Cinobite, 4)
                .outputItems(COSMIC_PROCESSOR, 4)
                .solderMultiplier(4)
                .save(provider);

// Cosmic Assembly
        ASSEMBLY_LINE_RECIPES.recipeBuilder("cosmic_assembly").duration(100).EUt(30_720_000)
                .inputItems(COSMIC_PROCESSOR, 3)
                .inputItems(SMD_CAPACITOR_COSMIC, 64)
                .inputItems(SMD_TRANSISTOR_COSMIC, 64)
                .inputItems(SMD_DIODE_COSMIC, 64)
                .inputItems(SMD_RESISTOR_COSMIC, 64)
                .inputItems(wireGtSingle, UHVSuperconductor, 4)
                .inputItems(ARAM, 64)
                .inputItems(ARAM, 64)
                .inputItems(plate, Quantum, 2)
                .inputItems(foil, Zylon, 16)
                .inputFluids(Tritanium.getFluid(L))
                .inputFluids(Polyetheretherketone.getFluid(L * 3))
                .inputFluids(NaquadahEnriched.getFluid(L * 2))
                .outputItems(COSMIC_ASSEMBLY)
                .save(provider);

// Cosmic Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder("cosmic_computer").duration(100).EUt(30_720_000)
                .inputItems(COSMIC_ASSEMBLY, 4)
                .inputItems(SMD_CAPACITOR_COSMIC, 64)
                .inputItems(SMD_TRANSISTOR_COSMIC, 64)
                .inputItems(SMD_DIODE_COSMIC, 64)
                .inputItems(SMD_RESISTOR_COSMIC, 64)
                .inputItems(wireGtDouble, UEVSuperconductor, 2)
                .inputItems(UHPIC, 64)
                .inputItems(ARAM, 64)
                .inputItems(OPTICAL_SOC, 32)
                .inputItems(plate, Quantum, 16)
                .inputItems(foil, FullerenePolymerMatrix, 12)
                .inputItems(GRAVI_STAR, 32)
                .inputFluids(SterileGrowthMedium.getFluid(16000))
                .inputFluids(Tritanium.getFluid(L))
                .inputFluids(Zylon.getFluid(L))
                .inputFluids(Naquadria.getFluid(L * 2))
                .outputItems(COSMIC_COMPUTER)
                .save(provider);

// Cosmic Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder("cosmic_mainframe").duration(200).EUt(30_720_000)
                .inputItems(COSMIC_COMPUTER, 2)
                .inputItems(SMD_CAPACITOR_COSMIC, 64)
                .inputItems(SMD_TRANSISTOR_COSMIC, 64)
                .inputItems(SMD_DIODE_COSMIC, 64)
                .inputItems(SMD_RESISTOR_COSMIC, 64)
                .inputItems(wireGtSingle, UIVSuperconductor, 12)
                .inputItems(UHASOC, 64)
                .inputItems(UHPIC, 64)
                .inputItems(frameGt, Quantum)
                .inputItems(plate, Quantum, 8)
                .inputItems(foil, FullerenePolymerMatrix, 64)
                .inputItems(UNSTABLE_STAR, 4)
                .inputFluids(Taranium.getFluid(L * 2))
                .inputFluids(TriniumTitanium.getFluid(L * 2))
                .inputFluids(Zylon.getFluid(L * 2))
                .inputFluids(Vibranium.getFluid(L * 2))
                .outputItems(COSMIC_MAINFRAME)
                .save(provider);
    }
    public static void supracasual(Consumer<FinishedRecipe> provider) {
// Supracausal Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("supra_processor").duration(50).EUt(122_880_000)
                .inputItems(UHASOC, 16)
                .inputItems(manifold_oscillatory_power_cell)
                .inputItems(microwormhole_generator)
                .inputItems(SUPRACAUSAL_PROCESSING_CORE)
                .inputItems(plate, SuperheavyHAlloy)
                .inputItems(wireGtSingle, UHVSuperconductor, 8)
                .outputItems(SUPRACAUSAL_PROCESSOR, 4)
                .solderMultiplier(4)
                .save(provider);

// Supracausal Assembly
        ASSEMBLY_LINE_RECIPES.recipeBuilder("supra_assembly").duration(50).EUt(122_880_000)
                .inputItems(SMD_CAPACITOR_SUPRACAUSAL, 16)
                .inputItems(SMD_DIODE_SUPRACAUSAL, 16)
                .inputItems(SMD_TRANSISTOR_SUPRACAUSAL, 16)
                .inputItems(SMD_RESISTOR_SUPRACAUSAL, 16)
                .inputItems(UHASOC, 4)
                .inputItems(SUPRACAUSAL_PROCESSOR, 3)
                .inputItems(recursively_folded_negative_space)
                .inputItems(plate, TriniumTitanium, 16)
                .inputItems(foil, FullerenePolymerMatrix, 24)
                .inputItems(wireGtSingle, UEVSuperconductor, 8)
                .inputFluids(Taranium.getFluid(L * 3))
                .inputFluids(TriniumTitanium.getFluid(L * 3))
                .inputFluids(ProtoAdamantium.getFluid(L * 2))
                .inputFluids(FullerenePolymerMatrix.getFluid(L * 2))
                .outputItems(SUPRACAUSAL_ASSEMBLY)
                .save(provider);

// Supracausal Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder("supra_computer").duration(100).EUt(491_520_000)
                .inputItems(SMD_CAPACITOR_SUPRACAUSAL, 32)
                .inputItems(SMD_DIODE_SUPRACAUSAL, 32)
                .inputItems(SMD_TRANSISTOR_SUPRACAUSAL, 32)
                .inputItems(SMD_RESISTOR_SUPRACAUSAL, 32)
                .inputItems(SUPRACAUSAL_ASSEMBLY, 4)
                .inputItems(ARAM, 12)
                .inputItems(eigenfolded_kerr_manifold)
                .inputItems(plate, TriniumTitanium, 32)
                .inputItems(plate, MetastableFlerovium, 16)
                .inputItems(plate, Neutronium, 4)
                .inputItems(wireGtSingle, UMVSuperconductor, 64)
                .inputItems(UHPIC, 2)
                .inputFluids(Taranium.getFluid(L * 2))
                .inputFluids(TriniumTitanium.getFluid(L * 2))
                .inputFluids(ProtoAdamantium.getFluid(L))
                .inputFluids(FullerenePolymerMatrix.getFluid(L * 2))
                .outputItems(SUPRACAUSAL_COMPUTER)
                .save(provider);

// Supracausal Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder("supra_mainframe").duration(100).EUt(Integer.MAX_VALUE)
                .inputItems(SMD_CAPACITOR_SUPRACAUSAL, 64)
                .inputItems(SMD_DIODE_SUPRACAUSAL, 64)
                .inputItems(SMD_TRANSISTOR_SUPRACAUSAL, 64)
                .inputItems(SMD_RESISTOR_SUPRACAUSAL, 64)
                .inputItems(SUPRACAUSAL_COMPUTER, 2)
                .inputItems(UHPIC, 8)
                .inputItems(ARAM, 16)
                .inputItems(ctc_computational_unit)
                .inputItems(COSMIC_MESH, 64)
                .inputItems(frameGt, Neutronium, 1)
                .inputItems(wireGtSingle, UXVSuperconductor, 64)
                .inputItems(COSMIC_FABRIC, 64)
                .inputItems(plate, QCDMatter, 64)
                .inputFluids(Taranium.getFluid(L * 64))
                .inputFluids(TriniumTitanium.getFluid(L * 64))
                .inputFluids(ProtoAdamantium.getFluid(L * 64))
                .inputFluids(FullerenePolymerMatrix.getFluid(L * 64))
                .outputItems(SUPRACAUSAL_MAINFRAME)
                .save(provider);
    }

}

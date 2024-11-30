package com.eve.examplemod.data.recipe.circuit;

import com.eve.examplemod.common.data.EVItems;
import com.gregtechceu.gtceu.common.data.GTItems;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class CircuitRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        refined(provider);
        micro(provider);
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
                .inputItems(smd_resistor_refined, 4)
                .inputItems(smd_transistor_refined, 4)
                .inputItems(smd_capacitor_refined, 4)
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
                .inputItems(smd_resistor_refined, 2)
                .inputItems(smd_transistor_refined, 2)
                .inputItems(smd_capacitor_refined, 2)
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
                .inputItems(smd_resistor_refined, 2)
                .inputItems(smd_transistor_refined, 2)
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
                .inputItems(smd_resistor_refined, 16)
                .inputItems(smd_transistor_refined, 8)
                .inputItems(smd_diode_refined, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 4)
                .inputItems(frameGt, StainlessSteel, 4)
                .outputItems(refined_mainframe, 1)
                .save(provider);
    }

    public static void micro(Consumer<FinishedRecipe> provider) {

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("micro_processor_standard").duration(100).EUt(400)
                .inputItems(smd_resistor_micro, 4)
                .inputItems(smd_transistor_micro, 4)
                .inputItems(smd_capacitor_micro, 4)
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
                .inputItems(smd_capacitor_micro, 2)
                .inputItems(smd_resistor_micro, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 2)
                .inputItems(ADVANCED_CIRCUIT_BOARD, 1)
                .inputItems(plate, Titanium, 1)
                .outputItems(PROCESSOR_ASSEMBLY_HV, 1)
                .save(provider);


        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("micro_computer_standard").duration(200).EUt(425)
                .inputItems(PROCESSOR_ASSEMBLY_HV, 4)
                .inputItems(smd_resistor_micro, 4)
                .inputItems(smd_transistor_micro, 4)
                .inputItems(RANDOM_ACCESS_MEMORY, 8)
                .inputItems(ADVANCED_CIRCUIT_BOARD, 1)
                .inputItems(wireGtSingle, HVSuperconductor, 1)
                .outputItems(WORKSTATION_EV, 1)
                .save(provider);

// Micro Mainframe


        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder("micro_mainframe_standard").duration(500).EUt(500)
                .inputItems(WORKSTATION_EV, 2)
                .inputItems(smd_resistor_micro, 20)
                .inputItems(smd_transistor_micro, 10)
                .inputItems(smd_diode_micro, 5)
                .inputItems(RANDOM_ACCESS_MEMORY, 8)
                .inputItems(frameGt, Titanium, 4)
                .outputItems(MAINFRAME_IV, 1)
                .save(provider);


    }
}

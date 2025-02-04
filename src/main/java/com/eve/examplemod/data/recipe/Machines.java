package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.machines.EVMultiMachines;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.gear;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.HULL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;

public class Machines {

    public static void init(Consumer<FinishedRecipe> provider) {


        ASSEMBLER_RECIPES.recipeBuilder("mv_infinite_fluid_drilling_rig")
                .inputItems(HULL[MV])
                .inputItems(frameGt, Steel, 4)
                .inputItems(CustomTags.MV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_MV, 4)
                .inputItems(ELECTRIC_PUMP_MV, 4)
                .inputItems(gear, VanadiumSteel, 4)
                .circuitMeta(3)
                .outputItems(EVMultiMachines.INFINITE_FLUID_DRILLING_RIG[MV])
                .duration(400).EUt(VA[MV]).save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("hv_infinite_fluid_drilling_rig")
                .inputItems(HULL[EV])
                .inputItems(frameGt, Titanium, 4)
                .inputItems(CustomTags.EV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_EV, 4)
                .inputItems(ELECTRIC_PUMP_EV, 4)
                .inputItems(gear, TungstenCarbide, 4)
                .circuitMeta(3)
                .outputItems(EVMultiMachines.INFINITE_FLUID_DRILLING_RIG[HV])
                .duration(400).EUt(VA[EV]).save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("ev_infinite_fluid_drilling_rig")
                .inputItems(HULL[LuV])
                .inputItems(frameGt, TungstenSteel, 4)
                .inputItems(CustomTags.LuV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_LuV, 4)
                .inputItems(ELECTRIC_PUMP_LuV, 4)
                .inputItems(gear, Osmiridium, 4)
                .circuitMeta(3)
                .outputItems(EVMultiMachines.INFINITE_FLUID_DRILLING_RIG[EV])
                .duration(400).EUt(VA[LuV]).save(provider);
    }

}

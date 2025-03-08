package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.machines.EVMultiMachines;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.machines.GCYMMachines.LARGE_MIXER;

public class MachineRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {

//        VanillaRecipeHelper.addShapedRecipe(provider, true, "ev_large_mixer", EV_LARGE_MIXER.asStack(), "FCF", "RXR", "MKM",
//                'C', CustomTags.IV_CIRCUITS, 'F', ChemicalHelper.get(pipeNormalFluid, Polybenzimidazole), 'R',
//                ChemicalHelper.get(rotor, Osmiridium), 'M', ELECTRIC_MOTOR_IV.asStack(), 'X', MIXER[IV].asStack(), 'K',
//                new UnificationEntry(TagPrefix.cableGtSingle, Platinum));

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

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("ev_large_chemical_reactor"),
                EVMultiMachines.EV_CHEMICAL_REACTOR.asStack(),
                "CRC",
                "PMP",
                "CHC",
                'M', CraftingComponent.MOTOR.getIngredient(HV),
                'R', ChemicalHelper.get(rotor, StainlessSteel),
                'P', ChemicalHelper.get(pipeLargeFluid, Polytetrafluoroethylene),
                'H', HULL[HV].asStack(),
                'C', EVCraftingComponent.CIRCUIT.getIngredient(GTValues.HV));

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("ev_large_assembler"),
                EVMultiMachines.LARGE_ASSEMBLER.asStack(),
                "RWR",
                "CAC",
                "MWM",
                'M', CraftingComponent.CONVEYOR.getIngredient(IV),
                'W', ChemicalHelper.get(cableGtSingle, Platinum),
                'C', EVCraftingComponent.CIRCUIT.getIngredient(IV),
                'A', ASSEMBLER[IV].asStack(),
                'R', EVCraftingComponent.ROBOT_ARM.getIngredient(IV));

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("desulfuriser"),
                EVMultiMachines.DESULFURISER.asStack(),
                "SPS",
                "CHC",
                "RPR",
                'S', ChemicalHelper.get(plate, Steel),
                'P', ChemicalHelper.get(pipeLargeFluid, StainlessSteel),
                'R', EVCraftingComponent.PUMP.getIngredient(HV),
                'H', HULL[HV].asStack(),
                'C', EVCraftingComponent.CIRCUIT.getIngredient(GTValues.HV));

        // drill
        // GCG
        // DHD
        // SCS
        // h , ev hull
        // g, gear
        // s, sensor which needs platinum
        // d, diamond grinding head
        // c, ev circuit
        // idk just make it somewhat cheap but require platinum from batching platline or just making platline outright

        // drill 2
        // sensor needs osmium rod
        // everything same but one tier up duh

        // drill 3
        // luv sensor which needs sutff maybe idfk
        // everything one tier up

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

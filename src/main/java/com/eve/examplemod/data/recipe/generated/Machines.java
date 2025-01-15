package com.eve.examplemod.data.recipe.generated;

import com.eve.examplemod.common.data.EVMachines;
import com.eve.examplemod.data.recipe.EVCraftingComponent;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import dev.latvian.mods.kubejs.integration.forge.jei.JEIEvents;
import dev.latvian.mods.kubejs.integration.forge.jei.RemoveJEIRecipesEvent;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.ENERGY_INPUT_HATCH;
import static com.gregtechceu.gtceu.common.data.GTMachines.HULL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.data.recipe.misc.MetaTileEntityLoader.registerMachineRecipe;

public class Machines {
    public static void init(Consumer<FinishedRecipe> provider) {

        EVCraftingComponent.initialiseComponents();

        // TODO machine recipes like input hatches and component blocks

        for (int tier = 0; tier < ENERGY_INPUT_HATCH.length; tier++){

            VanillaRecipeHelper.addShapelessRecipe(provider, GTValues.VN[tier] + "_energy_hatch", ENERGY_INPUT_HATCH[tier].asStack(), HULL[tier].asStack(), CraftingComponent.CABLE.getIngredient(tier));
        }

        for (int tier = 0; tier < EVMachines.ROBOT_ARM_COMPONENT.length; tier++){

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase() + "robot_arm_component")
                    .inputItems(CraftingComponent.CABLE.getIngredient(tier),8)
                    .inputItems(HULL[tier].asStack())
                    .inputItems(EVCraftingComponent.ROBOT_ARM.getIngredient(tier), 2)
                    .inputFluids(GTMaterials.SolderingAlloy.getFluid(288))
                    .outputItems(EVMachines.ROBOT_ARM_COMPONENT[tier].asStack())
                    .EUt(VA[tier])
                    .duration(20*10)
                    .save(provider);
        }

        registerMachineRecipe(provider, EVMachines.CHEMICAL_DEHYDRATOR,
                "FCF",
                "WHW",
                "PRP",
                'F', CraftingComponent.COIL_HEATING_DOUBLE,
                'W', CraftingComponent.CABLE_QUAD,
                'H', CraftingComponent.HULL,
                'P', CraftingComponent.PLATE,
                'C', EVCraftingComponent.CIRCUIT,
                'R', EVCraftingComponent.PUMP
                );

        for (int tier = 0; tier < EVMachines.CONVEYOR_COMPONENT.length; tier++){

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase() + "conveyor_component")
                    .inputItems(CraftingComponent.CABLE.getIngredient(tier),8)
                    .inputItems(HULL[tier].asStack())
                    .inputItems(EVCraftingComponent.CONVEYOR.getIngredient(tier), 2)
                    .inputFluids(GTMaterials.SolderingAlloy.getFluid(288))
                    .outputItems(EVMachines.CONVEYOR_COMPONENT[tier].asStack())
                    .EUt(VA[tier])
                    .duration(20*10)
                    .save(provider);
        }


    }
}

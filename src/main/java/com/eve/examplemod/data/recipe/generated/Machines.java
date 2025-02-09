package com.eve.examplemod.data.recipe.generated;

import com.eve.examplemod.common.data.machines.EVMachines;
import com.eve.examplemod.data.recipe.EVCraftingComponent;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.GTValues.VN;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.block;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.HULL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Glass;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.*;
import static com.gregtechceu.gtceu.data.recipe.misc.MetaTileEntityLoader.registerMachineRecipe;

public class Machines {
    public static void init(Consumer<FinishedRecipe> provider) {

        EVCraftingComponent.initialiseComponents();

        // TODO machine recipes like input hatches and component blocks

        for (var machine : SUPER_TANK){
            if (machine == null) continue;
            int tier = machine.getTier();

            VanillaRecipeHelper.addShapedRecipe(provider, true, "tank_super_" + VN[tier].toLowerCase(),
                    machine.asStack(),
                    "CPC",
                    "IHI",
                    "CIC",
                    'H', HULL[tier].asStack(),
                    'I', PLATE.getIngredient(tier),
                    'C', CIRCUIT.getIngredient(tier),
                    'P', EVCraftingComponent.PUMP.getIngredient(tier)
                    );
        }

        for (var machine : GTMachines.FLUID_IMPORT_HATCH) {
            if (machine == null) continue;
            int tier = machine.getTier();

                GTRecipeTypes.ASSEMBLER_RECIPES
                        .recipeBuilder("fluid_hatch_" + VN[tier].toLowerCase())
                        .inputItems(CraftingComponent.HULL.getIngredient(tier))
                        .inputItems(ChemicalHelper.get(block, Glass))
                        .circuitMeta(1)
                        .outputItems(machine)
                        .duration(300)
                        .EUt(VA[tier])
                        .save(provider);

                VanillaRecipeHelper.addShapedRecipe(provider, true, "fluid_hatch_crafting_" + VN[tier].toLowerCase(),
                        FLUID_IMPORT_HATCH[tier].asStack(),
                        "G",
                        "H",
                        'G', ChemicalHelper.get(block, Glass),
                        'H', HULL[tier].asStack()
                );
        }

//        List<BlockEntry<CoilBlock>> coilList = List.of(COIL_TITAN_STEEL, COIL_PIKYONIUM, COIL_BLACK_TITANIUM, COIL_NEUTRONIUM, COIL_COSMIC_NEUTRONIUM
//        //        , COIL_INFINITY, COIL_ETERNITY
//        );
//        List<Material> materialList = List.of(TitanSteel, Pikyonium, BlackTitanium, Neutronium, CosmicNeutronium, TitanSteel, TitanSteel);
//        List<Material> fluidList = List.of(Tritanium, Adamantium, Vibranium, Cinobite, Neutronium, CosmicNeutronium, CosmicNeutronium);
//
//
//        coilList.forEach(coil -> {
//                    ASSEMBLER_RECIPES.recipeBuilder(coil.getId())
//                            .inputItems(MICA_INSULATOR_FOIL, 8)
//                            .inputItems(wireGtDouble, materialList.get(coilList.indexOf(coil)), 6)
//                            .inputFluids(fluidList.get(coilList.indexOf(coil)).getFluid(144))
//                            .outputItems(coil.asItem())
//                            .EUt(GTValues.VA[coil.get().coilType.getTier()])
//                            .duration(5*20)
//                            .save(provider);
//        }
//        );

        for (var machine : GTMachines.FLUID_EXPORT_HATCH) {
            if (machine == null) continue;
            int tier = machine.getTier();
                GTRecipeTypes.ASSEMBLER_RECIPES
                        .recipeBuilder("fluid_export_hatch_" + VN[tier].toLowerCase())
                        .inputItems(CraftingComponent.HULL.getIngredient(tier))
                        .inputItems(ChemicalHelper.get(block, Glass))
                        .circuitMeta(2)
                        .outputItems(machine)
                        .duration(300)
                        .EUt(VA[tier])
                        .save(provider);

            VanillaRecipeHelper.addShapedRecipe(provider, true, "fluid_export_hatch_crafting_" + VN[tier].toLowerCase(),
                    FLUID_EXPORT_HATCH[tier].asStack(),
                    "H",
                    "G",
                    'G', ChemicalHelper.get(block, Glass),
                    'H', HULL[tier].asStack()
            );
        }

        for (var machine : GTMachines.ITEM_IMPORT_BUS) {
            if (machine == null) continue;
            int tier = machine.getTier();
                GTRecipeTypes.ASSEMBLER_RECIPES
                        .recipeBuilder("evitem_import_bus_" + VN[tier].toLowerCase())
                        .inputItems(Tags.Items.CHESTS_WOODEN)
                        .inputItems(CraftingComponent.HULL.getIngredient(tier))
                        .circuitMeta(1)
                        .outputItems(machine)
                        .duration(300)
                        .EUt(VA[tier])
                        .save(provider);

            VanillaRecipeHelper.addShapedRecipe(provider, true, "item_import_bus_crafting_" + VN[tier].toLowerCase(),
                    ITEM_IMPORT_BUS[tier].asStack(),
                    "G",
                    "H",
                    'G', Tags.Items.CHESTS_WOODEN,
                    'H', HULL[tier].asStack()
            );

        }

        for (var machine : GTMachines.ITEM_EXPORT_BUS) {
            if (machine == null) continue;
            int tier = machine.getTier();
                GTRecipeTypes.ASSEMBLER_RECIPES
                        .recipeBuilder("evitem_export_bus_" + VN[tier].toLowerCase())
                        .inputItems(CraftingComponent.HULL.getIngredient(tier))
                        .inputItems(Tags.Items.CHESTS_WOODEN)
                        .circuitMeta(2)
                        .outputItems(machine)
                        .duration(300)
                        .EUt(VA[tier])
                        .save(provider);

            VanillaRecipeHelper.addShapedRecipe(provider, true, "item_export_bus_crafting_" + VN[tier].toLowerCase(),
                    ITEM_EXPORT_BUS[tier].asStack(),
                    "H",
                    "G",
                    'G', Tags.Items.CHESTS_WOODEN,
                    'H', HULL[tier].asStack()
            );
        }

        for (int tier = 0; tier < ENERGY_INPUT_HATCH.length; tier++){

            VanillaRecipeHelper.addShapelessRecipe(provider, GTValues.VN[tier] + "_energy_hatch", ENERGY_INPUT_HATCH[tier].asStack(), HULL[tier].asStack(), CraftingComponent.CABLE.getIngredient(tier));
        }

        for (int tier = 0; tier < EVMachines.ROBOT_ARM_COMPONENT.length; tier++){

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase() + "_robot_arm_component")
                    .inputItems(CraftingComponent.CABLE.getIngredient(tier),8)
                    .inputItems(HULL[tier].asStack())
                    .inputItems(EVCraftingComponent.ROBOT_ARM.getIngredient(tier), 2)
                    .inputFluids(GTMaterials.SolderingAlloy.getFluid(288))
                    .outputItems(EVMachines.ROBOT_ARM_COMPONENT[tier].asStack())
                    .EUt(VA[tier])
                    .duration(20*10)
                    .save(provider);
        }
        for (int tier = 0; tier < EVMachines.INTEGRAL_FRAMEWORK.length; tier++){
            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase() + "_integral_framework").EUt(tier).duration(100)
                    .inputItems(EVCraftingComponent.CIRCUIT.getIngredient(tier), 4)
                    .inputItems(EVCraftingComponent.HULL.getIngredient(tier))
                    .inputItems(EVCraftingComponent.CABLE_QUAD.getIngredient(tier))
                    .inputItems(EVCraftingComponent.PLATE.getIngredient(tier), 4)
                    .inputItems(EVCraftingComponent.GEAR.getIngredient(tier), 4)
                    .outputItems(EVMachines.INTEGRAL_FRAMEWORK[tier].asStack())
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

        registerMachineRecipe(provider, EVMachines.HARVESTER,
                "PGP",
                "CHC",
                "DDD",
                'H', CraftingComponent.HULL,
                'P', EVCraftingComponent.PISTON,
                'C', EVCraftingComponent.CIRCUIT,
                'G', GRINDER,
                'D', PLATE
        );

        registerMachineRecipe(provider, EVMachines.SPAWNER,
                "SPE",
                "CHC",
                "DDD",
                'H', CraftingComponent.HULL,
                'P', EVCraftingComponent.PUMP,
                'C', EVCraftingComponent.CIRCUIT,
                'E', EMITTER,
                'S', EVCraftingComponent.SENSOR,
                'D', PLATE
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

package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVBlocks;
import com.eve.examplemod.common.data.EVMachines;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.BrightSteel;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMultiMachines.PRIMITIVE_BLAST_FURNACE;
import static net.minecraft.world.item.Items.*;

public class MiscRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {


        VanillaRecipeHelper.addSmeltingRecipe(provider, "wrought_iron", ChemicalHelper.get(ingot, Iron),ChemicalHelper.get(ingot, WroughtIron));


            VanillaRecipeHelper.addShapedRecipe(provider, true, id("industrial_primitive_blast_furnace"),
                    EVMachines.INDUSTRIAL_PRIMITIVE_BLAST_FURNACE.asStack(1),
                    "PFP",
                    "FTF",
                    "PFP",
                    'P', CASING_PRIMITIVE_BRICKS.asStack(),
                    'F', FURNACE.asItem(),
                    'T', PRIMITIVE_BLAST_FURNACE.asStack());


        VanillaRecipeHelper.addShapedRecipe(provider, true, id("emitter_ev"),
                GTItems.EMITTER_EV.asStack(),
                "WRC",
                "RER",
                "CRW",
                'E', ChemicalHelper.get(gem, EnderPearl),
                'R', ChemicalHelper.get(rod, Platinum),
                'W', ChemicalHelper.get(cableGtSingle, Aluminium),
                'C', EVCraftingComponent.CIRCUIT.getIngredient(GTValues.EV));

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("iv_electric_motor"),
                ELECTRIC_MOTOR_IV.asStack(),
                "TWR",
                "WMW",
                "RWT",
                'W', ChemicalHelper.get(wireGtQuadruple, BrightSteel),
                'T', ChemicalHelper.get(cableGtSingle, Tungsten),
                'R', ChemicalHelper.get(rod, TungstenSteel),
                'M', ChemicalHelper.get(rod, NeodymiumMagnetic));

        ASSEMBLER_RECIPES.recipeBuilder("iv_electric_motor").EUt(7680).duration(100)
                .inputItems(ChemicalHelper.get(wireGtQuadruple, BrightSteel), 4)
                .inputItems(ChemicalHelper.get(rod, TungstenSteel), 2)
                .inputItems( ChemicalHelper.get(cableGtSingle, Tungsten), 2)
                .inputItems(ChemicalHelper.get(rod, NeodymiumMagnetic))
                .outputItems(ELECTRIC_MOTOR_IV.asStack())
                .save(provider);

        // TODO probably add upgraded recipes for fusion coils
        ASSEMBLER_RECIPES.recipeBuilder("evsuperconducting_coil").EUt(VA[LuV])
                .inputItems(wireGtDouble, IndiumTinBariumTitaniumCuprate, 32)
                .inputItems(foil, NiobiumTitanium, 32)
                .inputFluids(NaquadahAlloy.getFluid(GTValues.L * 24))
                .outputItems(GTBlocks.SUPERCONDUCTING_COIL.asStack())
                .duration(100).save(provider);


        VanillaRecipeHelper.addShapedRecipe(provider, true, id("circuit_assembly_line"),
                EVMachines.CIRCUIT_ASSEMBLY_LINE.asStack(),
                "ARA",
                "CHC",
                "ARA",
                'C', EVCraftingComponent.CIRCUIT.getIngredient(GTValues.LuV),
                'H', EVCraftingComponent.HULL.getIngredient(GTValues.LuV),
                'A', CASING_ASSEMBLY_CONTROL,
                'R', EVCraftingComponent.ROBOT_ARM.getIngredient(GTValues.LuV));

        ASSEMBLY_LINE_RECIPES.recipeBuilder("evrobot_arm_luv")
                .inputItems(rodLong, HSSS, 4)
                .inputItems(gear, HSSS)
                .inputItems(gearSmall, HSSS, 3)
                .inputItems(ELECTRIC_MOTOR_LuV, 2)
                .inputItems(ELECTRIC_PISTON_LuV)
                .inputItems(CustomTags.LuV_CIRCUITS)
                .inputItems(CustomTags.IV_CIRCUITS, 2)
                .inputItems(CustomTags.EV_CIRCUITS, 4)
                .inputItems(cableGtDouble, YttriumBariumCuprate, 16)
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .inputFluids(Lubricant.getFluid(250))
                .outputItems(ROBOT_ARM_LuV)
//                .scannerResearch(b -> b
//                        .researchStack(ROBOT_ARM_IV.asStack())
//                        .duration(900)
//                        .EUt(VA[EV]))
                .duration(600).EUt(6000).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("biodiesel_creosote_oil_methanol")
                .inputItems(dustTiny, SodiumHydroxide)
                .outputFluids(BioDiesel.getFluid(6000))
                .outputFluids(Glycerol.getFluid(1000))
                .inputFluids(Creosote.getFluid(6000))
                .inputFluids(Methanol.getFluid(1000))
                .save(provider);

        VanillaRecipeHelper.addSmeltingRecipe(provider, id("precious_metal_smelting"),
                ChemicalHelper.get(ingot, PreciousMetal), ChemicalHelper.get(nugget, Gold, 2), 1);

        // todo fix blasting recipe
//        VanillaRecipeHelper.addBlastingRecipe(provider, id("precious_metal_blasting"),
//                ChemicalHelper.get(ingot, PreciousMetal), ChemicalHelper.get(nugget, Gold, 2), 1);

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("quartz_block_2x2"),
                QUARTZ_BLOCK.getDefaultInstance(),
                "QQ",
                "QQ",
                'Q', QUARTZ);

        VanillaRecipeHelper.addShapelessRecipe(provider, id("straight_rubber"),
                EVBlocks.STRAIGHT_RUBBER_SAPLING.asStack(),
                RUBBER_SAPLING.asStack(),
                STICK);

        VanillaRecipeHelper.addShapelessRecipe(provider, id("ulv_motor"),
                ELECTRIC_MOTOR_ULV.asStack(3),
                ChemicalHelper.get(plate, Lead),
                ChemicalHelper.get(wireGtSingle, Lead),
                ChemicalHelper.get(rod, IronMagnetic));

        VanillaRecipeHelper.addShapelessRecipe(provider, id("ulv_conveyor_kelp"),
                CONVEYOR_MODULE_ULV.asStack(1),
                DRIED_KELP,
                DRIED_KELP,
                ELECTRIC_MOTOR_ULV,
                ELECTRIC_MOTOR_ULV);

        VanillaRecipeHelper.addShapelessRecipe(provider, id("ulv_conveyor"),
                CONVEYOR_MODULE_ULV.asStack(1),
                ChemicalHelper.get(plate, Rubber),
                ChemicalHelper.get(plate, Rubber),
                ELECTRIC_MOTOR_ULV,
                ELECTRIC_MOTOR_ULV);

        VanillaRecipeHelper.addShapelessRecipe(provider, id("ulv_piston"),
                ELECTRIC_PISTON_ULV.asStack(),
                ChemicalHelper.get(plate, Lead),
                ELECTRIC_MOTOR_ULV,
                ChemicalHelper.get(rod, Lead),
                ChemicalHelper.get(gear, Iron));

        VanillaRecipeHelper.addShapelessRecipe(provider, id("ulv_pump"),
                ELECTRIC_PUMP_ULV.asStack(),
                ChemicalHelper.get(rotor, Tin),
                ELECTRIC_MOTOR_ULV,
                ChemicalHelper.get(pipeSmallFluid, Bronze));

        VanillaRecipeHelper.addShapelessRecipe(provider, id("robot_arm_ulv"),
                ROBOT_ARM_ULV.asStack(),
                ChemicalHelper.get(rod, Lead),
                ELECTRIC_MOTOR_ULV,
                VACUUM_TUBE,
                ELECTRIC_PISTON_ULV);


        CHEMICAL_RECIPES.recipeBuilder("biodiesel_creosote_oil_ethanol")
                .inputItems(dustTiny, SodiumHydroxide)
                .outputFluids(BioDiesel.getFluid(6000))
                .outputFluids(Glycerol.getFluid(1000))
                .inputFluids(Creosote.getFluid(6000))
                .inputFluids(Ethanol.getFluid(1000))
                .save(provider);

        COKE_OVEN_RECIPES.recipeBuilder("charcoal_coke_oven")
                .inputItems(gem, Charcoal)
                .outputItems(gem, Coke)
                .outputFluids(Creosote.getFluid(1750))
                .save(provider);

        BLAST_RECIPES.recipeBuilder("blast_silicon_1")
                .blastFurnaceTemp(1700)
                .inputItems(dust, Silicon)
                .outputItems(ingot, Silicon)
                .EUt(128)
                .duration(50*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_cupronickel_alumino_silicate")
                .inputItems(dust, AluminoSilicateWool, 12)
                .inputItems(wireGtDouble, Cupronickel, 6)
                .inputFluids(Tin.getFluid(144))
                .outputItems(COIL_CUPRONICKEL.asItem())
                .EUt(32)
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_cupronickel")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, Cupronickel, 6)
                .inputFluids(Tin.getFluid(144))
                .outputItems(COIL_CUPRONICKEL.asItem())
                .EUt(32)
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_kanthal")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, Kanthal, 6)
                .inputFluids(Copper.getFluid(144))
                .outputItems(COIL_KANTHAL.asItem())
                .EUt(V[GTValues.MV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_kanthal")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, Nichrome, 6)
                .inputFluids(Aluminium.getFluid(144))
                .outputItems(COIL_KANTHAL.asItem())
                .EUt(V[GTValues.HV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_rtm_alloy")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, RTMAlloy, 6)
                .inputFluids(Nichrome.getFluid(144))
                .outputItems(COIL_RTMALLOY.asItem())
                .EUt(V[GTValues.EV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_hssg")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, HSSG, 6)
                .inputFluids(Tungsten.getFluid(144))
                .outputItems(COIL_HSSG.asItem())
                .EUt(V[GTValues.IV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_naquadah")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, Naquadah, 6)
                .inputFluids(HSSG.getFluid(144))
                .outputItems(COIL_NAQUADAH.asItem())
                .EUt(V[GTValues.LuV])
                .duration(5*20)
                .save(provider);



        CHEMICAL_RECIPES.recipeBuilder("sodium_hydroxide")
                .EUt(32)
                .inputItems(dust, Sodium, 2)
                .inputFluids(Water.getFluid(2000))
                .outputItems(dust, SodiumHydroxide, 2)
                .outputFluids(Hydrogen.getFluid(1000))
                .duration(20*50)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("epoxy_petrochem")
                .inputFluids(NitrogenDioxide.getFluid(1000))
                .inputFluids(Naphtha.getFluid(30000))
                .inputFluids(Epichlorohydrin.getFluid(144))
                .outputFluids(Epoxy.getFluid(288))
                .EUt(120)
                .duration(20*20)
                .save(provider);
    }
}

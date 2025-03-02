package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVBlocks;
import com.eve.examplemod.common.data.machines.EVMachines;
import com.eve.examplemod.common.data.machines.EVMultiMachines;
import com.eve.examplemod.config.EVConfig;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.BlockTags;

import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.BrightSteel;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials.Color.Magenta;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMultiMachines.PRIMITIVE_BLAST_FURNACE;
import static net.minecraft.world.item.Items.*;

public class MiscRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {

        if (EVConfig.INSTANCE.evEndAccess) end(provider);

        CHEMICAL_RECIPES.recipeBuilder("polystyrene_from_air")
                .circuitMeta(1)
                .inputFluids(Air.getFluid(1000))
                .inputFluids(Styrene.getFluid(L))
                .outputFluids(Polystyrene.getFluid(L))
                .duration(160).EUt(VA[LV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("polystyrene_from_oxygen")
                .circuitMeta(1)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(Styrene.getFluid(L))
                .outputFluids(Polystyrene.getFluid(216))
                .duration(160).EUt(VA[LV]).save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("polystyrene_from_tetrachloride_air")
                .circuitMeta(3)
                .inputFluids(Air.getFluid(7500))
                .inputFluids(Styrene.getFluid(2160))
                .inputFluids(TitaniumTetrachloride.getFluid(100))
                .outputFluids(Polystyrene.getFluid(3240))
                .duration(800).EUt(VA[LV]).save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("polystyrene_from_tetrachloride_oxygen")
                .circuitMeta(3)
                .inputFluids(Oxygen.getFluid(7500))
                .inputFluids(Styrene.getFluid(2160))
                .inputFluids(TitaniumTetrachloride.getFluid(100))
                .outputFluids(Polystyrene.getFluid(4320))
                .duration(800).EUt(VA[LV]).save(provider);


        VanillaRecipeHelper.addSmeltingRecipe(provider, "wrought_iron", ChemicalHelper.get(ingot, Iron),ChemicalHelper.get(ingot, WroughtIron));


            VanillaRecipeHelper.addShapedRecipe(provider, true, id("industrial_primitive_blast_furnace"),
                    EVMultiMachines.INDUSTRIAL_PRIMITIVE_BLAST_FURNACE.asStack(1),
                    "PFP",
                    "FTF",
                    "PFP",
                    'P', CASING_PRIMITIVE_BRICKS.asStack(),
                    'F', FURNACE.asItem(),
                    'T', PRIMITIVE_BLAST_FURNACE.asStack());


        VanillaRecipeHelper.addShapedRecipe(provider, true, id("ev_emitter_ev"),
                GTItems.EMITTER_EV.asStack(),
                "WRC",
                "RER",
                "CRW",
                'E', ChemicalHelper.get(gem, EnderPearl),
                'R', ChemicalHelper.get(rod, Platinum),
                'W', ChemicalHelper.get(cableGtSingle, Aluminium),
                'C', EVCraftingComponent.CIRCUIT.getIngredient(GTValues.EV));

        VanillaRecipeHelper.addShapelessRecipe(provider, id("lv_superconductor_dust"),
                ChemicalHelper.get(dust, LVSuperconductor, 9),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Tin),
                ChemicalHelper.get(dust, Antimony)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("iv_electric_motor"),
                ELECTRIC_MOTOR_IV.asStack(),
                "TWR",
                "WMW",
                "RWT",
                'W', ChemicalHelper.get(wireGtDouble, BrightSteel),
                'T', ChemicalHelper.get(cableGtSingle, Tungsten),
                'R', ChemicalHelper.get(rod, TungstenSteel),
                'M', ChemicalHelper.get(rod, NeodymiumMagnetic));

        // i dont like how you have to centrifuge it to get rid of the () around the SiO2 lol
        // yeah yeah balance but i think it used to be this way in old gt as well
        ELECTROLYZER_RECIPES.recipeBuilder("glass_dust_electrolysis").EUt(30).duration(60)
                .inputItems(dust, Glass, 3)
                .outputItems(dust, Silicon)
                .outputFluids(Oxygen.getFluid(2000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("iv_electric_motor").EUt(7680).duration(100)
                .inputItems(ChemicalHelper.get(wireGtDouble, BrightSteel), 4)
                .inputItems(ChemicalHelper.get(rod, TungstenSteel), 2)
                .inputItems( ChemicalHelper.get(cableGtSingle, Tungsten), 2)
                .inputItems(ChemicalHelper.get(rod, NeodymiumMagnetic))
                .outputItems(ELECTRIC_MOTOR_IV.asStack())
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("sugarcane_to_chad_macerator").EUt(20).duration(30)
                .inputItems(SUGAR_CANE)
                .outputItems(dust, Paper)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("sand_to_clay").EUt(10).duration(10)
                .inputItems(SAND)
                .outputItems(CLAY)
                .inputFluids(Water.getFluid(125))
                .save(provider);

        GAS_TURBINE_FUELS.recipeBuilder("nitro_benzene_fuel")
                .EUt(-32)
                .duration(100)
                .inputFluids(Nitrobenzene.getFluid(1))
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

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("evfluid_filter"),
                FLUID_FILTER.asStack(),
                "ZZZ",
                "ZLZ",
                "ZZZ",
                'L', ChemicalHelper.get(gem, Lapis),
                'H', ChemicalHelper.get(foil, Zinc));

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
                .outputFluids(Creosote.getFluid(80 * 8))
                .duration(20 * 8)
                .save(provider);

        COKE_OVEN_RECIPES.recipeBuilder("charcoal_from_log_coke_oven")
                .inputItems(BlockTags.LOGS_THAT_BURN)
                .outputItems(CHARCOAL)
                .outputFluids(Creosote.getFluid(300 * 8))
                .duration(20 * 4 * 8)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("blast_silicon_1")
                .blastFurnaceTemp(1700)
                .inputItems(dust, Silicon)
                .outputItems(ingot, Silicon)
                .circuitMeta(1)
                .EUt(128)
                .duration(50*20)
                .save(provider);

//        BLAST_RECIPES.recipeBuilder("blast_silicon_2")
////                .blastFurnaceTemp(1700)
////                .inputItems(dust, Silicon)
////                .outputItems(ingot, Silicon)
////                .inputFluids(Nitrogen.getFluid(1000))
////                .circuitMeta(2)
////                .EUt(128)
////                .duration(27*20)
////                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_cupronickel_alumino_silicate")
                .inputItems(dust, AluminoSilicateWool, 12)
                .inputItems(wireGtDouble, Cupronickel, 6)
                .inputFluids(Tin.getFluid(144))
                .outputItems(COIL_CUPRONICKEL.asItem())
                .EUt(32)
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_cupronickel_mica")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, Cupronickel, 6)
                .inputFluids(Tin.getFluid(144))
                .outputItems(COIL_CUPRONICKEL.asItem())
                .EUt(32)
                .duration(5*20)
                .save(provider);

//        ASSEMBLER_RECIPES.recipeBuilder("coil_kanthal_mica")
//                .inputItems(MICA_INSULATOR_FOIL, 8)
//                .inputItems(wireGtDouble, Kanthal, 6)
//                .inputFluids(Copper.getFluid(144))
//                .outputItems(COIL_KANTHAL.asItem())
//                .EUt(V[GTValues.MV])
//                .duration(5*20)
//                .save(provider);

                ASSEMBLER_RECIPES.recipeBuilder("coil_nichrome_mica")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, Nichrome, 6)
                .inputFluids(Aluminium.getFluid(144))
                .outputItems(COIL_NICHROME.asItem())
                .EUt(VA[GTValues.MV])
                .duration(5*20)
                .save(provider);

//        ASSEMBLER_RECIPES.recipeBuilder("coil_kanthal")
//                .inputItems(MICA_INSULATOR_FOIL, 8)
//                .inputItems(wireGtDouble, Nichrome, 6)
//                .inputFluids(Aluminium.getFluid(144))
//                .outputItems(COIL_KANTHAL.asItem())
//                .EUt(V[GTValues.HV])
//                .duration(5*20)
//                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_rtm_alloy_mica")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, RTMAlloy, 6)
                .inputFluids(Nichrome.getFluid(144))
                .outputItems(COIL_RTMALLOY.asItem())
                .EUt(V[GTValues.EV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_hssg_mica")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, HSSG, 6)
                .inputFluids(Tungsten.getFluid(144))
                .outputItems(COIL_HSSG.asItem())
                .EUt(V[GTValues.IV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_naquadah_mica")
                .inputItems(MICA_INSULATOR_FOIL, 8)
                .inputItems(wireGtDouble, Naquadah, 6)
                .inputFluids(HSSG.getFluid(144))
                .outputItems(COIL_NAQUADAH.asItem())
                .EUt(V[GTValues.LuV])
                .duration(5*20)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("sodium_hydroxide")
                .EUt(30)
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

        CHEMICAL_RECIPES.recipeBuilder("nitrogen_dioxide").EUt(30).duration(30*20)
                .inputFluids(Nitrogen.getFluid(1000))
                .inputFluids(Oxygen.getFluid(2000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .circuitMeta(3)
                .save(provider);
    }
    public static void end(Consumer<FinishedRecipe> provider) {
        CHEMICAL_RECIPES.recipeBuilder("eye_of_ender")
                .EUt(VA[EV])
                .inputItems(ENDER_PEARL)
                .inputItems(BLAZE_ROD)
                .outputItems(ENDER_EYE)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("hv_emitter_ruby").EUt(30)
                .inputItems(ChemicalHelper.get(rod, Chromium), 4)
                .inputItems(ChemicalHelper.get(cableGtSingle, Gold))
                .inputItems(EVCraftingComponent.CIRCUIT.getIngredient(HV), 2)
                .inputItems(ChemicalHelper.get(gemFlawless, Ruby))
                .circuitMeta(1)
                .outputItems(EMITTER_HV.get())
                .save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("hv_emitter_ruby"),
                EMITTER_HV.asStack(),
                "GRC",
                "RFR",
                "CRG",
                'G', ChemicalHelper.get(cableGtSingle, Gold),
                'R', ChemicalHelper.get(rod, Chromium),
                'C', EVCraftingComponent.CIRCUIT.getIngredient(HV),
                'F', ChemicalHelper.get(gemFlawless, Ruby)
                );

        // item recipes

        CANNER_RECIPES.recipeBuilder("bose_einstein_cooling_container").duration(280).EUt(90000)
                .inputItems(EMPTY_LASER_COOLING_CONTAINER)
                .inputFluids(Rubidium.getFluid(L * 2))
                .outputItems(BOSE_EINSTEIN_COOLING_CONTAINER)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("laser_diode").duration(260).EUt(980000)
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .inputItems(SMD_DIODE_BIOWARE)
                .inputItems(lens, Magenta)
                .inputItems(wireFine, Gold, 3)
                .outputItems(LASER_DIODE)
                .save(provider);

        // Laser Cooling Unit
        ASSEMBLER_RECIPES.recipeBuilder("laser_cooling_unit").duration(300).EUt(1200000)
                .inputFluids(SolderingAlloy.getFluid(L * 2))
                .inputItems(wireFine, Gold, 4)
                .inputItems(CASING_ALUMINIUM_FROSTPROOF.asItem())
                .inputItems(LASER_DIODE)
                .inputItems(CraftingComponent.CIRCUIT.getIngredient(HV))
                .outputItems(LASER_COOLING_UNIT)
                .save(provider);


        ASSEMBLER_RECIPES.recipeBuilder("empty_laser_cooling_container").duration(380).EUt(1150000)
                .inputItems(plate, Steel, 32)
                .inputItems(LASER_COOLING_UNIT)
                .inputItems(MAGNETIC_TRAP)
                .inputFluids(SolderingAlloy.getFluid(L))
                .outputItems(EMPTY_LASER_COOLING_CONTAINER)
                .save(provider);

        // Magnetic Trap
        ASSEMBLER_RECIPES.recipeBuilder("magnetic_trap").duration(480).EUt(1000000)
                .inputFluids(SolderingAlloy.getFluid(L * 3))
                .inputItems(wireGtDouble, UVSuperconductor, 2)
                .inputItems(CASING_ALUMINIUM_FROSTPROOF.asItem())
                .outputItems(MAGNETIC_TRAP)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("glowstone_mixing").duration(20*4).EUt(VA[LV])
                .inputItems(dust, Gold)
                .inputItems(dust, Redstone)
                .outputItems(dust, Glowstone, 2)
                .save(provider);

        // Gravi Star
        AUTOCLAVE_RECIPES.recipeBuilder("gravi_star").duration(480).EUt(7680)
                .inputItems(NETHER_STAR.asItem())
                .inputFluids(Dubnium.getFluid(L * 2))
                .outputItems(GRAVI_STAR)
                .save(provider);

        // Unstable Star
        AUTOCLAVE_RECIPES.recipeBuilder("unstable_star").duration(480).EUt(122880)
                .inputItems(GRAVI_STAR)
                .inputFluids(Adamantium.getFluid(L * 2))
                .outputItems(UNSTABLE_STAR)
                .save(provider);
    }

}

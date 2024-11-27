package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVItems;
import com.eve.examplemod.common.data.EVMachines;
import com.eve.examplemod.common.machine.multiblock.primitive.IndustrialPrimitiveBlastFurnace;
import com.eve.examplemod.data.recipe.serialized.chemistry.MicaInsulator;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.ACTIVE_COOLER_RECIPES;
import static com.gregtechceu.gtceu.api.GTValues.V;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.ELECTRIC_BLAST_FURNACE;
import static com.gregtechceu.gtceu.common.data.GTMachines.PRIMITIVE_BLAST_FURNACE;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
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



        CHEMICAL_RECIPES.recipeBuilder("biodiesel_creosote_oil_methanol")
                .inputItems(dustTiny, SodiumHydroxide)
                .outputFluids(BioDiesel.getFluid(6000))
                .outputFluids(Glycerol.getFluid(1000))
                .inputFluids(Creosote.getFluid(6000))
                .inputFluids(Methanol.getFluid(1000))
                .save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("quartz_block_2x2"),
                QUARTZ_BLOCK.getDefaultInstance(),
                "QQ",
                "QQ",
                'Q', QUARTZ);

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
                .inputItems(mica_insulator_foil, 8)
                .inputItems(wireGtDouble, Cupronickel, 6)
                .inputFluids(Tin.getFluid(144))
                .outputItems(COIL_CUPRONICKEL.asItem())
                .EUt(32)
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_kanthal")
                .inputItems(mica_insulator_foil, 8)
                .inputItems(wireGtDouble, Kanthal, 6)
                .inputFluids(Copper.getFluid(144))
                .outputItems(COIL_KANTHAL.asItem())
                .EUt(V[GTValues.MV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_kanthal")
                .inputItems(mica_insulator_foil, 8)
                .inputItems(wireGtDouble, Nichrome, 6)
                .inputFluids(Aluminium.getFluid(144))
                .outputItems(COIL_KANTHAL.asItem())
                .EUt(V[GTValues.HV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_rtm_alloy")
                .inputItems(mica_insulator_foil, 8)
                .inputItems(wireGtDouble, RTMAlloy, 6)
                .inputFluids(Nichrome.getFluid(144))
                .outputItems(COIL_RTMALLOY.asItem())
                .EUt(V[GTValues.EV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_hssg")
                .inputItems(mica_insulator_foil, 8)
                .inputItems(wireGtDouble, HSSG, 6)
                .inputFluids(Tungsten.getFluid(144))
                .outputItems(COIL_HSSG.asItem())
                .EUt(V[GTValues.IV])
                .duration(5*20)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("coil_naquadah")
                .inputItems(mica_insulator_foil, 8)
                .inputItems(wireGtDouble, Naquadah, 6)
                .inputFluids(HSSG.getFluid(144))
                .outputItems(COIL_NAQUADAH.asItem())
                .EUt(V[GTValues.LuV])
                .duration(5*20)
                .save(provider);

        ACTIVE_COOLER_RECIPES.recipeBuilder("cryotheum")
                .inputFluids(Cryotheum.getFluid(1))
                .duration(20)
                .save(provider);
    }
}

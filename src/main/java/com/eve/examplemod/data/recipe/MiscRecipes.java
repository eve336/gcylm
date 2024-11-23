package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVMachines;
import com.eve.examplemod.common.machine.multiblock.primitive.IndustrialPrimitiveBlastFurnace;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_PRIMITIVE_BRICKS;
import static com.gregtechceu.gtceu.common.data.GTMachines.PRIMITIVE_BLAST_FURNACE;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.CHEMICAL_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.COKE_OVEN_RECIPES;
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




    }
}

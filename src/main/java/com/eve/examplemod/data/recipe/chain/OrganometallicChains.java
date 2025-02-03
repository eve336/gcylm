package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.api.data.tag.EVTagPrefix.dioxide;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.BLAST_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.CHEMICAL_RECIPES;

public class OrganometallicChains {
    public static void init(Consumer<FinishedRecipe> provider) {
        int chainNumber = 0;
        CHEMICAL_RECIPES.recipeBuilder("organometallic_chain_" + chainNumber++).duration(160).EUt(8000) //2CH4O -> CH3OCH3 + H2O
                .inputFluids(Methanol.getFluid(2000))
                .notConsumable(dust, Alumina)
                .notConsumable(dust, SiliconDioxide)
                .outputFluids(Dimethylether.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("organometallic_chain_" + chainNumber++).duration(160).EUt(2000) //CH3OCH3 + C2H4O -> C4H10O2
                .inputFluids(Dimethylether.getFluid(1000))
                .inputFluids(EthyleneOxide.getFluid(1000))
                .outputFluids(Dimethoxyethane.getFluid(1000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("organometallic_chain_" + chainNumber++).duration(160).EUt(2000) //C5H6 + LiC4H9 -> LiC5H5 + C4H10
                .inputFluids(Cyclopentadiene.getFluid(1000))
                .inputFluids(Dimethoxyethane.getFluid(500))
                .inputFluids(ButylLithium.getFluid(1000))
                .outputFluids(Butane.getFluid(1000))
                .outputFluids(LithiumCyclopentadienide.getFluid(1000))
                .save(provider);

        BLAST_RECIPES.recipeBuilder("organometallic_chain_" + chainNumber++).duration(1800).EUt(120) //2H + 2CfO2 -> Cf2O3 + H2O
                .blastFurnaceTemp(2500)
                .inputFluids(Hydrogen.getFluid(2000))
                .inputItems(dioxide, Californium, 6)
                .outputItems(CaliforniumTrioxide, 5)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("organometallic_chain_" + chainNumber++).duration(240).EUt(2000) //6HCl + Cf2O3 -> 2CfCl3 + 3H2O
                .inputFluids(HydrochloricAcid.getFluid(6000))
                .inputItems(CaliforniumTrioxide, 5)
                .outputItems(CaliforniumTrichloride, 8)
                .outputFluids(Water.getFluid(3000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("organometallic_chain_" + chainNumber++).duration(160).EUt(200000) //3LiC5H5 + CfCl3 -> CfC15H15 + 3LiCf
                .inputFluids(LithiumCyclopentadienide.getFluid(3000))
                .inputItems(CaliforniumTrichloride, 4)
                .outputItems(LithiumChloride, 6)
                .outputFluids(CaliforniumCyclopentadienide.getFluid(1000))
                .save(provider);
    }
}

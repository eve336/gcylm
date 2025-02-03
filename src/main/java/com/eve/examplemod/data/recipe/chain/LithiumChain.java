package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class LithiumChain {
    // TODO do we even need a lithium chain??
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // LiAlSi2O6 = LiAlSi2O6
        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(120).blastFurnaceTemp(1400)
                .inputItems(dust, Spodumene, 4)
                .outputItems(RoastedSpodumene)
                .save(provider);

        // KLi3Al4F2O10 + CaO = CaF2 + (KLi3Al4O10)O
        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(120).blastFurnaceTemp(1400)
                .inputItems(dust, Lepidolite, 8)
                .inputItems(dust, Quicklime, 2)
                .outputItems(RoastedLepidolite)
                .outputItems(dust, Fluorite, 3)
                .save(provider);

        // LiAlSi2O6 + H2SO4 = [LiAlO2 + H2SO4] + 2SiO2
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(120).EUt(120)
                .inputItems(RoastedSpodumene)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(DissolvedLithiumOre.getFluid(1000))
                .outputItems(dust, SiliconDioxide, 6)
                .save(provider);

        // (KLi3Al4O10)O + Al + 3H2SO4 = 3[LiAlO2 + H2SO4] + Al2O3 + K2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(140).EUt(120)
                .inputItems(RoastedLepidolite)
                .inputItems(dust, Aluminium)
                .inputFluids(SulfuricAcid.getFluid(3000))
                .outputFluids(DissolvedLithiumOre.getFluid(3000))
                .outputItems(dust, Potash, 3)
                .outputItems(Alumina,5)
                .save(provider);

        // 2[LiAlO2 + H2SO4] + H2SO4 + CO2 = Al2(SO4)3 + [Li2CO3 + H2O] + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(140).EUt(120)
                .inputFluids(DissolvedLithiumOre.getFluid(2000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .inputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(AluminiumSulfate,17)
                .outputFluids(LithiumCarbonateSolution.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .save(provider);

        // K2SO4 -> 2K + S + 4O
        ELECTROLYZER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(180).EUt(120)
                .inputItems(PotassiumSulfate,7)
                .outputItems(dust, Potassium, 2)
                .outputItems(dust, Sulfur)
                .outputFluids(Oxygen.getFluid(4000))
                .save(provider);

        // Al2(SO4)3 = 2Al + 3S + 12O
        ELECTROLYZER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(180).EUt(120)
                .inputItems(AluminiumSulfate,17)
                .outputItems(dust, Aluminium, 2)
                .outputItems(dust, Sulfur, 3)
                .outputFluids(Oxygen.getFluid(12000))
                .save(provider);

        // [Li2CO3 + H2O] + 2HCl + 2Na = 2[LiCl + H2O] + Na2CO3
        // off by 1 oxygen, which is fine since water is lost in dehydrator step
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(130).EUt(120)
                .inputItems(dust, Sodium, 2)
                .inputFluids(LithiumCarbonateSolution.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputItems(dust, SodaAsh, 6)
                .outputFluids(LithiumChlorideSolution.getFluid(2000))
                .save(provider);

        // [LiCl + H2O] = LiCl + H2O (H2O Voided - Dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(180).EUt(120)
                .inputFluids(LithiumChlorideSolution.getFluid(1000))
                .outputFluids(Chlorine.getFluid(1000))
                .outputItems(dust, Lithium)
                .save(provider);

        // Combined Step - Lepidolite
        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(1920).duration(200)
                .inputItems(dust, Lepidolite, 8)
                .inputFluids(SulfuricAcid.getFluid(3000))
                .outputItems(dust, LithiumFluoride, 4)
                .outputItems(dust, Potash, 3)
                .outputItems(AluminiumSulfate,17)
                .save(provider);

        // Combined Step - Spodumene
        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(1920).duration(200)
                .inputItems(dust, Spodumene, 8)
                .inputFluids(SulfuricAcid.getFluid(3000))
                .outputItems(dust, SiliconDioxide, 12)
                .outputItems(AluminiumSulfate,17)
                .outputItems(dust, Lithium, 2)
                .save(provider);
    }
}

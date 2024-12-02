package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;


public class Platline {
    public static void init(Consumer<FinishedRecipe> provider) {
        palladium(provider);
        platinum(provider);
    }

    public static void platinum(Consumer<FinishedRecipe> provider) {
        BLAST_RECIPES.recipeBuilder("iridium_gold_blast_recipe_001")
                .blastFurnaceTemp(775)
                .inputItems(dust, IridiumMetalResidue)
                .outputItems(dust, IridiumDioxide, 6)
                .outputItems(dust, PGSDResidue, 5)
                .EUt(120)
                .duration(200)
                .save(provider);

// (SiO2)2Au3 -> 2SiO2 + 3Au
        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder("pgsd_residue_to_silicon_gold_002")
                .inputItems(dust, PGSDResidue, 5)
                .outputItems(dust, SiliconDioxide, 6)
                .outputItems(dust, Gold, 3)
                .EUt(10)
                .duration(226)
                .save(provider);

// 2IrO2 + HCl -> (HCl)2(IrO2)2
        CHEMICAL_RECIPES.recipeBuilder("iridium_dioxide_hydrochloric_acid_003")
                .inputItems(dust, IridiumDioxide, 6)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputFluids(AcidicIridiumSolution.getFluid(1000))
                .duration(300)
                .EUt(30)
                .save(provider);

// (HCl)2(IrO2)2 + 4NH4Cl -> 4NH3 + 2IrCl3 + 3H2O
        CHEMICAL_RECIPES.recipeBuilder("iridium_chloride_ammonia_004")
                .inputFluids(AcidicIridiumSolution.getFluid(1000))
                .inputFluids(AmmoniumChloride.getFluid(3000))
                .outputFluids(Ammonia.getFluid(3000))
                .outputFluids(Water.getFluid(3000))
                .outputItems(dust, IridiumChloride, 8)
                .duration(300)
                .EUt(30)
                .save(provider);

// IrCl3 + 3H -> 3HCl + Ir + (CuNi)
        LARGE_CHEMICAL_RECIPES.recipeBuilder("iridium_chloride_hydrogen_005")
                .inputItems(dust, IridiumChloride, 4)
                .inputFluids(Hydrogen.getFluid(3000))
                .outputFluids(HydrochloricAcid.getFluid(3000))
                .outputItems(dust, PGSDResidue2, 2)
                .outputItems(dust, Iridium)
                .duration(300)
                .EUt(1920)
                .save(provider);

// Pt[REE] + [HNO3 + HCl] -> Pt[REE] + Ir2[REE]3
        CHEMICAL_RECIPES.recipeBuilder("platinum_aqua_regia_006")
                .inputItems(dust, PlatinumMetallicPowder, 18)
                .inputFluids(AquaRegia.getFluid(9000))
                .outputFluids(PlatinumConcentrate.getFluid(9000))
                .outputItems(dust, PlatinumResidue, 5)
                .EUt(30)
                .duration(100*20)
                .save(provider);

// HNO3 + HCl -> [HNO3 + HCl]
        MIXER_RECIPES.recipeBuilder("nitric_hydrochloric_to_aqua_regia_007")
                .inputFluids(NitricAcid.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(AquaRegia.getFluid(2000))
                .EUt(30)
                .duration(30)
                .save(provider);

// [HNO3 + HCl] -> HNO3 + HCl
        CENTRIFUGE_RECIPES.recipeBuilder("aqua_regia_to_nitric_hydrochloric_008")
                .inputFluids(AquaRegia.getFluid(2000))
                .outputFluids(NitricAcid.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .EUt(30)
                .duration(192)
                .save(provider);

// 2K + 2S + 7O -> K2S2O7
        MIXER_RECIPES.recipeBuilder("potassium_sulfur_oxygen_to_disulfate_009")
                .circuitMeta(0)
                .inputItems(dust, Potassium, 2)
                .inputItems(dust, Sulfur, 2)
                .inputFluids(Oxygen.getFluid(7000))
                .outputItems(dust, PotassiumDisulfate, 11)
                .EUt(96)
                .duration(42)
                .save(provider);

// Ir2[REE]3 + K2S2O7 + O -> Ir2[REE]2 + K2SO4 + RhSO4
        BLAST_RECIPES.recipeBuilder("iridium_residue_disulfate_blast_010")
                .inputItems(dust, PlatinumResidue, 5)
                .inputItems(dust, PotassiumDisulfate, 11)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, LeachResidue, 4)
                .outputItems(PotassiumSulfate, 7)
                .outputFluids(RhodiumSulfate.getFluid(1000))
                .blastFurnaceTemp(775)
                .EUt(120)
                .duration(200)
                .save(provider);

// 3Na2CO3 + 10Ir2[REE]2 + 3O -> 6Ir2O2(SiO2)2Au3[REE] + 3Na2O4Ru + 3CO
        BLAST_RECIPES.recipeBuilder("iridium_leach_blast_011")
                .inputItems(dust, SodaAsh, 18)
                .inputItems(dust, LeachResidue, 40)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, RarestMetalResidue, 6)
                .outputItems(dust, SodiumRuthenate, 21)
                .outputFluids(CarbonMonoxide.getFluid(3000))
                .blastFurnaceTemp(775)
                .EUt(120)
                .duration(200)
                .save(provider);

// HCl + 2Ir2O2(SiO2)2Au3[REE] -> OsO4(H2O)(HCl) + 2Ir2O2(SiO2)2Au3
        BLAST_RECIPES.recipeBuilder("iridium_residue_osmium_solution_012")
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputItems(dust, RarestMetalResidue, 2)
                .outputFluids(AcidicOsmiumSolution.getFluid(2000))
                .outputItems(dust, IridiumMetalResidue, 2)
                .blastFurnaceTemp(775)
                .EUt(120)
                .duration(100)
                .save(provider);

// HCl + NH3 -> NH4Cl
        CHEMICAL_RECIPES.recipeBuilder("hydrochloric_ammonia_to_ammonium_chloride_013")
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputFluids(AmmoniumChloride.getFluid(1000))
                .EUt(30)
                .duration(15)
                .save(provider);

// PlatinumConcentrate + AmmoniumChloride -> PlatinumSalt
        LARGE_CHEMICAL_RECIPES.recipeBuilder("platinum_concentrate_ammonium_chloride_014")
                .inputFluids(PlatinumConcentrate.getFluid(2000))
                .inputFluids(AmmoniumChloride.getFluid(200))
                .outputItems(dustSmall, PlatinumSalt, 10)
                .outputItems(dust, PlatinumRawPowder, 2)
                .outputFluids(PalladiumAmmonia.getFluid(200))
                .outputFluids(NitricAcid.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(1200))
                .EUt(30)
                .duration(1200)
                .save(provider);

// Sifter Recipe for Platinum Salt Refined
        SIFTER_RECIPES.recipeBuilder("platinum_salt_refinement_015")
                .inputItems(dust, PlatinumSalt, 2)
                .chancedOutput(ChemicalHelper.get(dust, PlatinumSaltRefined, 2), 9500, 0)
                .EUt(24)
                .duration(300)
                .save(provider);

// Blast Recipe for Platinum Metal from Refined Salt
        BLAST_RECIPES.recipeBuilder("platinum_refined_salt_blast_016")
                .inputItems(dust, PlatinumSaltRefined, 2)
                .outputItems(dust, PlatinumMetallicPowder, 2)
                .outputFluids(Chlorine.getFluid(133))
                .EUt(120)
                .blastFurnaceTemp(775)
                .duration(200)
                .save(provider);

// PtCl2 + Ca -> Pt + CaCl2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("platinum_calcium_reduction_017")
                .inputItems(dust, PlatinumRawPowder, 3)
                .inputItems(dust, Calcium)
                .outputItems(dust, Platinum)
                .outputItems(dust, CalciumChloride, 3)
                .EUt(30)
                .duration(250)
                .save(provider);
    }
    public static void palladium(Consumer<FinishedRecipe> provider) {

    }
}

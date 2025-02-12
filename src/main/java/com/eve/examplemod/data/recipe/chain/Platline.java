package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.SHAPE_MOLD_BALL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;


public class Platline {
    public static void init(Consumer<FinishedRecipe> provider) {
        palladium(provider);
        platinumIridium(provider);
        rhodium(provider);
        ruthenium(provider);
        osmium(provider);
    }

    public static void platinumIridium(Consumer<FinishedRecipe> provider) {
        CENTRIFUGE_RECIPES.recipeBuilder("pgs_centrifuging")
                .inputItems(dust, PlatinumGroupSludge)
                .outputItems(dust, SiliconDioxide)
                .outputItems(dust, PreciousMetal)
                .outputItems(dust, PlatinumMetallicPowder, 2)
                .chancedOutput(dust, RarestMetalResidue, 30, 0)
                .chancedOutput(dust, IridiumMetalResidue, 30, 0)
                .chancedOutput(dust, PalladiumMetallicPowder, 33, 0)
                .save(provider);

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

        /// todo oxygen ebf recipe
//        BLAST_RECIPES.recipeBuilder("platline_test").duration(200).EUt(120).blastFurnaceTemp(1100)
//                .inputItems(dust, PlatinumResidue, 5)
//                .inputItems(dust, PotassiumDisulfate,5)
//                //.inputFluids(Oxygen.getFluid(1000))
//                //.inputFluids(Oxygen.getFluid(1000))
//                .outputItems(dust,LeachResidue, 4)
//                .outputFluids(RhodiumSulfate.getFluid(1000))
//                .circuitMeta(15)
//                .save(provider);

// Ir2[REE]3 + K2S2O7 + O -> Ir2[REE]2 + K2SO4 + RhSO4
        BLAST_RECIPES.recipeBuilder("iridium_residue_disulfate_blast_0102983")
                .inputItems(dust, PlatinumResidue, 5)
                .inputItems(dust, PotassiumDisulfate, 11)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, LeachResidue, 4)
                .outputItems(dust, PotassiumSulfate, 7)
                .outputFluids(RhodiumSulfate.getFluid(1000))
                //.blastFurnaceTemp(775)
                .circuitMeta(2)
                .EUt(120)
                .duration(200)
                .save(provider);

// 3Na2CO3 + 10Ir2[REE]2 + 3O -> 6Ir2O2(SiO2)2Au3[REE] + 3Na2O4Ru + 3CO
        BLAST_RECIPES.recipeBuilder("skibidtoilsdjahnkdasd")
                .inputItems(dust, SodaAsh, 18)
                .inputItems(dust, LeachResidue, 40)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, RarestMetalResidue, 6)
                .outputItems(dust, SodiumRuthenate, 21)
                .outputFluids(CarbonMonoxide.getFluid(3000))
                .circuitMeta(1)
                //.blastFurnaceTemp(775)
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
                .chancedOutput(dust, PlatinumSalt, 10, "1/4", 0)
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
        var chainNumber = 0;
// NH3 + Pd? -> NH3Pd?
        CHEMICAL_RECIPES.recipeBuilder("palladium_chain_" + chainNumber++)
                .inputFluids(Ammonia.getFluid(1000))
                .inputItems(dust, PalladiumMetallicPowder, 2)
                .outputFluids(PalladiumAmmonia.getFluid(1000))
                .EUt(30)
                .duration(250)
                .save(provider);

        // NH3Pd? -> Pd?
        CHEMICAL_RECIPES.recipeBuilder("palladium_chain_" + chainNumber++)
                .circuitMeta(1)
                .inputFluids(PalladiumAmmonia.getFluid(1000))
                .outputItems(dust, PalladiumSalt, 2)
                .EUt(30)
                .duration(250)
                .save(provider);

        // Pd? -> Pd?
        SIFTER_RECIPES.recipeBuilder("palladium_chain_" + chainNumber++)
                .inputItems(dust, PalladiumSalt, 2)
                .chancedOutput(dust, PalladiumMetallicPowder, 2, 9500, 0)
                .EUt(24)
                .duration(300)
                .save(provider);

        // NH3Pd? + Pd? ->
        LARGE_CHEMICAL_RECIPES.recipeBuilder("palladium_chain_" + chainNumber++)
                .circuitMeta(0)
                .inputFluids(PalladiumAmmonia.getFluid(1000))
                .inputItems(dust, PalladiumMetallicPowder, 2)
                .chancedOutput(dust, PalladiumSalt, 10, "1/4", 0)
                .chancedOutput(dust, PalladiumRawPowder,12, "1/9", 0)
                .EUt(30)
                .duration(250)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("palladium_chain_" + chainNumber++)
                .inputItems(dust, PalladiumRawPowder, 2)
                .inputFluids(FormicAcid.getFluid(2000))
                .outputFluids(Ammonia.getFluid(3000))
                .outputFluids(AceticAcid.getFluid(1000))
                .outputItems(dust, Palladium, 2)
                .EUt(1920)
                .duration(300)
                .save(provider);
    }
    public static void rhodium(Consumer<FinishedRecipe> provider) {

        var chainNumber = 0;
        CHEMICAL_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputFluids(RhodiumSulfate.getFluid(3000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(RhodiumSulfateSolution.getFluid(3000))
                .chancedOutput(dust, LeachResidue, 4, "1/9", 0)
                .EUt(30)
                .duration(400)
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputFluids(RhodiumSulfateSolution.getFluid(1000))
                .inputItems(dust, Zinc)
                .outputItems(dust, ZincSulfate, 6)
                .outputItems(dust, CrudeRhodiumMetal, 2)
                .EUt(30)
                .duration(300)
                .save(provider);

        // Rh[NaCl] + NaCl -> Rh(NaCl)2
        BLAST_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputItems(dust, CrudeRhodiumMetal, 2)
                .inputItems(dust, Salt, 2)
                .outputItems(dust, RhodiumSalt, 3)
                .blastFurnaceTemp(775)
                .EUt(120)
                .duration(300)
                .save(provider);

        // Rh(NaCl)2 + Cl -> Rh(NaCl)2Cl
        MIXER_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputItems(dust, RhodiumSalt, 3)
                .inputFluids(Chlorine.getFluid(1000))
                .outputFluids(RhodiumSaltSolution.getFluid(1000))
                .EUt(30)
                .duration(30)
                .save(provider);

        // 2Na + 2HNO3 + O -> 2NaNO3 + H2O
        CHEMICAL_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputItems(dust, Sodium, 2)
                .inputFluids(NitricAcid.getFluid(2000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, SodiumNitrate, 10)
                .outputFluids(Water.getFluid(1000))
                .EUt(60)
                .duration(8)
                .save(provider);

        // Rh(NaCl)2Cl + NaNO3 + 2NO2 + 2O -> 3NaCl + Rh(NH3)3
        LARGE_CHEMICAL_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputFluids(RhodiumSaltSolution.getFluid(1000))
                .inputFluids(NitrogenDioxide.getFluid(2000))
                .inputFluids(Oxygen.getFluid(2000))
                .inputItems(dust, SodiumNitrate, 5)
                .outputItems(dust, Salt, 6)
                .outputItems(dust, RhodiumNitrate, 13)
                .EUt(30)
                .duration(300)
                .save(provider);

        // Rh(NH3)3 -> Rh(NH3)3
        SIFTER_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputItems(dust, RhodiumNitrate, 13)
                .chancedOutput(dust, RhodiumFilterCake, 2, 9500, 0)
                .EUt(30)
                .duration(600)
                .save(provider);

        // Rh(NH3)3 + 2H2O -> Rh(NH3)3(H2O)2
        MIXER_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputItems(dust, RhodiumFilterCake, 2)
                .inputFluids(Water.getFluid(2000))
                .outputFluids(RhodiumFilterCakeSolution.getFluid(1000))
                .EUt(30)
                .duration(300)
                .save(provider);

        // Rh(NH3)2(H2O)2 -> Rh + 2NH3 + 2H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("rhodium_chain_" + chainNumber++)
                .inputFluids(RhodiumFilterCakeSolution.getFluid(1000))
                .outputItems(dust, Rhodium)
                .outputFluids(Ammonia.getFluid(2000))
                .EUt(30)
                .duration(500)
                .save(provider);
    }

    public static void ruthenium(Consumer<FinishedRecipe> provider) {
        var chainNumber = 0;
        // Na2O4Ru + 2Cl -> (NaCl)2RuO4
        CHEMICAL_RECIPES.recipeBuilder("ruthenium_chain_" + chainNumber++)
                .inputItems(dust, SodiumRuthenate, 14)
                .inputFluids(Chlorine.getFluid(2000))
                .outputFluids(RutheniumTetroxideSolution.getFluid(1000))
                .EUt(30)
                .duration(100)
                .save(provider);

        // (NaCl)2RuO4 + H2O -> (NaCl)2RuO4(H2O)
        CRACKING_RECIPES.recipeBuilder("ruthenium_chain_" + chainNumber++)
                .inputFluids(Steam.getFluid(1000))
                .inputFluids(RutheniumTetroxideSolution.getFluid(1000))
                .outputFluids(HotRutheniumTetroxideSolution.getFluid(2000))
                .EUt(480)
                .duration(150)
                .save(provider);

        // Multiplying the mixture out
        // (NaCl)2RuO4(H2O) -> 2NaCl + RuO4 + H2O
        DISTILLATION_RECIPES.recipeBuilder("ruthenium_chain_" + chainNumber++)
                .inputFluids(HotRutheniumTetroxideSolution.getFluid(2000))
                .outputItems(dust, Salt, 4)
                .outputFluids(RutheniumTetroxide.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .duration(1500)
                .EUt(480)
                .save(provider);

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder("ruthenium_chain_" + chainNumber++)
                .notConsumable(SHAPE_MOLD_BALL)
                .inputFluids(RutheniumTetroxide.getFluid(1000))
                .outputItems(dust, RutheniumTetroxide, 5)
                .EUt(8)
                .duration(16)
                .save(provider);

        // RuO4 + 8HCl -> 4H2O + 8Cl + Ru
        CHEMICAL_RECIPES.recipeBuilder("ruthenium_chain_" + chainNumber++)
                .inputItems(dust, RutheniumTetroxide, 5)
                .inputFluids(HydrochloricAcid.getFluid(8000))
                .outputFluids(Water.getFluid(4000))
                .outputFluids(Chlorine.getFluid(8000))
                .outputItems(dust, Ruthenium)
                .EUt(30)
                .duration(300)
                .save(provider);
    }

    public static void osmium(Consumer<FinishedRecipe> provider) {
        int chainNumber = 0;
        // OsO4(H2O)(HCl) -> OsO4(H2O) + HCl
        DISTILLATION_RECIPES.recipeBuilder("osmium_chain_" + chainNumber++)
                .inputFluids(AcidicOsmiumSolution.getFluid(2000))
                .outputFluids(OsmiumSolution.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .EUt(7680)
                .duration(150)
                .save(provider);

        // OsO4(H2O) + 8HCl -> Os + 8Cl + 5H2O
        CHEMICAL_RECIPES.recipeBuilder("osmium_chain_" + chainNumber++)
                .inputFluids(OsmiumSolution.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(8000))
                .outputItems(dust, Osmium)
                .outputFluids(Chlorine.getFluid(8000))
                .outputFluids(Water.getFluid(5000))
                .EUt(30)
                .duration(300)
                .save(provider);

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder("osmium_chain_" + chainNumber++)
                .inputItems(ingot, Palladium, 3)
                .inputFluids(Rhodium.getFluid(144))
                .outputItems(ingotHot, RhodiumPlatedPalladium, 4)
                .EUt(7680)
                .duration(200)
                .save(provider);
    }
    

}

package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.UVA_HALIDE_LAMP;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;


public class RheniumChain {
    public static void init(Consumer<FinishedRecipe> provider) {
        // Molybdenite MUST NOT be producible from its components!

        /*
         * Unknown compounds key: (could use some help on this)
         * GoldCyanide: AuCN
         * GoldDepleteMolybdenite: MoS2
         * MolybdenumConcentrate:
         * ChlorideLeachedSolution:
         * MolybdenumFlue:
         * RheniumSulfuricSolution:
         * RheniumSeparationMixture: Does not matter, doesn't impact formulas (despite being consumed)
         * PlatinumSaltCrude:
         * PlatinumSaltRefined:
         * RheniumScrubbedSolution: Re
         * LeachedColumbite:
         * PurifiedColumbite:
         * LeachedPyrochlore:
         * PurifiedPyrochlore:
         */

        var chainNumber = 0;
        // CH4 + NH3 + 3O -> HCN + 3H2O
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Oxygen.getFluid(3000))
                .outputFluids(HydrogenCyanide.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .EUt(1920)
                .duration(50)
                .save(provider);

        // 2HCN + O + 2Na -> 2NaCN + H2O
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(HydrogenCyanide.getFluid(2000))
                .inputFluids(Oxygen.getFluid(1000))
                .inputItems(dust, Sodium, 2)
                .outputFluids(SodiumCyanide.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .EUt(1920)
                .duration(12)
                .save(provider);

        // MoS2 + NaCN -> AuCN + MoS2(depl.)
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(dust, Molybdenite, 3)
                .inputFluids(SodiumCyanide.getFluid(1000))
                .outputFluids(GoldCyanide.getFluid(1000))
                .outputItems(GoldDepleteMolybdenite, 3)
                .EUt(7680)
                .duration(100)
                .save(provider);

        // AuCN + Na -> NaCN + Au
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(GoldCyanide.getFluid(1000))
                .inputItems(dust, Sodium)
                .outputFluids(SodiumCyanide.getFluid(1000))
                .outputItems(dust, Gold)
                .EUt(1920)
                .duration(150)
                .save(provider);

        // MoS2 + FeCl3 ->
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(GoldDepleteMolybdenite, 3)
                .inputFluids(Iron3Chloride.getFluid(500))
                .outputItems(MolybdenumConcentrate, 4)
                .outputFluids(ChlorideLeachedSolution.getFluid(500))
                .EUt(1920)
                .duration(10)
                .save(provider);

        // 8? -> CaCl2 + CuCl2 + PbCl2 + BiCl3 + 8FeCl2
        CENTRIFUGE_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(ChlorideLeachedSolution.getFluid(8000))
                .outputItems(dust, CalciumChloride, 3)
                .outputItems(CopperChloride, 3)
                .outputItems(LeadChloride, 3)
                .outputItems(BismuthChloride, 4)
                .outputFluids(Iron2Chloride.getFluid(8000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // FeCl2 + Cl -> FeCl3
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Iron2Chloride.getFluid(1000))
                .inputFluids(Chlorine.getFluid(1000))
                .outputFluids(Iron3Chloride.getFluid(1000))
                .EUt(30)
                .duration(150)
                .save(provider);

        // CuCl2 -> Cu + Cl2
        ELECTROLYZER_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(CopperChloride, 3)
                .outputItems(dust, Copper)
                .outputFluids(Chlorine.getFluid(2000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // PbCl2 -> Pb + Cl2
        ELECTROLYZER_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(LeadChloride, 3)
                .outputItems(dust, Lead)
                .outputFluids(Chlorine.getFluid(2000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // BiCl3 -> Bi + 3Cl
        ELECTROLYZER_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(BismuthChloride, 4)
                .outputItems(dust, Bismuth)
                .outputFluids(Chlorine.getFluid(3000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // ? + ~7O -> 3? + MoO3
        BLAST_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(MolybdenumConcentrate, 4)
                .inputFluids(Oxygen.getFluid(7250))
                .blastFurnaceTemp(8550)
                .EUt(120)
                .duration(340)
                .outputFluids(MolybdenumFlue.getFluid(3000))
                .outputItems(MolybdenumTrioxide, 4)
                .save(provider);

        // 6H + MoO3 -> Mo + 3H2O(steam)
        BLAST_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Hydrogen.getFluid(6000))
                .inputItems(MolybdenumTrioxide, 4)
                .outputItems(dust, Molybdenum)
                .outputFluids(Steam.getFluid(3000))
                .blastFurnaceTemp(1000)
                .EUt(120)
                .duration(200)
                .save(provider);

        // 3? + 0.5NH3 -> 3SO2 + 0.5NH4ReO4
        MIXER_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(MolybdenumFlue.getFluid(3000))
                .inputFluids(Water.getFluid(250))
                .outputFluids(RheniumSulfuricSolution.getFluid(3000))
                .EUt(491520)
                .duration(30)
                .save(provider);

        // ? + 0.5NH3 -> 3SO2 + 0.5NH4ReO4
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(RheniumSulfuricSolution.getFluid(3000))
                .inputFluids(Ammonia.getFluid(500))
                .outputFluids(SulfurDioxide.getFluid(3000))
                .outputFluids(AmmoniumPerrhenate.getFluid(500))
                .EUt(480)
                .duration(90)
                .save(provider);

        // NH4ReO4 + 7H -> Re + NH3 + 4H2O
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(AmmoniumPerrhenate.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(7000))
                .outputItems(dust, Rhenium)
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(Water.getFluid(4000))
                .EUt(480)
                .duration(110)
                .save(provider);

        // Hg + 2CH3COOH -> C4H6O4Hg + H2
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Mercury.getFluid(1000))
                .inputFluids(AceticAcid.getFluid(2000))
                .outputItems(MercuryAcetate, 15)
                .outputFluids(Hydrogen.getFluid(2000))
                .EUt(480)
                .duration(90)
                .save(provider);

        // C2H4O + CH3NH2 -> C3H9NO
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(EthyleneOxide.getFluid(1000))
                .inputFluids(Methylamine.getFluid(1000))
                .outputFluids(Methylethanolamine.getFluid(1000))
                .EUt(480)
                .duration(90)
                .save(provider);

        // CaC2 + N2 -> CaCN2 + C
        BLAST_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(dust, CalciumCarbide, 3)
                .inputFluids(Nitrogen.getFluid(2000))
                .outputItems(dust, CalciumCyanamide, 4)
                .outputItems(dust, Carbon)
                .blastFurnaceTemp(2000)
                .EUt(120)
                .duration(360)
                .save(provider);

        // 2HCl + C3H9NO + O + CaCN2 -> C2H7N3 + CH3COOH + CaCl2
        CHEMICAL_PLANT_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputFluids(Methylethanolamine.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .inputItems(CalciumCyanamide, 4)
                .outputFluids(Methylguanidine.getFluid(1000))
                .outputFluids(AceticAcid.getFluid(1000))
                .outputItems(dust, CalciumChloride, 3)
                .notConsumable(dust, Palladium)
                .notConsumable(dust, MercuryAcetate)
                .EUt(480)
                .duration(240)
                .save(provider);

        // C2H7N3 + HNO3 + H2SO4 + HCl + NaNO2 -> 2H2SO4(dil.) + C2H5N5O3 + NaCl
        // Not perfect, but was the best way to try and conserve acids
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Methylguanidine.getFluid(1000))
                .inputFluids(NitrationMixture.getFluid(2000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputItems(SodiumNitrite, 4)
                .outputFluids(DilutedSulfuricAcid.getFluid(2000))
                .outputFluids(Methylnitronitrosoguanidine.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .EUt(480)
                .duration(220)
                .save(provider);

        // C6H12O6 + bacteria -> C5H12O
        BIO_REACTOR_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(Glucose, 24)
                .notConsumable(dust, SelectivelyMutatedCupriavidiusNecator)
                .inputFluids(Ammonia.getFluid(10))
                .outputFluids(IsoamylAlcohol.getFluid(1000))
                .EUt(491520)
                .duration(20)
                .save(provider);

        // C8H16 + H2O -> C8H18O
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Oct1ene.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(Octanol.getFluid(1000))
                .notConsumableFluid(PhosphoricAcid.getFluid(0))
                .notConsumable(dust, PalladiumLoadedRutileNanoparticles)
                .notConsumable(UVA_HALIDE_LAMP)
                .EUt(30720)
                .duration(110)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(CupriavidusNecator, 2)
                .notConsumable(UVA_HALIDE_LAMP)
                .inputFluids(Methylnitronitrosoguanidine.getFluid(250))
                .outputItems(SelectivelyMutatedCupriavidiusNecator)
                .EUt(30720)
                .duration(20)
                .save(provider);

        // 3C8H18O + NH3 -> 3H2O + C24H51N
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Octanol.getFluid(3000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .outputFluids(Trioctylamine.getFluid(1000))
                .EUt(480)
                .duration(90)
                .save(provider);

        // 2C12H26 + 0.5C24H51N + 0.25C8H18O + 0.5C6H12O + 0.375CH3COOH + 0.375C5H12O -> ~4C11H24
        LARGE_MIXER_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(Kerosene.getFluid(8000))
                .inputFluids(Trioctylamine.getFluid(500))
                .inputFluids(Octanol.getFluid(500))
                .inputFluids(MethylIsobutylKetone.getFluid(250))
                .inputFluids(AceticAcid.getFluid(250))
                .inputFluids(IsoamylAlcohol.getFluid(250))
                .outputFluids(RheniumSeparationMixture.getFluid(10000))
                .EUt(7680)
                .duration(90)
                .save(provider);

        // ? + RSM -> ? + ?(20%) + Re
        CENTRIFUGE_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(dust, PlatinumSalt, 2)
                .inputFluids(RheniumSeparationMixture.getFluid(250))
                .chancedOutput(dust, PlatinumSaltRefined, 2, 9500, 0)
                .outputFluids(RheniumScrubbedSolution.getFluid(250))
                .outputFluids(RheniumSeparationMixture.getFluid(200))
                .EUt(7680)
                .duration(50)
                .save(provider);

        // ? + 0.2? -> ? + Re
        CENTRIFUGE_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(LeachedColumbite, 17)
                .inputFluids(RheniumSeparationMixture.getFluid(250))
                .outputItems(PurifiedColumbite)
                .outputFluids(RheniumScrubbedSolution.getFluid(250))
                .outputFluids(RheniumSeparationMixture.getFluid(200))
                .EUt(7680)
                .duration(50)
                .save(provider);

        //  + 0.2? -> ? + Re
        CENTRIFUGE_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(LeachedPyrochlore)
                .inputFluids(RheniumSeparationMixture.getFluid(250))
                .outputItems(PurifiedPyrochlore)
                .outputFluids(RheniumScrubbedSolution.getFluid(250))
                .outputFluids(RheniumSeparationMixture.getFluid(200))
                .EUt(7680)
                .duration(50)
                .save(provider);

        // ? + 5HF -> H2NbOF5
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(PurifiedColumbite)
                .inputFluids(HydrofluoricAcid.getFluid(5000))
                .outputFluids(FluoroniobicAcid.getFluid(1000))
                .EUt(480)
                .duration(180)
                .save(provider);

        // Nb(H2O) + 5HF -> H2NbOF5
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputItems(PurifiedPyrochlore)
                .inputFluids(HydrofluoricAcid.getFluid(5000))
                .outputFluids(FluoroniobicAcid.getFluid(1000))
                .EUt(480)
                .duration(180)
                .save(provider);

        // Re + 3NH3 + H2SO4 -> (NH4)2SO4 + NH4ReO4
        CHEMICAL_RECIPES.recipeBuilder("rhenium_chain_" + chainNumber++)
                .inputFluids(RheniumScrubbedSolution.getFluid(1000))
                .inputFluids(Ammonia.getFluid(3000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(AmmoniumSulfate.getFluid(1000))
                .outputFluids(AmmoniumPerrhenate.getFluid(1000))
                .EUt(1920)
                .duration(110)
                .save(provider);
    }
}

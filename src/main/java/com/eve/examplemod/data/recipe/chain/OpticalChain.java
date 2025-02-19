package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.WHITE_HALIDE_LAMP;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.ingotHot;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class OpticalChain {
    public static void init(Consumer<FinishedRecipe> provider) { // TODO

        int chainNumber = 0;

        // FIBER CHEMISTRY =============================================================================================

        // Zr + 4F -> ZrF4
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100)
                .inputItems(dust, Zirconium)
                .inputFluids(Fluorine.getFluid(4000))
                .outputItems(ZirconiumTetrafluoride, 5)
                .save(provider);

        // Ba + 2F -> BaF2
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100)
                .inputItems(dust, Barium)
                .inputFluids(Fluorine.getFluid(2000))
                .outputItems(BariumDifluoride, 3)
                .save(provider);

        // La + 3F -> LaF3
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100)
                .inputItems(dust, Lanthanum)
                .inputFluids(Fluorine.getFluid(3000))
                .outputItems(LanthanumTrifluoride, 4)
                .save(provider);

        // Al + 3F -> AlF3
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100)
                .inputItems(dust, Aluminium)
                .inputFluids(Fluorine.getFluid(3000))
                .outputItems(AluminiumTrifluoride, 4)
                .save(provider);

        // Er + 3F -> ErF3
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100)
                .inputItems(dust, Erbium)
                .inputFluids(Fluorine.getFluid(3000))
                .outputItems(ErbiumTrifluoride, 4)
                .save(provider);

        // Si + 4F -> SiF4
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(150).EUt(480)
                .inputItems(dust, Silicon)
                .inputFluids(Fluorine.getFluid(4000))
                .outputFluids(SiliconFluoride.getFluid(1000))
                .save(provider);

        // LASER CHEMISTRY =============================================================================================

        // SiF4 + 2HF -> H2SiF6
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(210).EUt(480)
                .inputFluids(SiliconFluoride.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(FluorosilicicAcid.getFluid(1000))
                .save(provider);

        // H2SiF6 + 6NH3 + 2H2O -> SiO2 + 6NH4F
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(320).EUt(480)
                .inputFluids(FluorosilicicAcid.getFluid(1000))
                .inputFluids(Ammonia.getFluid(6000))
                .inputFluids(Water.getFluid(2000))
                .outputItems(dust, SiliconDioxide, 3)
                .outputFluids(AmmoniumFluoride.getFluid(6000))
                .save(provider);

        // 2NH4F -> NH3 + NH4HF2
        CENTRIFUGE_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(340).EUt(120)
                .inputFluids(AmmoniumFluoride.getFluid(2000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputItems(AmmoniumBifluoride, 8)
                .save(provider);

        // H2O + NH4HF2 -> [NH4HF2 + H2O]
        MIXER_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(140).EUt(30)
                .inputFluids(DistilledWater.getFluid(1000))
                .inputItems(AmmoniumBifluoride, 8)
                .outputFluids(AmmoniumBifluorideSolution.getFluid(1000))
                .save(provider);

        // [NH4HF2 + H2O] -> NH3 + 2HF + H2O
        CENTRIFUGE_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(260).EUt(120)
                .inputFluids(AmmoniumBifluorideSolution.getFluid(2000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // NH4VO3 + NaCl + Na2O -> Na3VO4 + NH4Cl
        BLAST_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(280).EUt(120).blastFurnaceTemp(700)
                .inputItems(dust, AmmoniumVanadate, 9)
                .inputItems(dust, Salt, 2)
                .inputItems(dust, SodiumOxide, 3)
                .outputItems(dust, PureSodiumVanadate, 8)
                .outputFluids(AmmoniumChloride.getFluid(1000))
                .save(provider);

        // 2Na + O -> Na2O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(60).EUt(30)
                .circuitMeta(1)
                .inputItems(dust, Sodium, 2)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(SodiumOxide, 3)
                .save(provider);

        // 3Y2O3 + Lu2O3 + Tm2O3 + 30HCl -> [6YCl3 + 2LuCl3 + 2TmCl3 + 15H2O]
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(280).EUt(15360)
                .inputItems(dust, YttriumOxide, 15)
                .inputItems(LutetiumOxide, 5)
                .inputItems(ThuliumOxide, 5)
                .inputFluids(HydrochloricAcid.getFluid(30000))
                .outputFluids(LuTmYChlorideSolution.getFluid(30000))
                .save(provider);

        // NaVO3 + NH4Cl + H2O -> NH4VO3 + NaCl(H2O)
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(80).EUt(120)
                .inputItems(SodiumMetavanadate, 5)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(AmmoniumChloride.getFluid(1000))
                .outputItems(AmmoniumVanadate, 9)
                .outputFluids(SaltWater.getFluid(1000))
                .save(provider);

        // [6YCl3 + 2LuCl3 + 2TmCl3 + 15H2O] + Na3VO4 + 2CH4N2O -> LuTmYVO Precipitate + 0.9Cl
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(320).EUt(480)
                .inputFluids(LuTmYChlorideSolution.getFluid(1000))
                .inputItems(PureSodiumVanadate, 8)
                .inputItems(Urea, 16)
                .outputFluids(Chlorine.getFluid(900))
                .outputItems(LuTmYVOPrecipitate)
                .save(provider);

        // LuTmYVO Precipitate + C2H6O -> LuTmYVO Nanoparticles + 3NaCl + (NH4)2CO3 + C3H6
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(200).EUt(7680)
                .inputItems(LuTmYVOPrecipitate)
                .inputFluids(Ethanol100.getFluid(1000))
                .outputItems(LuTmYVONanoparticles)
                .outputItems(dust, Salt, 6)
                .outputItems(dust, AmmoniumCarbonate, 14)
                .outputFluids(Propene.getFluid(1000))
                .save(provider);

        // (NH4)2CO3 + Ca + NaH + 2O -> 2NH3 + Ca(OH)2 + NaHCO3
        BLAST_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(270).EUt(120).blastFurnaceTemp(700)
                .inputItems(dust, AmmoniumCarbonate, 14)
                .inputItems(dust, SodiumHydride, 2)
                .inputItems(dust, Calcium)
                .inputFluids(Oxygen.getFluid(2000))
                .outputFluids(Ammonia.getFluid(2000))
                .outputItems(dust, SodiumBicarbonate, 6)
                .outputItems(dust, CalciumHydroxide, 5)
                .save(provider);

        // NaH -> Na + H
        ELECTROLYZER_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(240).EUt(30)
                .inputItems(SodiumHydride, 2)
                .outputItems(dust, Sodium)
                .outputFluids(Hydrogen.getFluid(1000))
                .save(provider);

        // MgF2 + ZnS + Ta2O5 + TiO2 + C2H5OH -> Dielectric Mirror Formation Mix
        MIXER_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(270).EUt(983040)
                .inputItems(MagnesiumFluoride, 3)
                .inputItems(ZincSulfide, 2)
                .inputItems(TantalumOxide, 7)
                .inputItems(dust, Rutile, 3)
                .inputFluids(Ethanol.getFluid(1000))
                .outputFluids(DielectricMirrorFormationMix.getFluid(1000))
                .save(provider);

        // COMPONENTS CHEMISTRY ========================================================================================

        // Nb + 5Cl -> NbCl5
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(290).EUt(120)
                .inputItems(dust, Niobium)
                .inputFluids(Chlorine.getFluid(5000))
                .outputItems(NiobiumChloride, 6)
                .save(provider);

        // LiAlH4 -> LiH + AlH3
        BLAST_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(260).EUt(120).blastFurnaceTemp(1600)
                .inputItems(dust, LithiumAluminiumHydride, 6)
                .outputItems(LithiumHydride, 2)
                .outputItems(AluminiumHydride, 4)
                .save(provider);

        // NbCl5 + LiH + 2H2O2 -> LiNbO4 + 5HCl
        BLAST_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(320).EUt(120).blastFurnaceTemp(4500)
                .inputItems(NiobiumChloride, 6)
                .inputItems(LithiumHydride, 2)
                .notConsumable(dust, Hafnium)
                .inputFluids(HydrogenPeroxide.getFluid(2000))
                .outputItems(ingotHot, LithiumNiobate, 6)
                .outputFluids(HydrochloricAcid.getFluid(5000))
                .save(provider);

        // 5NaOH + NbCl5 -> 5NaCl + H5NbO5
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(200).EUt(120)
                .inputItems(dust, SodiumHydroxide, 15)
                .inputItems(NiobiumChloride, 6)
                .outputItems(dust, Salt, 10)
                .outputItems(NiobiumHydroxide, 11)
                .save(provider);

        // 2H5NbO5 + 5C2H2O4 + NH3 + Na -> 9H2O + [C10Nb2O20 + NH4] + NaOH
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(140).EUt(480)
                .inputItems(NiobiumHydroxide, 22)
                .inputItems(dust, Sodium)
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(OxalicAcid.getFluid(5000))
                .outputItems(dust, SodiumHydroxide, 3)
                .outputFluids(Water.getFluid(9000))
                .outputFluids(AmmoniumNiobiumOxalateSolution.getFluid(1000))
                .save(provider);

        // [C10Nb2O20 + NH4] + 2LiNbO4 -> Nanoparticles
        CHEMICAL_BATH_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(260).EUt(491520)
                .inputItems(dust, LithiumNiobate, 12)
                .inputFluids(AmmoniumNiobiumOxalateSolution.getFluid(1000))
                .outputItems(LithiumNiobateNanoparticles, 3)
                .save(provider);

        // MgO + NH4HF2 -> MgF2 + NH3 + H2O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100).EUt(120)
                .inputItems(dust, Magnesia, 2)
                .inputItems(dust, AmmoniumBifluoride, 8)
                .outputItems(dust, MagnesiumFluoride, 3)
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // P + I -> InP
        BLAST_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(270).EUt(120).blastFurnaceTemp(4600)
                .inputItems(dust, Phosphorus)
                .inputItems(dust, Indium)
                .outputItems(dust, IndiumPhosphide, 2)
                .save(provider);

        // Zn + S -> ZnS
        BLAST_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(270).EUt(120).blastFurnaceTemp(4600)
                .inputItems(dust, Zinc)
                .inputItems(dust, Sulfur)
                .outputItems(ZincSulfide, 2)
                .save(provider);

        // NH4NO3 -> NH3 + HNO3
        ELECTROLYZER_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(220).EUt(120)
                .inputFluids(AmmoniumNitrate.getFluid(1000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(NitricAcid.getFluid(1000))
                .save(provider);

        // C2H7NO + NH3 -> C2H8N2 + H2O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(180).EUt(120)
                .inputFluids(Ethanolamine.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputFluids(Ethylenediamine.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .notConsumable(dust, Palladium)
                .save(provider);

        // 2C2H8N2 + 24CH2O + 8HCl + 8NaCN + 6O -> [3[C10H16N2O8 + C2H8N2 + 2O] + 8NaCl]
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(250).EUt(7680)
                .inputFluids(Ethylenediamine.getFluid(2000))
                .inputFluids(Formaldehyde.getFluid(24000))
                .inputFluids(HydrochloricAcid.getFluid(8000))
                .inputFluids(SodiumCyanide.getFluid(8000))
                .inputFluids(Oxygen.getFluid(6000))
                .outputFluids(EDTASolution.getFluid(15000))
                .save(provider);

        // [3[C10H16N2O8 + C2H8N2 + 2O] + 8NaCl] -> 8NaCl + 3C10H16N2O8 + 3[C2H8N2 + 2O]
        // 3[C2H8N2 + 2O] -> 3C2H5NO2 + 3NH3
        DISTILLATION_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(240).EUt(1920)
                .inputFluids(EDTASolution.getFluid(15000))
                .outputItems(dust, Salt, 16)
                .outputFluids(Ammonia.getFluid(3000))
                .outputFluids(EDTA.getFluid(3000))
                .outputFluids(Glycine.getFluid(3000))
                .save(provider);

        // C2H5NO2 + CH4 + 2 Br + 2 CsOH -> 2 [CsBr + H2O] + C3H7NO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100).EUt(480)
                .notConsumable(WHITE_HALIDE_LAMP)
                .inputItems(CaesiumHydroxide, 6)
                .inputFluids(Glycine.getFluid(1000))
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(Bromine.getFluid(2000))
                .outputFluids(CesiumBromideSolution.getFluid(2000))
                .outputItems(Sarcosine, 13)
                .save(provider);

        // 2Cs + H2O2 -> 2CsOH
        CHEMICAL_BATH_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(180).EUt(120)
                .inputItems(dust, Caesium, 2)
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputItems(CaesiumHydroxide, 6)
                .save(provider);

        // [CsBr + H2O] -> CsOH + Br + H
        ELECTROLYZER_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(250).EUt(120)
                .inputFluids(CesiumBromideSolution.getFluid(1000))
                .outputFluids(Bromine.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(1000))
                .outputItems(CaesiumHydroxide, 3)
                .save(provider);

        // 2Pr + H2SO4 -> Pr2O3 + H2S + O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100).EUt(480)
                .inputItems(dust, Praseodymium, 2)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(PraseodymiumOxide, 5)
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

        // 2Ho + H2SO4 -> Ho2O3 + H2S + O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100).EUt(480)
                .inputItems(dust, Holmium, 2)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(HolmiumOxide, 5)
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

        // 2Nd + H2SO4 -> Nd2O3 + H2S + O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100).EUt(480)
                .inputItems(dust, Neodymium, 2)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(NeodymiumOxide, 5)
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

        // 2Y + H2SO4 -> Y2O3 + H2S + O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(100).EUt(480)
                .inputItems(dust, Yttrium, 2)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, YttriumOxide, 5)
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

        // 3Y2O3 + Pr2O3 + Ho2O3 + 30HNO3 -> [6Y(NO3)3 + 2Pr(NO3)3 + 2Ho(NO3)3 + 15H2O]
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(280).EUt(15360)
                .inputItems(dust, YttriumOxide, 15)
                .inputItems(PraseodymiumOxide, 5)
                .inputItems(HolmiumOxide, 5)
                .inputFluids(NitricAcid.getFluid(30000))
                .outputFluids(PrYHoNitrateSolution.getFluid(30000))
                .save(provider);

        // Be + LiF + 2NH4HF2 + CO + [6Y(NO3)3 + 2Pr(NO3)3 + 2Nd(NO3)3 + 15H2O] -> 2PrHoYLF Nanoparticles + 2NH4NO3 + 2HF + BeF2 + CO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(200).EUt(7680)
                .inputItems(dust, LithiumFluoride, 2)
                .inputItems(dust, Beryllium)
                .inputItems(AmmoniumBifluoride, 16)
                .inputFluids(PrYHoNitrateSolution.getFluid(2000))
                .inputFluids(CarbonMonoxide.getFluid(1000))
                .notConsumableFluid(CetaneTrimethylAmmoniumBromide.getFluid(0))
                .notConsumableFluid(EDTA.getFluid(0))
                .outputItems(PrHoYLFNanoparticles, 2)
                .outputItems(dust, BerylliumFluoride, 3)
                .outputFluids(AmmoniumNitrate.getFluid(2000))
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // 2CH4 + 5Cl -> [2CH4 + 5Cl]
        MIXER_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(240).EUt(1920)
                .inputFluids(Methane.getFluid(2000))
                .inputFluids(Chlorine.getFluid(5000))
                .outputFluids(ChlorinatedSolvents.getFluid(7000))
                .save(provider);

        // 2[2CH4 + 5Cl] -> 1.33CH3Cl + 2.17CH2Cl2 + 2.17CHCl3 + 1.33CCl4
        // Not chemically balanced, but is a convenient, not too OP recipe
        // todo check this
        DISTILLATION_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(240).EUt(1920)
                .inputFluids(ChlorinatedSolvents.getFluid(14000))
                .outputFluids(Chloromethane.getFluid(1330))
                .outputFluids(Dichloromethane.getFluid(2170))
                .outputFluids(Chloroform.getFluid(2170))
                .outputFluids(CarbonTetrachloride.getFluid(1330))
                .save(provider);

        FLUID_HEATER_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(130).EUt(480)
                .inputFluids(Butanol.getFluid(1000))
                .circuitMeta(0)
                .outputFluids(ButanolGas.getFluid(1000))
                .save(provider);

        // 3C4H10O + NH3 -> C12H27N + 3H2O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(140).EUt(480)
                .inputFluids(ButanolGas.getFluid(3000))
                .inputFluids(Ammonia.getFluid(1000))
                .notConsumable(dust, Zeolite)
                .outputFluids(Tributylamine.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .save(provider);

        // Al2O3 + 6HNO3 -> 2Al(NO3)3 + 3H2O
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(190).EUt(30)
                .inputItems(Alumina, 5)
                .inputFluids(NitricAcid.getFluid(6000))
                .outputItems(AluminiumNitrate, 26)
                .outputFluids(Water.getFluid(3000))
                .save(provider);

        // 2Al(NO3)3 + CH2Cl2 + C12H27N -> [2Al(NO3)3 + CH2Cl2 + C12H27N]
        CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(290).EUt(120)
                .inputItems(AluminiumNitrate, 26)
                .inputFluids(Dichloromethane.getFluid(1000))
                .inputFluids(Tributylamine.getFluid(1000))
                .outputFluids(CrudeAluminaSolution.getFluid(1000))
                .save(provider);

        // [2Al(NO3)3 + CH2Cl2 + C12H27N] + C12H27N + H2O2 -> [Al2O3 + CH2Cl2 + 2C12H27N] + 2HNO3 + NO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(210).EUt(480)
                .inputFluids(CrudeAluminaSolution.getFluid(1000))
                .inputFluids(Tributylamine.getFluid(1000))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputFluids(AluminaSolution.getFluid(1000))
                .outputFluids(NitricAcid.getFluid(2000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .save(provider);

        // 5NH3 + 5HCN + 3H2SO4 + 2KMnO4 -> 3H2O + 2MnSO4 + K2SO4 + 5NH4CNO
        LARGE_CHEMICAL_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(220).EUt(480)
                .inputFluids(Ammonia.getFluid(5000))
                .inputFluids(HydrogenCyanide.getFluid(5000))
                .inputFluids(SulfuricAcid.getFluid(3000))
                .inputItems(dust, PotassiumPermanganate, 12)
                .outputFluids(Water.getFluid(3000))
                .outputItems(ManganeseSulfate, 12)
                .outputItems(PotassiumSulfate, 7)
                .outputFluids(AmmoniumCyanate.getFluid(5000))
                .save(provider);

        // NH4CNO -> CH4N2O
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(320).EUt(480)
                .inputFluids(AmmoniumCyanate.getFluid(1000))
                .outputItems(Urea, 8)
                .save(provider);

        // 3K2MnO4 + 2H2O -> MnO2 + 2KMnO4 + 4KOH
        BLAST_RECIPES.recipeBuilder("optical_chain_" + chainNumber++).duration(250).EUt(120).blastFurnaceTemp(720)
                .inputItems(dust, PotassiumManganate, 21)
                .inputFluids(Water.getFluid(2000))
                .outputItems(dust, Pyrolusite, 3)
                .outputItems(dust, PotassiumPermanganate, 12)
                .outputFluids(PotassiumHydroxide.getFluid(4000))
                .save(provider);
    }
}

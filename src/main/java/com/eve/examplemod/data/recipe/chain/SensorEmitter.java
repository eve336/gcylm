package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_PLANT_RECIPES;
import static com.eve.examplemod.common.data.EVRecipeTypes.LARGE_MIXER_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class SensorEmitter {
    static int chainNumber = 1;
    public static void init(Consumer<FinishedRecipe> provider) {
        MIXER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(420).EUt(120)
                .inputItems(dust, Strontium)
                .inputItems(BariumOxide,2)
                .inputFluids(AceticAcid.getFluid(2000))
                .outputFluids(BariumStrontiumAcetateSolution.getFluid(1000))
                .save(provider);

        // Ti + 2O -> TiO2
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(100).EUt(1920)
                .inputItems(dust, Titanium)
                .inputFluids(Oxygen.getFluid(2000))
                .outputItems(dust, Rutile, 3)
                .save(provider);

        // TiO2 + 4C3H8O -> C12H28O4Ti + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(480)
                .inputItems(dust, Rutile, 3)
                .inputFluids(IsopropylAlcohol.getFluid(4000))
                .outputFluids(TitaniumIsopropoxide.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .save(provider);

        // [C4H6BaSrO4 + H2O] + C12H28O4Ti + 2C -> [C4H6BaSrO4 + C12H28O4Ti + H2O + 2C]
        MIXER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(280).EUt(120)
                .inputFluids(BariumStrontiumAcetateSolution.getFluid(1000))
                .inputFluids(TitaniumIsopropoxide.getFluid(1000))
                .inputItems(dust, Carbon, 2)
                .outputFluids(BariumStrontiumTitanatePreparation.getFluid(2000))
                .save(provider);

        // [C4H6BaSrO4 + C12H28O4Ti + H2O + 2C] -> BaO4SrTi + C5H10O2 + 4C3H6 + H2O + CO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(250).EUt(480)
                .inputFluids(BariumStrontiumTitanatePreparation.getFluid(2000))
                .outputItems(BariumStrontiumTitanate,7)
                .outputFluids(IsopropylAcetate.getFluid(1000))
                .outputFluids(Propene.getFluid(4000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // C5H10O2 + H2O -> C3H8O + CH3COOH
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(200).EUt(480)
                .notConsumable(dust, PhosphorusPentoxide)
                .inputFluids(IsopropylAcetate.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(IsopropylAlcohol.getFluid(1000))
                .outputFluids(AceticAcid.getFluid(1000))
                .save(provider);

        // 9H2O + 2F7K2Ta -> Ta2O5 + 14HF + 4KOH
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(130).EUt(120)
                .inputItems(PotasssiumFluoroTantalate,20)
                .inputFluids(Water.getFluid(9000))
                .outputItems(TantalumOxide,7)
                .outputFluids(HydrofluoricAcid.getFluid(14000))
                .outputFluids(PotassiumHydroxide.getFluid(4000))
                .save(provider);

        // 2Ta + 10Cl + 5H2O -> Ta2O5 + 10HCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(480).EUt(120)
                .inputItems(dust, Tantalum, 2)
                .inputFluids(Chlorine.getFluid(10000))
                .inputFluids(Water.getFluid(5000))
                .outputItems(TantalumOxide,7)
                .outputFluids(HydrochloricAcid.getFluid(10000))
                .save(provider);

        // 2Sc + 6Cl + 3H2O -> Sc2O3 + 6HCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(480).EUt(120)
                .inputItems(dust, Scandium, 2)
                .inputFluids(Chlorine.getFluid(6000))
                .inputFluids(Water.getFluid(3000))
                .outputItems(ScandiumOxide,5)
                .outputFluids(HydrochloricAcid.getFluid(6000))
                .save(provider);

        // 2Lu + 6Cl + 3H2O -> Lu2O3 + 6HCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(480).EUt(120)
                .inputItems(dust, Lutetium, 2)
                .inputFluids(Chlorine.getFluid(6000))
                .inputFluids(Water.getFluid(3000))
                .outputItems(LutetiumOxide,5)
                .outputFluids(HydrochloricAcid.getFluid(6000))
                .save(provider);

        // 2Tm + 6Cl + 3H2O -> Tm2O3 + 6HCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(480).EUt(120)
                .inputItems(dust, Thulium, 2)
                .inputFluids(Chlorine.getFluid(6000))
                .inputFluids(Water.getFluid(3000))
                .outputItems(ThuliumOxide,5)
                .outputFluids(HydrochloricAcid.getFluid(6000))
                .save(provider);

        // 2Eu + 6Cl + 3H2O -> Eu2O3 + 6HCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(480).EUt(120)
                .inputItems(dust, Europium, 2)
                .inputFluids(Chlorine.getFluid(6000))
                .inputFluids(Water.getFluid(3000))
                .outputItems(EuropiumOxide,5)
                .outputFluids(HydrochloricAcid.getFluid(6000))
                .save(provider);

        // Pb(NO3)2 + 9Ca -> [Pb(NO3)2 + 9Ca]
        MIXER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(200).EUt(30)
                .inputItems(dust, LeadNitrate, 9)
                .inputItems(dust, Calcium, 9)
                .outputItems(LeadNitrateCalciumMixture,18)
                .save(provider);

        // [2Pb(NO3)2 + 9Ca] + Ta2O5 + Sc2O3 + 3O -> 2Pb(ScTa)O3 + 9CaO + 4NO2
        BLAST_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(350).EUt(120).blastFurnaceTemp(1350)
                .inputItems(dust, LeadNitrateCalciumMixture,18)
                .inputItems(dust, TantalumOxide,7)
                .inputItems(dust, ScandiumOxide,5)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, LeadScandiumTantalate,12)
                .outputItems(dust, Quicklime, 18)
                .outputFluids(NitrogenDioxide.getFluid(4000))
                .save(provider);

        // 4Tb + 7Ds + 10Fe + 5Co + 2B + Si + C -> [4Tb + 7Ds + 10Fe + 5Co + 2B + Si + C]
        LARGE_MIXER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(940).EUt(30)
                .inputItems(dust, Terbium, 4)
                .inputItems(dust, Dysprosium, 7)
                .inputItems(dust, Iron, 10)
                .inputItems(dust, Cobalt, 5)
                .inputItems(dust, Boron, 2)
                .inputItems(dust, Silicon)
                .inputItems(dust, Carbon)
                .outputItems(MagnetorestrictiveAlloy,30)
                .save(provider);

        // Pb + Se -> PbSe
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(120)
                .inputItems(dust, Lead)
                .inputItems(dust, Selenium)
                .outputItems(dust, LeadSelenide,2)
                .save(provider);

        // Zn + Se -> ZnSe
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(120)
                .inputItems(dust, Zinc)
                .inputItems(dust, Selenium)
                .outputItems(dust, ZincSelenide,2)
                .save(provider);

        // Fr + Cs + 2Cd + 6Br -> FrCsCd2Br6
        BLAST_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(350).EUt(120).blastFurnaceTemp(2200)
                .inputItems(dust, Francium)
                .inputItems(dust, Caesium)
                .inputItems(dust, Cadmium, 2)
                .inputFluids(Bromine.getFluid(6000))
                .outputItems(dust, FranciumCaesiumCadmiumBromide,10)
                .save(provider);

        // C6H5NH2 + NaNO2 + 2HCl + NaI -> 2NaCl + 2N + 2H2O + C6H5I
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(220).EUt(480)
                .inputFluids(Aniline.getFluid(1000))
                .inputItems(SodiumNitrite,4)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputItems(SodiumIodide,2)
                .outputItems(dust, Salt, 4)
                .outputFluids(Nitrogen.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputFluids(Iodobenzene.getFluid(1000))
                .save(provider);

        // C6H5I + C8H8 + Cl -> HCl + I + C14H12
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(350).EUt(18000)
                .notConsumable(dust, PalladiumAcetate)
                .inputFluids(Iodobenzene.getFluid(1000))
                .inputFluids(Styrene.getFluid(1000))
                .inputFluids(Chlorine.getFluid(1000))
                .notConsumableFluid(Tributylamine.getFluid(1))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .outputItems(dust, Iodine)
                .outputItems(Stilbene,26)
                .save(provider);

        // C6H6O2 + NH3 -> C6H7NO + H2O
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(220).EUt(480)
                .inputFluids(Resorcinol.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputFluids(Amino3phenol.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // C2H4 + NH3 -> C2H5NH2
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(130).EUt(480)
                .inputFluids(Ethylene.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputFluids(Ethylamine.getFluid(2000))
                .notConsumable(dust, SodiumAzanide)
                .save(provider);

        // 3C2H5NH2 + C6H7NO + 2C8H4O3 + HCl -> 2NH3 + C28H31ClN2O3 + 4O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(490000)
                .inputFluids(Ethylamine.getFluid(3000))
                .inputFluids(Amino3phenol.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputItems(dust, PhthalicAnhydride, 30)
                .notConsumable(dust, TetraethylammoniumNonahydridides)
                .outputFluids(Ammonia.getFluid(2000))
                .outputFluids(Oxygen.getFluid(4000))
                .outputItems(RhodamineB,65)
                .save(provider);

        // Re + 7F + 4H2O + NH3 -> 7HF + NH4ReO4
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(300).EUt(7680)
                .inputItems(dust, Rhenium)
                .inputFluids(Fluorine.getFluid(7000))
                .inputFluids(Water.getFluid(4000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(7000))
                .outputFluids(AmmoniumPerrhenate.getFluid(1000))
                .save(provider);

        // Tc + NaOH + 2HNO3 -> NO2 + H3NO + NaTcO4
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(300).EUt(480)
                .inputItems(dust, Technetium)
                .inputItems(dust, SodiumHydroxide, 3)
                .inputFluids(NitricAcid.getFluid(2000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .outputFluids(Hydroxylamine.getFluid(1000))
                .outputItems(SodiumPertechnetate,6)
                .save(provider);

        // KOH + NH4ReO4 -> KReO4 + NH3 + H2O
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(280).EUt(480)
                .inputFluids(PotassiumHydroxide.getFluid(1000))
                .inputFluids(AmmoniumPerrhenate.getFluid(1000))
                .outputItems(PotassiumPerrhenate,6)
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // K + NaTcO4 -> KTcO4 + Na
        BLAST_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(280).EUt(120).blastFurnaceTemp(6500)
                .inputItems(dust, Potassium)
                .inputItems(dust, SodiumPertechnetate,6)
                .outputItems(dust, PotassiumPertechnate,6)
                .outputItems(dust, Sodium)
                .save(provider);

        // KReO4 + 18K + 13C2H5OH + 4O -> 4KOH + H9K2ReO4 + 13C2H5KO
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(1920)
                .inputItems(PotassiumPerrhenate,6)
                .inputItems(dust, Potassium, 18)
                .inputFluids(Ethanol.getFluid(13000))
                .inputFluids(Oxygen.getFluid(4000))
                .outputFluids(PotassiumHydroxide.getFluid(4000))
                .outputItems(PotassiumNonahydridorhenate,16)
                .outputFluids(PotassiumEthoxide.getFluid(13000))
                .save(provider);

        // KTcO4 + 18K + 13C2H5OH + 4O -> 4KOH + H9K2TcO4 + 13C2H5KO
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(1920)
                .inputItems(PotassiumPertechnate,6)
                .inputItems(dust, Potassium, 18)
                .inputFluids(Ethanol.getFluid(13000))
                .inputFluids(Oxygen.getFluid(4000))
                .outputFluids(PotassiumHydroxide.getFluid(4000))
                .outputItems(PotassiumNonahydridotechnetate,16)
                .outputFluids(PotassiumEthoxide.getFluid(13000))
                .save(provider);

        // C2H5KO + HCl -> C2H5OH + KCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(200).EUt(480)
                .inputFluids(PotassiumEthoxide.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(Ethanol.getFluid(1000))
                .outputItems(dust, RockSalt, 2)
                .save(provider);

        // H9K2ReO4 + H9K2TcO4 + 2C8H20NBr + 2Br -> 4KBr + [C8H20NH9ReO4 + C8H20NH9TcO4]
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(360).EUt(15310)
                .inputItems(PotassiumNonahydridorhenate,16)
                .inputItems(PotassiumNonahydridotechnetate,16)
                .inputFluids(TetraethylammoniumBromide.getFluid(2000))
                .inputFluids(Bromine.getFluid(2000))
                .outputItems(PotassiumBromide,8)
                .outputItems(TetraethylammoniumNonahydridides,86)
                .save(provider);

        // KI + C6H7NO + C4H9Li -> C10H15N + KOH + LiI
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(200).EUt(480)
                .inputItems(PotassiumIodide,2)
                .inputFluids(AminoPhenol.getFluid(1000))
                .inputFluids(ButylLithium.getFluid(1000))
                .outputFluids(Butylaniline.getFluid(1000))
                .outputFluids(PotassiumHydroxide.getFluid(1000))
                .outputItems(LithiumIodide,2)
                .save(provider);

        // NaH + C3H9SiCl -> C3H10Si + NaCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(170).EUt(1920)
                .inputItems(SodiumHydride,2)
                .inputFluids(Trimethylchlorosilane.getFluid(1000))
                .outputFluids(Trimethylsilane.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .save(provider);

        // K + Br -> KBr
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(120)
                .inputItems(dust, Potassium)
                .inputFluids(Bromine.getFluid(1000))
                .outputItems(PotassiumBromide,2)
                .save(provider);

        // KBr + O3 -> KBrO3
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(200).EUt(480)
                .inputItems(PotassiumBromide,2)
                .inputFluids(Ozone.getFluid(1000))
                .outputItems(PotassiumBromate,5)
                .save(provider);

        // C8H4O3 + NaI + NaNO2 + [NaOH + H2O] + NH3 + HCl + 2Cl -> C7H5IO2 + N2 + CO2 + 3[H2O + NaCl]
        CHEMICAL_PLANT_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(350).EUt(122880)
                .inputItems(dust, PhthalicAnhydride, 15)
                .inputItems(SodiumIodide,2)
                .inputItems(SodiumNitrite,4)
                .inputFluids(SodiumHydroxideSolution.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(Chlorine.getFluid(2000))
                .outputFluids(IodobenzoicAcid.getFluid(1000))
                .outputFluids(Nitrogen.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputFluids(SaltWater.getFluid(3000))
                .save(provider);

        // 3C7H5IO2 + H2SO4 + 2O -> H2S + 3C7H5IO4
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(200).EUt(1920)
                .notConsumable(dust, PotassiumBromate)
                .inputFluids(IodobenzoicAcid.getFluid(3000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .inputFluids(Oxygen.getFluid(2000))
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputItems(IBX,51)
                .save(provider);

        // LiI -> Li + I
        ELECTROLYZER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(224).EUt(30)
                .inputItems(dust, LithiumIodide,2)
                .outputItems(dust, Lithium)
                .outputItems(dust, Iodine)
                .save(provider);

        // KBr -> K + Br
        ELECTROLYZER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(224).EUt(30)
                .inputItems(PotassiumBromide,2)
                .outputItems(dust, Potassium)
                .outputFluids(Bromine.getFluid(1000))
                .save(provider);

        // C3H10Si + C6H5Cl + 2CH2O + C7H5IO4 -> 2H + (CH3)3SiCl + C8H8O2 + C7H5IO4
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(250).EUt(7680)
                .inputFluids(Trimethylsilane.getFluid(1000))
                .inputFluids(Chlorobenzene.getFluid(1000))
                .inputFluids(Formaldehyde.getFluid(2000))
                .inputItems(IBX,17)
                .notConsumable(dust, CobaltOxide)
                .outputFluids(Trimethylchlorosilane.getFluid(1000))
                .outputFluids(Methoxybenzaldehyde.getFluid(1000))
                .outputFluids(IodobenzoicAcid.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);

        // C8H8O2 + C10H15N -> C18H21NO + H2O
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(190).EUt(122880)
                .inputFluids(Methoxybenzaldehyde.getFluid(1000))
                .inputFluids(Butylaniline.getFluid(1000))
                .notConsumable(dust, TetraethylammoniumNonahydridides)
                .outputFluids(MBBA.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(320).EUt(480)
                .inputItems(dust, CarbonNanotubes)
                .inputFluids(MBBA.getFluid(1000))
                .outputFluids(LiquidCrystalDetector.getFluid(1000))
                .save(provider);

        // PdCl2 + 2CH3COOH -> C4H6O4Pd + 2HCl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(260).EUt(480)
                .inputItems(PalladiumChloride,3)
                .inputFluids(AceticAcid.getFluid(2000))
                .outputItems(PalladiumAcetate,15)
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // I + Cl -> ICl
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(120)
                .inputItems(dust, Iodine)
                .inputFluids(Chlorine.getFluid(1000))
                .outputFluids(IodineMonochloride.getFluid(1000))
                .save(provider);

        // Re + Rh + Nq -> ReRhNq
        MIXER_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(260).EUt(84500)
                .inputItems(dust, Rhenium)
                .inputItems(dust, Rhodium)
                .inputItems(dust, Naquadah)
                .outputItems(RhReNqCatalyst,3)
                .save(provider);

        // Mg + 2Cl -> MgCl2
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(50).EUt(120)
                .inputItems(dust, Magnesium)
                .inputFluids(Chlorine.getFluid(2000))
                .outputItems(dust, MagnesiumChloride, 3)
                .save(provider);

        // 2MgCl2 + 3C2H2 + (CH3)3SiCl + 2Br -> 3HCl + C9H12Si(MgBr)2 + 2Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(350).EUt(480)
                .inputItems(dust, MagnesiumChloride, 6)
                .inputFluids(Acetylene.getFluid(3000))
                .inputFluids(Trimethylchlorosilane.getFluid(1000))
                .inputFluids(Bromine.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(3000))
                .outputFluids(AcetylatingReagent.getFluid(1000))
                .outputFluids(Chlorine.getFluid(2000))
                .save(provider);

        // C10H8 + 2CH4O -> 2H2O + C12H12
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(260).EUt(120)
                .inputFluids(Naphthalene.getFluid(1000))
                .inputFluids(Methanol.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputFluids(Dimethylnaphthalene.getFluid(1000))
                .save(provider);

        // C12H12 + C9H12Si(MgBr)2 + ICl + 2 Cl + C4H4BrNO2 -> 2MgClBr + H2C18H11I + (CH3)3SiCl  + HBr + C4H5NO2
        CHEMICAL_PLANT_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(290).EUt(122880)
                .inputFluids(Dimethylnaphthalene.getFluid(1000))
                .inputFluids(AcetylatingReagent.getFluid(1000))
                .inputFluids(IodineMonochloride.getFluid(1000))
                .inputFluids(Chlorine.getFluid(2000))
                .inputItems(Bromosuccinimide,12)
                .notConsumable(dust, RhReNqCatalyst)
                .outputItems(MgClBromide,6)
                .outputItems(Succinimide,12)
                .outputFluids(Dihydroiodotetracene.getFluid(1000))
                .outputFluids(Trimethylchlorosilane.getFluid(1000))
                .outputFluids(HydrobromicAcid.getFluid(1000))
                .save(provider);

        // C6H5OH + 10Cl + 2HCN + O -> 8HCl + C8Cl2N2O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(250).EUt(30720)
                .inputFluids(Phenol.getFluid(1000))
                .inputFluids(Chlorine.getFluid(10000))
                .inputFluids(HydrogenCyanide.getFluid(2000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(8000))
                .outputFluids(Dichlorodicyanobenzoquinone.getFluid(1000))
                .save(provider);

        // C8N2Cl2(OH)2 + H2O2 -> C8Cl2N2O2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(250).EUt(480)
                .inputFluids(Dichlorodicyanohydroquinone.getFluid(1000))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputFluids(Dichlorodicyanobenzoquinone.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .notConsumable(dust, VanadiumOxide)
                .save(provider);

        // C4H6O4Pd + Li2TiO3 + 2HCl + H2O -> C4H6O4 + 2[H2O + LiCl] + PdTiO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(350).EUt(491520)
                .inputItems(PalladiumAcetate,15)
                .inputItems(wireFine, LithiumTitanate, 24)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputFluids(Water.getFluid(1000))
                .notConsumable(UVA_HALIDE_LAMP)
                .outputFluids(LithiumChlorideSolution.getFluid(2000))
                .outputItems(dust, SuccinicAcid,14)
                .outputItems(PalladiumLoadedRutileNanoparticles,5)
                .save(provider);

        // 2H2C18H11I + 2C8Cl2N2O2 + C3H8O -> C3H6O + 2C8N2Cl2(OH)2 + 2I + 2C18H12
        LARGE_CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(260).EUt(491520)
                .inputFluids(Dihydroiodotetracene.getFluid(2000))
                .inputFluids(Dichlorodicyanobenzoquinone.getFluid(2000))
                .inputFluids(IsopropylAlcohol.getFluid(1000))
                .outputFluids(Acetone.getFluid(1000))
                .outputFluids(Dichlorodicyanohydroquinone.getFluid(2000))
                .outputItems(dust, Iodine, 2)
                .outputItems(Tetracene,60)
                .notConsumable(UVA_HALIDE_LAMP)
                .notConsumable(dust, PalladiumLoadedRutileNanoparticles)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("sensor_emitter_" + chainNumber++).duration(240).EUt(491520)
                .inputItems(LEPTON_TRAP_CRYSTAL)
                .inputItems(dustSmall, Vibranium, 2)
                .inputFluids(HeavyLeptonMix.getFluid(500))
                .inputFluids(FreeElectronGas.getFluid(500))
                .outputItems(CHARGED_LEPTON_TRAP_CRYSTAL)
                .save(provider);
    }
}

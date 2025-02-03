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

public class HNIWChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;
        // 2NH3 + H2SO4 -> (NH4)2SO4
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++).duration(200).EUt(480)
                .inputFluids(Ammonia.getFluid(2000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .circuitMeta(1)
                .outputFluids(AmmoniumSulfate.getFluid(1000))
                .save(provider);

        //(NH4)2SO4 + CaCO3 -> (NH4)2CO3 + CaSO4
        BLAST_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++).duration(270).EUt(120).blastFurnaceTemp(700)
                .inputFluids(AmmoniumSulfate.getFluid(1000))
                .inputItems(dust, Calcite, 5)
                .outputItems(dust, Gypsum, 6)
                .outputItems(AmmoniumCarbonate,14)
                .save(provider);


        //K2CO3 + 2 SO2 + H2O -> 2 KHSO3 + CO2
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(SulfurDioxide.getFluid(2000))
                .inputItems(PotassiumCarbonate,6)
                .inputFluids(Water.getFluid(1000))
                .outputItems(PotassiumBisulfite,12)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // K + HNO3 -> KNO3 + H
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(dust, Potassium)
                .inputFluids(NitricAcid.getFluid(1000))
                .outputItems(dust, Saltpeter, 5)
                .outputFluids(Hydrogen.getFluid(1000))
                .duration(100).EUt(30).save(provider);

        //KNO3 + Pb -> PbO + KNO2
        BLAST_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(dust, Saltpeter, 5)
                .inputItems(dust, Lead)
                .outputItems(PotassiumNitrite,4)
                .outputItems(dust, Massicot, 2)
                .blastFurnaceTemp(3000)
                .EUt(120)
                .duration(200)
                .save(provider);

        //KNO2 + CH3COOH + NaCl -> HNO2 + CH3COONa + KCl
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(PotassiumNitrite,4)
                .inputFluids(AceticAcid.getFluid(1000))
                .inputItems(dust, Salt, 2)
                .outputFluids(NitrousAcid.getFluid(1000))
                .outputItems(dust, RockSalt, 2)
                .outputFluids(SodiumAcetate.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        ///2 KHSO3 + HNO2 -> K2NHS2O7 + H2O
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(NitrousAcid.getFluid(1000))
                .inputItems(PotassiumBisulfite,12)
                .outputItems(PotassiumHydroxylaminedisulfonate,13)
                .outputFluids(Water.getFluid(1000))
                .EUt(1920)
                .duration(100)
                .save(provider);

        //2 K2NHS2O7 + 4 H2O -> 2 K2SO4 + H2SO4 + N2H8SO6
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(PotassiumHydroxylaminedisulfonate,26)
                .inputFluids(Water.getFluid(4000))
                .outputItems(HydroxylammoniumSulfate,17)
                .outputItems(PotassiumSulfate,12)
                .outputFluids(SulfuricAcid.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save(provider);

        //N2H8SO6 + BaCl2 -> 2 H4NOCl + BaSO4
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(HydroxylammoniumSulfate,17)
                .inputItems(BariumChloride,3)
                .outputFluids(HydroxylamineHydrochloride.getFluid(2000))
                .outputFluids(BariumSulfateSolution.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        //C4H6O4 + CaCl2 (not consumed) + (CH3CO)2O -> C4H4O3 + 2 CH3COOH
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(SuccinicAcid,14)
                .inputFluids(AceticAnhydride.getFluid(1000))
                .notConsumable(dust, CalciumChloride)
                .outputItems(SuccinicAnhydride,11)
                .outputFluids(AceticAcid.getFluid(2000))
                .EUt(7680)
                .duration(100)
                .save(provider);

        //2 CH2O + C2H2 + 4 H -> C4H8O + H2O
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(Acetylene.getFluid(1000))
                .inputFluids(Formaldehyde.getFluid(2000))
                .inputFluids(Hydrogen.getFluid(4000))
                .outputFluids(Tetrahydrofuran.getFluid(1000))
                .EUt(7680)
                .duration(75)
                .save(provider);

        //C4H4O3 + NH3OHCl + Na -> C4H5NO3 + H2O + NaCl + H
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(SuccinicAnhydride,11)
                .inputItems(dust, Sodium)
                .inputFluids(HydroxylamineHydrochloride.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputItems(NHydroxysuccinimide,13)
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save(provider);

        //NH3 + 3 C2H5OH -> (C2H5)3N + 3 H2O
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Ethanol.getFluid(3000))
                .outputFluids(Triethylamine.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        //(CH2CO)2NOH + (CH3CO)2O -> C6H7NO4 + CH3COOH
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .notConsumableFluid(Triethylamine.getFluid(1000))
                .inputFluids(AceticAnhydride.getFluid(1000))
                .inputItems(NHydroxysuccinimide,13)
                .notConsumableFluid(Tetrahydrofuran.getFluid(1000))
                .outputItems(SuccinimidylAcetate,18)
                .outputFluids(AceticAcid.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save(provider);

        // Se + 2O -> SeO2
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(dust, Selenium)
                .inputFluids(Oxygen.getFluid(2000))
                .outputItems(SeleniumOxide,3)
                .duration(100).EUt(30).save(provider);

        //SeO2 + H2O -> H2SeO3
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(SeleniumOxide)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(SelenousAcid.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        //CH3CHO + O -> (CHO)2 + H2O
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(Acetaldehyde.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .notConsumableFluid(SelenousAcid.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Glyoxal.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        //2 CH3COOH + (NH4)2CO3 -> H2O + CO2 + 2 CH3COONH4
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(AmmoniumCarbonate,14)
                .inputFluids(AceticAcid.getFluid(2000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(AmmoniumAcetate,24)
                .EUt(1920)
                .duration(100)
                .save(provider);

        //CH3COONH4 -> CH3CONH2 + H2O (H2O lost in dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(AmmoniumAcetate,12)
                .outputItems(Acetamide,9)
                .EUt(480)
                .duration(100)
                .save(provider);

        //CH3CONH2 -> CH3CN + H2O (H2O lost in dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(Acetamide,9)
                .outputItems(Acetonitrile,6)
                .EUt(480)
                .duration(100)
                .save(provider);

        //C7H8 + Cl -> C7H7Cl + H
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(Toluene.getFluid(1000))
                .inputFluids(Chlorine.getFluid(1000))
                .notConsumable(UVA_HALIDE_LAMP)
                .outputFluids(BenzylChloride.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        //6 CH2O + 4 NH3 -> C6H12N4 + 6 H2O
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(Formaldehyde.getFluid(4000))
                .inputFluids(Ammonia.getFluid(6000))
                .outputItems(Hexamethylenetetramine,22)
                .outputFluids(Water.getFluid(6000))
                .EUt(480)
                .duration(100)
                .save(provider);

        //C7H7Cl + C6H12N4 + 2 HCl + 6 H2O -> C7H9N + 6 CH2O + 3 NH4Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(BenzylChloride.getFluid(1000))
                .inputItems(Hexamethylenetetramine,22)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputFluids(Water.getFluid(6000))
                .outputFluids(Benzylamine.getFluid(1000))
                .outputFluids(AmmoniumChloride.getFluid(3000))
                .outputFluids(Formaldehyde.getFluid(6000))
                .EUt(7680)
                .duration(200)
                .save(provider);

        //6 C7H9N + 3 (CHO)2 + CH3CN (not consumed) -> C48N6H48 + 6 H2O
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(Glyoxal.getFluid(3000))
                .inputFluids(Benzylamine.getFluid(6000))
                .notConsumable(dust, Acetonitrile)
                .outputItems(Hexabenzylhexaazaisowurtzitane)
                .outputFluids(Water.getFluid(6000))
                .EUt(7680)
                .duration(100)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(PalladiumChloride)
                .inputItems(dust, Carbon)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(Formaldehyde.getFluid(1000))
                .outputItems(PdCCatalyst)
                .EUt(1920)
                .duration(100)
                .save(provider);

        //C48N6H48 + 4C6H7NO4 + 8H -> 4C7H8 + C28N6H32O4 + 4C4H5NO2 + 4O
        CHEMICAL_PLANT_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(Hexabenzylhexaazaisowurtzitane)
                .inputItems(SuccinimidylAcetate,72)
                .inputFluids(Hydrogen.getFluid(8000))
                .notConsumable(dust, PdCCatalyst)
                .notConsumableFluid(Ethylbenzene.getFluid(1000))
                .notConsumableFluid(HydrobromicAcid.getFluid(1000))
                .notConsumableFluid(Dimethylformamide.getFluid(1000))
                .outputItems(DibenzylTetraacetylhexaazaisowurtzitane)
                .outputItems(Succinimide,48)
                .outputFluids(Toluene.getFluid(4000))
                .outputFluids(Oxygen.getFluid(4000))
                .EUt(30720)
                .duration(100)
                .save(provider);

        //BF3 + HF + HNO3 -> NO2BF4 + H2O
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(BoronFluoride.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(1000))
                .inputFluids(NitricAcid.getFluid(1000))
                .outputItems(NitroniumTetrafluoroborate,8)
                .outputFluids(Water.getFluid(1000))
                .EUt(1920)
                .duration(100)
                .save(provider);

        //BF3 + HF + NO2 -> NOBF4 + HNO3
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(BoronFluoride.getFluid(2000))
                .inputFluids(HydrofluoricAcid.getFluid(2000))
                .inputFluids(DinitrogenTetroxide.getFluid(2000))
                .outputItems(NitrosoniumTetrafluoroborate,7)
                .outputFluids(NitricAcid.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);


        //C28N6H32O4 + 6 NOBF4 + 2 H2O -> C14N8H18O6 + 2 C7H6O + 4 NO + 6 HBF4
        LARGE_CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(DibenzylTetraacetylhexaazaisowurtzitane)
                .inputItems(NitrosoniumTetrafluoroborate,42)
                .inputFluids(Water.getFluid(2000))
                .outputItems(Tetraacetyldinitrosohexaazaisowurtzitane)
                .outputFluids(TetrafluoroboricAcid.getFluid(6000))
                .outputFluids(NitricOxide.getFluid(4000))
                .outputFluids(Benzaldehyde.getFluid(2000))
                .EUt(1920)
                .duration(100)
                .save(provider);

        //C14N8H18O6 + 6 NO2BF4 + 4 H2O -> C6H6N12O12 + 2 NOBF4 + 4 CH3COOH + 4 HBF4
        LARGE_CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(Tetraacetyldinitrosohexaazaisowurtzitane)
                .inputItems(NitroniumTetrafluoroborate,48)
                .inputFluids(Water.getFluid(4000))
                .outputItems(CrudeHexanitroHexaazaisowurtzitane)
                .outputItems(NitrosoniumTetrafluoroborate,14)
                .outputFluids(TetrafluoroboricAcid.getFluid(4000))
                .outputFluids(AceticAcid.getFluid(4000))
                .EUt(491520)
                .duration(100)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(CrudeHexanitroHexaazaisowurtzitane)
                .inputFluids(Ethylenediamine.getFluid(1000))
                .inputItems(SilicaGel)
                .outputItems(HexanitroHexaazaisowurtzitane,8)
                .EUt(1920)
                .duration(100)
                .save(provider);

        // HBF4 + 3H2O -> 4HF + H3BO3
        CHEMICAL_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputFluids(TetrafluoroboricAcid.getFluid(1000))
                .inputFluids(Water.getFluid(3000))
                .outputFluids(HydrofluoricAcid.getFluid(4000))
                .outputFluids(BoricAcid.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("hniw_chain_" + chainNumber++)
                .inputItems(BrevibacteriumFlavium)
                .inputItems(Succinimide,12)
                .outputItems(SuccinicAnhydride,11)
                .outputFluids(Ammonia.getFluid(1000))
                .EUt(3840)
                .duration(100)
                .save(provider);

    }
}

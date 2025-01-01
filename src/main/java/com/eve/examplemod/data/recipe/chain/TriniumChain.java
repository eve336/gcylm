package com.eve.examplemod.data.recipe.chain;

import com.eve.examplemod.common.data.EVMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.api.data.tag.EVTagPrefix.*;
import static com.eve.examplemod.common.data.EVBlocks.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GCYMRecipeTypes.ALLOY_BLAST_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class TriniumChain {
    static int chainNumber = 1;
    public static void init(Consumer<FinishedRecipe> provider) {
        //B(OH)3 + 3 C2H5OH + 4 NaH -> 3 C2H5ONa + NaBH4 + 3 H2O
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .duration(120)
                .EUt(480)
                .inputItems(SodiumHydride,8)
                .inputFluids(BoricAcid.getFluid(1000))
                .inputFluids(Ethanol.getFluid(3000))
                .notConsumableFluid(SulfuricAcid.getFluid(250))
                .outputItems(SodiumBorohydride,6)
                .outputItems(SodiumEthoxide,27)
                .outputFluids(Water.getFluid(3000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(150).EUt(125)
                .inputFluids(Diethylether.getFluid(1000))
                .inputFluids(BoronFluoride.getFluid(1000))
                .outputFluids(BoronTrifluorideEtherate.getFluid(1000))
                .save(provider);

        //17 NaBH4 + 20 BF3·(CH2CH3)2O + 4 H2O2 + 2 HF -> 2 NaF + 2 H2O + 2 B10H14 + 2 B(OH)3 + 15 NaBF4 + 20 H2 + 20 (CH2CH3)2O
        //divided by two, and optimal choice as a gate
        LARGE_CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(380).EUt(2000)
                .inputItems(SodiumBorohydride,51)
                .inputFluids(HydrofluoricAcid.getFluid(1000))
                .inputFluids(HydrogenPeroxide.getFluid(2000))
                .inputFluids(BoronTrifluorideEtherate.getFluid(10000))
                .outputItems(Decaborane,24)
                .outputItems(dust, SodiumFluoride, 2)
                .outputItems(SodiumTetrafluoroborate,45)
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(20000))
                .outputFluids(Diethylether.getFluid(10000))
                .save(provider);

        //NaBF4 -> NaF + BF3
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(120).EUt(125)
                .inputItems(SodiumTetrafluoroborate,6)
                .circuitMeta(0)
                .outputItems(dust, SodiumFluoride, 2)
                .outputFluids(BoronFluoride.getFluid(1000))
                .save(provider);

        //B10H14 + NaCN + CsOH + 2 HCl + 3 CH3OH -> CsB10H12CN(CH3)3Cl + 4 H2O + NaCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(500)
                .inputItems(Decaborane,24)
                .inputItems(CaesiumHydroxide,3)
                .inputFluids(SodiumCyanide.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputFluids(Methanol.getFluid(3000))
                .notConsumableFluid(SulfuricAcid.getFluid(250))
                .outputItems(CesiumCarboranePrecusor,38)
                .outputItems(dust, Salt, 2)
                .outputFluids(Water.getFluid(4000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(165).EUt(125)
                .inputFluids(Dimethylsulfide.getFluid(2000))
                .inputFluids(Diborane.getFluid(1000))
                .outputFluids(BoraneDimethylsulfide.getFluid(2000))
                .save(provider);

        //CsB10H12CN(CH3)3Cl + NaH + BH3.(CH3)2S -> CsCB11H12 + N(CH3)3 + NaCl + H2S + 2 CH4
        LARGE_CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(260).EUt(500)
                .inputItems(CesiumCarboranePrecusor,38)
                .inputItems(SodiumHydride,2)
                .inputFluids(BoraneDimethylsulfide.getFluid(1000))
                .notConsumableFluid(Tetrahydrofuran.getFluid(250))
                .outputItems(CesiumCarborane,25)
                .outputItems(dust, Salt, 2)
                .outputFluids(Trimethylamine.getFluid(1000))
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputFluids(Methane.getFluid(2000))
                .save(provider);

        //2 CsCB11H12 + 2 AgNO3 + 44F + 2I + HCl + (CH3)3SiH -> 2 H(CHB11F11) + 2CsNO3 + 2AgI + 22HF + (CH3)3SiCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(320).EUt(2000)
                .inputItems(CesiumCarborane,50)
                .inputItems(SilverNitrate,10)
                .inputItems(dust, Iodine, 2)
                .inputFluids(Fluorine.getFluid(44000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(Trimethylsilane.getFluid(1000))
                .outputItems(Fluorocarborane,50)
                .outputItems(CaesiumNitrate,10)
                .outputItems(SilverIodide,4)
                .outputFluids(HydrofluoricAcid.getFluid(22000))
                .outputFluids(Trimethylchlorosilane.getFluid(1000))
                .save(provider);

        //Ag + 2 HNO3 -> AgNO3 + NO2 + H2O
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(150).EUt(125)
                .inputItems(dust, Silver)
                .inputFluids(NitricAcid.getFluid(2000))
                .outputItems(SilverNitrate,5)
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        //Ag2O + 2 HNO3 -> 2 AgNO3 + H2O
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(150).EUt(125)
                .inputItems(dust, SilverOxide, 3)
                .inputFluids(NitricAcid.getFluid(2000))
                .outputItems(SilverNitrate,10)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        ELECTROLYZER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(175).EUt(30)
                .inputItems(CaesiumNitrate,5)
                .outputItems(dust, Caesium)
                .outputFluids(Nitrogen.getFluid(1000))
                .outputFluids(Oxygen.getFluid(3000))
                .save(provider);

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(210).EUt(125).blastFurnaceTemp(1100)
                .inputItems(SilverIodide,4)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, SilverOxide, 3)
                .outputItems(dust, Iodine, 2)
                .save(provider);

        //Trinium Chain Proper

        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(200).EUt(125)
                .inputItems(dust, SodiumNitrate, 5)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(FumingNitricAcid.getFluid(1000))
                .outputItems(dust, SodiumBisulfate, 7)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(180).EUt(125)
                .inputFluids(FumingNitricAcid.getFluid(1000))
                .outputItems(PureCrystallineNitricAcid,5)
                .save(provider);

        //2 Ke3Ac2Se4At4 + 8 HNO3 + 8 SO2 + NaClO4 ->  8 SeO2 + 8At + [NaCl + 4 H2O + 2 Ke3Ac2S4(NO3)4 + ?]
        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(265).EUt(130500).blastFurnaceTemp(9400)
                .inputItems(dust, Triniite, 16)
                .inputItems(PureCrystallineNitricAcid,40)
                .inputItems(SodiumPerchlorate,6)
                .inputFluids(SulfurDioxide.getFluid(8000))
                .outputItems(dust, Astatine, 8)
                .outputItems(SeleniumOxide,24)
                .outputFluids(NitratedTriniiteSolution.getFluid(4000))
                .save(provider);

        //1/2[NaCl + 4 H2O + 2 Ke3Ac2S4(NO3)4 + ?] + 12 NaOH -> 4 Na2S + Ke3Ac2(OH)12? + [0.5 NaCl + 4 NaNO3 + 2 H2O + ?]
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(190).EUt(500)
                .inputItems(dust, SodiumHydroxide, 36)
                .inputFluids(NitratedTriniiteSolution.getFluid(2000))
                .outputItems(ActiniumTriniumHydroxides,29)
                .outputItems(dust, SodiumSulfide, 12)
                .outputFluids(ResidualTriniiteSolution.getFluid(2000))
                .save(provider);

        //0.5 NaCl + 4 NaNO3 + 2 H2O + ? -> 0.5 NaCl + 4 NaNO3 + 0.75 Nq + 0.5 Nq + 0.444 Nq*
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(190).EUt(8100)
                .inputFluids(ResidualTriniiteSolution.getFluid(2000))
                .outputItems(dust, Salt)
                .outputItems(dust, SodiumNitrate, 20)
                .outputItems(dustSmall, NaquadriaticCompound, 3)
                .outputItems(dustSmall, EnrichedNaquadricCompound, 2)
                .outputItems(dustTiny, NaquadriaticCompound, 4)
                .save(provider);

        // 6 KF + C6H6 + 6 Cl -> C6F6 + 6 KCl + 6 H
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(185).EUt(125)
                .inputItems(dust, PotassiumFluoride, 12)
                .inputFluids(Chlorine.getFluid(6000))
                .inputFluids(Benzene.getFluid(1000))
                .notConsumable(dust, Rhenium)
                .outputFluids(Perfluorobenzene.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(6000))
                .outputItems(dust, RockSalt, 12)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(350).EUt(32750)
                .inputItems(wireFine, CarbonNanotubes,6)
                .inputItems(Fullerene)
                .inputItems(Fluorocarborane,125)
                .inputFluids(Perfluorobenzene.getFluid(2000))
                .outputItems(PROTONATED_FULLERENE_SIEVING_MATRIX)
                .save(provider);

        //C65H70B55F55 + 6 Ra + 2 Ke3Ac2(OH)12? -> 2 Ra3Ac2(OH)12? + Ke6C65H70B55F55
        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(210).EUt(262000)
                .inputItems(dust, Radium, 6)
                .inputItems(ActiniumTriniumHydroxides,58)
                .inputItems(PROTONATED_FULLERENE_SIEVING_MATRIX)
                .inputFluids(Water.getFluid(2000))
                .outputItems(SATURATED_FULLERENE_SIEVING_MATRIX)
                .outputFluids(ActiniumRadiumHydroxideSolution.getFluid(2000))
                .save(provider);

        //Ke6C65H70B55F55 + 13 H2SbF7 + 59 KrF2 -> 59 Kr + 13 SbF3 + 6 KeF4 + 32 C2H2 + CF4 + 55 BF3 + 32 HF
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(180).EUt(131000)
                .inputItems(SATURATED_FULLERENE_SIEVING_MATRIX)
                .inputFluids(FluoroantimonicAcid.getFluid(13000))
                .inputFluids(KryptonDifluoride.getFluid(59000))
                .outputItems(AntimonyTrifluoride,52)
                .chancedOutput(wireFine, CarbonNanotubes, 6, 9500, 0)
                .outputFluids(Krypton.getFluid(59000))
                .outputFluids(HeavilyFluorinatedTriniumSolution.getFluid(2000))
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(350).EUt(32760)
                .inputFluids(HeavilyFluorinatedTriniumSolution.getFluid(2000))
                .outputItems(TriniumTetrafluoride,30)
                .outputFluids(Perfluorobenzene.getFluid(2000))
                .outputFluids(Acetylene.getFluid(32000))
                .outputFluids(BoronFluoride.getFluid(55000))
                .outputFluids(CarbonFluoride.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(32000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(30)
                .inputItems(dust, Calcium)
                .inputFluids(Fluorine.getFluid(2000))
                .outputItems(dust, Fluorite, 3)
                .save(provider);

        EXTRACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(40).EUt(30)
                .inputItems(dust, Fluorite)
                .outputFluids(Fluorite.getFluid(GTValues.L))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(30)
                .inputItems(dust, Calcium)
                .inputFluids(Fluorite.getFluid(432))
                .outputFluids(MoltenCalciumSalts.getFluid(1000))
                .save(provider);

        ELECTROLYZER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(200).EUt(2000)
                .inputItems(TriniumTetrafluoride,5)
                .inputFluids(MoltenCalciumSalts.getFluid(1000))
                .outputItems(dust, Trinium)
                .outputItems(dust, Calcium, 2)
                .outputFluids(Fluorine.getFluid(6000))
                .save(provider);

        //QoL to hook up the acetylene output into the fullerene chain

        //3 C2H2 -> C6H6
        FLUID_HEATER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(190).EUt(500)
                .inputFluids(Acetylene.getFluid(3000))
                .notConsumable(ALUMINO_SILICATE_GLASS_TUBE)
                .outputFluids(Benzene.getFluid(1000))
                .save(provider);

        //C6H6 + 2 C2H2 -> C10H8 + 2 H
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(230).EUt(500)
                .inputFluids(Benzene.getFluid(1000))
                .inputFluids(Acetylene.getFluid(2000))
                .notConsumable(UVA_HALIDE_LAMP)
                .outputFluids(Naphthalene.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);

        //Actinium Side

        //C2H2O + HCl -> C2H3OCl
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(125)
                .inputFluids(Ethenone.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(AcetylChloride.getFluid(1000))
                .save(provider);

        //C2H5OH + C2H2O + 3 HF -> C4H5F3O2 + 6 H
        LARGE_CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(230).EUt(500)
                .inputFluids(Ethanol.getFluid(1000))
                .inputFluids(AcetylChloride.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(3000))
                .outputFluids(EthylTrifluoroacetate.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(6000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .save(provider);

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(190).EUt(500).blastFurnaceTemp(900)
                .inputItems(dust, Phosphorus, 4)
                .inputItems(dust, Sulfur, 10)
                .outputItems(PhosphorousPentasulfide,14)
                .save(provider);

        //P4S10 + 10 C4H6O2 + 10 C2H3OCl -> P4O10 + 10 C6H6SO + 10 [HCl + H2O]
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(210).EUt(500)
                .inputItems(PhosphorousPentasulfide,7)
                .inputFluids(Succinaldehyde.getFluid(5000))
                .inputFluids(AcetylChloride.getFluid(5000))
                .outputFluids(Acetothienone.getFluid(5000))
                .outputFluids(DilutedHydrochloricAcid.getFluid(10000))
                .outputItems(dust, PhosphorusPentoxide, 7)
                .save(provider);

        //C2H5ONa + C6H6SO + C4H5F3O2 + HCl -> NaCl + 2 C2H5OH + C8H5F3O2S
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(220).EUt(1000)
                .inputItems(SodiumEthoxide,9)
                .inputFluids(EthylTrifluoroacetate.getFluid(1000))
                .inputFluids(Acetothienone.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(TheonylTrifluoroacetate.getFluid(1000))
                .outputFluids(Ethanol.getFluid(2000))
                .outputItems(dust, Salt, 2)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(290).EUt(4100)
                .inputFluids(ActiniumRadiumHydroxideSolution.getFluid(1000))
                .inputFluids(NitricAcid.getFluid(12000))
                .outputFluids(ActiniumRadiumNitrateSolution.getFluid(13000))
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(32700)
                .inputFluids(ActiniumRadiumNitrateSolution.getFluid(13000))
                .notConsumableFluid(TheonylTrifluoroacetate.getFluid(500))
                .outputItems(ActiniumNitrate,26)
                .outputItems(RadiumNitrate,27)
                .outputItems(dustSmall, Thorium)
                .outputItems(dustSmall, Protactinium)
                .outputItems(dustSmall, Francium)
                .outputItems(dustSmall, Radium)
                .outputFluids(Water.getFluid(13000))
                .save(provider);

        //Ac(NO3)3 -> Ac + 3 N + 9 O
        ELECTROLYZER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(210).EUt(500)
                .inputItems(ActiniumNitrate,13)
                .outputItems(dust, Actinium)
                .outputFluids(Nitrogen.getFluid(3000))
                .outputFluids(Oxygen.getFluid(9000))
                .save(provider);

        //Ra(NO3)2 -> Ra + 2 N + 6 O
        ELECTROLYZER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(500)
                .inputItems(RadiumNitrate,9)
                .outputItems(dust, Radium)
                .outputFluids(Nitrogen.getFluid(2000))
                .outputFluids(Oxygen.getFluid(6000))
                .save(provider);

    }
}

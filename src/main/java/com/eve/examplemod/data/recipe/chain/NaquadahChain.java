package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class NaquadahChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // Nq + 2[HNO3 + HCl] -> Naquadric Solution [Nq + NO2] + [H2O + HNO3] + HCl + Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, NaquadricCompound)
                .inputFluids(AquaRegia.getFluid(4000))
                .outputFluids(NaquadricSolution.getFluid(1000))
                .outputFluids(DiluteNitricAcid.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(Chlorine.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, Potassium, 2)
                .inputFluids(HydrogenPeroxide.getFluid(3000))
                .inputFluids(SulfuricAcid.getFluid(2000))
                .outputItems(dust, PotassiumPeroxymonosulfate, 16)
                .outputFluids(Water.getFluid(4000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(PotassiumHydroxide.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, PotassiumPeroxymonosulfate, 8)
                .outputFluids(Water.getFluid(1000))
                .save(provider);


        // Nq + 2[HNO3 + HCl] = Enriched Naquadric Solution [Nq + NO2] + [H2O + HNO3] + HCl + Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, EnrichedNaquadricCompound)
                .inputFluids(AquaRegia.getFluid(4000))
                .outputFluids(EnrichedNaquadricSolution.getFluid(1000))
                .outputFluids(DiluteNitricAcid.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(Chlorine.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // Nq + 2[HNO3 + HCl] = Naquadriatic Solution [Nq + NO2] + [H2O + HNO3] + HCl + Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, NaquadriaticCompound)
                .inputFluids(AquaRegia.getFluid(4000))
                .outputFluids(NaquadriaticSolution.getFluid(1000))
                .outputFluids(DiluteNitricAcid.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(Chlorine.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // Sb2O3 + 6HF = 2SbF3 + 3H2O
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, AntimonyTrioxide, 5)
                .inputFluids(HydrofluoricAcid.getFluid(6000))
                .outputItems(AntimonyTrifluoride,8)
                .outputFluids(Water.getFluid(3000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // SbF3 + 2F = SbF5
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(AntimonyTrifluoride,4)
                .inputFluids(Fluorine.getFluid(2000))
                .outputFluids(AntimonyPentafluoride.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // SbF5 + 2HF = H2SbF7
        LARGE_CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .circuitMeta(0)
                .inputFluids(AntimonyPentafluoride.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(FluoroantimonicAcid.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // Naquadric Solution [Nq + NO2] + H2SbF7 = SbF3 + Fluoronaquadric Acid [H2NqF4] + NO2
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NaquadricSolution.getFluid(1000))
                .inputFluids(FluoroantimonicAcid.getFluid(1000))
                .outputItems(AntimonyTrifluoride,4)
                .outputFluids(FluoronaquadricAcid.getFluid(1000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // Enriched Naquadric Solution [Nq + NO2] + H2SbF7 = SbF3 + Enriched Fluoronaquadric Acid [H2NqF4] + NO2
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(EnrichedNaquadricSolution.getFluid(1000))
                .inputFluids(FluoroantimonicAcid.getFluid(1000))
                .outputItems(AntimonyTrifluoride,4)
                .outputFluids(EnrichedFluoronaquadricAcid.getFluid(1000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // Naquadriatic Solution [Nq + NO2] + H2SbF7 = SbF3 + Fluoronaquadriatic Acid [H2NqF4] + NO2
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NaquadriaticSolution.getFluid(1000))
                .inputFluids(FluoroantimonicAcid.getFluid(1000))
                .outputItems(AntimonyTrifluoride,4)
                .outputFluids(FluoronaquadriaticAcid.getFluid(1000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // Fluoronaquadric Acid [H2NqF4] = 2HF + Naquadah Difluoride [NqF2]
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(FluoronaquadricAcid.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(NaquadahDifluoride.getFluid(1000))
                .EUt(7680)
                .duration(100)
                .save(provider);

        // Enriched Fluoronaquadric Acid [H2NqF4] = 2HF + Enriched Naquadah Difluoride [NqF2]
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(EnrichedFluoronaquadricAcid.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(EnrichedNaquadahDifluoride.getFluid(1000))
                .EUt(7680)
                .duration(100)
                .save(provider);

        // Fluoronaquadriatic Acid [H2NqF4] = 2HF + Naquadria Difluoride [NqF2]
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(FluoronaquadriaticAcid.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(NaquadriaDifluoride.getFluid(1000))
                .EUt(7680)
                .duration(100)
                .save(provider);

        // 3 Naquadah Difluoride [NqF2] + 2In = 2InF3 + 3 Naquadah Concentrate [Nq]
        BLAST_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NaquadahDifluoride.getFluid(3000))
                .inputItems(dust, Indium, 2)
                .outputItems(dust, IndiumTrifluoride,8)
                .outputItems(dust, NaquadahConcentrate,3)
                .EUt(30720)
                .duration(100)
                .blastFurnaceTemp(4500)
                .save(provider);

        // 3 Enriched Naquadah Difluoride [NqF2] + 2In = 2InF3 + 3 Enriched Naquadah Concentrate [Nq]
        BLAST_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(EnrichedNaquadahDifluoride.getFluid(3000))
                .inputItems(dust, Indium, 2)
                .outputItems(dust, IndiumTrifluoride,8)
                .outputItems(EnrichedNaquadahConcentrate,3)
                .EUt(30720)
                .duration(100)
                .blastFurnaceTemp(4500)
                .save(provider);

        // 3 Naquadria Difluoride [NqF2] + 2In = 2InF3 + 3 Naquadria Concentrate [Nq]
        BLAST_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NaquadriaDifluoride.getFluid(3000))
                .inputItems(dust, Indium, 2)
                .outputItems(dust, IndiumTrifluoride,8)
                .outputItems(NaquadriaConcentrate,3)
                .EUt(30720)
                .duration(100)
                .blastFurnaceTemp(4500)
                .save(provider);

        // 6F + Naquadria Concentrate [Nq] = Naquadria Hexafluoride [NqF6]
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(Fluorine.getFluid(6000))
                .inputItems(dust, NaquadriaConcentrate)
                .outputFluids(NaquadriaHexafluoride.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // Rn + 2F = RnF2
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(Radon.getFluid(1000))
                .inputFluids(Fluorine.getFluid(2000))
                .outputFluids(RadonDifluoride.getFluid(1000))
                .EUt(120)
                .duration(200)
                .save(provider);

        // RnF2 + Naquadria Hexafluoride [NqF6] = Radon Naquadriaoctafluoride [RnNqF8]
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(RadonDifluoride.getFluid(1000))
                .inputFluids(NaquadriaHexafluoride.getFluid(1000))
                .outputFluids(RadonNaquadriaoctafluoride.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // Xe + 3O = XeO3
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(Xenon.getFluid(1000))
                .inputFluids(Oxygen.getFluid(3000))
                .outputFluids(XenonTrioxide.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // XeO3 -> Xe + O3
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(XenonTrioxide.getFluid(1000))
                .outputFluids(Xenon.getFluid(1000))
                .outputFluids(Oxygen.getFluid(3000))
                .EUt(30)
                .duration(370)
                .save(provider);

        // Cs + F = CsF
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, Caesium)
                .inputFluids(Fluorine.getFluid(1000))
                .outputFluids(CesiumFluoride.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // CsF + XeO3 = CsXeO3F
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(CesiumFluoride.getFluid(1000))
                .inputFluids(XenonTrioxide.getFluid(1000))
                .outputFluids(CesiumXenontrioxideFluoride.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // CsXeO3F + Radon Naquadriaoctafluoride [RnNqF8] = RnO3 + NqCsXeF9
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(CesiumXenontrioxideFluoride.getFluid(1000))
                .inputFluids(RadonNaquadriaoctafluoride.getFluid(1000))
                .outputFluids(RadonTrioxide.getFluid(1000))
                .outputFluids(NaquadriaCesiumXenonNonfluoride.getFluid(1000))
                .EUt(7680)
                .duration(200)
                .save(provider);

        // NO2 + F = NO2F
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NitrogenDioxide.getFluid(1000))
                .inputFluids(Fluorine.getFluid(1000))
                .outputFluids(NitrylFluoride.getFluid(1000))
                .EUt(120)
                .duration(120)
                .save(provider);

        // 2NO2F + NqCsXeF9 = (NO2)2XeF8 + NqF2CsF
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NitrylFluoride.getFluid(2000))
                .inputFluids(NaquadriaCesiumXenonNonfluoride.getFluid(1000))
                .outputFluids(NitrosoniumOctafluoroxenate.getFluid(1000))
                .outputFluids(NaquadriaCesiumfluoride.getFluid(1000))
                .EUt(480)
                .duration(400)
                .save(provider);

        // NqF2CsF = Nq + 3F + Cs
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NaquadriaCesiumfluoride.getFluid(1000))
                .outputItems(dust, Naquadria)
                .outputFluids(Fluorine.getFluid(3000))
                .outputItems(dust, Caesium)
                .EUt(30720)
                .duration(120)
                .save(provider);

        // RnO3 = Rn + O3
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(RadonTrioxide.getFluid(1000))
                .outputFluids(Radon.getFluid(1000))
                .outputFluids(Oxygen.getFluid(3000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // (NO2)2XeF8 = 8F + Xe + 2NO2
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NitrosoniumOctafluoroxenate.getFluid(1000))
                .outputFluids(Fluorine.getFluid(8000))
                .outputFluids(Xenon.getFluid(1000))
                .outputFluids(NitrogenDioxide.getFluid(2000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // Enriched Naquadah Concentrate [Nq] + 6F = NqF6
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(EnrichedNaquadahConcentrate)
                .inputFluids(Fluorine.getFluid(6000))
                .outputFluids(EnrichedNaquadahhexafluoride.getFluid(1000))
                .EUt(480)
                .duration(175)
                .save(provider);

        // NqF6 + Xe = XeNqF6
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(EnrichedNaquadahhexafluoride.getFluid(1000))
                .inputFluids(Xenon.getFluid(1000))
                .outputFluids(EnrichedXenonHexafluoronaquadate.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // 2Au + 3Cl2 -> Au2Cl6
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, Gold, 2)
                .inputFluids(Chlorine.getFluid(6000))
                .outputFluids(AuricChloride.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // Br + 3F = BrF3
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(Bromine.getFluid(1000))
                .inputFluids(Fluorine.getFluid(3000))
                .outputFluids(BromineTrifluoride.getFluid(1000))
                .EUt(30)
                .duration(150)
                .save(provider);

        // 2BrF3 + Au2Cl6 = 2AuF3 + 2Br + 6Cl
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(BromineTrifluoride.getFluid(2000))
                .inputFluids(AuricChloride.getFluid(1000))
                .outputItems(AuricFluoride,8)
                .outputFluids(Bromine.getFluid(2000))
                .outputFluids(Chlorine.getFluid(6000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // H2SbF7 + AuF3 + XeNqF6 + 9H = Nq + 9HF + [AuXe + H2SbF7]
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(AuricFluoride,4)
                .inputFluids(FluoroantimonicAcid.getFluid(1000))
                .inputFluids(EnrichedXenonHexafluoronaquadate.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(9000))
                .outputItems(dust, NaquadahEnriched)
                .outputFluids(XenoauricFluoroantimonicAcid.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(9000))
                .EUt(480)
                .duration(125)
                .save(provider);

        // [AuXe + H2SbF7] = Au + Xe + 2HF + SbF5
        ELECTROLYZER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(XenoauricFluoroantimonicAcid.getFluid(1000))
                .outputItems(dust, Gold)
                .outputFluids(Xenon.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(AntimonyPentafluoride.getFluid(1000))
                .EUt(7680)
                .duration(200)
                .save(provider);

        // 2H2SO4 + 3H2O2 + 2K = 2KHSO5 + 4H2O
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(SulfuricAcid.getFluid(2000))
                .inputFluids(HydrogenPeroxide.getFluid(3000))
                .inputItems(dust, Potassium, 2)
                .outputItems(PotassiumPeroxymonosulfate,16)
                .outputFluids(Water.getFluid(4000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // KOH + O + H2SO4 -> KHSO5 + H2O
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(PotassiumHydroxide.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(PotassiumPeroxymonosulfate,8)
                .EUt(480)
                .duration(100)
                .save(provider);

        // HF + KHSO5 + Nq = H2O + KF + NqSO4
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(HydrofluoricAcid.getFluid(1000))
                .inputItems(dust, PotassiumPeroxymonosulfate,8)
                .inputItems(dust, NaquadahConcentrate)
                .outputFluids(Water.getFluid(1000))
                .outputItems(dust, PotassiumFluoride, 2)
                .outputFluids(NaquadahSulfate.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // NqSO4 + 2H = H2SO4 + Nq
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NaquadahSulfate.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, Naquadah)
                .EUt(7680)
                .duration(200)
                .save(provider);

        // 2InF3 + 3H2O = In2O3 + 6HF
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, IndiumTrifluoride,8)
                .inputFluids(Water.getFluid(3000))
                .outputItems(dust, IndiumTrioxide,5)
                .outputFluids(HydrofluoricAcid.getFluid(6000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // In2O3 + 3C = 2In + 3CO
        BLAST_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, IndiumTrioxide,5)
                .inputItems(dust, Carbon, 3)
                .outputItems(dust, Indium, 2)
                .outputFluids(CarbonMonoxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .blastFurnaceTemp(4500)
                .save(provider);

        // NH3 + HNO3 = NH4NO3
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(NitricAcid.getFluid(1000))
                .outputFluids(AmmoniumNitrate.getFluid(1000))
                .EUt(480)
                .duration(120)
                .save(provider);

        // Nq + NH4NO3 = Naquadah Solution [Nq + NH4NO3]
        MIXER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, Naquadah)
                .inputFluids(AmmoniumNitrate.getFluid(1000))
                .outputFluids(NaquadahSolution.getFluid(1000))
                .EUt(7680)
                .duration(200)
                .save(provider);

        // 2 Naquadah Solution [Nq + NH4NO3] = Clear Naquadah Liquid + NH3 + HNO3
        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(NaquadahSolution.getFluid(2000))
                .outputFluids(ClearNaquadahLiquid.getFluid(1000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(NitricAcid.getFluid(1000))
                .chancedOutput(dust, PlatinumRawPowder, 15, "1/9", 0)
                .chancedOutput(dust, IridiumChloride, 12, "1/9", 0)
                .chancedOutput(dust, Naquadah, "1/9", 0)
                .EUt(7680)
                .duration(150)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ClearNaquadahLiquid.getFluid(1000))
                .outputFluids(ComplicatedNaquadahGas.getFluid(60))
                .outputFluids(ComplicatedLightNaquadah.getFluid(180))
                .outputFluids(ComplicatedMediumNaquadah.getFluid(320))
                .outputFluids(ComplicatedHeavyNaquadah.getFluid(440))
                .EUt(7680)
                .duration(500)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ComplicatedNaquadahGas.getFluid(2000))
                .outputFluids(NaquadahGas.getFluid(1000))
                .chancedOutput(dust, IridiumChloride, 4, "1/9", 0)
                .EUt(7680)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ComplicatedHeavyNaquadah.getFluid(2000))
                .outputFluids(HeavyNaquadah.getFluid(1000))
                .chancedOutput(dust, IridiumChloride, 4, "1/9", 0)
                .EUt(7680)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ComplicatedLightNaquadah.getFluid(2000))
                .outputFluids(LightNaquadah.getFluid(1000))
                .chancedOutput(dust, IridiumChloride, 4, "1/9", 0)
                .EUt(7680)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ComplicatedMediumNaquadah.getFluid(2000))
                .outputFluids(MediumNaquadah.getFluid(1000))
                .chancedOutput(dust, IridiumChloride, 4, "1/9", 0)
                .EUt(7680)
                .duration(200)
                .save(provider);

        CRACKING_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(MediumNaquadah.getFluid(1000))
                .inputFluids(Fluorine.getFluid(400))
                .outputFluids(FCrackedMediumNaquadah.getFluid(1400))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CRACKING_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(LightNaquadah.getFluid(1000))
                .inputFluids(Fluorine.getFluid(200))
                .outputFluids(FCrackedLightNaquadah.getFluid(1200))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CRACKING_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(HeavyNaquadah.getFluid(1000))
                .inputFluids(Fluorine.getFluid(600))
                .outputFluids(FCrackedHeavyNaquadah.getFluid(1600))
                .EUt(7680)
                .duration(200)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(FCrackedLightNaquadah.getFluid(1200))
                .outputFluids(NaquadahGas.getFluid(350))
                .outputFluids(LightNaquadahFuel.getFluid(400))
                .outputFluids(MediumNaquadahFuel.getFluid(150))
                .outputFluids(HeavyNaquadahFuel.getFluid(50))
                .outputFluids(Fluorine.getFluid(150))
                .EUt(7680)
                .duration(200)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(FCrackedMediumNaquadah.getFluid(1400))
                .outputFluids(NaquadahGas.getFluid(150))
                .outputFluids(LightNaquadahFuel.getFluid(200))
                .outputFluids(MediumNaquadahFuel.getFluid(400))
                .outputFluids(HeavyNaquadahFuel.getFluid(100))
                .outputFluids(Fluorine.getFluid(350))
                .EUt(7680)
                .duration(200)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(FCrackedHeavyNaquadah.getFluid(1600))
                .outputFluids(NaquadahGas.getFluid(50))
                .outputFluids(LightNaquadahFuel.getFluid(100))
                .outputFluids(MediumNaquadahFuel.getFluid(200))
                .outputFluids(HeavyNaquadahFuel.getFluid(400))
                .outputFluids(Fluorine.getFluid(550))
                .EUt(7680)
                .duration(200)
                .save(provider);

        // Cu + O + H2SO4 = [CuSO4 + H2O]
        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, Copper)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(CopperSulfateSolution.getFluid(1000))
                .EUt(480)
                .duration(300)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(CopperSulfateSolution.getFluid(900))
                .inputFluids(NaquadahGas.getFluid(100))
                .inputItems(dust, NaquadahEnriched)
                .outputFluids(ENaquadahSolution.getFluid(1000))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ENaquadahSolution.getFluid(2000))
                .outputItems(dustTiny, PlatinumRawPowder, 3)
                .outputFluids(OsmiumSolution.getFluid(350))
                .chancedOutput(dust, NaquadahEnriched, "1/9", 0)
                .outputFluids(ClearENaquadahLiquid.getFluid(1000))
                .EUt(7680)
                .duration(200)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ClearENaquadahLiquid.getFluid(1000))
                .outputFluids(ComplicatedNaquadahGas.getFluid(60))
                .outputFluids(ComplicatedLightENaquadah.getFluid(180))
                .outputFluids(ComplicatedMediumENaquadah.getFluid(320))
                .outputFluids(ComplicatedHeavyENaquadah.getFluid(440))
                .EUt(7680)
                .duration(500)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ComplicatedHeavyENaquadah.getFluid(2000))
                .outputFluids(HeavyENaquadah.getFluid(1000))
                .chancedOutput(dust, Naquadria, "1/9", 0)
                .outputItems(dustTiny, IridiumChloride, 8)
                .outputFluids(OsmiumSolution.getFluid(350))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ComplicatedLightENaquadah.getFluid(2000))
                .outputFluids(LightENaquadah.getFluid(1000))
                .chancedOutput(dust, Naquadria, "1/9", 0)
                .chancedOutput(dust, IridiumChloride, 8, "1/9", 0)
                .outputFluids(OsmiumSolution.getFluid(350))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(ComplicatedMediumENaquadah.getFluid(2000))
                .outputFluids(MediumENaquadah.getFluid(1000))
                .chancedOutput(dust, Naquadria, "1/9", 0)
                .chancedOutput(dust, IridiumChloride, 8, "1/9", 0)
                .outputFluids(OsmiumSolution.getFluid(350))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CRACKING_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(MediumENaquadah.getFluid(1000))
                .inputFluids(Radon.getFluid(400))
                .outputFluids(RnCrackedMediumENaquadah.getFluid(1400))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CRACKING_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(LightENaquadah.getFluid(1000))
                .inputFluids(Radon.getFluid(200))
                .outputFluids(RnCrackedLightNaquadah.getFluid(1200))
                .EUt(7680)
                .duration(200)
                .save(provider);

        CRACKING_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(HeavyENaquadah.getFluid(1000))
                .inputFluids(Radon.getFluid(600))
                .outputFluids(RnCrackedHeavyENaquadah.getFluid(1600))
                .EUt(7680)
                .duration(200)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(RnCrackedLightNaquadah.getFluid(1200))
                .outputFluids(NaquadahGas.getFluid(350))
                .outputFluids(LightENaquadahFuel.getFluid(400))
                .outputFluids(MediumENaquadahFuel.getFluid(150))
                .outputFluids(HeavyENaquadahFuel.getFluid(50))
                .outputFluids(Radon.getFluid(180))
                .EUt(7680)
                .duration(200)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(RnCrackedMediumENaquadah.getFluid(1400))
                .outputFluids(NaquadahGas.getFluid(150))
                .outputFluids(LightENaquadahFuel.getFluid(200))
                .outputFluids(MediumENaquadahFuel.getFluid(400))
                .outputFluids(HeavyENaquadahFuel.getFluid(100))
                .outputFluids(Radon.getFluid(350))
                .EUt(7680)
                .duration(200)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(RnCrackedHeavyENaquadah.getFluid(1600))
                .outputFluids(NaquadahGas.getFluid(50))
                .outputFluids(LightENaquadahFuel.getFluid(100))
                .outputFluids(MediumENaquadahFuel.getFluid(200))
                .outputFluids(HeavyENaquadahFuel.getFluid(400))
                .outputFluids(Radon.getFluid(570))
                .EUt(7680)
                .duration(200)
                .save(provider);

        LARGE_CENTRIFUGE_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputItems(dust, Naquadria)
                .inputFluids(NitrogenDioxide.getFluid(500))
                .inputFluids(SulfuricAcid.getFluid(500))
                .outputFluids(NaquadriaSolution.getFluid(1000))
                .outputItems(dustTiny, Lutetium)
                .outputItems(dustTiny, GTMaterials.Uranium238)
                .outputItems(dustTiny, NaquadahEnriched)
                .outputItems(dustTiny, GTMaterials.Plutonium239)
                .EUt(7680)
                .duration(100)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(LightNaquadahFuel.getFluid(500))
                .inputFluids(LightENaquadahFuel.getFluid(300))
                .inputFluids(NaquadriaSolution.getFluid(200))
                .inputItems(dust, Rutherfordium)
                .inputFluids(Plutonium244.getFluid(144))
                .outputFluids(HyperFuelI.getFluid(2000))
                .EUt(1920)
                .duration(200)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(MediumNaquadahFuel.getFluid(400))
                .inputFluids(MediumENaquadahFuel.getFluid(350))
                .inputFluids(NaquadriaSolution.getFluid(250))
                .inputItems(dust, Dubnium)
                .inputFluids(Curium250.getFluid(144))
                .outputFluids(HyperFuelII.getFluid(2000))
                .EUt(7680)
                .duration(200)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(HeavyNaquadahFuel.getFluid(300))
                .inputFluids(HeavyENaquadahFuel.getFluid(400))
                .inputFluids(NaquadriaSolution.getFluid(300))
                .inputItems(dust, Adamantium)
                .inputFluids(Fermium258.getFluid(144))
                .outputFluids(HyperFuelIII.getFluid(2000))
                .EUt(30720)
                .duration(200)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("naquadah_chain_" + chainNumber++)
                .inputFluids(HyperFuelIII.getFluid(1000))
                .inputItems(dust, Neutronium)
                .inputItems(dust, Taranium)
                .outputFluids(HyperFuelIV.getFluid(3000))
                .EUt(8000000)
                .duration(1)
                .save(provider);
    }
}

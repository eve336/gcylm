package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class BrineChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        // NH3 + C3H6 + 3O -> 3H2O + C3H3N
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_0").duration(100).EUt(120)
                .notConsumable(dust, Platinum)
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Propene.getFluid(1000))
                .inputFluids(Oxygen.getFluid(3000))
                .outputFluids(Water.getFluid(3000))
                .outputFluids(AcryloNitrile.getFluid(1000))
                .save(provider);

        // S + NaCN -> NaSCN
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_1").duration(100).EUt(120)
                .inputItems(dust, Sulfur)
                .inputFluids(SodiumCyanide.getFluid(1000))
                .outputFluids(SodiumThiocyanate.getFluid(1000))
                .save(provider);

        // NO + C3H3N + NaSCN -> [C3H3N]n(NaSCN) polymerized with Oxygen bond
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_2").duration(160).EUt(30)
                .inputFluids(NitricOxide.getFluid(1000))
                .inputFluids(AcryloNitrile.getFluid(1000))
                .inputFluids(SodiumThiocyanate.getFluid(1000))
                .outputFluids(PolyacrylonitrileSolution.getFluid(1000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("brine_chain_3").duration(240).EUt(7680)
                .inputItems(plate, RhodiumPlatedPalladium, 4)
                .inputItems(CraftingComponent.MOTOR.getIngredient(GTValues.LuV))
                .outputItems(RAPIDLY_ROTATING_CRUCIBLE)
                .save(provider);

        // [C3H3N]n -> NaSCN + (solidified)[C3H3N]n
        BLAST_RECIPES.recipeBuilder("brine_chain_4").duration(180).EUt(120).blastFurnaceTemp(600)
                .notConsumable(RAPIDLY_ROTATING_CRUCIBLE)
                .inputFluids(PolyacrylonitrileSolution.getFluid(1000))
                .outputItems(AcrylicFibers)
                .outputFluids(SodiumThiocyanate.getFluid(1000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("brine_chain_5").duration(60).EUt(24)
                .inputItems(dust,AcrylicFibers)
                .inputItems(wireFine, Gold)
                .outputItems(ACRYLIC_YARN)
                .save(provider);

        // CH2O2 + CH3OH -> H2O + C2H4O2
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_6").duration(120).EUt(120)
                .inputFluids(FormicAcid.getFluid(1000))
                .inputFluids(Methanol.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(MethylFormate.getFluid(1000))
                .save(provider);

        // C2H4O2 + 2NH3 + 2O -> 2CH3NO(H2O)
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_7").duration(90).EUt(120)
                .inputFluids(MethylFormate.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Oxygen.getFluid(2000))
                .outputFluids(WetFormamide.getFluid(1000))
                .save(provider);

        // CH3NO(H2O) -> CH3NO + H2O
        DISTILLATION_RECIPES.recipeBuilder("brine_chain_8").duration(200).EUt(120)
                .inputFluids(WetFormamide.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Formamide.getFluid(1000))
                .save(provider);

        // CH3NO(H2O) -> CH3NO + H2O
        FLUID_HEATER_RECIPES.recipeBuilder("brine_chain_9").duration(60).EUt(30)
                .circuitMeta(0)
                .inputFluids(WetFormamide.getFluid(100))
                .outputFluids(Formamide.getFluid(100))
                .save(provider);

        // NH4NO3 + 2 SO2 + 3 H2O + 2 NH3 = [(NH3OH)2SO4 + (NH4)2SO4]
        LARGE_CHEMICAL_RECIPES.recipeBuilder("brine_chain_10").duration(120).EUt(120)
                .inputFluids(AmmoniumNitrate.getFluid(1000))
                .inputFluids(SulfurDioxide.getFluid(2000))
                .inputFluids(Water.getFluid(3000))
                .inputFluids(Ammonia.getFluid(2000))
                .outputFluids(HydroxylamineDisulfate.getFluid(2000))
                .save(provider);

        // [(NH3OH)2SO4 + (NH4)2SO4] + 2 NH3 -> 2H3NO + 2 (NH4)2SO4
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_11").duration(180).EUt(120)
                .inputFluids(HydroxylamineDisulfate.getFluid(2000))
                .inputFluids(Ammonia.getFluid(2000))
                .outputFluids(Hydroxylamine.getFluid(2000))
                .outputFluids(AmmoniumSulfate.getFluid(2000))
                .save(provider);

        // CH3NO + H3NO -> H3N2O(CH) + H2O
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_12").duration(120).EUt(120)
                .inputFluids(Formamide.getFluid(1000))
                .inputFluids(Hydroxylamine.getFluid(1000))
                .outputFluids(Amidoxime.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("brine_chain_13").duration(40).EUt(480)
                .inputItems(ACRYLIC_YARN)
                .inputFluids(Amidoxime.getFluid(100))
                .outputItems(HEAVY_METAL_ABSORBING_YARN)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_14").duration(100).EUt(120)
                .inputItems(HEAVY_METAL_ABSORBING_YARN)
                .inputFluids(SeaWater.getFluid(16000))
                .outputItems(URANIUM_SATURATED_YARN)
                .outputFluids(SaltWater.getFluid(16000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_15").duration(200).EUt(1920)
                .inputItems(URANIUM_SATURATED_YARN)
                .inputFluids(NitricAcid.getFluid(100))
                .chancedOutput(HEAVY_METAL_ABSORBING_YARN.asStack(), 9900, 0)
                .outputFluids(PureUranylNitrateSolution.getFluid(100))
                .save(provider);

        // ? -> UO2(NO3)2
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_16").duration(120).EUt(30)
                .inputFluids(PureUranylNitrateSolution.getFluid(900))
                .outputItems(UranylNitrate, 11)
                .save(provider);

        // UO2(NO3)2 + H2O -> UO2 + 2HNO3(dil.)
        BLAST_RECIPES.recipeBuilder("brine_chain_16").duration(200).EUt(120).blastFurnaceTemp(500)
                .inputItems(dust,UranylNitrate, 11)
                .inputFluids(Water.getFluid(1000))
                .outputItems(UraniumDioxide, 3)
                .outputFluids(DiluteNitricAcid.getFluid(2000))
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("brine_chain_18").duration(300).EUt(480)
                .inputFluids(DiluteNitricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(NitricAcid.getFluid(1000))
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_19").duration(200).EUt(480)
                .inputFluids(DebrominatedBrine.getFluid(1000))
                .outputFluids(Brine.getFluid(100))
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_20").duration(200).EUt(480)
                .circuitMeta(1)
                .inputFluids(SaltWater.getFluid(1000))
                .outputFluids(Brine.getFluid(100))
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_21").duration(200).EUt(480)
                .inputFluids(SeaWater.getFluid(1000))
                .outputFluids(Brine.getFluid(100))
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_22").duration(160).EUt(480)
                .inputFluids(Brine.getFluid(1000))
                .outputFluids(ConcentratedBrine.getFluid(800))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("brine_chain_23").duration(200).EUt(480)
                .inputFluids(BrominatedBrine.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(AcidicBrominatedBrine.getFluid(1000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_24").duration(200).EUt(480)
                .inputFluids(AcidicBrominatedBrine.getFluid(1000))
                .inputFluids(SulfurDioxide.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(Brine.getFluid(1000))
                .outputFluids(SulfuricBromineSolution.getFluid(1000))
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("brine_chain_25").duration(150).EUt(120)
                .inputFluids(ConcentratedBrine.getFluid(1000))
                .outputFluids(CalciumFreeBrine.getFluid(1000))
                .outputItems(CalciumSalts, 13)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("brine_chain_26").duration(160).EUt(120)
                .inputFluids(CalciumFreeBrine.getFluid(1000))
                .outputFluids(SodiumFreeBrine.getFluid(1000))
                .outputItems(SodiumSalts, 4)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("brine_chain_27").duration(200).EUt(120)
                .inputFluids(SodiumFreeBrine.getFluid(1000))
                .outputFluids(PotassiumFreeBrine.getFluid(1000))
                .outputItems(dust, PotassiumMagnesiumSalts, 30)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_28").duration(150).EUt(480)
                .inputItems(BORON_RETAINING_YARN)
                .inputFluids(PotassiumFreeBrine.getFluid(1000))
                .outputItems(BORON_SATURATED_YARN)
                .outputFluids(BoronFreeSolution.getFluid(1000))
                .save(provider);

        // Na2CO3, CaO
        MIXER_RECIPES.recipeBuilder("brine_chain_29").duration(80).EUt(1920)
                .inputItems(dust, SodaAsh ,6)
                .inputItems(dust, Quicklime, 2)
                .inputFluids(BoronFreeSolution.getFluid(1000))
                .outputItems(CalciumMagnesiumSalts, 16)
                .outputFluids(SodiumLithiumSolution.getFluid(1000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_30").duration(150).EUt(480)
                .inputItems(LITHIUM_SIEVE)
                .inputFluids(SodiumLithiumSolution.getFluid(1000))
                .outputFluids(SaltWater.getFluid(1000))
                .outputItems(LITHIUM_SATURATED_LITHIUM_SIEVE)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_31").duration(320).EUt(480)
                .inputItems(LITHIUM_SATURATED_LITHIUM_SIEVE)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .chancedOutput(LITHIUM_SIEVE.asStack(), 9000, 0)
                .outputFluids(LithiumChlorideSolution.getFluid(1000))
                .save(provider);

        // Al + 3H -> AlH3
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_32").duration(80).EUt(30)
                .inputItems(dust, Aluminium)
                .inputFluids(Hydrogen.getFluid(3000))
                .outputItems(AluminiumHydride, 4)
                .save(provider);

        // NaH + AlH3 -> NaAlH4
        MIXER_RECIPES.recipeBuilder("brine_chain_33").duration(190).EUt(30)
                .inputItems(dust,SodiumHydride, 2)
                .inputItems(dust,AluminiumHydride, 4)
                .outputItems(SodiumAluminiumHydride, 6)
                .save(provider);

        // LiCl + NaAlH4 + H2O -> NaCl(H2O) + LiAlH4
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_34").duration(210).EUt(3000)
                .inputItems(dust,LithiumChloride, 2)
                .inputItems(dust,SodiumAluminiumHydride, 6)
                .inputFluids(Water.getFluid(1000))
                .outputItems(LithiumAluminiumHydride, 6)
                .outputFluids(SaltWater.getFluid(1000))
                .save(provider);

        // C12H22O11 + H2O -> C6H12O6 + C6H12O6
        // Input 2 sugar, 45 is too hard
        CHEMICAL_BATH_RECIPES.recipeBuilder("brine_chain_35").duration(300).EUt(480)
                .inputItems(dust, Sugar, 2)
                .inputFluids(Water.getFluid(1000))
                .outputItems(Glucose, 24)
                .outputItems(Fructose, 24)
                .save(provider);

        // C6H10O5 + bacteria -> C6H12O6
        BIO_REACTOR_RECIPES.recipeBuilder("brine_chain_36").duration(150).EUt(120)
                .inputItems(dust,Cellulose, 21)
                .inputItems(dust,EschericiaColi)
                .outputItems(Glucose, 24)
                .save(provider);

        // Na + NH3 -> H + NaNH2
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_37").duration(110).EUt(120)
                .inputItems(dust, Sodium)
                .inputFluids(Ammonia.getFluid(1000))
                .circuitMeta(0)
                .outputFluids(Hydrogen.getFluid(1000))
                .outputItems(SodiumAzanide, 4)
                .save(provider);

        // NH4NO3 -> N2O + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_38").duration(100).EUt(30)
                .inputFluids(AmmoniumNitrate.getFluid(1000))
                .circuitMeta(1)
                .outputFluids(NitrousOxide.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .save(provider);

        // 2NaNH2 + N2O -> NH3 + NaOH + NaN3
        LARGE_CHEMICAL_RECIPES.recipeBuilder("brine_chain_39").duration(230).EUt(120)
                .inputItems(dust,SodiumAzanide, 8)
                .inputFluids(NitrousOxide.getFluid(1000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputItems(dust, SodiumHydroxide, 3)
                .outputItems(SodiumAzide, 4)
                .save(provider);

        // NaOH + H2O -> NaOH(H2O)
        MIXER_RECIPES.recipeBuilder("brine_chain_40").duration(60).EUt(30)
                .circuitMeta(0)
                .inputItems(dust, SodiumHydroxide, 3)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(SodiumHydroxideSolution.getFluid(1000))
                .save(provider);

        // C6H12O6 + LiAlH4 + NaN3 + H2SO4 + H2O -> LiOH(H2O) + C6H11O5NH2 + AlH3 + NaHSO4 + 2 N
        LARGE_CHEMICAL_RECIPES.recipeBuilder("brine_chain_41").duration(250).EUt(120)
                .inputItems(dust,Glucose, 24)
                .inputItems(dust,LithiumAluminiumHydride, 6)
                .inputItems(dust,SodiumAzide, 4)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(Nitrogen.getFluid(2000))
                .outputFluids(LithiumHydroxideSolution.getFluid(1000))
                .outputItems(dust, Glucosamine, 25)
                .outputItems(AluminiumHydride, 4)
                .outputItems(dust, SodiumBisulfate, 7)
                .save(provider);

        // AlH3 + 3H2O -> Al(OH)3 + 6H
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_42").duration(100).EUt(30)
                .inputItems(dust,AluminiumHydride, 4)
                .inputFluids(Water.getFluid(3000))
                .outputItems(AluminiumHydroxide, 7)
                .outputFluids(Hydrogen.getFluid(6000))
                .save(provider);

        // [C6H11NO4]n + bacteria -> C6H13NO5
        BIO_REACTOR_RECIPES.recipeBuilder("brine_chain_43").duration(100).EUt(4096)
                .inputFluids(Chitosan.getFluid(1000))
                .inputItems(dust,EschericiaColi)
                .outputItems(dust, Glucosamine, 25)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("brine_chain_44").duration(50).EUt(480)
                .inputItems(dust,Glucosamine, 2)
                .inputItems(wireFine, Gold)
                .inputFluids(Polystyrene.getFluid(144))
                .outputItems(BORON_RETAINING_YARN)
                .save(provider);

        // 2NaOH + H2SO4 + HBO2 -> H3BO3 + Na2SO4(H2O)
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_45").duration(170).EUt(480)
                .inputItems(BORON_SATURATED_YARN)
                .inputItems(dust, SodiumHydroxide, 6)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(BoricAcid.getFluid(1000))
                .outputFluids(SodiumSulfateSolution.getFluid(1000))
                .chancedOutput(BORON_RETAINING_YARN.asStack(), 9900, 0)
                .save(provider);

        // 2H3BO3 -> 3H2O + B2O3 (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_46").duration(100).EUt(120)
                .notConsumable(dust, Boron)
                .inputFluids(BoricAcid.getFluid(2000))
                .outputItems(BoronOxide, 5)
                .save(provider);

        // B2O3 -> 2B + 3O
        ELECTROLYZER_RECIPES.recipeBuilder("brine_chain_47").duration(400).EUt(120)
                .inputItems(dust,BoronOxide, 5)
                .outputItems(dust, Boron, 2)
                .outputFluids(Oxygen.getFluid(3000))
                .save(provider);

        // B2O3 + 6HF -> 3H2O + 2BF3
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_48").duration(160).EUt(120)
                .inputItems(dust,BoronOxide, 5)
                .inputFluids(HydrofluoricAcid.getFluid(6000))
                .outputFluids(Water.getFluid(3000))
                .outputFluids(BoronFluoride.getFluid(2000))
                .save(provider);

        // 4BF3 + 3LiAlH4 -> 2B2H6 + 3AlF4Li
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_49").duration(80).EUt(30)
                .inputFluids(BoronFluoride.getFluid(4000))
                .inputItems(dust,LithiumAluminiumHydride, 18)
                .outputFluids(Diborane.getFluid(2000))
                .outputItems(dust, LithiumAluminiumFluoride, 18)
                .save(provider);

        // LiAlF4 -> AlF3 + LiF
        ELECTROLYZER_RECIPES.recipeBuilder("brine_chain_50").duration(250).EUt(120)
                .inputItems(dust,LithiumAluminiumFluoride, 6)
                .outputItems(dust, AluminiumTrifluoride, 4)
                .outputItems(dust, LithiumFluoride, 2)
                .save(provider);

        // 2AlF3 + 3H2O -> Al2O3 + 6HF
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_51").duration(140).EUt(120)
                .inputItems(dust,AluminiumTrifluoride, 8)
                .inputFluids(Water.getFluid(3000))
                .outputItems(dust, Alumina, 5)
                .outputFluids(HydrofluoricAcid.getFluid(6000))
                .save(provider);

        // B2H6 -> 2B + 6H (H lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_52").duration(60).EUt(480)
                .notConsumable(dust, Boron)
                .inputFluids(Diborane.getFluid(1000))
                .outputItems(dust, Boron, 2)
                .save(provider);

        // Na + H -> NaH
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_53").duration(140).EUt(30)
                .inputItems(dust, Sodium)
                .inputFluids(Hydrogen.getFluid(1000))
                .outputItems(SodiumHydride, 2)
                .save(provider);

        // C + 2S -> CS2
        BLAST_RECIPES.recipeBuilder("brine_chain_54").duration(120).EUt(120).blastFurnaceTemp(1000)
                .inputItems(dust, Carbon)
                .inputItems(dust, Sulfur, 2)
                .outputFluids(CarbonSulfide.getFluid(1000))
                .outputItems(dustTiny, Ash)
                .save(provider);

        // 3C + 2HCl + 2CH3NH2 + CS2 -> 2C3H6ClNS
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_55").duration(200).EUt(480)
                .inputItems(dust, Carbon, 3)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputFluids(Methylamine.getFluid(2000))
                .inputFluids(CarbonSulfide.getFluid(1000))
                .outputFluids(DimethylthiocarbamoilChloride.getFluid(2000))
                .outputFluids(Oxygen.getFluid(6000))
                .save(provider);

        // C6H6O2 + (CH3)2NCClS  + LiAlH4 -> C6H6OS + (CH3)2NCHO + LiCl + AlH3
        LARGE_CHEMICAL_RECIPES.recipeBuilder("brine_chain_56").duration(180).EUt(500)
                .notConsumable(dust, Palladium)
                .notConsumable(dust, SodiumHydride)
                .notConsumableFluid(Dimethylformamide.getFluid(500))
                .inputFluids(Resorcinol.getFluid(1000))
                .inputFluids(DimethylthiocarbamoilChloride.getFluid(1000))
                .inputItems(dust,LithiumAluminiumHydride, 6)
                .outputFluids(Mercaptophenol.getFluid(1000))
                .outputFluids(Dimethylformamide.getFluid(1000))
                .outputItems(LithiumChloride, 2)
                .outputItems(AluminiumHydride, 4)
                .save(provider);

        CRACKING_RECIPES.recipeBuilder("brine_chain_57").duration(40).EUt(120)
                .inputFluids(Hydrogen.getFluid(250))
                .inputFluids(Dimethylformamide.getFluid(750))
                .outputFluids(Formaldehyde.getFluid(120))
                .outputFluids(Dimethylamine.getFluid(160))
                .save(provider);

        // CH3OH + NH3 -> CH3OH(NH3)
        MIXER_RECIPES.recipeBuilder("brine_chain_58").duration(160).EUt(960)
                .notConsumable(dust, Nickel)
                .inputFluids(Methanol.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputFluids(AmineMixture.getFluid(2000))
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("brine_chain_59").duration(200).EUt(480)
                .inputFluids(AmineMixture.getFluid(2000))
                .outputFluids(Trimethylamine.getFluid(500))
                .outputFluids(Dimethylamine.getFluid(800))
                .outputFluids(Methylamine.getFluid(700))
                .save(provider);

        //(CH3)2NH + HCOOCH3 -> (CH3)2NCHO + CH3OH
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_60").duration(100).EUt(120)
                .inputFluids(Dimethylamine.getFluid(1000))
                .inputFluids(MethylFormate.getFluid(1000))
                .outputFluids(Dimethylformamide.getFluid(1000))
                .outputFluids(Methanol.getFluid(1000))
                .save(provider);

        // MoO3 + 2NaOH -> Na2MoO4 + H2O
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_61").duration(80).EUt(30)
                .inputItems(dust,MolybdenumTrioxide, 4)
                .inputItems(dust, SodiumHydroxide, 6)
                .outputItems(SodiumMolybdate, 7)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // 12Na2MoO4 + H3PO4 -> Mo12Na3O40P + 10 Na2O + H2O + NaOH (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_62").duration(180).EUt(1920)
                .inputItems(dust,SodiumMolybdate, 84)
                .inputFluids(PhosphoricAcid.getFluid(1000))
                .outputItems(dust, SodiumPhosphomolybdate, 56)
                .outputItems(dust, SodiumHydroxide, 3)
                .outputItems(dust, SodiumOxide, 30)
                .save(provider);

        // 12Na2WO4 + H3PO4 -> Na3O40PW12 + 10 Na2O + H2O + NaOH (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_63").duration(180).EUt(1920)
                .inputFluids(SodiumTungstate.getFluid(12000))
                .inputFluids(PhosphoricAcid.getFluid(1000))
                .outputItems(dust, SodiumPhosphotungstate, 56)
                .outputItems(dust, SodiumHydroxide, 3)
                .outputItems(dust, SodiumOxide, 30)
                .save(provider);

        // C3H6 + H2O -> C3H8O
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_64").duration(160).EUt(480)
                .inputFluids(Propene.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(IsopropylAlcohol.getFluid(1000))
                .notConsumable(dust, SodiumPhosphomolybdate)
                .notConsumable(dust, SodiumPhosphotungstate)
                .save(provider);

        //2 IrCl3 + 2 C8H12 -> (C8H12)2Ir2Cl2 + 4 Cl
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_65").duration(100).EUt(120)
                .inputItems(dust, IridiumChloride, 8)
                .inputFluids(Cyclooctadiene.getFluid(2000))
                .outputItems(IridiumCyclooctadienylChlorideDimer, 44)
                .outputFluids(Chlorine.getFluid(4000))
                .save(provider);

        //4 Li + PCl3 + 2 C3H8O + 2 H2O -> 2 LiCl + 2 [LiOH + H2O] + P(C3H7)2Cl
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_66").duration(140).EUt(500)
                .inputItems(dust, Lithium, 4)
                .inputFluids(Water.getFluid(2000))
                .inputFluids(PhosphorusTrichloride.getFluid(1000))
                .inputFluids(IsopropylAlcohol.getFluid(2000))
                .outputItems(LithiumChloride, 4)
                .outputFluids(LithiumHydroxideSolution.getFluid(2000))
                .outputFluids(ChlorodiisopropylPhosphine.getFluid(1000))
                .save(provider);

        //4 P(C3H7)2Cl + (C8H12)2Ir2Cl2 + 2 C6H6OS -> 2 IrP2C18H32SOCl + 2 C8H12 + 4 HCl (divided by 2)
        LARGE_CHEMICAL_RECIPES.recipeBuilder("brine_chain_67").duration(200).EUt(1200)
                .inputItems(dust,IridiumCyclooctadienylChlorideDimer, 22)
                .inputFluids(ChlorodiisopropylPhosphine.getFluid(2000))
                .inputFluids(Mercaptophenol.getFluid(1000))
                .notConsumable(dust, BerylliumFluoride)
                .outputItems(dust, DehydrogenationCatalyst, 56)
                .outputFluids(Cyclooctadiene.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // C4H8 + C8H18 -> C4H10 + C8H16
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_68").duration(190).EUt(120)
                .notConsumable(dust, DehydrogenationCatalyst)
                .inputFluids(Butene.getFluid(1000))
                .inputFluids(Octane.getFluid(1000))
                .outputFluids(Butane.getFluid(1000))
                .outputFluids(Oct1ene.getFluid(1000))
                .save(provider);

        // N(CH3)3 + Br + C8H18 + C8H16 -> C19H42BrN + H
        LARGE_CHEMICAL_RECIPES.recipeBuilder("brine_chain_69").duration(300).EUt(480)
                .inputFluids(Trimethylamine.getFluid(1000))
                .inputFluids(Bromine.getFluid(1000))
                .inputFluids(Octane.getFluid(1000))
                .inputFluids(Oct1ene.getFluid(1000))
                .outputFluids(CetaneTrimethylAmmoniumBromide.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(1000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_70").duration(180).EUt(480)
                .inputFluids(Styrene.getFluid(1000))
                .notConsumableFluid(AmmoniumPersulfate.getFluid(0))
                .inputFluids(CetaneTrimethylAmmoniumBromide.getFluid(20))
                .outputItems(PolystyreneNanoParticles)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("brine_chain_71").duration(300).EUt(480)
                .inputItems(dust, LithiumTitanate, 2)
                .inputItems(dust,PolystyreneNanoParticles, 2)
                .outputItems(LITHIUM_SIEVE)
                .outputFluids(Styrene.getFluid(2000))
                .save(provider);

        // CaCO3, CaSO4(H2O)2
        CENTRIFUGE_RECIPES.recipeBuilder("brine_chain_72").duration(200).EUt(120)
                .inputItems(dust,CalciumSalts, 13)
                .outputItems(dust, Calcite, 5)
                .outputItems(dust, Gypsum, 8)
                .save(provider);

        // NaCl, NaF
        CENTRIFUGE_RECIPES.recipeBuilder("brine_chain_73").duration(200).EUt(120)
                .inputItems(dust,SodiumSalts, 2)
                .outputItems(dust, Salt, 2)
                .chancedOutput(ChemicalHelper.get(dustTiny, SodiumFluoride, 2), 400, 0)
                .save(provider);

        // KCl, MgSO4, K2SO4
        CENTRIFUGE_RECIPES.recipeBuilder("brine_chain_74").duration(200).EUt(120)
                .inputItems(dust,PotassiumMagnesiumSalts, 15)
                .outputItems(dust, RockSalt, 2)
                .outputItems(dust, MagnesiumSulfate, 6)
                .outputItems(PotassiumSulfate, 7)
                .chancedOutput(ChemicalHelper.get(dustTiny, PotassiumFluoride, 2), 400, 0)
                .save(provider);

        // CaCO3, CO2, MgO
        CENTRIFUGE_RECIPES.recipeBuilder("brine_chain_75").duration(200).EUt(120)
                .inputItems(dust,CalciumMagnesiumSalts, 8)
                .outputItems(dust, Calcite, 5)
                .chancedOutput(dust, StrontiumCarbonate, 5, 40, 0)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(dust, Magnesia, 2)
                .save(provider);

        // MgSO4 -> Mg + S + 4O
        ELECTROLYZER_RECIPES.recipeBuilder("brine_chain_76").duration(180).EUt(120)
                .inputItems(dust,MagnesiumSulfate, 6)
                .outputItems(dust, Magnesium)
                .outputItems(dust, Sulfur)
                .outputFluids(Oxygen.getFluid(4000))
                .save(provider);

        // MgO + 2HCl -> 2H2O + MgCl2
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_77").duration(230).EUt(120)
                .inputItems(dust, Magnesia, 2)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputItems(dust, MagnesiumChloride, 3)
                .save(provider);

        // SrSO4 + Na2CO3 + 2C -> SrCO3 + 2CO2 + Na2S
        BLAST_RECIPES.recipeBuilder("brine_chain_78").duration(360).EUt(120).blastFurnaceTemp(1200)
                .inputItems(dust, Celestine, 6)
                .inputItems(dust, SodaAsh, 6)
                .inputItems(dust, Carbon, 2)
                .outputItems(StrontiumCarbonate, 5)
                .outputFluids(CarbonDioxide.getFluid(2000))
                .outputItems(dust, SodiumSulfide, 3)
                .save(provider);

        // SrCO3 -> SrO + CO2
        CHEMICAL_RECIPES.recipeBuilder("brine_chain_79").duration(100).EUt(120)
                .inputItems(dust,StrontiumCarbonate, 5)
                .outputItems(StrontiumOxide, 2)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // SrO -> Sr + O
        ELECTROLYZER_RECIPES.recipeBuilder("brine_chain_80").duration(300).EUt(120)
                .inputItems(dust,StrontiumOxide, 2)
                .outputItems(dust, Strontium)
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("brine_chain_81").duration(260).EUt(120)
                .inputFluids(Brine.getFluid(6400))
                .outputFluids(ChilledBrine.getFluid(3000))
                .save(provider);

        // CaCO3, CaSO4(H2O)2, NaCl, KCl
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_82").duration(190).EUt(480)
                .inputFluids(ChilledBrine.getFluid(2000))
                .outputFluids(MagnesiumContainingBrine.getFluid(1000))
                .outputItems(dust, Calcite, 5)
                .outputItems(dust, Gypsum, 8)
                .outputItems(dust, Salt, 2)
                .outputItems(dust, RockSalt, 2)
                .save(provider);

        // MgCl2, MgSO4
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("brine_chain_83").duration(270).EUt(480)
                .inputFluids(MagnesiumContainingBrine.getFluid(1000))
                .outputItems(dust, MagnesiumChloride, 3)
                .outputItems(dust, MagnesiumSulfate, 6)
                .outputFluids(LithiumChlorideSolution.getFluid(200))
                .save(provider);
    }
}

package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVBlocks.LEPTONIC_CHARGE;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class CosmicChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;
        STELLAR_FORGE_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(60).EUt(14000000)
                .inputItems(LEPTONIC_CHARGE.asItem())
                .inputItems(DEGENERATE_RHENIUM_DUST)
                .outputFluids(QuarkGluonPlasma.getFluid(4000))
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(60).EUt(14000000)
                .inputItems(LEPTONIC_CHARGE.asItem())
                .inputItems(DEGENERATE_RHENIUM_PLATE)
                .outputFluids(QuarkGluonPlasma.getFluid(2000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(600).EUt(122880)
                .inputItems(wireFine, YttriumBariumCuprate, 64)
                .inputItems(wireFine, NiobiumTitanium, 64)
                .inputItems(plate, NiobiumNitride, 8)
                .inputItems(foil, Polybenzimidazole, 16)
                .inputItems(rodLong, VanadiumGallium)
                .outputItems(SEPARATION_ELECTROMAGNET)
                .save(provider);

        LARGE_CENTRIFUGE_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(200).EUt(1200000)
                .inputFluids(QuarkGluonPlasma.getFluid(1000))
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .outputFluids(HeavyQuarks.getFluid(750))
                .outputFluids(Gluons.getFluid(500))
                .outputFluids(LightQuarks.getFluid(250))
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(100).EUt(2400000)
                .inputFluids(HeavyLeptonMix.getFluid(1000))
                .inputFluids(HeavyQuarks.getFluid(1000))
                .inputFluids(Gluons.getFluid(1000))
                .outputFluids(CosmicComputingMix.getFluid(3000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(100).EUt(3250000)
                .inputFluids(HeavyQuarks.getFluid(750))
                .inputFluids(LightQuarks.getFluid(250))
                .outputFluids(HeavyQuarkEnrichedMix.getFluid(1000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(130).EUt(450000)
                .inputFluids(Titanium50.getFluid(144))
                .inputFluids(Scandium.getFluid(144))
                .outputFluids(ScandiumTitanium50Mix.getFluid(288))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(130).EUt(450000)
                .inputFluids(Radon.getFluid(1000))
                .inputFluids(Radium.getFluid(144))
                .outputFluids(RadonRadiumMix.getFluid(288))
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(140).EUt(4500000)
                .inputFluids(Deuterium.getFluid(2000))
                .inputFluids(MetastableHassium.getFluid(144))
                .inputFluids(MetastableFlerovium.getFluid(144))
                .inputFluids(MetastableOganesson.getFluid(144))
                .outputFluids(DeuteriumSuperheavyMix.getFluid(2592))
                .save(provider);

        ADV_FUSION_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(100).EUt(1100000)
                // TODO adv fusion
//                .coilTier(3)
                // Add data for coil tier
//                .addData("coilTier", 3)
                .fusionStartEU(5000000000L)
                .inputFluids(DeuteriumSuperheavyMix.getFluid(144))
                .inputFluids(HeavyQuarkEnrichedMix.getFluid(144))
                .outputFluids(HeavyQuarkDegenerateMatter.getFluid(144))
                .save(provider);

        // 3HCl + Fl -> FlCl3 + 3H
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(150).EUt(7680)
                .inputFluids(HydrochloricAcid.getFluid(3000))
                .inputItems(dust, MetastableFlerovium)
                .outputFluids(Trichloroferane.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(3000))
                .save(provider);

        // C6H5F + 2Na -> C6H5Na + NaF
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(210).EUt(480)
                .inputFluids(FluoroBenzene.getFluid(1000))
                .inputItems(dust, Sodium, 2)
                .outputFluids(Phenylsodium.getFluid(1000))
                .outputItems(dust, SodiumFluoride, 2)
                .save(provider);

        // LiAlH4 + C4H6O4 -> C4H6O2 + Li + Al + 2H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(180).EUt(15360)
                .inputItems(LithiumAluminiumHydride,4)
                .inputItems(SuccinicAcid,14)
                .outputFluids(Succinaldehyde.getFluid(1000))
                .outputItems(dust, Lithium)
                .outputItems(dust, Aluminium)
                .outputFluids(Water.getFluid(2000))
                .save(provider);

        // 2KF + H + C6H4Cl2 + N -> 2KCl + C6H5F2N
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(160).EUt(480)
                .inputItems(dust, PotassiumFluoride, 4)
                .inputFluids(Hydrogen.getFluid(1000))
                .inputFluids(Dichlorobenzene.getFluid(1000))
                .inputFluids(Nitrogen.getFluid(1000))
                .notConsumable(dust, AluminiumChloride)
                .outputItems(dust, RockSalt, 4)
                .outputFluids(Difluoroaniline.getFluid(1000))
                .save(provider);

        // C6H5F2N + C4H6O2 -> C10H7F2N + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(180).EUt(480)
                .inputFluids(Difluoroaniline.getFluid(1000))
                .inputFluids(Succinaldehyde.getFluid(1000))
                .notConsumable(dust, PhosphorusPentoxide)
                .outputFluids(NDifluorophenylpyrrole.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .save(provider);

        // 6 H2O + 2 HCl + 2 AgBF4 + 8 C6H5Na + 2C8H20NBr + 2 AgClO4 + 3 (C5H5)2Cl2Ti + 6 C10H7F2N -> 4AgCl + 2NaBr + 6H2ONaCl + [3 (C5H5)2(C10H6F2N)2Ti + 2 (C6H5)4NBF4 + 8 C2H5OH]
        CHEMICAL_PLANT_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(350).EUt(30720)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputFluids(Silvertetrafluoroborate.getFluid(2000))
                .inputFluids(Phenylsodium.getFluid(8000))
                .inputFluids(TetraethylammoniumBromide.getFluid(2000))
                .inputItems(SilverPerchlorate,12)
                .inputItems(TitaniumCyclopentadienyl,69)
                .inputItems(dust, Ice, 42)
                .inputFluids(NDifluorophenylpyrrole.getFluid(6000))
                .outputItems(dust, SilverChloride, 8)
                .outputItems(SodiumBromide,4)
                .outputFluids(SaltWater.getFluid(6000))
                .outputFluids(PhotopolymerSolution.getFluid(8000))
                .save(provider);

        // 3NaClO -> 2NaCl + NaClO3
        ELECTROLYZER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(210).EUt(120)
                .inputItems(SodiumHypochlorite,9)
                .outputItems(dust, Salt, 4)
                .outputItems(SodiumChlorate,5)
                .save(provider);

        // NaClO3 + H2O2 -> NaClO4 + H2O
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(200).EUt(120)
                .inputItems(SodiumChlorate,5)
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputItems(SodiumPerchlorate,6)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // Ag2O + 2NaClO4 + HCl -> 2AgClO4 + Na2O + dil.HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(350).EUt(480)
                .inputItems(dust, SilverOxide, 3)
                .inputItems(SodiumPerchlorate,12)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputItems(SilverPerchlorate,12)
                .outputItems(SodiumOxide,3)
                .outputFluids(DilutedHydrochloricAcid.getFluid(1000))
                .save(provider);

        // 2AgCl + H2O -> Ag2O + 2HCl
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(100)
                .inputItems(dust, SilverChloride, 4)
                .notConsumable(dust, SodiumHydroxide)
                .inputFluids(Water.getFluid(1000))
                .outputItems(dust, SilverOxide, 3)
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // Ag2O + C -> 2Ag + CO
        BLAST_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(80).EUt(120).blastFurnaceTemp(1200)
                .inputItems(dust, SilverOxide, 3)
                .inputItems(dust, Carbon)
                .outputItems(ingot, Silver, 2)
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .save(provider);

        // Ge + 2S -> GeS2
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(340).EUt(120)
                .inputItems(dust, Germanium)
                .inputItems(dust, Sulfur, 2)
                .outputItems(GermaniumSulfide,3)
                .save(provider);

        // GeS2 + 6O -> GeO2 + 2SO2
        BLAST_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(240).EUt(120).blastFurnaceTemp(2500)
                .inputItems(GermaniumSulfide,3)
                .inputFluids(Oxygen.getFluid(6000))
                .outputItems(GermaniumOxide,3)
                .outputFluids(SulfurDioxide.getFluid(2000))
                .save(provider);

        // WC + 4O -> WO3 + CO
        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(400).EUt(480)
                .inputItems(dust, TungstenCarbide, 2)
                .inputFluids(Oxygen.getFluid(4000))
                .outputItems(dust, TungstenTrioxide, 4)
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .save(provider);

        // CdS + WO3 + 3O -> CdWO4 + SO2
        BLAST_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(320).EUt(120).blastFurnaceTemp(2800)
                .inputItems(CadmiumSulfide,2)
                .inputItems(dust, TungstenTrioxide, 4)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(CadmiumTungstate,6)
                .outputFluids(SulfurDioxide.getFluid(1000))
                .save(provider);

        // CsI + Tm + Tl -> CsITmTl
        BLAST_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(260).EUt(120).blastFurnaceTemp(2853)
                .inputItems(CesiumIodide)
                .inputItems(dustSmall, Thulium, 2)
                .inputItems(dustSmall, Thallium, 2)
                .outputItems(TlTmCesiumIodide,2)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(240).EUt(7680)
                .inputFluids(Anthracene.getFluid(1000))
                .inputItems(Tetracene,2)
                .outputItems(PolycyclicAromaticMix,3)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(340).EUt(120)
                .inputItems(dust, Caesium)
                .inputItems(dust, Iodine)
                .outputItems(CesiumIodide,2)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("cosmic_chain_" + chainNumber++).duration(80).EUt(500000)
                .inputFluids(BismuthNitrateSolution.getFluid(4000))
                .inputItems(GermaniumOxide,3)
                .notConsumable(LOW_FREQUENCY_LASER)
                .outputItems(BismuthGermanate,33)
                .outputItems(dust, Potash, 18)
                .outputFluids(NitrogenDioxide.getFluid(12000))
                .outputFluids(Water.getFluid(4000))
                .save(provider);
    }
}

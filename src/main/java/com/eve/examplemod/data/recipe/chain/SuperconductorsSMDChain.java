package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials.Color.Magenta;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import com.eve.examplemod.common.data.EVMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.api.data.tag.EVTagPrefix.*;
import static com.eve.examplemod.common.data.EVBlocks.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GCYMRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;


public class SuperconductorsSMDChain {
    static int chainNumber = 1;
    public static void init(Consumer<FinishedRecipe> provider) {
        // Cu + In + Ga -> CuGaIn
        MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(120)
                .inputItems(dust, Copper)
                .inputItems(dust, Indium)
                .inputItems(dust, Gallium)
                .outputItems(CopperGalliumIndiumMix,3)
                .save(provider);

        // 2H + Se -> H2Se
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(180).EUt(120)
                .inputFluids(Hydrogen.getFluid(2000))
                .inputItems(dust, Selenium)
                .outputFluids(HydroselenicAcid.getFluid(1000))
                .save(provider);

        // 2H2Se + CuInGa -> CuInGaSe2 + 4 H
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(180).EUt(480)
                .inputFluids(HydroselenicAcid.getFluid(2000))
                .inputItems(CopperGalliumIndiumMix,3)
                .outputItems(CopperGalliumIndiumSelenide,5)
                .outputFluids(Hydrogen.getFluid(4000))
                .save(provider);

        // MnO2 + 2KOH + O -> K2MnO4 + H2O
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(170).EUt(30)
                .inputItems(dust, Pyrolusite, 3)
                .inputFluids(PotassiumHydroxide.getFluid(2000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(PotassiumManganate,7)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // La2O3 + 2CaO + 2K2MnO4 -> 2LaCaMnO3 + 2K2O + 5O
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(380).EUt(120).blastFurnaceTemp(900)
                .inputItems(LanthanumOxide,5)
                .inputItems(dust, Quicklime, 4)
                .inputItems(PotassiumManganate,14)
                .outputItems(LanthanumCalciumManganate,12)
                .outputItems(dust, Potash, 6)
                .outputFluids(Oxygen.getFluid(5000))
                .save(provider);

        // Fe + Pt -> FePt
        MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(230).EUt(240)
                .inputItems(dust, Iron)
                .inputItems(dust, Platinum)
                .outputItems(IronPlatinumCatalyst,2)
                .save(provider);

        // C6H5OH + HNO3 + 6H -> 3H2O + C6H7NO
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(120)
                .inputFluids(Phenol.getFluid(1000))
                .inputFluids(NitricAcid.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(6000))
                .notConsumable(dust, IronPlatinumCatalyst)
                .outputFluids(Water.getFluid(3000))
                .outputFluids(AminoPhenol.getFluid(1000))
                .save(provider);

        // C6H7NO + C3H8O3 + O -> C9H7NO + 4H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(480)
                .inputFluids(AminoPhenol.getFluid(1000))
                .inputFluids(Glycerol.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .notConsumableFluid(NitroBenzene.getFluid(1))
                .outputFluids(Hydroxyquinoline.getFluid(1000))
                .outputFluids(Water.getFluid(4000))
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(350).EUt(1920)
                .inputFluids(Hydroxyquinoline.getFluid(1000))
                .inputItems(dust, Aluminium)
                .outputItems(AluminiumComplex,19)
                .save(provider);

        // Na2O4Ru + 2H -> RuO2 + 2NaOH
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(270).EUt(120).blastFurnaceTemp(1250)
                .inputItems(dust, SodiumRuthenate, 7)
                .inputFluids(Hydrogen.getFluid(2000))
                .outputItems(dust, RutheniumDioxide, 3)
                .outputItems(dust, SodiumHydroxide, 6)
                .save(provider);

        // Bi + 6HNO3 -> [Bi(NO3)3 + H2O] + 3NO2 + 2H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(350).EUt(30)
                .inputItems(dust, Bismuth)
                .inputFluids(NitricAcid.getFluid(6000))
                .outputFluids(BismuthNitrateSolution.getFluid(1000))
                .outputFluids(NitrogenDioxide.getFluid(3000))
                .outputFluids(Water.getFluid(2000))
                .save(provider);

        // 2Na2O4Ru + 2[Bi(NO3)3 + H2O] -> Bi2Ru2O7 + 4NaNO3 + N2H4 + 9O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(480)
                .inputItems(dust, SodiumRuthenate, 14)
                .inputFluids(BismuthNitrateSolution.getFluid(2000))
                .outputFluids(Hydrazine.getFluid(1000))
                .outputFluids(Oxygen.getFluid(9000))
                .outputItems(dust, BismuthRuthenate, 11)
                .outputItems(dust, SodiumNitrate, 20)
                .save(provider);

        // NaNO3 -> Na + N + 3O
        ELECTROLYZER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(270).EUt(30)
                .inputItems(dust, SodiumNitrate, 5)
                .outputItems(dust, Sodium)
                .outputFluids(Nitrogen.getFluid(1000))
                .outputFluids(Oxygen.getFluid(3000))
                .save(provider);

        // 2IrO2 + 2[Bi(NO3)3 + H2O] + H -> Bi2Ir2O7 + 5HNO2 + NO2
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(300).EUt(1920)
                .inputItems(dust, IridiumDioxide,6)
                .inputFluids(BismuthNitrateSolution.getFluid(2000))
                .inputFluids(Hydrogen.getFluid(1000))
                .outputItems(dust, BismuthIridiate, 11)
                .outputFluids(NitricAcid.getFluid(5000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .save(provider);

        // BaCl3 + H2O -> [BaCl3 + H2O]
        MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(230).EUt(120)
                .inputItems(BariumChloride,3)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(BariumChlorideSolution.getFluid(1000))
                .save(provider);

        // TiCl4 + [NaOH + H2O] + [BaCl2 + H2O] -> BaTiO3 + NaCl + 5HCl
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(120)
                .inputFluids(TitaniumTetrachloride.getFluid(1000))
                .inputFluids(SodiumHydroxideSolution.getFluid(1000))
                .inputFluids(BariumChlorideSolution.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputFluids(BariumTitanatePreparation.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(4000))
                .save(provider);

        // 0.1Prep -> 0.2Titanate, 2:1 ratio
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(58).EUt(1920)
                .inputFluids(BariumTitanatePreparation.getFluid(100))
                .outputItems(dust, BariumTitanate)
                .save(provider);

        // H2S + C4H6O4 + 4Br -> C4Br4S + 4H2O
        CHEMICAL_PLANT_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(230).EUt(4960)
                .inputItems(SuccinicAcid,14)
                .inputFluids(HydrogenSulfide.getFluid(1000))
                .inputFluids(Bromine.getFluid(4000))
                .outputFluids(Perbromothiophene.getFluid(1000))
                .outputFluids(Water.getFluid(4000))
                .save(provider);

        // 2 C4Br4S + 4 C2H5ONa + C2H4O2 + 2H2O -> 2 C8H12O2S + 4 NaBr + 4 HBr + 2 CO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(80).EUt(480)
                .notConsumable(dust, Zinc)
                .inputFluids(Perbromothiophene.getFluid(1000))
                .inputFluids(AceticAcid.getFluid(500))
                .inputItems(SodiumEthoxide,18)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(Diethoxythiophene.getFluid(1000))
                .outputFluids(HydrobromicAcid.getFluid(2000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(SodiumBromide,8)
                .save(provider);

        // C2H6O2 + C6H8S -> C6H6O2S + 2CH4
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(140).EUt(120)
                .notConsumable(GELLED_TOLUENE)
                .inputFluids(EthyleneGlycol.getFluid(1000))
                .inputFluids(Diethoxythiophene.getFluid(1000))
                .outputFluids(EDOT.getFluid(1000))
                .outputFluids(Ethanol.getFluid(2000))
                .save(provider);

        // (C8H8)n + H2SO4 + C6H6O2S (aka: EDOT) -> PEDOT + Dilute H2SO4
        CHEMICAL_PLANT_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(1920)
                .inputFluids(Polystyrene.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .inputFluids(EDOT.getFluid(1000))
                .notConsumableFluid(SodiumPersulfate.getFluid(0))
                .notConsumable(dust, IronSulfateDust)
                .outputFluids(DilutedSulfuricAcid.getFluid(1000))
                .outputItems(dust, PEDOT, 3)
                .save(provider);

        // Fe + H2SO4 -> FeSO4 + 2H
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(250).EUt(30)
                .inputItems(dust, Iron)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(IronSulfateDust,6)
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);

        // ZrCl4 + 2H2O -> ZrOCl2 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(ZirconiumTetrachloride,5)
                .inputFluids(Water.getFluid(2000))
                .outputItems(ZirconylChloride,4)
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // Pb + N2O4 + 2O -> Pb(NO3)2
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).EUt(120).duration(150)
                .inputItems(dust, Lead)
                .inputFluids(DinitrogenTetroxide.getFluid(1000))
                .inputFluids(Oxygen.getFluid(2000))
                .outputItems(dust, LeadNitrate, 9)
                .save(provider);

        // ZrOCl2 + TiO2 + Pb(NO3)2 + 2H -> PbZrTiO3 + 2HNO3 + 2Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(480)
                .inputItems(ZirconylChloride,4)
                .inputItems(dust, Rutile, 3)
                .inputItems(dust, LeadNitrate, 9)
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(NitricAcid.getFluid(2000))
                .outputFluids(Chlorine.getFluid(2000))
                .outputItems(dust, LeadZirconateTitanate, 6)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(430).EUt(30720)
                .inputItems(gemExquisite, LeadZirconateTitanate, 2)
                .inputItems(wireFine, Gold)
                .inputFluids(SolderingAlloy.getFluid(288))
                .outputItems(PIEZOELECTRIC_CRYSTAL)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(500).EUt(120).blastFurnaceTemp(2400)
                .inputItems(dust, Tungsten, 9)
                .inputItems(oxide, Thorium)
                .outputItems(ingot, ThoriumDopedTungsten, 10)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(270).EUt(120).blastFurnaceTemp(1800)
                .inputItems(dust, Quartzite)
                .inputItems(Alumina,5)
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .outputItems(ALUMINO_SILICATE_GLASS_TUBE)
                .save(provider);

        ALLOY_BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                .inputItems(dust, SiliconDioxide, 3)
                .inputItems(BariumOxide,2)
                .inputItems(dust, Garnierite, 2)
                .inputItems(dust, SodaAsh, 6)
                .outputFluids(WoodsGlass.getFluid(1296))
                .blastFurnaceTemp(1400)
                .save(provider);

        // Fe + 2I -> FeI2
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Iron)
                .inputItems(dust, Iodine, 2)
                .outputItems(IronIodide,3)
                .save(provider);

        // Tl + I -> TlI
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Thallium)
                .inputItems(dust, Iodine)
                .outputItems(ThalliumIodide,2)
                .save(provider);

        // Rb + I -> RbI
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Rubidium)
                .inputItems(dust, Iodine)
                .outputItems(RubidiumIodide,2)
                .save(provider);

        // K + I -> KI
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Potassium)
                .inputItems(dust, Iodine)
                .outputItems(PotassiumIodide,2)
                .save(provider);

        // In + 3I -> InI3
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Indium)
                .inputItems(dust, Iodine, 3)
                .outputItems(IndiumIodide,4)
                .save(provider);

        // Ga + 3I -> GaI3
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Gallium)
                .inputItems(dust, Iodine, 3)
                .outputItems(GalliumIodide,4)
                .save(provider);

        // Sc + 3I -> ScI3
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Scandium)
                .inputItems(dust, Iodine, 3)
                .outputItems(ScandiumIodide,4)
                .save(provider);

        // FeI2 + 5CO -> 2I + Fe(CO)5 (all x5)
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(480)
                .inputItems(IronIodide,15)
                .inputFluids(CarbonMonoxide.getFluid(25000))
                .notConsumable(block, Copper)
                .outputItems(dust, Iodine, 10)
                .outputItems(dustSmall, Iron, 2)
                .outputFluids(IronCarbonyl.getFluid(5000))
                .save(provider);

        FLUID_HEATER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(200).EUt(480)
                .circuitMeta(1)
                .inputFluids(IronCarbonyl.getFluid(1000))
                .outputFluids(PurifiedIronCarbonyl.getFluid(900))
                .save(provider);

        ELECTROLYZER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(340).EUt(480)
                .inputFluids(PurifiedIronCarbonyl.getFluid(1000))
                .outputItems(CarbonylPurifiedIron)
                .outputFluids(CarbonMonoxide.getFluid(5000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                // TODO small coil
//                .inputItems(SMALL_COIL,4)
                .inputItems(CarbonylPurifiedIron)
                .inputItems(wireFine, AnnealedCopper, 2)
                .inputFluids(SolderingAlloy.getFluid(144))
                .outputItems(INDUCTOR)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                .inputItems(RESISTOR)
                .inputItems(INDUCTOR)
                .inputItems(wireFine, Cupronickel, 2)
                .outputItems(BALLAST)
                .save(provider);

        // 2V + 5Na2CO3 + 4H2O -> 5CO + 2NaVO3 + 8NaOH
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(180).EUt(120).blastFurnaceTemp(650)
                .inputItems(dust, Vanadium, 2)
                .inputItems(dust, SodaAsh, 30)
                .inputFluids(Water.getFluid(4000))
                .outputFluids(CarbonMonoxide.getFluid(5000))
                .outputItems(SodiumMetavanadate,10)
                .outputItems(dust, SodiumHydroxide, 24)
                .save(provider);

        // Y2O3 + Eu2O3 + V2O5 + 6H -> 2YEuVO4 + 3H2O
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(340).EUt(120).blastFurnaceTemp(1200)
                .inputItems(dust, YttriumOxide, 5)
                .inputItems(EuropiumOxide,5)
                .inputItems(VanadiumOxide,7)
                .inputFluids(Hydrogen.getFluid(6000))
                .outputItems(YttriumEuropiumVanadate,14)
                .outputFluids(Steam.getFluid(3000))
                .save(provider);

        // SrCl2 + H2SO4 -> SrSO4 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(160).EUt(480)
                .inputItems(StrontiumChloride,3)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, Celestine, 6)
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // 2SrO + Eu2O3 + 2Al2O3 + 6H -> 2SrEuAl2O4 + 3H2O
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(340).EUt(120).blastFurnaceTemp(1200)
                .inputItems(StrontiumOxide,4)
                .inputItems(EuropiumOxide,5)
                .inputItems(Alumina,10)
                .inputFluids(Hydrogen.getFluid(6000))
                .outputItems(StrontiumEuropiumAluminate,16)
                .outputFluids(Steam.getFluid(3000))
                .save(provider);

        List<Material> halides = List.of(ThalliumIodide, RubidiumIodide, IndiumIodide, ScandiumIodide, GalliumIodide);
        List<Material> mixtures = List.of(GreenHalideMix, RedHalideMix, BlueHalideMix, WhiteHalideMix, UVAHalideMix);
        List<ItemEntry<Item>> lamp_cores = List.of(GREEN_LAMP_CORE, RED_LAMP_CORE, BLUE_LAMP_CORE, WHITE_LAMP_CORE, UVA_LAMP_CORE);
        List<ItemEntry<Item>> halide_lamp = List.of(GREEN_HALIDE_LAMP, RED_HALIDE_LAMP, BLUE_HALIDE_LAMP, WHITE_HALIDE_LAMP, UVA_HALIDE_LAMP);

        for (int i = 0; i < 5; i++) {
            MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(30)
                    .inputItems(halides.get(i))
                    .inputItems(PotassiumIodide,2)
                    .inputFluids(Mercury.getFluid(1000))
                    .outputItems(dust, mixtures.get(i),2)
                    .save(provider);

            ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(1920)
                    .inputItems(dust, mixtures.get(i))
                    .inputItems(foil, Molybdenum, 2)
                    .inputItems(wireFine, ThoriumDopedTungsten, 4)
                    .inputItems(ALUMINO_SILICATE_GLASS_TUBE)
                    .inputItems(plate, CubicZirconia, 2)
                    .inputFluids(Argon.getFluid(1000))
                    .outputItems(lamp_cores.get(i))
                    .save(provider);

            if (i == 4) {
                ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                        .inputItems(lamp_cores.get(i))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, WoodsGlass, 2)
                        .inputItems(YttriumEuropiumVanadate,7)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i))
                        .save(provider);

                ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                        .inputItems(lamp_cores.get(i))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, WoodsGlass, 2)
                        .inputItems(StrontiumEuropiumAluminate,4)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i))
                        .save(provider);

                ASSEMBLY_LINE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(7680)
                        .inputItems(dust, mixtures.get(i))
                        .inputItems(foil, Molybdenum, 2)
                        .inputItems(wireFine, ThoriumDopedTungsten, 4)
                        .inputItems(ALUMINO_SILICATE_GLASS_TUBE)
                        .inputItems(plate, CubicZirconia, 2)
                        .inputFluids(Xenon.getFluid(250))
                        .inputFluids(SolderingAlloy.getFluid(432))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, WoodsGlass, 2)
                        .inputItems(YttriumEuropiumVanadate,7)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i),2)
                        .save(provider);

                ASSEMBLY_LINE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(7680)
                        .inputItems(dust, mixtures.get(i))
                        .inputItems(foil, Molybdenum, 2)
                        .inputItems(wireFine, ThoriumDopedTungsten, 4)
                        .inputItems(ALUMINO_SILICATE_GLASS_TUBE)
                        .inputItems(plate, CubicZirconia, 2)
                        .inputFluids(Xenon.getFluid(250))
                        .inputFluids(SolderingAlloy.getFluid(432))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, WoodsGlass, 2)
                        .inputItems(StrontiumEuropiumAluminate,4)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i),2)
                        .save(provider);

            } else {
                ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                        .inputItems(lamp_cores.get(i))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, BorosilicateGlass, 2)
                        .inputItems(YttriumEuropiumVanadate,7)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i))
                        .save(provider);

                ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                        .inputItems(lamp_cores.get(i))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, BorosilicateGlass, 2)
                        .inputItems(StrontiumEuropiumAluminate,4)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i))
                        .save(provider);

                ASSEMBLY_LINE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(7680)
                        .inputItems(dust, mixtures.get(i))
                        .inputItems(foil, Molybdenum, 2)
                        .inputItems(wireFine, ThoriumDopedTungsten, 4)
                        .inputItems(ALUMINO_SILICATE_GLASS_TUBE)
                        .inputItems(plate, CubicZirconia, 2)
                        .inputFluids(Xenon.getFluid(250))
                        .inputFluids(SolderingAlloy.getFluid(432))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, BorosilicateGlass, 2)
                        .inputItems(YttriumEuropiumVanadate,7)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i),2)
                        .save(provider);

                ASSEMBLY_LINE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(7680)
                        .inputItems(dust, mixtures.get(i))
                        .inputItems(foil, Molybdenum, 2)
                        .inputItems(wireFine, ThoriumDopedTungsten, 4)
                        .inputItems(ALUMINO_SILICATE_GLASS_TUBE)
                        .inputItems(plate, CubicZirconia, 2)
                        .inputFluids(Xenon.getFluid(250))
                        .inputFluids(SolderingAlloy.getFluid(432))
                        .inputItems(rod, MaragingSteel250, 4)
                        .inputItems(BALLAST)
                        .inputItems(foil, Electrum, 2)
                        .inputItems(plate, BorosilicateGlass, 2)
                        .inputItems(StrontiumEuropiumAluminate,4)
                        .inputFluids(Nitrogen.getFluid(1000))
                        .outputItems(halide_lamp.get(i),2)
                        .save(provider);
            }
        }

        // 6F + 2CS2 -> C2F6S2 + 2S
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(250).EUt(120)
                .notConsumable(dust, Iodine)
                .inputFluids(Fluorine.getFluid(6000))
                .inputFluids(CarbonSulfide.getFluid(2000))
                .outputFluids(Biperfluoromethanedisulfide.getFluid(1000))
                .outputItems(dust, Sulfur, 2)
                .save(provider);

        // Hg + 3H2O2 + C2F6S2 + BaCO3 -> [C2BaF6O6S2 + 3H2O + Hg] + C
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(480)
                .inputFluids(Mercury.getFluid(1000))
                .inputFluids(Water.getFluid(3000))
                .inputFluids(Biperfluoromethanedisulfide.getFluid(1000))
                .inputItems(BariumCarbonate,5)
                .notConsumable(UVA_HALIDE_LAMP)
                .outputFluids(BariumTriflateSolution.getFluid(3000))
                .outputItems(dust, Carbon)
                .save(provider);

        // [C2BaF6O6S2 + 3H2O + Hg] -> C2BaF6O6S2 + 3H2O + Hg
        CENTRIFUGE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(1920)
                .inputFluids(BariumTriflateSolution.getFluid(3000))
                .outputItems(BariumTriflate,17)
                .outputFluids(Mercury.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .save(provider);

        // 3H2SO4 + 2Sc + 3C2BaF6O6S2 -> 3BaSO4 + 2C3F9O9S3Sc + 6H
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(200).EUt(480)
                .inputFluids(SulfuricAcid.getFluid(3000))
                .inputItems(dust, Scandium, 2)
                .inputItems(BariumTriflate,51)
                .outputItems(dust, Barite, 21)
                .outputItems(ScandiumTriflate,50)
                .outputFluids(Hydrogen.getFluid(6000))
                .save(provider);

        // 2HNO3 + BaS -> H2S + Ba(NO3)2
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(120)
                .inputFluids(NitricAcid.getFluid(2000))
                .inputItems(BariumSulfide,2)
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputItems(BariumNitrate,9)
                .save(provider);

        // 2HNO3 + Cu -> 2H + Cu(NO3)2
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(120)
                .inputFluids(NitricAcid.getFluid(2000))
                .inputItems(dust, Copper)
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(2000))
                .outputItems(CopperNitrate,9)
                .save(provider);

        // 6HNO3 + Y2O3 -> 3H2O + 2Y(NO3)3
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(120)
                .inputFluids(NitricAcid.getFluid(6000))
                .inputItems(dust, YttriumOxide, 5)
                .circuitMeta(0)
                .outputFluids(Water.getFluid(3000))
                .outputItems(YttriumNitrate,26)
                .save(provider);

        // C3H5ClO + 2H2O + Na2CO3 -> C3H8O3 + NaCl + NaHCO3
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(100).EUt(1024)
                .inputFluids(Epichlorohydrin.getFluid(1000))
                .inputFluids(Water.getFluid(2000))
                .inputItems(dust, SodaAsh, 6)
                .outputFluids(Glycerol.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputItems(SodiumBicarbonate,6)
                .save(provider);

        // C3H8O3 + 2HCl + 3HCN + HClO + 3H2O -> C6H8O7 + 3NH4Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(7680)
                .inputFluids(Glycerol.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputFluids(HypochlorousAcid.getFluid(1000))
                .inputFluids(HydrogenCyanide.getFluid(3000))
                .inputFluids(Water.getFluid(3000))
                .notConsumable(dust, PotassiumDichromate)
                .circuitMeta(0)
                .outputFluids(CitricAcid.getFluid(1000))
                .outputFluids(AmmoniumChloride.getFluid(3000))
                .save(provider);

        // 3Cu(NO3)2 + 2Ba(NO3)2 + Y(NO3)3 + 2NH3 + C6H8O7 -> YBa2Cu3O6 + 15NO2 + 6CO + 4H2O + 6H
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(7680)
                .inputItems(CopperNitrate,27)
                .inputItems(BariumNitrate,18)
                .inputItems(YttriumNitrate,13)
                .inputFluids(Ammonia.getFluid(2000))
                .inputFluids(CitricAcid.getFluid(1000))
                .outputItems(WellMixedYBCOxides,12)
                .outputFluids(NitrogenDioxide.getFluid(15000))
                .outputFluids(CarbonMonoxide.getFluid(6000))
                .outputFluids(Water.getFluid(4000))
                .outputFluids(Hydrogen.getFluid(6000))
                .save(provider);

        // 2Th + 2Ba + 3Cu + 2Ca -> TBCC
        ASSEMBLER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(360).EUt(122880)
                .inputItems(foil, Thallium, 2)
                .inputItems(foil, Barium, 2)
                .inputItems(foil, Copper, 3)
                .inputItems(foil, Calcium, 2)
                .outputItems(PiledTBCC,9)
                .save(provider);

        // [2Th + 2Ba + 3Cu + 2Ca] + 10O -> TBCCO
        ARC_FURNACE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(30720)
                .inputItems(PiledTBCC)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(TBCCODust)
                .save(provider);

        // 9O + C6H12O6 -> 3C2H2O4 + 3H2O
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(120).EUt(480)
                .notConsumable(dust, VanadiumOxide)
                .inputFluids(Oxygen.getFluid(9000))
                .inputItems(Glucose,24)
                .outputFluids(Water.getFluid(3000))
                .outputFluids(OxalicAcid.getFluid(3000))
                .save(provider);

        // 2C2H2O4 + 2O + Ac -> Ac(C2O4)2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(180).EUt(30720)
                .inputFluids(OxalicAcid.getFluid(2000))
                .inputFluids(Oxygen.getFluid(2000))
                .inputItems(dust, Actinium)
                .outputFluids(Water.getFluid(2000))
                .outputItems(ActiniumOxalate,13)
                .save(provider);

        // C + 4Cl -> CCl4
//        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(30)
//                .inputItems(dust, Carbon)
//                .circuitMeta(0)
//                .inputFluids(Chlorine.getFluid(4000))
//                .outputFluids(CarbonTetrachloride.getFluid(1000))
//                .save(provider);

        // Ac(C2O4)2 + 3NaH + 13Na + 4CCl4 -> AcH3 + 16NaCl + 8CO
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(530).EUt(120)
                .blastFurnaceTemp(10700)
                .inputItems(ActiniumOxalate,13)
                .inputItems(SodiumHydride,6)
                .inputItems(dust, Sodium, 13)
                .inputFluids(CarbonTetrachloride.getFluid(4000))
                .outputItems(ActiniumHydride,4)
                .outputItems(dust, Salt, 32)
                .outputFluids(CarbonDioxide.getFluid(8000))
                .save(provider);

        // AcH3 + 9H -> AcH12 (multiplied by 18)
        STELLAR_FORGE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(7800000)
                .inputItems(NAQUADRIA_CHARGE.asItem())
                .inputItems(ActiniumHydride,72)
                .inputFluids(Hydrogen.getFluid(162000))
                .outputFluids(ActiniumSuperhydridePlasma.getFluid(72000))
                .save(provider);

        CANNER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++)
                .inputItems(PLASMA_CONTAINMENT_CELL)
                .inputFluids(ActiniumSuperhydridePlasma.getFluid(1000))
                .outputItems(ACTINIUM_PLASMA_CONTAINMENT_CELL)
                .EUt(750000)
                .duration(20)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(340).EUt(8380000)
                .inputItems(ACTINIUM_PLASMA_CONTAINMENT_CELL)
                .inputFluids(LiquidHelium.getFluid(24000))
                .outputItems(ActiniumSuperhydride,13)
                .outputItems(PLASMA_CONTAINMENT_CELL)
                .outputFluids(Helium.getFluid(24000))
                .save(provider);

        // 2La + 2 C60H30 -> La2(C60H30)2
        MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(140).EUt(30720)
                .inputItems(dust, Lanthanum, 2)
                .inputItems(UnfoldedFullerene,2)
                .outputItems(LanthanumFullereneMix,4)
                .save(provider);

        //La2(C60H30)2 + 20 N -> La2(C60)2 + 20 NH3
        LARGE_ENGRAVER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(1966080)
                .inputItems(LanthanumFullereneMix,4)
                .inputFluids(Nitrogen.getFluid(20000))
                .notConsumable(lens, Magenta)
                .outputFluids(Ammonia.getFluid(20000))
                .outputItems(LanthanumEmbeddedFullerene,4)
                .save(provider);

        // 3Rb + 3Cs + La2(C60)2 -> La2Cs3Rb3(C60)2
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(680).EUt(120).blastFurnaceTemp(2400)
                .inputItems(LanthanumEmbeddedFullerene,4)
                .inputItems(dust, Rubidium, 3)
                .inputItems(dust, Caesium, 3)
                .outputItems(FullereneSuperconductiveDust,10)
                .save(provider);

        // (CH3)2SiHCl + CH4 -> (CH3)3SiCl + 2H
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(110).EUt(1920)
                .inputFluids(Dimethyldichlorosilane.getFluid(1000))
                .inputFluids(Methane.getFluid(1000))
                .outputFluids(Trimethylchlorosilane.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);

        // 2CH2O2 + 2Br + 4Na + 2H2O -> Br2C2H2O2 + 4NaOH + 2H
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(360).EUt(7680)
                .inputFluids(FormicAcid.getFluid(2000))
                .inputFluids(Bromine.getFluid(2000))
                .inputFluids(Water.getFluid(2000))
                .notConsumableFluid(Trimethylchlorosilane.getFluid(1))
                .inputItems(dust, Sodium, 4)
                .outputItems(dust, SodiumHydroxide, 12)
                .outputFluids(Dibromoacrolein.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);

        // 6NaOH + 4S -> 2Na2S + Na2S2O3 + 3H2O
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(120).blastFurnaceTemp(4500)
                .inputItems(dust, SodiumHydroxide, 18)
                .inputItems(dust, Sulfur, 4)
                .outputItems(dust, SodiumSulfide, 6)
                .outputItems(SodiumThiosulfate,7)
                .outputFluids(Steam.getFluid(3000))
                .save(provider);

        // 2Cl + C2H6 -> C2H5Cl + HCl
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(200).EUt(3340)
                .inputFluids(Chlorine.getFluid(2000))
                .inputFluids(Ethane.getFluid(1000))
                .outputFluids(Chloroethane.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .notConsumable(UVA_HALIDE_LAMP)
                .save(provider);

        // C2H4Cl2 + 2Na2S2O3 + C2H2Br2O2 -> C4H4S2Br2 + 2NaHSO4 + 2NaCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(7680)
                .inputItems(SodiumThiosulfate,14)
                .inputFluids(Chloroethane.getFluid(1000))
                .inputFluids(Dibromoacrolein.getFluid(1000))
                .outputItems(dust, Salt, 4)
                .outputItems(dust, SodiumBisulfate, 14)
                .outputFluids(Bromohydrothiine.getFluid(1000))
                .save(provider);

        // C4H4S2Br2 + 2Se + 2C4H9Li -> C4H4S2Li2Se2 + 2C4H9Br
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(30720)
                .inputFluids(Bromohydrothiine.getFluid(1000))
                .inputFluids(ButylLithium.getFluid(2000))
                .inputItems(dust, Selenium, 2)
                .outputFluids(Bromobutane.getFluid(2000))
                .outputItems(Lithiumthiinediselenide,14)
                .save(provider);

        // C3H6 + C4H8 -> C3H4 + C4H10
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(200).EUt(480)
                .inputFluids(Propene.getFluid(1000))
                .inputFluids(Butene.getFluid(1000))
                .notConsumable(dust, DehydrogenationCatalyst)
                .outputFluids(Propadiene.getFluid(1000))
                .outputFluids(Butane.getFluid(1000))
                .save(provider);

        // TiCl4 + 2 C3H4 + 2 C2H2 -> 2 HCl + (C5H5)2Cl2Ti
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(7680)
                .inputFluids(TitaniumTetrachloride.getFluid(1000))
                .inputFluids(Propadiene.getFluid(2000))
                .inputFluids(Acetylene.getFluid(2000))
                .notConsumable(dust, ScandiumTriflate)
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .outputItems(TitaniumCyclopentadienyl,23)
                .save(provider);

        // C2F4 + 2C4H4S2Li2Se2 -> C10H8S4Se4 + 4LiF
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(7920).EUt(120).blastFurnaceTemp(3500)
                .inputItems(Lithiumthiinediselenide,28)
                .inputFluids(Tetrafluoroethylene.getFluid(1000))
                .notConsumable(dust, TitaniumCyclopentadienyl)
                .outputItems(dust, LithiumFluoride, 8)
                .outputItems(BETS,26)
                .save(provider);

        // This is correct
        // > ok
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(20250).EUt(120).blastFurnaceTemp(5000)
                .inputItems(BETS)
                .inputFluids(AmmoniumPerrhenate.getFluid(1000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputItems(BETSPerrhenate)
                .save(provider);

        // C4H9Br + NaOH -> NaBr + C4H10O
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(40).EUt(120)
                .inputFluids(Bromobutane.getFluid(1000))
                .inputItems(dust, SodiumHydroxide, 3)
                .outputItems(SodiumBromide,2)
                .outputFluids(Butanol.getFluid(1000))
                .save(provider);

        // NaBr -> Na + Br
        ELECTROLYZER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(120)
                .inputItems(SodiumBromide,2)
                .outputItems(dust, Sodium)
                .outputFluids(Bromine.getFluid(1000))
                .save(provider);

        // 2Fr + C2H2 -> Fr2C2 + 2H
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(480)
                .inputItems(dust, Francium, 2)
                .inputFluids(Acetylene.getFluid(1000))
                .outputItems(FranciumCarbide,4)
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);

        // 4B + 3C -> B4C3
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(550).EUt(120).blastFurnaceTemp(4000)
                .inputItems(dust, Boron, 4)
                .inputItems(dust, Carbon, 3)
                .outputItems(BoronCarbide,7)
                .save(provider);

        // 2Fr2C2 + B4C3 -> Fr4B4C7
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(1920)
                .inputItems(FranciumCarbide,8)
                .inputItems(BoronCarbide,7)
                .outputItems(BoronFranciumCarbide,15)
                .save(provider);

        // At + H2SO4 -> [At + H2O + SO3]
        MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(140).EUt(7680)
                .inputItems(dust, Astatine)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(AstatideSolution.getFluid(1000))
                .save(provider);

        // 3[At + H2O + SO3] + Ho + Th + Cn + Fl -> 3H2SO4 + [3At + Ho + Th + Cn + Fl]
        MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(380).EUt(30720)
                .inputFluids(AstatideSolution.getFluid(3000))
                .inputItems(dust, Holmium)
                .inputItems(dust, Thulium)
                .inputItems(dust, Copernicium)
                .inputItems(dust, MetastableFlerovium)
                .outputFluids(SulfuricAcid.getFluid(3000))
                .outputItems(MixedAstatideSalts,7)
                .save(provider);

        // Fr4B4C7 + 2[3At + Ho + Th + Cn + Fl] = B4C7Fr4At6Ho2Th2Fl2Cn2
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(15000).EUt(120).blastFurnaceTemp(11300)
                .inputItems(BoronFranciumCarbide,15)
                .inputItems(MixedAstatideSalts,14)
                .outputItems(BorocarbideDust,29)
                .save(provider);

        // 6I + 6[NaOH + H2O] -> NaIO3 + 5NaI + 9H2O
        ELECTROLYZER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(260).EUt(1920)
                .inputItems(dust, Iodine, 6)
                .inputFluids(SodiumHydroxideSolution.getFluid(6000))
                .outputItems(SodiumIodate,5)
                .outputItems(SodiumIodide,10)
                .outputFluids(Water.getFluid(9000))
                .save(provider);

        // 3[Cu + H2SO4] + 6NaOH + NaI + 3SO3 -> NaIO3 + 3Cu + 3Na + 3NaSO4 + 6H2O + 3SO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(1920)
                .inputFluids(CopperSulfateSolution.getFluid(3000))
                .inputFluids(SulfurTrioxide.getFluid(3000))
                .inputItems(SodiumIodide,2)
                .inputItems(dust, SodiumHydroxide, 18)
                .outputItems(SodiumIodate,5)
                .outputItems(dust, Copper, 3)
                .outputItems(dust, Sodium, 3)
                .outputFluids(SodiumSulfateSolution.getFluid(3000))
                .outputFluids(Water.getFluid(6000))
                .outputFluids(SulfurDioxide.getFluid(3000))
                .save(provider);

        // NaIO3 + NaClO -> NaIO4 + NaCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(240).EUt(1920)
                .inputItems(SodiumIodate,5)
                .inputItems(SodiumHypochlorite,3)
                .outputItems(SodiumPeriodate,6)
                .outputItems(dust, Salt, 2)
                .save(provider);

        // 3NaIO4 + 4Ru + 8NaOH -> 3NaI + 4Na2RuO4 + 4H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(220).EUt(480)
                .inputItems(SodiumPeriodate,18)
                .inputItems(dust, Ruthenium, 4)
                .inputItems(dust, SodiumHydroxide, 24)
                .outputItems(SodiumIodide,6)
                .outputItems(dust, SodiumRuthenate, 28)
                .outputFluids(Water.getFluid(4000))
                .save(provider);

        // Sg + 2 NaOH + 6 F + 2H2O -> 6HF + Na2SgO4
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(820).EUt(30720)
                .inputItems(dust, Seaborgium)
                .inputItems(dust, SodiumHydroxide, 6)
                .inputFluids(Fluorine.getFluid(6000))
                .inputFluids(Water.getFluid(2000))
                .outputFluids(HydrofluoricAcid.getFluid(6000))
                .outputItems(SodiumSeaborgate,7)
                .save(provider);

        // Sr + 2Cl -> SrCl2
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(120)
                .inputItems(dust, Strontium)
                .inputFluids(Chlorine.getFluid(2000))
                .outputItems(StrontiumChloride,3)
                .save(provider);

        // Na2O4Ru + Na2SgO4 + 2SrCl2 -> 4NaCl + RuSgSr2O8
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(1360).EUt(120).blastFurnaceTemp(4500)
                .inputItems(dust, SodiumRuthenate, 7)
                .inputItems(SodiumSeaborgate,5)
                .inputItems(StrontiumChloride,6)
                .outputItems(dust, Salt, 8)
                .outputItems(StrontiumSuperconductorDust,12)
                .save(provider);

        // Os + 4O -> OsO4
        ARC_FURNACE_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(520).EUt(4800)
                .inputItems(dust, Osmium)
                .inputFluids(Oxygen.getFluid(4000))
                .outputItems(OsmiumTetroxide,5)
                .save(provider);

        // NaIO4 + C3H6O -> NaIO3 + CH2O + C2H4O
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(220).EUt(7680)
                .notConsumable(dust, OsmiumTetroxide)
                .inputItems(SodiumPeriodate,6)
                .inputFluids(Acetone.getFluid(1000))
                .outputItems(SodiumIodate,5)
                .outputFluids(Formaldehyde.getFluid(1000))
                .outputFluids(Acetaldehyde.getFluid(1000))
                .save(provider);

        // C4H10 + 2Br -> C4H9Br + HBr
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(7680)
                .notConsumable(UVA_HALIDE_LAMP)
                .inputFluids(Butane.getFluid(1000))
                .inputFluids(Bromine.getFluid(2000))
                .outputFluids(Bromobutane.getFluid(1000))
                .outputFluids(HydrobromicAcid.getFluid(1000))
                .save(provider);

        // Ir + 2O -> IrO2
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(280).EUt(120).blastFurnaceTemp(700)
                .notConsumable(dust, Salt)
                .inputItems(dust, Iridium)
                .inputFluids(Oxygen.getFluid(2000))
                .outputItems(dust, IridiumDioxide, 3)
                .save(provider);

        // Kr + 2F -> KrF2
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(170).EUt(480)
                .notConsumable(UVA_HALIDE_LAMP)
                .inputFluids(Krypton.getFluid(1000))
                .inputFluids(Fluorine.getFluid(2000))
                .outputFluids(KryptonDifluoride.getFluid(1000))
                .save(provider);

        // Mn + KrF2 -> MnF2 + Kr
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(170).EUt(480)
                .inputItems(dust, Manganese)
                .inputFluids(KryptonDifluoride.getFluid(1000))
                .outputItems(ManganeseFluoride,3)
                .outputFluids(Krypton.getFluid(1000))
                .save(provider);

        // MnF2 + O + H2O -> MnO2 + 2HF
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(160).EUt(120)
                .inputItems(ManganeseFluoride,3)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, Pyrolusite, 3)
                .outputFluids(HydrofluoricAcid.getFluid(2000))
                .save(provider);

        // C6H6O + H2O2 + H2O + 4Cl + 2C2H2O -> C10H10O6 + 4HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(320).EUt(122880)
                .inputFluids(Phenol.getFluid(1000))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .inputFluids(Chlorine.getFluid(4000))
                .inputFluids(Ethenone.getFluid(2000))
                .outputFluids(PhenylenedioxydiaceticAcid.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(4000))
                .save(provider);

        // NaSCN + HCl + 2CH3CH2NH2 -> NH3 + (C2H5NH)2CS + NaCl
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(30720)
                .inputFluids(SodiumThiocyanate.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(Ethylamine.getFluid(2000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(Diethylthiourea.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .save(provider);

        // C10H10O6 + 2(C2H5NH)2CS + 2SOCl2 -> 2SO2 + 4HCl + C20H30N4O4S2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(250).EUt(122880)
                .inputFluids(Diethylthiourea.getFluid(2000))
                .inputFluids(ThionylChloride.getFluid(2000))
                .inputFluids(PhenylenedioxydiaceticAcid.getFluid(1000))
                .outputFluids(SulfurDioxide.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(4000))
                .outputFluids(Isophthaloylbisdiethylthiourea.getFluid(1000))
                .save(provider);

        // Hs + 4Cl -> HsCl4
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(930).EUt(120).blastFurnaceTemp(12000)
                .inputItems(dust, MetastableHassium)
                .inputFluids(Chlorine.getFluid(4000))
                .outputItems(HassiumChloride,5)
                .save(provider);

        // Re + 5Cl -> ReCl5
        BLAST_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(930).EUt(120).blastFurnaceTemp(12500)
                .inputItems(dust, Rhenium)
                .inputFluids(Chlorine.getFluid(5000))
                .outputItems(RheniumChloride,6)
                .save(provider);

        // SbF5 + PCl3 + HF -> SbCl3 + HPF6
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(280).EUt(7680)
                .inputFluids(AntimonyPentafluoride.getFluid(1000))
                .inputFluids(PhosphorusTrichloride.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(1000))
                .outputItems(AntimonyTrichloride,4)
                .outputFluids(FluorophosphoricAcid.getFluid(1000))
                .save(provider);

        // SbCl3 + 3HF -> SbF3 + 3HCl
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(210).EUt(480)
                .inputItems(AntimonyTrichloride,4)
                .inputFluids(HydrofluoricAcid.getFluid(3000))
                .outputItems(AntimonyTrifluoride,4)
                .outputFluids(HydrochloricAcid.getFluid(3000))
                .save(provider);

        // 3C20H30N4O4S2 + ReCl5 + HsCl4 + TlCl + HPF6 -> ReHsTlC60PN12H84S6O12F6 + 7HCl + 3Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(620).EUt(845000)
                .inputItems(RheniumChloride,6)
                .inputItems(HassiumChloride,5)
                .inputItems(ThalliumChloride,2)
                .inputFluids(Isophthaloylbisdiethylthiourea.getFluid(3000))
                .inputFluids(FluorophosphoricAcid.getFluid(1000))
                .outputItems(RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate,125)
                .outputFluids(HydrochloricAcid.getFluid(7000))
                .outputFluids(Chlorine.getFluid(3000))
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(270).EUt(250000)
                .inputItems(dust, Naquadah)
                .inputItems(dust, NaquadahEnriched)
                .inputItems(dust, Naquadria)
                .inputItems(dust, Vibranium)
                .inputItems(dust, Adamantium)
                .inputItems(dust, Taranium)
                .inputItems(dust, Trinium)
                .inputItems(dust, Duranium)
                .inputItems(dust, Tritanium)
                .outputItems(Legendarium,9)
                .save(provider);

        CHEMICAL_PLANT_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(520).EUt(445000)
                .inputItems(dust, Cerium)
                .inputItems(dust, Caesium)
                .inputItems(dust, Cobalt, 2)
                .inputItems(dust, Indium, 10)
                .inputFluids(CosmicComputingMix.getFluid(1000))
                .outputItems(ChargedCesiumCeriumCobaltIndium,14)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(290).EUt(320000)
                .inputFluids(Cycloparaphenylene.getFluid(200))
                .inputFluids(Methane.getFluid(800))
                .inputItems(LanthanumEmbeddedFullerene)
                .notConsumable(plate, Rhenium)
                .outputItems(LanthanumFullereneNanotubes)
                .save(provider);

        // 2La + H2SO4 = La2O3 + H2S + O
        CHEMICAL_RECIPES.recipeBuilder("superconductors_smd_chain_" + chainNumber++).duration(100).EUt(120)
                .inputItems(dust, Lanthanum, 2)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, LanthanumOxide,5)
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

    }
}

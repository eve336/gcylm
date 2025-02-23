package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.eve.examplemod.common.data.EVRecipeTypes.LARGE_MIXER_RECIPES;
import static com.gregtechceu.gtceu.api.GTValues.MV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.SHAPE_MOLD_BLOCK;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static net.minecraft.world.level.block.Blocks.GRAVEL;
import static net.minecraft.world.level.block.Blocks.WHITE_BED;

public class VariousChains {
    public static void init(Consumer<FinishedRecipe> provider) {
        memoryFoam(provider);
        drillingMud(provider);
        hydrogenPeroxide(provider);
        fuels(provider);
        coalTar(provider);
        misc(provider);
    }
    public static void memoryFoam(Consumer<FinishedRecipe> provider) {
        int chainNumber = 0;

        // C2H4O + H2O -> [C2H4O + H2O]
        MIXER_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(140).EUt(120)
                .inputFluids(EthyleneOxide.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(WetEthyleneOxide.getFluid(1000))
                .save(provider);

        // [C2H4O + H2O] -> C2H6O2
        FLUID_HEATER_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(130).EUt(120)
                .circuitMeta(0)
                .inputFluids(WetEthyleneOxide.getFluid(1000))
                .outputFluids(EthyleneGlycol.getFluid(1000))
                .save(provider);

        // C7H8 + 2COCl2 + 2HNO3 + 12 H -> C9H6N2O2 + 4 HCl + 6 H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(125).EUt(480)
                .inputFluids(Toluene.getFluid(1000))
                .inputFluids(Phosgene.getFluid(2000))
                .inputFluids(NitricAcid.getFluid(2000))
                .inputFluids(Hydrogen.getFluid(10000))
                .outputFluids(TolueneDiisocyanate.getFluid(2000))
                .outputFluids(HydrochloricAcid.getFluid(4000))
                .outputFluids(Water.getFluid(6000))
                .save(provider);

        // C9H6N2O2 + 4C2H6O2 + O -> C17H16N2O4 + 7H2O
        CHEMICAL_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(110).EUt(480)
                .inputFluids(TolueneDiisocyanate.getFluid(1000))
                .inputFluids(EthyleneGlycol.getFluid(4000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputFluids(Polyurethane.getFluid(1000))
                .outputFluids(Water.getFluid(7000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(110).EUt(120)
                .inputFluids(Polyurethane.getFluid(1000))
                .inputFluids(EthyleneGlycol.getFluid(1000))
                .inputItems(dust, Calcite, 5)
                .outputFluids(ViscoelasticPolyurethane.getFluid(2000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(150).EUt(120)
                .inputFluids(ViscoelasticPolyurethane.getFluid(1000))
                .inputFluids(Air.getFluid(1000))
                .outputFluids(ViscoelasticPolyurethaneFoam.getFluid(2000))
                .save(provider);

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(60).EUt(30)
                .inputFluids(ViscoelasticPolyurethaneFoam.getFluid(1000))
                .notConsumable(SHAPE_MOLD_BLOCK)
                .outputItems(MEMORY_FOAM_BLOCK)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("memory_foam_recipes_" + chainNumber++).duration(260).EUt(8)
                .inputItems(rod, Wood, 3)
                .inputItems(MEMORY_FOAM_BLOCK,3)
                .outputItems(WHITE_BED.asItem())
                .save(provider);

    }
    public static void drillingMud(Consumer<FinishedRecipe> provider) {
        int chainNumber = 0;

        // HClO + C2H4 -> C2H5ClO
        CHEMICAL_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(480)
                .inputFluids(HypochlorousAcid.getFluid(1000))
                .inputFluids(Ethylene.getFluid(1000))
                .outputFluids(Chloroethanol.getFluid(1000))
                .save(provider);

        // C2H5ClO + C3H9N + Na -> C5H14NO + NaCl
        CHEMICAL_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(480)
                .inputItems(dust, Sodium)
                .inputFluids(Chloroethanol.getFluid(1000))
                .inputFluids(Trimethylamine.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputFluids(Choline.getFluid(1000))
                .save(provider);

        // C2(H2O)4C + C5H14NO -> ATL
        // TODO lignite stuff
//        CHEMICAL_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(120)
//                .inputItems(dust, Lignite)
//                .inputFluids(Choline.getFluid(1000))
//                .outputFluids(ATL.getFluid(1000))
//                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("atl").duration(6*20).EUt(120)
                .inputFluids(Choline.getFluid(1000))
                .inputItems(dust, Coal)
                .outputFluids(ATL.getFluid(1000))
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(480)
                .inputFluids(BariumSulfateSolution.getFluid(1000))
                .inputFluids(CalciumCarbonateSolution.getFluid(1000))
                .inputFluids(BentoniteClaySlurry.getFluid(1000))
                .inputFluids(Lubricant.getFluid(1000))
                .inputFluids(ATL.getFluid(1000))
                .inputFluids(EthyleneGlycol.getFluid(1000))
                .outputFluids(DrillingMud.getFluid(6000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputFluids(BariumSulfateSolution.getFluid(1000))
                .inputFluids(CalciumCarbonateSolution.getFluid(1000))
                .outputFluids(CaCBaSMixture.getFluid(2000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputFluids(BentoniteClaySlurry.getFluid(1000))
                .inputFluids(Lubricant.getFluid(1000))
                .outputFluids(LubricantClaySlurry.getFluid(2000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputFluids(ATL.getFluid(1000))
                .inputFluids(EthyleneGlycol.getFluid(1000))
                .outputFluids(ATLEthylene.getFluid(2000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(60).EUt(120)
                .inputFluids(CaCBaSMixture.getFluid(2000))
                .inputFluids(LubricantClaySlurry.getFluid(2000))
                .outputFluids(DrillingMudMixture.getFluid(4000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(60).EUt(120)
                .inputFluids(DrillingMudMixture.getFluid(4000))
                .inputFluids(ATLEthylene.getFluid(2000))
                .outputFluids(DrillingMud.getFluid(6000))
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("drilling_mud_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputFluids(UsedDrillingMud.getFluid(1000))
                .outputFluids(DrillingMud.getFluid(990))
                .outputItems(GRAVEL.asItem())
                .save(provider);

    }
    public static void hydrogenPeroxide(Consumer<FinishedRecipe> provider) {
        int chainNumber = 0;

        // C16H12O2H2 + 2O + C14H10 (catalyst) -> H2O2 + C16H12O2
        CHEMICAL_RECIPES.recipeBuilder("hydrogen_peroxide_recipes_" + chainNumber++).duration(600).EUt(240)
                .inputFluids(Oxygen.getFluid(2000))
                .inputFluids(EthylAnthraHydroQuinone.getFluid(1000))
                .notConsumableFluid(Anthracene.getFluid(1))
                .outputFluids(HydrogenPeroxide.getFluid(2000))
                .outputFluids(EthylAnthraQuinone.getFluid(1000))
                .save(provider);

        // 2H + C16H12O2 -> C16H12O2H2
        CHEMICAL_RECIPES.recipeBuilder("hydrogen_peroxide_recipes_" + chainNumber++).duration(600).EUt(120)
                .inputFluids(Hydrogen.getFluid(2000))
                .inputFluids(EthylAnthraQuinone.getFluid(1000))
                .outputFluids(EthylAnthraHydroQuinone.getFluid(1000))
                .save(provider);

        // C8H4O3 + C8H10 -> C16H12O2 + H2O
        CHEMICAL_RECIPES.recipeBuilder("hydrogen_peroxide_recipes_" + chainNumber++).duration(300).EUt(120)
                .inputItems(dust, PhthalicAnhydride, 15)
                .inputFluids(Ethylbenzene.getFluid(1000))
                .outputFluids(EthylAnthraQuinone.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // C2H4 + C6H6 -> C8H10
        CHEMICAL_RECIPES.recipeBuilder("hydrogen_peroxide_recipes_" + chainNumber++).duration(300).EUt(60)
                .circuitMeta(1)
                .inputFluids(Ethylene.getFluid(1000))
                .inputFluids(Benzene.getFluid(1000))
                .outputFluids(Ethylbenzene.getFluid(1000))
                .save(provider);

        // C8H6O4 -> C8H4O3 + H2O (H2O voided - Dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("hydrogen_peroxide_recipes_" + chainNumber++).duration(600).EUt(120)
                .inputFluids(PhthalicAcid.getFluid(1000))
                .outputItems(dust, PhthalicAnhydride, 15)
                .save(provider);

        // 21O + 4 C10H8 -> 5C8H6O4 + H2O
        CHEMICAL_RECIPES.recipeBuilder("hydrogen_peroxide_recipes_" + chainNumber++).duration(210).EUt(120)
                .notConsumable(dust, Lithium)
                .inputFluids(Oxygen.getFluid(21000))
                .inputFluids(Naphthalene.getFluid(4000))
                .outputFluids(PhthalicAcid.getFluid(5000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

    }
    public static void fuels(Consumer<FinishedRecipe> provider) {
        int chainNumber = 0;

        // High Octane Gasoline
        LARGE_CHEMICAL_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(50).EUt(1920)
                .inputFluids(NitricOxide.getFluid(6000))
                .inputFluids(Gasoline.getFluid(20000))
                .inputFluids(Toluene.getFluid(1000))
                .inputFluids(Octane.getFluid(2000))
                .inputFluids(EthylTertButylEther.getFluid(3000))
                .outputFluids(HighOctaneGasoline.getFluid(32000))
                .save(provider);

        // Gasoline
        CHEMICAL_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(10).EUt(480)
                .inputFluids(RawGasoline.getFluid(10000))
                .inputFluids(Toluene.getFluid(1000))
                .outputFluids(Gasoline.getFluid(11000))
                .save(provider);

        // Raw Gasoline
//        LARGE_CHEMICAL_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(100).EUt(480)
//                .inputFluids(Naphtha.getFluid(16000))
//                .inputFluids(Gas.getFluid(2000))
//                .inputFluids(Methanol.getFluid(1000))
//                .inputFluids(Acetone.getFluid(1000))
//                .outputFluids(RawGasoline.getFluid(20000))
//                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(400).EUt(480)
                .inputFluids(Ethanol.getFluid(1000))
                .inputFluids(Butane.getFluid(1000))
                .outputFluids(GTMaterials.EthylTertButylEther.getFluid(2000))
                .save(provider);

        // Rocket Fuel Tier T4
        // C2H8N2 + N2O4 = H8N4C2O4 (treat like chem reactor recipes)
        MIXER_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(280).EUt(480)
                .inputFluids(Dimethylhydrazine.getFluid(1000))
                .inputFluids(DinitrogenTetroxide.getFluid(1000))
                .outputFluids(RocketFuelH8N4C2O4.getFluid(1000))
                .save(provider);

        // 2NO2 = N2O4
        CHEMICAL_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(320).EUt(480)
                .notConsumable(dust, Copper)
                .inputFluids(NitrogenDioxide.getFluid(2000))
                .outputFluids(DinitrogenTetroxide.getFluid(1000))
                .save(provider);

        // Rocket Fuel Tier 3
        // HNO3 + CH3(NH)NH2 = CN3H7O3 (treat like chem reactor recipes)
        MIXER_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(200).EUt(240)
                .inputFluids(NitricAcid.getFluid(1000))
                .inputFluids(MonoMethylHydrazine.getFluid(1000))
                .outputFluids(RocketFuelCN3H7O3.getFluid(1000))
                .save(provider);

        // C + 2H + N2H4 = CH3(NH)NH2
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(480).EUt(240)
                .inputItems(dust, Carbon)
                .inputFluids(Hydrogen.getFluid(2000))
                .inputFluids(Hydrazine.getFluid(1000))
                .outputFluids(MonoMethylHydrazine.getFluid(1000))
                .save(provider);

        // Rocket Fuel Tier 2
        // N2H4 + CH3OH = [N2H4 + CH3OH] (treat like chem reactor recipes)
        MIXER_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(120).EUt(240)
                .inputFluids(Hydrazine.getFluid(1000))
                .inputFluids(Methanol.getFluid(1000))
                .outputFluids(DenseHydrazineFuelMixture.getFluid(1000))
                .save(provider);

        // Rocket Fuel Tier 1
        // O + RP-1 = [O + RP-1] (treat like chem reactor recipes)
        MIXER_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(16).EUt(240)
                .inputFluids(Oxygen.getFluid(FluidStorageKeys.LIQUID, 1000))
                .inputFluids(RP1.getFluid(1000))
                .outputFluids(RP1RocketFuel.getFluid(1000))
                .save(provider);

        // Rocket fuel chemicals
        // 2NH3 + H2O2 = N2H4 + H2O
        CHEMICAL_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(320).EUt(30)
                .inputFluids(Ammonia.getFluid(2000))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputFluids(Hydrazine.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // LOX
//        VACUUM_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(30).EUt(480)
//                .inputFluids(Oxygen.getFluid(1000))
//                .inputFluids(Oxygen.getFluid(FluidStorageKeys.LIQUID, 1000))
//                .save(provider);

        // Liquid Hydrogen
        VACUUM_RECIPES.recipeBuilder("liquid_hydrogen").duration(16).EUt(540)
                .inputFluids(Hydrogen.getFluid(500))
                .outputFluids(LiquidHydrogen.getFluid(500))
                .save(provider);

        // RP1
        DISTILLERY_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(16).EUt(120)
                .circuitMeta(0)
                .inputFluids(Kerosene.getFluid(50))
                .outputFluids(RP1.getFluid(25))
                .save(provider);

    }
    public static void coalTar(Consumer<FinishedRecipe> provider) {
        int chainNumber = 0;

//        PYROLYSE_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(1080).EUt(60)
//                .circuitMeta(20)
//                .inputItems(gem, Lignite, 16)
//                .outputItems(dust, Ash, 4)
//                .outputFluids(CoalTar.getFluid(800))
//                .save(provider);

        PYROLYSE_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(360).EUt(120)
                .circuitMeta(20)
                .inputItems(gem, Charcoal, 32)
                .outputItems(dust, Ash, 4)
                .outputFluids(CoalTar.getFluid(800))
                .save(provider);
        PYROLYSE_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(720).EUt(120)
                .circuitMeta(20)
                .inputItems(gem, Coal, 12)
                .outputItems(dust, Ash, 4)
                .outputFluids(CoalTar.getFluid(2200))
                .save(provider);

        PYROLYSE_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(360).EUt(240)
                .circuitMeta(20)
                .inputItems(gem, Coke, 8)
                .outputItems(dust, Ash, 4)
                .outputFluids(CoalTar.getFluid(3400))
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(900).EUt(60)
                .inputFluids(CoalTar.getFluid(1000))
                .outputFluids(CoalTarOil.getFluid(500))
                .outputFluids(Kerosene.getFluid(200))
                .outputFluids(Ethylbenzene.getFluid(150))
                .outputFluids(Naphtha.getFluid(100))
                .outputFluids(Anthracene.getFluid(50))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(320).EUt(30)
                .inputFluids(SulfuricAcid.getFluid(8000))
                .inputFluids(CoalTarOil.getFluid(8000))
                .outputFluids(SulfuricCoalTarOil.getFluid(16000))
                .save(provider);

        DISTILLERY_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(80).EUt(30)
                .circuitMeta(0)
                .inputFluids(SulfuricCoalTarOil.getFluid(50))
                .outputFluids(Naphthalene.getFluid(50))
                .save(provider);

        DISTILLERY_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(5).EUt(480)
                .circuitMeta(1)
                .inputFluids(SulfuricCoalTarOil.getFluid(800))
                .outputFluids(Naphthalene.getFluid(800))
                .save(provider);

        // Radon Production ==========================================
        CHEMICAL_RECIPES.recipeBuilder("coal_tar_recipes_" + chainNumber++).duration(250).EUt(122880)
                .inputItems(ingot, GTMaterials.Plutonium239,  8)
                .inputItems(dust, GTMaterials.Uranium238)
                .inputFluids(Air.getFluid(10000))
                .outputItems(dust, GTMaterials.Plutonium239, 8)
                .outputFluids(Radon.getFluid(1000))
                .save(provider);

    }
    public static void misc(Consumer<FinishedRecipe> provider) {
        
        int chainNumber = 0;
// UU-Matter ===================================================================================================
        LARGE_MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(50).EUt(491520)
                .inputFluids(BosonicUUMatter.getFluid(1000))
                .inputFluids(FermionicUUMatter.getFluid(1000))
                .inputFluids(FreeElectronGas.getFluid(2000))
                .outputFluids(UUMatter.getFluid(1000))
                .save(provider);

        // Sodium Hypochlorite =========================================================================================
        // 2NaOH + 2Cl -> H2O + NaCl + NaClO
        LARGE_CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(80).EUt(120)
                .inputFluids(Chlorine.getFluid(2000))
                .inputItems(dust, SodiumHydroxide, 6)
                .outputFluids(Water.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputItems(SodiumHypochlorite,3)
                .save(provider);

        // HClO + NaOH -> H2O + NaClO
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(90).EUt(120)
                .inputFluids(HypochlorousAcid.getFluid(1000))
                .inputItems(dust, SodiumHydroxide, 3)
                .circuitMeta(0)
                .outputFluids(Water.getFluid(1000))
                .outputItems(SodiumHypochlorite,3)
                .save(provider);

        // 2 NaClO + CO2 + H2O -> 2 HClO + Na2CO3
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(90).EUt(120)
                .inputItems(SodiumHypochlorite,6)
                .inputFluids(CarbonDioxide.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputItems(dust, SodaAsh, 6)
                .outputFluids(HypochlorousAcid.getFluid(2000))
                .save(provider);

        // Lignite Processing ==========================================================================================
        FLUID_HEATER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(120).EUt(120)
                .circuitMeta(0)
                .inputFluids(Nitrogen.getFluid(1000))
                .outputFluids(HotNitrogen.getFluid(1000))
                .save(provider);

        // C2(H2O)4C + N(hot) -> N + 3C + 4H2O (H2O lost to dehydrator)
//        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(190).EUt(120)
//                .inputItems(dust, Lignite)
//                .inputFluids(HotNitrogen.getFluid(1000))
//                .outputFluids(Nitrogen.getFluid(1000))
//                .outputItems(DehydratedLignite,3)
//                .save(provider);

        COMPRESSOR_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(40).EUt(30)
                .inputItems(DehydratedLignite,3)
                .outputItems(BCEPellet) //Todo make BCE pellet equivalent to coal as furnace fuel
                .save(provider);

        // GRAPHENE
        // Graphene ====================================================================================================

        // FeCl3 + C6H12O6 = [FeCl3 + C6H12O6]
        MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(80).EUt(30)
                .inputFluids(Iron3Chloride.getFluid(1000))
                .inputItems(dust, Glucose,24)
                .outputFluids(GlucoseIronSolution.getFluid(1000))
                .save(provider);

        // [FeCl3 + C6H12O6] -> [6CO + Fe] + 3Cl + 5H2O + H2 (H2O and H2 lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(40).EUt(120)
                .notConsumable(rodLong, YttriumBariumCuprate)
                .inputFluids(GlucoseIronSolution.getFluid(1000))
                .outputItems(GRAPHENE_IRON_PLATE)
                .outputFluids(Chlorine.getFluid(3000))
                .save(provider);

        // KMnO4 + NaNO3 + H2SO4 = Graphene Oxidation Solution
        MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(260).EUt(120)
                .inputItems(dust, PotassiumPermanganate,6)
                .inputItems(dust, SodiumNitrate, 5)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(GrapheneOxidationSolution.getFluid(1000))
                .save(provider);

        // Graphite + Oxidation Solution = Graphite Oxide + Residue
        CHEMICAL_BATH_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(480)
                .inputItems(dust, Graphite, 3)
                .inputFluids(GrapheneOxidationSolution.getFluid(100))
                .outputItems(dust, GraphiteOxide)
                .chancedOutput(dust, GrapheneOxidationResidue, 8000, 1000)
                .save(provider);

        // Graphene + Oxidation Solution = Graphene Oxide + Residue
        // wtf why does this even exist it just looks like a waste of power and does nothing??
//        CHEMICAL_BATH_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(20).EUt(24)
//                .inputItems(dust, Graphene)
//                .inputFluids(GrapheneOxidationSolution.getFluid(100))
//                .outputItems(dust, GrapheneOxide,3)
//                .chancedOutput(dust, GrapheneOxidationResidue, 8000, 1000)
//                .save(provider);

        // Graphene Oxidation Residue -> Graphene Oxidation Solution
        EXTRACTOR_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(65).EUt(24)
                .inputItems(dust, GrapheneOxidationResidue)
                .outputFluids(GrapheneOxidationSolution.getFluid(100))
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(24)
                .inputItems(dust, GraphiteOxide)
                .inputFluids(Water.getFluid(100))
                .outputItems(dust, GrapheneOxide,3)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(30).EUt(480)
                .inputItems(dust, GrapheneOxide,3)
                .notConsumable(WHITE_HALIDE_LAMP)
                .notConsumableFluid(Hydrazine.getFluid(1))
                .outputItems(dust, Graphene)
                .save(provider);

        // [6CO + Fe] -> C6O + Fe
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputItems(GRAPHENE_IRON_PLATE)
                .outputItems(dust, GrapheneOxide,3)
                .outputItems(dust, Iron)
                .save(provider);

        // Liquid Air Distillation =====================================================================================
        DISTILLATION_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(7500).EUt(1920)
                .inputFluids(LiquidAir.getFluid(100000))
                .outputFluids(Nitrogen.getFluid(78000))
                .outputFluids(Oxygen.getFluid(20000))
                .outputFluids(Argon.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(500))
                .outputFluids(Neon.getFluid(100))
                .outputFluids(Helium.getFluid(50))
                .outputFluids(Methane.getFluid(20))
                .outputFluids(Krypton.getFluid(10))
                .outputFluids(Hydrogen.getFluid(5))
                .outputFluids(Xenon.getFluid(1))
                .save(provider);

        // Pyrotheum ===================================================================================================
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(80).EUt(VA[MV])
                .inputItems(dust, Coal)
                .inputItems(dust, Sulfur)
                .outputItems(dust, Blaze, 2)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(80).EUt(VA[MV])
                .inputItems(dust, Charcoal)
                .inputItems(dust, Sulfur)
                .outputItems(dust, Blaze, 2)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(120)
                .inputItems(dust, Redstone)
                .inputItems(dust, Sulfur)
                .inputItems(dust, Blaze, 2)
                .outputItems(dust, Pyrotheum, 4)
                .save(provider);

        EXTRACTOR_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(32).EUt(24)
                .inputItems(dust, Pyrotheum)
                .outputFluids(Pyrotheum.getFluid(250))
                .save(provider);

        // TODO CRYOTHEUM
//        // Cryotheum ===================================================================================================
//        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(80).EUt(480)
//                .inputItems(dust, Snow)
//                .inputItems(dust, Redstone)
//                .notConsumableFluid(Ice.getFluid(0))
//                .outputItems(dust, Blizz, 2)
//                .save(provider);

//        MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(120)
//                .inputItems(dust, Redstone)
//                .inputItems(dust, Snow)
//                .inputItems(dust, Blizz, 2)
//                .outputItems(dust, Cryotheum, 4)
//                .save(provider);

        EXTRACTOR_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(32).EUt(24)
                .inputItems(dust, Cryotheum)
                .outputFluids(Cryotheum.getFluid(250))
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++)
                .duration(200)
                .EUt(480)
                .circuitMeta(0)
                .inputFluids(Cryotheum.getFluid(10000))
                .outputFluids(SupercooledCryotheum.getFluid(10000))
                .save(provider);

        // Nuclear Process Distillation ================================================================================
        DISTILLATION_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(75).EUt(120)
                .inputFluids(RedOil.getFluid(3000))
                .outputItems(dust, FerriteMixture)
                .outputFluids(Hydrazine.getFluid(1000))
                .outputFluids(RP1.getFluid(1000))
                .outputFluids(TributylPhosphate.getFluid(1000))
                .save(provider);

        // 3Cl + P -> PCl3
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(60)
                .inputFluids(Chlorine.getFluid(3000))
                .inputItems(dust, Phosphorus)
                .circuitMeta(3)
                .outputFluids(PhosphorusTrichloride.getFluid(1000))
                .save(provider);

        // PCl3 + O -> POCl3
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100)
                .inputFluids(PhosphorusTrichloride.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputFluids(PhosphorylChloride.getFluid(1000))
                .save(provider);

        // POCl3 + 3C4H10O -> C12H27O4P + 3HCl
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100)
                .inputFluids(PhosphorylChloride.getFluid(1000))
                .inputFluids(Butanol.getFluid(3000))
                .outputFluids(HydrochloricAcid.getFluid(3000))
                .outputFluids(TributylPhosphate.getFluid(1000))
                .save(provider);

        // Formic acid =================================================================================================
        // CO + NaOH -> HCOONa
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).EUt(30).duration(60)
                .inputFluids(CarbonMonoxide.getFluid(1000))
                .inputItems(dust, SodiumHydroxide, 3)
                .circuitMeta(0)
                .outputFluids(SodiumFormate.getFluid(1000))
                .save(provider);

        // HCOONa + H2SO4 -> CH2O2 + NaHSO4
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).EUt(30).duration(60)
                .inputFluids(SodiumFormate.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(FormicAcid.getFluid(1000))
                .outputItems(dust, SodiumBisulfate, 7)
                .save(provider);

        // Misc Reactions ==============================================================================================
        // 3Ca + 3PO4 + H + O -> [3Ca + 3PO4 + H + O]
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).EUt(30).duration(100)
                .inputItems(dust, Calcium, 3)
                .inputItems(dust, Phosphate, 3) // this is probably wrong
                .inputFluids(Hydrogen.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, OrganicFertilizer, 10)
                .save(provider);

        // 2HCl + CaCO3 -> H2O + CO2 + CaCl2
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(30)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .inputItems(dust, Calcite, 5)
                .outputFluids(Water.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(dust, CalciumChloride, 3)
                .save(provider);

        // Zr + 4Cl -> ZrCl4
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(120)
                .inputItems(dust, Zirconium)
                .inputFluids(Chlorine.getFluid(4000))
                .outputItems(dust, ZirconiumTetrachloride,5)
                .save(provider);

        // ZrCl4 -> Zr + 4Cl
        ELECTROLYZER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(120)
                .inputItems(dust, ZirconiumTetrachloride,5)
                .outputItems(dust, Zirconium)
                .outputFluids(Chlorine.getFluid(4000))
                .save(provider);

        // SiF4 -> Si + 4F
        ELECTROLYZER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(120)
                .inputFluids(SiliconFluoride.getFluid(1000))
                .outputItems(dust, Silicon)
                .outputFluids(Fluorine.getFluid(4000))
                .save(provider);

        // CF4 -> C + 4F
        ELECTROLYZER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(120)
                .inputFluids(CarbonFluoride.getFluid(1000))
                .outputItems(dust, Carbon)
                .outputFluids(Fluorine.getFluid(4000))
                .save(provider);

        // BaSO4 + H2O -> [BaSO4 + H2O]
        MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputItems(dust, Barite)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(BariumSulfateSolution.getFluid(1000))
                .save(provider);

        // CaCO3 + H2O -> [CaCO3 + H2O]
        MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputItems(dust, Calcite)
                .circuitMeta(0)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(CalciumCarbonateSolution.getFluid(1000))
                .save(provider);

        // Bentonite + Clay + 2H2O -> 2[H2O + 0.5 Bentonite + 0.5 Clay]
        MIXER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(120).EUt(30)
                .inputItems(dust, Bentonite)
                .inputItems(dust, Clay)
                .inputFluids(Water.getFluid(2000))
                .outputFluids(BentoniteClaySlurry.getFluid(2000))
                .save(provider);

        // Fe + 3HCl -> FeCl3 + 3H
        /*CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(30)
                .inputItems(dust, Iron)
                .inputFluids(HydrochloricAcid.getFluid(3000))
                .outputFluids(Iron3Chloride.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(3000))
                .save(provider);*/

        // LiCl -> Li + Cl
        ELECTROLYZER_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(110).EUt(120)
                .inputItems(LithiumChloride,2)
                .outputFluids(Chlorine.getFluid(1000))
                .outputItems(dust, Lithium)
                .save(provider);

        // Li + Cl -> LiCl
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(125).EUt(120)
                .inputItems(dust, Lithium)
                .inputFluids(Chlorine.getFluid(1000))
                .circuitMeta(1)
                .outputItems(LithiumChloride,2)
                .save(provider);

        // Al + 3Cl -> AlCl3
        CHEMICAL_RECIPES.recipeBuilder("misc_recipes_" + chainNumber++).duration(100).EUt(30)
                .inputItems(dust, Aluminium)
                .inputFluids(Chlorine.getFluid(3000))
                .circuitMeta(1)
                .outputItems(AluminiumChloride,4)
                .save(provider);
    }
}

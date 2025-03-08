package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dustSmall;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class TaraniumChain {
    static int chainNumber = 1;
    public static void init(Consumer<FinishedRecipe> provider) {

        MIXER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(dust, Stone, 24)
                .inputFluids(HydrofluoricAcid.getFluid(6000))
                .outputFluids(DirtyHexafluorosilicicAcid.getFluid(3000))
                .duration(40)
                .EUt(100)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(DirtyHexafluorosilicicAcid.getFluid(3000))
                .outputFluids(DiluteHexafluorosilicicAcid.getFluid(3000))
                .outputItems(StoneResidueDust,12)
                .duration(40)
                .EUt(100)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(DiluteHexafluorosilicicAcid.getFluid(3000))
                .outputFluids(Water.getFluid(2000))
                .outputFluids(FluorosilicicAcid.getFluid(1000))
                .duration(160)
                .EUt(200)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(dust, StoneResidueDust,24)
                .inputFluids(SodiumHydroxideSolution.getFluid(1000))
                .outputItems(dust, UncommonResidues)
                .outputItems(dustSmall, Magnetite)
                .outputFluids(SodiumHydroxideSolution.getFluid(925))
                .outputFluids(RedMud.getFluid(75))
                .duration(40)
                .EUt(100)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(Oxygen.getFluid(FluidStorageKeys.LIQUID, 2000))
                .inputFluids(LiquidFluorine.getFluid(2000))
                .notConsumable(MICROFOCUS_X_RAY_TUBE)
                .outputFluids(Dioxygendifluoride.getFluid(1000))
                .duration(80)
                .EUt(200)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(UncommonResidues)
                .inputFluids(Dioxygendifluoride.getFluid(1000))
                .outputItems(PartiallyOxidizedResidues)
                .duration(80)
                .EUt(100)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(DistilledWater.getFluid(10000))
                .inputItems(PartiallyOxidizedResidues,10)
                .outputFluids(OxidizedResidualSolution.getFluid(10000))
                .outputItems(InertResidues)
                .duration(200)
                .EUt(100)
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(OxidizedResidualSolution.getFluid(2000))
                .outputItems(OxidizedResidues)
                .outputItems(HeavyOxidizedResidues)
                .duration(80)
                .EUt(3000)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(OxidizedResidues,10)
                .inputFluids(Hydrogen.getFluid(60000))
                .outputItems(MetallicResidues)
                .outputFluids(DiluteHydrofluoricAcid.getFluid(40000))
                .duration(1600)
                .EUt(2000)
                .blastFurnaceTemp(3500)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(HeavyOxidizedResidues,10)
                .inputFluids(Hydrogen.getFluid(60000))
                .outputItems(HeavyMetallicResidues)
                .outputFluids(DiluteHydrofluoricAcid.getFluid(40000))
                .duration(1600)
                .EUt(2000)
                .blastFurnaceTemp(3500)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(DiluteHydrofluoricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(1000))
                .duration(80)
                .EUt(200)
                .save(provider);

        LARGE_CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(MetallicResidues,10)
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .outputItems(DiamagneticResidues,3)
                .outputItems(ParamagneticResidues,3)
                .outputItems(FerromagneticResidues,3)
                .outputItems(UncommonResidues)
                .duration(80)
                .EUt(8000)
                .save(provider);

        LARGE_CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(HeavyMetallicResidues,10)
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .outputItems(HeavyDiamagneticResidues,3)
                .outputItems(HeavyParamagneticResidues,3)
                .outputItems(HeavyFerromagneticResidues,3)
                .outputItems(ExoticHeavyResidues)
                .duration(80)
                .EUt(8000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(FerromagneticResidues,6)
                .outputItems(dustSmall, Iron)
                .outputItems(dustSmall, Nickel)
                .outputItems(dustSmall, Cobalt)
                .duration(100)
                .EUt(3000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(DiamagneticResidues,6)
                .outputItems(dustSmall, Calcium)
                .outputItems(dustSmall, Zinc)
                .outputItems(dustSmall, Copper)
                .outputItems(dustSmall, Gallium)
                .outputItems(dustSmall, Beryllium)
                .outputItems(dustSmall, Tin)
                .duration(100)
                .EUt(3000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(ParamagneticResidues,6)
                .outputItems(dustSmall, Sodium)
                .outputItems(dustSmall, Potassium)
                .outputItems(dustSmall, Magnesium)
                .outputItems(dustSmall, Titanium)
                .outputItems(dustSmall, Vanadium)
                .outputItems(dustSmall, Manganese)
                .duration(100)
                .EUt(3000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(HeavyParamagneticResidues,6)
                .outputItems(dustSmall, Thorium)
                .outputItems(dustSmall, GTMaterials.Uranium238)
                .outputItems(dustSmall, Tungsten)
                .outputItems(dustSmall, Hafnium)
                .outputItems(dustSmall, Tantalum)
                .outputItems(dustSmall, Thallium)
                .duration(120)
                .EUt(3000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(HeavyDiamagneticResidues,6)
                .outputItems(dustSmall, Lead)
                .outputItems(dustSmall, Cadmium)
                .outputItems(dustSmall, Indium)
                .outputItems(dustSmall, Gold)
                .outputItems(dustSmall, Bismuth)
                .outputFluids(Mercury.getFluid(36))
                .duration(120)
                .EUt(3000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(HeavyFerromagneticResidues,6)
                .outputItems(dustSmall, Dysprosium)
                .duration(120)
                .EUt(3000)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(DistilledWater.getFluid(2000))
                .inputItems(ExoticHeavyResidues,16)
                .inputItems(dust, SodiumHydroxide, 3)
                .inputItems(PROTONATED_FULLERENE_SIEVING_MATRIX)
                .outputFluids(SodiumHydroxideSolution.getFluid(1000))
                .outputItems(SATURATED_FULLERENE_SIEVING_MATRIX)
                .duration(40)
                .EUt(2000000)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(InertResidues,10)
                .notConsumableFluid(FluoroantimonicAcid.getFluid(1))
                .outputItems(CleanInertResidues,10)
                .outputItems(dust, NaquadricCompound)
                .duration(320)
                .EUt(200)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(Tritium.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(1000))
                .outputFluids(TritiumHydride.getFluid(1000))
                .duration(160)
                .EUt(2000)
                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TritiumHydride.getFluid(10000))
                .outputFluids(Helium3Hydride.getFluid(100))
                .outputFluids(TritiumHydride.getFluid(9900))
                .duration(800)
                .EUt(200)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputItems(dust, CleanInertResidues)
                .inputFluids(Helium3Hydride.getFluid(1000))
                .outputFluids(UltraacidicResidueSolution.getFluid(1000))
                .duration(160)
                .EUt(2000)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(UltraacidicResidueSolution.getFluid(2000))
                .inputFluids(Oxygen.getFluid(FluidStorageKeys.LIQUID, 4000))
                .inputFluids(LiquidXenon.getFluid(1000))
                .outputFluids(XenicAcid.getFluid(1000))
                .outputFluids(DustyLiquidHelium3.getFluid(2000))
                .duration(120)
                .EUt(2000)
                .save(provider);

        // 2 H2XeO4 -> 2 Xe + H2O + H2O2 + O3 + 2 O
        ELECTROLYZER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(XenicAcid.getFluid(2000))
                .outputFluids(Xenon.getFluid(2000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Ozone.getFluid(1000))
                .outputFluids(HydrogenPeroxide.getFluid(1000))
                .outputFluids(Oxygen.getFluid(2000))
                .duration(120)
                .EUt(500)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(DustyLiquidHelium3.getFluid(1000))
                .outputFluids(TaraniumEnrichedLHelium3.getFluid(100))
                .outputFluids(TaraniumSemidepletedLHelium3.getFluid(300))
                .outputFluids(TaraniumDepletedLHelium3.getFluid(600))
                .duration(400)
                .EUt(3000)
                .save(provider);

        FUSION_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TaraniumEnrichedLHelium3.getFluid(1000))
                .inputFluids(Helium3.getFluid(1000))
                .outputFluids(TaraniumRichDustyHeliumPlasma.getFluid(3000))
                .duration(160)
                .EUt(7680)
                .fusionStartEU(480000000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TaraniumRichDustyHeliumPlasma.getFluid(3000))
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .outputFluids(TaraniumRichHelium4.getFluid(FluidStorageKeys.PLASMA,500))
                .outputFluids(Hydrogen.getFluid(FluidStorageKeys.PLASMA,2000))
                .outputFluids(TaraniumDepletedHeliumPlasma.getFluid(500))
                .duration(80)
                .EUt(2000)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(Helium3.getFluid(FluidStorageKeys.PLASMA,1000))
                .inputFluids(TaraniumDepletedLHelium3.getFluid(1000))
                .outputFluids(TaraniumDepletedHeliumPlasma.getFluid(2000))
                .duration(160)
                .EUt(2000)
                .save(provider);

        LARGE_CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TaraniumDepletedHeliumPlasma.getFluid(10000))
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .outputFluids(Helium3.getFluid(FluidStorageKeys.PLASMA,10000))
                .outputItems(CleanInertResidues,2)
                .duration(160)
                .EUt(2000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TaraniumSemidepletedLHelium3.getFluid(1000))
                .outputFluids(TaraniumEnrichedLHelium3.getFluid(100))
                .outputFluids(TaraniumDepletedLHelium3.getFluid(900))
                .duration(400)
                .EUt(3000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TaraniumRichHelium4.getFluid(400))
                .outputItems(dust, Taranium)
                .outputFluids(TaraniumPoorLiquidHelium.getFluid(400))
                .duration(20)
                .EUt(8000)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TaraniumPoorLiquidHelium.getFluid(1000))
                .inputFluids(LiquidHelium3.getFluid(200))
                .outputFluids(TaraniumPoorLiquidHeliumMix.getFluid(1200))
                .duration(80)
                .EUt(8000)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(TaraniumPoorLiquidHeliumMix.getFluid(1200))
                .outputFluids(Helium.getFluid(FluidStorageKeys.LIQUID, 1000))
                .outputFluids(DustyLiquidHelium3.getFluid(200))
                .duration(80)
                .EUt(8000)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,100))
                .inputFluids(TaraniumRichHelium4.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(TaraniumRichHelium4.getFluid(1000))
                .outputFluids(Helium.getFluid(100))
                .circuitMeta(1)
                .duration(80)
                .EUt(8000)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,100))
                .inputFluids(Hydrogen.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Helium.getFluid(100))
                .circuitMeta(1)
                .duration(80)
                .EUt(8000)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++).duration(30).EUt(480)
                .inputFluids(Fluorine.getFluid(1000))
                .outputFluids(LiquidFluorine.getFluid(1000))
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++).duration(30).EUt(480)
                .inputFluids(Xenon.getFluid(1000))
                .outputFluids(LiquidXenon.getFluid(1000))
                .save(provider);

        FLUID_HEATER_RECIPES.recipeBuilder("taranium_chain_" + chainNumber++)
                .inputFluids(Helium3.getFluid(1000))
                .outputFluids(Helium3.getFluid(FluidStorageKeys.PLASMA,1000))
                .circuitMeta(0)
                .duration(60)
                .EUt(8000)
                .save(provider);
    }
}

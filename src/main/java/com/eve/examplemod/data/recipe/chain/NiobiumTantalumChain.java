package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.List;
import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials.Color.Magenta;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
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

public class NiobiumTantalumChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // MnO2 + sugar(tiny) + H2SO4 -> + CO2 + MnSO4
        // weird, but probably fine
        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(340).EUt(120).blastFurnaceTemp(1500)
                .inputItems(dust, Pyrolusite, 3)
                .inputItems(dustTiny, Sugar)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(111))
                .outputItems(ManganeseSulfate,6)
                .save(provider);

        // MnCO3 + sugar(tiny) + H2SO4 -> CO2 + MnSO4
        // weird, but probably fine
        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(340).EUt(120).blastFurnaceTemp(1500)
                .inputItems(dust, Rhodocrosite, 5)
                .inputItems(dustTiny, Sugar)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1111))
                .outputItems(ManganeseSulfate,6)
                .save(provider);

        // MnSO4 -> Mn + S + 4O
        ELECTROLYZER_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(120).EUt(500)
                .inputItems(ManganeseSulfate,6)
                .outputItems(dust, Manganese)
                .outputItems(dust, Sulfur)
                .outputFluids(Oxygen.getFluid(4000))
                .save(provider);

        // SnO2 + C + H2O -> (SnO2)C
        MIXER_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(340).EUt(30)
                .inputItems(dust, Cassiterite, 2)
                .inputItems(dust, Coke)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputItems(CassiteriteCokePellets,5)
                .save(provider);

        // CokePellets -> CO2 + 2Sn + slag
        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(260).EUt(120).blastFurnaceTemp(1600)
                .inputItems(CassiteriteCokePellets,5)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(ingot, Tin, 2)
                .outputItems(TinSlag)
                .save(provider);

        // 6slag -> ash + ?
        CENTRIFUGE_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(180).EUt(120)
                .inputItems(TinSlag,6)
                .outputItems(dust, DarkAsh)
                .outputItems(NbTaContainingDust,4)
                .save(provider);

        // ? + C + SiO2 -> CO2 + FeSiO3 + (Nb2O5)(Ta2O5)
        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(260).EUt(120).blastFurnaceTemp(1600)
                .inputItems(NbTaContainingDust,4)
                .inputItems(dust, Carbon)
                .inputItems(dust, SiliconDioxide, 3)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(ingot, Ferrosilite, 5)
                .outputItems(NiobiumTantalumOxide,14)
                .save(provider);

        // 19HF + (Nb2O5)(Ta2O5) -> AlF3 + SiF4 + ? + 7.5H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(280).EUt(1920)
                .inputFluids(HydrofluoricAcid.getFluid(19000))
                .inputItems(NiobiumTantalumOxide,14)
                .outputItems(AluminiumTrifluoride,4)
                .outputFluids(SiliconFluoride.getFluid(1000))
                .outputFluids(NbTaFluorideMix.getFluid(1000))
                .outputFluids(Water.getFluid(7500))
                .save(provider);

        // BaO + O -> BaO2
        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(230).EUt(120).blastFurnaceTemp(2300)
                .inputItems(BariumOxide,2)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(BariumPeroxide,3)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(340).EUt(120).blastFurnaceTemp(3400)
                .inputItems(dust, Columbite)
                .inputItems(BariumPeroxide,3)
                .inputItems(dust, SodiumHydroxide, 3)
                .outputFluids(Water.getFluid(500))
                .outputItems(FusedColumbite,9)
                .outputItems(ColumbiteMinorOxideResidue,4)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(240).EUt(30)
                .inputItems(FusedColumbite,9)
                .inputFluids(SulfuricAcid.getFluid(4000))
                .outputItems(LeachedColumbite,17)
                .outputItems(IronSulfateDust,12)
                .outputItems(dust, SodiumSulfate, 14)
                .save(provider);

        // FeSO4 -> Fe + S + 4O
        ELECTROLYZER_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(400).EUt(120)
                .inputItems(IronSulfateDust,6)
                .outputItems(dust, Iron)
                .outputItems(dust, Sulfur)
                .outputFluids(Oxygen.getFluid(4000))
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(260).EUt(120)
                .inputItems(ColumbiteMinorOxideResidue,4)
                .outputItems(BariumOxide,2)
                .chancedOutput(dust, Cassiterite, 2, 1000, 75)
                .chancedOutput(dust, TungstenTrioxide, 4, 1000, 75)
                .chancedOutput(dust, Alumina,5, 1000, 75)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(180).EUt(480)
                .inputItems(LeachedColumbite,17)
                .inputFluids(HydrofluoricAcid.getFluid(10400))
                .outputFluids(FluoroniobicAcid.getFluid(2000))
                .outputFluids(Water.getFluid(3200))
                .save(provider);

        // MnTa2O6 + BaO2 + NaOH -> 0.5H2O + (Fe2O3)(NaO)Ta2O5 + (BaO)(ZrO2)(TiO2)(SiO2)
        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(340).EUt(120).blastFurnaceTemp(3400)
                .inputItems(dust, Tantalite, 5)
                .inputItems(BariumPeroxide,3)
                .inputItems(dust, SodiumHydroxide, 3)
                .outputFluids(Water.getFluid(1000))
                .outputItems(FusedTantalite,9)
                .outputItems(TantaliteMinorOxideResidue,4)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(240).EUt(120)
                .inputItems(FusedTantalite,9)
                .inputFluids(SulfuricAcid.getFluid(4000))
                .outputItems(LeachedTantalite,17)
                .outputItems(dust, SodiumSulfate, 14)
                .outputItems(ManganeseSulfate,12)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(260).EUt(480)
                .inputItems(TantaliteMinorOxideResidue,4)
                .outputItems(BariumOxide,2)
                .chancedOutput(dust, CubicZirconia, 3, 1000, 75)
                .chancedOutput(dust, Rutile, 3, 1000, 75)
                .chancedOutput(dust, SiliconDioxide, 3, 1000, 75)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(180).EUt(120)
                .inputItems(LeachedTantalite,17)
                .inputFluids(HydrofluoricAcid.getFluid(13600))
                .outputFluids(FluorotantalicAcid.getFluid(2000))
                .outputFluids(Water.getFluid(4800))
                .save(provider);

        // C12H27O4P + C6H12O -> C18H39O5P
        MIXER_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(220).EUt(30)
                .inputFluids(TributylPhosphate.getFluid(1000))
                .inputFluids(MethylIsobutylKetone.getFluid(1000))
                .outputFluids(NbTaSeparationMixture.getFluid(2000))
                .save(provider);

        BLAST_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(350).EUt(480).blastFurnaceTemp(2700)
                .inputItems(dust, Pyrochlore, 6)
                .inputFluids(SulfuricAcid.getFluid(2000))
                .outputItems(AcidicLeachedPyrochlore,6)
                .outputFluids(REEThUSulfateSolution.getFluid(1000))
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(240).EUt(480)
                .inputItems(AcidicLeachedPyrochlore,3)
                .inputFluids(HydrogenPeroxide.getFluid(3000))
                .inputFluids(SulfuricAcid.getFluid(12000))
                .outputFluids(HydrofluoricAcid.getFluid(13000))
                .outputFluids(AlkalineEarthSulfateSolution.getFluid(8000))
                .outputFluids(Oxygen.getFluid(3000))
                .outputItems(LeachedPyrochlore,3)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(180).EUt(120)
                .inputItems(LeachedPyrochlore)
                .inputFluids(HydrofluoricAcid.getFluid(10400))
                .outputFluids(FluoroniobicAcid.getFluid(2000))
                .outputFluids(Water.getFluid(3200))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(160).EUt(480)
                .inputFluids(REEThUSulfateSolution.getFluid(2000))
                .inputFluids(NitricAcid.getFluid(7000))
                .outputItems(UranylThoriumNitrate,26)
                .outputFluids(RareEarthNitrateSolution.getFluid(1000))
                .outputFluids(SulfuricAcid.getFluid(4000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(280).EUt(480)
                .inputFluids(RareEarthNitrateSolution.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(3000))
                .outputFluids(NitricAcid.getFluid(3000))
                .outputFluids(RareEarthChloridesSolution.getFluid(1000))
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(250).EUt(1920)
                .inputFluids(AlkalineEarthSulfateSolution.getFluid(4000))
                .outputFluids(Water.getFluid(4000))
                .outputItems(dust, Barite, 3)
                .outputItems(dust, Gypsum, 8)
                .outputItems(dust, Celestine, 6)
                .outputItems(dustSmall, Radium, 2)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(125).EUt(7680)
                .inputFluids(FluoroniobicAcid.getFluid(10000))
                .inputFluids(NbTaSeparationMixture.getFluid(1000))
                .outputFluids(OxypentafluoroNiobate.getFluid(9000))
                .outputFluids(HeptafluoroTantalate.getFluid(1000))
                .save(provider);

        // (H2NbOF5 + H2TaF7) -> H2NbOF5 + H2TaF7
        LARGE_CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(125).EUt(7680)
                .inputFluids(NbTaFluorideMix.getFluid(2000))
                .inputFluids(NbTaSeparationMixture.getFluid(200))
                .outputFluids(OxypentafluoroNiobate.getFluid(1000))
                .outputFluids(HeptafluoroTantalate.getFluid(1000))
                .save(provider);

        // 10HTaF7 -> H2NbOF5 + 9H2TaF7
        LARGE_CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(125).EUt(7680)
                .inputFluids(FluorotantalicAcid.getFluid(10000))
                .inputFluids(NbTaSeparationMixture.getFluid(1000))
                .outputFluids(OxypentafluoroNiobate.getFluid(1000))
                .outputFluids(HeptafluoroTantalate.getFluid(9000))
                .save(provider);

        // H2NbOF5 + 2KF -> K2NbF7 + H2O
        CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(170).EUt(120)
                .inputFluids(OxypentafluoroNiobate.getFluid(1000))
                .inputItems(dust, PotassiumFluoride, 4)
                .outputItems(PotasssiumFluoroNiobate,10)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // H2TaF7 + 2KOH -> K2TaF7 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(170).EUt(120)
                .inputFluids(HeptafluoroTantalate.getFluid(1000))
                .inputFluids(PotassiumHydroxide.getFluid(2000))
                .outputItems(PotasssiumFluoroTantalate,10)
                .outputFluids(Water.getFluid(2000))
                .save(provider);

        // K2NbF7 + 5Na -> 5NaF + 2KF + Nb
        ELECTROLYZER_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(120).EUt(120)
                .inputItems(PotasssiumFluoroNiobate,10)
                .inputFluids(Sodium.getFluid(5000))
                .outputItems(dust, SodiumFluoride, 10)
                .outputItems(dust, PotassiumFluoride, 4)
                .outputItems(dust, Niobium)
                .save(provider);

        // K2TaF7 + 5Na -> 5NaF + 2KF + Ta
        ELECTROLYZER_RECIPES.recipeBuilder("niobium_tantalum_chain_" + chainNumber++).duration(170).EUt(120)
                .inputItems(PotasssiumFluoroTantalate,10)
                .inputFluids(Sodium.getFluid(5000))
                .outputItems(dust, SodiumFluoride, 10)
                .outputItems(dust, PotassiumFluoride, 4)
                .outputItems(dust, Tantalum)
                .save(provider);
    }
}

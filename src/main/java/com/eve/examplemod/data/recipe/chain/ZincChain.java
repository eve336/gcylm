package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;
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

public class ZincChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // ZnS + C + H2O = [ZnS + C + H2O]
        MIXER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(50).EUt(120)
                .inputItems(dust, Sphalerite)
                .inputItems(dust, Coke)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputItems(dust, ZincCokePellets,3)
                .save(provider);

        // 2[ZnS + C + H2O] + 6O = 2ZnO + Zinc Residual Slag + Zinc Exhaust [Contains: Dark Ash + CO2 + SO2]
        BLAST_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(120).EUt(120).blastFurnaceTemp(1500)
                .inputItems(dust, ZincCokePellets,6)
                .inputFluids(Oxygen.getFluid(6000))
                .outputItems(dust, Zincite, 4)
                .outputItems(dust, ZincResidualSlag)
                .circuitMeta(1)
                .outputFluids(ZincExhaustMixture.getFluid(1000))
                .save(provider);

        // ZnO + 2H2SO4 = ZnSO4 + ZincLeachingResidue [Contains: (H2O)(H2SO4)]
        CHEMICAL_BATH_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(40).EUt(480)
                .inputItems(dust, Zincite, 2)
                .inputFluids(SulfuricAcid.getFluid(2000))
                .outputItems(dust, ZincSulfate, 6)
                .outputItems(dust, ZincLeachingResidue)
                .save(provider);

        // Zinc Exhaust = Dark Ash + Zinc Flue Dust + CO2 + SO2
        CENTRIFUGE_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(140).EUt(120)
                .inputFluids(ZincExhaustMixture.getFluid(1000))
                .chancedOutput(dust, ZincFlueDust, 4500, 750)
                .outputItems(dustSmall, DarkAsh)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputFluids(SulfurDioxide.getFluid(1000))
                .save(provider);

        // Zinc Residual Slag = Fine Zinc Slag Dust
        MACERATOR_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(80).EUt(120)
                .inputItems(dust, ZincResidualSlag)
                .outputItems(dust, FineZincSlagDust)
                .save(provider);

        // Fine Zinc Slag Dust + H2O = Zinc Slag Slurry [Contains: Fine Zinc Slag Dust + H2O]
        MIXER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(80).EUt(30)
                .inputItems(dust, FineZincSlagDust)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(ZincSlagSlurry.getFluid(1000))
                .save(provider);

        // [Fine Zinc Slag Dust + H2O] = Metal Rich Slag Slurry [Contains: H2O] + Zinc ResidualS lag
        ELECTROLYZER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(130).EUt(30)
                .inputFluids(ZincSlagSlurry.getFluid(1000))
                .outputFluids(MetalRichSlagSlurry.getFluid(1000))
                .chancedOutput(dust, ZincResidualSlag, 2500, 0)
                .save(provider);

        // Metal Rich Slag Slurry [Contains: H2O] + H3PO4 = Acidic Metal Slurry [Contains: H2O + H3PO4]
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(140).EUt(30)
                .inputFluids(MetalRichSlagSlurry.getFluid(1000))
                .inputFluids(PhosphoricAcid.getFluid(1000))
                .outputFluids(AcidicMetalSlurry.getFluid(1000))
                .save(provider);

        // 2 Acidic Metal Slurry [Contains: H2O + H3PO4] + H3PO4 = Separated Metal Slurry [Contains: 3 H3PO4 + H2O] + Metal Rich Slag Slurry [Contains: H2O]
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(180).EUt(30)
                .inputFluids(AcidicMetalSlurry.getFluid(2000))
                .inputFluids(PhosphoricAcid.getFluid(1000))
                .outputFluids(SeparatedMetalSlurry.getFluid(1000))
                .outputFluids(MetalRichSlagSlurry.getFluid(1000))
                .save(provider);

        // Separated Metal Slurry [Contains: 3 H3PO4 + H2O] + 2NaOH = Metal Hydroxide Mix + Na2HPO4 + 2H2O
        // 3 H3PO4 + 6 NaOH + H2O = 3 Na2HPO4 + 7 H2O
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(150).EUt(30)
                .inputFluids(SeparatedMetalSlurry.getFluid(1000))
                .inputItems(dust, SodiumHydroxide, 6)
                .outputFluids(MetalHydroxideMix.getFluid(1000))
                .outputFluids(Water.getFluid(7000))
                .outputItems(DisodiumPhosphate,24)
                .save(provider);

        // Na2HPO4 = H + 4O + P + 2Na
        ELECTROLYZER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(50).EUt(120)
                .inputItems(DisodiumPhosphate,8)
                .outputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Oxygen.getFluid(4000))
                .outputItems(dust, Phosphorus)
                .outputItems(dust, Sodium, 2)
                .save(provider);

        // Metal Hydroxide Mix = 0.25Zn + Zinc Poor Mix
        //
        // People were regularly confused about these three recipes, as it essentially just gave 0.5 of the metal per
        // recipe, so I changed it to not consume the fine wire, and output 2 Small Dusts of the metal instead.
        ELECTROLYZER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(130).EUt(120)
                .inputFluids(MetalHydroxideMix.getFluid(1000))
                .notConsumable(wireFine, Zinc)
                .outputItems(dustSmall, Zinc, 2)
                .outputFluids(ZincPoorMix.getFluid(1000))
                .save(provider);

        // Zinc Poor Mix = 0.25Fe + Iron Poor Mix
        ELECTROLYZER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(130).EUt(120)
                .inputFluids(ZincPoorMix.getFluid(1000))
                .notConsumable(wireFine, Iron)
                .outputItems(dustSmall, Iron, 2)
                .outputFluids(IronPoorMix.getFluid(1000))
                .save(provider);

        // Iron Poor Mix = 0.25Cu + Indium Hydroxide Concentrate [Contains: In(OH)3]
        ELECTROLYZER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(50).EUt(480)
                .inputFluids(IronPoorMix.getFluid(1000))
                .notConsumable(wireFine, Copper)
                .outputItems(dustSmall, Copper, 2)
                .outputFluids(IndiumHydroxideConcentrate.getFluid(1000))
                .save(provider);

        // Indium Hydroxide Concentrate [Contains: In(OH)3] = In(OH)3
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(230).EUt(120)
                .inputFluids(IndiumHydroxideConcentrate.getFluid(1000))
                .outputItems(dust, IndiumHydroxide,7)
                .save(provider);

        // In(OH)3 + 3H = In + 3H2O
        BLAST_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(240).EUt(120)
                .blastFurnaceTemp(4500)
                .inputItems(dust, IndiumHydroxide,7)
                .inputFluids(Hydrogen.getFluid(3000))
                .outputItems(dust, Indium)
                .outputFluids(Steam.getFluid(3000))
                .save(provider);

        // Zinc Flue Dust + H2SO4 = Cadmium Zinc Dust [Contains: Cd + Zn + H2SO4]
        CHEMICAL_BATH_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(180).EUt(960)
                .inputItems(dust, ZincFlueDust)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, CadmiumZincDust,3)
                .save(provider);

        // Cadmium Zinc Dust [Contains: Cd + Zn + H2SO4] + Hg = Cadmium Thallium Liquor [Contains: Cd + Tl + H2SO4] + Zinc Amalgam [Contains: Zn + Hg]
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(140).EUt(120)
                .inputItems(dust, CadmiumZincDust,3)
                .inputFluids(Mercury.getFluid(1000))
                .outputFluids(CadmiumThalliumLiquor.getFluid(1000))
                .outputFluids(ZincAmalgam.getFluid(1000))
                .save(provider);

        // Zinc Amalgam [Contains: Zn + Hg] = Zn + Hg
        CENTRIFUGE_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(220).EUt(120)
                .inputFluids(ZincAmalgam.getFluid(1000))
                .outputFluids(Mercury.getFluid(1000))
                .chancedOutput(dust, Zinc, 6500, 550)
                .save(provider);

        // 9 Cadmium Thallium Liquor [Contains: Cd + Tl + H2SO4] = Thallium Residue [Contains: 2 Tl] + 9 Cadmium Sulfate Solution [Contains: CdSO4]
        CENTRIFUGE_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(110).EUt(1920)
                .inputFluids(CadmiumThalliumLiquor.getFluid(9000))
                .outputItems(dust, ThalliumResidue)
                .outputFluids(CadmiumSulfateSolution.getFluid(9000))
                .save(provider);

        // 9 Cadmium Sulfate Solution [Contains: CdSO4] = 9 H2SO4 + Cd
        ELECTROLYZER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(110).EUt(120)
                .inputFluids(CadmiumSulfateSolution.getFluid(9000))
                .outputFluids(SulfuricAcid.getFluid(9000))
                .outputItems(dust, Cadmium)
                .save(provider);

        // Thallium Residue [Contains: 2 Tl] + H2SO4 = Thallium Sulfate Solution [Contains: Tl2SO4]
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(120).EUt(120)
                .inputItems(dust, ThalliumResidue)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(ThalliumSulfateSolution.getFluid(1000))
                .save(provider);

        // Thallium Sulfate Solution [Contains: Tl2SO4 + H2O] + 2 HCl  = 2TlCl + H2SO4 + H2O (because solution)
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(230).EUt(120)
                .inputFluids(ThalliumSulfateSolution.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputItems(dust, ThalliumChloride,4)
                .outputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // 2TlCl + Zn = 2Tl + ZnCl2
        BLAST_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(240).EUt(120).blastFurnaceTemp(750)
                .inputItems(ThalliumChloride,4)
                .inputItems(dust, Zinc)
                .outputItems(dust, Thallium, 2)
                .outputItems(dust, ZincChloride,3)
                .save(provider);

        // ZnCl2 = Zn + 2Cl
        ELECTROLYZER_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, ZincChloride,3)
                .outputItems(dust, Zinc)
                .outputFluids(Chlorine.getFluid(2000))
                .save(provider);

        // Na2CO3 + SO2 = Na2SO3 + CO2
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(70).EUt(30)
                .inputItems(dust, SodaAsh, 6)
                .inputFluids(SulfurDioxide.getFluid(1000))
                .outputItems(dust, SodiumSulfite,6)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // 2 Wood + Na2SO4 + H2O2 + [NaOH + H2O] = 2C6H10O5 + Polyphenol Mix
        // This recipe is close enough
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(90).EUt(30)
                .inputItems(dust, Wood, 2)
                .inputItems(dust, SodiumSulfite,6)
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .inputFluids(SodiumHydroxideSolution.getFluid(1000))
                .outputItems(dust, Cellulose,42)
                .outputFluids(PolyphenolMix.getFluid(1000))
                .save(provider);

//        FORMING_PRESS_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(250).EUt(30)
//                .inputItems(Cellulose)
//                .notConsumable(SHAPE_MOLD_PLATE)
//                .outputItems(new ItemStack(Items.PAPER))
//                .save(provider);

        // Polyphenol Mix = Acidified Polyphenol Mix
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(200).EUt(30)
                .inputFluids(PolyphenolMix.getFluid(1000))
                .notConsumableFluid(HydrochloricAcid.getFluid(0))
                .outputFluids(AcidifiedPolyphenolMix.getFluid(1000))
                .save(provider);

        // 2C2H5OH = (C2H5)2O + H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(120).EUt(750)
                .inputFluids(Ethanol.getFluid(2000))
                .notConsumableFluid(SulfuricAcid.getFluid(0))
                .circuitMeta(1)
                .outputFluids(Diethylether.getFluid(1000))
                .save(provider);

        // 0.5(C2H5)2O + Acidified Polyphenol Mix = 1 Tannic Acid + 0.5 Wood Tar
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(100).EUt(120)
                .inputFluids(Diethylether.getFluid(500))
                .inputFluids(AcidifiedPolyphenolMix.getFluid(1000))
                .outputFluids(TannicAcid.getFluid(1000))
                .outputFluids(WoodTar.getFluid(500))
                .save(provider);

        // ZincLeachingResidue [Contains: (H2O)(H2SO4)] -> FeSO4 + 0.5H4GeO4
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(100).EUt(480)
                .inputItems(dust, ZincLeachingResidue)
                .notConsumableFluid(TannicAcid.getFluid(1))
                .outputItems(IronSulfateDust,6)
                .outputFluids(GermanicAcidSolution.getFluid(500))
                .save(provider);

        // H4GeO4 + 4HCl = [GeCl4 + 4H2O]
        CHEMICAL_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(130).EUt(120)
                .inputFluids(GermanicAcidSolution.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(GermaniumChloride.getFluid(1000))
                .save(provider);

        // [GeCl4 + 4H2O] = 4HCl + GeO2 + 2H2O (lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(60).EUt(1920)
                .inputFluids(GermaniumChloride.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(4000))
                .outputItems(dust, GermaniumOxide,3)
                .save(provider);

        // GeO2 + 4H = Ge + 2H2O
        BLAST_RECIPES.recipeBuilder("zinc_chain_" + chainNumber++).duration(220).EUt(120).blastFurnaceTemp(1300)
                .inputItems(dust, GermaniumOxide,3)
                .inputFluids(Hydrogen.getFluid(4000))
                .outputItems(dust, Germanium)
                .outputFluids(Water.getFluid(2000))
                .save(provider);
    }
}

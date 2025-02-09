package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.PdCCatalyst;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class ZirconChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // Ba + H2O2 = Ba(OH)2
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(125).EUt(480)
                .inputItems(dust, Barium)
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .outputItems(BariumHydroxide,5)
                .save(provider);

        // 2C3H6O = C6H10O + H2O
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(100).EUt(120)
                .notConsumable(dust, BariumHydroxide)
                .inputFluids(Acetone.getFluid(2000))
                .outputFluids(MesitylOxide.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // C6H10O + C + H2O = C6H12O + CO
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(130).EUt(480)
                .notConsumable(dust, PdCCatalyst)
                .inputItems(dust, Carbon)
                .inputFluids(MesitylOxide.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(MethylIsobutylKetone.getFluid(1000))
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .save(provider);

        // S + HCN = HSCN
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(100).EUt(120)
                .inputItems(dust, Sulfur)
                .inputFluids(HydrogenCyanide.getFluid(1000))
                .outputFluids(ThiocyanicAcid.getFluid(1000))
                .save(provider);

        // C6H12O + HSCN = [C6H12O + HSCN]
        MIXER_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(80).EUt(120)
                .inputFluids(MethylIsobutylKetone.getFluid(1000))
                .inputFluids(ThiocyanicAcid.getFluid(1000))
                .outputFluids(ZrHfSeparationMix.getFluid(2000))
                .save(provider);

        // ZrSiO4 + 8Cl = ZrHfCl4 + SiCl4?
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(120).EUt(120)
                .inputItems(dust, Zircon, 6)
                .inputFluids(Chlorine.getFluid(4000))
                .outputFluids(ZrHfChloride.getFluid(1000))
                .outputFluids(ZirconChlorinatingResidue.getFluid(1000))
                .save(provider);

        // SiCl4? = SiCl4 + Co + RareEarth
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(140).EUt(120)
                .inputFluids(ZirconChlorinatingResidue.getFluid(1000))
                .outputItems(SiliconChloride,5)
                .chancedOutput(dust, Cobalt, 7500, 450)
                .chancedOutput(dust, RareEarth, 200, 20)
                .save(provider);

        // SiCl4 = Si + 4Cl
        ELECTROLYZER_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(240).EUt(120)
                .inputItems(SiliconChloride,5)
                .outputItems(dust, Silicon)
                .outputFluids(Chlorine.getFluid(4000))
                .save(provider);

        // ZrHfCl4 + H2O = Cl2HfOZr + 2HCl
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(100).EUt(480)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(ZrHfChloride.getFluid(1000))
                .outputFluids(ZrHfOxyChloride.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // todo what the fucl?
        // 3Cl2HfOZr + 3HClO + 3H2SO4 + 15NH3 + 3H2O2 = 9NH4Cl + 3(NH4)2SO4 + 3ZrO2 + 3HfO2 (THIS IS TOO BIG)
        // 3Cl2HfOZr + 3H2SO4 + 6NH4Cl + 9O = 3(NH4)2SO4 + 6HCl + 6Cl + 3ZrO2 + 3HfO2 (THIS FITS)
        // 3Cl2HfOZr + 3SO3 + 6NH4Cl + 6H2O2 = 3(NH4)2SO4 + 12HCl + 3ZrO2 + 3HfO2 (CURRENTLY USING)
        LARGE_CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(100).EUt(1920)
                .inputFluids(ZrHfOxyChloride.getFluid(3000))
                .inputFluids(SulfurTrioxide.getFluid(3000))
                .inputFluids(AmmoniumChloride.getFluid(6000))
                .inputFluids(HydrogenPeroxide.getFluid(6000))
                .notConsumableFluid(ZrHfSeparationMix.getFluid(0))
                .outputFluids(AmmoniumSulfate.getFluid(3000))
                .outputFluids(HydrochloricAcid.getFluid(12000))
                .outputItems(dust, CubicZirconia, 3)
                .chancedOutput(dust, HafniumOxide,3, 1000, 0)
                .save(provider);

        // C + 4Cl + ZrO2 = CO2 + ZrCl4
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(150).EUt(480)
                .inputItems(dust, Carbon)
                .inputFluids(Chlorine.getFluid(4000))
                .inputItems(dust, CubicZirconia, 3)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(ZirconiumTetrachloride,5)
                .save(provider);

        // ZrCl4 + 2Mg = Zr + 2MgCl2
        BLAST_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(300).EUt(120).blastFurnaceTemp(2500)
                .inputItems(dust, ZirconiumTetrachloride,5)
                .inputItems(dust, Magnesium, 2)
                .outputItems(dust, Zirconium)
                .outputItems(dust, MagnesiumChloride, 6)
                .save(provider);

        // C + 4Cl + HfO2 = CO2 + HfCl4
        CHEMICAL_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(150).EUt(120)
                .inputItems(dust, Carbon)
                .inputFluids(Chlorine.getFluid(4000))
                .inputItems(dust, HafniumOxide,3)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(dust, HafniumChloride,5)
                .save(provider);

        // HfCl4 + 2Mg = Hf + 2MgCl2
        BLAST_RECIPES.recipeBuilder("zircon_chain_" + chainNumber++).duration(300).EUt(120).blastFurnaceTemp(2500)
                .inputItems(dust, HafniumChloride,5)
                .inputItems(dust, Magnesium, 2)
                .outputItems(dust, Hafnium)
                .outputItems(dust, MagnesiumChloride, 6)
                .save(provider);
    }
}

package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class AluminiumChain {
        public static void init(Consumer<FinishedRecipe> provider) {

            // 2Al(OH)3 -> Al2O3 + 3H2O
            BLAST_RECIPES.recipeBuilder("aluminium_chain_1").duration(200).EUt(120).blastFurnaceTemp(1100)
                    .inputItems(dust, AluminiumHydroxide, 14)
                    .outputItems(dust, Alumina,5)
                    .outputFluids(Water.getFluid(3000))
                    .save(provider);

            // 6NaOH + Al2O3 + 12HF -> 2Na3AlF6 + 9H2O
            CHEMICAL_RECIPES.recipeBuilder("aluminium_chain_2").duration(400).EUt(120)
                    .inputItems(dust, SodiumHydroxide, 18)
                    .inputItems(dust, Alumina, 5)
                    .inputFluids(HydrofluoricAcid.getFluid(12000))
                    .outputFluids(SodiumHexafluoroaluminate.getFluid(2000))
                    .outputFluids(Water.getFluid(9000))
                    .save(provider);

// 2Al2O3 + Na3AlF6 -> 4Al + 3NaF + AlF3 + 6O
            ELECTROLYZER_RECIPES.recipeBuilder("aluminium_chain_3").duration(200).EUt(120)
                    .inputItems(dust, Alumina, 10)
                    .inputFluids(SodiumHexafluoroaluminate.getFluid(1000))
                    .outputFluids(Oxygen.getFluid(6000))
                    .outputItems(dust, Aluminium, 4)
                    .outputItems(dust, SodiumFluoride, 6)
                    .outputItems(dust, AluminiumTrifluoride, 4)
                    .save(provider);

// 3NaF + AlF3 -> Na3AlF6
            CHEMICAL_RECIPES.recipeBuilder("aluminium_chain_4").duration(200).EUt(120)
                    .inputItems(dust, SodiumFluoride, 6)
                    .inputItems(dust, AluminiumTrifluoride, 4)
                    .outputFluids(SodiumHexafluoroaluminate.getFluid(1000))
                    .save(provider);

// 24[H2O + NaOH] + (TiO2)2Al16H10O29 -> [24H2O + 24NaOH + (TiO2)2Al16H10O29 + ?]
            MIXER_RECIPES.recipeBuilder("aluminium_chain_5").duration(240).EUt(30)
                    .inputFluids(SodiumHydroxideSolution.getFluid(24000))
                    .inputItems(dust, Bauxite, 39)
                    .outputFluids(SodiumHydroxideBauxite.getFluid(24000))
                    .save(provider);

// [24H2O + 24NaOH + (TiO2)2Al16H10O29 + ?] = [4TiO2 + 16Al(OH)3 + 24NaOH + 5 H2O]
            FLUID_HEATER_RECIPES.recipeBuilder("aluminium_chain_6").duration(30).EUt(30)
                    .circuitMeta(0)
                    .inputFluids(SodiumHydroxideBauxite.getFluid(1000))
                    .outputFluids(ImpureAluminiumHydroxideSolution.getFluid(1000))
                    .save(provider);

// [4TiO2 + 16Al(OH)3 + 24NaOH + 5 H2O] + 9 H2O = 8 Red Mud + 8 [2 Al(OH)3 + H2O]
            CHEMICAL_RECIPES.recipeBuilder("aluminium_chain_7").duration(230).EUt(120)
                    .inputFluids(Water.getFluid(9000))
                    .inputFluids(ImpureAluminiumHydroxideSolution.getFluid(24000))
                    .outputFluids(RedMud.getFluid(8000))
                    .outputFluids(PureAluminiumHydroxideSolution.getFluid(16000))
                    .save(provider);

// [2 Al(OH)3 + H2O] = 2 Al(OH)3 + H2O
            CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("aluminium_chain_8").duration(240).EUt(120)
                    .inputFluids(PureAluminiumHydroxideSolution.getFluid(1000))
                    .circuitMeta(0)
                    .outputItems(dust, AluminiumHydroxide, 14)
                    .save(provider);

// [2 Al(OH)3 + H2O] = 2 Al(OH)3 + H2O
            CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("aluminium_chain_9").duration(240).EUt(240)
                    .inputFluids(PureAluminiumHydroxideSolution.getFluid(4000))
                    .circuitMeta(1)
                    .outputItems(dust, AluminiumHydroxide, 56)
                    .save(provider);

// 8 Red Mud + 36 HCl = 8 Neutralized Mud
            MIXER_RECIPES.recipeBuilder("aluminium_chain_10").duration(100).EUt(120)
                    .inputFluids(RedMud.getFluid(1000))
                    .inputFluids(HydrochloricAcid.getFluid(4500))
                    .outputFluids(NeutralisedRedMud.getFluid(2000))
                    .save(provider);

// 8 Neutralized Mud = 4 Red Slurry + 4 Ferric REE Chloride + 24 NaCl + H2O
            CENTRIFUGE_RECIPES.recipeBuilder("aluminium_chain_11").duration(100).EUt(120)
                    .inputFluids(NeutralisedRedMud.getFluid(2000))
                    .outputFluids(RedSlurry.getFluid(1000))
                    .outputFluids(FerricREEChloride.getFluid(1000))
                    .outputFluids(SaltWater.getFluid(6000))
                    .save(provider);

// 4 Ferric REE Chloride = 2 Rare Earth Chlorides + 2 Iron III Chloride + 6 H2O
            CENTRIFUGE_RECIPES.recipeBuilder("aluminium_chain_12").duration(320).EUt(480)
                    .inputFluids(FerricREEChloride.getFluid(2000))
                    .outputFluids(RareEarthChloridesSolution.getFluid(1000))
                    .outputFluids(Iron3Chloride.getFluid(1000))
                    .outputFluids(Water.getFluid(3000))
                    .save(provider);

// 4 Red Slurry + 4 H2SO4 = 4 TiO(SO4) + 4H2O
            CHEMICAL_RECIPES.recipeBuilder("aluminium_chain_13").duration(160).EUt(120)
                    .inputFluids(RedSlurry.getFluid(2000))
                    .inputFluids(SulfuricAcid.getFluid(2000))
                    .outputFluids(TitanylSulfate.getFluid(2000))
                    .outputFluids(Water.getFluid(2000))
                    .save(provider);

// TiO(SO4) + 4HCl = TiCl4 + H2SO4 + H2O
            CHEMICAL_RECIPES.recipeBuilder("aluminium_chain_14").duration(160).EUt(960)
                    .inputFluids(TitanylSulfate.getFluid(1000))
                    .inputFluids(HydrochloricAcid.getFluid(4000))
                    .outputFluids(TitaniumTetrachloride.getFluid(1000))
                    .outputFluids(SulfuricAcid.getFluid(2100))
                    .save(provider);


        }
}

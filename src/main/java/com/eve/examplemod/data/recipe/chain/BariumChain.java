package com.eve.examplemod.data.recipe.chain;


import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class BariumChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        // Ba + 2HCl -> BaCl2 + 2H
        CHEMICAL_RECIPES.recipeBuilder("barium_chain_0").duration(100).EUt(120)
                .inputItems(dust, Barium)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputItems(dust, BariumChloride, 3)
                .outputFluids(Hydrogen.getFluid(2000))
                .save(provider);

        // BaCl2 + H2SO4 -> BaSO4 + HCl
        CHEMICAL_RECIPES.recipeBuilder("barium_chain_1").duration(50).EUt(480)
                .inputItems(dust,BariumChloride, 3)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, Barite, 6)
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // BaSO4 + 2C -> BaS + 2CO2
        BLAST_RECIPES.recipeBuilder("barium_chain_2").duration(220).EUt(120).blastFurnaceTemp(1200)
                .inputItems(dust, Barite, 6)
                .inputItems(dust, Carbon, 2)
                .outputItems(dust, BariumSulfide, 2)
                .outputFluids(CarbonDioxide.getFluid(2000))
                .save(provider);

        // BaS + H2O + CO2 -> BaCO3 + H2S
        CHEMICAL_RECIPES.recipeBuilder("barium_chain_3").duration(280).EUt(30)
                .inputItems(dust,BariumSulfide, 2)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(dust, BariumCarbonate, 5)
                .outputFluids(HydrogenSulfide.getFluid(1000))
                .save(provider);

        // BaCO3 -> CO2 + BaO
        CHEMICAL_RECIPES.recipeBuilder("barium_chain_4").duration(100).EUt(30)
                .inputItems(dust,BariumCarbonate, 5)
                .circuitMeta(0)
                .outputItems(dust, BariumOxide, 2)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // BaO -> Ba + O
        ELECTROLYZER_RECIPES.recipeBuilder("barium_chain_5").duration(220).EUt(30)
                .inputItems(dust,BariumOxide, 2)
                .outputItems(dust, Barium)
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

        // 4BaO + 2Al -> 3Ba + Al2BaO4
        BLAST_RECIPES.recipeBuilder("barium_chain_5").duration(180).EUt(120).blastFurnaceTemp(700)
                .inputItems(dust,BariumOxide, 8)
                .inputItems(dust, Aluminium, 2)
                .outputItems(ingot, Barium, 3)
                .outputItems(dust, BariumAluminate, 7)
                .save(provider);

        // 2Al2BaO4 -> BaO + Al2O3
        CENTRIFUGE_RECIPES.recipeBuilder("barium_chain_6").duration(300).EUt(30)
                .inputItems(dust, BariumAluminate, 14)
                .outputItems(dust, BariumOxide, 2)
                .outputItems(dust, Alumina, 5)
                .save(provider);

        // NEW BARIUM-HOLDING ORES

        // BaCa(CO3)2 + H2SO4 -> BaSO4 + (H2O)CaCO3 + CO2
        CHEMICAL_RECIPES.recipeBuilder("barium_chain_7").duration(100).EUt(30)
                .inputItems(dust, Barytocalcite, 10)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, Barite, 6)
                .outputFluids(CalciumCarbonateSolution.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // (H20)CaCO3 -> H2O + CaCO3
        CENTRIFUGE_RECIPES.recipeBuilder("barium_chain_8").duration(200).EUt(30)
                .inputFluids(CalciumCarbonateSolution.getFluid(1000))
                .outputItems(dust, Calcite, 5)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // BaCa(CO3)2 -> BaCO3 + CaCO3
        ELECTROLYZER_RECIPES.recipeBuilder("barium_chain_9").duration(1040).EUt(60)
                .inputItems(dust, Barytocalcite, 10)
                .outputItems(dust, BariumCarbonate, 5)
                .outputItems(dust, Calcite, 5)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("barium_chain_10").duration(50).EUt(80)
                .inputItems(dust, Witherite, 5)
                .outputItems(dust, BariumCarbonate, 5)
                .chancedOutput(ChemicalHelper.get(dustTiny, Calcite), 9000, 150)
                .chancedOutput(ChemicalHelper.get(dustTiny, Galena), 7000, 120)
                .chancedOutput(ChemicalHelper.get(dustTiny, Barite), 4000, 90)
                .save(provider);
    }
}

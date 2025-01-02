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

public class SeleniumChain {
    public static void init(Consumer<FinishedRecipe> provider) {
        /*
         * Unknown compounds key:
         * ElectricallyImpureCopper: Cu
         * CopperRefiningSolution: CuH2SO4
         * AnodicSlime: TeSe
         * SelenateTellurateMix: TeSe(H2Na2CO3)2
         * SelenateSolution: SeH2CO3
         */

        // CuFeS2 + SiO2 + 5O -> Cu(EIC) + FeSiO3 + 2SO2
        var chainNumber = 0;
        BLAST_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(240).EUt(120).blastFurnaceTemp(1500)
                .inputItems(crushedRefined, Chalcopyrite)
                .inputItems(dust, SiliconDioxide, 3)
                .inputFluids(Oxygen.getFluid(5000))
                .outputItems(dust, ElectricallyImpureCopper)
                .outputItems(dust, Ferrosilite, 5)
                .outputFluids(SulfurDioxide.getFluid(2000))
                .save(provider);

        // Cu + H2SO4 -> CuH2SO4
        CHEMICAL_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(200).EUt(120)
                .inputItems(dust, ElectricallyImpureCopper)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(CopperRefiningSolution.getFluid(1000))
                .save(provider);

        // 2Cu + CuH2SO4 -> H2SO4 + 3Cu + TeSe(75%)
        ELECTROLYZER_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(450).EUt(120)
                .inputItems(plate, ElectricallyImpureCopper, 2)
                .inputFluids(CopperRefiningSolution.getFluid(1000))
                .outputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(ingot, Copper, 3)
                .chancedOutput(dust, AnodicSlime, 7500, 0)
                .save(provider);

        // TeSe + 2Na2CO3 + 4O -> TeO2SeO2(Na2CO3)2
        BLAST_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(320).EUt(120).blastFurnaceTemp(2100)
                .inputItems(AnodicSlime)
                .inputItems(dust, SodaAsh, 12)
                .inputFluids(Oxygen.getFluid(4000))
                .outputItems(dustTiny, PreciousMetal, 5)
                .outputFluids(SeleniteTelluriteMix.getFluid(1000))
                .save(provider);

        // TeO2SeO2(Na2CO3)2 + H2SO4 -> TeO2 + Na2SO4 + Na2SeO3 + CO2 + H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(270).EUt(1920)
                .inputFluids(SeleniteTelluriteMix.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(TelluriumOxide,3)
                .outputItems(dust, Sodium, 4)
                .outputFluids(Water.getFluid(2000))
                .outputFluids(SulfurDioxide.getFluid(1000))
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .outputFluids(SeleniteSolution.getFluid(1000))
                .save(provider);

        // Na2SeO3 + 2HCl -> 2NaCl + SeO2 + H2O
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(240).EUt(480)
                .inputFluids(SeleniteSolution.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputItems(dust, Salt, 4)
                .outputItems(SeleniumOxide,3)
                .save(provider);

        // SeO2 + 2SO2 -> Se + 2SO3
        CHEMICAL_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(260).EUt(120)
                .inputItems(SeleniumOxide,3)
                .inputFluids(SulfurDioxide.getFluid(2000))
                .outputItems(dust, Selenium)
                .outputFluids(SulfurTrioxide.getFluid(2000))
                .save(provider);

        // TeO2 + 2SO2 -> Te + 2SO3
        CHEMICAL_RECIPES.recipeBuilder("selenium_chain_" + chainNumber++).duration(260).EUt(120)
                .inputItems(TelluriumOxide,3)
                .inputFluids(SulfurDioxide.getFluid(2000))
                .outputItems(dust, Tellurium)
                .outputFluids(SulfurTrioxide.getFluid(2000))
                .save(provider);
    }
}

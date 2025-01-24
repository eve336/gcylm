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

public class ChromiumChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // Na2CO3 + H2O -> Na2CO3(H2O)
        MIXER_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(60).EUt(30)
                .inputItems(dust, SodaAsh, 6)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(SodiumCarbonateSolution.getFluid(1000))
                .save(provider);

        // 2NaOH + CO2 -> Na2CO3 + H2O
        CHEMICAL_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(80).EUt(480)
                .inputItems(dust, SodiumHydroxide, 6)
                .inputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(dust, SodaAsh, 6)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        // CaCO3 + 2NaCl -> Na2CO3 + CaCl2
        BLAST_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(120).EUt(120).blastFurnaceTemp(500)
                .inputItems(dust, Calcite, 5)
                .inputItems(dust, Salt, 4)
                .outputItems(dust, SodaAsh, 6)
                .outputItems(dust, CalciumChloride, 3)
                .save(provider);

        // 2Cr2FeO4 + 4Na2CO3(H2O) + 7O -> Fe2O3 + 4CO2 + 4Na2CrO4(H2O)
        // TODO banded iron idk
//        CHEMICAL_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(120).EUt(120)
//                .inputItems(dust, Chromite, 7)
//                .inputFluids(SodiumCarbonateSolution.getFluid(4000))
//                .inputFluids(Oxygen.getFluid(7000))
//                .outputItems(dust, BandedIron, 5)
//                .outputFluids(CarbonDioxide.getFluid(4000))
//                .outputFluids(SodiumChromateSolution.getFluid(4000))
//                .save(provider);

        // 2Na2CrO4(H2O) + H2SO4 -> Na2Cr2O7(H2O) + Na2SO4 + 2H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(180).EUt(120)
                .inputFluids(SodiumChromateSolution.getFluid(2000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(SodiumDichromateSolution.getFluid(1000))
                .outputItems(dust, SodiumSulfate, 7)
                .save(provider);

        // 2C + Na2Cr2O7(H2O) -> Na2CO3 + Cr2O3 + CO + H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(200).EUt(120)
                .inputItems(dust, Carbon, 2)
                .inputFluids(SodiumDichromateSolution.getFluid(1000))
                .outputItems(dust, SodaAsh, 6)
                .outputItems(dust, ChromiumIIIOxide,5)
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .save(provider);

        // Cr2O3 + 2Al -> 2 Cr + Al2O3
        BLAST_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(200).EUt(120).blastFurnaceTemp(1200)
                .inputItems(dust, ChromiumIIIOxide,5)
                .inputItems(dust, Aluminium, 2)
                .outputItems(dust, Chromium, 2)
                .outputItems(dust, Alumina,5)
                .save(provider);

        // Combined Step - Chromite
        // TODO idk banded iron
//        CHEMICAL_BATH_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).EUt(1920).duration(200)
//                .inputItems(dust, Chromite, 7)
//                .inputFluids(SulfuricAcid.getFluid(3000))
//                .outputItems(dust, BandedIron, 5)
//                .outputItems(dust, Sulfur, 3)
//                .outputItems(dust, Chromium, 4)
//                .save(provider);

        // Na2SO4(H2O) -> Na2SO4
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(120).EUt(120)
                .inputFluids(SodiumSulfateSolution.getFluid(1000))
                .outputItems(dust, SodiumSulfate, 7)
                .save(provider);

        // Al2O3Cr + (HNO3 + HCl) -> Al2O3Cr(HNO3HCl)
        MIXER_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(280).EUt(1920)
                .inputItems(dust, Ruby, 6)
                .inputFluids(AquaRegia.getFluid(2000))
                .outputFluids(RubySlurry.getFluid(2000))
                .save(provider);

        // Al2O3Cr(HNO3HCl) -> 2Al + Cr + 3O + Ti + Fe + V + HNO3 + HCl
        CENTRIFUGE_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(320).EUt(480)
                .inputFluids(RubySlurry.getFluid(2000))
                .outputItems(dust, Aluminium, 2)
                .outputItems(dust, Chromium)
                .chancedOutput(dustTiny, Titanium, 2000, 0)
                .chancedOutput(dustTiny, Iron, 2000, 0)
                .chancedOutput(dustTiny, Vanadium, 2000, 0)
                .outputFluids(Oxygen.getFluid(3000))
                .outputFluids(NitricAcid.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .save(provider);

        // Al2O3 + (HNO3 + HCl) -> Al2O3(HNO3HCl)
        MIXER_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(280).EUt(1920)
                .inputItems(dust, Sapphire, 5)
                .inputFluids(AquaRegia.getFluid(2000))
                .outputFluids(SapphireSlurry.getFluid(2000))
                .save(provider);

        // Al2O3(HNO3HCl) -> 2Al + 3O + Ti + Fe + V + HNO3 + HCl
        CENTRIFUGE_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(320).EUt(480)
                .inputFluids(SapphireSlurry.getFluid(2000))
                .outputItems(dust, Aluminium, 2)
                .chancedOutput(dustTiny, Titanium, 2000, 0)
                .chancedOutput(dustTiny, Iron, 2000, 0)
                .chancedOutput(dustTiny, Vanadium, 2000, 0)
                .outputFluids(Oxygen.getFluid(3000))
                .outputFluids(NitricAcid.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .save(provider);

        // Al2O3 + (HNO3 + HCl) -> Al2O3(HNO3HCl)
        MIXER_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(280).EUt(1920)
                .inputItems(dust, GreenSapphire, 5)
                .inputFluids(AquaRegia.getFluid(2000))
                .outputFluids(GreenSapphireSlurry.getFluid(2000))
                .save(provider);

        // Al2O3(HNO3HCl) -> 2Al + 3O + Be + Ti + Fe + V + HNO3 + HCl
        CENTRIFUGE_RECIPES.recipeBuilder("chromium_chain_" + chainNumber++).duration(320).EUt(480)
                .inputFluids(GreenSapphireSlurry.getFluid(2000))
                .outputItems(dust, Aluminium, 2)
                .chancedOutput(dustTiny, Beryllium, 2000, 0)
                .chancedOutput(dustTiny, Titanium, 2000, 0)
                .chancedOutput(dustTiny, Iron, 2000, 0)
                .chancedOutput(dustTiny, Vanadium, 2000, 0)
                .outputFluids(Oxygen.getFluid(3000))
                .outputFluids(NitricAcid.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .save(provider);
    }
}

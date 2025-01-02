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

public class IodineChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // NaNO3·KNO3·KCl·NaIO3 + H2O = [NaNO3·KNO3·KCl·NaIO3 + H2O]
        MIXER_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(30).EUt(7680)
                .inputItems(dust, Caliche)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(CalicheIodateBrine.getFluid(1000))
                .save(provider);

        // [NaNO3·KNO3·KCl·NaIO3 + H2O] + 3H2O + 3SO2 = [NaNO3·KNO3·KCl·NaI + H2O] + 3H2SO4
        CHEMICAL_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(160).EUt(120)
                .inputFluids(CalicheIodateBrine.getFluid(1000))
                .inputFluids(SulfurDioxide.getFluid(3000))
                .inputFluids(Water.getFluid(3000))
                .outputFluids(IodideSolution.getFluid(1000))
                .outputFluids(SulfuricAcid.getFluid(3000))
                .save(provider);

        // 5[NaNO3·KNO3·KCl·NaI] + [NaNO3·KNO3·KCl·NaIO3 + H2O] -> 6[NaNO3·KNO3·KCl·NaOH + H2O + I]
        MIXER_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(140).EUt(120)
                .inputFluids(CalicheIodateBrine.getFluid(1000))
                .inputFluids(IodideSolution.getFluid(5000))
                .outputFluids(CalicheIodineBrine.getFluid(6000))
                .save(provider);

        // [NaNO3·KNO3·KCl·NaOH + H2O + I] +  Kerosene ->  [NaNO3·KNO3·KCl·NaOH + H2O] + [Kerosene + I]
        CHEMICAL_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(90).EUt(480)
                .inputFluids(CalicheIodineBrine.getFluid(1000))
                .inputFluids(Kerosene.getFluid(1000))
                .outputFluids(CalicheNitrateSolution.getFluid(1000))
                .outputFluids(KeroseneIodineSolution.getFluid(1000))
                .save(provider);

        // [Kerosene + I] = Kerosene + I
        CENTRIFUGE_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(140).EUt(120)
                .inputFluids(KeroseneIodineSolution.getFluid(1000))
                .outputFluids(Kerosene.getFluid(1000))
                .outputItems(dust, Iodine)
                .save(provider);

        // [NaNO3·KNO3·KCl·NaOH + H2O] = NaNO3 + KNO3 + KCl + NaOH + H2O (Water evaporated - Dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(120).EUt(30)
                .inputFluids(CalicheNitrateSolution.getFluid(1000))
                .outputItems(dust, SodiumNitrate, 5)
                .outputItems(dust, PotassiumNitrate, 5)
                .outputItems(dust, RockSalt, 2)
                .outputItems(dust, SodiumHydroxide, 3)
                .save(provider);

        // 2[I + Oil] = Oil + I?
        CENTRIFUGE_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(160).EUt(30)
                .inputFluids(IodizedOil.getFluid(2000))
                .outputFluids(Oil.getFluid(1000))
                .outputFluids(IodizedBrine.getFluid(1000))
                .save(provider);

        // I? + 0.3Cl = 1.3I??
        MIXER_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(240).EUt(7680)
                .inputFluids(IodizedBrine.getFluid(1000))
                .inputFluids(Chlorine.getFluid(300))
                .outputFluids(IodineBrineMix.getFluid(1300))
                .save(provider);

        // 1.3I?? = Br? + 0.3I?
        CENTRIFUGE_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(150).EUt(7680)
                .inputFluids(IodineBrineMix.getFluid(1300))
                .outputFluids(BrominatedBrine.getFluid(1000))
                .outputFluids(IodineSlurry.getFluid(300))
                .save(provider);

        // I? = I
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("iodine_chain_" + chainNumber++).duration(200).EUt(7680)
                .inputFluids(IodineSlurry.getFluid(1000))
                .outputItems(dust, Iodine)
                .save(provider);
    }
}

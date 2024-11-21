package com.eve.examplemod.data.recipe.chain;


import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;


public class ArcFurnaceOxidation {
    public static void init(Consumer<FinishedRecipe> provider) {
        // 2Sb + 3O = Sb2O3
        ARC_FURNACE_RECIPES.recipeBuilder("antimony_trioxide_oxidation").EUt(30).duration(60)
                .inputItems(dust, Antimony, 2)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(ChemicalHelper.get(dust, AntimonyTrioxide, 5))
                .save(provider);

        // NiZnFe4 + 8O = NiZnFe4O8
        ARC_FURNACE_RECIPES.recipeBuilder("nickel_zinc_ferrite_arc_furnace").EUt(120).duration(600)
                .inputItems(dust, FerriteMixture, 6)
                .inputFluids(Oxygen.getFluid(8000))
                .outputItems(ChemicalHelper.get(ingot, NickelZincFerrite, 14))
                .save(provider);


        // YBa2Cu3O6 + O -> YBa2Cu3O7
        ARC_FURNACE_RECIPES.recipeBuilder("ycbo_arc_furnace").duration(2509).EUt(7680)
                .inputItems(dust,WellMixedYBCOxides, 12)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(ingotHot, YttriumBariumCuprate, 13)
                .save(provider);

        ARC_FURNACE_RECIPES.recipeBuilder("cobalt_oxide_arc_furnace").EUt(30).duration(100)
                .inputItems(dust, Cobalt)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, CobaltOxide, 2)
                .save(provider);
    }
}

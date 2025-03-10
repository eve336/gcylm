package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class GoldChain {

    public static void init(Consumer<FinishedRecipe> provider) {

        // negative on fucking water and oxygen for some reason

        CENTRIFUGE_RECIPES.recipeBuilder("ohio")
                .inputItems(dust, GoldAlloy, 4)
                .outputItems(ChemicalHelper.get(dust, Copper))
                .outputItems(dustTiny, Gold, 4)
                .duration(500)
                .EUt(30)
                .save(provider);

        ELECTROLYZER_RECIPES.recipeBuilder("ohio")
                .inputItems(dust, GoldLeach, 4)
                .inputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(dust, Copper, 3)
                .outputItems(dustTiny, Gold, 8)
                .duration(300)
                .EUt(30)
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("goldline").EUt(30).duration(80)
                .inputItems(dust, CopperLeach, 4)
                .outputItems(dust, Copper, 3)
                .chancedOutput(dust, Lead, 1500, 500)
                .chancedOutput(dust, Iron, 1200, 400)
                .chancedOutput(dust, Nickel, 1000, 300)
                .chancedOutput(dust, Silver, 800, 200)
                .chancedOutput(dust, Manganese, 800, 100)
                .save(provider);


        
        ALLOY_SMELTER_RECIPES.recipeBuilder("gold_alloy").EUt(30).duration(100)
                .inputItems(dust, PreciousMetal)
                .inputItems(dust, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("gold_alloy_2").EUt(30).duration(100)
                .inputItems(ingot, PreciousMetal)
                .inputItems(dust, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("gold_alloy_3").EUt(30).duration(100)
                .inputItems(dust, PreciousMetal)
                .inputItems(ingot, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        ALLOY_SMELTER_RECIPES.recipeBuilder("gold_alloy_4").EUt(30).duration(100)
                .inputItems(ingot, PreciousMetal)
                .inputItems(ingot, Copper, 3)
                .outputItems(ingot, GoldAlloy, 4)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("potassium_metabisulfate").duration(100).EUt(30)
                .circuitMeta(1)
                .inputItems(dust, Potassium, 2)
                .inputItems(dust, Sulfur, 2)
                .inputFluids(Oxygen.getFluid(5000))
                .outputItems(dust, PotassiumMetabisulfite, 9)
                .save(provider);

        // H(AuCl4) -> Au + H + Cl4
        CHEMICAL_RECIPES.recipeBuilder("goldline4").duration(100).EUt(30)
                .inputFluids(ChloroauricAcid.getFluid(1000))
                .notConsumable(dust, PotassiumMetabisulfite)
                .outputItems(dust, Gold, 1)
                .outputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Chlorine.getFluid(4000))
                .save(provider);

        // Cu3Au? + HCl + 3 Cl -> H(AuCl4) + Cu3?
        CHEMICAL_RECIPES.recipeBuilder("goldline2").duration(80).EUt(30)
                .inputItems(dust, GoldLeach, 4)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(Chlorine.getFluid(3000))
                .outputItems(dust, CopperLeach, 4)
                .outputFluids(ChloroauricAcid.getFluid(1000))
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("goldline8").duration(80)
                .inputItems(ingot, GoldAlloy, 4)
                .inputFluids(NitricAcid.getFluid(1000))
                .outputItems(dust, GoldLeach, 4)
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .save(provider);
    }
}

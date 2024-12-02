package com.eve.examplemod.data.recipe.chain;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
public class HydrogenPeroxide {
    public static void init(Consumer<FinishedRecipe> provider) {

        // ethyl_anthrahydroquinone_and_oxygen_to_hydrogen_peroxide_and_ethyl_anthraquinone_001
        CHEMICAL_RECIPES.recipeBuilder("ethyl_anthrahydroquinone_and_oxygen_to_hydrogen_peroxide_and_ethyl_anthraquinone_001")
                .duration(600).EUt(240)
                .inputFluids(Oxygen.getFluid(2000))
                .inputFluids(EthylAnthraHydroQuinone.getFluid(1000))
                .notConsumableFluid(Anthracene.getFluid(1))
                .outputFluids(HydrogenPeroxide.getFluid(2000))
                .outputFluids(EthylAnthraQuinone.getFluid(1000))
                .save(provider);

// hydrogen_and_ethyl_anthraquinone_to_ethyl_anthrahydroquinone_002
        CHEMICAL_RECIPES.recipeBuilder("hydrogen_and_ethyl_anthraquinone_to_ethyl_anthrahydroquinone_002")
                .duration(600).EUt(120)
                .inputFluids(Hydrogen.getFluid(2000))
                .inputFluids(EthylAnthraQuinone.getFluid(1000))
                .outputFluids(EthylAnthraHydroQuinone.getFluid(1000))
                .save(provider);

// phthalic_anhydride_and_ethylbenzene_to_ethyl_anthraquinone_and_water_003
        CHEMICAL_RECIPES.recipeBuilder("phthalic_anhydride_and_ethylbenzene_to_ethyl_anthraquinone_and_water_003")
                .duration(300).EUt(120)
                .inputItems(dust, PhthalicAnhydride, 15)
                .inputFluids(Ethylbenzene.getFluid(1000))
                .outputFluids(EthylAnthraQuinone.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);

// ethylene_and_benzene_to_ethylbenzene_004
        CHEMICAL_RECIPES.recipeBuilder("ethylene_and_benzene_to_ethylbenzene_004")
                .duration(300).EUt(60)
                .circuitMeta(1)
                .inputFluids(Ethylene.getFluid(1000))
                .inputFluids(Benzene.getFluid(1000))
                .outputFluids(Ethylbenzene.getFluid(1000))
                .save(provider);

// phthalic_acid_to_phthalic_anhydride_005
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("phthalic_acid_to_phthalic_anhydride_005")
                .duration(600).EUt(120)
                .inputFluids(PhthalicAcid.getFluid(1000))
                .outputItems(dust, PhthalicAnhydride, 15)
                .save(provider);

// lithium_and_oxygen_and_naphthalene_to_phthalic_acid_and_water_006
        CHEMICAL_RECIPES.recipeBuilder("lithium_and_oxygen_and_naphthalene_to_phthalic_acid_and_water_006")
                .duration(210).EUt(120)
                .notConsumable(dust, Lithium)
                .inputFluids(Oxygen.getFluid(21000))
                .inputFluids(Naphthalene.getFluid(4000))
                .outputFluids(PhthalicAcid.getFluid(5000))
                .outputFluids(Water.getFluid(1000))
                .save(provider);
    }
}
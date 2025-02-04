package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class VanadiumChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // Fe3O4V + C = 3Fe + (VO)C(TiO2) + CO
        BLAST_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(220).EUt(120).blastFurnaceTemp(1500)
                .inputItems(dust, VanadiumMagnetite, 4)
                .inputItems(dust, Carbon)
                .outputItems(ingot, Iron, 3)
                .outputItems(VanadiumSlag,5)
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .save(provider);

        // (VO)C(TiO2) = Dark Ash + TiO2 + VO
        MACERATOR_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(80).EUt(24)
                .inputItems(dust, VanadiumSlag,5)
                .outputItems(dust, DarkAsh)
                .outputItems(dustSmall, Rutile)
                .outputItems(dust, VanadiumSlagDust,2)
                .save(provider);

        // 2VO + 3Na2CO3 = 2Na3VO4 + 3CO
        BLAST_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(150).EUt(120).blastFurnaceTemp(700)
                .inputItems(dust, VanadiumSlagDust,4)
                .inputItems(dust, SodaAsh, 18)
                .outputItems(dust, SodiumVanadate,16)
                .outputFluids(CarbonMonoxide.getFluid(3000))
                .save(provider);

        // H2SO4 + NH4Cl + Na3VO4 = NH4VO3 + [Cl + 3Na + O + H2SO4]
        CHEMICAL_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(120).EUt(120)
                .inputFluids(SulfuricAcid.getFluid(1000))
                .inputItems(dust, SodiumVanadate,8)
                .inputFluids(AmmoniumChloride.getFluid(1000))
                .outputItems(dust, AmmoniumVanadate,9)
                .outputFluids(VanadiumWasteSolution.getFluid(1000))
                .save(provider);

        // [Cl + 3Na + O + H2SO4] = SiO2 + Al(OH)3 + NaCl + Na2SO4 + H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(120).EUt(30)
                .inputFluids(VanadiumWasteSolution.getFluid(4000))
                .outputItems(dust, Salt, 2)
                .outputItems(dust, SodiumSulfate, 7)
                .chancedOutput(dust, SiliconDioxide, 3, 5000, 1200)
                .chancedOutput(dust, AluminiumHydroxide,7, 5000, 1200)
                .save(provider);

        // Na2SO4 + H2 -> H2SO4 + 2Na
        CHEMICAL_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(90).EUt(30)
                .inputItems(dust, SodiumSulfate, 7)
                .inputFluids(Hydrogen.getFluid(2000))
                .outputItems(dust, Sodium, 2)
                .outputFluids(SulfuricAcid.getFluid(1000))
                .save(provider);

        // 2NH4VO3 = V2O5 + 2NH3 + H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(240).EUt(120)
                .inputItems(dust, AmmoniumVanadate,18)
                .outputItems(dust, VanadiumOxide,7)
                .outputFluids(Ammonia.getFluid(2000))
                .save(provider);

        // V2O5 + 2Al + C = Al2O3 + 2V + CO2
        BLAST_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).duration(200).EUt(120).blastFurnaceTemp(1200)
                .inputItems(dust, VanadiumOxide,7)
                .inputItems(dust, Aluminium, 2)
                .inputItems(dust, Carbon)
                .outputItems(dust, Alumina,5)
                .outputItems(dust, Vanadium, 2)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // Combined Step - Vanadium Magnetite
        CHEMICAL_BATH_RECIPES.recipeBuilder("vanadium_chain_" + chainNumber++).EUt(1920).duration(200)
                .inputItems(dust, VanadiumMagnetite, 4)
                .inputFluids(SulfuricAcid.getFluid(3000))
                .outputItems(dust, Vanadium, 2)
                .outputItems(dust, Magnetite, 7)
                .outputItems(dust, Sulfur, 3)
                .save(provider);
    }
}

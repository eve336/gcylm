package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.plate;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class PEEKChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;
        // Na2B4O7(H2O)10 + 2HCl -> 4H3BO3 + 5H2O + 2NaCl
        CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputItems(dust, Borax, 23)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputFluids(BoricAcid.getFluid(4000))
                .outputFluids(Water.getFluid(5000))
                .outputItems(dust, Salt, 4)
                .EUt(120)
                .duration(150)
                .save(provider);

        // H3BO3 + 4HF -> HBF4 + 3H2O
        CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(BoricAcid.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(4000))
                .outputFluids(FluoroBoricAcid.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .EUt(120)
                .duration(100)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputItems(dust, Cobalt)
                .inputItems(dust, Charcoal, 2)
                .inputItems(plate, Polybenzimidazole)
                .inputFluids(Acetylene.getFluid(1000))
                .inputFluids(Steam.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(4000))
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .outputItems(CoAcABCatalyst)
                .EUt(500000)
                .duration(10)
                .save(provider);

        // H2O + NaNO3 -> NaNO3(H2O)
        MIXER_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(Water.getFluid(1000))
                .inputItems(dust, SodiumNitrate, 5)
                .outputFluids(SodiumNitrateSolution.getFluid(1000))
                .EUt(120)
                .duration(80)
                .save(provider);

        // NaNO3(H2O) -> NaNO2 + H2O + O
        CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(SodiumNitrateSolution.getFluid(1000))
                .notConsumable(dust, CoAcABCatalyst)
                .outputItems(SodiumNitrite, 4)
                .outputFluids(Oxygen.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .EUt(30)
                .duration(300)
                .save(provider);

        // HBF4 + HCl + C6H5NH2 + NaNO2 -> NaCl + C6H5BF4N2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(FluoroBoricAcid.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(Aniline.getFluid(1000))
                .inputItems(SodiumNitrite, 4)
                .outputItems(dust, Salt, 2)
                .outputFluids(BenzenediazoniumTetrafluoroborate.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .duration(130)
                .EUt(30720)
                .save(provider);

        // C6H5BF4N2 -> BF3 + 2N + C6H5F
        DISTILLATION_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(BenzenediazoniumTetrafluoroborate.getFluid(1000))
                .outputFluids(BoronFluoride.getFluid(1000))
                .outputFluids(Nitrogen.getFluid(2000))
                .outputFluids(FluoroBenzene.getFluid(1000))
                .EUt(500000)
                .duration(100)
                .save(provider);

        // C6H5F + CH4 + H2SbF7 -> C7H7F + 4HF + SbF3
        CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(FluoroBenzene.getFluid(1000))
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(FluoroantimonicAcid.getFluid(1000))
                .outputFluids(Fluorotoluene.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(4000))
                .outputItems(AntimonyTrifluoride, 4)
                .EUt(480)
                .duration(150)
                .save(provider);

        // SbF3 -> Sb + 3F
        ELECTROLYZER_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputItems(AntimonyTrifluoride, 4)
                .outputItems(dust, Antimony)
                .outputFluids(Fluorine.getFluid(3000))
                .EUt(120)
                .duration(160)
                .save(provider);

        // Zn + Fe + Al + Cl -> ZnFeAlCl
        MIXER_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputItems(dust, Zinc)
                .inputItems(dust, Iron)
                .inputItems(dust, Aluminium)
                .inputFluids(Chlorine.getFluid(1000))
                .outputItems(ZnFeAlClCatalyst, 4)
                .EUt(15360)
                .duration(250)
                .save(provider);

        // H2O + 6Cl + C7H7F + C6H5F -> C13H8OF2 + 6HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(Chlorine.getFluid(6000))
                .inputFluids(Fluorotoluene.getFluid(1000))
                .inputFluids(FluoroBenzene.getFluid(1000))
                .notConsumable(dust, ZnFeAlClCatalyst)
                .outputItems(Difluorobenzophenone, 24)
                .outputFluids(HydrochloricAcid.getFluid(6000))
                .EUt(1920)
                .duration(100)
                .save(provider);

        // C6H6O2 + C13H8OF2 + Na2CO3 -> [(OC6H4)3C]n + H2O + 2NaF
        // Not perfectly balanced, but is probably fine
        LARGE_CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(Hydroquinone.getFluid(1000))
                .inputItems(Difluorobenzophenone, 24)
                .inputItems(dust, SodaAsh, 6)
                .outputFluids(Polyetheretherketone.getFluid(2592))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputItems(dust, SodiumFluoride, 4)
                .EUt(122880)
                .duration(250)
                .save(provider);

        // C3H6 + C6H6 + 3O -> C3H6O + C6H6O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputFluids(Propene.getFluid(1000))
                .inputFluids(Benzene.getFluid(1000))
                .inputFluids(Oxygen.getFluid(3000))
                .outputFluids(Acetone.getFluid(1000))
                .outputFluids(Hydroquinone.getFluid(1000))
                .outputFluids(Resorcinol.getFluid(1000))
                .EUt(7860)
                .duration(200)
                .save(provider);

        // MgClBr -> Mg + Cl + Br
        ELECTROLYZER_RECIPES.recipeBuilder("peek_chain_" + chainNumber++)
                .inputItems(MgClBromide, 3)
                .outputItems(dust, Magnesium)
                .outputFluids(Chlorine.getFluid(1000))
                .outputFluids(Bromine.getFluid(1000))
                .EUt(120)
                .duration(160)
                .save(provider);
    }
}

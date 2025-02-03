package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.UVA_HALIDE_LAMP;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.BIO_REACTOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.lens;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class FullereneChain {
    public static void init(Consumer<FinishedRecipe> provider) {


        // probably none of this is completely correct, but it may be a decent base to speed it up

        LARGE_CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_1")
                .inputFluids(Naphthalene.getFluid(1000))
                .inputFluids(SodiumCyanide.getFluid(1000))
                .inputFluids(Bromine.getFluid(2000))
                .outputItems(SodiumBromide, 2)
                .notConsumable(UVA_HALIDE_LAMP)
                .outputFluids(HydrobromicAcid.getFluid(1000))
                .outputItems(Cyanonaphthalene, 19)
                .EUt(1920)
                .duration(80)
                .save(provider);

// HBr + Cl -> HCl + Br
        CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_2")
                .inputFluids(HydrobromicAcid.getFluid(1000))
                .inputFluids(Chlorine.getFluid(1000))
                .outputFluids(Bromine.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .duration(160)
                .EUt(125)
                .save(provider);

// 2 NaBr + H3PO4 -> 2 HBr + Na2HPO4
        CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_3")
                .inputItems(dust, SodiumBromide, 4)
                .inputFluids(PhosphoricAcid.getFluid(1000))
                .outputFluids(HydrobromicAcid.getFluid(2000))
                .outputItems(DisodiumPhosphate, 8)
                .duration(190)
                .EUt(125)
                .save(provider);

// C10H7CN + H2O + 3HCl -> C11H8O + NH4Cl + 2Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_4")
                .inputItems(dust, Cyanonaphthalene, 19)
                .notConsumable(dust, TinChloride)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(3000))
                .outputFluids(Naphthaldehyde.getFluid(1000))
                .outputFluids(AmmoniumChloride.getFluid(1000))
                .outputFluids(Chlorine.getFluid(2000))
                .EUt(1920)
                .duration(80)
                .save(provider);

// NH4Cl -> HCl + NH3
        ELECTROLYZER_RECIPES.recipeBuilder("fullerene_chain_5")
                .inputFluids(AmmoniumChloride.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(Ammonia.getFluid(1000))
                .duration(200)
                .EUt(120)
                .save(provider);

// C11H8O + C8H10 + O -> C19H14 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_6")
                .inputFluids(Naphthaldehyde.getFluid(1000))
                .inputFluids(Ethylbenzene.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .notConsumable(dust, Iodine)
                .notConsumable(dust, Triphenylphosphine)
                .outputFluids(Water.getFluid(2000))
                .outputItems(Methylbenzophenanthrene, 33)
                .EUt(1920)
                .duration(100)
                .save(provider);

// C19H14 + KCN + C4H4BrNO2 -> C20H13N + KBr + C4H5NO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_7")
                .inputItems(dust, Methylbenzophenanthrene, 33)
                .inputItems(dust, PotassiumCyanide, 3)
                .inputItems(dust, Bromosuccinimide, 12)
                .outputItems(Benzophenanthrenylacetonitrile, 34)
                .outputItems(PotassiumBromide, 2)
                .outputItems(Succinimide, 12)
                .EUt(1920)
                .duration(100)
                .save(provider);

// 3C20H13N -> C60H30 + 3NH3
        LARGE_CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_8")
                .inputItems(dust, Benzophenanthrenylacetonitrile,102)
                .notConsumable(dust, TiAlChloride)
                .outputItems(UnfoldedFullerene)
                .outputFluids(Ammonia.getFluid(3000))
                .EUt(7680)
                .duration(250)
                .save(provider);

// C60H30 + 10N -> C60 + 10NH3
        LASER_ENGRAVER_RECIPES.recipeBuilder("fullerene_chain_9")
                .notConsumable(lens, MarkerMaterials.Color.Magenta)
                .inputItems(dust, UnfoldedFullerene)
                .inputFluids(Nitrogen.getFluid(10000))
                .outputItems(Fullerene)
                .outputFluids(Ammonia.getFluid(10000))
                .EUt(2000000)
                .duration(200)
                .save(provider);

// 6Na + PCl3 + 3C6H5Cl -> 6NaCl + C18H15P
        LARGE_CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_10")
                .inputItems(dust, Sodium, 6)
                .inputFluids(PhosphorusTrichloride.getFluid(1000))
                .inputFluids(Chlorobenzene.getFluid(3000))
                .outputItems(dust, Salt, 12)
                .outputItems(Triphenylphosphine, 34)
                .EUt(7680)
                .duration(250)
                .save(provider);

// BIO REACTOR RECIPE for Succinic Acid Production
        BIO_REACTOR_RECIPES.recipeBuilder("fullerene_chain_11")
                .inputItems(dust, EschericiaColi)
                .inputItems(dust, Sugar)
                .EUt(480)
                .outputItems(SuccinicAcid, 14)
                .duration(200)
                .save(provider);

// C4H6O4 + NH3 -> C4H5NO2 + 2H2O
        BLAST_RECIPES.recipeBuilder("fullerene_chain_12")
                .inputItems(dust, SuccinicAcid, 14)
                .inputFluids(Ammonia.getFluid(1000))
                .outputItems(Succinimide, 12)
                .outputFluids(Water.getFluid(2000))
                .EUt(120)
                .duration(500)
                .blastFurnaceTemp(2100)
                .save(provider);

// C4H5NO2 + 2Br -> C4H4BrNO2 + HBr
        CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_13")
                .inputItems(dust, Succinimide, 12)
                .inputFluids(Bromine.getFluid(2000))
                .outputItems(Bromosuccinimide, 12)
                .outputFluids(HydrobromicAcid.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

// C4H4BrNO2 -> HBr + NO2 + 4C + 3H
        ELECTROLYZER_RECIPES.recipeBuilder("fullerene_chain_14")
                .inputItems(dust, Bromosuccinimide, 12)
                .outputItems(dust, Carbon, 4)
                .outputFluids(Hydrogen.getFluid(3000))
                .outputFluids(HydrobromicAcid.getFluid(1000))
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .duration(158)
                .EUt(120)
                .save(provider);

// SO3 + S + 2Cl -> SO2 + SOCl2
        CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_15")
                .inputFluids(SulfurTrioxide.getFluid(1000))
                .inputItems(dust, Sulfur)
                .inputFluids(Chlorine.getFluid(2000))
                .outputFluids(SulfurDioxide.getFluid(1000))
                .outputFluids(ThionylChloride.getFluid(1000))
                .EUt(480)
                .duration(400)
                .save(provider);

// TiCl4 + AlCl3 -> TiAlCl7
        MIXER_RECIPES.recipeBuilder("fullerene_chain_16")
                .inputFluids(TitaniumTetrachloride.getFluid(1000))
                .inputItems(dust, AluminiumChloride, 4)
                .EUt(7680)
                .duration(50)
                .outputItems(TiAlChloride, 9)
                .save(provider);

// HCN + KOH -> KCN + H2O
        CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_17")
                .inputFluids(HydrogenCyanide.getFluid(1000))
                .inputFluids(PotassiumHydroxide.getFluid(1000))
                .circuitMeta(0)
                .outputItems(PotassiumCyanide, 3)
                .outputFluids(Water.getFluid(1000))
                .EUt(480)
                .duration(160)
                .save(provider);

// C6H6 + NH3 + 2Cl -> C6H5NH2 + HCl
        CHEMICAL_RECIPES.recipeBuilder("fullerene_chain_18")
                .inputFluids(Benzene.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Chlorine.getFluid(2000))
                .outputItems(Aniline, 3)
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .duration(480)
                .EUt(1920)
                .save(provider);
    }
}

package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.api.data.tag.EVTagPrefix.oxide;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;
import static com.eve.examplemod.common.data.EVRecipeTypes.LARGE_CENTRIFUGE_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class REEChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        /*
         * When I use [REE], it could be any of the below, in any combination,
         * [La, Pr, Nd, Ce, Sc, Eu, Gd, Sm, Y, Tb, Dy, Ho, Er, Tm, Yt, Lu],
         * being all Rare Earth Elements, excluding Promethium (Pm).
         *
         * Unknown compounds key:
         * Acidic Salt Water: 3 == H2SO4(NaCl)3(H2O)3
         * SulfuricBromineSolution: H2SO4Br(H2O)
         * DebrominatedWater: H2O, basically
         * HotVapourMixture: H2SO4Br(H2O)2
         * DampBromine: Br(H2O)
         * RareEarth: [REE]
         * RareEarthHydroxidesSolution: Na[REE]-OH(H2O)
         * RareEarthChloridesSolution: HNaOH[REE]-Cl(H2O)
         * ThUSludge: ThU
         * LaNdOxidesSolution: LaPrNdCeOx
         * SmGdOxidesSolution: ScEuGdSmOx
         * TbHoOxidesSolution: YTbDyHoOx
         * ErLuOxidesSolution: ErTmYtLuOx
         */

        // 3NaCl(H2O) + 2Cl + H2SO4 -> H2SO4(NaCl)3(H2O)3Cl2
        // Formula above multiplied up for simplicity
        var chainNumber = 0;
        CHEMICAL_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(SaltWater.getFluid(1500))
                .inputFluids(Chlorine.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(500))
                .outputFluids(AcidicSaltWater.getFluid(3000))
                .EUt(480)
                .duration(180)
                .save(provider);

        // H2SO4(NaCl)3(H2O)3Cl2 -> 3NaCl + H2SO4Br(H2O)Cl2 + 2H2O
        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(AcidicSaltWater.getFluid(6000))
                .outputItems(dust, Salt, 6)
                .outputFluids(SulfuricBromineSolution.getFluid(2000))
                .outputFluids(DebrominatedWater.getFluid(2000))
                .EUt(480)
                .duration(180)
                .save(provider);

        // H2SO4Br(H2O)Cl2 + H2O -> H2SO4Br(H2O)2Cl2
        CHEMICAL_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(SulfuricBromineSolution.getFluid(2000))
                .inputFluids(Steam.getFluid(1000))
                .outputFluids(HotVapourMixture.getFluid(3000))
                .EUt(480)
                .duration(150)
                .save(provider);

        // H2SO4Br(H2O)2Cl2 -> H2SO4 + H2O + 2Cl + Br(H2O)
        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(HotVapourMixture.getFluid(3000))
                .outputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(DebrominatedWater.getFluid(1000))
                .outputFluids(Chlorine.getFluid(2000))
                .outputFluids(DampBromine.getFluid(1000))
                .EUt(480)
                .duration(180)
                .save(provider);

        // Br(H2O) -> Br
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(DampBromine.getFluid(1000))
                .outputFluids(Bromine.getFluid(1000))
                .EUt(480)
                .duration(400)
                .save(provider);

        // CO + C3H6 + 2H -> C4H8O
        CHEMICAL_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(CarbonMonoxide.getFluid(1000))
                .inputFluids(Propene.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(Butyraldehyde.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // 2C4H8O + 4H -> C8H18O + H2O
        CHEMICAL_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(Butyraldehyde.getFluid(2000))
                .inputFluids(Hydrogen.getFluid(4000))
                .outputFluids(Ethylhexanol.getFluid(3000))
                .outputFluids(Water.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // 5C8H18O + 0.5P4O10 -> 2C16H35O4P + 2C4H10O
        CHEMICAL_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(Ethylhexanol.getFluid(5000))
                .inputItems(dust, PhosphorusPentoxide, 7)
                .outputFluids(DiethylhexylPhosphoricAcid.getFluid(2000))
                .outputFluids(Butanol.getFluid(2000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // [REE] + 3 [NaOH + H2O] + 3 H2O -> [REE(OH)3 + 3 NaOH + 3 H2O] + 3 H
        CHEMICAL_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputItems(dust, RareEarth)
                .inputFluids(SodiumHydroxideSolution.getFluid(3000))
                .inputFluids(Water.getFluid(3000))
                .outputFluids(RareEarthHydroxidesSolution.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(3000))
                .circuitMeta(3)
                .EUt(480)
                .duration(200)
                .save(provider);

        // 3 HCl + [REE(OH)3 + 3 NaOH] -> ThU + [REECl3 + 3 H2O] + 3 [NaOH + H2O]
        CHEMICAL_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(HydrochloricAcid.getFluid(3000))
                .inputFluids(RareEarthHydroxidesSolution.getFluid(1000))
                .outputFluids(RareEarthChloridesSolution.getFluid(3000))
                .outputFluids(SodiumHydroxideSolution.getFluid(3000))
                .outputItems(dust, ThUSludge, 2)
                .EUt(480)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++).duration(100).EUt(30)
                .inputFluids(SodiumHydroxideSolution.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(dust, SodiumHydroxide, 3)
                .save(provider);


        // 2 [REECl3 + 3 H2O] + C16H35O4P(cat.) -> [REE2O3](sep.) + 6 HCl + 3 H2O
        LARGE_CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(RareEarthChloridesSolution.getFluid(6000))
                .notConsumableFluid(DiethylhexylPhosphoricAcid.getFluid(0))
                .outputFluids(LaNdOxidesSolution.getFluid(250))
                .outputFluids(SmGdOxidesSolution.getFluid(250))
                .outputFluids(TbHoOxidesSolution.getFluid(250))
                .outputFluids(ErLuOxidesSolution.getFluid(250))
                .outputFluids(HydrochloricAcid.getFluid(6000))
                .EUt(480)
                .duration(600)
                .save(provider);

        // 4LaPrNdCeOx -> La2O3 + Pr2O3 + Nd2O3 + Ce2O3 (each 43% +2.75%)
        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(LaNdOxidesSolution.getFluid(4000))
                .chancedOutput(dust, LanthanumOxide, 5, 4300, 275)
                .chancedOutput(dust, PraseodymiumOxide, 5, 4300, 275)
                .chancedOutput(dust, NeodymiumOxide, 5, 4300, 275)
                .chancedOutput(dust, CeriumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save(provider);

        // 4ScEuGdSmOx -> Sc2O3 + Eu2O3 + Gd2O3 + Sm2O3 (each 43% +2.75%)
        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(SmGdOxidesSolution.getFluid(4000))
                .chancedOutput(dust, ScandiumOxide, 5, 4300, 275)
                .chancedOutput(dust, EuropiumOxide, 5, 4300, 275)
                .chancedOutput(dust, GadoliniumOxide, 5, 4300, 275)
                .chancedOutput(dust, SamariumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save(provider);

        // 4YTbDyHoOx -> Y2O3 + Tb2O3 + Dy2O3 + Ho2O3 (each 43% +2.75%)
        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(TbHoOxidesSolution.getFluid(4000))
                .chancedOutput(dust, YttriumOxide, 5, 4300, 275)
                .chancedOutput(dust, TerbiumOxide, 5, 4300, 275)
                .chancedOutput(dust, DysprosiumOxide, 5, 4300, 275)
                .chancedOutput(dust, HolmiumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save(provider);

        // 4ErTmYtLuOx -> Er2O3 + Tm2O3 + Yt2O3 + Lu2O3 (each 43% +2.75%)
        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputFluids(ErLuOxidesSolution.getFluid(4000))
                .chancedOutput(dust, ErbiumOxide, 5, 4300, 275)
                .chancedOutput(dust, ThuliumOxide, 5, 4300, 275)
                .chancedOutput(dust, YtterbiumOxide, 5, 4300, 275)
                .chancedOutput(dust, LutetiumOxide, 5, 4300, 275)
                .EUt(480)
                .duration(220)
                .save(provider);

        // 3C + 2La2O3 -> 4La + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, LanthanumOxide, 10)
                .outputItems(dust, Lanthanum, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Pr2O3 -> 4Pr + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, PraseodymiumOxide, 10)
                .outputItems(dust, Praseodymium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Nd2O3 -> 4Nd + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, NeodymiumOxide, 10)
                .outputItems(dust, Neodymium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Ce2O3 -> 4Ce + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, CeriumOxide, 10)
                .outputItems(dust, Cerium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Sc2O3 -> 4Sc + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, ScandiumOxide, 10)
                .outputItems(dust, Scandium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Eu2O3 -> 4Eu + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, EuropiumOxide, 10)
                .outputItems(dust, Europium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Gd2O3 -> 4Gd + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, GadoliniumOxide, 10)
                .outputItems(dust, Gadolinium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Sm2O3 -> 4Sm + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, SamariumOxide, 10)
                .outputItems(dust, Samarium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Y2O3 -> 4Y + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, YttriumOxide, 10)
                .outputItems(dust, Yttrium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Tb2O3 -> 4Tb + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, TerbiumOxide, 10)
                .outputItems(dust, Terbium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Dy2O3 -> 4Dy + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, DysprosiumOxide, 10)
                .outputItems(dust, Dysprosium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Ho2O3 -> 4Ho + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, HolmiumOxide, 10)
                .outputItems(dust, Holmium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Er2O3 -> 4Er + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, ErbiumOxide, 10)
                .outputItems(dust, Erbium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Tm2O3 -> 4Tm + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, ThuliumOxide, 10)
                .outputItems(dust, Thulium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + Yt2O3 -> 4Yt + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, YtterbiumOxide, 10)
                .outputItems(dust, Ytterbium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 3C + 2Lu2O3 -> 4Lu + 3CO2
        BLAST_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .blastFurnaceTemp(2500)
                .inputItems(dust, Carbon, 3)
                .inputItems(dust, LutetiumOxide, 10)
                .outputItems(dust, Lutetium, 4)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // 2ThU + O -> 0.5ThO + Th(20%) + U(20%)
        // hhaaha buffed bc tiny dusts are a nuisance
        CENTRIFUGE_RECIPES.recipeBuilder("ree_chain_" + chainNumber++)
                .inputItems(dust, ThUSludge, 4)
                .inputFluids(Oxygen.getFluid(500))
                .chancedOutput(dust, Thorium, 2000, 150)
                .chancedOutput(dust, GTMaterials.Uranium238, 2000, 150)
                .outputItems(oxide, Thorium)
                .EUt(480)
                .duration(250)
                .save(provider);

    }
}

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

public class CombinedChains {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // Fullerenes ================================================================================================

        // 10C10H8 + 10C8H10 -> 3C60H30 + 90H (H voided)
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(40).EUt(31457280) // UIV
                .inputFluids(Naphthalene.getFluid(10000))
                .inputFluids(Ethylbenzene.getFluid(10000))
                .outputItems(UnfoldedFullerene,3)
                .save(provider);


        // Naquadah ==================================================================================================

        // Naquadric Compound [Nq] + KHSO5 + 2H -> Nq + KOH + H2SO4
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(50).EUt(491520) // UV
                .inputItems(dust, NaquadricCompound)
                .inputItems(PotassiumPeroxymonosulfate,8)
                .inputFluids(Hydrogen.getFluid(2000))
                .outputItems(dust, Naquadah)
                .outputFluids(PotassiumHydroxide.getFluid(1000))
                .outputFluids(SulfuricAcid.getFluid(1000))
                .save(provider);

        // Enriched Naquadric Compound [Nq+] + Au2Cl6 + Xe + 3O -> Nq+ + 2Au + 6Cl + XeO3
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(50).EUt(491520) // UV
                .inputItems(dust, EnrichedNaquadricCompound)
                .inputFluids(AuricChloride.getFluid(1000))
                .inputFluids(Xenon.getFluid(1000))
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, NaquadahEnriched)
                .outputItems(dust, Gold, 2)
                .outputFluids(Chlorine.getFluid(6000))
                .outputFluids(XenonTrioxide.getFluid(1000))
                .save(provider);

        // Naquadriatic Compound [*Nq*] + Rn + Xe + 6O -> *Nq* + RnO3 + XeO3
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(50).EUt(491520) // UV
                .inputItems(dust, NaquadriaticCompound)
                .inputFluids(Radon.getFluid(1000))
                .inputFluids(Xenon.getFluid(1000))
                .inputFluids(Oxygen.getFluid(6000))
                .outputItems(dust, Naquadria)
                .outputFluids(RadonTrioxide.getFluid(1000))
                .outputFluids(XenonTrioxide.getFluid(1000))
                .save(provider);


        // Polymers ==================================================================================================


        // Rubber (unneeded)

        // Polyethylene (unneeded)

        // Polyvinyl Chloride (unneeded)

        // Polystyrene (unneeded)

        // Styrene-Butadiene Rubber (unneeded)

        // Polytetrafluoroethylene (unneeded)

        // Epoxy
        // 2C6H6 + 8O + 2C2H4 + C3H6 -> C2H4O + CO2 + 3H2O (gtce epoxy is not balanced)
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(60).EUt(30720) // LuV
                .inputFluids(Benzene.getFluid(2000))
                .inputFluids(Oxygen.getFluid(8000))
                .inputFluids(Ethylene.getFluid(2000))
                .inputFluids(Propene.getFluid(1000))
                .notConsumableFluid(HydrochloricAcid.getFluid(0))
                .outputFluids(Epoxy.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .save(provider);

        // 4,4'-Oxydianiline-Pyromellitimide
        // C6H4(CH3)2 + 2CH3Cl + 12O + 2C6H5NH2 + C2H5OH -> C22H14N2O7 + 2CH4 + 6H2O + 2HCl
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(491520) // UV
                .notConsumable(dust, Tin)
                .inputFluids(OrthoXylene.getFluid(1000))
                .inputFluids(Chloromethane.getFluid(2000))
                .inputFluids(Oxygen.getFluid(12000))
                .inputFluids(Aniline.getFluid(2000))
                .inputFluids(Phenol.getFluid(1000))
                .outputFluids(Polyimide.getFluid(1008))
                .outputFluids(Methane.getFluid(2000))
                .outputFluids(Water.getFluid(6000))
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // Fluorinated-Ethylene Proplyene (unneeded)

        // Polybenzimidazole
        // 2NH3 + 2HNO3 + 3C6H6 + 3O + C2H4 -> C20H12N4 + 9H2O
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(70).EUt(1966080) // UHV
                .notConsumable(dust, Zinc)
                .inputFluids(Oxygen.getFluid(3000))
                .inputFluids(Ethylene.getFluid(1000))
                .inputFluids(Ammonia.getFluid(2000))
                .inputFluids(NitricAcid.getFluid(2000))
                .inputFluids(Benzene.getFluid(3000))
                .outputFluids(Polybenzimidazole.getFluid(1008))
                .outputFluids(Water.getFluid(10000))
                .save(provider);

        // PolyEtherEtherKetone
        // C6H6O2 + 2C6H5F + Na2CO3 -> [(OC6H4)3C]n + 2NaF + 2H2O
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(120).EUt(31457280) // UIV
                .inputItems(dust, SodaAsh, 6)
                .inputFluids(Hydroquinone.getFluid(1000))
                .inputFluids(FluoroBenzene.getFluid(2000))
                .outputFluids(Polyetheretherketone.getFluid(2592))
                .outputFluids(Water.getFluid(2000))
                .outputItems(dust, SodiumFluoride, 4)
                .EUt(122880)
                .duration(250)
                .save(provider);

        // Zylon
        // C6H6O2 + 2HNO3 + C8H10 -> C14H6N2O2 + 6H2O
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(30).EUt(31457280) // UIV
                .notConsumable(dust, AuPdCCatalyst)
                .inputFluids(Resorcinol.getFluid(1000))
                .inputFluids(NitricAcid.getFluid(2000))
                .inputFluids(OrthoXylene.getFluid(1000))
                .outputItems(dust, Zylon)
                .outputFluids(Water.getFluid(6000))
                .save(provider);

        // Fullerene Polymer Matrix
        // Pd + C10H10Fe + C60 + C3H7NO2 -> PdC73H15NFe + H2O + O (voided water)
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(60).EUt(31457280 * 2) // UXV
                .inputItems(Fullerene,1)
                .inputItems(Sarcosine,13)
                .inputItems(dust, Palladium, 1)
                .inputFluids(Ferrocene.getFluid(1000))
                .notConsumableFluid(AceticAcid.getFluid(500))
                .notConsumable(dust, SodiumEthoxide)
                .notConsumable(dust, AluminiumChloride)
                .notConsumableFluid(Chloroform.getFluid(1))
                .notConsumableFluid(Toluene.getFluid(1))
                .outputItems(PdFullereneMatrix)
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);


        // 7C8H8 + 8CH2Cl2 + 8C60 + 8C11H14O2 + 8C2H6S + 8C6H5Cl -> 8C7H8 + 8H2S + 8C80H21O2 + 24HCl
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(60).EUt(31457280 * 4) // UXV
                .notConsumable(dust, Dimethylaminopyridine)
                .inputItems(Fullerene,8)
                .inputFluids(Styrene.getFluid(7000))
                .inputFluids(Dichloromethane.getFluid(8000))
                .inputFluids(Phenylpentanoicacid.getFluid(8000))
                .inputFluids(Dimethylsulfide.getFluid(8000))
                .inputFluids(Chlorobenzene.getFluid(8000))
                .outputFluids(Toluene.getFluid(8000))
                .outputFluids(HydrogenSulfide.getFluid(8000))
                .outputFluids(HydrochloricAcid.getFluid(24000))
                .outputFluids(PCBS.getFluid(8000))
                .save(provider);

        // Combined Process - Uraninite
        CHEMICAL_PLANT_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(7680).duration(864)
                .inputItems(dust, Uraninite, 3)
                .inputFluids(NitrationMixture.getFluid(4000))
                .outputItems(dioxide, GTMaterials.Uranium238, 3)
                .outputFluids(UraniumSulfateWasteSolution.getFluid(1000))
                .outputFluids(UraniumRefinementWasteSolution.getFluid(1000))
                .outputFluids(ThoriumNitrateSolution.getFluid(1000))
                .save(provider);
    }
}

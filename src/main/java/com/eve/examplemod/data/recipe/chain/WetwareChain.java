package com.eve.examplemod.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
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
import static net.minecraft.world.item.Items.APPLE;
import static net.minecraft.world.level.block.Blocks.*;

public class WetwareChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // GROWTH MEDIUM ===============================================================================================

        // 2CaO + 5C -> CO2 + 2CaC2
        BLAST_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(dust, Quicklime, 4)
                .inputItems(dust, Carbon, 5)
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .outputItems(CalciumCarbide,6)
                .blastFurnaceTemp(2500)
                .EUt(120)
                .duration(300)
                .save(provider);

        // CaC2 + 2H2O -> Ca(OH)2 + C2H2
        BLAST_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(CalciumCarbide,3)
                .inputFluids(Steam.getFluid(2000))
                .outputItems(CalciumHydroxide,5)
                .outputFluids(Acetylene.getFluid(1000))
                .blastFurnaceTemp(2300)
                .EUt(120)
                .duration(200)
                .save(provider);

        // Ca(OH)2 + 2HCl -> 2H2O + CaCl2
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(CalciumHydroxide,5)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputItems(dust, CalciumChloride, 3)
                .EUt(120)
                .duration(60)
                .save(provider);

        // O + CH3OH -> CH2O + H2O
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .notConsumable(dust, Silver)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(Methanol.getFluid(1000))
                .outputFluids(Formaldehyde.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .save(provider);

        // CH2O + C2H2 -> C3H4O
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .notConsumable(dust, Copper)
                .inputFluids(Formaldehyde.getFluid(1000))
                .inputFluids(Acetylene.getFluid(1000))
                .outputFluids(PropargylAlcohol.getFluid(1000))
                .EUt(120)
                .duration(120)
                .save(provider);

        // C3H4O + HCl -> C3H3Cl + H2O
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(PropargylAlcohol.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputFluids(PropargylChloride.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

//        EXTRACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
//                .inputItems(RUBBER_DROP)
//                .outputFluids(Resin.getFluid(100))
//                .EUt(24)
//                .duration(100)
//                .save(provider);

        DISTILLATION_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .outputItems(dustSmall, RawRubber)
                .inputFluids(Resin.getFluid(1000))
                .outputFluids(Turpentine.getFluid(200))
                .outputFluids(Isoprene.getFluid(20))
                .EUt(480)
                .duration(500)
                .save(provider);

        // C10H16 + H2SO4 -> C10H16 + H2SO4
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Turpentine.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(BetaPinene,26)
                .outputFluids(SulfuricAcid.getFluid(1000))
                .EUt(480)
                .duration(110)
                .save(provider);

        // C10H16 + 2C5H8 + 2O -> 2C10H16O
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(BetaPinene,26)
                .inputFluids(Isoprene.getFluid(2000))
                .inputFluids(Oxygen.getFluid(2000))
                .outputFluids(Citral.getFluid(2000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // C10H16O + C3H6O -> C13H20O + H2O
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Citral.getFluid(1000))
                .inputFluids(Acetone.getFluid(1000))
                .outputFluids(BetaIonone.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .EUt(120)
                .duration(250)
                .save(provider);

        // 25C13H20O + 5C3H3Cl -> 17C20H30O + 8O + 5HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(BetaIonone.getFluid(25000))
                .inputFluids(PropargylChloride.getFluid(5000))
                .outputFluids(VitaminA.getFluid(17000))
                .outputFluids(Oxygen.getFluid(8000))
                .outputFluids(HydrochloricAcid.getFluid(5000))
                .EUt(480)
                .duration(150)
                .save(provider);

        // This needs to be better, Zalgo was working on something
        MACERATOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(APPLE)
                .chancedOutput(dust, Yeast, 500, 500)
                .EUt(30)
                .duration(50)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Biomass.getFluid(1000))
                .inputItems(Yeast)
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .outputFluids(LinoleicAcid.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save(provider);

        // C2H4 + O -> C2H4O
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .circuitMeta(10)
                .inputFluids(Ethylene.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputFluids(EthyleneOxide.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        // NH3 + C2H4O -> C2H7NO
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(EthyleneOxide.getFluid(1000))
                .outputFluids(Ethanolamine.getFluid(1000))
                .EUt(7680)
                .duration(60)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(CupriavidusNecator)
                .inputItems(dust, Sugar)
                .inputFluids(Nitrogen.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Biotin.getFluid(2000))
                .EUt(7680)
                .duration(40)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Biotin.getFluid(1000))
                .inputFluids(LinoleicAcid.getFluid(1000))
                .inputFluids(Catalase.getFluid(1000))
                .inputFluids(VitaminA.getFluid(1000))
                .inputFluids(Ethanolamine.getFluid(1000))
                .outputFluids(B27Supplement.getFluid(5000))
                .EUt(7680)
                .duration(150)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(CleanAmmoniaSolution.getFluid(2000))
                .EUt(480)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(CleanAmmoniaSolution.getFluid(1000))
                .inputItems(BrevibacteriumFlavium)
                .inputItems(dust, Sugar)
                .outputItems(Glutamine,40)
                .EUt(30720)
                .duration(500)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(dust, Meat)
                .outputFluids(Blood.getFluid(1000))
                .EUt(30)
                .duration(50)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Blood.getFluid(1000))
                .outputFluids(BloodCells.getFluid(500))
                .outputFluids(BloodPlasma.getFluid(500))
                .EUt(480)
                .duration(200)
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(BloodPlasma.getFluid(1000))
                .outputFluids(Catalase.getFluid(200))
                .outputFluids(BFGF.getFluid(200))
                .outputFluids(EGF.getFluid(200))
                .EUt(480)
                .duration(50)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(B27Supplement.getFluid(1000))
                .inputFluids(AmmoniumNitrate.getFluid(1000))
                .inputItems(Glutamine,20)
                .inputFluids(BFGF.getFluid(1000))
                .inputFluids(EGF.getFluid(1000))
                .outputFluids(RawGrowthMedium.getFluid(4000))
                .EUt(480)
                .duration(500)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(BloodCells.getFluid(1000))
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(BacterialGrowthMedium.getFluid(2000))
                .EUt(120)
                .duration(100)
                .save(provider);

        // STERILIZED GROWTH MEDIUM ====================================================================================

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(dust, SiliconDioxide, 3)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputItems(dust, SodiumHydroxide, 3)
                .inputFluids(Steam.getFluid(1000))
                .outputFluids(SilicaGelBase.getFluid(3000))
                .EUt(120)
                .duration(120)
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(SilicaGelBase.getFluid(1000))
                .outputItems(SilicaGel,3)
                .outputItems(dust, Salt, 2)
                .EUt(480)
                .duration(125)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(SilicaGel,3)
                .inputItems(Alumina,5)
                .outputItems(SilicaAluminaGel,8)
                .EUt(30)
                .duration(60)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(SilicaAluminaGel)
                .outputItems(ZeoliteSievingPellets)
                .blastFurnaceTemp(4500)
                .EUt(120)
                .duration(400)
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(WetZeoliteSievingPellets)
                .outputItems(ZeoliteSievingPellets)
                .EUt(120)
                .duration(50)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(ZeoliteSievingPellets)
                .inputFluids(Ethanol.getFluid(1000))
                .outputFluids(Ethanol100.getFluid(1000))
                .outputItems(WetZeoliteSievingPellets)
                .EUt(120)
                .duration(100)
                .save(provider);

        AUTOCLAVE_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(PETRI_DISH)
                .inputFluids(Ethanol100.getFluid(100))
                .outputItems(STERILIZED_PETRI_DISH)
                .EUt(7680)
                .duration(25)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(PiranhaSolution.getFluid(2000))
                .EUt(30)
                .duration(50)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(PiranhaSolution.getFluid(100))
                .inputItems(CONTAMINATED_PETRI_DISH)
                .outputItems(PETRI_DISH)
                .EUt(30)
                .duration(25)
                .save(provider);

        // [H2SO4 + HNO3] + C6H6 -> C6H5NO2 + H2O + H2SO4
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(NitrationMixture.getFluid(2000))
                .inputFluids(Benzene.getFluid(1000))
                .outputFluids(NitroBenzene.getFluid(1000))
                .outputFluids(DilutedSulfuricAcid.getFluid(2000))
                .EUt(30)
                .duration(100)
                .save(provider);

        // 6H + C6H5NO2 -> C6H5NH2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Hydrogen.getFluid(6000))
                .inputFluids(NitroBenzene.getFluid(1000))
                .notConsumable(dust, Zinc)
                .outputFluids(Aniline.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .EUt(30)
                .duration(100)
                .save(provider);

        // HCl + 2H2SO4 + O -> HSO3Cl + 2H2O + SO3
        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(2000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputFluids(ChlorosulfonicAcid.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputFluids(SulfurTrioxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .save(provider);

        // C6H5NH2 + (CH3CO)2O + HSO3Cl -> C8H8ClNO3S + H2O + CH3COOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Aniline.getFluid(1000))
                .inputFluids(AceticAnhydride.getFluid(1000))
                .inputFluids(ChlorosulfonicAcid.getFluid(1000))
                .outputFluids(AcetylsulfanilylChloride.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(AceticAcid.getFluid(1000))
                .EUt(1920)
                .duration(100)
                .save(provider);

        // H2O + Na2CO3 -> NaHCO3 + NaOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++).duration(140).EUt(30)
                .inputFluids(Water.getFluid(1000))
                .inputItems(dust, SodaAsh, 6)
                .outputItems(SodiumBicarbonate,6)
                .outputItems(dust, SodiumHydroxide, 3)
                .save(provider);

        // NaHCO3 -> NaOH + CO2
        ELECTROLYZER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++).duration(145).EUt(120)
                .inputItems(SodiumBicarbonate,6)
                .outputItems(dust, SodiumHydroxide, 3)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        // NaHCO3 + C8H8ClNO3S + NH3 -> NaCl + C6H8N2O2S + CO2 + CH3COOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(SodiumBicarbonate,6)
                .inputFluids(AcetylsulfanilylChloride.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputFluids(Sulfanilamide.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputFluids(AceticAcid.getFluid(1000))
                .EUt(30720)
                .duration(50)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(RawGrowthMedium.getFluid(1000))
                .inputFluids(Sulfanilamide.getFluid(250))
                .outputFluids(SterileGrowthMedium.getFluid(1250))
                .EUt(7680)
                .duration(100)
                .save(provider);

        // STEM CELLS ==================================================================================================

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(dust, Meat)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(AnimalCells.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .notConsumable(dust, Naquadria)
                .inputFluids(AnimalCells.getFluid(1000))
                .outputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .EUt(7680)
                .duration(500)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(1)
                .EUt(480)
                .duration(100)
                .outputFluids(MycGene.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(2)
                .EUt(480)
                .duration(100)
                .outputFluids(Oct4Gene.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(3)
                .EUt(480)
                .duration(100)
                .outputFluids(SOX2Gene.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(4)
                .EUt(480)
                .duration(100)
                .outputFluids(KFL4Gene.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .inputFluids(AnimalCells.getFluid(1000))
                .inputFluids(GeneTherapyFluid.getFluid(1000))
                .EUt(30720)
                .duration(1000)
                .outputItems(STEM_CELLS)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputItems(STEM_CELLS)
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .outputItems(STEM_CELLS,2)
                .outputFluids(DepletedGrowthMedium.getFluid(500))
                .EUt(480)
                .duration(100)
                .save(provider);

        FERMENTING_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputFluids(FermentedBiomass.getFluid(1000))
                .EUt(30)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .inputItems(StreptococcusPyogenes)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(Cas9.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Cas9.getFluid(1000))
                .inputFluids(MycGene.getFluid(1000))
                .inputFluids(Oct4Gene.getFluid(1000))
                .inputFluids(SOX2Gene.getFluid(1000))
                .inputFluids(KFL4Gene.getFluid(1000))
                .inputItems(EschericiaColi)
                .outputFluids(GenePlasmids.getFluid(5000))
                .EUt(1920)
                .duration(50)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .inputItems("listAllmushroom", 1)
                .outputFluids(Chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .inputItems(BROWN_MUSHROOM.asItem())
                .outputFluids(Chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .inputItems(RED_MUSHROOM_BLOCK.asItem())
                .outputFluids(Chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(Chitin.getFluid(1000))
                .inputItems(BifidobacteriumBreve)
                .outputFluids(Chitosan.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("wetware_chain_" + chainNumber++)
                .inputFluids(GenePlasmids.getFluid(1000))
                .inputFluids(Chitosan.getFluid(1000))
                .outputFluids(GeneTherapyFluid.getFluid(2000))
                .EUt(7680)
                .duration(25)
                .save(provider);
    }
}

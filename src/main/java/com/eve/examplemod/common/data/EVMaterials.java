package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.eve.examplemod.api.data.material.properties.*;
import com.eve.examplemod.api.fluids.store.EVFluidStorageKeys;
import com.eve.examplemod.config.EVConfig;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.*;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.common.data.EVElements.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.V;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTElements.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;


@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class EVMaterials {

    public static void init() {

    }

    public static void modifyMaterials() {




        Neutronium.setProperty(PropertyKey.WIRE, new WireProperties(VA[OpV], 2, 32));

        PotassiumHydroxide.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));

        AmmoniumChloride.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));

        Rutherfordium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));


        Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Bohrium.addFlags(GENERATE_PLATE);

        Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Seaborgium.addFlags(GENERATE_PLATE);

        TinAlloy.addFlags(GENERATE_FINE_WIRE);

        Barium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Zirconium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Ytterbium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Mendelevium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Californium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Berkelium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Curium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Neptunium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Technetium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Promethium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Gadolinium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Protactinium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Strontium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Einsteinium.setProperty(PropertyKey.INGOT, new IngotProperty());

        Polonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Polonium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));

        Copernicium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Copernicium.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));

        HastelloyX78.setProperty(EVPropertyKey.MIXER, new EVMixerProperty(-1, -1));


        //Nuclear Properties
        Curium246.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Curium247, 1000)));
        Plutonium244.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Plutonium245, 1100, Curium245, 8900)));
        Thorium232.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Thorium233, 100, Protactinium233, 1000, Uranium233, 8900)));
        Thorium233.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Protactinium233, 9000)));
        Protactinium233.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Uranium233, 9000)));
        Uranium234.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Uranium235, 9000)));
        Uranium238.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Uranium239, 100, Neptunium239, 1000, Plutonium239, 8900)));

        Neptunium237.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Protactinium233, 9000)));
        Neptunium239.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Plutonium239, 9000)));
        Plutonium240.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Plutonium241, 9000)));
        Plutonium245.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Americium245, 9000)));
        Americium243.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Neptunium239, 9000)));
        Americium245.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Curium245, 9000)));
        Americium241.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Plutonium241, 9000)));
        Curium250.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(
                Curium251, 100,
                Berkelium251, 1000,
                Californium251, 8900
        )));
        Thorium.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(
                Thorium233, 100,
                Protactinium233, 1000,
                Uranium233, 8900
        )));
        Curium251.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Americium245, 9000)));
        Berkelium249.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Americium245, 9000)));
        Berkelium251.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Californium251, 9000)));
        Berkelium247.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Curium247, 9000)));
        Californium252.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Californium253, 9000)));
        Californium256.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(
                Californium257, 100,
                Einsteinium257, 1000,
                Fermium257, 8900
        )));
        Californium257.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Einsteinium257, 9000)));
        Einsteinium255.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Berkelium251, 9000)));
        Einsteinium257.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Fermium257, 9000)));
        Einsteinium253.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Californium253, 9000)));
        Fermium258.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Fermium259, 9000)));
        Fermium262.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(
                Fermium263, 1000,
                Mendelevium263, 9000
        )));
        Fermium263.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Mendelevium263, 9000)));
        Mendelevium261.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Einsteinium257, 9000)));
        Mendelevium259.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(0, Map.of(Fermium259, 9000)));
        Fermium257.setProperty(EVPropertyKey.NUCLEAR, new EVNuclearProperty(90, Map.of()));


        Protactinium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Thorium), Map.of(Protactinium233, 3000)));
        Thorium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Uranium238), Map.of(Protactinium233, 3000)));
        GTMaterials.Uranium238.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Neptunium), Map.of(Uranium238, 3000)));
        Neptunium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(GTMaterials.Plutonium239), Map.of(Neptunium, 3000)));
        GTMaterials.Plutonium239.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Americium), Map.of(GTMaterials.Plutonium239, 3000)));
        Americium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Curium), Map.of(Americium, 3000)));
        Curium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Berkelium), Map.of(Curium, 3000)));
        Berkelium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Californium), Map.of(Berkelium, 3000)));
        Californium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Einsteinium), Map.of(Berkelium, 3000)));
        Einsteinium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Fermium), Map.of(Einsteinium, 3000)));
        Fermium.setProperty(EVPropertyKey.WASTE, new EVWasteProperty(Set.of(Mendelevium), Map.of(Fermium, 3000)));

        GTMaterials.Uranium238.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(EVMaterials.Uranium238, 9890, Uranium235, 100, Uranium234, 10)));
        Neptunium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Neptunium235, 2000,
                Neptunium237, 5000,
                Neptunium239, 3000
        )));
        GTMaterials.Plutonium239.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Plutonium244, 9890,
                Plutonium241, 100,
                Plutonium240, 10
        )));
        Americium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Americium241, 2000,
                Americium243, 5000,
                Americium245, 3000
        )));
        Curium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Curium250, 9890,
                Curium247, 100,
                Curium246, 10
        )));
        Berkelium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Berkelium247, 2000,
                Berkelium249, 5000,
                Berkelium251, 3000
        )));
        Californium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Californium252, 9890,
                Californium253, 100,
                Californium256, 10
        )));
        Einsteinium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Einsteinium253, 2000,
                Einsteinium255, 5000,
                Einsteinium257, 3000
        )));
        Fermium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Fermium258, 9890,
                Fermium259, 100,
                Fermium262, 10
        )));
        Mendelevium.setProperty(EVPropertyKey.COMPONENT, new EVComponentProperty(Map.of(
                Mendelevium259, 2000,
                Mendelevium261, 5000,
                Mendelevium263, 3000
        )));


        Uranium235.addFlags(GENERATE_NUCLEAR, FISSILE_OXIDE);
        Thorium.addFlags(GENERATE_NUCLEAR);
        Plutonium241.addFlags(GENERATE_NUCLEAR, FISSILE_OXIDE);
        GTMaterials.Uranium238.addFlags(GENERATE_NUCLEAR);
        GTMaterials.Plutonium239.addFlags(GENERATE_NUCLEAR);

        Mendelevium.addFlags(GENERATE_NUCLEAR);
        Fermium.addFlags(GENERATE_NUCLEAR);
        Einsteinium.addFlags(GENERATE_NUCLEAR);
        Californium.addFlags(GENERATE_NUCLEAR);
        Berkelium.addFlags(GENERATE_NUCLEAR);
        Protactinium.addFlags(GENERATE_NUCLEAR);
        Curium.addFlags(GENERATE_NUCLEAR);
        Americium.addFlags(GENERATE_NUCLEAR);
        Neptunium.addFlags(GENERATE_NUCLEAR);

        if (EVConfig.INSTANCE.programmerArt) {
            ReinforcedEpoxyResin.setMaterialARGB(7491595);
            ReinforcedEpoxyResin.setMaterialIconSet(DULL);
            Epoxy.setMaterialARGB(0xC88C14);
            Epoxy.setMaterialIconSet(DULL);
        }

        Set<Material> set = new HashSet<>();
        Set<Material> decayset = new HashSet<>();

        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlag(GENERATE_NUCLEAR)) {
                    if (material.getProperty(EVPropertyKey.COMPONENT) != null) {
                        EVComponentProperty prop = material.getProperty(EVPropertyKey.COMPONENT);
                        prop.components.forEach((ohio, rizz) -> set.add(ohio));
                    }
                    if (material.getProperty(EVPropertyKey.NUCLEAR) != null) {
                        EVNuclearProperty nuclearProperty = material.getProperty(EVPropertyKey.NUCLEAR);
                        nuclearProperty.decayProducts.forEach((key, value) -> decayset.add(key));
                    }
                }
            }
        }

        // something something generate nuclear stuff probably
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasFlag(GENERATE_NUCLEAR)) {

                    if (!material.getProperties().hasProperty(PropertyKey.INGOT)) {
                        material.setProperty(PropertyKey.INGOT, new IngotProperty());
                    }

                    // depleted fuel fluid
                    if (material.hasFlag(FISSILE_OXIDE) || decayset.contains(material)) {
                        if (material.getProperty(PropertyKey.FLUID) == null) {
                            var prop = new FluidProperty();
                            prop.getStorage().enqueueRegistration(EVFluidStorageKeys.depleted_nitrate, new FluidBuilder());
                            material.setProperty(PropertyKey.FLUID, prop);
                        } else {
                            material.getProperty(PropertyKey.FLUID).getStorage().enqueueRegistration(EVFluidStorageKeys.depleted_nitrate,
                                    new FluidBuilder());
                        }
                    }

                    // isotope separation fluids
                    if (set.contains(material)) {
                        if (material.getProperty(PropertyKey.FLUID) == null) {
                            var prop = new FluidProperty();
                            prop.getStorage().enqueueRegistration(EVFluidStorageKeys.steam_cracked_hexafluoride, new FluidBuilder());
                            material.setProperty(PropertyKey.FLUID, prop);
                        } else
                            material.getProperty(PropertyKey.FLUID).getStorage().enqueueRegistration(EVFluidStorageKeys.steam_cracked_hexafluoride,
                                    new FluidBuilder());
                    }
                    if (set.contains(material) || (material.getElement() != null && !material.getElement().isIsotope())) {
                        if (material.getProperty(PropertyKey.FLUID) == null) {
                            var prop = new FluidProperty();
                            prop.getStorage().enqueueRegistration(EVFluidStorageKeys.hexafluoride, new FluidBuilder());
                            material.setProperty(PropertyKey.FLUID, prop);
                        } else
                            material.getProperty(PropertyKey.FLUID).getStorage().enqueueRegistration(EVFluidStorageKeys.hexafluoride,
                                    new FluidBuilder());
                    }
                }
                if (material.getElement() != null && !material.getElement().isIsotope()) {
                    if (material.getProperty(PropertyKey.FLUID) == null) {
                        var prop = new FluidProperty();
                        prop.getStorage().enqueueRegistration(EVFluidStorageKeys.hexachloride, new FluidBuilder());
                    } else {
                        material.getProperty(PropertyKey.FLUID).getStorage().enqueueRegistration(EVFluidStorageKeys.hexachloride, new FluidBuilder());
                    }
                }
            }
        }

        List<Material> fluidList = List.of(Water, HydrofluoricAcid, SodiumHexafluoroaluminate, Oxygen, SodiumHydroxideSolution, SodiumHydroxideBauxite, ImpureAluminiumHydroxideSolution, RedMud, PureAluminiumHydroxideSolution, HydrochloricAcid, NeutralisedRedMud, RedSlurry, FerricREEChloride, SaltWater, RareEarthChloridesSolution, IronChloride, SulfuricAcid, TitanylSulfate, TitaniumTetrachloride, Methane, Steam, Air, RichNitrogenMix, Nitrogen, OxidisedNitrogenMix, Ethanolamine, PurifiedNitrogenMix, CarbonatedEthanolamine, AmmoniaRichMix, Ammonia, CarbonDioxide, Hydrogen, HydrogenSulfide, CalciumCarbonateSolution, OrthoXylene, OrthoXyleneZeoliteMixture, ParaXylene, Bromine, Dibromomethylbenzene, HydrogenPeroxide, Propene, Isochloropropane, Ethenone, AceticAcid, AceticAnhydride, Resorcinol, NitricAcid, Dinitrodipropanyloxybenzene, SodiumAcetate, Propane, Acetone, MesitylOxide, MethylIsobutylKetone, HydrogenCyanide, ThiocyanicAcid, ZrHfSeparationMix, Chlorine, ZrHfChloride, ZirconChlorinatingResidue, ZrHfOxyChloride, SulfurTrioxide, AmmoniumChloride, AmmoniumSulfate, DistilledWater, ZincExhaustMixture, SulfurDioxide, ZincSlagSlurry, MetalRichSlagSlurry, PhosphoricAcid, AcidicMetalSlurry, SeparatedMetalSlurry, MetalHydroxideMix, ZincPoorMix, IronPoorMix, IndiumHydroxideConcentrate, Mercury, CadmiumThalliumLiquor, ZincAmalgam, CadmiumSulfateSolution, ThalliumSulfateSolution, PolyphenolMix, AcidifiedPolyphenolMix, Ethanol, Diethylether, TannicAcid, WoodTar, GermanicAcidSolution, GermaniumChloride, Acetylene, Methanol, Formaldehyde, PropargylAlcohol, PropargylChloride, Resin, Turpentine, Isoprene, Citral, BetaIonone, VitaminA, Biomass, LinoleicAcid, Ethylene, EthyleneOxide, Biotin, Catalase, B27Supplement, CleanAmmoniaSolution, Blood, BloodCells, BloodPlasma, BFGF, EGF, AmmoniumNitrate, RawGrowthMedium, BacterialGrowthMedium, SilicaGelBase, Ethanol100, PiranhaSolution, NitrationMixture, Benzene, NitroBenzene, DilutedSulfuricAcid, Aniline, ChlorosulfonicAcid, AcetylsulfanilylChloride, Sulfanilamide, SterileGrowthMedium, AnimalCells, RapidlyReplicatingAnimalCells, MycGene, Oct4Gene, SOX2Gene, KFL4Gene, GeneTherapyFluid, DepletedGrowthMedium, FermentedBiomass, Cas9, GenePlasmids, Chitin, Chitosan, BosonicUUMatter, FermionicUUMatter, FreeElectronGas, UUMatter, HypochlorousAcid, HotNitrogen, GlucoseIronSolution, GrapheneOxidationSolution, Hydrazine, LiquidAir, Argon, Neon, Helium, Krypton, Xenon, Lava, Pyrotheum, Ice, Cryotheum, SupercooledCryotheum, RedOil, RP1, TributylPhosphate, PhosphorusTrichloride, PhosphorylChloride, Butanol, SodiumFormate, FormicAcid, SiliconFluoride, Fluorine, BariumSulfateSolution, BentoniteClaySlurry, EthylAnthraHydroQuinone, EthylAnthraQuinone, PhthalicAcid, Naphthalene, Chloroethanol, Trimethylamine, Choline, ATL, Lubricant, EthyleneGlycol, DrillingMud, CaCBaSMixture, LubricantClaySlurry, ATLEthylene, DrillingMudMixture, UsedDrillingMud, WetEthyleneOxide, Toluene, Phosgene, TolueneDiisocyanate, Polyurethane, ViscoelasticPolyurethane, ViscoelasticPolyurethaneFoam, NitricOxide, Gasoline, Octane, EthylTertButylEther, HighOctaneGasoline, RawGasoline, Naphtha, Butane, Dimethylhydrazine, DinitrogenTetroxide, RocketFuelH8N4C2O4, NitrogenDioxide, MonoMethylHydrazine, RocketFuelCN3H7O3, DenseHydrazineFuelMixture, RP1RocketFuel, LiquidHydrogen, Kerosene, CoalTar, CoalTarOil, Anthracene, SulfuricCoalTarOil, Radon, VanadiumWasteSolution, UranylChlorideSolution, UranylNitrateSolution, PurifiedUranylNitrate, UraniumSulfateWasteSolution, UraniumDiuranate, PotassiumHydroxide, UraniumRefinementWasteSolution, ThoriumNitrateSolution, Lithium, Sodium, Potassium, Rubidium, Caesium, Francium, Tin, Gallium, Indium, Bismuth, Polonium, Lanthanum, Cerium, Praseodymium, Neodymium, Europium, Ytterbium, Plutonium239, NonMetals, NobleGases, Helium3, LiquidHelium3, LiquidNitrogen, LiquidHelium, LiquidEnrichedHelium, SuperfluidHelium, ProtoAdamantium, Taranium, HeavyLeptonMix, Gluons, Periodicium, DenseNeutronPlasma, Cycloparaphenylene, NeutroniumDopedNanotubes, CosmicMeshPlasma, ElectronDegenerateRheniumPlasma, Titanium, NaquadahEnriched, SuperheavyMix, NeutronPlasma, BoricAcid, BoronFluoride, BoronTrifluorideEtherate, SodiumCyanide, Dimethylsulfide, Diborane, BoraneDimethylsulfide, Tetrahydrofuran, Trimethylsilane, Trimethylchlorosilane, FumingNitricAcid, NitratedTriniiteSolution, ResidualTriniiteSolution, Perfluorobenzene, ActiniumRadiumHydroxideSolution, FluoroantimonicAcid, KryptonDifluoride, HeavilyFluorinatedTriniumSolution, Fluorite, MoltenCalciumSalts, AcetylChloride, EthylTrifluoroacetate, Succinaldehyde, Acetothienone, DilutedHydrochloricAcid, TheonylTrifluoroacetate, ActiniumRadiumNitrateSolution, DirtyHexafluorosilicicAcid, DiluteHexafluorosilicicAcid, FluorosilicicAcid, LiquidFluorine, Dioxygendifluoride, OxidizedResidualSolution, DiluteHydrofluoricAcid, Tritium, TritiumHydride, Helium3Hydride, UltraacidicResidueSolution, LiquidXenon, XenicAcid, DustyLiquidHelium3, Ozone, TaraniumEnrichedLHelium3, TaraniumSemidepletedLHelium3, TaraniumDepletedLHelium3, TaraniumRichDustyHeliumPlasma, TaraniumDepletedHeliumPlasma, TaraniumRichHelium4, TaraniumPoorLiquidHelium, TaraniumPoorLiquidHeliumMix, HydroselenicAcid, Phenol, AminoPhenol, Glycerol, Hydroxyquinoline, BismuthNitrateSolution, BariumChlorideSolution, BariumTitanatePreparation, Perbromothiophene, Diethoxythiophene, HydrobromicAcid, EDOT, Polystyrene, SodiumPersulfate, SolderingAlloy, WoodsGlass, IronCarbonyl, PurifiedIronCarbonyl, CarbonSulfide, Biperfluoromethanedisulfide, BariumTriflateSolution, Epichlorohydrin, CitricAcid, OxalicAcid, CarbonTetrachloride, ActiniumSuperhydridePlasma, Dimethyldichlorosilane, Dibromoacrolein, Ethane, Chloroethane, Bromohydrothiine, ButylLithium, Bromobutane, Butene, Propadiene, Tetrafluoroethylene, AmmoniumPerrhenate, AstatideSolution, SodiumSulfateSolution, Acetaldehyde, PhenylenedioxydiaceticAcid, SodiumThiocyanate, Ethylamine, Diethylthiourea, ThionylChloride, Isophthaloylbisdiethylthiourea, AntimonyPentafluoride, FluorophosphoricAcid, CosmicComputingMix, BariumStrontiumAcetateSolution, IsopropylAlcohol, TitaniumIsopropoxide, BariumStrontiumTitanatePreparation, IsopropylAcetate, Iodobenzene, Styrene, Tributylamine, Amino3phenol, Hydroxylamine, PotassiumEthoxide, TetraethylammoniumBromide, Butylaniline, IodobenzoicAcid, Chlorobenzene, Methoxybenzaldehyde, MBBA, LiquidCrystalDetector, IodineMonochloride, AcetylatingReagent, Dimethylnaphthalene, Dihydroiodotetracene, Dichlorodicyanobenzoquinone, Dichlorodicyanohydroquinone, LithiumChlorideSolution, CopperRefiningSolution, SeleniteTelluriteMix, SeleniteSolution, GoldCyanide, ChlorideLeachedSolution, Iron2Chloride, MolybdenumFlue, RheniumSulfuricSolution, Methylamine, Methylethanolamine, Methylguanidine, Methylnitronitrosoguanidine, IsoamylAlcohol, Oct1ene, Octanol, Trioctylamine, RheniumSeparationMixture, RheniumScrubbedSolution, FluoroniobicAcid, AcidicSaltWater, SulfuricBromineSolution, HotVapourMixture, DampBromine, Butyraldehyde, Ethylhexanol, DiethylhexylPhosphoricAcid, RareEarthHydroxidesSolution, LaNdOxidesSolution, SmGdOxidesSolution, TbHoOxidesSolution, ErLuOxidesSolution, SeedOil, FishOil, Soap, DeglyceratedSoap, StearicAcid, Trioctylphosphine, QuantumDots, Diaminobenzidine, Diphenylisophtalate, Polybenzimidazole, Dichlorobenzidine, Nitrochlorobenzene, Chloromethane, Oxydianiline, PolyamicAcid, Polyimide, Hexafluoropropylene, FluorinatedEthylenePropylene, AcidicIridiumSolution, AquaRegia, PlatinumConcentrate, RhodiumSulfate, AcidicOsmiumSolution, PalladiumAmmonia, RhodiumSulfateSolution, RhodiumSaltSolution, RhodiumFilterCakeSolution, RutheniumTetroxideSolution, HotRutheniumTetroxideSolution, RutheniumTetroxide, OsmiumSolution, Rhodium, FluoroBoricAcid, SodiumNitrateSolution, BenzenediazoniumTetrafluoroborate, FluoroBenzene, Fluorotoluene, Hydroquinone, Polyetheretherketone, Dimethylether, Dimethoxyethane, Cyclopentadiene, LithiumCyclopentadienide, CaliforniumCyclopentadienide, AmmoniumFluoride, AmmoniumBifluorideSolution, LuTmYChlorideSolution, DielectricMirrorFormationMix, AmmoniumNiobiumOxalateSolution, Ethylenediamine, EDTASolution, EDTA, Glycine, CesiumBromideSolution, PrYHoNitrateSolution, CetaneTrimethylAmmoniumBromide, ChlorinatedSolvents, Dichloromethane, Chloroform, ButanolGas, CrudeAluminaSolution, AluminaSolution, AmmoniumCyanate, NbTaFluorideMix, FluorotantalicAcid, NbTaSeparationMixture, REEThUSulfateSolution, AlkalineEarthSulfateSolution, RareEarthNitrateSolution, OxypentafluoroNiobate, HeptafluoroTantalate, NaquadricSolution, DiluteNitricAcid, EnrichedNaquadricSolution, NaquadriaticSolution, FluoronaquadricAcid, EnrichedFluoronaquadricAcid, FluoronaquadriaticAcid, NaquadahDifluoride, EnrichedNaquadahDifluoride, NaquadriaDifluoride, NaquadriaHexafluoride, RadonDifluoride, RadonNaquadriaoctafluoride, XenonTrioxide, CesiumFluoride, CesiumXenontrioxideFluoride, RadonTrioxide, NaquadriaCesiumXenonNonfluoride, NitrylFluoride, NitrosoniumOctafluoroxenate, NaquadriaCesiumfluoride, EnrichedNaquadahhexafluoride, EnrichedXenonHexafluoronaquadate, AuricChloride, BromineTrifluoride, XenoauricFluoroantimonicAcid, NaquadahSulfate, NaquadahSolution, ClearNaquadahLiquid, ComplicatedNaquadahGas, ComplicatedLightNaquadah, ComplicatedMediumNaquadah, ComplicatedHeavyNaquadah, NaquadahGas, HeavyNaquadah, LightNaquadah, MediumNaquadah, FCrackedMediumNaquadah, FCrackedLightNaquadah, FCrackedHeavyNaquadah, LightNaquadahFuel, MediumNaquadahFuel, HeavyNaquadahFuel, ENaquadahSolution, ClearENaquadahLiquid, ComplicatedLightENaquadah, ComplicatedMediumENaquadah, ComplicatedHeavyENaquadah, HeavyENaquadah, LightENaquadah, MediumENaquadah, RnCrackedMediumENaquadah, RnCrackedLightNaquadah, RnCrackedHeavyENaquadah, LightENaquadahFuel, MediumENaquadahFuel, HeavyENaquadahFuel, NaquadriaSolution, HyperFuelI, HyperFuelII, HyperFuelIII, HyperFuelIV, DissolvedLithiumOre, LithiumCarbonateSolution, CalicheIodateBrine, IodideSolution, CalicheIodineBrine, CalicheNitrateSolution, KeroseneIodineSolution, IodizedOil, Oil, IodizedBrine, IodineBrineMix, BrominatedBrine, IodineSlurry, Hexanediol, Hexamethylenediamine, Tertbutanol, Toluenesulfonate, Triaminoethaneamine, TertButylAzidoformate, AminatedFullerene, Azafullerene, SupercriticalCO2, NitrousAcid, HydroxylamineHydrochloride, Triethylamine, SelenousAcid, Glyoxal, BenzylChloride, Benzylamine, Dimethylformamide, TetrafluoroboricAcid, Benzaldehyde, ChloroauricAcid, LithiumHydroxideSolution, LithiumPeroxideSolution, NitrogenPentoxide, Carbon, Carbon12, Carbon13, Nitrogen14, CNOcatalyst, HeliumCNO, Titanium44, Calcium44, Chromium48, Iron52, Nickel56, Iron, QuassifissioningPlasma, FlYbPlasma, MetastableFlerovium, Ytterbium178, Hafnium, TitaniumTetrafluoride, Titanium50Tetrafluoride, Titanium50, OgannesonBreedingBase, HotMetastableOganesson, Magnesium, Silicon, Sulfur, Calcium, Helium4, Bohrium, Trinium, Tritanium, Adamantium, Seaborgium, Vibranium, ScandiumTitanium50Mix, RadonRadiumMix, MetastableHassium, Deuterium, Beryllium, Tungsten, Platinum, Lutetium, Americium, Thorium, Naquadah, Osmium, Manganese, Gold, Aluminium, Nickel, Copernicium, Vanadium, Duranium, Tantalum, Silver, Naquadria, Rutherfordium, Dubnium, Meitnerium, Tennessine, Livermorium, Moscovium, Astatine, Nihonium, Radium, Roentgenium, Naphthaldehyde, Ferrocene, Ferrocenylfulleropyrrolidine, BenzoylChloride, BenzoylPeroxide, HydroiodicAcid, AcryloNitrile, TrimethyltinChloride, Phenylpentanoicacid, PCBA, Silvertetrafluoroborate, Diisopropylcarbodiimide, Dimethylamine, Pyridine, PCBS, QuarkGluonPlasma, HeavyQuarks, LightQuarks, HeavyQuarkEnrichedMix, Scandium, MetastableOganesson, DeuteriumSuperheavyMix, HeavyQuarkDegenerateMatter, Trichloroferane, Phenylsodium, Dichlorobenzene, Difluoroaniline, NDifluorophenylpyrrole, PhotopolymerSolution, SodiumCarbonateSolution, SodiumChromateSolution, SodiumDichromateSolution, RubySlurry, SapphireSlurry, GreenSapphireSlurry, PolyacrylonitrileSolution, MethylFormate, WetFormamide, Formamide, HydroxylamineDisulfate, Amidoxime, SeaWater, PureUranylNitrateSolution, Brine, ConcentratedBrine, AcidicBrominatedBrine, CalciumFreeBrine, SodiumFreeBrine, PotassiumFreeBrine, BoronFreeSolution, SodiumLithiumSolution, NitrousOxide, DimethylthiocarbamoilChloride, Mercaptophenol, AmineMixture, SodiumTungstate, Cyclooctadiene, ChlorodiisopropylPhosphine, AmmoniumPersulfate, ChilledBrine, MagnesiumContainingBrine, SodiumAlginateSolution, AscorbicAcid, DehydroascorbicAcid);
        List<String> nonFluidList = new ArrayList<>();
        fluidList.forEach((material -> {
                    if (!material.hasProperty(PropertyKey.FLUID) && !material.hasFluid()) {
                        nonFluidList.add(material.getName());
                    }
                })
        );
        System.out.println("non Fluid List: " + nonFluidList);

    }


    public static final List<MaterialFlag> EXT2_METAL = new ArrayList<>();
    public static final List<MaterialFlag> CORE_METAL = new ArrayList<>();

    static {
        EXT2_METAL.addAll(Arrays.asList(GENERATE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_LONG_ROD, AUTOGEN_MIXER_RECIPE));
        CORE_METAL.addAll(EXT2_METAL);
        CORE_METAL.addAll(Arrays.asList(GENERATE_RING, GENERATE_FRAME, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_DENSE));
    }


    public static final Material Uranium238 = new Material.Builder(EVMain.id("uranium_238"))
            .ingot()
            .color(GTMaterials.Uranium238.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE)
            .element(EVElements.U238)
            .buildAndRegister()
            .setFormula("U238", true);

    public static final Material Plutonium239 = new Material.Builder(EVMain.id("plutonium_239"))
            .ingot()
            .color(GTMaterials.Plutonium239.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(EVElements.Pu239)
            .buildAndRegister()
            .setFormula("Pu239", true);

    public static final Material Uranium233 = new Material.Builder(EVMain.id("uranium_233"))
            .ingot()
            .color(Uranium238.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(U233)
            .buildAndRegister()
            .setFormula("U233", true);

    public static final Material Uranium239 = new Material.Builder(EVMain.id("uranium_239"))
            .ingot()
            .color(Uranium238.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(U239)
            .buildAndRegister()
            .setFormula("U239", true);

    public static final Material Protactinium233 = new Material.Builder(EVMain.id("protactinium_233"))
            .ingot()
            .color(Protactinium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Pa233)
            .buildAndRegister()
            .setFormula("Pa233", true);

    public static final Material Thorium233 = new Material.Builder(EVMain.id("thorium_233"))
            .ingot()
            .color(Thorium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Th233)
            .buildAndRegister()
            .setFormula("Th233", true);

    public static final Material Thorium232 = new Material.Builder(EVMain.id("thorium_232"))
            .ingot()
            .color(Thorium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Th232)
            .buildAndRegister()
            .setFormula("Th232", true);

    public static final Material Uranium234 = new Material.Builder(EVMain.id("uranium_234"))
            .ingot()
            .color(Uranium238.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE)
            .element(U234)
            .buildAndRegister()
            .setFormula("U234", true);

    public static final Material Fermium259 = new Material.Builder(EVMain.id("fermium_259"))
            .ingot()
            .color(0x984ACF)
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(Fm259)
            .buildAndRegister()
            .setFormula("Fm259", true);

    public static final Material Fermium262 = new Material.Builder(EVMain.id("fermium_262"))
            .ingot()
            .color(0x984ACF)
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE)
            .element(Fm262)
            .buildAndRegister()
            .setFormula("Fm262", true);

    public static final Material Fermium263 = new Material.Builder(EVMain.id("fermium_263"))
            .ingot()
            .color(0x984ACF)
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Fm263)
            .buildAndRegister()
            .setFormula("Fm263", true);

    public static final Material Plutonium245 = new Material.Builder(EVMain.id("plutonium_245"))
            .ingot()
            .color(Plutonium241.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Pu245)
            .buildAndRegister()
            .setFormula("Pu245", true);

    public static final Material Plutonium244 = new Material.Builder(EVMain.id("plutonium_244"))
            .ingot()
            .color(Plutonium241.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE)
            .element(Pu244)
            .buildAndRegister()
            .setFormula("Pu244", true);

    public static final Material Plutonium240 = new Material.Builder(EVMain.id("plutonium_240"))
            .ingot()
            .color(Plutonium241.getMaterialRGB())
            .iconSet(METALLIC)
            .element(Pu240)
            .flags(GENERATE_NUCLEAR, FISSILE)
            .buildAndRegister()
            .setFormula("Pu240", true);

    public static final Material Einsteinium257 = new Material.Builder(EVMain.id("einsteinium_257"))
            .ingot()
            .color(Einsteinium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR)
            .iconSet(METALLIC)
            .element(Es257)
            .buildAndRegister()
            .setFormula("Es257", true);

    public static final Material Californium253 = new Material.Builder(EVMain.id("californium_253"))
            .ingot()
            .color(Californium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(Cf253)
            .buildAndRegister()
            .setFormula("Cf253", true);

    public static final Material Californium256 = new Material.Builder(EVMain.id("californium_256"))
            .ingot()
            .color(Californium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR, FISSILE)
            .iconSet(METALLIC)
            .element(Cf256)
            .buildAndRegister()
            .setFormula("Cf256", true);

    public static final Material Californium257 = new Material.Builder(EVMain.id("californium_257"))
            .ingot()
            .color(Californium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR)
            .iconSet(METALLIC)
            .element(Cf257)
            .buildAndRegister()
            .setFormula("Cf257", true);

    public static final Material Californium252 = new Material.Builder(EVMain.id("californium_252"))
            .ingot()
            .color(Californium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE)
            .element(Cf252)
            .buildAndRegister()
            .setFormula("Cf252", true);

    public static final Material Californium251 = new Material.Builder(EVMain.id("californium_251"))
            .ingot()
            .color(Californium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(Cf251)
            .buildAndRegister()
            .setFormula("Cf251", true);

    public static final Material Berkelium251 = new Material.Builder(EVMain.id("berkelium_251"))
            .ingot()
            .color(Berkelium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Bk251)
            .buildAndRegister()
            .setFormula("Bk251", true);

    public static final Material Berkelium249 = new Material.Builder(EVMain.id("berkelium_249"))
            .ingot()
            .color(Berkelium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(Bk249)
            .buildAndRegister()
            .setFormula("Bk249", true);

    public static final Material Berkelium247 = new Material.Builder(EVMain.id("berkelium_247"))
            .ingot()
            .color(Berkelium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Bk249)
            .buildAndRegister()
            .setFormula("Bk247", true);

    public static final Material Curium251 = new Material.Builder(EVMain.id("curium_251"))
            .ingot()
            .color(Curium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR)
            .iconSet(METALLIC)
            .element(Cm251)
            .buildAndRegister()
            .setFormula("Cm251", true);

    public static final Material Curium250 = new Material.Builder(EVMain.id("curium_250"))
            .ingot()
            .color(Curium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR, FISSILE)
            .iconSet(METALLIC)
            .element(Cm250)
            .buildAndRegister()
            .setFormula("Cm250", true);

    public static final Material Curium246 = new Material.Builder(EVMain.id("curium_246"))
            .ingot()
            .color(Curium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR, FISSILE)
            .iconSet(METALLIC)
            .element(Cm246)
            .buildAndRegister()
            .setFormula("Cm246", true);

    public static final Material Curium245 = new Material.Builder(EVMain.id("curium_245"))
            .ingot()
            .color(Curium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .iconSet(METALLIC)
            .element(Cm245)
            .buildAndRegister()
            .setFormula("Cm245", true);

    public static final Material Curium247 = new Material.Builder(EVMain.id("curium_247"))
            .ingot()
            .color(Curium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .iconSet(METALLIC)
            .element(Cm247)
            .buildAndRegister()
            .setFormula("Cm247", true);

    public static final Material Americium245 = new Material.Builder(EVMain.id("americium_245"))
            .ingot()
            .color(Americium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Am245)
            .buildAndRegister()
            .setFormula("Am245", true);

    public static final Material Americium243 = new Material.Builder(EVMain.id("americium_243"))
            .ingot()
            .color(Americium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(Am243)
            .buildAndRegister()
            .setFormula("Am243", true);

    public static final Material Americium241 = new Material.Builder(EVMain.id("americium_241"))
            .ingot()
            .color(Americium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Am241)
            .buildAndRegister()
            .setFormula("Am241", true);

    public static final Material Neptunium235 = new Material.Builder(EVMain.id("neptunium_235"))
            .ingot()
            .color(Neptunium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Np235)
            .buildAndRegister()
            .setFormula("Np235", true);

    public static final Material Neptunium237 = new Material.Builder(EVMain.id("neptunium_237"))
            .ingot()
            .color(Neptunium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(Np237)
            .buildAndRegister()
            .setFormula("Np237", true);

    public static final Material Neptunium239 = new Material.Builder(EVMain.id("neptunium_239"))
            .ingot()
            .color(Neptunium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Np239)
            .buildAndRegister()
            .setFormula("Np239", true);

    public static final Material Pyrotheum = new Material.Builder(EVMain.id("pyrotheum"))
            .color(0xFF9A3C)
            .iconSet(SAND)
            .dust(1)
            .components(Redstone, 1, Blaze, 2, Sulfur, 1)
            .flags(DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_RECIPES)
            .liquid()
            .buildAndRegister();


    public static final Material Blizz = new Material.Builder(EVMain.id("blizz"))
            .color(0x01F3F6)
            .iconSet(DULL)
            .dust(1)
            .components(Redstone, 1, Water, 1)
            .flags(NO_SMELTING, MORTAR_GRINDABLE)
            .liquid()
            .buildAndRegister();

    public static final Material Cryotheum = new Material.Builder(EVMain.id("cryotheum"))

            .color(0x01F3F6)
            .iconSet(SAND)
            .dust(1)
            .components(Redstone, 1, Blizz, 2, Water, 1)
            .flags(DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_RECIPES)
            .liquid()
            .buildAndRegister();

    public static final Material Adamantium = new Material.Builder(EVMain.id("adamantium"))
            .color(0x2d365c)
            .element(Ad)
            .iconSet(SHINY).ingot(7).liquid().appendFlags(CORE_METAL).blastTemp(10850)
            .flags(DISABLE_AUTOGEN_MIXER)
            .buildAndRegister()
            .setFormula("Ad", true);


    public static final Material Vibranium = new Material.Builder(EVMain.id("vibranium")).color(0x828aad).iconSet(SHINY).ingot(7).liquid().appendFlags(CORE_METAL).blastTemp(11220).buildAndRegister();
    public static final Material Taranium = new Material.Builder(EVMain.id("taranium")).color(0x0c0c0d).iconSet(SHINY).ingot().liquid().appendFlags(CORE_METAL).flags(DISABLE_AUTOGEN_MIXER).blastTemp(10000).buildAndRegister();
    public static final Material MetastableOganesson = new Material.Builder(EVMain.id("metastable_oganesson")).color(0xE61C24).iconSet(SHINY).ingot().liquid().appendFlags(CORE_METAL).element(Og).blastTemp(10380).buildAndRegister();
    public static final Material MetastableFlerovium = new Material.Builder(EVMain.id("metastable_flerovium")).color(0x521973).iconSet(SHINY).ingot().liquid().appendFlags(CORE_METAL).element(Fl).blastTemp(10990).buildAndRegister();
    public static final Material MetastableHassium = new Material.Builder(EVMain.id("metastable_hassium")).fluid().color(0x2d3a9d).iconSet(SHINY).ingot(6).appendFlags(CORE_METAL).element(Hs).blastTemp(11240).buildAndRegister();


    public static final Material FluorinatedEthylenePropylene = new Material.Builder(EVMain.id("fluorinated_ethylene_propylene"))
            .color(0xC8C8C8)
            .iconSet(DULL)
            .ingot(1)
            .liquid()
            .components(Carbon, 5, Fluorine, 10)
            .flags(GENERATE_PLATE, FLAMMABLE, NO_SMASHING, DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material EglinSteelBase = new Material.Builder(EVMain.id("eglin_steel_base"))
            .color(0x8B4513)
            .iconSet(SAND)
            .dust(6)
            .components(Iron, 4, Kanthal, 1, Invar, 5)
            .buildAndRegister();

    public static final Material EglinSteel = new Material.Builder(EVMain.id("eglin_steel"))
            .color(0x8B4513)
            .iconSet(METALLIC)
            .ingot(6)
            .components(EglinSteelBase, 10, Sulfur, 1, Silicon, 1, Carbon, 1)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(1048)
            .buildAndRegister();

    public static final Material Grisium = new Material.Builder(EVMain.id("grisium"))
            .color(0x355D6A)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Titanium, 9, Carbon, 9, Potassium, 9, Lithium, 9, Sulfur, 9, Hydrogen, 5)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(3850)
            .buildAndRegister();

    public static final Material Inconel625 = new Material.Builder(EVMain.id("inconel_a"))
            .color(0x80C880)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Nickel, 3, Chromium, 7, Molybdenum, 10, Invar, 10, Nichrome, 13)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(2425)
            .buildAndRegister();

    public static final Material MaragingSteel250 = new Material.Builder(EVMain.id("maraging_steel_a"))
            .color(0x92918D)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Steel, 16, Molybdenum, 1, Titanium, 1, Nickel, 4, Cobalt, 2)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(2413)
            .buildAndRegister();


    public static final Material Staballoy = new Material.Builder(EVMain.id("staballoy"))
            .color(0x444B42)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Uranium238, 9, Titanium, 1)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME, DISABLE_DECOMPOSITION)
            .blastTemp(3450)
            .buildAndRegister();

    public static final Material HastelloyN = new Material.Builder(EVMain.id("hastelloy_n"))
            .color(0xDDDDDD)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Yttrium, 2, Molybdenum, 4, Chromium, 2, Titanium, 2, Nickel, 15)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME, GENERATE_DENSE)
            .blastTemp(4350)
            .buildAndRegister();

    public static final Material Tumbaga = new Material.Builder(EVMain.id("tumbaga"))
            .color(0xFFB20F)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Gold, 7, Bronze, 3)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(1200)
            .buildAndRegister();

    public static final Material Stellite = new Material.Builder(EVMain.id("stellite"))
            .color(0x9991A5)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Cobalt, 9, Chromium, 9, Manganese, 5, Titanium, 2)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(4310)
            .buildAndRegister();

    public static final Material Talonite = new Material.Builder(EVMain.id("talonite"))
            .color(0x9991A5)
            .iconSet(SHINY)
            .ingot(6)
            .components(Cobalt, 4, Chromium, 3, Phosphorus, 2, Molybdenum, 1)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(3454)
            .buildAndRegister();

    public static final Material LVSuperconductorBase = new Material.Builder(EVMain.id("lv_superconductor_base"))
            .color(0x535353)
            .iconSet(SHINY)
            .ingot(1)
            .components(Tin, 9, Antimony, 1, Gallium, 2)
            .flags(AUTOGEN_MIXER_RECIPE)
            .blastTemp(1000)
            .buildAndRegister();

    public static final Material MVSuperconductorBase = new Material.Builder(EVMain.id("mv_superconductor_base"))
            .color(0x535353)
            .iconSet(SHINY)
            .ingot(1)
            .components(Cadmium, 5, Magnesium, 1, Oxygen, 6)
            .flags(AUTOGEN_MIXER_RECIPE)
            .blastTemp(1200)
            .buildAndRegister();

    public static final Material HVSuperconductorBase = new Material.Builder(EVMain.id("hv_superconductor_base"))
            .color(0x4a2400)
            .iconSet(SHINY)
            .ingot(1)
            .components(Titanium, 1, Barium, 9, Copper, 10, Oxygen, 20)
            .flags(AUTOGEN_MIXER_RECIPE)
            .blastTemp(3300)
            .buildAndRegister();


    public static final Material IVSuperconductorBase = new Material.Builder(EVMain.id("iv_superconductor_base"))
            .color(0x300030)
            .iconSet(SHINY)
            .ingot(1)
            .components(Vanadium, 1, Indium, 3)
            .flags(AUTOGEN_MIXER_RECIPE)
            .blastTemp(5200)
            .buildAndRegister();


    public static final Material ZPMSuperconductorBase = new Material.Builder(EVMain.id("zpm_superconductor_base"))
            .color(0x111111)
            .iconSet(SHINY)
            .ingot(1)
            .components(Naquadah, 4, Indium, 2, Palladium, 6, Osmium, 1)
            .flags(AUTOGEN_MIXER_RECIPE)
            .blastTemp(8100)
            .buildAndRegister();

    public static final Material MVSuperconductor = new Material.Builder(EVMain.id("mv_superconductor"))
            .color(0x535353)
            .iconSet(SHINY)
            .ingot(1)
            .cableProperties(128, 1, 0, true)
            .components(MVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HVSuperconductor = new Material.Builder(EVMain.id("hv_superconductor"))
            .color(0x4a2400)
            .iconSet(SHINY)
            .ingot(1)
            .cableProperties(512, 1, 0, true)
            .components(HVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material EVSuperconductor = new Material.Builder(EVMain.id("ev_superconductor"))
            .color(0x005800)
            .iconSet(SHINY)
            .ingot(1)
            .cableProperties(2048, 1, 0, true)
            .components(UraniumTriplatinum, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material IVSuperconductor = new Material.Builder(EVMain.id("iv_superconductor"))
            .color(0x300030)
            .iconSet(SHINY)
            .ingot(1)
            .cableProperties(8192, 1, 0, true)
            .components(IVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material ZPMSuperconductor = new Material.Builder(EVMain.id("zpm_superconductor"))
            .color(0x111111)
            .iconSet(SHINY)
            .ingot(1)
            .cableProperties(131072, 1, 0, true)
            .components(ZPMSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Enderium = new Material.Builder(EVMain.id("enderium"))
            .color(0x23524a)
            .iconSet(METALLIC)
            .ingot(3)
            .components(Lead, 3, Platinum, 1, EnderPearl, 1)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material Nitinol60 = new Material.Builder(EVMain.id("nitinol_a"))
            .color(0xCCB0EC)
            .iconSet(METALLIC)
            .ingot(4)
            .components(Nickel, 2, Titanium, 3)
            .flags(GENERATE_FRAME)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material BabbittAlloy = new Material.Builder(EVMain.id("babbitt_alloy"))
            .color(0xA19CA4)
            .iconSet(METALLIC)
            .ingot(4)
            .components(Tin, 5, Lead, 36, Antimony, 8, Arsenic, 1)
            .flags(GENERATE_FRAME)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material HG1223 = new Material.Builder(EVMain.id("hg_alloy"))
            .color(0x245397)
            .iconSet(METALLIC)
            .ingot(4)
            .components(Mercury, 1, Barium, 2, Calcium, 2, Copper, 3, Oxygen, 8)
            .flags(GENERATE_FRAME, GENERATE_DENSE)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material IncoloyMA956 = new Material.Builder(EVMain.id("incoloy_ma"))
            .color(0xAABEBB)
            .iconSet(METALLIC)
            .ingot(4)
            .components(Iron, 16, Aluminium, 3, Chromium, 5, Yttrium, 1)
            .flags(GENERATE_FRAME)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();


    public static final Material ZirconiumCarbide = new Material.Builder(EVMain.id("zirconium_carbide"))
            .color(0xFFDACD)
            .iconSet(SHINY)
            .ingot(2)
            .components(Zirconium, 1, Carbon, 1)
            .flags(GENERATE_FRAME)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material Fermium257 = new Material.Builder(EVMain.id("fermium_257"))
            .ingot().liquid()
            .color(0x984ACF).iconSet(METALLIC)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .element(Fm257)
            .buildAndRegister()
            .setFormula("Fm257", true);

    public static final Material Fermium258 = new Material.Builder(EVMain.id("fermium_258"))
            .ingot().liquid()
            .color(0x984ACF).iconSet(METALLIC)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_NUCLEAR, FISSILE)
            .element(Fm258)
            .buildAndRegister()
            .setFormula("Fm258", true);

    public static final Material Mendelevium259 = new Material.Builder(EVMain.id("mendelevium_259"))
            .ingot().liquid()
            .color(Mendelevium.getMaterialRGB()).iconSet(METALLIC)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_NUCLEAR)
            .element(Md259)
            .buildAndRegister()
            .setFormula("Md-259", true);

    public static final Material Mendelevium261 = new Material.Builder(EVMain.id("mendelevium_261"))
            .ingot().liquid()
            .color(Mendelevium.getMaterialRGB()).iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .appendFlags(EXT2_METAL)
            .element(Md261)
            .buildAndRegister()
            .setFormula("Md-261", true);

    public static final Material Mendelevium263 = new Material.Builder(EVMain.id("mendelevium_263"))
            .ingot().liquid()
            .color(Mendelevium.getMaterialRGB()).iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Md263)
            .buildAndRegister()
            .setFormula("Md-263", true);


    public static final Material GoldAlloy = new Material.Builder(EVMain.id("gold_alloy"))
            .color(0xBBA52B)
            .iconSet(SHINY)
            .ingot(2)
            .components(Copper, 3, Gold, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PreciousMetal = new Material.Builder(EVMain.id("precious_metal"))
            .color(0xB99023)
            .iconSet(SHINY)
            .ingot(2).ore()
            .components(Gold, 1, RareEarth, 1)
            .buildAndRegister();

    public static final Material LithiumFluoride = new Material.Builder(EVMain.id("lithium_fluoride"))
            .color(0x757575)
            .iconSet(SHINY)
            .ingot(2)
            .components(Lithium, 1, Fluorine, 1)
            .buildAndRegister(); // LithiumHydroxide + Hydrogen = LithiumFluoride

    public static final Material BerylliumFluoride = new Material.Builder(EVMain.id("beryllium_fluoride"))
            .color(0x757575)
            .iconSet(SHINY)
            .ingot(2)
            .components(Beryllium, 1, Fluorine, 2)
            .buildAndRegister();

    public static final Material LeadBismuthEutectic = new Material.Builder(EVMain.id("lead_bismuth_eutatic"))
            .color(0x757575)
            .iconSet(SHINY)
            .ingot(2).liquid()
            .components(Lead, 3, Bismuth, 7)
            .flags()
            .buildAndRegister();

    public static final Material AbyssalAlloy = new Material.Builder(EVMain.id("abyssal_alloy"))
            .color(0x9E706A)
            .iconSet(METALLIC)
            .ingot(6)
            .components(StainlessSteel, 5, TungstenCarbide, 5, Nichrome, 5, Bronze, 5, IncoloyMA956, 5, Iodine, 1, Germanium, 1, Radon, 1)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material ReactorSteel = new Material.Builder(EVMain.id("reactor_steel"))
            .color(0xB4B3B0)
            .iconSet(SHINY)
            .ingot(2)
            .components(Iron, 15, Niobium, 1, Vanadium, 4, Carbon, 2)
            .flags(DISABLE_DECOMPOSITION, GENERATE_DENSE)
            .buildAndRegister();

    public static final Material Incoloy813 = new Material.Builder(EVMain.id("incoloy813"))
            .color(0x37bf7e)
            .iconSet(SHINY)
            .ingot(2)
            .components(VanadiumSteel, 4, Osmiridium, 2, Technetium, 3, Germanium, 4, Iridium, 7, Duranium, 5, Uranium238, 1) // Changed Uranium to Uranium238
            .flags(GENERATE_FRAME, DISABLE_DECOMPOSITION)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();


    public static final Material HastelloyX78 = new Material.Builder(EVMain.id("hastelloy_x78"))
            .color(0x6ba3e3)
            .iconSet(SHINY)
            .ingot(2)
            .components(NaquadahAlloy, 10, Rhenium, 5, Naquadria, 4, Gadolinium, 3, Strontium, 2, Polonium, 3, Rutherfordium, 2, Fermium258, 1)
            .flags(GENERATE_FRAME, DISABLE_DECOMPOSITION)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material HastelloyK243 = new Material.Builder(EVMain.id("hastelloy_k243"))
            .color(0xa5f564)
            .iconSet(SHINY)
            .ingot(2)
            .components(HastelloyX78, 5, NiobiumNitride, 2, Tritanium, 4, TungstenCarbide, 4, Promethium, 4, Mendelevium261, 1)
            .flags(GENERATE_FRAME, DISABLE_DECOMPOSITION)
            .appendFlags(EXT2_METAL)
            .buildAndRegister();

    public static final Material Polyetheretherketone = new Material.Builder(EVMain.id("polyetheretherketone"))
            .color(0x403e37)
            .iconSet(DULL)
            .ingot(2)
            .fluid()
            .components(Carbon, 20, Hydrogen, 12, Oxygen, 3)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, NO_SMASHING, GENERATE_FOIL, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Zylon = new Material.Builder(EVMain.id("zylon"))
            .color(0xFFE000)
            .iconSet(SHINY)
            .ingot(2)
            .fluid()
            .components(Carbon, 14, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, NO_SMASHING, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material FullerenePolymerMatrix = new Material.Builder(EVMain.id("fullerene_polymer_matrix"))
            .color(0x403e37)
            .iconSet(DULL)
            .ingot(2)
            .fluid()
            .components(Palladium, 1, Iron, 1, Carbon, 153, Hydrogen, 36, Nitrogen, 1, Oxygen, 2)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, NO_SMASHING, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material CarbonNanotubes = new Material.Builder(EVMain.id("carbon_nanotubes"))
            .color(0x2c2c2c)
            .iconSet(SHINY)
            .ingot(5)
            .components(Carbon, 1)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, NO_SMASHING, GENERATE_FOIL, DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
            .buildAndRegister();

    public static final Material BlackTitanium = new Material.Builder(EVMain.id("black_titanium"))
            .color(0x6C003B)
            .iconSet(SHINY)
            .fluid()
            .ingot(7)
            .components(Titanium, 26, Lanthanum, 6, Tungsten, 4, Cobalt, 3, Manganese, 2, Phosphorus, 2, Palladium, 2, Niobium, 1, Argon, 5)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material TungstenTitaniumCarbide = new Material.Builder(EVMain.id("tungsten_titanium_carbide"))
            .color(0x800d0d)
            .iconSet(SHINY)
            .ingot(7)
            .components(TungstenCarbide, 7, Titanium, 3)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();


    public static final Material Inconel792 = new Material.Builder(EVMain.id("inconel_b"))
            .color(0x6CF076)
            .iconSet(SHINY)
            .ingot(5)
            .components(Nickel, 2, Niobium, 1, Aluminium, 2, Nichrome, 1)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material Pikyonium = new Material.Builder(EVMain.id("pikyonium"))
            .color(0x3467BA)
            .iconSet(SHINY)
            .ingot(7)
            .components(Inconel792, 8, EglinSteel, 5, NaquadahEnriched, 4, Cerium, 3, Antimony, 2, Platinum, 2, Ytterbium, 1, TungstenSteel, 4)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material Lafium = new Material.Builder(EVMain.id("lafium"))
            .color(0x0d0d60)
            .iconSet(SHINY)
            .ingot(7)
            .components(HastelloyN, 8, Naquadah, 4, Samarium, 2, Tungsten, 4, Argon, 2, Aluminium, 6, Nickel, 8, Carbon, 2)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material Zeron100 = new Material.Builder(EVMain.id("zeron"))
            .color(0xB4B414)
            .iconSet(SHINY)
            .ingot(5)
            .components(Chromium, 13, Nickel, 3, Molybdenum, 2, Copper, 10, Tungsten, 2, Steel, 20)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material Cinobite = new Material.Builder(EVMain.id("cinobite"))
            .color(0x010101)
            .iconSet(SHINY)
            .ingot(5)
            .fluid()
            .components(Zeron100, 8, Naquadria, 4, Gadolinium, 3, Aluminium, 2, Mercury, 1, Tin, 1, Titanium, 6, Osmiridium, 1)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();


    public static final Material ProtoAdamantium = new Material.Builder(EVMain.id("proto_adamantium"))
            .color(0x4662d4)
            .iconSet(SHINY)
            .ingot(7)
            .components(Adamantium, 3, Promethium, 2)
            .flags()
            .fluid()
            .appendFlags(CORE_METAL)
            .blastTemp(11244)
            .buildAndRegister();


    public static final Material TriniumTitanium = new Material.Builder(EVMain.id("trinium_titanium"))
            .color(0x9986a3)
            .iconSet(SHINY)
            .ingot(7)
            .fluid()
            .components(Trinium, 2, Titanium, 1)
            .flags()
            .appendFlags(CORE_METAL)
            .blastTemp(11000)
            .buildAndRegister();

    public static final Material LithiumTitanate = new Material.Builder(EVMain.id("lithium_titanate"))
            .color(0xfe71a9)
            .iconSet(SHINY)
            .ingot(5)
            .components(Lithium, 2, Titanium, 1, Oxygen, 3)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material Titanium50 = new Material.Builder(EVMain.id("titanium50")).fluid()
            .color(Titanium.getMaterialRGB())
            .iconSet(SHINY)
            .ingot(5)
            .flags()
            .buildAndRegister();

    public static final Material ElectricallyImpureCopper = new Material.Builder(EVMain.id("electrically_impure_copper"))
            .color(0x765A30)
            .iconSet(DULL)
            .ingot(2)
            .components(Copper, 1, RareEarth, 1)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Polyurethane = new Material.Builder(EVMain.id("polyurethane")).fluid()
            .color(0xeffcef)
            .iconSet(DULL)
            .ingot(2)
            .components(Carbon, 17, Hydrogen, 16, Nitrogen, 2, Oxygen, 4)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, GENERATE_ROD, NO_SMASHING, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material ThoriumDopedTungsten = new Material.Builder(EVMain.id("thoria_doped_tungsten"))
            .color(Tungsten.getMaterialRGB())
            .iconSet(SHINY)
            .ingot(2)
            .components(Thorium, 1, Tungsten, 9)
            .flags(GENERATE_ROD, GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material WoodsGlass = new Material.Builder(EVMain.id("woods_glass")).fluid()
            .color(0x730099)
            .iconSet(SHINY)
            .ingot(2)
            .components(SiliconDioxide, 1, Barium, 1, Oxygen, 1, Garnierite, 1, SodaAsh, 1)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material BariumTitanate = new Material.Builder(EVMain.id("barium_titanate"))
            .color(0x99FF99)
            .iconSet(SHINY)
            .ingot(2)
            .components(Barium, 1, Titanium, 1, Oxygen, 3)
            .flags(GENERATE_FOIL, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material TantalumHafniumSeaborgiumCarbide = new Material.Builder(EVMain.id("tantalum_hafnium_seaborgium_carbide"))
            .color(0x2c2c2c)
            .iconSet(SHINY)
            .ingot(6)
            .components(Tantalum, 12, Hafnium, 3, Seaborgium, 1, Carbon, 16)
            .flags(GENERATE_PLATE, EXCLUDE_BLOCK_CRAFTING_RECIPES, DISABLE_DECOMPOSITION)
            .liquid()
            .buildAndRegister();

    public static final Material BismuthRuthenate = new Material.Builder(EVMain.id("bismuth_ruthenate"))
            .color(0x94cf5c)
            .iconSet(DULL)
            .ingot(2)
            .components(Bismuth, 2, Ruthenium, 2, Oxygen, 7)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material GermaniumTungstenNitride = new Material.Builder(EVMain.id("germanium_tungsten_nitride"))
            .color(0x8f8fcf)
            .iconSet(DULL)
            .ingot(2)
            .components(Germanium, 3, Tungsten, 3, Nitrogen, 10)
            .flags(GENERATE_PLATE)
            .liquid()
            .buildAndRegister();

    public static final Material BismuthIridiate = new Material.Builder(EVMain.id("bismuth_iridiate"))
            .color(0x478a6b)
            .iconSet(DULL)
            .ingot(5)
            .components(Bismuth, 2, Iridium, 2, Oxygen, 7)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PEDOT = new Material.Builder(EVMain.id("pedot"))
            .color(0x5cef20)
            .iconSet(DULL)
            .ingot(5)
            .components(Carbon, 6, Hydrogen, 6, Oxygen, 2, Sulfur, 1)
            .flags(GENERATE_FINE_WIRE, DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material LithiumNiobate = new Material.Builder(EVMain.id("lithium_niobate"))
            .color(0xcfcf3a)
            .iconSet(SHINY)
            .ingot(6)
            .components(Lithium, 1, Niobium, 1, Oxygen, 4)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HeavyQuarkDegenerateMatter = new Material.Builder(EVMain.id("heavy_quark_degenerate_matter")).fluid()
            .color(0x5dbd3a)
            .iconSet(SHINY)
            .ingot(6)
            .appendFlags(CORE_METAL)
            .flags(DISABLE_AUTOGEN_MIXER)
            .buildAndRegister();

    public static final Material SuperheavyHAlloy = new Material.Builder(EVMain.id("superheavy_h_alloy"))
            .color(0xE84B36)
            .iconSet(SHINY)
            .ingot(6)
            .liquid()
            .components(Copernicium, 1, Nihonium, 1, MetastableFlerovium, 1, Moscovium, 1, Livermorium, 1, Tennessine, 1, MetastableOganesson, 1)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SuperheavyLAlloy = new Material.Builder(EVMain.id("superheavy_l_alloy"))
            .color(0x2B45DF)
            .iconSet(SHINY)
            .ingot(6)
            .fluid()
            .components(Rutherfordium, 1, Dubnium, 1, Seaborgium, 1, Bohrium, 1, MetastableHassium, 1, Meitnerium, 1, Roentgenium, 1)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material QCDMatter = new Material.Builder(EVMain.id("qcd_confined_matter"))
            .color(0xeb9e3f)
            .iconSet(SHINY)
            .ingot(7)
            .fluid()
            .flags(GENERATE_PLATE, NO_WORKING, NO_SMELTING, NO_SMASHING, GENERATE_FRAME, GENERATE_ROD)
            .buildAndRegister();

    public static final Material Periodicium = new Material.Builder(EVMain.id("periodicium")).fluid()
            .color(0x3d4bf6)
            .iconSet(SHINY)
            .ingot(6)
            .components(Hydrogen, 1, Helium, 1, Lithium, 1, Beryllium, 1, Boron, 1, Carbon, 1, Nitrogen, 1, Oxygen, 1, Fluorine, 1, Neon, 1,
                    Sodium, 1, Magnesium, 1, Aluminium, 1, Silicon, 1, Phosphorus, 1, Sulfur, 1, Chlorine, 1, Argon, 1, Potassium, 1, Calcium, 1,
                    Scandium, 1, Titanium, 1, Vanadium, 1, Chromium, 1, Manganese, 1, Iron, 1, Cobalt, 1, Nickel, 1, Copper, 1, Zinc, 1,
                    Gallium, 1, Germanium, 1, Arsenic, 1, Selenium, 1, Bromine, 1, Krypton, 1, Rubidium, 1, Strontium, 1, Yttrium, 1,
                    Zirconium, 1, Niobium, 1, Molybdenum, 1, Technetium, 1, Ruthenium, 1, Rhodium, 1, Palladium, 1, Silver, 1, Cadmium, 1,
                    Indium, 1, Tin, 1, Antimony, 1, Tellurium, 1, Iodine, 1, Xenon, 1, Caesium, 1, Barium, 1, Lanthanum, 1, Cerium, 1,
                    Praseodymium, 1, Neodymium, 1, Promethium, 1, Samarium, 1, Europium, 1, Gadolinium, 1, Terbium, 1, Dysprosium, 1,
                    Holmium, 1, Erbium, 1, Thulium, 1, Ytterbium, 1, Lutetium, 1, Hafnium, 1, Tantalum, 1, Tungsten, 1, Rhenium, 1,
                    Osmium, 1, Iridium, 1, Platinum, 1, Gold, 1, Mercury, 1, Thallium, 1, Lead, 1, Bismuth, 1, Polonium, 1, Astatine, 1,
                    Radon, 1, Francium, 1, Radium, 1, Actinium, 1, Thorium, 1, Protactinium, 1, Uranium238, 1, Neptunium, 1, Plutonium239, 1,
                    Americium, 1, Curium, 1, Berkelium, 1, Californium, 1, Einsteinium, 1, Fermium, 1, Mendelevium, 1, Rutherfordium, 1,
                    Dubnium, 1, Seaborgium, 1, Bohrium, 1, MetastableHassium, 1, Meitnerium, 1, Roentgenium, 1, Copernicium, 1,
                    Nihonium, 1, MetastableFlerovium, 1, Moscovium, 1, Livermorium, 1, Tennessine, 1, MetastableOganesson, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material CosmicNeutronium = new Material.Builder(EVMain.id("cosmic_neutronium"))
            .color(0x323232)
            .iconSet(SHINY)
            .ingot(7)
            .components(Neutronium, 1)
            .cableProperties(VA[MAX], 32, 32)
            .flags(DISABLE_DECOMPOSITION, DISABLE_AUTOGEN_MIXER)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material NaquadriaticTaranium = new Material.Builder(EVMain.id("naquadriatic_taranium"))
            .color((Naquadria.getMaterialRGB() + Taranium.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .ingot(1)
            .components(Naquadria, 1, Taranium, 1)
            .flags(GENERATE_LONG_ROD)
            .appendFlags(STD_METAL)
            .buildAndRegister();

    public static final Material Polyimide = new Material.Builder(EVMain.id("polyimide"))
            .color(0xFF7F50)
            .iconSet(DULL)
            .ingot(1).fluid()
            .components(Carbon, 22, Hydrogen, 12, Nitrogen, 2, Oxygen, 6)
            .flags(GENERATE_PLATE, FLAMMABLE, NO_SMASHING)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material NeutralMatter = new Material.Builder(EVMain.id("neutral_matter"))
            .color(3956968)
            .iconSet(FLUID)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PositiveMatter = new Material.Builder(EVMain.id("positive_matter"))
            .color(11279131)
            .iconSet(FLUID)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material IronChloride = new Material.Builder(EVMain.id("iron_chloride"))
            .color(0x060b0b)
            .iconSet(FLUID)
            .fluid()
            .components(Iron, 1, Chlorine, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HighPressureSteam = new Material.Builder(EVMain.id("high_pressure_steam"))
            .color(0xFFFFFF)
            .iconSet(FLUID)
            .fluid()
            .components(Water, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material EthylTertButylEther = new Material.Builder(EVMain.id("ethyl_tert_butyl_ether"))
            .color(0xCBCBCB)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material RocketFuelH8N4C2O4 = new Material.Builder(EVMain.id("rocket_fuel_a"))
            .color(0x5ECB22)
            .iconSet(FLUID)
            .fluid()
            .components(Hydrogen, 8, Nitrogen, 4, Carbon, 2, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material CoalTarOil = new Material.Builder(EVMain.id("coal_tar_oil"))
            .color(0xB5B553)
            .iconSet(FLUID)
            .fluid()
            .components(CoalTar, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SulfuricCoalTarOil = new Material.Builder(EVMain.id("sulfuric_coal_tar_oil"))
            .color(0xFFFFAD)
            .iconSet(FLUID)
            .fluid()
            .components(CoalTarOil, 1, SulfuricAcid, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Anthracene = new Material.Builder(EVMain.id("anthracene"))
            .color(0xA2ACA2)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 14, Hydrogen, 10)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Kerosene = new Material.Builder(EVMain.id("kerosene"))
            .color(0xD570D5)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material MonoMethylHydrazine = new Material.Builder(EVMain.id("monomethylhydrazine"))
            .color(0xFFFFFF)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 1, Hydrogen, 6, Nitrogen, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Hydrazine = new Material.Builder(EVMain.id("hydrazine"))
            .color(0xFFFFFF)
            .iconSet(FLUID)
            .fluid()
            .components(Nitrogen, 2, Hydrogen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HydrogenPeroxide = new Material.Builder(EVMain.id("hydrogen_peroxide"))
            .color(0xD1FFFF)
            .iconSet(FLUID)
            .fluid()
            .components(Hydrogen, 2, Oxygen, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material EthylAnthraQuinone = new Material.Builder(EVMain.id("ethylanthraquinone"))
            .color(0xFFFF00)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material EthylAnthraHydroQuinone = new Material.Builder(EVMain.id("ethylanthrahydroquinone"))
            .color(0xFFFF47)
            .iconSet(FLUID)
            .fluid()
            .components(EthylAnthraQuinone, 1, Hydrogen, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material DenseHydrazineFuelMixture = new Material.Builder(EVMain.id("dense_hydrazine_fuel_mixture"))
            .color(0x5E2B4A)
            .iconSet(FLUID)
            .fluid()
            .components(Hydrazine, 1, Methanol, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RocketFuelCN3H7O3 = new Material.Builder(EVMain.id("rocket_fuel_b"))
            .color(0xBE46C5)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 1, Nitrogen, 3, Hydrogen, 7, Oxygen, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RP1RocketFuel = new Material.Builder(EVMain.id("rocket_fuel_c"))
            .color(0xFF503C)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1, Oxygen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RP1 = new Material.Builder(EVMain.id("rp"))
            .color(0xFF6E5D)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material FermentationBase = new Material.Builder(EVMain.id("fermentation_base"))
            .color(0x3D5917)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material LiquidHydrogen = new Material.Builder(EVMain.id("liquid_hydrogen"))
            .color(0x3AFFC6)
            .iconSet(FLUID)
            .fluid()
            .components(Hydrogen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumConcentrate = new Material.Builder(EVMain.id("platinum_concentrate"))
            .color(Platinum.getMaterialRGB())
            .iconSet(FLUID)
            .fluid()
            .components(Platinum, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material PalladiumAmmonia = new Material.Builder(EVMain.id("palladium_enriched_ammonia"))
            .color(Platinum.getMaterialRGB())
            .iconSet(FLUID)
            .fluid()
            .components(Palladium, 1, Ammonia, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SodiumFormate = new Material.Builder(EVMain.id("sodium_formate"))
            .color(0xFFAAAA)
            .iconSet(FLUID)
            .fluid()
            .components(Hydrogen, 1, Carbon, 1, Oxygen, 2, Sodium, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material RhodiumSulfateSolution = new Material.Builder(EVMain.id("rhodium_sulfate_solution"))
            .color(0xFFBB66)
            .iconSet(FLUID)
            .fluid()
            .components(RhodiumSulfate, 1, Water, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RutheniumTetroxideSolution = new Material.Builder(EVMain.id("ruthenium_tetroxide_solution"))
            .color(0xC7C7C7)
            .iconSet(FLUID)
            .fluid()
            .components(Salt, 2, Ruthenium, 1, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HotRutheniumTetroxideSolution = new Material.Builder(EVMain.id("hot_ruthenium_tetroxide_solution"))
            .color(0xC7C7C7)
            .iconSet(FLUID)
            .fluid()
            .components(RutheniumTetroxideSolution, 1, Water, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material OsmiumSolution = new Material.Builder(EVMain.id("osmium_solution"))
            .color((Osmium.getMaterialRGB() + Water.getMaterialRGB()) / 2)
            .iconSet(FLUID)
            .fluid()
            .components(Osmium, 1, Oxygen, 4, Water, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material IridiumDioxide = new Material.Builder(EVMain.id("iridium_dioxide"))
            .color((Iridium.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .components(Iridium, 1, Oxygen, 2)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES)
            .liquid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material AcidicIridiumSolution = new Material.Builder(EVMain.id("acidic_iridium_solution"))
            .color(IridiumDioxide.getMaterialRGB() - 20)
            .iconSet(FLUID)
            .fluid()
            .components(HydrochloricAcid, 2, IridiumDioxide, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RhodiumSaltSolution = new Material.Builder(EVMain.id("rhodium_salt_solution"))
            .color(0x667788)
            .iconSet(FLUID)
            .fluid()
            .components(Rhodium, 1, Salt, 2, Chlorine, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RhodiumFilterCakeSolution = new Material.Builder(EVMain.id("rhodium_filter_cake_solution"))
            .color(0x667788)
            .iconSet(FLUID)
            .fluid()
            .components(Rhodium, 1, Water, 2, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material Diphenylisophtalate = new Material.Builder(EVMain.id("diphenylisophtalate"))
            .color(0x246E57)
            .iconSet(DULL)
            .fluid()
            .components(Carbon, 20, Hydrogen, 14, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material SodiumTungstate = new Material.Builder(EVMain.id("sodium_tungstate"))
            .color(0x7A7777)
            .iconSet(FLUID)
            .fluid()
            .components(Sodium, 2, Tungsten, 1, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material IodizedOil = new Material.Builder(EVMain.id("iodized_oil"))
            .color(0x666666)
            .iconSet(FLUID)
            .fluid()
            .buildAndRegister();

    public static final Material CubicZirconia = new Material.Builder(EVMain.id("cubic_zirconia"))
            .color(0xFFDFE2)
            .iconSet(DIAMOND)
            .gem()
            .components(Zirconium, 1, Oxygen, 2)
            .flags(GENERATE_PLATE, NO_SMELTING, GENERATE_LENS)
            .buildAndRegister();

    public static final Material Prasiolite = new Material.Builder(EVMain.id("prasiolite"))
            .color(0x9EB749)
            .iconSet(QUARTZ)
            .gem()
            .components(Silicon, 5, Oxygen, 10, Iron, 1)
            .flags(GENERATE_PLATE, GENERATE_LENS)
            .buildAndRegister();

    public static final Material BismuthTellurite = new Material.Builder(EVMain.id("bismuth_tellurite"))
            .color(0x006B38)
            .iconSet(SAND)
            .dust()
            .components(Bismuth, 2, Tellurium, 3)
            .buildAndRegister();

    public static final Material MagnetoResonatic = new Material.Builder(EVMain.id("magneto_resonatic"))
            .color(0xFF97FF)
            .iconSet(MAGNETIC)
            .gem()
            .components(Prasiolite, 3, BismuthTellurite, 6, CubicZirconia, 1, SteelMagnetic, 1)
            .flags(DISABLE_DECOMPOSITION, FLAMMABLE, HIGH_SIFTER_OUTPUT, NO_SMELTING, GENERATE_LENS, GENERATE_PLATE)
            .buildAndRegister();

    public static final Material RhodiumSalt = new Material.Builder(EVMain.id("rhodium_salt"))
            .color(0x848484)
            .iconSet(GEM_VERTICAL)
            .gem()
            .components(Rhodium, 1, Salt, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Zircon = new Material.Builder(EVMain.id("zircon"))
            .color(0xEB9E3F)
            .iconSet(GEM_VERTICAL)
            .gem()
            .ore()
            .components(Zirconium, 1, Silicon, 1, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material LeadZirconateTitanate = new Material.Builder(EVMain.id("lead_zirconate_titanate"))
            .color(0x359ADE)
            .iconSet(OPAL)
            .gem()
            .components(Lead, 1, Zirconium, 1, Titanium, 1, Oxygen, 3)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material AluminoSilicateWool = new Material.Builder(EVMain.id("alumino_silicate_wool"))
            .color(0xbbbbbb)
            .iconSet(SAND)
            .dust()
            .components(Aluminium, 2, Silicon, 1, Oxygen, 5)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PhthalicAnhydride = new Material.Builder(EVMain.id("phthalicanhydride"))
            .color(0xD1D1D1)
            .iconSet(SAND)
            .dust()
            .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Dibismuthhydroborat = new Material.Builder(EVMain.id("dibismuthhydroborat"))
            .color(0x00B749)
            .iconSet(SAND)
            .dust()
            .components(Bismuth, 2, Hydrogen, 1, Boron, 1)
            .buildAndRegister();


    public static final Material CircuitCompoundMK3 = new Material.Builder(EVMain.id("circuit_compound_mkc"))
            .color(0x003316)
            .iconSet(SAND)
            .dust()
            .components(IndiumGalliumPhosphide, 1, Dibismuthhydroborat, 3, BismuthTellurite, 2)
            .buildAndRegister();

    public static final Material YttriumOxide = new Material.Builder(EVMain.id("yttrium_oxide"))
            .color(0xC6EBB3)
            .iconSet(SAND)
            .dust()
            .components(Yttrium, 2, Oxygen, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Zirkelite = new Material.Builder(EVMain.id("zirkelite"))
            .color(0x6B5E6A)
            .iconSet(DULL)
            .dust()
            .ore()
            .components(Calcium, 2, Thorium, 2, Cerium, 1, Zirconium, 7, Rutile, 6, Niobium, 4, Oxygen, 10)
            .buildAndRegister();

    public static final Material PlatinumSalt = new Material.Builder(EVMain.id("platinum_salt"))
            .color(Platinum.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .components(Platinum, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumSaltRefined = new Material.Builder(EVMain.id("refined_platinum_salt"))
            .color(Platinum.getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .components(Platinum, 1, RareEarth, 1, Chlorine, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumMetallicPowder = new Material.Builder(EVMain.id("platinum_metallic_powder"))
            .color(Platinum.getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .ore()
            .components(Platinum, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumResidue = new Material.Builder(EVMain.id("platinum_residue"))
            .color(0x64632E)
            .iconSet(ROUGH)
            .dust()
            .components(Iridium, 2, RareEarth, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumRawPowder = new Material.Builder(EVMain.id("reprecipitated_platinum"))
            .color(Platinum.getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .components(Platinum, 1, Chlorine, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PalladiumMetallicPowder = new Material.Builder(EVMain.id("palladium_metallic_powder"))
            .color(Palladium.getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .ore()
            .components(Palladium, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PalladiumRawPowder = new Material.Builder(EVMain.id("reprecipitated_palladium"))
            .color(Palladium.getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .components(Palladium, 1, Ammonia, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PalladiumSalt = new Material.Builder(EVMain.id("palladium_salt"))
            .color(Palladium.getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .components(Palladium, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SodiumSulfate = new Material.Builder(EVMain.id("sodium_sulfate"))
            .color(0xFFFFFF)
            .iconSet(ROUGH)
            .dust()
            .components(Sodium, 2, Sulfur, 1, Oxygen, 4)
            .buildAndRegister();

    public static final Material PotassiumDisulfate = new Material.Builder(EVMain.id("potassium_disulfate"))
            .color(0xFBBB66)
            .iconSet(DULL)
            .dust()
            .components(Potassium, 2, Sulfur, 2, Oxygen, 7)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES)
            .liquid()
            .buildAndRegister();

    public static final Material GoldLeach = new Material.Builder(EVMain.id("gold_leach"))
            .color(0xBBA52B)
            .dust()
            .iconSet(ROUGH)
            .buildAndRegister()
            .setFormula("Cu3Au?", true);

    public static final Material LeachResidue = new Material.Builder(EVMain.id("leach_residue"))
            .color(0x644629)
            .iconSet(ROUGH)
            .dust()
            .components(Iridium, 2, RareEarth, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material SodiumRuthenate = new Material.Builder(EVMain.id("sodium_ruthenate"))
            .color(0x3A40CB)
            .iconSet(SHINY)
            .dust()
            .components(Sodium, 2, Oxygen, 4, Ruthenium, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material RutheniumDioxide = new Material.Builder(EVMain.id("ruthenium_dioxide"))
            .color(RutheniumTetroxide.getMaterialRGB())
            .iconSet(DULL)
            .ingot(2)
            .components(Ruthenium, 1, Oxygen, 2)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RarestMetalResidue = new Material.Builder(EVMain.id("rarest_metal_residue"))
            .color(0x644629)
            .iconSet(ROUGH)
            .dust()
            .ore()
            .components(Iridium, 2, Oxygen, 2, SiliconDioxide, 2, Gold, 3, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PGSDResidue = new Material.Builder(EVMain.id("sludge_dust_residue"))
            .color((SiliconDioxide.getMaterialRGB() + Gold.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components(SiliconDioxide, 2, Gold, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material PGSDResidue2 = new Material.Builder(EVMain.id("metallic_sludge_dust_residue"))
            .color((Copper.getMaterialRGB() + Nickel.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components(Copper, 1, Nickel, 1)
            .flags(DECOMPOSITION_BY_CENTRIFUGING)
            .buildAndRegister();

    public static final Material CrudeRhodiumMetal = new Material.Builder(EVMain.id("crude_rhodium_metal"))
            .color(0x666666)
            .iconSet(DULL)
            .dust()
            .components(Rhodium, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SodiumNitrate = new Material.Builder(EVMain.id("sodium_nitrate"))
            .color(0x846684)
            .iconSet(ROUGH)
            .dust()
            .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RhodiumNitrate = new Material.Builder(EVMain.id("rhodium_nitrate"))
            .color((SodiumNitrate.getMaterialRGB() + Rhodium.getMaterialRGB()) / 2)
            .iconSet(QUARTZ)
            .dust()
            .components(Rhodium, 1, Ammonia, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material ZincSulfate = new Material.Builder(EVMain.id("zinc_sulfate"))
            .color((Zinc.getMaterialRGB() + Sulfur.getMaterialRGB()) / 2)
            .iconSet(QUARTZ)
            .dust()
            .components(Zinc, 1, Sulfur, 1, Oxygen, 4)
            .buildAndRegister();

    public static final Material RhodiumFilterCake = new Material.Builder(EVMain.id("rhodium_filter_cake"))
            .color(RhodiumNitrate.getMaterialRGB() - 10)
            .iconSet(QUARTZ)
            .dust()
            .components(Rhodium, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material Triniite = new Material.Builder(EVMain.id("triniite"))
            .color(0x5F5A76)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Trinium, 3, Actinium, 3, Selenium, 4, Astatine, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SilverOxide = new Material.Builder(EVMain.id("silver_oxide"))
            .color(0x4D4D4D)
            .iconSet(DULL)
            .dust()
            .components(Silver, 2, Oxygen, 1)

            .buildAndRegister();

    public static final Material SilverChloride = new Material.Builder(EVMain.id("silver_chloride"))
            .color(0xFEFEFE)
            .iconSet(DULL)
            .dust()
            .components(Silver, 1, Chlorine, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PotassiumMetabisulfite = new Material.Builder(EVMain.id("potassium_metabisulfite"))
            .color(0xFFFFFF)
            .iconSet(DULL)
            .dust()
            .components(Potassium, 2, Sulfur, 2, Oxygen, 5)

            .buildAndRegister();

    public static final Material LeadNitrate = new Material.Builder(EVMain.id("lead_nitrate"))
            .color(0xFEFEFE)
            .iconSet(DULL)
            .dust()
            .components(Lead, 1, Nitrogen, 2, Oxygen, 6)

            .buildAndRegister();

    public static final Material SodiumPotassiumAlloy = new Material.Builder(EVMain.id("sodium_potassium_alloy"))
            .color(0x252525)
            .iconSet(SHINY)
            .dust()
            .components(Sodium, 7, Potassium, 3)
            .buildAndRegister();

    public static final Material SodiumFluoride = new Material.Builder(EVMain.id("sodium_fluoride"))
            .color((Sodium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components(Sodium, 1, Fluorine, 1)
            .buildAndRegister();

    public static final Material PotassiumFluoride = new Material.Builder(EVMain.id("potassium_fluoride"))
            .color(0xFDFDFD)
            .iconSet(DULL)
            .dust()
            .components(Potassium, 1, Fluorine, 1)
            .buildAndRegister();

    public static final Material FLiNaK = new Material.Builder(EVMain.id("flinak"))
            .color(0x252525)
            .iconSet(DULL)
            .dust()
            .fluid()
            .components(Fluorine, 3, Lithium, 1, Sodium, 1, Potassium, 1)
            .buildAndRegister();

    public static final Material FLiBe = new Material.Builder(EVMain.id("flibe"))
            .color(0x252525)
            .iconSet(DULL)
            .dust()
            .fluid()
            .components(Fluorine, 3, Lithium, 1, Beryllium, 1)
            .flags()
            .buildAndRegister();

    public static final Material OrganicFertilizer = new Material.Builder(EVMain.id("organic_fertilizer"))
            .color(0xDDDDDD)
            .iconSet(SHINY)
            .dust()
            .components(Calcium, 5, Phosphate, 3, Hydrogen, 1, Oxygen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material CalciumTungstate = new Material.Builder(EVMain.id("calcium_tungstate"))
            .color(0x6e6867)
            .iconSet(SHINY)
            .dust()
            .components(Tungsten, 1, Calcium, 1, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();


    public static final Material TungstenTrioxide = new Material.Builder(EVMain.id("tungsten_trioxide"))
            .color(0x99FF97)
            .iconSet(Tungsten.getMaterialIconSet())
            .dust()
            .components(Tungsten, 1, Oxygen, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material TungstenHexachloride = new Material.Builder(EVMain.id("tungsten_hexachloride"))
            .color(0x533f75)
            .iconSet(METALLIC)
            .dust()
            .components(Tungsten, 1, Chlorine, 6)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material NaquadricCompound = new Material.Builder(EVMain.id("naquadric_compound"))
            .color(Naquadah.getMaterialRGB())
            .iconSet(Naquadah.getMaterialIconSet())
            .dust()
            .ore()
            .components(Naquadah, 1)
            .buildAndRegister();

    public static final Material EnrichedNaquadricCompound = new Material.Builder(EVMain.id("enriched_naquadric_compound"))
            .color(NaquadahEnriched.getMaterialRGB())
            .iconSet(NaquadahEnriched.getMaterialIconSet())
            .dust()
            .ore()
            .components(NaquadahEnriched, 1)
            .buildAndRegister();

    public static final Material NaquadriaticCompound = new Material.Builder(EVMain.id("naquadriatic_compound"))
            .color(Naquadria.getMaterialRGB())
            .iconSet(Naquadria.getMaterialIconSet())
            .dust()
            .ore()
            .components(Naquadria, 1)
            .buildAndRegister();

    public static final Material Caliche = new Material.Builder(EVMain.id("caliche"))
            .color(0xeb9e3f)
            .iconSet(DULL)
            .dust()
            .ore()
            .components(SodiumNitrate, 1, Potassium, 1, Nitrogen, 1, Oxygen, 3, RockSalt, 1, Sodium, 1, Iodine, 1, Oxygen, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Rhodocrosite = new Material.Builder(EVMain.id("rhodocrosite"))
            .color(0xff6699)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Manganese, 1, Carbon, 1, Oxygen, 3)
            .buildAndRegister();

    public static final Material Fluorite = new Material.Builder(EVMain.id("fluorite")).fluid()
            .color(0x009933)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Calcium, 1, Fluorine, 2)
            .buildAndRegister();

    public static final Material Columbite = new Material.Builder(EVMain.id("columbite"))
            .color(0xCCCC00)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Iron, 1, Niobium, 2, Oxygen, 6)
            .buildAndRegister();


    public static final Material FluoroApatite = new Material.Builder(EVMain.id("fluoroapatite"))
            .color(Apatite.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .ore()
            .components(Calcium, 5, Phosphate, 3, Fluorine, 1)
            .buildAndRegister();

    public static final Material NdYAG = new Material.Builder(EVMain.id("nd_yag"))
            .color(0xcf8acf)
            .iconSet(SHINY)
            .dust()
            .fluid()
            .buildAndRegister();

    public static final Material PrHoYLF = new Material.Builder(EVMain.id("prho_ylf"))
            .color(0x6f20af)
            .iconSet(SHINY)
            .dust()
            .fluid()
            .buildAndRegister();

    public static final Material LuTmYVO = new Material.Builder(EVMain.id("lutm_yvo"))
            .color(0x206faf)
            .iconSet(SHINY)
            .dust()
            .fluid()
            .buildAndRegister();


    public static final Material Barytocalcite = new Material.Builder(EVMain.id("barytocalcite"))
            .color(0xbf9c7c)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Barium, 1, Calcium, 1, Carbon, 2, Oxygen, 6)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Witherite = new Material.Builder(EVMain.id("witherite"))
            .color(0xc6c29d)
            .iconSet(ROUGH)
            .dust()
            .ore()
            .components(Barium, 1, Carbon, 1, Oxygen, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Arsenopyrite = new Material.Builder(EVMain.id("arsenopyrite"))
            .color(0xaa9663)
            .iconSet(METALLIC)
            .dust()
            .ore()
            .components(Iron, 1, Arsenic, 1, Sulfur, 1)
            .buildAndRegister();

    public static final Material Gallite = new Material.Builder(EVMain.id("gallite"))
            .color(0x7f7b9e)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Copper, 1, Gallium, 1, Sulfur, 2)
            .buildAndRegister();

    public static final Material Bowieite = new Material.Builder(EVMain.id("bowieite"))
            .color(0x8b8995)
            .iconSet(ROUGH)
            .dust()
            .ore()
            .components(Rhodium, 1, Iridium, 1, Platinum, 1, Sulfur, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Celestine = new Material.Builder(EVMain.id("celestine"))
            .color(0x9db1b8)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Strontium, 1, Sulfur, 1, Oxygen, 4)
            .buildAndRegister();

    public static final Material NaquadricSolution = new Material.Builder(EVMain.id("naquadric_solution"))
            .fluid()
            .color(0x232225)
            .buildAndRegister()
            .setFormula("NqNO2", true);

    public static final Material EnrichedNaquadricSolution = new Material.Builder(EVMain.id("enriched_naquadric_solution"))
            .fluid()
            .color(0x312735)
            .buildAndRegister()
            .setFormula("Nq+NO2", true);

    public static final Material NaquadriaticSolution = new Material.Builder(EVMain.id("naquadriatic_solution"))
            .fluid()
            .color(0x312735)
            .buildAndRegister()
            .setFormula("*Nq*NO2", true);

    public static final Material AntimonyPentafluoride = new Material.Builder(EVMain.id("antimony_pentafluoride"))
            .fluid()
            .color(Antimony.getMaterialRGB())
            .buildAndRegister()
            .setFormula("SbF5", true);


    public static final Material FluoronaquadricAcid = new Material.Builder(EVMain.id("fluoronaquadric_acid"))
            .fluid()
            .color(0x485d60)
            .buildAndRegister()
            .setFormula("H2NqF4", true);

    public static final Material EnrichedFluoronaquadricAcid = new Material.Builder(EVMain.id("enriched_fluoronaquadric_acid"))
            .fluid()
            .color(0x485d60)
            .buildAndRegister()
            .setFormula("H2Nq+F4", true);

    public static final Material FluoronaquadriaticAcid = new Material.Builder(EVMain.id("fluoronaquadriatic_acid"))
            .fluid()
            .color(0x485d60)
            .buildAndRegister()
            .setFormula("H2*Nq*F4", true);

    public static final Material NaquadahDifluoride = new Material.Builder(EVMain.id("naquadah_difluoride"))
            .fluid()
            .color(0x324649)
            .buildAndRegister()
            .setFormula("NqF2", true);

    public static final Material EnrichedNaquadahDifluoride = new Material.Builder(EVMain.id("enriched_naquadah_difluoride"))
            .fluid()
            .color(0x141e1f)
            .buildAndRegister()
            .setFormula("Nq+F2", true);

    public static final Material NaquadriaDifluoride = new Material.Builder(EVMain.id("naquadria_difluoride"))
            .fluid()
            .color(0x141e1f)
            .buildAndRegister()
            .setFormula("*Nq*F2", true);

    public static final Material NaquadriaHexafluoride = new Material.Builder(EVMain.id("naquadria_hexafluoride"))
            .fluid()
            .color(0x111c27)
            .buildAndRegister()
            .setFormula("*Nq*F6", true);

    public static final Material RadonDifluoride = new Material.Builder(EVMain.id("radon_difluoride"))
            .fluid()
            .color(0x9966ff)
            .buildAndRegister()
            .setFormula("RnF2", true);

    public static final Material RadonNaquadriaoctafluoride = new Material.Builder(EVMain.id("radon_naquadriaoctafluoride"))
            .fluid()
            .color(0x111c27)
            .buildAndRegister()
            .setFormula("Rd*Nq*F8", true);

    public static final Material XenonTrioxide = new Material.Builder(EVMain.id("xenon_trioxide"))
            .fluid()
            .color(0x432791)
            .buildAndRegister()
            .setFormula("XeO3", true);

    public static final Material CesiumFluoride = new Material.Builder(EVMain.id("cesium_fluoride"))
            .fluid()
            .color(0xabab69)
            .buildAndRegister()
            .setFormula("CsF", true);

    public static final Material CesiumXenontrioxideFluoride = new Material.Builder(EVMain.id("cesium_xenontrioxide_fluoride"))
            .color(0x3333cc)
            .fluid()
            .buildAndRegister()
            .setFormula("CsXeO3F", true);

    public static final Material RadonTrioxide = new Material.Builder(EVMain.id("radon_trioxide"))
            .color(0x9966ff)
            .fluid()
            .buildAndRegister()
            .setFormula("RnO3", true);

    public static final Material NaquadriaCesiumXenonNonfluoride = new Material.Builder(EVMain.id("naquadria_cesium_xenon_nonfluoride"))
            .color(0x1c1c5e)
            .fluid()
            .buildAndRegister()
            .setFormula("NqCsXeF9", true);

    public static final Material NitrylFluoride = new Material.Builder(EVMain.id("nitryl_fluoride"))
            .color(NitricOxide.getMaterialRGB())
            .fluid()
            .buildAndRegister()
            .setFormula("NO2F", true);

    public static final Material NitrosoniumOctafluoroxenate = new Material.Builder(EVMain.id("nitrosonium_octafluoroxenate"))
            .color(0x3f3f83)
            .fluid()
            .buildAndRegister()
            .setFormula("(NO2)2XeF8", true);

    public static final Material NaquadriaCesiumfluoride = new Material.Builder(EVMain.id("naquadria_cesiumfluoride"))
            .color(0x636379)
            .fluid()
            .buildAndRegister()
            .setFormula("NqF2CsF", true);

    public static final Material EnrichedNaquadahhexafluoride = new Material.Builder(EVMain.id("enriched_naquadahhexafluoride"))
            .color(0x030330)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+F6", true);

    public static final Material EnrichedXenonHexafluoronaquadate = new Material.Builder(EVMain.id("enriched_xenon_hexafluoronaquadate"))
            .color(0x1e1ec2)
            .fluid()
            .buildAndRegister()
            .setFormula("XeNq+F6", true);

    public static final Material AuricChloride = new Material.Builder(EVMain.id("auric_chloride"))
            .color(0xdffb50)
            .fluid()
            .buildAndRegister()
            .setFormula("Au2Cl6", true);

    public static final Material BromineTrifluoride = new Material.Builder(EVMain.id("bromine_trifluoride"))
            .color(0xfcde1d)
            .fluid()
            .buildAndRegister()
            .setFormula("BrF3", true);

    public static final Material XenoauricFluoroantimonicAcid = new Material.Builder(EVMain.id("xenoauric_fluoroantimonic_acid"))
            .color(0x685b08)
            .fluid()
            .buildAndRegister()
            .setFormula("XeAuSbF6", true);

    public static final Material NaquadahSulfate = new Material.Builder(EVMain.id("naquadah_sulfate"))
            .color(0x38330f)
            .fluid()
            .buildAndRegister()
            .setFormula("NqSO4", true);

    public static final Material NaquadahSolution = new Material.Builder(EVMain.id("naquadah_solution"))
            .color(0x523b3a)
            .fluid()
            .buildAndRegister()
            .setFormula("NqNH4NO3", true);

    public static final Material ClearNaquadahLiquid = new Material.Builder(EVMain.id("clear_naquadah_liquid"))
            .color(0xa89f9e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq?", true);

    public static final Material ComplicatedNaquadahGas = new Material.Builder(EVMain.id("complicated_naquadah_gas"))
            .color(0x403d3d)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq??", true);

    public static final Material ComplicatedHeavyNaquadah = new Material.Builder(EVMain.id("complicated_heavy_naquadah"))
            .color(0x403d3d)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq??", true);

    public static final Material ComplicatedMediumNaquadah = new Material.Builder(EVMain.id("complicated_medium_naquadah"))
            .color(0x403d3d)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq??", true);

    public static final Material ComplicatedLightNaquadah = new Material.Builder(EVMain.id("complicated_light_naquadah"))
            .color(0x403d3d)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq??", true);

    public static final Material NaquadahGas = new Material.Builder(EVMain.id("naquadah_gas"))
            .color(0x575757)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq", true);

    public static final Material LightNaquadah = new Material.Builder(EVMain.id("light_naquadah"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq", true);

    public static final Material MediumNaquadah = new Material.Builder(EVMain.id("medium_naquadah"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq", true);

    public static final Material HeavyNaquadah = new Material.Builder(EVMain.id("heavy_naquadah"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq", true);

    public static final Material FCrackedLightNaquadah = new Material.Builder(EVMain.id("fl_cracked_light_naquadah"))
            .color(0x505e5b)
            .fluid()
            .buildAndRegister()
            .setFormula("FlNq", true);

    public static final Material FCrackedMediumNaquadah = new Material.Builder(EVMain.id("fl_cracked_medium_naquadah"))
            .color(0x505e5b)
            .fluid()
            .buildAndRegister()
            .setFormula("FlNq", true);

    public static final Material FCrackedHeavyNaquadah = new Material.Builder(EVMain.id("fl_cracked_heavy_naquadah"))
            .color(0x505e5b)
            .fluid()
            .buildAndRegister()
            .setFormula("FlNq", true);

    public static final Material LightNaquadahFuel = new Material.Builder(EVMain.id("light_naquadah_fuel"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq", true);

    public static final Material MediumNaquadahFuel = new Material.Builder(EVMain.id("medium_naquadah_fuel"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq", true);

    public static final Material HeavyNaquadahFuel = new Material.Builder(EVMain.id("heavy_naquadah_fuel"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq", true);

    public static final Material AmmoniumNitrate = new Material.Builder(EVMain.id("ammonium_nitrate"))
            .color(Ammonia.getMaterialRGB())
            .fluid()
            .buildAndRegister()
            .setFormula("NH4NO3", true);

    public static final Material ENaquadahSolution = new Material.Builder(EVMain.id("e_naquadah_solution"))
            .color(0x523b3a)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+?", true);

    public static final Material ClearENaquadahLiquid = new Material.Builder(EVMain.id("clear_e_naquadah_liquid"))
            .color(0xa89f9e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+?", true);

    public static final Material ComplicatedHeavyENaquadah = new Material.Builder(EVMain.id("complicated_heavy_e_naquadah"))
            .color(0x403d3d)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+??", true);

    public static final Material ComplicatedMediumENaquadah = new Material.Builder(EVMain.id("complicated_medium_e_naquadah"))
            .color(0x403d3d)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+??", true);

    public static final Material ComplicatedLightENaquadah = new Material.Builder(EVMain.id("complicated_light_e_naquadah"))
            .color(0x403d3d)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+??", true);

    public static final Material LightENaquadah = new Material.Builder(EVMain.id("light_e_naquadah"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+", true);

    public static final Material MediumENaquadah = new Material.Builder(EVMain.id("medium_e_naquadah"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+", true);

    public static final Material HeavyENaquadah = new Material.Builder(EVMain.id("heavy_e_naquadah"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+", true);

    public static final Material RnCrackedLightNaquadah = new Material.Builder(EVMain.id("rn_cracked_light_e_naquadah"))
            .color(0x505e5b)
            .fluid()
            .buildAndRegister()
            .setFormula("RnNq+", true);

    public static final Material RnCrackedMediumENaquadah = new Material.Builder(EVMain.id("rn_cracked_medium_e_naquadah"))
            .color(0x505e5b)
            .fluid()
            .buildAndRegister()
            .setFormula("RnNq+", true);

    public static final Material RnCrackedHeavyENaquadah = new Material.Builder(EVMain.id("rn_cracked_heavy_e_naquadah"))
            .color(0x505e5b)
            .fluid()
            .buildAndRegister()
            .setFormula("RnNq+", true);

    public static final Material LightENaquadahFuel = new Material.Builder(EVMain.id("light_e_naquadah_fuel"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+", true);

    public static final Material MediumENaquadahFuel = new Material.Builder(EVMain.id("medium_e_naquadah_fuel"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+", true);

    public static final Material HeavyENaquadahFuel = new Material.Builder(EVMain.id("heavy_e_naquadah_fuel"))
            .color(0x2e2e2e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq+", true);


    public static final Material HyperFuelI = new Material.Builder(EVMain.id("hyper_fluid_i"))
            .color(0xfaff5e)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq(Nq+)(*Nq*)RfPu", true);

    public static final Material HyperFuelII = new Material.Builder(EVMain.id("hyper_fluid_ii"))
            .color(0xd8db67)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq(Nq+)(*Nq*)DbCm", true);

    public static final Material HyperFuelIII = new Material.Builder(EVMain.id("hyper_fluid_iii"))
            .color(0x8f9146)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq(Nq+)(*Nq*)AdCf", true);

    public static final Material HyperFuelIV = new Material.Builder(EVMain.id("hyper_fluid_iv"))
            .color(0x4d4e31)
            .fluid()
            .buildAndRegister()
            .setFormula("Nq(Nq+)(*Nq*)AdCfNtTn", true);

    public static final Material AcidicSaltWater = new Material.Builder(EVMain.id("acidic_salt_water"))
            .color(0x006960)
            .fluid()
            .buildAndRegister()
            .setFormula("H2SO4(NaCl)3(H2O)3Cl2", true);

    public static final Material SulfuricBromineSolution = new Material.Builder(EVMain.id("sulfuric_bromine_solution"))
            .color(0xff5100)
            .fluid()
            .buildAndRegister()
            .setFormula("H2SO4Br(H2O)Cl2", true);

    public static final Material HotVapourMixture = new Material.Builder(EVMain.id("hot_vapour_mixture"))
            .color(0xff5100)
            .fluid()
            .buildAndRegister()
            .setFormula("H2SO4Br(H2O)2Cl2", true);

    public static final Material DampBromine = new Material.Builder(EVMain.id("damp_bromine"))
            .color(0xe17594)
            .fluid()
            .buildAndRegister()
            .setFormula("Br(H2O)", true);


    public static final Material Ethylhexanol = new Material.Builder(EVMain.id("ethylhexanol"))
            .color(0xfeea9a)
            .fluid()
            .buildAndRegister()
            .setFormula("C8H18O", true);

    public static final Material DiethylhexylPhosphoricAcid = new Material.Builder(EVMain.id("di_ethylhexyl_phosphoric_acid"))
            .color(0xffff99)
            .fluid()
            .buildAndRegister()
            .setFormula("C16H35O4P", true);

    public static final Material RareEarthHydroxidesSolution = new Material.Builder(EVMain.id("rare_earth_hydroxides_solution"))
            .color(0xcfb37d)
            .fluid()
            .buildAndRegister()
            .setFormula("NaOH(H2O)?(OH)3", true);

    public static final Material RareEarthChloridesSolution = new Material.Builder(EVMain.id("rare_earth_chlorides_solution"))
            .color(0x164b45)
            .fluid()
            .buildAndRegister()
            .setFormula("(?Cl3)H2O", true);

    public static final Material LaNdOxidesSolution = new Material.Builder(EVMain.id("la_nd_oxides_solution"))
            .color(0x9ce3db)
            .fluid()
            .buildAndRegister()
            .setFormula("(La2O3)(Pr2O3)(Nd2O3)(Ce2O3)", true);

    public static final Material SmGdOxidesSolution = new Material.Builder(EVMain.id("sm_gd_oxides_solution"))
            .color(0xffff99)
            .fluid()
            .buildAndRegister()
            .setFormula("(Sc2O3)(Eu2O3)(Gd2O3)(Sm2O3)", true);

    public static final Material TbHoOxidesSolution = new Material.Builder(EVMain.id("tb_ho_oxides_solution"))
            .color(0x99ff99)
            .fluid()
            .buildAndRegister()
            .setFormula("(Y2O3)(Tb2O3)(Dy2O3)(Ho2O3)", true);

    public static final Material ErLuOxidesSolution = new Material.Builder(EVMain.id("er_lu_oxides_solution"))
            .color(0xffb3ff)
            .fluid()
            .buildAndRegister()
            .setFormula("(Er2O3)(Tm2O3)(Yb2O3)(Lu2O3)", true);

    public static final Material SupercooledCryotheum = new Material.Builder(EVMain.id("supercooled_cryotheum"))
            .color(Cryotheum.getMaterialRGB() - 10)
            .fluid()
            .buildAndRegister();

    public static final Material Turpentine = new Material.Builder(EVMain.id("turpentine"))
            .color(0x93bd46)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H16", true);

    public static final Material Acetylene = new Material.Builder(EVMain.id("acetylene"))
            .color(0x959c60)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H2", true);


    public static final Material PropargylAlcohol = new Material.Builder(EVMain.id("propargyl_alcohol"))
            .color(0xbfb32a)
            .fluid()
            .buildAndRegister()
            .setFormula("CHCCH2OH", true);

    public static final Material PropargylChloride = new Material.Builder(EVMain.id("propargyl_chloride"))
            .color(0x918924)
            .fluid()
            .buildAndRegister()
            .setFormula("HC2CH2Cl", true);

    public static final Material Citral = new Material.Builder(EVMain.id("citral"))
            .color(0xf2e541)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H16O", true);

    public static final Material BetaIonone = new Material.Builder(EVMain.id("beta_ionone"))
            .color(0xdc5ce6)
            .fluid()
            .buildAndRegister()
            .setFormula("C13H20O", true);

    public static final Material VitaminA = new Material.Builder(EVMain.id("vitamin_a"))
            .color(0x8d5c91)
            .fluid()
            .buildAndRegister()
            .setFormula("C20H30O", true);

    public static final Material EthyleneOxide = new Material.Builder(EVMain.id("ethylene_oxide"))
            .color(0xa0c3de)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H4O", true);

    public static final Material Ethanolamine = new Material.Builder(EVMain.id("ethanolamine"))
            .color(0x6f7d87)
            .fluid()
            .buildAndRegister()
            .setFormula("HOCH2CH2NH2", true);

    public static final Material Biotin = new Material.Builder(EVMain.id("biotin"))
            .color(0x68cc6a)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H16N2O3S", true);

    public static final Material B27Supplement = new Material.Builder(EVMain.id("b27_supplement"))
            .color(0x386939)
            .fluid()
            .buildAndRegister()
            .setFormula("C142H230N36O44S", true);

    public static final Material CleanAmmoniaSolution = new Material.Builder(EVMain.id("clear_ammonia_solution"))
            .color(0x53c9a0)
            .fluid()
            .buildAndRegister()
            .setFormula("NH3(H2O)", true);

    public static final Material Catalase = new Material.Builder(EVMain.id("catalase"))
            .color(0xdb6596)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material Blood = new Material.Builder(EVMain.id("blood"))
            .color(0x5c0606)
            .fluid()
            .buildAndRegister()
            .setFormula("Blood", true);

    public static final Material BloodCells = new Material.Builder(EVMain.id("blood_cells"))
            .color(0xad2424)
            .fluid()
            .buildAndRegister()
            .setFormula("???", true);

    public static final Material BloodPlasma = new Material.Builder(EVMain.id("blood_plasma"))
            .color(0xe37171)
            .fluid()
            .buildAndRegister()
            .setFormula("???", true);

    public static final Material BFGF = new Material.Builder(EVMain.id("bfgf"))
            .color(0xb365e0)
            .fluid()
            .buildAndRegister()
            .setFormula("bFGF", true);

    public static final Material EGF = new Material.Builder(EVMain.id("egf"))
            .color(0x815799)
            .fluid()
            .buildAndRegister()
            .setFormula("C257H381N73O83S7", true);

    public static final Material NitroBenzene = new Material.Builder(EVMain.id("nitro_benzene"))
            .color(0x81c951)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5NO2", true);

    public static final Material Aniline = new Material.Builder(EVMain.id("aniline"))
            .color(0x4c911d)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5NH2", true);

    public static final Material ChlorosulfonicAcid = new Material.Builder(EVMain.id("chlorosulfonic_acid"))
            .color(0x916c1d)
            .fluid()
            .buildAndRegister()
            .setFormula("HSO3Cl", true);

    public static final Material Sulfanilamide = new Material.Builder(EVMain.id("sulfanilamide"))
            .color(0x523b0a)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H8N2O2S", true);

    public static final Material SilicaGelBase = new Material.Builder(EVMain.id("silica_gel_base"))
            .color(0x27a176)
            .fluid()
            .buildAndRegister()
            .setFormula("SiO2(HCl)(NaOH)(H2O)", true);

    public static final Material Ethanol100 = new Material.Builder(EVMain.id("ethanol_100"))
            .color(Ethanol.getMaterialRGB())
            .fluid()
            .buildAndRegister()
            .setFormula("C2H5OH", true);

    public static final Material PiranhaSolution = new Material.Builder(EVMain.id("piranha_solution"))
            .color(0x4820ab)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2SO4)H2O2", true);

    public static final Material WaterAgarMix = new Material.Builder(EVMain.id("water_agar_mix"))
            .color(0x48dbbe)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O?", true);

    public static final Material BacterialGrowthMedium = new Material.Builder(EVMain.id("bacterial_growth_medium"))
            .color(0x0b2e12)
            .fluid()
            .buildAndRegister()
            .setFormula("For Bacteria", true);

    public static final Material DepletedGrowthMedium = new Material.Builder(EVMain.id("depleted_growth_medium"))
            .color(0x071209)
            .fluid()
            .buildAndRegister()
            .setFormula("Depleted", true);

    public static final Material AnimalCells = new Material.Builder(EVMain.id("animal_cells"))
            .color(0xc94996)
            .fluid()
            .buildAndRegister()
            .setFormula("???", true);

    public static final Material RapidlyReplicatingAnimalCells = new Material.Builder(EVMain.id("rapidly_replicating_animal_cells"))
            .color(0x7a335e)
            .fluid()
            .buildAndRegister()
            .setFormula("????", true);

    public static final Material MycGene = new Material.Builder(EVMain.id("myc_gene"))
            .color(0x445724)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material Oct4Gene = new Material.Builder(EVMain.id("oct_4_gene"))
            .color(0x374f0d)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material SOX2Gene = new Material.Builder(EVMain.id("sox_2_gene"))
            .color(0x5d8714)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material KFL4Gene = new Material.Builder(EVMain.id("kfl_4_gene"))
            .color(0x759143)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material Cas9 = new Material.Builder(EVMain.id("cas_9"))
            .color(0x5f6e46)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material GenePlasmids = new Material.Builder(EVMain.id("pluripotency_induction_gene_plasmids"))
            .color(0xabe053)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material Chitin = new Material.Builder(EVMain.id("chitin"))
            .color(0xcbd479)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material Chitosan = new Material.Builder(EVMain.id("chitosan"))
            .color(0xb1bd42)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material GeneTherapyFluid = new Material.Builder(EVMain.id("pluripotency_induction_gene_therapy_fluid"))
            .color(0x6b2f66)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material Resin = new Material.Builder(EVMain.id("resin"))
            .color(0x3d2f11)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material LinoleicAcid = new Material.Builder(EVMain.id("linoleic_acid"))
            .color(0xD5D257)
            .fluid()
            .buildAndRegister()
            .setFormula("C18H32O2", true);

    public static final Material SiliconFluoride = new Material.Builder(EVMain.id("silicon_fluoride"))
            .color(0xB2B4B4)
            .fluid()
            .buildAndRegister()
            .setFormula("SiF4", true);

    public static final Material PhosphorusTrichloride = new Material.Builder(EVMain.id("phosphorus_trichloride"))
            .color((Phosphorus.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("PCl3", true);

    public static final Material PhosphorylChloride = new Material.Builder(EVMain.id("phosphoryl_chloride"))
            .color(0xE6E6E6)
            .fluid()
            .buildAndRegister()
            .setFormula("POCl3", true);

    public static final Material TributylPhosphate = new Material.Builder(EVMain.id("tributyl_phosphate"))
            .color(0x7C5B2C)
            .fluid()
            .buildAndRegister()
            .setFormula("(C4H9)3PO4", true);

    public static final Material Butanol = new Material.Builder(EVMain.id("butanol"))
            .color(FermentedBiomass.getMaterialRGB() + 20)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H9OH", true);

    public static final Material RedOil = new Material.Builder(EVMain.id("red_oil"))
            .color(0x7C1500)
            .fluid()
            .buildAndRegister()
            .setFormula("H2N4(RP-1)NiZnFe4", true);


    public static final Material SodiumCyanide = new Material.Builder(EVMain.id("sodium_cyanide"))
            .color(0x5f7c8c)
            .fluid()
            .buildAndRegister()
            .setFormula("NaCN", true);

    public static final Material GoldCyanide = new Material.Builder(EVMain.id("gold_cyanide"))
            .color(0x8c8761)
            .fluid()
            .buildAndRegister()
            .setFormula("AuCN", true);

    public static final Material ChlorideLeachedSolution = new Material.Builder(EVMain.id("chloride_leached_solution"))
            .color(0x41472e)
            .fluid()
            .buildAndRegister()
            .setFormula("CaCl2(CuCl2)(PbCl2)(BiCl3)(FeCl2)", true);

    public static final Material MolybdenumFlue = new Material.Builder(EVMain.id("molybdenum_flue_gas"))
            .color(0x333338)
            .fluid()
            .buildAndRegister()
            .setFormula("H2OReS?", true);

    public static final Material RheniumSulfuricSolution = new Material.Builder(EVMain.id("rhenium_sulfuric_solution"))
            .color(0xbabaff)
            .fluid()
            .buildAndRegister()
            .setFormula("ReS?", true);

    public static final Material AmmoniumSulfate = new Material.Builder(EVMain.id("ammonium_sulfate"))
            .color(0x6464f5)
            .fluid()
            .buildAndRegister();

    public static final Material AmmoniumPerrhenate = new Material.Builder(EVMain.id("ammonium_perrhenate"))
            .color(0x1c1c45)
            .fluid()
            .buildAndRegister();

    public static final Material ElectronDegenerateRheniumPlasma = new Material.Builder(EVMain.id("degenerate_rhenium_plasma"))
            .color(0x6666FF)
            .fluid()
            .buildAndRegister()
            .setFormula("Rh", false);

    public static final Material LiquidHelium = new Material.Builder(EVMain.id("liquid_helium"))
            .color(Helium.getMaterialRGB())
            .fluid()
            .buildAndRegister()
            .setFormula("He", true);

    public static final Material BoricAcid = new Material.Builder(EVMain.id("boric_acid"))
            .color(0xD5D2D7)
            .fluid()
            .buildAndRegister()
            .setFormula("H3BO3", true);

    public static final Material FluoroBoricAcid = new Material.Builder(EVMain.id("fluoroboric_acid"))
            .color(0xD5D2D7)
            .fluid()
            .buildAndRegister()
            .setFormula("HBF4", true);

    public static final Material BenzenediazoniumTetrafluoroborate = new Material.Builder(EVMain.id("benzenediazonium_tetrafluoroborate"))
            .color(0xD5D2D7)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5BF4N2", true);

    public static final Material BoronFluoride = new Material.Builder(EVMain.id("boron_fluoride"))
            .color(0xD5D2D7)
            .fluid()
            .buildAndRegister()
            .setFormula("BF3", true);

    public static final Material FluoroBenzene = new Material.Builder(EVMain.id("fluoro_benzene"))
            .color(0xD5D2D7)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5F", true);

    public static final Material SodiumNitrateSolution = new Material.Builder(EVMain.id("sodium_nitrate_solution"))
            .color(0xA09ED7)
            .fluid()
            .buildAndRegister()
            .setFormula(Water.getChemicalFormula() + "NaNO3", true);

    public static final Material Fluorotoluene = new Material.Builder(EVMain.id("fluorotoluene"))
            .color(0xE0DA99)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H7F", true);

    public static final Material OrthoXylene = new Material.Builder(EVMain.id("ortho_xylene"))
            .color(0xB9575E)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H4(CH3)2", true);

    public static final Material OrthoXyleneZeoliteMixture = new Material.Builder(EVMain.id("ortho_xylene_zeolite"))
            .color(0xB9785E)
            .fluid()
            .buildAndRegister()
            .setFormula("(NaC4Si27Al9(H2O)28O72)C6H4(CH3)2", true);

    public static final Material ParaXylene = new Material.Builder(EVMain.id("para_xylene"))
            .color(0xB9575E)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H4(CH3)2", true);

    public static final Material Dibromomethylbenzene = new Material.Builder(EVMain.id("dibromomethylbenzene"))
            .color(0x0A1D2C)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H6Br2", true);


    public static final Material Isochloropropane = new Material.Builder(EVMain.id("isochloropropane"))
            .color(0xD5DD95)
            .fluid()
            .buildAndRegister()
            .setFormula("CH3CClCH3", true);

    public static final Material Resorcinol = new Material.Builder(EVMain.id("resorcinol"))
            .color(0xD5DDBE)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H6O2", true);

    public static final Material Dinitrodipropanyloxybenzene = new Material.Builder(EVMain.id("dinitrodipropanyloxybenzene"))
            .color(0x83945F)
            .fluid()
            .buildAndRegister()
            .setFormula("C12H16O2(NO2)2", true);

    public static final Material Naphthaldehyde = new Material.Builder(EVMain.id("napthaldehyde"))
            .color(0xBCA853)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H7CHO", true);

    public static final Material HydrobromicAcid = new Material.Builder(EVMain.id("hydrobromic_acid"))
            .color(0xBC6C53)
            .fluid()
            .buildAndRegister()
            .setFormula("HBr", true);

    public static final Material ThionylChloride = new Material.Builder(EVMain.id("thionyl_chloride"))
            .color(0xF9F7E5)
            .fluid()
            .buildAndRegister()
            .setFormula("SOCl2", true);

    public static final Material Diisopropylcarbodiimide = new Material.Builder(EVMain.id("diisopropylcarbodiimide"))
            .color(0xA0CFFE)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H14N2", true);

    public static final Material Pyridine = new Material.Builder(EVMain.id("pyridine"))
            .color((Ammonia.getMaterialRGB() + Formaldehyde.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C5H5N", true);

    public static final Material Phenylpentanoicacid = new Material.Builder(EVMain.id("phenylpentanoicacid"))
            .color((Butene.getMaterialRGB() + CarbonMonoxide.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C11H14O2", true);

    public static final Material Dimethylsulfide = new Material.Builder(EVMain.id("dimethylsulfide"))
            .color((Methanol.getMaterialRGB() + HydrogenSulfide.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3)2S", true);

    public static final Material BenzoylChloride = new Material.Builder(EVMain.id("benzoyl_chloride"))
            .color((Toluene.getMaterialRGB() + ThionylChloride.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H5ClO", true);

    public static final Material Silvertetrafluoroborate = new Material.Builder(EVMain.id("silvertetrafluoroborate"))
            .color((SilverOxide.getMaterialRGB() + BoronFluoride.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("AgBF4", true);

    public static final Material PCBA = new Material.Builder(EVMain.id("pcba"))
            .color((Chlorobenzene.getMaterialRGB() + Dimethylsulfide.getMaterialRGB() + Phenylpentanoicacid.getMaterialRGB()) / 3)
            .fluid()
            .buildAndRegister()
            .setFormula("C72H14O2", true);

    public static final Material PCBS = new Material.Builder(EVMain.id("pcbs"))
            .color((Styrene.getMaterialRGB() + PCBA.getMaterialRGB() - 40) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C80H21O2", true);

    public static final Material Ferrocene = new Material.Builder(EVMain.id("ferrocene"))
            .color((Water.getMaterialRGB() + Chlorine.getMaterialRGB() + Iron.getMaterialRGB()) / 3)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H10Fe", true);

    public static final Material Ferrocenylfulleropyrrolidine = new Material.Builder(EVMain.id("ferrocenylfulleropyrrolidine"))
            .color((Ferrocene.getMaterialRGB() + Ethylene.getMaterialRGB() + CarbonMonoxide.getMaterialRGB()) / 3)
            .fluid()
            .buildAndRegister()
            .setFormula("C74H19FeN", true);

    public static final Material Hydroquinone = new Material.Builder(EVMain.id("hydroquinone"))
            .color((Oxygen.getMaterialRGB() + Propene.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H4(OH)2", true);

    public static final Material SodiumAcetate = new Material.Builder(EVMain.id("sodium_acetate"))
            .color((Sodium.getMaterialRGB() + AceticAnhydride.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H3NaO2", true);


    public static final Material Methylamine = new Material.Builder(EVMain.id("methylamine"))
            .color((Methanol.getMaterialRGB() + Ammonia.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("CH3NH2", true);

    public static final Material Phosgene = new Material.Builder(EVMain.id("phosgene"))
            .color((Chlorine.getMaterialRGB() + CarbonMonoxide.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("COCl2", true);

    public static final Material IsopropylAlcohol = new Material.Builder(EVMain.id("isopropyl_alcohol"))
            .color((Water.getMaterialRGB() + Propene.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C3H8O", true);

    public static final Material VanadiumWasteSolution = new Material.Builder(EVMain.id("vanadium_waste_solution"))
            .color(0xbf95f5)
            .fluid()
            .buildAndRegister()
            .setFormula("NaCl(Na2SO4)(SiO2)(Al(OH)3)", true);

    public static final Material UranylChlorideSolution = new Material.Builder(EVMain.id("uranyl_chloride_solution"))
            .color(0xdfe018)
            .fluid()
            .buildAndRegister()
            .setFormula("UO2Cl2(H2O)?", true);

    public static final Material UranylNitrateSolution = new Material.Builder(EVMain.id("uranyl_nitrate_solution"))
            .color(0xdfe018)
            .fluid()
            .buildAndRegister()
            .setFormula("UO2(NO3)2(H2O)?", true);

    public static final Material UraniumSulfateWasteSolution = new Material.Builder(EVMain.id("uranium_sulfate_waste_solution"))
            .color(0xdfe018)
            .fluid()
            .buildAndRegister()
            .setFormula("PbRaSr(H2SO4)", true);

    public static final Material PurifiedUranylNitrate = new Material.Builder(EVMain.id("purified_uranyl_nitrate_solution"))
            .color(0xeff028)
            .fluid()
            .buildAndRegister()
            .setFormula("UO2(NO3)2(H2O)", true);

    public static final Material UraniumDiuranate = new Material.Builder(EVMain.id("uranium_diuranate"))
            .color(0xeff028)
            .fluid()
            .buildAndRegister()
            .setFormula("(NH4)2U2O7", true);

    public static final Material UraniumRefinementWasteSolution = new Material.Builder(EVMain.id("uranium_refinement_waste_solution"))
            .color(0xeff028)
            .fluid()
            .buildAndRegister()
            .setFormula("H2SO4C?", true);

    public static final Material ThoriumNitrateSolution = new Material.Builder(EVMain.id("thorium_nitrate_solution"))
            .color(0x33bd45)
            .fluid()
            .buildAndRegister()
            .setFormula("Th(NO3)4(H2O)", true);

    public static final Material SodiumHexafluoroaluminate = new Material.Builder(EVMain.id("sodium_hexafluoroaluminate"))
            .color((Sodium.getMaterialRGB() + Aluminium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 3)
            .fluid()
            .buildAndRegister()
            .setFormula("Na3AlF6", true);

    public static final Material SodiumCarbonateSolution = new Material.Builder(EVMain.id("sodium_carbonate_solution"))
            .color(SodaAsh.getMaterialRGB() + 30)
            .fluid()
            .buildAndRegister()
            .setFormula("Na2CO3(H2O)", true);

    public static final Material SodiumSulfateSolution = new Material.Builder(EVMain.id("sodium_sulfate_solution"))
            .color(SodiumSulfate.getMaterialRGB() + 30)
            .fluid()
            .buildAndRegister()
            .setFormula("Na2SO4(H2O)", true);

    public static final Material SodiumChromateSolution = new Material.Builder(EVMain.id("sodium_chromate_solution"))
            .color(0xf2e70f)
            .fluid()
            .buildAndRegister()
            .setFormula("Na2CrO4(H2O)", true);

    public static final Material SodiumDichromateSolution = new Material.Builder(EVMain.id("sodium_dichromate_solution"))
            .color(0xf2750f)
            .fluid()
            .buildAndRegister()
            .setFormula("Na2Cr2O7", true);

    public static final Material RichNitrogenMix = new Material.Builder(EVMain.id("rich_nitrogen_mix"))
            .color(0x6891d8)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O(CH4)?", true);

    public static final Material OxidisedNitrogenMix = new Material.Builder(EVMain.id("oxidised_nitrogen_mix"))
            .color(0x708ACD)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)2(CH4)??", true);

    public static final Material PurifiedNitrogenMix = new Material.Builder(EVMain.id("purified_nitrogen_mix"))
            .color(0x6891d8)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)2(CH4)?", true);

    public static final Material CarbonatedEthanolamine = new Material.Builder(EVMain.id("carbonated_ethanolamine"))
            .color(0x6f7d87)
            .fluid()
            .buildAndRegister()
            .setFormula("H2NCH2CH2OHC", true);

    public static final Material AmmoniaRichMix = new Material.Builder(EVMain.id("ammonia_rich_mix"))
            .color(0x2f5d99)
            .fluid()
            .buildAndRegister()
            .setFormula("NH3((H2O)2(CH4)?)", true);

    public static final Material DissolvedLithiumOre = new Material.Builder(EVMain.id("dissolved_lithium_ores"))
            .color(0x664850)
            .fluid()
            .buildAndRegister()
            .setFormula("LiAlO2(H2SO4)", true);

    public static final Material LithiumCarbonateSolution = new Material.Builder(EVMain.id("lithium_carbonate_solution"))
            .color((Lithium.getMaterialRGB() + Carbon.getMaterialRGB() + Oxygen.getMaterialRGB()) / 3)
            .fluid()
            .buildAndRegister()
            .setFormula("Li2CO3(H2O)", true);

    public static final Material LithiumChlorideSolution = new Material.Builder(EVMain.id("lithium_chloride_solution"))
            .color(Lithium.getMaterialRGB() + Chlorine.getMaterialRGB())
            .fluid()
            .buildAndRegister()
            .setFormula("LiCl(H2O)", true);

    public static final Material CalicheIodateBrine = new Material.Builder(EVMain.id("caliche_iodate_brine"))
            .color(0xffe6660)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)NaNO3KNO3KClNaIO3", true);

    public static final Material IodideSolution = new Material.Builder(EVMain.id("iodide_solution"))
            .color(0x08081c)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)NaNO3KNO3KClNaI", true);

    public static final Material CalicheNitrateSolution = new Material.Builder(EVMain.id("caliche_nitrate_solution"))
            .color(0xffe6660)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)NaNO3KNO3KClNaOH", true);

    public static final Material CalicheIodineBrine = new Material.Builder(EVMain.id("caliche_iodine_brine"))
            .color(0xffe6660)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)NaNO3KNO3KClNaOHI", true);

    public static final Material KeroseneIodineSolution = new Material.Builder(EVMain.id("kerosene_iodine_solution"))
            .color(0x08081c)
            .fluid()
            .buildAndRegister()
            .setFormula("C12H26I", true);

    public static final Material IodizedBrine = new Material.Builder(EVMain.id("iodized_brine"))
            .color(0x525242)
            .fluid()
            .buildAndRegister()
            .setFormula("I?", true);

    public static final Material IodineBrineMix = new Material.Builder(EVMain.id("iodine_brine_mix"))
            .color(0x525242)
            .fluid()
            .buildAndRegister()
            .setFormula("I??", true);

    public static final Material IodineSlurry = new Material.Builder(EVMain.id("iodine_slurry"))
            .color(0x08081c)
            .fluid()
            .buildAndRegister()
            .setFormula("I?", true);

    public static final Material Brine = new Material.Builder(EVMain.id("brine"))
            .color(0xfcfc8a)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material MesitylOxide = new Material.Builder(EVMain.id("mesityl_oxide"))
            .color(Acetone.getMaterialRGB() - 10)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H10O", true);

    public static final Material MethylIsobutylKetone = new Material.Builder(EVMain.id("methyl_isobutyl_ketone"))
            .color((MesitylOxide.getMaterialRGB() + WaterAgarMix.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H12O", true);

    public static final Material ThiocyanicAcid = new Material.Builder(EVMain.id("thiocyanic_acid"))
            .color(0xfcfc30)
            .fluid()
            .buildAndRegister()
            .setFormula("HSCN", true);

    public static final Material ZrHfSeparationMix = new Material.Builder(EVMain.id("zrhf_separation_mix"))
            .color(0xfcfc95)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material ZrHfChloride = new Material.Builder(EVMain.id("zrhf_chloride"))
            .color(0x51d351)
            .fluid()
            .buildAndRegister()
            .setFormula("ZrHfCl4", true);

    public static final Material ZrHfOxyChloride = new Material.Builder(EVMain.id("zrhf_oxychloride"))
            .color(0x51d351)
            .fluid()
            .buildAndRegister()
            .setFormula("Cl2HfOZr", true);

    public static final Material ZirconChlorinatingResidue = new Material.Builder(EVMain.id("zircon_chlorinating_residue"))
            .color(0x51d351)
            .fluid()
            .buildAndRegister()
            .setFormula("(SiCl4)Co?", true);

    public static final Material ZincExhaustMixture = new Material.Builder(EVMain.id("zinc_exhaust_mixture"))
            .color((CarbonDioxide.getMaterialRGB() + SulfurDioxide.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("(SO2)(CO2)?", true);

    public static final Material ZincSlagSlurry = new Material.Builder(EVMain.id("zinc_slag_slurry"))
            .color(Zinc.getMaterialRGB() - 20)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O?", true);

    public static final Material MetalRichSlagSlurry = new Material.Builder(EVMain.id("metal_slag_slurry"))
            .color(Zinc.getMaterialRGB() - 10)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material AcidicMetalSlurry = new Material.Builder(EVMain.id("acidic_metal_slurry"))
            .color((Zinc.getMaterialRGB() - 10 + PhosphoricAcid.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("H3PO4?", true);

    public static final Material SeparatedMetalSlurry = new Material.Builder(EVMain.id("separated_metal_slurry"))
            .color(Zinc.getMaterialRGB() - 20)
            .fluid()
            .buildAndRegister()
            .setFormula("H3PO4?", true);

    public static final Material MetalHydroxideMix = new Material.Builder(EVMain.id("metal_hydroxide_mix"))
            .color(Zinc.getMaterialRGB() - 30)
            .fluid()
            .buildAndRegister()
            .setFormula("?ZnOH", true);

    public static final Material ZincPoorMix = new Material.Builder(EVMain.id("zinc_poor_mix"))
            .color(Iron.getMaterialRGB() - 10)
            .fluid()
            .buildAndRegister()
            .setFormula("?Fe", true);

    public static final Material IronPoorMix = new Material.Builder(EVMain.id("iron_poor_mix"))
            .color(Copper.getMaterialRGB() + 10)
            .fluid()
            .buildAndRegister()
            .setFormula("?In", true);

    public static final Material IndiumHydroxideConcentrate = new Material.Builder(EVMain.id("indium_hydroxide_concentrate"))
            .color((Indium.getMaterialRGB() + Hydrogen.getMaterialRGB() + 10) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("In(OH)3", true);

    public static final Material CadmiumThalliumLiquor = new Material.Builder(EVMain.id("cdtl_liquor"))
            .color((Cadmium.getMaterialRGB() + Thallium.getMaterialRGB() + RareEarth.getMaterialRGB()) / 3)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2SO4)CdTl", true);

    public static final Material ZincAmalgam = new Material.Builder(EVMain.id("zinc_amalgam"))
            .color(Zinc.getMaterialRGB() - 20)
            .fluid()
            .buildAndRegister()
            .setFormula("ZnHg", true);

    public static final Material CadmiumSulfateSolution = new Material.Builder(EVMain.id("cadmium_sulfate"))
            .color((Cadmium.getMaterialRGB() + SulfuricAcid.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("CdSO4?", true);

    public static final Material ThalliumSulfateSolution = new Material.Builder(EVMain.id("thallium_sulfate"))
            .color((Thallium.getMaterialRGB() + SulfuricAcid.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("Tl2SO4?", true);

    public static final Material PolyphenolMix = new Material.Builder(EVMain.id("polyphenol_mix"))
            .color(Phenol.getMaterialRGB() + 10)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material AcidifiedPolyphenolMix = new Material.Builder(EVMain.id("acidified_polyphenol_mix"))
            .color((PolyphenolMix.getMaterialRGB() + SulfuricAcid.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material Diethylether = new Material.Builder(EVMain.id("diethylether"))
            .color(AcidifiedPolyphenolMix.getMaterialRGB() - 20)
            .fluid()
            .buildAndRegister()
            .setFormula("(C2H5)2O", true);

    public static final Material TannicAcid = new Material.Builder(EVMain.id("tannic_acid"))
            .color((Diethylether.getMaterialRGB() + AcidifiedPolyphenolMix.getMaterialRGB()) / 4)
            .fluid()
            .buildAndRegister()
            .setFormula("C76H52O46", true);

    public static final Material GermanicAcidSolution = new Material.Builder(EVMain.id("germanic_acid_solution"))
            .color(Germanium.getMaterialRGB() - 10)
            .fluid()
            .buildAndRegister()
            .setFormula("H4GeO4", true);

    public static final Material GermaniumChloride = new Material.Builder(EVMain.id("germanium_chloride"))
            .color((Germanium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("GeCl4", true);

    public static final Material SodiumHydroxideSolution = new Material.Builder(EVMain.id("sodium_hydroxide_solution"))
            .color(SodiumHydroxide.getMaterialRGB() + 50)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)NaOH", true);

    public static final Material LithiumHydroxideSolution = new Material.Builder(EVMain.id("lithium_hydroxide_solution"))
            .color((Lithium.getMaterialRGB() + Oxygen.getMaterialRGB() + Hydrogen.getMaterialRGB()) / 3)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)LiOH", true);

    public static final Material LithiumPeroxideSolution = new Material.Builder(EVMain.id("lithium_peroxide"))
            .color((Lithium.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)Li2O2", true);

    public static final Material Ozone = new Material.Builder(EVMain.id("ozone"))
            .color(0x0099FF)
            .fluid()
            .buildAndRegister()
            .setFormula("O3", true);

    public static final Material NitrogenPentoxide = new Material.Builder(EVMain.id("nitrogen_pentoxide"))
            .color(0x0033C0)
            .fluid()
            .buildAndRegister()
            .setFormula("N2O5", true);


    public static final Material AcryloNitrile = new Material.Builder(EVMain.id("acrylonitrile"))
            .color(0x9999ff)
            .fluid()
            .buildAndRegister()
            .setFormula("CH2CHCN", true);

    public static final Material SodiumThiocyanate = new Material.Builder(EVMain.id("sodium_thiocyanate"))
            .color((Sodium.getMaterialRGB() + Sulfur.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("NaSCN", true);

    public static final Material PolyacrylonitrileSolution = new Material.Builder(EVMain.id("polyacrylonitrile_solution"))
            .color(0x9999ff)
            .fluid()
            .buildAndRegister()
            .setFormula("(C3H3N)n(NaSCN)", true);

    public static final Material MethylFormate = new Material.Builder(EVMain.id("methyl_formate"))
            .color(0Xff9999)
            .fluid()
            .buildAndRegister()
            .setFormula("HCOOCH3", true);

    public static final Material WetFormamide = new Material.Builder(EVMain.id("wet_formamide"))
            .color(0x33CCFF)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)CH3NO", true);


    public static final Material HydroxylamineDisulfate = new Material.Builder(EVMain.id("hydroxylamine_disulfate"))
            .color(0x99add6)
            .fluid()
            .buildAndRegister()
            .setFormula("(NH3OH)2(NH4)2(SO4)2", true);

    public static final Material Hydroxylamine = new Material.Builder(EVMain.id("hydroxylamine"))
            .color(0x99cc99)
            .fluid()
            .buildAndRegister()
            .setFormula("H3NO", true);

    public static final Material Amidoxime = new Material.Builder(EVMain.id("amidoxime"))
            .color(0x66ff33)
            .fluid()
            .buildAndRegister()
            .setFormula("H3N2O(CH)", true);

    public static final Material PureUranylNitrateSolution = new Material.Builder(EVMain.id("pure_uranyl_nitrate"))
            .color(0x33bd45)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)UO2(NO3)2", true);

    public static final Material CarbonSulfide = new Material.Builder(EVMain.id("carbon_sulfide"))
            .color(0x40ffbf)
            .fluid()
            .buildAndRegister()
            .setFormula("CS2", true);

    public static final Material AmineMixture = new Material.Builder(EVMain.id("amine_mixture"))
            .color((Methanol.getMaterialRGB() - 20 + Ammonia.getMaterialRGB() - 10) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("(NH3)CH4", true);

    public static final Material DimethylthiocarbamoilChloride = new Material.Builder(EVMain.id("dimethylthiocarbamoil_chloride"))
            .color(0xd9ff26)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3)2NC(S)Cl", true);

    public static final Material Trimethylamine = new Material.Builder(EVMain.id("trimetylamine"))
            .color(Dimethylamine.getMaterialRGB() + 20)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3)3N", true);

    public static final Material Mercaptophenol = new Material.Builder(EVMain.id("mercaptophenol"))
            .color(0xbaaf18)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H6OS", true);

    public static final Material Dimethylformamide = new Material.Builder(EVMain.id("dimethylformamide"))
            .color(0x42bdff)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3)2NCH", true);

    public static final Material Oct1ene = new Material.Builder(EVMain.id("1_octene"))
            .color(0x7e8778)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8H16", true);

    public static final Material CetaneTrimethylAmmoniumBromide = new Material.Builder(EVMain.id("cetane_trimethyl_ammonium_bromide"))
            .color(0xb9c1c9)
            .iconSet(SHINY)
            .dust()
            .fluid()
            .buildAndRegister()
            .setFormula("C19H42BrN", true);

    public static final Material AmmoniumPersulfate = new Material.Builder(EVMain.id("ammonium_persulfate"))
            .color(0x6464f5)
            .iconSet(DULL)
            .dust()
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("(NH4)2S2O8", true);


    public static final Material SeaWater = new Material.Builder(EVMain.id("sea_water"))
            .color(0x0000FF)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O + salts", true);

    public static final Material ConcentratedBrine = new Material.Builder(EVMain.id("concentrated_brine"))
            .color(0xfcfc95)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NaCl", true);

    public static final Material CalciumFreeBrine = new Material.Builder(EVMain.id("calcium_free_brine"))
            .color(0xfcfca6)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NaCl - Ca", true);

    public static final Material SodiumFreeBrine = new Material.Builder(EVMain.id("sodium_free_brine"))
            .color(0xfcfcb1)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("KCl", true);

    public static final Material PotassiumFreeBrine = new Material.Builder(EVMain.id("potassium_free_brine"))
            .color(0xfcfcbc)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NaCl", true);

    public static final Material BoronFreeSolution = new Material.Builder(EVMain.id("boron_free_solution"))
            .color(0xfcfccd)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O - B", true);

    public static final Material SodiumLithiumSolution = new Material.Builder(EVMain.id("sodium_lithium_solution"))
            .color(0xfcfccd)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NaLi?", true);

    public static final Material ChilledBrine = new Material.Builder(EVMain.id("chilled_brine"))
            .color(0xfcfc95)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NaCl (chilled)", true);

    public static final Material MagnesiumContainingBrine = new Material.Builder(EVMain.id("magnesium_containing_brine"))
            .color(0xfcfcbc)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("MgCl2", true);

    public static final Material BrominatedBrine = new Material.Builder(EVMain.id("brominated_brine"))
            .color(0xfdd48d)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Br?", true);

    public static final Material AcidicBrominatedBrine = new Material.Builder(EVMain.id("acidic_brominated_brine"))
            .color(0xfdd48d)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2SO4)Cl?", true);

    public static final Material ButylLithium = new Material.Builder(EVMain.id("butyl_lithium"))
            .color((Butane.getMaterialRGB() + Lithium.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H9Li", true);

    public static final Material Acetaldehyde = new Material.Builder(EVMain.id("acetaldehyde"))
            .color(0xFF9933)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H4O", true);

    public static final Material Benzaldehyde = new Material.Builder(EVMain.id("benzaldehyde"))
            .color(0xb26f22)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H6O", true);

    public static final Material Dibenzylideneacetone = new Material.Builder(EVMain.id("dibenzylideneacetone"))
            .color(0xcc6699)
            .iconSet(SHINY)
            .fluid()
            .buildAndRegister()
            .setFormula("C17H14O", true);

    public static final Material TrimethyltinChloride = new Material.Builder(EVMain.id("trimethyltin_chloride"))
            .color(0x8c8075)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3)3SnCl", true);

    public static final Material ChloroPlatinicAcid = new Material.Builder(EVMain.id("chloroplatinic_acid"))
            .color(0xffba54)
            .iconSet(SHINY)
            .fluid()
            .buildAndRegister()
            .setFormula("H2PtCl6", true);

    public static final Material Cyclooctadiene = new Material.Builder(EVMain.id("cyclooctadiene"))
            .color(0x33CC33)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8H12", true);

    public static final Material Cycloparaphenylene = new Material.Builder(EVMain.id("cycloparaphenylene"))
            .color(0x333333)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("CPP", true);

    public static final Material SuperheavyMix = new Material.Builder(EVMain.id("superheavy_mix"))
            .color(0x403737)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("SgBhRfDb", true);

    public static final Material NeutronPlasma = new Material.Builder(EVMain.id("neutron_plasma"))
            .color(0xf0e9e9)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("n", true);

    public static final Material HotMetastableOganesson = new Material.Builder(EVMain.id("hot_oganesson"))
            .color(0x521973)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Og", true);

    public static final Material TitaniumTetrafluoride = new Material.Builder(EVMain.id("titanium_tetrafluoride"))
            .color(Titanium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("TiF4", true);

    public static final Material Titanium50Tetrafluoride = new Material.Builder(EVMain.id("titanium50_tetrafluoride"))
            .color(Titanium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("TiF4", true);

    public static final Material Carbon12 = new Material.Builder(EVMain.id("carbon_12"))
            .color(Carbon.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C_12", true);

    public static final Material Carbon13 = new Material.Builder(EVMain.id("carbon_13"))
            .color(Carbon.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C_13", true);

    public static final Material Nitrogen14 = new Material.Builder(EVMain.id("nitrogen_14"))
            .color(Nitrogen.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("N_14", true);

    public static final Material Nitrogen15 = new Material.Builder(EVMain.id("nitrogen_15"))
            .color(Nitrogen.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("N_15", true);

    public static final Material CNOcatalyst = new Material.Builder(EVMain.id("cno_catalyst"))
            .color((Nitrogen.getMaterialRGB() + Carbon.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(C_12)(C_13)(N_14)(N_15)", true);

    public static final Material Calcium44 = new Material.Builder(EVMain.id("calcium_44"))
            .color(Calcium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Ca_44", true);

    public static final Material OgannesonBreedingBase = new Material.Builder(EVMain.id("og_breeding_base"))
            .color((Titanium.getMaterialRGB() + 0xA85A12) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(Ti_50)Cf_252", true);

    public static final Material QuassifissioningPlasma = new Material.Builder(EVMain.id("quasifissioning_plasma"))
            .color(0xD5CB54)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("???", true);

    public static final Material Ytterbium178 = new Material.Builder(EVMain.id("ytterbium_178"))
            .color(Ytterbium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Yb_178", true);

    public static final Material FlYbPlasma = new Material.Builder(EVMain.id("flyb_plasma"))
            .color((Ytterbium.getMaterialRGB() + 0x521973) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("FlYb", true);

    public static final Material Chromium48 = new Material.Builder(EVMain.id("chromium48"))
            .color(Chromium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Cr_48", true);

    public static final Material Iron52 = new Material.Builder(EVMain.id("iron52"))
            .color(Iron.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Fe_52", true);

    public static final Material Nickel56 = new Material.Builder(EVMain.id("nickel56"))
            .color(Nickel.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Ni_56", true);

    public static final Material Titanium44 = new Material.Builder(EVMain.id("titanium44"))
            .color(Titanium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Ti_44", true);

    public static final Material HeliumCNO = new Material.Builder(EVMain.id("helium_rich_cno"))
            .color(0x59ffa6)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("He?", true);

    public static final Material SeleniteTelluriteMix = new Material.Builder(EVMain.id("selenite_tellurite_mixture"))
            .color(0x765A30)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("TeO2SeO2(Na2CO3)2", true);

    public static final Material SeleniteSolution = new Material.Builder(EVMain.id("selenite_solution"))
            .color(0xc1c46a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Na2SeO3", true);

    public static final Material CopperRefiningSolution = new Material.Builder(EVMain.id("copper_refining_solution"))
            .color(0x765A30)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("CuH2SO4", true);

    public static final Material SodiumHydroxideBauxite = new Material.Builder(EVMain.id("sodium_hydroxide_bauxite"))
            .color(0xbf731a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Al2H2O4", true);

    public static final Material ImpureAluminiumHydroxideSolution = new Material.Builder(EVMain.id("impure_aloh3_solution"))
            .color(0xd8653e)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)Al(OH)3?", true);

    public static final Material PureAluminiumHydroxideSolution = new Material.Builder(EVMain.id("pure_aloh3_solution"))
            .color((Aluminium.getMaterialRGB() + Oxygen.getMaterialRGB() + Hydrogen.getMaterialRGB() + 40) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)Al2(OH)6", true);

    public static final Material RedMud = new Material.Builder(EVMain.id("red_mud"))
            .color(0xcc3300)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("HCl?", true);

    public static final Material NeutralisedRedMud = new Material.Builder(EVMain.id("neutralised_red_mud"))
            .color(0xcc3300)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Fe??", true);

    public static final Material FerricREEChloride = new Material.Builder(EVMain.id("ferric_ree_chloride"))
            .color(0x30301a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Fe?", true);

    public static final Material RedSlurry = new Material.Builder(EVMain.id("red_slurry"))
            .color(0xcc3300)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("TiO2?", true);

    public static final Material TitanylSulfate = new Material.Builder(EVMain.id("titanyl_sulfate"))
            .color(0xdc3d7c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("TiO(SO4)", true);


    public static final Material DiluteNitricAcid = new Material.Builder(EVMain.id("dilute_nitric_acid"))
            .color((NitricAcid.getMaterialRGB() + Water.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)HNO3", true);

    public static final Material NbTaSeparationMixture = new Material.Builder(EVMain.id("nbta_separation_mixture"))
            .color(0xbcac93)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C18H39O5P", true);

    public static final Material FluoroniobicAcid = new Material.Builder(EVMain.id("fluroniobic_acid"))
            .color(0x73ff00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NbHF7", true);

    public static final Material FluorotantalicAcid = new Material.Builder(EVMain.id("flurotantalic_acid"))
            .color(0x73ff00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("TaHF7", true);

    public static final Material NbTaFluorideMix = new Material.Builder(EVMain.id("nbta_fluoride_mix"))
            .color(0xbcac93)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2NbOF5)(H2TaF7)", true);

    public static final Material OxypentafluoroNiobate = new Material.Builder(EVMain.id("oxypentafluoroniobate"))
            .color(0x73ff00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2NbOF5", true);

    public static final Material HeptafluoroTantalate = new Material.Builder(EVMain.id("heptafluorotantalate"))
            .color(0x73ff00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2TaF7", true);

    public static final Material REEThUSulfateSolution = new Material.Builder(EVMain.id("reethu_sulfate_solution"))
            .color(0x89be5c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("?SO4", true);

    public static final Material RareEarthNitrateSolution = new Material.Builder(EVMain.id("rare_earth_nitrate_solution"))
            .color(0xcfb37d)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("?NO3", true);

    public static final Material AlkalineEarthSulfateSolution = new Material.Builder(EVMain.id("alkalineearth_sulfate"))
            .color(0xe6ebff)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("?SO4", true);

    public static final Material WetEthyleneOxide = new Material.Builder(EVMain.id("wet_etylene_oxide"))
            .color(0x90b3ff)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)C2H4O", true);

    public static final Material EthyleneGlycol = new Material.Builder(EVMain.id("ethylene_glycol"))
            .color(0x8080fa)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H6O2", true);

    public static final Material Chloroethanol = new Material.Builder(EVMain.id("chloroethanol"))
            .color(0xcfb050)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H5ClO", true);

    public static final Material Choline = new Material.Builder(EVMain.id("choline"))
            .color(0x63e45f)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C5H14NO", true);

    public static final Material ATL = new Material.Builder(EVMain.id("atl"))
            .color(0x709c4a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("ATL", true);

    public static final Material HotNitrogen = new Material.Builder(EVMain.id("hot_nitrogen"))
            .color(Nitrogen.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("N", true);

    public static final Material ViscoelasticPolyurethane = new Material.Builder(EVMain.id("viscoelastic_polyurethane"))
            .color(0xeffcef)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C17H16N2O4?", true);

    public static final Material ViscoelasticPolyurethaneFoam = new Material.Builder(EVMain.id("viscoelastic_polyurethane_foam"))
            .color(0xeffcef)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C17H16N2O4?", true);

    public static final Material CalciumCarbonateSolution = new Material.Builder(EVMain.id("calcium_carbonate_solution"))
            .color(Calcite.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)CaCO3", true);

    public static final Material BariumSulfateSolution = new Material.Builder(EVMain.id("barium_sulfate_solution"))
            .color(Barite.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)BaSO4", true);

    public static final Material BentoniteClaySlurry = new Material.Builder(EVMain.id("bentonite_clay_solution"))
            .color(0xdbc9c5)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O?", true);

    public static final Material DrillingMud = new Material.Builder(EVMain.id("drilling_mud"))
            .color(0x996600)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("For the Void Miner", true);

    public static final Material UsedDrillingMud = new Material.Builder(EVMain.id("used_drilling_mud"))
            .color(0x998833)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Used Mud", true);

    public static final Material TolueneDiisocyanate = new Material.Builder(EVMain.id("toluene_diisocyanate"))
            .color(0xbaf6ca)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C9H6N2O2", true);

    public static final Material HydroselenicAcid = new Material.Builder(EVMain.id("hydroselenic_acid"))
            .color(Selenium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2Se", true);


    public static final Material Hydroxyquinoline = new Material.Builder(EVMain.id("hydroxyquinoline"))
            .color(0x3a9a71)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C9H7NO", true);

    public static final Material Perbromothiophene = new Material.Builder(EVMain.id("perbromothiophene"))
            .color(0x87cc17)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4Br4S", true);

    public static final Material Diethoxythiophene = new Material.Builder(EVMain.id("dietoxythiophene"))
            .color(0x90ff43)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H2(OC2H5)2S", true);

    public static final Material EDOT = new Material.Builder(EVMain.id("ethylenedioxythiophene"))
            .color(0x7a9996)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H4O2C4H2S", true);

    public static final Material CitricAcid = new Material.Builder(EVMain.id("citric_acid"))
            .color(0xffcc00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H8O7", true);

    public static final Material OxalicAcid = new Material.Builder(EVMain.id("oxalic_acid"))
            .color(0x4aaae2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("HOOCCOOH", true);

    public static final Material Trimethylchlorosilane = new Material.Builder(EVMain.id("trimethylchlorosilane"))
            .color(Dimethyldichlorosilane.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3)3SiCl", true);

    public static final Material Dibromoacrolein = new Material.Builder(EVMain.id("dibromoacrolein"))
            .color(0x4a4a4a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H2Br2O2", true);

    public static final Material Bromohydrothiine = new Material.Builder(EVMain.id("bromodihydrothiine"))
            .color(0x40ff3a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H4S2Br2", true);

    public static final Material Bromobutane = new Material.Builder(EVMain.id("bromobutane"))
            .color(0xff3333)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("CH3(CH2)3Br", true);

    public static final Material AstatideSolution = new Material.Builder(EVMain.id("astatide_solution"))
            .color(0x6df63f)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("At(H2O)(SO3)", true);

    public static final Material Biperfluoromethanedisulfide = new Material.Builder(EVMain.id("biperfluoromethanedisulfide"))
            .color(0x3ada40)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2F6S2", true);

    public static final Material BariumTriflateSolution = new Material.Builder(EVMain.id("barium_triflate_solution"))
            .color((Barium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)3(Hg)C2BaF6O6S2", true);

    public static final Material BariumStrontiumAcetateSolution = new Material.Builder(EVMain.id("basr_acetate_solution"))
            .color(0x9a9b98)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H3BaO2Sr", true);

    public static final Material TitaniumIsopropoxide = new Material.Builder(EVMain.id("titanium_isopropoxide"))
            .color(0xFF0066)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Ti(OCH(CH3)2)4", true);

    public static final Material BariumChlorideSolution = new Material.Builder(EVMain.id("barium_chloride_solution"))
            .color((Barium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)BaCl3", true);

    public static final Material IronCarbonyl = new Material.Builder(EVMain.id("iron_carbonyl"))
            .color(0xff8000)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Fe?", true);

    public static final Material PurifiedIronCarbonyl = new Material.Builder(EVMain.id("purified_iron_carbonyl"))
            .color(0xff8000)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Fe", true);

    public static final Material BismuthNitrateSolution = new Material.Builder(EVMain.id("bismuth_nitrate_solution"))
            .color((Bismuth.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)Bi(NO3)3", true);

    public static final Material BariumTitanatePreparation = new Material.Builder(EVMain.id("barium_titanate_preparation"))
            .color(0x99FF99)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("BaTiO3", true);

    public static final Material BariumStrontiumTitanatePreparation = new Material.Builder(EVMain.id("basr_titanate_preparation"))
            .color(0xFF0066)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(BaTiO3)C2H3BaO2Sr", true);

    public static final Material CarbonTetrachloride = new Material.Builder(EVMain.id("carbon_tetrachloride"))
            .color(0x2d8020)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("CCl4", true);

    public static final Material Chloroethane = new Material.Builder(EVMain.id("chloroethane"))
            .color(0x33aa33)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("CH3CH2Cl", true);

    public static final Material ActiniumSuperhydridePlasma = new Material.Builder(EVMain.id("actinium_superhydride_plasma"))
            .color(Actinium.getMaterialRGB() * 9 / 8)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("AcH12", true);

    public static final Material Diborane = new Material.Builder(EVMain.id("diborane"))
            .color(Boron.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(BH3)2", true);

    public static final Material IsopropylAcetate = new Material.Builder(EVMain.id("isopropyl_acetate"))
            .color((Strontium.getMaterialRGB() + IsopropylAlcohol.getMaterialRGB() + Water.getMaterialRGB()) / 3)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3)2CHCOOCH3", true);

    public static final Material ChlorinatedSolvents = new Material.Builder(EVMain.id("chlorinated_solvents"))
            .color(0x40804c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH4)2Cl5", true);

    public static final Material Dichloromethane = new Material.Builder(EVMain.id("dichloromethane"))
            .color(Chloromethane.getMaterialRGB() - 10)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("CH2Cl2", true);

    public static final Material ButanolGas = new Material.Builder(EVMain.id("butanol_gas"))
            .color(Butanol.getMaterialRGB() + 20)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H9OH", true);

    public static final Material Tributylamine = new Material.Builder(EVMain.id("tributylamine"))
            .color(0x801a80)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(C4H9)3N", true);

    public static final Material CrudeAluminaSolution = new Material.Builder(EVMain.id("crude_alumina_solution"))
            .color(Aluminium.getMaterialRGB() - 30)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(Al(NO3)3)2(CH2Cl2)(C12H27N)", true);

    public static final Material AluminaSolution = new Material.Builder(EVMain.id("alumina_solution"))
            .color(Aluminium.getMaterialRGB() - 15)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(Al2O3)(CH2Cl2)(C12H27N)2", true);

    public static final Material UnprocessedNdYAGSolution = new Material.Builder(EVMain.id("unprocessed_ndyag_solution"))
            .color(0x6f20af)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Nd:YAG", true);

    public static final Material AmmoniumCyanate = new Material.Builder(EVMain.id("ammonium_cyanate"))
            .color(0x3a5dcf)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NH4CNO", true);

    public static final Material Ethylenediamine = new Material.Builder(EVMain.id("ethylenediamine"))
            .color(Ethanolamine.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H4(NH2)2", true);

    public static final Material EDTASolution = new Material.Builder(EVMain.id("edta_solution"))
            .color(0x0026d9)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(C10H16N2O8)3(C2H8N2)O2", true);

    public static final Material EDTA = new Material.Builder(EVMain.id("edta"))
            .color(0x0026d9)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H16N2O8", true);

    public static final Material Glycine = new Material.Builder(EVMain.id("glycine"))
            .color((Ethylenediamine.getMaterialRGB() + Formaldehyde.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NH2CH2COOH", true);

    public static final Material PrYHoNitrateSolution = new Material.Builder(EVMain.id("pryho_nitrate_solution"))
            .color(0x00f2b2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(Y(NO3)3)6(Pr(NO3)3)2(Nd(NO3)3)2(H2O)15", true);

    public static final Material PhosphorousArsenicSolution = new Material.Builder(EVMain.id("phosphorous_arsenic_solution"))
            .color(PhosphoricAcid.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("AsCd(HPO4)10", true);

    public static final Material FluorosilicicAcid = new Material.Builder(EVMain.id("fluorosilicic_acid"))
            .color(0x2ccf2a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2SiF6", true);

    public static final Material AmmoniumFluoride = new Material.Builder(EVMain.id("ammonium_fluoride"))
            .color(AmmoniumChloride.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("NH4F", true);

    public static final Material AmmoniumBifluorideSolution = new Material.Builder(EVMain.id("ammonium_bifluoride_solution"))
            .color((Ammonia.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)NH4FHF", true);

    public static final Material LuTmYChlorideSolution = new Material.Builder(EVMain.id("lutmy_chloride_solution"))
            .color(0x00f2b2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(YCl3)6(LuCl3)2(TmCl3)2(H2O)15", true);

    public static final Material MercuryNitrate = new Material.Builder(EVMain.id("mercury_nitrate"))
            .color(0xd6b8ad)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Hg(NO3)2", true);

    public static final Material BismuthVanadateSolution = new Material.Builder(EVMain.id("bismuth_vanadate_solution"))
            .color(0xffff00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H2O)BiVO4", true);

    public static final Material Nitrotoluene = new Material.Builder(EVMain.id("nitrotoluene"))
            .color(0xfcca00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H7NO2", true);

    public static final Material Naphthylamine = new Material.Builder(EVMain.id("naphthylamine"))
            .color(0xe3e81c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H9N", true);

    public static final Material Acetoacetanilide = new Material.Builder(EVMain.id("acetoacetanilide"))
            .color(0xffffc2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H11NO2", true);

    public static final Material Quinizarin = new Material.Builder(EVMain.id("quinizarin"))
            .color(0x3c5a2c0)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C14H8O4", true);

    public static final Material Toluenesulfonate = new Material.Builder(EVMain.id("toluenesulfonate"))
            .color(0x8f8f00)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H7SO3Na", true);

    public static final Material Isopropylsuccinate = new Material.Builder(EVMain.id("isopropylsuccinate"))
            .color(0xb26680)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H12O4", true);

    public static final Material MaleicAnhydride = new Material.Builder(EVMain.id("maleic_anhydride"))
            .color(0x3c20ad)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H2O3", true);

    public static final Material Benzonitrile = new Material.Builder(EVMain.id("benzonitrile"))
            .color(0x2c2c9c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H5N", true);

    public static final Material SeaborgiumDopedNanotubes = new Material.Builder(EVMain.id("seaborgium_doped_nanotubes"))
            .color(0x2c2c8c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("SgCNT", true);

    public static final Material FullereneDopedNanotubes = new Material.Builder(EVMain.id("fullerene_doped_nanotubes"))
            .color(0x6c2c6c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C60CNT", true);

    public static final Material AmmoniumNiobiumOxalateSolution = new Material.Builder(EVMain.id("ammonium_niobium_oxalate_solution"))
            .color(0x6c6cac)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(NH4)C10Nb2O20", true);

    public static final Material DielectricMirrorFormationMix = new Material.Builder(EVMain.id("dielectric_mirror_formation_mix"))
            .color(0xff992c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("MgF2ZnSTa2Ti(C2H6O8)", true);

    public static final Material LiquidZBLAN = new Material.Builder(EVMain.id("molten_zblan"))
            .color((Zirconium.getMaterialRGB() + Barium.getMaterialRGB() + Lanthanum.getMaterialRGB() + Aluminium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 5)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(ZrF4)18(BaF2)7(LaF3)2(AlF3)(NaF)7", true);

    public static final Material Iodobenzene = new Material.Builder(EVMain.id("iodobenzene"))
            .color(0x2c2c6c0)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5I", true);

    public static final Material Amino3phenol = new Material.Builder(EVMain.id("3_aminophenol"))
            .color(AminoPhenol.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H7NO", true);

    public static final Material Dimethylnaphthalene = new Material.Builder(EVMain.id("dimethylnaphthalene"))
            .color(0xe34fb0)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C12H12", true);

    public static final Material IodineMonochloride = new Material.Builder(EVMain.id("iodine_monochloride"))
            .color(0x004c4c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("ICl", true);

    public static final Material AcetylatingReagent = new Material.Builder(EVMain.id("acetylating_reagent"))
            .color(0x8d5e63)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C9H12Si(MgBr)2", true);

    public static final Material Dihydroiodotetracene = new Material.Builder(EVMain.id("dihydroiodotetracene"))
            .color(0x5c4d38)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2C18H11I", true);

    public static final Material Dichlorodicyanobenzoquinone = new Material.Builder(EVMain.id("dichlorodicyanobenzoquinone"))
            .color(0x3a2aba)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8Cl2N2O2", true);

    public static final Material Dichlorodicyanohydroquinone = new Material.Builder(EVMain.id("dichlorodicyanohidroquinone"))
            .color(0x3a2aba)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8Cl2N2(OH)2", true);

    public static final Material IodobenzoicAcid = new Material.Builder(EVMain.id("iodobenzoic_acid"))
            .color(0x2cac6c0)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C7H5IO2", true);

    public static final Material Methoxybenzaldehyde = new Material.Builder(EVMain.id("methoxybenzaldehyde"))
            .color(0x3c3a7a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8H8O2", true);

    public static final Material Butylaniline = new Material.Builder(EVMain.id("butylaniline"))
            .color(Aniline.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H15N", true);

    public static final Material MBBA = new Material.Builder(EVMain.id("mbba"))
            .color(0xfa30fa)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C18H21NO", true);

    public static final Material LiquidCrystalDetector = new Material.Builder(EVMain.id("liquid_crystal_detector"))
            .color(0xda20da)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material PotassiumEthoxide = new Material.Builder(EVMain.id("potassium_ethoxide"))
            .color(Ethanol.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H5KO", true);

    public static final Material TetraethylammoniumBromide = new Material.Builder(EVMain.id("tetraethylammonium_bromide"))
            .color(0xcc33ff)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8H20NBr", true);

    public static final Material Hexanediol = new Material.Builder(EVMain.id("hexanediol"))
            .color(EthyleneGlycol.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H14O2", true);

    public static final Material Hexamethylenediamine = new Material.Builder(EVMain.id("hexamethylenediamine"))
            .color(Ethylenediamine.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H16N2", true);

    public static final Material Tertbutanol = new Material.Builder(EVMain.id("tertbutanol"))
            .color(0xcccc2c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H10O", true);

    public static final Material Triaminoethaneamine = new Material.Builder(EVMain.id("triaminoethaneamine"))
            .color(0x6f7d87)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(NH2CH2CH2)3N", true);

    public static final Material TertButylAzidoformate = new Material.Builder(EVMain.id("tertbuthylcarbonylazide"))
            .color(0x888818)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C5H9N3O2", true);

    public static final Material AminatedFullerene = new Material.Builder(EVMain.id("aminated_fullerene"))
            .color(0x2c2caa)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C60N12H12", true);

    public static final Material Azafullerene = new Material.Builder(EVMain.id("azafullerene"))
            .color(0x8a7a1a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C60N12H12", true);

    public static final Material Ethylamine = new Material.Builder(EVMain.id("ethylamine"))
            .color(Ethylenediamine.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H5NH2", true);

    public static final Material Trimethylsilane = new Material.Builder(EVMain.id("trimethylsilane"))
            .color(Trimethylchlorosilane.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C3H10Si", true);

    public static final Material KryptonDifluoride = new Material.Builder(EVMain.id("krypton_difluoride"))
            .color(Krypton.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("KrF2", true);

    // TODO Quark Gluon plasma and Heavy quarks formula
    public static final Material QuarkGluonPlasma = new Material.Builder(EVMain.id("quark_gluon_plasma"))
            .color(0x8f00ff)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material HeavyQuarks = new Material.Builder(EVMain.id("heavy_quarks"))
            .color(0x008800)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();


    //TODO formula all of these
    public static final Material LightQuarks = new Material.Builder(EVMain.id("light_quarks"))
            .color(0x0000ff)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material Gluons = new Material.Builder(EVMain.id("gluons"))
            .color(0xfcfcfa)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material HeavyLeptonMix = new Material.Builder(EVMain.id("heavy_lepton_mix"))
            .color(0x5adf52)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material CosmicComputingMix = new Material.Builder(EVMain.id("cosmic_computing_mix"))
            .color(0xafad2f)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();


    // TODO formula
    public static final Material HeavyQuarkEnrichedMix = new Material.Builder(EVMain.id("heavy_quark_enriched_mix"))
            .color(0xefefef)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material DeuteriumSuperheavyMix = new Material.Builder(EVMain.id("deuterium_superheavy_mix"))
            .color(0xa2d2a4)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(H_2)FlHsOg");

    public static final Material ScandiumTitanium50Mix = new Material.Builder(EVMain.id("scandium_titanium50_mix"))
            .color((Scandium.getMaterialRGB() + Titanium.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("ScTi_50");

    public static final Material RadonRadiumMix = new Material.Builder(EVMain.id("radon_radium_mix"))
            .color((Radium.getMaterialRGB() + Radon.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("RnRa");

    public static final Material Phenylsodium = new Material.Builder(EVMain.id("phenylsodium"))
            .color(0x2c2cc8)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5Na");

    public static final Material Difluoroaniline = new Material.Builder(EVMain.id("difluoroaniline"))
            .color(0x3fac4a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5F2N");

    public static final Material Succinaldehyde = new Material.Builder(EVMain.id("succinaldehyde"))
            .color(0x7c6d9a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C4H6O2");

    public static final Material NDifluorophenylpyrrole = new Material.Builder(EVMain.id("n_difluorophenylpyrrole"))
            .color(0x3a9aa9)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H7F2N");

    public static final Material PhotopolymerSolution = new Material.Builder(EVMain.id("photopolymer_solution"))
            .color(0x8a526d)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C149H97N10O2(TiBF20)");

    public static final Material Trichloroferane = new Material.Builder(EVMain.id("trichloroferane"))
            .color(0x521973)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("FlCl3");

    public static final Material GlucoseIronSolution = new Material.Builder(EVMain.id("glucose_iron_solution"))
            .color((Sugar.getMaterialRGB() + Iron.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(C6H12O6)FeCl3");

    public static final Material GrapheneOxidationSolution = new Material.Builder(EVMain.id("graphene_oxidation_solution"))
            .color(0x96821a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(KMnO4)(NaNO3)(H2SO4)");

    public static final Material SupercriticalCO2 = new Material.Builder(EVMain.id("supercritcal_co2"))
            .color(CarbonDioxide.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("CO2");

    public static final Material NobleGases = new Material.Builder(EVMain.id("noble_gases_mixture"))
            .color((Helium.getMaterialRGB() + Neon.getMaterialRGB() + Argon.getMaterialRGB() + Krypton.getMaterialRGB() + Xenon.getMaterialRGB() + Radon.getMaterialRGB()))
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("HeNeArKrXeRn");

    public static final Material NonMetals = new Material.Builder(EVMain.id("non_metals"))
            .color((Hydrogen.getMaterialRGB() + Boron.getMaterialRGB() + Carbon.getMaterialRGB() + Nitrogen.getMaterialRGB() + Oxygen.getMaterialRGB() + Fluorine.getMaterialRGB() + Phosphorus.getMaterialRGB() + Sulfur.getMaterialRGB() + Chlorine.getMaterialRGB() + Arsenic.getMaterialRGB() + Selenium.getMaterialRGB() + Bromine.getMaterialRGB() + Tellurium.getMaterialRGB() + Iodine.getMaterialRGB() + Astatine.getMaterialRGB()))
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("BCPSAsSeTeIAtONHFClBr");

    // TODO formula
    public static final Material DenseNeutronPlasma = new Material.Builder(EVMain.id("dense_neutron_plasma"))
            .color(0xacecac)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material CosmicMeshPlasma = new Material.Builder(EVMain.id("cosmic_mesh_plasma"))
            .color(0x1c1c8c)
            .iconSet(DULL)
            .dust()
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("NN", true);

    public static final Material SuperfluidHelium = new Material.Builder(EVMain.id("superfluid_helium"))
            .color(Helium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("He", true);

    public static final Material LiquidHelium3 = new Material.Builder(EVMain.id("liquid_helium_3"))
            .color(Helium3.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("He_3", true);

    public static final Material LiquidEnrichedHelium = new Material.Builder(EVMain.id("liquid_enriched_helium"))
            .color(Helium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("HeHe_3", true);

    public static final Material LiquidNitrogen = new Material.Builder(EVMain.id("liquid_nitrogen"))
            .color(Nitrogen.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("N", true);

    public static final Material Methylethanolamine = new Material.Builder(EVMain.id("methylethanolamine"))
            .color(0x6a3baa)
            .iconSet(DULL)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("C3H9NO", true);

    public static final Material Methylguanidine = new Material.Builder(EVMain.id("methylguanidine"))
            .color(0x5a9a3c)
            .iconSet(DULL)
            .fluid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("C2H7N3", true);

    public static final Material Methylnitronitrosoguanidine = new Material.Builder(EVMain.id("methylnitronitrosoguanidine"))
            .color(0x68b15d)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C2H5N5O3", true);

    public static final Material IsoamylAlcohol = new Material.Builder(EVMain.id("isoamyl_alcohol"))
            .color(0xcaba77)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C5H12O", true);

    public static final Material Octanol = new Material.Builder(EVMain.id("octanol"))
            .color(0xa2b8c2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8H18O", true);

    public static final Material Trioctylamine = new Material.Builder(EVMain.id("trioctylamine"))
            .color(0x87a2bc)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C24H51N", true);

    public static final Material RheniumSeparationMixture = new Material.Builder(EVMain.id("rhenium_separation_mixture"))
            .color(0xed2c3a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C11H24", true);

    public static final Material RheniumScrubbedSolution = new Material.Builder(EVMain.id("rhenium_scrubbed_solution"))
            .color(0xedccca)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Re?", true);

    public static final Material NeutroniumDopedNanotubes = new Material.Builder(EVMain.id("neutronium_doped_nanotubes"))
            .color((Neutronium.getMaterialRGB() + CarbonNanotubes.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Nt?", true);

    public static final Material SupercriticalSteam = new Material.Builder(EVMain.id("supercritical_steam"))
            .color(Steam.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O", true);

    public static final Material SupercriticalDeuterium = new Material.Builder(EVMain.id("supercritical_deuterium"))
            .color(Deuterium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("H_2", true);

    public static final Material SupercriticalSodiumPotassiumAlloy = new Material.Builder(EVMain.id("supercritical_sodium_potassium_alloy"))
            .color(SodiumPotassiumAlloy.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Na7K3", true);

    public static final Material SupercriticalSodium = new Material.Builder(EVMain.id("supercritical_sodium"))
            .color(Sodium.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Na", true);

    public static final Material SupercriticalFLiNaK = new Material.Builder(EVMain.id("supercritical_flinak"))
            .color(FLiNaK.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("FLiNaK", true);

    public static final Material SupercriticalFLiBe = new Material.Builder(EVMain.id("supercritical_flibe"))
            .color(FLiBe.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("FLiBe", true);

    public static final Material SupercriticalLeadBismuthEutectic = new Material.Builder(EVMain.id("supercritical_lead_bismuth_eutectic"))
            .color(LeadBismuthEutectic.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("Pb3Bi7", true);

    public static final Material FreeAlphaGas = new Material.Builder(EVMain.id("free_alpha_gas"))
            .color(0xe0d407)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("a", true);

    public static final Material FreeElectronGas = new Material.Builder(EVMain.id("free_electron_gas"))
            .color(0x044c4c)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("e-", true);


    //TODO formula
    public static final Material HighEnergyQGP = new Material.Builder(EVMain.id("high_energy_qgp"))
            .color(0x8f00ff)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister();

    public static final Material AcetylsulfanilylChloride = new Material.Builder(EVMain.id("acetylsulfanilyl_chloride"))
            .color((Aniline.getMaterialRGB() + AceticAnhydride.getMaterialRGB() + ChlorosulfonicAcid.getMaterialRGB()) / 3)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C8H8ClNO3S", true);

    public static final Material BenzoylPeroxide = new Material.Builder(EVMain.id("benzoyl_peroxide"))
            .color((Barium.getMaterialRGB() + BenzoylChloride.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C14H10O4", true);


    public static final Material Propadiene = new Material.Builder(EVMain.id("propadiene"))
            .color((Butanol.getMaterialRGB() - 20))
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C3H4", true);

    public static final Material FluorophosphoricAcid = new Material.Builder(EVMain.id("fluorophosphoric_acid"))
            .color(PhosphorusTrichloride.getMaterialRGB())
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("HPF6", true);

    public static final Material PhenylenedioxydiaceticAcid = new Material.Builder(EVMain.id("phenylenedioxydiacetic_acid"))
            .color(0x99546a)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("C10H10O6", true);

    public static final Material Diethylthiourea = new Material.Builder(EVMain.id("diethylthiourea"))
            .color(0x2acaa4)
            .iconSet(DULL)
            .fluid()
            .buildAndRegister()
            .setFormula("(C2H5NH)2CS", true);

    public static final Material Isophthaloylbisdiethylthiourea = new Material.Builder(EVMain.id("isophthaloylbisdiethylthiourea")).fluid()
            .color(0x8a7b9c)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister()
            .setFormula("C18H26N4O2S2", true);

    public static final Material SodiumAlginateSolution = new Material.Builder(EVMain.id("sodium_alginate_solution"))
            .color(0xca8642)
            .iconSet(DULL)
            .liquid()
            .buildAndRegister()
            .setFormula("NaC6H7O6", true);

    public static final Material AscorbicAcid = new Material.Builder(EVMain.id("ascorbic_acid"))
            .color(0xe6cd00)
            .iconSet(DULL)
            .liquid()
            .components()
            .buildAndRegister()
            .setFormula("C6H8O6", true);

    public static final Material DehydroascorbicAcid = new Material.Builder(EVMain.id("dehydroascorbic_acid"))
            .color(0xe6cd00)
            .iconSet(DULL)
            .liquid()
            .components()
            .buildAndRegister()
            .setFormula("C6H6O6", true);

    public static final Material CaCBaSMixture = new Material.Builder(EVMain.id("cacbas_mixture")).fluid()
            .color((CalciumCarbonateSolution.getMaterialRGB() + BariumSulfateSolution.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material LubricantClaySlurry = new Material.Builder(EVMain.id("lubricant_clay_slurry")).fluid()
            .color((Lubricant.getMaterialRGB() + BentoniteClaySlurry.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material ATLEthylene = new Material.Builder(EVMain.id("atl_ethylene_mixture")).fluid()
            .color((ATL.getMaterialRGB() + EthyleneGlycol.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material DrillingMudMixture = new Material.Builder(EVMain.id("drilling_mud_mixture")).fluid()
            .color((CaCBaSMixture.getMaterialRGB() + LubricantClaySlurry.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material Cyclopentadiene = new Material.Builder(EVMain.id("cyclopentadiene")).fluid()
            .color(Cyclooctadiene.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister()
            .setFormula("C5H6", true);

    public static final Material ChloroauricAcid = new Material.Builder(EVMain.id("chloroauric_acid"))
            .color(0xDFD11F)
            .iconSet(DULL)
            .fluid()
            .components()
            .buildAndRegister()
            .setFormula("HAuCl?", true);

    public static final Material Helium4 = new Material.Builder(EVMain.id("helium4")).fluid()
            .color(Helium.getMaterialRGB() - 10)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister()
            .setFormula("He_4", true);


    // TODO formula
    public static final Material FermionicUUMatter = new Material.Builder(EVMain.id("fermionic_uu_matter")).fluid()
            .color(UUMatter.getMaterialRGB() / 3)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();


    //TODO formula
    public static final Material BosonicUUMatter = new Material.Builder(EVMain.id("bosonic_uu_matter")).fluid()
            .color(UUMatter.getMaterialRGB() - FermionicUUMatter.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material Oxydianiline = new Material.Builder(EVMain.id("oxydianiline")).fluid()
            .color(0xF0E130)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material PolyamicAcid = new Material.Builder(EVMain.id("polyamic_acid")).fluid()
            .color(0xFFAE42)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material Hexafluoropropylene = new Material.Builder(EVMain.id("hexafluoropropylene")).fluid()
            .color(0x111111)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material Dimethylether = new Material.Builder(EVMain.id("dimethylether")).fluid()
            .color(0xe6cd11)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material Dimethoxyethane = new Material.Builder(EVMain.id("dimethoxyethane")).fluid()
            .color(0x2acbb4)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material LithiumCyclopentadienide = new Material.Builder(EVMain.id("lithiumcyclopentadienide")).fluid()
            .color(0x95556a)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material CaliforniumCyclopentadienide = new Material.Builder(EVMain.id("californiumcyclopentadienide"))
            .color(0x94445b)
            .iconSet(DULL)
            .dust()
            .fluid()
            .components()
            .buildAndRegister();

    public static final Material Soap = new Material.Builder(EVMain.id("soap")).fluid()
            .color(0xFFAE42)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material DeglyceratedSoap = new Material.Builder(EVMain.id("deglyceratedsoap")).fluid()
            .color(0xFFAE41)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister();

    public static final Material StearicAcid = new Material.Builder(EVMain.id("stearicacid")).fluid()
            .color(0x2bbbb4)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister()
            .setFormula("C18H36O2", true);

    public static final Material Trioctylphosphine = new Material.Builder(EVMain.id("trioctylphosphine")).fluid()
            .color(0xF1E130)
            .iconSet(DULL)
            .dust()
            .components()
            .buildAndRegister()
            .setFormula("C24H51P", true);

    public static final Material QuantumDots = new Material.Builder(EVMain.id("quantumdots"))
            .color(0xff0000)
            .iconSet(DULL)
            .fluid()
            .components()
            .buildAndRegister()
            .setFormula("CdSe", true);


    public static final Material IridiumTrichlorideSolution = new Material.Builder(EVMain.id("iridiumtrichloridesolution"))
            .color(0x96821a)
            .iconSet(DULL)
            .dust()
            .fluid()
            .components()
            .buildAndRegister()
            .setFormula("IrCl3", true);

    public static final Material SemisolidHydrogen = new Material.Builder(EVMain.id("semisolidhydrogen"))
            .color(0x044c4b)
            .iconSet(DULL)
            .dust()
            .fluid()
            .components()
            .buildAndRegister()
            .setFormula("H", true);

    public static final Material MicrocrystallizingHydrogen = new Material.Builder(EVMain.id("microcrystallizinghydrogen"))
            .color(0x155d5c)
            .iconSet(DULL)
            .dust()
            .components()
            .fluid()
            .buildAndRegister()
            .setFormula("H", true);

    public static final Material Toluidine = new Material.Builder(EVMain.id("toluidine"))
            .color((Toluene.getMaterialRGB() + Aniline.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C7H9N", true);

    public static final Material ApatiteAcidicLeach = new Material.Builder(EVMain.id("apatite_acidic_leach"))
            .color(PhosphoricAcid.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("H10P3O12Cl??", true);

    public static final Material FluoroapatiteAcidicLeach = new Material.Builder(EVMain.id("fluoroapatite_acidic_leach"))
            .color(PhosphoricAcid.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("H10P3O12F??", true);

    public static final Material NitrousAcid = new Material.Builder(EVMain.id("nitrous_acid")).fluid()
            .color(0x1e73b0)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("HNO2", true);

    public static final Material HydroxylamineHydrochloride = new Material.Builder(EVMain.id("hydroxylamine_hydrochloride")).fluid()
            .color(((Barium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2 + 0xF0EAD6) / 2)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("HONH2HCl", true);

    public static final Material SelenousAcid = new Material.Builder(EVMain.id("selenous_acid")).fluid()
            .color((0xFFFF66 + Water.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("H2SeO3", true);

    public static final Material Glyoxal = new Material.Builder(EVMain.id("glyoxal")).fluid()
            .color(0xf2f068)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C2H2O2", true);

    public static final Material BenzylChloride = new Material.Builder(EVMain.id("benzyl_chloride")).fluid()
            .color(0xaef7fc)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C7H7Cl", true);

    public static final Material Benzylamine = new Material.Builder(EVMain.id("benzylamine")).fluid()
            .color(0x5c8082)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C7H9N", true);

    public static final Material Tetrahydrofuran = new Material.Builder(EVMain.id("tetrahydrofuran")).fluid()
            .color(0xb7ebcd)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("(CH2)4O", true);

    public static final Material Triethylamine = new Material.Builder(EVMain.id("triethylamine")).fluid()
            .color(Ethylenediamine.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("N(CH2CH3)3", true);

    public static final Material TetrafluoroboricAcid = new Material.Builder(EVMain.id("tetrafluoroboric_acid")).fluid()
            .color(Silvertetrafluoroborate.getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("HBF4", true);

    public static final Material BoronTrifluorideEtherate = new Material.Builder(EVMain.id("boron_trifluoride_etherate")).fluid()
            .color((BoronFluoride.getMaterialRGB() + Diethylether.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("(BF3)(C2H5)2O", true);

    public static final Material BoraneDimethylsulfide = new Material.Builder(EVMain.id("borane_dimethylsulfide")).fluid()
            .color((Diborane.getMaterialRGB() + Dimethylsulfide.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("(BH3)(CH3)2S", true);

    public static final Material Perfluorobenzene = new Material.Builder(EVMain.id("perfluorobenzene")).fluid()
            .color(0x226E22)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C6F6", true);

    public static final Material NitratedTriniiteSolution = new Material.Builder(EVMain.id("nitrated_triniite_solution")).fluid()
            .color(0x428c9f)
            .iconSet(DULL)
            .dust()
            .buildAndRegister();

    public static final Material ResidualTriniiteSolution = new Material.Builder(EVMain.id("residual_triniite_solution")).fluid()
            .color(0x219daf)
            .iconSet(DULL)
            .dust()
            .buildAndRegister();

    public static final Material HeavilyFluorinatedTriniumSolution = new Material.Builder(EVMain.id("heavily_fluorinated_trinium_solution")).fluid()
            .color(0x348d41)
            .iconSet(DULL)
            .dust()
            .buildAndRegister();

    public static final Material MoltenCalciumSalts = new Material.Builder(EVMain.id("molten_calcium_salts")).fluid()
            .color((Fluorite.getMaterialRGB() + Calcium.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .buildAndRegister();

    public static final Material EthylTrifluoroacetate = new Material.Builder(EVMain.id("ethyl_trifluoroacetate")).fluid()
            .color(0x88a12d)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C4H5F3O2", true);

    public static final Material Acetothienone = new Material.Builder(EVMain.id("acetothieone")).fluid()
            .color(0x79882a)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C6H6SO", true);

    public static final Material TheonylTrifluoroacetate = new Material.Builder(EVMain.id("theonyl_trifluoroacetate")).fluid()
            .color(0x88882b)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C8H5F3O2S", true);

    public static final Material ActiniumRadiumNitrateSolution = new Material.Builder(EVMain.id("actinium_radium_nitrate_solution")).fluid()
            .color(0xd2f0df)
            .iconSet(DULL)
            .dust()
            .buildAndRegister();

    public static final Material ActiniumRadiumHydroxideSolution = new Material.Builder(EVMain.id("actinium_radium_hydroxide_solution")).fluid()
            .color(0xe2f5ef)
            .buildAndRegister()
            .setFormula("H3AcRa(OH)6", true);

    public static final Material FumingNitricAcid = new Material.Builder(EVMain.id("fuming_nitric_acid")).fluid()
            .color(NitricAcid.getMaterialRGB())
            .buildAndRegister()
            .setFormula("HNO3", true);

    public static final Material AcetylChloride = new Material.Builder(EVMain.id("acetyl_chloride")).fluid()
            .color(AceticAcid.getMaterialRGB())
            .buildAndRegister()
            .setFormula("C2H3OCl", true);

    public static final Material DirtyHexafluorosilicicAcid = new Material.Builder(EVMain.id("dirty_hexafluorosilicic_acid")).fluid()
            .color((Stone.getMaterialRGB() + FluorosilicicAcid.getMaterialRGB()) / 2)
            .buildAndRegister()
            .setFormula("H2SiF6?", true);

    public static final Material DiluteHexafluorosilicicAcid = new Material.Builder(EVMain.id("dilute_hexafluorosilicic_acid")).fluid()
            .color((Water.getMaterialRGB() * 2 + FluorosilicicAcid.getMaterialRGB()) / 3)
            .buildAndRegister()
            .setFormula("(H2O)2(H2SiF6)", true);

    public static final Material Dioxygendifluoride = new Material.Builder(EVMain.id("dioxygen_difluoride")).fluid()
            .color(0x32bdaf)
            .buildAndRegister()
            .setFormula("FOOF", true);

    public static final Material DiluteHydrofluoricAcid = new Material.Builder(EVMain.id("dilute_hydrofluoric_acid")).fluid()
            .color((Water.getMaterialRGB() + HydrofluoricAcid.getMaterialRGB()) / 3)
            .buildAndRegister()
            .setFormula("(H2O)(HF)", true);

    public static final Material OxidizedResidualSolution = new Material.Builder(EVMain.id("oxidized_residual_solution")).fluid()
            .color(0x23ad7f)
            .buildAndRegister();

    public static final Material TritiumHydride = new Material.Builder(EVMain.id("tritium_hydride")).fluid()
            .color(Tritium.getMaterialRGB())
            .buildAndRegister()
            .setFormula("TH", true);

    public static final Material Helium3Hydride = new Material.Builder(EVMain.id("helium_iii_hydride")).fluid()
            .color(Helium3.getMaterialRGB())
            .buildAndRegister()
            .setFormula("He_3H", true);

    public static final Material UltraacidicResidueSolution = new Material.Builder(EVMain.id("ultraacidic_residue_solution")).fluid()
            .color((FluoroantimonicAcid.getMaterialRGB() + Helium3Hydride.getMaterialRGB()) / 2)
            .buildAndRegister();

    public static final Material XenicAcid = new Material.Builder(EVMain.id("xenic_acid")).fluid()
            .color(0x5a4c9c)
            .buildAndRegister()
            .setFormula("H2XeO4", true);

    public static final Material DustyLiquidHelium3 = new Material.Builder(EVMain.id("dusty_liquid_helium3")).fluid()
            .color(2 * Helium3.getMaterialRGB() / 3 + Taranium.getMaterialRGB() / 5)
            .buildAndRegister();

    public static final Material TaraniumEnrichedLHelium3 = new Material.Builder(EVMain.id("taranium_enriched_liquid_helium3")).fluid()
            .color(Helium3.getMaterialRGB() / 2 + Taranium.getMaterialRGB() / 2)
            .buildAndRegister();

    public static final Material TaraniumSemidepletedLHelium3 = new Material.Builder(EVMain.id("taranium_semidepleted_liquid_helium3")).fluid()
            .color(2 * Helium3.getMaterialRGB() / 3 + Taranium.getMaterialRGB() / 5)
            .buildAndRegister();

    public static final Material TaraniumDepletedLHelium3 = new Material.Builder(EVMain.id("taranium_depleted_liquid_helium3")).fluid()
            .color(Helium3.getMaterialRGB() * 5 / 6 + Taranium.getMaterialRGB() / 8)
            .buildAndRegister();

    public static final Material TaraniumRichDustyHeliumPlasma = new Material.Builder(EVMain.id("taranium_rich_dusty_helium_plasma")).fluid()
            .color(Helium.getMaterialRGB() / 2 + Taranium.getMaterialRGB() / 2)
            .buildAndRegister()
            .setFormula("HeliumPlasma", true);

    public static final Material TaraniumDepletedHeliumPlasma = new Material.Builder(EVMain.id("taranium_depleted_helium_plasma")).fluid()
            .color(Helium.getMaterialRGB() / 2 + Taranium.getMaterialRGB() / 2)
            .buildAndRegister()
            .setFormula("HeliumPlasma", true);

    public static final Material TaraniumRichHelium4 = new Material.Builder(EVMain.id("taranium_rich_helium_4")).fluid()
            .color(Helium.getMaterialRGB() / 2 + Taranium.getMaterialRGB())
            .buildAndRegister()
            .setFormula("He_4", true);

    public static final Material TaraniumPoorLiquidHelium = new Material.Builder(EVMain.id("taranium_poor_liquid_helium")).fluid()
            .color(Helium3.getMaterialRGB() * 6 / 7 + Taranium.getMaterialRGB() / 14)
            .buildAndRegister();

    public static final Material LiquidFluorine = new Material.Builder(EVMain.id("liquid_fluorine")).fluid()
            .color(Fluorine.getMaterialRGB() - 0x303030)
            .buildAndRegister();

    public static final Material LiquidXenon = new Material.Builder(EVMain.id("liquid_xenon")).fluid()
            .color(Xenon.getMaterialRGB())
            .buildAndRegister()
            .setFormula("Xe", true);

    public static final Material TaraniumPoorLiquidHeliumMix = new Material.Builder(EVMain.id("taranium_poor_liquid_helium_mix")).fluid()
            .color(TaraniumPoorLiquidHelium.getMaterialRGB() * 10 / 11 + LiquidHelium.getMaterialRGB() / 11)
            .buildAndRegister();

    public static final Material HydroiodicAcid = new Material.Builder(EVMain.id("hydroiodic_acid")).fluid()
            .color(Hydrogen.getMaterialRGB() / 2 + Iodine.getMaterialRGB() / 2)
            .buildAndRegister()
            .setFormula("HI", true);

    public static final Material ChlorodiisopropylPhosphine = new Material.Builder(EVMain.id("chlorodiisopropyl_phosphine"))
            .liquid()
            .color(0xa2c122)
            .buildAndRegister();

    public static final Material CesiumBromideSolution = new Material.Builder(EVMain.id("cesium_bromide_solution"))
            .color((Caesium.getMaterialRGB() - 10 + SaltWater.getMaterialRGB()) / 2)
            .fluid()
            .buildAndRegister()
            .setFormula("CsBr(H2O)", true);


    public static final Material IndiumTrifluoride = new Material.Builder(EVMain.id("indium_trifluoride"))
            .color(0x2b0f48)
            .dust()
            .buildAndRegister()
            .setFormula("InF3", true);

    public static final Material IndiumTrioxide = new Material.Builder(EVMain.id("indium_trioxide"))
            .color(0x2b0f48)
            .dust()
            .buildAndRegister()
            .setFormula("In2O3", true);

    public static final Material NaquadahConcentrate = new Material.Builder(EVMain.id("naquadah_concentrate"))
            .color(Naquadah.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Nq?", true);

    public static final Material EnrichedNaquadahConcentrate = new Material.Builder(EVMain.id("enriched_naquadah_concentrate"))
            .color(NaquadahEnriched.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Nq+?", true);

    public static final Material NaquadriaConcentrate = new Material.Builder(EVMain.id("naquadria_concentrate"))
            .color(Naquadria.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("*Nq*?", true);

    public static final Material AuricFluoride = new Material.Builder(EVMain.id("auric_fluoride"))
            .color(0xdffb50)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("AuF3", true);

    public static final Material ThUSludge = new Material.Builder(EVMain.id("thorium_uranium_sludge"))
            .color(0x002908)
            .dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("ThU", true);

    public static final Material LanthanumOxide = new Material.Builder(EVMain.id("lanthanum_oxide"))
            .color(Lanthanum.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("La2O3", true);

    public static final Material PraseodymiumOxide = new Material.Builder(EVMain.id("praseodymium_oxide"))
            .color(Praseodymium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Pr2O3", true);

    public static final Material NeodymiumOxide = new Material.Builder(EVMain.id("neodymium_oxide"))
            .color(Neodymium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Nd2O3", true);

    public static final Material CeriumOxide = new Material.Builder(EVMain.id("cerium_oxide"))
            .color(Cerium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Ce2O3", true);

    public static final Material EuropiumOxide = new Material.Builder(EVMain.id("europium_oxide"))
            .color(Europium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Eu2O3", true);

    public static final Material GadoliniumOxide = new Material.Builder(EVMain.id("gadolinium_oxide"))
            .color(Gadolinium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Gd2O3", true);

    public static final Material SamariumOxide = new Material.Builder(EVMain.id("samarium_oxide"))
            .color(Samarium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Sm2O3", true);

    public static final Material TerbiumOxide = new Material.Builder(EVMain.id("terbium_oxide"))
            .color(Terbium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Tb2O3", true);

    public static final Material DysprosiumOxide = new Material.Builder(EVMain.id("dysprosium_oxide"))
            .color(Dysprosium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Dy2O3", true);

    public static final Material HolmiumOxide = new Material.Builder(EVMain.id("holmium_oxide"))
            .color(Holmium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Ho2O3", true);

    public static final Material ErbiumOxide = new Material.Builder(EVMain.id("erbium_oxide"))
            .color(Erbium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Er2O3", true);

    public static final Material ThuliumOxide = new Material.Builder(EVMain.id("thulium_oxide"))
            .color(Thulium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Tm2O3", true);

    public static final Material YtterbiumOxide = new Material.Builder(EVMain.id("ytterbium_oxide"))
            .color(Ytterbium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Yb2O3", true);

    public static final Material LutetiumOxide = new Material.Builder(EVMain.id("lutetium_oxide"))
            .color(Lutetium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Lu2O3", true);

    public static final Material ScandiumOxide = new Material.Builder(EVMain.id("scandium_oxide"))
            .color(Scandium.getMaterialRGB())
            .dust()
            .buildAndRegister()
            .setFormula("Sc2O3", true);

    public static final Material CalciumCarbide = new Material.Builder(EVMain.id("calcium_carbide"))
            .color(0x807b70)
            .dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("CaC2", true);


    public static final Material BetaPinene = new Material.Builder(EVMain.id("beta_pinene"))
            .color(0x61ad6b)
            .dust()
            .buildAndRegister()
            .setFormula("C10H16", true);

    public static final Material Yeast = new Material.Builder(EVMain.id("yeast"))
            .color(0xf0e660)
            .dust()
            .buildAndRegister()
            .setFormula("???", true);

    public static final Material Glutamine = new Material.Builder(EVMain.id("glutamine"))
            .color(0xede9b4)
            .dust()
            .buildAndRegister()
            .setFormula("C5H10N2O3", true);

    public static final Material SilicaGel = new Material.Builder(EVMain.id("silica_gel"))
            .color(0x61daff)
            .dust()
            .buildAndRegister()
            .setFormula("SiO2", true);

    public static final Material SilicaAluminaGel = new Material.Builder(EVMain.id("silica_alumina_gel"))
            .color(0x558d9e)
            .dust()
            .buildAndRegister()
            .setFormula("Al2O3SiO2", true);

    public static final Material ZeoliteSievingPellets = new Material.Builder(EVMain.id("zeolite_sieving_pellets"))
            .color(0xa17bd1)
            .dust()
            .buildAndRegister()
            .setFormula("Al2O3SiO2", true);

    public static final Material WetZeoliteSievingPellets = new Material.Builder(EVMain.id("wet_zeolite_sieving_pellets"))
            .color(0x392f45)
            .dust()
            .buildAndRegister()
            .setFormula("Al2O3SiO2?", true);

    public static final Material GreenAlgae = new Material.Builder(EVMain.id("green_algae"))
            .color(0x228b22)
            .dust()
            .buildAndRegister()
            .setFormula("An Algae", true);

    public static final Material BrownAlgae = new Material.Builder(EVMain.id("brown_algae"))
            .color(0xa52a2a)
            .dust()
            .buildAndRegister()
            .setFormula("An Algae", true);

    public static final Material RedAlgae = new Material.Builder(EVMain.id("red_algae"))
            .color(0xf08080)
            .dust()
            .buildAndRegister()
            .setFormula("An Algae", true);

    public static final Material DryRedAlgae = new Material.Builder(EVMain.id("dry_red_algae"))
            .color(0xff7f50)
            .dust()
            .buildAndRegister()
            .setFormula("A Dry Algae", true);

    public static final Material RedAlgaePowder = new Material.Builder(EVMain.id("red_algae_powder"))
            .color(0xcc2f2f)
            .dust()
            .buildAndRegister()
            .setFormula("A Powdered Algae", true);

    public static final Material PreFreezeAgar = new Material.Builder(EVMain.id("pre_freeze_agar"))
            .color(0x132b0d)
            .dust()
            .buildAndRegister()
            .setFormula("Warm Agar", true);

    public static final Material FrozenAgarCrystals = new Material.Builder(EVMain.id("frozen_agar_crystals"))
            .color(0x68db4b)
            .dust()
            .buildAndRegister()
            .setFormula("Cold Agar", true);


    public static final Material BrevibacteriumFlavium = new Material.Builder(EVMain.id("brevibacterium_flavium"))
            .color(0x2c4d24)
            .dust()
            .buildAndRegister()
            .setFormula("Bacteria", true);

    public static final Material StreptococcusPyogenes = new Material.Builder(EVMain.id("streptococcus_pyogenes"))
            .color(0x1c3b15)
            .dust()
            .buildAndRegister()
            .setFormula("Bacteria", true);

    public static final Material EschericiaColi = new Material.Builder(EVMain.id("eschericia_coli"))
            .color(0x2d4228)
            .dust()
            .buildAndRegister()
            .setFormula("Bacteria", true);

    public static final Material BifidobacteriumBreve = new Material.Builder(EVMain.id("bifidobacterium_breve"))
            .color(0x377528)
            .dust()
            .buildAndRegister()
            .setFormula("Bacteria", true);

    public static final Material Alumina = new Material.Builder(EVMain.id("alumina"))
            .color(0x0b585c)
            .dust()
            .buildAndRegister()
            .setFormula("Al2O3", true);

    public static final Material CupriavidusNecator = new Material.Builder(EVMain.id("cupriavidus_necator"))
            .color(0x22704f)
            .dust()
            .buildAndRegister()
            .setFormula("Bacteria", true);

    public static final Material Shewanella = new Material.Builder(EVMain.id("shewanella"))
            .color(0x8752ab)
            .dust()
            .buildAndRegister()
            .setFormula("Bacteria", true);

    public static final Material ZirconiumTetrachloride = new Material.Builder(EVMain.id("zirconium_tetrachloride"))
            .color(0xF0F0F0)
            .dust()
            .buildAndRegister()
            .setFormula("ZrCl4", true);

    public static final Material SiliconCarbide = new Material.Builder(EVMain.id("silicon_carbide"))
            .color((Silicon.getMaterialRGB() + Carbon.getMaterialRGB()) / 2)
            .dust()
            .buildAndRegister()
            .setFormula("SiC", true);

    public static final Material GoldDepleteMolybdenite = new Material.Builder(EVMain.id("gold_deplete_molybdenite"))
            .color(0x7c7c8f)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("MoS2?", true);

    public static final Material MolybdenumConcentrate = new Material.Builder(EVMain.id("molybdenum_concentrate"))
            .color(0x565666)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("MoS2Re", true);

    public static final Material MolybdenumTrioxide = new Material.Builder(EVMain.id("molybdenum_trioxide"))
            .color(0x666685)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("MoO3", true);

    public static final Material CopperChloride = new Material.Builder(EVMain.id("copper_chloride"))
            .color(0xf5b35d)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("CuCl2", true);

    public static final Material BismuthChloride = new Material.Builder(EVMain.id("bismuth_chloride"))
            .color(0x95f5d7)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("BiCl3", true);

    public static final Material LeadChloride = new Material.Builder(EVMain.id("lead_chloride"))
            .color((Lead.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("PbCl2", true);

    public static final Material ZirconiumTetrafluoride = new Material.Builder(EVMain.id("zirconium_tetrafluoride"))
            .color((Zirconium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ZrF4", true);

    public static final Material BariumDifluoride = new Material.Builder(EVMain.id("barium_difluoride"))
            .color((Barium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("BaF2", true);

    public static final Material LanthanumTrifluoride = new Material.Builder(EVMain.id("lanthanum_trifluoride"))
            .color((Lanthanum.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("LaF3", true);

    public static final Material AluminiumTrifluoride = new Material.Builder(EVMain.id("aluminium_trifluoride"))
            .color((Aluminium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("AlF3", true);

    public static final Material ErbiumTrifluoride = new Material.Builder(EVMain.id("erbium_trifluoride"))
            .color((Erbium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("ErF3", true);

    public static final Material ZBLANDust = new Material.Builder(EVMain.id("zblan_dust"))
            .color((ZirconiumTetrafluoride.getMaterialRGB() + BariumDifluoride.getMaterialRGB() + LanthanumTrifluoride.getMaterialRGB() + AluminiumTrifluoride.getMaterialRGB()) / 4)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(ZrF4)18(BaF2)7(LaF3)2(AlF3)(NaF)7", true);

    public static final Material ErbiumDopedZBLANDust = new Material.Builder(EVMain.id("erbium_doped_zblan_dust"))
            .color((ZBLANDust.getMaterialRGB() + ErbiumTrifluoride.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(ErF3)(ZrF4)18(BaF2)7(LaF3)2(AlF3)(NaF)7", true);


    public static final Material SuccinicAcid = new Material.Builder(EVMain.id("succinic_acid"))
            .color((MaleicAnhydride.getMaterialRGB() + Water.getMaterialRGB() + Hydrogen.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C4H6O4", true);

    public static final Material Succinimide = new Material.Builder(EVMain.id("succinimide"))
            .color((SuccinicAcid.getMaterialRGB() + Ammonia.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("C4H5NO2", true);

    public static final Material Bromosuccinimide = new Material.Builder(EVMain.id("bromo_succinimide"))
            .color((Succinimide.getMaterialRGB() + Bromine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("C4H4BrNO2", true);

    public static final Material Benzophenanthrenylacetonitrile = new Material.Builder(EVMain.id("benzophenanthrenylacetonitrile"))
            .color((Naphthaldehyde.getMaterialRGB() + Ethylene.getMaterialRGB() - 20) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C20H13N", true);

    public static final Material UnfoldedFullerene = new Material.Builder(EVMain.id("unfolded_fullerene"))
            .color((Benzophenanthrenylacetonitrile.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C60H30", true);

    public static final Material Fullerene = new Material.Builder(EVMain.id("fullerene"))
            .color((UnfoldedFullerene.getMaterialRGB() - 20))
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("C60", true);

    public static final Material TiAlChloride = new Material.Builder(EVMain.id("tial_chloride"))
            .color((Titanium.getMaterialRGB() + Aluminium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("TiAlCl7", true);

    public static final Material Dimethylaminopyridine = new Material.Builder(EVMain.id("dimethylaminopyridine"))
            .color((Dimethylamine.getMaterialRGB() + Pyridine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("(CH3)2NC5H4N", true);

    public static final Material PdIrReOCeOS = new Material.Builder(EVMain.id("pdirreoceos"))
            .color((Palladium.getMaterialRGB() + Iridium.getMaterialRGB() + Rhenium.getMaterialRGB() + Cerium.getMaterialRGB() + Osmium.getMaterialRGB() + Silicon.getMaterialRGB() + Oxygen.getMaterialRGB()) / 7)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("PdIrReCeOsSiO4", true);

    public static final Material SodiumEthoxide = new Material.Builder(EVMain.id("sodium_ethoxide"))
            .color((Ethanol.getMaterialRGB() + SodiumHydroxide.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("C2H5ONa", true);

    public static final Material MgClBromide = new Material.Builder(EVMain.id("mgcl_bromide"))
            .color((MagnesiumChloride.getMaterialRGB() + Bromine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("MgClBr", true);

    public static final Material Sarcosine = new Material.Builder(EVMain.id("sarcosine"))
            .color((Glycine.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C3H7NO2", true);


    public static final Material ZnFeAlClCatalyst = new Material.Builder(EVMain.id("znfealcl_catalyst"))
            .color((Zinc.getMaterialRGB() + Iron.getMaterialRGB() + Aluminium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 4)
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("ZnFeAlCl", true);

    public static final Material Difluorobenzophenone = new Material.Builder(EVMain.id("difluorobenzophenone"))
            .color((FluoroBenzene.getMaterialRGB() + Fluorotoluene.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(FC6H4)2CO", true);

    public static final Material AluminiumChloride = new Material.Builder(EVMain.id("aluminium_chloride"))
            .color((Aluminium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("AlCl3", true);

    public static final Material PdFullereneMatrix = new Material.Builder(EVMain.id("pd_fullerene_matrix"))
            .color((Palladium.getMaterialRGB() + Fullerene.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("PdC73H15NFe", true);

    public static final Material Terephthalaldehyde = new Material.Builder(EVMain.id("terephthalaldehyde"))
            .color((Dibromomethylbenzene.getMaterialRGB() + SulfuricAcid.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("C8H6O2", true);

    public static final Material PreZylon = new Material.Builder(EVMain.id("pre_zylon"))
            .color((Terephthalaldehyde.getMaterialRGB() + Dinitrodipropanyloxybenzene.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("C20H22N2O2", true);

    public static final Material AuPdCCatalyst = new Material.Builder(EVMain.id("aupdc_catalyst"))
            .color((Gold.getMaterialRGB() + Palladium.getMaterialRGB() + Carbon.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("AuPdC", true);

    public static final Material Cyanonaphthalene = new Material.Builder(EVMain.id("cyanonaphthalene"))
            .color((SodiumCyanide.getMaterialRGB() + Naphthalene.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("C11H7N", true);

    public static final Material TinChloride = new Material.Builder(EVMain.id("tin_chloride"))
            .color((Tin.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("SnCl2", true);

    public static final Material Triphenylphosphine = new Material.Builder(EVMain.id("triphenylphosphine"))
            .color((Chlorobenzene.getMaterialRGB() + PhosphorusTrichloride.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("(C6H5)3P", true);

    public static final Material Methylbenzophenanthrene = new Material.Builder(EVMain.id("methylbenzophenanthrene"))
            .color((Naphthaldehyde.getMaterialRGB() + Ethylbenzene.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("C19H14", true);

    public static final Material VanadiumSlag = new Material.Builder(EVMain.id("vanadium_slag"))
            .color((Vanadium.getMaterialRGB() + Titanium.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(VO)C(TiO2)", true);

    public static final Material VanadiumSlagDust = new Material.Builder(EVMain.id("vanadium_slag_dust"))
            .color(0xf2ef1b)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("VO", true);

    public static final Material SodiumVanadate = new Material.Builder(EVMain.id("sodium_vanadate"))
            .color(0xf2df1d)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Na3VO4", true);

    public static final Material AmmoniumVanadate = new Material.Builder(EVMain.id("ammonium_vanadate"))
            .color(0xf2ff1c)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("NH4VO3", true);

    public static final Material VanadiumOxide = new Material.Builder(EVMain.id("vanadium_oxide"))
            .color(0xf2ef1b)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("V2O5", true);


    public static final Material BariumCarbonate = new Material.Builder(EVMain.id("barium_carbonate"))
            .color(Salt.getMaterialRGB() + 10)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("BaCO3", true);

    public static final Material BariumOxide = new Material.Builder(EVMain.id("barium_oxide"))
            .color((Barium.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("BaO", true);

    public static final Material BariumAluminate = new Material.Builder(EVMain.id("barium_aluminate"))
            .color(Saltpeter.getMaterialRGB() + 10)
            .dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("BaAl2O4", true);

    public static final Material PotassiumUranylTricarbonate = new Material.Builder(EVMain.id("potassium_uranyl_carbonate"))
            .color(0xeff028)
            .dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("(UO2)CO3", true);

    public static final Material UraniumPeroxideThoriumOxide = new Material.Builder(EVMain.id("uranium_peroxide_thorium_oxide"))
            .color(0x202020)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(UO3)(H2O2)ThO2", true);

    public static final Material UraniumThoriumOxide = new Material.Builder(EVMain.id("uranium_thorium_oxide"))
            .color(0x202020)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("UO2ThO2", true);


    public static final Material UranylThoriumSulfate = new Material.Builder(EVMain.id("uranium_thorium_sulfate"))
            .color(0xe7e848)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(UO2)SO4ThO2", true);

    public static final Material UranylThoriumNitrate = new Material.Builder(EVMain.id("uranium_thorium_nitrate"))
            .color(0xe7e848)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("UO2(NO3)2Th(NO3)4", true);

    public static final Material UraniumOxideThoriumNitrate = new Material.Builder(EVMain.id("uranium_oxide_thorium_nitrate"))
            .color(0x33bd45)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("UO2Th(NO3)4", true);

    public static final Material CaesiumHydroxide = new Material.Builder(EVMain.id("caesium_hydroxide"))
            .color(Caesium.getMaterialRGB() - 10)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("CsOH", true);

    public static final Material AluminiumHydroxide = new Material.Builder(EVMain.id("aluminium_hydroxide"))
            .color(Aluminium.getMaterialRGB() - 25)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("Al(OH)3", true);


    public static final Material GrapheneOxidationResidue = new Material.Builder(EVMain.id("graphene_oxidation_residue"))
            .color(0x96821a)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("(KMnO4)(NaNO3)(H2SO4)", true);

    public static final Material NiAlOCatalyst = new Material.Builder(EVMain.id("nialo_catalyst"))
            .color(0x0af0af)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("NiAl2O4", true);

    public static final Material FeCrOCatalyst = new Material.Builder(EVMain.id("fecro_catalyst"))
            .color(0x8C4517)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("FeCrO3", true);

    public static final Material RoastedSpodumene = new Material.Builder(EVMain.id("roasted_spodumene"))
            .color(0x3d3d29)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("LiAlSi2O6", true);

    public static final Material RoastedLepidolite = new Material.Builder(EVMain.id("roasted_lepidolite"))
            .color(0x470024)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("KLi3Al4O11", true);


    public static final Material Lithiumthiinediselenide = new Material.Builder(EVMain.id("lithiumthiinediselenide"))
            .color(0x7ada00)
            .iconSet(METALLIC)
            .dust()
            .buildAndRegister()
            .setFormula("C4H4S2Li2Se2", true);

    public static final Material NickelChloride = new Material.Builder(EVMain.id("nickel_chloride"))
            .color(Nickel.getMaterialRGB() + 10)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("NiCl2", true);

    public static final Material AluminiumSulfate = new Material.Builder(EVMain.id("aluminium_sulfate"))
            .color((Aluminium.getMaterialRGB() + Sulfur.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("Al2(SO4)3", true);

    public static final Material BariumHydroxide = new Material.Builder(EVMain.id("barium_hydroxide"))
            .color((Barium.getMaterialRGB() + Hydrogen.getMaterialRGB() + Oxygen.getMaterialRGB()) / 3)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("Ba(OH)2", true);

    public static final Material HafniumOxide = new Material.Builder(EVMain.id("hafnium_oxide"))
            .color(0x404040)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("HfO2", true);

    public static final Material SiliconChloride = new Material.Builder(EVMain.id("silicon_chloride"))
            .color(Silicon.getMaterialRGB() - 15)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("SiCl4", true);

    public static final Material HafniumChloride = new Material.Builder(EVMain.id("hafnium_chloride"))
            .color(Hafnium.getMaterialRGB() + 20)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("HfCl4", true);

    public static final Material ZincCokePellets = new Material.Builder(EVMain.id("zinc_coke_pellets"))
            .color((Zinc.getMaterialRGB() + Coke.getMaterialRGB()) / 2)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("(H2O)(ZnS)C", true);

    public static final Material ZincResidualSlag = new Material.Builder(EVMain.id("zinc_residual_slag"))
            .color(Zinc.getMaterialRGB() - 20)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material ZincFlueDust = new Material.Builder(EVMain.id("zinc_flue_dust"))
            .color(0xfcfca)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material ZincLeachingResidue = new Material.Builder(EVMain.id("zinc_leaching_residue"))
            .color((Germanium.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("Ge?", true);

    public static final Material FineZincSlagDust = new Material.Builder(EVMain.id("fine_zinc_slag_dust"))
            .color(Zinc.getMaterialRGB() - 10)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material IndiumHydroxide = new Material.Builder(EVMain.id("indium_hydroxide"))
            .color((Indium.getMaterialRGB() + SodiumHydroxide.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("In(OH)3", true);

    public static final Material CadmiumZincDust = new Material.Builder(EVMain.id("cadmium_zinc_dust"))
            .color((Cadmium.getMaterialRGB() + Zinc.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(H2SO4)CdZn?", true);

    public static final Material ThalliumResidue = new Material.Builder(EVMain.id("thallium_residue"))
            .color(Thallium.getMaterialRGB() - 10)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("Tl?", true);

    public static final Material ThalliumChloride = new Material.Builder(EVMain.id("thallium_chloride"))
            .color((Thallium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("TlCl", true);

    public static final Material ZincChloride = new Material.Builder(EVMain.id("zinc_chloride"))
            .color((Zinc.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("ZnCl2", true);

    public static final Material SodiumSulfite = new Material.Builder(EVMain.id("sodium_sulfite"))
            .color((SodiumHydroxide.getMaterialRGB() + Sulfur.getMaterialRGB()) / 2)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("Na2SO3", true);

    public static final Material Cellulose = new Material.Builder(EVMain.id("cellulose"))
            .color(0xfefefc)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C6H10O5", true);

    public static final Material GermaniumOxide = new Material.Builder(EVMain.id("germanium_oxide"))
            .color(Germanium.getMaterialRGB() + 10)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("GeO2", true);

    public static final Material DisodiumPhosphate = new Material.Builder(EVMain.id("sodium_diphosphate"))
            .color((Sodium.getMaterialRGB() + Phosphorus.getMaterialRGB()) / 2)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("Na2HPO4", true);

    public static final Material AcrylicFibers = new Material.Builder(EVMain.id("acrylic_fibers"))
            .color(0xfdfdfb)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("(C5O2H8)n", true);


    // TODO formula
    public static final Material UranylNitrate = new Material.Builder(EVMain.id("uranyl_nitrate"))
            .color(0x33bd45)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister();

    // TODO formula
    public static final Material CalciumSalts = new Material.Builder(EVMain.id("calcium_salts"))
            .color(Calcium.getMaterialRGB() - 10)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister();

    public static final Material SodiumSalts = new Material.Builder(EVMain.id("sodium_salts"))
            .color(Sodium.getMaterialRGB() - 5)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("NaCl?", true);


    //TODO formula
    public static final Material PotassiumMagnesiumSalts = new Material.Builder(EVMain.id("kmg_salts"))
            .color(0xcacac8)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister();

    // TODO formula
    public static final Material CalciumMagnesiumSalts = new Material.Builder(EVMain.id("camg_salts"))
            .color(0xcacac8)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister();

    public static final Material UraniumDioxide = new Material.Builder(EVMain.id("uranium_dioxide"))
            .color(Uranium238.getMaterialRGB())
            .components(Uranium238, 1, Oxygen, 2)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister();

    public static final Material SodiumAluminiumHydride = new Material.Builder(EVMain.id("sodium_aluminium_hydride"))
            .color(0x98cafc)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("NaAlH4", true);

    public static final Material LithiumAluminiumHydride = new Material.Builder(EVMain.id("lithium_aluminium_hydride"))
            .color(0xc0defc)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("LiAlH4", true);

    public static final Material SodiumAzanide = new Material.Builder(EVMain.id("sodium_azanide"))
            .color((Sodium.getMaterialRGB() + Hydrogen.getMaterialRGB() + Nitrogen.getMaterialRGB()) / 3)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("NaNH2", true);

    public static final Material SodiumAzide = new Material.Builder(EVMain.id("sodium_azide"))
            .color((Sodium.getMaterialRGB() + Nitrogen.getMaterialRGB()) / 2)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("NaN3", true);

    public static final Material Glucosamine = new Material.Builder(EVMain.id("glucosamine"))
            .color((Cellulose.getMaterialRGB() + Water.getMaterialRGB()) / 2)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("C6H13NO5", true);

    public static final Material AluminiumHydride = new Material.Builder(EVMain.id("aluminium_hydride"))
            .color(0x0b585c)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("AlH3", true);

    public static final Material SodiumHydride = new Material.Builder(EVMain.id("sodium_hydride"))
            .color(0xcacac8)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("NaH", true);

    public static final Material DehydrogenationCatalyst = new Material.Builder(EVMain.id("dehydrogenation_catalyst"))
            .color(0x6464f5)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("?", true);

    public static final Material PolystyreneNanoParticles = new Material.Builder(EVMain.id("polystryrene_nanoparticles"))
            .color(0x888079)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("(C8H8)n", true);

    public static final Material MagnesiumSulfate = new Material.Builder(EVMain.id("magnesium_sulfate"))
            .color(0xcacac8)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("MgSO4", true);

    public static final Material SodiumMolybdate = new Material.Builder(EVMain.id("sodium_molybdate"))
            .color(0xfcfc00)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("Na2MoO4", true);

    public static final Material SodiumPhosphomolybdate = new Material.Builder(EVMain.id("sodium_phosphomolybdate"))
            .color(0xfcfc00)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(MoO3)12Na3PO4", true);

    public static final Material SodiumPhosphotungstate = new Material.Builder(EVMain.id("sodium_phosphotungstate"))
            .color(0x7a7777)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(WO3)12Na3PO4", true);

    public static final Material Fructose = new Material.Builder(EVMain.id("fructose"))
            .color((Cellulose.getMaterialRGB() + Sugar.getMaterialRGB()) / 2)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("C6H12O6", true);

    public static final Material Glucose = new Material.Builder(EVMain.id("glucose"))
            .color(Sugar.getMaterialRGB())
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("C6H12O6", true);

    public static final Material LeadNitrateCalciumMixture = new Material.Builder(EVMain.id("lead_nitrate_calcium_mixture"))
            .color((LeadNitrate.getMaterialRGB() + Calcium.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(Pb(NO3)2)Ca9", true);

    public static final Material StrontiumOxide = new Material.Builder(EVMain.id("strontium_oxide"))
            .color(0xcacac8)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("SrO", true);


    public static final Material Diiodobiphenyl = new Material.Builder(EVMain.id("diiodobiphenyl"))
            .color(0x000f66)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("C12H8I2", true);

    public static final Material Bipyridine = new Material.Builder(EVMain.id("bipyridine"))
            .color(0X978662)
            .iconSet(FINE)
            .dust()
            .buildAndRegister()
            .setFormula("C10H8N2", true);

    public static final Material PalladiumChloride = new Material.Builder(EVMain.id("palladium_chloride"))
            .color(0xb9c0c7)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("PdCl2", true);

    public static final Material PalladiumBisDibenzylidieneacetone = new Material.Builder(EVMain.id("palladium_bisdibenzylidieneacetone"))
            .color(0Xbe81a0)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("C51H42O3Pd2", true);

    public static final Material PotassiumTetrachloroplatinate = new Material.Builder(EVMain.id("potassium_tetrachloroplatinate"))
            .color(0xffba54)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("K2PtCl4", true);

    public static final Material NickelTriphenylPhosphite = new Material.Builder(EVMain.id("nickel_triphenyl_phosphite"))
            .color(0xd9d973)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("C36H30Cl2NiP2", true);

    public static final Material Dichlorocycloctadieneplatinium = new Material.Builder(EVMain.id("dichlorocyclooctadieneplatinium"))
            .color(0xe0f78a)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("C8H12Cl2Pt", true);

    public static final Material GrapheneNanotubeMix = new Material.Builder(EVMain.id("graphene_nanotube_mix"))
            .color(0x2c2c2c)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("(C)C?", true);

    public static final Material GrapheneAlignedCNT = new Material.Builder(EVMain.id("graphene_aligned_cnt"))
            .color(0x2c2c2c)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(C)C30H20", true);

    public static final Material NiAlCatalyst = new Material.Builder(EVMain.id("nial_catalyst"))
            .color(0x6ea2ff)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("NiAl", true);

    // TODO formula
    public static final Material TitaniumNitrate = new Material.Builder(EVMain.id("titanium_nitrate"))
            .color(0xFF0066)
            .iconSet(FINE)
            .dust()
            .buildAndRegister();

    public static final Material SilverNitrate = new Material.Builder(EVMain.id("silver_nitrate"))
            .color(0xfdfdca)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("AgNO3", true);

    public static final Material AnodicSlime = new Material.Builder(EVMain.id("anodic_slime"))
            .color(0x765A30)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("SeTe??", true);

    public static final Material TelluriumOxide = new Material.Builder(EVMain.id("tellurium_oxide"))
            .color(0xFFFF66)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("TeO2", true);

    public static final Material SeleniumOxide = new Material.Builder(EVMain.id("selenium_oxide"))
            .color(0xFFFF66)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("SeO2", true);

    public static final Material ManganeseSulfate = new Material.Builder(EVMain.id("manganese_sulfate"))
            .color((Manganese.getMaterialRGB() + Sulfur.getMaterialRGB()) / 2)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("MnSO4", true);

    public static final Material TinSlag = new Material.Builder(EVMain.id("tin_slag"))
            .color(0xc8b9a9)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("NbTa?", true);

    public static final Material NbTaContainingDust = new Material.Builder(EVMain.id("nbta_containing_dust"))
            .color(0xc8b9a9)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("NbTa", true);

    public static final Material NiobiumTantalumOxide = new Material.Builder(EVMain.id("niobium_tantalum_oxide"))
            .color((Niobium.getMaterialRGB() + Tantalum.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(Nb2O5)(Ta2O5)", true);

    public static final Material FusedColumbite = new Material.Builder(EVMain.id("fused_columbite"))
            .color(0xCCCC00)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("(Fe2O3)(NaO)Nb2O5", true);

    public static final Material LeachedColumbite = new Material.Builder(EVMain.id("leached_columbite"))
            .color(0xCCCC00)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(Nb2O5)9Ta2O5?", true);

    public static final Material FusedTantalite = new Material.Builder(EVMain.id("fused_tantalite"))
            .color(0x915028)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("(Fe2O3)(NaO)Ta2O5", true);

    public static final Material LeachedTantalite = new Material.Builder(EVMain.id("leached_tantalite"))
            .color(0x915028)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(Ta2O5)9Nb2O5?", true);

    public static final Material ColumbiteMinorOxideResidue = new Material.Builder(EVMain.id("columbite_minor_oxide_residue"))
            .color(0x915028)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("(BaO)(SnO2)(WO3)(Al2O3)", true);

    public static final Material TantaliteMinorOxideResidue = new Material.Builder(EVMain.id("tantalite_minor_oxide_residue"))
            .color(0xCCCC00)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("(BaO)(ZrO2)(TiO2)(SiO2)", true);

    public static final Material LeachedPyrochlore = new Material.Builder(EVMain.id("leached_pyrochlore"))
            .color(0x996633)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(Nb2O5)9Ta2O5?", true);

    public static final Material AcidicLeachedPyrochlore = new Material.Builder(EVMain.id("acidic_leached_pyrochlore"))
            .color(0x996633)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("(H2SO4)Ca12Sr6Ba6?ThUNb26O78F26", true);

    public static final Material PotasssiumFluoroNiobate = new Material.Builder(EVMain.id("potassium_fluoroniobate"))
            .color(0x73ff00)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("K2NbF7", true);

    public static final Material PotasssiumFluoroTantalate = new Material.Builder(EVMain.id("potassium_fluorotantalate"))
            .color(0x73ff00)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("K2TaF7", true);

    public static final Material BariumPeroxide = new Material.Builder(EVMain.id("barium_peroxide"))
            .color((Barium.getMaterialRGB() + Oxygen.getMaterialRGB() - 30) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("BaO2", true);

    public static final Material CassiteriteCokePellets = new Material.Builder(EVMain.id("cassiterite_coke_pellets"))
            .color(0x8f8f8f)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("SnO2C?", true);

    public static final Material IronSulfateDust = new Material.Builder(EVMain.id("iron_sulfate_dust"))
            .color((Iron.getMaterialRGB() + Sulfur.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("FeSO4", true);

    // TODO formula
    public static final Material StrontiumCarbonate = new Material.Builder(EVMain.id("strontium_carbonate"))
            .color(0xcacac8)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister();


    public static final Material SodiumHypochlorite = new Material.Builder(EVMain.id("sodium_hypochlorite"))
            .color(0x6cff50)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("NaClO", true);

    public static final Material DehydratedLignite = new Material.Builder(EVMain.id("dehydrated_lignite"))
            .color(0x5c4020)
            .iconSet(DULL)
            .dust()
            .buildAndRegister()
            .setFormula("C2(H2O)4C?", true);

    public static final Material BCEPellet = new Material.Builder(EVMain.id("bce_pellet"))
            .color(0x3c3020)
            .iconSet(LIGNITE)
            .dust()
            .buildAndRegister()
            .setFormula("C2(H2O)4C", true);

    public static final Material CopperGalliumIndiumMix = new Material.Builder(EVMain.id("copper_gallium_indium_mix"))
            .color((Indium.getMaterialRGB() + Copper.getMaterialRGB() + Gallium.getMaterialRGB()) / 3)
            .iconSet(ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("CuGaIn", true);

    public static final Material CopperGalliumIndiumSelenide = new Material.Builder(EVMain.id("copper_gallium_indium_selenide"))
            .color((CopperGalliumIndiumMix.getMaterialRGB() + Selenium.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("CuGaInSe2", true);

    public static final Material LanthanumCalciumManganate = new Material.Builder(EVMain.id("lanthanum_gallium_manganate"))
            .color(0x8aa07b)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("LaCaMnO3", true);

    public static final Material AluminiumComplex = new Material.Builder(EVMain.id("aluminium_complex"))
            .color(0x3f5a9f)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("AlC9H7NO", true);

    public static final Material IronPlatinumCatalyst = new Material.Builder(EVMain.id("iron_platinum_catalyst"))
            .color(Iron.getMaterialRGB() / 2 + Platinum.getMaterialRGB() / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("FePt", true);

    public static final Material YttriumNitrate = new Material.Builder(EVMain.id("yttrium_nitrate"))
            .color(0xdadafc)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("Y(NO3)3", true);

    public static final Material CopperNitrate = new Material.Builder(EVMain.id("copper_nitrate"))
            .color(0xcaecec)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("Cu(NO3)2", true);

    public static final Material BariumNitrate = new Material.Builder(EVMain.id("barium_nitrate"))
            .color((Barium.getMaterialRGB() + NitricAcid.getMaterialRGB()) / 2)
            .iconSet(SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("Ba(NO3)2", true);

    public static final Material WellMixedYBCOxides = new Material.Builder(EVMain.id("well_mixed_ybc_oxides"))
            .color(0x2c3429)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("YBa2Cu3O6", true);

    public static final Material PiledTBCC = new Material.Builder(EVMain.id("piled_tbcc"))
            .color(0x669900)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Tl2Ba2Cu3Ca2", true);

    public static final Material ActiniumOxalate = new Material.Builder(EVMain.id("actinium_oxalate"))
            .color(Actinium.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Ac(CO2)4", true);

    public static final Material ActiniumHydride = new Material.Builder(EVMain.id("actinium_hydride"))
            .color(Actinium.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("AcH3", true);

    public static final Material LanthanumFullereneMix = new Material.Builder(EVMain.id("lanthanum_fullerene_mix"))
            .color(0xdfcafa)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(C60)2La2?", true);

    public static final Material LanthanumEmbeddedFullerene = new Material.Builder(EVMain.id("lanthanum_embedded_fullerene"))
            .color(0x99cc00)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(C60)2La2", true);

    public static final Material IronIodide = new Material.Builder(EVMain.id("iron_iodide"))
            .color((Iron.getMaterialRGB() + Iodine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("FeI2", true);


    public static final Material ThalliumIodide = new Material.Builder(EVMain.id("thallium_iodide"))
            .color((Thallium.getMaterialRGB() + Iodine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("TlI", true);

    public static final Material ScandiumIodide = new Material.Builder(EVMain.id("scandium_iodide"))
            .color((Scandium.getMaterialRGB() + Iodine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("ScI3", true);

    public static final Material RubidiumIodide = new Material.Builder(EVMain.id("rubidium_iodide"))
            .color((Rubidium.getMaterialRGB() + Iodine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("RbI", true);

    public static final Material IndiumIodide = new Material.Builder(EVMain.id("indium_iodide"))
            .color((Indium.getMaterialRGB() + Iodine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("InI3", true);

    public static final Material GalliumIodide = new Material.Builder(EVMain.id("gallium_iodide"))
            .color((Gallium.getMaterialRGB() + Iodine.getMaterialRGB()) / 2)
            .dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("GaI3", true);

    public static final Material UVAHalideMix = new Material.Builder(EVMain.id("uva_halide_mix"))
            .color((GalliumIodide.getMaterialRGB() + PotassiumIodide.getMaterialRGB() + Mercury.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Hg(GaI3)KI", true);

    public static final Material WhiteHalideMix = new Material.Builder(EVMain.id("white_halide_mix"))
            .color((ScandiumIodide.getMaterialRGB() + PotassiumIodide.getMaterialRGB() + Mercury.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Hg(ScI3)KI", true);

    public static final Material BlueHalideMix = new Material.Builder(EVMain.id("blue_halide_mix"))
            .color((IndiumIodide.getMaterialRGB() + PotassiumIodide.getMaterialRGB() + Mercury.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Hg(InI3)KI", true);

    public static final Material GreenHalideMix = new Material.Builder(EVMain.id("green_halide_mix"))
            .color((ThalliumIodide.getMaterialRGB() + PotassiumIodide.getMaterialRGB() + Mercury.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Hg(TlI)KI", true);

    public static final Material RedHalideMix = new Material.Builder(EVMain.id("red_halide_mix"))
            .color((RubidiumIodide.getMaterialRGB() + PotassiumIodide.getMaterialRGB() + Mercury.getMaterialRGB()) / 3)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Hg(RbI)KI", true);

    public static final Material CarbonylPurifiedIron = new Material.Builder(EVMain.id("carbonyl_purified_iron"))
            .color(Iron.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Fe", true);

    public static final Material BariumTriflate = new Material.Builder(EVMain.id("barium_triflate"))
            .color((Barium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Ba(OSO2CF3)2", true);

    public static final Material ScandiumTriflate = new Material.Builder(EVMain.id("scandium_triflate"))
            .color(0xdfcfcf)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Sc(OSO2CF3)3", true);

    public static final Material SodiumThiosulfate = new Material.Builder(EVMain.id("sodium_thiosulfate"))
            .color(0x2090fc)
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("Na2S2O3", true);

    public static final Material TitaniumCyclopentadienyl = new Material.Builder(EVMain.id("titanium_cyclopentadienyl"))
            .color(0xbc30bc)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(C5H5)2Cl2Ti", true);

    public static final Material SodiumBromide = new Material.Builder(EVMain.id("sodium_bromide"))
            .color(0xfeaffc)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NaBr", true);

    public static final Material FranciumCarbide = new Material.Builder(EVMain.id("francium_carbide"))
            .color(Francium.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Fr2C2", true);

    public static final Material BoronCarbide = new Material.Builder(EVMain.id("boron_carbide"))
            .color(0x303030)
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("B4C3", true);

    public static final Material BoronFranciumCarbide = new Material.Builder(EVMain.id("boron_francium_carbide"))
            .color(0x808080)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Fr4B4C7", true);

    public static final Material MixedAstatideSalts = new Material.Builder(EVMain.id("mixed_astatide_salts"))
            .color(0x6df63f)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(At3)(Ho)(Th)(Cn)(Fl)", true);

    public static final Material SodiumIodide = new Material.Builder(EVMain.id("sodium_iodide"))
            .color(0x555588)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NaI", true);

    public static final Material SodiumIodate = new Material.Builder(EVMain.id("sodium_iodate"))
            .color(0x11116d)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NaIO3", true);

    public static final Material SodiumPeriodate = new Material.Builder(EVMain.id("sodium_periodate"))
            .color(0x11116d)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("NaIO4", true);

    public static final Material SodiumSeaborgate = new Material.Builder(EVMain.id("sodium_seaborgate"))
            .color(0x55bbd4)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Na2SgO4", true);


    public static final Material StrontiumChloride = new Material.Builder(EVMain.id("strontium_chloride"))
            .color(0x3a9aba)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("SrCl2", true);

    public static final Material YttriumEuropiumVanadate = new Material.Builder(EVMain.id("yttrium_europium_vanadate"))
            .color((Yttrium.getMaterialRGB() + Europium.getMaterialRGB() + Vanadium.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("YEuVO4", true);

    public static final Material StrontiumEuropiumAluminate = new Material.Builder(EVMain.id("strontium_europium_aluminate"))
            .color((Strontium.getMaterialRGB() + Europium.getMaterialRGB() + Aluminium.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("SrEuAl2O4", true);

    public static final Material BariumStrontiumTitanate = new Material.Builder(EVMain.id("barium_strontium_titanate"))
            .color(0xFF0066)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("BaO4SrTi", true);

    public static final Material PotassiumManganate = new Material.Builder(EVMain.id("potassium_manganate"))
            .color(0xaf20af)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("K2MnO4", true);

    public static final Material BariumChloride = new Material.Builder(EVMain.id("barium_chloride"))
            .dust()
            .color((Barium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("BaCl2", true);

    public static final Material TantalumOxide = new Material.Builder(EVMain.id("tantalum_oxide"))
            .color((Tantalum.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Ta2O5", true);

    public static final Material ZirconylChloride = new Material.Builder(EVMain.id("zirconyl_chloride"))
            .color(ZirconiumTetrachloride.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ZrOCl2", true);

    public static final Material LeadSelenide = new Material.Builder(EVMain.id("lead_selenide"))
            .color((Lead.getMaterialRGB() + Selenium.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("PbSe", true);

    public static final Material LeadScandiumTantalate = new Material.Builder(EVMain.id("lead_scandium_tantalate"))
            .color((Lead.getMaterialRGB() + Scandium.getMaterialRGB() + Tantalum.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Pb(ScTa)O3", true);

    public static final Material BETS = new Material.Builder(EVMain.id("bets"))
            .color(0x7ada00)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C10H8S4Se4", true);

    public static final Material MagnetorestrictiveAlloy = new Material.Builder(EVMain.id("magnetorestrictive_alloy"))
            .color(0xafefef)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Tb4Dy7Fe10Co5B2SiC", true);

    public static final Material BoronOxide = new Material.Builder(EVMain.id("boron_oxide"))
            .color((Boron.getMaterialRGB() + Oxygen.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("B2O3", true);

    public static final Material LithiumAluminiumFluoride = new Material.Builder(EVMain.id("lithium_aluminium_fluoride"))
            .color((Lithium.getMaterialRGB() + Aluminium.getMaterialRGB() + Fluorine.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("AlF4Li", true);

    public static final Material Polystyrene = new Material.Builder(EVMain.id("polystyrene"))
            .color(8945785)
            .ingot()
            .fluid()
            .components(Carbon, 8, Hydrogen, 8)
            .iconSet(DULL)
            .flags(GENERATE_FOIL)
            .buildAndRegister();


    public static final Material HafniumCarbide = new Material.Builder(EVMain.id("hafnium_carbide"))
            .color(0x2c2c2c)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("HfC", true);


    public static final Material SeaborgiumCarbide = new Material.Builder(EVMain.id("seaborgium_carbide"))
            .color(0x2c2c2c)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("SgC", true);

    public static final Material AluminiumNitrate = new Material.Builder(EVMain.id("aluminium_nitrate"))
            .color(Alumina.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Al(NO3)3", true);

    public static final Material NeodymiumDopedYttrium = new Material.Builder(EVMain.id("neodymium_doped_yttrium"))
            .color(YttriumOxide.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("Nd:Y?", true);

    public static final Material NdYAGNanoparticles = new Material.Builder(EVMain.id("nd_yag_nanoparticles"))
            .color(0x6f20af)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Nd:YAG", true);

    public static final Material PotassiumPermanganate = new Material.Builder(EVMain.id("potassium_permanganate"))
            .color(PotassiumManganate.getMaterialRGB() - 15)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("KMnO4", true);

    public static final Material Urea = new Material.Builder(EVMain.id("urea"))
            .color(0x30cf20)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CH4N2O", true);

    public static final Material FluoroapatiteSolidResidue = new Material.Builder(EVMain.id("fluoroapatite_solid_residue"))
            .color(0x3cb290)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Ca6PO4SiO3F", true);

    public static final Material ApatiteSolidResidue = new Material.Builder(EVMain.id("apatite_solid_residue"))
            .color(0x3cb290)
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("Ca6PO4SiO3", true);

    public static final Material AmmoniumBifluoride = new Material.Builder(EVMain.id("ammonium_bifluoride"))
            .color(0x20cfcf)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NH4HF2", true);

    public static final Material SodiumArsenate = new Material.Builder(EVMain.id("sodium_arsenate"))
            .color(0xbffabf)
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("Na3AsO4", true);

    public static final Material PrHoYLFNanoparticles = new Material.Builder(EVMain.id("prho_ylf_nanoparticles"))
            .color(0xcf8acf)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Pr/Ho:YLF", true);

    public static final Material LuTmYVONanoparticles = new Material.Builder(EVMain.id("lutm_yvo_nanoparticles"))
            .color(0x206faf)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Lu/Tm:YVO", true);

    public static final Material PureSodiumVanadate = new Material.Builder(EVMain.id("pure_sodium_vanadate"))
            .color(SodiumVanadate.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Na3VO4", true);

    public static final Material AmmoniumCarbonate = new Material.Builder(EVMain.id("ammonium_carbonate"))
            .color(AmmoniumSulfate.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(NH4)2CO3", true);

    public static final Material CadmiumSulfide = new Material.Builder(EVMain.id("cadmium_sulfide"))
            .color(0xffff00)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CdS", true);

    public static final Material UnprocessedNdYAGDust = new Material.Builder(EVMain.id("unprocessed_ndyag_dust"))
            .color(0x6f20af)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("Nd:YAG?", true);

    public static final Material LuTmYVOPrecipitate = new Material.Builder(EVMain.id("lutm_yvo_precipitate"))
            .color(0xcf8acf)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("Lu/Tm:YVO?", true);

    public static final Material RawSienna = new Material.Builder(EVMain.id("raw_siena"))
            .color(0x663300)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("SiO2(MnO2)(FeO2)", true);

    public static final Material BurnedSienna = new Material.Builder(EVMain.id("burned_siena"))
            .color(0xff0000)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("SiO2(MnO2)(FeO2)", true);

    public static final Material BismuthVanadate = new Material.Builder(EVMain.id("bismuth_vanadate"))
            .color(0xffff00)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("BiVO4", true);

    public static final Material CopperArsenite = new Material.Builder(EVMain.id("copper_arsenite"))
            .color(0x66ff66)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Cu3(AsO4)2", true);

    public static final Material MercuryIodide = new Material.Builder(EVMain.id("mercury_iodide"))
            .color(0xff0000)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("HgI2", true);

    public static final Material TitaniumYellow = new Material.Builder(EVMain.id("titanium_yellow"))
            .color(0xffff00)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("NiO(Sb2O3)(TiO2)20", true);

    public static final Material CobaltZincOxide = new Material.Builder(EVMain.id("cobalt_zinc_oxide"))
            .color(0x00ffff)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("CoZn4O5", true);

    public static final Material ScheelesGreen = new Material.Builder(EVMain.id("scheeles_green"))
            .color(0x00ff00)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("AsCuHO3", true);

    public static final Material CobaltAluminate = new Material.Builder(EVMain.id("cobalt_aluminate"))
            .color(0x0000ff)
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("Al2Co2O5", true);


    public static final Material AmmoniumManganesePhosphate = new Material.Builder(EVMain.id("ammonium_manganese_phosphate"))
            .color(0x660066)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("NH4MnPO4", true);

    public static final Material HanPurple = new Material.Builder(EVMain.id("hans_purple"))
            .color(0x660066)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("BaCuSi2O6", true);

    public static final Material ChromeYellow = new Material.Builder(EVMain.id("chrome_yellow"))
            .color(0xffff00)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("PbCrO4", true);

    public static final Material Jasper = new Material.Builder(EVMain.id("jasper"))
            .color(0xC85050)
            .gem()
            .ore()
            .buildAndRegister();

    public static final Material Quantum = new Material.Builder(EVMain.id("quantum"))
            .color(0x0f0f0f)
            .iconSet(SHINY)
            .ingot(7)
            .fluid()
            .components(Stellite, 7, Jasper, 5, Gallium, 5, Americium, 5, Palladium, 5, Bismuth, 5, Germanium, 5, SiliconCarbide, 5)
            .appendFlags(CORE_METAL)
            .blastTemp(11400)
            .buildAndRegister();

    public static final Material ChromeOrange = new Material.Builder(EVMain.id("chrome_orange"))
            .color(0xff6600)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("Pb2CrO5", true);

    public static final Material DiaminostilbenedisulfonicAcid = new Material.Builder(EVMain.id("diaminostilbenedisulfonic_acid"))
            .color(0xffffff)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C14H14N2O6S2");

    public static final Material Nigrosin = new Material.Builder(EVMain.id("nigrosin"))
            .color(0x000000)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C36H26N5ClNa2S2O6");

    public static final Material DirectBrown = new Material.Builder(EVMain.id("direct_brown"))
            .color(0x663300)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C26H19N6NaO3S");

    public static final Material DianilineterephthalicAcid = new Material.Builder(EVMain.id("dianilineterephthalic_acid"))
            .color(0xff0000)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C20H16N2O4");

    public static final Material Quinacridone = new Material.Builder(EVMain.id("quinacridone"))
            .color(0xff0000)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C20H12N2O2");

    public static final Material DiarylideYellow = new Material.Builder(EVMain.id("diarylide_yellow"))
            .color(0xffff00)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C32H26Cl2N6O4");

    public static final Material AlizarineCyanineGreen = new Material.Builder(EVMain.id("alizarine_cyanine_green"))
            .color(0x00ff00)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C28H20N2Na2O8S2");

    public static final Material Aminoanthraquinone = new Material.Builder(EVMain.id("aminoanthraquinone"))
            .color(0x0000ff)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C14H9NO2");

    public static final Material IndanthroneBlue = new Material.Builder(EVMain.id("indanthrone_blue"))
            .color(0x0000ff)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C28H14N2O2");

    public static final Material Diketopyrrolopyrrole = new Material.Builder(EVMain.id("diketopyrrolopyrrole"))
            .color(0xff6600)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C18H12N2O2");

    public static final Material Mauveine = new Material.Builder(EVMain.id("mauveine"))
            .color(0x660066)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C26H23N4");

    public static final Material Indigo = new Material.Builder(EVMain.id("indigo"))
            .color(0x0000ff)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C16H10N2O2");

    public static final Material Tetrabromoindigo = new Material.Builder(EVMain.id("tetrabromoindigo"))
            .color(0x00ff00)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C16H6Br2N2O2");

    public static final Material CyanIndigoDye = new Material.Builder(EVMain.id("cyan_indigo_dye"))
            .color(0x009999)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(C16H10N2O2)2Br2");

    public static final Material Fluorescein = new Material.Builder(EVMain.id("fluorescein"))
            .color(0x990000)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C20H12O5");

    public static final Material Erythrosine = new Material.Builder(EVMain.id("erythrosine"))
            .color(0xff00ff)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C20H6I4Na2O5");

    public static final Material ManganeseIIIOxide = new Material.Builder(EVMain.id("manganese_iii_oxide"))
            .color(Pyrolusite.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("Mn2O3");

    public static final Material MercuryChloride = new Material.Builder(EVMain.id("mercury_chloride"))
            .color(0xd6b8ad)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("HgCl2");

    public static final Material SodiumSulfanilate = new Material.Builder(EVMain.id("sodium_sulfanilate"))
            .color(0xe49879)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C6H6NNaO3S");

    public static final Material Anthraquinone = new Material.Builder(EVMain.id("anthraquinone"))
            .color(0xfff782)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C14H8O2");

    public static final Material LithiumHydride = new Material.Builder(EVMain.id("lithium_hydride"))
            .color((Lithium.getMaterialRGB() + Hydrogen.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("LiH");

    public static final Material NiobiumChloride = new Material.Builder(EVMain.id("niobium_chloride"))
            .color(Niobium.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("NbCl5");

    public static final Material NiobiumHydroxide = new Material.Builder(EVMain.id("niobium_hydroxide"))
            .color(0x7c7c7c)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Nb(OH)5");

    public static final Material MagnesiumFluoride = new Material.Builder(EVMain.id("magnesium_fluoride"))
            .color(0xcfcfcf)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("MgF2");


    public static final Material LithiumNiobateNanoparticles = new Material.Builder(EVMain.id("lithium_niobate_nanoparticles"))
            .color(LithiumNiobate.getMaterialRGB() - 10)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("LiNbO4");

    public static final Material LithiumHydroxide = new Material.Builder(EVMain.id("lithium_hydroxide"))
            .color((Lithium.getMaterialRGB() + Oxygen.getMaterialRGB() + Hydrogen.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("LiOH");

    public static final Material RhReNqCatalyst = new Material.Builder(EVMain.id("rhrenq_catalyst"))
            .color((Rhenium.getMaterialRGB() + Rhodium.getMaterialRGB() + Naquadah.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ReRhNq");

    public static final Material PalladiumAcetate = new Material.Builder(EVMain.id("palladium_acetate"))
            .color(0xcc3300)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C4H6O4Pd");

    public static final Material FranciumCaesiumCadmiumBromide = new Material.Builder(EVMain.id("francium_caesium_cadmium_bromide"))
            .color((Francium.getMaterialRGB() + Caesium.getMaterialRGB() + Cadmium.getMaterialRGB() + Bromine.getMaterialRGB()) / 4)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("FrCsCf2Br6");

    public static final Material ZincSelenide = new Material.Builder(EVMain.id("zinc_selenide"))
            .color(0xfcfc00)
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("ZnSe");

    public static final Material RhodamineB = new Material.Builder(EVMain.id("rhodamine_b"))
            .color(0xfc2020)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C28H31ClN2O3");

    public static final Material Stilbene = new Material.Builder(EVMain.id("stilbene"))
            .color(0x3c9c3c)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C14H12");

    public static final Material Tetracene = new Material.Builder(EVMain.id("tetracene"))
            .color(0x99801a)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C18H12");

    public static final Material DitertbutylDicarbonate = new Material.Builder(EVMain.id("ditertbutyl_dicarbonate"))
            .color(0xccccf6)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C10H18O5");

    public static final Material PotassiumBromide = new Material.Builder(EVMain.id("potassium_bromide"))
            .color(0xe066a3)
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("KBr");

    public static final Material PotassiumBromate = new Material.Builder(EVMain.id("potassium_bromate"))
            .color(0x8a4cd1)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("KBrO3");

    public static final Material IBX = new Material.Builder(EVMain.id("ibx"))
            .color(0x20208c)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C7H5IO4");

    public static final Material SodiumPertechnetate = new Material.Builder(EVMain.id("sodium_pertechnetate"))
            .color(0x6162c4)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("NaTcO4");

    public static final Material PotassiumPertechnate = new Material.Builder(EVMain.id("potassium_pertechnate"))
            .color(0xdec451)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("KTcO4");

    public static final Material PotassiumPerrhenate = new Material.Builder(EVMain.id("potassium_perrhenate"))
            .color(0xdec451)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("KReO4");

    public static final Material PotassiumNonahydridotechnetate = new Material.Builder(EVMain.id("potassium_nonahydridotechnetate"))
            .color(0xede2a4)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("H9K2TcO4");

    public static final Material PotassiumNonahydridorhenate = new Material.Builder(EVMain.id("potassium_nonahydridorhenate"))
            .color(0xeae2a8)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("H9K2ReO4");

    public static final Material LithiumIodide = new Material.Builder(EVMain.id("lithium_iodide"))
            .color(Lithium.getMaterialRGB() + Iodine.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("LiI");

    public static final Material PalladiumLoadedRutileNanoparticles = new Material.Builder(EVMain.id("palladium_loaded_rutile_nanoparticles"))
            .color(Palladium.getMaterialRGB() + Rutile.getMaterialRGB())
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("PdTiO2");

    public static final Material SaccharicAcid = new Material.Builder(EVMain.id("saccharic_acid"))
            .color(Glucose.getMaterialRGB())
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("C6H10O8");

    public static final Material AdipicAcid = new Material.Builder(EVMain.id("adipic_acid"))
            .color(0xda9288)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C6H10O4", true);

    public static final Material TetraethylammoniumNonahydridides = new Material.Builder(EVMain.id("tetraethylammonium_nonahydrides"))
            .color(0xbee8b9)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(C8H20N)(ReH9)(TcH9)", true);

    public static final Material ManganeseFluoride = new Material.Builder(EVMain.id("manganese_fluoride"))
            .color(Pyrolusite.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("MnF2", true);

    public static final Material GermaniumSulfide = new Material.Builder(EVMain.id("germanium_sulfide"))
            .color(GermaniumOxide.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("GeS2", true);

    public static final Material BismuthGermanate = new Material.Builder(EVMain.id("bismuth_germanate"))
            .color(0x94cf5c)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Bi12GeO20", true);

    public static final Material CesiumIodide = new Material.Builder(EVMain.id("cesium_iodide"))
            .color(CaesiumHydroxide.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("CsI", true);

    public static final Material TlTmCesiumIodide = new Material.Builder(EVMain.id("tl_tm_cesium_iodide"))
            .color(CaesiumHydroxide.getMaterialRGB() * 9 / 10 + Thallium.getMaterialRGB() / 10)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("CsITlTm", true);

    public static final Material CadmiumTungstate = new Material.Builder(EVMain.id("cadmium_tungstate"))
            .color(CalciumTungstate.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("CdWO4", true);

    public static final Material PolycyclicAromaticMix = new Material.Builder(EVMain.id("polycyclic_aromatic_mix"))
            .color(Tetracene.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C18H12", true);

    public static final Material SodiumOxide = new Material.Builder(EVMain.id("sodium_oxide"))
            .color(0x0373fc)
            .dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Na2O", true);

    public static final Material GrapheneOxide = new Material.Builder(EVMain.id("graphene_oxide"))
            .color(Graphene.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C(O2)", true);

    public static final Material GraphiteOxide = new Material.Builder(EVMain.id("graphite_oxide"))
            .color(Graphite.getMaterialRGB())
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("C(O2)", true);

    public static final Material ChromiumIIIOxide = new Material.Builder(EVMain.id("chromium_iii_oxide"))
            .color(0x4bf25f)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Cr2O3", true);

    public static final Material GrapheneGelSuspension = new Material.Builder(EVMain.id("graphene_gel_suspension"))
            .color(0xadadad)
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C", true);

    public static final Material DryGrapheneGel = new Material.Builder(EVMain.id("dry_graphene_gel"))
            .color(0x3a3ada)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C", true);

    public static final Material SodiumPerchlorate = new Material.Builder(EVMain.id("sodium_perchlorate"))
            .color(Salt.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("NaClO4", true);


    //periodicium stuff

    public static final Material PreciousMetals = new Material.Builder(EVMain.id("precious_metals"))
            .color((Ruthenium.getMaterialRGB() + Rhodium.getMaterialRGB() + Palladium.getMaterialRGB() + Silver.getMaterialRGB() + Rhenium.getMaterialRGB() + Osmium.getMaterialRGB() + Iridium.getMaterialRGB() + Platinum.getMaterialRGB() + Gold.getMaterialRGB()) / 9)
            .iconSet(MaterialIconSet.SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("RuRhPdAgReOsIrPtAu", true);

    public static final Material PostTransitionMetals = new Material.Builder(EVMain.id("post_transition_metals"))
            .color((Aluminium.getMaterialRGB() + Silicon.getMaterialRGB() + Zinc.getMaterialRGB() + Gallium.getMaterialRGB() + Germanium.getMaterialRGB() + Cadmium.getMaterialRGB() + Indium.getMaterialRGB() + Tin.getMaterialRGB() + Antimony.getMaterialRGB() + Mercury.getMaterialRGB() + Thallium.getMaterialRGB() + Lead.getMaterialRGB() + Bismuth.getMaterialRGB() + Polonium.getMaterialRGB()) / 14)
            .iconSet(MaterialIconSet.SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("AlSiZnGaGeCdInSnSbHgTlPbBiPo", true);


    public static final Material RefractoryMetals = new Material.Builder(EVMain.id("refractory_metals"))
            .color((Zirconium.getMaterialRGB() + Niobium.getMaterialRGB() + Molybdenum.getMaterialRGB() + Technetium.getMaterialRGB() + Hafnium.getMaterialRGB() + Tantalum.getMaterialRGB() + Tungsten.getMaterialRGB()) / 7)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("ZrNbMoTcHfTaW", true);

    public static final Material LightTransitionMetals = new Material.Builder(EVMain.id("light_transition_metals"))
            .color((Titanium.getMaterialRGB() + Vanadium.getMaterialRGB() + Chromium.getMaterialRGB() + Manganese.getMaterialRGB() + Iron.getMaterialRGB() + Cobalt.getMaterialRGB() + Nickel.getMaterialRGB() + Copper.getMaterialRGB()) / 8)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("TiVCrMnFeCoNiCu", true);

    public static final Material Alkalis = new Material.Builder(EVMain.id("alkalis"))
            .color((Lithium.getMaterialRGB() + Beryllium.getMaterialRGB() + Sodium.getMaterialRGB() + Magnesium.getMaterialRGB() + Potassium.getMaterialRGB() + Calcium.getMaterialRGB() + Scandium.getMaterialRGB() + Rubidium.getMaterialRGB() + Strontium.getMaterialRGB() + Yttrium.getMaterialRGB() + Caesium.getMaterialRGB() + Barium.getMaterialRGB() + Francium.getMaterialRGB() + Radium.getMaterialRGB()) / 12)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("LiBeNaMgKCaScRbSrYCeBaFrRa", true);

    public static final Material Lanthanoids = new Material.Builder(EVMain.id("lanthanoids"))
            .color((Lanthanum.getMaterialRGB() + Cerium.getMaterialRGB() + Praseodymium.getMaterialRGB() + Neodymium.getMaterialRGB() + Promethium.getMaterialRGB() + Samarium.getMaterialRGB() + Europium.getMaterialRGB() + Gadolinium.getMaterialRGB() + Terbium.getMaterialRGB() + Dysprosium.getMaterialRGB() + Holmium.getMaterialRGB() + Erbium.getMaterialRGB() + Thulium.getMaterialRGB() + Ytterbium.getMaterialRGB() + Lutetium.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("LaPrNdPmSmEuGdTbDyHoErTmYbLu", true);

    public static final Material Actinoids = new Material.Builder(EVMain.id("actinoids"))
            .color((Actinium.getMaterialRGB() + Thorium.getMaterialRGB() + Protactinium.getMaterialRGB() + Uranium238.getMaterialRGB() + Neptunium.getMaterialRGB() + Plutonium241.getMaterialRGB() + Americium.getMaterialRGB() + Curium.getMaterialRGB() + Berkelium.getMaterialRGB() + Californium.getMaterialRGB() + Einsteinium.getMaterialRGB() + Fermium.getMaterialRGB() + Mendelevium.getMaterialRGB()) / 13)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("AcThPaNpPuAmCmBkCfEsFmMd", true);


    public static final Material MercuryAcetate = new Material.Builder(EVMain.id("mercury_acetate"))
            .color(0xcc8562)
            .iconSet(MaterialIconSet.ROUGH)
            .dust()
            .buildAndRegister()
            .setFormula("Hg(CH3COO)2", true);

    public static final Material CalciumCyanamide = new Material.Builder(EVMain.id("calcium_cyanamide"))
            .color(CalciumCarbide.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("CaCN2", true);

    public static final Material SelectivelyMutatedCupriavidiusNecator = new Material.Builder(EVMain.id("selectively_mutated_cupriavidius_necator"))
            .color(CupriavidusNecator.getMaterialRGB() * 5 / 4)
            .iconSet(MaterialIconSet.SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("Bacteria", true);

    public static final Material PurifiedColumbite = new Material.Builder(EVMain.id("purified_columbite"))
            .color(LeachedColumbite.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY)
            .dust()
            .buildAndRegister()
            .setFormula("Ta2O5Nb18O45", true);

    public static final Material PurifiedPyrochlore = new Material.Builder(EVMain.id("purified_pyrochlore"))
            .color(LeachedPyrochlore.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("Ta2O5Nb18O45", true);

    public static final Material ChargedCesiumCeriumCobaltIndium = new Material.Builder(EVMain.id("charged_cesium_cerium_cobalt_indium"))
            .color(0x52ad25).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("CsCeCo2In10", true);

    public static final Material RheniumChloride = new Material.Builder(EVMain.id("rhenium_chloride"))
            .color(0x3c2a5c).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ReCl5", true);

    public static final Material AntimonyTrichloride = new Material.Builder(EVMain.id("antimony_trichloride"))
            .color(AntimonyTrifluoride.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("SbCl3", true);

    public static final Material LithiumCobaltOxide = new Material.Builder(EVMain.id("lithium_cobalt_oxide"))
            .color(0xd2a4f3).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("LiCoO", true);

    public static final Material LithiumTriflate = new Material.Builder(EVMain.id("lithium_triflate"))
            .color(0xe2dae3).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("LiCSO3F3", true);

    public static final Material Xylose = new Material.Builder(EVMain.id("xylose"))
            .color(Glucose.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("C5H10O5", true);

    public static final Material SiliconNanoparticles = new Material.Builder(EVMain.id("silicon_nanoparticles"))
            .color(Silicon.getMaterialRGB()).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Si?", true);

    public static final Material Halloysite = new Material.Builder(EVMain.id("halloysite"))
            .color(0x23423a).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Al9Si10O50Ga", true);

    public static final Material GalliumChloride = new Material.Builder(EVMain.id("gallium_chloride"))
            .color(0x92867a).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("GaCl3", true);

    public static final Material SulfurCoatedHalloysite = new Material.Builder(EVMain.id("sulfur_coated_halloysite"))
            .color(0x23973a).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("S2C2(Al9Si10O50Ga)", true);

    public static final Material FluorideBatteryElectrolyte = new Material.Builder(EVMain.id("fluoride_battery_electrolyte"))
            .color(0x9a628a).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("La9BaF29(C8H7F)", true);

    public static final Material LanthanumNickelOxide = new Material.Builder(EVMain.id("lanthanum_nickel_oxide"))
            .color(Garnierite.getMaterialRGB() / 2 + Lanthanum.getMaterialRGB() / 2)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("La2NiO4", true);

    public static final Material Sorbose = new Material.Builder(EVMain.id("sorbose"))
            .color(Glucose.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("C6H12O6", true);

    public static final Material CalciumAlginate = new Material.Builder(EVMain.id("calcium_alginate"))
            .color(0x654321).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CaC12H14O12", true);

    public static final Material NickelOxideHydroxide = new Material.Builder(EVMain.id("nickel_oxide_hydroxide"))
            .color(0xa2f2a2).dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("NiO(OH)", true);

    public static final Material BETSPerrhenate = new Material.Builder(EVMain.id("bets_perrhenate"))
            .color(0x7ada00).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ReC10H8S4Se4O4", true);

    public static final Material TBCCODust = new Material.Builder(EVMain.id("tbcco_dust"))
            .color(0x669900).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("TlBa2Ca2Cu3O10", true);

    public static final Material BorocarbideDust = new Material.Builder(EVMain.id("borocarbide_dust"))
            .color(0x9a9a2a).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("B4C7Fr4At6Ho2Th2Fl2Cn2", true);

    public static final Material ActiniumSuperhydride = new Material.Builder(EVMain.id("actinium_superhydride"))
            .color(Actinium.getMaterialRGB() * 9 / 8)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("AcH12", true);

    public static final Material StrontiumSuperconductorDust = new Material.Builder(EVMain.id("strontium_superconductor_dust"))
            .color(0x45abf4).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Sr2RuSgO8", true);

    public static final Material FullereneSuperconductiveDust = new Material.Builder(EVMain.id("fullerene_superconductor_dust"))
            .color(0x99cc00).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("LaCsRb(C60)2", true);

    public static final Material HassiumChloride = new Material.Builder(EVMain.id("hassium_chloride"))
            .color(0x5d2abc).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("HsCl4", true);

    public static final Material RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate = new Material.Builder(EVMain.id("rhenium_hassium_thallium_isophtaloylbisdiethylthiourea"))
            .color(0xa26a8b).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ReHsTlC60PN12H84S6O12F6", true);

    public static final Material Legendarium = new Material.Builder(EVMain.id("legendarium"))
            .color(0xffffff).dust()
            .iconSet(MaterialIconSet.SHINY)
            .flags(AUTOGEN_MIXER_RECIPE)
            .components(Naquadah, 1, NaquadahEnriched, 1, Naquadria, 1, Vibranium, 1, Adamantium, 1, Taranium, 1, Trinium, 1, Duranium, 1, Tritanium, 1)
            .buildAndRegister()
            .setFormula("NqNq+*Nq*DrTrKeTnAdVb", true);

    public static final Material LanthanumFullereneNanotubes = new Material.Builder(EVMain.id("lanthanum_fullerene_nanotubes"))
            .color(LanthanumFullereneMix.getMaterialRGB() * 3 / 5)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("La2(C60)2CNT", true);

    public static final Material SodiumMetavanadate = new Material.Builder(EVMain.id("sodium_metavanadate"))
            .color(SodaAsh.getMaterialRGB())
            .iconSet(MaterialIconSet.FINE).dust()
            .buildAndRegister()
            .setFormula("NaVO3", true);

    public static final Material PotassiumPeroxymonosulfate = new Material.Builder(EVMain.id("potassium_peroxymonosulfate"))
            .color(PotassiumMetabisulfite.getMaterialRGB() + 20)
            .iconSet(MaterialIconSet.FINE).dust()
            .buildAndRegister()
            .setFormula("KHSO5", true);

    public static final Material CoAcABCatalyst = new Material.Builder(EVMain.id("coacab_catalyst"))
            .color(0x755f30).dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("Co/AC-AB", true);

    public static final Material SilverPerchlorate = new Material.Builder(EVMain.id("silver_perchlorate"))
            .color(SilverChloride.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("AgClO4", true);

    public static final Material SodiumChlorate = new Material.Builder(EVMain.id("sodium_chlorate"))
            .color(Salt.getMaterialRGB()).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NaClO3", true);

    public static final Material CopperLeach = new Material.Builder(EVMain.id("copper_leach"))
            .color(0x765A30).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Cu3?", true);


    public static final Material Durene = new Material.Builder(EVMain.id("durene"))
            .color(0xA39C95).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C6H2(CH3)4", true);

    public static final Material PyromelliticDianhydride = new Material.Builder(EVMain.id("pyromellitic_dianhydride"))
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C6H2(C2O3)2", true);

    public static final Material CaliforniumTrioxide = new Material.Builder(EVMain.id("californiumtrioxide"))
            .color(0x7cc922).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Cf2O3", true);

    public static final Material CaliforniumTrichloride = new Material.Builder(EVMain.id("californiumtrichloride"))
            .color(0x3e9837).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CfCl3", true);

    public static final Material IridiumTrioxide = new Material.Builder(EVMain.id("iridiumtrioxide"))
            .color(0x9a9a2b).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Ir2O3", true);

    public static final Material PotassiumHydroxylaminedisulfonate = new Material.Builder(EVMain.id("potassium_hydroxylaminedisulfonate"))
            .color((0xF0EAD6 + NitrousAcid.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("KHSO3", true);

    public static final Material SuccinicAnhydride = new Material.Builder(EVMain.id("succinic_anhydride"))
            .color((SuccinicAcid.getMaterialRGB() + AceticAnhydride.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("(CH2CO)2O", true);

    public static final Material AmmoniumAcetate = new Material.Builder(EVMain.id("ammonium_acetate"))
            .color(0xb6dee0).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("NH4CH3CO2", true);

    public static final Material Acetamide = new Material.Builder(EVMain.id("acetamide"))
            .color(0xa6bebf).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("CH3CONH2", true);

    public static final Material Acetonitrile = new Material.Builder(EVMain.id("acetonitrile"))
            .color(0xa2afb0).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("CH3CN", true);

    public static final Material NHydroxysuccinimide = new Material.Builder(EVMain.id("n-hydroxysuccinimide"))
            .color(0xdbcae3).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(CH2CO)2NOH", true);

    public static final Material Hexabenzylhexaazaisowurtzitane = new Material.Builder(EVMain.id("hexabenzylhexaazaisowurtzitane"))
            .color(0x624573).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C48N6H48", true);

    public static final Material SuccinimidylAcetate = new Material.Builder(EVMain.id("succinimidyl_acetate"))
            .color(0xbd93a6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C6H7NO4", true);

    public static final Material DibenzylTetraacetylhexaazaisowurtzitane = new Material.Builder(EVMain.id("dibenzyltetraacetylhexaazaisowurtzitane"))
            .color(0xb3c98b).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C28N6H32O4", true);

    public static final Material HexanitroHexaazaisowurtzitane = new Material.Builder(EVMain.id("hexanitrohexaazaisowurtzitane"))
            .color(0x414a4f).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C6H6N12O12", true);

    public static final Material NitroniumTetrafluoroborate = new Material.Builder(EVMain.id("nitronium_tetrafluoroborate"))
            .color(0x686c6e).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("NO2BF4", true);

    public static final Material NitrosoniumTetrafluoroborate = new Material.Builder(EVMain.id("nitrosonium_tetrafluoroborate"))
            .color(0x7e8d94).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("NOBF4", true);

    public static final Material Hexamethylenetetramine = new Material.Builder(EVMain.id("hexamethylenetetramine"))
            .color(0x7e8d94).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(CH2)6N4", true);

    public static final Material PdCCatalyst = new Material.Builder(EVMain.id("pdc_catalyst"))
            .color((Palladium.getMaterialRGB() + Carbon.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("PdC", true);

    public static final Material Tetraacetyldinitrosohexaazaisowurtzitane = new Material.Builder(EVMain.id("tetraacetyldinitrosohexaazaisowurtzitane"))
            .color((DibenzylTetraacetylhexaazaisowurtzitane.getMaterialRGB() + Hexabenzylhexaazaisowurtzitane.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("C14N8H18O6", true);

    public static final Material CrudeHexanitroHexaazaisowurtzitane = new Material.Builder(EVMain.id("crude_hexanitrohexaazaisowurtzitane"))
            .color(HexanitroHexaazaisowurtzitane.getMaterialRGB() * 5 / 7)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("C6H6N12O12", true);

    public static final Material PotassiumBisulfite = new Material.Builder(EVMain.id("potassium_bisulfite"))
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("KHSO3", true);

    public static final Material PotassiumNitrite = new Material.Builder(EVMain.id("potassium_nitrite"))
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("KNO2", true);

    public static final Material HydroxylammoniumSulfate = new Material.Builder(EVMain.id("hydroxylammonium_sulfate"))
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(NH3OH)2SO4", true);

    public static final Material SodiumBorohydride = new Material.Builder(EVMain.id("sodium_borohydride"))
            .color(0xc2c2fa).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NaBH4", true);

    public static final Material SodiumTetrafluoroborate = new Material.Builder(EVMain.id("sodium_tetrafluoroborate"))
            .color((SodiumBorohydride.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("NaBF4", true);

    public static final Material Decaborane = new Material.Builder(EVMain.id("decaborane"))
            .color(Diborane.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("B10H14", true);

    public static final Material CesiumCarboranePrecusor = new Material.Builder(EVMain.id("cesium_carborane_precursor"))
            .color(0xb56487).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CsB10H12CN(CH3)3Cl", true);

    public static final Material CesiumCarborane = new Material.Builder(EVMain.id("cesium_carborane"))
            .color(CesiumCarboranePrecusor.getMaterialRGB() * 6 / 5)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("CsCB11H12", true);

    public static final Material Fluorocarborane = new Material.Builder(EVMain.id("fluorocarborane"))
            .color(0x20EB7A).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("HCHB11F11", true);

    public static final Material CaesiumNitrate = new Material.Builder(EVMain.id("caesium_nitrate"))
            .color(0x7452DC).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CsNO3", true);

    public static final Material SilverIodide = new Material.Builder(EVMain.id("silver_iodide"))
            .color((SilverChloride.getMaterialRGB() * 2 + Iodine.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("AgI", true);

    public static final Material ActiniumTriniumHydroxides = new Material.Builder(EVMain.id("actinium_trinium_hydroxides"))
            .color((ActiniumOxalate.getMaterialRGB() + Trinium.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("Ke3Ac2(OH)12", true);

    public static final Material TriniumTetrafluoride = new Material.Builder(EVMain.id("trinium_tetrafluoride"))
            .color(0x477347).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("KeF4", true);

    public static final Material ActiniumNitrate = new Material.Builder(EVMain.id("actinium_nitrate"))
            .color(YttriumNitrate.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("Ac(NO3)3", true);

    public static final Material RadiumNitrate = new Material.Builder(EVMain.id("radium_nitrate"))
            .color(BariumNitrate.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("Ra(NO3)2", true);

    public static final Material PhosphorousPentasulfide = new Material.Builder(EVMain.id("phosphorous_pentasulfide"))
            .color(0xEBAD24).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("P4S10", true);

    public static final Material PureCrystallineNitricAcid = new Material.Builder(EVMain.id("pure_crystalline_nitric_acid"))
            .color(NitricAcid.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("HNO3", true);

    public static final Material StoneResidueDust = new Material.Builder(EVMain.id("stone_residue_dust"))
            .color(Stone.getMaterialRGB() / 5 * 3)
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister();

    public static final Material DiamagneticResidues = new Material.Builder(EVMain.id("diamagnetic_residues"))
            .color((Calcium.getMaterialRGB() + Zinc.getMaterialRGB() + Copper.getMaterialRGB() + Gallium.getMaterialRGB() + Beryllium.getMaterialRGB() + Tin.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyDiamagneticResidues = new Material.Builder(EVMain.id("heavy_diamagnetic_residues"))
            .color((Lead.getMaterialRGB() + Mercury.getMaterialRGB() + Cadmium.getMaterialRGB() + Indium.getMaterialRGB() + Gold.getMaterialRGB() + Bismuth.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material ParamagneticResidues = new Material.Builder(EVMain.id("paramagnetic_residues"))
            .color((Sodium.getMaterialRGB() + Potassium.getMaterialRGB() + Magnesium.getMaterialRGB() + Titanium.getMaterialRGB() + Vanadium.getMaterialRGB() + Manganese.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyParamagneticResidues = new Material.Builder(EVMain.id("heavy_paramagnetic_residues"))
            .color((Thorium.getMaterialRGB() + Thallium.getMaterialRGB() + Uranium238.getMaterialRGB() + Tungsten.getMaterialRGB() + Hafnium.getMaterialRGB() + Tantalum.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material FerromagneticResidues = new Material.Builder(EVMain.id("ferromagnetic_residues"))
            .color((Iron.getMaterialRGB() + Nickel.getMaterialRGB() + Cobalt.getMaterialRGB()) / 7)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyFerromagneticResidues = new Material.Builder(EVMain.id("heavy_ferromagnetic_residues"))
            .color(DysprosiumOxide.getMaterialRGB() * 3 / 11)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material UncommonResidues = new Material.Builder(EVMain.id("uncommon_residues"))
            .color((Triniite.getMaterialRGB() + NaquadriaticTaranium.getMaterialRGB() + PreciousMetals.getMaterialRGB()) / 5)
            .iconSet(MaterialIconSet.FINE).dust()
            .buildAndRegister();

    public static final Material PartiallyOxidizedResidues = new Material.Builder(EVMain.id("partially_oxidized_residues"))
            .color(StoneResidueDust.getMaterialRGB() + Dioxygendifluoride.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material MetallicResidues = new Material.Builder(EVMain.id("metallic_residues"))
            .color((DiamagneticResidues.getMaterialRGB() + ParamagneticResidues.getMaterialRGB() + FerromagneticResidues.getMaterialRGB() + UncommonResidues.getMaterialRGB() / 3) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyMetallicResidues = new Material.Builder(EVMain.id("heavy_metallic_residues"))
            .color((HeavyDiamagneticResidues.getMaterialRGB() + HeavyParamagneticResidues.getMaterialRGB() + HeavyFerromagneticResidues.getMaterialRGB() + UncommonResidues.getMaterialRGB() / 3) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material OxidizedResidues = new Material.Builder(EVMain.id("oxidized_residues"))
            .color((DiamagneticResidues.getMaterialRGB() + ParamagneticResidues.getMaterialRGB() + FerromagneticResidues.getMaterialRGB() + 0x9f0000) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyOxidizedResidues = new Material.Builder(EVMain.id("heavy_oxidized_residues"))
            .color((DiamagneticResidues.getMaterialRGB() + ParamagneticResidues.getMaterialRGB() + FerromagneticResidues.getMaterialRGB() + 0x9f0000) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material ExoticHeavyResidues = new Material.Builder(EVMain.id("exotic_heavy_residues"))
            .color(NitratedTriniiteSolution.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister();

    public static final Material CleanInertResidues = new Material.Builder(EVMain.id("clean_inert_residues"))
            .color((Taranium.getMaterialRGB() + Xenon.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister();

    public static final Material IridiumCyclooctadienylChlorideDimer = new Material.Builder(EVMain.id("iridium_cyclooctadienyl_chloride_dimer"))
            .color((Dichlorocycloctadieneplatinium.getMaterialRGB() + Iridium.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("Ir2(C8H12)2Cl2", true);

    public static final Material FinelyPowderedRutile = new Material.Builder(EVMain.id("finely_powdered_rutile"))
            .color(0xffffff).dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("TiO2", true);

    public static final Material InertResidues = new Material.Builder(EVMain.id("inert_residues"))
            .color(0x61587a).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister();

    public static final Material MicaPulp = new Material.Builder(EVMain.id("mica_pulp"))
            .dust()
            .color(0x917445)
            .iconSet(MaterialIconSet.SAND)
            .components(Mica, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material TitanSteel = new Material.Builder(EVMain.id("titan_steel"))
            .ingot(7)
            .color(0xAA0d0d)
            .iconSet(SHINY)
            .components(TungstenTitaniumCarbide, 3, Jasper, 3)
            .appendFlags(CORE_METAL)
            .blastTemp(9200)
            .buildAndRegister();


    public static final Material UVSuperconductorBase = new Material.Builder(EVMain.id("uv_superconductor_base"))
            .ingot()
            .color(0xe0d207)
            .iconSet(MaterialIconSet.SHINY)
            .components(Naquadria, 4, Osmiridium, 3, Rutherfordium, 1, Samarium, 1)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(8900)
            .buildAndRegister();

    public static final Material UVSuperconductor = new Material.Builder(EVMain.id("uv_superconductor"))
            .ingot()
            .color(0xe0d207)
            .iconSet(MaterialIconSet.SHINY)
            .components(UVSuperconductorBase, 1, Nitrogen, 1)
            .cableProperties(V[UV], 4, 0, true)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UHVSuperconductorBase = new Material.Builder(EVMain.id("uhv_superconductor_base"))
            .ingot()
            .color(0x359ffc)
            .iconSet(MaterialIconSet.SHINY)
            .components(TBCCODust, 4, StrontiumSuperconductorDust, 4, Taranium, 1)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(10000)
            .buildAndRegister();

    public static final Material UHVSuperconductor = new Material.Builder(EVMain.id("uhv_superconductor"))
            .ingot()
            .color(0x359ffc)
            .iconSet(MaterialIconSet.SHINY)
            .components(UHVSuperconductorBase, 1, Nitrogen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UEVSuperconductorBase = new Material.Builder(EVMain.id("uev_superconductor_base"))
            .ingot()
            .color(0x954fe0)
            .iconSet(MaterialIconSet.SHINY)
            .components(ActiniumSuperhydride, 1, BETSPerrhenate, 1, TriniumTitanium, 2, Quantum, 1, Adamantium, 1)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .blastTemp(11150)
            .buildAndRegister();

    public static final Material UEVSuperconductor = new Material.Builder(EVMain.id("uev_superconductor"))
            .ingot()
            .color(0x954fe0)
            .iconSet(MaterialIconSet.SHINY)
            .components(UEVSuperconductorBase, 1, Nitrogen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UIVSuperconductorBase = new Material.Builder(EVMain.id("uiv_superconductor_base"))
            .ingot()
            .color(0x8bf743)
            .iconSet(MaterialIconSet.SHINY)
            .components(BorocarbideDust, 2, FullereneSuperconductiveDust, 1, MetastableOganesson, 2, ProtoAdamantium, 2)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(11600)
            .buildAndRegister();

    public static final Material UIVSuperconductor = new Material.Builder(EVMain.id("uiv_superconductor"))
            .ingot()
            .color(0x8bf743)
            .iconSet(MaterialIconSet.SHINY)
            .components(UIVSuperconductorBase, 1, Nitrogen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UMVSuperconductorBase = new Material.Builder(EVMain.id("uxv_superconductor_base"))
            .ingot()
            .color(0x883afc)
            .iconSet(MaterialIconSet.SHINY)
            .components(BlackTitanium, 3, SuperheavyHAlloy, 2, ChargedCesiumCeriumCobaltIndium, 3, RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate, 6)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(12000)
            .buildAndRegister();

    public static final Material Einsteinium253 = new Material.Builder(EVMain.id("einsteinium_253"))
            .ingot()
            .color(Einsteinium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Es253)
            .buildAndRegister()
            .setFormula("Es253", true);

    public static final Material Einsteinium255 = new Material.Builder(EVMain.id("einsteinium_255"))
            .ingot()
            .color(Einsteinium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .iconSet(METALLIC)
            .element(Es255)
            .buildAndRegister()
            .setFormula("Es255", true);

    public static final Material HDCS = new Material.Builder(EVMain.id("hdcs"))
            .color(0x334433)
            .ingot()
            .iconSet(SHINY)
            .components(TungstenSteel, 12, HSSS, 9, HSSG, 6, Ruridit, 3, MagnetoResonatic, 2, Plutonium239, 1)
            .blastTemp(9900)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material EnrichedNaquadahAlloy = new Material.Builder(EVMain.id("enriched_naquadah_alloy"))
            .ingot()
            .iconSet(SHINY)
            .color(0x403f3d)
            .fluid()
            .components(NaquadahEnriched, 4, Rhodium, 2, Ruthenium, 2, Dubnium, 1, Rubidium, 2, Einsteinium255, 1)
            .appendFlags(EXT2_METAL)
            .blastTemp(10000)
            .buildAndRegister();

    public static final Material UMVSuperconductor = new Material.Builder(EVMain.id("uxv_superconductor"))
            .ingot()
            .color(0x883afc)
            .iconSet(MaterialIconSet.SHINY)
            .components(UMVSuperconductorBase, 1, Nitrogen, 1)
            .cableProperties(V[UXV], 4, 0, true)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UXVSuperconductorBase = new Material.Builder(EVMain.id("opv_superconductor_base"))
            .color(0xe34b5a)
            .iconSet(SHINY)
            .ingot()
            .components(Neutronium, 4, Legendarium, 5, ActiniumSuperhydride, 5, LanthanumFullereneNanotubes, 4, RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate, 12)
            .flags(AUTOGEN_MIXER_RECIPE)
            .blastTemp(14000)
            .buildAndRegister();

    public static final Material UXVSuperconductor = new Material.Builder(EVMain.id("opv_superconductor"))
            .color(0xe34b5a)
            .iconSet(SHINY)
            .ingot()
            .components(UXVSuperconductorBase, 1, Nitrogen, 1)
            .cableProperties(VA[OpV], 4, 0, true)
            .buildAndRegister();
}
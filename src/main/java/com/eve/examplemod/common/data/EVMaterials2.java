package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.common.data.EVElements.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.METALLIC;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.SHINY;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Nitrogen;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class EVMaterials2 {
    public static final List<MaterialFlag> EXT2_METAL = new ArrayList<>();
    public static final List<MaterialFlag> CORE_METAL = new ArrayList<>();

    static {
        EXT2_METAL.addAll(Arrays.asList(GENERATE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_LONG_ROD, AUTOGEN_MIXER_RECIPE));
        CORE_METAL.addAll(EXT2_METAL);
        CORE_METAL.addAll(Arrays.asList(GENERATE_RING, GENERATE_FRAME, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_DENSE));
    }
    public static void init(){

    }

    public static final Material ActiniumTriniumHydroxides = new Material.Builder(EVMain.id("actinium_trinium_hydroxides")).fluid()
            .color((ActiniumOxalate.getMaterialRGB() + Trinium.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("Ke3Ac2(OH)12", true);

    public static final Material TriniumTetrafluoride = new Material.Builder(EVMain.id("trinium_tetrafluoride")).fluid()
            .color(0x477347).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("KeF4", true);

    public static final Material ActiniumNitrate = new Material.Builder(EVMain.id("actinium_nitrate")).fluid()
            .color(YttriumNitrate.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("Ac(NO3)3", true);

    public static final Material RadiumNitrate = new Material.Builder(EVMain.id("radium_nitrate")).fluid()
            .color(BariumNitrate.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("Ra(NO3)2", true);

    public static final Material PhosphorousPentasulfide = new Material.Builder(EVMain.id("phosphorous_pentasulfide")).fluid()
            .color(0xEBAD24).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("P4S10", true);

    public static final Material PureCrystallineNitricAcid = new Material.Builder(EVMain.id("pure_crystalline_nitric_acid")).fluid()
            .color(NitricAcid.getMaterialRGB())
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("HNO3", true);

    public static final Material StoneResidueDust = new Material.Builder(EVMain.id("stone_residue_dust")).fluid()
            .color(Stone.getMaterialRGB() / 5 * 3)
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister();

    public static final Material DiamagneticResidues = new Material.Builder(EVMain.id("diamagnetic_residues")).fluid()
            .color((Calcium.getMaterialRGB() + Zinc.getMaterialRGB() + Copper.getMaterialRGB() + Gallium.getMaterialRGB() + Beryllium.getMaterialRGB() + Tin.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyDiamagneticResidues = new Material.Builder(EVMain.id("heavy_diamagnetic_residues")).fluid()
            .color((Lead.getMaterialRGB() + Mercury.getMaterialRGB() + Cadmium.getMaterialRGB() + Indium.getMaterialRGB() + Gold.getMaterialRGB() + Bismuth.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material ParamagneticResidues = new Material.Builder(EVMain.id("paramagnetic_residues")).fluid()
            .color((Sodium.getMaterialRGB() + Potassium.getMaterialRGB() + Magnesium.getMaterialRGB() + Titanium.getMaterialRGB() + Vanadium.getMaterialRGB() + Manganese.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyParamagneticResidues = new Material.Builder(EVMain.id("heavy_paramagnetic_residues")).fluid()
            .color((Thorium.getMaterialRGB() + Thallium.getMaterialRGB() + GTMaterials.Uranium238.getMaterialRGB() + Tungsten.getMaterialRGB() + Hafnium.getMaterialRGB() + Tantalum.getMaterialRGB()) / 15)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material FerromagneticResidues = new Material.Builder(EVMain.id("ferromagnetic_residues")).fluid()
            .color((Iron.getMaterialRGB() + Nickel.getMaterialRGB() + Cobalt.getMaterialRGB()) / 7)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyFerromagneticResidues = new Material.Builder(EVMain.id("heavy_ferromagnetic_residues")).fluid()
            .color(DysprosiumOxide.getMaterialRGB() * 3 / 11)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material UncommonResidues = new Material.Builder(EVMain.id("uncommon_residues")).fluid()
            .color((Triniite.getMaterialRGB() + NaquadriaticTaranium.getMaterialRGB() + PreciousMetals.getMaterialRGB()) / 5)
            .iconSet(MaterialIconSet.FINE).dust()
            .buildAndRegister();

    public static final Material PartiallyOxidizedResidues = new Material.Builder(EVMain.id("partially_oxidized_residues")).fluid()
            .color(StoneResidueDust.getMaterialRGB() + Dioxygendifluoride.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material MetallicResidues = new Material.Builder(EVMain.id("metallic_residues")).fluid()
            .color((DiamagneticResidues.getMaterialRGB() + ParamagneticResidues.getMaterialRGB() + FerromagneticResidues.getMaterialRGB() + UncommonResidues.getMaterialRGB() / 3) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyMetallicResidues = new Material.Builder(EVMain.id("heavy_metallic_residues")).fluid()
            .color((HeavyDiamagneticResidues.getMaterialRGB() + HeavyParamagneticResidues.getMaterialRGB() + HeavyFerromagneticResidues.getMaterialRGB() + UncommonResidues.getMaterialRGB() / 3) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material OxidizedResidues = new Material.Builder(EVMain.id("oxidized_residues")).fluid()
            .color((DiamagneticResidues.getMaterialRGB() + ParamagneticResidues.getMaterialRGB() + FerromagneticResidues.getMaterialRGB() + 0x9f0000) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material HeavyOxidizedResidues = new Material.Builder(EVMain.id("heavy_oxidized_residues")).fluid()
            .color((DiamagneticResidues.getMaterialRGB() + ParamagneticResidues.getMaterialRGB() + FerromagneticResidues.getMaterialRGB() + 0x9f0000) / 4)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister();

    public static final Material ExoticHeavyResidues = new Material.Builder(EVMain.id("exotic_heavy_residues")).fluid()
            .color(NitratedTriniiteSolution.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister();

    public static final Material CleanInertResidues = new Material.Builder(EVMain.id("clean_inert_residues")).fluid()
            .color((Taranium.getMaterialRGB() + Xenon.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister();

    public static final Material IridiumCyclooctadienylChlorideDimer = new Material.Builder(EVMain.id("iridium_cyclooctadienyl_chloride_dimer")).fluid()
            .color((Dichlorocycloctadieneplatinium.getMaterialRGB() + Iridium.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("Ir2(C8H12)2Cl2", true);

    public static final Material FinelyPowderedRutile = new Material.Builder(EVMain.id("finely_powdered_rutile")).fluid()
            .color(0xffffff).dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("TiO2", true);

    public static final Material InertResidues = new Material.Builder(EVMain.id("inert_residues")).fluid()
            .color(0x61587a).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister();

    public static final Material MicaPulp = new Material.Builder(EVMain.id("mica_pulp")).fluid()
            .dust()
            .color(0x917445)
            .iconSet(MaterialIconSet.SAND)
            .components(Mica, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material TitanSteel = new Material.Builder(EVMain.id("titan_steel")).fluid()
            .ingot(7)
            .color(0xAA0d0d)
            .iconSet(SHINY)
            .components(TungstenTitaniumCarbide, 3, Jasper, 3)
            .appendFlags(CORE_METAL)
            .blastTemp(9200)
            .buildAndRegister();


    public static final Material UVSuperconductorBase = new Material.Builder(EVMain.id("uv_superconductor_base")).fluid()
            .ingot()
            .color(0xe0d207)
            .iconSet(MaterialIconSet.SHINY)
            .components(Naquadria, 4, Osmiridium, 3, Rutherfordium, 1, Samarium, 1)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(8900)
            .buildAndRegister();

    public static final Material UVSuperconductor = new Material.Builder(EVMain.id("uv_superconductor")).fluid()
            .ingot()
            .color(0xe0d207)
            .iconSet(MaterialIconSet.SHINY)
            .components(UVSuperconductorBase, 1, Nitrogen, 1)
            .cableProperties(V[UV], 4, 0, true)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();















    public static final Material Einsteinium253 = new Material.Builder(EVMain.id("einsteinium_253")).fluid()
            .ingot()
            .color(Einsteinium.getMaterialRGB())
            .iconSet(METALLIC)
            .flags(GENERATE_NUCLEAR)
            .element(Es253)
            .buildAndRegister()
            .setFormula("Es253", true);

    public static final Material Einsteinium255 = new Material.Builder(EVMain.id("einsteinium_255")).fluid()
            .ingot()
            .color(Einsteinium.getMaterialRGB())
            .flags(GENERATE_NUCLEAR, FISSILE_OXIDE)
            .iconSet(METALLIC)
            .element(Es255)
            .buildAndRegister()
            .setFormula("Es255", true);

    public static final Material HDCS = new Material.Builder(EVMain.id("hdcs")).fluid()
            .color(0x334433)
            .ingot()
            .iconSet(SHINY)
            .components(TungstenSteel, 12, HSSS, 9, HSSG, 6, Ruridit, 3, MagnetoResonatic, 2, GTMaterials.Plutonium239, 1)
            .blastTemp(9900)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material EnrichedNaquadahAlloy = new Material.Builder(EVMain.id("enriched_naquadah_alloy")).fluid()
            .ingot()
            .iconSet(SHINY)
            .color(0x403f3d)
            .fluid()
            .components(NaquadahEnriched, 4, Rhodium, 2, Ruthenium, 2, Dubnium, 1, Rubidium, 2, Einsteinium255, 1)
            .appendFlags(EXT2_METAL)
            .blastTemp(10000)
            .buildAndRegister();



    public static final Material SulfurCoatedHalloysite = new Material.Builder(EVMain.id("sulfur_coated_halloysite")).fluid()
            .color(0x23973a).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("S2C2(Al9Si10O50Ga)", true);

    public static final Material FluorideBatteryElectrolyte = new Material.Builder(EVMain.id("fluoride_battery_electrolyte")).fluid()
            .color(0x9a628a).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("La9BaF29(C8H7F)", true);

    public static final Material LanthanumNickelOxide = new Material.Builder(EVMain.id("lanthanum_nickel_oxide")).fluid()
            .color(Garnierite.getMaterialRGB() / 2 + Lanthanum.getMaterialRGB() / 2)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("La2NiO4", true);

    public static final Material Sorbose = new Material.Builder(EVMain.id("sorbose")).fluid()
            .color(Glucose.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("C6H12O6", true);

    public static final Material CalciumAlginate = new Material.Builder(EVMain.id("calcium_alginate")).fluid()
            .color(0x654321).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CaC12H14O12", true);

    public static final Material NickelOxideHydroxide = new Material.Builder(EVMain.id("nickel_oxide_hydroxide")).fluid()
            .color(0xa2f2a2).dust()
            .iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("NiO(OH)", true);

    public static final Material BETSPerrhenate = new Material.Builder(EVMain.id("bets_perrhenate")).fluid()
            .color(0x7ada00).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ReC10H8S4Se4O4", true);

    public static final Material TBCCODust = new Material.Builder(EVMain.id("tbcco_dust")).fluid()
            .color(0x669900).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("TlBa2Ca2Cu3O10", true);

    public static final Material BorocarbideDust = new Material.Builder(EVMain.id("borocarbide_dust")).fluid()
            .color(0x9a9a2a).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("B4C7Fr4At6Ho2Th2Fl2Cn2", true);

    public static final Material ActiniumSuperhydride = new Material.Builder(EVMain.id("actinium_superhydride")).fluid()
            .color(Actinium.getMaterialRGB() * 9 / 8)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("AcH12", true);

    public static final Material StrontiumSuperconductorDust = new Material.Builder(EVMain.id("strontium_superconductor_dust")).fluid()
            .color(0x45abf4).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Sr2RuSgO8", true);

    public static final Material FullereneSuperconductiveDust = new Material.Builder(EVMain.id("fullerene_superconductor_dust")).fluid()
            .color(0x99cc00).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("LaCsRb(C60)2", true);

    public static final Material HassiumChloride = new Material.Builder(EVMain.id("hassium_chloride")).fluid()
            .color(0x5d2abc).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("HsCl4", true);

    public static final Material RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate = new Material.Builder(EVMain.id("rhenium_hassium_thallium_isophtaloylbisdiethylthiourea")).fluid()
            .color(0xa26a8b).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("ReHsTlC60PN12H84S6O12F6", true);

    public static final Material Legendarium = new Material.Builder(EVMain.id("legendarium")).fluid()
            .color(0xffffff).dust()
            .iconSet(MaterialIconSet.SHINY)
            .flags(AUTOGEN_MIXER_RECIPE)
            .components(Naquadah, 1, NaquadahEnriched, 1, Naquadria, 1, Vibranium, 1, Adamantium, 1, Taranium, 1, Trinium, 1, Duranium, 1, Tritanium, 1)
            .buildAndRegister()
            .setFormula("NqNq+*Nq*DrTrKeTnAdVb", true);

    public static final Material LanthanumFullereneNanotubes = new Material.Builder(EVMain.id("lanthanum_fullerene_nanotubes")).fluid()
            .color(LanthanumFullereneMix.getMaterialRGB() * 3 / 5)
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("La2(C60)2CNT", true);

    public static final Material SodiumMetavanadate = new Material.Builder(EVMain.id("sodium_metavanadate")).fluid()
            .color(SodaAsh.getMaterialRGB())
            .iconSet(MaterialIconSet.FINE).dust()
            .buildAndRegister()
            .setFormula("NaVO3", true);

    public static final Material PotassiumPeroxymonosulfate = new Material.Builder(EVMain.id("potassium_peroxymonosulfate")).fluid()
            .color(PotassiumMetabisulfite.getMaterialRGB() + 20)
            .iconSet(MaterialIconSet.FINE).dust()
            .buildAndRegister()
            .setFormula("KHSO5", true);

    public static final Material CoAcABCatalyst = new Material.Builder(EVMain.id("coacab_catalyst")).fluid()
            .color(0x755f30).dust()
            .iconSet(MaterialIconSet.FINE)
            .buildAndRegister()
            .setFormula("Co/AC-AB", true);

    public static final Material SilverPerchlorate = new Material.Builder(EVMain.id("silver_perchlorate")).fluid()
            .color(SilverChloride.getMaterialRGB())
            .iconSet(MaterialIconSet.SHINY).dust()
            .buildAndRegister()
            .setFormula("AgClO4", true);

    public static final Material SodiumChlorate = new Material.Builder(EVMain.id("sodium_chlorate")).fluid()
            .color(Salt.getMaterialRGB()).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NaClO3", true);

    public static final Material CopperLeach = new Material.Builder(EVMain.id("copper_leach")).fluid()
            .color(0x765A30).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Cu3?", true);


    public static final Material Durene = new Material.Builder(EVMain.id("durene")).fluid()
            .color(0xA39C95).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("C6H2(CH3)4", true);

    public static final Material PyromelliticDianhydride = new Material.Builder(EVMain.id("pyromellitic_dianhydride")).fluid()
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C6H2(C2O3)2", true);

    public static final Material CaliforniumTrioxide = new Material.Builder(EVMain.id("californiumtrioxide")).fluid()
            .color(0x7cc922).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Cf2O3", true);

    public static final Material CaliforniumTrichloride = new Material.Builder(EVMain.id("californiumtrichloride")).fluid()
            .color(0x3e9837).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CfCl3", true);

    public static final Material IridiumTrioxide = new Material.Builder(EVMain.id("iridiumtrioxide")).fluid()
            .color(0x9a9a2b).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Ir2O3", true);

    public static final Material PotassiumHydroxylaminedisulfonate = new Material.Builder(EVMain.id("potassium_hydroxylaminedisulfonate")).fluid()
            .color((0xF0EAD6 + NitrousAcid.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("KHSO3", true);

    public static final Material SuccinicAnhydride = new Material.Builder(EVMain.id("succinic_anhydride")).fluid()
            .color((SuccinicAcid.getMaterialRGB() + AceticAnhydride.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("(CH2CO)2O", true);

    public static final Material AmmoniumAcetate = new Material.Builder(EVMain.id("ammonium_acetate")).fluid()
            .color(0xb6dee0).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("NH4CH3CO2", true);

    public static final Material Acetamide = new Material.Builder(EVMain.id("acetamide")).fluid()
            .color(0xa6bebf).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("CH3CONH2", true);

    public static final Material Acetonitrile = new Material.Builder(EVMain.id("acetonitrile")).fluid()
            .color(0xa2afb0).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("CH3CN", true);

    public static final Material NHydroxysuccinimide = new Material.Builder(EVMain.id("n-hydroxysuccinimide")).fluid()
            .color(0xdbcae3).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(CH2CO)2NOH", true);

    public static final Material Hexabenzylhexaazaisowurtzitane = new Material.Builder(EVMain.id("hexabenzylhexaazaisowurtzitane")).fluid()
            .color(0x624573).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C48N6H48", true);

    public static final Material SuccinimidylAcetate = new Material.Builder(EVMain.id("succinimidyl_acetate")).fluid()
            .color(0xbd93a6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C6H7NO4", true);

    public static final Material DibenzylTetraacetylhexaazaisowurtzitane = new Material.Builder(EVMain.id("dibenzyltetraacetylhexaazaisowurtzitane")).fluid()
            .color(0xb3c98b).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C28N6H32O4", true);

    public static final Material HexanitroHexaazaisowurtzitane = new Material.Builder(EVMain.id("hexanitrohexaazaisowurtzitane")).fluid()
            .color(0x414a4f).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("C6H6N12O12", true);

    public static final Material NitroniumTetrafluoroborate = new Material.Builder(EVMain.id("nitronium_tetrafluoroborate")).fluid()
            .color(0x686c6e).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("NO2BF4", true);

    public static final Material NitrosoniumTetrafluoroborate = new Material.Builder(EVMain.id("nitrosonium_tetrafluoroborate")).fluid()
            .color(0x7e8d94).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("NOBF4", true);

    public static final Material Hexamethylenetetramine = new Material.Builder(EVMain.id("hexamethylenetetramine")).fluid()
            .color(0x7e8d94).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(CH2)6N4", true);

    public static final Material PdCCatalyst = new Material.Builder(EVMain.id("pdc_catalyst")).fluid()
            .color((Palladium.getMaterialRGB() + Carbon.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("PdC", true);

    public static final Material Tetraacetyldinitrosohexaazaisowurtzitane = new Material.Builder(EVMain.id("tetraacetyldinitrosohexaazaisowurtzitane")).fluid()
            .color((DibenzylTetraacetylhexaazaisowurtzitane.getMaterialRGB() + Hexabenzylhexaazaisowurtzitane.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("C14N8H18O6", true);

    public static final Material CrudeHexanitroHexaazaisowurtzitane = new Material.Builder(EVMain.id("crude_hexanitrohexaazaisowurtzitane")).fluid()
            .color(HexanitroHexaazaisowurtzitane.getMaterialRGB() * 5 / 7)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("C6H6N12O12", true);

    public static final Material PotassiumBisulfite = new Material.Builder(EVMain.id("potassium_bisulfite")).fluid()
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("KHSO3", true);

    public static final Material PotassiumNitrite = new Material.Builder(EVMain.id("potassium_nitrite")).fluid()
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("KNO2", true);

    public static final Material HydroxylammoniumSulfate = new Material.Builder(EVMain.id("hydroxylammonium_sulfate")).fluid()
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(NH3OH)2SO4", true);

    public static final Material SodiumBorohydride = new Material.Builder(EVMain.id("sodium_borohydride")).fluid()
            .color(0xc2c2fa).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("NaBH4", true);

    public static final Material SodiumTetrafluoroborate = new Material.Builder(EVMain.id("sodium_tetrafluoroborate")).fluid()
            .color((SodiumBorohydride.getMaterialRGB() + Fluorine.getMaterialRGB()) / 2)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("NaBF4", true);

    public static final Material Decaborane = new Material.Builder(EVMain.id("decaborane")).fluid()
            .color(Diborane.getMaterialRGB())
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("B10H14", true);

    public static final Material CesiumCarboranePrecusor = new Material.Builder(EVMain.id("cesium_carborane_precursor")).fluid()
            .color(0xb56487).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CsB10H12CN(CH3)3Cl", true);

    public static final Material CesiumCarborane = new Material.Builder(EVMain.id("cesium_carborane")).fluid()
            .color(CesiumCarboranePrecusor.getMaterialRGB() * 6 / 5)
            .iconSet(MaterialIconSet.DULL).dust()
            .buildAndRegister()
            .setFormula("CsCB11H12", true);

    public static final Material Fluorocarborane = new Material.Builder(EVMain.id("fluorocarborane")).fluid()
            .color(0x20EB7A).dust()
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("HCHB11F11", true);

    public static final Material CaesiumNitrate = new Material.Builder(EVMain.id("caesium_nitrate")).fluid()
            .color(0x7452DC).dust()
            .iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("CsNO3", true);

    public static final Material SilverIodide = new Material.Builder(EVMain.id("silver_iodide")).fluid()
            .color((SilverChloride.getMaterialRGB() * 2 + Iodine.getMaterialRGB()) / 3)
            .iconSet(MaterialIconSet.ROUGH).dust()
            .buildAndRegister()
            .setFormula("AgI", true);

    public static final Material UEVSuperconductorBase = new Material.Builder(EVMain.id("uev_superconductor_base")).fluid()
            .ingot()
            .color(0x954fe0)
            .iconSet(MaterialIconSet.SHINY)
            .components(ActiniumSuperhydride, 1, BETSPerrhenate, 1, TriniumTitanium, 2, Quantum, 1, Adamantium, 1)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .blastTemp(11150)
            .buildAndRegister();

    public static final Material UHVSuperconductorBase = new Material.Builder(EVMain.id("uhv_superconductor_base")).fluid()
            .ingot()
            .color(0x359ffc)
            .iconSet(MaterialIconSet.SHINY)
            .components(TBCCODust, 4, StrontiumSuperconductorDust, 4, Taranium, 1)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(10000)
            .buildAndRegister();

    public static final Material UXVSuperconductorBase = new Material.Builder(EVMain.id("opv_superconductor_base")).fluid()
            .color(0xe34b5a)
            .iconSet(SHINY)
            .ingot()
            .components(Neutronium, 4, Legendarium, 5, ActiniumSuperhydride, 5, LanthanumFullereneNanotubes, 4, RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate, 12)
            .flags(AUTOGEN_MIXER_RECIPE)
            .blastTemp(14000)
            .buildAndRegister();

    public static final Material UXVSuperconductor = new Material.Builder(EVMain.id("opv_superconductor")).fluid()
            .color(0xe34b5a)
            .iconSet(SHINY)
            .ingot()
            .components(UXVSuperconductorBase, 1, Nitrogen, 1)
            .cableProperties(VA[OpV], 4, 0, true)
            .buildAndRegister();

    public static final Material UMVSuperconductorBase = new Material.Builder(EVMain.id("uxv_superconductor_base")).fluid()
            .ingot()
            .color(0x883afc)
            .iconSet(MaterialIconSet.SHINY)
            .components(BlackTitanium, 3, SuperheavyHAlloy, 2, ChargedCesiumCeriumCobaltIndium, 3, RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate, 6)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(12000)
            .buildAndRegister();

    public static final Material UMVSuperconductor = new Material.Builder(EVMain.id("uxv_superconductor")).fluid()
            .ingot()
            .color(0x883afc)
            .iconSet(MaterialIconSet.SHINY)
            .components(UMVSuperconductorBase, 1, Nitrogen, 1)
            .cableProperties(V[UXV], 4, 0, true)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UIVSuperconductorBase = new Material.Builder(EVMain.id("uiv_superconductor_base")).fluid()
            .ingot()
            .color(0x8bf743)
            .iconSet(MaterialIconSet.SHINY)
            .components(BorocarbideDust, 2, FullereneSuperconductiveDust, 1, MetastableOganesson, 2, ProtoAdamantium, 2)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .appendFlags(STD_METAL)
            .blastTemp(11600)
            .buildAndRegister();

    public static final Material UIVSuperconductor = new Material.Builder(EVMain.id("uiv_superconductor")).fluid()
            .ingot()
            .color(0x8bf743)
            .iconSet(MaterialIconSet.SHINY)
            .components(UIVSuperconductorBase, 1, Nitrogen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UEVSuperconductor = new Material.Builder(EVMain.id("uev_superconductor")).fluid()
            .ingot()
            .color(0x954fe0)
            .iconSet(MaterialIconSet.SHINY)
            .components(UEVSuperconductorBase, 1, Nitrogen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material UHVSuperconductor = new Material.Builder(EVMain.id("uhv_superconductor")).fluid()
            .ingot()
            .color(0x359ffc)
            .iconSet(MaterialIconSet.SHINY)
            .components(UHVSuperconductorBase, 1, Nitrogen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();
}

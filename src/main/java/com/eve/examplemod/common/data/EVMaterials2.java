package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.AUTOGEN_MIXER_RECIPE;
import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.DISABLE_ELECTRIC_BLAST;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials.EXT2_METAL;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_FRAME;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.METALLIC;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EVMaterials2 {
    public static void init() {

    }

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

    public static final Material PdCCatalyst = new Material.Builder(EVMain.id("palladium_on_carbon"))
            .color((Palladium.getMaterialRGB() + Carbon.getMaterialRGB()) / 2)
            .dust()
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

    public static final Material PotassiumNitrate = new Material.Builder(EVMain.id("potassium_nitrate"))
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("KNO3", true);

    public static final Material HydroxylammoniumSulfate = new Material.Builder(EVMain.id("hydroxylammonium_sulfate"))
            .color(0xF0EAD6).dust()
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("(NH3OH)2SO4", true);

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

    public static final Material DebrominatedWater = new Material.Builder(EVMain.id("debrominated_water"))
            .color(0x0000ff)
            .fluid()
            .buildAndRegister()
            .setFormula("H2O");

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

    public static final Material Grisium = new Material.Builder(EVMain.id("grisium"))
            .color(0x355D6A)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Titanium, 9, Carbon, 9, Potassium, 9, Lithium, 9, Sulfur, 9, Hydrogen, 5)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(3850)
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

    public static final Material Inconel625 = new Material.Builder(EVMain.id("inconel_a"))
            .color(0x80C880)
            .iconSet(METALLIC)
            .ingot(6)
            .components(Nickel, 3, Chromium, 7, Molybdenum, 10, Invar, 10, Nichrome, 13)
            .appendFlags(EXT2_METAL)
            .flags(GENERATE_FRAME)
            .blastTemp(2425)
            .buildAndRegister();

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
            .cableProperties(2048, 4, 0, true)
            .components(Platinum, 1, Palladium, 2)
            .flags(DISABLE_DECOMPOSITION, AUTOGEN_MIXER_RECIPE)
            .blastTemp(1950, BlastProperty.GasTier.MID)
            .buildAndRegister();

    public static final Material IVSuperconductor = new Material.Builder(EVMain.id("iv_superconductor"))
            .color(0x300030)
            .iconSet(SHINY)
            .ingot(1)
            .cableProperties(8192, 1, 0, true)
            .components(IVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material ChromeYellow = new Material.Builder(EVMain.id("chrome_yellow"))
            .color(0xffff00)
            .iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("PbCrO4", true);

    // TODO colours
    public static final Material Dichlorodifluoromethane = new Material.Builder(EVMain.id("dichlorodifluoromethane"))
            .fluid()
            .color(9347289)
            .buildAndRegister()
            .setFormula("CCl2F2");

    public static final Material DichloroTerphenyl = new Material.Builder(EVMain.id("tetrachloro_terphenyl"))
            .fluid()
            .color(3284783)
            .buildAndRegister()
            .setFormula("C18H12Cl2");

    public static final Material Terphenyl = new Material.Builder(EVMain.id("terphenyl"))
            .fluid()
            .color(349839)
            .buildAndRegister()
            .setFormula("C18H14");

    public static final Material Dibromobenzene = new Material.Builder(EVMain.id("para-dibromobenzene"))
            .fluid()
            .buildAndRegister()
            .setFormula("C6H4Br2");

    public static final Material DichlorophenylboronicAcid = new Material.Builder(EVMain.id("2_6-dichlorophenylboronic_acid"))
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5Cl2B(OH)2");

    public static final Material PhenylboronicAcid = new Material.Builder(EVMain.id("phenylboronic_acid"))
            .dust()
            .buildAndRegister()
            .setFormula("C6H5B(OH)2");

    public static final Material Bromobenzene = new Material.Builder(EVMain.id("bromobenzene"))
            .fluid()
            .buildAndRegister()
            .setFormula("C6H5Br");

    public static final Material Dichlorobromobenzene = new Material.Builder(EVMain.id("dichlorobromobenzene"))
            .fluid()
            .buildAndRegister()
            .setFormula("C6H3Cl2Br");

    // todo colour

    public static final Material BrightSteel = new Material.Builder(EVMain.id("bright_steel"))
            .ingot(7)
            .color(0xAA0d0d)
            .iconSet(SHINY)
            .components(Iron, 4, Bismuth, 2, Caesium, 2, Europium, 1)
            .appendFlags(CORE_METAL)
            .cableProperties(8192, 3, 1)
            .blastTemp(2900)
            .buildAndRegister();

    public static final Material ZBLAN = new Material.Builder(EVMain.id("zblan"))
            .ingot()
            .fluid()
            .color((ZirconiumTetrafluoride.getMaterialRGB()+BariumDifluoride.getMaterialRGB()+LanthanumTrifluoride.getMaterialRGB()+AluminiumTrifluoride.getMaterialRGB())/4)
            .blastTemp(2500, BlastProperty.GasTier.HIGH)
            .components(ZirconiumTetrafluoride, 90, BariumDifluoride, 21, SodiumFluoride, 14, LanthanumTrifluoride, 8, AluminiumTrifluoride, 4)
            .flags(AUTOGEN_MIXER_RECIPE, GENERATE_FINE_WIRE)
            .buildAndRegister();

    public static final Material ErbiumDopedZBLAN = new Material.Builder(EVMain.id("erbium_doped_zblan"))
            .color((ZBLAN.getMaterialRGB() + ErbiumTrifluoride.getMaterialRGB()) / 2)
            .dust()
            .ingot()
            .blastTemp(2500, BlastProperty.GasTier.HIGH)
            .iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("(ErF3)(ZrF4)18(BaF2)7(LaF3)2(AlF3)(NaF)7", true);

    public static final Material Ferralium = new Material.Builder(EVMain.id("ferralium"))
            .ingot().iconSet(METALLIC)
            .color(0x1EF737)
            .blastTemp(3600, BlastProperty.GasTier.MID)
            .components(Steel, 8, Palladium, 3, Platinum, 4, Bismuth, 2, Yttrium, 3)
            .flags(GENERATE_FRAME, GENERATE_PLATE, AUTOGEN_MIXER_RECIPE)
            .buildAndRegister();

    public static final Material AbyssalAlloy = new Material.Builder(EVMain.id("abyssal_alloy"))
            .color(0x9E706A)
            .iconSet(METALLIC)
            .ingot(6)
            .components(StainlessSteel, 5, TungstenCarbide, 5, Nichrome, 5, Bronze, 5, Ferralium, 5, Iodine, 1, Germanium, 1, Radon, 1)
            .flags(DISABLE_DECOMPOSITION)
            .appendFlags(EXT2_METAL)
            .cableProperties(V[UHV], 6, 6)
            .buildAndRegister();

    public static final Material Duracite = new Material.Builder(EVMain.id("duracite"))
            .color(0x914f16)
            .iconSet(METALLIC)
            .blastTemp(3800, BlastProperty.GasTier.MID)
            .components(Steel, 7, Europium, 6, Osmium, 2, Iridium, 2, Germanium, 2)
            .flags(GENERATE_FRAME, GENERATE_PLATE, AUTOGEN_MIXER_RECIPE, GENERATE_SPRING)
            .buildAndRegister();

    public static final Material Infernite = new Material.Builder(EVMain.id("infernite"))
            .color(0xd92b14)
            .fluid()
            .iconSet(METALLIC)
            .flags(GENERATE_FRAME, GENERATE_PLATE, DISABLE_ELECTRIC_BLAST)
            .blastTemp(4200, BlastProperty.GasTier.HIGH)
            //.blast(b -> b.temp(4200, BlastProperty.GasTier.HIGH)
            //        .blastStats(VA[EV]))
            .components(Steel, 5, Rhodium, 1, Ruthenium, 1, Iodine, 2,  Pyrotheum, 2)
            .buildAndRegister();



//    public static final Material LithiumHydride = new Material.Builder(EVMain.id("lithium_hydride"))
//            .dust()
//            .color((Lithium.getMaterialRGB()+Hydrogen.getMaterialRGB())/2 )
//            .buildAndRegister()
//            .setFormula("LiH", true);
}

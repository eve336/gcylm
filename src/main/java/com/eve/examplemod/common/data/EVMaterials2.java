package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.DULL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EVMaterials2 {
    public static void init() {

    }
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
}

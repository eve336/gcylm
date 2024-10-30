package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.eve.examplemod.common.data.EVElements.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTElements.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;


@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class EVMaterials {

    public static void init(){}


    public static final List<MaterialFlag> EXT2_METAL = new ArrayList<>();
    public static final List<MaterialFlag> CORE_METAL = new ArrayList<>();

    static {
        EXT2_METAL.addAll(Arrays.asList(GENERATE_PLATE , GENERATE_DENSE , GENERATE_ROD , GENERATE_BOLT_SCREW , GENERATE_GEAR , GENERATE_FOIL , GENERATE_FINE_WIRE , GENERATE_LONG_ROD));
        CORE_METAL.addAll(EXT2_METAL);
        CORE_METAL.addAll(Arrays.asList(GENERATE_RING, GENERATE_FRAME, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_DENSE));
    }
    public static final Material Copernicium = new Material.Builder(EVMain.id("copernicium"))
            .ingot(4).liquid()
            .color(0xFFFEFF).iconSet(DULL)
            .element(Cn)
            .buildAndRegister();

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
            .buildAndRegister()
            .setFormula("Ad", true);


    public static final Material Vibranium = new Material.Builder(EVMain.id("vibranium")).color(0x828aad).iconSet(SHINY).ingot(7).liquid().appendFlags(CORE_METAL).blastTemp(11220).buildAndRegister();
    public static final Material Taranium = new Material.Builder(EVMain.id("taranium")).color(0x0c0c0d).iconSet(SHINY).ingot().liquid().appendFlags(CORE_METAL).blastTemp(10000).buildAndRegister();
    public static final Material MetastableOganesson = new Material.Builder(EVMain.id("metastable_oganesson")).color(0xE61C24).iconSet(SHINY).ingot().liquid().appendFlags(CORE_METAL).element(Og).blastTemp(10380).buildAndRegister();
    public static final Material MetastableFlerovium = new Material.Builder(EVMain.id("metastable_flerovium")).color(0x521973).iconSet(SHINY).ingot().liquid().appendFlags(CORE_METAL).element(Fl).blastTemp(10990).buildAndRegister();
    public static final Material MetastableHassium = new Material.Builder(EVMain.id("metastable_hassium")).color(0x2d3a9d).iconSet(SHINY).ingot(6).appendFlags(CORE_METAL).element(Hs).blastTemp(11240).buildAndRegister();
    public static final Material Zirconium = new Material.Builder(EVMain.id("zirconium")).color(0xE0E1E1).iconSet(METALLIC).ingot().liquid().appendFlags(EXT2_METAL).element(Zr).buildAndRegister();
    public static final Material Polonium = new Material.Builder(EVMain.id("polonium")).color(0xC9D47E).iconSet(DULL).ingot().liquid().element(Po).buildAndRegister();


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

    public static final Material MVSuperconductorBase = new Material.Builder(EVMain.id("mv_superconductor_base"))
            .color(0x535353)
            .iconSet(SHINY)
            .ingot(1)
            .components(Cadmium, 5, Magnesium, 1, Oxygen, 6)
            .appendFlags(STD_METAL)
            .blastTemp(1200)
            .buildAndRegister();

    public static final Material HVSuperconductorBase = new Material.Builder(EVMain.id("hv_superconductor_base"))
            .color(0x4a2400)
            .iconSet(SHINY)
            .ingot(1)
            .components(Titanium, 1, Barium, 9, Copper, 10, Oxygen, 20)
            .appendFlags(STD_METAL)
            .blastTemp(3300)
            .buildAndRegister();


    public static final Material IVSuperconductorBase = new Material.Builder(EVMain.id("iv_superconductor_base"))
            .color(0x300030)
            .iconSet(SHINY)
            .ingot(1)
            .components(Vanadium, 1, Indium, 3)
            .appendFlags(STD_METAL)
            .blastTemp(5200)
            .buildAndRegister();

    public static final Material LuVSuperconductorBase = new Material.Builder(EVMain.id("luv_superconductor_base"))
            .color(0x7a3c00)
            .iconSet(SHINY)
            .ingot(1)
            .components(Indium, 4, Bronze, 8, Barium, 2, Titanium, 1, Oxygen, 14)
            .appendFlags(STD_METAL)
            .blastTemp(6000)
            .buildAndRegister();

    public static final Material ZPMSuperconductorBase = new Material.Builder(EVMain.id("zpm_superconductor_base"))
            .color(0x111111)
            .iconSet(SHINY)
            .ingot(1)
            .components(Naquadah, 4, Indium, 2, Palladium, 6, Osmium, 1)
            .appendFlags(STD_METAL)
            .flags(DISABLE_DECOMPOSITION)
            .blastTemp(8100)
            .buildAndRegister();

    public static final Material MVSuperconductor = new Material.Builder(EVMain.id("mv_superconductor"))
            .color(0x535353)
            .iconSet(SHINY)
            .ingot(1)
            .components(MVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HVSuperconductor = new Material.Builder(EVMain.id("hv_superconductor"))
            .color(0x4a2400)
            .iconSet(SHINY)
            .ingot(1)
            .components(HVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material EVSuperconductor = new Material.Builder(EVMain.id("ev_superconductor"))
            .color(0x005800)
            .iconSet(SHINY)
            .ingot(1)
            .components(UraniumTriplatinum, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material IVSuperconductor = new Material.Builder(EVMain.id("iv_superconductor"))
            .color(0x300030)
            .iconSet(SHINY)
            .ingot(1)
            .components(IVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material LuVSuperconductor = new Material.Builder(EVMain.id("luv_superconductor"))
            .color(0x7a3c00)
            .iconSet(SHINY)
            .ingot(1)
            .components(LuVSuperconductorBase, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material ZPMSuperconductor = new Material.Builder(EVMain.id("zpm_superconductor"))
            .color(0x111111)
            .iconSet(SHINY)
            .ingot(1)
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
            .flags(GENERATE_FRAME , GENERATE_DENSE)
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

    public static final Material Fermium258 = new Material.Builder(EVMain.id("fermium_258"))
            .ingot().liquid()
            .color(0x984ACF).iconSet(METALLIC)
            .appendFlags(EXT2_METAL)
            .element(Fm258)
            .buildAndRegister()
            .setFormula("Fm-258", true);

    public static final Material Mendelevium261 = new Material.Builder(EVMain.id("mendelevium_261"))
            .ingot().liquid()
            .color(Mendelevium.getMaterialRGB()).iconSet(METALLIC)
            .appendFlags(EXT2_METAL)
            .element(Md261)
            .buildAndRegister()
            .setFormula("Md-261", true);



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
            .flags(DISABLE_DECOMPOSITION)
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
            .flags(DISABLE_DECOMPOSITION , GENERATE_DENSE)
            .buildAndRegister();

    public static final Material Incoloy813 = new Material.Builder(EVMain.id("incoloy813"))
            .color(0x37bf7e)
            .iconSet(SHINY)
            .ingot(2)
            .components(VanadiumSteel, 4, Osmiridium, 2, Technetium, 3, Germanium, 4, Iridium, 7, Duranium, 5, Uranium238, 1) // Changed Uranium to Uranium238
            .flags(GENERATE_FRAME , DISABLE_DECOMPOSITION)
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
            .components(Carbon, 20, Hydrogen, 12, Oxygen, 3)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, NO_SMASHING, GENERATE_FOIL, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Zylon = new Material.Builder(EVMain.id("zylon"))
            .color(0xFFE000)
            .iconSet(SHINY)
            .ingot(2)
            .components(Carbon, 14, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES, NO_SMASHING, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material FullerenePolymerMatrix = new Material.Builder(EVMain.id("fullerene_polymer_matrix"))
            .color(0x403e37)
            .iconSet(DULL)
            .ingot(2)
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
            .appendFlags(CORE_METAL)
            .buildAndRegister();


    public static final Material TriniumTitanium = new Material.Builder(EVMain.id("trinium_titanium"))
            .color(0x9986a3)
            .iconSet(SHINY)
            .ingot(7)
            .components(Trinium, 2, Titanium, 1)
            .flags()
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material LithiumTitanate = new Material.Builder(EVMain.id("lithium_titanate"))
            .color(0xfe71a9)
            .iconSet(SHINY)
            .ingot(5)
            .components(Lithium, 2, Titanium, 1, Oxygen, 3)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material Titanium50 = new Material.Builder(EVMain.id("titanium50"))
            .color(Titanium.getMaterialRGB())
            .iconSet(SHINY)
            .ingot(5)
            .components()
            .flags()
            .buildAndRegister();

    public static final Material ElectricallyImpureCopper = new Material.Builder(EVMain.id("electrically_impure_copper"))
            .color(0x765A30)
            .iconSet(DULL)
            .ingot(2)
            .components(Copper, 1, RareEarth, 1)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Polyurethane = new Material.Builder(EVMain.id("polyurethane"))
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

    public static final Material WoodsGlass = new Material.Builder(EVMain.id("woods_glass"))
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

    public static final Material RutheniumDioxide = new Material.Builder(EVMain.id("ruthenium_dioxide"))
            .color(RutheniumTetroxide.getMaterialRGB())
            .iconSet(DULL)
            .ingot(2)
            .components(Ruthenium, 1, Oxygen, 2)
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


    public static final Material FermionicUUMatter = new Material.Builder(EVMain.id("fermionic_uu_matter"))
            .color(UUMatter.getMaterialRGB() / 3)
            .liquid()
            .buildAndRegister();


    public static final Material BosonicUUMatter = new Material.Builder(EVMain.id("bosonic_uu_matter"))
            .color(UUMatter.getMaterialRGB() - FermionicUUMatter.getMaterialRGB())
            .liquid()
            .buildAndRegister();

}
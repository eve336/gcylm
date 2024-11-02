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

    public static final Material LithiumNiobate = new Material.Builder(EVMain.id("lithium_niobate"))
            .color(0xcfcf3a)
            .iconSet(SHINY)
            .ingot(6)
            .components(Lithium, 1, Niobium, 1, Oxygen, 4)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HeavyQuarkDegenerateMatter = new Material.Builder(EVMain.id("heavy_quark_degenerate_matter"))
            .color(0x5dbd3a)
            .iconSet(SHINY)
            .ingot(6)
            .appendFlags(CORE_METAL)
            .buildAndRegister();

    public static final Material SuperheavyHAlloy = new Material.Builder(EVMain.id("superheavy_h_alloy"))
            .color(0xE84B36)
            .iconSet(SHINY)
            .ingot(6)
            .components(Copernicium, 1, Nihonium, 1, MetastableFlerovium, 1, Moscovium, 1, Livermorium, 1, Tennessine, 1, MetastableOganesson, 1)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SuperheavyLAlloy = new Material.Builder(EVMain.id("superheavy_l_alloy"))
            .color(0x2B45DF)
            .iconSet(SHINY)
            .ingot(6)
            .components(Rutherfordium, 1, Dubnium, 1, Seaborgium, 1, Bohrium, 1, MetastableHassium, 1, Meitnerium, 1, Roentgenium, 1)
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material QCDMatter = new Material.Builder(EVMain.id("qcd_confined_matter"))
            .color(0xeb9e3f)
            .iconSet(SHINY)
            .ingot(7)
            .flags(GENERATE_PLATE, NO_WORKING, NO_SMELTING, NO_SMASHING, GENERATE_FRAME, GENERATE_ROD)
            .buildAndRegister();

    public static final Material Periodicium = new Material.Builder(EVMain.id("periodicium"))
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
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material CosmicNeutronium = new Material.Builder(EVMain.id("cosmic_neutronium"))
            .color(0x323232)
            .iconSet(SHINY)
            .ingot(7)
            .components(Neutronium, 1)
            .flags(DISABLE_DECOMPOSITION)
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


    public static final Material FishOil = new Material.Builder(EVMain.id("fish_oil"))
            .color(14467421)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RawGrowthMedium = new Material.Builder(EVMain.id("raw_growth_medium"))
            .color(10777425)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material SterileGrowthMedium = new Material.Builder(EVMain.id("sterilized_growth_medium"))
            .color(11306862)
            .iconSet(FLUID)
            .fluid()
            .components(RawGrowthMedium, 1, RareEarth, 1)
            .flags( DISABLE_DECOMPOSITION)
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
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material HighOctaneGasoline = new Material.Builder(EVMain.id("high_octane"))
            .color(0xC7860B)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1, Carbon, 8, Hydrogen, 18)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Octane = new Material.Builder(EVMain.id("octane"))
            .color(0xCBCBCB)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 8, Hydrogen, 18)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material EthylTertButylEther = new Material.Builder(EVMain.id("ethyl_tert_butyl_ether"))
            .color(0xCBCBCB)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Gasoline = new Material.Builder(EVMain.id("gasoline"))
            .color(0xC7860B)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RawGasoline = new Material.Builder(EVMain.id("raw_gasoline"))
            .color(0xC5560C)
            .iconSet(FLUID)
            .fluid()
            .components(RareEarth, 1)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material RocketFuelH8N4C2O4 = new Material.Builder(EVMain.id("rocket_fuel_a"))
            .color(0x5ECB22)
            .iconSet(FLUID)
            .fluid()
            .components(Hydrogen, 8, Nitrogen, 4, Carbon, 2, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material CoalTar = new Material.Builder(EVMain.id("coal_tar"))
            .color(0x5E3122)
            .iconSet(FLUID)
            .fluid()
            .components(Coal, 1, RareEarth, 1)
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

    public static final Material EthylBenzene = new Material.Builder(EVMain.id("ethylbenzene"))
            .color(0xD5D5D5)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 8, Hydrogen, 10)
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

    public static final Material PhthalicAcid = new Material.Builder(EVMain.id("phthalicacid"))
            .color(0xD1D1D1)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Naphthalene = new Material.Builder(EVMain.id("naphtalene"))
            .color(0xFFFFFF)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 10, Hydrogen, 8)
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

    public static final Material LiquidOxygen = new Material.Builder(EVMain.id("liquid_oxygen"))
            .color(0x81FFFD)
            .iconSet(FLUID)
            .fluid()
            .components(Oxygen, 1)
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

    public static final Material AquaRegia = new Material.Builder(EVMain.id("aqua_regia"))
            .color(0xFFB132)
            .iconSet(FLUID)
            .fluid()
            .components(NitricAcid, 1, HydrochloricAcid, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material AmmoniumChloride = new Material.Builder(EVMain.id("ammonium_chloride"))
            .color((Ammonia.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .iconSet(FLUID)
            .fluid()
            .components(Nitrogen, 1, Hydrogen, 4, Chlorine, 1)
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

    public static final Material FormicAcid = new Material.Builder(EVMain.id("formic_acid"))
            .color(0xFFAA77)
            .iconSet(FLUID)
            .fluid()
            .components(Carbon, 1, Hydrogen, 2, Oxygen, 2)
            .buildAndRegister();

    public static final Material RhodiumSulfate = new Material.Builder(EVMain.id("rhodium_sulfate"))
            .color(0xEEAA55)
            .iconSet(FLUID)
            .fluid()
            .components(Rhodium, 1, Sulfur, 1, Oxygen, 4, RareEarth, 1)
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
            .color((Osmium .getMaterialRGB() + Water .getMaterialRGB()) / 2)
            .iconSet(FLUID)
            .fluid()
            .components(Osmium, 1, Oxygen, 4, Water, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material AcidicOsmiumSolution = new Material.Builder(EVMain.id("acidic_osmium_solution"))
            .color(OsmiumSolution .getMaterialRGB() - 20)
            .iconSet(FLUID)
            .fluid()
            .components(Osmium, 1, Oxygen, 4, Water, 1, HydrochloricAcid, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material IridiumDioxide = new Material.Builder(EVMain.id("iridium_dioxide"))
            .color((Iridium .getMaterialRGB() + Oxygen .getMaterialRGB()) / 2)
            .iconSet(DULL)
            .components(Iridium, 1, Oxygen, 2)
            .flags(EXCLUDE_BLOCK_CRAFTING_RECIPES)
            .liquid()
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material AcidicIridiumSolution = new Material.Builder(EVMain.id("acidic_iridium_solution"))
            .color(IridiumDioxide .getMaterialRGB() - 20)
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

    public static final Material Nitrochlorobenzene = new Material.Builder(EVMain.id("nitrochlorobenzene"))
            .color(0x8FB51A)
            .iconSet(DULL)
            .fluid()
            .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Dichlorobenzidine = new Material.Builder(EVMain.id("dichlorobenzidine"))
            .color(0xA1DEA6)
            .iconSet(DULL)
            .fluid()
            .components(Carbon, 12, Hydrogen, 10, Chlorine, 2, Nitrogen, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Diaminobenzidine = new Material.Builder(EVMain.id("diaminobenzidine"))
            .color(0x337D59)
            .iconSet(DULL)
            .fluid()
            .components(Carbon, 12, Hydrogen, 14, Nitrogen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Diphenylisophtalate = new Material.Builder(EVMain.id("diphenylisophtalate"))
            .color(0x246E57)
            .iconSet(DULL)
            .fluid()
            .components(Carbon, 20, Hydrogen, 14, Oxygen, 4)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Chlorobenzene = new Material.Builder(EVMain.id("chlorobenzene"))
            .color(0x326A3E)
            .iconSet(DULL)
            .fluid()
            .components(Carbon, 6, Hydrogen, 5, Chlorine, 1)
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
            .flags( DISABLE_DECOMPOSITION, FLAMMABLE, HIGH_SIFTER_OUTPUT, NO_SMELTING, GENERATE_LENS, GENERATE_PLATE)
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

    public static final Material Massicot = new Material.Builder(EVMain.id("massicot"))
            .color(0x88A56D)
            .iconSet(SAND)
            .dust()
            .components(Lead, 1, Oxygen, 1)
            .buildAndRegister();

    public static final Material AntimonyTrioxide = new Material.Builder(EVMain.id("antimony_trioxide"))
            .color(0x7B8A60)
            .iconSet(SAND)
            .dust()
            .components(Antimony, 2, Oxygen, 3)
            .buildAndRegister();

    public static final Material Zincite = new Material.Builder(EVMain.id("zincite"))
            .color(0x88BDA3)
            .iconSet(SAND)
            .dust()
            .components(Zinc, 1, Oxygen, 1)
            .buildAndRegister();

    public static final Material AluminoSilicateWool = new Material.Builder(EVMain.id("alumino_silicate_wool"))
            .color(0xbbbbbb)
            .iconSet(SAND)
            .dust()
            .components(Aluminium, 2, Silicon, 1, Oxygen, 5)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Ferrosilite = new Material.Builder(EVMain.id("ferrosilite"))
            .color(0x505E46)
            .iconSet(SAND)
            .dust()
            .components(Iron, 1, Silicon, 1, Oxygen, 3)
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
            .color(Platinum .getMaterialRGB())
            .iconSet(DULL)
            .dust()
            .components(Platinum, 1, RareEarth, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumSaltRefined = new Material.Builder(EVMain.id("refined_platinum_salt"))
            .color(Platinum .getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .components(Platinum, 1, RareEarth, 1, Chlorine, 1)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumMetallicPowder = new Material.Builder(EVMain.id("platinum_metallic_powder"))
            .color(Platinum .getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .ore()
            .components(Platinum, 1, RareEarth, 1)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumResidue = new Material.Builder(EVMain.id("platinum_residue"))
            .color(0x64632E)
            .iconSet(ROUGH)
            .dust()
            .components(Iridium, 2, RareEarth, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PlatinumRawPowder = new Material.Builder(EVMain.id("reprecipitated_platinum"))
            .color(Platinum .getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .components(Platinum, 1, Chlorine, 2)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PalladiumMetallicPowder = new Material.Builder(EVMain.id("palladium_metallic_powder"))
            .color(Palladium .getMaterialRGB())
            .iconSet(METALLIC)
            .dust()
            .ore()
            .components(Palladium, 1, RareEarth, 1)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PalladiumRawPowder = new Material.Builder(EVMain.id("reprecipitated_palladium"))
            .color(Palladium .getMaterialRGB())
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

    public static final Material CalciumChloride = new Material.Builder(EVMain.id("calcium_chloride"))
            .color(0xFFFFFF)
            .iconSet(DULL)
            .dust()
            .components(Calcium, 1, Chlorine, 2)
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

    public static final Material IrMetalResidue = new Material.Builder(EVMain.id("iridium_metal_residue"))
            .color(0x846649)
            .iconSet(ROUGH)
            .dust()
            .ore()
            .components(Iridium, 2, Oxygen, 4, SiliconDioxide, 2, Gold, 3)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material PGSDResidue = new Material.Builder(EVMain.id("sludge_dust_residue"))
            .color((SiliconDioxide.getMaterialRGB() + Gold.getMaterialRGB()) / 2)
            .iconSet(DULL)
            .dust()
            .components(SiliconDioxide, 2, Gold, 3)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material IridiumChloride = new Material.Builder(EVMain.id("iridium_chloride"))
            .color((Iridium.getMaterialRGB() + Chlorine.getMaterialRGB()) / 2)
            .iconSet(LAPIS)
            .dust()
            .components(Iridium, 1, Chlorine, 3)
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

    public static final Material ChromiumTrioxide = new Material.Builder(EVMain.id("chromium_trioxide"))
            .color(0xFFE4E1)
            .iconSet(DULL)
            .dust()
            .components(Chromium, 1, Oxygen, 3)
            .buildAndRegister();

    public static final Material PotassiumDichromate = new Material.Builder(EVMain.id("potassium_dichromate"))
            .color(0xFF084E)
            .iconSet(DULL)
            .dust()
            .components(Potassium, 2, Chromium, 2, Oxygen, 7)
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

    public static final Material TungsticAcid = new Material.Builder(EVMain.id("tungstic_acid"))
            .color(0xFFE700)
            .iconSet(SHINY)
            .dust()
            .components(Hydrogen, 2, Tungsten, 1, Oxygen, 4)
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

    public static final Material Fluorite = new Material.Builder(EVMain.id("fluorite"))
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

    public static final Material Pyrochlore = new Material.Builder(EVMain.id("pyrochlore"))
            .color(0x996633)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Calcium, 12, Strontium, 6, Barium, 6, RareEarth, 1, Thorium, 1, Uranium238, 1, Niobium, 26, Oxygen, 78, Fluorine, 26)
            .flags( DISABLE_DECOMPOSITION)
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

    public static final Material IndiumPhospide = new Material.Builder(EVMain.id("indium_phosphide"))
            .color(0x5c9c9c)
            .iconSet(SHINY)
            .dust()
            .components(Indium, 1, Phosphorus, 1)
            .buildAndRegister();

    public static final Material Barytocalcite = new Material.Builder(EVMain.id("barytocalcite"))
            .color(0xbf9c7c)
            .iconSet(SHINY)
            .dust()
            .ore()
            .components(Barium, 1, Calcium, 1, Carbon, 2, Oxygen, 6)
            .flags( DISABLE_DECOMPOSITION)
            .buildAndRegister();

    public static final Material Witherite = new Material.Builder(EVMain.id("witherite"))
            .color(0xc6c29d)
            .iconSet(ROUGH)
            .dust()
            .ore()
            .components(Barium, 1, Carbon, 1, Oxygen, 3)
            .flags( DISABLE_DECOMPOSITION)
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
            .flags( DISABLE_DECOMPOSITION)
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

    public static final Material FluoroantimonicAcid = new Material.Builder(EVMain.id("fluoroantimonic_acid"))
            .fluid()
            .color(0x8da2a5)
            .buildAndRegister()
            .setFormula("H2SbF7", true);

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

    public static final Material NaquadriaSolution = new Material.Builder(EVMain.id("naquadria_solution"))
            .color(0x523b3a)
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

    public static final Material Butyraldehyde = new Material.Builder(EVMain.id("butyraldehyde"))
            .color(0xe7cf6e)
            .fluid()
            .buildAndRegister()
            .setFormula("CH3(CH2)3CH(CH2CH3)CH2OH", true);

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

    public static final Material Formaldehyde = new Material.Builder(EVMain.id("formaldehyde"))
            .color(0x95a13a)
            .fluid()
            .buildAndRegister()
            .setFormula("CH2O", true);

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

    public static final Material HydrogenCyanide = new Material.Builder(EVMain.id("hydrogen_cyanide"))
            .color(0xb6d1ae)
            .fluid()
            .buildAndRegister()
            .setFormula("HCN", true);

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
            .setFormula( Water.getChemicalFormula() + "NaNO3", true);

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

    public static final Material AceticAnhydride = new Material.Builder(EVMain.id("acetic_anhydride"))
            .color(0xD5DDDF)
            .fluid()
            .buildAndRegister()
            .setFormula("(CH3CO)2O", true);

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
}
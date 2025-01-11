package com.eve.examplemod.data.recipe.chain;

import com.eve.examplemod.api.data.material.properties.EVComponentProperty;
import com.eve.examplemod.api.data.material.properties.EVNuclearProperty;
import com.eve.examplemod.api.data.material.properties.EVPropertyKey;
import com.eve.examplemod.api.data.material.properties.EVWasteProperty;
import com.eve.examplemod.api.fluids.store.EVFluidStorageKeys;
import com.eve.examplemod.common.data.EVBlocks;
import com.eve.examplemod.common.data.EVItems;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;

import java.util.*;
import java.util.function.Consumer;

import static com.eve.examplemod.api.data.material.info.EVMaterialFlags.*;
import static com.eve.examplemod.api.data.tag.EVTagPrefix.*;
import static com.eve.examplemod.common.data.EVBlocks.QCD_CHARGE;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.NUCLEAR_REACTOR_RECIPES;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class UltimateMaterials {
    static int chainNumber = 1;
    public static void init(Consumer<FinishedRecipe> provider) {

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(270).EUt(250000)
                .inputItems(dust, Ruthenium)
                .inputItems(dust, Rhodium)
                .inputItems(dust, Palladium)
                .inputItems(dust, Silver)
                .inputItems(dust, Rhenium)
                .inputItems(dust, Osmium)
                .inputItems(dust, Iridium)
                .inputItems(dust, Platinum)
                .inputItems(dust, Gold)
                .outputItems(PreciousMetals,9)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(210).EUt(250000)
                .inputItems(dust, Zirconium)
                .inputItems(dust, Hafnium)
                .inputItems(dust, Niobium)
                .inputItems(dust, Tantalum)
                .inputItems(dust, Molybdenum)
                .inputItems(dust, Tungsten)
                .inputItems(dust, Technetium)
                .outputItems(RefractoryMetals,7)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(240).EUt(250000)
                .inputItems(dust, Titanium)
                .inputItems(dust, Vanadium)
                .inputItems(dust, Manganese)
                .inputItems(dust, Chromium)
                .inputItems(dust, Iron)
                .inputItems(dust, Nickel)
                .inputItems(dust, Cobalt)
                .inputItems(dust, Copper)
                .outputItems(LightTransitionMetals,8)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(420).EUt(250000)
                .inputItems(dust, Beryllium)
                .inputItems(dust, Magnesium)
                .inputItems(dust, Calcium)
                .inputItems(dust, Strontium)
                .inputItems(dust, Barium)
                .inputItems(dust, Radium)
                .inputItems(dust, Scandium)
                .inputItems(dust, Yttrium)
                .inputFluids(Lithium.getFluid(144))
                .inputFluids(Sodium.getFluid(144))
                .inputFluids(Potassium.getFluid(144))
                .inputFluids(Rubidium.getFluid(144))
                .inputFluids(Caesium.getFluid(144))
                .inputFluids(Francium.getFluid(144))
                .outputItems(Alkalis,14)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(420).EUt(250000)
                .inputItems(dust, Zinc)
                .inputItems(dust, Cadmium)
                .inputItems(dust, Aluminium)
                .inputItems(dust, Silicon)
                .inputItems(dust, Germanium)
                .inputItems(dust, Antimony)
                .inputItems(dust, Thallium)
                .inputItems(dust, Lead)
                .inputFluids(Mercury.getFluid(144))
                .inputFluids(Tin.getFluid(144))
                .inputFluids(Gallium.getFluid(144))
                .inputFluids(Indium.getFluid(144))
                .inputFluids(Bismuth.getFluid(144))
                .inputFluids(Polonium.getFluid(144))
                .outputItems(PostTransitionMetals,14)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(450).EUt(250000)
                .inputItems(dust, Samarium)
                .inputItems(dust, Gadolinium)
                .inputItems(dust, Terbium)
                .inputItems(dust, Thulium)
                .inputItems(dust, Holmium)
                .inputItems(dust, Lutetium)
                .inputItems(dust, Promethium)
                .inputItems(dust, Erbium)
                .inputItems(dust, Dysprosium)
                .inputFluids(Lanthanum.getFluid(144))
                .inputFluids(Cerium.getFluid(144))
                .inputFluids(Praseodymium.getFluid(144))
                .inputFluids(Neodymium.getFluid(144))
                .inputFluids(Europium.getFluid(144))
                .inputFluids(Ytterbium.getFluid(144))
                .outputItems(Lanthanoids,15)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(390).EUt(250000)
                .inputItems(dust, Actinium)
                .inputItems(dust, Thorium)
                .inputItems(dust, Protactinium)
                .inputItems(dust, GTMaterials.Uranium238)
                .inputItems(dust, Americium)
                .inputItems(dust, Curium)
                .inputItems(dust, Berkelium)
                .inputItems(dust, Fermium)
                .inputItems(dust, Californium)
                .inputFluids(Neptunium.getFluid(144))
                .inputFluids(GTMaterials.Plutonium239.getFluid(144))
                .inputFluids(Mendelevium.getFluid(144))
                .inputFluids(Einsteinium.getFluid(144))
                .outputItems(Actinoids,13)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(450).EUt(250000)
                .inputItems(dust, Boron)
                .inputItems(dust, Carbon)
                .inputItems(dust, Phosphorus)
                .inputItems(dust, Sulfur)
                .inputItems(dust, Arsenic)
                .inputItems(dust, Selenium)
                .inputItems(dust, Tellurium)
                .inputItems(dust, Iodine)
                .inputItems(dust, Astatine)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(Nitrogen.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(1000))
                .inputFluids(Fluorine.getFluid(1000))
                .inputFluids(Chlorine.getFluid(1000))
                .inputFluids(Bromine.getFluid(1000))
                .outputFluids(NonMetals.getFluid(15000))
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(180).EUt(250000)
                .inputFluids(Helium.getFluid(1000))
                .inputFluids(Neon.getFluid(1000))
                .inputFluids(Argon.getFluid(1000))
                .inputFluids(Krypton.getFluid(1000))
                .inputFluids(Xenon.getFluid(1000))
                .inputFluids(Radon.getFluid(1000))
                .outputFluids(NobleGases.getFluid(6000))
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(360).EUt(5400000)
                .inputItems(dust, SuperheavyLAlloy, 7)
                .inputItems(dust, SuperheavyHAlloy, 7)
                .inputItems(Alkalis,14)
                .inputItems(RefractoryMetals,7)
                .inputItems(LightTransitionMetals,8)
                .inputItems(PreciousMetals,9)
                .inputItems(PostTransitionMetals,14)
                .inputItems(Lanthanoids,15)
                .inputItems(Actinoids,13)
                .inputFluids(NonMetals.getFluid(15000))
                .inputFluids(NobleGases.getFluid(6000))
                .outputItems(dust, Periodicium, 115)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(20).EUt(30720)
                .inputFluids(Helium3.getFluid(5000))
                .outputFluids(LiquidHelium3.getFluid(5000))
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(20).EUt(480)
                .inputFluids(Nitrogen.getFluid(5000))
                .outputFluids(LiquidNitrogen.getFluid(5000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(60).EUt(7680)
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,1000))
                .inputFluids(LiquidHelium3.getFluid(1000))
                .outputFluids(LiquidEnrichedHelium.getFluid(2000))
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(150).EUt(725000)
                .inputFluids(LiquidEnrichedHelium.getFluid(2000))
                .inputFluids(LiquidNitrogen.getFluid(1000))
                .outputFluids(SuperfluidHelium.getFluid(1000))
                .outputFluids(LiquidHelium3.getFluid(1000))
                .outputFluids(Nitrogen.getFluid(1000))
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(150).EUt(15000000)
                .inputItems(frameGt, QCDMatter)
//                .inputItems(GAMetaBlocks.FUSION_CASING.getItemVariant(GAFusionCasing.CasingType.ADV_FUSION_COIL_3))
                .inputItems(ELECTRIC_PUMP_UXV,2)
                .inputItems(CraftingComponent.CIRCUIT.getIngredient(GTValues.UIV))
                .inputItems(pipeLargeFluid, Neutronium, 4)
                .inputItems(plate, Neutronium, 12)
                .inputFluids(ProtoAdamantium.getFluid(2592))
                .inputFluids(Taranium.getFluid(1584))
                .outputItems(EXTREMELY_DURABLE_PLASMA_CELL)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(10).EUt(125000000)
                .inputItems(block, Neutronium, 5)
                .inputItems(block, HeavyQuarkDegenerateMatter, 5)
                .inputItems(QCD_CHARGE.asItem())
                .inputFluids(HeavyLeptonMix.getFluid(6000))
                .inputFluids(Gluons.getFluid(6000))
                .inputFluids(Periodicium.getFluid(2736))
                .outputFluids(DenseNeutronPlasma.getFluid(18000))
                .save(provider);

        CANNER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(90).EUt(62500000)
                .inputItems(EXTREMELY_DURABLE_PLASMA_CELL)
                .inputFluids(DenseNeutronPlasma.getFluid(1000))
                .outputItems(DENSE_NEUTRON_PLASMA_CELL)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(10).EUt(125000000)
                .inputItems(DENSE_NEUTRON_PLASMA_CELL)
                .inputItems(QCD_CHARGE.asItem())
                .outputItems(COSMIC_NEUTRON_PLASMA_CELL)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(500).EUt(10000000)
                .inputItems(COSMIC_NEUTRON_PLASMA_CELL)
                .inputFluids(SuperfluidHelium.getFluid(48000))
                .outputFluids(Helium.getFluid(48000))
                .notConsumable(INGOT_FIELD_SHAPE)
                .outputItems(ingot, CosmicNeutronium)
                .outputItems(EXTREMELY_DURABLE_PLASMA_CELL)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(290).EUt(320000)
                .inputFluids(Cycloparaphenylene.getFluid(200))
                .inputFluids(Methane.getFluid(800))
                .inputItems(dust, Neutronium)
                .notConsumable(plate, Rhenium)
                .outputFluids(NeutroniumDopedNanotubes.getFluid(1000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(350).EUt(84500000)
                .inputItems(plate, CarbonNanotubes, 3)
                .inputItems(plate, CosmicNeutronium, 3)
                .inputItems(plate, FullerenePolymerMatrix, 3)
                .inputFluids(NeutroniumDopedNanotubes.getFluid(2000))
                .outputItems(HIGHLY_DENSE_POLYMER_PLATE)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(10).EUt(100000000)
                .inputItems(HIGHLY_DENSE_POLYMER_PLATE)
                .inputItems(QCD_CHARGE.asItem())
                .outputFluids(CosmicMeshPlasma.getFluid(1000))
                .save(provider);

        CANNER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(90).EUt(125000000)
                .inputItems(TIME_DILATION_CONTAINMENT_UNIT)
                .inputFluids(CosmicMeshPlasma.getFluid(1000))
                .outputItems(COSMIC_MESH_CONTAINMENT_UNIT)
                .save(provider);

        List<ItemEntry<Item>> fieldShapes = List.of(PLATE_FIELD_SHAPE, INGOT_FIELD_SHAPE, WIRE_FIELD_SHAPE, SPHERE_FIELD_SHAPE, ROD_FIELD_SHAPE);
        List<ItemEntry<Item>> molds = List.of(SHAPE_MOLD_PLATE, SHAPE_MOLD_INGOT, SHAPE_EXTRUDER_WIRE, SHAPE_MOLD_BALL, SHAPE_EXTRUDER_ROD);
        for (int i = 0; i < fieldShapes.size(); i++) {
            ASSEMBLER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(340).EUt(122880)
                    .inputItems(molds.get(i))
                    .inputItems(plate, Polybenzimidazole, 2)
                    .inputItems(plate, Polyetheretherketone, 2)
                    // TODO master tier circuits?
//                    .inputItems(circuit, MarkerMaterials.Tier.Master)
                    .outputItems(fieldShapes.get(i))
                    .save(provider);
        }

        PLASMA_CONDENSER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(500).EUt(10000000)
                .inputItems(COSMIC_MESH_CONTAINMENT_UNIT)
                .inputFluids(SuperfluidHelium.getFluid(24000))
                .outputFluids(Helium.getFluid(24000))
                .notConsumable(PLATE_FIELD_SHAPE)
                .outputItems(COSMIC_MESH)
                .outputItems(TIME_DILATION_CONTAINMENT_UNIT)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(500).EUt(10000000)
                .inputItems(COSMIC_MESH_CONTAINMENT_UNIT)
                .inputFluids(SuperfluidHelium.getFluid(24000))
                .inputFluids(Xenon.getFluid(500))
                .outputFluids(Helium.getFluid(24000))
                .notConsumable(WIRE_FIELD_SHAPE)
                .outputItems(COSMIC_FABRIC)
                .outputItems(TIME_DILATION_CONTAINMENT_UNIT)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(10).EUt(10000000)
                .inputItems(COSMIC_FABRIC)
                .inputItems(QCD_CHARGE.asItem())
                .outputFluids(CosmicMeshPlasma.getFluid(1000))
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("ultimate_materials_" + chainNumber++).duration(10).EUt(10000000)
                .inputItems(COSMIC_MESH)
                .inputItems(QCD_CHARGE.asItem())
                .outputFluids(CosmicMeshPlasma.getFluid(1000))
                .save(provider);
    }
}

package com.eve.examplemod.data.recipe.circuit;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVBlocks.LEPTONIC_CHARGE;
import static com.eve.examplemod.common.data.EVBlocks.QCD_CHARGE;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.L;
import static com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials.Color.Lime;
import static com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials.Color.White;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static net.minecraft.world.item.Items.ROTTEN_FLESH;

public class CircuitComponentRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {


        
        int chainNumber = 1;

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(96)
                .inputItems(wireFine, Copper, 6)
                .inputItems(plate, Silver)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_TRANSISTOR_REFINED,32)
                .save(provider);

        // Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(96)
                .inputItems(wireFine, Copper, 4)
                .inputItems(dust, Carbon)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_RESISTOR_REFINED,24)
                .save(provider);

        // Capacitor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(60).EUt(120)
                .inputItems(foil, Rubber, 4)
                .inputItems(foil, Steel)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_CAPACITOR_REFINED,16)
                .save(provider);

        // Diode
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(600).EUt(30)
                .inputItems(wireFine, Gold, 8)
                .inputItems(dust, Lithium)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_DIODE_REFINED,32)
                .save(provider);





        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(600).EUt(30)
                .inputItems(wireFine, Platinum, 8)
                .inputItems(dust, GalliumArsenide)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_DIODE_MICRO,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(600).EUt(120)
                .inputItems(foil, Aluminium)
                .inputItems(foil, SiliconeRubber, 4)
                .inputFluids(Polyethylene.getFluid(36))
                .outputItems(SMD_CAPACITOR_MICRO,16)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(50).EUt(120)
                .inputItems(foil, Aluminium)
                .inputItems(foil, PolyvinylChloride, 4)
                .inputFluids(Polyethylene.getFluid(36))
                .outputItems(SMD_CAPACITOR_MICRO,16)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(96)
                .inputItems(wireFine, Electrum, 8)
                .inputItems(dust, Carbon)
                .circuitMeta(1)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_RESISTOR_MICRO,24)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(96)
                .inputItems(plate, Gallium)
                .inputItems(wireFine, AnnealedCopper, 6)
                .inputFluids(Polyethylene.getFluid(L * 2))
                .outputItems(SMD_TRANSISTOR_MICRO,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(494)
                .inputItems(wireFine, Palladium, 12)
                .inputItems(plate, Magnalium)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_TRANSISTOR_NANO,32)
                .save(provider);

        // Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(494)
                .inputItems(wireFine, Cerium, 8)
                .inputItems(dust, Graphite)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_RESISTOR_NANO,24)
                .save(provider);

        // Capacitor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(60).EUt(480)
                .inputItems(foil, Silicon, 4)
                .inputItems(foil, Titanium)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_CAPACITOR_NANO,16)
                .save(provider);

        // Diode
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(600).EUt(120)
                .inputItems(wireFine, ReinforcedEpoxyResin, 8)
                .inputItems(dust, Caesium)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_DIODE_NANO,32)
                .save(provider);





        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(1976)
                .inputItems(wireFine, GTMaterials.Plutonium239, 12)
                .inputItems(plate, Americium)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_TRANSISTOR_QUANTUM,32)
                .save(provider);

        // Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(1976)
                .inputItems(wireFine, Ruthenium, 8).inputItems(plate, Graphene)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_RESISTOR_QUANTUM,24)
                .save(provider);

        // Capacitor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(60).EUt(1920)
                .inputItems(foil, SiliconeRubber, 4)
                .inputItems(foil, Tungsten)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_CAPACITOR_QUANTUM,16)
                .save(provider);

        // Diode
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(600).EUt(480)
                .inputItems(wireFine, HSSG, 8)
                .inputItems(dust, Polonium)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_DIODE_QUANTUM,32)
                .save(provider);



        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(7904)
                .inputItems(wireFine, Rutherfordium, 12)
                .inputItems(plate, NetherStar)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_TRANSISTOR_CRYSTAL,32)
                .save(provider);

        // SMD Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(7904)
                .inputItems(wireFine, NaquadahAlloy, 8)
                .inputItems(plate, Graphene)
                .inputItems(SiliconCarbide)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_RESISTOR_CRYSTAL,24)
                .save(provider);

        // SMD Capacitor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(60).EUt(7680)
                .inputItems(foil, Polybenzimidazole, 4)
                .inputItems(foil, NaquadahAlloy)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_CAPACITOR_CRYSTAL,16)
                .save(provider);

        // SMD Diode
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(600).EUt(1920)
                .inputItems(wireFine, HSSS, 8)
                .inputItems(GermaniumSulfide)
                .inputFluids(Polyethylene.getFluid(L))
                .outputItems(SMD_DIODE_CRYSTAL,32)
                .save(provider);

        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .duration(12000).EUt(480)
                .inputItems(gemExquisite, Olivine)
                .inputFluids(Rutherfordium.getFluid(L / 2))
                .chancedOutput(RAW_CRYSTAL_CHIP.asStack(), "1/2", 1000)
                .save(provider);
        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .duration(12000).EUt(480)
                .inputItems(gemExquisite, Emerald)
                .inputFluids(Rutherfordium.getFluid(L / 2))
                .chancedOutput(RAW_CRYSTAL_CHIP.asStack(), "1/2", 1000)
                .save(provider);
        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .duration(12000).EUt(480)
                .inputItems(gemFlawless, Olivine)
                .inputFluids(Rutherfordium.getFluid(L / 2))
                .chancedOutput(RAW_CRYSTAL_CHIP.asStack(), "1/4", 750)
                .save(provider);
        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .duration(12000).EUt(480)
                .inputItems(gemFlawless, Emerald)
                .inputFluids(Rutherfordium.getFluid(L / 2))
                .chancedOutput(RAW_CRYSTAL_CHIP.asStack(), "1/4", 750)
                .save(provider);

        // Engraved Crystal CPU

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .duration(450).EUt(480).blastFurnaceTemp(5000)
                .inputItems(RAW_CRYSTAL_CHIP).inputItems(plate, Emerald)
                .inputFluids(Rutherfordium.getFluid(L / 2))
                .outputItems(ENGRAVED_CRYSTAL_CHIP).save(provider);
        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .duration(450).EUt(480).blastFurnaceTemp(5000)
                .inputItems(RAW_CRYSTAL_CHIP).inputItems(plate, Olivine)
                .inputFluids(Rutherfordium.getFluid(L / 2))
                .outputItems(ENGRAVED_CRYSTAL_CHIP).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputItems(foil, VanadiumGallium, 24)
                .inputItems(KAPTON_BOARD)
                .inputFluids(SodiumPersulfate.getFluid(6000))
                .outputItems(KAPTON_CIRCUIT_BOARD)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputItems(foil, VanadiumGallium, 24)
                .inputItems(KAPTON_BOARD)
                .inputFluids(Iron3Chloride.getFluid(3000))
                .outputItems(KAPTON_CIRCUIT_BOARD)
                .save(provider);

      // polyamic acid and stuff

        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputFluids(OrthoXylene.getFluid(1000))
                .inputFluids(Chloromethane.getFluid(2000))
                .outputItems(dust, Durene,24)
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .EUt(30)
                .duration(100)
                .save(provider);

        // C6H2(CH3)4 + 12O -> C6H2(C2O3)2 + 6H2O
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputItems(dust, Durene,24)
                .inputFluids(Oxygen.getFluid(12000))
                .outputItems(dust, PyromelliticDianhydride,18)
                .outputFluids(Water.getFluid(6000))
                .EUt(120)
                .duration(150)
                .save(provider);

        // 2C6H5NH2 + C2H5OH -> C12H12N2O + 2CH4
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .notConsumable(dust, Tin)
                .notConsumableFluid(HydrochloricAcid.getFluid(1))
                .inputFluids(Aniline.getFluid(2000))
                .inputFluids(Phenol.getFluid(1000))
                .outputFluids(Oxydianiline.getFluid(1000))
                .outputFluids(Methane.getFluid(2000))
                .EUt(120)
                .duration(150)
                .save(provider);

        // C6H2(C2O3)2 + C12H12N2O -> C22H14N2O7
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputItems(dust, PyromelliticDianhydride,18)
                .inputFluids(Oxydianiline.getFluid(1000))
                .outputFluids(PolyamicAcid.getFluid(1000))
                .EUt(7680)
                .duration(400)
                .save(provider);

        // Lose water
        // This should not gain water output ever, due to
        // the 1B -> 144mb recipe change with the above recipe.
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputFluids(PolyamicAcid.getFluid(144))
                .outputFluids(Polyimide.getFluid(144))
                .EUt(30)
                .duration(270)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(300).EUt(240)
                .inputItems(plate, Polyimide)
                .inputFluids(FluorinatedEthylenePropylene.getFluid(L / 2))
                .outputItems(KAPTON_BOARD)
                .save(provider);

        // no more polyimide


        // 3C2F4 -> 2C3F6
        PYROLYSE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .circuitMeta(1)
                .notConsumable(rod, Steel)
                .inputFluids(Tetrafluoroethylene.getFluid(3000))
                .outputFluids(Hexafluoropropylene.getFluid(2000))
                .EUt(96)
                .duration(460)
                .save(provider);

        // C2F4 + C3F6 -> C5F10
        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputFluids(Tetrafluoroethylene.getFluid(1000))
                .inputFluids(Hexafluoropropylene.getFluid(1000))
                .outputFluids(FluorinatedEthylenePropylene.getFluid(1000))
                .EUt(1920)
                .duration(125)
                .save(provider);



        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(30720)
                .inputItems(wireFine, NaquadahAlloy, 8)
                .inputFluids(Polytetrafluoroethylene.getFluid(L))
                .inputItems(foil, NaquadahEnriched, 4)
                .inputItems(foil, Polybenzimidazole, 4)
                .outputItems(SMD_CAPACITOR_WETWARE,32)
                .save(provider);

        // SMD Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(30720)
                .inputItems(wireFine, NaquadahAlloy, 8)
                .inputFluids(Polytetrafluoroethylene.getFluid(L))
                .inputItems(plate, Naquadria)
                .inputItems(plate, RutheniumDioxide)
                .outputItems(SMD_RESISTOR_WETWARE,32)
                .save(provider);

        // SMD Transistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(30720)
                .inputItems(wireFine, NaquadahAlloy, 8)
                .inputFluids(Polytetrafluoroethylene.getFluid(L))
                .inputItems(plate, NaquadahEnriched)
                .outputItems(SMD_TRANSISTOR_WETWARE,32)
                .save(provider);

        // SMD Diode
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(30720)
                .inputItems(wireFine, NaquadahAlloy, 8)
                .inputFluids(Polytetrafluoroethylene.getFluid(L))
                .inputItems(dust, Naquadria)
                .inputItems(LanthanumCalciumManganate)
                .outputItems(SMD_DIODE_WETWARE,32)
                .save(provider);





        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(30720 * 4)
                .inputItems(wireFine, Dubnium, 8)
                .inputItems(plate, GermaniumTungstenNitride, 4)
                .inputFluids(Polyimide.getFluid(L * 2))
                .outputItems(SMD_TRANSISTOR_BIOWARE,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(30720 * 4)
                .inputItems(wireFine, PEDOT, 8)
                .inputItems(foil, Polytetrafluoroethylene, 4)
                .inputItems(foil, BariumTitanate, 4)
                .inputFluids(Polyimide.getFluid(L * 2))
                .outputItems(SMD_CAPACITOR_BIOWARE,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(30720 * 4)
                .inputItems(wireFine, Osmiridium, 8)
                .inputItems(AluminiumComplex)
                .inputItems(CopperGalliumIndiumSelenide)
                .inputFluids(Polyimide.getFluid(L * 2))
                .outputItems(SMD_DIODE_BIOWARE,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(30720 * 4)
                .inputItems(wireFine, NaquadahAlloy, 6)
                .inputItems(plate, BismuthRuthenate)
                .inputItems(plate, BismuthIridiate)
                .inputFluids(Polyimide.getFluid(L * 2))
                .outputItems(SMD_RESISTOR_BIOWARE,24)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputItems(foil, SiliconeRubber, 32)
                .inputItems(wireFine, NaquadahAlloy, 16)
                .inputItems(SMD_TRANSISTOR_BIOWARE,2)
                .inputItems(SMD_RESISTOR_BIOWARE,2)
                .inputItems(SMD_DIODE_BIOWARE,2)
                .inputItems(SMD_CAPACITOR_BIOWARE,2)
                .inputItems(CYBER_PROCESSING_UNIT)
                .inputItems(STEM_CELLS,4)
                .inputFluids(Tritanium.getFluid(144))
                .outputItems(NEURO_PROCESSOR,4)
                .EUt(30720 * 16)
                .duration(150)
                .save(provider);



        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(1200000)
                .inputItems(wireFine, Pikyonium, 8)
                .inputItems(plate, LithiumNiobate, 4)
                .inputItems(plate, Polyetheretherketone, 4)
                .inputFluids(Polybenzimidazole.getFluid(L * 4))
                .outputItems(SMD_DIODE_OPTICAL,32)
                .save(provider);

        // SMD Transistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(1200000)
                .inputItems(wireFine, Pikyonium, 8)
                .inputItems(plate, LeadZirconateTitanate, 4)
                .inputItems(plate, LithiumTitanate, 4)
                .inputFluids(Polybenzimidazole.getFluid(L * 4))
                .outputItems(SMD_TRANSISTOR_OPTICAL,32)
                .save(provider);

        // SMD Capacitor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(1200000)
                .inputItems(wireFine, Pikyonium, 8)
                .inputItems(foil, CarbonNanotubes, 4)
                .inputItems(foil, Polyetheretherketone, 4)
                .inputFluids(Polybenzimidazole.getFluid(L * 4))
                .outputItems(SMD_CAPACITOR_OPTICAL,32)
                .save(provider);

        // SMD Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(1200000)
                .inputItems(wireFine, Pikyonium, 8)
                .inputItems(SodiumSeaborgate,5)
                .inputItems(TBCCODust,4)
                .inputFluids(Polybenzimidazole.getFluid(L * 4))
                .outputItems(SMD_RESISTOR_OPTICAL,32)
                .save(provider);


        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(foil, Cinobite)
                .inputItems(foil, Quantum)
                .outputItems(SMD_CAPACITOR_EXOTIC,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(wireFine, Cinobite)
                .inputItems(foil, TriniumTitanium)
                .outputItems(SMD_RESISTOR_EXOTIC,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(plate, Vibranium)
                .inputItems(plate, Quantum)
                .outputItems(SMD_DIODE_EXOTIC,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(DEGENERATE_RHENIUM_PLATE)
                .inputItems(foil, TriniumTitanium)
                .outputItems(SMD_TRANSISTOR_EXOTIC,32)
                .save(provider);


        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(6000000)
                .inputItems(wireFine, Cinobite, 8)
                .inputItems(plate, SuperheavyHAlloy, 4)
                .inputItems(plate, Vibranium, 4)
                .inputFluids(FullerenePolymerMatrix.getFluid(L))
                .outputItems(SMD_DIODE_COSMIC,32)
                .save(provider);

        // SMD Transistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(6000000)
                .inputItems(wireFine, Cinobite, 8)
                .inputItems(plate, MetastableHassium)
                .inputItems(DEGENERATE_RHENIUM_PLATE,4)
                .inputFluids(Zylon.getFluid(L))
                .outputItems(SMD_TRANSISTOR_COSMIC,32)
                .save(provider);

        // SMD Capacitor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(6000000)
                .inputItems(wireFine, Cinobite, 8)
                .inputItems(foil, Quantum, 4)
                .inputItems(foil, FullerenePolymerMatrix, 4)
                .inputFluids(Zylon.getFluid(L))
                .outputItems(SMD_CAPACITOR_COSMIC,32)
                .save(provider);

        // SMD Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(250).EUt(6000000)
                .inputItems(wireFine, Cinobite, 8)
                .inputItems(plate, SuperheavyLAlloy, 4)
                .inputItems(plate, TriniumTitanium, 4)
                .inputFluids(FullerenePolymerMatrix.getFluid(L))
                .outputItems(SMD_RESISTOR_COSMIC,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(400).EUt(134217728)
                .inputFluids(FullerenePolymerMatrix.getFluid(L))
                .inputItems(plate, ProtoAdamantium)
                .inputItems(MICA_INSULATOR_FOIL,8)
                .notConsumable(MICROWORMHOLE_GENERATOR)
                .outputItems(SMD_CAPACITOR_SUPRACAUSAL,32)
                .save(provider);

        // SMD Diode
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(400).EUt(134217728)
                .inputFluids(FullerenePolymerMatrix.getFluid(L))
                .inputItems(plate, Vibranium)
                .inputItems(Tetracene)
                .notConsumable(MICROWORMHOLE_GENERATOR)
                .outputItems(SMD_DIODE_SUPRACAUSAL,32)
                .save(provider);

        // SMD Transistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(400).EUt(134217728)
                .inputFluids(FullerenePolymerMatrix.getFluid(L))
                .inputItems(plate, Neutronium)
                .inputItems(Tetracene)
                .notConsumable(MICROWORMHOLE_GENERATOR)
                .outputItems(SMD_TRANSISTOR_SUPRACAUSAL,32)
                .save(provider);

        // SMD Resistor
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(400).EUt(134217728)
                .inputFluids(FullerenePolymerMatrix.getFluid(L))
                .inputItems(foil, TitanSteel)
                .inputItems(ChargedCesiumCeriumCobaltIndium)
                .notConsumable(MICROWORMHOLE_GENERATOR)
                .outputItems(SMD_RESISTOR_SUPRACAUSAL,32)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(800).EUt(33550000)
                .inputItems(NUCLEAR_CLOCK)
                .inputItems(TOPOLOGICAL_MANIPULATOR_UNIT,1)
                .inputItems(RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM,1)
                .inputItems(GRAVITON_TRANSDUCER,1)
                .inputItems(QCD_PROTECTIVE_PLATING,3)
                .inputItems(plate, Neutronium)
                .inputItems(wireGtSingle, UMVSuperconductor, 2)
                .inputItems(SMD_CAPACITOR_SUPRACAUSAL,16)
                .inputItems(SMD_DIODE_SUPRACAUSAL,16)
                .inputItems(SMD_TRANSISTOR_SUPRACAUSAL,16)
                .inputItems(SMD_RESISTOR_SUPRACAUSAL,16)
                .inputFluids(FullerenePolymerMatrix.getFluid(L * 9))
                .outputItems(SUPRACAUSAL_PROCESSING_CORE,8)
                .save(provider);

        // Topological Manipulator Unit
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(300).EUt(33550000)
                .inputItems(CONTAINED_KERR_NEWMANN_SINGULARITY)
                .inputItems(MICROWORMHOLE_GENERATOR)
                .inputItems(FIELD_GENERATOR_UHV)
                .inputItems(QCD_PROTECTIVE_PLATING,2)
                .inputFluids(Neutronium.getFluid(L))
                .outputItems(TOPOLOGICAL_MANIPULATOR_UNIT)
                .save(provider);

        // Graviton Transducer
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(200).EUt(33550000)
                .inputItems(CONTAINED_REISSNER_NORDSTROM_SINGULARITY)
                .inputItems(MICROWORMHOLE_GENERATOR)
                .inputItems(SENSOR_UIV)
                .inputItems(QCD_PROTECTIVE_PLATING,2)
                .inputFluids(Neutronium.getFluid(L))
                .outputItems(GRAVITON_TRANSDUCER)
                .save(provider);

        // Relativistic Spinorial Memory System
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(200).EUt(33550000)
                .inputItems(FIELD_GENERATOR_UHV)
                .inputItems(SENSOR_UIV)
                .inputItems(NEUTRON_REFLECTOR,2)
                .inputItems(BATTERY_MEDIUM_LIS)
                .inputItems(wireGtSingle, UMVSuperconductor, 2)
//                .inputItems(FUSION_CASING.getItemVariant(ADV_FUSION_COIL_1))
                .inputFluids(Neutronium.getFluid(L * 9))
                .outputItems(RELATIVISTIC_SPINORIAL_MEMORY_SYSTEM)
                .save(provider);

        // CTC Guidance Unit
        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(400).EUt(134217728)
                .inputItems(SUPRACAUSAL_PROCESSING_CORE)
                .inputItems(TOOL_DATA_ORB)
                .inputItems(NUCLEAR_CLOCK)
                .inputItems(BATTERY_LARGE_LIS)
                .inputItems(ARAM,16)
                .inputFluids(TriniumTitanium.getFluid(L * 9))
                .inputFluids(Vibranium.getFluid(L * 9))
                .outputItems(CTC_GUIDANCE_UNIT)
                .save(provider);

        // Nuclear Clock
        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(33550000)
                .inputItems(SENSOR_UIV,2)
                .inputItems(SCINTILLATOR)
                .inputItems(ULTRASHORT_PULSE_LASER,2)
                .inputItems(BOSE_EINSTEIN_COOLING_CONTAINER)
                .inputFluids(Thorium.getFluid(L))
                .inputFluids(BlackTitanium.getFluid(L * 9))
                .outputItems(NUCLEAR_CLOCK)
                .save(provider);

        // Manifold Oscillatory Power Cell
        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(180).EUt(33550000)
                .inputItems(wireGtSingle, Pikyonium, 32)
                .inputItems(DEGENERATE_RHENIUM_PLATE,2)
                .inputItems(wireFine, Quantum, 8)
                .inputItems(rod, NeodymiumMagnetic, 32)
                .inputItems(plate, Vibranium, 16)
                .inputFluids(Taranium.getFluid(L / 2))
                .inputFluids(Naquadria.getFluid(L))
                .inputFluids(Trinium.getFluid(L * 2))
                .outputItems(MANIFOLD_OSCILLATORY_POWER_CELL)
                .save(provider);

        // QCD Charge
        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(200).EUt(33550000)
                .inputItems(plate, ProtoAdamantium, 3)
                .inputItems(TIME_DILATION_CONTAINMENT_UNIT)
                .inputItems(LEPTONIC_CHARGE.asItem())
                .inputItems(plate, HeavyQuarkDegenerateMatter, 2)
                .inputItems(plate, SuperheavyHAlloy)
                .inputItems(plate, SuperheavyLAlloy)
                .inputItems(plate, Taranium, 2)
                .inputFluids(Gluons.getFluid(L * 9))
                .outputItems(QCD_CHARGE.asItem())
                .save(provider);

        // CTC Computational Unit Container
        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(1000).EUt(33550000)
                .inputItems(CTC_GUIDANCE_UNIT)
                .inputItems(MANIFOLD_OSCILLATORY_POWER_CELL)
                .inputItems(plate, EnrichedNaquadahAlloy, 36)
                .inputItems(plate, FullerenePolymerMatrix, 36)
                .inputItems(FIELD_GENERATOR_UHV,3)
                .inputItems(plateDense, Neutronium)
                .inputItems(plate, Taranium, 2)
                .inputItems(frameGt, Neutronium)
                .inputItems(plate, HeavyQuarkDegenerateMatter, 6)
                .inputItems(TIME_DILATION_CONTAINMENT_UNIT)
                .inputItems(STABILIZED_WORMHOLE_GENERATOR)
                .inputFluids(SuperheavyHAlloy.getFluid(L * 9))
                .inputFluids(SuperheavyLAlloy.getFluid(L * 9))
                .inputFluids(TriniumTitanium.getFluid(L * 9))
                .inputFluids(ProtoAdamantium.getFluid(L * 9))
                .outputItems(CTC_COMPUTATIONAL_UNIT_CONTAINER)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(134217728)
                .inputItems(ingot, HeavyQuarkDegenerateMatter)
                .inputItems(QCD_CHARGE.asItem())
                .outputFluids(HighEnergyQGP.getFluid(L))
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(400).EUt(134217728)
                .inputItems(QCD_PROTECTIVE_PLATING,4)
                .inputItems(QCD_CHARGE.asItem())
                .outputFluids(QCDMatter.getFluid(L * 9))
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(134217728)
                .inputItems(QCD_CHARGE.asItem())
                .inputItems(MACROWORMHOLE_GENERATOR,2)
                .outputItems(RECURSIVELY_FOLDED_NEGATIVE_SPACE)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(134217728)
                .inputItems(STABILIZED_WORMHOLE_GENERATOR)
                .inputItems(RECURSIVELY_FOLDED_NEGATIVE_SPACE)
                .inputItems(QCD_CHARGE.asItem())
                .outputItems(EIGENFOLDED_KERR_MANIFOLD)
                .save(provider);

        STELLAR_FORGE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(800).EUt(134217728)
                .inputItems(EIGENFOLDED_KERR_MANIFOLD)
                .inputItems(CTC_COMPUTATIONAL_UNIT_CONTAINER)
                .inputItems(QCD_CHARGE.asItem())
                .outputItems(CTC_COMPUTATIONAL_UNIT)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(134217728)
                .inputFluids(HighEnergyQGP.getFluid(L))
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,10000))
                .outputFluids(Helium.getFluid(10000))
                .notConsumable(PLATE_FIELD_SHAPE)
                .outputItems(QCD_PROTECTIVE_PLATING)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(40).EUt(134217728)
                .inputFluids(QCDMatter.getFluid(L))
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,20000))
                .outputFluids(Helium.getFluid(20000))
                .notConsumable(PLATE_FIELD_SHAPE)
                .outputItems(plate, QCDMatter)
                .save(provider);

        PLASMA_CONDENSER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(20).EUt(134217728)
                .inputFluids(QCDMatter.getFluid(L / 2))
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID,10000))
                .outputFluids(Helium.getFluid(10000))
                .notConsumable(ROD_FIELD_SHAPE)
                .outputItems(rod, QCDMatter)
                .save(provider);


        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(320).EUt(11796480)
                .inputItems(COSMIC_PROCESSING_UNIT_CORE)
                .inputItems(SMD_DIODE_COSMIC,2)
                .inputItems(SMD_RESISTOR_COSMIC,2)
                .inputItems(SMD_TRANSISTOR_COSMIC,2)
                .inputItems(SMD_CAPACITOR_COSMIC,2)
                .inputItems(foil, FullerenePolymerMatrix, 2)
                .inputItems(ULTRASHORT_PULSE_LASER)
                .inputItems(wireGtSingle, Cinobite, 8)
                .inputItems(CLADDED_OPTICAL_FIBER_CORE,8)
                .inputItems(BOSE_EINSTEIN_COOLING_CONTAINER,4)
                .inputItems(plate,BlackTitanium,4)
                .inputFluids(Zylon.getFluid(L * 6))
                .inputFluids(Quantum.getFluid(L * 3))
                .inputFluids(SolderingAlloy.getFluid(L * 9))
                .inputFluids(ProtoAdamantium.getFluid(L * 3))
                .outputItems(COSMIC_PROCESSING_CORE,8)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(695000)
                .inputItems(COATED_HASSIUM_WAFER)
                .inputFluids(PhotopolymerSolution.getFluid(500))
                .outputItems(PHOTOCOATED_HASSIUM_WAFER)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(320).EUt(840000)
                .inputItems(lens, White)
                .inputItems(CLADDED_OPTICAL_FIBER_CORE,8)
                .outputItems(GRATING_LITHOGRAPHY_MASK)
                .save(provider);

        LASER_ENGRAVER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(320).EUt(3200000)
                .inputItems(PHOTOCOATED_HASSIUM_WAFER)
                .notConsumable(GRATING_LITHOGRAPHY_MASK)
                .outputItems(DIFFRACTOR_GRATING_MIRROR)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(270).EUt(4500000)
                .inputItems(HIGH_FREQUENCY_LASER)
                .inputItems(DIFFRACTOR_GRATING_MIRROR,4)
                .inputItems(NDYAG_ROD)
                .inputItems(LUTMYVO_ROD)
                .inputItems(ALUMINO_SILICATE_GLASS_TUBE)
                .inputItems(CLADDED_OPTICAL_FIBER_CORE,2)
                .inputFluids(SolderingAlloy.getFluid(L * 2))
                .outputItems(ULTRASHORT_PULSE_LASER)
                .save(provider);

        FORMING_PRESS_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(280).EUt(1500000)
                .inputItems(plate, Vibranium, 2)
                .inputItems(TlTmCesiumIodide)
                .inputItems(PolycyclicAromaticMix)
                .inputItems(CadmiumTungstate)
                .inputItems(BismuthGermanate)
                .outputItems(SCINTILLATOR_CRYSTAL)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(340).EUt(3450000).blastFurnaceTemp(10900)
                .inputItems(dust, MetastableHassium)
                .inputItems(dust, Molybdenum)
                .inputItems(dust, Rhenium)
                .inputFluids(NaquadahAlloy.getFluid(L))
                .outputItems(LEPTON_TRAP_CRYSTAL)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(380).EUt(3500000)
                .inputItems(SCINTILLATOR_CRYSTAL)
                .inputItems(screw, HDCS, 12)
                .inputItems(plate, Cinobite, 4)
                .inputItems(plate, Quantum, 4)
                .inputItems(SEPARATION_ELECTROMAGNET)
                .inputItems(foil, Zylon, 6)
                .inputItems(wireFine, Cinobite, 12)
                .inputFluids(TriniumTitanium.getFluid(L * 3))
                .inputFluids(SolderingAlloy.getFluid(L * 2))
                .outputItems(SCINTILLATOR)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(350).EUt(7500000)
                .inputItems(DEGENERATE_RHENIUM_PLATE,3)
                .inputItems(wireFine, HeavyQuarkDegenerateMatter, 6)
                .inputItems(plate, HeavyQuarkDegenerateMatter, 2)
                .inputFluids(CosmicComputingMix.getFluid(1000))
                .outputItems(COSMIC_PROCESSING_UNIT_CORE)
                .save(provider);


        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(foil, Cinobite)
                .inputItems(foil, Quantum)
                .outputItems(SMD_CAPACITOR_EXOTIC,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(wireFine, Cinobite)
                .inputItems(foil, TriniumTitanium)
                .outputItems(SMD_RESISTOR_EXOTIC,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(plate, Vibranium)
                .inputItems(plate, Quantum)
                .outputItems(SMD_DIODE_EXOTIC,32)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt((int)1E+6).inputFluids(Polyetheretherketone.getFluid(144 * 4))
                .inputItems(DEGENERATE_RHENIUM_PLATE)
                .inputItems(foil, TriniumTitanium)
                .outputItems(SMD_TRANSISTOR_EXOTIC,32)
                .save(provider);

        LASER_ENGRAVER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(800000)
//                .inputItems(WAFER_RUTHERFORDIUM)
                .notConsumable(lens, Diamond)
                .outputItems(UNTREATED_EXOTIC_WAFER)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(2000)
                .inputItems(UNTREATED_EXOTIC_WAFER)
                .inputFluids(MicrocrystallizingHydrogen.getFluid(100))
                .outputItems(EXOTIC_WAFER)
                .save(provider);

        CUTTER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(200000)
                .inputItems(EXOTIC_WAFER)
                .outputItems(EXOTIC_CHIP,16)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(2000)
                .inputItems(HIGH_FREQUENCY_LASER)
                .inputItems(plate, MetastableHassium)
                .inputItems(HIGHLY_REFLECTIVE_MIRROR)
                .inputFluids(Zylon.getFluid(72))
                .outputItems(EXCITATION_MAINTAINER)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(8000)
                .inputItems(plate, Graphene)
                .inputItems(AEROGRAPHENE,5)
                .inputItems(wireFine, TriniumTitanium)
                .inputFluids(Zylon.getFluid(72))
                .outputItems(CRYOGENIC_INTERFACE)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(4000000)
                .inputItems(CRYOGENIC_INTERFACE)
                .inputItems(EXCITATION_MAINTAINER)
                .inputItems(EXOTIC_CHIP)
                .inputItems(X_RAY_WAVEGUIDE)
                .inputFluids(QuantumDots.getFluid(10))
                .inputFluids(Zylon.getFluid(144))
                .inputFluids(LiquidHydrogen.getFluid(10))
                .notConsumableFluid(Xenon.getFluid(1000))
                .notConsumable(ELECTRON_SOURCE)
                .outputItems(RYDBERG_SPINORIAL_ASSEMBLY)
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(4000000)
                .inputItems(NON_LINEAR_OPTICAL_LENS)
                .inputItems(DEGENERATE_RHENIUM_PLATE)
                .inputItems(foil, TriniumTitanium)
                .inputItems(RYDBERG_SPINORIAL_ASSEMBLY)
                .inputItems(X_RAY_LASER)
                .inputFluids(QuantumDots.getFluid(10))
                .outputItems(EXOTIC_PROCESSING_CORE,6)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(5000)
                .inputItems(X_RAY_WAVEGUIDE)
                .inputItems(MICROFOCUS_X_RAY_TUBE)
                .inputItems(X_RAY_MIRROR_PLATE)
                .inputFluids(CaliforniumCyclopentadienide.getFluid(10))
                .outputItems(X_RAY_LASER)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(1800).EUt(120) //2H + 2IrO2 -> Ir2O3 + H2O
                .inputFluids(Hydrogen.getFluid(2000))
                .inputItems(dust, IridiumDioxide, 6)
                .outputItems(IridiumTrioxide,5)
                .outputFluids(Water.getFluid(1000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(2000)
                .inputFluids(HydrochloricAcid.getFluid(6000))
                .inputItems(IridiumTrioxide,5)
                .outputFluids(IridiumTrichlorideSolution.getFluid(6000))
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(100)
                .inputFluids(FullerenePolymerMatrix.getFluid(18))
                .notConsumable(wireFine, Polyetheretherketone)
                .outputItems(FULLERENE_POLYMER_MATRIX_SOFT_TUBING)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(500)
                .inputItems(FULLERENE_POLYMER_MATRIX_SOFT_TUBING)
                .outputItems(FULLERENE_POLYMER_MATRIX_FINE_TUBING)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(800000)
                .inputItems(FULLERENE_POLYMER_MATRIX_FINE_TUBING)
                .inputFluids(IridiumTrichlorideSolution.getFluid(100))
                .outputItems(X_RAY_WAVEGUIDE)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(200000)
                .inputFluids(IridiumTrichlorideSolution.getFluid(100))
                .inputItems(plate, Graphene)
                .outputItems(X_RAY_MIRROR_PLATE)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(500)
                .inputFluids(LiquidHydrogen.getFluid(1000))
                .outputFluids(SemisolidHydrogen.getFluid(1000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(80).EUt(500)
                .inputFluids(LiquidHydrogen.getFluid(1000))
                .inputFluids(SemisolidHydrogen.getFluid(1000))
                .outputFluids(MicrocrystallizingHydrogen.getFluid(1000))
                .save(provider);


        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(320).EUt(1474560)
                .inputItems(OPTICAL_SOC)
                .inputItems(SMD_DIODE_OPTICAL,2)
                .inputItems(SMD_RESISTOR_OPTICAL,2)
                .inputItems(SMD_TRANSISTOR_OPTICAL,2)
                .inputItems(SMD_CAPACITOR_OPTICAL,2)
                .inputItems(foil, Polyetheretherketone, 2)
                .inputItems(LOW_FREQUENCY_LASER)
                .inputItems(MEDIUM_FREQUENCY_LASER)
                .inputItems(HIGH_FREQUENCY_LASER)
                .inputItems(NON_LINEAR_OPTICAL_LENS,2)
                .inputItems(CLADDED_OPTICAL_FIBER_CORE,2)
                .inputItems(BOSE_EINSTEIN_COOLING_CONTAINER)
                .inputItems(plate,Graphene,4)
                .inputFluids(Polytetrafluoroethylene.getFluid(L * 6))
                .inputFluids(EnrichedNaquadahAlloy.getFluid(L * 3))
                .inputFluids(SolderingAlloy.getFluid(L * 9))
                .inputFluids(FullereneDopedNanotubes.getFluid(L))
                .outputItems(OPTICAL_PROCESSING_CORE,6)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(200).EUt(750000)
                .inputItems(dustSmall, Radium)
                .inputItems(plate, Polybenzimidazole, 4)
                .inputItems(plate, Polyetheretherketone, 6)
                .inputItems(plate, Steel, 4)
                .inputFluids(SolderingAlloy.getFluid(L))
                .outputItems(ELECTRON_SOURCE)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(200).EUt(800000)
                .inputItems(plate, Graphene, 2)
                .inputItems(ELECTRIC_MOTOR_UHV)
                .inputFluids(SolderingAlloy.getFluid(L * 2))
                .outputItems(ROTATING_TRANSPARENT_SURFACE)
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(320).EUt(3200000)
                .inputItems(LithiumNiobateNanoparticles,2)
                .notConsumable(ROTATING_TRANSPARENT_SURFACE)
                .notConsumable(ELECTRON_SOURCE)
                .inputFluids(Xenon.getFluid(1000))
                .outputItems(PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE)
                .save(provider);

        LATHE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(260).EUt(1600000)
                .inputItems(PERIODICALLY_POLED_LITHIUM_NIOBATE_BOULE)
                .outputItems(NON_LINEAR_OPTICAL_LENS)
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(240).EUt(710000)
                .inputItems(plate, Germanium)
                .inputFluids(Zinc.getFluid(144))
                .inputFluids(HydrogenSulfide.getFluid(1000))
                .outputFluids(Hydrogen.getFluid(1000))
                .outputItems(HIGHLY_REFLECTIVE_MIRROR)
                .save(provider);

        LARGE_MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(3000)
                .inputItems(dust, ZirconiumTetrafluoride,90)
                .inputItems(dust, BariumDifluoride,21)
                .inputItems(dust, LanthanumTrifluoride,8)
                .inputItems(dust, AluminiumTrifluoride,4)
                .inputItems(dust, SodiumFluoride, 14)
                .outputItems(dust, ZBLANDust,35)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(3000)
                .inputItems(dust, ZBLANDust)
                .inputItems(ErbiumTrifluoride,4)
                .outputItems(ErbiumDopedZBLANDust,2)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(6000)
                .inputFluids(Argon.getFluid(1000))
                .inputItems(dust, ZBLANDust)
                .outputItems(ZBLAN)
                .blastFurnaceTemp(2500)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(6000)
                .inputFluids(Argon.getFluid(1000))
                .inputItems(ErbiumDopedZBLANDust)
                .outputItems(ERBIUM_DOPED_ZBLAN)
                .blastFurnaceTemp(2500)
                .save(provider);

        FORMING_PRESS_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(7680).duration(2000)
                .notConsumable(SHAPE_MOLD_INGOT)
                .inputItems(ZBLAN)
                .outputItems(ZBLAN_INGOT)
                .save(provider);

        ARC_FURNACE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(10000)
                .inputFluids(Oxygen.getFluid(1000))
                .inputItems(ZBLAN_INGOT)
                .outputItems(HOT_ANNEALED_ZBLAN_INGOT)
                .save(provider);

        EXTRUDER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(7680).duration(2000)
                .notConsumable(SHAPE_EXTRUDER_WIRE)
                .inputItems(HOT_ANNEALED_ZBLAN_INGOT)
                .outputItems(ZBLAN_FIBER,2)
                .save(provider);

        // Optical Fiber
        FORMING_PRESS_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(4000).duration(2000)
                .inputItems(ZBLAN_FIBER)
                .inputItems(ERBIUM_DOPED_ZBLAN)
                .outputItems(CLADDED_OPTICAL_FIBER_CORE)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30).duration(150)
                .inputItems(CLADDED_OPTICAL_FIBER_CORE)
                .inputFluids(Polytetrafluoroethylene.getFluid(144))
//                .outputItems(OreDictUnifier.get(opticalFiberSingle.toString()))
                .save(provider);


        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputItems(wireFine, NaquadahAlloy, 16)
                .inputItems(plate, Tritanium, 2)
                .inputItems(ELECTRIC_PUMP_LuV)
                .inputItems(pipeSmallFluid, Polybenzimidazole, 2)
                .inputItems(dust, Shewanella,2)
                .inputFluids(Polybenzimidazole.getFluid(L * 8))
                .outputItems(NEURO_SUPPORT_UNIT)
                .EUt(30720)
                .duration(250)
                .save(provider);

        // Cyber Processing Unit
        ASSEMBLY_LINE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++)
                .inputItems(ELECTRICALLY_WIRED_PETRI_DISH)
                .inputItems(foil, SiliconeRubber, 8)
                .inputItems(wireFine, Gold, 64)
                .inputItems(SMD_TRANSISTOR_WETWARE,4)
                .inputItems(SMD_DIODE_WETWARE,4)
                .inputItems(SMD_RESISTOR_WETWARE,4)
                .inputItems(SMD_CAPACITOR_WETWARE,4)
                .inputItems(WETWARE_CIRCUIT_BOARD)
                .inputItems(STEM_CELLS)
                .inputItems(NEURO_SUPPORT_UNIT)
                .inputFluids(Polybenzimidazole.getFluid(L * 8))
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .inputFluids(Titanium.getFluid(L * 9))
                .outputItems(CYBER_PROCESSING_UNIT,8)
                .EUt(30720 * 4)
                .duration(250)
                .save(provider);



        FLUID_SOLIDFICATION_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(24)
                .inputFluids(Polystyrene.getFluid(L / 4))
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .outputItems(PETRI_DISH)
                .save(provider);

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(160).EUt(24)
                .inputFluids(Polytetrafluoroethylene.getFluid(L / 4))
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .outputItems(PETRI_DISH)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(7680).duration(100)
                .inputItems(wireFine, Titanium)
                .inputFluids(Polyethylene.getFluid(1008))
                .inputItems(STERILIZED_PETRI_DISH)
                .outputItems(ELECTRICALLY_WIRED_PETRI_DISH)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(200)
                .inputFluids(Biomass.getFluid(1000))
                .inputFluids(SaltWater.getFluid(1000))
                .outputItems(dust, GreenAlgae)
                .outputItems(dust, RedAlgae)
                .outputItems(dust, BrownAlgae)
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30).duration(150)
                .inputItems(dust, RedAlgae)
                .outputItems(dust, DryRedAlgae)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30).duration(75)
                .inputItems(dust, DryRedAlgae)
                .outputItems(dust, RedAlgaePowder)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30).duration(150)
                .inputItems(dust, RedAlgaePowder)
                .inputItems(dustSmall, SodaAsh)
                .outputItems(dust, PreFreezeAgar)
                .save(provider);

        VACUUM_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(100)
                .inputItems(dust, PreFreezeAgar)
                .outputItems(dust, FrozenAgarCrystals)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30).duration(200)
                .inputItems(dust, FrozenAgarCrystals)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(WaterAgarMix.getFluid(1000))
                .save(provider);

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30).duration(50)
                .inputFluids(WaterAgarMix.getFluid(1000))
                .outputItems(dust, Agar)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(480).duration(100)
                .inputItems(STERILIZED_PETRI_DISH)
                .inputItems(dust, Agar)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(CLEAN_CULTURE)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(500)
                .inputItems(PIEZOELECTRIC_CRYSTAL)
                .inputItems(rodLong, RhodiumPlatedPalladium)
                .outputItems(ULTRASONIC_HOMOGENIZER)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(2400)
                .inputItems(dust, GreenAlgae)
                .inputItems(CLEAN_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(SHEWANELLA_CULTURE)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(2400)
                .inputItems(new ItemStack(Blocks.DIRT))
                .inputItems(CLEAN_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(BREVIBACTERIUM_CULTURE)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(2400)
                .inputItems(new ItemStack(Blocks.DIRT))
                .inputItems(CLEAN_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(CUPRIVADUS_CULTURE)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(2400)
                .inputItems(new ItemStack(Items.BEEF))
                .inputItems(CLEAN_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(ESCHERICHIA_CULTURE)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(2400)
                .inputFluids(Milk.getFluid(1000))
                .inputItems(CLEAN_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(BIFIDOBACTERIUM_CULTURE)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(2400)
                .inputItems(ROTTEN_FLESH)
                .inputItems(CLEAN_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(STREPTOCOCCUS_CULTURE)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(200)
                .inputItems(SHEWANELLA_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(dust, Shewanella)
                .outputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputItems(CONTAMINATED_PETRI_DISH)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(200)
                .inputItems(STREPTOCOCCUS_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(dust, StreptococcusPyogenes)
                .outputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputItems(CONTAMINATED_PETRI_DISH)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(200)
                .inputItems(BIFIDOBACTERIUM_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(dust, BifidobacteriumBreve)
                .outputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputItems(CONTAMINATED_PETRI_DISH)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(200)
                .inputItems(ESCHERICHIA_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(dust, EschericiaColi)
                .outputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputItems(CONTAMINATED_PETRI_DISH)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(200)
                .inputItems(BREVIBACTERIUM_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(dust, BrevibacteriumFlavium)
                .outputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputItems(CONTAMINATED_PETRI_DISH)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(30720).duration(200)
                .inputItems(CUPRIVADUS_CULTURE)
                .inputFluids(BacterialGrowthMedium.getFluid(1000))
                .outputItems(dust, CupriavidusNecator)
                .outputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputItems(CONTAMINATED_PETRI_DISH)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(100)
                .inputItems(dust, Shewanella)
                .outputItems(dust, Shewanella,2)
                .inputFluids(BacterialGrowthMedium.getFluid(250))
                .outputFluids(DepletedGrowthMedium.getFluid(250))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(100)
                .inputItems(dust, BrevibacteriumFlavium)
                .outputItems(dust, BrevibacteriumFlavium,2)
                .inputFluids(BacterialGrowthMedium.getFluid(250))
                .outputFluids(DepletedGrowthMedium.getFluid(250))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(100)
                .inputItems(dust, EschericiaColi)
                .outputItems(dust, EschericiaColi,2)
                .inputFluids(BacterialGrowthMedium.getFluid(250))
                .outputFluids(DepletedGrowthMedium.getFluid(250))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(100)
                .inputItems(dust, StreptococcusPyogenes)
                .outputItems(dust, StreptococcusPyogenes,2)
                .inputFluids(BacterialGrowthMedium.getFluid(250))
                .outputFluids(DepletedGrowthMedium.getFluid(250))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(100)
                .inputItems(dust, BifidobacteriumBreve)
                .outputItems(dust, BifidobacteriumBreve,2)
                .inputFluids(BacterialGrowthMedium.getFluid(250))
                .outputFluids(DepletedGrowthMedium.getFluid(250))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).EUt(120).duration(100)
                .inputItems(dust, CupriavidusNecator)
                .outputItems(dust, CupriavidusNecator,2)
                .inputFluids(BacterialGrowthMedium.getFluid(250))
                .outputFluids(DepletedGrowthMedium.getFluid(250))
                .save(provider);


        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(12000).EUt(480).inputItems(gemExquisite, Olivine).inputFluids(Rutherfordium.getFluid(L / 2)).chancedOutput(RAW_CRYSTAL_CHIP.asItem(), "1/2", 1000).save(provider);
        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(12000).EUt(480).inputItems(gemExquisite, Emerald).inputFluids(Rutherfordium.getFluid(L / 2)).chancedOutput(RAW_CRYSTAL_CHIP.asItem(), "1/2", 1000).save(provider);
        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(12000).EUt(480).inputItems(gemFlawless, Olivine) .inputFluids(Rutherfordium.getFluid(L / 2)).chancedOutput(RAW_CRYSTAL_CHIP.asItem(), "1/4", 750).save(provider);
        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(12000).EUt(480).inputItems(gemFlawless, Emerald) .inputFluids(Rutherfordium.getFluid(L / 2)).chancedOutput(RAW_CRYSTAL_CHIP.asItem(), "1/4", 750).save(provider);

        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(450).EUt(480).blastFurnaceTemp(5000).inputItems(RAW_CRYSTAL_CHIP).inputItems(plate, Emerald).inputFluids(Rutherfordium.getFluid(L / 2)).outputItems(ENGRAVED_CRYSTAL_CHIP).save(provider);
        BLAST_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(450).EUt(480).blastFurnaceTemp(5000).inputItems(RAW_CRYSTAL_CHIP).inputItems(plate, Olivine).inputFluids(Rutherfordium.getFluid(L / 2)).outputItems(ENGRAVED_CRYSTAL_CHIP).save(provider);;

        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(150).EUt(6)
                .inputItems(dust, Carbon)
                .inputFluids(Cerium.getFluid(1))
                .chancedOutput(CARBON_FIBERS.get(),2, "1/8", 250)
                .save(provider);

        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(150).EUt(6)
                .inputItems(dust, Carbon)
                .inputFluids(Palladium.getFluid(1))
                .chancedOutput(CARBON_FIBERS.get(),2, "3/4", 250)
                .save(provider);

        AUTOCLAVE_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(150).EUt(6)
                .inputItems(dust, Carbon)
                .inputFluids(Platinum.getFluid(1))
                .chancedOutput(CARBON_FIBERS.get(),2, "7/10", 250)
                .save(provider);

        LASER_ENGRAVER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(100).EUt(10000)
                .inputItems(ENGRAVED_CRYSTAL_CHIP)
                .notConsumable(lens, Lime)
                .outputItems(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .save(provider);

        CUTTER_RECIPES.recipeBuilder("circuit_components_" + chainNumber++).duration(960).EUt(60)
                .inputItems(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .outputItems(RAW_CRYSTAL_CHIP,2)
                .save(provider);

    }

}

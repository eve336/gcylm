package com.eve.examplemod.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.AdipicAcid;
import static com.eve.examplemod.common.data.EVMaterials2.SaccharicAcid;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class InsulationWireAssemblyChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        int chainNumber = 0;

        // 4C2H4 + NH3 + HBr -> C8H20NBr
        CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(240).EUt(120)
                .inputFluids(Ethylene.getFluid(4000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(HydrobromicAcid.getFluid(1000))
                .outputFluids(TetraethylammoniumBromide.getFluid(1000))
                .save(provider);

        // H2O + C6H12O6 -> C6H14O2 + 5O
        CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(180).EUt(120)
                .notConsumable(dust, PdIrReOCeOS)
                .inputFluids(Water.getFluid(1000))
                .inputItems(Fructose, 24)
                .notConsumableFluid(TetraethylammoniumBromide.getFluid(0))
                .outputFluids(Hexanediol.getFluid(1000))
                .outputFluids(Oxygen.getFluid(5000))
                .save(provider);

        // 2NH3 + C6H14O2 -> 2H2O + C6H16N2
        CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(240).EUt(480)
                .inputFluids(Hexanediol.getFluid(1000))
                .inputFluids(Ammonia.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputFluids(Hexamethylenediamine.getFluid(1000))
                .notConsumable(dust, Ruthenium)
                .notConsumable(dust, Alumina)
                .save(provider);

        // C6H12O6 + 3 O -> C6H10O8 + H2O
        CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(160).EUt(480)
                .inputItems(Glucose, 24)
                .inputFluids(Oxygen.getFluid(3000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(SaccharicAcid, 24)
                .save(provider);

        // C6H10O8 + 8H -> C6H10O4 + 4H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(160).EUt(480)
                .inputItems(SaccharicAcid, 24)
                .notConsumable(dust, AuPdCCatalyst)
                .notConsumable(dust, ScandiumTriflate)
                .inputFluids(Hydrogen.getFluid(8000))
                .outputItems(AdipicAcid, 20)
                .outputFluids(Water.getFluid(4000))
                .save(provider);

        // C3H6O + CH4 -> C4H10O
        CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(125).EUt(120)
                .notConsumable(dust, MagnesiumChloride)
                .inputItems(ZeoliteSievingPellets)
                .inputFluids(Acetone.getFluid(1000))
                .inputFluids(Methane.getFluid(1000))
                .outputFluids(Tertbutanol.getFluid(1000))
                .outputItems(WetZeoliteSievingPellets)
                .save(provider);

        // 2C4H10O + 2CO2 -> H2O + C10H18O5
        CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(260).EUt(480)
                .inputFluids(Tertbutanol.getFluid(2000))
                .inputFluids(CarbonDioxide.getFluid(2000))
                .notConsumableFluid(Toluenesulfonate.getFluid(0))
                .outputFluids(Water.getFluid(1000))
                .outputItems(DitertbutylDicarbonate, 33)
                .save(provider);

        // C4H8 + C10H18O5 + 4NH3 + 3C -> 2 C4H10O + C6H18N4 + 3CO
        LARGE_CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(370).EUt(480)
                .inputItems(DitertbutylDicarbonate, 33)
                .inputItems(dust, Carbon, 3)
                .inputFluids(Butene.getFluid(1000))
                .inputFluids(Ammonia.getFluid(4000))
                .notConsumableFluid(Trimethylchlorosilane.getFluid(0))
                .outputFluids(Tertbutanol.getFluid(2000))
                .outputFluids(CarbonMonoxide.getFluid(3000))
                .outputFluids(Triaminoethaneamine.getFluid(1000))
                .save(provider);

        LARGE_CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(290).EUt(30720)
                .inputItems(foil, Polyetheretherketone)
                .inputItems(foil, SiliconeRubber)
                .inputItems(AdipicAcid, 20)
                .inputFluids(Hexamethylenediamine.getFluid(1000))
                .inputFluids(Triaminoethaneamine.getFluid(500))
                .outputItems(PEEK_POLYAMIDE_FOIL, 3)
                .save(provider);

        // 2K + 2NaN3 + C10H18O5 -> 2Na + K2O + 2C5H9N3O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(210).EUt(480)
                .inputItems(dust, Potassium, 2)
                .inputItems(SodiumAzide, 8)
                .inputItems(DitertbutylDicarbonate, 33)
                .outputItems(dust, Sodium, 2)
                .outputItems(dust, Potash, 6)
                .outputFluids(TertButylAzidoformate.getFluid(2000))
                .save(provider);

        // Aminated Fullerene is a Secondary Amine
        // C60 + 4C5H9N3O2 + 8H2O + 4CO -> C60N12H12 + 4C4H10O + 8CO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(120).EUt(30720)
                .inputItems(Fullerene)
                .inputFluids(TertButylAzidoformate.getFluid(4000))
                .inputFluids(Water.getFluid(8000))
                .inputFluids(CarbonMonoxide.getFluid(4000))
                .outputFluids(AminatedFullerene.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(8000))
                .outputFluids(Tertbutanol.getFluid(4000))
                .save(provider);

        FLUID_HEATER_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(120).EUt(480)
                .inputFluids(AminatedFullerene.getFluid(1000))
                .outputFluids(Azafullerene.getFluid(1000))
                .notConsumable(wireFine, Rhenium)
                .save(provider);

        CHEMICAL_BATH_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(30).EUt(7680)
                .inputItems(PEEK_POLYAMIDE_FOIL)
                .inputFluids(Azafullerene.getFluid(10))
                .outputItems(HIGHLY_INSULATING_FOIL)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(100).EUt(120)
                .inputFluids(Resorcinol.getFluid(500))
                .inputFluids(Formaldehyde.getFluid(1000))
                .inputItems(dust, GrapheneOxide, 3)
                .outputItems(dust, GrapheneGelSuspension)
                .save(provider);

        AUTOCLAVE_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(260).EUt(480)
                .inputItems(dust, GrapheneGelSuspension)
                .inputFluids(Acetone.getFluid(100))
                .outputItems(dust, DryGrapheneGel)
                .save(provider);

        FLUID_HEATER_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(80).EUt(480)
                .inputFluids(CarbonDioxide.getFluid(1000))
                .outputFluids(SupercriticalCO2.getFluid(1000))
                .circuitMeta(0)
                .save(provider);

        BLAST_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(400).EUt(120).blastFurnaceTemp(5000)
                .inputItems(dust, DryGrapheneGel)
                .inputFluids(SupercriticalCO2.getFluid(1000))
                .outputItems(AEROGRAPHENE)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("insulation_wire_assembly_" + chainNumber++).duration(210).EUt(30720)
                .inputItems(rod, Polyurethane)
                .inputItems(rod, ReinforcedEpoxyResin)
                .inputItems(MEMORY_FOAM_BLOCK)
                .inputItems(HIGHLY_INSULATING_FOIL)
                .inputItems(AEROGRAPHENE)
                .inputFluids(Argon.getFluid(1000))
                .outputItems(INSULATION_WIRE_ASSEMBLY, 2)
                .save(provider);
    }
}

package com.eve.examplemod.data.recipe.chain;


import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class Batteries {
    public static void init(Consumer<FinishedRecipe> provider) {

        // 4NiO + 3H2SO4 + 6KOH -> 3K2SO4 + 4NiO2H + 4H + 2H2O (H + H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("batteries_0").duration(240).EUt(1300)
                .inputItems(dust, Garnierite, 8)
                .inputFluids(SulfuricAcid.getFluid(3000))
                .inputFluids(PotassiumHydroxide.getFluid(6000))
                .outputItems(dust,PotassiumSulfate, 21)
                .outputItems(dust, NickelOxideHydroxide, 16)
                .save(provider);

        // 2CoO + Li2CO3(H2O) -> 2 LiCoO2 + CO + H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("batteries_1").duration(240).EUt(4000)
                .inputItems(dust, CobaltOxide, 4)
                .inputFluids(LithiumCarbonateSolution.getFluid(1000))
                .notConsumableFluid(Oxygen.getFluid(0))
                .outputItems(dust, LithiumCobaltOxide, 6)
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .save(provider);

        // BaO6S2C2F6 + Li2CO3(H2O) -> BaCO3 + 2LiCSO3F3 + H2O (H2O lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("batteries_2").duration(220).EUt(480)
                .inputItems(dust, BariumTriflate, 17)
                .inputFluids(LithiumCarbonateSolution.getFluid(1000))
                .outputItems(dust,BariumCarbonate, 5)
                .outputItems(dust, LithiumTriflate, 18)
                .save(provider);

        // Algae + 6Na2CO3(H2O) -> 4C6H10O5 + 2C5H10O5 + 6NaC6H7O6(H2O) + 6CO2 + 6H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("batteries_3").duration(600).EUt(1920)
                .inputItems(dust, BrownAlgae, 10)
                .notConsumable(dust, Diatomite)
                .inputFluids(SodiumCarbonateSolution.getFluid(6000))
                .outputItems(dust, Cellulose, 84)
                .outputItems(dust, Xylose, 20)
                .outputFluids(Biomass.getFluid(540))
                .outputFluids(SodiumAlginateSolution.getFluid(6000))
                .outputFluids(CarbonDioxide.getFluid(6000))
                .outputFluids(Water.getFluid(6000))
                .save(provider);

        // 2NaC6H7O6(H2O) + CaCl2 -> CaC12H14O12 + 2NaCl(H2O)
        MIXER_RECIPES.recipeBuilder("batteries_4").duration(290).EUt(30)
                .inputFluids(SodiumAlginateSolution.getFluid(2000))
                .inputItems(dust, CalciumChloride, 3)
                .outputItems(dust, CalciumAlginate, 39)
                .outputFluids(SaltWater.getFluid(4000))
                .save(provider);

        // C3H10Si + 5C6H8O7 + C19H42BrN + 3NH3 -> Si + 2CO + 4NO2 + HBr + 25C2H4O
        LARGE_CHEMICAL_RECIPES.recipeBuilder("batteries_5").duration(220).EUt(1920)
                .inputFluids(Trimethylsilane.getFluid(1000))
                .inputFluids(CitricAcid.getFluid(5000))
                .inputFluids(CetaneTrimethylAmmoniumBromide.getFluid(1000))
                .inputFluids(Ammonia.getFluid(3000))
                .outputItems(dust, SiliconNanoparticles)
                .outputFluids(CarbonMonoxide.getFluid(2000))
                .outputFluids(NitrogenDioxide.getFluid(4000))
                .outputFluids(HydrobromicAcid.getFluid(1000))
                .outputFluids(Acetaldehyde.getFluid(25000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("batteries_6").duration(3200).EUt(120)
                .inputItems(dust, Glucose,24)
                .inputItems(dust, StreptococcusPyogenes)
                .outputItems(dust, Sorbose, 24)
                .save(provider);

        // C6H12O6 -> C6H8O6 + 4H (H lost to dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("batteries_7").duration(280).EUt(480)
                .inputItems(dust, Sorbose,24)
                .outputFluids(AscorbicAcid.getFluid(1000))
                .notConsumable(dust, Platinum)
                .save(provider);

        // C6H6O6 + 2H -> C6H8O6
        CHEMICAL_RECIPES.recipeBuilder("batteries_8").duration(280).EUt(480)
                .inputFluids(DehydroascorbicAcid.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(2000))
                .outputFluids(AscorbicAcid.getFluid(1000))
                .notConsumable(dust, Nickel)
                .save(provider);

        CHEMICAL_PLANT_RECIPES.recipeBuilder("batteries_9").duration(390).EUt(7680)
                .inputItems(dust, GrapheneOxide, 3)
                .inputItems(dust, SiliconNanoparticles)
                .inputItems(dust, CalciumAlginate)
                .inputItems(dust, CarbonNanotubes)
                .inputFluids(SodiumCarbonateSolution.getFluid(1000))
                .inputFluids(AscorbicAcid.getFluid(1000))
                .outputItems(NANOSILICON_CATHODE)
                .outputFluids(DehydroascorbicAcid.getFluid(1000))
                .save(provider);

        // Ga + 3Cl -> GaCl3
        CHEMICAL_RECIPES.recipeBuilder("batteries_10").duration(100).EUt(120)
                .inputItems(dust, Gallium)
                .inputFluids(Chlorine.getFluid(3000))
                .outputItems(dust, GalliumChloride, 4)
                .save(provider);

        // 9AlCl3 + GaCl3 + 10SiO2 + 15H2O + 30NH3 + 15O -> Al9Si10O50Ga + 30NH4Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder("batteries_11").duration(470).EUt(7680)
                .inputItems(dust, AluminiumChloride,36)
                .inputItems(dust, GalliumChloride, 4)
                .inputItems(dust, SilicaGel,30)
                .inputFluids(Water.getFluid(15000))
                .inputFluids(Ammonia.getFluid(30000))
                .inputFluids(Oxygen.getFluid(15000))
                .outputItems(dust, Halloysite, 90)
                .outputFluids(AmmoniumChloride.getFluid(30000))
                .save(provider);

        MIXER_RECIPES.recipeBuilder("batteries_12").duration(100).EUt(480)
                .inputItems(dust, Halloysite, 9)
                .inputItems(dust, Xylose, 40)
                .inputItems(dust, Sulfur, 2)
                .outputItems(dust, SulfurCoatedHalloysite, 9)
                .outputFluids(Water.getFluid(10000))
                .save(provider);

        // LaF3 + BaF2 + 10C7H7F + 10CH2O -> 10H2O
        CHEMICAL_RECIPES.recipeBuilder("batteries_13").duration(320).EUt(30720)
                .inputItems(dust, LanthanumTrifluoride,36)
                .inputItems(dust, BariumDifluoride, 3)
                .inputFluids(Fluorotoluene.getFluid(10000))
                .inputFluids(Formaldehyde.getFluid(10000))
                .outputItems(dust, FluorideBatteryElectrolyte, 2)
                .outputFluids(Water.getFluid(10000))
                .save(provider);

        // Ni + O -> NiO
        CHEMICAL_RECIPES.recipeBuilder("batteries_14").duration(200).EUt(120)
                .inputItems(dust, Nickel)
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, Garnierite, 2)
                .save(provider);

        // 7La2O3 + 7NiO + Ca + 2C10H16N2O8 -> 7La2NiO4 + CaO + 15CO + 5CH4 + 4NH3
        CHEMICAL_PLANT_RECIPES.recipeBuilder("batteries_15").duration(420).EUt(30720)
                .inputItems(dust, LanthanumOxide, 35)
                .inputItems(dust, Garnierite, 14)
                .inputItems(dust, Calcium)
                .inputFluids(EDTA.getFluid(2000))
                .outputItems(dust, LanthanumNickelOxide, 49)
                .outputItems(dust, Quicklime, 2)
                .outputFluids(CarbonMonoxide.getFluid(15000))
                .outputFluids(Methane.getFluid(5000))
                .outputFluids(Ammonia.getFluid(4000))
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_16")
                .inputItems(plate, Titanium, 4)
                .inputItems(plate, Vanadium, 2)
                .inputItems(cableGtSingle, Aluminium, 8)
                .inputItems(dust, NickelOxideHydroxide, 2)
                .EUt(1920)
                .duration(100)
                .outputItems(BATTERY_NIMH_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_17")
                .inputItems(plate, TungstenSteel, 4)
                .inputItems(plate, Vanadium, 4)
                .inputItems(cableGtSingle, Platinum, 8)
                .inputItems(dust, LithiumCobaltOxide, 3)
                .EUt(7680)
                .duration(100)
                .outputItems(BATTERY_SMALL_LITHIUM_ION_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_18")
                .inputItems(plate, RhodiumPlatedPalladium, 4)
                .inputItems(plate, Vanadium, 6)
                .inputItems(cableGtSingle, NiobiumTitanium, 8)
                .inputItems(dust, LithiumCobaltOxide, 6)
                .EUt(7680 * 4)
                .duration(100)
                .outputItems(BATTERY_MEDIUM_LITHIUM_ION_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_19")
                .inputItems(plate, HSSS, 4)
                .inputItems(plate, Naquadria, 2)
                .inputItems(cableGtSingle, Naquadah, 8)
                .inputItems(dust, LithiumCobaltOxide, 9)
                .EUt(7680 * 16)
                .duration(100)
                .outputItems(BATTERY_LARGE_LITHIUM_ION_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_20")
                .inputItems(plate, Tritanium, 4)
                .inputItems(plate, Naquadria, 4)
                .inputItems(cableGtSingle, NaquadahAlloy, 8)
                .inputItems(NANOSILICON_CATHODE)
                .inputItems(dust, SulfurCoatedHalloysite, 3)
                .EUt(7680 * 64)
                .duration(100)
                .outputItems(BATTERY_SMALL_LIS_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_21")
                .inputItems(plate, Seaborgium, 4)
                .inputItems(plate, Naquadria, 6)
                .inputItems(cableGtSingle, AbyssalAlloy, 8)
                .inputItems(NANOSILICON_CATHODE, 2)
                .inputItems(dust, SulfurCoatedHalloysite, 6)
                .EUt(30720 * 16)
                .duration(100)
                .outputItems(BATTERY_MEDIUM_LIS_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_22")
                .inputItems(plate, Bohrium, 4)
                .inputItems(cableGtSingle, TitanSteel, 8)
                .inputItems(plate, NaquadriaticTaranium, 2)
                .inputItems(NANOSILICON_CATHODE, 4)
                .inputItems(dust, SulfurCoatedHalloysite, 9)
                .EUt(30720 * 64)
                .duration(100)
                .outputItems(BATTERY_LARGE_LIS_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_23")
                .inputItems(plate, Quantum, 4)
                .inputItems(cableGtSingle, BlackTitanium, 8)
                .inputItems(plate, NaquadriaticTaranium, 4)
                .inputItems(plate, Neutronium)
                .inputItems(dust, LanthanumNickelOxide, 7)
                .EUt(122880 * 4)
                .duration(100)
                .outputItems(BATTERY_SMALL_FLUORIDE_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_24")
                .inputItems(plate, Neutronium, 6)
                .inputItems(cableGtSingle, Neutronium, 8)
                .inputItems(plate, Neutronium, 2)
                .inputItems(dust, LanthanumNickelOxide, 14)
                .EUt(122880 * 16)
                .duration(100)
                .outputItems(BATTERY_MEDIUM_FLUORIDE_EMPTY)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("batteries_25")
                .inputItems(plate, CosmicNeutronium, 4)
                .inputItems(wireGtSingle, UXVSuperconductor, 8)
                .inputItems(plate, Neutronium, 6)
                .inputItems(plate, Neutronium, 4)
                .inputItems(dust, LanthanumNickelOxide, 28)
                .EUt(122880 * 64)
                .duration(100)
                .outputItems(BATTERY_LARGE_FLUORIDE_EMPTY)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_26")
                .inputFluids(PotassiumHydroxide.getFluid(1000))
                .inputItems(BATTERY_NIMH_EMPTY)
                .EUt(480)
                .duration(60)
                .outputItems(BATTERY_NIMH)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_27")
                .inputItems(dust, LithiumTriflate)
                .inputItems(BATTERY_SMALL_LITHIUM_ION_EMPTY)
                .EUt(480 * 4)
                .duration(60)
                .outputItems(BATTERY_SMALL_LITHIUM_ION)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_28")
                .inputItems(dust, LithiumTriflate, 2)
                .inputItems(BATTERY_MEDIUM_LITHIUM_ION_EMPTY)
                .EUt(480 * 16)
                .duration(60)
                .outputItems(BATTERY_MEDIUM_LITHIUM_ION)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_29")
                .inputItems(dust, LithiumTriflate, 4)
                .inputItems(BATTERY_LARGE_LITHIUM_ION_EMPTY)
                .EUt(480 * 64)
                .duration(60)
                .outputItems(BATTERY_LARGE_LITHIUM_ION)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_30")
                .inputItems(dust, LithiumTriflate, 4)
                .inputItems(BATTERY_SMALL_LIS_EMPTY)
                .EUt(30720 * 4)
                .duration(60)
                .outputItems(BATTERY_SMALL_LIS)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_31")
                .inputItems(dust, LithiumTriflate, 8)
                .inputItems(BATTERY_MEDIUM_LIS_EMPTY)
                .EUt(30720 * 16)
                .duration(60)
                .outputItems(BATTERY_MEDIUM_LIS)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_32")
                .inputItems(dust, LithiumTriflate, 16)
                .inputItems(BATTERY_LARGE_LIS_EMPTY)
                .EUt(30720 * 64)
                .duration(60)
                .outputItems(BATTERY_LARGE_LIS)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_33")
                .inputItems(dust, FluorideBatteryElectrolyte)
                .inputItems(BATTERY_SMALL_FLUORIDE_EMPTY)
                .EUt(1966080 * 4)
                .duration(60)
                .outputItems(BATTERY_SMALL_FLUORIDE)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_34")
                .inputItems(dust, FluorideBatteryElectrolyte, 2)
                .inputItems(BATTERY_MEDIUM_FLUORIDE_EMPTY)
                .EUt(1966080 * 16)
                .duration(60)
                .outputItems(BATTERY_MEDIUM_FLUORIDE)
                .save(provider);

        CANNER_RECIPES.recipeBuilder("batteries_35")
                .inputItems(dust, FluorideBatteryElectrolyte, 4)
                .inputItems(BATTERY_LARGE_FLUORIDE_EMPTY)
                .EUt(1966080 * 64)
                .duration(60)
                .outputItems(BATTERY_LARGE_FLUORIDE)
                .save(provider);
    }
}

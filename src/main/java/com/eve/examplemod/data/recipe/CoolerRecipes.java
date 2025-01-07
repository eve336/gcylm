package com.eve.examplemod.data.recipe;

import com.eve.examplemod.common.data.EVMachines;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.eve.examplemod.common.data.EVMaterials2.*;
import static com.eve.examplemod.common.data.EVRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static net.minecraft.world.item.Items.QUARTZ;
import static net.minecraft.world.item.Items.QUARTZ_BLOCK;


public class CoolerRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {

        // im putting the fuel cell recipe here bc i cant be assed making another java file and this is nuclear related

        // TODO make a real recipe for this lmaooo
        VanillaRecipeHelper.addShapedRecipe(provider, true, id("fuel_cell"),
                EVMachines.FUEL_CELL.asStack(),
                "ZRZ",
                "ZWZ",
                "ZRZ",
                'Z', ChemicalHelper.get(plate, Zirconium),
                'R', ChemicalHelper.get(rod, Zirconium),
                'W', ChemicalHelper.get(wireFine, Copper));

        VanillaRecipeHelper.addShapedRecipe(provider, true, id("active_cooler"),
                EVMachines.ACTIVE_COOLER.asStack(),
                "CIC",
                "CPC",
                "COC",
                'P', CraftingComponent.PUMP.getIngredient(GTValues.EV),
                'C', ChemicalHelper.get(plate, Copper),
                'O', ChemicalHelper.get(pipeNormalFluid, Copper),
                'I', CraftingComponent.CIRCUIT.getIngredient(GTValues.IV));

        ACTIVE_COOLER_RECIPES.recipeBuilder("distilled_water")
                .inputFluids(DistilledWater.getFluid(1))
                .addData("cooling", 6)
                .duration(1)
                .save(provider);

        ACTIVE_COOLER_RECIPES.recipeBuilder("cryotheum")
                .inputFluids(Cryotheum.getFluid(1))
                .addData("cooling", 11)
                .duration(1)
                .save(provider);

        ACTIVE_COOLER_RECIPES.recipeBuilder("supercooled_cryotheum")
                .inputFluids(SupercooledCryotheum.getFluid(1))
                .addData("cooling", 15)
                .duration(1)
                .save(provider);

        ACTIVE_COOLER_RECIPES.recipeBuilder("dichlorodifluoromethane")
                .inputFluids(Dichlorodifluoromethane.getFluid(1))
                .addData("cooling", 20)
                .duration(1)
                .save(provider);


        // Dichlorodifluoromethane

        // CH4 + 8 Cl -> CCl4 + 4HCl
        CHEMICAL_RECIPES.recipeBuilder("carbon_tetrachloride")
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(Chlorine.getFluid(8000))
                .outputFluids(CarbonTetrachloride.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(4000))
                .save(provider);

        // CCl4 + 2 HF -> CCl2F2 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder("dichlorodifluoromethane")
                .inputFluids(CarbonTetrachloride.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(2000))
                .outputFluids(Dichlorodifluoromethane.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);

        // Chlorinated solvents instead lo ?
        // CH2Cl2 + 4F -> CCl2F2 + 2HF
        CHEMICAL_RECIPES.recipeBuilder("dichlorodifluoromethane_from_dichloromethane")
                .inputFluids(Dichloromethane.getFluid(1000))
                .inputFluids(Fluorine.getFluid(4000))
                .outputFluids(Dichlorodifluoromethane.getFluid(1000))
                .outputFluids(HydrofluoricAcid.getFluid(4000))
                .save(provider);


        // Polyphenyl ether ?

        // terphenyl

        // Dibromobenzene
        // C6H6 + 4Br -> C6H4Br2 + 2HBr
        CHEMICAL_RECIPES.recipeBuilder("dibromobenzene")
                .inputFluids(Benzene.getFluid(1000))
                .inputFluids(Bromine.getFluid(4000))
                .outputFluids(Dibromobenzene.getFluid(1000))
                .outputFluids(HydrobromicAcid.getFluid(2000))
                .save(provider);

        // dichlorobromobenzene
        // C6H4Cl2 + 2Br -> C6H3Cl2Br + HBr
        CHEMICAL_RECIPES.recipeBuilder("dichlorobromobenzene")
                .inputFluids(Dichlorobenzene.getFluid(1000))
                .inputFluids(Bromine.getFluid(2000))
                .outputFluids(Dichlorobromobenzene.getFluid(1000))
                .outputFluids(HydrobromicAcid.getFluid(1000))
                .save(provider);

        // PhenylBoronic Acid
        //C6H5B(OCH3)2 + H2O -> C6H5B(OH)2 + CH3OH
        CHEMICAL_RECIPES.recipeBuilder("phenylboronic_acid")

                .inputFluids(Water.getFluid(1000))
                .outputItems(dust, PhenylboronicAcid)
                .outputFluids(Methanol.getFluid(1000))
                        .save(provider);

        // dichlorophenylboronic acid
        // C6H3Cl2Br + C6H5B(OH)2 -> C6H3Cl2B(OH)2 + C6H5Br
        CHEMICAL_RECIPES.recipeBuilder("dichlorophenylboronic_acid")
                .inputItems(dust, PhenylboronicAcid)
                .inputFluids(Dichlorobromobenzene.getFluid(1000))
                .outputFluids(DichlorophenylboronicAcid.getFluid(1000))
                .outputFluids(Bromobenzene.getFluid(1000))
                .save(provider);


        // Cl2-Ph-Ph-Ph-Cl2
        // C6H4Br2 + 2 C6Cl2H3B(OH)2 -> C18Cl4H10 + 2B + Br2 + 2H2O + O2
        // 14 H + 18 C + 4O
        // 80 degrees C
        // Catalyst
        CHEMICAL_RECIPES.recipeBuilder("dichloroterphenyl")
                .inputFluids(Dibromobenzene.getFluid(1000))
                .inputFluids(DichlorophenylboronicAcid.getFluid(2000))
                .outputFluids(DichloroTerphenyl.getFluid(1000))
                .outputFluids(Bromine.getFluid(2000))
                .outputItems(dust, Boron, 2)
                .outputFluids(Water.getFluid(2000))
                .outputFluids(Oxygen.getFluid(1000))
                .save(provider);

        // Cl-Ph-Ph-Ph-Cl  + 4H -> Ph - Ph - Ph + 2HCl
        // Palladium / Carbon catalyst
        CHEMICAL_RECIPES.recipeBuilder("terphenyl")
                .notConsumable(dust, Palladium)
                .inputFluids(DichloroTerphenyl.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(4000))
                .outputFluids(Terphenyl.getFluid(1000))
                .outputFluids(HydrochloricAcid.getFluid(2000))
                .save(provider);
    }
}

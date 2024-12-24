package com.eve.examplemod.common.machine.trait;

import com.eve.examplemod.api.capability.IFuelCell;
import com.eve.examplemod.common.machine.multiblock.miner;
import com.eve.examplemod.common.machine.multiblock.part.ActiveCooler;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

public class ActiveCoolerLogic extends RecipeLogic {
    public ActiveCoolerLogic(IRecipeLogicMachine machine) {
        super(machine);
    }

    @Override
    public ActiveCooler getMachine() {
        return (ActiveCooler) super.getMachine();
    }



    @Override
    public void findAndHandleRecipe() {
        if (!getMachine().fuelCellsEmpty()) {
            
            super.findAndHandleRecipe();
        }
    }
}
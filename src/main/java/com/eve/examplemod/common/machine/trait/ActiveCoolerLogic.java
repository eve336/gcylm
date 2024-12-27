package com.eve.examplemod.common.machine.trait;

import com.eve.examplemod.api.capability.IFuelCell;
import com.eve.examplemod.common.machine.multiblock.miner;
import com.eve.examplemod.common.machine.multiblock.part.ActiveCooler;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
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

    // TODO fix jank

    @Override
    public void serverTick() {
        System.out.println(getMachine().fuelCellsEmpty());
        if (!isActive && !getMachine().fuelCellsEmpty()) {
            boolean b = false;
            System.out.println(getMachine().fuelCellList);
            getMachine().fuelCellsEmpty();
            for (IFuelCell cell : getMachine().fuelCellList) {
                if (cell.getHeat() > 0) {
                    b = true;
                }
            }
            if (b) {
                findAndHandleRecipe();
            }
        }
        super.serverTick();
    }

    @Override
    public void setupRecipe(GTRecipe recipe) {
        if (handleFuelRecipe()) {
            boolean b = false;
            getMachine().fuelCellsEmpty();
            int cooling = recipe.data.getInt("cooling");
            // fuelCellList == null
            if (getMachine().fuelCellList != null) {
                for (IFuelCell cell : getMachine().fuelCellList) {
                    if (cell.getHeat() > cooling / getMachine().fuelCellList.size()) {
                        b = true;
                    }
                }
            }
            if (!machine.beforeWorking(recipe) || !b || getMachine().fuelCellList == null) {
                setStatus(Status.IDLE);
                progress = 0;
                duration = 0;
                isActive = false;
                return;
            }
            recipe.preWorking(this.machine);

            if (handleRecipeIO(recipe, IO.IN) && b) {
                if (lastRecipe != null && !recipe.equals(lastRecipe)) {
                    chanceCaches.clear();
                }
                recipeDirty = false;
                lastRecipe = recipe;
                setStatus(Status.WORKING);
                progress = 0;
                duration = recipe.duration;
                isActive = true;
            }
        }
    }
}
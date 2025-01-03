package com.eve.examplemod.common.machine.trait;

import com.eve.examplemod.api.capability.IFuelCell;
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

    // I forgot how my code (didn't) work
    // why does intellij have grammarly built in?

    // does this work??

    // TODO fix jank

    @Override
    public void serverTick() {
        System.out.println(this.getStatus());
        System.out.println(getMachine().fuelCellsEmpty());
        if ((!isActive || isIdle()) && !getMachine().fuelCellsEmpty()) {
            getMachine().fuelCellsEmpty();
            boolean b = false;
            System.out.println(getMachine().fuelCellList);
            getMachine().fuelCellsEmpty();
            for (IFuelCell cell : getMachine().fuelCellList) {
                if (cell.getHeat() > getMachine().cooling()) {
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
            // what is this comment for
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

            if (handleRecipeIO(recipe, IO.IN)) {
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
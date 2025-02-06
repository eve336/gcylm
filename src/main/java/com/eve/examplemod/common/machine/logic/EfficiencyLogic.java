package com.eve.examplemod.common.machine.logic;

import com.eve.examplemod.common.machine.multiblock.EfficiencyMachine;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

public class EfficiencyLogic extends RecipeLogic {
    public EfficiencyLogic(IRecipeLogicMachine machine) {
        super(machine);
    }

    @Override
    public EfficiencyMachine getMachine() {
        return (EfficiencyMachine) super.getMachine();
    }

    @Override
    public void setupRecipe(GTRecipe recipe) {
        if (handleFuelRecipe()) {
            if (!machine.beforeWorking(recipe)) {
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
                    getMachine().setTicks(getMachine().getRampUpTime() / 10);
                }
                recipeDirty = false;
                lastRecipe = recipe;
                setStatus(Status.WORKING);
                progress = 0;
                duration = (int) (recipe.duration / getMachine().Speed);
                isActive = true;
            }
        }
    }
}

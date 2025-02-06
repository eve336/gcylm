package com.eve.examplemod.common.machine.logic;

import com.eve.examplemod.common.machine.multiblock.EfficiencyMachine;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;

public class EfficiencyLogic extends RecipeLogic {
    @Persisted
    GTRecipe cacheRecipe;
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
                // idk how to check the last recipe ran (lastRecipe appears to get cleared when the machine isnt running or something)
                if (lastRecipe != null && !recipe.equals(lastRecipe) || cacheRecipe != null && !recipe.equals(cacheRecipe)) {
                    chanceCaches.clear();
                    getMachine().setTicks((int) (getMachine().rampUpTime * (getMachine().restartSpeedPercent/100)));
                }
                recipeDirty = false;
                lastRecipe = recipe;
                setStatus(Status.WORKING);
                progress = 0;
                duration = (int) (recipe.duration / getMachine().Speed);
                isActive = true;

                cacheRecipe = recipe;
            }
        }
    }
}

package com.eve.examplemod.common.machine.logic;

import com.eve.examplemod.common.data.EVMaterials;
import com.eve.examplemod.common.machine.multiblock.CosmicRayDetector;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.server.level.ServerLevel;

public class CosmicRayDetectorLogic extends RecipeLogic {

    public CosmicRayDetectorLogic(IRecipeLogicMachine machine) {
        super(machine);
    }

    @Override
    public CosmicRayDetector getMachine() {
        return (CosmicRayDetector) super.getMachine();
    }

    @Override
    public void findAndHandleRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel) {
            lastRecipe = null;
            var match = getCosmicRayRecipe();
            if (match != null) {
                if (match.matchRecipe(this.machine).isSuccess() && match.matchTickRecipe(this.machine).isSuccess()) {
                    setupRecipe(match);
                }
            }

        }
    }

    public GTRecipe getCosmicRayRecipe() {
        var recipe = GTRecipeBuilder.ofRaw()
                .outputFluids(EVMaterials.HeavyLeptonMix.getFluid(getMachine().getAmount()))
                .EUt(2097152)
                .duration(1);
        return recipe.buildRawRecipe();
    }
}

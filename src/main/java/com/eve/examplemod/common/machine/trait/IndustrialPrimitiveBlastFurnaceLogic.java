package com.eve.examplemod.common.machine.trait;

import com.eve.examplemod.common.machine.multiblock.primitive.IndustrialPrimitiveBlastFurnace;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.server.level.ServerLevel;

public class IndustrialPrimitiveBlastFurnaceLogic extends RecipeLogic {


    public boolean coke = false;

    public IndustrialPrimitiveBlastFurnaceLogic(IRecipeLogicMachine machine) {
        super(machine);
    }


    @Override
    public IndustrialPrimitiveBlastFurnace getMachine() {
        return (IndustrialPrimitiveBlastFurnace) super.getMachine();
    }



    @Override
    public void findAndHandleRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel) {
            lastRecipe = null;
            var match = getIronRecipe();
            var match2 = getIronCokeRecipe();

            if (match != null) {
                if (match.matchRecipe(this.machine).isSuccess() && match.matchTickRecipe(this.machine).isSuccess()) {
                    if (getMachine().fuel > 0 && !coke){
                        setupRecipe(match);
                        return;
                    }
                    if (getMachine().consumeFuel()) {
                        setupRecipe(match);
                        coke = false;
                        return;
                    }
                }
            }
            if (match2 != null) {
                if (match2.matchRecipe(this.machine).isSuccess() && match2.matchTickRecipe(this.machine).isSuccess()) {
                    if (getMachine().fuel > 0 && coke){
                        setupRecipe(match2);
                        return;
                    }
                    if (getMachine().consumeFuelCoke()) {
                        setupRecipe(match2);
                        coke = true;
                    }
                }
            }
        }
    }
    public GTRecipe getIronRecipe() {
        var recipe = GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Iron), 1)
                .outputItems(ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Steel), 1)
                .duration(1500/getMachine().size);


        return recipe.buildRawRecipe();
    }
    public GTRecipe getIronCokeRecipe() {
        var recipe = GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Iron), 1)
                .outputItems(ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Steel), 1)
                .duration(750/getMachine().size);


        return recipe.buildRawRecipe();
    }
}

package com.eve.examplemod.common.machine.trait;


import com.eve.examplemod.common.machine.multiblock.VoidOreMiner;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VOMLogic extends RecipeLogic {

    public static final List<Map.Entry<Integer, ItemStack>> ORES = new ArrayList<>();

    static {
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(PropertyKey.ORE)) {
                    ORES.add(Map.entry(1, ChemicalHelper.get(TagPrefix.ore, material)));
                }
            }
        }
    }


    public VOMLogic(IRecipeLogicMachine machine) {
        super(machine);
    }

    @Override
    public VoidOreMiner getMachine() {
        return (VoidOreMiner) super.getMachine();
    }


    @Override
    public void findAndHandleRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel) {
            lastRecipe = null;
            var match = getCryotheumRecipe();
            var match2 = getPyrotheumRecipe();

            if (match != null) {
                if (match.matchRecipe(this.machine).isSuccess() && match.matchTickRecipe(this.machine).isSuccess() && !getMachine().overheat) {
                    setupRecipe(match);
                    if (getMachine().onWorking()) {
                        getMachine().cryotheum = true;
                        return;
                    }
                }
            }
            if (match2 != null) {
                if (match2.matchRecipe(this.machine).isSuccess() && match2.matchTickRecipe(this.machine).isSuccess() && !getMachine().overheat) {
                    setupRecipe(match2);
                    if (getMachine().onWorking()) {
                        getMachine().cryotheum = false;
                    }
                }
            }
        }
    }

    public GTRecipe getCryotheumRecipe() {
        var recipe = GTRecipeBuilder.ofRaw()
                .inputFluids(getMachine().PYROTHEUM_STACK, getMachine().CRYOTHEUM_STACK, getMachine().DRILLING_MUD_STACK)
                .outputFluids(getMachine().USED_DRILLING_MUD_STACK)
                .duration(20)
                .inputEU(GTValues.V[getMachine().tier]);
        for (int i = 0; i < getMachine().temperature / 100; i++) {
            // TODO formula plus blacklist for ores
            // genuinely how the fuck does this even work
            recipe.outputItems(ORES.get(GTUtil.getRandomItem(GTValues.RNG, ORES, ORES.size())).getValue(), getMachine().temperature / 100);
        }
        return recipe.buildRawRecipe();
    }

    public GTRecipe getPyrotheumRecipe() {
        var recipe = GTRecipeBuilder.ofRaw()
                .inputFluids(getMachine().PYROTHEUM_STACK, getMachine().DRILLING_MUD_STACK)
                .outputFluids(getMachine().USED_DRILLING_MUD_STACK)
                .duration(20)
                .inputEU(GTValues.V[getMachine().tier]);
        for (int i = 0; i < getMachine().temperature / 100; i++) {
            recipe.outputItems(ORES.get(GTUtil.getRandomItem(GTValues.RNG, ORES, ORES.size())).getValue(), getMachine().temperature / 100);
        }
        return recipe.buildRawRecipe();
    }


}

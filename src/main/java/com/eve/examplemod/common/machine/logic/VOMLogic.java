package com.eve.examplemod.common.machine.logic;


import com.eve.examplemod.common.machine.multiblock.VoidOreMiner;
import com.eve.examplemod.config.EVConfig;
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

    public static List<Material> OreMaterial = new ArrayList<>();

    public final List<Map.Entry<Integer, ItemStack>> ORES = new ArrayList<>();

    static {
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(PropertyKey.ORE)) {
                    OreMaterial.add(material);
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

    // surely theres a better way to do this lmao
    // this can probably all be made static
    public void updateBlacklist() {


        List<String> blacklist = new ArrayList<>();

        // VOM1
        if (getMachine().tier == GTValues.UV) {
            blacklist = List.of(EVConfig.INSTANCE.VOM1Blacklist);
        }
        else if (getMachine().tier == GTValues.UHV){
            blacklist = List.of(EVConfig.INSTANCE.VOM2Blacklist);
        }
        else if (getMachine().tier == GTValues.UEV){
            blacklist = List.of(EVConfig.INSTANCE.VOM3Blacklist);
        }

        List<String> finalBlacklist = blacklist;
        OreMaterial.removeIf(ore -> {
            if (finalBlacklist.contains(ore.getName())) {
                return true;
            }
            else {
                ORES.add(Map.entry(1, ChemicalHelper.get(TagPrefix.ore, ore)));
                return false;
            }
        });
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

    // gety someone else to make vom output ores formula for me

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
        int numberOres = getMachine().temperature / 1000;
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

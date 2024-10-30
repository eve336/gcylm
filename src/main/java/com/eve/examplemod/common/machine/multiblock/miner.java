package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.data.EVMaterials;
import com.eve.examplemod.common.machine.trait.VOMLogic;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeCapabilityHolder;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SuppressWarnings({"SpellCheckingInspection"})
public class miner extends WorkableElectricMultiblockMachine
        implements IFancyUIMachine, IDisplayUIMachine {



    private final int maxTemperature;
    public final int tier;
    private TickableSubscription serverTickEvent;
    public int temperature = 0;
    public boolean cryotheum = false;
    public boolean overheat = false;
    public FluidStack CRYOTHEUM_STACK = EVMaterials.Cryotheum.getFluid(1);
    public FluidStack PYROTHEUM_STACK = EVMaterials.Pyrotheum.getFluid(1);
    private static final int CONSUME_START = 100;
    private double currentDrillingFluid = CONSUME_START;





    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("working: " + onWorking()));
        textList.add(Component.translatable("Temperaure: " + temperature));
        textList.add(Component.translatable("cryotheum: " + cryotheum));
    }

    public miner(IMachineBlockEntity holder, int tier, int temp) {
        super(holder);
        this.tier=tier;
        this.maxTemperature=temp;
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new VOMLogic(this);
    }

    @NotNull
    @Override
    public VOMLogic getRecipeLogic() {
        return (VOMLogic) super.getRecipeLogic();
    }





    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        updateServerTickSubscription();
    }

    @Override
    public void onStructureInvalid() {
        this.unsubscribe(serverTickEvent);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if(!isRemote() && isFormed()) {
            updateServerTickSubscription();
        }
    }

    private void updateServerTickSubscription() {
        serverTickEvent = this.subscribeServerTick(serverTickEvent, this::serverTickEvent);
    }




    private void serverTickEvent() {
        if (temperature < 0){
            temperature = 0;
        }
        if (overheat) {
            if (temperature > 0) {
                temperature -= 10;
            }
            if (temperature == 0) {
                overheat = false;
            }
            if (currentDrillingFluid > CONSUME_START) {
                currentDrillingFluid--;
            }
            if (currentDrillingFluid < CONSUME_START) {
                currentDrillingFluid = CONSUME_START;
            }
        }
        if (getOffsetTimer() % 20 == 0) {
            PYROTHEUM_STACK = EVMaterials.Pyrotheum.getFluid((int) currentDrillingFluid);
            CRYOTHEUM_STACK = EVMaterials.Cryotheum.getFluid((int) currentDrillingFluid);


            if (getRecipeLogic().isWorking() && !overheat && !cryotheum) {
                temperature += (int)(currentDrillingFluid / 100.0);
                currentDrillingFluid = currentDrillingFluid * 1.02;
            }

            if (temperature > maxTemperature) {
                overheat = true;
                currentDrillingFluid = CONSUME_START;
            }
        }

    }

    }
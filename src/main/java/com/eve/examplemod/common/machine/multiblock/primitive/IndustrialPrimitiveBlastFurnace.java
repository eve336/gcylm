package com.eve.examplemod.common.machine.multiblock.primitive;

import com.eve.examplemod.common.machine.logic.IndustrialPrimitiveBlastFurnaceLogic;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.lang.Math.PI;

public class IndustrialPrimitiveBlastFurnace extends WorkableElectricMultiblockMachine
        implements IFancyUIMachine, IDisplayUIMachine {


    @Persisted
    public int efficiency;

    // @Persisted to hopefully stop the bug where it consumes 1 piece of fuel every tick
    @Persisted
    public int fuel = 0;
    public int size;


    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("Fuel left: " + fuel));
        textList.add(Component.translatable("Current size: " + size));
        textList.add(Component.translatable("Fuel Efficiency: " + getEfficiency() + "%"));
    }


    public IndustrialPrimitiveBlastFurnace(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }


    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new IndustrialPrimitiveBlastFurnaceLogic(this);
    }


    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        size = this.getPattern().getFormedRepetitionCount()[1];
        getEfficiency();
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }


    @Override
    public boolean onWorking() {
        if (!isFormed){
            return super.onWorking();
        }
        if (fuel > 0) {
            if (getOffsetTimer() % 20 == 0) {
                fuel = fuel - 1;
            }
            return super.onWorking();
        }
        if (fuel == 0) {
            if (getRecipeLogic().coke) {
                if (fuel == 0) {
                    if (!consumeFuelCoke()) {
                        recipeLogic.interruptRecipe();
                    }
                }
            }
            if (!getRecipeLogic().coke) {
                if (fuel == 0) {
                    if (!consumeFuel()) {
                        recipeLogic.interruptRecipe();
                    }
                }
            }
        }
        return super.onWorking();
    }


    //THIS IS THE MOST JANK SHIT IVE EVER CODED IN MY LIFE BUT IT TECHNICALLY WORKS FOR NOW
    //TODO CHANGE THIS LATER

    @NotNull
    @Override
    public IndustrialPrimitiveBlastFurnaceLogic getRecipeLogic() {
        return (IndustrialPrimitiveBlastFurnaceLogic) super.getRecipeLogic();
    }

    protected GTRecipe getCoalRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.gem, GTMaterials.Coal))
                .buildRawRecipe();
    }

    protected GTRecipe getCoalDustRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.dust, GTMaterials.Coal))
                .buildRawRecipe();
    }

    protected GTRecipe getCoalBlockRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.block, GTMaterials.Coal))
                .buildRawRecipe();
    }

    protected GTRecipe getCharcoalRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.gem, GTMaterials.Charcoal))
                .buildRawRecipe();
    }

    protected GTRecipe getCharcoalDustRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.dust, GTMaterials.Charcoal))
                .buildRawRecipe();
    }

    protected GTRecipe getCharcoalBlockRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.block, GTMaterials.Charcoal))
                .buildRawRecipe();
    }

    protected GTRecipe getCokeRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.gem, GTMaterials.Coke))
                .buildRawRecipe();
    }

    protected GTRecipe getCokeDustRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.dust, GTMaterials.Coke))
                .buildRawRecipe();
    }

    protected GTRecipe getCokeBlockRecipe() {
        return GTRecipeBuilder.ofRaw()
                .inputItems(ChemicalHelper.get(TagPrefix.block, GTMaterials.Coke))
                .buildRawRecipe();
    }


    public boolean consumeFuel() {
        if (getCoalRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 100 * efficiency / 100;
            return true;
        }
        if (getCoalDustRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 100 * efficiency / 100;
            return true;
        }
        if (getCoalBlockRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 1000 * efficiency / 100;
            return true;
        }
        if (getCharcoalRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 100 * efficiency / 100;
            return true;
        }
        if (getCharcoalDustRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 100 * efficiency / 100;
            return true;
        }
        if (getCharcoalBlockRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 1000 * efficiency / 100;
            return true;
        }

        return false;
    }

    public boolean consumeFuelCoke() {
        if (getCokeRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 200 * efficiency / 100;
            return true;
        }
        if (getCokeDustRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 200 * efficiency / 100;
            return true;
        }
        if (getCokeBlockRecipe().handleRecipeIO(IO.IN, this, this.recipeLogic.getChanceCaches())) {
            fuel = 2000 * efficiency / 100;
            return true;
        }
        getRecipeLogic().coke = false;
        return false;
    }


    public int getEfficiency() {
        this.efficiency = (int) ((((-Math.atan(size / 4.0 / PI - 64 / 4.0 / PI / 2) + (PI / 2)) / PI + ((-Math.atan(64 / 4.0 / PI / 2) + PI / 2) / PI) / 2)) * 100.0);
        return efficiency;
    }
}

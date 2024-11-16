package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.machine.trait.CosmicRayDetectorLogic;
import com.eve.examplemod.common.machine.trait.VOMLogic;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CosmicRayDetector extends WorkableElectricMultiblockMachine {

    private int height;

    public CosmicRayDetector(IMachineBlockEntity holder) {
        super(holder);
    }


    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new CosmicRayDetectorLogic(this);
    }

    @NotNull
    @Override
    public CosmicRayDetectorLogic getRecipeLogic() {
        return (CosmicRayDetectorLogic) super.getRecipeLogic();
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        height = getPos().getY();
    }


    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable(String.valueOf(getAmount())));
        textList.add(Component.translatable(String.valueOf(height)));
    }

    public int getAmount() {
        double amount = Math.min(((double) height) / (256-5), 1);
        amount = Math.max(amount, 0);
        amount *= 35;
        amount *= Math.pow(4,(getTier() - GTValues.UHV));
        amount += 15;
        return (int) amount;
    }
}

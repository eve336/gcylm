package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.machine.logic.EfficiencyLogic;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EfficiencyMachine extends WorkableElectricMultiblockMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(EfficiencyMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    public EfficiencyMachine(IMachineBlockEntity holder, int rampUpTime1, float startingSpeedPercent1, float restartSpeedPercent1, Object... args) {
        super(holder, args, rampUpTime1, startingSpeedPercent1, restartSpeedPercent1);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @NotNull
    @Override
    public EfficiencyLogic getRecipeLogic() {
        return (EfficiencyLogic) super.getRecipeLogic();
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        if (args.length > 2 && args[args.length - 3] instanceof Integer rampuptime && args[args.length - 2] instanceof Float start && args[args.length - 1] instanceof Float restart) {
            return new EfficiencyLogic(this, rampuptime, start, restart);
        }
        throw new IllegalArgumentException("EfficiencyMachine need args [rampuptime, startspeedpercent, restartspeedpercent] for initialization");
    }

//    @Override
//    public void onStructureInvalid() {
//        getRecipeLogic().ticks = (int) (rampUpTime * (startingSpeedPercent/100));
//        getRecipeLogic().Speed = startingSpeedPercent/100;
//        super.onStructureInvalid();
//    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("Speed: %.2f%%".formatted(getRecipeLogic().Speed * 100)));
    }

    @Override
    public boolean onWorking() {
        if (getRecipeLogic().ticks < getRecipeLogic().rampUpTime) {
            getRecipeLogic().ticks++;
            getRecipeLogic().Speed = (float) getRecipeLogic().ticks / getRecipeLogic().rampUpTime;
        }
        return super.onWorking();
    }
}

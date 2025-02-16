package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.machine.logic.EfficiencyLogic;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.WorkableTieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.common.machine.electric.MinerMachine;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EfficiencyMachine extends WorkableElectricMultiblockMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(EfficiencyMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    public final float startingSpeedPercent;

    public final float restartSpeedPercent;

    public final int rampUpTime;

    public EfficiencyMachine(IMachineBlockEntity holder, int rampUpTime, float startingSpeedPercent1, float restartSpeedPercent1) {
        super(holder);
        this.rampUpTime = rampUpTime;
        this.startingSpeedPercent = startingSpeedPercent1;
        this.restartSpeedPercent = restartSpeedPercent1;
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
        return new EfficiencyLogic(this);
    }







    @Override
    public void onStructureInvalid() {
        getRecipeLogic().ticks = (int) (rampUpTime * (startingSpeedPercent/100));
        getRecipeLogic().Speed = startingSpeedPercent/100;
        super.onStructureInvalid();
    }



    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("Speed: %.2f%%".formatted(getRecipeLogic().Speed * 100)));
    }

    @Override
    public boolean onWorking() {
        if (getRecipeLogic().ticks < rampUpTime) {
            getRecipeLogic().ticks++;
            getRecipeLogic().Speed = (float) getRecipeLogic().ticks / rampUpTime;
        }
        return super.onWorking();
    }
}

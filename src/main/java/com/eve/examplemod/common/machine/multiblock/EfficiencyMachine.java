package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.machine.logic.EfficiencyLogic;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EfficiencyMachine extends WorkableElectricMultiblockMachine {

    private final float startingSpeedPercent = 5;

    @Getter
    private final int rampUpTime;

    @Getter
    @Persisted
    public float Speed = startingSpeedPercent / 100;

    @Persisted
    @Setter
    private int ticks;

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("Speed: %.2f%%".formatted(Speed * 100)));
    }

    public EfficiencyMachine(IMachineBlockEntity holder, int rampUpTime) {
        super(holder);
        this.rampUpTime = rampUpTime;
        ticks = (int) (rampUpTime * (startingSpeedPercent/100));
    }



    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new EfficiencyLogic(this);
    }

    @NotNull
    @Override
    public EfficiencyLogic getRecipeLogic() {
        return (EfficiencyLogic) super.getRecipeLogic();
    }

    @Override
    public boolean onWorking() {
        if (ticks < rampUpTime) {
            ticks++;
            Speed = (float) ticks / rampUpTime;
        }
        return super.onWorking();
    }
}

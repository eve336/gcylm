package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.machine.trait.EfficiencyLogic;
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

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("Speed: " + ticks / rampUpTime));
    }

    public EfficiencyMachine(IMachineBlockEntity holder, int rampUpTime) {
        super(holder);
        this.rampUpTime = rampUpTime;
        ticks = this.rampUpTime / 5;
    }

    @Getter
    @Persisted
    public int Speed;

    // in ticks probably
    @Getter
    private final int rampUpTime;

    @Persisted
    @Setter
    private int ticks;


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
            Speed = rampUpTime / ticks;
        }
        return super.onWorking();
    }
}

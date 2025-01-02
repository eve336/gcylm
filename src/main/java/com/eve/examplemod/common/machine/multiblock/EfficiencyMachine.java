package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.machine.trait.EfficienyLogic;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class EfficiencyMachine extends WorkableElectricMultiblockMachine {





    public EfficiencyMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    public EfficiencyMachine(IMachineBlockEntity holder, int rampUpTime) {
        super(holder);
        this.rampUpTime = rampUpTime;
    }

    @Getter
    @Persisted
    public int Speed;

    // in ticks probably
    private int rampUpTime;

    @Persisted
    private int ticks = rampUpTime / 10;


    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new EfficienyLogic(this);
    }

    @NotNull
    @Override
    public EfficienyLogic getRecipeLogic() {
        return (EfficienyLogic) super.getRecipeLogic();
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

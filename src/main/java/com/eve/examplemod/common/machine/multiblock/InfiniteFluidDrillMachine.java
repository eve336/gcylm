package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.common.machine.logic.InfiniteFluidDrillLogic;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FluidDrillMachine;
import com.gregtechceu.gtceu.common.machine.trait.FluidDrillLogic;
import org.jetbrains.annotations.NotNull;

public class InfiniteFluidDrillMachine extends FluidDrillMachine {
    public InfiniteFluidDrillMachine(IMachineBlockEntity holder, int tier) {
        super(holder, tier);
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new InfiniteFluidDrillLogic(this);
    }

    @NotNull
    @Override
    public FluidDrillLogic getRecipeLogic() {
        return (InfiniteFluidDrillLogic) super.getRecipeLogic();
    }
}

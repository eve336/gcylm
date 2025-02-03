package com.eve.examplemod.common.machine.logic;

import com.gregtechceu.gtceu.common.machine.multiblock.electric.FluidDrillMachine;
import com.gregtechceu.gtceu.common.machine.trait.FluidDrillLogic;

public class InfiniteFluidDrillLogic extends FluidDrillLogic {
    public InfiniteFluidDrillLogic(FluidDrillMachine machine) {
        super(machine);
    }

    @Override
    protected void depleteVein() {
    }
}

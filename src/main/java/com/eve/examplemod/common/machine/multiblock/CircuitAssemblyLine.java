package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.api.capability.IComponentPart;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.AssemblyLineMachine;

public class CircuitAssemblyLine extends AssemblyLineMachine {
    public CircuitAssemblyLine(IMachineBlockEntity holder) {
        super(holder);
    }
    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        int minTier = tier;
        for (IMultiPart part : getParts()) {
            if (part instanceof IComponentPart component){
                minTier = Math.min(minTier, component.getTier());
            }
        }
        tier = minTier;
    }

}

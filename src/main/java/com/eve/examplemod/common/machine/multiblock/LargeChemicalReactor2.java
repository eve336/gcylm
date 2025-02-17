package com.eve.examplemod.common.machine.multiblock;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.common.block.CoilBlock;

public class LargeChemicalReactor2 extends EfficiencyMachine {
    private ICoilType coilType = CoilBlock.CoilType.CUPRONICKEL;
    public LargeChemicalReactor2(IMachineBlockEntity holder, int rampUpTime1, float startingSpeedPercent1, float restartSpeedPercent1, Object... args) {
        super(holder, rampUpTime1, startingSpeedPercent1, restartSpeedPercent1, args);
    }
    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var type = getMultiblockState().getMatchContext().get("CoilType");
        if (type instanceof ICoilType coil) {
            this.coilType = coil;
        }
    }
    public int getCoilTier() {
        return coilType.getTier();
    }

    public ICoilType getCoilType() {
        return this.coilType;
    }
}

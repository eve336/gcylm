package com.eve.examplemod.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.eve.examplemod.api.capability.IComponentPart;
import lombok.Getter;

public class ComponentPartBlock extends MultiblockPartMachine implements IComponentPart{



    @Getter
    public int Tier;

    public ComponentPartBlock(IMachineBlockEntity holder, int Tier) {
        super(holder);
        this.Tier = Tier;
    }
}

package com.eve.examplemod.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.eve.examplemod.api.capability.IComponentPart;
import lombok.Getter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;

@Getter
public class ComponentPartBlock extends MultiblockPartMachine implements IComponentPart{


    public int Tier;

    public ComponentPartBlock(IMachineBlockEntity holder, int Tier) {
        super(holder);
        this.Tier = Tier;
    }

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        return false;
    }
}

package com.eve.examplemod.api.pattern;

import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pipenet.IPipeNode;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.world.level.block.entity.BlockEntity;

public class EVPredicates {
    public static TraceabilityPredicate pipes(){
    new TraceabilityPredicate(blockWorldState -> {
        BlockEntity tileEntity = blockWorldState.getTileEntity();
        return (tileEntity instanceof IPipeNode<?, ?> pipeNode);
    }, () -> {
        return new BlockInfo[0];
    });
        return null;
    }
}

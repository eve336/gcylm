package com.eve.examplemod.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.eve.examplemod.api.capability.IComponentPart;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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


    @Override
    public @NotNull BlockState getBlockAppearance(BlockState state, BlockAndTintGetter level, BlockPos pos, Direction side, BlockState sourceState, BlockPos sourcePos) {
//        return super.getBlockAppearance(state, level, pos, side, sourceState, sourcePos);
        var appearance = getCoverContainer().getBlockAppearance(state, level, pos, side, sourceState, sourcePos);
        if (appearance != null) return appearance;
        return getDefinition().getAppearance().get();
    }

    @Override
    public boolean replacePartModelWhenFormed() {
//        return super.replacePartModelWhenFormed();
        return false;
    }
}

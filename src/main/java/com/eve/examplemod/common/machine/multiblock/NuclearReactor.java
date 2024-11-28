package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.api.capability.IFuelCell;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.machine.multiblock.electric.CleanroomMachine.MIN_DEPTH;
import static com.gregtechceu.gtceu.common.machine.multiblock.electric.CleanroomMachine.MIN_RADIUS;

public class NuclearReactor extends WorkableElectricMultiblockMachine {

    private int fuelCells;
    private int totalHeat;
    private TickableSubscription serverTickEvent;



    @Persisted
    private int lDist = 0;
    @Persisted
    private int rDist = 0;
    @Persisted
    private int bDist = 0;
    @Persisted
    private int fDist = 0;
    @Persisted
    private int hDist = 0;

    public List<IFuelCell> iFuelCells;


    public NuclearReactor(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void onStructureFormed() {
        updateServerTickSubscription();
        fuelCells = 0;
        totalHeat = 0;
        super.onStructureFormed();
        for (IMultiPart part : getParts()) {
            if (part instanceof IFuelCell){
                fuelCells++;
            }
        }
        iFuelCells = getParts().stream()
                .filter(p -> p instanceof IFuelCell).map(IFuelCell.class::cast)
                .toList();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if(!isRemote() && isFormed()) {
            updateServerTickSubscription();
        }

    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        fuelCells = 0;
        totalHeat = 0;
        iFuelCells = null;
    }



    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable(String.valueOf(fuelCells)));
        textList.add(Component.translatable("Total Heat: " + String.valueOf(totalHeat)));
    }

    private void updateServerTickSubscription() {
        serverTickEvent = this.subscribeServerTick(serverTickEvent, this::serverTickEvent);
    }

    private void serverTickEvent() {
        totalHeat = 0;
        for (IFuelCell cell : iFuelCells){
            totalHeat = totalHeat + cell.getHeat();
        }
    }



    public boolean isBlockEdge(@NotNull Level world, @NotNull BlockPos.MutableBlockPos pos, @NotNull Direction direction) {
        return world.getBlockState(pos.move(direction)) == GTBlocks.PLASTCRETE.getDefaultState();
    }


    public boolean isBlockFloor(@NotNull Level world, @NotNull BlockPos.MutableBlockPos pos, @NotNull Direction direction) {
        return isBlockEdge(world, pos, direction) || world.getBlockState(pos) == GTBlocks.CLEANROOM_GLASS.getDefaultState();
    }


    public void updateStructureDimensions() {
        Level world = getLevel();
        Direction front = getFrontFacing();
        Direction back = front.getOpposite();
        Direction left = front.getCounterClockWise();
        Direction right = left.getOpposite();
        BlockPos.MutableBlockPos lPos = getPos().mutable();
        BlockPos.MutableBlockPos rPos = getPos().mutable();
        BlockPos.MutableBlockPos fPos = getPos().mutable();
        BlockPos.MutableBlockPos bPos = getPos().mutable();
        BlockPos.MutableBlockPos hPos = getPos().mutable();
        // find the distances from the controller to the plascrete blocks on one horizontal axis and the Y axis
        // repeatable aisles take care of the second horizontal axis
        int lDist = 0;
        int rDist = 0;
        int bDist = 0;
        int fDist = 0;
        int hDist = 0;
        // find the left, right, back, and front distances for the structure pattern
        // maximum size is 15x15x15 including walls, so check 7 block radius around the controller for blocks
        for (int i = 1; i < 8; i++) {
            if (lDist == 0 && isBlockEdge(world, lPos, left)) lDist = i;
            if (rDist == 0 && isBlockEdge(world, rPos, right)) rDist = i;
            if (bDist == 0 && isBlockEdge(world, bPos, back)) bDist = i;
            if (fDist == 0 && isBlockEdge(world, fPos, front)) fDist = i;
            if (lDist != 0 && rDist != 0 && bDist != 0 && fDist != 0) break;
        }
        // height is diameter instead of radius, so it needs to be done separately
        for (int i = 1; i < 15; i++) {
            if (isBlockFloor(world, hPos, Direction.DOWN)) hDist = i;
            if (hDist != 0) break;
        }
        if (lDist < MIN_RADIUS || rDist < MIN_RADIUS || bDist < MIN_RADIUS || fDist < MIN_RADIUS || hDist < MIN_DEPTH) {
            this.isFormed = false;
            return;
        }
        this.lDist = lDist;
        this.rDist = rDist;
        this.bDist = bDist;
        this.fDist = fDist;
        this.hDist = hDist;
    }

    @NotNull
    protected BlockState getCasingState() {
        return GTBlocks.PLASTCRETE.getDefaultState();
    }

    @NotNull
    protected BlockState getGlassState() {
        return GTBlocks.CLEANROOM_GLASS.getDefaultState();
    }

    @NotNull
    @Override
    public BlockPattern getPattern() {
        // return the default structure, even if there is no valid size found
        // this means auto-build will still work, and prevents terminal crashes.
        if (getLevel() != null) updateStructureDimensions();
        // these can sometimes get set to 0 when loading the game, breaking JEI
        if (lDist < MIN_RADIUS) lDist = MIN_RADIUS;
        if (rDist < MIN_RADIUS) rDist = MIN_RADIUS;
        if (bDist < MIN_RADIUS) bDist = MIN_RADIUS;
        if (fDist < MIN_RADIUS) fDist = MIN_RADIUS;
        if (hDist < MIN_DEPTH) hDist = MIN_DEPTH;
        if (this.getFrontFacing() == Direction.EAST || this.getFrontFacing() == Direction.WEST) {
            int tmp = lDist;
            lDist = rDist;
            rDist = tmp;
        }
        // build each row of the structure
        StringBuilder borderBuilder = new StringBuilder(); // BBBBB
        StringBuilder wallBuilder = new StringBuilder(); // BXXXB
        StringBuilder insideBuilder = new StringBuilder(); // X X
        StringBuilder roofBuilder = new StringBuilder(); // BFFFB
        StringBuilder controllerBuilder = new StringBuilder(); // BFSFB
        StringBuilder centerBuilder = new StringBuilder(); // BXKXB
        // everything to the left of the controller
        for (int i = 0; i < lDist; i++) {
            borderBuilder.append("B");
            if (i == 0) {
                wallBuilder.append("B");
                insideBuilder.append("X");
                roofBuilder.append("B");
                controllerBuilder.append("B");
                centerBuilder.append("B");
            } else {
                insideBuilder.append(" ");
                wallBuilder.append("X");
                roofBuilder.append("F");
                controllerBuilder.append("F");
                centerBuilder.append("X");
            }
        }
        // everything in-line with the controller
        borderBuilder.append("B");
        wallBuilder.append("X");
        insideBuilder.append(" ");
        roofBuilder.append("F");
        controllerBuilder.append("S");
        centerBuilder.append("K");
        // everything to the right of the controller
        for (int i = 0; i < rDist; i++) {
            borderBuilder.append("B");
            if (i == rDist - 1) {
                wallBuilder.append("B");
                insideBuilder.append("X");
                roofBuilder.append("B");
                controllerBuilder.append("B");
                centerBuilder.append("B");
            } else {
                insideBuilder.append(" ");
                wallBuilder.append("X");
                roofBuilder.append("F");
                controllerBuilder.append("F");
                centerBuilder.append("X");
            }
        }
        // build each slice of the structure
        String[] wall = new String[hDist + 1]; // "BBBBB", "BXXXB", "BXXXB", "BXXXB", "BBBBB"
        Arrays.fill(wall, wallBuilder.toString());
        wall[0] = borderBuilder.toString();
        wall[wall.length - 1] = borderBuilder.toString();
        String[] slice = new String[hDist + 1]; // "BXXXB", "X X", "X X", "X X", "BFFFB"
        Arrays.fill(slice, insideBuilder.toString());
        slice[0] = wallBuilder.toString();
        slice[slice.length - 1] = roofBuilder.toString();
        String[] center = Arrays.copyOf(slice, slice.length); // "BXKXB", "X X", "X X", "X X", "BFSFB"
        if (this.getFrontFacing() == Direction.NORTH || this.getFrontFacing() == Direction.SOUTH) {
            center[0] = centerBuilder.reverse().toString();
            center[center.length - 1] = controllerBuilder.reverse().toString();
        } else {
            center[0] = centerBuilder.toString();
            center[center.length - 1] = controllerBuilder.toString();
        }
        TraceabilityPredicate wallPredicate = states(getCasingState(), getGlassState());
        TraceabilityPredicate basePredicate = Predicates.abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2)
                .or(autoAbilities(getRecipeType()));
        // layer the slices one behind the next
        return  // the block beneath the controller must only be a casing for structure
                // dimension checks
                FactoryBlockPattern.start().aisle(wall).aisle(slice).setRepeatable(bDist - 1).aisle(center).aisle(slice).setRepeatable(fDist - 1).aisle(wall).where('S', Predicates.controller(Predicates.blocks(this.getDefinition().get()))).where('B', states(getCasingState()).or(basePredicate)).where('X', wallPredicate.or(basePredicate).or(abilities(PartAbility.PASSTHROUGH_HATCH).setMaxGlobalLimited(30))).where('K', wallPredicate).where('F', Predicates.cleanroomFilters()).where(' ', any().or(abilities(EVPartAbility.FUEL_CELL))).build();


    }
}

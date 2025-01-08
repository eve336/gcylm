package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.api.capability.IFuelCell;
import com.eve.examplemod.common.machine.multiblock.part.PassiveCooler;
import com.eve.examplemod.config.EVConfig;
import com.gregtechceu.gtceu.api.block.IMachineBlock;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pipenet.IPipeNode;
import com.gregtechceu.gtceu.common.block.FluidPipeBlock;
import com.gregtechceu.gtceu.common.blockentity.FluidPipeBlockEntity;
import com.gregtechceu.gtceu.common.blockentity.ItemPipeBlockEntity;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlockEntities.FLUID_PIPE;
import static com.gregtechceu.gtceu.common.machine.multiblock.electric.CleanroomMachine.MIN_DEPTH;
import static com.gregtechceu.gtceu.common.machine.multiblock.electric.CleanroomMachine.MIN_RADIUS;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.capability.GTCapabilityHelper;
import com.gregtechceu.gtceu.api.capability.ICleanroomReceiver;
import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.SimpleGeneratorMachine;
import com.gregtechceu.gtceu.api.machine.feature.ICleanroomProvider;
import com.gregtechceu.gtceu.api.machine.feature.IDataInfoProvider;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMaintenanceMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMufflerMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.misc.EnergyContainerList;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.item.PortableScannerBehavior;
import com.gregtechceu.gtceu.common.machine.electric.HullMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.generator.LargeCombustionEngineMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.generator.LargeTurbineMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DiodePartMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.CokeOvenMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveBlastFurnaceMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitivePumpMachine;
import com.gregtechceu.gtceu.common.machine.trait.CleanroomLogic;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.utils.GTUtil;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.BlockInfo;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;

public class NuclearReactor extends WorkableElectricMultiblockMachine {

    private int fuelCells;
    private int totalHeat;
    private TickableSubscription serverTickEvent;
    int temp = 0;



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

    public List<IFuelCell> iFuelCells = new ArrayList<>();


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
        iFuelCells = new ArrayList<>();
    }



    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("Fuel Cells: " + fuelCells));
        textList.add(Component.translatable("Total Heat: " + totalHeat));
    }

    private void updateServerTickSubscription() {
        serverTickEvent = this.subscribeServerTick(serverTickEvent, this::serverTickEvent);
    }

    private void serverTickEvent() {
        if (iFuelCells != null && isFormed() && (recipeLogic.isIdle() || !recipeLogic.isWorking())){
            if (!iFuelCells.isEmpty()){
                totalHeat = 0;
                iFuelCells.forEach(c -> {
                    totalHeat = totalHeat + c.getHeat();
                });
            }
        }
    }

    @Override
    public boolean onWorking() {
        if (recipeLogic.getLastRecipe() != null) {
            temp = recipeLogic.getLastRecipe().data.getInt("temperature");
        }
        totalHeat = 0;
        if (iFuelCells != null) {
            if (isFormed() && !iFuelCells.isEmpty() && isActive() && recipeLogic.isWorking() && !recipeLogic.isIdle()) {
                for (IFuelCell cell : iFuelCells) {
                    // remove get offset timer if it doesnt work
                    if (getOffsetTimer() % 20 == 0) {
                        cell.changeHeat(temp);
                    }
                    totalHeat = totalHeat + cell.getHeat();
                    // it stopped after 4 recipes (5 seconds) and me timing 20 seconds so i think it works
                    // shut up grammarly
                    if (cell.getHeat() > (temp * EVConfig.INSTANCE.reactorMeltdownTime)) {
                        recipeLogic.setWorkingEnabled(false);
                    }
                }
            }
        }
        return super.onWorking();
    }

    public boolean isBlockEdge(@NotNull Level world, @NotNull BlockPos.MutableBlockPos pos, @NotNull Direction direction) {
        return world.getBlockState(pos.move(direction)) == GTBlocks.CASING_TITANIUM_STABLE.getDefaultState();
    }


    public boolean isBlockFloor(@NotNull Level world, @NotNull BlockPos.MutableBlockPos pos, @NotNull Direction direction) {
        return isBlockEdge(world, pos, direction) || world.getBlockState(pos) == GTBlocks.CASING_LAMINATED_GLASS.getDefaultState();
    }


    // troll laugh

    public void updateStructureDimensions() {
        Level world = getLevel();
        if (world == null) return;
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

        if (Math.abs(lDist - rDist) > 1 || Math.abs(bDist - fDist) > 1) {
            this.isFormed = false;
            return;
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
        return GTBlocks.CASING_TITANIUM_STABLE.getDefaultState();
    }

    @NotNull
    protected BlockState getGlassState() {
        return GTBlocks.CASING_LAMINATED_GLASS.getDefaultState();
    }

    private TraceabilityPredicate getValidFloorBlocks() {
        return states(GTBlocks.CASING_TITANIUM_STABLE.getDefaultState(), GTBlocks.PLASTCRETE.getDefaultState());
//        return Predicates.blockTag(CustomTags.CLEANROOM_FLOORS);
    }

    @NotNull
    protected TraceabilityPredicate innerPredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            Set<ICleanroomReceiver> receivers = blockWorldState.getMatchContext().getOrCreate("cleanroomReceiver",
                    Sets::newHashSet);
            // all non-GTMachines are allowed inside by default
            BlockEntity blockEntity = blockWorldState.getTileEntity();
//            if (blockEntity instanceof IMachineBlockEntity machineBlockEntity) {
//                var machine = machineBlockEntity.getMetaMachine();
//            }
            // wanna check if this how to allow pipes inside
//            if (blockEntity instanceof ItemPipeBlockEntity || blockEntity instanceof  FluidPipeBlockEntity){
//               return true;
//            }
            if (blockEntity != null) {
                var receiver = GTCapabilityHelper.getCleanroomReceiver(blockWorldState.getWorld(),
                        blockWorldState.getPos(), null);
                if (receiver != null) {
                    receivers.add(receiver);
                }
            }
            return true;
        }, null) {

            @Override
            public boolean isAny() {
                return true;
            }

            @Override
            public boolean addCache() {
                return true;
            }
        };
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

        StringBuilder[] floorLayer = new StringBuilder[fDist + bDist + 1];
        List<StringBuilder[]> wallLayers = new ArrayList<>();
        StringBuilder[] ceilingLayer = new StringBuilder[fDist + bDist + 1];

        for (int i = 0; i < floorLayer.length; i++) {
            floorLayer[i] = new StringBuilder(lDist + rDist + 1);
            ceilingLayer[i] = new StringBuilder(lDist + rDist + 1);
        }

        for (int i = 0; i < hDist - 1; i++) {
            wallLayers.add(new StringBuilder[fDist + bDist + 1]);
            for (int j = 0; j < fDist + bDist + 1; j++) {
                var s = new StringBuilder(lDist + rDist + 1);
                wallLayers.get(i)[j] = s;
            }
        }

        for (int i = 0; i < lDist + rDist + 1; i++) {
            for (int j = 0; j < fDist + bDist + 1; j++) {
                if (i == 0 || i == lDist + rDist || j == 0 || j == fDist + bDist) { // all edges
                    floorLayer[j].append('A'); // floor edge
                    for (int k = 0; k < hDist - 1; k++) {
                        wallLayers.get(k)[j].append('W'); // walls
                    }
                    ceilingLayer[j].append('D'); // ceiling edge
                } else { // not edges
                    if (i == lDist && j == fDist) { // very center
                        floorLayer[j].append('K');
                    } else {
                        floorLayer[j].append('E'); // floor valid blocks
                    }
                    for (int k = 0; k < hDist - 1; k++) {
                        wallLayers.get(k)[j].append(' ');
                    }
                    if (i == lDist && j == fDist) { // very center
                        ceilingLayer[j].append('C'); // controller
                    } else {
                        ceilingLayer[j].append('F'); // filter
                    }
                }
            }
        }

        String[] f = new String[bDist + fDist + 1];
        for (int i = 0; i < floorLayer.length; i++) {
            f[i] = floorLayer[i].toString();
        }
        String[] m = new String[bDist + fDist + 1];
        for (int i = 0; i < wallLayers.get(0).length; i++) {
            m[i] = wallLayers.get(0)[i].toString();
        }
        String[] c = new String[bDist + fDist + 1];
        for (int i = 0; i < ceilingLayer.length; i++) {
            c[i] = ceilingLayer[i].toString();
        }

        TraceabilityPredicate wallPredicate = states(getCasingState(), getGlassState());
        TraceabilityPredicate basePredicate = Predicates.abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1)
                .setMaxGlobalLimited(2)
                .or(Predicates.autoAbilities(getDefinition().getRecipeTypes()))
                .or(abilities(PartAbility.PASSTHROUGH_HATCH).setMaxGlobalLimited(30));

        return FactoryBlockPattern.start(LEFT, FRONT, UP)
                .aisle(f)
                .aisle(m).setRepeatable(wallLayers.size())
                .aisle(c)
                .where('C', Predicates.controller(Predicates.blocks(this.getDefinition().get())))
                .where('F', Predicates.cleanroomFilters())
                .where('D', states(getCasingState())) // ceiling edges
                .where(' ', innerPredicate())
                .where('E', wallPredicate.or(basePredicate) // inner floor
                        .or(getValidFloorBlocks().setMaxGlobalLimited(4)))
                .where('K', wallPredicate // very center floor, needed for height check
                        .or(getValidFloorBlocks()))
                .where('W', wallPredicate.or(basePredicate))// walls
                .where('A', wallPredicate.or(basePredicate)) // floor edges
                .build();
    }
}

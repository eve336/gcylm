package com.eve.examplemod.common.machine.multiblock;

import com.eve.examplemod.api.capability.IFuelCell;
import com.google.common.collect.Tables;
import com.gregtechceu.gtceu.api.capability.recipe.*;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.editor.EditableMachineUI;
import com.gregtechceu.gtceu.api.gui.editor.EditableUI;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.ui.GTRecipeTypeUI;
import com.lowdragmc.lowdraglib.gui.editor.configurator.ColorConfigurator;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.utils.Position;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;

import javax.crypto.Mac;
import java.awt.*;
import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiFunction;

public class GeckoMultiblock extends WorkableElectricMultiblockMachine {

    public List<IMultiPart> MachineBlockEntity;

    public Color color;


    public GeckoMultiblock(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static boolean recolorBlockState(Level level, BlockPos pos, DyeColor color) {
        BlockState state = level.getBlockState(pos);
        for (Property property : state.getProperties()) {
            if (property.getValueClass() == DyeColor.class) {
                state.setValue(property, color);
                return true;
            }
        }
        return false;
    }

    private boolean tryPaintSpecialBlock(Level world, BlockPos pos) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof IMachineBlockEntity machineBe) {
            MetaMachine mte = machineBe.getMetaMachine();
            if (mte != null) {
                if (mte.getPaintingColor() != color.getRGB()) {
                    mte.setPaintingColor(color.getRGB());
                    return true;
                } else return false;
            }
        }
        return false;
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        MachineBlockEntity = null;
    }


    @Override
    public void onStructureFormed() {

        color = Color.magenta;
        Level level = getLevel();
        super.onStructureFormed();
        this.tryPaintSpecialBlock(level, getPos());
        MachineBlockEntity = getParts().stream()
                .filter(p -> p instanceof IMultiPart).map(IMultiPart.class::cast)
                .toList();


        if (isFormed) {
        for (IMultiPart block : MachineBlockEntity){
            BlockPos pos = block.self().getPos();
            tryPaintSpecialBlock(level, pos);
        }
        }
    }
    public Widget createUIWidget() {
        WidgetGroup group =  new WidgetGroup(new Position(0, 0));
        group.addWidget(super.createUIWidget());
        group.addWidget(new LabelWidget(0, 0, "im a sigma"));
        // ME Network status
        // Config slots
        return group;
    }
}

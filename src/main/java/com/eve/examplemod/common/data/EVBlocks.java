package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.EVCoilBlock;
import com.eve.examplemod.common.block.explosive.LeptonicBlock;
import com.eve.examplemod.common.block.explosive.QCDBlock;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.block.explosive.IndustrialTNTBlock;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.gui.spectator.categories.TeleportToPlayerMenuCategory;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class EVBlocks {

    public static final BlockEntry<LeptonicBlock> LEPTONIC_CHARGE = EVRegistries.REGISTRATE
            .block("leptonic_charge", LeptonicBlock::new)
            .lang("Leptonic Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .tag(BlockTags.MINEABLE_WITH_AXE)
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/leptonic_charge_side"),
                    EVMain.id("block/misc/leptonic_charge_top_bottom"))))
            .simpleItem()
            .register();

    public static final BlockEntry<LeptonicBlock> NAQUADRIA_CHARGE = EVRegistries.REGISTRATE
            .block("naquadria_charge", LeptonicBlock::new)
            .lang("Naquadria Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .tag(BlockTags.MINEABLE_WITH_AXE)
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/naquadria_charge_side"),
                    EVMain.id("block/misc/naquadria_charge_top_bottom"))))
            .simpleItem()
            .register();

    public static final BlockEntry<LeptonicBlock> TARANIUM_CHARGE = EVRegistries.REGISTRATE
            .block("taranium_charge", LeptonicBlock::new)
            .lang("Taranium Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .tag(BlockTags.MINEABLE_WITH_AXE)
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/taranium_charge_side"),
                    EVMain.id("block/misc/taranium_charge_top_bottom"))))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SUPERHEAVY_BLOCK = EVRegistries.REGISTRATE
            .block("superheavy_block", Block::new)
            .lang("Super Heavy Block")
            .simpleItem()
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(),prov.models().cubeAll(ctx.getName(),
                    EVMain.id("block/superheavy_block")
                    )))
            .register();

    public static final BlockEntry<QCDBlock> QCD_CHARGE = EVRegistries.REGISTRATE
            .block("qcd_charge", QCDBlock::new)
            .lang("Quantum Chromodynamically Charged Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .tag(BlockTags.MINEABLE_WITH_AXE)
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/qcd_charge_side"),
                    EVMain.id("block/misc/qcd_charge_top_bottom"))))
            .simpleItem()
            .register();


    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType) {
        BlockEntry<CoilBlock> coilBlock = EVRegistries.REGISTRATE
                .block("%s_coil_block".formatted(coilType.getName()), p -> new CoilBlock(p, coilType))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createCoilModel("%s_coil_block".formatted(coilType.getName()), coilType))
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
        return coilBlock;
    }

    public static void init(){

    }
}

package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.block.explosive.LeptonicBlock;
import com.eve.examplemod.common.block.explosive.QCDBlock;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.GTModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    public static final BlockEntry<SaplingBlock> STRAIGHT_RUBBER_SAPLING = EVRegistries.REGISTRATE
            .block("straight_rubber_sapling", properties -> new SaplingBlock(new StraightRubberTreeGrower(), properties.noCollission()))
            .initialProperties(() -> Blocks.OAK_SAPLING)
            .lang("Straight Rubber Sapling")
            .blockstate(GTModels::createCrossBlockState)
            .addLayer(() -> RenderType::cutoutMipped)
            .tag(BlockTags.SAPLINGS)
            .item()
            .model(GTModels::rubberTreeSaplingModel)
            .build()
            .register();

//    public static final BlockEntry<SaplingBlock> skibidi = EVRegistries.REGISTRATE
//            .block("oak_sapling", new SaplingBlock(new StraightRubberTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
//
//    OAK_SAPLING = register("oak_sapling", new SaplingBlock(new OakTreeGrower(), Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));



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

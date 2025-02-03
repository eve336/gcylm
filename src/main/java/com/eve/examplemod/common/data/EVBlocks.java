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
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static com.eve.examplemod.api.registries.EVRegistries.REGISTRATE;

public class EVBlocks {

    public static final BlockEntry<LeptonicBlock> LEPTONIC_CHARGE = REGISTRATE
            .block("leptonic_charge", LeptonicBlock::new)
            .lang("Leptonic Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/leptonic_charge_side"),
                    EVMain.id("block/misc/leptonic_charge_top_bottom"))))
            .simpleItem()
            .register();

    public static final BlockEntry<LeptonicBlock> NAQUADRIA_CHARGE = REGISTRATE
            .block("naquadria_charge", LeptonicBlock::new)
            .lang("Naquadria Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/naquadria_charge_side"),
                    EVMain.id("block/misc/naquadria_charge_top_bottom"))))
            .simpleItem()
            .register();

    public static final BlockEntry<LeptonicBlock> TARANIUM_CHARGE = REGISTRATE
            .block("taranium_charge", LeptonicBlock::new)
            .lang("Taranium Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/taranium_charge_side"),
                    EVMain.id("block/misc/taranium_charge_top_bottom"))))
            .simpleItem()
            .register();



    public static final BlockEntry<QCDBlock> QCD_CHARGE = REGISTRATE
            .block("qcd_charge", QCDBlock::new)
            .lang("Quantum Chromodynamically Charged Charge")
            .properties(p -> p.mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava())
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeTop(ctx.getName(),
                    EVMain.id("block/misc/qcd_charge_side"),
                    EVMain.id("block/misc/qcd_charge_top_bottom"))))
            .simpleItem()
            .register();

    public static final BlockEntry<SaplingBlock> STRAIGHT_RUBBER_SAPLING = REGISTRATE
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

    public static final BlockEntry<Block> SUPERHEAVY_BLOCK = REGISTRATE
            .block("superheavy_block", Block::new)
            .lang("Super Heavy Block")
            .simpleItem()
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(),prov.models().cubeAll(ctx.getName(),
                    EVMain.id("block/superheavy_block")
            )))
            .register();

    // wetware farming :3
//    public static final BlockEntry<Spikes> SPIKES = EVRegistries.REGISTRATE
//            .block("spikes", Spikes::new)
//            .lang("Spikes")
//            .register();

//    public static final BlockEntry<CoilBlock> COIL_TITAN_STEEL = createCoilBlock(EVCoilBlock.CoilType.TITAN_STEEL);
//    public static final BlockEntry<CoilBlock> COIL_PIKYONIUM = createCoilBlock(EVCoilBlock.CoilType.PIKYONIUM);
//    public static final BlockEntry<CoilBlock> COIL_BLACK_TITANIUM = createCoilBlock(EVCoilBlock.CoilType.BLACK_TITANIUM);
//    public static final BlockEntry<CoilBlock> COIL_NEUTRONIUM = createCoilBlock(EVCoilBlock.CoilType.NEUTRONIUM);
//    public static final BlockEntry<CoilBlock> COIL_COSMIC_NEUTRONIUM = createCoilBlock(EVCoilBlock.CoilType.COSMIC_NEUTRONIUM);
//    public static final BlockEntry<CoilBlock> COIL_INFINITY = createCoilBlock(EVCoilBlock.CoilType.INFINITY);
//    public static final BlockEntry<CoilBlock> COIL_ETERNITY = createCoilBlock(EVCoilBlock.CoilType.ETERNITY);





    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType) {
        BlockEntry<CoilBlock> coilBlock = EVRegistries.REGISTRATE
                .block("%s_coil_block".formatted(coilType.getName()), p -> new CoilBlock(p, coilType))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(GTModels.createCoilModel("%s_coil_block".formatted(coilType.getName()), coilType))
                .tag(
                        //GTToolType.WRENCH.harvestTags.get(0),
                        BlockTags.MINEABLE_WITH_PICKAXE)
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
        return coilBlock;
    }


//    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType) {
//        BlockEntry<CoilBlock> coilBlock = REGISTRATE.block("%s_coil_block".formatted(coilType.getName()), p -> new CoilBlock(p, coilType))
//                .initialProperties(() -> Blocks.IRON_BLOCK)
//                .addLayer(() -> RenderType::cutoutMipped)
//                .blockstate(GTModels.createCoilModel("%s_coil_block".formatted(coilType.getName()), coilType))
//                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .item(BlockItem::new)
//                .build()
//                .register();
//        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
//        return coilBlock;
//    }
//    private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType, IRenderer renderer, IRenderer activeRenderer) {
//        BlockEntry<CoilBlock> coilBlock = REGISTRATE.block("%s_coil_block".formatted(coilType.getName()), p -> (CoilBlock) new CosmicCoilBlock(p, coilType, renderer, activeRenderer))
//                .initialProperties(() -> Blocks.IRON_BLOCK)
//                .addLayer(() -> RenderType::translucent)
//                .blockstate(NonNullBiConsumer.noop())
//                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .item(BlockItem::new)
//                .model(NonNullBiConsumer.noop())
//                .build()
//                .register();
//        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
//        return coilBlock;
//    }

    public static void init(){

    }
}

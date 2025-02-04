package com.eve.examplemod.common.data.machines;

import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.machine.multiblock.InfiniteFluidDrillMachine;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FluidDrillMachine;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.network.chat.Component;

import java.util.Locale;
import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;

public class EVMultiMachines {

    public static final MultiblockMachineDefinition[] INFINITE_FLUID_DRILLING_RIG = registerTieredMultis(
            "infinite_fluid_drilling_rig", InfiniteFluidDrillMachine::new,
            (tier, builder) -> builder
                    .rotationState(RotationState.ALL)
                    .langValue(VCF[tier] + "Infinite Fluid Drilling Rig " + VLVT[tier])
//                    .langValue("%s Infinite Fluid Drilling Rig %s".formatted(VLVH[tier], VLVT[tier]))
                    .recipeType(DUMMY_RECIPES)
                    .tooltips(
                            Component.translatable("gtceu.machine.fluid_drilling_rig.description"),
                            Component.translatable("gtceu.machine.fluid_drilling_rig.depletion",
                                    FormattingUtil.formatNumbers(0)),
                            Component.translatable("gtceu.universal.tooltip.energy_tier_range", GTValues.VNF[tier],
                                    GTValues.VNF[tier + 1]),
                            Component.translatable("gtceu.machine.fluid_drilling_rig.production",
                                    FluidDrillMachine.getRigMultiplier(tier),
                                    FormattingUtil.formatNumbers(FluidDrillMachine.getRigMultiplier(tier) * 1.5)))
                    .appearanceBlock(() -> FluidDrillMachine.getCasingState(tier))
                    .pattern((definition) -> FactoryBlockPattern.start()
                            .aisle("XXX", "#F#", "#F#", "#F#", "###", "###", "###")
                            .aisle("XXX", "FCF", "FCF", "FCF", "#F#", "#F#", "#F#")
                            .aisle("XSX", "#F#", "#F#", "#F#", "###", "###", "###")
                            .where('S', controller(blocks(definition.get())))
                            .where('X', blocks(FluidDrillMachine.getCasingState(tier)).setMinGlobalLimited(3)
                                    .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1)
                                            .setMaxGlobalLimited(2))
                                    .or(abilities(PartAbility.EXPORT_FLUIDS).setMaxGlobalLimited(1)))
                            .where('C', blocks(FluidDrillMachine.getCasingState(tier)))
                            .where('F', blocks(FluidDrillMachine.getFrameState(tier)))
                            .where('#', any())
                            .build())
                    .workableCasingRenderer(FluidDrillMachine.getBaseTexture(tier),
                            GTCEu.id("block/multiblock/fluid_drilling_rig"))
                    .register(),
            MV, HV, EV);

    public static MultiblockMachineDefinition[] registerTieredMultis(String name,
                                                                     BiFunction<IMachineBlockEntity, Integer, MultiblockControllerMachine> factory,
                                                                     BiFunction<Integer, MultiblockMachineBuilder, MultiblockMachineDefinition> builder,
                                                                     int... tiers) {
        MultiblockMachineDefinition[] definitions = new MultiblockMachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = EVRegistries.REGISTRATE
                    .multiblock(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static void init(){

    }
}

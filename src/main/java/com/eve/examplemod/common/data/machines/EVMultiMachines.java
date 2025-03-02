package com.eve.examplemod.common.data.machines;

import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.data.EVRecipeModifiers;
import com.eve.examplemod.common.data.EVRecipeTypes;
import com.eve.examplemod.common.machine.multiblock.EVPartAbility;
import com.eve.examplemod.common.machine.multiblock.InfiniteFluidDrillMachine;
import com.eve.examplemod.common.machine.multiblock.LargeChemicalReactor2;
import com.eve.examplemod.common.machine.multiblock.primitive.IndustrialPrimitiveBlastFurnace;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FluidDrillMachine;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.BiFunction;

import static com.eve.examplemod.api.registries.EVRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.machine.multiblock.PartAbility.INPUT_ENERGY;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GCYMBlocks.CASING_LARGE_SCALE_ASSEMBLING;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.NaquadahAlloy;
import static com.gregtechceu.gtceu.common.data.GTMaterials.StainlessSteel;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;

public class EVMultiMachines {

    // todo make it so you can use stainless steel casings for lgts since turbine casings arent even harder, theyre just bloat content

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

    public static final MultiblockMachineDefinition EV_CHEMICAL_REACTOR = REGISTRATE
            .multiblock("ev_chemical_reactor", holder -> new LargeChemicalReactor2(holder, 4500, 10, 2))
            .rotationState(RotationState.ALL)
            .langValue("Large Chemical Reactor")
            .tooltips(Component.translatable("examplemod.chemical_reactor.tooltip"))
            .recipeType(GTRecipeTypes.LARGE_CHEMICAL_RECIPES)
            .recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK_SUBTICK), EVRecipeModifiers::lcrOverclock)
            .appearanceBlock(CASING_PTFE_INERT)
            .pattern(definition -> {
                var casing = blocks(CASING_PTFE_INERT.get()).setMinGlobalLimited(10);
                var abilities = Predicates.autoAbilities(definition.getRecipeTypes())
                        .or(Predicates.autoAbilities(false, false, false));
                return FactoryBlockPattern.start()
                        .aisle("XXX", "XCX", "XXX")
                        .aisle("XCX", "CPC", "XCX")
                        .aisle("XXX", "XSX", "XXX")
                        .where('S', Predicates.controller(blocks(definition.getBlock())))
                        .where('X', casing.or(abilities))
                        .where('P', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                        .where('C', heatingCoils().setExactLimit(1)
                                .or(abilities)
                                .or(casing))
                        .build();
            })

            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                var baseBuilder = MultiblockShapeInfo.builder()
                        .where('S', definition, Direction.NORTH)
                        .where('X', CASING_PTFE_INERT.getDefaultState())
                        .where('P', CASING_POLYTETRAFLUOROETHYLENE_PIPE.getDefaultState())
                        .where('C', COIL_CUPRONICKEL.getDefaultState())
                        .where('I', ITEM_IMPORT_BUS[3], Direction.NORTH)
                        .where('E', ENERGY_INPUT_HATCH[3], Direction.NORTH)
                        .where('O', ITEM_EXPORT_BUS[3], Direction.NORTH)
                        .where('F', FLUID_IMPORT_HATCH[3], Direction.NORTH)
                        .where('M', MAINTENANCE_HATCH, Direction.NORTH)
                        .where('H', FLUID_EXPORT_HATCH[3], Direction.NORTH);
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XXX")
                        .aisle("XXX", "XPX", "XXX")
                        .aisle("XEX", "XCX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XXX")
                        .aisle("XXX", "XPX", "XCX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XXX")
                        .aisle("XCX", "XPX", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XXX")
                        .aisle("XXX", "CPX", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XXX")
                        .aisle("XXX", "XPC", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                return shapeInfo;
            })
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_inert_ptfe"),
                    GTCEu.id("block/multiblock/large_chemical_reactor"))
            .register();

    public static final MultiblockMachineDefinition INDUSTRIAL_PRIMITIVE_BLAST_FURNACE = REGISTRATE
            .multiblock("industrial_primitive_blast_furnace", IndustrialPrimitiveBlastFurnace::new)
            .langValue("Industrial Primitive Blast Furnace")
            .tooltips(Component.translatable("examplemod.industrial_primitive_blast_furnace"))
            .rotationState(RotationState.ALL)
            .recipeType(DUMMY_RECIPES)
            .alwaysTryModifyRecipe(true)
            .recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK))
            .appearanceBlock(CASING_PRIMITIVE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, UP, BACK)
                    .aisle("FFF", "FSF", "FFF", "FFF")
                    .aisle("FFF", "I#I", "F#F", "F#F").setRepeatable(1, 64)
                    .aisle("FFF", "FOF", "FFF", "FFF")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('F', blocks(CASING_PRIMITIVE_BRICKS.get()))
                    .where('O',blocks(ITEM_EXPORT_BUS[1].getBlock()))
                    .where('I', blocks(ITEM_IMPORT_BUS[1].getBlock()).setMaxLayerLimited(1).setMinLayerLimited(1).or(blocks(CASING_PRIMITIVE_BRICKS.get())))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                    GTCEu.id("block/multiblock/primitive_blast_furnace"))
            .register();


    // todo i dont know i kinda wanna change it bc its ugly as all hell
    public static final MultiblockMachineDefinition DESULFURISER = REGISTRATE
            .multiblock("desulfuriser", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .langValue("Desulfuriser")
            .recipeType(EVRecipeTypes.DESULFURISER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK_SUBTICK))
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> {
                var casing = blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(4);
                var abilities = Predicates.autoAbilities(definition.getRecipeTypes()).or(abilities(PartAbility.INPUT_ENERGY))
                        .or(Predicates.autoAbilities(false, false, false));
                return FactoryBlockPattern.start()
                        .aisle("FF", "PP", "XX", "XX", "XX")
                        .aisle("FF", "SP", "XX", "XX", "XX")
                        .where('S', Predicates.controller(blocks(definition.getBlock())))
                        .where('X', casing.or(abilities))
                        .where('P', blocks(CASING_STEEL_PIPE.get()))
                        .where('F', blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, StainlessSteel)))
//                        .where('C', heatingCoils().setExactLimit(1)
//                                .or(abilities)
//                                .or(casing))
                        .build();
            })
            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                var baseBuilder = MultiblockShapeInfo.builder()
                        .where('S', definition, Direction.NORTH)
                        .where('X', CASING_STAINLESS_CLEAN.getDefaultState())
                        .where('P', CASING_STEEL_PIPE.getDefaultState())
                        .where('E', ENERGY_INPUT_HATCH[3], Direction.NORTH)
                        .where('I', FLUID_IMPORT_HATCH[3], Direction.NORTH)
                        .where('F', ChemicalHelper.getBlock(TagPrefix.frameGt, StainlessSteel))
                        .where('H', FLUID_EXPORT_HATCH[3], Direction.NORTH);
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("FF", "SP", "IH", "EX", "XX")
                        .aisle("FF", "PP", "XX", "XX", "XX")
                        .build());
                return shapeInfo;
            })
            .workableCasingRenderer(GTCEu.id("block/casings/pipe/machine_casing_pipe_steel"),
                    GTCEu.id("block/multiblock/distillation_tower"))
            .register();

    // blah blah because of energy hatch rework this makes it so you need circuits of tier plus small assembler of tier before making it (all subject to change)
    public final static MultiblockMachineDefinition LARGE_ASSEMBLER = GTRegistration.REGISTRATE
            .multiblock("large_assembler", WorkableElectricMultiblockMachine::new)
            .langValue("Large Assembling Factory")
            .tooltips(Component.translatable("gtceu.multiblock.parallelizable.tooltip"))
            .tooltips(Component.translatable("gtceu.machine.available_recipe_map_1.tooltip",
                    Component.translatable("gtceu.assembler")))
//            .conditionalTooltip(GTMachineUtils.defaultEnvironmentRequirement(),
//                    ConfigHolder.INSTANCE.gameplay.environmentalHazards)
            .rotationState(RotationState.ALL)
            .recipeType(ASSEMBLER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH,
                    GTRecipeModifiers.OC_NON_PERFECT_SUBTICK)
            .appearanceBlock(CASING_LARGE_SCALE_ASSEMBLING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX")
                    .aisle("XXXXXXXXX", "XCCCXAAAX", "XGGGXXXXX")
                    .aisle("XXXXXXXXX", "XGGGXXSXX", "XGGGX###X")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(CASING_LARGE_SCALE_ASSEMBLING.get()).setMinGlobalLimited(40)
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), false, false, true, true, true,
                                    true))
                            .or(Predicates.abilities(INPUT_ENERGY).setMaxGlobalLimited(2))
                            .or(Predicates.autoAbilities(false, false, true)))
                    .where('G', Predicates.blocks(CASING_TEMPERED_GLASS.get()))
                    .where('A', Predicates.air())
                    .where('C', abilities(EVPartAbility.ROBOT_ARM))
                    .where('#', Predicates.any())
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/gcym/large_scale_assembling_casing"),
                    GTCEu.id("block/multiblock/gcym/large_assembler"))
            .register();

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

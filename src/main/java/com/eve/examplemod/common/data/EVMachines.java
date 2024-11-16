package com.eve.examplemod.common.data;


import com.eve.examplemod.EVMain;
import com.eve.examplemod.api.recipe.EVOverclockingLogic;
import com.eve.examplemod.common.machine.multiblock.CosmicRayDetector;
import com.eve.examplemod.common.machine.multiblock.EVPartAbility;
import com.eve.examplemod.common.machine.multiblock.miner;
import com.eve.examplemod.common.machine.multiblock.ComponentMultiblock;
import com.eve.examplemod.common.machine.multiblock.part.ComponentPartBlock;
import com.eve.examplemod.common.machine.multiblock.part.triplething;
import com.eve.examplemod.common.machine.multiblock.primitive.IndustrialPrimitiveBlastFurnace;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.*;
import com.gregtechceu.gtceu.api.machine.multiblock.*;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.common.machine.multiblock.part.*;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;


import java.util.ArrayList;
import java.util.Locale;
import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.abilities;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;

import static com.eve.examplemod.api.registries.EVRegistries.REGISTRATE;


import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;

import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.ALL_TIERS;



public class EVMachines {

    public static final PartAbility[] TRI_INPUT_HATCH_ABILITIES = new PartAbility[] {
            PartAbility.IMPORT_ITEMS, PartAbility.IMPORT_FLUIDS, PartAbility.INPUT_ENERGY
    };

    public static final PartAbility[] TRI_OUTPUT_HATCH_ABILITIES = new PartAbility[] {
            PartAbility.EXPORT_ITEMS, PartAbility.EXPORT_FLUIDS, PartAbility.OUTPUT_ENERGY
    };

    public static final MachineDefinition[] ENERGY_INPUT_HATCH_64A = registerTieredMachines("energy_input_hatch_64a",
            (holder, tier) -> new EnergyHatchPartMachine(holder, tier, IO.IN, 64),
            (tier, builder) -> builder
                    .langValue(VNF[tier] + " 64a Energy Hatch")
                    .rotationState(RotationState.ALL)
                    .abilities(PartAbility.INPUT_ENERGY)
                    .tooltips(Component.translatable("gtceu.machine.energy_hatch.input.tooltip"))
                    .overlayTieredHullRenderer("energy_hatch.input_high")
                    .compassNode("energy_hatch")
                    .register(),
            ALL_TIERS);


    public static final MachineDefinition[] DUAL_IMPORT_HATCH = registerTieredMachines(
            "tri_input_hatch",
            (holder, tier) -> new triplething(holder, tier, IO.IN, 2),
            (tier, builder) -> builder
                    .langValue("%s Dual Input Hatch".formatted(VNF[tier]))
                    .rotationState(RotationState.ALL)
                    .abilities(TRI_INPUT_HATCH_ABILITIES)
                    .overlayTieredHullRenderer("dual_hatch.import")
                    .compassNode("dual_hatch")
                    .register(),
            DUAL_HATCH_TIERS);

    public static final MachineDefinition[] CHEMICAL_DEHYDRATOR = registerSimpleMachines("chemical_dehydrator", EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES);

    public static final MachineDefinition[] ROBOT_ARM_COMPONENT = registerTieredMachines("robot_arm_component",
            ComponentPartBlock::new,
            (tier, builder) -> builder
                    .langValue(VNF[tier] + " ROBOT ARM BLOCK")
                    .rotationState(RotationState.ALL)
                    .abilities(EVPartAbility.ROBOT_ARM)
                    .register(),
            ALL_TIERS);

    public static final MachineDefinition[] CONVEYOR_COMPONENT = registerTieredMachines("conveyor_component",
            ComponentPartBlock::new,
            (tier, builder) -> builder
                    .langValue(VNF[tier] + " CONVEYOR BLOCK")
                    .rotationState(RotationState.ALL)
                    .abilities(EVPartAbility.CONVEYOR)
                    .register(),
            ALL_TIERS);

    public static final MultiblockMachineDefinition VOM1 = REGISTRATE
            .multiblock("vom", holder -> new miner(holder, UHV, 9000))
            .tooltips(GTMachines.defaultEnvironmentRequirement())
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK_SUBTICK))
            .appearanceBlock(CASING_PTFE_INERT)
            .pattern(definition -> {
                var casing = blocks(CASING_PTFE_INERT.get()).setMinGlobalLimited(10);
                var abilities = Predicates.autoAbilities(definition.getRecipeTypes())
                        .or(Predicates.autoAbilities(true, false, false));
                return FactoryBlockPattern.start()
                        .aisle("XXX", "XCX", "XXX")
                        .aisle("XCX", "CPC", "XCX")
                        .aisle("XXX", "XSX", "XXX")
                        .where('S', Predicates.controller(blocks(definition.getBlock())))
                        .where('X', casing.or(abilities))
                        .where('P', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                        .where('C', blocks(COIL_CUPRONICKEL.get()).setExactLimit(1)
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
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "XPX", "XXX")
                        .aisle("XEX", "XCX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "XPX", "XCX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XCX", "XPX", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "CPX", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "XPC", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                return shapeInfo;
            })
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_inert_ptfe"),
                    GTCEu.id("block/multiblock/large_chemical_reactor"))
            .compassSections(GTCompassSections.TIER[HV])
            .compassNodeSelf()
            .register();


    public static final MultiblockMachineDefinition INDUSTRIAL_PRIMITIVE_BLAST_FURNACE = REGISTRATE
            .multiblock("industrial_primitive_blast_furnace", IndustrialPrimitiveBlastFurnace::new)
            .langValue("Industrial Primitive Blast Furnace")
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
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
            .compassSections(GTCompassSections.TIER[IV])
            .compassNodeSelf()
            .register();


    public static final MultiblockMachineDefinition COSMIC_GAY_DETECTOR = REGISTRATE
            .multiblock("cosmic_ray_detector", CosmicRayDetector::new)
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .alwaysTryModifyRecipe(true)
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FFF", "FFF", "FFF", "FFF")
                    .aisle("FFF", "F#F", "F#F", "F#F")
                    .aisle("FFF", "FSF", "FFF", "FFF")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('F', blocks(CASING_PRIMITIVE_BRICKS.get()).or(abilities(PartAbility.INPUT_ENERGY)).or(abilities(PartAbility.EXPORT_FLUIDS)))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                    GTCEu.id("block/multiblock/primitive_blast_furnace"))
            .compassSections(GTCompassSections.TIER[IV])
            .compassNodeSelf()
            .register();



    public static final MultiblockMachineDefinition EV_CHEMICAL_REACTOR = REGISTRATE
            .multiblock("ev_chemical_reactor", ComponentMultiblock::new)
            .tooltips(GTMachines.defaultEnvironmentRequirement())
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.LARGE_CHEMICAL_RECIPES)
            .recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK_SUBTICK))
            .appearanceBlock(CASING_PTFE_INERT)
            .pattern(definition -> {
                var casing = blocks(CASING_PTFE_INERT.get()).setMinGlobalLimited(10);
                var abilities = Predicates.autoAbilities(definition.getRecipeTypes())
                        .or(Predicates.autoAbilities(true, false, false));
                return FactoryBlockPattern.start()
                        .aisle("XXX", "XCX", "XXX")
                        .aisle("XCX", "CPC", "XCX")
                        .aisle("XXX", "XSX", "XXX")
                        .where('S', Predicates.controller(blocks(definition.getBlock())))
                        .where('X', casing.or(abilities).or(Predicates.abilities(EVPartAbility.ROBOT_ARM).setMaxGlobalLimited(1).setMinGlobalLimited(1)))
                        .where('P', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                        .where('C', blocks(COIL_CUPRONICKEL.get()).setExactLimit(1)
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
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "XPX", "XXX")
                        .aisle("XEX", "XCX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "XPX", "XCX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XCX", "XPX", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "CPX", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                shapeInfo.add(baseBuilder.shallowCopy()
                        .aisle("IXO", "FSH", "XMX")
                        .aisle("XXX", "XPC", "XXX")
                        .aisle("XEX", "XXX", "XXX")
                        .build());
                return shapeInfo;
            })
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_inert_ptfe"),
                    GTCEu.id("block/multiblock/large_chemical_reactor"))
            .compassSections(GTCompassSections.TIER[HV])
            .compassNodeSelf()
            .register();







    public static MachineDefinition[] registerTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = REGISTRATE
                    .machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static void init(){

    }
}

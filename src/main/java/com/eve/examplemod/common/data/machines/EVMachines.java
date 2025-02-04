package com.eve.examplemod.common.data.machines;


import com.eve.examplemod.EVMain;
import com.eve.examplemod.common.data.EVRecipeTypes;
import com.eve.examplemod.common.machine.multiblock.*;
import com.eve.examplemod.common.machine.multiblock.part.*;
import com.eve.examplemod.common.machine.multiblock.primitive.IndustrialPrimitiveBlastFurnace;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.common.machine.multiblock.part.EnergyHatchPartMachine;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.BiFunction;

import static com.eve.examplemod.api.EVValues.CLR;
import static com.eve.examplemod.api.EVValues.ROMAN;
import static com.eve.examplemod.api.registries.EVRegistries.REGISTRATE;
import static com.eve.examplemod.common.data.EVRecipeTypes.ACTIVE_COOLER_RECIPES;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;



public class EVMachines{

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
                    .register(),
            GTMachineUtils.ALL_TIERS);


//    public static final MachineDefinition[] DUAL_IMPORT_HATCH = registerTieredMachines(
//            "tri_input_hatch",
//            (holder, tier) -> new triplething(holder, tier, IO.IN, 2),
//            (tier, builder) -> builder
//                    .langValue("%s Dual Input Hatch".formatted(VNF[tier]))
//                    .rotationState(RotationState.ALL)
//                    .abilities(TRI_INPUT_HATCH_ABILITIES)
//                    .overlayTieredHullRenderer("dual_hatch.import")
//                    .compassNode("dual_hatch")
//                    .register(),
//            DUAL_HATCH_TIERS);

    // TODO machine texture
    public static final MachineDefinition[] CHEMICAL_DEHYDRATOR = registerSimpleMachines("chemical_dehydrator", EVRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES);

    public static final MachineDefinition[] ROBOT_ARM_COMPONENT = registerTieredMachines("robot_arm_component",
            ComponentPartBlock::new,
            (tier, builder) -> builder
                    .langValue(VNF[tier] + " Robot Arm Block")
                    .rotationState(RotationState.ALL)
                    .abilities(EVPartAbility.ROBOT_ARM)
                    .register(),
            GTMachineUtils.ALL_TIERS);

    public static final MachineDefinition[] CONVEYOR_COMPONENT = registerTieredMachines("conveyor_component",
            ComponentPartBlock::new,
            (tier, builder) -> builder
                    .langValue(VNF[tier] + " Conveyor Block")
                    .rotationState(RotationState.ALL)
                    .abilities(EVPartAbility.CONVEYOR)
                    .register(),
            GTMachineUtils.ALL_TIERS);

    public static final MachineDefinition[] INTEGRAL_FRAMEWORK = registerTieredMachines("integral_framework",
            ComponentPartBlock::new,
            (tier, builder) -> builder
                    .langValue(CLR[tier] + "Integral Framework " + ROMAN[tier])
                    .tooltips(Component.translatable("Max Voltage " + VN[tier]))
                    .rotationState(RotationState.ALL)
                    .modelRenderer(() -> EVMain.id("block/machine/part/"+VN[tier].toLowerCase() + "_integral_framework"))
                    // TODO find anything but this shitty workaround,, kinda fixed but want to make it so it doesnt get replaced by the multiblock texture
                    .abilities(EVPartAbility.INTEGRAL_FRAMEWORK)
                    .register(),
            GTMachineUtils.ALL_TIERS);

    public static final MachineDefinition FUEL_CELL = REGISTRATE
                    .machine("fuel_cell", FuelCell::new)
                    .rotationState(RotationState.ALL)
                    .abilities(EVPartAbility.FUEL_CELL)
                    .register();

    public static final MachineDefinition GECKO_CASING = REGISTRATE
            .machine("gecko_casing", GeckoCasing::new)
            .langValue("Gecko Casing")
            .rotationState(RotationState.ALL)
            .modelRenderer(() -> EVMain.id("block/casings/gecko"))
            .abilities(EVPartAbility.GECKO_CASING)
            .register();

    public static final MachineDefinition DISTILLED_WATER_COOLER = REGISTRATE
            .machine("distilled_water_cooler", holder -> new PassiveCooler(holder, 1))
            .abilities(EVPartAbility.COOLER)
            .register();

    public static final MachineDefinition CRYOTHEUM_COOLER = REGISTRATE
            .machine("cryotheum_cooler", holder -> new PassiveCooler(holder, 3))
            .abilities(EVPartAbility.COOLER)
            .register();

    public static final MachineDefinition SUPERCOOLED_CRYOTHEUM_COOLER = REGISTRATE
            .machine("supercooled_cryotheum_cooler", holder -> new PassiveCooler(holder, 4))
            .abilities(EVPartAbility.COOLER)
            .register();

    public static final MachineDefinition ACTIVE_COOLER = REGISTRATE
            .machine("active_cooler", holder -> new ActiveCooler(holder, 1, defaultTankSizeFunction))
            .abilities(EVPartAbility.COOLER)
            .recipeType(ACTIVE_COOLER_RECIPES)
            .register();



    public static final MultiblockMachineDefinition VOM1 = REGISTRATE
            .multiblock("vom", holder -> new VoidOreMiner(holder, UV, 9000))
            .tooltips(defaultEnvironmentRequirement())
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
                        .where('X', casing.or(abilities).or(abilities(PartAbility.EXPORT_FLUIDS))
                                .or(abilities(PartAbility.IMPORT_FLUIDS))
                                .or(abilities(PartAbility.EXPORT_FLUIDS))
                                .or(abilities(PartAbility.INPUT_ENERGY))
                                .or(abilities(PartAbility.IMPORT_ITEMS))
                                .or(abilities(PartAbility.EXPORT_ITEMS))
                        )
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
            .register();


    public static final MultiblockMachineDefinition GECKO_MULTIBLOCK = REGISTRATE
            .multiblock("gecko_multiblock", GeckoMultiblock::new)
            .langValue("Gecko")
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .alwaysTryModifyRecipe(true)
            .recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK))
            .appearanceBlock(CASING_PRIMITIVE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, UP, BACK)
                    .aisle("FFF", "FSF", "FFF", "FFF")
                    .aisle("FFF", "I#I", "F#F", "F#F")
                    .aisle("FFF", "FOF", "FFF", "FFF")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('F', ability(EVPartAbility.GECKO_CASING))
                    .where('O',blocks(ITEM_EXPORT_BUS[1].getBlock()))
                    .where('I', blocks(ITEM_IMPORT_BUS[1].getBlock()).setMaxLayerLimited(1).setMinLayerLimited(1).or(blocks(CASING_PRIMITIVE_BRICKS.get())))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(EVMain.id("block/casings/gecko"),
                    GTCEu.id("block/multiblock/primitive_blast_furnace"))
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
            .register();


    public static final MultiblockMachineDefinition NUCLEAR_REACTOR = REGISTRATE
            .multiblock("nuclear_reactor", NuclearReactor::new)
            .rotationState(RotationState.ALL)
            .recipeType(EVRecipeTypes.NUCLEAR_REACTOR_RECIPES)
            .alwaysTryModifyRecipe(true)
            .appearanceBlock(CASING_TITANIUM_STABLE)
            .pattern((definition) -> FactoryBlockPattern.start()
                    .aisle("XXXXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX")
                    .aisle("XXXXX", "X   X", "X   X", "X   X", "XFFFX")
                    .aisle("XXXXX", "X   X", "X   X", "X   X", "XFSFX")
                    .aisle("XXXXX", "X   X", "X   X", "X   X", "XFFFX")
                    .aisle("XXXXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX")
                    .where('X', blocks(CASING_TITANIUM_STABLE.get())
                            .or(blocks(CASING_LAMINATED_GLASS.get()))
                            .or(abilities(PartAbility.PASSTHROUGH_HATCH).setPreviewCount(3))
                            .or(Predicates.autoAbilities(definition.getRecipeTypes()))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1, 1).setMaxGlobalLimited(2)))
                    .where('S', controller(blocks(definition.getBlock())))
                    .where(' ', any())
                    .where('E', abilities(PartAbility.INPUT_ENERGY))
                    .where('F', cleanroomFilters())
                    .where('I', abilities(PartAbility.PASSTHROUGH_HATCH))
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
                    GTCEu.id("block/multiblock/cleanroom"))
            .register();

    public static final MultiblockMachineDefinition CIRCUIT_ASSEMBLY_LINE = REGISTRATE
            .multiblock("circuit_assembly_line", CircuitAssemblyLine::new)
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.CIRCUIT_ASSEMBLER_RECIPES)
            .appearanceBlock(CASING_STEEL_SOLID)
            .recipeModifier(GTRecipeModifiers.OC_PERFECT_SUBTICK)
            .pattern((definition) -> FactoryBlockPattern.start(LEFT, DOWN, FRONT)
                    .aisle("GAG", "RTR", "FOF")
                    .aisle("GAG", "RTR", "FIF").setRepeatable(5)
                    .aisle("GSG", "RTR", "FIF")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('F', blocks(CASING_STEEL_SOLID.get()).or(abilities(PartAbility.IMPORT_FLUIDS).or(abilities(PartAbility.INPUT_ENERGY))))
                    .where('G', blocks(CASING_GRATE.get()))
                    .where('R', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('A', blocks(CASING_ASSEMBLY_CONTROL.get()))
                    .where('O', abilities(PartAbility.EXPORT_ITEMS))
                    .where('I', blocks(ITEM_IMPORT_BUS[0].getBlock()))
                    .where('T', abilities(EVPartAbility.INTEGRAL_FRAMEWORK))
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/assembly_line"))
            .register();




    public static final MultiblockMachineDefinition EV_CHEMICAL_REACTOR = REGISTRATE
            .multiblock("ev_chemical_reactor", holder -> new EfficiencyMachine(holder, 3000))
            .tooltips(defaultEnvironmentRequirement())
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

package com.eve.examplemod.common.machine.multiblock;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;

public class EVPartAbility extends PartAbility {
    public static final PartAbility ROBOT_ARM = new PartAbility("robot_arm");
    public static final PartAbility PUMP = new PartAbility("pump");
    public static final PartAbility MOTOR = new PartAbility("motor");
    public static final PartAbility FIELD_GENERATOR = new PartAbility("field_generator");
    public static final PartAbility PISTON = new PartAbility("piston");
    public static final PartAbility EMITTER = new PartAbility("emitter");
    public static final PartAbility SENSOR = new PartAbility("sensor");
    public static final PartAbility CONVEYOR = new PartAbility("conveyor");
    public static final PartAbility INTEGRAL_FRAMEWORK = new PartAbility("integral_framework");

    public static final PartAbility FUEL_CELL = new PartAbility("fuel_cell");
    public static final PartAbility COOLER = new PartAbility("cooler");






    public EVPartAbility(String name) {
        super(name);
    }
}

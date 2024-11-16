package com.eve.examplemod.api.recipe;

import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;

public class EVOverclockingLogic extends OverclockingLogic {


    public static final double IMPERFECT_DURATION_FACTOR = 0.75;


    public static final OverclockingLogic IMPERFECT_OVERCLOCK = new OverclockingLogic(IMPERFECT_DURATION_FACTOR, STD_VOLTAGE_FACTOR, false);


    public EVOverclockingLogic(Logic logic) {
        super(logic);
    }
}

package com.eve.examplemod.api.fluids.store;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKey;

public class EVFluidStorageKeys {


    public static final FluidStorageKey depleted_nitrate = new FluidStorageKey(EVMain.id("depleted_nitrate_solution"),
            "depleted_nitrate_solution",
            MaterialIconType.liquid,
            m -> "depleted_" + m.getName(),
            m -> "gtceu.fluid.depleted_nitrate_solution",
            FluidState.LIQUID, -1);

    public static final FluidStorageKey hexachloride = new FluidStorageKey(EVMain.id("hexachloride"),
            "hexachloride",
            MaterialIconType.liquid,
            m -> m.getName() + "_hexachloride",
            m -> "gtceu.fluid.hexachloride",
            FluidState.LIQUID, -1);

    public static final FluidStorageKey hexafluoride = new FluidStorageKey(EVMain.id("hexafluoride"),
            "hexafluoride",
            MaterialIconType.liquid,
            m -> "ev_" + m.getName() + "_hexafluoride",
            m -> "gtceu.fluid.hexafluoride",
            FluidState.LIQUID, -1);

    public static final FluidStorageKey steam_cracked_hexafluoride = new FluidStorageKey(EVMain.id("steam_cracked_hexafluoride"),
            "steam_cracked_hexafluoride",
            MaterialIconType.liquid,
            m -> "steam_cracked_" + m.getName() + "_hexafluoride",
            m -> "gtceu.fluid.steam_cracked_hexafluoride",
            FluidState.LIQUID, -4);


}

package com.eve.examplemod.api.fluids.store;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKey;
import org.jetbrains.annotations.NotNull;

public class EVFluidStorageKeys {
    public static final FluidStorageKey skib = new FluidStorageKey(EVMain.id("depleted_nitrate_solution"),
            "depleted_nitrate_solution",
            MaterialIconType.liquid,
            m -> m.getName() + "_depleted_fuel_nitrate_solution",
            m -> "gtceu.fluid.generic",
            FluidState.LIQUID, -1);


    private static @NotNull String prefixedRegisteredName(@NotNull String prefix, @NotNull FluidStorageKey key,
                                                          @NotNull Material material) {
        FluidProperty property = material.getProperty(PropertyKey.FLUID);
        if (property != null && property.getPrimaryKey() != key) {
            return prefix + material.getName();
        }
        return material.getName();
    }

    private static @NotNull String postfixedRegisteredName(@NotNull String postfix, @NotNull FluidStorageKey key,
                                                           @NotNull Material material) {
        FluidProperty property = material.getProperty(PropertyKey.FLUID);
        if (property != null && property.getPrimaryKey() != key) {
            return material.getName() + postfix;
        }
        return material.getName();
    }
}

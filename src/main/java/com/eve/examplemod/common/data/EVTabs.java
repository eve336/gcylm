package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.eve.examplemod.EVMain.EV_REGISTRATE;

public class EVTabs {
    public static RegistryEntry<CreativeModeTab> EV_MATERIALS = EV_REGISTRATE.defaultCreativeTab("ev_items",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("ev_items", EV_REGISTRATE))
                            .icon(() -> EVItems.smd_capacitor_refined.asStack())
                            .title(EV_REGISTRATE.addLang("itemGroup", EVMain.id("ev_items"),  "ev Materials"))
                            .build())
            .register();

    static {
        EV_REGISTRATE.creativeModeTab(() -> EVTabs.EV_MATERIALS);
    }

    public static void init() {

    }
}

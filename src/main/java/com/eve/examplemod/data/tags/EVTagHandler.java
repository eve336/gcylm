package com.eve.examplemod.data.tags;

import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.world.item.Item;

public class EVTagHandler {
    public static void initItem(RegistrateTagsProvider<Item> provider) {
        EVItemTags.init(provider);
    }
}

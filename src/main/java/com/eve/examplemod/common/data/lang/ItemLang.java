package com.eve.examplemod.common.data.lang;


import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;

public class ItemLang {

    public static void init(RegistrateLangProvider provider) {

        for (var recipeType : GTRegistries.RECIPE_TYPES) {
            provider.add(recipeType.registryName.toLanguageKey(), toEnglishName(recipeType.registryName.getPath()));
        }

    }
}

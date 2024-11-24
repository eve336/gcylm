package com.eve.examplemod.common.data.lang;


import com.eve.examplemod.EVMain;
import com.eve.examplemod.common.data.EVMaterials;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.tterrag.registrate.providers.RegistrateLangProvider;


import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static com.eve.examplemod.EVMain.LOGGER;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;

import static com.gregtechceu.gtceu.common.data.GTCompassSections.MATERIALS;

public class ItemLang {


    public static void init(RegistrateLangProvider provider) {
        initGeneratedNames(provider);
        initItemTooltips(provider);
    }
    private static void initGeneratedNames(RegistrateLangProvider provider) {


    }

    private static void initItemTooltips(RegistrateLangProvider provider) {
        provider.add("item.examplemod.refined_processor.tooltip","LV-Tier Circuit");
    }
}

package com.eve.examplemod.common.data.lang;

import com.eve.examplemod.common.data.EVMaterials;

import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;

public class MaterialLangGenerator {
    public static void generate(RegistrateLangProvider provider) {
        provider.add(EVMaterials.Cryotheum.getUnlocalizedName(), toEnglishName(EVMaterials.Cryotheum.getName()));
    }
}

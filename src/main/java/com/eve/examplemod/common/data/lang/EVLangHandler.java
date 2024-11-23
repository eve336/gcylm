package com.eve.examplemod.common.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class EVLangHandler {
    public static void init(RegistrateLangProvider provider){
        ItemLang.init(provider);
        MaterialLangGenerator.generate(provider);
    }
}

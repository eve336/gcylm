package com.eve.examplemod.common.data.lang;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;

public class EVLangHandler extends LangHandler {
    public static void init(RegistrateLangProvider provider){


        provider.add("tagprefix.oxide", TagPrefix.get("oxide").langValue());
        provider.add("tagprefix.fuel_oxide", TagPrefix.get("fuel_oxide").langValue());
        provider.add("tagprefix.fuel_pure", TagPrefix.get("fuel_pure").langValue());
    }
}

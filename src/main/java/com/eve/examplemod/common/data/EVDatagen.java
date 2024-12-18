package com.eve.examplemod.common.data;

import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.data.lang.EVLangHandler;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;

import static com.eve.examplemod.EVMain.EV_REGISTRATE;


public class EVDatagen {
    public static void init(){
        EVRegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, EVLangHandler::init);
    }

}

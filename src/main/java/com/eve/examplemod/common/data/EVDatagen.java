package com.eve.examplemod.common.data;

import com.eve.examplemod.api.registries.EVRegistries;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;

import static com.eve.examplemod.EVMain.EV_REGISTRATE;


public class EVDatagen {
    public static void init(){
        EV_REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
        EV_REGISTRATE.addDataGenerator(ProviderType.LANG, com.eve.examplemod.common.data.lang.LangHandler::init);
        GTRegistration.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }

}

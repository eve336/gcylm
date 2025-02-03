package com.eve.examplemod.common.data;

import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.data.lang.EVLangHandler;
import com.tterrag.registrate.providers.ProviderType;


public class EVDatagen {
    public static void init(){
        EVRegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, EVLangHandler::init);
    }

}

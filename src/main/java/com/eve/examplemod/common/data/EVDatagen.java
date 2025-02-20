package com.eve.examplemod.common.data;

import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.data.lang.EVLangHandler;
import com.eve.examplemod.data.tags.EVTagHandler;
import com.gregtechceu.gtceu.common.registry.GTRegistration;
import com.gregtechceu.gtceu.data.tags.TagsHandler;
import com.tterrag.registrate.providers.ProviderType;


public class EVDatagen {

    public static void init(){
        EVRegistries.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, EVTagHandler::initItem);
        EVRegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, EVLangHandler::init);
    }

}

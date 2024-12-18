package com.eve.examplemod.common.data.lang;

import com.eve.examplemod.api.data.tag.EVTagPrefix;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;

public class EVLangHandler  {
    public static void init(RegistrateLangProvider provider){


        provider.add("tagprefix.oxide", TagPrefix.get("oxide").langValue());
        provider.add("tagprefix.fuel_oxide", TagPrefix.get("fuelOxide").langValue());
        provider.add("tagprefix.fuel_pure", TagPrefix.get("fuelPure").langValue());

        provider.add("gtceu.fluid.depleted_nitrate_solution", "Depleted %t Fuel Nitrate Solution");

    }
}

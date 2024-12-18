package com.eve.examplemod.common.data.lang;

import com.eve.examplemod.api.data.tag.EVTagPrefix;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;

public class EVLangHandler  {
    public static void init(RegistrateLangProvider provider){




        for (TagPrefix tagPrefix : TagPrefix.values()) {
            provider.add(tagPrefix.getUnlocalizedName(), tagPrefix.langValue);
        }

        provider.add("gtceu.fluid.depleted_nitrate_solution", "Depleted %s Fuel Nitrate Solution");

    }
}

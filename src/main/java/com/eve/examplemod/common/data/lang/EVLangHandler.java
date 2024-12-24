package com.eve.examplemod.common.data.lang;

import com.eve.examplemod.api.data.tag.EVTagPrefix;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import org.apache.commons.codec.language.bm.Lang;

import static com.gregtechceu.gtceu.data.lang.LangHandler.replace;

public class EVLangHandler  extends LangHandler {
    public static void init(RegistrateLangProvider provider){




        for (TagPrefix tagPrefix : TagPrefix.values()) {
            provider.add(tagPrefix.getUnlocalizedName(), tagPrefix.langValue);
        }

        provider.add("gtceu.fluid.depleted_nitrate_solution", "Depleted %s Fuel Nitrate Solution");
        provider.add("gtceu.fluid.hexachloride", "%s Hexachloride");
        provider.add("gtceu.fluid.hexafluoride", "%s Hexafluoride");
        provider.add("gtceu.fluid.steam_cracked_hexafluoride", "Steam Cracked %s Hexafluoride");
        provider.add("examplemod.recipe.temperature", "Temperature: %s");
        provider.add("examplemod.recipe.cooling", "Cooling: %s");

    }
}

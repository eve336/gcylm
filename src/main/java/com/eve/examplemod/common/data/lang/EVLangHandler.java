package com.eve.examplemod.common.data.lang;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.RegistrateLangProvider;

public class EVLangHandler extends LangHandler {
    public static void init(RegistrateLangProvider provider){

        EVMachineLang.init(provider);


        for (TagPrefix tagPrefix : TagPrefix.values()) {
            provider.add(tagPrefix.getUnlocalizedName(), tagPrefix.langValue);
        }

        provider.add("gtceu.fluid.depleted_nitrate_solution", "Depleted %s Fuel Nitrate Solution");
        provider.add("gtceu.fluid.hexachloride", "%s Hexachloride");
        provider.add("gtceu.fluid.hexafluoride", "%s Hexafluoride");
        provider.add("gtceu.fluid.steam_cracked_hexafluoride", "Steam Cracked %s Hexafluoride");
        provider.add("examplemod.recipe.temperature", "Temperature: %s");
        provider.add("examplemod.recipe.cooling", "Cooling: %s");

        provider.add("item.examplemod.refined_processor.tooltip", "LV-Tier Circuit");

        provider.add("gtceu.chemical_dehydrator", "Chemical Dehydrator");
        provider.add("gtceu.stellar_forge", "Stellar Forge");
        provider.add("gtceu.chemplant", "Chemical Plant");
        // bio_reactor
        provider.add("gtceu.bio_reactor", "Bio Reactor");
        // active_cooler
        provider.add("gtceu.active_cooler", "Active cooler");
        // nuclear_reactor
        provider.add("gtceu.nuclear_reactor", "Nuclear Reactor");
        // large_mixer
        provider.add("gtceu.large_mixer", "Large Mixer");
        // gas_centrifuge
        provider.add("gtceu.gas_centrifuge", "Gas Centrifuge");
        // plasma_condenser
        provider.add("gtceu.plasma_condenser", "Plasma Condenser");
        // replication
        provider.add("gtceu.replication", "Replication");
        // large_centrifuge
        provider.add("gtceu.large_centrifuge", "Large Centrifuge");
        // large_engraver
        provider.add("gtceu.large_engraver", "Large Engraver");
        // adv_fusion
        provider.add("gtceu.adv_fusion", "Adv Fusion");
        // spawner
        provider.add("gtceu.spawner", "Mob Spawner");
        // harvester
        provider.add("gtceu.harvester", "Mob Harvester");


    }
}

package com.eve.examplemod.common.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class EVMachineLang {
    protected static void init(RegistrateLangProvider provider) {
        provider.add("examplemod.chemical_reactor.tooltip", "Starts with 10% speed which increases over time. Changing recipes resets the speed");
        provider.add("examplemod.industrial_primitive_blast_furnace", "Can run Primitive Blast Furnace recipes. Extending the multiblock increases the speed by 100% per layer and reduces fuel efficiency.");

    }
}

package com.eve.examplemod.integration.kjs;

import com.eve.examplemod.common.data.EVMaterials;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;

public class EVKJSPlugin extends KubeJSPlugin {
    @Override
    public void initStartup() {
        super.initStartup();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void registerBindings(BindingsEvent event) {
        super.registerBindings(event);
        event.add("EVMaterials", EVMaterials.class);
    }
}

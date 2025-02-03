package com.eve.examplemod.api.data.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class EVPropertyKey extends PropertyKey {
    public EVPropertyKey(String key, Class type) {
        super(key, type);
    }
    public static final PropertyKey<EVNuclearProperty> NUCLEAR = new PropertyKey<>("nuclear", EVNuclearProperty.class);
    public static final PropertyKey<EVMixerProperty> MIXER = new PropertyKey<>("mixer", EVMixerProperty.class);
    public static final PropertyKey<EVWasteProperty> WASTE = new PropertyKey<>("waste", EVWasteProperty.class);
    public static final PropertyKey<EVComponentProperty> COMPONENT = new PropertyKey<>("component", EVComponentProperty.class);
}

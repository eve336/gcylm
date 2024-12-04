package com.eve.examplemod.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class EVElements {
    public static final Element Fm258 = createAndRegister(100,158, -1, null, "Fermium-258", "Fm-258", true);
    public static final Element Md261 = createAndRegister(101, 160, -1, null, "Mendelevium-261", "Md-261", true);
    public static final Element Es255 = createAndRegister(99, 156, -1, null, "Einsteinium-255", "Es-255", true);

    public static final Element Ad = createAndRegister(101, 160, -1, null, "Adamantium", "Ad", false);

    public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(name, element);
        return element;
    }

    public static void init() {

    }
}

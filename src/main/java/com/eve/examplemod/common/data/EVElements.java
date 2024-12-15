package com.eve.examplemod.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class EVElements {
    public static final Element U234 = createAndRegister(100,158, -1, null, "Uranium-234", "U234", true);
    public static final Element Fm258 = createAndRegister(100,158, -1, null, "Fermium-258", "Fm258", true);
    public static final Element Fm262 = createAndRegister(100,158, -1, null, "Fermium-262", "Fm262", true);
    public static final Element Md261 = createAndRegister(101, 160, -1, null, "Mendelevium-261", "Md261", true);
    public static final Element Es255 = createAndRegister(99, 156, -1, null, "Einsteinium-255", "Es255", true);
    public static final Element Es257 = createAndRegister(99, 158, -1, null, "Einsteinium-257", "Es257", true);
    public static final Element Cf253 = createAndRegister(99, 156, -1, null, "Californium-253", "Cf253", true);
    public static final Element Cf256 = createAndRegister(99, 156, -1, null, "Californium-256", "Cf256", true);
    public static final Element Cf252 = createAndRegister(99, 156, -1, null, "Californium-252", "Cf252", true);
    public static final Element Bk251 = createAndRegister(99, 156, -1, null, "Berkelium-251", "Bk251", true);
    public static final Element Bk249 = createAndRegister(99, 156, -1, null, "Berkelium-249", "Bk249", true);
    public static final Element Cm245 = createAndRegister(99, 156, -1, null, "Curium-245", "Cm245", true);
    public static final Element Cm246 = createAndRegister(99, 156, -1, null, "Curium-246", "Cm246", true);
    public static final Element Cm247 = createAndRegister(99, 156, -1, null, "Curium-247", "Cm247", true);
    public static final Element Cm250 = createAndRegister(99, 156, -1, null, "Curium-250", "Cm250", true);
    public static final Element Am245 = createAndRegister(99, 156, -1, null, "Americium-245", "Am245", true);
    public static final Element Am243 = createAndRegister(99, 156, -1, null, "Americium-243", "Am243", true);
    public static final Element Np239 = createAndRegister(99, 156, -1, null, "Neptunium-239", "Np239", true);
    public static final Element Np237 = createAndRegister(99, 156, -1, null, "Neptunium-237", "Np237", true);
    public static final Element Np235 = createAndRegister(99, 156, -1, null, "Neptunium-235", "Np235", true);

    public static final Element Pu245 = createAndRegister(99, 156, -1, null, "Plutonium-245", "Pu245", true);
    public static final Element Pu244 = createAndRegister(99, 156, -1, null, "Plutonium-244", "Pu244", true);
    public static final Element Pu240 = createAndRegister(99, 156, -1, null, "Plutonium-240", "Pu240", true);

    public static final Element Th232 = createAndRegister(99, 156, -1, null, "Thorium-232", "Th232", true);
    public static final Element Th233 = createAndRegister(99, 156, -1, null, "Thorium-233", "Th233", true);
    public static final Element Pa233 = createAndRegister(99, 156, -1, null, "Protactinium-233", "Pa233", true);
    public static final Element U233 = createAndRegister(99, 156, -1, null, "Uranium-233", "U233", true);
    public static final Element U239 = createAndRegister(99, 156, -1, null, "Uranium-239", "U239", true);




    public static final Element Ad = createAndRegister(101, 160, -1, null, "Adamantium", "Ad", false);

    public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(name, element);
        return element;
    }

    public static void init() {

    }
}

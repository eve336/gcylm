package com.eve.examplemod.common.data;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class EVElements {
    public static final Element U234 = createAndRegister(100,158, -1, null, "Uranium-234", "U-234", true);
    public static final Element Fm257 = createAndRegister(100,158, -1, null, "Fermium-257", "Fm-257", true);
    public static final Element Fm258 = createAndRegister(100,158, -1, null, "Fermium-258", "Fm-258", true);
    public static final Element Fm259 = createAndRegister(100,158, -1, null, "Fermium-259", "Fm-259", true);
    public static final Element Fm262 = createAndRegister(100,158, -1, null, "Fermium-262", "Fm-262", true);
    public static final Element Fm263 = createAndRegister(100,158, -1, null, "Fermium-263", "Fm-263", true);
    public static final Element Md259 = createAndRegister(101, 160, -1, null, "Mendelevium-259", "Md-259", true);
    public static final Element Md261 = createAndRegister(101, 160, -1, null, "Mendelevium-261", "Md-261", true);
    public static final Element Md263 = createAndRegister(101, 160, -1, null, "Mendelevium-263", "Md-263", true);
    public static final Element Es253 = createAndRegister(99, 156, -1, null, "Einsteinium-253", "Es-253", true);
    public static final Element Es255 = createAndRegister(99, 156, -1, null, "Einsteinium-255", "Es-255", true);
    public static final Element Es257 = createAndRegister(99, 158, -1, null, "Einsteinium-257", "Es-257", true);
    public static final Element Cf253 = createAndRegister(99, 156, -1, null, "Californium-253", "Cf-253", true);
    public static final Element Cf257 = createAndRegister(99, 156, -1, null, "Californium-257", "Cf-257", true);
    public static final Element Cf256 = createAndRegister(99, 156, -1, null, "Californium-256", "Cf-256", true);
    public static final Element Cf252 = createAndRegister(99, 156, -1, null, "Californium-252", "Cf-252", true);
    public static final Element Cf251 = createAndRegister(99, 156, -1, null, "Californium-251", "Cf-251", true);
    public static final Element Bk251 = createAndRegister(99, 156, -1, null, "Berkelium-251", "Bk-251", true);
    public static final Element Bk249 = createAndRegister(99, 156, -1, null, "Berkelium-249", "Bk-249", true);
    public static final Element Cm245 = createAndRegister(99, 156, -1, null, "Curium-245", "Cm-245", true);
    public static final Element Cm246 = createAndRegister(99, 156, -1, null, "Curium-246", "Cm-246", true);
    public static final Element Cm247 = createAndRegister(99, 156, -1, null, "Curium-247", "Cm-247", true);
    public static final Element Cm250 = createAndRegister(99, 156, -1, null, "Curium-250", "Cm-250", true);
    public static final Element Cm251 = createAndRegister(99, 156, -1, null, "Curium-251", "Cm-251", true);
    public static final Element Am245 = createAndRegister(99, 156, -1, null, "Americium-245", "Am-245", true);
    public static final Element Am243 = createAndRegister(99, 156, -1, null, "Americium-243", "Am-243", true);
    public static final Element Am241 = createAndRegister(99, 156, -1, null, "Americium-241", "Am-241", true);
    public static final Element Np239 = createAndRegister(99, 156, -1, null, "Neptunium-239", "Np-239", true);
    public static final Element Np237 = createAndRegister(99, 156, -1, null, "Neptunium-237", "Np-237", true);
    public static final Element Np235 = createAndRegister(99, 156, -1, null, "Neptunium-235", "Np-235", true);

    public static final Element Pu245 = createAndRegister(99, 156, -1, null, "Plutonium-245", "Pu-245", true);
    public static final Element Pu244 = createAndRegister(99, 156, -1, null, "Plutonium-244", "Pu-244", true);
    public static final Element Pu240 = createAndRegister(99, 156, -1, null, "Plutonium-240", "Pu-240", true);

    public static final Element Th232 = createAndRegister(99, 156, -1, null, "Thorium-232", "Th-232", true);
    public static final Element Th233 = createAndRegister(99, 156, -1, null, "Thorium-233", "Th-233", true);
    public static final Element Pa233 = createAndRegister(99, 156, -1, null, "Protactinium-233", "Pa-233", true);
    public static final Element U233 = createAndRegister(99, 156, -1, null, "Uranium-233", "U-233", true);
    public static final Element U239 = createAndRegister(99, 156, -1, null, "Uranium-239", "U-239", true);

    //Possibly temporary
    public static final Element Pu239 = createAndRegister(94, 145, -1, null, "plutonium-239", "Pu-239", true);
    public static final Element U238 = createAndRegister(92, 146, -1, null, "uranium-238", "U-238", true);


    public static final Element Ad = createAndRegister(101, 160, -1, null, "Adamantium", "Ad", false);

    public static Element createAndRegister(long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        GTRegistries.ELEMENTS.register(name, element);
        return element;
    }

    public static void init() {

    }
}

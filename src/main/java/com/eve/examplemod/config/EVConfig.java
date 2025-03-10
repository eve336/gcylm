package com.eve.examplemod.config;


import com.eve.examplemod.EVMain;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = EVMain.MOD_ID)
public class EVConfig {
    public static EVConfig INSTANCE;
    private static final Object LOCK = new Object();

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(EVConfig.class, ConfigFormats.yaml()).getConfigInstance();
            }
        }
    }


    @Configurable
    @Configurable.Comment({"Default = false"})
    public boolean programmerArtEpoxy = false;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean configEnergyDrainDrive = true;

    @Configurable
    @Configurable.Comment({"Default = 0.25f"})
    public float driveEnergyDrainBase = 0.25f;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean yellowRutherfordium = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderGold = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderPlatline = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderTungsten = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderIndium = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderNaquadah = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderYCBO = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean removeCircuitAssemblerRecipes = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean removeLargeCircuitAssembler = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean evEndAccess = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean solarsWorkInNether = true;

    @Configurable
    @Configurable.Comment("Whether or not blocks should break from a lack of oxygen if ad astra is installed.\nDefault = false")
    public boolean adAstraBreaksBlocks = false;

    @Configurable
    @Configurable.Comment({"Default = 20 seconds"})
    public int reactorMeltdownTime = 20;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean darkerSteel = true;

    // wip
    @Configurable
    @Configurable.Comment({"Default = true, wip"})
    public boolean reworkGTCableCovering = true;

    // eventually change these, especially nuclear materials bc nuclear rework

    @Configurable
    public String[] VOM1Blacklist = {
            "triniite",
            "trinium",
            "duranium",
            "tritanium",
            "rutherfordium",
            "californium",
            "curium",
            "seaborgium",
            "berkelium",
            "fermium",
            "einsteinium",
            "dubnium",
            "bohrium"
    };

    @Configurable
    public String[] VOM2Blacklist = {
            "trinium",
            "fermium",
            "bohrium",
            "seaborgium",
            "einsteinium"
    };

    @Configurable
    public String[] VOM3Blacklist = {
            "bohrium",
            "fermium"
    };
}

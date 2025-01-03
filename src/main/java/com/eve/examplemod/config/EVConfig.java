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
    public boolean programmerArt = false;

    @Configurable
    @Configurable.Comment({"Default = true Turn off to add back gold ore"})
    public boolean harderGold = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderPlatline = true;

    @Configurable
    @Configurable.Comment({"Default = true"})
    public boolean harderTungsten = true;

    @Configurable
    @Configurable.Comment({"Default = 20 seconds"})
    public int reactorMeltdownTime = 20;
}

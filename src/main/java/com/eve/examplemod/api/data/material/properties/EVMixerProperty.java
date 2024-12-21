package com.eve.examplemod.api.data.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;

public class EVMixerProperty implements IMaterialProperty {

    private int durationOverride = -1;

    private int eutOverride = -1;

    @Override
    public void verifyProperty(MaterialProperties properties) {

    }

    public EVMixerProperty(int durationOverride, int eutOverride){
        this.durationOverride = durationOverride;
        this.eutOverride = eutOverride;
    }
    public int getDurationOverride() {
        return durationOverride;
    }

    public void setDurationOverride(int duration) {
        this.durationOverride = duration;
    }

    public int getEUtOverride() {
        return eutOverride;
    }

    public void setEutOverride(int eut) {
        this.eutOverride = eut;
    }
}

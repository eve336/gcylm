package com.eve.examplemod.api.data.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;

import java.util.Map;

public class EVComponentProperty implements IMaterialProperty {


    public EVComponentProperty(Map<Material, Integer> components){
        this.components = components;
    }

    @Override
    public void verifyProperty(MaterialProperties properties) {
    }
    public Map<Material, Integer> components;

}

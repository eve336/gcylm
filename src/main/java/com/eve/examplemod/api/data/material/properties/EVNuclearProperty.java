package com.eve.examplemod.api.data.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class EVNuclearProperty implements IMaterialProperty<EVNuclearProperty> {


    public EVNuclearProperty(int heat, Map<Material, Integer> decayProducts){
        this.heat = heat;
        this.decayProducts = decayProducts;
    }

    @Setter
    private int heat;
    private int complexity;
    @Override
    public void verifyProperty(MaterialProperties properties) {
    }
    public Map<Material, Integer> decayProducts;

}

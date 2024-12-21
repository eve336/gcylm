package com.eve.examplemod.api.data.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Getter
public class EVWasteProperty implements IMaterialProperty {


    public EVWasteProperty(Set<Material> realMaterials, Map<Material, Integer> wasteProducts){
        this.wasteProducts = wasteProducts;
        this.realMaterials = realMaterials;
    }

    @Override
    public void verifyProperty(MaterialProperties properties) {
    }
    @Getter
    public Map<Material, Integer> wasteProducts;

    @Getter
    public Set<Material> realMaterials;

}

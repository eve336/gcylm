package com.eve.examplemod.common;


import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.materials.FirstDegreeMaterials;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class EVCoilBlock extends CoilBlock {


    public EVCoilBlock(Properties properties, ICoilType coilType) {
        super(properties, coilType);
    }

    public enum CoilType implements StringRepresentable, ICoilType {

        CUPRONICKEL("cupronickel", 36000, 1 , 1, GTMaterials.Cupronickel, GTCEu.id("block/casings/coils/machine_coil_cupronickel"));
        @NotNull
        @Getter
        private final String name;
        //electric blast furnace properties
        @Getter
        private final int coilTemperature;
        //multi smelter properties
        @Getter
        private final int level;
        @Getter
        private final int energyDiscount;
        @NotNull
        @Getter
        private final Material material;
        @NotNull @Getter
        private final ResourceLocation texture;

        CoilType(String name, int coilTemperature, int level, int energyDiscount, Material material, ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.material = material;
            this.texture = texture;
        }

        public int getTier() {
            return this.ordinal();
        }



        @NotNull
        @Override
        public String toString() {
            return getName();
        }

        @Override
        @NotNull
        public String getSerializedName() {
            return name;
        }
    }
}
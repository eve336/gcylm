package com.eve.examplemod.common;


import com.eve.examplemod.EVMain;
import com.eve.examplemod.common.data.EVMaterials;
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

import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Cupronickel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Neutronium;

public class EVCoilBlock extends CoilBlock {


    public EVCoilBlock(Properties properties, ICoilType coilType) {
        super(properties, coilType);
    }

    public enum CoilType implements StringRepresentable, ICoilType {

        // using evmaterials here calls it too early and the game crashes
        TITAN_STEEL("titan_steel", 9600, 8, 5, Cupronickel, EVMain.id("block/casings/coils/machine_coil_titan_steel"), 8),
        PIKYONIUM("pikyonium", 10700, 9, 6, Cupronickel, EVMain.id("block/casings/coils/machine_coil_pikyonium"), 9),
        BLACK_TITANIUM("black_titanium", 11200, 10, 7, Cupronickel, EVMain.id("block/casings/coils/machine_coil_black_titanium"), 10),
        NEUTRONIUM("neutronium", 12600, 11, 11, Cupronickel, EVMain.id("block/casings/coils/machine_coil_neutronium"), 11),
        COSMIC_NEUTRONIUM("cosmic_neutronium", 14200, 11, 9, Cupronickel, EVMain.id("block/casings/coils/machine_coil_cosmic_neutronium"), 11),
        INFINITY("infinity", 28400, 12, 12, Cupronickel, EVMain.id("block/casings/coils/machine_coil_infinity"), 12),
        ETERNITY("eternity", 56800, 12, 1000, Cupronickel, EVMain.id("block/casings/coils/machine_coil_eternity"), 12);






        @NotNull
        @Getter
        private final String name;
        private int tier;
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

        CoilType(String name, int coilTemperature, int level, int energyDiscount, Material material, ResourceLocation texture, int tier) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.material = material;
            this.texture = texture;
            this.tier = tier;
        }

        public int getTier() {
            return this.tier;
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
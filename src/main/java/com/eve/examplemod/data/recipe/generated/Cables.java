package com.eve.examplemod.data.recipe.generated;

import com.google.common.collect.ImmutableMap;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.data.recipe.generated.WireRecipeHandler;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.Map;
import java.util.function.Consumer;

import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.cableGtHex;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.StyreneButadieneRubber;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;

public class Cables {

    private static final Map<TagPrefix, Integer> INSULATION_AMOUNT = ImmutableMap.of(
            cableGtSingle, 1,
            cableGtDouble, 1,
            cableGtQuadruple, 2,
            cableGtOctal, 3,
            cableGtHex, 5);

    public static void init(Consumer<FinishedRecipe> provider) {
        wireGtSingle.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
        wireGtDouble.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
        wireGtQuadruple.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
        wireGtOctal.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
        wireGtHex.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
    }

    public static void generateCableCovering(TagPrefix wirePrefix, Material material, WireProperties property,
                                             Consumer<FinishedRecipe> provider) {

        // Superconductors have no Cables, so exit early
        if (property.isSuperconductor()) return;

//        int cableAmount = (int) (wirePrefix.getMaterialAmount(material) * 2 / M);
        TagPrefix cablePrefix = TagPrefix.get("cable" + wirePrefix.name().substring(4));
        int voltageTier = GTUtil.getTierByVoltage(property.getVoltage());
        int insulationAmount = INSULATION_AMOUNT.get(cablePrefix);

        // Generate hand-crafting recipes for ULV and LV cables
//        if (voltageTier <= LV) {
//            generateManualRecipe(wirePrefix, material, cablePrefix, cableAmount, provider);
//        }
        GTRecipeBuilder builder;

        // Polyethylene Recipe (ULV-EV cables)
        // 1.5 times better than rubber
        // silicone rubber is 2x better
        if (voltageTier < EV) {
            builder = ASSEMBLER_RECIPES
                    .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_polyethylene")
                    .EUt(VA[ULV]).duration(100)
                    .inputItems(wirePrefix, material)
                    .outputItems(cablePrefix, material)
                    .inputFluids(Polyethylene.getFluid(96 * insulationAmount));
            builder.save(provider);
        }

//        if (voltageTier > UXV){
            builder = ASSEMBLER_RECIPES
                    .recipeBuilder("cover" + material.getName() + "_" + wirePrefix + "_fullerene_polymer_matrix")
                    .EUt(VA[ULV]).duration(100)
                    .inputItems(wirePrefix, material)
                    .outputItems(cablePrefix, material)
                    .inputFluids(FullerenePolymerMatrix.getFluid(18
                            // * (voltageTier + 1)
                            * insulationAmount));
        if (voltageTier == OpV){
            builder.inputItems(INSULATION_WIRE_ASSEMBLY, insulationAmount);
        }
        if (voltageTier > OpV){
            builder.inputItems(INSULATION_WIRE_ASSEMBLY, 2 * insulationAmount);

        }
        builder.save(provider);
//        }

        // Silicone Rubber Recipe (all cables)
//        builder = ASSEMBLER_RECIPES
//                .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_silicone")
//                .EUt(VA[ULV]).duration(100)
//                .inputItems(wirePrefix, material)
//                .outputItems(cablePrefix, material);
//
//        // Apply a Polyphenylene Sulfate Foil if LuV or above.
//        if (voltageTier >= LuV) {
//            builder.inputItems(foil, PolyphenyleneSulfide, insulationAmount);
//        }
//
//        // Apply a PVC Foil if EV or above.
//        if (voltageTier >= EV) {
//            builder.inputItems(foil, PolyvinylChloride, insulationAmount);
//        }
//
//        builder.inputFluids(SiliconeRubber.getFluid(L * insulationAmount / 2))
//                .save(provider);
//
//        // Styrene Butadiene Rubber Recipe (all cables)
//        builder = ASSEMBLER_RECIPES
//                .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_styrene_butadiene")
//                .EUt(VA[ULV]).duration(100)
//                .inputItems(wirePrefix, material)
//                .outputItems(cablePrefix, material);
//
//        // Apply a Polyphenylene Sulfate Foil if LuV or above.
//        if (voltageTier >= LuV) {
//            builder.inputItems(foil, PolyphenyleneSulfide, insulationAmount);
//        }
//
//        // Apply a PVC Foil if EV or above.
//        if (voltageTier >= EV) {
//            builder.inputItems(foil, PolyvinylChloride, insulationAmount);
//        }
//
//        builder.inputFluids(StyreneButadieneRubber.getFluid(L * insulationAmount / 4))
//                .save(provider);
    }
    }

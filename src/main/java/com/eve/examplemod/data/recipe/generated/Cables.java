package com.eve.examplemod.data.recipe.generated;

import com.eve.examplemod.config.EVConfig;
import com.google.common.collect.ImmutableMap;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
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
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.PACKER_RECIPES;

public class Cables {

    // NB this is ALL subject to extreme change
    // todo figure out what i want to do with this

    private static final Map<TagPrefix, Integer> INSULATION_AMOUNT = ImmutableMap.of(
            cableGtSingle, 1,
            cableGtDouble, 1,
            cableGtQuadruple, 2,
            cableGtOctal, 3,
            cableGtHex, 5);

    public static void init(Consumer<FinishedRecipe> provider) {
        if (EVConfig.INSTANCE.reworkGTCableCovering) {
            wireGtSingle.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
            wireGtDouble.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
            wireGtQuadruple.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
            wireGtOctal.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
            wireGtHex.executeHandler(provider, PropertyKey.WIRE, Cables::generateCableCovering);
        }
    }

    public static void generateCableCovering(TagPrefix wirePrefix, Material material, WireProperties property,
                                             Consumer<FinishedRecipe> provider) {

        // Superconductors have no Cables, so exit early
        if (property.isSuperconductor()) return;

        int cableAmount = (int) (wirePrefix.getMaterialAmount(material) * 2 / M);
        TagPrefix cablePrefix = TagPrefix.get("cable" + wirePrefix.name().substring(4));
        int voltageTier = GTUtil.getTierByVoltage(property.getVoltage());
        int insulationAmount = INSULATION_AMOUNT.get(cablePrefix);

        // Generate hand-crafting recipes for ULV and LV cables
        if (voltageTier <= LV) {
            generateManualRecipe(wirePrefix, material, cablePrefix, cableAmount, provider);
        }
//        if (voltageTier <= LV) {
//            generateManualRecipe(wirePrefix, material, cablePrefix, cableAmount, provider);
//        }
        GTRecipeBuilder builder;

        // Polyethylene Recipe (ULV-EV cables)
        if (voltageTier <= EV) {
            for (int i = 0; i < 2; i++) {


                builder = ASSEMBLER_RECIPES
                        .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_polyethylene")
                        .EUt(VA[ULV]).duration(100)
                        .inputItems(wirePrefix, material)
                        .outputItems(cablePrefix, material)
                        .inputFluids(Polyethylene.getFluid(72 * insulationAmount));
                if (voltageTier > HV) {
                    if (i == 0) {
                        builder.inputItems(foil, PolyvinylChloride, 2 * insulationAmount);
                    } else builder.inputItems(foil, SiliconeRubber, 2 * insulationAmount);
                }
                builder.save(provider);


                builder = ASSEMBLER_RECIPES
                        .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_rubber")
                        .EUt(VA[ULV]).duration(100)
                        .inputItems(wirePrefix, material)
                        .outputItems(cablePrefix, material)
                        .inputFluids(Rubber.getFluid(L * insulationAmount));

                if (voltageTier > HV) {
                    if (i == 0) {
                        builder.inputItems(foil, PolyvinylChloride, 2 * insulationAmount);
                    } else builder.inputItems(foil, SiliconeRubber, 2 * insulationAmount);
                }
                builder.save(provider);

            }
        }

//        if (voltageTier <= IV) {
//            // maybe one of these should be better than the other? whichever is harder probably
//            builder = ASSEMBLER_RECIPES
//                    .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_polyvinyl_chloride")
//                    .EUt(VA[ULV]).duration(100)
//                    .inputItems(wirePrefix, material)
//                    .outputItems(cablePrefix, material)
//                    .inputFluids(PolyvinylChloride.getFluid(72 * insulationAmount));
//            builder.save(provider);
//
//            builder = ASSEMBLER_RECIPES
//                    .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_silicone")
//                    .EUt(VA[ULV]).duration(100)
//                    .inputItems(wirePrefix, material)
//                    .outputItems(cablePrefix, material)
//                    .inputFluids(SiliconeRubber.getFluid(72 * insulationAmount));
//            builder.save(provider);
//        }

        if (voltageTier <= LuV) {
            builder = ASSEMBLER_RECIPES
                    .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_pbi")
                    .EUt(VA[ULV]).duration(100)
                    .inputItems(wirePrefix, material)
                    .outputItems(cablePrefix, material)
                    .inputFluids(PolyphenyleneSulfide.getFluid(60 * insulationAmount));
            builder.save(provider);
        }

        if (voltageTier <= UV) {
            builder = ASSEMBLER_RECIPES
                    .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_pbi")
                    .EUt(VA[ULV]).duration(100)
                    .inputItems(wirePrefix, material)
                    .outputItems(cablePrefix, material)
                    .inputFluids(Polybenzimidazole.getFluid(56 * insulationAmount));
            builder.save(provider);
        }

        if (voltageTier <= UEV) {
            builder = ASSEMBLER_RECIPES
                    .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_peek")
                    .EUt(VA[ULV]).duration(100)
                    .inputItems(wirePrefix, material)
                    .outputItems(cablePrefix, material)
                    .inputFluids(Polyetheretherketone.getFluid(46 * insulationAmount));
            builder.save(provider);
        }

        if (voltageTier <= UXV) {
            builder = ASSEMBLER_RECIPES
                    .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_zylon")
                    .EUt(VA[ULV]).duration(100)
                    .inputItems(wirePrefix, material)
                    .outputItems(cablePrefix, material)
                    .inputFluids(Zylon.getFluid(32 * insulationAmount));
            builder.save(provider);
        }

//        if (voltageTier > UXV){
        builder = ASSEMBLER_RECIPES
                .recipeBuilder("cover_" + material.getName() + "_" + wirePrefix + "_fullerene_polymer_matrix")
                .EUt(VA[ULV]).duration(100)
                .inputItems(wirePrefix, material)
                .outputItems(cablePrefix, material)
                .inputFluids(FullerenePolymerMatrix.getFluid(16
                        // * (voltageTier + 1)
                        * insulationAmount));
        if (voltageTier == OpV) {
            builder.inputItems(INSULATION_WIRE_ASSEMBLY, insulationAmount);
        }
        if (voltageTier > OpV) {
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

    private static void generateManualRecipe(TagPrefix wirePrefix, Material material, TagPrefix cablePrefix,
                                             int cableAmount, Consumer<FinishedRecipe> provider) {
        int insulationAmount = INSULATION_AMOUNT.get(cablePrefix);
        Object[] ingredients = new Object[insulationAmount + 1];
        ingredients[0] = new UnificationEntry(wirePrefix, material);
        for (int i = 1; i <= insulationAmount; i++) {
            ingredients[i] = ChemicalHelper.get(plate, Rubber);
        }
        VanillaRecipeHelper.addShapelessRecipe(provider, String.format("%s_cable_%d", material.getName(), cableAmount),
                ChemicalHelper.get(cablePrefix, material),
                ingredients);

        PACKER_RECIPES.recipeBuilder("cover_" + material.getName() + "_" + wirePrefix)
                .inputItems(wirePrefix, material)
                .inputItems(plate, Rubber, insulationAmount)
                .outputItems(cablePrefix, material)
                .duration(100).EUt(VA[ULV])
                .save(provider);
    }
}

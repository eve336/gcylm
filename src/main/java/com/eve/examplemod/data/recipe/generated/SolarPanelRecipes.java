package com.eve.examplemod.data.recipe.generated;

import com.eve.examplemod.data.recipe.EVCraftingComponent;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.Map;
import java.util.function.Consumer;

import static com.eve.examplemod.EVMain.id;
import static com.eve.examplemod.common.data.EVItems.*;
import static com.eve.examplemod.common.data.EVMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.gemExquisite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class SolarPanelRecipes {
    static Map<Integer, Material> materialMap = Map.of(1, Diamond, 2, Ruby, 3, Ruby, 4, Emerald, 5, BlueTopaz, 6, RhodiumSalt, 7, CubicZirconia, 8, LeadZirconateTitanate);
    static Map<Integer, ItemEntry<ComponentItem>> itemEntryMap = Map.of(1, LV_SOLAR_PANEL, 2, MV_SOLAR_PANEL, 3, HV_SOLAR_PANEL, 4, EV_SOLAR_PANEL, 5, IV_SOLAR_PANEL, 6, LuV_SOLAR_PANEL, 7, ZPM_SOLAR_PANEL, 8, UV_SOLAR_PANEL);
    public static void init(Consumer<FinishedRecipe> provider) {
        for (int i = 1; i < 9; i++) {
            VanillaRecipeHelper.addShapedRecipe(provider, true, id(GTValues.VN[i].toLowerCase() + "_solar"),
                    itemEntryMap.get(i).asStack(),
                    "SGS",
                    "CHC",
                    "WBW",
                    'B', EVCraftingComponent.BATTERY.getIngredient(i),
                    'S', CraftingComponent.SENSOR.getIngredient(i + 3),
                    'G', ChemicalHelper.get(gemExquisite, materialMap.get(i)),
                    'C', CraftingComponent.CIRCUIT.getIngredient(i + 3),
                    'W', CraftingComponent.CABLE.getIngredient(i + 3),
                    'H', CraftingComponent.HULL.getIngredient(i + 3)
            );
        }
    }
}

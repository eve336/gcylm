package com.eve.examplemod.mixins;

import com.eve.examplemod.config.EVConfig;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.generated.WireRecipeHandler;
import net.minecraft.data.recipes.FinishedRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(WireRecipeHandler.class)
public class CableCoveringMixin {
    @Inject(
            method = "generateCableCovering",
            at = @At(value = "HEAD", remap = false),
            cancellable = true

    )
    private static void mixin(TagPrefix wirePrefix, Material material, WireProperties property, Consumer<FinishedRecipe> provider, CallbackInfo ci){
        if (EVConfig.INSTANCE.reworkGTCableCovering) {
            ci.cancel();
        }
    }
}

package com.eve.examplemod.mixins;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.materials.SecondDegreeMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;


@Mixin(SecondDegreeMaterials.class)
public abstract class NaqAlloyMixin {
    @Redirect(
            method = "register",
            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/data/chemical/material/Material$Builder;components([Ljava/lang/Object;)Lcom/gregtechceu/gtceu/api/data/chemical/material/Material$Builder;", ordinal = 39),
            remap = false
    )
    private static Material.Builder mixin(Material.Builder instance, Object[] i){
        return instance.components(Naquadah, 2, Osmiridium, 1);
    }
}

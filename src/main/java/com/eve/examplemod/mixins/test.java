package com.eve.examplemod.mixins;

import com.gregtechceu.gtceu.common.data.materials.SecondDegreeMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SecondDegreeMaterials.class)
public class test {
    @Redirect(
            method = "register"
            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/data/chemical/material/Material$Builder;components([Ljava/lang/Object;)Lcom/gregtechceu/gtceu/api/data/chemical/material/Material$Builder;")
    )
}

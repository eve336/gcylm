package com.eve.examplemod.mixins;

import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GTMachines.class)
public class MinerSpeedMixin {
    @Redirect(
            method = "<clinit>",
            at = @At(value = "INVOKE", target = "MinerMachine")
    )
    private static void mixin(){

    }
}

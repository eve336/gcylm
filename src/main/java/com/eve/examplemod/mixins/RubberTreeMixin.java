package com.eve.examplemod.mixins;

import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(WorkableElectricMultiblockMachine.class)
public class RubberTreeMixin {
    @Inject(method = "onStructureFormed", at = @At("HEAD"), remap = false)
    private void mixin(CallbackInfo ci) {
//        System.out.println("ohio");
    }
}

package com.eve.examplemod.mixins;

import appeng.blockentity.storage.DriveBlockEntity;
import com.eve.examplemod.config.EVConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(DriveBlockEntity.class)
public abstract class DrivePowerMixin {
    @ModifyVariable(
            method = "updateState",
            at = @At(value = "STORE", ordinal = 0),
            index = 1
    )
    private double mixin(double power){
        if (EVConfig.INSTANCE.configEnergyDrainDrive) {
            return EVConfig.INSTANCE.driveEnergyDrainBase;
        }
        return 2.0;
    }
}

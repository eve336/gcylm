package com.eve.examplemod.mixins;

import com.eve.examplemod.config.EVConfig;
import earth.terrarium.adastra.common.systems.EnvironmentEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(EnvironmentEffects.class)
public class AdAstraMixin {
    @Inject(method = "tickBlock", at = @At("HEAD"), cancellable = true)
    private static void mixin(ServerLevel level, BlockPos pos, BlockState state, CallbackInfo ci){
        if (!EVConfig.INSTANCE.adAstraBreaksBlocks){
            ci.cancel();
        }
    }
}

package com.eve.examplemod.mixins;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;

//@Mixin(GTMachines.class)
//public class quadenergyhatch {
//    // HHWYWHGYG WHY AM I SO STUPUID LMAO <<<< JUST COPY THE CODE FROM GT AND MAKE THEM FOR LOW TIERS
//    @WrapOperation(
//            method = "<clinit>",
//            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/common/data/machines/GTMachineUtils;registerTieredMachines(Ljava/lang/String;Ljava/util/function/BiFunction;Ljava/util/function/BiFunction;[I)[Lcom/gregtechceu/gtceu/api/machine/MachineDefinition;", ordinal = 20)
//    )
//    private static MachineDefinition[] Mixin(String register, BiFunction<IMachineBlockEntity, Integer, MetaMachine> tier, BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> name, int[] factory, Operation<MachineDefinition[]> original){
//        factory = GTValues.tiersBetween(LV, GTCEuAPI.isHighTier() ? MAX : UHV);
//        return original.call(register, tier, name, factory);
//    }
//}

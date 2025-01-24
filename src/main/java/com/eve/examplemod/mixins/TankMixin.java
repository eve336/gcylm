package com.eve.examplemod.mixins;

import com.eve.examplemod.config.EVConfig;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.client.renderer.machine.QuantumTankRenderer;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.machine.storage.QuantumTankMachine;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.gregtechceu.gtceu.api.GTValues.LVT;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;

//@Mixin(GTMachines.class)
//public class TankMixin {
//    @Redirect(
//            method = "<clinit>",
//            at = @At(value = "FIELD", target = "Lcom/gregtechceu/gtceu/common/data/GTMachines;MINER:[Lcom/gregtechceu/gtceu/api/machine/MachineDefinition;", remap = false)
//
//    )
//    private static void mixin(MachineDefinition[] value){
//            registerTieredMachines("super_tank",
//                    (holder, tier) -> new QuantumTankMachine(holder, tier,
//                            16000 * FluidType.BUCKET_VOLUME * (long) Math.pow(2, tier - 1)),
//                    (tier, builder) -> builder
//                            .langValue("Super Tank " + LVT[tier])
//                            .blockProp(BlockBehaviour.Properties::dynamicShape)
//                            .rotationState(RotationState.ALL)
//                            .renderer(() -> new QuantumTankRenderer(tier))
//                            .hasTESR(true)
//                            .tooltipBuilder(TANK_TOOLTIPS)
//                            .tooltips(Component.translatable("gtceu.machine.quantum_tank.tooltip"),
//                                    Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity",
//                                            FormattingUtil.formatNumbers(4_000_000 * (long) Math.pow(2, tier - 1))))
//                            .register(),
//                    LOW_TIERS);
//
//    }
//}

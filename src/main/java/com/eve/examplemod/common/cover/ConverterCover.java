package com.eve.examplemod.common.cover;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.capability.compat.EUToFEProvider;
import com.gregtechceu.gtceu.api.cover.CoverBehavior;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.machine.TieredEnergyMachine;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ConverterCover extends CoverBehavior {



    public ConverterCover(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide, int tier) {
        super(definition, coverHolder, attachedSide);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (coverHolder instanceof TieredEnergyMachine machine) {

        }
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    private static class skibidi {
        @SubscribeEvent
        public static void listen(AttachCapabilitiesEvent<BlockEntity> event) {
            if (event.getObject() instanceof MetaMachineBlockEntity){
                event.addCapability(EVMain.id("fe_capability"), new EUToFEProvider(event.getObject()));
            }
        }
    }

}

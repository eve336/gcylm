package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.cover.*;
import com.gregtechceu.gtceu.client.renderer.cover.*;

import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("SpellCheckingInspection")
public class EVCovers {

    public static class CoverInfo {
        public ResourceLocation id;
        public CoverDefinition definition;

        CoverInfo(String id, CoverDefinition.TieredCoverBehaviourProvider behavior, ICoverRenderer renderer) {
            this.id = EVMain.id(id);
            this.definition = register(id, behavior, renderer);
        }
    };





    public static CoverInfo ROBOT_ARM = new CoverInfo(
            "robot_arm",
            RobotArmCover::new,
            RobotArmCoverRenderer.INSTANCE
    );

    public static CoverInfo PUMP = new CoverInfo(
            "pump",
            PumpCover::new,
            PumpCoverRenderer.INSTANCE
    );

    public static CoverInfo CONVEYOR = new CoverInfo(
            "conveyor",
            ConveyorCover::new,
            ConveyorCoverRenderer.INSTANCE
    );





    public static CoverDefinition register(
            String id,
            CoverDefinition.TieredCoverBehaviourProvider behavior,
            ICoverRenderer renderer
    ) {
        var definition = new CoverDefinition(EVMain.id(id),
                (def, coverable, side) -> behavior.create(def, coverable, side, GTValues.MAX),
                renderer);

        return definition;
    }
}
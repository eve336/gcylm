package com.eve.examplemod.common.data;

import com.eve.examplemod.common.cover.EVSolarPanel;
import com.eve.examplemod.common.cover.ConverterCover;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.cover.*;
import com.gregtechceu.gtceu.client.renderer.cover.*;

import it.unimi.dsi.fastutil.ints.Int2ObjectFunction;

import java.util.Arrays;
import java.util.Locale;



@SuppressWarnings("SpellCheckingInspection")
public class EVCovers {


    public static final int[] ALL_TIERS_WITH_ULV = GTValues.tiersBetween(GTValues.ULV, GTValues.MAX);


    public static CoverDefinition[] EVSOLAR = registerTiered(
            "ev_solar",
            EVSolarPanel::new,
            tier -> new SimpleCoverRenderer(GTCEu.id("block/cover/overlay_solar_panel")), ALL_TIERS_WITH_ULV
    );

    public static CoverDefinition[] CONVERTER = registerTiered(
            "converter",
            ConverterCover::new,
            tier -> new SimpleCoverRenderer(GTCEu.id("block/cover/overlay_solar_panel")), ALL_TIERS_WITH_ULV
    );

    public static CoverDefinition[] ROBOT_ARM = registerTiered(
            "ev_robot_arm",
            RobotArmCover::new,
            tier -> RobotArmCoverRenderer.INSTANCE, ALL_TIERS_WITH_ULV
    );

    public static CoverDefinition[] PUMP = registerTiered(
            "ev_pump",
            PumpCover::new,
            tier -> PumpCoverRenderer.INSTANCE, ALL_TIERS_WITH_ULV
    );

    public static CoverDefinition[] CONVEYOR = registerTiered(
            "ev_conveyor",
            ConveyorCover::new,
            tier -> ConveyorCoverRenderer.INSTANCE, ALL_TIERS_WITH_ULV
    );

    public static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator) {
        return register(id, behaviorCreator, new SimpleCoverRenderer(GTCEu.id("block/cover/" + id)));
    }

    public static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                           ICoverRenderer coverRenderer) {
        var definition = new CoverDefinition(GTCEu.id(id), behaviorCreator, coverRenderer);
        GTRegistries.COVERS.register(GTCEu.id(id), definition);
        return definition;
    }

    public static CoverDefinition[] registerTiered(String id,
                                                   CoverDefinition.TieredCoverBehaviourProvider behaviorCreator,
                                                   Int2ObjectFunction<ICoverRenderer> coverRenderer, int... tiers) {
        return Arrays.stream(tiers).mapToObj(tier -> {
            var name = id + "." + GTValues.VN[tier].toLowerCase(Locale.ROOT);
            return register(name, (def, coverable, side) -> behaviorCreator.create(def, coverable, side, tier),
                    coverRenderer.apply(tier));
        }).toArray(CoverDefinition[]::new);
    }

    public static CoverDefinition[] registerTiered(String id,
                                                   CoverDefinition.TieredCoverBehaviourProvider behaviorCreator,
                                                   int... tiers) {
        return Arrays.stream(tiers).mapToObj(tier -> {
            var name = id + "." + GTValues.VN[tier].toLowerCase(Locale.ROOT);
            return register(name, (def, coverable, side) -> behaviorCreator.create(def, coverable, side, tier));
        }).toArray(CoverDefinition[]::new);
    }


    public static void init() {
    }
}
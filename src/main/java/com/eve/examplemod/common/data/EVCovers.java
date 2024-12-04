package com.eve.examplemod.common.data;

import com.eve.examplemod.EVMain;
import com.eve.examplemod.common.cover.EVSolarPanel;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.addon.AddonFinder;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.cover.*;
import com.gregtechceu.gtceu.client.renderer.cover.*;

import it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoader;

import java.util.Arrays;
import java.util.Locale;

import static com.gregtechceu.gtceu.common.data.GTCovers.ALL_TIERS_WITH_ULV;
import static com.gregtechceu.gtceu.common.data.GTCovers.registerTiered;

@SuppressWarnings("SpellCheckingInspection")
public class EVCovers {




    public static CoverDefinition[] EVSOLAR = registerTiered(
            "ev_solar",
            EVSolarPanel::new,
            tier -> new SimpleCoverRenderer(GTCEu.id("block/cover/overlay_solar_panel")), ALL_TIERS_WITH_ULV
    );

    public static CoverDefinition[] ROBOT_ARM = registerTiered(
            "robot_arm",
            RobotArmCover::new,
            tier -> RobotArmCoverRenderer.INSTANCE, GTValues.MAX
    );

    public static CoverDefinition[] PUMP = registerTiered(
            "pump",
            PumpCover::new,
            tier -> PumpCoverRenderer.INSTANCE, GTValues.MAX
    );

    public static CoverDefinition[] CONVEYOR = registerTiered(
            "conveyor",
            ConveyorCover::new,
            tier -> ConveyorCoverRenderer.INSTANCE, GTValues.MAX
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
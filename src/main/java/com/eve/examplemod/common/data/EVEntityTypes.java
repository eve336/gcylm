package com.eve.examplemod.common.data;

import com.eve.examplemod.common.entity.LeptonicEntity;
import com.eve.examplemod.common.entity.QCDEntity;
import com.gregtechceu.gtceu.common.entity.IndustrialTNTEntity;
import com.tterrag.registrate.util.entry.EntityEntry;
import net.minecraft.world.entity.MobCategory;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class EVEntityTypes {

    public static final EntityEntry<LeptonicEntity> LEPTONIC_CHARGE = REGISTRATE
            .<LeptonicEntity>entity("leptonic_charge", LeptonicEntity::new, MobCategory.MISC)
            .lang("Leptonic Charge")
            .properties(builder -> builder.sized(0.98F, 0.98F).fireImmune().clientTrackingRange(10).updateInterval(10))
            .register();

    public static final EntityEntry<QCDEntity> QCD_CHARGE = REGISTRATE
            .<QCDEntity>entity("qcd_charge", QCDEntity::new, MobCategory.MISC)
            .lang("Leptonic Charge")
            .properties(builder -> builder.sized(0.98F, 0.98F).fireImmune().clientTrackingRange(10).updateInterval(10))
            .register();
    public static void init(){}
}

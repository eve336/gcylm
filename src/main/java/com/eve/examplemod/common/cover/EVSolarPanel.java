package com.eve.examplemod.common.cover;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.common.cover.CoverSolarPanel;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.haoict.tiab.common.entities.TimeAcceleratorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import com.magorage.tiab.api.ITimeInABottleAPI;
import net.minecraft.world.phys.AABB;

import java.util.List;

import static com.eve.examplemod.EVMain.isTiabLoaded;


public class EVSolarPanel extends CoverSolarPanel {
    private final long EUt;
    public EVSolarPanel(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide, int tier) {
        super(definition, coverHolder, attachedSide, tier);
        this.EUt = GTValues.V[tier];

    }
    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    protected void update() {
        if(isTiabLoaded()) {
            Level level = coverHolder.getLevel();
            List<TimeAcceleratorEntity> entities = level.getEntitiesOfClass(TimeAcceleratorEntity.class, new AABB(coverHolder.getPos(), (coverHolder.getPos().offset(1, 1, 1))));
            if (!entities.isEmpty()) {
                int max = entities.stream().mapToInt(TimeAcceleratorEntity::getTimeRate).max().orElseThrow();
                    BlockPos blockPos = coverHolder.getPos();
                    if (GTUtil.canSeeSunClearly(level, blockPos)) {
                        IEnergyContainer energyContainer = getEnergyContainer();
                        if (energyContainer != null) {
                            for (int i = 0; i < max; i++) {
                                energyContainer.addEnergy(EUt);
                            }
                        }
                    }
                    return;
            }
            super.update();
            return;
        }
        super.update();
    }
}

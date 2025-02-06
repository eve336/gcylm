package com.eve.examplemod.common.cover;

import com.eve.examplemod.EVUtils;
import com.eve.examplemod.config.EVConfig;
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

    // this is the worst code if ever written

    void ohio(){
        Level level = coverHolder.getLevel();
        BlockPos blockPos = coverHolder.getPos();
        if (EVConfig.INSTANCE.solarsWorkInNether && EVUtils.canSeeSunClearly(level, blockPos) || GTUtil.canSeeSunClearly(level, blockPos)){
            IEnergyContainer energyContainer = getEnergyContainer();
            if (energyContainer == null) return;
            if (isTiabLoaded()){
                List<TimeAcceleratorEntity> entities = level.getEntitiesOfClass(TimeAcceleratorEntity.class, new AABB(coverHolder.getPos(), (coverHolder.getPos().offset(1, 1, 1))));
                if (!entities.isEmpty()) {
                    int max = entities.stream().mapToInt(TimeAcceleratorEntity::getTimeRate).max().orElseThrow();
                    for (int i = 0; i < max; i++) {
                        energyContainer.addEnergy(EUt);
                    }
                    return;
                }
            }
            energyContainer.acceptEnergyFromNetwork(null, EUt, 1);
        }
    }

    @Override
    protected void update() {
        Level level = coverHolder.getLevel();
        BlockPos blockPos = coverHolder.getPos();
        if (EVConfig.INSTANCE.solarsWorkInNether && EVUtils.canSeeSunClearly(level, blockPos) || GTUtil.canSeeSunClearly(level, blockPos)){
            IEnergyContainer energyContainer = getEnergyContainer();
            if (energyContainer == null) return;
            if (isTiabLoaded()){
                List<TimeAcceleratorEntity> entities = level.getEntitiesOfClass(TimeAcceleratorEntity.class, new AABB(coverHolder.getPos(), (coverHolder.getPos().offset(1, 1, 1))));
                if (!entities.isEmpty()) {
                    int max = entities.stream().mapToInt(TimeAcceleratorEntity::getTimeRate).max().orElseThrow();
                    for (int i = 0; i < max; i++) {
                        energyContainer.addEnergy(EUt);
                    }
                    return;
                }
            }
            energyContainer.acceptEnergyFromNetwork(null, EUt, 1);
        }
//        Level level = coverHolder.getLevel();
//        BlockPos blockPos = coverHolder.getPos();
//        if (isTiabLoaded()) {
//            List<TimeAcceleratorEntity> entities = level.getEntitiesOfClass(TimeAcceleratorEntity.class, new AABB(coverHolder.getPos(), (coverHolder.getPos().offset(1, 1, 1))));
//            if (!entities.isEmpty()) {
//                int max = entities.stream().mapToInt(TimeAcceleratorEntity::getTimeRate).max().orElseThrow();
//                if (EVConfig.INSTANCE.solarsWorkInNether) {
//                    if (EVUtils.canSeeSunClearly(level, blockPos)) {
//                        IEnergyContainer energyContainer = getEnergyContainer();
//                        if (energyContainer != null) {
//                            for (int i = 0; i < max; i++) {
//                                energyContainer.addEnergy(EUt);
//                            }
//                        }
//                    }
//                    return;
//                }
//                if (GTUtil.canSeeSunClearly(level, blockPos)) {
//                    IEnergyContainer energyContainer = getEnergyContainer();
//                    if (energyContainer != null) {
//                        for (int i = 0; i < max; i++) {
//                            energyContainer.addEnergy(EUt);
//                        }
//                    }
//                }
//                return;
//            }
//            if (EVConfig.INSTANCE.solarsWorkInNether) {
//                updateNether(level, blockPos);
//            }
//            else super.update();
//            return;
//        }
//        if (EVConfig.INSTANCE.solarsWorkInNether) {
//            updateNether(level, blockPos);
//        }
//        else super.update();
    }

    void updateNether(Level level, BlockPos blockPos) {
        if (EVUtils.canSeeSunClearly(level, blockPos)) {
            IEnergyContainer energyContainer = getEnergyContainer();
            if (energyContainer != null) {
                energyContainer.acceptEnergyFromNetwork(null, EUt, 1);
            }
        }
    }
}

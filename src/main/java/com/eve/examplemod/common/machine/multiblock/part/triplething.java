package com.eve.examplemod.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableEnergyContainer;
import com.gregtechceu.gtceu.common.machine.multiblock.part.DualHatchPartMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

public class triplething extends DualHatchPartMachine implements IExplosionMachine {

    @Persisted
    public final NotifiableEnergyContainer energyContainer;
    @Getter
    protected int amperage;
    protected TickableSubscription explosionSubs;
    @Nullable
    protected ISubscription energyListener;

    public triplething(IMachineBlockEntity holder, int tier, IO io, int amperage, Object... args) {
        super(holder, tier, io, args);
        this.amperage = amperage;
        this.energyContainer = createEnergyContainer(args);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected NotifiableEnergyContainer createEnergyContainer(Object... args) {
        NotifiableEnergyContainer container;
        if (io == IO.OUT) {
            container = NotifiableEnergyContainer.emitterContainer(this, GTValues.V[tier] * 64L * amperage, GTValues.V[tier], amperage);
            container.setSideOutputCondition(s -> s == getFrontFacing() && isWorkingEnabled());
            container.setCapabilityValidator(s -> s == null || s == getFrontFacing());
        } else {
            container = NotifiableEnergyContainer.receiverContainer(this, GTValues.V[tier] * 16L * amperage, GTValues.V[tier], amperage);
            container.setSideInputCondition(s -> s == getFrontFacing() && isWorkingEnabled());
            container.setCapabilityValidator(s -> s == null || s == getFrontFacing());
        }
        return container;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        // if machine need to check explosion conditions
        if (ConfigHolder.INSTANCE.machines.doTerrainExplosion && shouldWeatherOrTerrainExplosion()) {
            energyListener = energyContainer.addChangedListener(this::updateExplosionSubscription);
            updateExplosionSubscription();
        }
    }

    protected void updateExplosionSubscription() {
        if (ConfigHolder.INSTANCE.machines.doTerrainExplosion && shouldWeatherOrTerrainExplosion() && energyContainer.getEnergyStored() > 0) {
            explosionSubs = subscribeServerTick(explosionSubs, this::checkExplosion);
        } else if (explosionSubs != null) {
            explosionSubs.unsubscribe();
            explosionSubs = null;
        }
    }

    protected void checkExplosion() {
        checkWeatherOrTerrainExplosion(tier, tier * 10);
        updateExplosionSubscription();
    }

    public int getAmperage() {
        return this.amperage;
    }

}

package com.eve.examplemod.data.forge;

import com.eve.examplemod.EVMain;
import com.eve.examplemod.common.data.EVConfiguredFeatures;
import com.gregtechceu.gtceu.api.registry.registrate.SoundEntryBuilder;
import com.gregtechceu.gtceu.data.tags.BiomeTagsLoader;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        var registries = event.getLookupProvider();
        if (event.includeClient()) {
            generator.addProvider(true, new SoundEntryBuilder.SoundEntryProvider(packOutput, EVMain.MOD_ID));
        }
        if (event.includeServer()) {
            var set = Set.of(EVMain.MOD_ID);
            generator.addProvider(true, new BiomeTagsLoader(packOutput, registries, existingFileHelper));
            DatapackBuiltinEntriesProvider provider = generator.addProvider(true, new DatapackBuiltinEntriesProvider(
                    packOutput, registries, new RegistrySetBuilder()
                    .add(Registries.CONFIGURED_FEATURE, EVConfiguredFeatures::bootstrap),
                    set));
//            generator.addProvider(true,
//                    new DamageTagsLoader(packOutput, provider.getRegistryProvider(), existingFileHelper));
        }
    }
}

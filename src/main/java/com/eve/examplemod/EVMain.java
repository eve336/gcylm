package com.eve.examplemod;

import com.eve.examplemod.api.data.material.info.EVMaterialIconType;
import com.eve.examplemod.api.registries.EVRegistries;
import com.eve.examplemod.common.data.*;
import com.eve.examplemod.common.data.machines.EVMachines;
import com.eve.examplemod.common.data.machines.EVMultiMachines;
import com.eve.examplemod.config.EVConfig;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.lowdragmc.lowdraglib.LDLib;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EVMain.MOD_ID)
public class EVMain {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LogManager.getLogger();
    public static GTRegistrate EV_REGISTRATE = GTRegistrate.create(EVMain.MOD_ID);
    public static MaterialRegistry MATERIAL_REGISTRY;




    public EVMain() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        EVMain.init();


        bus.register(this);
        bus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        bus.addGenericListener(MachineDefinition.class, this::registerMachines);
        // Most other events are fired on Forge's bus.
        // If we want to use annotations to register event listeners,
        // we need to register our object like this!
    }



    private static void init() {
        EVRegistries.REGISTRATE.registerRegistrate();
        EVDatagen.init();
        EVBlocks.init();
        EVConfig.init();
        EVMaterialIconType.init();

    }



    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
            LOGGER.info("Look, I found a {}!", Items.DIAMOND);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

    // You MUST have this for custom materials.
    // Remember to register them not to GT's namespace, but your own.

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(EVMain.MOD_ID);
    }



    // As well as this.
    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        //CustomMaterials.init();
        EVMaterials.init();
        EVMaterials2.init();
    }

    @SubscribeEvent
    // This is optional, though.
    public void modifyMaterials(PostMaterialEvent event) {
        //CustomMaterials.modify();
        EVMaterials.modifyMaterials();
    }

    @SubscribeEvent
    public void onLoadComplete(FMLLoadCompleteEvent event) {
        GTCEuAPI.HEATING_COILS.remove(CoilBlock.CoilType.KANTHAL);
    }

    public static boolean isTiabLoaded(){
        return LDLib.isModLoaded("tiab");
    }



    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        //CustomRecipeTypes.init();
        EVRecipeTypes.init();
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        //CustomMachines.init();
        EVMachines.init();
        EVMultiMachines.init();
    }
}
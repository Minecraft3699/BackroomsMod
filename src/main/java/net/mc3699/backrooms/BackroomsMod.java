package net.mc3699.backrooms;

import net.mc3699.backrooms.blocks.ModBlockEntities;
import net.mc3699.backrooms.blocks.ModBlocks;
import net.mc3699.backrooms.dimension.ModChunkGenerators;
import net.mc3699.backrooms.entity.ModEntities;
import net.mc3699.backrooms.entity.client.HowlerRenderer;
import net.mc3699.backrooms.entity.client.LifeformRenderer;
import net.mc3699.backrooms.items.CreativeTab;
import net.mc3699.backrooms.items.ModItems;
import net.mc3699.backrooms.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BackroomsMod.MODID)
public class BackroomsMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "mcbr";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public BackroomsMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        CreativeTab.register(modEventBus);
        ModSounds.register(modEventBus);
        ModChunkGenerators.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @EventBusSubscriber(modid = BackroomsMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.HOWLER_ENTITY, HowlerRenderer::new);
            EntityRenderers.register(ModEntities.LIFEFORM_ENTITY, LifeformRenderer::new);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}

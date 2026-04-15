package net.mc3699.backrooms;

import dev.anvilcraft.lib.v2.registrum.Registrum;
import net.mc3699.backrooms.registry.BRBlockEntities;
import net.mc3699.backrooms.registry.BRBlocks;
import net.mc3699.backrooms.dimension.ModChunkGenerators;
import net.mc3699.backrooms.entity.ModEntities;
import net.mc3699.backrooms.entity.client.HowlerRenderer;
import net.mc3699.backrooms.entity.client.LifeformRenderer;
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

@Mod(Backrooms.MODID)
public class Backrooms
{
    public static final String MODID = "mcbr";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Registrum REGISTRUM = Registrum.create(MODID);


    public Backrooms(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        BRBlocks.init();
        BRBlockEntities.init();

        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModChunkGenerators.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @EventBusSubscriber(modid = Backrooms.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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

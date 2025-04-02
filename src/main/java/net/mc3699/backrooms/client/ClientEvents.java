package net.mc3699.backrooms.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.Light;
import foundry.veil.api.client.render.light.PointLight;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import foundry.veil.api.client.render.shader.VeilShaders;
import net.mc3699.backrooms.BackroomsMod;
import net.mc3699.backrooms.blocks.Level1CeilingLightBlock;
import net.mc3699.backrooms.dimension.BackroomsGeneration;
import net.mc3699.backrooms.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.io.IOException;
import java.net.Proxy;
import java.util.List;

@EventBusSubscriber(modid = BackroomsMod.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientEvents {
    private static boolean ambiencePlaying = false;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Pre event)
    {

        if(Minecraft.getInstance().level != null)
        {
            Minecraft mc = Minecraft.getInstance();

            ResourceKey<Level> dimKey = Minecraft.getInstance().player.level().dimension();
            if(dimKey.equals(BackroomsGeneration.BACKROOMS_DIM_KEY))
            {
                if(!ambiencePlaying)
                {
                    mc.getSoundManager().play(SimpleSoundInstance.forAmbientAddition(ModSounds.LVL1_CEILING_LIGHT.get()));
                    ambiencePlaying = true;
                }
            } else {
                if(ambiencePlaying)
                {
                    mc.getSoundManager().stop();
                    ambiencePlaying = false;
                }
            }
        }
    }

}

package net.mc3699.backrooms.client;

import net.mc3699.backrooms.BackroomsMod;
import net.mc3699.backrooms.blocks.Level1CeilingLightBlock;
import net.mc3699.backrooms.dimension.BackroomsGeneration;
import net.mc3699.backrooms.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

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

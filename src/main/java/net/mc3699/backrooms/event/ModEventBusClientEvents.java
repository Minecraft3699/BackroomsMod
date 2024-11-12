package net.mc3699.backrooms.event;

import net.mc3699.backrooms.BackroomsMod;
import net.mc3699.backrooms.entity.client.HowlerPlaceholderModel;
import net.mc3699.backrooms.entity.client.LifeformModel;
import net.mc3699.backrooms.entity.client.ModModelLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = BackroomsMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        // Legacy test entity, ignore. you really wanted it so it stays
        event.registerLayerDefinition(ModModelLayers.HOWLER_LAYER, HowlerPlaceholderModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LIFEFORM_GEN_1_LAYER, LifeformModel::createBodyLayer);
    }

}

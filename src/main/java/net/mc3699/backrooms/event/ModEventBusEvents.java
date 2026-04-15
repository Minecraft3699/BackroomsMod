package net.mc3699.backrooms.event;

import net.mc3699.backrooms.Backrooms;
import net.mc3699.backrooms.entity.ModEntities;
import net.mc3699.backrooms.entity.behavior.HowlerEntity;
import net.mc3699.backrooms.entity.behavior.LifeformEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Backrooms.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.HOWLER_ENTITY, HowlerEntity.createHowlerAttributes().build());
        event.put(ModEntities.LIFEFORM_ENTITY, LifeformEntity.createAttributes().build());
    }
}

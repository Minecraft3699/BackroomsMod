package net.mc3699.backrooms.entity;

import net.mc3699.backrooms.Backrooms;
import net.mc3699.backrooms.entity.behavior.HowlerEntity;
import net.mc3699.backrooms.entity.behavior.LifeformEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.RegisterEvent;

public class ModEntities {

    // Howler Entity (legacy, do not remove the funny man)
    public static final ResourceKey<EntityType<?>> HOWLER_ENTITY_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "howler"));

    public static EntityType<HowlerEntity> HOWLER_ENTITY;


    // Gen 1 Lifeform
    public static final ResourceKey<EntityType<?>> LIFEFORM_GEN_1_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "lifeform_gen_1"));

    public static EntityType<LifeformEntity> LIFEFORM_ENTITY;


    public static void registerEntities(RegisterEvent event)
    {
        event.register(Registries.ENTITY_TYPE, registry -> {
            HOWLER_ENTITY = EntityType.Builder.<HowlerEntity>of(HowlerEntity::new, MobCategory.MONSTER).sized(0.5f, 2.5f).build("howler");
            LIFEFORM_ENTITY = EntityType.Builder.<LifeformEntity>of(LifeformEntity::new, MobCategory.MONSTER).sized(2.5f, 3f).build("lifeform_gen_1");


            registry.register(HOWLER_ENTITY_KEY, HOWLER_ENTITY);
            registry.register(LIFEFORM_GEN_1_KEY, LIFEFORM_ENTITY);
        });
    }


    public static void register(IEventBus eventBus)
    {
        eventBus.addListener(ModEntities::registerEntities);
    }

}

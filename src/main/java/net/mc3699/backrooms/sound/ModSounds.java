package net.mc3699.backrooms.sound;

import net.mc3699.backrooms.BackroomsMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, BackroomsMod.MODID);

    public static Supplier<SoundEvent> registerSoundEvent(String name)
    {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(BackroomsMod.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }


    public static final Supplier<SoundEvent> AUDITORY_GUIDEPOST = registerSoundEvent("auditory_guidepost_ping");
    public static final Supplier<SoundEvent> LVL1_CEILING_LIGHT = registerSoundEvent("light_1");




    public static void register(IEventBus modEventBus)
    {
        SOUND_EVENTS.register(modEventBus);
    }

}
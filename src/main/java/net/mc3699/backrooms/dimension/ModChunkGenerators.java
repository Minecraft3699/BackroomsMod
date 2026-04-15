package net.mc3699.backrooms.dimension;

import com.mojang.serialization.MapCodec;
import net.mc3699.backrooms.Backrooms;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModChunkGenerators {

    public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNK_GENERATORS =
            DeferredRegister.create(Registries.CHUNK_GENERATOR, Backrooms.MODID);

    public static void register(IEventBus eventBus)
    {
        CHUNK_GENERATORS.register("backrooms", () -> BackroomsChunkGenerator.CODEC);
        CHUNK_GENERATORS.register(eventBus);
    }
}

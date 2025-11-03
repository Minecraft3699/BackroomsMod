package net.mc3699.backrooms.dimension.util;

import net.minecraft.world.level.chunk.LevelChunk;

import java.util.Map;
import java.util.WeakHashMap;

public class StructureConnectionStorage {

    private static final Map<LevelChunk, StructureConnectionData> CHUNK_DATA_MAP = new WeakHashMap<>();

    public static StructureConnectionData get(LevelChunk chunk) {
        return CHUNK_DATA_MAP.computeIfAbsent(chunk, c -> new StructureConnectionData());
    }

}

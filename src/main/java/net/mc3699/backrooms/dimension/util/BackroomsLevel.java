package net.mc3699.backrooms.dimension.util;

import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.RandomState;

public abstract class BackroomsLevel {

    public abstract void generate(WorldGenRegion worldGenRegion, StructureManager structureManager, RandomState randomState, ChunkAccess chunkAccess);

    public abstract int getStartLevel();

    public abstract int getEndLevel();

}

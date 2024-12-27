package net.mc3699.backrooms.dimension.levels;

import net.mc3699.backrooms.blocks.ModBlocks;
import net.mc3699.backrooms.dimension.GenNoise;
import net.mc3699.backrooms.dimension.util.GenUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

import static net.mc3699.backrooms.dimension.util.GenUtil.generateBasicWallsWithExtension;
import static net.mc3699.backrooms.dimension.util.GenUtil.isChunkInNoise;

public class BackroomsL1 {

    private final static int L1_FLOOR_LEVEL = -62;
    private final static int L1_CEILING_LEVEL = -56;

    public static void generateChunk(ChunkAccess chunk)
    {
        GenUtil.generateBeams(chunk, L1_CEILING_LEVEL + 2);
        GenUtil.fillLayer(chunk, L1_CEILING_LEVEL + 3, Blocks.OAK_PLANKS);

        GenUtil.fillLayer(chunk, L1_CEILING_LEVEL, ModBlocks.LVL1_CEILING_TILE.get());

        if(isChunkInNoise(chunk.getPos().x, chunk.getPos().z, GenNoise.PlusRoomNoise, 0.6))
        {
            GenUtil.generateCrossShape(chunk,L1_FLOOR_LEVEL,L1_CEILING_LEVEL);
            GenUtil.generateLights(chunk, L1_CEILING_LEVEL);
            return;
        }
        if(!isChunkInNoise(chunk.getPos().x,chunk.getPos().z, GenNoise.UnlitRoomNoise, 0.2)) {
            GenUtil.generateLights(chunk, L1_CEILING_LEVEL);
        }

        if(!isChunkInNoise(chunk.getPos().x,chunk.getPos().z, GenNoise.EmptyAreaNoise, 0.25)) {
            GenUtil.generateBasicWallsWithExtension(chunk, L1_FLOOR_LEVEL, L1_CEILING_LEVEL, ModBlocks.LVL1_WALLPAPER.get(), 3,  Blocks.STONE_BRICKS);


        }

        GenUtil.fillLayer(chunk, L1_FLOOR_LEVEL, ModBlocks.LVL1_CARPET.get());
    }

}

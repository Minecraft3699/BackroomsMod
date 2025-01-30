package net.mc3699.backrooms.dimension.levels;

import net.mc3699.backrooms.blocks.ModBlocks;
import net.mc3699.backrooms.dimension.GenNoise;
import net.mc3699.backrooms.dimension.util.GenUtil;
import net.mc3699.backrooms.utility.BlockFill;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;

import static net.mc3699.backrooms.dimension.util.GenUtil.isChunkInNoise;
import static net.mc3699.backrooms.dimension.util.GenUtil.random;

public class BackroomsPitfallZone {


    public static int PFZ_FLOOR_LEVEL = -57;
    public static int PFZ_CEILING_LEVEL = -46;


    private static void carve(ChunkAccess chunk)
    {
        if(random.nextInt(1,10) < 2)
        {
            int cXstart = random.nextInt(2,8);
            int cZstart = random.nextInt(2, 8);

            int cXend = random.nextInt(9, 13);
            int cZend = random.nextInt(9, 13);

            BlockFill.fillArea(chunk, cXstart, PFZ_FLOOR_LEVEL+1, cZstart, cXend, PFZ_CEILING_LEVEL-2, cZend, Blocks.AIR.defaultBlockState().getBlock());
        }
    }

    private static void genRegular(ChunkAccess chunk)
    {

        GenUtil.fillLayer(chunk, PFZ_CEILING_LEVEL + 3, Blocks.OAK_PLANKS);
        GenUtil.fillLayer(chunk, PFZ_FLOOR_LEVEL, ModBlocks.LVL1_CARPET.get());
        GenUtil.fillLayer(chunk, PFZ_CEILING_LEVEL, ModBlocks.LVL1_CEILING_TILE.get());


        if(isChunkInNoise(chunk.getPos().x, chunk.getPos().z, GenNoise.PlusRoomNoise, 0.6))
        {
            GenUtil.generateCrossShape(chunk,PFZ_FLOOR_LEVEL,PFZ_CEILING_LEVEL);
            GenUtil.generateLights(chunk, PFZ_CEILING_LEVEL);
            return;
        }
        if(!isChunkInNoise(chunk.getPos().x,chunk.getPos().z, GenNoise.UnlitRoomNoise, 0.2)) {
            GenUtil.generateLights(chunk, PFZ_CEILING_LEVEL);
        }

        if(!isChunkInNoise(chunk.getPos().x,chunk.getPos().z, GenNoise.EmptyAreaNoise, 0.25)) {
            GenUtil.generateBasicWallsWithExtension(chunk, PFZ_FLOOR_LEVEL, PFZ_CEILING_LEVEL, ModBlocks.LVL1_WALLPAPER.get(), 3,  Blocks.STONE_BRICKS);
        }

        carve(chunk);
    }

    private static void genZRoad(ChunkAccess chunk)
    {
        // Road Chunk
        BlockFill.fillArea(chunk, 0, PFZ_FLOOR_LEVEL, 14, 15, PFZ_FLOOR_LEVEL, 14, Blocks.SMOOTH_STONE.defaultBlockState().getBlock());
        BlockFill.fillArea(chunk, 0, PFZ_FLOOR_LEVEL, 1, 15, PFZ_FLOOR_LEVEL, 1, Blocks.SMOOTH_STONE.defaultBlockState().getBlock());
        BlockFill.fillArea(chunk, 15, PFZ_FLOOR_LEVEL, 2, 0, PFZ_FLOOR_LEVEL, 13, Blocks.GRAY_CONCRETE.defaultBlockState().getBlock());
    }

    private static void genNegativeTunnelPart(ChunkAccess chunk)
    {
        BlockFill.fillArea(chunk, 0, PFZ_FLOOR_LEVEL + 1, 0, 15, PFZ_CEILING_LEVEL - 1, 0, Blocks.BLACK_CONCRETE.defaultBlockState().getBlock());
        BlockFill.fillArea(chunk, 0, PFZ_CEILING_LEVEL- 1, 0, 15, PFZ_CEILING_LEVEL - 1 , 15, Blocks.BLACK_CONCRETE.defaultBlockState().getBlock());
        BlockFill.fillArea(chunk, 0, PFZ_FLOOR_LEVEL, 0, 15, PFZ_FLOOR_LEVEL, 15, Blocks.GRASS_BLOCK.defaultBlockState().getBlock());
    }

    public static void generateChunk(ChunkAccess chunk)
    {
        // Basics
        GenUtil.generateBeams(chunk, PFZ_CEILING_LEVEL + 2);

        if(chunk.getPos().z == 500)
        {
            genZRoad(chunk);
            if(chunk.getLevel() != null && chunk.getLevel() instanceof ServerLevel chunkLevel)
            {
                ChunkAccess negativeChunk = chunk.getLevel().getChunk(chunk.getPos().x,chunk.getPos().z - 1, ChunkStatus.EMPTY, false);
                chunkLevel.getChunkSource().addRegionTicket(TicketType.FORCED, negativeChunk.getPos(), 1, negativeChunk.getPos());
                genNegativeTunnelPart(negativeChunk);
            }
        } else {
            genRegular(chunk);
        }



    }
}

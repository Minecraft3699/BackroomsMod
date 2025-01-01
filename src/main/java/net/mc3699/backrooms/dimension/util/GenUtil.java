package net.mc3699.backrooms.dimension.util;

import net.mc3699.backrooms.blocks.ModBlocks;
import net.mc3699.backrooms.utility.BlockFill;
import net.minecraft.core.Direction;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;

import java.util.Random;

public class GenUtil {

    public static Random random = new Random();

    public static void generateLights(ChunkAccess chunk, int layer)
    {
        ChunkPos chunkPos = chunk.getPos();
        for(int x = 0; x < 15; x = x + 4)
        {
            for(int z = 0; z < 15; z = z + 4)
            {
                chunk.setBlockState(chunkPos.getWorldPosition().offset(x,layer,z), ModBlocks.LVL1_CEILING_LIGHT.get().defaultBlockState(), true);
                if(chunk.getBlockState(chunkPos.getWorldPosition().offset(x,layer-1,z)).is(Blocks.AIR))
                {
                    chunk.setBlockState(chunkPos.getWorldPosition().offset(x,layer-1,z), Blocks.LIGHT.defaultBlockState().setValue(BlockStateProperties.LEVEL, 15), false);
                }
            }
        }
    }

    public static void generateBeams(ChunkAccess chunk, int layer)
    {
        for(int x = 0; x < 16; x = x + 2)
        {
            for(int z = 0; z < 16; z++)
            {
                chunk.setBlockState(chunk.getPos().getWorldPosition().offset(x,layer, z),
                        Blocks.STRIPPED_OAK_LOG.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z), true);
            }
        }
    }





    public static void fillLayer(ChunkAccess chunk, int layer, Block block)
    {
        BlockFill.fillArea(chunk, 0,layer,0,15,layer,15, block);
        chunk.initializeLightSources();
    }


    public static void generateBasicWalls(ChunkAccess chunk, int floorLevel, int ceilingLevel, Block block)
    {
        int startX = random.nextInt(0, 15);
        int startZ = random.nextInt(0, 15);
        int length = random.nextInt(5, 15);
        int wallThickness = random.nextInt(0,4);

        if(random.nextBoolean())
        {
            BlockFill.fillArea(chunk, startX, floorLevel+1, startZ, startX+length, ceilingLevel-1, startZ+wallThickness, block);
        } else {
            BlockFill.fillArea(chunk, startX, floorLevel+1, startZ, startX+wallThickness, ceilingLevel-1, startZ+length, block);
        }

    }

    public static void generateBasicWallsWithExtension(ChunkAccess chunk, int floorLevel, int ceilingLevel, Block block, int extensionOffset, Block extensionBlock)
    {
        int startX = random.nextInt(0, 15);
        int startZ = random.nextInt(0, 15);
        int length = random.nextInt(5, 15);
        int wallThickness = random.nextInt(0,4);

        if(random.nextBoolean())
        {
            BlockFill.fillArea(chunk, startX, floorLevel+1, startZ, startX+length, ceilingLevel-1, startZ+wallThickness, block);
            BlockFill.fillArea(chunk, startX, ceilingLevel+1, startZ, startX+length, ceilingLevel+extensionOffset, startZ+wallThickness, extensionBlock);
        } else {
            BlockFill.fillArea(chunk, startX, floorLevel+1, startZ, startX+wallThickness, ceilingLevel-1, startZ+length, block);
            BlockFill.fillArea(chunk, startX, ceilingLevel+1, startZ, startX+wallThickness, ceilingLevel+extensionOffset, startZ+length, extensionBlock);
        }

    }

    public static boolean isChunkInNoise(int chunkX, int chunkZ, PerlinNoise noise, double threshold)
    {
        double scale = 0.1;
        double noiseValue = noise.getValue(chunkX * scale, chunkZ * scale, 0.0);
        return noiseValue > threshold;
    }

    public static void fillWall(ChunkAccess chunk, int startX, int startZ, int endX, int endZ, int startLayer, int endLayer, Block block)
    {

        for(int height = startLayer; height < endLayer+1; height++)
        {
            for(int ix = startX; ix < endX; ix++)
            {
                for(int iz = startZ; iz < endZ; iz++)
                {
                    chunk.setBlockState(chunk.getPos().getWorldPosition().offset(ix,height,iz), block.defaultBlockState(), true);
                }
            }
        }
    }


    public static void generateCrossShape(ChunkAccess chunk, int floorLevel, int ceilingLevel)
    {
        fillWall(chunk, 6, 3, 9, 12, floorLevel, ceilingLevel,ModBlocks.LVL1_WALLPAPER.get());
        fillWall(chunk, 3, 6, 12,9, floorLevel, ceilingLevel, ModBlocks.LVL1_WALLPAPER.get());
    }

}

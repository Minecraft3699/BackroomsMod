package net.mc3699.backrooms.dimension.levels;

import net.mc3699.backrooms.dimension.util.BackroomsLevel;
import net.mc3699.backrooms.dimension.util.GenUtil;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.RandomState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BackroomsL2 extends BackroomsLevel {

    private static final Random random = new Random();

    public static final int L2_FLOOR_HEIGHT = -31;
    public static final int L2_CEILING_HEIGHT = -23;


    private static final List<Block> blockList = new ArrayList<>();

    static {
        blockList.add(Blocks.STONE_BRICKS);
        blockList.add(Blocks.CRACKED_STONE_BRICKS);
        blockList.add(Blocks.GLASS);
        blockList.add(Blocks.STONE);
        blockList.add(Blocks.GRAY_CONCRETE);
    }


    public static void generateChunk(ChunkAccess chunk)
    {
        GenUtil.fillLayer(chunk, L2_FLOOR_HEIGHT, Blocks.SMOOTH_STONE);
        GenUtil.fillLayer(chunk, L2_CEILING_HEIGHT, Blocks.DARK_OAK_PLANKS);
        GenUtil.generateBasicWalls(chunk, L2_FLOOR_HEIGHT, L2_CEILING_HEIGHT, blockList.get(random.nextInt(blockList.size())));
        GenUtil.generateLights(chunk, L2_CEILING_HEIGHT);
    }

    @Override
    public void generate(WorldGenRegion worldGenRegion, StructureManager structureManager, RandomState randomState, ChunkAccess chunkAccess) {
        generateChunk(chunkAccess);
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public int getEndLevel() {
        return 0;
    }
}

package net.mc3699.backrooms.dimension.levels;

import net.mc3699.backrooms.blocks.ModBlocks;
import net.mc3699.backrooms.dimension.util.GenUtil;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BackroomsL2 {

    private static final Random random = new Random();

    public static final int L2_FLOOR_HEIGHT = -53;
    public static final int L2_CEILING_HEIGHT = -38;


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

}

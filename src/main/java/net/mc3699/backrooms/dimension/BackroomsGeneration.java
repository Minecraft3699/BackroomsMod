package net.mc3699.backrooms.dimension;

import net.mc3699.backrooms.BackroomsMod;
import net.mc3699.backrooms.dimension.levels.BackroomsL1;
import net.mc3699.backrooms.dimension.levels.BackroomsL2;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ChunkEvent;

import java.util.Random;

@EventBusSubscriber
public class BackroomsGeneration {




    public static final ResourceKey<Level> BACKROOMS_DIM_KEY =
            ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(BackroomsMod.MODID, "backrooms"));

    public static final ResourceLocation BACKROOMS_L1_BIOME_KEY =
            ResourceLocation.fromNamespaceAndPath(BackroomsMod.MODID, "backrooms_level_one");

    public static final Random random = new Random();

    @SubscribeEvent
    public static void backroomsChunkGen(ChunkEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel level) {
            if (event.isNewChunk()) {
                if (level.dimension() == BACKROOMS_DIM_KEY) {
                    // Insert levels for generation here.
                    BackroomsL1.generateChunk(event.getChunk());
                    BackroomsL2.generateChunk(event.getChunk());
                    //BackroomsHallwayTest.generateChunk(event.getChunk());
                }
            }
        }
    }
}


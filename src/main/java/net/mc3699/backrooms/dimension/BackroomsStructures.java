package net.mc3699.backrooms.dimension;


import net.mc3699.backrooms.Backrooms;
import net.mc3699.backrooms.dimension.util.StructureConnectionInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public class BackroomsStructures {
    public record BackroomsStructureInfo(ResourceLocation structure, BlockPos offset) {
    }

    // Hub

    public static final BackroomsStructureInfo HALLWAY_HUB = new BackroomsStructureInfo(
            ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "office_hallway_hub"), BlockPos.ZERO);

    public static final StructureConnectionInfo HALLWAY_HUB_CONNECTIONS =
            new StructureConnectionInfo(HALLWAY_HUB, Set.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST));

    // Straight

    public static final BackroomsStructureInfo HALLWAY_STRAIGHT = new BackroomsStructureInfo(
            ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "office_hallway_straight"),  BlockPos.ZERO);

    public static final StructureConnectionInfo HALLWAY_STRAIGHT_CONNECTIONS =
            new StructureConnectionInfo(HALLWAY_STRAIGHT, Set.of(Direction.NORTH, Direction.SOUTH));

    // Corner

    public static final BackroomsStructureInfo HALLWAY_CORNER = new BackroomsStructureInfo(
            ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "office_hallway_corner"), BlockPos.ZERO);

    public static final StructureConnectionInfo HALLWAY_CORNER_CONNECTIONS =
            new StructureConnectionInfo(HALLWAY_CORNER, Set.of(Direction.NORTH, Direction.EAST));

    // Junction

    public static final BackroomsStructureInfo HALLWAY_JUNCTION = new BackroomsStructureInfo(
            ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "office_hallway_t_junction"), BlockPos.ZERO);

    public static final StructureConnectionInfo HALLWAY_JUNCTION_CONNECTIONS =
            new StructureConnectionInfo(HALLWAY_JUNCTION, Set.of(Direction.NORTH, Direction.EAST, Direction.WEST));
}

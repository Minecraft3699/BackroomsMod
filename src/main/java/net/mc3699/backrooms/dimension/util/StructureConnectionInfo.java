package net.mc3699.backrooms.dimension.util;

import net.mc3699.backrooms.dimension.BackroomsStructures;
import net.minecraft.core.Direction;

import java.util.Set;

public class StructureConnectionInfo {
    public final BackroomsStructures.BackroomsStructureInfo structure;
    public final Set<Direction> exits;

    public StructureConnectionInfo(BackroomsStructures.BackroomsStructureInfo structure, Set<Direction> exits) {
        this.structure = structure;
        this.exits = exits;
    }
}

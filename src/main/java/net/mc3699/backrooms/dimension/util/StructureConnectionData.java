package net.mc3699.backrooms.dimension.util;

import net.minecraft.core.Direction;

import java.util.EnumMap;

public class StructureConnectionData {
    private final EnumMap<Direction, Boolean> exits = new EnumMap<>(Direction.class);

    public StructureConnectionData() {
        for (Direction dir : Direction.values()) exits.put(dir, false);
    }

    public void setExit(Direction dir, boolean value) {
        exits.put(dir, value);
    }

    public boolean hasExit(Direction dir) {
        return exits.get(dir);
    }
}

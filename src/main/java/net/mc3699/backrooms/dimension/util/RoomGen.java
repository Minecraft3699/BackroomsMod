package net.mc3699.backrooms.dimension.util;

import net.mc3699.backrooms.utility.BlockFill;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.block.state.BlockState;

public class RoomGen {


    public static void createRoom(int x, int y, int z, Room room, WorldGenRegion genRegion) {
        // Floor
        BlockFill.fillRegion(genRegion, x, y, z, x + 15, y, z + 15, room.floorMaterial);

        // Ceiling
        //BlockFill.fillRegion(genRegion, x, y + 6, z, x + 15, y + 6, z + 15, room.ceilingMaterial);

        // NORTH wall (z = startZ)
        if (room.walls[0]) {
            BlockFill.fillRegion(genRegion, x, y + 1, z, x + 15, y + 5, z, room.wallMaterial);
        }

        // EAST wall (x = x + 15)
        if (room.walls[1]) {
            BlockFill.fillRegion(genRegion, x + 15, y + 1, z, x + 15, y + 5, z + 15, room.wallMaterial);
        }

        // SOUTH wall (z = z + 15)
        if (room.walls[2]) {
            BlockFill.fillRegion(genRegion, x, y + 1, z + 15, x + 15, y + 5, z + 15, room.wallMaterial);
        }

        // WEST wall (x = startX)
        if (room.walls[3]) {
            BlockFill.fillRegion(genRegion, x, y + 1, z, x, y + 5, z + 15, room.wallMaterial);
        }
    }


    public static class Room {

        // 0 = N, 1 = E, 2 = S, 3 = W

        public boolean[] walls = new boolean[4];
        private  boolean[] entrances = new boolean[4];

        public void setWalls(boolean north, boolean east, boolean south, boolean west) {
            walls[0] = north;
            walls[1] = east;
            walls[2] = south;
            walls[3] = west;
        }

        public void setEntrances(boolean north, boolean east, boolean south, boolean west) {
            entrances[0] = north;
            entrances[1] = east;
            entrances[2] = south;
            entrances[3] = west;
        }

        public boolean[] getWalls() {
            return walls.clone();
        }

        public boolean[] getEntrances() {
            return entrances.clone();
        }

        BlockState floorMaterial;
        BlockState ceilingMaterial;
        BlockState wallMaterial;

        public void setCeilingMaterial(BlockState ceilingMaterial) {
            this.ceilingMaterial = ceilingMaterial;
        }

        public void setFloorMaterial(BlockState floorMaterial) {
            this.floorMaterial = floorMaterial;
        }

        public void setWallMaterial(BlockState wallMaterial) {
            this.wallMaterial = wallMaterial;
        }
    }




}

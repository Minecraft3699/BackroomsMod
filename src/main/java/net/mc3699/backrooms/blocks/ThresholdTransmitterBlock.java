package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.blocks.entity.PrototypeBlockEntity;
import net.mc3699.backrooms.dimension.BackroomsGeneration;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;


public class ThresholdTransmitterBlock extends Block {
    public ThresholdTransmitterBlock(Properties properties) {
        super(properties);
    }

}

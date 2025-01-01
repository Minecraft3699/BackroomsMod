package net.mc3699.backrooms.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.mc3699.backrooms.dimension.BackroomsGeneration;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ThresholdOriginBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    protected ThresholdOriginBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED,false));
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    Vec3 NORTH_ORIENTATION = new Vec3(1,0,0);
    Vec3 SOUTH_ORIENTATION = new Vec3(-1,0,0);
    Vec3 EAST_ORIENTATION = new Vec3(0,0,1);
    Vec3 WEST_ORIENTATION = new Vec3(0,0,-1);

    Vec3 NORTH_OFFSET = new Vec3(0,2,-0.001);
    Vec3 SOUTH_OFFSET = new Vec3(1,2,+1.001);
    Vec3 EAST_OFFSET = new Vec3(1.001,0.5,0.5);
    Vec3 WEST_OFFSET = new Vec3(-0.001,0.5,0.5);

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(POWERED);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }


}

package net.mc3699.backrooms.blocks.threshold;

import net.mc3699.backrooms.registry.BRBlockEntities;
import net.mc3699.backrooms.registry.BRBlocks;
import net.mc3699.backrooms.blocks.util.CustomDirectionalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ThresholdPortalBlock extends CustomDirectionalBlock implements EntityBlock {
    public ThresholdPortalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {

        super.entityInside(state, level, pos, entity);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BRBlockEntities.THRESHOLD_PORTAL.create(blockPos,blockState);
    }
}

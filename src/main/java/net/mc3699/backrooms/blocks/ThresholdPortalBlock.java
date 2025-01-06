package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.blocks.entity.ThresholdPortalBlockEntity;
import net.mc3699.backrooms.blocks.util.CustomDirectionalBlock;
import net.mc3699.backrooms.dimension.BackroomsGeneration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ThresholdPortalBlock extends CustomDirectionalBlock implements EntityBlock {
    public ThresholdPortalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }



    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {

        if(!level.isClientSide() && player instanceof ServerPlayer serverPlayer)
        {
            // Overworld To Backrooms
            ServerLevel backroomsLevel = serverPlayer.server.getLevel(BackroomsGeneration.BACKROOMS_DIM_KEY);
            assert backroomsLevel != null;
            serverPlayer.changeDimension(new DimensionTransition(backroomsLevel, new Vec3(pos.getX()+0.5, -61, pos.getZ()+0.5), new Vec3(0, 0, 0), 0, 0, false,
                    entity -> {
                            // Intentionally blank, add effects here if you want them after entering backrooms
                    }));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ThresholdPortalBlockEntity(blockPos, blockState);
    }
}

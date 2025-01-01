package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.dimension.BackroomsGeneration;
import net.minecraft.client.multiplayer.chat.report.ReportEnvironment;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class ThresholdPortalBlock extends Block {
    public ThresholdPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        if(!level.isClientSide() && player instanceof ServerPlayer serverPlayer)
        {
            ServerLevel backroomsLevel = serverPlayer.server.getLevel(BackroomsGeneration.BACKROOMS_DIM_KEY);
            serverPlayer.changeDimension(new DimensionTransition(backroomsLevel, new Vec3(0, 4, 0), new Vec3(0, 0, 0), 0, 0, true,
                    entity -> {

                    }));
        }
        return InteractionResult.SUCCESS;
    }
}

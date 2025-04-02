package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.blocks.entity.ThresholdPortalBlockEntity;
import net.mc3699.backrooms.blocks.util.CustomDirectionalBlock;
import net.mc3699.backrooms.dimension.BackroomsGeneration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ThresholdPortalBlock extends CustomDirectionalBlock implements EntityBlock {
    public ThresholdPortalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }


    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {


        if(level.getBlockEntity(pos) instanceof ThresholdPortalBlockEntity thresholdPortalBlockEntity && entity instanceof Player)
        {
            thresholdPortalBlockEntity.removeAllLights();
        }

        if(level instanceof ServerLevel serverLevel)
        {
            MinecraftServer server = serverLevel.getServer();

            ServerLevel overworldLevel = server.getLevel(Level.OVERWORLD);
            ServerLevel backroomsLevel = server.getLevel(BackroomsGeneration.BACKROOMS_DIM_KEY);

            if(serverLevel.equals(overworldLevel))
            {

                BlockPos entryPoint = new BlockPos(pos.getX(), -40, pos.getZ());

                assert backroomsLevel != null;
                backroomsLevel.setBlock(entryPoint, ModBlocks.THRESHOLD_PORTAL.get().defaultBlockState(), 3);
                entity.teleportTo(backroomsLevel, pos.getX()+0.5, -40, pos.getZ()+3, RelativeMovement.ALL, entity.getYHeadRot(), entity.getXRot());
            }

        }

        super.entityInside(state, level, pos, entity);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ThresholdPortalBlockEntity(blockPos, blockState);
    }
}

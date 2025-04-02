package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.blocks.entity.BeamInitiatorBlockEntity;
import net.mc3699.backrooms.blocks.util.CustomDirectionalBlock;
import net.mc3699.backrooms.blocks.util.ThresholdAssembler;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class BeamInitiatorBlock extends CustomDirectionalBlock implements EntityBlock {
    public BeamInitiatorBlock(Properties properties) {
        super(properties);
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BeamInitiatorBlockEntity(blockPos, blockState);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide())
        {

            ThresholdAssembler assembler = new ThresholdAssembler(level);

            boolean success = assembler.checkThresholdAssembly(pos, state.getValue(FACING));
            if(success)
            {
                assembler.addPortalBlocks(pos, state.getValue(FACING));
            }

        }
        return InteractionResult.FAIL;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

    }
}

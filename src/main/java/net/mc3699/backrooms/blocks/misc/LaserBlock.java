package net.mc3699.backrooms.blocks.misc;

import net.mc3699.backrooms.registry.BRBlockEntities;
import net.mc3699.backrooms.registry.BRBlocks;
import net.mc3699.backrooms.blocks.util.CustomDirectionalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class LaserBlock extends CustomDirectionalBlock implements EntityBlock {

    public static BooleanProperty EMITTING = BooleanProperty.create("emitting");
    public static BooleanProperty ASSEMBLED = BooleanProperty.create("assembled");

    public LaserBlock(Properties properties) {
        super(properties);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(EMITTING);
        builder.add(ASSEMBLED);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide())
        {
            BlockState onState = state.setValue(EMITTING,true);
            level.setBlock(pos, onState, 3);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BRBlockEntities.LASER.create(blockPos,blockState);
    }
}

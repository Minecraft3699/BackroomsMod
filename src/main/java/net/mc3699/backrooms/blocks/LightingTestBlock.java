package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.blocks.entity.LightTestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LightingTestBlock extends Block implements EntityBlock {

    public LightingTestBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LightTestBlockEntity(blockPos, blockState);
    }
}

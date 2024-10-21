package net.mc3699.backrooms.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public class WallpaperBlock extends Block {

    public static final BooleanProperty IS_BOTTOM = BooleanProperty.create("is_bottom");

    public WallpaperBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(stateDefinition.any().setValue(IS_BOTTOM, false));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(IS_BOTTOM);
    }
}

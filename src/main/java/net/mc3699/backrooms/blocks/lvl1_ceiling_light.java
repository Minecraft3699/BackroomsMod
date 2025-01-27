package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class lvl1_ceiling_light extends Block {
    public lvl1_ceiling_light(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        level.scheduleTick(pos, this, 80);
    }


    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!level.isClientSide())
        {
            level.playSound(null, pos, ModSounds.LVL1_CEILING_LIGHT.get(), SoundSource.BLOCKS, 0.8f, 1);
            level.scheduleTick(pos,this, 80);
        }
    }
}

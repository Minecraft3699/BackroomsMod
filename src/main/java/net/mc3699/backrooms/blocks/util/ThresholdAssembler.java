package net.mc3699.backrooms.blocks.util;

import net.mc3699.backrooms.blocks.threshold.BeamInitiatorBlock;
import net.mc3699.backrooms.blocks.threshold.MagneticLensBlock;
import net.mc3699.backrooms.registry.BRBlocks;
import net.mc3699.backrooms.blocks.threshold.RFCavityBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ThresholdAssembler {

    private final Level level;

    public ThresholdAssembler(Level level)
    {
        this.level = level;
    }


    public boolean checkThresholdSide(BlockPos beamOrigin, Direction assemblyDirection)
    {
        // Check Emitters
        for(int i = 0; i < 3; i++)
        {
            BlockState checkBlock = level.getBlockState(beamOrigin.above(i));
            if(checkBlock.getBlock() instanceof BeamInitiatorBlock)
            {
                if(checkBlock.getValue(BeamInitiatorBlock.FACING).equals(assemblyDirection))
                {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        // Check RF Cavities
        for(int i = 0; i < 3; i++)
        {
            BlockState checkBlock = level.getBlockState(beamOrigin.relative(assemblyDirection, 1).above(i));
            if(checkBlock.getBlock() instanceof RFCavityBlock)
            {
                if(checkBlock.getValue(RFCavityBlock.FACING).equals(assemblyDirection))
                {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        // Check Magnetic Lenses

        for(int i = 0; i < 3; i++)
        {
            BlockState checkBlock = level.getBlockState(beamOrigin.relative(assemblyDirection, 2).above(i));
            if(checkBlock.getBlock() instanceof MagneticLensBlock)
            {
                if(checkBlock.getValue(MagneticLensBlock.FACING).equals(assemblyDirection))
                {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean checkThresholdAssembly(BlockPos beamOrigin, Direction assemblyDirection)
    {
        boolean firstSideValid = checkThresholdSide(beamOrigin, assemblyDirection);
        boolean secondSideValid = checkThresholdSide(beamOrigin.relative(assemblyDirection, 7), assemblyDirection.getOpposite());
        return firstSideValid && secondSideValid;
    }

    public void addPortalBlocks(BlockPos beamOrigin, Direction assemblyDirection)
    {
        if(checkThresholdAssembly(beamOrigin, assemblyDirection))
        {
            for(int x = 0; x < 2; x++)
            {
                for(int y = 0; y < 3; y++)
                {
                    level.setBlock(beamOrigin.relative(assemblyDirection, 3+x).above(y), BRBlocks.THRESHOLD_PORTAL.get().defaultBlockState(), 3);
                }
            }
        }
    }
}

package net.mc3699.backrooms.blocks.entity;

import net.mc3699.backrooms.blocks.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

public class PrototypeBlockEntity extends BlockEntity {

    boolean PORTAL_OPEN = false;

    public boolean hasPortal()
    {
        return PORTAL_OPEN;
    }

    public void setHasPortal(boolean hasPortal)
    {
        PORTAL_OPEN = hasPortal;
    }


    public PrototypeBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PROTOTYPE_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putBoolean("portal_open", PORTAL_OPEN);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        PORTAL_OPEN = tag.getBoolean("portal_open");
        super.loadAdditional(tag, registries);
    }
}

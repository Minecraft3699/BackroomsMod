package net.mc3699.backrooms.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PrototypeBlockEntity extends BlockEntity {

    boolean PORTAL_OPEN = false;

    public PrototypeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public boolean hasPortal()
    {
        return PORTAL_OPEN;
    }

    public void setHasPortal(boolean hasPortal)
    {
        PORTAL_OPEN = hasPortal;
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

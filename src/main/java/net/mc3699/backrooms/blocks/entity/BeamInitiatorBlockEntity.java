package net.mc3699.backrooms.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BeamInitiatorBlockEntity extends BlockEntity {

    boolean active = false;
    int charge = 300;

    public BeamInitiatorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putInt("power", charge);
        tag.putBoolean("active", active);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        charge = tag.getInt("power");
        active = tag.getBoolean("active");
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, BeamInitiatorBlockEntity blockEntity)
    {
        if(level.getBlockEntity(pos) instanceof BeamInitiatorBlockEntity bEnt)
        {
            bEnt.charge = bEnt.charge + 1;
        }
    }

}

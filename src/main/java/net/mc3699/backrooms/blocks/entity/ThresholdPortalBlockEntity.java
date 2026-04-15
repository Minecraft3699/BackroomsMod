package net.mc3699.backrooms.blocks.entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ThresholdPortalBlockEntity extends BlockEntity {

    private BlockPos targetLocation;
    private ResourceKey<Level> targetDimension;

    public ThresholdPortalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }


    @Override
    public void setRemoved() {
        super.setRemoved();
    }


    @Override
    public void onLoad() {
    }

    @Override
    public void onChunkUnloaded() {
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        if(targetDimension != null)
        {
            tag.putString("target_dimension", targetDimension.location().toString());
        }

        if(targetLocation != null)
        {
            tag.putInt("returnX", targetLocation.getX());
            tag.putInt("returnY", targetLocation.getY());
            tag.putInt("returnZ", targetLocation.getZ());
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("target_dimension"))
        {
            this.targetDimension = ResourceKey.create(Registries.DIMENSION,
                    ResourceLocation.fromNamespaceAndPath("mcbr", tag.getString("target_dimension")));
        }
        if(tag.contains("returnX") && tag.contains("returnY") && tag.contains("returnZ"))
        {
            this.targetLocation = new BlockPos(tag.getInt("returnX"), tag.getInt("returnY"), tag.getInt("returnZ"));
        }
    }

    public BlockPos getTargetLocation() {
        return targetLocation;
    }

    public ResourceKey<Level> getTargetDimension() {
        return targetDimension;
    }


    public void setTargetLocation(BlockPos targetLocation) {
        this.targetLocation = targetLocation;
    }

    public void setTargetDimension(ResourceKey<Level> targetDimension) {
        this.targetDimension = targetDimension;
    }
}
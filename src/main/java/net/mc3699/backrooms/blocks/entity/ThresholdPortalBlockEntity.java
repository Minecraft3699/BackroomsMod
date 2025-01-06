package net.mc3699.backrooms.blocks.entity;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.AreaLight;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import foundry.veil.api.client.render.shader.VeilShaders;
import net.mc3699.backrooms.blocks.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaternionf;

public class ThresholdPortalBlockEntity extends BlockEntity {

    private BlockPos returnLocation;
    private ResourceKey<Level> localDimension;
    private ResourceKey<Level> targetDimension;


    private final LightRenderer lightRenderer = VeilRenderSystem.renderer().getLightRenderer();
    private final AreaLight light = new AreaLight();

    public ThresholdPortalBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.THRESHOLD_PORTAL.get(), pos, blockState);
    }

    private void createLight()
    {
        light.setBrightness(.6f);
        light.setColor(255,255,0);
        light.setSize(1,1);
        light.setPosition(getBlockPos().getX(), getBlockPos().getY()+0.5, getBlockPos().getZ());
        light.setOrientation(new Quaternionf(0,0,0,0));
        lightRenderer.addLight(light);
    }

    private void removeLight()
    {
        lightRenderer.removeLight(light);
    }

    @Override
    public void setRemoved() {
        if(level.isClientSide)
        {
            removeLight();
        }
        super.setRemoved();
    }


    @Override
    public void onLoad() {
        if(getLevel().isClientSide)
        {
            createLight();
        }
    }

    @Override
    public void onChunkUnloaded() {
        if(getLevel().isClientSide)
        {
            removeLight();
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        if(localDimension != null)
        {
            tag.putString("local_dimension", localDimension.location().toString());
        }

        if(targetDimension != null)
        {
            tag.putString("target_dimension", targetDimension.location().toString());
        }

        if(returnLocation != null)
        {
            tag.putInt("returnX", returnLocation.getX());
            tag.putInt("returnY", returnLocation.getY());
            tag.putInt("returnZ", returnLocation.getZ());
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);



        if(tag.contains("local_dimension"))
        {
            this.localDimension = ResourceKey.create(Registries.DIMENSION,
                    ResourceLocation.fromNamespaceAndPath("mcbr", tag.getString("local_dimension")));
        }
        if(tag.contains("target_dimension"))
        {
            this.targetDimension = ResourceKey.create(Registries.DIMENSION,
                    ResourceLocation.fromNamespaceAndPath("mcbr", tag.getString("target_dimension")));
        }
        if(tag.contains("returnX") && tag.contains("returnY") && tag.contains("returnZ"))
        {
            this.returnLocation = new BlockPos(tag.getInt("returnX"), tag.getInt("returnY"), tag.getInt("returnZ"));
        }
    }

    public BlockPos getReturnLocation() {
        return returnLocation;
    }

    public ResourceKey<Level> getLocalDimension() {
        return localDimension;
    }

    public ResourceKey<Level> getTargetDimension() {
        return targetDimension;
    }
}
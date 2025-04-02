package net.mc3699.backrooms.blocks.entity;

import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.Light;
import foundry.veil.api.client.render.light.PointLight;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import foundry.veil.api.client.render.light.renderer.LightTypeRenderer;
import net.mc3699.backrooms.blocks.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class ThresholdPortalBlockEntity extends BlockEntity {

    private BlockPos targetLocation;
    private ResourceKey<Level> targetDimension;


    private final LightRenderer lightRenderer = VeilRenderSystem.renderer().getLightRenderer();
    private final PointLight light = new PointLight();

    public ThresholdPortalBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.THRESHOLD_PORTAL.get(), pos, blockState);
    }

    private void createLight()
    {
        light.setBrightness(.001f);
        light.setColor(1024,1024,0);
        light.setRadius(5);
        light.setPosition(getBlockPos().getX()+0.5, getBlockPos().getY()+0.5, getBlockPos().getZ()+0.5);
        lightRenderer.addLight(light);
    }

    private void removeLight()
    {
        lightRenderer.removeLight(light);
    }

    public void removeAllLights()
    {
        List<Light> allVeilLights = lightRenderer.getLights(LightTypeRegistry.POINT.get());
        for(Light lightToRemove : allVeilLights)
        {
            lightRenderer.removeLight(lightToRemove);
        }
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
package net.mc3699.backrooms.blocks.entity;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.PointLight;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import net.mc3699.backrooms.blocks.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.attachment.AttachmentType;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class LightTestBlockEntity extends BlockEntity {

    private final LightRenderer lightRenderer = VeilRenderSystem.renderer().getLightRenderer();
    private PointLight light;

    public LightTestBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.LIGHT_TEST_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public void onLoad() {
        if(light == null && getLevel().isClientSide())
        {
            createLight();
            light.setPosition(worldPosition.getX()+0.5, worldPosition.getY()+2, worldPosition.getZ()+0.5);
            light.setRadius(10);
            light.setColor(0,255,0);
            light.setBrightness(0.002f);
            light.markDirty();
            lightRenderer.addLight(light);
        }
        super.onLoad();
    }

    @Override
    public void setRemoved() {
        if(level.isClientSide() && light != null)
        {
            lightRenderer.removeLight(light);
        }
        super.setRemoved();

    }

    public void createLight()
    {
        light = new PointLight();
    }

}

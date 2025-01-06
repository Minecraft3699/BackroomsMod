package net.mc3699.backrooms.blocks.blockRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import net.mc3699.backrooms.blocks.ModBlocks;
import net.mc3699.backrooms.blocks.entity.ThresholdPortalBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class ThresholdPortalRenderer implements BlockEntityRenderer<ThresholdPortalBlockEntity> {

    private static final ResourceLocation DISTORTION = ResourceLocation.fromNamespaceAndPath("mcbr","distortion");
    public final BlockRenderDispatcher dispatcher;

    public ThresholdPortalRenderer(BlockEntityRendererProvider.Context context) {
        this.dispatcher = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(ThresholdPortalBlockEntity thresholdPortalBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        ShaderProgram shader = VeilRenderSystem.setShader(DISTORTION);

        shader.bind();
        dispatcher.renderSingleBlock(ModBlocks.THRESHOLD_PORTAL.get().defaultBlockState(), poseStack, multiBufferSource, i, i1);
        ShaderProgram.unbind();
    }
}

package net.mc3699.backrooms.blocks.blockRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import net.mc3699.backrooms.BackroomsMod;
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
    private static final ResourceLocation plasmaTexture = ResourceLocation.fromNamespaceAndPath(BackroomsMod.MODID, "textures/block/plasma.png");
    public final BlockRenderDispatcher dispatcher;

    public ThresholdPortalRenderer(BlockEntityRendererProvider.Context context) {
        this.dispatcher = context.getBlockRenderDispatcher();
    }


    private static void addVert(VertexConsumer vertexConsumer, PoseStack poseStack, float x, float y, float z, float u, float v)
    {
        vertexConsumer.addVertex(poseStack.last().pose(), x, y, z)
                .setUv(u,v)
                .setUv1(0,0)
                .setUv2(255,255)
                .setColor(1f,1f,1f,0.999f)
                .setNormal(poseStack.last(), 0,1,0);
    }

    private static void drawPlasma(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, float beamLen)
    {
        addVert(vertexConsumer, poseStack, 0, 0.55f, 2, 0f,0f);
        addVert(vertexConsumer, poseStack, 0, 0.55f, -2, 1f,0f);
        addVert(vertexConsumer, poseStack, -2, 0.55f, -2, 1f,1f);
        addVert(vertexConsumer, poseStack, -2, 0.55f, 2f, 0f,1f);
    }

    @Override
    public void render(ThresholdPortalBlockEntity thresholdPortalBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        ShaderProgram shader = VeilRenderSystem.setShader(DISTORTION);
        shader.bind();
        VertexConsumer builder = multiBufferSource.getBuffer(RenderType.entityTranslucent(plasmaTexture));
        drawPlasma(poseStack, builder, i, i1, 1);
        ShaderProgram.unbind();
    }
}

package net.mc3699.backrooms.blocks.entity.blockRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.mc3699.backrooms.Backrooms;
import net.mc3699.backrooms.blocks.misc.LaserBlock;
import net.mc3699.backrooms.blocks.entity.LaserBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;

public class PlasmaRenderer implements BlockEntityRenderer<LaserBlockEntity> {

    private BlockEntityRendererProvider.Context ctx;

    public PlasmaRenderer(BlockEntityRendererProvider.Context context) {
        ctx = context;
    }


    private static final ResourceLocation plasmaTexture = ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "textures/block/plasma.png");
    RandomSource randomSource = RandomSource.create();

    @Override
    public void render(LaserBlockEntity laserBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
            if(laserBlockEntity.getBlockState().getValue(LaserBlock.EMITTING))
            {
                poseStack.pushPose();


                float randFloatX = randomSource.nextFloat();
                float randFloatZ = randomSource.nextFloat();

                poseStack.translate(0,2,0.5);

                poseStack.mulPose(Axis.XP.rotationDegrees(-90));


            /*
                switch (laserBlockEntity.getBlockState().getValue(LaserBlock.FACING))
                {
                    case NORTH -> poseStack.mulPose(Axis.XP.rotationDegrees(90));
                    case SOUTH -> poseStack.mulPose(Axis.XP.rotationDegrees(-90));
                    case EAST  -> poseStack.mulPose(Axis.ZP.rotationDegrees(90));
                    case WEST  -> poseStack.mulPose(Axis.ZP.rotationDegrees(-90));
                }
            */

                VertexConsumer builder = multiBufferSource.getBuffer(RenderType.entityTranslucent(plasmaTexture));
                drawPlasma(poseStack, builder, 10, i, i1);

                poseStack.popPose();
            }
    }

    @Override
    public boolean shouldRenderOffScreen(LaserBlockEntity blockEntity) {
        return true;
    }



    private static void drawPlasma(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, float beamLen)
    {
        addVert(vertexConsumer, poseStack, 0, 0.55f, 2, 0f,0f);
        addVert(vertexConsumer, poseStack, 0, 0.55f, -2, 1f,0f);
        addVert(vertexConsumer, poseStack, -2, 0.55f, -2, 1f,1f);
        addVert(vertexConsumer, poseStack, -2, 0.55f, 2f, 0f,1f);
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
}
package net.mc3699.backrooms.entity.client;

import net.mc3699.backrooms.Backrooms;
import net.mc3699.backrooms.entity.behavior.HowlerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HowlerRenderer extends MobRenderer<HowlerEntity, HowlerPlaceholderModel<HowlerEntity>> {
    public HowlerRenderer(EntityRendererProvider.Context context) {
        super(context, new HowlerPlaceholderModel<>(context.bakeLayer(ModModelLayers.HOWLER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(HowlerEntity howlerEntity) {
        return ResourceLocation.fromNamespaceAndPath(Backrooms.MODID, "textures/entity/howler_base.png");
    }
}

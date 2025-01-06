package net.mc3699.backrooms.shader;

import net.mc3699.backrooms.blocks.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class ModRenderTypes {

    public static void setup()
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.THRESHOLD_PORTAL.get(), RenderType.translucent());
    }

}

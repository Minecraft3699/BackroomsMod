package net.mc3699.backrooms.items;

import net.mc3699.backrooms.BackroomsMod;
import net.mc3699.backrooms.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BackroomsMod.MODID);

    public static final Supplier<CreativeModeTab> BACKROOMS_ITEMS_TAB = CREATIVE_TAB.register("backrooms_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.LVL1_WALLPAPER.get()))
                    .title(Component.translatable("creative_tab.mcbr.backrooms_items"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LVL1_WALLPAPER);
                        output.accept(ModBlocks.LVL1_CARPET);
                        output.accept(ModBlocks.LVL1_CEILING_TILE);
                        output.accept(ModBlocks.LVL1_CEILING_LIGHT);
                        output.accept(ModBlocks.AUDITORY_GUIDEPOST);
                        output.accept(ModBlocks.THRESHOLD_ORIGIN);
                        output.accept(ModBlocks.BEAM_INITIATOR);
                        output.accept(ModBlocks.RF_CAVITY);
                        output.accept(ModBlocks.MAGNETIC_LENS);
                    }))
                    .build()
    );


    public static void register(IEventBus modEventBus)
    {
        CREATIVE_TAB.register(modEventBus);
    }

}

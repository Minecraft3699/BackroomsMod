package net.mc3699.backrooms.blocks;

import net.mc3699.backrooms.BackroomsMod;
import net.mc3699.backrooms.blocks.util.CustomDirectionalBlock;
import net.mc3699.backrooms.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BackroomsMod.MODID);


    public static final DeferredBlock<Block> MOIST_CARPET = registerBlock("lvl1_carpet", () -> new Block(BlockBehaviour.Properties.of()
            .strength(0.5f)
            .sound(SoundType.WOOL)
            ));


    public static final DeferredBlock<Block> YELLOW_WALLPAPER = registerBlock("lvl1_wallpaper",
            () -> new WallpaperBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> TILE = registerBlock("lvl1_ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> TILE_LIGHT = registerBlock("lvl1_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.GLASS).emissiveRendering((blockState, blockGetter, blockPos) -> false).lightLevel(blockState -> 0)));

    public static final DeferredBlock<Block> TILE_VENT = registerBlock("tile_vent",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PROTOTYPE = registerBlock("prototype",
            () -> new PrototypeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> THRESHOLD_TRANSMITTER = registerBlock("threshold_transmitter",
            () -> new ThresholdTransmitterBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> THRESHOLD_ORIGIN = registerBlock("threshold_origin",
            () -> new ThresholdOriginBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> NULL_ZONE = registerBlock("null_zone",
            () -> new NullZoneBlock(BlockBehaviour.Properties.of().noCollission()));

    public static final DeferredBlock<Block> LASER_TEST = registerBlock("laser",
            () -> new LaserBlock(BlockBehaviour.Properties.of()));

    public static final DeferredBlock<Block> RF_CAVITY = registerBlock("rf_cavity",
            () -> new CustomDirectionalBlock(BlockBehaviour.Properties.of().sound(SoundType.COPPER_GRATE)));

    public static final DeferredBlock<Block> BEAM_INITIATOR = registerBlock("beam_initiator",
            () -> new BeamInitiatorBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> MAGNETIC_LENS = registerBlock("magnetic_lens",
            () -> new CustomDirectionalBlock(BlockBehaviour.Properties.of().sound(SoundType.COPPER)));

    public static final DeferredBlock<Block> THRESHOLD_BACKPLANE = registerBlock("threshold_backplane",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> LIGHT_TEST = registerBlock("light_test",
            () -> new LightingTestBlock(BlockBehaviour.Properties.of()));

    public static final DeferredBlock<AuditoryGuidepostBlock> AUDITORY_GUIDEPOST = registerBlock("auditory_guidepost",
            () -> new AuditoryGuidepostBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).noCollission()));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> returnBlock = BLOCKS.register(name, block);
        registerItem(name, returnBlock);
        return returnBlock;
    }


    private static <T extends Block> void registerItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}

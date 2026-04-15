package net.mc3699.backrooms.registry;

import dev.anvilcraft.lib.v2.registrum.util.entry.BlockEntry;
import net.mc3699.backrooms.Backrooms;
import net.mc3699.backrooms.blocks.entity.*;
import net.mc3699.backrooms.blocks.misc.LaserBlock;
import net.mc3699.backrooms.blocks.misc.PrototypeBlock;
import net.mc3699.backrooms.blocks.structure.FalseSkyBlock;
import net.mc3699.backrooms.blocks.structure.Level1CeilingLightBlock;
import net.mc3699.backrooms.blocks.structure.WallpaperBlock;
import net.mc3699.backrooms.blocks.threshold.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BRBlocks {

    public static final BlockEntry<Block> LVL1_CARPET = Backrooms.REGISTRUM.block("lvl1_carpet", Block::new)
            .properties(p -> p.strength(0.5f).sound(SoundType.WOOL))
            .simpleItem()
            .register();

    public static final BlockEntry<WallpaperBlock> LVL1_WALLPAPER = Backrooms.REGISTRUM.block("lvl1_wallpaper", WallpaperBlock::new)
            .properties(p -> p.strength(1.5f).sound(SoundType.STONE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CHAIR = Backrooms.REGISTRUM.block("chair", Block::new)
            .properties(p -> p.strength(1.5f).sound(SoundType.STONE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LVL1_CEILING_TILE = Backrooms.REGISTRUM.block("lvl1_ceiling_tile", Block::new)
            .properties(p -> p.sound(SoundType.WOOL))
            .simpleItem()
            .register();

    public static final BlockEntry<Level1CeilingLightBlock> LVL1_CEILING_LIGHT = Backrooms.REGISTRUM.block("lvl1_ceiling_light", Level1CeilingLightBlock::new)
            .properties(p -> p.sound(SoundType.GLASS)
                    .emissiveRendering((state, getter, pos) -> false)
                    .lightLevel(state -> 0))
            .simpleItem()
            .register();

    public static final BlockEntry<PrototypeBlock> PROTOTYPE = Backrooms.REGISTRUM.block("prototype", PrototypeBlock::new)
            .properties(p -> p.sound(SoundType.METAL))
            .blockEntity(PrototypeBlockEntity::new).build()
            .simpleItem()
            .register();

    public static final BlockEntry<ThresholdOriginBlock> THRESHOLD_ORIGIN = Backrooms.REGISTRUM.block("threshold_origin", ThresholdOriginBlock::new)
            .properties(p -> p.sound(SoundType.METAL))
            .simpleItem()
            .register();

    public static final BlockEntry<LaserBlock> LASER_TEST = Backrooms.REGISTRUM.block("laser", LaserBlock::new)
            .properties(p -> p.ofFullCopy(Blocks.COPPER_BLOCK))
            .blockEntity(LaserBlockEntity::new).build()
            .simpleItem()
            .register();

    public static final BlockEntry<RFCavityBlock> RF_CAVITY = Backrooms.REGISTRUM.block("rf_cavity", RFCavityBlock::new)
            .properties(p -> p.sound(SoundType.COPPER_GRATE))
            .simpleItem()
            .register();

    public static final BlockEntry<BeamInitiatorBlock> BEAM_INITIATOR = Backrooms.REGISTRUM.block("beam_initiator", BeamInitiatorBlock::new)
            .properties(p -> p.sound(SoundType.METAL))
            .blockEntity(BeamInitiatorBlockEntity::new).build()
            .simpleItem()
            .register();

    public static final BlockEntry<MagneticLensBlock> MAGNETIC_LENS = Backrooms.REGISTRUM.block("magnetic_lens", MagneticLensBlock::new)
            .properties(p -> p.sound(SoundType.COPPER))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> THRESHOLD_BACKPLANE = Backrooms.REGISTRUM.block("threshold_backplane", Block::new)
            .properties(p -> p.sound(SoundType.STONE))
            .simpleItem()
            .register();

    public static final BlockEntry<ThresholdPortalBlock> THRESHOLD_PORTAL = Backrooms.REGISTRUM.block("threshold_portal", ThresholdPortalBlock::new)
            .properties(BlockBehaviour.Properties::noCollission)
            .blockEntity(ThresholdPortalBlockEntity::new).build()
            .simpleItem()
            .register();

    public static final BlockEntry<AuditoryGuidepostBlock> AUDITORY_GUIDEPOST = Backrooms.REGISTRUM.block("auditory_guidepost", AuditoryGuidepostBlock::new)
            .properties(p -> p.sound(SoundType.METAL).noCollission())
            .simpleItem()
            .register();

    public static final BlockEntry<FalseSkyBlock> FALSE_SKY_BLOCK = Backrooms.REGISTRUM.block("false_sky", FalseSkyBlock::new)
            .properties(p -> p.destroyTime(1000000f))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> TEST_BLOCK = Backrooms.REGISTRUM.block("test_block", Block::new)
            .lang("Test Block")
            .simpleItem()
            .register();

    public static void init() {}
}
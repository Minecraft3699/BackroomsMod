package net.mc3699.backrooms.registry;

import dev.anvilcraft.lib.v2.registrum.util.entry.BlockEntityEntry;
import net.mc3699.backrooms.Backrooms;
import net.mc3699.backrooms.blocks.entity.BeamInitiatorBlockEntity;
import net.mc3699.backrooms.blocks.entity.LaserBlockEntity;
import net.mc3699.backrooms.blocks.entity.PrototypeBlockEntity;
import net.mc3699.backrooms.blocks.entity.ThresholdPortalBlockEntity;

public class BRBlockEntities {

    public static final BlockEntityEntry<PrototypeBlockEntity> PROTOTYPE =
            Backrooms.REGISTRUM.blockEntity("prototype_block_entity", PrototypeBlockEntity::new)
                    .validBlocks(BRBlocks.PROTOTYPE)
                    .register();

    public static final BlockEntityEntry<LaserBlockEntity> LASER =
            Backrooms.REGISTRUM.blockEntity("laser_block_entity", LaserBlockEntity::new)
                    .validBlocks(BRBlocks.LASER_TEST)
                    .register();

    public static final BlockEntityEntry<ThresholdPortalBlockEntity> THRESHOLD_PORTAL =
            Backrooms.REGISTRUM.blockEntity("threshold_portal", ThresholdPortalBlockEntity::new)
                    .validBlocks(BRBlocks.THRESHOLD_PORTAL)
                    .register();

    public static final BlockEntityEntry<BeamInitiatorBlockEntity> BEAM_INIT_ENTITY =
            Backrooms.REGISTRUM.blockEntity("beam_init_entity", BeamInitiatorBlockEntity::new)
                    .validBlocks(BRBlocks.BEAM_INITIATOR)
                    .register();

    public static void init() {}

}

package net.mc3699.backrooms.datagen;

import net.mc3699.backrooms.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // Backrooms Generation
        dropSelf(ModBlocks.LVL1_CARPET.get());
        dropSelf(ModBlocks.LVL1_CEILING_TILE.get());
        dropSelf(ModBlocks.LVL1_WALLPAPER.get());
        // Machines
        dropSelf(ModBlocks.AUDITORY_GUIDEPOST.get());
        dropSelf(ModBlocks.BEAM_INITIATOR.get());
        dropSelf(ModBlocks.MAGNETIC_LENS.get());
        dropSelf(ModBlocks.RF_CAVITY.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

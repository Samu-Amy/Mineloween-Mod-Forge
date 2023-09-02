package net.samu.mineloween.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GEM_BLOCK.get());

        this.add(ModBlocks.GEM_ORE.get(),
                block -> createOreDrop(ModBlocks.GEM_ORE.get(), ModItems.RAW_GEM.get()));
    }

    // Ogni blocco che creiamo deve avere una loot table, se non ne ha una deve avere ".noLootTable()" come proprietà quando viene creato
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

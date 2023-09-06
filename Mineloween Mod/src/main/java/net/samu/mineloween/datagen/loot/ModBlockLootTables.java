package net.samu.mineloween.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.block.custom.BelladonnaCropBlock;
import net.samu.mineloween.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GEM_BLOCK.get());
        this.dropSelf(ModBlocks.GEMMED_COBBLESTONE.get());
        this.dropSelf(ModBlocks.GEMMED_COBBLESTONE_STAIRS.get());
        this.dropSelf(ModBlocks.GEMMED_COBBLESTONE_BUTTON.get());
        this.dropSelf(ModBlocks.GEMMED_COBBLESTONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GEMMED_COBBLESTONE_FENCE.get());
        this.dropSelf(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.GEMMED_COBBLESTONE_WALL.get());
        this.dropSelf(ModBlocks.MOD_BOOKSHELF.get());

        this.add(ModBlocks.GEMMED_COBBLESTONE_SLAB.get(), block -> createSlabItemTable(ModBlocks.GEMMED_COBBLESTONE_SLAB.get()));

        this.add(ModBlocks.GEM_ORE.get(),
                block -> createOreDrop(ModBlocks.GEM_ORE.get(), ModItems.RAW_GEM.get()));

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BELLADONNA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(BelladonnaCropBlock.AGE, BelladonnaCropBlock.MAX_AGE));
        this.add(ModBlocks.BELLADONNA_CROP.get(), this.createCropDrops(ModBlocks.BELLADONNA_CROP.get(), ModItems.GEM.get(), ModItems.BELLADONNA_SEEDS.get(), lootitemcondition$builder1)); // TODO: cambia loot di base a bacche
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

package net.samu.mineloween.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SamuMineloweenMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.WAND_VALUABLES).add(ModBlocks.GEM_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.GEM_ORE.get(),
                ModBlocks.GEM_BLOCK.get(),
                ModBlocks.GEMMED_COBBLESTONE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.GEM_ORE.get(),
                ModBlocks.GEM_BLOCK.get());

        this.tag(BlockTags.FENCES).add(
                ModBlocks.GEMMED_COBBLESTONE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES).add(
                ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE.get());

        this.tag(BlockTags.WALLS).add(
                ModBlocks.GEMMED_COBBLESTONE_WALL.get());
    }
}

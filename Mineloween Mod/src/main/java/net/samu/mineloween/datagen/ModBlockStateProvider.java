package net.samu.mineloween.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.block.custom.ModBookshelf;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SamuMineloweenMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GEM_ORE);
        blockWithItem(ModBlocks.GEM_BLOCK);
        blockWithItem(ModBlocks.GEMMED_COBBLESTONE);

        customBookshelf();

        stairsBlock(((StairBlock) ModBlocks.GEMMED_COBBLESTONE_STAIRS.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.GEMMED_COBBLESTONE_SLAB.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()));

        buttonBlock(((ButtonBlock) ModBlocks.GEMMED_COBBLESTONE_BUTTON.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GEMMED_COBBLESTONE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()));

        fenceBlock(((FenceBlock) ModBlocks.GEMMED_COBBLESTONE_FENCE.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()));
        wallBlock(((WallBlock) ModBlocks.GEMMED_COBBLESTONE_WALL.get()), blockTexture(ModBlocks.GEMMED_COBBLESTONE.get()));
    }

    // Crea sia il blocco che l'oggetto
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void customBookshelf() {
        getVariantBuilder(ModBlocks.MOD_BOOKSHELF.get()).forAllStates(state -> {
            if(state.getValue(ModBookshelf.FILL_LEVEL) == 0) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("empty_bookshelf",
                        new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + "empty_bookshelf")))};
            } else if(state.getValue(ModBookshelf.FILL_LEVEL) == 1) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bookshelf_level_1",
                        new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + "bookshelf_level_1")))};
            } else if(state.getValue(ModBookshelf.FILL_LEVEL) == 2) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bookshelf_level_2",
                        new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + "bookshelf_level_2")))};
            } else if(state.getValue(ModBookshelf.FILL_LEVEL) == 3) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bookshelf_level_3",
                        new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + "bookshelf_level_3")))};
            } else if(state.getValue(ModBookshelf.FILL_LEVEL) == 4) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bookshelf_level_4",
                        new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + "bookshelf_level_4")))};
            } else if(state.getValue(ModBookshelf.FILL_LEVEL) == 5) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bookshelf_level_5",
                        new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + "bookshelf_level_5")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("mod_bookshelf",
                        new ResourceLocation("minecraft:block/" + "bookshelf")))};
            }
        });
        simpleBlockItem(ModBlocks.MOD_BOOKSHELF.get(), models().cubeAll("empty_bookshelf",
                new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + "empty_bookshelf")));
    }
}

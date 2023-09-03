package net.samu.mineloween.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SamuMineloweenMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GEM_ORE);
        blockWithItem(ModBlocks.GEM_BLOCK);
        blockWithItem(ModBlocks.GEMMED_COBBLESTONE);

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
}

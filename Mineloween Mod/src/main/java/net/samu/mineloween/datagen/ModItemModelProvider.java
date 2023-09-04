package net.samu.mineloween.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SamuMineloweenMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_GEM);
        simpleItem(ModItems.GEM);
        simpleItem(ModItems.CHOCOLATE);
        simpleItem(ModItems.LEAF);

        fenceItem(ModBlocks.GEMMED_COBBLESTONE_FENCE, ModBlocks.GEMMED_COBBLESTONE);
        buttonItem(ModBlocks.GEMMED_COBBLESTONE_BUTTON, ModBlocks.GEMMED_COBBLESTONE);
        wallItem(ModBlocks.GEMMED_COBBLESTONE_WALL, ModBlocks.GEMMED_COBBLESTONE);

        evenSimplerBlockItem(ModBlocks.GEMMED_COBBLESTONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.GEMMED_COBBLESTONE_SLAB);
        evenSimplerBlockItem(ModBlocks.GEMMED_COBBLESTONE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE);

        handheldItem(ModItems.SCYTHE);
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(SamuMineloweenMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(SamuMineloweenMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SamuMineloweenMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(SamuMineloweenMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}

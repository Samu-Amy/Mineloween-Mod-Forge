package net.samu.mineloween.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
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
        simpleItem(ModItems.WAND);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0",new ResourceLocation(SamuMineloweenMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}

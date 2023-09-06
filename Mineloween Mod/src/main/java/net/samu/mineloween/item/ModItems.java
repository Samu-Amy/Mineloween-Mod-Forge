package net.samu.mineloween.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.custom.FuelItem;
import net.samu.mineloween.item.custom.ModArmorItem;
import net.samu.mineloween.item.custom.WandItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SamuMineloweenMod.MOD_ID);

    // --------------- Minerals ---------------
    public static final RegistryObject<Item> RAW_GEM = ITEMS.register("raw_gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM = ITEMS.register("gem", () -> new Item(new Item.Properties()));

    // --------------- Tools ---------------
    public static final RegistryObject<Item> WAND = ITEMS.register("wand", () -> new WandItem(new Item.Properties().durability(3000)));
    public static final RegistryObject<Item> SCYTHE = ITEMS.register("scythe", () -> new SwordItem(ModToolTiers.DARK, 6, -3.8f, new Item.Properties()));
    public static final RegistryObject<Item> GEM_SWORD = ITEMS.register("gem_sword", () -> new SwordItem(ModToolTiers.GEM, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> GEM_PICKAXE = ITEMS.register("gem_pickaxe", () -> new PickaxeItem(ModToolTiers.GEM, -2, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> GEM_AXE = ITEMS.register("gem_axe", () -> new AxeItem(ModToolTiers.GEM, 7, -3f, new Item.Properties()));
    public static final RegistryObject<Item> GEM_SHOVEL = ITEMS.register("gem_shovel", () -> new ShovelItem(ModToolTiers.GEM, -2, -3, new Item.Properties()));
    public static final RegistryObject<Item> GEM_HOE = ITEMS.register("gem_hoe", () -> new HoeItem(ModToolTiers.GEM, -7, 0, new Item.Properties()));

    // --------------- Armor ---------------
    public static final RegistryObject<Item> GEM_HELMET = ITEMS.register("gem_helmet", () -> new ModArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GEM_CHESTPLATE = ITEMS.register("gem_chestplate", () -> new ModArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GEM_LEGGINS = ITEMS.register("gem_leggins", () -> new ModArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GEM_BOOTS = ITEMS.register("gem_boots", () -> new ModArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.BOOTS, new Item.Properties()));

    // --------------- Food ---------------
    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().food(ModFoods.CHOCOLATE)));

    // --------------- Crops ---------------
    public static final RegistryObject<Item> BELLADONNA_SEEDS = ITEMS.register("belladonna_seeds", () -> new ItemNameBlockItem(ModBlocks.BELLADONNA_CROP.get(), new Item.Properties()));

    // --------------- Fuels ---------------
    public static final RegistryObject<Item> LEAF = ITEMS.register("leaf", () -> new FuelItem(new Item.Properties(), 50));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

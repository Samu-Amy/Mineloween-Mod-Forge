package net.samu.mineloween.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.item.custom.FuelItem;
import net.samu.mineloween.item.custom.WandItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SamuMineloweenMod.MOD_ID);

    public static final RegistryObject<Item> RAW_GEM = ITEMS.register("raw_gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM = ITEMS.register("gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WAND = ITEMS.register("wand", () -> new WandItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().food(ModFoods.CHOCOLATE)));

    public static final RegistryObject<Item> LEAF = ITEMS.register("leaf", () -> new FuelItem(new Item.Properties(), 50));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

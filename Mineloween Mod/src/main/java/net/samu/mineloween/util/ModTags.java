package net.samu.mineloween.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.samu.mineloween.SamuMineloweenMod;

// TODO: Elimina o modifica (per trovare i mob interessati nel raggio d'azione) "WAND_VALUABLES"

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> WAND_VALUABLES= tag("wand_valuables");
        public static final TagKey<Block> NEEDS_GEM_TOOL= tag("needs_gem_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SamuMineloweenMod.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SamuMineloweenMod.MOD_ID, name));
        }
    }
}

package net.samu.mineloween.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier GEM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2450, 10f, 5f, 20, ModTags.Blocks.NEEDS_GEM_TOOL, () -> Ingredient.of(ModItems.GEM.get())),
            new ResourceLocation(SamuMineloweenMod.MOD_ID, "gem"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier DARK = TierSortingRegistry.registerTier(
            new ForgeTier(6, 3000, 9f, 6f, 25, ModTags.Blocks.NEEDS_GEM_TOOL, () -> Ingredient.of(ModItems.GEM.get())),
            new ResourceLocation(SamuMineloweenMod.MOD_ID, "dark"), List.of(GEM), List.of()); // Tier più alto della netherite (che è livello 4)
    // TODO: cambia ingredients (e forse anche tags) per DARK
}

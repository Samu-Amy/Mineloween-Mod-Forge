package net.samu.mineloween.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.block.ModBlocks;
import net.samu.mineloween.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GEM_SMELTABLES = List.of(ModBlocks.GEM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_GEM.get(), 1f, 200, "gem");
        oreBlasting(pWriter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_GEM.get(), 1f, 100, "gem");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GEM.get(), 9)
                        .requires(ModBlocks.GEM_BLOCK.get())
                        .unlockedBy(getHasName(ModBlocks.GEM_BLOCK.get()), has(ModBlocks.GEM_BLOCK.get()))
                        .save(pWriter, "gem_from_gem_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GEM_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GEM.get())
                .unlockedBy(getHasName(ModItems.GEM.get()), has(ModItems.GEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GEM.get())
                .pattern(" R ")
                .pattern("RAR")
                .pattern(" R ")
                .define('R', ModItems.RAW_GEM.get())
                .define('A', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(ModItems.GEM.get()), has(ModItems.GEM.get()))
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WAND.get())
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.GEM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.GEM.get()), has(ModItems.GEM.get()))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, SamuMineloweenMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

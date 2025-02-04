package com.test.testmod.neighbor.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.block.ModBlocks;
import com.test.testmod.neighbor.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    //private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.GET(), ModItems.NETHER_RAW_SAPPHIRE.GET());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //oreSmelting(pWriter, ModItems.WINGLE, RecipeCategory.MISC, ModItems.THE_SLORBO.get(), 0.25f, 200, "slorbo");
        //oreBlasting(pWriter, ModItems.WINGLE, RecipeCategory.MISC, ModItems.THE_SLORBO.get(), 0.25f, 100, "the_slorbo");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GARUGAMESH.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.THE_SLORBO.get()), has(ModItems.THE_SLORBO.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THE_SLORBO.get(), 9)
                .requires(ModBlocks.GARUGAMESH.get())
                .unlockedBy(getHasName(ModBlocks.GARUGAMESH.get()), has(ModBlocks.GARUGAMESH.get()))
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
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TestMod.MODID + ":" +getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> WINGLE_SMELTABLES = List.of(ModItems.WINGLE.get(),
            ModBlocks.SLIMPO.get(), ModBlocks.SLIMPO_NETHERRACK.get());
    private static final List<ItemLike> PROMISE_SMELTABLES = List.of(ModItems.PROMISE.get(),
            ModBlocks.PROMISE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ///////////////////////////
        /////////NEIGHBOR//////////
        ///////////////////////////
        oreBlasting(pWriter, WINGLE_SMELTABLES, RecipeCategory.MISC, ModItems.THE_SLORBO.get(), 1, 150, "Slorbo");
        oreSmelting(pWriter, WINGLE_SMELTABLES, RecipeCategory.MISC, ModItems.THE_SLORBO.get(), 1, 50, "Slorbo");

        oreSmelting(pWriter, PROMISE_SMELTABLES, RecipeCategory.MISC, ModItems.IMPURE_PROMISE.get(), 5, 250, "Promise");
        oreBlasting(pWriter, PROMISE_SMELTABLES, RecipeCategory.MISC, ModItems.IMPURE_PROMISE.get(), 5, 150, "Promise");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GARUGAMESH.get())
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.WINGLE.get()), has(ModItems.WINGLE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_PROMISE.get())
                .pattern(" I ")
                .pattern("ISI")
                .pattern(" I ")
                .define('I', ModItems.IMPURE_PROMISE.get())
                .define('S', Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PROMISE_SWORD.get())
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" S ")
                .define('D', ModItems.PURE_PROMISE.get())
                .define('S', Items.DARK_OAK_LOG)
                .unlockedBy(getHasName(ModItems.PURE_PROMISE.get()), has(ModItems.PURE_PROMISE.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SLORP_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ANGRY_SLORP.get())
                .unlockedBy(getHasName(ModItems.ANGRY_SLORP.get()), has(ModItems.ANGRY_SLORP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GARUGAMESH_DOOR.get())
                .pattern("DD ")
                .pattern("DD ")
                .pattern("DD ")
                .define('D', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.WINGLE.get()), has(ModItems.WINGLE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SLORP_SWORD.get())
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" S ")
                .define('D', ModItems.ANGRY_SLORP.get())
                .define('S', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.ANGRY_SLORP.get()), has(ModItems.ANGRY_SLORP.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SLORP_SHOVEL.get())
                .pattern(" D ")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', ModItems.ANGRY_SLORP.get())
                .define('S', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.ANGRY_SLORP.get()), has(ModItems.ANGRY_SLORP.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SLORP_HOE.get())
                .pattern("DD ")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', ModItems.ANGRY_SLORP.get())
                .define('S', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.ANGRY_SLORP.get()), has(ModItems.ANGRY_SLORP.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SLORP_PICKAXE.get())
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', ModItems.ANGRY_SLORP.get())
                .define('S', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.ANGRY_SLORP.get()), has(ModItems.ANGRY_SLORP.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SLORP_AXE.get())
                .pattern("DD ")
                .pattern("DS ")
                .pattern(" S ")
                .define('D', ModItems.ANGRY_SLORP.get())
                .define('S', ModItems.THE_SLORBO.get())
                .unlockedBy(getHasName(ModItems.ANGRY_SLORP.get()), has(ModItems.ANGRY_SLORP.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WINGLE.get(), 9)
                .requires(ModBlocks.GARUGAMESH.get())
                .unlockedBy(getHasName(ModBlocks.GARUGAMESH.get()), has(ModBlocks.GARUGAMESH.get()))
                .save(pWriter);




        ///////////////////////////
        /////////SERENITY//////////
        ///////////////////////////
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SPEED_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CHUCKSTER_FRUIT.get())
                .unlockedBy(getHasName(ModItems.CHUCKSTER_FRUIT.get()), has(ModItems.CHUCKSTER_FRUIT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHUCKSTER_FRUIT.get(), 9)
                .requires(ModBlocks.SPEED_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SPEED_BLOCK.get()), has(ModBlocks.SPEED_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLUSH_DOOR.get())
                .pattern("DD ")
                .pattern("DD ")
                .pattern("DD ")
                .define('D', ModItems.SLIME_MACE.get())
                .unlockedBy(getHasName(ModItems.WINGLE.get()), has(ModItems.WINGLE.get()))
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
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TestMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}


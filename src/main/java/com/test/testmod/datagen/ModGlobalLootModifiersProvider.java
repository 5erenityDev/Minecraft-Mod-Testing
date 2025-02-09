package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.item.ModItems;

import com.test.testmod.loot.AddItemModifier;
import com.test.testmod.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, TestMod.MODID);
    }

    @Override
    protected void start() {

        //Serenity

        add("doohickey_from_dead_bush", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEAD_BUSH).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.DOOHICKEY.get()));

        add("permafrost_from_stray", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/stray")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, ModItems.PERMAFROST.get()));

        add("permafrost_from_igloos", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/igloo_chest")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build()}, ModItems.PERMAFROST.get()));

        add("doohickey_from_suspicious_sand", new AddSusSandItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build() }, ModItems.DOOHICKEY.get()));

        //Neighbor

        add("slorper_from_slorp_mass", new AddItemModifier(new LootItemCondition[] {
               LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SLORP_BLOCK.get()).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, ModItems.SLORPER.get()));

        add("pure_promise_from_enderdragon", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/ender_dragon")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ModItems.PURE_PROMISE.get()));

    }
}

package com.test.testmod.neighbor.datagen.loot;

import com.test.testmod.neighbor.block.ModBlocks;
import com.test.testmod.neighbor.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class Neighbor_ModBlockLootTables extends BlockLootSubProvider {
    public Neighbor_ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //this.dropSelf(ModBlocks.SPEED_BLOCK.get());
        this.dropSelf(ModBlocks.TOMBLER.get());
        this.dropSelf(ModBlocks.GARUGAMESH.get());

        //this.add(ModBlocks.SAPPHIRE_ORE.get(), block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));

        this.add(ModBlocks.SLIMPO.get(), block -> createBulkOreDrops(ModBlocks.SLIMPO.get(), ModItems.WINGLE.get()));
        this.add(ModBlocks.SLIMPO_NETHERRACK.get(), block -> createBulkOreDrops(ModBlocks.SLIMPO_NETHERRACK.get(), ModItems.WINGLE.get()));
        this.add(ModBlocks.SLORP_BLOCK.get(), block -> createBulkOreDrops(ModBlocks.SLORP_BLOCK.get(), ModItems.ANGRY_SLORP.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));

    }

    protected LootTable.Builder createBulkOreDrops (Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                (LootPoolEntryContainer.Builder) this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0F, 12.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)
                                )));
    }

    protected LootTable.Builder createFleshBlockDrops (Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                (LootPoolEntryContainer.Builder) this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 12.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)
                                )));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.NEIGHBOR_BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

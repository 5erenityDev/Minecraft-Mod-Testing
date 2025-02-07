package com.test.testmod.datagen.loot;

import com.test.testmod.block.ModBlocks;
import com.test.testmod.item.ModItems;
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

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        ///////////////////////////
        /////////NEIGHBOR//////////
        ///////////////////////////
        this.dropSelf(ModBlocks.TOMBLER.get());
        this.dropSelf(ModBlocks.GARUGAMESH.get());

        //this.add(ModBlocks.SAPPHIRE_ORE.get(), block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));

        this.add(ModBlocks.SLIMPO.get(), block -> createBulkOreDrops(ModBlocks.SLIMPO.get(), ModItems.WINGLE.get()));
        this.add(ModBlocks.SLIMPO_NETHERRACK.get(), block -> createBulkOreDrops(ModBlocks.SLIMPO_NETHERRACK.get(), ModItems.WINGLE.get()));
        this.add(ModBlocks.SLORP_BLOCK.get(), block -> createBulkOreDrops(ModBlocks.SLORP_BLOCK.get(), ModItems.ANGRY_SLORP.get()));
        this.add(ModBlocks.PROMISE_ORE.get(), block -> createSmallOreDrops(ModBlocks.PROMISE_ORE.get(), ModItems.PROMISE.get()));


        this.dropSelf(ModBlocks.GARUGAMESH_WALLS.get());
        this.dropSelf(ModBlocks.GARUGAMESH_FENCE.get());
        this.dropSelf(ModBlocks.GARUGAMESH_FENCE_GATE.get());
        this.dropSelf(ModBlocks.GARUGAMESH_BUTTON.get());
        this.dropSelf(ModBlocks.GARUGAMESH_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GARUGAMESH_STAIRS.get());
        this.dropSelf(ModBlocks.GARUGAMESH_TRAPDOOR.get());


        this.add(ModBlocks.GARUGAMESH_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GARUGAMESH_SLAB.get()));
        this.add(ModBlocks.GARUGAMESH_DOOR.get(),
                block -> createDoorTable(ModBlocks.GARUGAMESH_DOOR.get()));

        ///////////////////////////
        /////////SERENITY//////////
        ///////////////////////////
        this.dropSelf(ModBlocks.SPEED_BLOCK.get());
        this.dropSelf(ModBlocks.PLUSH_BLOCK.get());

        this.dropSelf(ModBlocks.PLUSH_WALLS.get());
        this.dropSelf(ModBlocks.PLUSH_FENCE.get());
        this.dropSelf(ModBlocks.PLUSH_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PLUSH_BUTTON.get());
        this.dropSelf(ModBlocks.PLUSH_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PLUSH_STAIRS.get());
        this.dropSelf(ModBlocks.PLUSH_TRAPDOOR.get());

        this.add(ModBlocks.PLUSH_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLUSH_SLAB.get()));
        this.add(ModBlocks.PLUSH_DOOR.get(),
                block -> createDoorTable(ModBlocks.PLUSH_DOOR.get()));

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

    protected LootTable.Builder createSmallOreDrops (Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                (LootPoolEntryContainer.Builder) this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
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
        //Collection<RegistryObject<Block>> combinedCollection = ModBlocks.NEIGHBOR_BLOCKS.getEntries();
        //Collection<RegistryObject<Block>> otherCollection = com.test.testmod.serenity.block.ModBlocks.SERENITY_BLOCKS.getEntries();
        //combinedCollection.addAll(otherCollection);
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

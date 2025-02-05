package com.test.testmod.neighbor.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class Neighbor_ModBlockStateProvider extends BlockStateProvider {
    public Neighbor_ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GARUGAMESH);
        blockWithItem(ModBlocks.SLIMPO);
        blockWithItem(ModBlocks.SLIMPO_NETHERRACK);
        blockWithItem(ModBlocks.TOMBLER);
        blockWithItem(ModBlocks.SLORP_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

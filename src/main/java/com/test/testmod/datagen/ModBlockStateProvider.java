package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ///////////////////////////
        /////////NEIGHBOR//////////
        ///////////////////////////
        blockWithItem(ModBlocks.GARUGAMESH);
        blockWithItem(ModBlocks.SLIMPO);
        blockWithItem(ModBlocks.SLIMPO_NETHERRACK);
        blockWithItem(ModBlocks.TOMBLER);
        blockWithItem(ModBlocks.SLORP_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.GARUGAMESH_STAIRS.get()), blockTexture(ModBlocks.GARUGAMESH.get()));
        slabBlock(((SlabBlock) ModBlocks.GARUGAMESH_SLAB.get()), blockTexture(ModBlocks.GARUGAMESH.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        buttonBlock(((ButtonBlock) ModBlocks.GARUGAMESH_BUTTON.get()), blockTexture(ModBlocks.GARUGAMESH.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GARUGAMESH_PRESSURE_PLATE.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        fenceBlock(((FenceBlock) ModBlocks.GARUGAMESH_FENCE.get()), blockTexture(ModBlocks.GARUGAMESH.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GARUGAMESH_FENCE_GATE.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        wallBlock(((WallBlock) ModBlocks.GARUGAMESH_WALLS.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.GARUGAMESH_DOOR.get(), modLoc("block/garugamesh_door_bottom"), modLoc("block/garugamesh_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.GARUGAMESH_TRAPDOOR.get()), modLoc("block/garugamesh_trapdoor"), true, "cutout");

        ///////////////////////////
        /////////SERENITY//////////
        ///////////////////////////
        blockWithItem(com.test.testmod.serenity.block.ModBlocks.SPEED_BLOCK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.neighbor.block.custom.MashedPotatoSquashCropBlock;
import com.test.testmod.neighbor.block.custom.StompleCropBlock;
import com.test.testmod.serenity.block.custom.ChucksterCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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
        blockWithItem(ModBlocks.PROMISE_ORE);
        blockWithItem(ModBlocks.PROMISE_BLOCK);

        simpleBlockWithItem(ModBlocks.GIGGLE.get(), models().cross(blockTexture(ModBlocks.GIGGLE.get()).getPath(),
                blockTexture(ModBlocks.GIGGLE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_GIGGLE.get(), models().singleTexture("potted_giggle",
                new ResourceLocation("flower_pot_cross"), "plant", blockTexture(ModBlocks.GIGGLE.get())).renderType("cutout"));

        stairsBlock(((StairBlock) ModBlocks.GARUGAMESH_STAIRS.get()), blockTexture(ModBlocks.GARUGAMESH.get()));
        slabBlock(((SlabBlock) ModBlocks.GARUGAMESH_SLAB.get()), blockTexture(ModBlocks.GARUGAMESH.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        buttonBlock(((ButtonBlock) ModBlocks.GARUGAMESH_BUTTON.get()), blockTexture(ModBlocks.GARUGAMESH.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GARUGAMESH_PRESSURE_PLATE.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        fenceBlock(((FenceBlock) ModBlocks.GARUGAMESH_FENCE.get()), blockTexture(ModBlocks.GARUGAMESH.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GARUGAMESH_FENCE_GATE.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        wallBlock(((WallBlock) ModBlocks.GARUGAMESH_WALLS.get()), blockTexture(ModBlocks.GARUGAMESH.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.GARUGAMESH_DOOR.get(), modLoc("block/garugamesh_door_bottom"), modLoc("block/garugamesh_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.GARUGAMESH_TRAPDOOR.get()), modLoc("block/garugamesh_trapdoor"), true, "cutout");

        makeMashedPotatoSquashCrop((CropBlock) ModBlocks.MASHEDPOTATOSQUASH_CROP.get(), "mashedpotatosquash_stage", "mashedpotatosquash_stage");
        makeStomplerCrop((CropBlock) ModBlocks.STOMPLE_CROP.get(), "stompler_stage", "stompler_stage");

        ///////////////////////////
        /////////SERENITY//////////
        ///////////////////////////
        blockWithItem(ModBlocks.SPEED_BLOCK);
        blockWithItem(ModBlocks.PLUSH_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.PLUSH_STAIRS.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.PLUSH_SLAB.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.PLUSH_BUTTON.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PLUSH_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.PLUSH_FENCE.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PLUSH_FENCE_GATE.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()));

        wallBlock(((WallBlock) ModBlocks.PLUSH_WALLS.get()), blockTexture(ModBlocks.PLUSH_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.PLUSH_DOOR.get(), modLoc("block/plush_door_bottom"), modLoc("block/plush_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PLUSH_TRAPDOOR.get()), modLoc("block/plush_trapdoor"), true, "cutout");

        makeChucksterCrop((CropBlock) ModBlocks.CHUCKSTER_CROP.get(), "chuckster_stage", "chuckster_stage");
    }

    public void makeChucksterCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> chucksterStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] chucksterStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ChucksterCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MODID, "block/" + textureName + state.getValue(((ChucksterCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));


    }


    private ConfiguredModel[] mashedPotatoSquashStates(BlockState state, CropBlock block, String modelname, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelname + state.getValue(((MashedPotatoSquashCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MODID, "block/" + textureName + state.getValue(((MashedPotatoSquashCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeMashedPotatoSquashCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> mashedPotatoSquashStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] stomplerStates(BlockState state, CropBlock block, String modelname, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelname + state.getValue(((StompleCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MODID, "block/" + textureName + state.getValue(((StompleCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeStomplerCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> stomplerStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

}

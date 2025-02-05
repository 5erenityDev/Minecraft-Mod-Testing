package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.neighbor.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ///////////////////////////
        /////////NEIGHBOR//////////
        ///////////////////////////
        simpleItem(ModItems.ANGRY_SLORP);
        simpleItem(ModItems.SLOP);
        simpleItem(ModItems.GROBBLER);
        simpleItem(ModItems.THE_SLORBO);
        simpleItem(ModItems.WINGLE);

        evenSimplerBlockItem(ModBlocks.GARUGAMESH_STAIRS);
        evenSimplerBlockItem(ModBlocks.GARUGAMESH_SLAB);
        evenSimplerBlockItem(ModBlocks.GARUGAMESH_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.GARUGAMESH_FENCE_GATE);

        simpleBlockItem(ModBlocks.GARUGAMESH_DOOR);

        fenceInventory("garugamesh_fence", modLoc("block/garugamesh"));
        buttonInventory("garugamesh_button", modLoc("block/garugamesh"));
        wallInventory("garugamesh_walls", modLoc("block/garugamesh"));
        trapdoorBottom("garugamesh_trapdoor", modLoc("block/garugamesh_trapdoor"));


        ///////////////////////////
        /////////SERENITY//////////
        ///////////////////////////
        simpleItem(com.test.testmod.serenity.item.ModItems.CHUCKSTER_FRUIT);
        simpleItem(com.test.testmod.serenity.item.ModItems.MACE);
        simpleItem(com.test.testmod.serenity.item.ModItems.TELEPORT_STAFF);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(TestMod.MODID, "item/" + item.getId().getPath()));
    }


    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TestMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
        new ResourceLocation(TestMod.MODID, "item/" + item.getId().getPath()));
    }
}

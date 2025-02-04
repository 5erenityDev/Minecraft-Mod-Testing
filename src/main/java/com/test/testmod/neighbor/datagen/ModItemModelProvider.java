package com.test.testmod.neighbor.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ANGRY_SLORP);
        simpleItem(ModItems.SLOP);
        simpleItem(ModItems.GROBBLER);
        simpleItem(ModItems.THE_SLORBO);
        simpleItem(ModItems.WINGLE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(TestMod.MODID, "item/" + item.getId().getPath()));
    }
}

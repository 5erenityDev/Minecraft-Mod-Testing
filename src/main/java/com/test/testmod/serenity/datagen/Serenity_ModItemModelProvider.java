package com.test.testmod.serenity.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.serenity.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class Serenity_ModItemModelProvider extends ItemModelProvider {
    public Serenity_ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CHUCKSTER_FRUIT);
        simpleItem(ModItems.MACE);
        simpleItem(ModItems.TELEPORT_STAFF);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(TestMod.MODID, "item/" + item.getId().getPath()));
    }
}

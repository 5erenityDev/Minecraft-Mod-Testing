package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ///////////////////////////
        /////////NEIGHBOR//////////
        ///////////////////////////
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SLORP_HELMET.get(),
                        ModItems.SLORP_BOOTS.get(),
                        ModItems.SLORP_LEGGINGS.get(),
                        ModItems.SLORP_CHESTPLATE.get())
                .add(ModItems.PROMISE_HELMET.get(),
                        ModItems.PROMISE_CHESTPLATE.get(),
                        ModItems.PROMISE_LEGGINGS.get(),
                        ModItems.PROMISE_BOOTS.get());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_KANPAI.get());



        ///////////////////////////
        /////////SERENITY//////////
        ///////////////////////////
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PERMAFROST_HELMET.get(),
                        ModItems.PERMAFROST_BOOTS.get(),
                        ModItems.PERMAFROST_LEGGINGS.get(),
                        ModItems.PERMAFROST_BOOTS.get());
    }
}

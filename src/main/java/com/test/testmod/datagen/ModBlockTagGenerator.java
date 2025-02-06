package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.neighbor.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ///////////////////////////
        /////////NEIGHBOR//////////
        ///////////////////////////
        this.tag(ModTags.Blocks.SLORP_REVENGE).add(ModBlocks.SLIMPO.get());


        //this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());
        //this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());
        //this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());
        //this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SLIMPO_NETHERRACK.get())
                .add(ModBlocks.SLIMPO.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.SLORP_BLOCK.get());



        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SLIMPO.get())
                .add(ModBlocks.SLIMPO_NETHERRACK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
                .add(ModBlocks.SLORP_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.GARUGAMESH_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.GARUGAMESH_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.GARUGAMESH_WALLS.get());



        ///////////////////////////
        /////////SERENITY//////////
        ///////////////////////////

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PLUSH_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PLUSH_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.PLUSH_WALLS.get());

    }
}

package com.test.testmod.serenity.datagen;

import com.test.testmod.TestMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class Serenity_ModBlockTagGenerator extends BlockTagsProvider {

    public Serenity_ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //this.tag(ModTags.Blocks.METAL_DETCTOR_VALUABLES).add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);


        //this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());
        //this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());
        //this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());
        //this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get());


        //this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(ModBlocks.SAPPHIRE_ORE.get());

        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.SAPPHIRE_ORE.get());

        //this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SAPPHIRE_ORE.get());

        //this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.SAPPHIRE_ORE.get());
    }
}

package com.test.testmod.neighbor.util;

import com.test.testmod.TestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> SLORP_REVENGE = tag("slorp_revenge");
        public static final TagKey<Block> NEEDS_SLORP_TOOL = tag("needs_slorp_tool");
        public static final TagKey<Block> NEEDS_PROMISE_TOOL = tag("needs_promise_tool");

        public static final TagKey<Block> NEEDS_PERMAFROST_TOOL = tag("needs_permafrost_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TestMod.MODID, name));
        }
    }
    public static class Items{


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TestMod.MODID, name));

        }
    }

}

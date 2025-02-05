package com.test.testmod.serenity.block;

import com.test.testmod.TestMod;
import com.test.testmod.serenity.block.custom.SpeedBlock;
import com.test.testmod.serenity.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Creates Register
    public static final DeferredRegister<Block> SERENITY_BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    // Puts Items on Register
    public static void register(IEventBus eventBus) {
        SERENITY_BLOCKS.register(eventBus);
    }

    // Initialize Block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = SERENITY_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Initialize Item
    private static  <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.SERENITY_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


}

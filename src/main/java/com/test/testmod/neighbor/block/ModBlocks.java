package com.test.testmod.neighbor.block;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.block.custom.TomblerBlock;
import com.test.testmod.neighbor.item.ModItems;
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
    public static final DeferredRegister<Block> NEIGHBOR_BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    // Puts Items on Register
    public static void register(IEventBus eventBus) {
        NEIGHBOR_BLOCKS.register(eventBus);
    }

    // Initialize Block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = NEIGHBOR_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Initialize Item
    private static  <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.NEIGHBOR_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> TOMBLER = registerBlock(
            "tombler",
            () -> new TomblerBlock(BlockBehaviour.Properties
                    .copy(Blocks.DIRT)
                    .sound(SoundType.COPPER)
                    .strength(1f)
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> GARUGAMESH = registerBlock
            ("garugamesh", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.AMETHYST)
            ));
    public static final RegistryObject<Block> SLIMPO = registerBlock
            ("slimpo", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.CHAIN)
                    .requiresCorrectToolForDrops()
                    .strength(3, 1)
            ));
}

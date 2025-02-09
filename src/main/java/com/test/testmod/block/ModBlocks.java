package com.test.testmod.block;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.block.custom.MashedPotatoSquashCropBlock;
import com.test.testmod.neighbor.block.custom.StompleCropBlock;
import com.test.testmod.neighbor.block.custom.TomblerBlock;
import com.test.testmod.item.ModItems;
import com.test.testmod.serenity.block.custom.ChucksterCropBlock;
import com.test.testmod.serenity.block.custom.SpeedBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Creates Register
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    // Puts Items on Register
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // Initialize Block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Initialize Item
    private static  <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
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
            ("garugamesh", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)
            ));
    public static final RegistryObject<Block> SLIMPO = registerBlock
            ("slimpo", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .sound(SoundType.NETHERRACK)
                    .strength(1f).requiresCorrectToolForDrops(), UniformInt.of(2, 3)
            ));
    public static final RegistryObject<Block> SLIMPO_NETHERRACK = registerBlock
            ("slimpo_netherrack", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .sound(SoundType.NETHERRACK)
                    .strength(0.8f).requiresCorrectToolForDrops(), UniformInt.of(1, 4)
            ));
    public static final RegistryObject<Block> SLORP_BLOCK = registerBlock
            ("slorp_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)
                    .sound(SoundType.SLIME_BLOCK)
                    .strength(3).requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> PROMISE_ORE = registerBlock
            ("promise_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .sound(SoundType.AMETHYST)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(5, 6)
            ));



    //Slabs, Stairs, Doors, Pressure plates, Buttons etc

    public static final RegistryObject<Block> GARUGAMESH_STAIRS = registerBlock
            ("garugamesh_stairs", () -> new StairBlock(() -> ModBlocks.GARUGAMESH.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)
            ));
    public static final RegistryObject<Block> GARUGAMESH_SLAB = registerBlock
            ("garugamesh_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)
            ));
    public static final RegistryObject<Block> GARUGAMESH_BUTTON = registerBlock
            ("garugamesh_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST),
                    BlockSetType.IRON, 20, true
            ));
    public static final RegistryObject<Block> GARUGAMESH_PRESSURE_PLATE = registerBlock
            ("garugamesh_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST),
                    BlockSetType.IRON
            ));
    public static final RegistryObject<Block> GARUGAMESH_FENCE = registerBlock
            ("garugamesh_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)
            ));
    public static final RegistryObject<Block> GARUGAMESH_FENCE_GATE = registerBlock
            ("garugamesh_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST),
                    SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_DOOR_CLOSE
            ));
    public static final RegistryObject<Block> GARUGAMESH_WALLS = registerBlock
            ("garugamesh_walls", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)
            ));
    //.noOcclusion() prevents an xray pretty much, cant see through the world. these are complicated but if you read them they are very simple
    public static final RegistryObject<Block> GARUGAMESH_DOOR = registerBlock
            ("garugamesh_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),
                    BlockSetType.DARK_OAK
            ));
    public static final RegistryObject<Block> GARUGAMESH_TRAPDOOR = registerBlock
            ("garugamesh_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST).noOcclusion(),
                    BlockSetType.DARK_OAK
            ));

    public static final RegistryObject<Block> GIGGLE = registerBlock
            ("giggle", () -> new FlowerBlock(() -> MobEffects.MOVEMENT_SPEED, 6, BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()
            ));
    public static final RegistryObject<Block> POTTED_GIGGLE = BLOCKS.register
            ("potted_giggle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.GIGGLE, BlockBehaviour.Properties.copy(Blocks.POTTED_AZALEA).noOcclusion()
            ));

    //Neighbor Crops
    public static final RegistryObject<Block> MASHEDPOTATOSQUASH_CROP = BLOCKS.register("mashedpotatosquash_crop",
            () -> new MashedPotatoSquashCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> STOMPLE_CROP = BLOCKS.register("stomple_crop",
            () -> new StompleCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));


    //Serenity


    public static final RegistryObject<Block> SPEED_BLOCK = registerBlock(
            "speed_block",
            () -> new SpeedBlock(BlockBehaviour.Properties
                    .copy(Blocks.DARK_PRISMARINE)
                    .sound(SoundType.AMETHYST)
                    .strength(0.1f)
                    .jumpFactor(5f)
                    .speedFactor(5f)
                    .requiresCorrectToolForDrops()
            )
    );
    public static final RegistryObject<Block> PLUSH_BLOCK = registerBlock
            ("plush_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL)
            ));
    //Slabs, Stairs, Doors, Pressure plates, Buttons etc
    public static final RegistryObject<Block> PLUSH_STAIRS = registerBlock
            ("plush_stairs", () -> new StairBlock(() -> ModBlocks.PLUSH_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL)
            ));
    public static final RegistryObject<Block> PLUSH_SLAB = registerBlock
            ("plush_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL)
            ));
    public static final RegistryObject<Block> PLUSH_BUTTON = registerBlock
            ("plush_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 20, true
            ));
    public static final RegistryObject<Block> PLUSH_PRESSURE_PLATE = registerBlock
            ("plush_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL),
                    BlockSetType.IRON
            ));
    public static final RegistryObject<Block> PLUSH_FENCE = registerBlock
            ("plush_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL)
            ));
    public static final RegistryObject<Block> PLUSH_FENCE_GATE = registerBlock
            ("plush_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL),
                    SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_DOOR_CLOSE
            ));
    public static final RegistryObject<Block> PLUSH_WALLS = registerBlock
            ("plush_walls", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL)
            ));
    public static final RegistryObject<Block> PLUSH_DOOR = registerBlock
            ("plush_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL).noOcclusion(),
                    BlockSetType.DARK_OAK
            ));
    public static final RegistryObject<Block> PLUSH_TRAPDOOR = registerBlock
            ("plush_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL).noOcclusion(),
                    BlockSetType.DARK_OAK
            ));

    public static final RegistryObject<Block> CHUCKSTER_CROP = BLOCKS.register("chuckster_crop",
            () -> new ChucksterCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
}

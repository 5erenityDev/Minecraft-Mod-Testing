package com.test.testmod.neighbor.item;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    // Creates Register
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    // Puts Items on Register
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    // Creates Tabs
    public static final RegistryObject<CreativeModeTab> NEIGHBOR_TAB = CREATIVE_MODE_TABS.register(
            "neighbor_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SLOP.get()))
                    .title(Component.translatable("creativetab.neighbor_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TOMBLER.get());
                        output.accept(ModBlocks.GARUGAMESH.get());
                        output.accept(ModBlocks.SLIMPO.get());
                        output.accept(ModBlocks.SLIMPO_NETHERRACK.get());
                        output.accept(ModBlocks.SLORP_BLOCK.get());
                        output.accept(ModItems.SLOP.get());
                        output.accept(ModItems.GROBBLER.get());
                        output.accept(ModItems.THE_SLORBO.get());
                        output.accept(ModItems.WINGLE.get());
                        output.accept(ModItems.ANGRY_SLORP.get());

                        output.accept(ModBlocks.GARUGAMESH_SLAB.get());
                        output.accept(ModBlocks.GARUGAMESH_STAIRS.get());
                        output.accept(ModBlocks.GARUGAMESH_DOOR.get());
                        output.accept(ModBlocks.GARUGAMESH_FENCE.get());
                        output.accept(ModBlocks.GARUGAMESH_FENCE_GATE.get());
                        output.accept(ModBlocks.GARUGAMESH_BUTTON.get());
                        output.accept(ModBlocks.GARUGAMESH_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.GARUGAMESH_TRAPDOOR.get());
                        output.accept(ModBlocks.GARUGAMESH_WALLS.get());
                    }).build()
    );


}

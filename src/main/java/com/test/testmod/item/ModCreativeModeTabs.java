package com.test.testmod.item;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
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
                        output.accept(ModItems.SLORPER.get());
                        output.accept(ModItems.ANGRY_SLORP.get());
                        output.accept(ModItems.SLORP_AXE.get());
                        output.accept(ModItems.SLORP_HOE.get());
                        output.accept(ModItems.SLORP_PICKAXE.get());
                        output.accept(ModItems.SLORP_SHOVEL.get());
                        output.accept(ModItems.SLORP_SWORD.get());

                        output.accept(ModItems.SLORP_HELMET.get());
                        output.accept(ModItems.SLORP_CHESTPLATE.get());
                        output.accept(ModItems.SLORP_LEGGINGS.get());
                        output.accept(ModItems.SLORP_BOOTS.get());

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

    public static final RegistryObject<CreativeModeTab> Promise_Tab = CREATIVE_MODE_TABS.register(
            "promise_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PURE_PROMISE.get()))
                    .title(Component.translatable("creativetab.promise_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PROMISE.get());
                        output.accept(ModItems.PURE_PROMISE.get());
                        output.accept(ModItems.IMPURE_PROMISE.get());
                        output.accept(ModItems.PROMISE_SWORD.get());
                        output.accept(ModBlocks.PROMISE_ORE.get());
                        output.accept(ModItems.PROMISE_HELMET.get());
                        output.accept(ModItems.PROMISE_CHESTPLATE.get());
                        output.accept(ModItems.PROMISE_LEGGINGS.get());
                        output.accept(ModItems.PROMISE_BOOTS.get());
                    }).build()
    );

    public static final RegistryObject<CreativeModeTab> SERENITY_TAB = CREATIVE_MODE_TABS.register(
            "serenity_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TELEPORT_STAFF.get()))
                    .title(Component.translatable("creativetab.serenity_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SPEED_BLOCK.get());
                        output.accept(ModItems.TELEPORT_STAFF.get());
                        output.accept(ModItems.MACE.get());
                        output.accept(ModItems.CHUCKSTER_FRUIT.get());
                        output.accept(ModItems.DOOHICKEY.get());
                        output.accept(ModItems.SLIME_MACE.get());

                        output.accept(ModBlocks.PLUSH_SLAB.get());
                        output.accept(ModBlocks.PLUSH_STAIRS.get());
                        output.accept(ModBlocks.PLUSH_DOOR.get());
                        output.accept(ModBlocks.PLUSH_FENCE.get());
                        output.accept(ModBlocks.PLUSH_FENCE_GATE.get());
                        output.accept(ModBlocks.PLUSH_BUTTON.get());
                        output.accept(ModBlocks.PLUSH_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PLUSH_TRAPDOOR.get());
                        output.accept(ModBlocks.PLUSH_WALLS.get());

                        output.accept(ModItems.PERMAFROST_SLEDGEHAMMER.get());
                        output.accept(ModItems.PERMAFROST_SCYTHE.get());
                        output.accept(ModItems.PERMAFROST_ICE_AXE.get());
                        output.accept(ModItems.PERMAFROST_ICE_SCRAPER.get());
                        output.accept(ModItems.PERMAFROST_ESTOC.get());
                    }).build()
    );

    


}

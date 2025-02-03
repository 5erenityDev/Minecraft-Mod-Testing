package com.test.testmod.neighbor.item;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.block.ModBlocks;
import com.test.testmod.neighbor.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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
                        output.accept(ModItems.SLOP.get());
                    }).build()
    );


}

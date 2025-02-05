package com.test.testmod.serenity.item;

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
    public static final RegistryObject<CreativeModeTab> SERENITY_TAB = CREATIVE_MODE_TABS.register(
            "serenity_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TELEPORT_STAFF.get()))
                    .title(Component.translatable("creativetab.serenity_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SPEED_BLOCK.get());
                        output.accept(ModItems.TELEPORT_STAFF.get());
                        output.accept(ModItems.MACE.get());
                        output.accept(ModItems.CHUCKSTER_FRUIT.get());
                    }).build()
    );


}

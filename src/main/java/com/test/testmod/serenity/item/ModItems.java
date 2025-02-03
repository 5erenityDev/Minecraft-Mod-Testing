package com.test.testmod.serenity.item;

import com.test.testmod.TestMod;
import com.test.testmod.serenity.item.custom.TeleportStaffItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Creates Register
    public static final DeferredRegister<Item> SERENITY_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    // Puts Items on Register
    public static void register(IEventBus eventBus) {
        SERENITY_ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> CHUCKSTER_FRUIT = SERENITY_ITEMS.register(
            "chuckster_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.CHUCKSTER_FRUIT))
    );

    public static final RegistryObject<Item> TELEPORT_STAFF = SERENITY_ITEMS.register(
            "teleport_staff",
            () -> new TeleportStaffItem(new Item.Properties().durability(100))
    );
}

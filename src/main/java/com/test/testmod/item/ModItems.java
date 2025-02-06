package com.test.testmod.item;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.item.custom.FuelItem;
import com.test.testmod.neighbor.item.custom.GrobblerItem;
import com.test.testmod.serenity.item.custom.MaceItem;
import com.test.testmod.serenity.item.custom.TeleportStaffItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Creates Register
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    // Puts Items on Register
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> SLOP = ITEMS.register(
            "slop",
            () -> new Item(new Item.Properties().food(ModFoods.SLOP)));
    public static final RegistryObject<Item> THE_SLORBO = ITEMS.register
            ("the_slorbo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WINGLE = ITEMS.register
            ("wingle", () -> new Item(new Item.Properties()));
    public  static final  RegistryObject<Item> GROBBLER = ITEMS.register
            ("grobbler", () -> new GrobblerItem(new Item.Properties().defaultDurability(200)));
    public static final RegistryObject<Item> ANGRY_SLORP = ITEMS.register
            ("angry_slorp", () -> new FuelItem(new Item.Properties(), 2000));



    public static final RegistryObject<Item> CHUCKSTER_FRUIT = ITEMS.register(
            "chuckster_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.CHUCKSTER_FRUIT))
    );

    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register(
            "teleport_staff",
            () -> new TeleportStaffItem(new Item.Properties().durability(100))
    );

    public static final RegistryObject<Item> MACE = ITEMS.register(
            "mace",
            () -> new MaceItem(new Item.Properties().durability(100))
    );

}

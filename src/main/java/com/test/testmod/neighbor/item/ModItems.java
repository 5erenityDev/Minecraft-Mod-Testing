package com.test.testmod.neighbor.item;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.item.ModFoods;
import com.test.testmod.neighbor.item.custom.GrobblerItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Creates Register
    public static final DeferredRegister<Item> NEIGHBOR_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    // Puts Items on Register
    public static void register(IEventBus eventBus) {
        NEIGHBOR_ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> SLOP = NEIGHBOR_ITEMS.register(
            "slop",
            () -> new Item(new Item.Properties().food(ModFoods.SLOP)));
    public static final RegistryObject<Item> THE_SLORBO = NEIGHBOR_ITEMS.register
            ("the_slorbo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WINGLE = NEIGHBOR_ITEMS.register
            ("wingle", () -> new Item(new Item.Properties()));
    public  static final  RegistryObject<Item> GROBBLER = NEIGHBOR_ITEMS.register
            ("grobbler", () -> new GrobblerItem(new Item.Properties().defaultDurability(200)));

}

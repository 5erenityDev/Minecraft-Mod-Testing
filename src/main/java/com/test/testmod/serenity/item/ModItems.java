package com.test.testmod.serenity.item;

import com.test.testmod.TestMod;
import com.test.testmod.serenity.item.custom.MaceItem;
import com.test.testmod.serenity.item.custom.TeleportStaffItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Creates Register
    public static final DeferredRegister<Item> SERENITY_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);


}

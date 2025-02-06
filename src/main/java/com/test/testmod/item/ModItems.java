package com.test.testmod.item;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.item.custom.FuelItem;
import com.test.testmod.neighbor.item.custom.GrobblerItem;
import com.test.testmod.serenity.item.custom.DoohickeyItem;
import com.test.testmod.serenity.item.custom.MaceItem;
import com.test.testmod.serenity.item.custom.TeleportStaffItem;
import net.minecraft.world.item.*;
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
    public static final RegistryObject<Item> SLORPER = ITEMS.register
            ("slorper", () -> new BowItem(new Item.Properties().defaultDurability(400)));

    public static final RegistryObject<Item> SLORP_SWORD = ITEMS.register
            ("slorp_sword", () -> new SwordItem(ModToolTiers.SLORP, 3,5,
                    new Item.Properties().defaultDurability(600)));
    public static final RegistryObject<Item> SLORP_PICKAXE = ITEMS.register
            ("slorp_pickaxe", () -> new PickaxeItem(ModToolTiers.SLORP, 1,8,
                    new Item.Properties().defaultDurability(600)));
    public static final RegistryObject<Item> SLORP_AXE = ITEMS.register
            ("slorp_axe", () -> new AxeItem(ModToolTiers.SLORP, 10,2,
                    new Item.Properties().defaultDurability(600)));
    public static final RegistryObject<Item> SLORP_HOE = ITEMS.register
            ("slorp_hoe", () -> new HoeItem(ModToolTiers.SLORP, 0,2,
                    new Item.Properties().defaultDurability(800)));
    public static final RegistryObject<Item> SLORP_SHOVEL = ITEMS.register
            ("slorp_shovel", () -> new ShovelItem(ModToolTiers.SLORP, 2,1,
                    new Item.Properties().defaultDurability(600)));

    public static final RegistryObject<Item> SLORP_HELMET = ITEMS.register
            ("slorp_helmet", () -> new ArmorItem(ModArmorMaterials.SLORP, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SLORP_CHESTPLATE = ITEMS.register
            ("slorp_chestplate", () -> new ArmorItem(ModArmorMaterials.SLORP, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SLORP_LEGGINGS = ITEMS.register
            ("slorp_leggings", () -> new ArmorItem(ModArmorMaterials.SLORP, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SLORP_BOOTS = ITEMS.register
            ("slorp_boots", () -> new ArmorItem(ModArmorMaterials.SLORP, ArmorItem.Type.BOOTS, new Item.Properties()));




    //Serenity Stuff

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

    public static final RegistryObject<Item> DOOHICKEY = ITEMS.register(
            "doohickey",
            () -> new DoohickeyItem(new Item.Properties().durability(6))
    );

}

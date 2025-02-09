package com.test.testmod.item;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.neighbor.item.custom.FuelItem;
import com.test.testmod.neighbor.item.custom.GrobblerItem;
import com.test.testmod.item.ModArmorItem;
import com.test.testmod.neighbor.item.custom.SlorperItem;
import com.test.testmod.serenity.item.custom.DoohickeyItem;
import com.test.testmod.serenity.item.custom.MaceItem;
import com.test.testmod.serenity.item.custom.SlimeMaceItem;
import com.test.testmod.serenity.item.custom.TeleportStaffItem;
import com.test.testmod.serenity.item.custom.*;
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
            ("slorper", () -> new SlorperItem(new Item.Properties().defaultDurability(400)));

    public static final RegistryObject<Item> PROMISE = ITEMS.register
            ("promise", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPURE_PROMISE = ITEMS.register
            ("impure_promise", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURE_PROMISE = ITEMS.register
            ("pure_promise", () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PROMISE_SWORD = ITEMS.register
            ("promise_sword", () -> new SwordItem(ModToolTiers.PROMISE, 6,0,
                    new Item.Properties().defaultDurability(2000).fireResistant()));

    public static final RegistryObject<Item> PROMISE_HELMET = ITEMS.register
            ("promise_helmet", () -> new ModArmorItem(ModArmorMaterials.PROMISE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PROMISE_CHESTPLATE = ITEMS.register
            ("promise_chestplate", () -> new ArmorItem(ModArmorMaterials.PROMISE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PROMISE_LEGGINGS = ITEMS.register
            ("promise_leggings", () -> new ArmorItem(ModArmorMaterials.PROMISE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PROMISE_BOOTS = ITEMS.register
            ("promise_boots", () -> new ArmorItem(ModArmorMaterials.PROMISE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));


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
            () -> new ChucksterFruitItem(new Item.Properties().food(ModFoods.CHUCKSTER_FRUIT))
    );

    public static final RegistryObject<Item> CHUCKSTER_SEEDS = ITEMS.register(
            "chuckster_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CHUCKSTER_CROP.get(), new Item.Properties())
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

    public static final RegistryObject<Item> SLIME_MACE = ITEMS.register(
            "slime_mace",
            () -> new SlimeMaceItem(new Item.Properties().durability(100))
    );


    public static final RegistryObject<Item> PERMAFROST = ITEMS.register
            ("permafrost", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PERMAFROST_ESTOC = ITEMS.register
            ("permafrost_estoc", () -> new SwordItem(ModToolTiers.PERMAFROST, 3,50,
                    new Item.Properties().defaultDurability(600)));
    public static final RegistryObject<Item> PERMAFROST_ICE_AXE = ITEMS.register
            ("permafrost_ice_axe", () -> new PickaxeItem(ModToolTiers.PERMAFROST, 1,8,
                    new Item.Properties().defaultDurability(600)));
    public static final RegistryObject<Item> PERMAFROST_SLEDGEHAMMER = ITEMS.register
            ("permafrost_sledgehammer", () -> new AxeItem(ModToolTiers.PERMAFROST, 10,2,
                    new Item.Properties().defaultDurability(600)));
    public static final RegistryObject<Item> PERMAFROST_SCYTHE = ITEMS.register
            ("permafrost_scythe", () -> new HoeItem(ModToolTiers.PERMAFROST, 0,2,
                    new Item.Properties().defaultDurability(800)));
    public static final RegistryObject<Item> PERMAFROST_ICE_SCRAPER = ITEMS.register
            ("permafrost_ice_scraper", () -> new ShovelItem(ModToolTiers.PERMAFROST, 2,1,
                    new Item.Properties().defaultDurability(600)));

    public static final RegistryObject<Item> PERMAFROST_ICE_LAUNCHER = ITEMS.register(
            "permafrost_ice_launcher",
            () -> new PermafrostIceLauncherItem(new Item.Properties().durability(600))
    );

    public static final RegistryObject<Item> PERMAFROST_HELMET = ITEMS.register
            ("permafrost_helmet", () -> new ModArmorItem(ModArmorMaterials.PERMAFROST, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> PERMAFROST_CHESTPLATE = ITEMS.register
            ("permafrost_chestplate", () -> new ModArmorItem(ModArmorMaterials.PERMAFROST, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> PERMAFROST_LEGGINGS = ITEMS.register
            ("permafrost_leggings", () -> new ModArmorItem(ModArmorMaterials.PERMAFROST, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> PERMAFROST_BOOTS = ITEMS.register
            ("permafrost_boots", () -> new ModArmorItem(ModArmorMaterials.PERMAFROST, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
}

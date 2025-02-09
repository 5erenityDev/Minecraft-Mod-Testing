package com.test.testmod.item;

import com.test.testmod.TestMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SLORP("slorp", 26,new int[]{ 6, 9, 6, 4 }, 25, SoundEvents.SLIME_BLOCK_HIT,
            1f, 2f, () -> Ingredient.of(ModItems.ANGRY_SLORP.get())),
    PROMISE("promise", 27, new int[]{10, 15, 10, 8}, 25, SoundEvents.ARMOR_EQUIP_DIAMOND,
            2f, 3f, () -> Ingredient.of(ModItems.PURE_PROMISE.get())),


    PERMAFROST("permafrost", 26,new int[]{ 999, 999, 999, 999 }, 25, SoundEvents.SNOW_STEP,
            1f, 2f, () -> Ingredient.of(ModItems.PERMAFROST.get()));


 private final String name;
 private final int durabilityMultiplyer;
 private final int[] protectionAmounts;
 private final int enchantmentValue;
 private final SoundEvent equipSound;
 private final float toughness;
 private final float knockbackResistance;
 private final Supplier<Ingredient> repairIngredient;

 private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplyer, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplyer = durabilityMultiplyer;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * durabilityMultiplyer;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return TestMod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

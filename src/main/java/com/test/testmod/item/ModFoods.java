package com.test.testmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SLOP = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, 200, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 1f)
            .build();

    public static final FoodProperties CHUCKSTER_FRUIT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2f)
            .fast()
            .build();
}

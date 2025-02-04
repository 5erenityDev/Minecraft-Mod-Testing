package com.test.testmod.neighbor.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends Item {
    private int burntimer = 0;

    public FuelItem(Properties pProperties, int burntimer) {
        super(pProperties);
        this.burntimer = burntimer;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burntimer;
    }
}

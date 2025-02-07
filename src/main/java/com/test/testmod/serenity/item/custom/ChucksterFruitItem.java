package com.test.testmod.serenity.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChucksterFruitItem extends Item {
    public ChucksterFruitItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pLivingEntity.sendSystemMessage(Component.literal("I'm a Chuckster!"));

        pLivingEntity.setDeltaMovement(5, 5, 0);

        return this.isEdible() ? pLivingEntity.eat(pLevel, pStack) : pStack;
    }


}

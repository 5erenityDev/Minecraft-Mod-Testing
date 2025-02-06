package com.test.testmod.serenity.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SlimeMaceItem extends Item {

    public SlimeMaceItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        ItemStack stack = player.getMainHandItem();
        if (!player.level().isClientSide) {

            stack.hurtAndBreak(1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }

        Vec3 pMov = player.getDeltaMovement();
        if (pMov.y < (double)0.0F) {
            player.setDeltaMovement(pMov.x, -pMov.y * 2, pMov.z);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {


            stack.hurtAndBreak(1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
            // Example: Damage the item

            Vec3 pMov = player.getDeltaMovement();
            if (pMov.y < (double)0.0F) {
                player.setDeltaMovement(pMov.x, -pMov.y * 2, pMov.z);
            }

        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.testmod.slime_mace_item.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

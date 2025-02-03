package com.test.testmod.serenity.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

import java.util.List;

public class MaceItem extends Item {

    private int sword_damage;

    public MaceItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {
            player.sendSystemMessage(Component.literal(String.valueOf(player.fallDistance*6)));

            entity.hurt(entity.damageSources().wither(), player.fallDistance*6);

            // Example: Damage the item
            stack.hurtAndBreak(1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.testmod.mace_item.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

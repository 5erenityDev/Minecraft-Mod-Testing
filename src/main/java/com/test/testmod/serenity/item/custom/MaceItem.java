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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

import java.util.List;

public class MaceItem extends Item {

    public MaceItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        int damage = 5;
        if (player.fallDistance > 1.5){
            if (!player.level().isClientSide) {
                damage = determineDamage(player.fallDistance);
                entity.hurt(entity.damageSources().wither(), damage);
                stack.hurtAndBreak(1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                player.fallDistance = 0;
            }
            /*
            Vec3 pMov = player.getDeltaMovement();
            if (pMov.y < (double) 0.0F) {
                player.setDeltaMovement(pMov.x, -pMov.y * 2, pMov.z);
            }
             */
        }
        else
        {
            entity.hurt(entity.damageSources().wither(), damage);
        }
        return false;
    }

    public int determineDamage(float fallDistance) {
        int damage = 5;
        boolean initial_checks = true;
        int first_check = 3;
        int second_check = 5;
        for (fallDistance = fallDistance; fallDistance > 0; fallDistance--) {
            if (initial_checks) {
                if (first_check > 0) {
                    damage += 4;
                }
                else
                {
                    if (second_check > 0)
                    {
                        damage += 2;
                    }
                    else
                    {
                        initial_checks = false;
                    }
                }
            }
            else
            {
                damage += 1;
            }
        }
        return damage;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.testmod.mace_item.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

package com.test.testmod.serenity.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

import java.util.List;

public class TeleportStaffItem extends Item {
    public TeleportStaffItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide()){
            Vec3 eyePos = pPlayer.getEyePosition(1.0f);
            Vec3 lookVec = pPlayer.getLookAngle();
            Vec3 targetPos = eyePos.add(lookVec.scale(20)); // 20 blocks max distance

            ClipContext context = new ClipContext(eyePos, targetPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, null);
            HitResult rayTraceResult = pLevel.clip(context);

            Vec3 lookedAtPos = rayTraceResult.getLocation();

            if (pPlayer != null)
            {
                pPlayer.teleportTo(lookedAtPos.x, lookedAtPos.y, lookedAtPos.z);

            }
        }

        itemstack.hurtAndBreak(1, pPlayer, player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.testmod.telport_staff.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

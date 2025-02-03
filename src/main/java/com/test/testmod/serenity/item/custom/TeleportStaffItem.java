package com.test.testmod.serenity.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class TeleportStaffItem extends Item {
    public TeleportStaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            int blockPosX = positionClicked.getX();
            int blockPosY = positionClicked.getY();
            int blockPosZ = positionClicked.getZ();
            Player player = pContext.getPlayer();
            if (player != null)
            {
                if (player.getScoreboardName() == "Dev")
                {
                    player.sendSystemMessage(Component.literal("You are the chosen one"));
                }
                else
                {
                    player.sendSystemMessage(Component.literal(player.getScoreboardName()));
                }
                player.teleportTo(blockPosX, blockPosY+1, blockPosZ);
                player.sendSystemMessage(Component.literal("Teleporting to - X: " + positionClicked.getX() + " Y: " + positionClicked.getY() + " Z: "+ positionClicked.getZ()));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }
}

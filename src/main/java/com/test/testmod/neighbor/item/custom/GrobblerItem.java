package com.test.testmod.neighbor.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class GrobblerItem extends Item {
    //I believe this to be the constructor, correct me if im wrong
    public GrobblerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();
            if (player != null){
                player.sendSystemMessage(Component.literal(player.getEnderChestInventory().toString()));
            }
        }
        pContext.getItemInHand().hurtAndBreak(2, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

}

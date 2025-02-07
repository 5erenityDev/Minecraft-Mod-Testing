package com.test.testmod.neighbor.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.function.Predicate;

public class SlorperItem extends BowItem {

    public SlorperItem(Properties pProperties) {
        super(pProperties);
    }

   @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
       ItemStack itemstack = pPlayer.getItemInHand(pHand);
       if (pPlayer.getAbilities().instabuild || pPlayer.getFoodData().getFoodLevel() >= 4) {;
                pPlayer.startUsingItem(pHand);
                return InteractionResultHolder.fail(itemstack);
        }
       else {
           pPlayer.sendSystemMessage(Component.literal("not enough hunger"));
            return InteractionResultHolder.fail(itemstack);
        }
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
            ItemStack itemstack = player.getProjectile(pStack);
            int i = this.getUseDuration(pStack) - pTimeLeft;
            i = ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) {
                return;
            }

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double) f <= 0.9)) {
                    boolean flag1 = player.getAbilities().instabuild || player.getFoodData().getFoodLevel() >= 4;
                    if (!pLevel.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, itemstack, player);
                        abstractarrow = this.customArrow(abstractarrow);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 4.0F, 0F);
                        if (f == 1.0F) {
                            abstractarrow.setCritArrow(true);
                        }
                        pStack.hurtAndBreak(1, player, (p_289501_) -> p_289501_.broadcastBreakEvent(player.getUsedItemHand()));

                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        pLevel.addFreshEntity(abstractarrow);
                    }
                    pLevel.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.SLIME_ATTACK, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    player.causeFoodExhaustion(2);
                        }
                else{
                    pLevel.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.SLIME_DEATH, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                }
                    }
                }
            }
        }








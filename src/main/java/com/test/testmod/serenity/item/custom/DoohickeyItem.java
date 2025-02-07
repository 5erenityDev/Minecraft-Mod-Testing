package com.test.testmod.serenity.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import java.util.Random;
import javax.annotation.Nullable;

public class DoohickeyItem  extends BowItem {
    public DoohickeyItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Random random = new Random();
        int randomInt = random.nextInt(10);
        boolean exploded = false;
        if (randomInt == 6)
        {
            if (!pLevel.isClientSide) {
                pPlayer.setSecondsOnFire(5);
                exploded = true;
                explode(pPlayer, pLevel);
            }
            itemstack.hurtAndBreak(6, pPlayer, (playerEntity) -> playerEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        this.releaseUse(itemstack, pLevel, pPlayer, 1, exploded);
        return InteractionResultHolder.fail(itemstack);
    }

    public void releaseUse(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft, boolean exploded) {
        if (pEntityLiving instanceof Player player) {
            boolean flag = true;
            ItemStack itemstack = player.getProjectile(pStack);

            int velocity = 5000;

            if (itemstack.isEmpty()) {
                itemstack = new ItemStack(Items.ARROW);
            }

            float f = getPowerForTime(velocity);
            if (!((double)f < 0.1D)) {
                boolean flag1 = true;
                if (!pLevel.isClientSide) {
                    ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                    AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, itemstack, player);
                    abstractarrow = customArrow(abstractarrow);

                    abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                    abstractarrow.setCritArrow(true);
                    if (!pLevel.isClientSide) {
                        abstractarrow.isInvisible();
                        if (exploded)
                            abstractarrow.isOnFire();
                    }
                    abstractarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
                    pLevel.addFreshEntity(abstractarrow);
                }

                pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                if (!flag1 && !player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                    if (itemstack.isEmpty()) {
                        player.getInventory().removeItem(itemstack);
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    protected void explode(Player player, Level level) {
        float f = 4.0F;
        level.explode(player, player.getX(), player.getY(0.0625D), player.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
    }
}

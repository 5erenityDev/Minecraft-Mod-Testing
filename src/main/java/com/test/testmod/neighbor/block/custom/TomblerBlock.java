package com.test.testmod.neighbor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TomblerBlock extends Block {
    public TomblerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.ENDERMAN_STARE, SoundSource.BLOCKS, 1f, 1f);
        pLevel.playSound(pPlayer, pPos, SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.BLOCKS, 0.5f, 1f);
        if(!pLevel.isClientSide()) {
            pLevel.setRainLevel(1);
            pLevel.setThunderLevel(1);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pEntity.isSteppingCarefully()) {
            scream(pLevel, pPos, pEntity);
        }
    }

    private boolean isNight = false;

    public void scream(Level pLevel, BlockPos pPos, Entity pEntity) {
        //Grabbing server side and acting on server
        if(!pLevel.isClientSide){
            isNight = pLevel.isNight();
            if (!isNight){
                pLevel.playSound((Player) null, pPos.getX(), pPos.getY(), pPos.getZ(), SoundEvents.GHAST_WARN,
                        SoundSource.BLOCKS, 1f, 1f);
                pEntity.setSecondsOnFire(30000);
            }
            else {
                pLevel.playSound((Player) null, pPos.getX(), pPos.getY(), pPos.getZ(), SoundEvents.GHAST_HURT,
                        SoundSource.BLOCKS, 1f, 1f);
                pEntity.setDeltaMovement(0, 6, 0);
            }
        }
        //Acting only for client player
        else {
            if (!isNight) {
                pEntity.setSecondsOnFire(30000);
            } else {
                pEntity.setDeltaMovement(0, 6, 0);
            }
        }
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.testmod.tombler"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
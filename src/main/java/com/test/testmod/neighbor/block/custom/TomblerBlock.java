package com.test.testmod.neighbor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TomblerBlock extends Block {
    public TomblerBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.ENDERMAN_STARE, SoundSource.BLOCKS, 1f, 1f);
        pLevel.playSound(pPlayer, pPos, SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.BLOCKS, 0.5f, 1f);
        pLevel.setRainLevel(1);
        pLevel.setThunderLevel(1);

        return InteractionResult.SUCCESS;
    }
}
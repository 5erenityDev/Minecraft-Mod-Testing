package com.test.testmod.neighbor.block.custom;

import com.test.testmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;


import java.util.function.Supplier;

public class GiggleFlowerBlock extends FlowerBlock {

    public GiggleFlowerBlock(Supplier<MobEffect> effectSupplier, int p_53513_, Properties p_53514_) {
        super(effectSupplier, p_53513_, p_53514_);
    }


    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.random.nextInt(300) == 1 && pLevel.isLoaded(pPos)) {
            pLevel.playSound((Player) null, pPos.getX(), pPos.getY(), pPos.getZ(), ModSounds.GIGGLE_LAUGH.get(),
                    SoundSource.BLOCKS, 0.2f, 1.2f);
        }

    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

}

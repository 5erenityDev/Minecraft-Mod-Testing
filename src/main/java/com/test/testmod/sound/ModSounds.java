package com.test.testmod.sound;

import com.test.testmod.TestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TestMod.MODID);

    public static final RegistryObject<SoundEvent> GIGGLE_LAUGH = registerSoundEvents("giggle_laugh");

    public static final RegistryObject<SoundEvent> PROMISE_BLOCK_BREAK = registerSoundEvents("promise_block_break");
    public static final RegistryObject<SoundEvent> PROMISE_BLOCK_STEP = registerSoundEvents("promise_block_step");
    public static final RegistryObject<SoundEvent> PROMISE_BLOCK_FALL = registerSoundEvents("promise_block_fall");
    public static final RegistryObject<SoundEvent> PROMISE_BLOCK_PLACE = registerSoundEvents("promise_block_place");
    public static final RegistryObject<SoundEvent> PROMISE_BLOCK_HIT = registerSoundEvents("promise_block_hit");

    public static final RegistryObject<SoundEvent> KANPAI = registerSoundEvents("kanpai");

    public static final ForgeSoundType PROMISE_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.PROMISE_BLOCK_BREAK, ModSounds.PROMISE_BLOCK_STEP, ModSounds.PROMISE_BLOCK_PLACE, ModSounds.PROMISE_BLOCK_HIT,
            ModSounds.PROMISE_BLOCK_FALL);



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TestMod.MODID, name)));
    }


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }


}

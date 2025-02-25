package com.test.testmod.event;

import com.test.testmod.TestMod;
import com.test.testmod.entity.ModEntities;
import com.test.testmod.entity.custom.GigglerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GIGGLER.get(), GigglerEntity.createAttributes().build());
        event.put(ModEntities.NERVITE.get(), GigglerEntity.createAttributes().build());
    }



}

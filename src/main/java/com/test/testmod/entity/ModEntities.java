package com.test.testmod.entity;

import com.test.testmod.TestMod;
import com.test.testmod.entity.custom.GigglerEntity;
import com.test.testmod.entity.custom.NerviteEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TestMod.MODID);

    public static final RegistryObject<EntityType<GigglerEntity>> GIGGLER =
            ENTITY_TYPES.register("giggler",
                    () -> EntityType.Builder.of(GigglerEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build("giggler"));

    public static final RegistryObject<EntityType<NerviteEntity>> NERVITE =
            ENTITY_TYPES.register("nervite",
                    () -> EntityType.Builder.of(NerviteEntity::new, MobCategory.CREATURE)
                            .sized(1f, 1f)
                            .build("nervite"));


    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }
}

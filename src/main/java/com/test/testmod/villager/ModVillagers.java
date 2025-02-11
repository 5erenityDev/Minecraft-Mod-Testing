package com.test.testmod.villager;

import com.google.common.collect.ImmutableSet;
import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TestMod.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TestMod.MODID);

    public static final RegistryObject<PoiType> TOMBLER_POI = POI_TYPES.register("tombler_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.TOMBLER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> TOMBLER_MSTER =
            VILLAGER_PROFESSION.register("tomblerlord", () -> new VillagerProfession("tomblerlord",
                    holder -> holder.get() == TOMBLER_POI.get(), holder -> holder.get() ==
                    TOMBLER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }
}

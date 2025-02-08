package com.test.testmod.item;

import com.test.testmod.TestMod;
import com.test.testmod.neighbor.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SLORP = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2000, 3f,6, 30,
                    ModTags.Blocks.NEEDS_SLORP_TOOL, () -> Ingredient.of(ModItems.ANGRY_SLORP.get())),
            new ResourceLocation(TestMod.MODID, "angry_slorp" ), List.of(Tiers.NETHERITE), List.of());

    public static final Tier PROMISE = TierSortingRegistry.registerTier(
            new ForgeTier(6, 4000, 6f,20, 30,
                    ModTags.Blocks.NEEDS_PROMISE_TOOL, () -> Ingredient.of(ModItems.PURE_PROMISE.get())),
            new ResourceLocation(TestMod.MODID, "pure_promise" ), List.of(ModToolTiers.SLORP), List.of());


    public static final Tier PERMAFROST = TierSortingRegistry.registerTier(
            new ForgeTier(2, 250, 20.0F, 2.0F, 14,
                    ModTags.Blocks.NEEDS_PERMAFROST_TOOL, () -> Ingredient.of(ModItems.PERMAFROST.get())),
            new ResourceLocation(TestMod.MODID, "permafrost" ), List.of(Tiers.IRON), List.of());
}

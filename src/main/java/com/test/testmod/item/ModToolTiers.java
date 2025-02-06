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
}

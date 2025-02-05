package com.test.testmod.serenity.datagen;

import com.test.testmod.serenity.datagen.loot.Serenity_ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class Serenity_ModLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(Serenity_ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}

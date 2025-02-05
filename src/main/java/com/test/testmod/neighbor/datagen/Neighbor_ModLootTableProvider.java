package com.test.testmod.neighbor.datagen;

import com.test.testmod.neighbor.datagen.loot.Neighbor_ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class Neighbor_ModLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(Neighbor_ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}

package com.test.testmod.neighbor.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.serenity.datagen.*;
import com.test.testmod.serenity.datagen.loot.Serenity_ModBlockLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new Neighbor_ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), Neighbor_ModLootTableProvider.create(packOutput));


        generator.addProvider(event.includeClient(), new Neighbor_ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new Neighbor_ModItemModelProvider(packOutput, existingFileHelper));


        Neighbor_ModBlockTagGenerator neighbor_BlockTagGenerator = generator.addProvider(event.includeServer(),
                new Neighbor_ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new Neighbor_ModItemTagGenerator(packOutput, lookupProvider, neighbor_BlockTagGenerator.contentsGetter(), existingFileHelper));

    }
}
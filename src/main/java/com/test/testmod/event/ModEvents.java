package com.test.testmod.event;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.entity.ModEntities;
import com.test.testmod.entity.custom.GigglerEntity;
import com.test.testmod.item.ModItems;
import com.test.testmod.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TestMod.MODID)
public class ModEvents {




    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType()  == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.MASHEDPOTATOSQUASH_SEEDS.get(), 3),
                    13, 4, 0.03f));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.STOMPLER_SEEDS.get(), 2),
                    4, 10, 0.06f));
        }


        if(event.getType() == ModVillagers.TOMBLER_MSTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 64),
                    new ItemStack(ModBlocks.TOMBLER.get(), 1),
                    1, 42, 0.03f));

        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.NETHER_STAR, 2),
                new ItemStack(ModBlocks.GIGGLE.get(), 1),
                1, 30, 0.08f));

    }

}

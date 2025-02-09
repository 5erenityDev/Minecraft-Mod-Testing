package com.test.testmod.neighbor.item.custom;

import com.google.common.collect.ImmutableMap;
import com.test.testmod.item.ModArmorMaterials;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, MobEffectInstance[]> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance[]>())
                    .put(ModArmorMaterials.PROMISE, new MobEffectInstance[]{
                            new MobEffectInstance(MobEffects.ABSORPTION,400, 2),
                            new MobEffectInstance(MobEffects.REGENERATION, 400, 2)
                    }
            ).build();





    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public void inventoryTick (ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!(pLevel.isClientSide() && pEntity instanceof ServerPlayer)) {
            if (hasFullSuiOfArmorOn((Player) pEntity)) {
                evaluateArmorEffects((Player) pEntity);
            }
          }
        }


    private boolean hasFullSuiOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
        }


    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance[]> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance[] mapStatusEffects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                for (MobEffectInstance mapStatusEffect : mapStatusEffects){
                    addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);

                }
            }
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorstack : player.getInventory().armor) {
            if(!(armorstack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && chestplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }


    private void    addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
    }


}





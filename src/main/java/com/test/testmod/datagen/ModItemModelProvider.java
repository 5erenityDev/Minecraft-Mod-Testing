package com.test.testmod.datagen;

import com.test.testmod.TestMod;
import com.test.testmod.block.ModBlocks;
import com.test.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ///////////////////////////
        /////////NEIGHBOR//////////
        ///////////////////////////
        simpleItem(ModItems.ANGRY_SLORP);
        simpleItem(ModItems.SLOP);
        simpleItem(ModItems.GROBBLER);
        simpleItem(ModItems.THE_SLORBO);
        simpleItem(ModItems.WINGLE);
        simpleHandHeldItem(ModItems.SLORP_HOE);
        simpleHandHeldItem(ModItems.SLORP_PICKAXE);
        simpleHandHeldItem(ModItems.SLORP_SHOVEL);
        simpleHandHeldItem(ModItems.SLORP_SWORD);
        simpleHandHeldItem(ModItems.SLORP_AXE);


        evenSimplerBlockItem(ModBlocks.GARUGAMESH_STAIRS);
        evenSimplerBlockItem(ModBlocks.GARUGAMESH_SLAB);
        evenSimplerBlockItem(ModBlocks.GARUGAMESH_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.GARUGAMESH_FENCE_GATE);
        simpleBlockItem(ModBlocks.GARUGAMESH_DOOR);

        trimmedArmorItem(ModItems.SLORP_HELMET);
        trimmedArmorItem(ModItems.SLORP_CHESTPLATE);
        trimmedArmorItem(ModItems.SLORP_LEGGINGS);
        trimmedArmorItem(ModItems.SLORP_BOOTS);

        fenceInventory("garugamesh_fence", modLoc("block/garugamesh"));
        buttonInventory("garugamesh_button", modLoc("block/garugamesh"));
        wallInventory("garugamesh_walls", modLoc("block/garugamesh"));
        trapdoorBottom("garugamesh_trapdoor", modLoc("block/garugamesh_trapdoor"));


        ///////////////////////////
        /////////SERENITY//////////e
        ///////////////////////////
        simpleItem(ModItems.CHUCKSTER_FRUIT);
        simpleItem(ModItems.MACE);
        simpleItem(ModItems.TELEPORT_STAFF);
        simpleItem(ModItems.DOOHICKEY);
        simpleItem(ModItems.SLIME_MACE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(TestMod.MODID, "item/" + item.getId().getPath()));
    }


    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TestMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
        new ResourceLocation(TestMod.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleHandHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TestMod.MODID, "item/" + item.getId().getPath()));
    }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = TestMod.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

}

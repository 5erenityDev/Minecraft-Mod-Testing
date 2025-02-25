package com.test.testmod.entity.client;

import com.test.testmod.TestMod;
import com.test.testmod.entity.custom.GigglerEntity;
import com.test.testmod.entity.custom.NerviteEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoRenderer;

public class NerviteModel extends GeoModel<NerviteEntity> {


    @Override
    public ResourceLocation getModelResource(NerviteEntity animatable, @Nullable GeoRenderer<NerviteEntity> renderer) {
        return new ResourceLocation(TestMod.MODID, "geo/nervite.geo.json");
    }

    @Override
    public ResourceLocation getModelResource(NerviteEntity nerviteEntity) {
        return new ResourceLocation(TestMod.MODID, "geo/nervite.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NerviteEntity animatable, @Nullable GeoRenderer<NerviteEntity> renderer) {
        return new ResourceLocation(TestMod.MODID, "texture/entity/nervite.png");
    }

    @Override
    public ResourceLocation getTextureResource(NerviteEntity nerviteEntity) {
        return new ResourceLocation(TestMod.MODID, "texture/entity/nervite.png");
    }


    @Override
    public ResourceLocation getAnimationResource(NerviteEntity nerviteEntity) {
        return new ResourceLocation(TestMod.MODID, "animations/nervite.animation.json");
    }

}

package com.test.testmod.entity.client;

import com.test.testmod.TestMod;
import com.test.testmod.entity.custom.GigglerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoRenderer;

public class GiggleModel extends GeoModel<GigglerEntity> {


    @Override
    public ResourceLocation getModelResource(GigglerEntity animatable, @Nullable GeoRenderer<GigglerEntity> renderer) {
        return new ResourceLocation(TestMod.MODID, "geo/giggler.geo.json");
    }

    @Override
    public ResourceLocation getModelResource(GigglerEntity gigglerEntity) {
        return new ResourceLocation(TestMod.MODID, "geo/giggler.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GigglerEntity animatable, @Nullable GeoRenderer<GigglerEntity> renderer) {
        return new ResourceLocation(TestMod.MODID, "texture/entity/giggler.png");
    }

    @Override
    public ResourceLocation getTextureResource(GigglerEntity gigglerEntity) {
        return new ResourceLocation(TestMod.MODID, "texture/entity/giggler.png");
    }


    @Override
    public ResourceLocation getAnimationResource(GigglerEntity gigglerEntity) {
        return new ResourceLocation(TestMod.MODID, "animations/giggler.animation.json");
    }


    @Override
    public void setCustomAnimations(GigglerEntity animatable, long instanceId, AnimationState<GigglerEntity> animationState) {

        CoreGeoBone head = getAnimationProcessor().getBone("Body");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.headPitch() * Mth.DEG_TO_RAD);
        }


    }
}

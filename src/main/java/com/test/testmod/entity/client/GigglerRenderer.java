package com.test.testmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.test.testmod.TestMod;
import com.test.testmod.entity.custom.GigglerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GigglerRenderer extends GeoEntityRenderer<GigglerEntity> {
    public GigglerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GiggleModel());
    }


    @Override
    public ResourceLocation getTextureLocation(GigglerEntity animatable) {
        return new ResourceLocation(TestMod.MODID, "textures/entity/giggler.png");
    }

    @Override
    public void render(GigglerEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.2f, 0.2f, 0.2f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}

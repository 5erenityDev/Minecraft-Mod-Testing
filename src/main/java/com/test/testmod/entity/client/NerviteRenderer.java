package com.test.testmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.test.testmod.TestMod;
import com.test.testmod.entity.custom.GigglerEntity;
import com.test.testmod.entity.custom.NerviteEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NerviteRenderer extends GeoEntityRenderer<NerviteEntity> {
    public NerviteRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NerviteModel());
    }


    @Override
    public ResourceLocation getTextureLocation(NerviteEntity animatable) {
        return new ResourceLocation(TestMod.MODID, "textures/entity/nervite.png");
    }

    @Override
    public void render(NerviteEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.7f, 0.7f, 0.7f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}

package com.test.testmod.entity.custom;


import com.test.testmod.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class NerviteEntity extends Animal implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public NerviteEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 15D)
                .add(Attributes.ATTACK_SPEED, 0.5f)
                .add(Attributes.FOLLOW_RANGE, 1f)
                .add(Attributes.MOVEMENT_SPEED, 0.6f)
                .add(Attributes.ATTACK_DAMAGE, 5f)
                .add(Attributes.ATTACK_KNOCKBACK, 2f);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 10f, 1.3f, 1.3f));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Monster.class, 10f, 1.3f, 1.3f));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 11.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));






    }




    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.NERVITE.get().create(serverLevel);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 5, this::predicate));
    }


    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> gigglerEntityAnimationState) {
        if (gigglerEntityAnimationState.isMoving()){
            gigglerEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.nervite.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        gigglerEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.nervite.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}

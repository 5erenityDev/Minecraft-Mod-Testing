package com.test.testmod.entity.custom;


import com.test.testmod.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.example.entity.BatEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class NerviteEntity extends Monster implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public static final RawAnimation ATTACK = RawAnimation.begin().thenPlay("animation.nervite.attack");

    public NerviteEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
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
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.1f, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Bat.class, true));

    }




    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllerRegistrar.add(new AnimationController<>(this, "attackController", 1, this::attackPredicate));
    }


    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> nerviteEntityAnimationState) {
        if (nerviteEntityAnimationState.isMoving()){
            nerviteEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.nervite.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        nerviteEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.nervite.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState<NerviteEntity> nerviteEntityAnimationState) {
        if (this.swinging) {
            return nerviteEntityAnimationState.setAndContinue(ATTACK);
        } else {
            nerviteEntityAnimationState.getController().forceAnimationReset();
            return PlayState.STOP;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}

package com.jacob.cobtech.entities;

import com.jacob.cobtech.init.ModEntityTypes;
import com.jacob.cobtech.init.SoundInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class CorruptedBrute extends MonsterEntity implements IAnimatedEntity {

	private EntityAnimationManager manager = new EntityAnimationManager();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 20,
			this::animationPredicate);

	public CorruptedBrute(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
	}

	public CorruptedBrute createChild(AgeableEntity ageable) {
		CorruptedBrute entity = new CorruptedBrute(ModEntityTypes.CORRUPTED_BRUTE.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return entity;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Robot.class, true));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(16.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
	}

	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
		super.onStruckByLightning(lightningBolt);
		this.setNoAI(true);
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}
	
	private <E extends CorruptedBrute> boolean animationPredicate(AnimationTestEvent<E> event) {
		if(event.isWalking()) {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.cobtech16.walk"));
			return true;
		} else {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.cobtech16.idle"));
			return true;
		}
	}
	
	private void registerAnimationControllers() {
		manager.addAnimationController(controller);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.CORRUPTED_BRUTE_AMBIENT.get();
	}
	
	protected SoundEvent getStepSound() {
	      return SoundInit.BRUTE_MOVE.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.CORRUPTED_BRUTE_HURT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.CORRUPTED_BRUTE_DEATH.get();
	}
	
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
	    this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}
}
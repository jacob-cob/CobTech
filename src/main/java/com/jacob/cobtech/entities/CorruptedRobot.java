package com.jacob.cobtech.entities;

import com.jacob.cobtech.init.ModEntityTypes;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CorruptedRobot extends MonsterEntity{
	
	public CorruptedRobot(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public CorruptedRobot createChild(AgeableEntity ageable) {
		CorruptedRobot entity = new CorruptedRobot(ModEntityTypes.CORRUPTED_ROBOT.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.50D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(0.1D);
	}
	
	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
		super.onStruckByLightning(lightningBolt);
		this.setNoAI(true);
	}
}
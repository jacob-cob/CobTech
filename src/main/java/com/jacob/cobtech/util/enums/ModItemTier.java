package com.jacob.cobtech.util.enums;

import java.util.function.Supplier;

import com.jacob.cobtech.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ModItemTier implements IItemTier 
{
	CYBER(6, 3725, 17.0F, 5.0F, 100, () -> {
		return Ingredient.fromItems(ItemInit.cyber_tech);
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;
	
	private ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
	      this.harvestLevel = harvestLevelIn;
	      this.maxUses = maxUsesIn;
	      this.efficiency = efficiencyIn;
	      this.attackDamage = attackDamageIn;
	      this.enchantability = enchantabilityIn;
	      this.repairMaterial = new LazyValue<>(repairMaterialIn);
	   }
	
	public int getMaxUses() {
	   return this.maxUses;
	}

	public float getEfficiency() {
	   return this.efficiency;
	}

	public float getAttackDamage() {
	   return this.attackDamage;
	}

	public int getHarvestLevel() {
	   return this.harvestLevel;
	}

	public int getEnchantability() {
	   return this.enchantability;
	}

	public Ingredient getRepairMaterial() {
	   return this.repairMaterial.getValue();
	}
}

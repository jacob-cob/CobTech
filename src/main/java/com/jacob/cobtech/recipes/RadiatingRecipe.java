package com.jacob.cobtech.recipes;

import com.jacob.cobtech.init.RecipeSerializerInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class RadiatingRecipe implements IRadiatingRecipe{

	private final ResourceLocation id;
	private Ingredient input;
	private ItemStack output;
	
	public RadiatingRecipe(ResourceLocation id, ItemStack output, Ingredient input) {
		this.id = id;
		this.output = output;
		this.input = input;
	}
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn) {
		if(this.input.test(inv.getStackInSlot(0))) {
			return true;
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(RecipeWrapper inv) {
		return this.output;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return RecipeSerializerInit.RADIATING_SERIALIZER.get();
	}

	@Override
	public Ingredient getInput() {
		return this.input;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		return NonNullList.from(null, this.input);
	}

}

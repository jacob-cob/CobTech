package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.recipes.IRadiatingRecipe;
import com.jacob.cobtech.recipes.RadiatingRecipe;
import com.jacob.cobtech.recipes.RadiatingRecipeSerializer;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {

	public static final IRecipeSerializer<RadiatingRecipe> RADIATING_RECIPE_SERIALIZER = new RadiatingRecipeSerializer();
	public static final IRecipeType<IRadiatingRecipe> RADIATING_TYPE = registerType(IRadiatingRecipe.RECIPE_TYPE_ID);
	
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(ForgeRegistries.RECIPE_SERIALIZERS, CobTech.MOD_ID);
	
	public static final RegistryObject<IRecipeSerializer<?>> RADIATING_SERIALIZER = RECIPE_SERIALIZERS.register("radiating", () -> RADIATING_RECIPE_SERIALIZER);

	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
		@Override
		public String toString() {
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
		return (T)Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}
}

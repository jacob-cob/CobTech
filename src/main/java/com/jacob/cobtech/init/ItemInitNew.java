package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.CobTech.CobTechGroup;
import com.jacob.cobtech.objects.items.ModSpawnEggItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew 
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CobTech.MOD_ID);
	
	public static final RegistryObject<Item> CARDBOARD = ITEMS.register("cardboard",
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	public static final RegistryObject<Item> PROCESSOR_2K = ITEMS.register("processor_2k",
			() -> new Item(new Item.Properties().group(CobTechGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> ROBOT_SPAWN_EGG = ITEMS.register("robot_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.ROBOT, 0xFFFFFF , 0x91FFFF ,new Item.Properties().group(CobTechGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> CORRUPTED_ROBOT_SPAWN_EGG = ITEMS.register("corrupted_robot_spawn_egg",
			() -> new ModSpawnEggItem(ModEntityTypes.CORRUPTED_ROBOT, 0xFFFFFF , 0x91FFFF ,new Item.Properties().group(CobTechGroup.instance)));
}

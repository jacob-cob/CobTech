package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.CobTech.CobTechGroup;
import com.jacob.cobtech.objects.items.SnowLauncherItem;
import com.jacob.cobtech.objects.items.SuperFuelItem;
import com.jacob.cobtech.util.enums.ModArmorMaterials;
import com.jacob.cobtech.util.enums.ModItemTier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CobTech.MOD_ID, bus = Bus.MOD)
@ObjectHolder(CobTech.MOD_ID)
public class ItemInit 
{
	public static final Item cyber_scrap = null;
	public static final Item reactor_rod = null;
	public static final Item cyber_tech = null;
	public static final Item processor_1k = null;
	public static final Item hologram_projector = null;
	public static final Item nutrient_bar = null;
	public static final Item cobite_ingot = null;
	public static final Item hardened_cobite_ingot = null;
	public static final Item cobite_stick = null;
	public static final Item cobite_plasma = null;
	public static final Item plastic = null;
	public static final Item organic_matter = null;
	
	//tools
	public static final Item cyber_sword = null;
	public static final Item cyber_pickaxe = null;
	public static final Item cyber_shovel = null;
	public static final Item cyber_axe = null;
	public static final Item cyber_hoe = null;
	public static final Item snowball_launcher = null;
	
	//armour
	public static final Item cyber_helmet = null;
	public static final Item cyber_chestplate = null;
	public static final Item cyber_boots = null;
	public static final Item cyber_leggings = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("cobite_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("cobite_plasma"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("cobite_stick"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("hardened_cobite_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(CobTechGroup.instance)).setRegistryName("cyber_scrap"));
		event.getRegistry().register(new Item(new Item.Properties().group(CobTechGroup.instance)).setRegistryName("cyber_tech"));
		event.getRegistry().register(new Item(new Item.Properties().group(CobTechGroup.instance)).setRegistryName("processor_1k"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("plastic"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("organic_matter"));
		event.getRegistry().register(new Item(new Item.Properties().group(CobTechGroup.instance)).setRegistryName("hologram_projector"));
		event.getRegistry().register(new SuperFuelItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("reactor_rod"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(7).saturation(1.2f).fastToEat().build())).setRegistryName("nutrient_bar"));
		
		//tools
		event.getRegistry().register(new SwordItem(ModItemTier.CYBER, 12, 10.0f, (new Item.Properties()).group(CobTechGroup.instance)).setRegistryName("cyber_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.CYBER, 7, 5.0f, (new Item.Properties()).group(CobTechGroup.instance)).setRegistryName("cyber_pickaxe"));
		event.getRegistry().register(new AxeItem(ModItemTier.CYBER, 16, 1.0f, (new Item.Properties()).group(CobTechGroup.instance)).setRegistryName("cyber_axe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.CYBER, 9, 5.0f, (new Item.Properties()).group(CobTechGroup.instance)).setRegistryName("cyber_shovel"));
		event.getRegistry().register(new HoeItem(ModItemTier.CYBER, 5, (new Item.Properties()).group(CobTechGroup.instance)).setRegistryName("cyber_hoe"));
		event.getRegistry().register(new SnowLauncherItem(new Item.Properties().maxStackSize(1).group(CobTechGroup.instance)).setRegistryName("snowball_launcher"));
		
		//armour
		event.getRegistry().register(new ArmorItem(ModArmorMaterials.CYBER, EquipmentSlotType.HEAD, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("cyber_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterials.CYBER, EquipmentSlotType.CHEST, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("cyber_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterials.CYBER, EquipmentSlotType.LEGS, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("cyber_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterials.CYBER, EquipmentSlotType.FEET, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("cyber_boots"));
	}
}
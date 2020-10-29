package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.CobTech.CobTechGroup;
import com.jacob.cobtech.objects.blocks.ChairBlock;
import com.jacob.cobtech.objects.blocks.FreezeBlock;
import com.jacob.cobtech.objects.blocks.QuarryBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(CobTech.MOD_ID)
@Mod.EventBusSubscriber(modid = CobTech.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block holographic_stone = null;
	public static final Block iron_plate = null;
	public static final Block cobite_ore = null;
	public static final Block speed_road = null;
	public static final Block slow_road = null;
	public static final Block freeze_block = null;
	public static final Block quarry = null;
	public static final Block chair = null;
	
	@SubscribeEvent
	public static void RegisterBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
				.hardnessAndResistance(0.0f).sound(SoundType.GLASS)).setRegistryName("holographic_stone"));
		
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(10.0f, 100.0f)
				.sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("iron_plate"));
		
		event.getRegistry().register(new QuarryBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(6.0f, 100.0f)
				.sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName("quarry"));
		
		event.getRegistry().register(new ChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 1.5f)
				.sound(SoundType.WOOD).notSolid()).setRegistryName("chair"));
		
		event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(30.0f, 1200.0f)
				.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(5)).setRegistryName("cobite_ore"));
		
		event.getRegistry().register(new Block(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f)
				.speedFactor(1.5f).sound(SoundType.METAL)).setRegistryName("speed_road"));
		
		event.getRegistry().register(new Block(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f)
				.speedFactor(0.01f).jumpFactor(1.0f).sound(SoundType.METAL)).setRegistryName("slow_road"));
		
		event.getRegistry().register(new FreezeBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(-1.0F, 3600000.0F)
				.speedFactor(0.01f).jumpFactor(0.0f).doesNotBlockMovement().sound(SoundType.GLASS).notSolid()).setRegistryName("freeze_block"));
	}
	
	@SubscribeEvent
	public static void RegisterBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(holographic_stone, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("holographic_stone"));
		event.getRegistry().register(new BlockItem(chair, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName("chair"));
		event.getRegistry().register(new BlockItem(speed_road, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("speed_road"));
		event.getRegistry().register(new BlockItem(slow_road, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("slow_road"));
		event.getRegistry().register(new BlockItem(iron_plate, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("iron_plate"));
		event.getRegistry().register(new BlockItem(freeze_block, new Item.Properties()).setRegistryName("freeze_block"));
		event.getRegistry().register(new BlockItem(quarry, new Item.Properties().group(CobTechGroup.instance)).setRegistryName("quarry"));
		event.getRegistry().register(new BlockItem(cobite_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("cobite_ore"));
	}
}
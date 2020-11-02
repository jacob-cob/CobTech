package com.jacob.cobtech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jacob.cobtech.init.BlockInitNew;
import com.jacob.cobtech.init.ItemInit;
import com.jacob.cobtech.init.ItemInitNew;
import com.jacob.cobtech.init.ModContainerTypes;
import com.jacob.cobtech.init.ModEntityTypes;
import com.jacob.cobtech.init.ModTileEntityTypes;
import com.jacob.cobtech.init.RecipeSerializerInit;
import com.jacob.cobtech.init.SoundInit;
import com.jacob.cobtech.objects.items.ModSpawnEggItem;
import com.jacob.cobtech.world.gen.CobOreGen;

import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("cobtech16")
@Mod.EventBusSubscriber(modid = CobTech.MOD_ID, bus = Bus.MOD)
public class CobTech 
{

	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "cobtech16";
	public static CobTech instance;

	public CobTech() 
	{
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);
		
		SoundInit.SOUNDS.register(modEventBus);
		ItemInitNew.ITEMS.register(modEventBus);
		RecipeSerializerInit.RECIPE_SERIALIZERS.register(modEventBus);
		BlockInitNew.BLOCKS.register(modEventBus);
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) 
	{
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(CobTechGroup.instance);
			final BlockItem blockitem = new BlockItem(block, properties);
			blockitem.setRegistryName(block.getRegistryName());
			registry.register(blockitem);
		});
		
		LOGGER.debug("Registered BlockItems lmao");
	}
	
	private void setup(final FMLCommonSetupEvent event) 
	{
		
	}

	private void doClientStuff(final FMLClientSetupEvent event) 
	{
		
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) 
	{
		
	}
	
	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event)
	{
		CobOreGen.generateOre();
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initSpawnEggs();	
	}
	
	public static class CobTechGroup extends ItemGroup
	{
		public static final CobTechGroup instance = new CobTechGroup(ItemGroup.GROUPS.length, "cobtechtab");
		private CobTechGroup(int index, String label)
		{
			super(index, label);
		}
		
		@Override
		public ItemStack createIcon() 
		{
			return new ItemStack(ItemInit.cyber_tech);
		}
	}
}

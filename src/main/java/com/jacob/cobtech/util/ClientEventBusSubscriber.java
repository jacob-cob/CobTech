package com.jacob.cobtech.util;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.client.entity.render.CorruptedBruteRender;
import com.jacob.cobtech.client.entity.render.CorruptedRobotRender;
import com.jacob.cobtech.client.entity.render.RobotRender;
import com.jacob.cobtech.client.gui.CardboardBoxScreen;
import com.jacob.cobtech.client.gui.CobiteCrateScreen;
import com.jacob.cobtech.client.gui.RadiatorScreen;
import com.jacob.cobtech.init.ModContainerTypes;
import com.jacob.cobtech.init.ModEntityTypes;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CobTech.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.CARDBOARD_BOX.get(), CardboardBoxScreen::new);
		ScreenManager.registerFactory(ModContainerTypes.COBITE_CRATE.get(), CobiteCrateScreen::new);
		ScreenManager.registerFactory(ModContainerTypes.RADIATOR.get(), RadiatorScreen::new);
		
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CORRUPTED_ROBOT.get(), CorruptedRobotRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CORRUPTED_BRUTE.get(), CorruptedBruteRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROBOT.get(), RobotRender::new);
	}
}

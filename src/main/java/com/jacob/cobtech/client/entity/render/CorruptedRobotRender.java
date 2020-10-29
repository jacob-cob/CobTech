package com.jacob.cobtech.client.entity.render;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.client.entity.model.CorruptedRobotModel;
import com.jacob.cobtech.entities.CorruptedRobot;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CorruptedRobotRender extends MobRenderer<CorruptedRobot, CorruptedRobotModel<CorruptedRobot>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(CobTech.MOD_ID,
			"textures/entity/corrupted_robot.png");

	public CorruptedRobotRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CorruptedRobotModel<CorruptedRobot>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(CorruptedRobot entity) {
		return TEXTURE;
	}
}

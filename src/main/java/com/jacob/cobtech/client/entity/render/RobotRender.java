package com.jacob.cobtech.client.entity.render;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.client.entity.model.RobotModel;
import com.jacob.cobtech.entities.Robot;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RobotRender extends MobRenderer<Robot, RobotModel<Robot>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(CobTech.MOD_ID,
			"textures/entity/robot.png");

	public RobotRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RobotModel<Robot>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(Robot entity) {
		return TEXTURE;
	}
}

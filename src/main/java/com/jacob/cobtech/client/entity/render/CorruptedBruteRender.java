package com.jacob.cobtech.client.entity.render;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.client.entity.model.CorruptedBruteModel;
import com.jacob.cobtech.entities.CorruptedBrute;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CorruptedBruteRender extends MobRenderer<CorruptedBrute, CorruptedBruteModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(CobTech.MOD_ID,
			"textures/entity/corrupted_brute.png");

	public CorruptedBruteRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CorruptedBruteModel(), 3.0f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(CorruptedBrute entity) {
		return TEXTURE;
	}
}

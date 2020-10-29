package com.jacob.cobtech.client.entity.model;

import com.jacob.cobtech.entities.CorruptedRobot;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CorruptedRobotModel<T extends CorruptedRobot> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Wheels;
	private final ModelRenderer RightWheel;
	private final ModelRenderer LeftWheel;
	private final ModelRenderer Base;
	private final ModelRenderer Parts;
	private final ModelRenderer Processor;
	private final ModelRenderer Controller;

	public CorruptedRobotModel() {
		textureWidth = 16;
		textureHeight = 16;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Wheels = new ModelRenderer(this);
		Wheels.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Wheels);
		

		RightWheel = new ModelRenderer(this);
		RightWheel.setRotationPoint(0.0F, 0.0F, 0.0F);
		Wheels.addChild(RightWheel);
		RightWheel.setTextureOffset(14, 19).addBox(5.0F, -3.0F, -6.0F, 1.0F, 3.0F, 12.0F, 0.0F, false);

		LeftWheel = new ModelRenderer(this);
		LeftWheel.setRotationPoint(0.0F, 0.0F, 0.0F);
		Wheels.addChild(LeftWheel);
		LeftWheel.setTextureOffset(0, 16).addBox(-6.0F, -3.0F, -6.0F, 1.0F, 3.0F, 12.0F, 0.0F, false);

		Base = new ModelRenderer(this);
		Base.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Base);
		Base.setTextureOffset(0, 0).addBox(-5.0F, -4.0F, -7.0F, 10.0F, 2.0F, 14.0F, 0.0F, false);

		Parts = new ModelRenderer(this);
		Parts.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Parts);
		

		Processor = new ModelRenderer(this);
		Processor.setRotationPoint(0.0F, 0.0F, 0.0F);
		Parts.addChild(Processor);
		Processor.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, 0.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		Controller = new ModelRenderer(this);
		Controller.setRotationPoint(0.0F, 0.0F, 0.0F);
		Parts.addChild(Controller);
		Controller.setTextureOffset(28, 16).addBox(0.0F, -5.0F, -5.0F, 3.0F, 1.0F, 9.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
	public ModelRenderer getBase() {
		return Base;
	}
	
	public ModelRenderer getBody() {
		return Body;
	}
	
	public ModelRenderer getController() {
		return Controller;
	}
	
	public ModelRenderer getLeftWheel() {
		return LeftWheel;
	}
	
	public ModelRenderer getParts() {
		return Parts;
	}
	
	public ModelRenderer getProcessor() {
		return Processor;
	}
	
	public ModelRenderer getRightWheel() {
		return RightWheel;
	}
	
	public ModelRenderer getWheels() {
		return Wheels;
	}
}
package com.jacob.cobtech.client.entity.model;

import com.jacob.cobtech.entities.CorruptedBrute;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class CorruptedBruteModel extends AnimatedEntityModel<CorruptedBrute> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Legs;
	private final AnimatedModelRenderer LeftLeg;
	private final AnimatedModelRenderer LeftFoot;
	private final AnimatedModelRenderer LeftQuad;
	private final AnimatedModelRenderer RightLeg;
	private final AnimatedModelRenderer RightFoot;
	private final AnimatedModelRenderer RightQuad;
	private final AnimatedModelRenderer Base;

    public CorruptedBruteModel()
    {
        textureWidth = 256;
    textureHeight = 256;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Legs = new AnimatedModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		
		Legs.setModelRendererName("Legs");
		this.registerModelRenderer(Legs);

		LeftLeg = new AnimatedModelRenderer(this);
		LeftLeg.setRotationPoint(26.0F, -33.0F, 0.0F);
		Legs.addChild(LeftLeg);
		
		LeftLeg.setModelRendererName("LeftLeg");
		this.registerModelRenderer(LeftLeg);

		LeftFoot = new AnimatedModelRenderer(this);
		LeftFoot.setRotationPoint(8.5F, 12.0F, -4.625F);
		LeftLeg.addChild(LeftFoot);
		LeftFoot.setTextureOffset(60, 60).addBox(-9.5F, 19.0F, -16.375F, 19.0F, 2.0F, 22.0F, 0.0F, false);
		LeftFoot.setTextureOffset(125, 15).addBox(-9.5F, 20.0F, 5.625F, 18.0F, 1.0F, 6.0F, 0.0F, false);
		LeftFoot.setTextureOffset(120, 49).addBox(-7.5F, 17.0F, -7.375F, 15.0F, 2.0F, 12.0F, 0.0F, false);
		LeftFoot.setTextureOffset(66, 119).addBox(-8.5F, 2.0F, -9.375F, 18.0F, 15.0F, 15.0F, 0.0F, false);
		LeftFoot.setModelRendererName("LeftFoot");
		this.registerModelRenderer(LeftFoot);

		LeftQuad = new AnimatedModelRenderer(this);
		LeftQuad.setRotationPoint(-0.75F, -2.75F, 2.75F);
		LeftLeg.addChild(LeftQuad);
		setRotationAngle(LeftQuad, -0.5236F, 0.0F, 0.0F);
		LeftQuad.setTextureOffset(125, 0).addBox(1.75F, 14.3744F, -2.3481F, 15.0F, 7.0F, 8.0F, 0.0F, false);
		LeftQuad.setTextureOffset(70, 84).addBox(0.75F, -3.6256F, -8.3481F, 20.0F, 20.0F, 15.0F, 0.0F, false);
		LeftQuad.setModelRendererName("LeftQuad");
		this.registerModelRenderer(LeftQuad);

		RightLeg = new AnimatedModelRenderer(this);
		RightLeg.setRotationPoint(-23.0F, -34.0F, 2.0F);
		Legs.addChild(RightLeg);
		
		RightLeg.setModelRendererName("RightLeg");
		this.registerModelRenderer(RightLeg);

		RightFoot = new AnimatedModelRenderer(this);
		RightFoot.setRotationPoint(-11.5F, 16.0F, -6.625F);
		RightLeg.addChild(RightFoot);
		RightFoot.setTextureOffset(0, 49).addBox(-9.5F, 16.0F, -16.375F, 19.0F, 2.0F, 22.0F, 0.0F, false);
		RightFoot.setTextureOffset(60, 49).addBox(-9.5F, 17.0F, 5.625F, 18.0F, 1.0F, 6.0F, 0.0F, false);
		RightFoot.setTextureOffset(117, 119).addBox(-7.5F, 14.0F, -7.375F, 15.0F, 2.0F, 12.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 108).addBox(-8.5F, -1.0F, -9.375F, 18.0F, 15.0F, 15.0F, 0.0F, false);
		RightFoot.setModelRendererName("RightFoot");
		this.registerModelRenderer(RightFoot);

		RightQuad = new AnimatedModelRenderer(this);
		RightQuad.setRotationPoint(0.25F, -2.75F, -0.25F);
		RightLeg.addChild(RightQuad);
		setRotationAngle(RightQuad, -0.5236F, 0.0F, 0.0F);
		RightQuad.setTextureOffset(120, 63).addBox(-19.25F, 14.7404F, -0.982F, 15.0F, 7.0F, 8.0F, 0.0F, false);
		RightQuad.setTextureOffset(0, 73).addBox(-20.25F, -3.2596F, -6.982F, 20.0F, 20.0F, 15.0F, 0.0F, false);
		RightQuad.setModelRendererName("RightQuad");
		this.registerModelRenderer(RightQuad);

		Base = new AnimatedModelRenderer(this);
		Base.setRotationPoint(0.5F, -38.75F, -4.5F);
		Body.addChild(Base);
		Base.setTextureOffset(0, 0).addBox(-23.5F, -11.25F, -6.5F, 49.0F, 22.0F, 27.0F, 0.0F, false);
		Base.setTextureOffset(125, 84).addBox(-7.5F, -5.25F, -7.5F, 13.0F, 11.0F, 1.0F, 0.0F, false);
		Base.setModelRendererName("Base");
		this.registerModelRenderer(Base);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("cobtech16", "animations/corrupted_brute.json");
    }
}
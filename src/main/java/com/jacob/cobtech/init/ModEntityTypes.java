package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.entities.CorruptedRobot;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			CobTech.MOD_ID);

	public static final RegistryObject<EntityType<CorruptedRobot>> CORRUPTED_ROBOT = ENTITY_TYPES
			.register("corrupted_robot",
					() -> EntityType.Builder.<CorruptedRobot>create(CorruptedRobot::new, EntityClassification.MONSTER)
							.size(0.9f, 0.5f)
							.build(new ResourceLocation(CobTech.MOD_ID, "corrupted_robot").toString()));
}
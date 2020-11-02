package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			CobTech.MOD_ID);

	public static final RegistryObject<SoundEvent> ROBOT_AMBIENT = SOUNDS.register("entity.robot.ambient",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.robot.ambient")));
	public static final RegistryObject<SoundEvent> CORRUPTED_ROBOT_AMBIENT = SOUNDS.register("entity.corrupted_robot.ambient",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.corrupted_robot.ambient")));
	public static final RegistryObject<SoundEvent> ROBOT_MOVE = SOUNDS.register("entity.robot.move",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.robot.move")));
	public static final RegistryObject<SoundEvent> CORRUPTED_ROBOT_HURT = SOUNDS.register("entity.corrupted_robot.hurt",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.corrupted_robot.hurt")));
	public static final RegistryObject<SoundEvent> BRUTE_MOVE = SOUNDS.register("entity.brute.move",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.brute.move")));
	public static final RegistryObject<SoundEvent> CORRUPTED_BRUTE_AMBIENT = SOUNDS.register("entity.corrupted_brute.ambient",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.corrupted_brute.ambient")));
	public static final RegistryObject<SoundEvent> CORRUPTED_BRUTE_HURT = SOUNDS.register("entity.corrupted_brute.hurt",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.corrupted_brute.hurt")));
	public static final RegistryObject<SoundEvent> CORRUPTED_BRUTE_DEATH = SOUNDS.register("entity.corrupted_brute.death",
			() -> new SoundEvent(new ResourceLocation(CobTech.MOD_ID, "entity.corrupted_brute.death")));
}

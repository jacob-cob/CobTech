package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.container.CardboardBoxContainer;
import com.jacob.cobtech.container.CobiteCrateContainer;
import com.jacob.cobtech.container.RadiatorContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
			ForgeRegistries.CONTAINERS, CobTech.MOD_ID);

	public static final RegistryObject<ContainerType<CardboardBoxContainer>> CARDBOARD_BOX = CONTAINER_TYPES
			.register("cardboard_box", () -> IForgeContainerType.create(CardboardBoxContainer::new));
	
	public static final RegistryObject<ContainerType<CobiteCrateContainer>> COBITE_CRATE = CONTAINER_TYPES
			.register("cobite_crate", () -> IForgeContainerType.create(CobiteCrateContainer::new));
	
	public static final RegistryObject<ContainerType<RadiatorContainer>> RADIATOR = CONTAINER_TYPES
			.register("radiator", () -> IForgeContainerType.create(RadiatorContainer::new));
}

package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.container.CardboardBoxContainer;

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
}

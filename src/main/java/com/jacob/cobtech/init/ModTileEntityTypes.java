package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.tileentity.CardboardBoxTileEntity;
import com.jacob.cobtech.tileentity.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, CobTech.MOD_ID);

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry",
			() -> TileEntityType.Builder.create(QuarryTileEntity::new, BlockInit.quarry).build(null));

	public static final RegistryObject<TileEntityType<CardboardBoxTileEntity>> CARDBOARD_BOX = TILE_ENTITY_TYPES
			.register("cardboard_box", () -> TileEntityType.Builder
					.create(CardboardBoxTileEntity::new, BlockInitNew.CARDBOARD_BOX.get()).build(null));
}

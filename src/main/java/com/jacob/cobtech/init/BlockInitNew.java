package com.jacob.cobtech.init;

import com.jacob.cobtech.CobTech;
import com.jacob.cobtech.objects.blocks.CardboardBoxBlock;
import com.jacob.cobtech.objects.blocks.CobiteCrateBlock;
import com.jacob.cobtech.objects.blocks.ModIronButton;
import com.jacob.cobtech.objects.blocks.ModPressurePlate;
import com.jacob.cobtech.objects.blocks.RadiatorBlock;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, CobTech.MOD_ID);

	public static final RegistryObject<Block> TESTING_BLOCK = BLOCKS.register("testing_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 1200.0f)
					.sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> TESTING_STAIRS = BLOCKS.register("testing_stairs",
			() -> new StairsBlock(() -> BlockInitNew.TESTING_BLOCK.get().getDefaultState(),
					Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 1200.0f).sound(SoundType.METAL)
							.harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> TESTING_BUTTON = BLOCKS.register("testing_button",
			() -> new ModIronButton(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 1200.0f)
					.sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> TESTING_PRESSURE_PLATE = BLOCKS.register("testing_pressure_plate",
			() -> new ModPressurePlate(Sensitivity.EVERYTHING, Block.Properties.create(Material.IRON)
					.hardnessAndResistance(4.0f, 1200.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> CARDBOARD_BOX = BLOCKS.register("cardboard_box",
			() -> new CardboardBoxBlock(
					Block.Properties.create(Material.WOOL).hardnessAndResistance(0.2f, 20.0f).sound(SoundType.CLOTH)));

	public static final RegistryObject<Block> COBITE_CRATE = BLOCKS.register("cobite_crate", () -> new CobiteCrateBlock(
			Block.Properties.create(Material.IRON).hardnessAndResistance(50.0f, 1200.0f).sound(SoundType.ANVIL)));

	public static final RegistryObject<Block> RADIATOR = BLOCKS.register("radiator",
			() -> new RadiatorBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(50.0f, 1200.0f)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
}

package com.jacob.cobtech.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class ChairBlock extends Block {

	public static final DirectionProperty IFACING = HorizontalBlock.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(3, 0, 3, 4, 5, 4), Block.makeCuboidShape(12, 0, 3, 13, 5, 4),
					Block.makeCuboidShape(3, 0, 12, 4, 5, 13), Block.makeCuboidShape(12, 0, 12, 13, 5, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(3, 6, 3, 4, 9, 13),
					Block.makeCuboidShape(12, 6, 3, 13, 9, 13), Block.makeCuboidShape(3, 6, 12, 13, 15, 13))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream
			.of(Block.makeCuboidShape(3, 0, 12, 4, 5, 13), Block.makeCuboidShape(3, 0, 3, 4, 5, 4),
					Block.makeCuboidShape(12, 0, 12, 13, 5, 13), Block.makeCuboidShape(12, 0, 3, 13, 5, 4),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(3, 6, 12, 13, 9, 13),
					Block.makeCuboidShape(3, 6, 3, 13, 9, 4), Block.makeCuboidShape(12, 6, 3, 13, 15, 13))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.makeCuboidShape(12, 0, 12, 13, 5, 13), Block.makeCuboidShape(3, 0, 12, 4, 5, 13),
					Block.makeCuboidShape(12, 0, 3, 13, 5, 4), Block.makeCuboidShape(3, 0, 3, 4, 5, 4),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(12, 6, 3, 13, 9, 13),
					Block.makeCuboidShape(3, 6, 3, 4, 9, 13), Block.makeCuboidShape(3, 6, 3, 13, 15, 4))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(12, 0, 3, 13, 5, 4), Block.makeCuboidShape(12, 0, 12, 13, 5, 13),
					Block.makeCuboidShape(3, 0, 3, 4, 5, 4), Block.makeCuboidShape(3, 0, 12, 4, 5, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(3, 6, 3, 13, 9, 4),
					Block.makeCuboidShape(3, 6, 12, 13, 9, 13), Block.makeCuboidShape(3, 6, 3, 4, 15, 13))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public ChairBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(IFACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(IFACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(IFACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(IFACING, rot.rotate(state.get(IFACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(IFACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(IFACING);
	}
}

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
			.of(Block.makeCuboidShape(1, 0, 1, 2, 5, 2), Block.makeCuboidShape(14, 0, 1, 15, 5, 2),
					Block.makeCuboidShape(1, 0, 12, 2, 5, 13), Block.makeCuboidShape(14, 0, 12, 15, 5, 13),
					Block.makeCuboidShape(1, 5, 1, 15, 6, 13), Block.makeCuboidShape(1, 6, 1, 2, 10, 12),
					Block.makeCuboidShape(14, 6, 1, 15, 10, 12), Block.makeCuboidShape(1, 6, 12, 15, 19, 13))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream
			.of(Block.makeCuboidShape(1, 0, 14, 2, 5, 15), Block.makeCuboidShape(1, 0, 1, 2, 5, 2),
					Block.makeCuboidShape(12, 0, 14, 13, 5, 15), Block.makeCuboidShape(12, 0, 1, 13, 5, 2),
					Block.makeCuboidShape(1, 5, 1, 13, 6, 15), Block.makeCuboidShape(1, 6, 14, 12, 10, 15),
					Block.makeCuboidShape(1, 6, 1, 12, 10, 2), Block.makeCuboidShape(12, 6, 1, 13, 19, 15))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.makeCuboidShape(14, 0, 14, 15, 5, 15), Block.makeCuboidShape(1, 0, 14, 2, 5, 15),
					Block.makeCuboidShape(14, 0, 3, 15, 5, 4), Block.makeCuboidShape(1, 0, 3, 2, 5, 4),
					Block.makeCuboidShape(1, 5, 3, 15, 6, 15), Block.makeCuboidShape(14, 6, 4, 15, 10, 15),
					Block.makeCuboidShape(1, 6, 4, 2, 10, 15), Block.makeCuboidShape(1, 6, 3, 15, 19, 4))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(14, 0, 1, 15, 5, 2), Block.makeCuboidShape(14, 0, 14, 15, 5, 15),
					Block.makeCuboidShape(3, 0, 1, 4, 5, 2), Block.makeCuboidShape(3, 0, 14, 4, 5, 15),
					Block.makeCuboidShape(3, 5, 1, 15, 6, 15), Block.makeCuboidShape(4, 6, 1, 15, 10, 2),
					Block.makeCuboidShape(4, 6, 14, 15, 10, 15), Block.makeCuboidShape(3, 6, 1, 4, 19, 15))
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

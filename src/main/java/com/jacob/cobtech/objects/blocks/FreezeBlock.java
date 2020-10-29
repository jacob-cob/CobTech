package com.jacob.cobtech.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class FreezeBlock extends Block{
	
   public FreezeBlock(Block.Properties properties) {
      super(properties);
   }

   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
      entityIn.setMotionMultiplier(state, new Vec3d(0.1D, (double)0.01F, 0.1D));
   }
   
   @Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}
}
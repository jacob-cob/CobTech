package com.jacob.cobtech.objects.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SnowLauncherItem extends Item 
{
		public SnowLauncherItem(Properties properties) 
		{
			super(properties);
		}
	
		public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			  ItemStack itemstack = playerIn.getHeldItem(handIn);
			  if(!(itemstack.getCount() == 0)) {
				  worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
				  if (!worldIn.isRemote) {
					  SnowballEntity snowballentity = new SnowballEntity(worldIn, playerIn);
					  snowballentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
					  worldIn.addEntity(snowballentity);
				  }
			  }

		      return ActionResult.resultSuccess(itemstack);
		   }
}

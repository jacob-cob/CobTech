package com.jacob.cobtech.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SuperFuelItem extends Item{

	public SuperFuelItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 1728000;
	}

}

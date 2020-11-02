package com.jacob.cobtech.container;

import java.util.Objects;

import com.jacob.cobtech.init.BlockInitNew;
import com.jacob.cobtech.init.ModContainerTypes;
import com.jacob.cobtech.tileentity.CobiteCrateTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class CobiteCrateContainer extends Container{
	
	public final CobiteCrateTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;
	
	public CobiteCrateContainer(final int windowId, final PlayerInventory playerInventory, final CobiteCrateTileEntity tileEntity) {
		super(ModContainerTypes.COBITE_CRATE.get(), windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
		
		//Main Inventory
		int startX = 8;
		int startY = 18;
		int slotSizePlus2 = 18;
		for(int row = 0; row < 8; row ++) {
			for(int column = 0; column < 13; column ++) {
				this.addSlot(new Slot(tileEntity, (row * 13) + column, startX + (column * slotSizePlus2), startY + (row * slotSizePlus2)));
			}
		}
		
		//Main Player Inventory
		int startPlayerInvY = startY * 9 + 12;
		int startPlayerInvX = startX * 5 + 4;
		for (int row = 0; row < 3; row ++) {
			for(int column = 0; column < 9; column ++) {
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startPlayerInvX + (column * slotSizePlus2), startPlayerInvY + (row * slotSizePlus2)));
			}
		}
		
		//Hotbar
		int hotbarY = startPlayerInvY + (startPlayerInvY / 3);
		for (int column = 0; column < 9; column ++) {
			this.addSlot(new Slot(playerInventory, column, startPlayerInvX + (column * slotSizePlus2), hotbarY));
		}
	}
	
	private static CobiteCrateTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if(tileAtPos instanceof CobiteCrateTileEntity) {
			return(CobiteCrateTileEntity)tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct!" + tileAtPos);
	}
	
	public CobiteCrateContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInitNew.COBITE_CRATE.get());
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < 9) {
				if (!this.mergeItemStack(itemstack1, 9, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
}

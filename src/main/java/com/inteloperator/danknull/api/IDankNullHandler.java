package com.inteloperator.danknull.api;

import com.google.common.collect.ImmutableList;
import com.inteloperator.danknull.DankNull;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import java.util.Map;

public interface IDankNullHandler extends IItemHandlerModifiable {

    /**
     * Gets the raw list of ItemStacks contained within this handler
     *
     * @return List of ItemStacks
     */
    NonNullList<ItemStack> getStackList();

    /**
     * extracts while ignoring extraction mode..needed for GUI on dock
     */
    @Nonnull
    default ItemStack extractItemIngoreExtractionMode(final int slot, final int amount, final boolean simulate) {
        return extractItem(slot, amount, simulate);
    }

    /**
     * Override to implement slot validation
     *
     * @param slot Slot index
     * @return The ItemStack that resides in this slot
     */
    @Nonnull
    @Override
    default ItemStack getStackInSlot(final int slot) {
        validateSlot(slot);
        return getStackList().get(slot);
    }

    /**
     * Returns the stack in the given slot with<br>
     * extraction rules applied
     *
     * @param slot Slot index
     * @return extractable stack
     */
    @Nonnull
    ItemStack getExtractableStackInSlot(int slot);

    /**
     * Returns the stack in slot "<i>slot</>" with<br>
     * actual stack size
     */
    @Nonnull
    ItemStack getFullStackInSlot(int slot);

    /**
     * Creates a stack with a size of 1 for rendering purposes
     *
     * @param slot Slot index
     * @return visual stack
     */
    @Nonnull
    ItemStack getRenderableStackForSlot(int slot);

    /**
     * Checks whether the stack matches any stacks in the<br>
     * itemHandler with OreDictionary mode enabled
     *
     * @param stack The stack being checked
     * @return is it is filtered by this itemHandler
     */
    boolean isOreDictFiltered(ItemStack stack);

    /**
     * Checks if the given ItemStack is contained in the inventory
     *
     * @param stack Stack to check
     * @return true if the stack is found within the inventory
     */
    boolean containsItemStack(@Nonnull ItemStack stack);

    /**
     * Searches the inventory for the given stack
     * Ignores stack size
     *
     * @param stack Stack to search for
     * @return Slot the Stack is in
     */
    int findItemStack(@Nonnull ItemStack stack);

    /**
     * Searches the inventory and returns all positions of stacks that are of the same item type.
     *
     * @param stack to search for
     * @return the slots that match the given stack
     */
    ImmutableList<Integer> findItemStacks(@Nonnull ItemStack stack);

    /**
     * Calculates the amount of stacks in the inventory
     *
     * @return Amount of stacks in the inventory
     */
    int stackCount();

    /**
     * Gets the Tier of DankNull
     *
     * @return Dank Null Tier
     */
    @Nonnull
    DankNull.DankNullTier getTier();

    /**
     * Returns the selected index
     *
     * @return Selected Index
     */
    int getSelected();

    /**
     * Sets the selected stack
     *
     * @param slot Selected index
     */
    void setSelected(int slot);

    /**
     * Cycles to the next (or previous) index
     *
     * @param forward Cycle forwards if true
     */
    void cycleSelected(boolean forward);

    /**
     * Returns if the DankNull is locked
     * Used for Creative DankNull
     *
     * @return True if DankNull is Locked
     */
    boolean isLocked();

    /**
     * Sets if the DankNull should be locked
     * Used for Creative DankNull
     *
     * @param lock True if DankNull should be locked
     */
    void setLocked(boolean lock);

    /**
     * Returns if the DankNull can be locked
     * Used for Creative DankNull
     *
     * @return True if the DankNull can be locked
     */
    boolean isLockingSupported();

    /**
     * Sets the UUID for syncing
     *
     * @param uuid UUID
     */
    //void setUUID(@Nonnull String uuid);

    ///**
    // * Gets the UUID for syncing
    // *
    // * @return UUID
    // */
    //@Nonnull
    //String getUUID();

    /**
     * Sets the ore mode for the given stack
     *
     * @param stack Stack to set the mode for
     * @param ore   Mode
     */
    void setOre(@Nonnull ItemStack stack, boolean ore);

    /**
     * Gets the ore mode for the stack
     *
     * @param stack Stack to check
     * @return True if oredict is enabled
     */
    boolean isOre(@Nonnull ItemStack stack);

    /**
     * Checks if the oredict is supported and enabled for the given stack
     *
     * @param stack Stack
     * @return True if oredict is supported and enabled
     */
    boolean isOreSupported(@Nonnull ItemStack stack);

    /**
     * Get the ItemStack Ore Map
     * Shouldn't be modified
     *
     * @return ItemStack Ore Map
     */
    @Nonnull
    Map<ItemStack, Boolean> getOres();

    /**
     * Sets the extraction mode for the given ItemStack
     *
     * @param stack Stack
     * @param mode  Mode
     */
    void setExtractionMode(@Nonnull ItemStack stack, @Nonnull DankNullItemModes.ItemExtractionMode mode);

    /**
     * Cycles the Extraction Mode for the given Stack
     *
     * @param stack   Stack
     * @param forward Cycle forwards if true
     */
    void cycleExtractionMode(@Nonnull ItemStack stack, boolean forward);

    /**
     * Gets the Extraction Mode for the given Stack
     *
     * @param stack Stack
     * @return Extraction Mode
     */
    @Nonnull
    DankNullItemModes.ItemExtractionMode getExtractionMode(@Nonnull ItemStack stack);

    /**
     * Get the ItemStack ExtractionMode Map
     * Shouldn't be modified
     *
     * @return ItemStack ExtractionMode Map
     */
    @Nonnull
    Map<ItemStack, DankNullItemModes.ItemExtractionMode> getExtractionModes();

    /**
     * Sets the Placement Mode for the given Stack
     *
     * @param stack Stack
     * @param mode  Placement Mode
     */
    void setPlacementMode(@Nonnull ItemStack stack, @Nonnull DankNullItemModes.ItemPlacementMode mode);

    /**
     * Cycles the Placement Mode for the given stack
     *
     * @param stack   Stack
     * @param forward Cycle forwards if true
     */
    void cyclePlacementMode(@Nonnull ItemStack stack, boolean forward);

    /**
     * Gets the Placement Mode for the given Stack
     *
     * @param stack Stack
     * @return Placement Mode
     */
    @Nonnull
    DankNullItemModes.ItemPlacementMode getPlacementMode(@Nonnull ItemStack stack);

    /**
     * Gets the ItemStack PlacementMode Map
     * Shouldn't be modified
     *
     * @return ItemStack PlacementMode Map
     */
    Map<ItemStack, DankNullItemModes.ItemPlacementMode> getPlacementMode();

    default void validateSlot(final int slot) {
        if (slot < 0 || slot >= getSlots()) {
            throw new RuntimeException("Slot " + slot + " not in valid range - [0," + getSlots() + ")");
        }
    }
}

package org.gthhcore.api.util;

import java.util.Objects;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import org.gthhcore.Tags;
import org.jetbrains.annotations.NotNull;

public class GTHHUtility {

    @NotNull
    public static ResourceLocation gthhId(@NotNull String path) {
        return new ResourceLocation(Tags.MODID, path);
    }

    /**
     *
     * @param modId  As a String - Example would be "minecraft"
     * @param itemId As a String - Example would be "bedrock"
     * @param amount As an Integer - Example would be any number less than 64
     * @param metaId As an Integer - Example would be 0
     * @return an ItemStack from Forges Registry based on the String I'd of said item.
     *         You can view the String I'd's by pressing F3 + H
     */
    public static @NotNull ItemStack getItemStackFromString(String modId, String itemId, int amount, int metaId) {
        return new ItemStack(
                Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, itemId))), amount,
                metaId);
    }

    public static @NotNull ItemStack getItemStackFromString(String modId, String itemId, int metaId) {
        return new ItemStack(
                Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, itemId))), 1, metaId);
    }

    /**
     *
     * @param modId  As a String - Example would be "minecraft"
     * @param itemId As a String - Example would be "bedrock"
     * @return Item of the Strings Value, Can be any Item from any mod, As long as you get the String ID correct!
     *         This one allows setting Item amounts for recipes.
     *         Useful in GTCEU Machines or anything that needs more than one Item in the recipe
     */
    public static @NotNull Item getItemFromString(String modId, String itemId, int metaId) {
        return new ItemStack(
                Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, itemId))), 1, metaId)
                        .getItem();
    }

    public static @NotNull Item getItemFromString(String modId, String itemId) {
        return new ItemStack(
                Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, itemId))), 1)
                        .getItem();
    }
}

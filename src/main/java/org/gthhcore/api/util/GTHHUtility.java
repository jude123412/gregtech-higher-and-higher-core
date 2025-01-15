package org.gthhcore.api.util;

import gregtech.api.GTValues;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.gthhcore.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class GTHHUtility {

    @NotNull
    public static ResourceLocation gthhId(@NotNull String path) {
        return new ResourceLocation(Tags.MODID, path);
    }

    /**
     *
     * @param id As a String - Example would be "minecraft:bedrock"
     * @return an ItemStack from Forges Registry based on the String I'd of said item.
     * You can view the String I'd's by pressing F3 + H
     */
    public static @NotNull ItemStack getItemStackFromString(String id){
        return new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(id))));
    }

    /**
     *
     * @param id As a String - Example : "minecraft:bedrock"
     * @return Item of the Strings Value, Can be any Item from any mod, As long as you get the String ID correct!
     * This one allows setting Item amounts for recipes.
     * Useful in GTCEU Machines or anything that needs more than one Item in the recipe
     */
    public static @NotNull Item getItemFromString(String id){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(id)));
    }
}

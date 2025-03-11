package org.gthhcore.api.recipes.properties;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import gregtech.api.recipes.recipeproperties.RecipeProperty;

public class SupercriticalProperty extends RecipeProperty<Boolean> {

    public static final String KEY = "supercritical";
    private static SupercriticalProperty INSTANCE;

    private SupercriticalProperty() {
        super(KEY, Boolean.class);
    }

    public static SupercriticalProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SupercriticalProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.supercritical",
                value, castValue(value)), x, y, color);
    }
}

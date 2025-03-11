package org.gthhcore.api.recipes.properties;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import gregtech.api.recipes.recipeproperties.RecipeProperty;

public class SuperheatedProperty extends RecipeProperty<Boolean> {

    public static final String KEY = "superheated";
    private static SuperheatedProperty INSTANCE;

    private SuperheatedProperty() {
        super(KEY, Boolean.class);
    }

    public static SuperheatedProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SuperheatedProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.superheated",
                value, castValue(value)), x, y, color);
    }
}

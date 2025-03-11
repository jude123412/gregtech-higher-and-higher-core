package org.gthhcore.api.recipes.properties;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import gregtech.api.recipes.recipeproperties.RecipeProperty;

public class HeatUnitProperty extends RecipeProperty<Integer> {

    public static final String KEY = "heatUnit";
    private static HeatUnitProperty INSTANCE;

    private HeatUnitProperty() {
        super(KEY, Integer.class);
    }

    public static HeatUnitProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HeatUnitProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.fission_heat",
                value, castValue(value)), x, y, color);
    }
}

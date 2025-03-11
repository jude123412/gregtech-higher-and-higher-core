package org.gthhcore.api.recipes.builder;

import org.gthhcore.api.recipes.properties.HeatUnitProperty;
import org.gthhcore.api.recipes.properties.SupercriticalProperty;
import org.gthhcore.api.recipes.properties.SuperheatedProperty;
import org.gthhcore.api.util.GTHHLog;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.PrimitiveProperty;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.ValidationResult;

public class FissionRecipeBuilder extends RecipeBuilder<FissionRecipeBuilder> {

    public FissionRecipeBuilder() {}

    public FissionRecipeBuilder(Recipe recipe, RecipeMap<FissionRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public FissionRecipeBuilder(RecipeBuilder<FissionRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public FissionRecipeBuilder copy() {
        return new FissionRecipeBuilder(this);
    }

    public FissionRecipeBuilder HUt(int heatUnit) {
        if (heatUnit <= 0) {
            GTHHLog.logger.error("HUt cannot be less than or equal to 0",
                    new Throwable());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(HeatUnitProperty.getInstance(), heatUnit);
        return this;
    }

    public FissionRecipeBuilder isSuperHeated() {
        this.applyProperty(SuperheatedProperty.getInstance(), true);
        return this;
    }

    public FissionRecipeBuilder isSupercritical() {
        this.applyProperty(SupercriticalProperty.getInstance(), true);
        return this;
    }

    @Override
    public ValidationResult<Recipe> build() {
        this.EUt(1);
        applyProperty(PrimitiveProperty.getInstance(), true);
        return super.build();
    }
}

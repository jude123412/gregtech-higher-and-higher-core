package org.gthhcore.loaders.recipe.mod.gregtech.material;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraft.init.Items;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHValues.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

public class ModIntegrationRecipes {

    public static void init() {
        registerModIntegrationRecipe();
    }


    public static void registerModIntegrationRecipe() {

        // Charged Certus Quartz
        POLARIZER_RECIPES.recipeBuilder()
                .duration(second * 10).EUt(VA[HV])
                .input(dust, CertusQuartz)
                .output(dust, ChargedCertusQuartz)
                .buildAndRegister();

        // Fluix
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 30).EUt(VA[HV])
                .input(dust, ChargedCertusQuartz)
                .input(dust, NetherQuartz)
                .input(dust, Redstone)
                .output(dust, Fluix, 3)
                .buildAndRegister();

        // Fluix Pearl
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 15).EUt(VA[EV])
                .input(dust, Fluix)
                .input(dust, EnderPearl)
                .output(dust, FluixPearl, 2)
                .buildAndRegister();

        // Fluixilized
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 120).EUt(VA[IV])
                .input(dust, FluixPearl)
                .input(dust, CertusQuartz)
                .input(dust, Fluix)
                .output(dust, Fluixilized, 3)
                .buildAndRegister();

        // Sand Compound
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[LV])
                .input(dust, Stone, 4)
                .input(dust, QuartzSand, 3)
                .input(dust, Clay, 2)
                .output(dust, SandCompound, 9)
                .buildAndRegister();

        // Electrical Steel
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 30).EUt(VA[LV])
                .input(dust, Steel)
                .input(dust, Silicon)
                .output(dust, ElectricalSteel, 2)
                .buildAndRegister();

        // Energetic Alloy
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[MV])
                .input(dust, Gold)
                .input(dust, Redstone)
                .input(dust, Glowstone)
                .output(dust, EnergeticAlloy, 2)
                .buildAndRegister();
        
        // Vibrant Alloy
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 60).EUt(VA[EV])
                .input(dust, EnergeticAlloy)
                .input(dust, EnderPearl)
                .output(dust, VibrantAlloy, 2)
                .buildAndRegister();

        // Redstone Alloy
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 30).EUt(VA[LV])
                .input(dust, ElectricalSteel)
                .input(dust, Redstone)
                .input(dust, Silicon)
                .output(dust, RedstoneAlloy, 3)
                .buildAndRegister();

        // Conductive Iron
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 30).EUt(VA[LV])
                .input(dust, RedstoneAlloy)
                .input(dust, Steel)
                .input(dust, Redstone)
                .output(dust, ConductiveIron, 3)
                .buildAndRegister();

        // Pulsating Iron
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 15).EUt(VA[ULV])
                .input(dust, EnderPearl)
                .input(dust, Steel)
                .output(dust, PulsatingIron)
                .buildAndRegister();

        // Pulsating Crystal
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(second * 60).EUt(VA[LV])
                .input(gem, Diamond)
                .fluidInputs(PulsatingIron.getFluid(L))
                .output(gem, PulsatingCrystal)
                .buildAndRegister();

        // Dark Steel
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[MV])
                .input(dust, Steel)
                .input(dust, Obsidian)
                .output(dust, DarkSteel, 2)
                .buildAndRegister();

        // Soularium
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[MV])
                .input(dust, Gold)
                .input(dust, Ash)
                .output(dust, Soularium, 2)
                .buildAndRegister();

        // End Steel
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[HV])
                .input(dust, DarkSteel)
                .input(dust, Endstone)
                .output(dust, EndSteel, 2)
                .buildAndRegister();

        // Crude Steel
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[ULV])
                .input(dust, Clay)
                .input(dust, QuartzSand)
                .input(dust, Tin)
                .output(dust, CrudeSteel, 3)
                .buildAndRegister();

        // Crystalline Alloy
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 90).EUt(VA[IV])
                .input(dust, Gold)
                .input(dust, PulsatingCrystal)
                .output(dust, CrystallineAlloy, 2)
                .buildAndRegister();

        // Melodic Alloy
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 120).EUt(VA[ZPM])
                .input(Items.CHORUS_FRUIT_POPPED)
                .input(dust, EndSteel)
                .output(dust, MelodicAlloy)
                .buildAndRegister();

        // Crystalline Pink Slime
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 150).EUt(VA[LuV])
                .input(dust, MelodicAlloy)
                .input(dust, CrystallineAlloy)
                .output(dust, CrystallinePinkSlime)
                .buildAndRegister();

        // Energetic Silver
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[MV])
                .input(dust, Silver)
                .input(dust, Redstone)
                .input(dust, Glowstone)
                .output(dust, EnergeticSilver, 3)
                .buildAndRegister();

        // Vivid Alloy
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 60).EUt(VA[HV])
                .input(dust, EnergeticSilver)
                .input(dust, EnderPearl)
                .output(dust, VividAlloy, 2)
                .buildAndRegister();

        // Stellar Alloy
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 240).EUt(VA[UV])
                .input(dust, VividAlloy)
                .input(dust, VibrantAlloy)
                .input(dust, CrystallinePinkSlime)
                .input(dust, NetherStar)
                .output(dust, StellarAlloy, 4)
                .buildAndRegister();



        // Vibrant Crystal
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(second * 60).EUt(VA[MV])
                .input(gem, Emerald)
                .fluidInputs(VibrantAlloy.getFluid(L))
                .output(gem, VibrantCrystal)
                .buildAndRegister();

        // Weather Crystal
        MIXER_RECIPES.recipeBuilder()
                .duration(second * 45).EUt(VA[EV])
                .input(dust, PulsatingCrystal, 2)
                .input(dust, VibrantCrystal, 2)
                .input(dust, EnderCrystal)
                .output(dust, WeatherCrystal, 5)
                .buildAndRegister();
    }
}

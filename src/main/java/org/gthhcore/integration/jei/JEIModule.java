package org.gthhcore.integration.jei;

import org.gthhcore.api.recipes.GTHHRecipeMaps;
import org.gthhcore.common.metatileentities.GTHHMetaTileEntities;

import gregtech.api.GTValues;
import gregtech.api.modules.GregTechModule;
import gregtech.api.util.Mods;
import gregtech.integration.IntegrationSubmodule;
import gregtech.modules.GregTechModules;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

@JEIPlugin
@GregTechModule(
                moduleID = GregTechModules.MODULE_JEI,
                containerID = GTValues.MODID,
                modDependencies = Mods.Names.JUST_ENOUGH_ITEMS,
                name = "GT Higher & Higher JEI Integration",
                description = "JEI Integration Module")
public class JEIModule extends IntegrationSubmodule implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        String semiFluidMapId = GTValues.MODID + ":" + GTHHRecipeMaps.FISSION_RECIPES.getUnlocalizedName();
        registry.addRecipeCatalyst(GTHHMetaTileEntities.FISSION_REACTOR.getStackForm(), semiFluidMapId);
    }
}

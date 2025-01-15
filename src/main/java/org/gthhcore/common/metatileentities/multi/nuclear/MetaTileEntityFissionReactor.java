package org.gthhcore.common.metatileentities.multi.nuclear;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.gthhcore.api.capability.impl.MultiblockFissionRecipeLogic;
import org.gthhcore.api.metatileentity.multiblock.FissionMultiblockController;
import org.gthhcore.common.metatileentities.GTHHMetaTileEntities;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static gregtech.api.metatileentity.multiblock.MultiblockAbility.*;
import static org.gthhcore.api.recipes.GTHHRecipeMaps.*;

public class MetaTileEntityFissionReactor extends FissionMultiblockController {


    public MetaTileEntityFissionReactor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, FISSION_RECIPES);
        this.recipeMapWorkable = new FissionReactorWorkableHandler(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityFissionReactor(metaTileEntityId);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("AAA", "AXA", "AAA")
                .aisle("AXA", "XCX", "AXA")
                .aisle("AAA", "ASA", "AAA")
                .where('S', selfPredicate().setCenter())
                .where('C', states(getCasingState()))
                .where('X', states(getCasingState()).setMinGlobalLimited(1)
                        .or(autoAbilities(false, true, true, true,false,false,false)
                                .or(abilities(OUTPUT_ENERGY).setMaxGlobalLimited(1)))
                )
                .where('A', any())
                .build();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.FROST_PROOF_CASING;
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF);
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.VACUUM_FREEZER_OVERLAY;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("###", "#X#", "###")
                .aisle("#E#", "IXO", "#S#")
                .aisle("###", "#M#", "###")
                .where('#', Blocks.AIR.getDefaultState())
                .where('X', MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF))
                .where('S', GTHHMetaTileEntities.FISSION_REACTOR, EnumFacing.UP)
                .where('E', MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.LV], EnumFacing.DOWN)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
                .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.EAST)
                .where('M', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH :
                        MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF), EnumFacing.SOUTH);
                 shapeInfo.add(builder.build());
        return shapeInfo;
    }
    
    public static class FissionReactorWorkableHandler extends MultiblockFissionRecipeLogic {

        private final MetaTileEntityFissionReactor fissionReactor;
        public FissionReactorWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.fissionReactor = (MetaTileEntityFissionReactor) tileEntity;
        }

        @Override
        public void invalidate() {
            parallelRecipesPerformed = 0;
            super.invalidate();
        }

        public MetaTileEntityFissionReactor getFissionReactor() {
            return fissionReactor;
        }
    }
}

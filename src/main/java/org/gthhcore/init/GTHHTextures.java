package org.gthhcore.init;

import codechicken.lib.texture.TextureUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;


public class GTHHTextures implements TextureUtils.IIconRegister {
    private static TextureMap map;
    public static TextureAtlasSprite PROCESSOR;
    public static TextureAtlasSprite ASSEMBLY;
    public static TextureAtlasSprite COMPUTER;
    public static TextureAtlasSprite MAINFRAME;
    public static TextureAtlasSprite BOARD;
    public static TextureAtlasSprite CIRCUIT_BOARD;
    public static TextureAtlasSprite SMD;
    public static TextureAtlasSprite SMALL_BATTERY;
    public static TextureAtlasSprite MEDIUM_BATTERY;
    public static TextureAtlasSprite LARGE_BATTERY;



    public GTHHTextures() {
        super();
    }


    @Override
    public void registerIcons(TextureMap textureMap) {
        map = textureMap;
        PROCESSOR = register("gthhcore:items/cosmic/mask/processor");
        ASSEMBLY = register("gthhcore:items/cosmic/mask/assembly");
        COMPUTER = register("gthhcore:items/cosmic/mask/computer");
        MAINFRAME = register("gthhcore:items/cosmic/mask/mainframe");
        BOARD = register("gthhcore:items/cosmic/mask/board");
        CIRCUIT_BOARD = register("gthhcore:items/cosmic/mask/circuit_board");
        SMD = register("gthhcore:items/cosmic/mask/smd");
        SMALL_BATTERY = register("gthhcore:items/cosmic/mask/small_battery");
        MEDIUM_BATTERY = register("gthhcore:items/cosmic/mask/medium_battery");
        LARGE_BATTERY = register("gthhcore:items/cosmic/mask/large_battery");
    }

    private static TextureAtlasSprite register(String sprite) {
        return map.registerSprite(new ResourceLocation(sprite));
    }
}

package com.inteloperator.danknull;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DankNull.modid)
public class DankNull {
    public static final String modid = "danknull";


    public DankNull() {
        var forge = MinecraftForge.EVENT_BUS;
        var mod = FMLJavaModLoadingContext.get().getModEventBus();
        forge.register(this);
    }

    public enum DankNullTier {
        REDSTONE, LAPIS, IRON, GOLD, DIAMOND, EMERALD, CREATIVE, NONE;

        //@formatter:off
        private static final int[] OPAQUE_HEX_COLORS = new int[]{
                0xFFEC4848,
                0xFF4885EC,
                0xFFFFFFFF,
                0xFFFFFF00,
                0xFF00FFFF,
                0xFF17FF6D,
                0xFF8F15D4,
                0x0
        };
        private static final int[] HEX_COLORS = new int[]{
                0x99EC4848,
                0x994885EC,
                0x99FFFFFF,
                0x99FFFF00,
                0x9900FFFF,
                0x9917FF6D,
                0x998F15D4,
                0x0
        };
    }

}

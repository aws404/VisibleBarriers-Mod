package com.aws404.visiblebarriers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = VisibleBarriers.MODID, name = VisibleBarriers.NAME, version = VisibleBarriers.VERSION)
public class VisibleBarriers {
    public static final String MODID = "visiblebarriers";
    public static final String NAME = "Visible Barriers";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(new ModListener());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        KeyBindings.registerBindings();
    }
}

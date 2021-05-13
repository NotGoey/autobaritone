package com.joshyspcs.betterbaratone;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "baratoneautostart";
    public static final String NAME = "better baratone";
    public static final String VERSION = "1.0";

    public static Logger logger;
    public static boolean stated = false;
    public static Thread startt;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        ClientCommandHandler.instance.registerCommand(new start());
        ClientCommandHandler.instance.registerCommand(new stop());
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    

}

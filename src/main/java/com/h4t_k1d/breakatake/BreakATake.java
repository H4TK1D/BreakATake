package com.h4t_k1d.breakatake;

import com.h4t_k1d.breakatake.client.GUI;
import com.h4t_k1d.breakatake.client.TickHandler;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(BreakATake.MODID)
public class BreakATake
{
    //Init tickHandler
    private static final TickHandler tickHandler = new TickHandler();
    // Set modid
    public static final String MODID = "breakatake";
    // Get current logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public BreakATake(IEventBus modEventBus, ModContainer modContainer)
    {
        //Add a listener to the tickHandler
        NeoForge.EVENT_BUS.addListener(tickHandler::tick);
        NeoForge.EVENT_BUS.addListener(GUI::tick);
        // Register Config
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
    }
}

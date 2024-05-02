package com.h4t_k1d.breakatake;

import com.h4t_k1d.breakatake.client.GUI;
import com.h4t_k1d.breakatake.client.TickHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(BreakATake.MODID)
public class BreakATake
{
    //Init tickHandler
    private static final TickHandler tickHandler = new TickHandler();
    // Set modid
    public static final String MODID = "breakatake";

    public BreakATake(IEventBus modEventBus, ModContainer modContainer)
    {
        //Add a listener to the tickHandler
        NeoForge.EVENT_BUS.addListener(tickHandler::tick);
        NeoForge.EVENT_BUS.addListener(GUI::tick);
        // Register Config
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
    }
}

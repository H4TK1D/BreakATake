package com.h4t_k1d.breakatake.client;

import com.h4t_k1d.breakatake.Config;
import com.h4t_k1d.breakatake.etc.Debugger;
import com.h4t_k1d.breakatake.events.playerKick;
import com.mojang.logging.LogUtils;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.Debug;
import org.slf4j.Logger;
import oshi.util.tuples.Pair;


public class TickHandler {
    private static final Timer timer = new Timer();
    private static final Logger LOGGER = LogUtils.getLogger();
    private static Boolean shouldHandleTick(){
        if (FMLEnvironment.dist != Dist.CLIENT) return false;
        if (Minecraft.getInstance().level == null) return false;
        return Minecraft.getInstance().screen == null || !Minecraft.getInstance().screen.isPauseScreen();
    }
    private static Boolean shouldKick(){
        if (Config.FocusMode) return false;
        if (timer.getTotalMinutes() % Config.KickTime != 0) return false;
        if (timer.getHours() == 0 && timer.getMinutes() != Config.KickTime) return false;
        return timer.getSeconds() == 0;
    }
    public void tick(ClientTickEvent.Post event) {
        if (!shouldHandleTick()) return;
        timer.tick();
        if (timer.getTicks() % 20 != 0) return;
        //Debugger.DebugTime(timer);
        if (!shouldKick()) return;
        Pair<Integer,Connection> connectionPair = ConnectionHandler.localConnection();
        if (connectionPair.getA() == 1) return;
        String kickString = String.format(
                "Take a break :)\n You have been playing for:\n%s Hours\n%s Minutes",
                timer.getHours(),
                timer.getMinutes()
        );
        Integer result = playerKick.kickPlayer(connectionPair.getB(),kickString);
        if (result == 1) Minecraft.crash(
                Minecraft.getInstance(),
                Minecraft.getInstance().gameDirectory,
                new CrashReport("Crash",new Throwable("Null Connection"))
        );
    }
}

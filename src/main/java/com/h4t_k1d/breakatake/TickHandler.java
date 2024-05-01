package com.h4t_k1d.breakatake;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.slf4j.Logger;


public class TickHandler {
    private static final Timer timer = new Timer();
    private static final Logger LOGGER = LogUtils.getLogger();
    public void tick(ClientTickEvent.Post event) {
        if (FMLEnvironment.dist != Dist.CLIENT) return;
        if (Minecraft.getInstance().level == null) return;
        if (Minecraft.getInstance().screen != null && Minecraft.getInstance().screen.isPauseScreen()) return;
        timer.tick();
        if (timer.getTicks() % 20 != 0) return;
        String timeString = String.format(
                "\nHours: %s\nMinutes: %s\nSeconds: %s\nTicks: %s",
                timer.getHours(),
                timer.getMinutes(),
                timer.getSeconds(),
                timer.getLocalTicks()
        );
        LOGGER.info(timeString);
        LOGGER.info(timer.getMinutes()+ " " + timer.getSeconds());
        if (timer.getMinutes() != 30 && timer.getMinutes() != 0) return;
        if (timer.getHours() == 0 && timer.getMinutes() != 30) return;
        if (timer.getSeconds() != 0) return;
        LOGGER.info("HÆNG DIG SELV DIT FEDE SVIN");
    }
}

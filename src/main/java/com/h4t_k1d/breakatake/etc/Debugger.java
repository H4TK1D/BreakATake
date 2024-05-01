package com.h4t_k1d.breakatake.etc;

import com.h4t_k1d.breakatake.client.Timer;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class Debugger {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static void DebugTime(Timer timer){

        String timeString = String.format(
                "\nHours: %s\nMinutes: %s\nSeconds: %s\nTicks: %s",
                timer.getHours(),
                timer.getMinutes(),
                timer.getSeconds(),
                timer.getLocalTicks()
        );
        LOGGER.info(timeString);
    }
}

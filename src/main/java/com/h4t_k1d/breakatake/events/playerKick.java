package com.h4t_k1d.breakatake.events;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;

public class playerKick {
    public static Integer kickPlayer(Connection c, String Reason){
        if (Minecraft.getInstance().player == null) return 1;
        c.disconnect(Component.literal(Reason));
        return 0;
    }
}

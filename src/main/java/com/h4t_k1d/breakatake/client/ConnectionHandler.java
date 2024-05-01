package com.h4t_k1d.breakatake.client;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import oshi.util.tuples.Pair;

public class ConnectionHandler {
    public static Pair<Integer,Connection> localConnection(){
        if (Minecraft.getInstance().player != null) {
            Connection newConnection = Minecraft.getInstance().player.connection.getConnection();
            return new Pair<>(0,newConnection);
        }
        return new Pair<>(1,null);

    }
}

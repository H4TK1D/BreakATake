package com.h4t_k1d.breakatake.client;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

public class GUI {
    public static void tick(RenderGuiEvent.Post event){
        if (FMLEnvironment.dist != Dist.CLIENT) return;
        Minecraft mc = Minecraft.getInstance();

        Font clockFont = mc.font;
        Window scaled = mc.getWindow();
        int width = scaled.getGuiScaledWidth();
        int xCoord = width-40;
        int yCoord = 10;
        int color = 0xffFFFFFF;

        Timer timer = TickHandler.timer;
        String clockText = String.format(
                "%s:%s:%s",
                timer.getHours(),
                timer.getMinutes(),
                timer.getSeconds()
        );

        drawText(clockFont,event.getGuiGraphics(),clockText,xCoord,yCoord,color);
    }
    private static void drawText(Font font, GuiGraphics guiGraphics, String content, int x, int y, int rgb) {
        guiGraphics.drawString(font, Component.literal(content), x, y, rgb, true);
    }
}

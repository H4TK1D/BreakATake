package com.h4t_k1d.breakatake;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = BreakATake.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.BooleanValue FOCUS_ENABLED = BUILDER
            .comment("Focus mode : You will not be kicked while this is active")
            .define("FocusMode",false);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static Boolean FocusMode;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        FocusMode = FOCUS_ENABLED.get();
    }
}

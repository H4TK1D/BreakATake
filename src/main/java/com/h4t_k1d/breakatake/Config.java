package com.h4t_k1d.breakatake;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = BreakATake.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.BooleanValue FOCUS_ENABLED = BUILDER
            .comment("You will not be kicked while this is active")
            .define("FocusMode",false);
    private static final ModConfigSpec.IntValue TIME_BEFORE_KICK = BUILDER
            .comment("Minutes before kick occurs")
            .defineInRange("KickTime",30,1,90);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static Boolean FocusMode;

    public static Integer KickTime;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        FocusMode = FOCUS_ENABLED.get();
        KickTime = TIME_BEFORE_KICK.get();
    }
}

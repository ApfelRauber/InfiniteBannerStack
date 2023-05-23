package de.seiboldsmuehle.infinite_banner_stack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class infinitebannerstack implements ModInitializer {
    @Override
    public void onInitialize() {
        GameRules.setupGamerules();
        ServerTickEvents.END_SERVER_TICK.register(new ServerTickListener());
    }
}
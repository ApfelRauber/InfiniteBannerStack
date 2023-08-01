package io.github.apfelrauber.infinite_banner_stack.sidedgamerulegetter;

import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStack;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

public class ServerGameRulesGetter implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        ServerTickEvents.END_SERVER_TICK.register(new ServerTickEvents.EndTick() {
            @Override
            public void onEndTick(MinecraftServer server) {
                InfiniteBannerStack.setGameRules(server.getGameRules());
            }
        });
    }
}

package io.github.apfelrauber.infinite_banner_stack.sidedgamerulegetter;

import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStack;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ClientGameRulesGetter implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(new ClientTickEvents.EndTick() {
            @Override
            public void onEndTick(MinecraftClient client) {
                if(client.world != null) InfiniteBannerStack.setGameRules(client.world.getGameRules());
            }
        });
    }
}

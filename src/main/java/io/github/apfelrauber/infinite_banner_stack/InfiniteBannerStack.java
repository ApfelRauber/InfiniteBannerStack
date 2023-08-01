package io.github.apfelrauber.infinite_banner_stack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.GameRules;

public class InfiniteBannerStack implements ModInitializer {
    public static GameRules currentGameRules;
    @Override
    public void onInitialize() {
        InfiniteBannerStackGameRules.setupGamerules();
    }

    public static void setGameRules(GameRules gameRules){
        currentGameRules = gameRules;
    }
}
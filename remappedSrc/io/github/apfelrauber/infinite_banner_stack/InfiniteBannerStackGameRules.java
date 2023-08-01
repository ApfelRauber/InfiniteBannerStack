package io.github.apfelrauber.infinite_banner_stack;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class InfiniteBannerStackGameRules {
    public static net.minecraft.world.GameRules.Key<net.minecraft.world.GameRules.IntRule> MAX_BANNER_STACK;

    public static void setupGamerules() {
        MAX_BANNER_STACK = GameRuleRegistry.register("maxBannerStack", GameRules.Category.MISC, GameRuleFactory.createIntRule(100, 0, 10000));
    }
}

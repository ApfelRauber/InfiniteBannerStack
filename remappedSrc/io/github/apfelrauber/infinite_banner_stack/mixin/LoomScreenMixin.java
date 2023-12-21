package io.github.apfelrauber.infinite_banner_stack.mixin;


import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStack;
import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStackGameRules;
import net.minecraft.client.gui.screen.ingame.LoomScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LoomScreen.class)
public class LoomScreenMixin {
    @ModifyConstant(method = "onInventoryChanged()V", constant = @Constant(intValue = 6))
    private int maxBannerPattern(int orig) {
        return InfiniteBannerStack.currentGameRules.get(InfiniteBannerStackGameRules.MAX_BANNER_STACK).get();
    }
}

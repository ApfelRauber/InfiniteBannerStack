package io.github.apfelrauber.infinite_banner_stack.mixin;


import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStack;
import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStackGameRules;
import net.minecraft.screen.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(LoomScreenHandler.class)
class LoomScreenHandlerMixin {
    @ModifyConstant(method = "onContentChanged(Lnet/minecraft/inventory/Inventory;)V", constant = @Constant(intValue = 6))
    private int maxBannerPattern(int orig) {
        return InfiniteBannerStack.currentGameRules.get(InfiniteBannerStackGameRules.MAX_BANNER_STACK).get();
    }
}

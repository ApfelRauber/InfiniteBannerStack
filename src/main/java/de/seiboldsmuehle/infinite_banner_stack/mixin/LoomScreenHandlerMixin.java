package de.seiboldsmuehle.infinite_banner_stack.mixin;


import de.seiboldsmuehle.infinite_banner_stack.GameRules;
import de.seiboldsmuehle.infinite_banner_stack.ServerTickListener;
import net.minecraft.screen.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(LoomScreenHandler.class)
class LoomScreenHandlerMixin {
    @ModifyConstant(method = "Lnet/minecraft/screen/LoomScreenHandler;onContentChanged(Lnet/minecraft/inventory/Inventory;)V", constant = @Constant(intValue = 6))
    private int maxBannerPattern(int orig) {
        return ServerTickListener.currentServer.getGameRules().get(GameRules.MAX_BANNER_STACK).get();
    }
}

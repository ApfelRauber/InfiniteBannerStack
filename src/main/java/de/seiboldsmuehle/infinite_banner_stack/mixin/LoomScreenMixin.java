package de.seiboldsmuehle.infinite_banner_stack.mixin;

import de.seiboldsmuehle.infinite_banner_stack.GameRules;
import de.seiboldsmuehle.infinite_banner_stack.ServerTickListener;
import net.minecraft.client.gui.screen.ingame.LoomScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LoomScreen.class)
public class LoomScreenMixin {
    @ModifyConstant(method = "Lnet/minecraft/client/gui/screen/ingame/LoomScreen;onInventoryChanged()V", constant = @Constant(intValue = 6))
    private int maxBannerPattern(int orig) {
        return ServerTickListener.currentServer.getGameRules().get(GameRules.MAX_BANNER_STACK).get();
    }
}

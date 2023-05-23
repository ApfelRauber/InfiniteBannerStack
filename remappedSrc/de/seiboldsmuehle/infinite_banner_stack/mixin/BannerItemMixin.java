package de.seiboldsmuehle.infinite_banner_stack.mixin;

import de.seiboldsmuehle.infinite_banner_stack.GameRules;
import de.seiboldsmuehle.infinite_banner_stack.ServerTickListener;
import net.minecraft.item.BannerItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BannerItem.class)
public class BannerItemMixin {
    @ModifyConstant(method = "Lnet/minecraft/item/BannerItem;appendBannerTooltip(Lnet/minecraft/item/ItemStack;Ljava/util/List;)V", constant = @Constant(intValue = 6))
    private static int maxBannerPattern(int orig) {
        return ServerTickListener.currentServer.getGameRules().get(GameRules.MAX_BANNER_STACK).get();
    }
}

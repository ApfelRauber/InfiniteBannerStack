package de.seiboldsmuehle.infinite_banner_stack.mixin;

import de.seiboldsmuehle.infinite_banner_stack.GameRules;
import de.seiboldsmuehle.infinite_banner_stack.ServerTickListener;
import net.minecraft.recipe.BannerDuplicateRecipe;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BannerDuplicateRecipe.class)
public class BannerDuplicateRecipeMixin {

    @ModifyConstant(method = "matches(Lnet/minecraft/inventory/CraftingInventory;Lnet/minecraft/world/World;)Z", constant = @Constant(intValue = 6))
    private int maxBannerPatternLS(int orig) {
        return ServerTickListener.currentServer.getGameRules().get(GameRules.MAX_BANNER_STACK).get();
    }
    @ModifyConstant(method = "craft(Lnet/minecraft/inventory/CraftingInventory;Lnet/minecraft/registry/DynamicRegistryManager;)Lnet/minecraft/item/ItemStack;", constant = @Constant(intValue = 6))
    private int maxBannerPattern(int orig) {
        return ServerTickListener.currentServer.getGameRules().get(GameRules.MAX_BANNER_STACK).get();
    }
}

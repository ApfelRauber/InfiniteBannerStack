package io.github.apfelrauber.infinite_banner_stack.mixin;

import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStack;
import io.github.apfelrauber.infinite_banner_stack.InfiniteBannerStackGameRules;
import net.minecraft.recipe.BannerDuplicateRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BannerDuplicateRecipe.class)
public class BannerDuplicateRecipeMixin {

    @ModifyConstant(method = "Lnet/minecraft/recipe/BannerDuplicateRecipe;matches(Lnet/minecraft/inventory/RecipeInputInventory;Lnet/minecraft/world/World;)Z", constant = @Constant(intValue = 6))
    private int maxBannerPatternLS(int orig) {
        return InfiniteBannerStack.currentGameRules.get(InfiniteBannerStackGameRules.MAX_BANNER_STACK).get();
    }
    @ModifyConstant(method = "Lnet/minecraft/recipe/BannerDuplicateRecipe;craft(Lnet/minecraft/inventory/RecipeInputInventory;Lnet/minecraft/registry/DynamicRegistryManager;)Lnet/minecraft/item/ItemStack;", constant = @Constant(intValue = 6))
    private int maxBannerPattern(int orig) {
        return InfiniteBannerStack.currentGameRules.get(InfiniteBannerStackGameRules.MAX_BANNER_STACK).get();
    }
}

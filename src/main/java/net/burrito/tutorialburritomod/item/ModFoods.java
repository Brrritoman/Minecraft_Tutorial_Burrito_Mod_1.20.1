package net.burrito.tutorialburritomod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.HEAL, 10, 1),0.1f).build();
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.75f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200, 1),0.25f).build();

}

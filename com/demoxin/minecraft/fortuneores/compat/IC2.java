package com.demoxin.minecraft.fortuneores.compat;

import ic2.api.item.Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import com.demoxin.minecraft.fortuneores.FortuneOres;

public class IC2 {
	public IC2()
	{
		ItemStack IronDust = Items.getItem("ironDust").copy();
		IronDust.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(FortuneOres.chunkIron)), null, IronDust);
		
		ItemStack GoldDust = Items.getItem("goldDust").copy();
		GoldDust.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(FortuneOres.chunkGold)), null, GoldDust);
	}
}

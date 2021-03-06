package com.demoxin.minecraft.fortuneores.compat;

import ic2.api.item.Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import com.demoxin.minecraft.fortuneores.FortuneOres;

public class IC2 {
	public IC2()
	{
		ItemStack IronDust = Items.getItem("crushedIronOre").copy();
		IronDust.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(FortuneOres.itemIron)), null, IronDust);
		
		ItemStack GoldDust = Items.getItem("crushedGoldOre").copy();
		GoldDust.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(FortuneOres.itemGold)), null, GoldDust);
	}
}

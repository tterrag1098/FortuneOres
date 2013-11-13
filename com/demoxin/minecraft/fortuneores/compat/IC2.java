package com.demoxin.minecraft.fortuneores.compat;

import ic2.api.item.Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import com.demoxin.minecraft.fortuneores.FortuneOres;

import cpw.mods.fml.common.registry.GameRegistry;

public class IC2 {
	public IC2()
	{
		// Add smeltable items.
		ItemStack CopperIngot = Items.getItem("copperIngot").copy();
		GameRegistry.addSmelting(FortuneOres.itemCopper.itemID, CopperIngot, 0);
		ItemStack TinIngot = Items.getItem("tinIngot").copy();
		GameRegistry.addSmelting(FortuneOres.itemTin.itemID, TinIngot, 0);
		ItemStack LeadIngot = Items.getItem("leadIngot").copy();
		GameRegistry.addSmelting(FortuneOres.itemLead.itemID, LeadIngot, 0);
		
		ItemStack IronDust = Items.getItem("crushedIronOre").copy();
		IronDust.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(FortuneOres.itemIron)), null, IronDust);
		
		ItemStack GoldDust = Items.getItem("crushedGoldOre").copy();
		GoldDust.stackSize = 2;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(FortuneOres.itemGold)), null, GoldDust);
	}
}

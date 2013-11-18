package com.demoxin.minecraft.fortuneores;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.oredict.OreDictionary;

public class OreSwapper {
	@ForgeSubscribe
	public void SwapOres(HarvestDropsEvent fEvent)
	{
		// This is our nice simple function to change up the loot lists if we're dropping ore blocks.
		
		// First things first, we don't want to work on any silk touch events.
		if(fEvent.isSilkTouching)
			return;
		
		// Check for empty drops list
		if(fEvent.drops.isEmpty())
			return;
		
		// We have a drop, let's check if it's an Item or and ItemBlock.  We're only interested in ItemBlocks
		if(!(fEvent.drops.get(0).getItem() instanceof ItemBlock))
			return;
		
		int itemID = fEvent.drops.get(0).itemID;
		ItemStack checkItem = fEvent.drops.get(0);
		
		// Iron
		if(FortuneOres.config.enableIron)
		{
			if(itemID == Block.oreIron.blockID || OreDictionary.getOreName(OreDictionary.getOreID(checkItem)) == "oreIron")
			{
				// This is dropping iron ore.  Let's sub in our loot list.
				GenerateLootList(fEvent.drops, FortuneOres.itemIron.itemID, RandCount(FortuneOres.config.countIron, fEvent.fortuneLevel, fEvent.world));
				fEvent.dropChance = 1.0f;
				return;
			}
		}
		
		// Gold
		if(FortuneOres.config.enableGold)
		{
			if(itemID == Block.oreGold.blockID || OreDictionary.getOreName(OreDictionary.getOreID(checkItem)) == "oreGold")
			{
				// This is dropping gold ore.  Let's sub in our loot list.
				GenerateLootList(fEvent.drops, FortuneOres.itemGold.itemID, RandCount(FortuneOres.config.countGold, fEvent.fortuneLevel, fEvent.world));
				fEvent.dropChance = 1.0f;
				return;
			}
		}
		
		// Copper
		if(FortuneOres.config.enableCopper)
		{
			if(OreDictionary.getOreName(OreDictionary.getOreID(checkItem)) == "oreCopper")
			{
				// This is dropping copper ore.  Sub our loot.
				GenerateLootList(fEvent.drops, FortuneOres.itemCopper.itemID, RandCount(FortuneOres.config.countCopper, fEvent.fortuneLevel, fEvent.world));
				fEvent.dropChance = 1.0f;
				return;
			}
		}
		
		// Tin
		if(FortuneOres.config.enableTin)
		{
			if(OreDictionary.getOreName(OreDictionary.getOreID(checkItem)) == "oreTin")
			{
				// This is dropping copper ore.  Sub our loot.
				GenerateLootList(fEvent.drops, FortuneOres.itemTin.itemID, RandCount(FortuneOres.config.countTin, fEvent.fortuneLevel, fEvent.world));
				fEvent.dropChance = 1.0f;
				return;
			}
		}
		
		// Lead
		if(FortuneOres.config.enableLead)
		{
			if(OreDictionary.getOreName(OreDictionary.getOreID(checkItem)) == "oreLead")
			{
				// This is dropping copper ore.  Sub our loot.
				GenerateLootList(fEvent.drops, FortuneOres.itemLead.itemID, RandCount(FortuneOres.config.countLead, fEvent.fortuneLevel, fEvent.world));
				fEvent.dropChance = 1.0f;
				return;
			}
		}
		
		// Silver
		if(FortuneOres.config.enableSilver)
		{
			if(OreDictionary.getOreName(OreDictionary.getOreID(checkItem)) == "oreSilver")
			{
				// This is dropping copper ore.  Sub our loot.
				GenerateLootList(fEvent.drops, FortuneOres.itemSilver.itemID, RandCount(FortuneOres.config.countSilver, fEvent.fortuneLevel, fEvent.world));
				fEvent.dropChance = 1.0f;
				return;
			}
		}
	}
	
	private void GenerateLootList(ArrayList<ItemStack> fList, int fItemID, int fCount)
	{
		fList.clear();
		for(int i = 0; i < fCount; ++i)
		{
			ItemStack drop = new ItemStack(fItemID, 1, 0);
			fList.add(drop);
		}
		
	}
	
	private int RandCount(int fBase, int fFortune, World fWorld)
	{
		return MathHelper.clamp_int(fWorld.rand.nextInt(fFortune + 1), 1, 10);
	}
}

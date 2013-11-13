package com.demoxin.minecraft.fortuneores;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.demoxin.minecraft.fortuneores.compat.IC2;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = FortuneOres.MODID, name = FortuneOres.NAME, version = FortuneOres.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FortuneOres {
	// Mod Info
	public static final String MODID = "FortuneOres";
	public static final String NAME = "FortuneOres";
	public static final String VERSION = "0.5";
	// Mod Info End
	
	// Singleton
	@Instance("FortuneOres")
	public static FortuneOres instance;
	
	// Config
	public static Config config;
	
	// Blocks
	public static Block blockIron;
	public static Block blockGold;
	// Mod Ores
	public static Block blockCopper;
	public static Block blockTin;
	public static Block blockLead;
	public static Block blockSilver;
	
	// Items
	public static Item itemIron;
	public static Item itemGold;
	// Mod Items
	public static Item itemCopper;
	public static Item itemTin;
	public static Item itemLead;
	public static Item itemSilver;
	
	// Mod Setup
	public static IC2 Compat_IC2;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent fEvent)
    {
    	config = new Config(new Configuration(fEvent.getSuggestedConfigurationFile()));
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent fEvent)
    {
    	// Hostile Takeover of blocks!
    	if(config.enableIron)
    	{
    		ReplaceOre(Block.oreIron.blockID, blockIron);
    	}
    	
    	if(config.enableGold)
    	{
    		ReplaceOre(Block.oreGold.blockID, blockGold);
    	}
    	
    	if(config.enableCopper)
    	{
    		for(int i = 0; i < Config.replaceCopper.length; ++i)
    		{
    			ReplaceOre(Config.replaceCopper[i], blockCopper);
    		}
    	}
    	
    	if(config.enableTin)
    	{
    		for(int i = 0; i < Config.replaceTin.length; ++i)
    		{
    			ReplaceOre(Config.replaceTin[i], blockTin);
    		}
    	}
    	
    	if(config.enableLead)
    	{
    		for(int i = 0; i < Config.replaceLead.length; ++i)
    		{
    			ReplaceOre(Config.replaceLead[i], blockLead);
    		}
    	}
    	
    	if(config.enableSilver)
    	{
    		for(int i = 0; i < Config.replaceSilver.length; ++i)
    		{
    			ReplaceOre(Config.replaceSilver[i], blockSilver);
    		}
    	}
    	
    	// Add some mod compatibility recipes if they're loaded.
    	
    	// IndustrialCraft
    	if(Loader.isModLoaded("IC2"))
    	{
    		Compat_IC2 = new IC2();
    	}
    }
    
    @EventHandler
    public void load(FMLInitializationEvent fEvent)
    {
    	// Add Ore Chunks
    	// Iron
    	itemIron = new Item_Chunk(config.itemIron, "orechunks.iron", "ironchunk");
        GameRegistry.registerItem(itemIron, "chunkIron");
        OreDictionary.registerOre("oreIron", new ItemStack(itemIron));
        // Gold
        itemGold = new Item_Chunk(config.itemGold, "orechunks.gold", "goldchunk");
        GameRegistry.registerItem(itemGold, "chunkGold");
        OreDictionary.registerOre("oreGold", new ItemStack(itemGold));
        
        // Mod Chunks
        // Copper
        itemCopper = new Item_Chunk(config.itemCopper, "orechunks.copper", "copperchunk");
        GameRegistry.registerItem(itemCopper, "chunkCopper");
        OreDictionary.registerOre("oreCopper", new ItemStack(itemCopper));
        // Tin
        itemTin = new Item_Chunk(config.itemTin, "orechunks.tin", "tinchunk");
        GameRegistry.registerItem(itemTin, "chunkTin");
        OreDictionary.registerOre("oreTin", new ItemStack(itemTin));
        // Lead
        itemLead = new Item_Chunk(config.itemLead, "orechunks.lead", "leadchunk");
        GameRegistry.registerItem(itemLead, "chunkLead");
        OreDictionary.registerOre("oreLead", new ItemStack(itemLead));
        // Silver
        itemSilver = new Item_Chunk(config.itemSilver, "orechunks.silver", "silverchunk");
        GameRegistry.registerItem(itemSilver, "chunkSilver");
        OreDictionary.registerOre("oreSilver", new ItemStack(itemSilver));
        
        // Set up our new Iron and Gold Items for smelting.
        ItemStack stackIron = new ItemStack(Item.ingotIron, 1);
        ItemStack stackGold = new ItemStack(Item.ingotGold, 1);
        GameRegistry.addSmelting(itemIron.itemID, stackIron, 0);
        GameRegistry.addSmelting(itemGold.itemID, stackGold, 0);
        

        // Blocks
        // Iron
        blockIron = new Block_Ore(config.blockIron, "iron_ore", "iron_ore", itemIron.itemID, config.countIron, 3.0F, 1, 3);
        GameRegistry.registerBlock(blockIron, "oreIron");
        MinecraftForge.setBlockHarvestLevel(blockIron, "pickaxe", 1);
        OreDictionary.registerOre("oreIron", new ItemStack(blockIron));
        
        // Gold
        blockGold = new Block_Ore(config.blockGold, "gold_ore", "gold_ore", itemGold.itemID, config.countGold, 3.0F, 2, 5);
        GameRegistry.registerBlock(blockGold, "oreGold");
        MinecraftForge.setBlockHarvestLevel(blockGold, "pickaxe", 2);
        OreDictionary.registerOre("oreGold", new ItemStack(blockGold));
        
        // Copper
        blockCopper = new Block_Ore(config.blockCopper, "copper_ore", "FortuneOres:copper_ore", itemCopper.itemID, config.countCopper, 3.0F, 1, 3);
        GameRegistry.registerBlock(blockCopper, "oreCopper");
        MinecraftForge.setBlockHarvestLevel(blockCopper, "pickaxe", 1);
        OreDictionary.registerOre("oreCopper", new ItemStack(blockCopper));
        
        // Tin
        blockTin = new Block_Ore(config.blockTin, "tin_ore", "FortuneOres:tin_ore", itemTin.itemID, config.countTin, 3.0F, 1, 3);
        GameRegistry.registerBlock(blockTin, "oreTin");
        MinecraftForge.setBlockHarvestLevel(blockTin, "pickaxe", 1);
        OreDictionary.registerOre("oreTin", new ItemStack(blockTin));
        
        // Lead
        blockLead = new Block_Ore(config.blockLead, "lead_ore", "FortuneOres:lead_ore", itemLead.itemID, config.countLead, 3.0F, 1, 3);
        GameRegistry.registerBlock(blockLead, "oreLead");
        MinecraftForge.setBlockHarvestLevel(blockLead, "pickaxe", 2);
        OreDictionary.registerOre("oreLead", new ItemStack(blockLead));
        
        // Silver
        blockSilver = new Block_Ore(config.blockSilver, "silver_ore", "FortuneOres:silver_ore", itemSilver.itemID, config.countSilver, 3.0F, 2, 5);
        GameRegistry.registerBlock(blockSilver, "oreSilver");
        MinecraftForge.setBlockHarvestLevel(blockSilver, "pickaxe", 2);
        OreDictionary.registerOre("oreSilver", new ItemStack(blockSilver));
    }
    
    private void ReplaceOre(int fBlockID, Block fNewBlock)
    {
    	Block.blocksList[fBlockID] = null;
    	Block.blocksList[fBlockID] = fNewBlock;
    }
}

package com.demoxin.minecraft.fortuneores;

import java.util.ArrayList;

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
	public static final String VERSION = "1.0";
	// Mod Info End
	
	// Singleton
	@Instance("FortuneOres")
	public static FortuneOres instance;
	
	// Config
	public static Config config;
	
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
    public void load(FMLInitializationEvent fEvent)
    {
    	AddItems();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent fEvent)
    {
    	AddSmelting();
    	MinecraftForge.EVENT_BUS.register(new OreSwapper());
    	// Add some mod compatibility recipes if they're loaded.
    	
    	// IndustrialCraft2
    	if(Loader.isModLoaded("IC2"))
    	{
    		Compat_IC2 = new IC2();
    	}
    }
    
    private void AddItems()
    {
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
    }
    
    private void AddSmelting()
    {
    	// Vanilla Smelting
        ItemStack stackIron = new ItemStack(Item.ingotIron, 1);
        ItemStack stackGold = new ItemStack(Item.ingotGold, 1);
        GameRegistry.addSmelting(itemIron.itemID, stackIron, 0);
        GameRegistry.addSmelting(itemGold.itemID, stackGold, 0);
        
        // Mod Chunks
        // Copper
        ArrayList<ItemStack> copperIngots = OreDictionary.getOres("ingotCopper");
        if(!copperIngots.isEmpty())
        {
        	// We have copper ingots registered.
        	ItemStack stackCopper = copperIngots.get(0);
        	GameRegistry.addSmelting(itemCopper.itemID, stackCopper, 0);
        }
        
        // Tin
        ArrayList<ItemStack> tinIngots = OreDictionary.getOres("ingotTin");
        if(!tinIngots.isEmpty())
        {
        	// We have copper ingots registered.
        	ItemStack stackTin = tinIngots.get(0);
        	GameRegistry.addSmelting(itemTin.itemID, stackTin, 0);
        }
        
        // Lead
        ArrayList<ItemStack> leadIngots = OreDictionary.getOres("ingotLead");
        if(!leadIngots.isEmpty())
        {
        	// We have copper ingots registered.
        	ItemStack stackLead = leadIngots.get(0);
        	GameRegistry.addSmelting(itemLead.itemID, stackLead, 0);
        }
        
        // Lead
        ArrayList<ItemStack> silverIngots = OreDictionary.getOres("ingotSilver");
        if(!silverIngots.isEmpty())
        {
        	// We have copper ingots registered.
        	ItemStack stackSilver = silverIngots.get(0);
        	GameRegistry.addSmelting(itemSilver.itemID, stackSilver, 0);
        }
    }
}

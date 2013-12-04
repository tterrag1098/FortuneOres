package com.demoxin.minecraft.fortuneores;

import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
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
	public static final String VERSION = "1.2";
	// Mod Info End
	
	// Singleton
	@Instance("FortuneOres")
	public static FortuneOres instance;
	
	// Config
	public static Config config;
	
	// Creative Tab
	public static CreativeTabs oreChunks;
	
	// Items
	public static Item itemIron;
	public static Item itemGold;
	// Mod Items
	public static Item itemCopper;
	public static Item itemTin;
	public static Item itemLead;
	public static Item itemSilver;
	// More Mods
    public static Item itemNickel;
    public static Item itemAluminum;
    public static Item itemCobalt;
    public static Item itemArdite;
    // Metallurgy Base Metals
    public static Item itemManganese;
    public static Item itemZinc;
    public static Item itemPlatinum;
	
	// Mod Setup
	public static IC2 Compat_IC2;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent fEvent)
    {
    	config = new Config(new Configuration(fEvent.getSuggestedConfigurationFile()));
    	
    	// Create our creative tab.
    	oreChunks = new CTabChunks(CreativeTabs.getNextID(), "OreChunks");
    	// Add Chunks
    	AddItems();
    	// Recipes
    	AddSmelting();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent fEvent)
    {
    	// HarvestDropsEvent Handler
    	MinecraftForge.EVENT_BUS.register(new OreSwapper());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent fEvent)
    {
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
        
        // Mod Mod Chunks
        // Nickel/Ferrous
        itemNickel = new Item_Chunk(config.itemNickel, "orechunks.nickel", "nickelchunk");
        GameRegistry.registerItem(itemNickel, "chunkNickel");
        OreDictionary.registerOre("oreNickel", new ItemStack(itemNickel));
        // Aluminum
        itemAluminum = new Item_Chunk(config.itemAluminum, "orechunks.aluminum", "aluminumchunk");
        GameRegistry.registerItem(itemAluminum, "chunkAluminum");
        OreDictionary.registerOre("oreAluminum", new ItemStack(itemAluminum));
        OreDictionary.registerOre("oreAluminium", new ItemStack(itemAluminum));
        OreDictionary.registerOre("oreNaturalAluminum", new ItemStack(itemAluminum));
        // Cobalt
        itemCobalt = new Item_Chunk(config.itemCobalt, "orechunks.cobalt", "cobaltchunk");
        GameRegistry.registerItem(itemCobalt, "chunkCobalt");
        OreDictionary.registerOre("oreCobalt", new ItemStack(itemCobalt));
        // Ardite
        itemArdite = new Item_Chunk(config.itemArdite, "orechunks.ardite", "arditechunk");
        GameRegistry.registerItem(itemArdite, "chunkArdite");
        OreDictionary.registerOre("oreArdite", new ItemStack(itemArdite));
        
        // Metallurgy
        // Manganese
        itemManganese = new Item_Chunk(config.itemManganese, "orechunks.manganese", "manganesechunk");
        GameRegistry.registerItem(itemManganese, "chunkManganese");
        OreDictionary.registerOre("oreManganese", new ItemStack(itemManganese));
        // Zinc
        itemZinc = new Item_Chunk(config.itemZinc, "orechunks.zinc", "zincchunk");
        GameRegistry.registerItem(itemZinc, "chunkZinc");
        OreDictionary.registerOre("oreZinc", new ItemStack(itemZinc));
        // Platinum
        itemPlatinum = new Item_Chunk(config.itemPlatinum, "orechunks.platinum", "platinumchunk");
        GameRegistry.registerItem(itemPlatinum, "chunkPlatinum");
        OreDictionary.registerOre("orePlatinum", new ItemStack(itemPlatinum));
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
        	// We have tin ingots registered.
        	ItemStack stackTin = tinIngots.get(0);
        	GameRegistry.addSmelting(itemTin.itemID, stackTin, 0);
        }
        
        // Lead
        ArrayList<ItemStack> leadIngots = OreDictionary.getOres("ingotLead");
        if(!leadIngots.isEmpty())
        {
        	// We have lead ingots registered.
        	ItemStack stackLead = leadIngots.get(0);
        	GameRegistry.addSmelting(itemLead.itemID, stackLead, 0);
        }
        
        // Silver
        ArrayList<ItemStack> silverIngots = OreDictionary.getOres("ingotSilver");
        if(!silverIngots.isEmpty())
        {
        	// We have silver ingots registered.
        	ItemStack stackSilver = silverIngots.get(0);
        	GameRegistry.addSmelting(itemSilver.itemID, stackSilver, 0);
        }
        
        // Nickel
        ArrayList<ItemStack> nickelIngots = OreDictionary.getOres("ingotNickel");
        if(!nickelIngots.isEmpty())
        {
        	// We have nickel ingots registered.
        	ItemStack stackNickel = nickelIngots.get(0);
        	GameRegistry.addSmelting(itemNickel.itemID, stackNickel, 0);
        }
        
        // Aluminum
        ArrayList<ItemStack> aluminumIngots = OreDictionary.getOres("ingotNaturalAluminum");
        if(!aluminumIngots.isEmpty())
        {
        	// We have aluminum ingots registered.
        	ItemStack stackAluminum = aluminumIngots.get(0);
        	GameRegistry.addSmelting(itemAluminum.itemID, stackAluminum, 0);
        }
        
        // Cobalt
        ArrayList<ItemStack> cobaltIngots = OreDictionary.getOres("ingotCobalt");
        if(!cobaltIngots.isEmpty())
        {
        	// We have cobalt ingots registered.
        	ItemStack stackCobalt = cobaltIngots.get(0);
        	GameRegistry.addSmelting(itemCobalt.itemID, stackCobalt, 0);
        }
        
        // Ardite
        ArrayList<ItemStack> arditeIngots = OreDictionary.getOres("ingotArdite");
        if(!arditeIngots.isEmpty())
        {
        	// We have ardite ingots registered.
        	ItemStack stackArdite = arditeIngots.get(0);
        	GameRegistry.addSmelting(itemArdite.itemID, stackArdite, 0);
        }
        
        // Manganese
        ArrayList<ItemStack> manganeseIngots = OreDictionary.getOres("ingotManganese");
        if(!manganeseIngots.isEmpty())
        {
        	// We have manganese ingots registered.
        	ItemStack stackManganese = manganeseIngots.get(0);
        	GameRegistry.addSmelting(itemManganese.itemID, stackManganese, 0);
        }
        
        // Zinc
        ArrayList<ItemStack> zincIngots = OreDictionary.getOres("ingotZinc");
        if(!zincIngots.isEmpty())
        {
        	// We have zinc ingots registered.
        	ItemStack stackZinc = zincIngots.get(0);
        	GameRegistry.addSmelting(itemZinc.itemID, stackZinc, 0);
        }
        
        // Platinum
        ArrayList<ItemStack> platinumIngots = OreDictionary.getOres("ingotPlatinum");
        if(!platinumIngots.isEmpty())
        {
        	// We have platinum ingots registered.
        	ItemStack stackPlatinum = platinumIngots.get(0);
        	GameRegistry.addSmelting(itemPlatinum.itemID, stackPlatinum, 0);
        }
    }
}

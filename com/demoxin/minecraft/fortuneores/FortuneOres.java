package com.demoxin.minecraft.fortuneores;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = FortuneOres.MODID, name = FortuneOres.NAME, version = FortuneOres.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FortuneOres {
	// Mod Info
	public static final String MODID = "FortuneOres";
	public static final String NAME = "FortuneOres";
	public static final String VERSION = "0.1";
	// Mod Info End
	
	// Singleton
	@Instance("FortuneOres")
	public static FortuneOres instance;
	
	// Config
	public static Config config;
	
	// Blocks
	public static Block oreIron;
	public static Block oreGold;
	
	// Items
	public static Item chunkIron;
	public static Item chunkGold;
    
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent fEvent)
    {
    	config = new Config(new Configuration(fEvent.getSuggestedConfigurationFile()));
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent fEvent) {}
    
    @EventHandler
    public void load(FMLInitializationEvent fEvent)
    {
        // Take over vanilla iron
	    Block.blocksList[Block.oreIron.blockID] = null;
	    oreIron = new Block_IronOre(Block.oreIron.blockID, Material.rock);
	    GameRegistry.registerBlock(oreIron, "oreIron");
	    MinecraftForge.setBlockHarvestLevel(oreIron, "pickaxe", 1);
	    Block.blocksList[Block.oreIron.blockID] = oreIron;
	    OreDictionary.registerOre("oreIron", new ItemStack(oreIron));
        
        // Add Iron Chunks
        chunkIron = new Item_IronChunk(config.itemIronChunkID);
        GameRegistry.registerItem(chunkIron, "chunkIron");
        LanguageRegistry.addName(chunkIron, "Iron Chunk");
        OreDictionary.registerOre("oreIron", new ItemStack(chunkIron));
        
        
        // Take over vanilla gold
	    Block.blocksList[Block.oreGold.blockID] = null;
	    oreGold = new Block_GoldOre(Block.oreGold.blockID, Material.rock);
	    GameRegistry.registerBlock(oreGold, "oreGold");
	    MinecraftForge.setBlockHarvestLevel(oreGold, "pickaxe", 2);
	    Block.blocksList[Block.oreGold.blockID] = oreGold;
	    OreDictionary.registerOre("oreGold", new ItemStack(oreGold));
        
        // Add gold chunks
        chunkGold = new Item_GoldChunk(config.itemGoldChunkID);
        GameRegistry.registerItem(chunkGold, "chunkGold");
        LanguageRegistry.addName(chunkGold, "Gold Chunk");
        OreDictionary.registerOre("oreGold", new ItemStack(chunkGold));
        
        // Materials
        ItemStack stackIron = new ItemStack(Item.ingotIron, 1);
        ItemStack stackGold = new ItemStack(Item.ingotGold, 1);
        
        // Smelting
        GameRegistry.addSmelting(chunkIron.itemID, stackIron, 0.2f);
        GameRegistry.addSmelting(chunkGold.itemID, stackGold, 0.2f);
    }
}

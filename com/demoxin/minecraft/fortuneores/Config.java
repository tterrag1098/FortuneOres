package com.demoxin.minecraft.fortuneores;

import net.minecraftforge.common.Configuration;

public class Config
{
    private int defaultItemID = 1200;
    private int defaultBlockID = 700;
    
    // Block IDs
    public final int blockIron;
    public final int blockGold;
    public final int blockCopper;
    public final int blockTin;
    public final int blockLead;
    public final int blockSilver;
    
    // Item Chunks 
    public final int itemIron;
    public final int itemGold;
    // Mod Ores
    // Common
    public final int itemCopper;
    public final int itemTin;
    public final int itemLead;
    public final int itemSilver;
    
    // Drop Rates
    public final int countIron;
    public final int countGold;
    // Mod Ores
    // Common
    public final int countCopper;
    public final int countTin;
    public final int countLead;
    public final int countSilver;
    
    // Enable Chunk Drops
    public final boolean enableIron;
    public final boolean enableGold;
    // Mod Ores
    // Common
    public final boolean enableCopper;
    public final boolean enableTin;
    public final boolean enableLead;
    public final boolean enableSilver;
    
    public static int[] replaceCopper;
	public static int[] replaceTin;
	public static int[] replaceLead;
	public static int[] replaceSilver;
 
    public Config(Configuration config)
    {
        config.load();
        
        // Iron
        enableIron = config.get("Iron", "Enable", true).getBoolean(true);
        itemIron = config.get("Iron", "ItemID", defaultItemID).getInt(defaultItemID);
        blockIron = config.get("Iron", "BlockID", defaultBlockID).getInt(defaultBlockID);
        countIron = config.get("Iron", "BaseDrop", 1).getInt(1);
        
        // Gold
        enableGold = config.get("Gold", "Enable", true).getBoolean(true);
        itemGold = config.get("Gold", "ItemID", defaultItemID+1).getInt(defaultItemID+1);
        blockGold = config.get("Gold", "BlockID", defaultBlockID+1).getInt(defaultBlockID+1);
        countGold = config.get("Gold", "BaseDrop", 1).getInt(1);
        
        // Copper
        enableCopper = config.get("Copper", "Enable", true).getBoolean(true);
        itemCopper = config.get("Copper", "ItemID", defaultItemID+2).getInt(defaultItemID+2);
        blockCopper = config.get("Copper", "BlockID", defaultBlockID+2).getInt(defaultBlockID+2);
        countCopper = config.get("Copper", "BaseDrop", 1).getInt(1);
        
        // Tin
        enableTin = config.get("Tin", "Enable", true).getBoolean(true);
        itemTin = config.get("Tin", "ItemID", defaultItemID+3).getInt(defaultItemID+3);
        blockTin = config.get("Tin", "BlockID", defaultBlockID+3).getInt(defaultBlockID+3);
        countTin = config.get("Tin", "BaseDrop", 1).getInt(1);
        
        // Lead
        enableLead = config.get("Lead", "Enable", true).getBoolean(true);
        itemLead = config.get("Lead", "ItemID", defaultItemID+4).getInt(defaultItemID+4);
        blockLead = config.get("Lead", "BlockID", defaultBlockID+4).getInt(defaultBlockID+4);
        countLead = config.get("Lead", "BaseDrop", 1).getInt(1);
        
        // Silver
        enableSilver = config.get("Silver", "Enable", true).getBoolean(true);
        itemSilver = config.get("Silver", "ItemID", defaultItemID+5).getInt(defaultItemID+5);
        blockSilver = config.get("Silver", "BlockID", defaultBlockID+5).getInt(defaultBlockID+5);
        countSilver = config.get("Silver", "BaseDrop", 1).getInt(1);
        
        // Replacement
        String[] aWorking;
        aWorking = (config.get("Replace", "Copper", "4000").getString()).split(",");
        replaceCopper = new int[aWorking.length];
        for(int i = 0; i < aWorking.length; ++i)
        {
        	replaceCopper[i] = Integer.parseInt(aWorking[i]);
        }
        
        aWorking = (config.get("Replace", "Tin", "4001").getString()).split(",");
        replaceTin = new int[aWorking.length];
        for(int i = 0; i < aWorking.length; ++i)
        {
        	replaceTin[i] = Integer.parseInt(aWorking[i]);
        }
        
        aWorking = (config.get("Replace", "Lead", "4003").getString()).split(",");
        replaceLead = new int[aWorking.length];
        for(int i = 0; i < aWorking.length; ++i)
        {
        	replaceLead[i] = Integer.parseInt(aWorking[i]);
        }
        
        aWorking = (config.get("Replace", "Silver", "4095").getString()).split(",");
        replaceSilver = new int[aWorking.length];
        for(int i = 0; i < aWorking.length; ++i)
        {
        	replaceSilver[i] = Integer.parseInt(aWorking[i]);
        }
       
        if(config.hasChanged())
        {
            config.save();
        }
    }
}
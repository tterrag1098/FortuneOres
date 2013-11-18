package com.demoxin.minecraft.fortuneores;

import net.minecraftforge.common.Configuration;

public class Config
{
    private int defaultItemID = 1200;
    
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
 
    public Config(Configuration config)
    {
        config.load();
        
        // Iron
        enableIron = config.get("Iron", "Enable", true).getBoolean(true);
        itemIron = config.get("Iron", "ItemID", defaultItemID).getInt(defaultItemID);
        countIron = config.get("Iron", "BaseDrop", 1).getInt(1);
        
        // Gold
        enableGold = config.get("Gold", "Enable", true).getBoolean(true);
        itemGold = config.get("Gold", "ItemID", defaultItemID+1).getInt(defaultItemID+1);
        countGold = config.get("Gold", "BaseDrop", 1).getInt(1);
        
        // Copper
        enableCopper = config.get("Copper", "Enable", true).getBoolean(true);
        itemCopper = config.get("Copper", "ItemID", defaultItemID+2).getInt(defaultItemID+2);
        countCopper = config.get("Copper", "BaseDrop", 1).getInt(1);
        
        // Tin
        enableTin = config.get("Tin", "Enable", true).getBoolean(true);
        itemTin = config.get("Tin", "ItemID", defaultItemID+3).getInt(defaultItemID+3);
        countTin = config.get("Tin", "BaseDrop", 1).getInt(1);
        
        // Lead
        enableLead = config.get("Lead", "Enable", true).getBoolean(true);
        itemLead = config.get("Lead", "ItemID", defaultItemID+4).getInt(defaultItemID+4);
        countLead = config.get("Lead", "BaseDrop", 1).getInt(1);
        
        // Silver
        enableSilver = config.get("Silver", "Enable", true).getBoolean(true);
        itemSilver = config.get("Silver", "ItemID", defaultItemID+5).getInt(defaultItemID+5);
        countSilver = config.get("Silver", "BaseDrop", 1).getInt(1);
               
        if(config.hasChanged())
        {
            config.save();
        }
    }
}
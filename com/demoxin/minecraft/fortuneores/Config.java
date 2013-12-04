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
    // More Mods
    public final int itemNickel;
    public final int itemAluminum;
    public final int itemCobalt;
    public final int itemArdite;
    // Metallurgy Base Metals
    public final int itemManganese;
    public final int itemZinc;
    public final int itemPlatinum;
    
    // Drop Rates
    public final int countIron;
    public final int countGold;
    // Mod Ores
    // Common
    public final int countCopper;
    public final int countTin;
    public final int countLead;
    public final int countSilver;
    // More Mods
    public final int countNickel;
    public final int countAluminum;
    public final int countCobalt;
    public final int countArdite;
    // Metallurgy Base Metals
    public final int countManganese;
    public final int countZinc;
    public final int countPlatinum;
    
    // Enable Chunk Drops
    public final boolean enableIron;
    public final boolean enableGold;
    // Mod Ores
    // Common
    public final boolean enableCopper;
    public final boolean enableTin;
    public final boolean enableLead;
    public final boolean enableSilver;
    // More Mods
    public final boolean enableNickel;
    public final boolean enableAluminum;
    public final boolean enableCobalt;
    public final boolean enableArdite;
    // Metallurgy Base Metals
    public final boolean enableManganese;
    public final boolean enableZinc;
    public final boolean enablePlatinum;
 
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
        
        // Nickel/Ferrous
        enableNickel = config.get("Nickel", "Enable", true).getBoolean(true);
        itemNickel = config.get("Nickel", "ItemID", defaultItemID+6).getInt(defaultItemID+6);
        countNickel = config.get("Nickel", "BaseDrop", 1).getInt(1);
        
        // Aluminum
        enableAluminum = config.get("Aluminum", "Enable", true).getBoolean(true);
        itemAluminum = config.get("Aluminum", "ItemID", defaultItemID+7).getInt(defaultItemID+7);
        countAluminum = config.get("Aluminum", "BaseDrop", 1).getInt(1);
        
        // Cobalt
        enableCobalt = config.get("Cobalt", "Enable", true).getBoolean(true);
        itemCobalt = config.get("Cobalt", "ItemID", defaultItemID+8).getInt(defaultItemID+8);
        countCobalt = config.get("Cobalt", "BaseDrop", 1).getInt(1);
        
        // Ardite
        enableArdite = config.get("Ardite", "Enable", true).getBoolean(true);
        itemArdite = config.get("Ardite", "ItemID", defaultItemID+9).getInt(defaultItemID+9);
        countArdite = config.get("Ardite", "BaseDrop", 1).getInt(1);
        
        // Manganese
        enableManganese = config.get("Manganese", "Enable", true).getBoolean(true);
        itemManganese = config.get("Manganese", "ItemID", defaultItemID+10).getInt(defaultItemID+10);
        countManganese = config.get("Manganese", "BaseDrop", 1).getInt(1);
        
        // Zinc
        enableZinc = config.get("Zinc", "Enable", true).getBoolean(true);
        itemZinc = config.get("Zinc", "ItemID", defaultItemID+11).getInt(defaultItemID+11);
        countZinc = config.get("Zinc", "BaseDrop", 1).getInt(1);
        
        // Platinum
        enablePlatinum = config.get("Platinum", "Enable", true).getBoolean(true);
        itemPlatinum = config.get("Platinum", "ItemID", defaultItemID+12).getInt(defaultItemID+2);
        countPlatinum = config.get("Platinum", "BaseDrop", 1).getInt(1);
               
        if(config.hasChanged())
        {
            config.save();
        }
    }
}
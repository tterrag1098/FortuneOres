package com.demoxin.minecraft.fortuneores;

import net.minecraftforge.common.Configuration;

public class Config
{
    private int defaultItemID = 1200;
 
    public final int itemIronChunkID;
    public final int itemGoldChunkID;
    
    public final boolean IC2Recipes;
 
    public Config(Configuration config)
    {
        config.load();
       
        itemIronChunkID = config.get("items", "itemIronChunkID", defaultItemID).getInt(defaultItemID);
        itemGoldChunkID = config.get("items", "itemGoldChunkID", defaultItemID + 1).getInt(defaultItemID + 1);
        
        // Mod Compatibility
        IC2Recipes = config.get("Mods", "IC2", false).getBoolean(false);
       
        if( config.hasChanged() )
        {
            config.save();
        }
    }
}
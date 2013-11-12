package com.demoxin.minecraft.fortuneores;

import net.minecraftforge.common.Configuration;

public class Config
{
    private int defaultItemID = 1200;
 
    public final int itemIronChunkID;
    public final int itemGoldChunkID;
    
    public final int countIronChunks;
    public final int countGoldChunks;
 
    public Config(Configuration config)
    {
        config.load();
       
        itemIronChunkID = config.get("items", "itemIronChunkID", defaultItemID).getInt(defaultItemID);
        itemGoldChunkID = config.get("items", "itemGoldChunkID", defaultItemID + 1).getInt(defaultItemID + 1);
        
        countIronChunks = config.get("drops", "BaseIronChunkDrop", 1).getInt();
        countGoldChunks = config.get("drops", "BaseGoldChunkDrop", 1).getInt();
       
        if( config.hasChanged() )
        {
            config.save();
        }
    }
}
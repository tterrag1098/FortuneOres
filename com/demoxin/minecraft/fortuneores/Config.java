package com.demoxin.minecraft.fortuneores;

import net.minecraftforge.common.Configuration;

public class Config
{
    private int defaultBlockID = 850;
    private int defaultItemID = 1200;
 
    public final int blockIronOreID;
    public final int blockGoldOreID;
    public final int itemIronChunkID;
    public final int itemGoldChunkID;
 
    public Config(Configuration config)
    {
        config.load();
       
        blockIronOreID = config.get("blocks", "blockIronOreID", defaultBlockID).getInt(defaultBlockID);
        blockGoldOreID = config.get("blocks", "blockGoldOreID", defaultBlockID + 1).getInt(defaultBlockID + 1);
        itemIronChunkID = config.get("items", "itemIronChunkID", defaultItemID).getInt(defaultItemID);
        itemGoldChunkID = config.get("items", "itemGoldChunkID", defaultItemID + 1).getInt(defaultItemID + 1);;
       
        if( config.hasChanged() )
        {
            config.save();
        }
    }
}
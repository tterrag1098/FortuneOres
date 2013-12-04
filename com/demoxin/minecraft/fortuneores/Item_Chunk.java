package com.demoxin.minecraft.fortuneores;

import net.minecraft.item.Item;

public class Item_Chunk extends Item
{
	public Item_Chunk(int fID, String fName, String fTexture)
    {
        super(fID);
        
        setMaxStackSize(64);
        setCreativeTab(FortuneOres.oreChunks);
        setUnlocalizedName(fName);
        
        // Texture
        this.setTextureName(FortuneOres.NAME + ":" + fTexture);
    }
}

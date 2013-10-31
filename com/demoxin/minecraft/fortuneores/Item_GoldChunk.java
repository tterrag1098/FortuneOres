package com.demoxin.minecraft.fortuneores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Item_GoldChunk extends Item
{
	public Item_GoldChunk(int fID)
    {
        super(fID);
        
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("chunkGold");
        
        // Texture
        this.setTextureName(FortuneOres.NAME + ":goldchunk");
    }
}


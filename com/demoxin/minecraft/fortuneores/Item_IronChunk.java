package com.demoxin.minecraft.fortuneores;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Item_IronChunk extends Item
{
	public Item_IronChunk(int fID)
    {
        super(fID);
        
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("chunkIron");
        
        // Texture
        this.setTextureName(FortuneOres.NAME + ":ironchunk");
    }
}

package com.demoxin.minecraft.fortuneores;

import net.minecraft.creativetab.CreativeTabs;

public class CTabChunks extends CreativeTabs {
	public CTabChunks(int fID, String fName) { super(fID, fName); }
	
	@Override
	public int getTabIconItemIndex() {
		return FortuneOres.itemIron.itemID;
	}
}

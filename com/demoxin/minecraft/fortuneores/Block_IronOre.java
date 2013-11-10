package com.demoxin.minecraft.fortuneores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Block_IronOre extends Block {
	public Block_IronOre(int fID, Material fMaterial)
    {
        super(fID, fMaterial);
        
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName("oreIron");
        setTextureName("iron_ore");
        setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return FortuneOres.chunkIron.itemID;
    }
    
    @Override
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return MathHelper.clamp_int(this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1), 1, 3);
    }
    
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
    	super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
    	
    	if(this.idDropped(par5, par1World.rand, par7) != this.blockID)
    	{
    		int xp = MathHelper.getRandomIntegerInRange(par1World.rand, 1, 3);
    		this.dropXpOnBlockBreak(par1World, par2, par3, par4, xp);
    	}
    }
}

package com.demoxin.minecraft.fortuneores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Block_Ore extends Block
{
	private final int DropID;
	private final int DropCount;
	private final int XPMin;
	private final int XPMax;
	
	public Block_Ore(int fID, String fName, String fTexture, int fDrop, int fCount, float fHardness, int fXPMin, int fXPMax)
	{
		super(fID, Material.rock);
		
		setResistance(5.0F);
		setStepSound(soundStoneFootstep);
		
		// Ore Specific
		setUnlocalizedName(fName);
        setTextureName(fTexture);
		setHardness(fHardness);
		
		DropID = fDrop;
		DropCount = fCount;
		XPMin = fXPMin;
		XPMax = fXPMax;
	}
	
	
	// Drops
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return DropID;
    }
	
	@Override
    public int quantityDropped(Random par1Random)
    {
        return DropCount;
    }
	
	@Override
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return MathHelper.clamp_int(this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1), 1, 10);
    }
	
	@Override
    protected boolean canSilkHarvest(){return true;}
	
	// XP
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
    	super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
    	
    	if(this.idDropped(par5, par1World.rand, par7) != this.blockID)
    	{
    		int xp = MathHelper.getRandomIntegerInRange(par1World.rand, XPMin, XPMax);
    		this.dropXpOnBlockBreak(par1World, par2, par3, par4, xp);
    	}
    }
}

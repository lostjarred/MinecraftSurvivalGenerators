package com.aa11lo.survivalgenerators.world.gen;

import java.util.Random;

import com.aa11lo.survivalgenerators.SurvivalGeneratorsMain;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLightPost extends WorldGenerator {
	
	private final IBlockState cobble = Blocks.COBBLESTONE.getDefaultState();
	private final IBlockState glowstone = Blocks.GLOWSTONE.getDefaultState();
	private final IBlockState fence = Blocks.OAK_FENCE.getDefaultState();
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		//finds the ground
		while (worldIn.isAirBlock(position) && position.getY() > 2)
		{
			position = position.down();
		}
		//get x y z values
		int posx = position.getX();
		int posy = position.getY();
		int posz = position.getZ();
		
		SurvivalGeneratorsMain.LOGGER.info("Attempting to spawn light post at" + " " + posx + " " + posy + " " + posz);
		for(int x = posx; x < posx + 3; x++) {
			for(int z = posz; z < posz + 3; z++) {
				worldIn.setBlockState(new BlockPos(x, posy, z), cobble);
			}
		}
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 1), (posz + 1)), fence);
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 2), (posz + 1)), fence);
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 3), (posz + 1)), fence);
		
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 4), (posz + 1)), glowstone, 1);
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 5), (posz + 1)), fence);
		
		//
		worldIn.setBlockState(new BlockPos(posx, (posy + 4), (posz + 1)), fence);
		worldIn.setBlockState(new BlockPos((posx + 2), (posy + 4), (posz + 1)), fence);
		
		worldIn.setBlockState(new BlockPos(posx, (posy + 3), (posz + 1)), fence);
		worldIn.setBlockState(new BlockPos((posx + 2), (posy + 3), (posz + 1)), fence);
		
		worldIn.setBlockState(new BlockPos(posx, (posy + 5), (posz + 1)), fence);
		worldIn.setBlockState(new BlockPos((posx + 2), (posy + 5), (posz + 1)), fence);
		
		//
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 4), (posz)), fence);
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 4), (posz + 2)), fence);
		
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 3), (posz)), fence);
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 3), (posz + 2)), fence);
		
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 5), (posz)), fence);
		worldIn.setBlockState(new BlockPos((posx + 1), (posy + 5), (posz + 2)), fence);
		
		return true;
	}

}

package com.aa11lo.survivalgenerators.world.biome;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

public class BiomeSurvival extends Biome {
	boolean replacestone = false;
	BlockState stonereplacement;
	int blockreplacestopy = 200;
	
	protected BiomeSurvival(Builder biomeBuilder) {
		super(biomeBuilder);
	}
	
	public void setStoneReplacement(BlockState stonereplacementin, int stopheight) {
		this.replacestone = true;
		this.stonereplacement = stonereplacementin;
		this.blockreplacestopy = stopheight;
	}
	
	public void replaceStone(IChunk chunkIn, int x, int y, int z, BlockState stonereplacement, int stopheight) {
		for (int blocky = y; blocky > 0; blocky--) {
			if (blocky > stopheight) {
				BlockPos curblockpos = new BlockPos(x, blocky, z);
				if(chunkIn.getBlockState(curblockpos) == Blocks.STONE.getDefaultState()) {
					chunkIn.setBlockState(curblockpos, stonereplacement, false);
				}
			}
		}
	}
	
	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
		if (this.replacestone) {
			replaceStone(chunkIn, x, startHeight, z, this.stonereplacement, this.blockreplacestopy);
		}
	}
	
}

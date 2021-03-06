package com.aa11lo.survivalgenerators.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;

public class ChunkGeneratorOverworldSurvival extends ChunkGeneratorOverworld implements IChunkGenerator {
	
	private Block stonereplacement;

	public ChunkGeneratorOverworldSurvival(World worldIn, long seed, boolean mapFeaturesEnabledIn,
			String generatorOptions, Block stoneReplacementin) {
		super(worldIn, seed, mapFeaturesEnabledIn, generatorOptions);
		this.stonereplacement = stoneReplacementin;
	}
	
	@Override
	public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn)
    {
		super.replaceBiomeBlocks(x, z, primer, biomesIn);
		
		//chunk position x/z?
		for (int cx = 0; cx < 16; ++cx) {
			for (int cz = 0; cz < 16; ++cz) {
				//need to convert to block pos so times by 16?
				replaceStone(x * 16 + cx, z * 16 + cz, primer, this.stonereplacement);
			}
		}
    }
	
	public void replaceStone(int x, int z, ChunkPrimer chunkin, Block stonereplacement) {
		//bitwise not sure what it is used for
		int x1 = x & 15;
		int z1 = z & 15;
		//top of world 255 stops just before some y value, replace later with variable....
		for (int y =255; y >=20; y--) {
			//debug
			//SurvivalGeneratorsMain.LOGGER.info("Scanning Block at " + x1 + " " + y + " " + z1);
			
			IBlockState scanblock = chunkin.getBlockState(x1, y, z1);
			//check if it is the block to replace
			if(scanblock.getBlock() == Blocks.STONE) {
				//make modular later...
				chunkin.setBlockState(x1, y, z1, stonereplacement.getDefaultState());
				
				//debug
				//logger only to see if it doing something, must comment out later!
				//SurvivalGeneratorsMain.LOGGER.info("Replaced Stone at " + x1 + " " + y + " " + z1);
			}
		}
	}

}

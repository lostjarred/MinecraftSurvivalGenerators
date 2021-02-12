package com.aa11lo.survivalgenerators.world.biome;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeSurvivalSnow extends BiomeSurvival {

	public BiomeSurvivalSnow(String registryname) {
		super(new BiomeProperties(registryname)
				.setTemperature(0.0f)
				.setRainfall(0.9f)
				.setSnowEnabled()
				);
		this.topBlock = Blocks.SNOW.getDefaultState();
		this.fillerBlock = Blocks.SNOW.getDefaultState();
		this.setRegistryName(registryname);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		
		BiomeDecorator survialbiomedecorator = new BiomeDecoratorSurvival();
		
		survialbiomedecorator.treesPerChunk=0;
		survialbiomedecorator.flowersPerChunk=0;
		survialbiomedecorator.grassPerChunk=0;
		
		return survialbiomedecorator;
		
	}

}

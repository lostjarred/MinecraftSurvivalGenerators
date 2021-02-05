package com.aa11lo.survivalgenerators.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeSurvivalSnow extends Biome {

	public BiomeSurvivalSnow(String registryname) {
		super(new BiomeProperties(registryname)
				.setTemperature(0.0f)
				.setRainfall(0.5f)
				.setSnowEnabled()
				);
		this.topBlock = Blocks.SNOW.getDefaultState();
		this.fillerBlock = Blocks.ICE.getDefaultState();
		this.spawnableCreatureList.clear();
		this.setRegistryName(registryname);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		
		BiomeDecorator survialbiomedecorator = new BiomeDecorator();
		
		survialbiomedecorator.treesPerChunk=0;
		survialbiomedecorator.flowersPerChunk=0;
		survialbiomedecorator.grassPerChunk=0;
		
		return survialbiomedecorator;
		
	}
}

package com.aa11lo.survivalgenerators.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;


public class BiomeSurvivalSnow extends BiomeSurvival {

	public BiomeSurvivalSnow(String registryname) {
		super(new BiomeProperties(registryname)
				.setTemperature(0.0f)
				.setRainfall(0.9f)
				.setSnowEnabled()
				.setBaseHeight(0.45f)
				.setHeightVariation(0.3F)
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

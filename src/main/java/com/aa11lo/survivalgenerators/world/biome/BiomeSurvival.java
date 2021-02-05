package com.aa11lo.survivalgenerators.world.biome;

import net.minecraft.world.biome.Biome;

public class BiomeSurvival extends Biome {

	public BiomeSurvival(BiomeProperties properties) {
		super(properties);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
	}

}

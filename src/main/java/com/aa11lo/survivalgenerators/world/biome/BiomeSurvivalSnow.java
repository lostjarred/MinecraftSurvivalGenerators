package com.aa11lo.survivalgenerators.world.biome;

import java.util.Random;

import com.aa11lo.survivalgenerators.SurvivalGeneratorsMain;
import com.aa11lo.survivalgenerators.world.gen.WorldGenLightTower;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
    {
		super.decorate(worldIn, rand, pos);
		//spawn tower decoration normally 1000
		if (rand.nextInt(1000) == 0) {
			int i = rand.nextInt(16) + 8;
            int j = rand.nextInt(16) + 8;
            BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
            (new WorldGenLightTower()).generate(worldIn, rand, blockpos);
		}
    }

}

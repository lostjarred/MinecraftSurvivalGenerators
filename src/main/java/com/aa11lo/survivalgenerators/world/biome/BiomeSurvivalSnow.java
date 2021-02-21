package com.aa11lo.survivalgenerators.world.biome;

import java.util.Random;

import com.aa11lo.survivalgenerators.world.gen.surfacebuilder.ModSurfaceBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class BiomeSurvivalSnow extends BiomeSurvival {

	public BiomeSurvivalSnow(String registryname) {
		super(
				(new Biome.Builder()
						.surfaceBuilder(SurfaceBuilder.DEFAULT, ModSurfaceBuilder.SURVIVALSNOWSURFACECONFIG)
						.precipitation(Biome.RainType.SNOW)
						.category(Biome.Category.TAIGA)
						.depth(0.2F)
						.scale(0.2F)
						.temperature(-0.5F)
						.downfall(0.8F)
						.waterColor(4020182)
						.waterFogColor(329011)
						.parent((String)null)
						)
				);
		setRegistryName(registryname);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	}
	@Override
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		super.buildSurface(random, chunkIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed);
		int blockx = x;
		int blockz = z;
		for (int blocky = startHeight; blocky > 0; blocky--) {
			if (blocky > 26) {
				BlockPos curblockpos = new BlockPos(blockx, blocky, blockz);
				if(chunkIn.getBlockState(curblockpos) == Blocks.STONE.getDefaultState()) {
					chunkIn.setBlockState(curblockpos, Blocks.PACKED_ICE.getDefaultState(), false);
				}
			}
		}
	}
}

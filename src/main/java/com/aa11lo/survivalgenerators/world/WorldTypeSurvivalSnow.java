package com.aa11lo.survivalgenerators.world;

import com.aa11lo.survivalgenerators.modinit.ModBiomes;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.OverworldGenSettings;


public class WorldTypeSurvivalSnow extends WorldType{

	public WorldTypeSurvivalSnow(String name) {
		super(name);
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world){
		if(world.getDimension().getType() == DimensionType.OVERWORLD) {
			return ChunkGeneratorType.SURFACE.create(world, 
					BiomeProviderType.FIXED.create(BiomeProviderType.FIXED.createSettings(world.getWorldInfo()).setBiome(ModBiomes.BIOME_SURVIVAL_SNOW)), 
					new OverworldGenSettings());
		}else {
			return super.createChunkGenerator(world);
		}
	}
	
	/*
	@Override
	public BiomeProvider getBiomeProvider(World world) {
		return new BiomeProviderSingle(ModBiomes.BIOME_SURVIVAL_SNOW);
	}
	
	@Override
	public net.minecraft.world.gen.IChunkGenerator getChunkGenerator(World world, String generatorOptions)
    {
		return new ChunkGeneratorOverworldSurvival(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions, Blocks.PACKED_ICE);
    }*/
}

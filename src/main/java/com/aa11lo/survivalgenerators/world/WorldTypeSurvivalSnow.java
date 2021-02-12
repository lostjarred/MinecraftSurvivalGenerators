package com.aa11lo.survivalgenerators.world;

import com.aa11lo.survivalgenerators.modinit.ModBiomes;
import com.aa11lo.survivalgenerators.world.gen.ChunkGeneratorOverworldSurvival;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;

public class WorldTypeSurvivalSnow extends WorldType {

	public WorldTypeSurvivalSnow(String name) {
		super(name);
	}
	
	@Override
	public BiomeProvider getBiomeProvider(World world) {
		return new BiomeProviderSingle(ModBiomes.BIOME_SURVIVAL_SNOW);
	}
	
	@Override
	public net.minecraft.world.gen.IChunkGenerator getChunkGenerator(World world, String generatorOptions)
    {
		return new ChunkGeneratorOverworldSurvival(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions, Blocks.PACKED_ICE);
    }
}

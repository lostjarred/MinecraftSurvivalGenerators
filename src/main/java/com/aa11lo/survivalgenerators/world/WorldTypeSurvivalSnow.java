package com.aa11lo.survivalgenerators.world;

import com.aa11lo.survivalgenerators.modinit.ModBiomes;

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
}

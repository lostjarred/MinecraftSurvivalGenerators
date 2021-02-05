package com.aa11lo.survivalgenerators.modinit;

import com.aa11lo.survivalgenerators.SurvivalGeneratorsMain;
import com.aa11lo.survivalgenerators.world.biome.BiomeSurvivalSnow;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBiomes {
	
	public static void register(IForgeRegistry<Biome> registry) {
		SurvivalGeneratorsMain.LOGGER.info("Starting Biome Register");
		registry.registerAll(
				BIOME_SURVIVAL_SNOW
		
				);
		SurvivalGeneratorsMain.LOGGER.info("Finish Biome Register");
	}
	
	public static final BiomeSurvivalSnow BIOME_SURVIVAL_SNOW = new BiomeSurvivalSnow("biome_survival_snow");
}

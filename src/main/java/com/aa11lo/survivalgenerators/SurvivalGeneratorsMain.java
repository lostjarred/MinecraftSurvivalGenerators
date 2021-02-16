package com.aa11lo.survivalgenerators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aa11lo.survivalgenerators.modinit.ModBiomes;
import com.aa11lo.survivalgenerators.world.WorldTypeSurvivalSnow;
import com.lo93.locore.init.registry.BiomeRegistry;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = SurvivalGeneratorsMain.MODID, name = SurvivalGeneratorsMain.NAME, version = SurvivalGeneratorsMain.VERSION)
	public class SurvivalGeneratorsMain
	{
	    public static final String MODID = "survivalgenerators";
	    public static final String NAME = "Survival Generators";
	    public static final String VERSION = "1.0";

	    public static final Logger LOGGER = LogManager.getLogger(MODID);
	    
	    public static final BiomeRegistry BIOMEREGISTRY = new BiomeRegistry(LOGGER);
	    
	    public static final WorldType SURVIVAL_SNOW_WORLDTYPE = new WorldTypeSurvivalSnow("Survival Snow");
	    
	    @EventHandler
	    public void init(FMLInitializationEvent event)
	    {
	    	LOGGER.info(NAME + " Is loading");
	    }
	    
	    @Mod.EventBusSubscriber
	    public static class RegistrationHandler {
	    	@SubscribeEvent
	    	public static void registerbiomes(RegistryEvent.Register<Biome> event) {
	    		BIOMEREGISTRY.RegisterBiome(event.getRegistry(), ModBiomes.BIOME_SURVIVAL_SNOW);
	    	}
	    }
	}

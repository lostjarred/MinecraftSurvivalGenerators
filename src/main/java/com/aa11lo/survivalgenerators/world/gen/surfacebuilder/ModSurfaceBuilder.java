package com.aa11lo.survivalgenerators.world.gen.surfacebuilder;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModSurfaceBuilder {
	public static final BlockState SNOW = Blocks.SNOW_BLOCK.getDefaultState();
	public static final BlockState PACKEDICE = Blocks.PACKED_ICE.getDefaultState();
	
	public static final SurfaceBuilderConfig SURVIVALSNOWSURFACECONFIG = new SurfaceBuilderConfig(SNOW, SNOW, PACKEDICE);
}

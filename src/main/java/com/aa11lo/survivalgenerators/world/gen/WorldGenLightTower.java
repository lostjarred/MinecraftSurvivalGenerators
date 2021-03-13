package com.aa11lo.survivalgenerators.world.gen;

import java.util.Random;

import com.aa11lo.survivalgenerators.SurvivalGeneratorsMain;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLightTower extends WorldGenerator {
	//blocks used in structure 
	private final IBlockState cobble = Blocks.COBBLESTONE.getDefaultState();
	private final IBlockState stone = Blocks.STONE.getDefaultState();
	private final IBlockState stonebrick = Blocks.STONEBRICK.getDefaultState();
	private final IBlockState stoneslab = Blocks.STONE_SLAB.getDefaultState().withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
	private final IBlockState glowstone = Blocks.GLOWSTONE.getDefaultState();
	private final IBlockState glass = Blocks.GLASS.getDefaultState();
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		//finds the ground
		while (worldIn.isAirBlock(position) && position.getY() > 2)
        {
            position = position.down();
        }
		
		//get x y z values
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		//debug
        SurvivalGeneratorsMain.LOGGER.info("Attempting to spawn light tower at" + " " + x + " " + y + " " + z);
		if (canSpawnHere(worldIn, x, (y + 1), z, 7, 11, 7)) {
			createBase(worldIn, x, y, z);
			createPlatform(worldIn, x, (y + 10), z);
			createTop(worldIn, x, (y + 11), z);
			//debug
            SurvivalGeneratorsMain.LOGGER.info("Spawn Successful");
		}else {
			//debug
            SurvivalGeneratorsMain.LOGGER.info("Spawn Failure");
		}
		return true;
	}
	
	private boolean canSpawnHere(World worldIn, int posx, int posy, int posz, int sizex, int sizey, int sizez) {
		boolean canspawn = true;
		for(int y = posy; y < (posy + sizey); y ++) {
			for(int x = posx; x < (posx + sizex); x ++) {
				for(int z = posz; z < (posz + sizez); z ++) {
					if (worldIn.getBlockState(new BlockPos(x, y, z)) != Blocks.AIR.getDefaultState()) {
						canspawn = false;
						return canspawn;
					}
				}
			}
		}
		return canspawn;
	}
	
	void createBase(World worldIn, int xin, int yin, int zin){
		
		//create support base
		for(int y = (yin - 5); y < yin; y++) {
			for(int x = xin; x < (xin + 7); x++) {
				for(int z = zin; z < (zin + 7); z++) {
					if (worldIn.getBlockState(new BlockPos(x, y, z)) == Blocks.AIR.getDefaultState()) {
						worldIn.setBlockState(new BlockPos(x - 2, y, z - 2), cobble);
					}
				}
			}
		}
		
		//create stone base
		for(int x = xin; x < (xin + 7); x++) {
			for(int z = zin; z < (zin + 7); z++) {
				worldIn.setBlockState(new BlockPos(x - 2, yin, z - 2), stone);
			}
		}
		
		
		//create stonebrick tower
		for(int y = yin; y < (yin + 10); y++) {
			
			for(int x = xin; x < (xin + 3); x++) {
				
				for(int z = zin; z < (zin + 3); z++) {
					worldIn.setBlockState(new BlockPos(x, y, z), stonebrick);
				}
			}
		}
			
	}
	
	
	void createPlatform(World worldIn, int xin, int yin, int zin) {
		//create a platform above stonebrick
		
		//centeral part stonebrick
		for(int x = xin; x < (xin + 3); x++) {
			for(int z = zin; z < (zin + 3); z++) {
				worldIn.setBlockState(new BlockPos(x, yin, z), stonebrick);
			}
		}
		
		//outer edge stone slab
		for(int x = (xin - 1); x < (xin + 4); x++) {
			for(int z = (zin - 1); z < (zin + 4); z++) {
				if (worldIn.getBlockState(new BlockPos(x, yin, z)) == Blocks.AIR.getDefaultState()) {
					worldIn.setBlockState(new BlockPos(x, yin, z), stoneslab);
				}
			}
		}
	}
	
	void createTop(World worldIn, int xin, int yin, int zin) {
		//create glowstone roof thing
		for(int y = yin; y < (yin + 3); y++) {
			for(int x = xin; x < (xin + 3); x++) {
				for(int z = zin; z < (zin + 3); z++) {
					worldIn.setBlockState(new BlockPos(x, y, z), glowstone, 1);
				}
			}
		}
		
		//suround in glass
		for(int y = yin; y < (yin + 4); y++) {
			for(int x = (xin - 1); x < (xin + 4); x++) {
				for(int z = (zin - 1); z < (zin + 4); z++) {
					if (worldIn.getBlockState(new BlockPos(x, y, z)) == Blocks.AIR.getDefaultState()) {
						worldIn.setBlockState(new BlockPos(x, y, z), glass);
					}
				}
			}
		}
	}	
}

package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class PigEggHatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double pigsAmount) {
		boolean found = false;
		double repeat = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		String SuperCoords = "";
		repeat = pigsAmount;
		SuperCoords = x + "/" + y + "/" + z;
		List<String> BlockArray = new ArrayList<String>();
		BlockArray.add(SuperCoords);
		world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(SvinosaModBlocks.PIG_EGG.get().defaultBlockState()));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLASH, x, y, z, 5, 0, 0, 0, 0);
		{
			// Get the radius of the sphere
			double radius = 0.6; // 3 blocks
			// Set the tolerance for how close to the surface a point must be to create a particle
			double tolerance = 0.5; // 0.1 blocks
			for (double xx = -radius; xx <= radius; xx += 0.1) {
				for (double yy = -radius; yy <= radius; yy += 0.1) {
					for (double zz = -radius; zz <= radius; zz += 0.1) {
						if (Math.abs(xx * xx + yy * yy + zz * zz - radius * radius) <= tolerance) {
							// Calculate the position of the particle
							double posX = x + xx;
							double posY = y + yy;
							double posZ = z + zz;
							if ((true)) {
								if (world instanceof ServerLevel)
									((ServerLevel) world).sendParticles(ParticleTypes.BUBBLE_POP, posX, posY, posZ, (int) 1, 0.01, 0.01, 0.01, 0);
							} else {
								world.addParticle(ParticleTypes.BUBBLE_POP, posX, posY, posZ, 0, 0, 0);
							}
						}
					}
				}
			}
		}
		sx = -2;
		for (int index0 = 0; index0 < (int) (5); index0++) {
			sy = -2;
			for (int index1 = 0; index1 < (int) (5); index1++) {
				sz = -2;
				for (int index2 = 0; index2 < (int) (5); index2++) {
					if (world.getBlockState(new BlockPos(x, y - 1, z)).canOcclude() && (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
						SuperCoords = (x + sx) + "/" + (y + sy) + "/" + (z + sz);
						BlockArray.add(SuperCoords);
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		Random r = new Random();
		for (int index3 = 0; index3 < (int) (repeat); index3++) {
			int randomitem = r.nextInt(BlockArray.size());
			SuperCoords = BlockArray.get(randomitem);
			SpawnRandomPigProcedure.execute(world, SplitCoordsStringProcedure.execute(SuperCoords, "x"), SplitCoordsStringProcedure.execute(SuperCoords, "y"), SplitCoordsStringProcedure.execute(SuperCoords, "z"));
		}
	}
}

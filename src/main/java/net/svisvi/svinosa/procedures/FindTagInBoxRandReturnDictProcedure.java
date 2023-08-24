package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class FindTagInBoxRandReturnDictProcedure {
	public static HashMap<String, String> execute(LevelAccessor world, double x, double y, double z, double bx, double by, double bz) {
		boolean found = false;
		List<Object> BlocksArray = new ArrayList<>();
		List<Object> Coords = new ArrayList<>();
		String tagg = "";
		String SuperCoords = "";
		double wx = 0;
		double wy = 0;
		double wz = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double RandBlock = 0;
		wx = bx;
		wy = by;
		wz = bz;
		found = false;
		SuperCoords = x + "/" + y + "/" + z;
		HashMap<String, String> randomBlocks = new HashMap<String, String>();
		randomBlocks.put("Stone", SuperCoords);
		randomBlocks.put("Ores", SuperCoords);
		randomBlocks.put("Pig", SuperCoords);
		randomBlocks.put("PigUpAir", SuperCoords);
		randomBlocks.put("PigDownAir", SuperCoords);
		List<String> StoneArray = new ArrayList<String>();
		List<String> OresArray = new ArrayList<String>();
		List<String> PigArray = new ArrayList<String>();
		List<String> PigUpAirArray = new ArrayList<String>();
		List<String> PigDownAirArray = new ArrayList<String>();
		sx = wx * (-1);
		for (int index0 = 0; index0 < (int) (wx * 2 + 1); index0++) {
			sy = wy * (-1);
			for (int index1 = 0; index1 < (int) (wy * 2 + 1); index1++) {
				sz = wz * (-1);
				for (int index2 = 0; index2 < (int) (wz * 2 + 1); index2++) {
					if (!(sx == 0 && sy == 0 && sz == 0)) {
						SuperCoords = (x + sx) + "/" + (y + sy) + "/" + (z + sz);
						RandBlock = Mth.nextInt(new Random(), 1, 4);
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:stone")))) {
							StoneArray.add(SuperCoords);
						} else if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:ores")))) {
							OresArray.add(SuperCoords);
						} else if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("svinosa:pig_block")))) {
							PigArray.add(SuperCoords);
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == SvinosaModBlocks.BASIC_PIG_ROOTED_BLOCK.get()) {
								if ((world.getBlockState(new BlockPos(x + sx, y + sy + 1, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
									PigUpAirArray.add(SuperCoords);
								}
								if ((world.getBlockState(new BlockPos(x + sx, (y + sy) - 1, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
									PigDownAirArray.add(SuperCoords);
								}
							}
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		Random r = new Random();
		if (!StoneArray.isEmpty()) {
			int randomitem = r.nextInt(StoneArray.size());
			SuperCoords = StoneArray.get(randomitem);
			randomBlocks.put("Stone", SuperCoords);
		}
		if (!OresArray.isEmpty()) {
			int randomitem = r.nextInt(OresArray.size());
			SuperCoords = OresArray.get(randomitem);
			randomBlocks.put("Ores", SuperCoords);
		}
		if (!PigArray.isEmpty()) {
			int randomitem = r.nextInt(PigArray.size());
			SuperCoords = PigArray.get(randomitem);
			randomBlocks.put("Pig", SuperCoords);
		}
		if (!PigUpAirArray.isEmpty()) {
			int randomitem = r.nextInt(PigUpAirArray.size());
			SuperCoords = PigUpAirArray.get(randomitem);
			randomBlocks.put("PigUpAir", SuperCoords);
		}
		if (!PigDownAirArray.isEmpty()) {
			int randomitem = r.nextInt(PigDownAirArray.size());
			SuperCoords = PigDownAirArray.get(randomitem);
			randomBlocks.put("PigDownAir", SuperCoords);
		}
		return randomBlocks;
	}
}

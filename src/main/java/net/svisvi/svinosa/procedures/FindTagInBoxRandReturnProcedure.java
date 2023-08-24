package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.SvinosaMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class FindTagInBoxRandReturnProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, double bx, double by, double bz, String tag) {
		if (tag == null)
			return "";
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
		double zMod = 0;
		double yMod = 0;
		double xMod = 0;
		tagg = tag;
		wx = bx;
		wy = by;
		wz = bz;
		found = false;
		SuperCoords = x + "/" + y + "/" + z;
		List<String> StringArray = new ArrayList<String>();
		sx = wx * (-1);
		for (int index0 = 0; index0 < (int) (wx * 2 + 1); index0++) {
			SvinosaMod.LOGGER.info("sx");
			sy = wy * (-1);
			for (int index1 = 0; index1 < (int) (wy * 2 + 1); index1++) {
				SvinosaMod.LOGGER.info("sy");
				sz = wz * (-1);
				for (int index2 = 0; index2 < (int) (wz * 2 + 1); index2++) {
					SvinosaMod.LOGGER.info("sz");
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation((tagg).toLowerCase(java.util.Locale.ENGLISH))))) {
						SvinosaMod.LOGGER.info("Find Tag: Block is a TAG");
						if (!(sx == 0 && sy == 0 && sz == 0)) {
							SuperCoords = (x + sx) + "/" + (y + sy) + "/" + (z + sz);
							StringArray.add(SuperCoords);
							SvinosaMod.LOGGER.info("FindTag: " + "Block at " + (x + sx) + "/" + (y + sy) + "/" + (z + sz));
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		Random r = new Random();
		if (!StringArray.isEmpty()) {
			int randomitem = r.nextInt(StringArray.size());
			SuperCoords = StringArray.get(randomitem);
		}
		SvinosaMod.LOGGER.info("FindTag: " + tagg + " Block send " + SuperCoords);
		return SuperCoords;
	}
}

package net.svisvi.svinosa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FindTagInBoxProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, double bx, double by, double bz, String tag) {
		if (tag == null)
			return false;
		boolean found = false;
		String tagg = "";
		String retur = "";
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double wx = 0;
		double yx = 0;
		double zx = 0;
		double wy = 0;
		double wz = 0;
		double xMod = 0;
		double yMod = 0;
		double zMod = 0;
		tagg = tag;
		wx = bx;
		wy = by;
		wz = bz;
		found = false;
		sx = wx * (-1);
		for (int index0 = 0; index0 < (int) (wx * 2 + 1); index0++) {
			sy = wy * (-1);
			for (int index1 = 0; index1 < (int) (wy * 2 + 1); index1++) {
				sz = wz * (-1);
				for (int index2 = 0; index2 < (int) (wz * 2 + 1); index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation((tagg).toLowerCase(java.util.Locale.ENGLISH))))) {
						if (sx != 0 && sy != 0 && sz != 0) {
							found = true;
							return true;
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		return false;
	}
}

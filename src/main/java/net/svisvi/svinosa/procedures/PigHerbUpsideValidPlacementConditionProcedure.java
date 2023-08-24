package net.svisvi.svinosa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class PigHerbUpsideValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("svinosa:pig_solid")))) {
			return true;
		}
		return false;
	}
}

package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SweepingVineNeighbourBlockChangedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(new BlockPos(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("svinosa:pig_solid"))) || (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == SvinosaModBlocks.PIG_HERB_SWEEPING_VINES_PLANT.get())) {
			world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(SvinosaModBlocks.PIG_HERB_SWEEPING_VINES_PLANT.get().defaultBlockState()));
			{
				BlockPos _pos = new BlockPos(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}

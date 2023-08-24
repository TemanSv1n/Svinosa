package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class PlacePigWallsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randomer = 0;
		randomer = Mth.nextInt(new Random(), 1, 100);
		if (randomer < 25) {
			world.setBlock(new BlockPos(x, y, z), (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("svinosa:pig_walls_deco"))).getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
		} else if (randomer >= 25 && randomer < 40) {
			world.setBlock(new BlockPos(x, y, z), SvinosaModBlocks.BASIC_PIG_ROOTED_BLOCK.get().defaultBlockState(), 3);
		} else {
			world.setBlock(new BlockPos(x, y, z), SvinosaModBlocks.BASIC_PIG_BLOCK.get().defaultBlockState(), 3);
		}
	}
}

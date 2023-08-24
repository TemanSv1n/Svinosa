package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class PlacePigHerbUpsideProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randomer = 0;
		double power_randomer = 0;
		if ((world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			randomer = Mth.nextInt(new Random(), 1, 100);
			if (randomer < 70) {
				world.setBlock(new BlockPos(x, y, z), (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("svinosa:pig_herb_upside"))).getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
			} else {
				world.setBlock(new BlockPos(x, y, z), SvinosaModBlocks.PIG_HERB_SWEEPING_VINES_PLANT.get().defaultBlockState(), 3);
			}
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SvinosaModBlocks.PIG_HERB_SWEEPING_VINES_PLANT.get()) {
				power_randomer = Mth.nextInt(new Random(), 3, 7);
				{
					int _value = 1;
					BlockPos _pos = new BlockPos(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				PigVineGrowUpProcedure.execute(world, x, y, z, power_randomer, 15, "NONE", "NONE");
			}
		}
	}
}

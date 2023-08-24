package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;
import net.svisvi.svinosa.SvinosaMod;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import com.mojang.blaze3d.shaders.Effect;

public class PigVineGrowUpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double p_lenght, double p_radius_i, String eff_param, String pigabl) {
		if (eff_param == null || pigabl == null)
			return;
		String Effect = "";
		String Pigable = "";
		double power_length = 0;
		double power_radius_i = 0;
		power_length = p_lenght;
		power_radius_i = p_radius_i;
		Effect = eff_param;
		Pigable = pigabl;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SvinosaModBlocks.PIG_HERB_VINES_PLANT.get()) {
			SvinosaMod.LOGGER.info("vine found");
			if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
				if (power_length >= 1) {
					power_length = power_length - 1;
					if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR || (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == SvinosaModBlocks.PIG_HERB_VINES_PLANT.get()) {
						if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
							{
								int _value = 0;
								BlockPos _pos = new BlockPos(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							world.setBlock(new BlockPos(x, y + 1, z), SvinosaModBlocks.PIG_HERB_VINES_PLANT.get().defaultBlockState(), 3);
							if ((world.getBlockState(new BlockPos(x, y + 2, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
								{
									int _value = 1;
									BlockPos _pos = new BlockPos(x, y + 1, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							}
							PigVineGrowUpProcedure.execute(world, x, y + 1, z, power_length, p_radius_i, Effect, Pigable);
						} else {
							PigVineGrowUpProcedure.execute(world, x, y + 1, z, power_length, p_radius_i, Effect, Pigable);
						}
					} else {
						BasicPigSpreadingHandlerProcedure.execute(world, x, y + 1, z, p_radius_i, p_radius_i, Effect, Pigable);
					}
				}
			}
		}
	}
}

package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;
import net.svisvi.svinosa.SvinosaMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.HashMap;

import com.mojang.blaze3d.shaders.Effect;

public class BasicPigSpreadingHandlerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double p_radius, double p_radius_i, String eff_param, String pigabl) {
		if (eff_param == null || pigabl == null)
			return;
		String Effect = "";
		String SString = "";
		String Pigable = "";
		String SUString = "";
		double power_radius = 0;
		double C_RADIUS = 0;
		double stX = 0;
		double stY = 0;
		double stZ = 0;
		double randomizer = 0;
		double random_effect = 0;
		double randomGrowth = 0;
		world.addParticle(ParticleTypes.ASH, x, y, z, 0, 0, 0);
		power_radius = p_radius_i;
		power_radius = p_radius;
		C_RADIUS = 1;
		randomizer = Mth.nextDouble(new Random(), 0, 100);
		randomGrowth = Mth.nextDouble(new Random(), 1, 6);
		Effect = eff_param;
		Pigable = pigabl;
		SString = "hooey";
		SvinosaMod.LOGGER.info("power " + power_radius);
		if (power_radius > 0) {
			HashMap<String, String> blocksMap = FindTagInBoxRandReturnDictProcedure.execute(world, x, y, z, C_RADIUS, C_RADIUS, C_RADIUS);
			SvinosaMod.LOGGER.info("map" + blocksMap);
			if (!(SString = blocksMap.get("Stone")).equals(x + "/" + y + "/" + z)) {
				if ((Effect).equals("REPEATER")) {
					world.setBlock(new BlockPos(SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z")),
							SvinosaModBlocks.REPEATER_PIG_BLOCK.get().defaultBlockState(), 3);
				} else if ((Effect).equals("NONE")) {
					PlacePigWallsProcedure.execute(world, SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z"));
				}
			} else if (!(SString = blocksMap.get("Ores")).equals(x + "/" + y + "/" + z)) {
				PlacePigOreProcedure.execute(world, SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z"));
			} else if (!(SString = blocksMap.get("Pig")).equals(x + "/" + y + "/" + z)) {
				random_effect = Mth.nextDouble(new Random(), 0, 100);
				if (!(SUString = blocksMap.get("PigUpAir")).equals(x + "/" + y + "/" + z) && randomizer <= 15 && p_radius_i - power_radius >= 8) {
					if ((Effect).equals("NONE")) {
						if (Mth.nextInt(new Random(), 0, 10) >= 6) {
							Effect = SelectRandomUpPigEffectProcedure.execute();
						}
					}
					if ((world.getBlockState(new BlockPos(SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y") + 1, SplitCoordsStringProcedure.execute(SString, "z"))))
							.getMaterial() == net.minecraft.world.level.material.Material.AIR) {
						if ((Effect).equals("GEYSER")) {
							world.setBlock(new BlockPos(SplitCoordsStringProcedure.execute(SUString, "x"), SplitCoordsStringProcedure.execute(SUString, "y") + 1, SplitCoordsStringProcedure.execute(SUString, "z")),
									SvinosaModBlocks.PIG_GEYSER.get().defaultBlockState(), 3);
						} else if ((Effect).equals("EGG")) {
							world.setBlock(new BlockPos(SplitCoordsStringProcedure.execute(SUString, "x"), SplitCoordsStringProcedure.execute(SUString, "y") + 1, SplitCoordsStringProcedure.execute(SUString, "z")),
									SvinosaModBlocks.PIG_EGG.get().defaultBlockState(), 3);
						} else if ((Effect).equals("MOUTH")) {
							world.setBlock(new BlockPos(SplitCoordsStringProcedure.execute(SUString, "x"), SplitCoordsStringProcedure.execute(SUString, "y") + 1, SplitCoordsStringProcedure.execute(SUString, "z")),
									SvinosaModBlocks.PIG_MOUTH_TEST.get().defaultBlockState(), 3);
						} else if ((Effect).equals("NONE")) {
							PlacePigHerbProcedure.execute(world, SplitCoordsStringProcedure.execute(SUString, "x"), SplitCoordsStringProcedure.execute(SUString, "y") + 1, SplitCoordsStringProcedure.execute(SUString, "z"));
						}
					}
				} else if (!(SUString = blocksMap.get("PigDownAir")).equals(x + "/" + y + "/" + z) && randomizer <= 15 && p_radius_i - power_radius >= 8) {
					if ((Effect).equals("NONE")) {
						if (Mth.nextInt(new Random(), 0, 10) >= 7) {
							Effect = SelectRandomDownPigEffectProcedure.execute();
						}
					}
					if ((world.getBlockState(new BlockPos(SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y") - 1, SplitCoordsStringProcedure.execute(SString, "z"))))
							.getMaterial() == net.minecraft.world.level.material.Material.AIR) {
						if ((Effect).equals("EGG")) {
							world.setBlock(new BlockPos(SplitCoordsStringProcedure.execute(SUString, "x"), SplitCoordsStringProcedure.execute(SUString, "y") - 1, SplitCoordsStringProcedure.execute(SUString, "z")),
									SvinosaModBlocks.PIG_EGG.get().defaultBlockState(), 3);
						} else if ((Effect).equals("NONE")) {
							PlacePigHerbUpsideProcedure.execute(world, SplitCoordsStringProcedure.execute(SUString, "x"), SplitCoordsStringProcedure.execute(SUString, "y") - 1, SplitCoordsStringProcedure.execute(SUString, "z"));
						}
					}
				} else {
					power_radius = power_radius - 1;
					if ((world.getBlockState(new BlockPos(SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z"))))
							.getBlock() == SvinosaModBlocks.PIG_HERB_VINES_PLANT.get()) {
						PigVineGrowUpProcedure.execute(world, SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z"), Math.ceil(power_radius * 2.5),
								p_radius_i, Effect, Pigable);
					} else if ((world.getBlockState(new BlockPos(SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z"))))
							.getBlock() == SvinosaModBlocks.PIG_HERB_SWEEPING_VINES_PLANT.get()) {
						SvinosaMod.LOGGER.info("sweeping!");
						if ((Effect).equals("NONE")) {
							if (Mth.nextInt(new Random(), 0, 10) >= 7) {
								Effect = SelectRandomVinesPigEffectProcedure.execute();
							}
						}
						SweepingVineGrowUpProcedure.execute(world, SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z"), randomGrowth,
								Math.ceil(power_radius * 2.5), p_radius_i, Effect, Pigable);
					} else {
						BasicPigSpreadingHandlerProcedure.execute(world, SplitCoordsStringProcedure.execute(SString, "x"), SplitCoordsStringProcedure.execute(SString, "y"), SplitCoordsStringProcedure.execute(SString, "z"), power_radius, p_radius_i,
								Effect, Pigable);
					}
				}
			}
		}
	}
}

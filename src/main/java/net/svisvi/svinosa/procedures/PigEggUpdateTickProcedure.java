package net.svisvi.svinosa.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;

public class PigEggUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Piggies = 0;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
			Piggies = 6;
			PigEggHatchProcedure.execute(world, x, y, z, Piggies);
		}
	}
}

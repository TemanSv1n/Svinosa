package net.svisvi.svinosa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

public class PigHerbVinesPlantEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.addParticle(ParticleTypes.ASH, x, y, z, 0, 1, 0);
		entity.clearFire();
	}
}

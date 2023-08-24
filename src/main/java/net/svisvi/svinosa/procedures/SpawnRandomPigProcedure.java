package net.svisvi.svinosa.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import java.util.Random;

public class SpawnRandomPigProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String SpawnType = "";
		SpawnType = SelectRandomPigEntityProcedure.execute();
		if ((SpawnType).equals("PIG")) {
			if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
				Entity _entityForSpawning = new Pig(EntityType.PIG, _serverLevelForEntitySpawn);
				_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				{
					Entity _ent = _entityForSpawning;
					_ent.setYRot((float) Mth.nextDouble(new Random(), 0, 360));
					_ent.setXRot((float) Mth.nextDouble(new Random(), 0, 360));
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				if (_entityForSpawning instanceof Mob _mobForSpawning)
					_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(_entityForSpawning);
			}
		} else if ((SpawnType).equals("HOGLIN")) {
			if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
				Entity _entityForSpawning = new Hoglin(EntityType.HOGLIN, _serverLevelForEntitySpawn);
				_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				{
					Entity _ent = _entityForSpawning;
					_ent.setYRot((float) Mth.nextDouble(new Random(), 0, 360));
					_ent.setXRot((float) Mth.nextDouble(new Random(), 0, 360));
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				_entityForSpawning.getPersistentData().putBoolean("IsImmuneToZombification", (true));
				if (_entityForSpawning instanceof Mob _mobForSpawning)
					_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(_entityForSpawning);
			}
		}
	}
}

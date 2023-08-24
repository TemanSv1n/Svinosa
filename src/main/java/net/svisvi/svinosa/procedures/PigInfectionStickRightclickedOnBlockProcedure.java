package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class PigInfectionStickRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack food = ItemStack.EMPTY;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SvinosaModBlocks.PIG_MOUTH_TEST.get()) {
			food = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			PigMouthSpreadingStartProcedure.execute(world, x, y, z, food);
		}
	}
}

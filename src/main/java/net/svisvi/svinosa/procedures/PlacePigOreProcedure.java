package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.init.SvinosaModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class PlacePigOreProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String ore_id = "";
		ore_id = ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString();
		world.setBlock(new BlockPos(x, y, z), SvinosaModBlocks.BASIC_PIG_ORE.get().defaultBlockState(), 3);
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putString("OldOre", ore_id);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}

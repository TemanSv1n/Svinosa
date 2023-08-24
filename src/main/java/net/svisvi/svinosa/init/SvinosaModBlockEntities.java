
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.svinosa.init;

import net.svisvi.svinosa.block.entity.PigMouthTestBlockEntity;
import net.svisvi.svinosa.block.entity.PigEggBlockEntity;
import net.svisvi.svinosa.block.entity.BasicPigOreBlockEntity;
import net.svisvi.svinosa.SvinosaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class SvinosaModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SvinosaMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PIG_MOUTH_TEST = register("pig_mouth_test", SvinosaModBlocks.PIG_MOUTH_TEST, PigMouthTestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BASIC_PIG_ORE = register("basic_pig_ore", SvinosaModBlocks.BASIC_PIG_ORE, BasicPigOreBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PIG_EGG = register("pig_egg", SvinosaModBlocks.PIG_EGG, PigEggBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

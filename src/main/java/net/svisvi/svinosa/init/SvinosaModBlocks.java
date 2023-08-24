
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.svinosa.init;

import net.svisvi.svinosa.block.SussyBlockBlock;
import net.svisvi.svinosa.block.SussyBlock;
import net.svisvi.svinosa.block.RepeaterPigBlockBlock;
import net.svisvi.svinosa.block.PigMouthTestBlock;
import net.svisvi.svinosa.block.PigHerbVinesPlantBlock;
import net.svisvi.svinosa.block.PigHerbTorchBlock;
import net.svisvi.svinosa.block.PigHerbSweepingVinesPlantBlock;
import net.svisvi.svinosa.block.PigHerbRootsUpsideBlock;
import net.svisvi.svinosa.block.PigHerbRootsBlock;
import net.svisvi.svinosa.block.PigGeyserBlock;
import net.svisvi.svinosa.block.PigEyeDaisyBlock;
import net.svisvi.svinosa.block.PigEggBlock;
import net.svisvi.svinosa.block.BasicPigRootedBlockBlock;
import net.svisvi.svinosa.block.BasicPigOreBlock;
import net.svisvi.svinosa.block.BasicPigBlockSnoutBlock;
import net.svisvi.svinosa.block.BasicPigBlockEyeBlock;
import net.svisvi.svinosa.block.BasicPigBlockBlock;
import net.svisvi.svinosa.SvinosaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class SvinosaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SvinosaMod.MODID);
	public static final RegistryObject<Block> BASIC_PIG_BLOCK_EYE = REGISTRY.register("basic_pig_block_eye", () -> new BasicPigBlockEyeBlock());
	public static final RegistryObject<Block> BASIC_PIG_BLOCK_SNOUT = REGISTRY.register("basic_pig_block_snout", () -> new BasicPigBlockSnoutBlock());
	public static final RegistryObject<Block> PIG_MOUTH_TEST = REGISTRY.register("pig_mouth_test", () -> new PigMouthTestBlock());
	public static final RegistryObject<Block> BASIC_PIG_ORE = REGISTRY.register("basic_pig_ore", () -> new BasicPigOreBlock());
	public static final RegistryObject<Block> REPEATER_PIG_BLOCK = REGISTRY.register("repeater_pig_block", () -> new RepeaterPigBlockBlock());
	public static final RegistryObject<Block> PIG_HERB_TORCH = REGISTRY.register("pig_herb_torch", () -> new PigHerbTorchBlock());
	public static final RegistryObject<Block> BASIC_PIG_ROOTED_BLOCK = REGISTRY.register("basic_pig_rooted_block", () -> new BasicPigRootedBlockBlock());
	public static final RegistryObject<Block> PIG_HERB_ROOTS = REGISTRY.register("pig_herb_roots", () -> new PigHerbRootsBlock());
	public static final RegistryObject<Block> PIG_EYE_DAISY = REGISTRY.register("pig_eye_daisy", () -> new PigEyeDaisyBlock());
	public static final RegistryObject<Block> PIG_HERB_VINES_PLANT = REGISTRY.register("pig_herb_vines_plant", () -> new PigHerbVinesPlantBlock());
	public static final RegistryObject<Block> SUSSY = REGISTRY.register("sussy", () -> new SussyBlock());
	public static final RegistryObject<Block> PIG_EGG = REGISTRY.register("pig_egg", () -> new PigEggBlock());
	public static final RegistryObject<Block> PIG_GEYSER = REGISTRY.register("pig_geyser", () -> new PigGeyserBlock());
	public static final RegistryObject<Block> SUSSY_BLOCK = REGISTRY.register("sussy_block", () -> new SussyBlockBlock());
	public static final RegistryObject<Block> BASIC_PIG_BLOCK = REGISTRY.register("basic_pig_block", () -> new BasicPigBlockBlock());
	public static final RegistryObject<Block> PIG_HERB_ROOTS_UPSIDE = REGISTRY.register("pig_herb_roots_upside", () -> new PigHerbRootsUpsideBlock());
	public static final RegistryObject<Block> PIG_HERB_SWEEPING_VINES_PLANT = REGISTRY.register("pig_herb_sweeping_vines_plant", () -> new PigHerbSweepingVinesPlantBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PigMouthTestBlock.registerRenderLayer();
			PigHerbTorchBlock.registerRenderLayer();
			PigHerbRootsBlock.registerRenderLayer();
			PigEyeDaisyBlock.registerRenderLayer();
			PigHerbVinesPlantBlock.registerRenderLayer();
			SussyBlock.registerRenderLayer();
			PigEggBlock.registerRenderLayer();
			PigGeyserBlock.registerRenderLayer();
			PigHerbRootsUpsideBlock.registerRenderLayer();
			PigHerbSweepingVinesPlantBlock.registerRenderLayer();
		}
	}
}

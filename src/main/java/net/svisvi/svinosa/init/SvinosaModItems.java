
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.svinosa.init;

import net.svisvi.svinosa.item.PigInfectionStickItem;
import net.svisvi.svinosa.item.PigBloodDropletItem;
import net.svisvi.svinosa.SvinosaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class SvinosaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SvinosaMod.MODID);
	public static final RegistryObject<Item> BASIC_PIG_BLOCK_EYE = block(SvinosaModBlocks.BASIC_PIG_BLOCK_EYE, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> BASIC_PIG_BLOCK_SNOUT = block(SvinosaModBlocks.BASIC_PIG_BLOCK_SNOUT, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_INFECTION_STICK = REGISTRY.register("pig_infection_stick", () -> new PigInfectionStickItem());
	public static final RegistryObject<Item> PIG_MOUTH_TEST = block(SvinosaModBlocks.PIG_MOUTH_TEST, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> BASIC_PIG_ORE = block(SvinosaModBlocks.BASIC_PIG_ORE, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_BLOOD_DROPLET = REGISTRY.register("pig_blood_droplet", () -> new PigBloodDropletItem());
	public static final RegistryObject<Item> REPEATER_PIG_BLOCK = block(SvinosaModBlocks.REPEATER_PIG_BLOCK, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_HERB_TORCH = block(SvinosaModBlocks.PIG_HERB_TORCH, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> BASIC_PIG_ROOTED_BLOCK = block(SvinosaModBlocks.BASIC_PIG_ROOTED_BLOCK, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_HERB_ROOTS = block(SvinosaModBlocks.PIG_HERB_ROOTS, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_EYE_DAISY = block(SvinosaModBlocks.PIG_EYE_DAISY, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_HERB_VINES_PLANT = block(SvinosaModBlocks.PIG_HERB_VINES_PLANT, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> SUSSY = block(SvinosaModBlocks.SUSSY, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_EGG = block(SvinosaModBlocks.PIG_EGG, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_GEYSER = block(SvinosaModBlocks.PIG_GEYSER, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> SUSSY_BLOCK = block(SvinosaModBlocks.SUSSY_BLOCK, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> BASIC_PIG_BLOCK = block(SvinosaModBlocks.BASIC_PIG_BLOCK, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_HERB_ROOTS_UPSIDE = block(SvinosaModBlocks.PIG_HERB_ROOTS_UPSIDE, SvinosaModTabs.TAB_SVINOSA);
	public static final RegistryObject<Item> PIG_HERB_SWEEPING_VINES_PLANT = block(SvinosaModBlocks.PIG_HERB_SWEEPING_VINES_PLANT, SvinosaModTabs.TAB_SVINOSA);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}

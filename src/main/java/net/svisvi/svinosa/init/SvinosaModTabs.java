
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.svinosa.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class SvinosaModTabs {
	public static CreativeModeTab TAB_SVINOSA;

	public static void load() {
		TAB_SVINOSA = new CreativeModeTab("tabsvinosa") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.PORKCHOP);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}

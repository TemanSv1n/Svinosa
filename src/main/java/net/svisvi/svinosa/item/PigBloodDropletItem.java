
package net.svisvi.svinosa.item;

import net.svisvi.svinosa.init.SvinosaModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PigBloodDropletItem extends Item {
	public PigBloodDropletItem() {
		super(new Item.Properties().tab(SvinosaModTabs.TAB_SVINOSA).stacksTo(64).rarity(Rarity.COMMON));
	}
}

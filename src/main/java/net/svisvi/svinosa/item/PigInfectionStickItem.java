
package net.svisvi.svinosa.item;

import net.svisvi.svinosa.procedures.PigInfectionStickRightclickedOnBlockProcedure;
import net.svisvi.svinosa.init.SvinosaModTabs;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class PigInfectionStickItem extends Item {
	public PigInfectionStickItem() {
		super(new Item.Properties().tab(SvinosaModTabs.TAB_SVINOSA).stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		PigInfectionStickRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}

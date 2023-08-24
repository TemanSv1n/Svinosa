package net.svisvi.svinosa.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.ArrayList;

import com.mojang.blaze3d.shaders.Effect;

public class PigMouthSpreadingStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack food_item) {
		ItemStack food = ItemStack.EMPTY;
		double C_RADIUS = 0;
		double repeater = 0;
		double power_radius = 0;
		List<Object> CoordsArray = new ArrayList<>();
		String Effect = "";
		String Pigable = "";
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.eat")), SoundSource.BLOCKS, 1, -1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.eat")), SoundSource.BLOCKS, 1, -1, false);
			}
		}
		food = (food_item);
		repeater = Math.ceil(food.getItem().isEdible() ? food.getItem().getFoodProperties().getNutrition() : 0);
		C_RADIUS = 1;
		power_radius = 15 + Math.ceil(food.getItem().isEdible() ? food.getItem().getFoodProperties().getSaturationModifier() : 0 / 10) * 5;
		if ((food_item).getItem() == Items.POISONOUS_POTATO) {
			repeater = 0;
			power_radius = 10;
			Effect = "POISONOUS";
		} else {
			Effect = "NONE";
		}
		if ((Effect).equals("HERB")) {
			Pigable = "PIG";
		} else {
			Pigable = "NONE";
		}
		if ((Effect).equals("POISONOUS")) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(false);
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			for (int index0 = 0; index0 < (int) (repeater); index0++) {
				BasicPigSpreadingHandlerProcedure.execute(world, x, y, z, power_radius, power_radius, Effect, Pigable);
			}
		}
	}
}

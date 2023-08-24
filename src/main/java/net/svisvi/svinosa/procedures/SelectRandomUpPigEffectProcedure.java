package net.svisvi.svinosa.procedures;

import net.svisvi.svinosa.SvinosaMod;

import net.minecraft.util.Mth;

import java.util.Random;
import java.util.HashMap;

public class SelectRandomUpPigEffectProcedure {
	public static String execute() {
		double summe = 0;
		double randus = 0;
		double progress = 0;
		String retval = "";
		retval = "NONE";
		HashMap<String, Double> Percentages = new HashMap<String, Double>();
		Percentages.put("MOUTH", 2.00);
		Percentages.put("EGG", 5.00);
		Percentages.put("GEYSER", 7.00);
		/*code*/
		for (double i : Percentages.values()) {
			summe = summe + i;
		}
		randus = Mth.nextDouble(new Random(), 0, summe);
		SvinosaMod.LOGGER.info("Randus: " + randus);
		for (String i : Percentages.keySet()) {
			progress = progress + Percentages.get(i);
			if (randus <= progress) {
				retval = i;
				break;
			}
		}
		SvinosaMod.LOGGER.info("Returned: " + retval);
		return retval;
	}
}

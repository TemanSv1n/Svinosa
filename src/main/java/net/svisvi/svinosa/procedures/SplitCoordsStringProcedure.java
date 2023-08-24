package net.svisvi.svinosa.procedures;

import org.checkerframework.checker.units.qual.s;

public class SplitCoordsStringProcedure {
	public static double execute(String CoordsStringus, String ReturnCoord) {
		if (CoordsStringus == null || ReturnCoord == null)
			return 0;
		String Stringus = "";
		String Returner = "";
		double rx = 0;
		double ry = 0;
		double rz = 0;
		Stringus = CoordsStringus;
		Returner = ReturnCoord;
		if ((Returner).equals("x")) {
			rx = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(Stringus.substring((int) 0, (int) Stringus.indexOf('/')));
			return rx;
		} else if ((Returner).equals("y")) {
			ry = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(Stringus.substring((int) (Stringus.indexOf('/') + 1), (int) Stringus.indexOf('/', (Stringus.indexOf('/')) + 1)));
			return ry;
		} else if ((Returner).equals("z")) {
			rz = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(Stringus.substring((int) (Stringus.indexOf('/', (Stringus.indexOf('/')) + 1) + 1), (int) (Stringus).length()));
			return rz;
		}
		return -1;
	}
}

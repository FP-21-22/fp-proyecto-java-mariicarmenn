package fp.utiles;

public class Checkers {

	public static void check(String textoRestriccion, Boolean condicion) {
		if (!condicion) {
			throw new IllegalArgumentException(
					Thread.currentThread().getStackTrace()[2].getClassName() +
					"." + 
					Thread.currentThread().getStackTrace()[2].getMethodName() +
					": " + 
					textoRestriccion);
		}
	}

	public static void checkNoNull(Object... parametros) {
		for (int i = 0; i < parametros.length; i++) {
			if (parametros[i] == null) {
				throw new IllegalArgumentException(
						Thread.currentThread().getStackTrace()[2].getClassName() +
						"." + 
						Thread.currentThread().getStackTrace()[2].getMethodName() +
						": el parámetro " + (i + 1) + " es nulo");
			}
		}
	}
}

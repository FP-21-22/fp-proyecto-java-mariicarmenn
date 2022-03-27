package fp.utiles;

public class Validators {
	public static Boolean sonDigitos(String codigo) {
		Boolean res = true;
		for (int i = 0; i< codigo.length(); i++) {
			res = res && Character.isDigit(codigo.charAt(i));
			if(!res) {
					break;
			}
		}
		return res;
	}
	
}
package fp.vacunas;

import java.util.List;


public class TestFactoriaVacunacion {
	public static void main(String[] args) {
		// 
		String ruta = "data/ccaa_vacunas_3.csv";
		List<Vacunacion> lista = FactoriaVacunacion.leeFichero(ruta);
		for(Vacunacion e:lista) {
			System.out.println(e);
		}
	}
}

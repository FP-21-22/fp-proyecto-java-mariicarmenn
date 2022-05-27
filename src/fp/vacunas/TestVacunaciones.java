package fp.vacunas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import fp.vacunas.*;

public class TestVacunaciones {
	
	public static void main(String[] args) {
		
		Stream<Vacunacion> CSV = FactoriaVacunacion.leeFichero("data/ccaa_vacunas_3.csv").stream();
		Vacunaciones v = new Vacunaciones(CSV);
		testCSV();
		
	}
	private static void testCSV() {
		System.out.println("\n- Test del constructor con el CSV: ");
		try {
			Stream<Vacunacion> CSV = FactoriaVacunacion.leeFichero("data/ccaa_vacunas_3.csv").stream();
			Vacunaciones vacCSV = new Vacunaciones(CSV);

			System.out.println(vacCSV);
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n\t " + e);
		}
	}
	

	
	
}

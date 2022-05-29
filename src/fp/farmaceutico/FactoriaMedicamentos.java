package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FactoriaMedicamentos {
	
	public static List<Medicamento> leeFichero(String nombreFichero){
		//
		List<Medicamento> res = new ArrayList<Medicamento>();		
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
				Medicamento p = parseaMedicamento(e);
				res.add(p);
			}
			cont++;
		}		
		return res;
	}
	
	public static Medicamento parseaMedicamento(String cadena) {
		String[] partes = cadena.split(",");
		String nombreDelMedicamento = partes[0];
		TipoMedicamento tipoDeMedicamento = TipoMedicamento.valueOf(partes[1].toUpperCase());
		String codigoDeLaEnfermedad = partes[2];
		String farmaceutica = partes[3];
		Double puntuacion = Double.parseDouble(partes[4]);
		Integer indiceSomatico = Integer.parseInt(partes[5]);
		String[] fecha_partes = partes[6].split("/");
		Integer dia = Integer.parseInt(fecha_partes[0]);
		Integer mes = Integer.parseInt(fecha_partes[1]);
		Integer anyo = Integer.parseInt(fecha_partes[2]);
		LocalDate fechaDeCatalogo = LocalDate.of(anyo, mes, dia);
		
		Medicamento res = new Medicamento(nombreDelMedicamento, tipoDeMedicamento,
				codigoDeLaEnfermedad, farmaceutica, puntuacion, indiceSomatico, 
				fechaDeCatalogo);
		return res;
	}
}

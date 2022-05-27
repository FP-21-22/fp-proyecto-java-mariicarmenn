package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FactoriaVacunacion {
	
	public static List<Vacunacion> leeFichero(String nombreFichero){
		//
		List<Vacunacion> res = new ArrayList<Vacunacion>();		
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
				Vacunacion p = parseaVacunacion(e);
				res.add(p);
			}
			cont++;
		}		
		return res;
	}
	
	public static Vacunacion parseaVacunacion(String cadena) {
		String[] partes = cadena.split(";");
		String[] fecha_partes= (partes[0]).split("/");
		Integer dia = Integer.parseInt(fecha_partes[0]);
		Integer mes = Integer.parseInt(fecha_partes[1]);
		Integer anyo = Integer.parseInt(fecha_partes[2]);
		LocalDate fecha = LocalDate.of(anyo, mes, dia);
		String comunidad = partes[1];
		Integer pfizer = Integer.parseInt(partes[2]);
		Integer moderna = Integer.parseInt(partes[3]);
		Integer astrazeneca = Integer.parseInt(partes[4]);
		Integer janssen = Integer.parseInt(partes[5]);
		Integer numeroDePersonas = Integer.parseInt(partes[6]);
		
		Vacunacion res = new Vacunacion(fecha,comunidad,pfizer,moderna,astrazeneca,janssen,numeroDePersonas);
		return res;
	}
}

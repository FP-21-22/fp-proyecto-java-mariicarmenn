package fp.vacunas;

import java.time.LocalDate;
import java.util.List;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroDePersonas) {
	
	//PROPIEDADES DERIVADAS
	public Integer numeroTotal(Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen) {
		Integer res = this.pfizer+this.moderna+this.astrazeneca+this.janssen;
		return res;
	}
	
	//RESTRICCIONES
	public Vacunacion{
		Checkers.check("La fecha tiene que ser posterior al 02/01/2021", fecha.isAfter(LocalDate.of(2021, 1, 2)));
	}
	//REPRESENTACION COMO CADENA
		//Por defecto asociado al record
	


	//ORDEN NATURAL
	public int compareTo(Vacunacion v) {
		// 
		int res = this.comunidad().compareTo(v.comunidad());
		if(comunidad.equals(v.comunidad())) {
			res = this.fecha().compareTo(v.fecha());
		}
		return res;
	}
	//MÉTODOS CONSTRUCTORES
	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroDePersonas) {
		Vacunacion res = new Vacunacion(fecha,comunidad,pfizer,moderna,astrazeneca,janssen,numeroDePersonas);
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
	public static void main(String[] args){
		Vacunacion v1 = Vacunacion.parseaVacunacion("04/01/2021;Andalucía;140295;0;0;0;0");
		System.out.println(v1);
	}
}

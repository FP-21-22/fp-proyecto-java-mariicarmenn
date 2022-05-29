package fp.clinico;

import java.time.LocalDate;
import fp.utiles.Checkers;
import fp.utiles.Validators;


public record Persona(String nombre, String apellidos, String dni, LocalDate fechaDeNacimiento) {
	
	//Propiedades derivadas
	public Integer edad() {
		LocalDate hoy = LocalDate.now();
		
		Integer res = fechaDeNacimiento.until(hoy).getYears();
		return res;
	}
	
	//RESTRICCIONES
	public Persona{
		Checkers.check("La fecha de nacimiento tiene que ser anterior a la fecha actual", fechaDeNacimiento.isBefore(LocalDate.now()));
		Checkers.check("El dni no es válido",Validators.sonDigitos(dni.substring(0, 8))&&Character.isLetter(dni.charAt(8)));
		
	}
	
	//REPRESENTACIÓN COMO CADENA
		//viene asociado con el record
	
	//CRITERIO DE IGUALDAD
		//viene asociado con el record
	
	//ORDEN NATURAL
	public int compareTo(Persona p) {
		int res = this.dni().compareTo(p.dni());
	
		return res;
	}
	
	//MÉTODOS CONSTRUCTORES
	public static Persona of(String nombre, String apellidos, String dni, LocalDate fechaDeNacimiento) {
		
		Persona res = new Persona(nombre,apellidos,dni,fechaDeNacimiento);
		 
		return res;
	}
	public static Persona parseaPersona(String cadena){
		String[] partes = cadena.split(",");
		String nombre = partes[0].trim();
		String apellidos = partes[1].trim();
		String dni = partes[2].trim();
		String[] fecha = (partes[3].trim()).split("/");
		Integer dia= Integer.parseInt(fecha[0]);
		Integer mes= Integer.parseInt(fecha[1]);
		Integer anyo= Integer.parseInt(fecha[2]);
		LocalDate fechaDeNacimiento = LocalDate.of(anyo,mes,dia);
		
		
		Persona res = new Persona(nombre,apellidos,dni,fechaDeNacimiento);
		return res;
		
	}
	
	//METODO MAIN
	public static void main(String[] args){
		Persona p1 = Persona.parseaPersona("Juan, García Rodríguez, 12755078Z, 20/03/1965");
		System.out.println(p1);
		
	}
	
	
	
}

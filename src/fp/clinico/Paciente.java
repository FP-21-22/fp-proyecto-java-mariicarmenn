package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Paciente(Persona persona,String codigoIngreso, LocalDateTime fechaYHoraIngreso) {
	
	//PROPIEDADES DERIVADAS
	public LocalDate fechaIngreso() {
        DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate fecha = LocalDate.parse(fechaYHoraIngreso.format(isoFecha));
		return fecha;
	}
	
	public String horaIngreso() {
		DateTimeFormatter isoHora = DateTimeFormatter.ISO_LOCAL_TIME;
        String hora = ((fechaYHoraIngreso.format(isoHora)).formatted("HH:mm")).toString();
		return hora;
	}
	
	//RESTRICCIONES
	public Paciente{
		Checkers.check("La fecha y hora tienen que ser anteriores a la fecha y hora actuales", fechaYHoraIngreso.isBefore(LocalDateTime.now()));
		
	}
	
	//MÉTODOS CONSTRUCTORES
	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fechaDeNacimiento,String codigoIngreso, LocalDateTime fechaYHoraIngreso) {
		
		Paciente res = new Paciente(Persona.of(nombre, apellidos, dni, fechaDeNacimiento), codigoIngreso, fechaYHoraIngreso);
		
		return res;
	}
	public static Paciente of(Persona persona,String codigoIngreso, LocalDateTime fechaYHoraIngreso) {
		
		Paciente res = new Paciente(persona, codigoIngreso, fechaYHoraIngreso);
		
		return res;
	}
	
	public static void main(String[] args){
		Persona p1 = Persona.of("Juan, García Rodríguez, 12755078Z, 20/03/1965");
		
		Paciente p2 = Paciente.of(p1, "sakjdaj", LocalDateTime.of(2021, 03, 25, 21, 42));
			
		System.out.println(p2.horaIngreso());
	}
}

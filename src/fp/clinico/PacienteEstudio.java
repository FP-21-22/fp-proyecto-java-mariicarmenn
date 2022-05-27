package fp.clinico;
import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad,Boolean hipertension, Boolean enfermedadDelCorazon,TipoResidencia tipoDeResidencia,Double nivelMedioDeGlucosa) {
	
	//PROPIEDADES DERIVADAS
	public Boolean factorDeRiesgo() {
		Boolean res= null;
		if(this.hipertension && this.edad>40) {
			res = true;
		}
		else {
			res = false;
		}
		
		return res;
	}
	
	//RESTRICCIONES
	public PacienteEstudio{
		Checkers.check("La edad tiene que ser mayot o igual que cero y menor o igual que 130.", edad>=0 && edad<=130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que 0.", nivelMedioDeGlucosa>=0);
	}

	//REPRESENTACION COMO CADENA
	public String toString() { 
		return "PacienteEstudio [id=" + id + ", edad=" + edad +  "]";
	}
	
	//CRITERIO DE IGUALDAD
		//por defecto asociado al record
	
	//CRITERIO DE ORDEN 
	public int compareTo(PacienteEstudio p) {
		
		int res = this.edad().compareTo(p.edad());
		if(res==0) {
			res = this.id().compareTo(p.id());
		}
		return res;
	}
	
	//MÉTODOS CONSTRUCTORES
	public static PacienteEstudio of(String id, String genero, Double edad,Boolean hipertension, Boolean enfermedadDelCorazon,TipoResidencia tipoDeResidencia,Double nivelMedioDeGlucosa) {
		PacienteEstudio res = new PacienteEstudio(id,genero,edad,hipertension,enfermedadDelCorazon,tipoDeResidencia,nivelMedioDeGlucosa);
		return res;
	}
	public static PacienteEstudio parseaPacienteEstudio(String cadena) {
		String[] partes= cadena.split(";");
		String id = partes[0];
		String genero = partes[1];
		Double edad = Double.parseDouble(partes[2]);
		Boolean hipertension = Boolean.parseBoolean(partes[3]);
		Boolean enfermedadDelCorazon = Boolean.parseBoolean(partes[4]);
		TipoResidencia tipoDeResidencia = TipoResidencia.valueOf(partes[5].toUpperCase());
		Double nivelMedioDeGlucosa = Double.parseDouble(partes[6]);
		
		PacienteEstudio res = new PacienteEstudio(id,genero,edad,hipertension,enfermedadDelCorazon,tipoDeResidencia,nivelMedioDeGlucosa); 
		
		return res;
		
	}
	
	public static void main(String[] args){
		PacienteEstudio p1 = PacienteEstudio.parseaPacienteEstudio("6306;Male;80;false;false;URBANA;83.84");
		System.out.println(p1);
	}
}

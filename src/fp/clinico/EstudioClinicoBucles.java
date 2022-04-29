package fp.clinico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EstudioClinicoBucles implements EstudioClinico {
	
	private List<PacienteEstudio> ls;
	
	//Tipo EstudioClinicoBucles que crea lista sin ning�n elemento.
	public EstudioClinicoBucles() {
		this.ls = new ArrayList<>();
	}
	
	//Tipo EstudioClinicoBucles qie crea lista con objetos del tipo PacienteEstudio como par�metro.
	public EstudioClinicoBucles(List<PacienteEstudio> ls) {
		this.ls = ls;
	}
	//metodo parse
	public static PacienteEstudio parseaLinea(String linea) {
		PacienteEstudio c1 = PacienteEstudio.of(linea);
		return c1;
	}
	
	@Override
	public Integer numeroPacientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borraEstudio() {
		// TODO Auto-generated method stub

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}

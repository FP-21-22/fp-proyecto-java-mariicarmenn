package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;




public class EstudioClinicoStream implements EstudioClinico {
	private List<PacienteEstudio> pacientes;
	
	public EstudioClinicoStream() {
		this.pacientes = new ArrayList<>();
	}
	public EstudioClinicoStream(List<PacienteEstudio> lista) {
		
		this.pacientes = lista;
	}
	@Override
	public Integer numeroPacientes() {
		
		return this.pacientes.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		this.pacientes.add(paciente);

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		this.pacientes.addAll(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		this.pacientes.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		
		return this.pacientes.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		this.pacientes.clear();

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		List<PacienteEstudio> res = leeFichero(nombreFichero);
		
		return new EstudioClinicoStream(res);
		
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
			//
			List<PacienteEstudio> res = new ArrayList<>();		
			List<String> aux = null;
			try {
				aux = Files.readAllLines(Paths.get(nombreFichero));
			} catch (IOException e) {
				e.printStackTrace();
			}
			int cont = 0;
			for(String e:aux) {
				if(cont>0) {
					PacienteEstudio p = PacienteEstudio.parseaPacienteEstudio(e);
					res.add(p);
				}
				cont++;
			}		
			return res;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		Boolean res = false;
		res = this.pacientes.stream().allMatch(x->x.tipoDeResidencia().equals(tipo));
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		Boolean res= null;
		res= this.pacientes.stream().anyMatch(x->x.tipoDeResidencia().equals(tipo));
		return res;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		
		Predicate<PacienteEstudio> pr = x->x.factorDeRiesgo();
		Integer res = (int)this.pacientes.stream().filter(pr).count();
		return res;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		
		Double res = this.pacientes.stream()
				.filter(x->x.factorDeRiesgo())
				.mapToDouble(x->x.edad())
				.average().orElse(0);
		return res;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		
		return this.pacientes.stream().
				filter(x->x.edad().equals(edad)).
				collect(Collectors.toList());
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		
		return this.pacientes.stream()
				.filter(x->x.edad()>edad)
				.collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	@Override //NO SE SI ESTA BIEN
	public Map<String, Long> numeroPacientesPorGenero() {
		return  this.pacientes.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::genero, 
						Collectors.counting()
						));
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		Map<String,Double> mapa = this.pacientes.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::genero, 
						Collectors.averagingDouble(x->x.edad())
						));
				return mapa;
	}

}

package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class EstudioClinicoBucles implements EstudioClinico {
	
	private List<PacienteEstudio> pacientes;
	public EstudioClinicoBucles() {
		this.pacientes = new ArrayList<>();
	}
	public EstudioClinicoBucles(List<PacienteEstudio> lista) {
		
		this.pacientes = lista;
	}
	
	@Override
	public Integer numeroPacientes() {
		
		return	this.pacientes.size();
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
		return new EstudioClinicoBucles(res);
		
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero){
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
		Boolean res = null;
		for(PacienteEstudio p: pacientes) {
			if(p.tipoDeResidencia().equals(tipo)) {
				res = true;
			}else {
				res=false;
			break;
			}
		}
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		Boolean res=false;
		for(PacienteEstudio p : pacientes) {
			if(p.tipoDeResidencia().equals(tipo)) {
				res=true;
			}
		}
		return res;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		Integer res = 0;
		for(PacienteEstudio p: pacientes) {
			if(p.factorDeRiesgo()) {
				res++;
			}
		}
		return res;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		List<Double> edades = new ArrayList<Double>();
		for(PacienteEstudio p: pacientes) {
			if(p.factorDeRiesgo()) {
				edades.add(p.edad());
			}
		}
		Double sum=0.;
		for(Double e: edades) {
			sum+=e;
		}
		return sum/edades.size();
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();
		for(PacienteEstudio p : pacientes) {
			if(p.edad()==edad) {
				res.add(p);
			}
			
		}
		return res;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		Map<String, List<PacienteEstudio>> res = new HashMap<String, List<PacienteEstudio>>();

		for (PacienteEstudio p : pacientes) {
			if (p.edad() >= edad) {

				if (res.containsKey(p.genero())) {
					res.get(p.genero()).add(p);
				} else {
					List<PacienteEstudio> lista = new ArrayList<PacienteEstudio>();
					lista.add(p);
					res.put(p.genero(), lista);
				}
			}
		}

		return res;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		Map<String, Long> res = new HashMap<String, Long>();

		for (PacienteEstudio p : pacientes) {
			
				if (res.containsKey(p.genero())) {
					Long contador = res.get(p.genero());
					res.put(p.genero(), contador++);
					
				} else {
					
					res.put(p.genero(), 1L);
				}
			}
		
		return res;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		Map<String, List<Double>> map1 = new HashMap<String, List<Double>>();
		for (PacienteEstudio p : pacientes) {
		if (map1.containsKey(p.genero())) {
			map1.get(p.genero()).add(p.edad());
		} else {
			List<Double> lista = new ArrayList<Double>();
			lista.add(p.edad());
			map1.put(p.genero(), lista);
		}
		}
		Map<String,Double> res = new HashMap<String, Double>();
		for(String g: map1.keySet()) {
			for(Double d: map1.get(g)) {
				if(res.containsKey(g)) {
					Double valor = res.get(g);
					res.put(g, valor+d/map1.get(g).size());
				}else {
					res.put(g, d/map1.get(g).size());
				}
			}
			
		}
		
		return res;
	}

}

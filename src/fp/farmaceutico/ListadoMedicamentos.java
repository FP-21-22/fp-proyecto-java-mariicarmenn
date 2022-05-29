package fp.farmaceutico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ListadoMedicamentos {
private List<Medicamento> listadoMedicamentos;
	
	public ListadoMedicamentos (Stream<Medicamento> a) {
		this.listadoMedicamentos = a.collect(Collectors.toList());
	}
	
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipo,LocalDate fecha) {
		Boolean res=false;
		for(Medicamento l: listadoMedicamentos) {
			if(fecha.isAfter(l.getFechaDeCatalogo()) && l.getTipoDeMedicamento().equals(tipo)) {
				res=true;
			}
		}
		
		return res;
	}
	
	public Set<String> nombreMedicamentosPuntuacionMayorA(Double puntuacion){
		
		Set<String> res = this.listadoMedicamentos.stream().
		 filter(x->(x.getPuntuacion()>puntuacion)).
		 map(Medicamento::getNombreDelMedicamento).
		 collect(Collectors.toSet());
		
		return res ;
	}
	
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento tipo) {
		
		Medicamento res =this.listadoMedicamentos.stream().
		filter(x->x.getTipoDeMedicamento().equals(tipo)).
		max(Comparator.comparing(Medicamento::getIndiceSomatico)).orElseThrow(null);
		
		return res.getNombreDelMedicamento();
	}
	
	public Map<TipoMedicamento,Double> agrupaTipoMedicamentoSegunPuntuacionMedia(){
		
		Map<TipoMedicamento, List<Double>> map1 = new HashMap<TipoMedicamento, List<Double>>();
		for (Medicamento m : listadoMedicamentos) {
		if (map1.containsKey(m.getTipoDeMedicamento())) {
			map1.get(m.getTipoDeMedicamento()).add(m.getPuntuacion());
		} else {
			List<Double> lista = new ArrayList<Double>();
			lista.add(m.getPuntuacion());
			map1.put(m.getTipoDeMedicamento(), lista);
		}
		}
		Map<TipoMedicamento,Double> res = new HashMap<TipoMedicamento, Double>();
		for(TipoMedicamento t: map1.keySet()) {
			for(Double p: map1.get(t)) {
				if(res.containsKey(t)) {
					Double valor = res.get(t);
					res.put(t, valor+p/map1.get(t).size());
				}else {
					res.put(t, p/map1.get(t).size());
				}
			}
			
		}
		
		return res;
	}
	
	public LocalDate fechaCatalogoMasFrecuente() {
		
		Map<LocalDate, Long> mapaAux = this.listadoMedicamentos.stream().
				collect(Collectors.groupingBy(
						Medicamento::getFechaDeCatalogo, 
						Collectors.counting()
						));	
		
		Long maximo = mapaAux.values().stream().max(Comparator.naturalOrder()).get();
		
		LocalDate clave = obtenerClaveDeUnValor(mapaAux,maximo);

		return clave;
	}
		
	    public static LocalDate obtenerClaveDeUnValor(Map<LocalDate, Long> mapaAux, Long maximo) {
	        for (Map.Entry<LocalDate, Long> e : mapaAux.entrySet()) {
	            if (e.getValue().equals(maximo)) {
	                return e.getKey();
	
	            }
	        }
			return null;
	    }
}

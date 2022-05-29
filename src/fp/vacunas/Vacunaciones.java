package fp.vacunas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class Vacunaciones {

	private List<Vacunacion> vacunaciones;
	
	public Vacunaciones (Stream<Vacunacion> a) {
		this.vacunaciones = a.collect(Collectors.toList());
	}
	
	public void anyadeVacunacion(Vacunacion v) {
		
		this.vacunaciones.add(v);
	}
	
	public List<Vacunacion> vacunacionesEntreFechas(LocalDate fecha1,LocalDate fecha2){
		
		List<Vacunacion> lista = new ArrayList<Vacunacion>();
		
		for(Vacunacion v : vacunaciones) {
			if(v.fecha().isBefore(fecha2) && v.fecha().isAfter(fecha1)) {
				lista.add(v);
			}
		}
		
		return lista;
		
	}
	
	public Boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad,Integer n) {
		
		List<Vacunacion> lista = new ArrayList<Vacunacion>();
		Boolean res = null;
		for(Vacunacion v : vacunaciones) {
			if(v.comunidad().equals(comunidad)) {
				lista.add(v);
				for(Vacunacion a:lista) {
					if(a.numeroDePersonas()==n) {
						res=true;
					}else {
						res=false;
					}
				}
			}
		}
		
		return res;
	}
	
	public LocalDate diaMasVacunacionesEn(String comunidad) {
		
		Comparator<Vacunacion> cmp = Comparator.comparing(Vacunacion::numeroDePersonas);
		LocalDate res= vacunaciones.stream()
				.filter(x->x.comunidad().equals(comunidad)).max(cmp).get().fecha();
		return res;
	}
	
	public Map<LocalDate,List<Vacunacion>> vacunacionesPorFecha(){

		return this.vacunaciones.stream().
				collect(Collectors.groupingBy(Vacunacion::fecha));
	}
	
	public Map<String,Integer> maximoNumTotalVacunasporComunidad(){
	
			Map<String, List<Integer>> mapa = this.vacunaciones.stream().collect(Collectors.groupingBy(Vacunacion::comunidad, Collectors.collectingAndThen(Collectors.toList(),lista->lista.stream().map(valor->valor.numeroDePersonas()).collect(Collectors.toList()))));
			Map<String, Integer> aux = mapa.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().max(Comparator.naturalOrder()).get()));
			return aux;
	}
	
}

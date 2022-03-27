package fp.farmaceutico;

import java.time.LocalDate;


import fp.utiles.Checkers;


public class Medicamento {
	
	//PROPIEDADES
	private String nombreDelMedicamento;
	private TipoMedicamento tipoDeMedicamento;
	private String codigoDeLaEnfermedad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaDeCatalogo;
	
	//GETTERS Y SETTERS
	public LocalDate getFechaDeCatalogo() {
		return fechaDeCatalogo;
	}

	public void setFechaDeCatalogo(LocalDate fechaDeCatalogo) {
		this.fechaDeCatalogo = fechaDeCatalogo;
	}

	public String getNombreDelMedicamento() {
		return nombreDelMedicamento;
	}

	public TipoMedicamento getTipoDeMedicamento() {
		return tipoDeMedicamento;
	}

	public String getCodigoDeLaEnfermedad() {
		return codigoDeLaEnfermedad;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}
	
	//PROPIEDADES DERIVADAS
	@SuppressWarnings("unused")
	private Boolean tratarEnfermedad (String cadena) {
		if(codigoDeLaEnfermedad.equals(cadena)) {
			return true;
		}else {
			return false;
		}
	}
		
	//REPRESENTACION COMO CADENA
	public String toString() {
		return "Medicamento [nombreDelMedicamento=" + nombreDelMedicamento + ", farmaceutica=" + farmaceutica + "]";
	}
	
	//ORDEN NATURAL
	public int compareTo(Medicamento m) {
		
		int res = this.nombreDelMedicamento.compareTo(m.nombreDelMedicamento);
		if(nombreDelMedicamento.equals(m.nombreDelMedicamento)) {
			res = this.farmaceutica.compareTo(m.farmaceutica);
		}
		return res;
	}
	//MÉTODO CONSTRUCTOR
	public Medicamento(String nombreDelMedicamento, TipoMedicamento tipoDeMedicamento,
			String codigoDeLaEnfermedad, String farmaceutica, Double puntuacion, Integer indiceSomatico,
			LocalDate fechaDeCatalogo) {
		this.nombreDelMedicamento = nombreDelMedicamento;
		this.tipoDeMedicamento = tipoDeMedicamento;
		this.codigoDeLaEnfermedad = codigoDeLaEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaDeCatalogo = fechaDeCatalogo;
		Checkers.check("La puntuacón ha de ser mayor que cero", puntuacion>0);
		Checkers.check("El índice somatico tiene que ser mayor o igual que 1000", indiceSomatico>=1000);
		Checkers.check("", fechaDeCatalogo.isAfter(LocalDate.of(2015, 1,1)));
	}
}

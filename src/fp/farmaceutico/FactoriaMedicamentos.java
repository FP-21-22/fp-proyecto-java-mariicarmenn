package fp.farmaceutico;

import java.time.LocalDate;


public class FactoriaMedicamentos {
	public static Medicamento parseaMedicamento(String cadena) {
		String[] partes = cadena.split(",");
		String nombreDelMedicamento = partes[0];
		TipoMedicamento tipoDeMedicamento = TipoMedicamento.valueOf(partes[1].toUpperCase());
		String codigoDeLaEnfermedad = partes[2];
		String farmaceutica = partes[3];
		Double puntuacion = Double.parseDouble(partes[4]);
		Integer indiceSomatico = Integer.parseInt(partes[5]);
		String[] fecha_partes = partes[6].split("/");
		Integer dia = Integer.parseInt(fecha_partes[0]);
		Integer mes = Integer.parseInt(fecha_partes[1]);
		Integer anyo = Integer.parseInt(fecha_partes[2]);
		LocalDate fechaDeCatalogo = LocalDate.of(anyo, mes, dia);
		
		Medicamento res = new Medicamento(nombreDelMedicamento, tipoDeMedicamento,
				codigoDeLaEnfermedad, farmaceutica, puntuacion, indiceSomatico, 
				fechaDeCatalogo);
		return res;
	}
}

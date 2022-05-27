package fp.farmaceutico;
import java.util.List;


public class TestFactoriaMedicamento {
	public static void main(String[] args) {
		// 
		String ruta = "data/medicamentos.csv";
		List<Medicamento> lista = FactoriaMedicamentos.leeFichero(ruta);
		for(Medicamento e:lista) {
			System.out.println(e);
		}
	}
}

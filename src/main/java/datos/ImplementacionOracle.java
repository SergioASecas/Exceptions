package datos;

import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public class ImplementacionOracle implements AccesoDatos {
	private boolean simularError;


	public void insertar() throws AccesoDatosEx {
		if (simularError) {
			throw new EscrituraDatosEx("Error en escritura de datos Oracle");
		}
		else {
			System.out.println("Insertar en Oracle");
		}
	}

	public void listar() throws AccesoDatosEx {
		if (simularError) {
			throw new LecturaDatosEx("Error en lectura de datos Oracle");
		}
		else {
			System.out.println("Listar en Oracle");
		}
		
	}

	public void simularError(Boolean simularError) {		
		this.simularError = simularError;
	}

	public boolean isSimularError() {
		return simularError;
	}
}

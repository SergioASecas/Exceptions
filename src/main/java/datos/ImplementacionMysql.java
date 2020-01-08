package datos;

import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;

public class ImplementacionMysql implements AccesoDatos {
	
	private boolean simularError;

	public ImplementacionMysql() {
		
	}

	public void insertar() throws AccesoDatosEx{
		if (simularError) {
			throw new EscrituraDatosEx("Error de escritura de datos");
		}
		else {
			System.out.println("Insertar desde MySQL");		
		}		
	}

	public void listar() throws AccesoDatosEx {
		if (simularError) {
			throw new LecturaDatosEx("Erorr en lista de datos");
		}
		else {
			System.out.println("Listar desde MySQL");
		}				
	}

	public void simularError(Boolean simularError) {
		this.simularError = simularError;
	}
	
	public boolean isSimularError() {
		return simularError;
	}

}

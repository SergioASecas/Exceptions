package manejoDeExcepciones;

import datos.AccesoDatos;
import datos.ImplementacionMysql;
import datos.ImplementacionOracle;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;

public class ManejoExcepciones2 {

	public static void main(String []args) {
		AccesoDatos ac = new ImplementacionMysql();
		ac.simularError(false);
		ejecutar(ac, "insertar");
		
		AccesoDatos ad = new ImplementacionOracle();
		ad.simularError(true);
		ejecutar(ad,"listar");
	}
	
	private static void ejecutar(AccesoDatos ac, String accionr) {
		if ("listar".equals(accionr)) {
			try {
				ac.listar();
			} catch (LecturaDatosEx e) {
				System.out.println("Error Lectura");
				e.printStackTrace(System.out);
			} catch (AccesoDatosEx e) {
				System.out.println("Error de acceso a datos");
				e.printStackTrace(System.out);
			}catch (Exception e) {
				System.out.println("Error general");
				e.printStackTrace(System.out);
			}
			finally {
				System.out.println("Procesar finally");
			}
		}
		else if ("insertar".equals(accionr)) {
			try {
				ac.insertar();
			} catch (AccesoDatosEx e) {
			System.out.println("Excepecion de acceso a datos");
			}
			finally {
				System.out.println("fINALLY");
			}
		}
		else {
			System.out.println();
		}
	}

}

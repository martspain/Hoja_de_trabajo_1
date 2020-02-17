import java.util.ArrayList;
/*
 * implementacionRadio.java
 * 
 * Version 1.3
 *
 * 18/01/2019
 * Diego Arredondo 
 * Bryann Alfaro 19372
 * 
 */

/**@author Bryann Alfaro
 * @author Diego de Jesus
 * @version 1.3
 * @since Enero 25,2020
 * 
 * Clase que implementa la radio. Se definen los metodos
 * que se usaran para el funcionamiento de la radio.
 *
 **/

public class implementacionRadio implements Radio{
	
	private double[] emisorasAM =new double[12];
	private double[] emisorasFM =new double[12];
	private boolean tipoFrecuencia=true;
	private boolean onOff = true;
	private double fm = 87.9;
	private double finFm = 107.9;
	private double am = 530;
	private int finAm = 1610;
	
	@Override
	/**
	 * Metodo que controla el encendido o apagado
	 * @param estado
	 */
	public boolean encenderApagar(boolean estado) {
		if(estado == true) {
			onOff = true;
			return onOff;
		}else {
			onOff = false;
			return onOff;
		}
	}
	
	
	@Override
	/**
	 * Método para guardar una estacion
	 * 
	 * @param estacion
	 *            estacion a guardar
	 * @param tipoFrecuencia
	 *            determinar si esta en AM/FM
	 * @param boton
	 * 			  boton donde se guarda
	 */
	public void guardarEstacion(double estacion,boolean tipoFrecuencia,int boton ) {
		// para FM
		if(tipoFrecuencia==true) {
			emisorasFM[boton-1]=estacion;
		}
		//para AM
		else {
			emisorasAM[boton-1]=estacion;
		}
	}
	
	@Override
	/**
	 * Método para seleccionar estacion
	 * 
	 * @param tipoFrecuencia
	 *            determinar si esta en AM/FM
	 * @param boton
	 * 			  boton de seleccion
	 */
	public double seleccionarEstacion(boolean tipoFrecuencia, int boton) {
		if(tipoFrecuencia==true) {
			if(emisorasFM[boton-1]==0) {
				return fm;
			}else {
				fm = emisorasFM[boton-1];
				return fm;
			}
			
		}else {
			if(emisorasAM[boton-1]==0) {
				return am;
			}else {
				am = emisorasAM[boton-1];
				return am;
			}
			
		}
	}
	
	@Override
	/**
	 * Método para cambiar frecuencia
	 * 
	 * @param tipo 
	 * 			 para cambio frecuencia
	 * @return tipoFrecuencia
	 */
	public boolean cambioTipoFrecuencia(boolean tipo){
			if(tipo == true) {
				tipoFrecuencia=false;
				return tipoFrecuencia;
			}else {
				tipoFrecuencia=true;
				return tipoFrecuencia;
			}
	}
	
	@Override
	/**
	 * Método para cambiar la estacion
	 * 
	 * @param tipo
	 * 			avanzar o retroceder
	 * @param tipoFrecuencia 
	 * 			Si se encuentra en AM/FM
	 * @return fm/am
	 */
	
	public double cambioEstacion(boolean tipo, boolean tipoFrecuencia) {
		//Si quiere avanzar
		if(tipo==true) {
			//Si esta en FM
			if(tipoFrecuencia==true) {
				fm += 0.2;
				if (fm > 107.9) {
					fm = 87.9;	
				}
			return fm;
			}else {
				am += 10;
				if (am > 1610) {
					am = 530;
				}
				return am;
			}
		
		} else {
			if(tipoFrecuencia==true) {
				fm -= 0.2;
				if (fm < 87.9) {
					fm = 107.9;
				}
			return fm;
			}else {
				am -= 10;
				if (am < 530) {
					am = 1610;
				}
				return am;
			}
			
		}
	}
	
	/**
	 * Método para obtener una estacion
	 * 
	 */
	public double getEstacion() {
		if (tipoFrecuencia==true) {
			return fm;
		} else {
			return am;
		}
	}
	
	@Override
	/**
	 * Metodo para obtener el tipo de frecuencia
	 * @return tipoFrecuencia
	 */
	public boolean getTipoFrecuencia() {
		return tipoFrecuencia;
	}
	
	@Override
	/**
	 * Metodo para obtener el estado
	 * @return onOff
	 */
	public boolean getEstado() {
		return onOff;
	}

}

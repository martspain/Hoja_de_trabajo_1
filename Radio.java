/*
Radio interface
Interface que tiene los métodos generales de una radio
Autores: 
Martín España	Carné: 19258
Hansel López	Carné: 19
Algoritmos y Estructuras de datos
Hoja de trabajo 1
Ultima modificación: 16/02/2020
Versión 1.0
*/

public interface Radio{
	
	//Metodo para cambiar la estacion actual (subir[true] o bajar[false])
	public double cambioEstacion(boolean upDown, boolean frequencyType);
	
	//Metodo para alternar entre tipos de frecuencia (AM o FM)
	public boolean cambioTipoFrecuencia (boolean type);
	
	//Metodo para alternar el estado de la radio (Encendido/apagado)
	public boolean encenderApagar(boolean status);
	
	//Metodo para guardar una estacion en uno de los botones
	public void guardarEstacion(double station, boolean frequencyType, int button);
	
	//Metodo para seleccionar uno de los botones y obtener la estacion guardada en el mismo
	public double seleccionarEstacion(boolean frequencyType, int button);
	
	//Metodo para obtener (getter) la estacion actual
	public double getEstacion();
	
	//Metodo para obtener (getter) el tipo de frecuencia (AM o FM)
	public boolean getTipoFrecuencia();
	
	//Metodo para obtener (getter) el estado actual de la radio(Encendido o apagado)
	public boolean getEstado();
	
}
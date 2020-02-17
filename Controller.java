/**
 * Controller class
 * Clase que maneja el menú y conecta el modelo con la vista (en este caso la clase controller actuara como la vista tambien) 
 * @author Martín España	Carné: 19258
 * @author Hansel López	Carné: 19026
 * Algoritmos y Estructuras de datos
 * Hoja de trabajo 1
 * Ultima modificación: 16/02/2020
 * Versión 1.0
*/

import java.util.Scanner;

public class Controller{
	
	Scanner input = new Scanner(System.in);
	CarRadio proto = new CarRadio();
	
	/**
	 * Metodo que corre el programa e inicia el ciclo principal
	*/
	public void runProgram(){
		boolean active = true;
		
		//Ciclo while del menu principal
		while(active){
			System.out.println("\nRadio iFruit \nMenu Principal \nIngrese la opcion que desea: \n1. Encender Radio \n2. Salir");
			String choice = input.next();
			
			//Opcion de encender la radio
			if(choice.equalsIgnoreCase("1")){
				proto.encenderApagar(true);
				
				//Mientras la radio este encendida mostrara las opciones para manipularla (menu de la radio)
				while(proto.getEstado()){
					System.out.println("\n/////////////////////////////////// \nEstacion actual: "+proto.getEstacion()+"\nFrecuencia actual: "+proto.getTipoFrecuencia()+"\n///////////////////////////////////");
					System.out.println("Que desea hacer? \n1. Cambiar de estacion \n2. Cambiar de frecuencia \n3. Guardar emisora actual en un boton \n4. Seleccionar un boton \n5. Apagar el radio");
					String secondChoice = input.next();
					boolean dial = true;
					
					//Opcion de cambiar de estacion
					switch(secondChoice){
						case "1":
							while(dial){
								System.out.println("Que frecuencia desea utilizar? \n1. AM \n2. FM");
								String freq = input.next();
								boolean dialing = true;
								
								switch(freq){
									case "1":
										while(dialing){
											proto.cambioTipoFrecuencia(true);
											System.out.println("\n/////////////////////////////////// \nEstacion actual: "+proto.getEstacion()+"\nFrecuencia actual: "+proto.getTipoFrecuencia()+"\n///////////////////////////////////");
											System.out.println("1. Subir de estacion \n2. Bajar de estacion \n3. Regresar");
											String upDown = input.next();
											if(upDown.equals("1")){
												proto.cambioEstacion(true, true);
											}
											else if(upDown.equals("2")){
												proto.cambioEstacion(false, true);
											}
											else if(upDown.equals("3")){
												dialing = false;
												dial = false;
											}
											else{
												System.out.println("Ingrese una opcion valida...");
											}
										}
									break;
									case "2":
										while(dialing){
											proto.cambioTipoFrecuencia(false);
											System.out.println("\n/////////////////////////////////// \nEstacion actual: "+proto.getEstacion()+"\nFrecuencia actual: "+proto.getTipoFrecuencia()+"\n///////////////////////////////////");
											System.out.println("1. Subir de estacion \n2. Bajar de estacion \n3. Regresar");
											String upDown = input.next();
											if(upDown.equals("1")){
												proto.cambioEstacion(true, false);
											}
											else if(upDown.equals("2")){
												proto.cambioEstacion(false, false);
											}
											else if(upDown.equals("3")){
												dialing = false;
												dial = false;
											}
											else{
												System.out.println("Ingrese una opcion valida...");
											}
										}
									break;
									default:
										System.out.println("Ingrese una opcion valida");
								}
							}
						break;
						case "2":
							if(proto.getTipoFrecuencia()){
								proto.cambioTipoFrecuencia(false);
							}
							else{
								proto.cambioTipoFrecuencia(true);
							}
						break;
						case "3":
							System.out.println("\nEn que boton desea agregar esta emisora? (Elija un numero entre el 1 y el 12)");
							try{
								int decision = input.nextInt();
								
								if(decision >= 1 && decision <= 12){
									proto.guardarEstacion(proto.getEstacion(), proto.getTipoFrecuencia(), decision);
								}
								else{
									System.out.println("\nIngrese un numero dentro del rango establecido...");
								}
							}
							catch(Exception e){
								System.out.println("\nPorfavor, ingrese numeros solamente...");
							}
						break;
						case "4":
							System.out.println("Que botones desea acceder? \n1. Frecuencia AM \n2. Frecuencia FM");
							try{
								String buttonFreq = input.next();
								double var;
								String fri;
								
								if(buttonFreq.equals("1")){
									System.out.println("Seleccione un boton (Elija un numero entre el 1 y el 12)");
									int number = input.nextInt();
									var = proto.seleccionarEstacion(true, number);
									fri = "AM";
								}
								else if(buttonFreq.equals("2")){
									System.out.println("Seleccione un boton (Elija un numero entre el 1 y el 12)");
									int number = input.nextInt();
									var = proto.seleccionarEstacion(false, number);
									fri = "FM";
								}
								System.out.println("La estacion seleccionada es la "+var+" de la frecuencia "+fri);
							}
							catch(Exception e){
								System.out.println("\nError: Ingrese un numero porfavor...");
							}
						break;
						case "5":
							proto.encenderApagar(false);
							System.out.println("Radio apagada...");
						break;
						default:
							System.out.println("Porfavor, ingrese una opcion valida...");
					}
				}
			}
			
			//Opcion de salir del programa
			else if(choice.equalsIgnoreCase("2")){
				System.out.println("\nGracias por utilizar la mejor radio de Los Santos");
				active = false;
			}
			
			//En caso de que ingrese una opcion invalida
			else{
				System.out.println("\n########### \nIngrese una opcion valida \n###########");
			}
		}
		
	}
	
}
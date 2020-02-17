/**
 * CarRadio Class
 * Implementación para la interfaz radio 
 * @author Martín España	Carné: 19258
 * @author Hansel López	Carné: 19026
 * Algoritmos y Estructuras de datos
 * Hoja de trabajo 1
 * Ultima modificación: 16/02/2020
 * Versión 1.0
*/

public class CarRadio implements Radio{
    private boolean status;
    private double currentStation;
    double[] estacionesAM = {530,540,550,560,570,580,590,1000,1010,1020,1030,1040};
    double[] estacionesFM = {87.9,88.1,88.3,88.5,88.7,88.9,89.1,89.3,89.5,89.7,100.1,100.3};
    private boolean frequencyType;
    int posicion;
    
    
    public double cambioEstacion(boolean upDown, boolean frequencyType){
        
        if(frequencyType == true){
            for(int i=0;i<12;i++){
                if(currentStation == estacionesAM[i]){
                    posicion = i;
                }
            }
            if(upDown == true){
                currentStation = estacionesAM[posicion+1];
            }else if(upDown == false){
                currentStation = estacionesAM[posicion-1];
            }
        }else if(frequencyType == false){
            for(int i=0;i<12;i++){
                if(currentStation == estacionesFM[i]){
                    posicion = i;
                }
            }
            if(upDown == true){
                currentStation = estacionesFM[posicion+1];
            }else if(upDown == false){
                currentStation = estacionesFM[posicion-1];
            }
        }        
        return currentStation;
    }

    public boolean cambioTipoFrecuencia (boolean type){
        this.frequencyType = type;
        return this.frequencyType;
    }

    public boolean encenderApagar(boolean status){
        this.status = status;
        return this.status;
    }

    public void guardarEstacion(double station, boolean frequencyType, int button){
        if(button>=0 && button<=11){
            button = button-1;
            if(frequencyType == true){            
                estacionesAM[button] = station;
            }else if(frequencyType == false){
                estacionesFM[button] = station;
            }
        }
    }

    public double seleccionarEstacion(boolean frequencyType, int button){
        if(button>=0 && button<=11){
            button = button-1;
            if(frequencyType == true){            
                currentStation = estacionesAM[button];
            }else if(frequencyType == false){
                currentStation = estacionesFM[button];
            }
        }
        return currentStation;
    }

    public double getEstacion(){
        return this.currentStation;
    }

    public boolean getTipoFrecuencia(){       
        return this.frequencyType;
    }

    public boolean getEstado(){       
        return this.status;
    }
}
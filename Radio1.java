

/**
 *
 * @author Jose Ponce 19092 y Hugo Roman 19199 Algoritmos y estructuras de datos
 *         19/01/2019 Radio1.java
 */
public class Radio1 implements Radio {// Clase radio1 que implementa a la clase radio
    // private int estado;


    private String estado1;
    private int tipo1;
    private int numero;
    private int frecuenciaAM = 530;
    private double frecuenciaFM = 87.9;
    private String frecuencia;
    private boolean encenderapagar;
    private boolean tipofrec;
    private boolean sumarrestar;
    private double frecuenciaactual;
    private double[] estAM = new double[13];
    private double[] estFM = new double [13];

    // Constructor
    public Radio1() {
        // estado = 0;
        estado1 = "";
        numero = 0;
        frecuenciaFM = 87.9;
        frecuenciaAM = 530;
        frecuencia = "";
        tipo1 = 0;
        encenderapagar = false;
        tipofrec = true;
        sumarrestar = true;
        frecuenciaactual=0;
    }

    // Metodos setters y getters de la clase radio1

    
    public void setSumarrestar(boolean sumarrestar) {
        this.sumarrestar = sumarrestar;
    }

    public boolean isSumarrestar() {
        return sumarrestar;
    }


    public boolean isEncenderapagar() {
        return encenderapagar;
    }

    public void setEncenderapagar(boolean encenderapagar) {
        this.encenderapagar = encenderapagar;
    }

    public void setFrecuenciaAM(int frecuenciaAM) {
        this.frecuenciaAM = frecuenciaAM;
    }

    public void setFrecuenciaFM(double frecuenciaFM) {
        this.frecuenciaFM = frecuenciaFM;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getFrecuenciaAM() {
        return frecuenciaAM;
    }

    public double getFrecuenciaFM() {
        return frecuenciaFM;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // public int getEstado() {
    // return estado;
    // }

    public String getEstado1() {
        return estado1;
    }

    // public void setEstado(int estado) {
    // this.estado = estado;
    // }

    public void setEstado1(String estado1) {
        this.estado1 = estado1;
    }

    // Listas creadas para que el usuario guarde sus emisoras favoritas
    String[] boton1 = new String[3];
    String[] boton2 = new String[3];
    String[] boton3 = new String[3];
    String[] boton4 = new String[3];
    String[] boton5 = new String[3];
    String[] boton6 = new String[3];
    String[] boton7 = new String[3];
    String[] boton8 = new String[3];
    String[] boton9 = new String[3];
    String[] boton10 = new String[3];
    String[] boton11 = new String[3];
    String[] boton12 = new String[3];

    public String[] getBoton1() {
        return boton1;
    }

    public void setBoton1(String[] boton1) {
        this.boton1 = boton1;
    }

    @Override
    public double cambioEstacion(boolean subirbajar, boolean tipofrec) { // Funcion para cambiar de estacion, entre FM y// AM
        if(encenderapagar){
                                                                      
        if (tipofrec) {
    
            if (subirbajar) {
                if (frecuenciaAM==1610){
                    frecuenciaAM=530;
                }
                frecuenciaAM += 10;
                frecuenciaactual=frecuenciaAM;
            } else {
                if (frecuenciaAM==530){
                    frecuenciaAM=1610;

                }
                frecuenciaAM -= 10;
                frecuenciaactual=frecuenciaAM;

            }

        } else {
        
        

            if (subirbajar) {
                    
                if(frecuenciaFM>=107.9){
                    frecuenciaFM=87.9;
            }
                frecuenciaFM += 0.2;
                frecuenciaactual=frecuenciaFM;

            } else {
                if(frecuenciaFM==87.9){
                    frecuenciaFM=107.9;
                }
                frecuenciaFM -= 0.2;
                frecuenciaactual=frecuenciaFM;


            }

        }}
		return frecuenciaactual;
    }

    @Override
    public boolean cambioTipoFrecuencia(boolean tipo) { // Funcion para cambiar el tipo de frecuencia entre AM Y FM
        if(encenderapagar){
        if (tipofrec) {
            frecuencia = "FM";
            tipofrec=false;
        } else
         {
            frecuencia = "AM";
            tipofrec=true;
        }
    }
        return tipofrec;
    }

    @Override
    public boolean encenderApagar(boolean estado) { // Funcion para encender el radio
        if (encenderapagar){
            encenderapagar=false;

        }
        else{
            encenderapagar=true;
        }
        return estado;

    }

  
    @Override
    public void guardarEstacion(double estacion, boolean tipoFrecuencia, int boton) { // Funcion para guardar estacion
                                                                                      // favorita

        if(tipoFrecuencia == true){
            estAM[boton] = estacion;
            
            
        }
            else{
            estFM[boton] = estacion;
            
            
            }
            
    }

    @Override
    public double seleccionarEstacion(boolean tipoFrecuencia, int boton) {
        double nuevaEstacion;
       if(tipoFrecuencia == true){
           nuevaEstacion=estAM[boton];
       }else{
           nuevaEstacion = estFM[boton];
       }
       
       return nuevaEstacion;
        
    }

    @Override
    public double getEstacion() {
        // TODO Auto-generated method stub
        return frecuenciaactual;
    }

    @Override
    public boolean getEstado() {
        return encenderapagar;
    }

    @Override
    public boolean getTipoFrecuencia() {
        
        return tipofrec;
    }


            

    
}


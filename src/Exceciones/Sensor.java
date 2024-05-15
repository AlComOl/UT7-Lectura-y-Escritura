package Exceciones;
/*
 * @autor Álvaro Comenge 
 * 
 * 
 *@fecha 15/05/24 
 */



		class SensorNoDisponible extends Exception {
		    private double dato;
		
		    SensorNoDisponible(double x) {
		        super("El sensor no está disponible y no se ha podido enviar el dato");
		        dato = x;
		    }
		
		    public double valor() {
		        return dato;
		    }
		}

		class Sensor {
		    public boolean enviarDato() {
		        return true; // Cambia esto a `false` para probar la excepción
		    }
		}
		
		class GestorSensor {
			    private Sensor s;
			
			    public GestorSensor(Sensor s) {
			        this.s = s;
			    }
	
			    public void enviaDatoAlSensor(double dato) throws SensorNoDisponible {
			        if (s.enviarDato()) {
			            throw new SensorNoDisponible(dato);
			        }
			    }
		}


    


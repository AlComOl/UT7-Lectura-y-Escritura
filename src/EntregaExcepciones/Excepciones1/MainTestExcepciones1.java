package EntregaExcepciones.Excepciones1;

import java.io.IOException;

/*
 * @autor Álvaro Comenge 
 * 
 * 
 * @fecha 15/05/24 
 */
public class MainTestExcepciones1 {

    // 1. Un método que propaga una excepción:
    public void f() throws IOException {
        // Fragmento de código que puede 
//    		lanzar una excepción de tipo IOException
        throw new IOException("Se ha producido un error de E/S");
    }

    // 2. Un método equivalente que no propaga la excepción:
    public void fNoPropaga() {
        // Fragmento de código libre de excepciones
        try {
            // Fragmento de código que puede lanzar una excepción de tipo IOException
            // (p.ej. Acceso a un fichero)
            throw new IOException("Se ha producido un error de E/S");
        } catch (IOException error) {
            // Tratamiento de la excepción
            System.out.println("Error capturado: " + error.getMessage());
        } finally {
            // Liberar recursos (siempre se hace)
            System.out.println("Liberar recursos.");
        }
    }

    // Definición de la clase Cuenta
    static class Cuenta {
        private String id;
        private int balance;

        public Cuenta(String id, int balance) {
            this.id = id;
            this.balance = balance;
        }

        public String getId() {
            return id;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    // Definición de la clase Database
    static class Database {
        public void startTransaction() {
            System.out.println("Transacción iniciada.");
        }

        public Cuenta find(String id) {
            // Simulación de búsqueda en la base de datos
            if (id.equals("123")) {
                return new Cuenta("123", 1000);
            } else if (id.equals("456")) {
                return new Cuenta("456", 2000);
            }
            return null;
        }

        public void store(Cuenta cuenta) {
            System.out.println("Cuenta " + cuenta.getId() + " almacenada con balance " + cuenta.getBalance());
        }

        public void commit() {
            System.out.println("Transacción confirmada.");
        }

        public void rollback() {
            System.out.println("Transacción cancelada.");
        }
    }

   

    public void transferir(String IDorigen, String IDdestino, int cantidad) {
    
    	
        Cuenta origen;
        Cuenta destino;
        // Comenzar transacción
        Database database = new Database();
        database.startTransaction();
        try {
            origen = database.find(IDorigen);
            if (origen == null) throw new Exception("No existe " + IDorigen);
            
            origen.setBalance(origen.getBalance() - cantidad);
            database.store(origen);
            destino = database.find(IDdestino);
            
            if (destino == null) throw new Exception("No existe " + IDdestino);
            destino.setBalance(destino.getBalance() + cantidad);
            database.store(destino);
            
            // Confirmar la transacción
            database.commit();
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
            // Cancelar la transacción
            database.rollback();
        }
    }

    // Creacion de nuevos tipos de excepciones
    public static class DivideByZeroException extends ArithmeticException {
        public DivideByZeroException(String message) {
            super(message);
        }
    }

    public double dividir(int num, int den) throws DivideByZeroException {
        if (den == 0)
            throw new DivideByZeroException("Error: División por cero!");
        return ((double) num / (double) den);
    }

    public static void main(String[] args) {
        MainTestExcepciones1 test = new MainTestExcepciones1();
        
        // Prueba del metodo que propaga una excepcion
        try {
            test.f();
        } catch (IOException e) {
            System.out.println("Excepción capturada en main: " + e.getMessage());
        }

        // Prueba del metodo que no propaga la excepcion
        test.fNoPropaga();

        // Prueba del método de transferencia
        test.transferir("123", "456", 500);

        // Prueba de la excepcion personalizada
        try {
            double resultado = test.dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (DivideByZeroException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}

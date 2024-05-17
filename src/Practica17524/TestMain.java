package Practica17524;

import java.io.*;
import java.util.*;

/************************************
 * @autor Alvaro Comenge Oliver
 * 
 * @Practica 17/05/24
 * @descripcion Practica Ficheros
 * 
 * Entrega por la tarde
 * 
 *******************************/

public class TestMain {

    static Scanner sc = new Scanner(System.in);
    static String titulo, tipo;
    static int codigo, dificultad;

    public static void getMenu() {
        System.out.println("Elige una opcion:");
        System.out.println("1. Anyadir Receta");
        System.out.println("2. Eliminar receta");
        System.out.println("3. Modificar Receta");
        System.out.println("4. Listado de Recetas HTML");
        System.out.println("5. Listado de recetas de un tipo de receta");
        System.out.println("6. Ver archivo");
        System.out.println("0. Salir");
    }

    public static void main(String[] args) throws IOException ,ExcepcionColeccion{
        int key;

        ArrayList<Receta> coleccion = new ArrayList<Receta>();
        String nfichero = "receta.obj";

        crearFicheroObjetos(nfichero); // creamos el archivo 
        cargarDesdeArchivo(nfichero, coleccion); // cargar recetas desde archivo

        do {
            getMenu();
            key = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (key) {
                case 1:
                    AnyadirReceta(coleccion);
                    llenarFicheroObjetos(nfichero, coleccion);
                    break;
                case 2:
                    eliminarReceta(coleccion);
                    llenarFicheroObjetos(nfichero, coleccion);
                    break;
                case 3:
                    modificarReceta( coleccion);
                    llenarFicheroObjetos(nfichero, coleccion);
                    break;
                case 4:
                    System.out.println("Introduce el nombre del archivo .html");
                    titulo = sc.nextLine();
                    generarListadoHTML(coleccion, titulo);
                    break;
                case 5:
                	System.out.println("Anyade tipo para mostrar todas)");
                    tipo = sc.nextLine();
                	mostrarRecetasPorTipo(coleccion,tipo);
                    break;
                case 6:
                    System.out.println(coleccion.toString());
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("La opcion no esta contemplada");
            }
        } while (key != 0);

        sc.close();
    }
    /**
     * Añade una nueva receta a la colección.
     * 
     * @param coleccion La colección de recetas.
     */
    public static void AnyadirReceta(ArrayList<Receta> coleccion) {
        int codigo, dificultad;
        String titulo, tipo;
            System.out.println("Anyade codigo de la receta (int)");
            codigo = sc.nextInt();
            sc.nextLine();
            System.out.println("Anyade titulo de la receta (string)");
            titulo = sc.nextLine();
            System.out.println("Anyade tipo de la receta (primero, segundo, postre, otro)");
            tipo = sc.nextLine();
            System.out.println("Anyade dificultad de la receta (de 1 a 5)");
            dificultad = sc.nextInt();

            Receta c = new Receta(codigo, titulo, tipo, dificultad);
            coleccion.add(c);
        }

    /**
     * Carga las recetas desde un archivo en la colección.
     * 
     * @param fichero El nombre del archivo desde el cual cargar las recetas.
     * @param coleccion La colección donde cargar las recetas.
     */
    public static void cargarDesdeArchivo(String fichero, ArrayList<Receta> coleccion) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fichero);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean finArchivo = false;
            while (!finArchivo) {
                try {
                    Receta r = (Receta) objectInputStream.readObject();
                    if (r == null) {
                        finArchivo = true;
                    } else {
                        coleccion.add(r);
                        System.out.println("El archivo se añadió al array de recetas");
                    }
                } catch (EOFException e) {
                    System.out.println("Se ha alcanzado el final del archivo.");
                    finArchivo = true;
                }
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    /**
     * Llena el archivo de objetos con las recetas de la colección.
     * 
     * @param fichero El nombre del archivo donde escribir las recetas.
     * @param coleccion La colección de recetas a escribir en el archivo.
     */
    public static void llenarFicheroObjetos(String fichero, ArrayList<Receta> coleccion) {
        try (FileOutputStream fo = new FileOutputStream(fichero);
             MiObjectOutputStream mObject = new MiObjectOutputStream(fo)) {
            for (Receta c : coleccion) {
                mObject.writeObject(c);
            }
            mObject.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    /**
     * Crea un archivo de objetos con una receta inicial.
     * 
     * @param nfichero El nombre del archivo a crear.
     * @throws IOException Si hay un error de entrada/salida.
     */
    public static void crearFicheroObjetos(String nfichero) throws IOException {
        File f = new File(nfichero);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        Receta c = new Receta(1, "Comida", "primero", 1);
        os.writeObject(c);
        os.close();
    }
    /**
     * Modifica una receta existente en la colección.
     * 
     * @param coleccion La colección de recetas.
     */
    public static void modificarReceta(ArrayList<Receta> coleccion) {
    	boolean esta=false;
    	System.out.println("Introduce el codigo de la receta");
    	codigo=sc.nextInt();
    	
    	for(Receta r : coleccion) {
    		
    		if(r.getCodigo()==codigo) {
    		esta=true;
    			
    			 System.out.println("Anyade titulo de la receta (string)");
                 titulo = sc.nextLine();
                 System.out.println("Anyade tipo de la receta (primero, segundo, postre, otro)");
                 tipo = sc.nextLine();
                 System.out.println("Anyade dificultad de la receta (de 1 a 5)");
                 dificultad = sc.nextInt();
                 
                 r.setTitulo(titulo);
                 r.setTipo(tipo);
                 r.setDificultad(dificultad);
                 
    		
    		}	
    	}  
    	if(!esta){
    		System.out.println("No se ha modificado la receta");
    	}
    }
    /**
     * Elimina una receta de la colección.
     * 
     * @param coleccion La colección de recetas.
     */
    public static void eliminarReceta(ArrayList<Receta> coleccion) {
    
    	try {
    		 boolean encontrado = false;
    	        Iterator<Receta> iterator = coleccion.iterator();
    	        System.out.println("Elimina codigo de la receta (int)");
    	        codigo = sc.nextInt();
    	        while (iterator.hasNext()) {
    	            Receta r = iterator.next();
    	            if (r.getCodigo() == codigo) {
    	                iterator.remove();
    	                encontrado = true;   
    	            }
    	        }
    	        
    	        if(!encontrado) {
    	        	throw new ExcepcionColeccion("La receta con el código " + codigo + " no está en la colección.");
    	        }
    	        
		} catch (ExcepcionColeccion e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}
    }
    /**
     * Muestra las recetas de un tipo específico.
     * 
     * @param coleccion La colección de recetas.
     * @param tipoReceta El tipo de receta a mostrar.
     */
    public static void mostrarRecetasPorTipo(ArrayList<Receta> coleccion, String tipoReceta) {
        System.out.println("Recetas del tipo " + tipoReceta + ":");
        boolean encontradas = false;
        
        for (Receta receta : coleccion) {
            if (receta.getTipo().equalsIgnoreCase(tipoReceta)) {
                System.out.println(receta);
                encontradas = true;
            }
        }
        
        if (!encontradas) {
            System.out.println("No se encontraron recetas del tipo " + tipoReceta);
        }
    }
    
    /**
     * Genera un listado de recetas en formato HTML y lo guarda en un archivo.
     * 
     * @param coleccion La colección de recetas.
     * @param nombreArchivo El nombre del archivo donde se guardará el listado.
     */
    public static void generarListadoHTML(ArrayList<Receta> coleccion, String nombreArchivo) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write("<!DOCTYPE html>\n");
            escritor.write("<html>\n");
            escritor.write("<head>\n");
            escritor.write("<title>Listado de Recetas</title>\n");
            escritor.write("</head>\n");
            escritor.write("<body>\n");
            escritor.write("<h1>Listado de Recetas</h1>\n");
            escritor.write("<table border=\"1\">\n");
            escritor.write("<tr><th>Código</th><th>Título</th><th>Tipo</th><th>Dificultad</th></tr>\n");
            for (Receta receta : coleccion) {
                escritor.write("<tr>\n");
                escritor.write("<td>" + receta.getCodigo() + "</td>\n");
                escritor.write("<td>" + receta.getTitulo() + "</td>\n");
                escritor.write("<td>" + receta.getTipo() + "</td>\n");
                escritor.write("<td>" + receta.getDificultad() + "</td>\n");
                escritor.write("</tr>\n");
            }
            escritor.write("</table>\n");
            escritor.write("</body>\n");
            escritor.write("</html>\n");
            System.out.println("El listado de recetas se ha generado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error");
        }
}
    
    
}
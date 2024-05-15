package VocabularioFicherosDeObgetos;
import java.io.Serializable;

/***************************************************************
 * @autor Álvaro Comenge
 * @descripcion Ejerccio Vocabulario
 * @version ArrayList
 * @Fecha 14-5-2024
 * 
 * **************************************************************/
public class Palabra implements Serializable{
	
	private String espanol;
	private String ingles;
	private String frances;
	
//	contructor parametros
	
	public Palabra(String espanol, String ingles, String frances) {
	
		this.espanol = espanol;
		this.ingles = ingles;
		this.frances = frances;
	}
	
	
//	geters setters
	public String getEspanol() {
		return espanol;
	}




	public void setEspanol(String espanol) {
		this.espanol = espanol;
	}


	public String getIngles() {
		return ingles;
	}


	public void setIngles(String ingles) {
		this.ingles = ingles;
	}


	public String getFrances() {
		return frances;
	}


	public void setFrances(String frances) {
		this.frances = frances;
	}
	
	
	@Override
    public String toString() {
        return "Espanyol: " + espanol + ", Ingles: " + ingles + ", Frances: " + frances;
    }	
		
	}

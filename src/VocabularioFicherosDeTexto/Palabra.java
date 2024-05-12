package VocabularioFicherosDeTexto;


/***************************************************************
 * @autor Álvaro Comenge
 * @descripcion Ejerccio Vocabulario
 * @version ArrayList
 * @Fecha 20-2-2024
 * 
 * **************************************************************/
public class Palabra {
	
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
		/******************************************************************
		 * @autor acome
		 * @descripcion Se sobrescribe el método toString() para proporcionar
		 *  una representación de cadena de la instancia de Palabra, mostrando las 
		 *  traducciones en español, inglés y francés.
		 * 
		 * 
		 * ****************************************************************/
		StringBuilder idioma = new StringBuilder();//Se crea un instancia de StringBuilder
		//con idioma.append agregamos a la cadena 
		idioma.append("\n Traduccion al Espanol : ");idioma.append(espanol);
		idioma.append("\n Traduccion al Ingles : ");idioma.append(ingles);
		idioma.append("\n Traduccion al Frances : ");idioma.append(frances);
		return idioma.toString();//devolvemos la cadena
	}
	 
}
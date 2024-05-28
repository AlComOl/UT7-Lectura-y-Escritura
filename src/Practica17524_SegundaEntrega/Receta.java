package Practica17524_SegundaEntrega;

import java.io.Serializable;

public class Receta implements Serializable {
	
	
	
	private int codigo;
	private String titulo;
	private String tipo;
	private int dificultad;
	
	
	
	public Receta() {
		
		
	}
	
	public Receta(int codigo, String titulo, String tipo, int dificultad) {
		
		this.codigo = codigo;
		this.titulo = titulo;
		this.tipo = tipo;
		this.dificultad = dificultad;
	}





	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public int getDificultad() {
		return dificultad;
	}



	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	
	
	@Override
    public String toString() {
        return "Receta{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", dificultad=" + dificultad +
                '}';
    }
}
	
	
	
	


package Practica17524;



public class ExcepcionColeccion  extends Exception{
	private int pos;
	
		public ExcepcionColeccion(String s, int pos) {
			super(s);
			this.pos=pos;
		
		}
		
		public ExcepcionColeccion(String s) {
			super(s);
		}
		public int ExcepcionColeccion() {
			return pos;
		}
	

}

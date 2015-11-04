
package Listas;

public interface ILista extends Iterable<Object>{
	public void insertar(Object dato);
	
	public boolean esVacia();
	
	public void vaciar();
	
	public void borrarInicio();
	
	public Object recuperar(Object dato);
}

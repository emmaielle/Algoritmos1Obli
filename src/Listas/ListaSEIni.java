
package Listas;

import java.io.File.*;
import java.util.Iterator;

public class ListaSEIni implements ILista{

	public NodoLista inicio;
	
	public void insertar(Object dato) {
		inicio = new NodoLista(dato,inicio);
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {
			
			private NodoLista aux = inicio;
			
			@Override
			public void remove() {
				
			}
			
			@Override
			public Object next() {
				Object actual = aux.getDato();
				aux = aux.getSig();
				return actual;
			}
			
			@Override
			public boolean hasNext() {
				return aux != null;
			}
			
			
		};
	}
	
	
	// clase arriba, que herede de estas dos y luego clases abajo que hereden

}

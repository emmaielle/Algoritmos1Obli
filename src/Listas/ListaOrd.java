package Listas;

import java.util.Comparator;
import java.util.Iterator;

public class ListaOrd implements ILista {

	private NodoLista inicio;
	private Comparator<Object> comp;
	
	public ListaOrd(Comparator<Object> comp) {
		this.comp = comp;
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

	@Override
	public void insertar(Object dato) {
		if(inicio == null || comp.compare(inicio.getDato(),dato)>=0)
			inicio = new NodoLista(dato,inicio);
		else{
			NodoLista aux = inicio;
			while(aux.getSig()!=null && comp.compare(aux.getSig().getDato(),dato)<0)
				aux = aux.getSig();
			aux.setSig(new NodoLista(dato,aux.getSig()));
		}
	}

}

package Listas;

import java.util.Comparator;
import java.util.Iterator;

public class ListaOrd implements ILista {

	private NodoLista inicio;
	private Comparator<Object> comp;
	
	public ListaOrd(Comparator<Object> comp) {
		this.comp = comp;
	}
	
	//moi
	//PRE:
    //POS: Retorna true si la lista no tiene nodos
	@Override
    public boolean esVacia(){
        if (this.inicio==null)
            return true;
        else
            return false;
      }
    
	//moi handmade
	// cambiar a DevolverX(int cual)
	public Object devolverPrimero(){
		return inicio.getDato();
	}
	
    //moi
	@Override
    public void vaciar(){
        //en java alcanza con apuntar inicio y fin a null
        inicio=null;
//	        while (inicio!=null)
//	            borrarInicio();
    }
    
    //moi
	@Override
    public void borrarInicio(){
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }
    }
	
	//PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(Object n){
        if (this.esVacia())
            return;
        if (this.inicio.getDato()== n)
            this.borrarInicio();
        else
        {
            NodoLista aux=this.inicio;
            while (aux.getSig()!=null && aux.getSig().getDato() != n)
                aux=aux.getSig();
            //lo encontré o llegué al final de la lista
            if (aux.getSig()!=null){
                NodoLista borrar = aux.getSig();
                aux.setSig(borrar.getSig());
                borrar.setSig(null);
            }
        }
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

package Listas;

import java.util.Comparator;
import java.util.Iterator;

public class ListaOrd implements ILista, Cloneable {

	private NodoLista inicio;
	private Comparator<Object> comp;
	
	public ListaOrd(Comparator<Object> comp) {
		this.comp = comp;
	}
	
	//================================================================================
    // Overrides
    //================================================================================

	@Override
	public void insertar(Object dato) {
		if(inicio == null || comp.compare(inicio.getDato(),dato) >=0)
			inicio = new NodoLista(dato,inicio);
		else{
			NodoLista aux = inicio;
			while(aux.getSig()!=null && comp.compare(aux.getSig().getDato(),dato)<0)
				aux = aux.getSig();
			aux.setSig(new NodoLista(dato,aux.getSig()));
		}
	}
	
	//PRE:
    //POS: Retorna true si la lista no tiene nodos
	@Override
    public boolean esVacia(){
        if (this.inicio==null)
            return true;
        else
            return false;
      }
	
	@Override
    public void vaciar(){
        //en java alcanza con apuntar inicio y fin a null
        inicio=null;
        // while (inicio!=null)
        // 	borrarInicio();
    }

	@Override
    public void borrarInicio(){
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }
    }
    
	@Override
	public Object recuperar(Object dato){
		NodoLista aux = inicio;
		while(aux != null){
			if (aux.getDato().equals(dato)) return aux.getDato();
			aux = aux.getSig();
		}
		return null;
	}
	
	@Override
	public int largo(){
		int cont=0;
        if (!this.esVacia()){
            NodoLista aux=this.inicio;
            while (aux!=null){
                 aux=aux.getSig();
                 cont ++;
            }
        }
        return cont;
	}
	
	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {
			
			private NodoLista aux = inicio;
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
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
	public ILista clone(){
		ILista lis = new ListaSEFin(); // habria que hacer la clase LisSEIFin
		NodoLista aux = inicio;
		while (aux!=null){
			lis.insertar(aux.getDato()); //nodo que tiene zona
			//tenemos memoria distinta que apunta al mismo objeto
			aux = aux.getSig();
		}
		return lis;
	}
	
	//================================================================================
    // Class-specific methods
    //================================================================================

	public Object devolverPrimero(){
		return inicio.getDato();
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
            while (aux.getSig()!=null && !aux.getSig().getDato().equals(n))
                aux=aux.getSig();
            //lo encontré o llegué al final de la lista
            if (aux.getSig()!=null){
                NodoLista borrar = aux.getSig();
                aux.setSig(borrar.getSig());
                borrar.setSig(null);
            }
        }
    }
	
    //================================================================================
    // Properties
    //================================================================================

	public NodoLista getInicio(){
		return this.inicio;
	}
	
}

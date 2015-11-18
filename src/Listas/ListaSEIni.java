
package Listas;

import java.util.Iterator;

public class ListaSEIni implements ILista{

	public NodoLista inicio;
	
	//================================================================================
    // Overrides
    //================================================================================
	
	@Override
	public void insertar(Object dato) {
		// inserta todo al siempre al inicio de la lista
		inicio = new NodoLista(dato,inicio);
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
		ILista lis = new ListaSEIni(); 
		NodoLista aux = inicio;
		while (aux!=null){
			lis.insertar(aux.getDato()); 
			aux = aux.getSig();
		}
		return lis;
	}
    
	//================================================================================
    // Properties
    //================================================================================

	public NodoLista getInicio(){
		return this.inicio;
	}

}

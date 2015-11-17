
package Listas;

import java.util.Iterator;

public class ListaSEFin implements ILista{

	public NodoLista fin;
	
	//================================================================================
    // Overrides
    //================================================================================
	
	@Override
	public void insertar(Object o) {
		//NodoLista nuevo= new NodoLista(n);
        if (this.esVacia())
        	fin = new NodoLista(o);
        else
        {
            NodoLista aux=this.fin;
            while (aux.getSig() != null)
                aux=aux.getSig();
            NodoLista nuevo= new NodoLista(o);
            aux.setSig(nuevo);
        }
		
	}
	
	//PRE:
    //POS: Retorna true si la lista no tiene nodos
	@Override
    public boolean esVacia(){
        if (this.fin==null)
            return true;
        else
            return false;
      }
    
	@Override
    public void vaciar(){
        //en java alcanza con apuntar inicio y fin a null
        fin=null;
//        while (inicio!=null)
//            borrarInicio();
    }
	
	@Override
    public void borrarInicio(){
        if (!this.esVacia()){
            this.fin=this.fin.getSig();
        }
    }
	
	@Override
	public Object recuperar(Object dato){
		NodoLista aux = fin;
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
            NodoLista aux=this.fin;
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
			
			private NodoLista aux = fin;
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public NodoLista next() {
				NodoLista actual = aux;
				aux = aux.getSig();
				return actual;
			}
			
			@Override
			public boolean hasNext() {
				return aux != null;
			}
			
		};
	}
	
//    //PRE: 
//    //POS: Agrega un nuevo Nodo al principio de la lista
//    public void agregarInicio(Object o){
//        NodoLista nuevo= new NodoLista(o);
//        nuevo.setSig(inicio);
//        this.inicio=nuevo;
//        if(this.fin==null)//estoy insertando el primer nodo
//            this.fin=nuevo;
//        }
//    

    @Override
    public ILista clon(){
		ILista lis = new ListaSEFin(); 
		NodoLista aux = fin;
		while (aux!=null){
			lis.insertar(aux.getDato()); //nodo que tiene zona
			//tenemos memoria distinta que apunta al mismo objeto
			aux = aux.getSig();
		}
		return lis;
	}
    
	//================================================================================
    // Properties
    //================================================================================

	public NodoLista getFin(){
		return this.fin;
	}

}
	
	



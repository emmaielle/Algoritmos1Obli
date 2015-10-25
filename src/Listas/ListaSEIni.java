
package Listas;

import java.util.Iterator;

public class ListaSEIni implements ILista{

	public NodoLista inicio;
	public NodoLista fin;
	
	public void insertar(Object dato) {
		inicio = new NodoLista(dato,inicio);
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
    
    //moi
	@Override
    public void vaciar(){
        //en java alcanza con apuntar inicio y fin a null
        inicio=null;
//        while (inicio!=null)
//            borrarInicio();
    }
    
    //moi
	@Override
    public void borrarInicio(){
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }
    }
    
    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public void agregarInicio(Object o){
        NodoLista nuevo= new NodoLista(o);
        nuevo.setSig(inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        }
    
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(Object o){
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia())
            this.agregarInicio(o);
        else
        {
            NodoLista aux=this.inicio;
            while (aux.getSig() != null)
                aux=aux.getSig();
            NodoLista nuevo= new NodoLista(o);
            aux.setSig(nuevo);
            this.fin=nuevo;
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
	
	
	// clase arriba, que herede de estas dos y luego clases abajo que hereden

}

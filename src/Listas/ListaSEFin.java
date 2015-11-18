
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
			
			// el metodo next() devuelve directamente el NodoLista, porque para el metodo duracion que toma una ListaSEFin, necesito
			// determinar el siguiente de una iteracion sin moverme a la siguiente iteracion (es decir, el i++ de las iteraciones
			// en listas convencionales), y con las listas manuales solo sé hacerlo accediendo al nodoLista
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
	
    @Override
    public ILista clone(){
		ILista lis = new ListaSEFin(); 
		NodoLista aux = fin;
		while (aux!=null){
			lis.insertar(aux.getDato()); 
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
	
	



package Listas;

import java.util.Iterator;

public class ListaSEFin implements ILista {

	public NodoLista fin;
	
	public void insertar(Object dato) {
		fin = new NodoLista(dato,fin);
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
	
	// mal
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
	public ILista clon(){
		ILista lis = new ListaSEFin(); // habria que hacer la clase LisSEIFin
		NodoLista aux = fin;
		while (aux!=null){
			lis.insertar(aux.getDato()); //nodo que tiene zona
			//tenemos memoria distinta que apunta al mismo objeto
			aux = aux.getSig();
		}
		return lis;
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
	
	public Object mostrarX(int i){
        if (this.esVacia())
            return null;
        else  {
            NodoLista aux = this.fin;
            int n = 0;
            while (aux!=null)  {
                if (n == i) return aux.getDato();
            	aux=aux.getSig();
                n++;
            }
            return null;
        }
	}
	
	//================================================================================
    // Properties
    //================================================================================

	public NodoLista getFin(){
		return this.fin;
	}
	
}

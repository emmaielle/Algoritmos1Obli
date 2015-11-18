package Listas;


public class Queue implements IQueue, Cloneable {

	private NodoLista inicio;
	private NodoLista fin;
	
	public Queue(){
		inicio = fin = null;
	}
	
	//================================================================================
    // Overrides de IQueue
    //================================================================================
	
	// insertar al final de la lista
	@Override
	public void enqueue(Object o){
		NodoLista aux = new NodoLista(o);
		if (inicio == null){
			fin = aux;
			inicio = fin;
		}
		else {
			fin.setSig(aux);
			fin = fin.getSig();
		}
	}

	// eliminar el primero de la lista
	public void dequeue(){
		NodoLista aux = inicio;
		inicio = inicio.getSig();
		aux.setSig(null);
		if (inicio == null) fin = null;
	}

	// retorna primer elemento de lista
	@Override
	public Object front (){
		return inicio.getDato();
	}

	@Override
	public boolean esVacio(){
		return inicio == null;
	}

	@Override
	public int largo(){
		int cant = 0;
		NodoLista aux = inicio;
		while(aux != null){
			cant++;
			aux = aux.getSig();
		}
		return cant;
	}
	
	//================================================================================
    // Override de Cloneable
    //================================================================================
	
    @Override
    public Queue clone(){
		Queue lis = new Queue(); 
		NodoLista aux = inicio;
		while (aux!=null){
			lis.enqueue(aux.getDato()); //nodo que tiene zona
			//tenemos memoria distinta que apunta al mismo objeto
			aux = aux.getSig();
		}
		return lis;
	}
}

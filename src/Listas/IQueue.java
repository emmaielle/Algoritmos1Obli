package Listas;

public interface IQueue {

	public void enqueue(Object o);
	
	public void dequeue();
	
	public Object front();
	
	public boolean esVacio();
		
	public int largo();
}

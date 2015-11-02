package Listas;

import java.util.Comparator;

import Dominio.Abonado;

public class AbonadoComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		return ((Abonado)o1).getNombre().compareTo(((Abonado)o2).getNombre());
	}
	
}

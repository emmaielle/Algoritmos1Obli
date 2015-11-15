package Listas;

import java.util.Comparator;

import Dominio.Chofer;

public class ChoferComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		return ((Chofer)o1).getNombre().compareTo(((Chofer)o2).getNombre());
	}

}
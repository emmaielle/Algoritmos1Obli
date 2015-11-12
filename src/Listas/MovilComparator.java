package Listas;

import Dominio.Movil;
import java.util.Comparator;

public class MovilComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		return ((Movil)o1).getId().compareTo(((Movil)o2).getId()); 
	}

}

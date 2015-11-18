package Listas;

import java.util.Comparator;
import Dominio.Zona;

public class ZonaComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		return ((Zona)o1).getId() - (((Zona)o2).getId());
	}
}

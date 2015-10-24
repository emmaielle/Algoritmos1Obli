package Listas;

import java.util.Comparator;

public class AlumnoComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		return ((Alumno)o1).compareTo(((Alumno)o2));
	}

}

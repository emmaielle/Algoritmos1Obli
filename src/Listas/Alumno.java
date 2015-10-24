package Listas;

public class Alumno {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Alumno(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + "]";
	}

	public int compareTo(Alumno alumno) {
		return alumno.getId().compareTo(id);
	}

}

package group.java.demo.enity;

public class Song {
	private String name;
	 private int id;
	 
	 public Song(String name, Integer id) {
		 
		 setId(id);
		 setName(name);
		 
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	 
	@Override
	public String toString() {
		return "nome film: " + getName() + " id: " + getId();
	}
	 
}

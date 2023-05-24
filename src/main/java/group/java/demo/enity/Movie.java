package group.java.demo.enity;

public class Movie {
 private String name;
 private int id;
 
  public Movie(String name, Integer id) {
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
		// TODO Auto-generated method stub
		return "nome film: " + getName() + " id: " + getId();
	}
  
}

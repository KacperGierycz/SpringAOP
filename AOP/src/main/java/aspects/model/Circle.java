package aspects.model;

public class Circle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("!!Circle seter calls!!");
		throw(new RuntimeException()); 
	}
	
	

}

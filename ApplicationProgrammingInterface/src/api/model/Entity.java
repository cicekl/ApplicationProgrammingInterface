package api.model;

abstract class Entity { 
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Entity() {
		super();
	}

	public Entity(int id) {
		super();
		this.id = id;
	} 
	

}

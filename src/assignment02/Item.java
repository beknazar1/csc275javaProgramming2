package assignment02;

public class Item {
	private String name;
	private int weight;
	private int value;
	private int durability;
	private int ID;
	
	public Item(){
		name = null;
		weight = 0;
		value = 0;
		durability = 0;
		ID = 0;
	}
	
	public Item(String name, int weight, int value, int durability, int ID) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.durability = durability;
		this.ID = ID;
	}
	
	public Item(Item original) {
		this(original.getName(), original.getWeight(), original.getValue(), original.getDurability(), original.getID());
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}


package finalProject;

public abstract class Item {
	private static final String TYPE = "item";
	protected String name;
	protected double weight;
	protected int value;
	protected int durability;
	protected int ID;

	public Item() {
		super();
	}

	public String getType() {
		return TYPE;
	}

	public Item(String name, double weight, int value, int durability, int iD) {
		super();
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.durability = durability;
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
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
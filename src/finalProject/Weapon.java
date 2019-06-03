package finalProject;

public class Weapon extends Item {
	private static final String TYPE = "weapon";
	private int damage;
	private String weaponType;
	private boolean twoHanded;
	
	public Weapon(String name, double weight, int value, int durability, int iD, int damage, String weaponType,
			boolean twoHanded) {
		super(name, weight, value, durability, iD);
		this.damage = damage;
		this.weaponType = weaponType;
		this.twoHanded = twoHanded;
	}

	public String getType() {
		return TYPE;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public boolean isTwoHanded() {
		return twoHanded;
	}

	public void setTwoHanded(boolean twoHanded) {
		this.twoHanded = twoHanded;
	}

}

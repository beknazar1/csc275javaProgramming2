package midterm;

public class Equipable extends Item {
	private String bodyPart;
	private boolean clothing;
	private String effect;

	public Equipable(String name, double weight, int value, int durability, int iD, String bodyPart, boolean clothing,
			String effect) {
		super(name, weight, value, durability, iD);
		this.bodyPart = bodyPart;
		this.clothing = clothing;
		this.effect = effect;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public boolean isClothing() {
		return clothing;
	}

	public void setClothing(boolean clothing) {
		this.clothing = clothing;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
}

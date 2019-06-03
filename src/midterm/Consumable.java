package midterm;

public class Consumable extends Item {
	private boolean rechargable;
	private boolean toxic;
	private int effectDuration;
	
	public Consumable(String name, double weight, int value, int durability, int iD, boolean rechargable, boolean toxic,
			int effectDuration) {
		super(name, weight, value, durability, iD);
		this.rechargable = rechargable;
		this.toxic = toxic;
		this.effectDuration = effectDuration;
	}

	public boolean isRechargable() {
		return rechargable;
	}

	public void setRechargable(boolean rechargable) {
		this.rechargable = rechargable;
	}

	public boolean isToxic() {
		return toxic;
	}

	public void setToxic(boolean toxic) {
		this.toxic = toxic;
	}

	public int getEffectDuration() {
		return effectDuration;
	}

	public void setEffectDuration(int effectDuration) {
		this.effectDuration = effectDuration;
	}

}

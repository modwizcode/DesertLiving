package github.modwiz.desertLiving;

public enum Wood {
	OAK(0),
	SPRUCE(1),
	BIRCH(2),
	JUNGLE(3);
	
	
	private final int damageValue;
	
	Wood(int damageValue) {
		this.damageValue = damageValue;
	}
	
	public int toDamage() {
		return this.damageValue;
	}
}

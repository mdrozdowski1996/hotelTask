package hotel.cechy;

public enum Kolorystyka {
	SZARY("szary"), 
	STALOWY("stalowy"),
	PURPUROWY("purpurowy"),
	SELEDYNOWY("seledynowy"),
	JASNOZIELONY("jasnozielony");
	
	private String color;
	
	private Kolorystyka(String color){
		this.color = color;
	}
	
	public String toString(){
		return this.color;
	}
	
}

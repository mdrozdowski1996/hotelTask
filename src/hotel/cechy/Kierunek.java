package hotel.cechy;

public enum Kierunek {
	POLNOC("północ"),
	ZACHOD("zachód"),
	POLUDNIE("południe"),
	WSCHOD("wschód");
	
	private String direction;
	
	private Kierunek(String direction){
		this.direction = direction;
	}
	
	public String toString(){
		return this.direction;
	}
	
}

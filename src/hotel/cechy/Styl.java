package hotel.cechy;

public enum Styl {
	ORIENTALNY("orientalny"),
	MORSKI("morski"), 
	NOWOCZESNY("nowoczesny"), 
	RUSTYKALNY("rustykalny"), 
	SECESYJNY("secesyjny");
	
	private String styleName;
	
	private Styl(String styleName){
		this.styleName = styleName;
	}
	public String toString(){
		return this.styleName;
	}
};


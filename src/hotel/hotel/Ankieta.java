package hotel.hotel;

import hotel.cechy.CechyPokoju;

public class Ankieta {
	private CechyPokoju cechy;
	private int dlugoscPobytu;
	private Data data;
	
	public Ankieta(CechyPokoju cechy, int dlugoscPobytu, Data data){
		this.cechy = cechy;
		this.dlugoscPobytu = dlugoscPobytu;
		this.data = data;
	}
	
	public CechyPokoju pokazCechy(){
		return this.cechy;
	}
	
	public Data poczatek(){
		return this.data;
	}
	public int dlugoscPobytu(){
		return this.dlugoscPobytu;
	}
	public String toString(){
		return this.cechy.toString() + ", " + this.data.toString() + ", " + this.dlugoscPobytu(); 
	}
		
}

package hotel.klient;
import hotel.hotel.Pokoj;
import hotel.hotel.Ankieta;

public abstract class StrategiaKlienta {
	protected String nazwa;
	
	public StrategiaKlienta(String nazwa){
		this.nazwa = nazwa;
	}
	
	public abstract boolean akceptujPokoj(Pokoj pokoj, Ankieta ankieta);
	public String toString(){
		return this.nazwa;
	}
}
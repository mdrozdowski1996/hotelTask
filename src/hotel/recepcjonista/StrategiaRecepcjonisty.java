package hotel.recepcjonista;

import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;

public abstract class StrategiaRecepcjonisty {
	protected String nazwa;
	
	protected StrategiaRecepcjonisty(String nazwa){
		this.nazwa = nazwa;
	}
	
	public abstract int wybierzPokoj(Pokoj[] pokoje, Ankieta ankieta);
	public abstract String toString();
}

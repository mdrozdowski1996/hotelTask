package hotel.klient;
import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;
//import hotel.hotel.CechyPokoju;

public class StrategiaKlientaWidokowego extends StrategiaKlienta{
	
	public StrategiaKlientaWidokowego(){
		super("widokowa");
	}
	
	public boolean akceptujPokoj(Pokoj pokoj, Ankieta ankieta){
		if(pokoj.pokazCechy().zwrocKierunek().equals( ankieta.pokazCechy().zwrocKierunek())) return true;
		else return false;
	}
}

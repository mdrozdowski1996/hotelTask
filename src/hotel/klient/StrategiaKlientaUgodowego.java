package hotel.klient;
import hotel.hotel.Pokoj;
import hotel.hotel.Ankieta;

public class StrategiaKlientaUgodowego extends StrategiaKlienta{

	public StrategiaKlientaUgodowego(){
		super("ugodowa");
	}
	
	public boolean akceptujPokoj(Pokoj pokoj, Ankieta ankieta){
		return true;
	}
}

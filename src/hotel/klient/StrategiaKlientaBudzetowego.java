package hotel.klient;

import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;

public class StrategiaKlientaBudzetowego extends StrategiaKlienta{
	
	public StrategiaKlientaBudzetowego(){
		super("budżetowa");
	}
	
	public boolean akceptujPokoj(Pokoj pokoj, Ankieta ankieta){
		return ankieta.pokazCechy().zwrocCene() >= pokoj.pokazCechy().zwrocCene();
	}
}

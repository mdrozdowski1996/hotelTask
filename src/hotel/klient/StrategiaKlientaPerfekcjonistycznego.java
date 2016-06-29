package hotel.klient;
import hotel.cechy.CechyPokoju;
import hotel.hotel.Ankieta;
import hotel.hotel.Pokoj;

public class StrategiaKlientaPerfekcjonistycznego extends StrategiaKlienta{
	
	public StrategiaKlientaPerfekcjonistycznego(){
		super("perfekcjonistyczna");
	}
	
	public boolean akceptujPokoj(Pokoj pokoj, Ankieta ankieta){
		return ankieta.pokazCechy().iloscWspolnychCech(pokoj.pokazCechy()) == CechyPokoju.iloscCech;
	}
}
